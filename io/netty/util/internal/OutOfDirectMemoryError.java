package io.netty.util.internal;

public final class OutOfDirectMemoryError extends OutOfMemoryError {
    private static final long serialVersionUID = 0x3AADCFB86D36EB23L;

    public OutOfDirectMemoryError(String s) {
        super(s);
    }
}

