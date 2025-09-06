package io.netty.handler.timeout;

public final class WriteTimeoutException extends TimeoutException {
    public static final WriteTimeoutException INSTANCE = null;
    private static final long serialVersionUID = 0xFDFD9D4DBE9840FFL;

    static {
        WriteTimeoutException.INSTANCE = new WriteTimeoutException();
    }

    public WriteTimeoutException() {
    }

    public WriteTimeoutException(String s) {
        super(s, false);
    }

    private WriteTimeoutException(boolean z) {
        super(null, z);
    }
}

