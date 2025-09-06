package io.netty.util.concurrent;

public class BlockingOperationException extends IllegalStateException {
    private static final long serialVersionUID = 0x222B92FF98970E8DL;

    public BlockingOperationException() {
    }

    public BlockingOperationException(String s) {
        super(s);
    }

    public BlockingOperationException(String s, Throwable throwable0) {
        super(s, throwable0);
    }

    public BlockingOperationException(Throwable throwable0) {
        super(throwable0);
    }
}

