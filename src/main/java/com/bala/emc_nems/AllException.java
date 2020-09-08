package com.bala.emc_nems;


public class AllException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AllException() {
        super();
    }

    public AllException(String message) {
        super(message);
    }
    
    public AllException(Throwable cause) {
        super(cause);
    }
}
