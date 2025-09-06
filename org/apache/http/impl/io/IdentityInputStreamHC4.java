package org.apache.http.impl.io;

import java.io.InputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.Args;

@NotThreadSafe
public class IdentityInputStreamHC4 extends InputStream {
    private boolean closed;
    private final SessionInputBuffer in;

    public IdentityInputStreamHC4(SessionInputBuffer sessionInputBuffer0) {
        this.closed = false;
        this.in = (SessionInputBuffer)Args.notNull(sessionInputBuffer0, "Session input buffer");
    }

    // 去混淆评级： 低(20)
    @Override
    public int available() {
        return this.in instanceof BufferInfo ? ((BufferInfo)this.in).length() : 0;
    }

    @Override
    public void close() {
        this.closed = true;
    }

    // 去混淆评级： 低(20)
    @Override
    public int read() {
        return this.closed ? -1 : this.in.read();
    }

    // 去混淆评级： 低(20)
    @Override
    public int read(byte[] arr_b, int v, int v1) {
        return this.closed ? -1 : this.in.read(arr_b, v, v1);
    }
}

