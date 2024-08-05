package com.user.controller;

import com.user.beans.Person;
import com.user.entity.PersonEntity;
import com.user.service.PersonService;
import com.user.utils.PersonUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/person")
public class PersonController {
    @Autowired
    PersonUtil personUtil;

    @Autowired
    PersonService personService;

    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doSignUp(@RequestBody Person person, HttpServletRequest request) {
        String contextPath = request.getContextPath() + request.getServletPath();
        try {
            String validationMessage = personUtil.validatePersonSignUpRequest(person);
            if(validationMessage != null) {
                return personUtil.generateResponse(400, contextPath, validationMessage);
            }
            personService.doSignUp(person);
            return ResponseEntity.ok("success");
        } catch (Exception e) {
            e.printStackTrace();
            return personUtil.generateResponse(500, contextPath, e.getMessage());
        }
    }

    @PostMapping(value = "/signin", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> doSignIn(@RequestBody Person person, HttpServletRequest request) {
        String contextPath = request.getContextPath() + request.getServletPath();
        try {
            String validationMessage = personUtil.validatePersonSignInRequest(person);
            if(validationMessage != null) {
                return personUtil.generateResponse(400, contextPath, validationMessage);
            }
            PersonEntity personEntity = personService.doSignIn(person);
            if(personEntity == null) {
                return personUtil.generateResponse(400, contextPath, "UserName Password doesn't exists.");
            }
            return ResponseEntity.ok(personEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return personUtil.generateResponse(500, contextPath, e.getMessage());
        }
    }

    @GetMapping(value = "/status")
    public String defaultPage() {
        return "Welcome to Spring Boot default page User Service";
    }
}
