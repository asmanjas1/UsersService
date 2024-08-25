package com.user.service;

import com.user.beans.Address;
import com.user.beans.Person;
import com.user.entity.AddressEntity;
import com.user.entity.PersonEntity;
import com.user.repository.AddressRepository;
import com.user.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

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

    @Override
    public void saveAddress(Address address, String id) throws Exception {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setPhoneNumber(id);
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1(address.getAddressLine1());
        addressEntity.setAddressLine2(address.getAddressLine2());
        addressEntity.setLocality(address.getLocality());
        addressEntity.setLandmark(address.getLandmark());
        addressEntity.setCity(address.getCity());
        addressEntity.setState(address.getState());
        addressEntity.setPincode(address.getPincode());
        addressEntity.setLongitude(address.getLongitude());
        addressEntity.setLatitude(address.getLatitude());
        addressEntity.setGoogleObject(address.getGoogleObject());
        addressEntity.setPersonEntity(personEntity);
        addressRepository.save(addressEntity);
    }

    @Override
    public List<AddressEntity> getAllAddress(String id) throws Exception {
        return addressRepository.findAllByPersonEntityPhoneNumber(id);
    }
}
