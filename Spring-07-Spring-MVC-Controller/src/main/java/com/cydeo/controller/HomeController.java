package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {  // Annotate the class with the @Controller stereotype annotation

    @RequestMapping("/home") // Use @RequestMapping annotation to associate the action with the HTTP request path
    public String home() {
        return "home.html"; // Return the HTML document name that contains the details we want the browser to display
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome.html";
    }
}
