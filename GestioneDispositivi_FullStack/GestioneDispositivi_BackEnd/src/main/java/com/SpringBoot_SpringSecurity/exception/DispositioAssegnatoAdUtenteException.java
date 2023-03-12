package com.SpringBoot_SpringSecurity.exception;

import org.hibernate.HibernateException;

public class DispositioAssegnatoAdUtenteException extends HibernateException {
    public DispositioAssegnatoAdUtenteException(String message) {
        super(message);
    }
}
