package io.netty.util;

import U4.x;

public class IllegalReferenceCountException extends IllegalStateException {
    private static final long serialVersionUID = 0xDD3398F3E175FC84L;

    public IllegalReferenceCountException() {
    }

    public IllegalReferenceCountException(int v) {
        this("refCnt: " + v);
    }

    public IllegalReferenceCountException(int v, int v1) {
        StringBuilder stringBuilder0 = x.n(v, "refCnt: ", ", ");
        stringBuilder0.append((v1 <= 0 ? "decrement: " + -v1 : "increment: " + v1));
        this(stringBuilder0.toString());
    }

    public IllegalReferenceCountException(String s) {
        super(s);
    }

    public IllegalReferenceCountException(String s, Throwable throwable0) {
        super(s, throwable0);
    }

    public IllegalReferenceCountException(Throwable throwable0) {
        super(throwable0);
    }
}

