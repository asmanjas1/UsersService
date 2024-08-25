package com.user.service;

import com.user.beans.Address;
import com.user.beans.Person;
import com.user.entity.AddressEntity;
import com.user.entity.PersonEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {
    void doSignUp(Person person) throws Exception;

    PersonEntity doSignIn(Person person) throws Exception;

    void saveAddress(Address address, String id) throws Exception;

    List<AddressEntity> getAllAddress(String id) throws Exception;
}
