package com.ranggarifqi.mealtracker.indonesianmealtracker.modules.response;

import com.ranggarifqi.mealtracker.indonesianmealtracker.modules.exception.CustomException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ErrorResponse {
    public static ResponseStatusException construct(Exception e) {
        if (e instanceof CustomException) {
            return new ResponseStatusException(((CustomException) e).getStatusCode(), e.getMessage(), e);
        }

        if (e instanceof ConstraintViolationException) {
            return new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }

        return new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
    }
}
