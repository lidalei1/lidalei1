package com.company;

public class EmptyFileException extends RuntimeException {
    EmptyFileException(){
        super();
    }

    EmptyFileException(String msg){
        super(msg);
    }
}
