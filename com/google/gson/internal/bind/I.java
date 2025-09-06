package com.google.gson.internal.bind;

import java.io.Writer;

public final class i extends Writer {
    @Override
    public final void close() {
        throw new AssertionError();
    }

    @Override
    public final void flush() {
        throw new AssertionError();
    }

    @Override
    public final void write(char[] arr_c, int v, int v1) {
        throw new AssertionError();
    }
}

