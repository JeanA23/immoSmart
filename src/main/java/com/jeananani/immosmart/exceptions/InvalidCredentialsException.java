package com.jeananani.immosmart.exceptions;

import com.jeananani.immosmart.constants.ExceptionConst;
import org.springframework.http.HttpStatus;

public class InvalidCredentialsException extends BusinessException{

    public InvalidCredentialsException() {
        super("Email ou mot de passe incorrect", HttpStatus.UNAUTHORIZED, ExceptionConst.INVALID_CREDENTIALS);
    }

    public InvalidCredentialsException(String message) {
        super(message, HttpStatus.UNAUTHORIZED, ExceptionConst.INVALID_CREDENTIALS);
    }
}
