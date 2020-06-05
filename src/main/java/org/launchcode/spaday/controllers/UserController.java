package org.launchcode.spaday.controllers;


import org.launchcode.spaday.models.User;
import org.launchcode.spaday.models.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

import static org.launchcode.spaday.models.UserData.users;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayUserPage(){
        return "user/index";
    }

    @GetMapping("add")
    public String displayAddUserForm(Model model){
        model.addAttribute("name", "");
        model.addAttribute("email","");
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model,
                                     @ModelAttribute User user, String verify){
        model.addAttribute(user);
        model.addAttribute("name", user.getUsername());
        model.addAttribute("email",user.getEmail());
        model.addAttribute("error", "Passwords Do Not " +
                "Match");
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("users", UserData.getAllUsers());
        String empty= "";
        if (!user.getPassword().equals(verify)|| user.getPassword().equals(empty)){
            return "user/add";
        } else {
            users.put(user.getId(), user);
            return "user/index";
        }
    }

    @GetMapping ("userDetails/{userId}")
    public String displayUserDetails (Model model,
                                      @PathVariable int userId){
        model.addAttribute("user",
                UserData.getUserById(userId));
        return "user/userDetails";
    }

    @GetMapping ("index")
    public String returnToUserListing(Model model){
        model.addAttribute("users", UserData.getAllUsers());
        return "user/index";
    }

}
