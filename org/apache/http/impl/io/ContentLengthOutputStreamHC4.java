package org.apache.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;

@NotThreadSafe
public class ContentLengthOutputStreamHC4 extends OutputStream {
    private boolean closed;
    private final long contentLength;
    private final SessionOutputBuffer out;
    private long total;

    public ContentLengthOutputStreamHC4(SessionOutputBuffer sessionOutputBuffer0, long v) {
        this.total = 0L;
        this.closed = false;
        this.out = (SessionOutputBuffer)Args.notNull(sessionOutputBuffer0, "Session output buffer");
        this.contentLength = Args.notNegative(v, "Content length");
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
        if(this.total < this.contentLength) {
            this.out.write(v);
            ++this.total;
        }
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
        long v2 = this.total;
        long v3 = this.contentLength;
        if(v2 < v3) {
            long v4 = v3 - v2;
            if(((long)v1) > v4) {
                v1 = (int)v4;
            }
            this.out.write(arr_b, v, v1);
            this.total += (long)v1;
        }
    }
}

