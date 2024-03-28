package com.example.produto.exceptions;

public class NotFoundGrupoProdutoException extends RuntimeException{

    public NotFoundGrupoProdutoException(String message) {
        super(message);
    }

    public NotFoundGrupoProdutoException(String message, Throwable cause) {
        super(message, cause);
    }
}
