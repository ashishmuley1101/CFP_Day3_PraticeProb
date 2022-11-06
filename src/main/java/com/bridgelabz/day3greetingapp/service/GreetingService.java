package com.bridgelabz.day3greetingapp.service;

import com.bridgelabz.day3greetingapp.model.Greeting;
import com.bridgelabz.day3greetingapp.repository.IGreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private IGreetingRepository repository;

    public String greetingMessage(){
        return "Hello World!";
    }
    public String greetingWithUserName(String firstName, String lastName) {
        if(firstName.isEmpty() && lastName.isEmpty())
            return greetingMessage();
        else if (!(firstName.equals("")) && (lastName.equals(""))) {
            return "Hello & Welcome to the greeting app, "+firstName;
        }
        else if (!(lastName.equals("")) && (firstName.equals(""))) {
            return "Hello & Welcome to the greeting app, "+lastName;
        }
        else
            return "Hello & Welcome to the greeting app, "+firstName+" "+lastName+"!";
    }

    public Greeting saveGreetings(Greeting greeting){
        return repository.save(greeting);
    }

    public Greeting findGreetingById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Greeting> findGreetings() {
        return repository.findAll();
    }

    public Greeting editGreeting(Greeting greeting, Integer id) {
        Greeting existingGreet = repository.findById(id).orElse(null);
        if (existingGreet != null) {
            existingGreet.setMessage(greeting.getMessage());
            return repository.save(existingGreet);
        }else return null;
    }

    public String deleteGreeting(Integer id) {
        repository.deleteById(id);
        return "Data Deleted";
    }
}
