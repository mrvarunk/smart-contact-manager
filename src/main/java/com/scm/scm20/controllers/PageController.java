package com.scm.scm20.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @Controller
    public class HomeController {

        @RequestMapping("/home")
        public String home(Model model) {
            model.addAttribute("name", "Home Page");
            model.addAttribute("youtubeChannel", "My Channel Name");
            model.addAttribute("githubRepo", "https://github.com/mrvarunk");
            return "home";
        }
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
