package com.bridgelabz.day3greetingapp.controller;

import com.bridgelabz.day3greetingapp.model.Greeting;
import com.bridgelabz.day3greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @Autowired
    public GreetingService service;

    @GetMapping(value = {"", "/", "/home"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting((int) counter.incrementAndGet(), String.format(template, name));
    }

    //UC3
    @GetMapping("/greetingsWithUser")
    public String greetingWithUserName(@RequestParam(value = "firstName", defaultValue = "") String firstName,
                                       @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        return service.greetingWithUserName(firstName, lastName);
    }

    //UC4
    @PostMapping("/addGreeting")
    public Greeting addGreeting(@RequestBody Greeting greeting){
        return service.saveGreetings(greeting);
    }

    //UC5
    @GetMapping("/greetingById/{id}")
    public Greeting getGreetingById(@PathVariable Integer id){
        return service.findGreetingById(id);
    }

    //UC6
    @GetMapping("/allGreetings")
    public List<Greeting> findAllGreetings() {
        return service.findGreetings();
    }

    //UC7
    @PutMapping("/editGreeting/{id}")
    public Greeting editGreeting(@RequestBody Greeting greeting, @PathVariable Integer id){
        return service.editGreeting(greeting, id);
    }

    //UC8
    @DeleteMapping("/deleteGreeting/{id}")
    public String deleteGreeting(@PathVariable Integer id){
        service.deleteGreeting(id);
        return "Data Deleted";
    }
}