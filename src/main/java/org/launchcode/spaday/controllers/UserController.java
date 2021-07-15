package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm(Model model) {
        model.addAttribute(new User());
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {
        //errors.hasErrors() returns true if the user is not valid
        //if errors.hasErrors() returns true, re-render the form
        //else if passwords do not match, re-render the form
        //else render index.html

        if(errors.hasErrors()) {
            return "/user/add";
        }
        else if(!user.getPassword().equals(verify)) {
            model.addAttribute("error", "Passwords do not match");
            return "/user/add";
        }
        else {
            return "/user/index";
        }

    }


}
