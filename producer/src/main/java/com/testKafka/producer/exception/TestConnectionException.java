package com.testKafka.producer.exception;

public class TestConnectionException extends Exception{

    private static final String DEFAULT_MESSAGE = "Test Connection Failed";

    public TestConnectionException(final String msg) {
        super(msg);
    }

    public TestConnectionException() {
        super();
    }

    @Override
    public String getMessage() {
        final String superMessage = super.getMessage();
        if (superMessage != null) {
            return superMessage;
        } else {
            return DEFAULT_MESSAGE;
        }
    }
}
