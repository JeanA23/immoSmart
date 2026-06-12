package com.jeananani.immosmart.exceptions;

import com.jeananani.immosmart.constants.ExceptionConst;
import org.springframework.http.HttpStatus;

public class SecurityException extends BusinessException{

    public SecurityException() {
        super("Un problème de sécurité est survenu", HttpStatus.UNAUTHORIZED, ExceptionConst.SECURITY_ERROR);
    }

    public SecurityException(String message) {
        super(message, HttpStatus.UNAUTHORIZED, ExceptionConst.SECURITY_ERROR);
    }
}
