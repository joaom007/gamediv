package br.com.scale.gamediv.service.exception;

public class ResourceNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    //Constructor for receve id not found for personalite response 404
    public ResourceNotFoundException(Object id) {
        super("Recurso não encontrado. Id " + id);
    }
    
}
