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
    public String send(@ModelAttribute Team13Shain team13shain,Model model,BindingResult result) {
    	
    	smartValidator.validate(team13shain, result);
    	if(result.hasErrors()) {
    		return "team13/Team13General/Team13_Login";
    	}
    	
    	 if ((shainService.isPass(team13shain)) == false) {
             model.addAttribute("error", "社員IDまたはメールアドレスが違います");
             return "team13/Team13General/Team13_Login";
         }
//    	ここに実処理呼び出し
    	Optional<Team13Shain> shainData = shainService.getShainById(team13shain.getShainId());
    	
    	
 //   	問題なく照合出来たら
//    	String shain_id = でIdを格納
//		loginSession.setShainId(shain_id);
//    	この文章を含めてコメントアウトを外し、不要な文章を消してください。
        return "team13/Team13General/Team13_Home";
    }
}
