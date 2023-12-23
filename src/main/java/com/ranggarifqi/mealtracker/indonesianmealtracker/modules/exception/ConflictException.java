package com.ranggarifqi.mealtracker.indonesianmealtracker.modules.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends CustomException{
    public ConflictException(String message) {
        super(message);
        this.statusCode = HttpStatus.CONFLICT;
    }
}
