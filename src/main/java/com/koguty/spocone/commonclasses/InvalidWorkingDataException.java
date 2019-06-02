package com.koguty.spocone.commonclasses;

/**
 * @author Kamil Rojek
 */
public class InvalidWorkingDataException extends Exception {
    public InvalidWorkingDataException(String msg) {
        super(msg);
    }
    public InvalidWorkingDataException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
