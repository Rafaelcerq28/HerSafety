package com.hersafety.hersafety.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ArgumentNotValidException extends RuntimeException {

    public ArgumentNotValidException(String message){
        super(message);
    }

}

