package com.example.rest.exception;

import org.springframework.security.core.AuthenticationException;


/**
 * @author OITECH develop team - 24/01/2019
 */
public class InvalidJwtAuthenticationException extends AuthenticationException {

    public InvalidJwtAuthenticationException(String e) {
        super(e);
    }
}
