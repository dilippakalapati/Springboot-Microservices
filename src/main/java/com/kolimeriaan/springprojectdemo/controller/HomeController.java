package com.kolimeriaan.springprojectdemo.controller;

import com.kolimeriaan.springprojectdemo.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    //@RequestMapping(value = "/users", method= RequestMethod.GET)
    @GetMapping("/users")
    public User getUsers() {
        User user = new User();
        user.setId(1);
        user.setName("Dilip");
        user.setEmailId("dilip@kolimeriaan.com");
        return user;
    }

    @GetMapping("/{id1}/{id2}")
    public String pathVariable(@PathVariable String id1, @PathVariable(name = "id2") String name){
        return "Path variables received are "+id1 +" and "+name;

    }

    @GetMapping("/requestParam")
    public String requestParams(@RequestParam String name, @RequestParam(name = "email", required = false, defaultValue = "") String emailId){

        return "Your name is: "+name+ " and EmailId is: "+emailId;
    }
}
