package com.getir.customer.exception;

import com.getir.customer.constant.ErrorConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(EmailNotValidException.class)
    public ResponseEntity<ExceptionResponse> emailNotValidException() {
        return new ResponseEntity<>(ExceptionResponse.builder().dateTime(LocalDateTime.now()).errorCode(ErrorConstants.EMAIL_NOT_VALID.getErrorCode()).errorMessage(ErrorConstants.EMAIL_NOT_VALID.getDescription()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmailIsBeingUsedByAnotherUserException.class)
    public ResponseEntity<ExceptionResponse> emailIsBeingUsedByAnotherUserException() {
        return new ResponseEntity<>(ExceptionResponse.builder().dateTime(LocalDateTime.now()).errorCode(ErrorConstants.EMAIL_IS_BEING_USED_BY_ANOTHER_USER.getErrorCode()).errorMessage(ErrorConstants.EMAIL_IS_BEING_USED_BY_ANOTHER_USER.getDescription()).build(), HttpStatus.BAD_REQUEST);
    }
}
