package com.sparta.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "redirect:/login-form.html";
    }
    //request param 을 통해 아이디와 패스워드를 받아도 되고
    //model.Attribute로 받아도 됨=> 이경우에는 아이디와 패스워드를 저장할 수 있는객체를 만들어야함
    @PostMapping("/login")
    public String loginProcess(
            @RequestParam String id,
            @RequestParam String password,
            // 이렇게 추가로 해야 나중에 모델 정보를 넘겨 줄 수 있음
            // 선언만 해주면 스프리이 알아서 model에 필요한 내용들로 다 채워넣어서 보내줌
            Model model
    ) {
        if (id.equals(password)) {
            model.addAttribute("loginId",id);
        }
        return "login-result";
    }

}
