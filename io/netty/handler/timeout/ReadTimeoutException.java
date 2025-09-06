package io.netty.handler.timeout;

public final class ReadTimeoutException extends TimeoutException {
    public static final ReadTimeoutException INSTANCE = null;
    private static final long serialVersionUID = 0x2596E864DD0715DL;

    static {
        ReadTimeoutException.INSTANCE = new ReadTimeoutException();
    }

    public ReadTimeoutException() {
    }

    public ReadTimeoutException(String s) {
        super(s, false);
    }

    private ReadTimeoutException(boolean z) {
        super(null, z);
    }
}

