package com.bridgelabz.day3greetingapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    //UC1

    @GetMapping("/hello")
    public String Hello() {
        return "Hello From Bridgelabz";
    }

    @RequestMapping("/query/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHelloParam(@RequestParam(value = "name") String name) {
        return "Hello " + name + "!";
    }
}