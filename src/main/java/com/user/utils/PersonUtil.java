package com.user.utils;

import com.user.beans.CustomResponse;
import com.user.beans.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PersonUtil {
    public String validatePersonSignUpRequest(Person person) {
        if(StringUtils.isEmpty(person.getName()) ||
                StringUtils.isEmpty(person.getPhoneNumber())||
                StringUtils.isEmpty(person.getPassword())) {
            return "Please provide valid Sign up request";
        }
        return null;
    }

    public String validatePersonSignInRequest(Person person) {
        if(StringUtils.isEmpty(person.getPhoneNumber())||
                StringUtils.isEmpty(person.getPassword())) {
            return "Please provide valid SignIn request";
        }
        return null;
    }

    public ResponseEntity<CustomResponse> generateResponse(
            int responseCode, String contextPath, String message) {
        CustomResponse customResponse = null;
        switch (responseCode) {
            case 200:
                customResponse = new CustomResponse(System.currentTimeMillis(),
                        HttpStatus.OK.toString(),
                        message,
                        contextPath,
                        HttpStatus.OK);
                return new ResponseEntity<>(customResponse, HttpStatus.OK);
            case 400:
                customResponse = new CustomResponse(System.currentTimeMillis(),
                        HttpStatus.BAD_REQUEST.toString(),
                        message,
                        contextPath,
                        HttpStatus.BAD_REQUEST);
                return new ResponseEntity<>(customResponse, HttpStatus.BAD_REQUEST);
            case 403:
                customResponse = new CustomResponse(System.currentTimeMillis(),
                        HttpStatus.FORBIDDEN.toString(),
                        message,
                        contextPath,
                        HttpStatus.FORBIDDEN);
                return new ResponseEntity<>(customResponse, HttpStatus.FORBIDDEN);
            case 404:
                customResponse = new CustomResponse(System.currentTimeMillis(),
                        HttpStatus.NOT_FOUND.toString(),
                        message,
                        contextPath,
                        HttpStatus.NOT_FOUND);
                return new ResponseEntity<>(customResponse, HttpStatus.NOT_FOUND);
            default:
                customResponse = new CustomResponse(System.currentTimeMillis(),
                        HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                        message,
                        contextPath,
                        HttpStatus.INTERNAL_SERVER_ERROR);
                return new ResponseEntity<>(customResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
