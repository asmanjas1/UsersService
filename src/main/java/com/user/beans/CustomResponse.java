package com.user.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class CustomResponse {
    private long timestamp;
    private String status;
    private String message;
    private String path;
    private HttpStatus error;
}
