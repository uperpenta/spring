package com.example.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String member, String nrId, long id){
        super(member);
    }
    
}
