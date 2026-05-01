package com.scm.scm20.controllers;

import com.scm.scm20.forms.UserForm;
import com.scm.scm20.entities.User;
import com.scm.scm20.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    // Serves the registration form
    @RequestMapping("/register")
    public String register(Model model) {
        UserForm userForm = new UserForm();
        // default data can be set here if needed: userForm.setName("Durgesh");
        model.addAttribute("userForm", userForm);
        return "register";
    }

    // Processes the registration form
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute("userForm") UserForm userForm) {
        System.out.println("Processing Registration...");
        System.out.println(userForm); // Prints fetched data to console via toString()

        // Convert UserForm to User Entity
        User user = User.builder()
                .name(userForm.getName())
                .email(userForm.getEmail())
                .password(userForm.getPassword())
                .about(userForm.getAbout())
                .phoneNumber(userForm.getPhoneNumber())
                .profilePic("https://www.learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2Flcwd_logo.4ed79428.png&w=640&q=75") // Default hardcoded picture
                .build();

        // Save the user using the Service layer
        User savedUser = userService.saveUser(user);
        System.out.println("User Saved");

        // Redirect back to the register page
        return "redirect:/register";
    }
}