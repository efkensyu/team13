package com.example.demo.team13.Team13Aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class Team13Aspect {	
	

	    // 全コントローラのGET/POSTメソッドを対象にする
	@Pointcut("within(com.example.demo.team13.Team13Controller..*)")
	public void controllerMethods() {}

	    // INFOログ(開始前)
	    @Before("controllerMethods()")
	    public void logBefore(JoinPoint jp) {
	        log.info("START: {}.{} Args={}",
	                 jp.getSignature().getDeclaringTypeName(),
	                 jp.getSignature().getName(),
	                 Arrays.toString(jp.getArgs()));
	    }

	    // ERRORログ（例外発生時）
	    @AfterThrowing(pointcut = "controllerMethods()", throwing = "ex")
	    public void logError(JoinPoint jp, Throwable ex) {
	        log.error("ERROR in {}.{}: {}",
	                  jp.getSignature().getDeclaringTypeName(),
	                  jp.getSignature().getName(),
	                  ex.getMessage());
	    }
	    
	    @Around("controllerMethods()")
	    public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
	        try {
	            log.info("START: {}.{} Args={}",
	                    jp.getSignature().getDeclaringTypeName(),
	                    jp.getSignature().getName(),
	                    Arrays.toString(jp.getArgs()));

	            return jp.proceed();

	        } catch (Exception e) {

	            String className = jp.getSignature().getDeclaringTypeName();

	            log.error("ERROR in {}: {}", className, e.getMessage());

	            org.springframework.web.context.request.RequestContextHolder
	                .currentRequestAttributes()
	                .setAttribute("errorSource", className,
	                        org.springframework.web.context.request.RequestAttributes.SCOPE_REQUEST);

	            return "team13/Team13_Error";
	        }
	    }
}