package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm() {
        return "/user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verifiedPassword) {
        // if verifiedPassword equals password property of user
        model.addAttribute("username", user.getUsername());

        if(verifiedPassword.equals(user.getPassword())) {
            return "/user/index";
        }
        else {
            model.addAttribute("email", user.getEmail());
            model.addAttribute("error", "Passwords did not match, please re-enter your info!");
            return "/user/add";
        }

    }
}
