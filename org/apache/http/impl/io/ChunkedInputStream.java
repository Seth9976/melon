package org.apache.http.impl.io;

import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.io.SessionInputBuffer;

@Deprecated
public class ChunkedInputStream extends InputStream {
    public ChunkedInputStream(SessionInputBuffer sessionInputBuffer0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void close() {
        throw new RuntimeException("Stub!");
    }

    public Header[] getFooters() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int read() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int read(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int read(byte[] arr_b, int v, int v1) {
        throw new RuntimeException("Stub!");
    }
}

