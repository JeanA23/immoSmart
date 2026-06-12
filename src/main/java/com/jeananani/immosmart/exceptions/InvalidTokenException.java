package com.jeananani.immosmart.exceptions;

import com.jeananani.immosmart.constants.ExceptionConst;
import org.springframework.http.HttpStatus;

public class InvalidTokenException extends BusinessException{

    public InvalidTokenException() {
        super("Token invalide ou expiré", HttpStatus.UNAUTHORIZED, ExceptionConst.INVALID_TOKEN);
    }

    public InvalidTokenException(String message) {
        super(message, HttpStatus.UNAUTHORIZED, ExceptionConst.INVALID_TOKEN);
    }
}
