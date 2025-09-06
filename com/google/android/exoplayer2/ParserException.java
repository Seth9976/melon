package com.google.android.exoplayer2;

import java.io.IOException;

public class ParserException extends IOException {
    public ParserException() {
    }

    public ParserException(String s) {
        super(s);
    }

    public ParserException(String s, Throwable throwable0) {
        super(s, throwable0);
    }

    public ParserException(Throwable throwable0) {
        super(throwable0);
    }
}

