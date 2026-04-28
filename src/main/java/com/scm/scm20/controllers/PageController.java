package com.scm.scm20.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("home page handler");

        //sending data to html
        model.addAttribute("name", "substrrng techno");
        model.addAttribute("youtubechannel", "learn coding");
        model.addAttribute("githubrepo", "https://github.com/mrvarunk");

        return "home";
    }
    //about route
    @RequestMapping("/about")
    public String aboutPage(){
        System.out.println("about page handler");
        return "about";
    }

    //services route
    @RequestMapping("/services")
    public String servicesPage(){
        System.out.println("services page handler");
        return "services";
    }
}
