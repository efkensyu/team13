package com.example.demo.team13.Team13Controller.Team13Auth.Team13Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Team13GeneralLoginController {
	@Autowired Team13LoginSession team13LoginSession;
    @GetMapping("/Team13_General_Login")
    public String login() {
        return "team13/Team13General/Team13_Login";
    }
    
    @PostMapping("/Team13_General_Login")
    public String sendlogin() {
    	
//    	ここに実処理呼び出し
    	
//    	問題なく照合出来たら
//    	String shain_id = でIdを格納
//		loginSession.setShainId(shain_id);
//    	この文章を含めてコメントアウトを外し、不要な文章を消してください。
        return "team13/Team13General/Team13_Home";
    }
}
