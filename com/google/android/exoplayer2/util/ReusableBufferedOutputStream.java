package com.google.android.exoplayer2.util;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

public final class ReusableBufferedOutputStream extends BufferedOutputStream {
    private boolean closed;

    public ReusableBufferedOutputStream(OutputStream outputStream0) {
        super(outputStream0);
    }

    public ReusableBufferedOutputStream(OutputStream outputStream0, int v) {
        super(outputStream0, v);
    }

    @Override
    public void close() {
        try {
            this.closed = true;
            this.flush();
            throwable0 = null;
        }
        catch(Throwable throwable0) {
        }
        try {
            this.out.close();
        }
        catch(Throwable throwable1) {
            if(throwable0 == null) {
                throwable0 = throwable1;
            }
        }
        if(throwable0 != null) {
            Util.sneakyThrow(throwable0);
        }
    }

    public void reset(OutputStream outputStream0) {
        Assertions.checkState(this.closed);
        this.out = outputStream0;
        this.count = 0;
        this.closed = false;
    }
}

