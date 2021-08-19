package com.org.queue.app.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.oauth2.sdk.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler extends Exception {

    @ExceptionHandler(value = { HttpClientErrorException.class })
    public ResponseEntity<Object> handleResourceNotFoundException(HttpClientErrorException ex) {
        String responseBody = ex.getResponseBodyAsString();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        ErrorResponse errorResponse = null;//new ErrorResponse();
        try {
            errorResponse = mapper.readValue(responseBody, ErrorResponse.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        ResponseEntity<Object> response = new ResponseEntity<>(errorResponse, headers, HttpStatus.BAD_REQUEST);

        return response;
    }
}
