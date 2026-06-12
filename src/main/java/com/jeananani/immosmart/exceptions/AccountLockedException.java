package com.jeananani.immosmart.exceptions;

import com.jeananani.immosmart.constants.ExceptionConst;
import org.springframework.http.HttpStatus;

public class AccountLockedException extends BusinessException {

    public AccountLockedException() {
        super("Ce compte est verrouillé", HttpStatus.FORBIDDEN, ExceptionConst.ACCOUNT_DISABLED);
    }

    public AccountLockedException(String message) {
        super(message, HttpStatus.FORBIDDEN, ExceptionConst.ACCOUNT_DISABLED);
    }
}
