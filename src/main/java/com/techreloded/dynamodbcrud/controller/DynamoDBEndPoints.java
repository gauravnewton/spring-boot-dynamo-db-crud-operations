package com.techreloded.dynamodbcrud.controller;

import com.techreloded.dynamodbcrud.entity.Person;
import com.techreloded.dynamodbcrud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DynamoDBEndPoints {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/savePerson")
    public Person savePerson(@RequestBody Person person){
        return personRepository.addPerson(person);
    }
    @GetMapping("/getPerson/{personId}")
    public Person findPerson(@PathVariable String personId){
        return personRepository.findPersonByPersonId(personId);
    }
    @DeleteMapping("/deletePerson")
    public String deletePerson(@RequestBody Person person){
        return personRepository.deletePerson(person);
    }
    @PutMapping("/editPerson")
    public String updatePerson(@RequestBody Person person){
        return personRepository.editPerson(person);
    }
    @GetMapping("/getAllPerson")
    public List<Person> getAllPerson(){
        return personRepository.getAllPerson();
    }
}
