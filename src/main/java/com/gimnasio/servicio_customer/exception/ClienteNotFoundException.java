package com.gimnasio.servicio_customer.exception;

public class ClienteNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
    public ClienteNotFoundException(String message) {
        super(message);
    }

    public ClienteNotFoundException(Long id) {
        super("Cliente no encontrado con ID: " + id);
    }
}