package com.example.demo.team13.Team13Controller.Team13Auth.Team13Login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team13.Session.Team13LoginSession;
import com.example.demo.team13.Team13Entity.Team13Shain;
import com.example.demo.team13.Team13Service.Team13Auth.Team13GeneralLoginService;

@Controller
public class Team13GeneralLoginController {
	@Autowired Team13LoginSession team13LoginSession;
	
	private Team13GeneralLoginService shainService;
	private SmartValidator smartValidator;
	
	//コンストラクタインジェクション
	public Team13GeneralLoginController(Team13GeneralLoginService shainService,SmartValidator smartValidator) {
		this.shainService = shainService;
		this.smartValidator = smartValidator;
	}
	
	//空のTeam13Shainのインスタンス作成(モデル名：login)
    @ModelAttribute("login")
    public Team13Shain setupLogin() {
        return new Team13Shain();
    }
	
    @GetMapping("/Team13_General_Login")
    public String index() {
        return "team13/Team13General/Team13_Login";
    }
    
    @PostMapping("/Team13_General_Login")
    public String send(@ModelAttribute("login") Team13Shain team13shain,BindingResult result,Model model) {
    	
    	smartValidator.validate(team13shain, result);
    	if(result.hasErrors()) {
    		return "team13/Team13General/Team13_Login";
    	}
    	
    	 if ((shainService.isPass(team13shain)) == false) {
             model.addAttribute("error", "社員IDまたはメールアドレスが違います");
             return "team13/Team13General/Team13_Login";
         }

    	Optional<Team13Shain> shainData = shainService.getShainById(team13shain.getShainId());
    	
    	
		Team13Shain shain = shainData.get();
		
		System.out.println(shainData);
		// セッションに DB の値を保存
		team13LoginSession.setShain_id(shain.getShainId());	
		team13LoginSession.setShain_nm(shain.getShainNm());
		team13LoginSession.setShain_adress(shain.getShainAdress());
		team13LoginSession.setShain_email(shain.getShainEmail());
		team13LoginSession.setShain_tell(shain.getShainTell());

    	String shain_id = team13shain.getShainId();
    	team13LoginSession.setShain_id(shain_id);
//		throw new RuntimeException("テスト用エラー");
		
        return "redirect:Team13_General_Home";
    }
}
