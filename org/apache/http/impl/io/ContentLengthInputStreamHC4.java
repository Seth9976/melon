package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.ConnectionClosedException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.Args;

@NotThreadSafe
public class ContentLengthInputStreamHC4 extends InputStream {
    private static final int BUFFER_SIZE = 0x800;
    private boolean closed;
    private final long contentLength;
    private SessionInputBuffer in;
    private long pos;

    public ContentLengthInputStreamHC4(SessionInputBuffer sessionInputBuffer0, long v) {
        this.pos = 0L;
        this.closed = false;
        this.in = (SessionInputBuffer)Args.notNull(sessionInputBuffer0, "Session input buffer");
        this.contentLength = Args.notNegative(v, "Content length");
    }

    // 去混淆评级： 低(20)
    @Override
    public int available() {
        return this.in instanceof BufferInfo ? Math.min(((BufferInfo)this.in).length(), ((int)(this.contentLength - this.pos))) : 0;
    }

    @Override
    public void close() {
        if(!this.closed) {
            try {
                if(this.pos < this.contentLength) {
                    while(this.read(new byte[0x800]) >= 0) {
                    }
                }
            }
            finally {
                this.closed = true;
            }
        }
    }

    @Override
    public int read() {
        if(this.closed) {
            throw new IOException("Attempted read from closed stream.");
        }
        if(Long.compare(this.pos, this.contentLength) >= 0) {
            return -1;
        }
        int v = this.in.read();
        if(v == -1) {
            if(this.pos < this.contentLength) {
                throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: " + this.contentLength + "; received: " + this.pos);
            }
            return -1;
        }
        ++this.pos;
        return v;
    }

    @Override
    public int read(byte[] arr_b) {
        return this.read(arr_b, 0, arr_b.length);
    }

    @Override
    public int read(byte[] arr_b, int v, int v1) {
        if(this.closed) {
            throw new IOException("Attempted read from closed stream.");
        }
        long v2 = this.pos;
        long v3 = this.contentLength;
        if(Long.compare(v2, v3) >= 0) {
            return -1;
        }
        if(((long)v1) + v2 > v3) {
            v1 = (int)(v3 - v2);
        }
        int v4 = this.in.read(arr_b, v, v1);
        if(v4 == -1 && this.pos < this.contentLength) {
            throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: " + this.contentLength + "; received: " + this.pos);
        }
        if(v4 > 0) {
            this.pos += (long)v4;
        }
        return v4;
    }

    @Override
    public long skip(long v) {
        if(v <= 0L) {
            return 0L;
        }
        long v1 = Math.min(v, this.contentLength - this.pos);
        long v2 = 0L;
        while(v1 > 0L) {
            int v3 = this.read(new byte[0x800], 0, ((int)Math.min(0x800L, v1)));
            if(v3 == -1) {
                break;
            }
            v2 += (long)v3;
            v1 -= (long)v3;
        }
        return v2;
    }
}

