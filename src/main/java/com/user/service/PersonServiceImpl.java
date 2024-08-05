package com.user.service;

import com.user.beans.Person;
import com.user.entity.PersonEntity;
import com.user.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public void doSignUp(Person person) throws Exception {
        Optional<PersonEntity> entity = personRepository.findById(person.getPhoneNumber());
        if(entity.isPresent()) {
            throw new Exception("Mobile already Used for existing account.");
        } else {
            PersonEntity personEntity = new PersonEntity();
            personEntity.setName(person.getName());
            personEntity.setPhoneNumber(person.getPhoneNumber());
            personEntity.setPassword(person.getPassword());
            personRepository.saveAndFlush(personEntity);
        }
    }

    @Override
    public PersonEntity doSignIn(Person person) throws Exception {
        return personRepository.findByPhoneNumberAndPassword(person.getPhoneNumber(), person.getPassword());
    }
}
