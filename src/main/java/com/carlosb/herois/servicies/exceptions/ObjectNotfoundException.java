package com.carlosb.herois.servicies.exceptions;

public class ObjectNotfoundException extends  RuntimeException{

    public ObjectNotfoundException(String msg){
        super(msg);
    }

    public ObjectNotfoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}
