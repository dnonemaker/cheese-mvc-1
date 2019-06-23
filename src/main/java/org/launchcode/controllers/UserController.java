package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("add")
    public String add(Model model){

        User u = new User();
        u.setUsername("");
        u.setEmail("");

        String pwError = "";

        model.addAttribute("user", u);
        model.addAttribute("pwError", pwError);
        return "user/add";
    }

    @RequestMapping(value ="add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute User user, String verify){

        if(user.getPassword().equals(verify)){
            model.addAttribute("user", user);

            return "user/index";
        }

        String pwError = "Passwords do not match!";
        model.addAttribute("user", user);
        model.addAttribute("pwError", pwError);
        return "user/add";
    }
}
