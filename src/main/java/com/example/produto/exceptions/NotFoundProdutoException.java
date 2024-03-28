package com.example.produto.exceptions;

public class NotFoundProdutoException extends RuntimeException{

    public NotFoundProdutoException(String message) {
        super(message);
    }

    public NotFoundProdutoException(String message, Throwable cause) {
        super(message, cause);
    }
}
