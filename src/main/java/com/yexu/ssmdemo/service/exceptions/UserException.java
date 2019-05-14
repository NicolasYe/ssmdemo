package com.yexu.ssmdemo.service.exceptions;

import java.io.Serializable;

public class UserException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 3251977238689014681L;

    public UserException(String message) {
        super(message);
    }
    public UserException(String message, Throwable cause) {super(message, cause);}

}
