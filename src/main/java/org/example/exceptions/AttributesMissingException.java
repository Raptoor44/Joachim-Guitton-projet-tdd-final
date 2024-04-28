package org.example.exceptions;

public class AttributesMissingException extends RuntimeException {

    public AttributesMissingException(String message) {
        super(message);
    }
}
