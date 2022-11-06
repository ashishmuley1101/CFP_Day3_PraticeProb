package com.bridgelabz.day3greetingapp.controller;

import com.bridgelabz.day3greetingapp.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    //UC1

    @GetMapping("/web")
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

    //UC2
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = {"", "/", "/home"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting((int) counter.incrementAndGet(), String.format(template, name));
    }
}