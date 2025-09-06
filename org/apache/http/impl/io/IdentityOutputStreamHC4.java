package org.apache.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;

@NotThreadSafe
public class IdentityOutputStreamHC4 extends OutputStream {
    private boolean closed;
    private final SessionOutputBuffer out;

    public IdentityOutputStreamHC4(SessionOutputBuffer sessionOutputBuffer0) {
        this.closed = false;
        this.out = (SessionOutputBuffer)Args.notNull(sessionOutputBuffer0, "Session output buffer");
    }

    @Override
    public void close() {
        if(!this.closed) {
            this.closed = true;
            this.out.flush();
        }
    }

    @Override
    public void flush() {
        this.out.flush();
    }

    @Override
    public void write(int v) {
        if(this.closed) {
            throw new IOException("Attempted write to closed stream.");
        }
        this.out.write(v);
    }

    @Override
    public void write(byte[] arr_b) {
        this.write(arr_b, 0, arr_b.length);
    }

    @Override
    public void write(byte[] arr_b, int v, int v1) {
        if(this.closed) {
            throw new IOException("Attempted write to closed stream.");
        }
        this.out.write(arr_b, v, v1);
    }
}

