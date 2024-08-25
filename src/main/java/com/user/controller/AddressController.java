package com.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.user.beans.Address;
import com.user.beans.Person;
import com.user.entity.AddressEntity;
import com.user.service.PersonService;
import com.user.utils.PersonUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/address")
public class AddressController {
    @Autowired
    PersonUtil personUtil;

    @Autowired
    PersonService personService;

    @PostMapping(value = "/save/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveAddress(@PathVariable("id") String id,
                                      @RequestBody Address address, HttpServletRequest request) {
        String contextPath = request.getContextPath() + request.getServletPath();
        try {
            personService.saveAddress(address, id);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            e.printStackTrace();
            return personUtil.generateResponse(500, contextPath, e.getMessage());
        }
    }

    @GetMapping(value = "/getAllAddressById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllAddress(@PathVariable("id") String id, HttpServletRequest request) {
        String contextPath = request.getContextPath() + request.getServletPath();
        try {
            List<AddressEntity> addressEntityList = personService.getAllAddress(id);
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            return ResponseEntity.ok(mapper.writeValueAsString(addressEntityList));
        } catch (Exception e) {
            e.printStackTrace();
            return personUtil.generateResponse(500, contextPath, e.getMessage());
        }
    }
}
