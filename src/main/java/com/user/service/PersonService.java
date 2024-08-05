package com.user.service;

import com.user.beans.Person;
import com.user.entity.PersonEntity;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {
    void doSignUp(Person person) throws Exception;

    PersonEntity doSignIn(Person person) throws Exception;
}
