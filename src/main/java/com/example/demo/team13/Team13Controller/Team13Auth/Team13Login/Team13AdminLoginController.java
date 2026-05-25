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

import com.example.demo.team13.Team13Entity.Team13Admin;
import com.example.demo.team13.Team13Service.Team13Auth.Team13AdminLoginService;

@Controller
public class Team13AdminLoginController {

    @Autowired
    private Team13LoginSession team13LoginSession;

    private final Team13AdminLoginService adminService;
    private final SmartValidator smartValidator;

    // コンストラクタインジェクション
    public Team13AdminLoginController(Team13AdminLoginService adminService,
                                      SmartValidator smartValidator) {
        this.adminService = adminService;
        this.smartValidator = smartValidator;
    }

    // 空の Team13Admin を Adminlogin 名でモデルに登録
    @ModelAttribute("Adminlogin")
    public Team13Admin setupLogin() {
        return new Team13Admin();
    }

    @GetMapping("/Team13_Admin_Login")
    public String login() {
        return "team13/Team13Admin/Team13_Login";
    }

    @PostMapping("/Team13_Admin_Login")
    public String send(@ModelAttribute("Adminlogin") Team13Admin team13admin,
                       BindingResult result,
                       Model model) {

        smartValidator.validate(team13admin, result);
        if (result.hasErrors()) {
            return "team13/Team13Admin/Team13_Login";
        }

        if (!adminService.isPass(team13admin)) {
            model.addAttribute("error", "管理者IDまたはパスワードが違います");
            return "team13/Team13Admin/Team13_Login";
        }

        Optional<Team13Admin> adminData =
                adminService.getAdminById(team13admin.getKanriId());

        // セッションに管理者IDを保存
        team13LoginSession.setShainId(team13admin.getKanriId());

        return "redirect:/Team13_Admin_Home";
    }
}
