package com.example.demo.team13.Team13Service.Team13General.Team13Cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.team13.Session.Team13UserInfoSession;
import com.example.demo.team13.Team13Controller.Team13General.Team13Cart.Team13CartInfo;

@ControllerAdvice
public class Team13GlobalModelAttributes {

    @Autowired
    private Team13UserInfoSession session;

    @ModelAttribute("sumPrice")
    public int sumPrice() {
        int sum = 0;
        List<Team13CartInfo> list = session.getCartInfo();

        if (list != null) {
            for (Team13CartInfo ci : list) {
                sum += ci.getShohin_price() * ci.getShohin_num();
            }
        }

        return sum;
    }
}
