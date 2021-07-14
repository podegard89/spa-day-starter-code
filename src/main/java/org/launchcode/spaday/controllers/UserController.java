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
    public String processAddUserForm(Model model, @ModelAttribute User user, @RequestParam String verifiedPassword) {
        // if verifiedPassword equals password property of user
        if(verifiedPassword.equals(user.getPassword())) {
            model.addAttribute("username", user.getUsername());
            return "/user/index";
        }
        else {
            return "/user/add";
        }

    }
}
