package com.bridgelabz.day3greetingapp.repository;

import com.bridgelabz.day3greetingapp.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGreetingRepository extends JpaRepository<Greeting,Integer> {
}
