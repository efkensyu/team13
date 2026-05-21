package com.example.demo.team13.Team13Controller.Team13General.Team13Product;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team13.Team13Entity.Team13Shain;
import com.example.demo.team13.Team13Service.Team13General.Team13Auth.Team13ShainService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team13GeneralHomeController {
	private final Team13ShainService team13ShainService;
	@GetMapping("/Team13_General_Home")
	public String add(Model model){
	 List<Team13Shain> shainData = team13ShainService.findAll();
	 model.addAttribute("shainData",shainData);
	 return "team13/Team13General/Team13_Home";
	 
	}
	
	@PostMapping("/Team13_General_Home")
	public String send(){
	
    return "team13/Team13General/Team13_Cart";
 
}

}
