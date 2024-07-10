package com.example.simpleform.controller;


import com.example.simpleform.model.UserModel;
import com.example.simpleform.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService service;
    private final UserService userService;

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new UserModel());
        return "register_page";
    }
    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new UserModel());
        return "login_page";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute UserModel userModel){
        System.out.println("Request register" + userModel);
        UserModel registeredUser =userService.registerUser(userModel.getLogin(), userModel.getPassword(),userModel.getEmail());
        return registeredUser == null ? "error_page" : "redirect:/login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute UserModel userModel){
        System.out.println("login request: " + userModel);
        UserModel authenticatedUser=userService.authenticate(userModel.getLogin(),userModel.getPassword());
        if(authenticatedUser != null){
            return "personal_page";
        }else return "error_page";

    }
}
