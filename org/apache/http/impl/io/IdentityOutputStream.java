package org.apache.http.impl.io;

import java.io.OutputStream;
import org.apache.http.io.SessionOutputBuffer;

@Deprecated
public class IdentityOutputStream extends OutputStream {
    public IdentityOutputStream(SessionOutputBuffer sessionOutputBuffer0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void close() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void flush() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void write(int v) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void write(byte[] arr_b) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void write(byte[] arr_b, int v, int v1) {
        throw new RuntimeException("Stub!");
    }
}

