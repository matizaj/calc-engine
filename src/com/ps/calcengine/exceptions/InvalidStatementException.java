package com.ps.calcengine.exceptions;

public class InvalidStatementException extends Exception{
    public InvalidStatementException(String msg) {
        super(msg);
    }

    public InvalidStatementException(String msg, Exception ex) {
        super(msg, ex);
    }
}
