package com.ranggarifqi.mealtracker.indonesianmealtracker.commons.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends CustomException{
    public ForbiddenException(String message) {
        super(message);
        this.statusCode = HttpStatus.FORBIDDEN;
    }
}
