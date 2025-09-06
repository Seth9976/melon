package org.apache.http.impl.auth;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

class HttpEntityDigester extends OutputStream {
    private boolean closed;
    private byte[] digest;
    private final MessageDigest digester;

    public HttpEntityDigester(MessageDigest messageDigest0) {
        this.digester = messageDigest0;
        messageDigest0.reset();
    }

    @Override
    public void close() {
        if(this.closed) {
            return;
        }
        this.closed = true;
        this.digest = this.digester.digest();
        super.close();
    }

    public byte[] getDigest() {
        return this.digest;
    }

    @Override
    public void write(int v) {
        if(this.closed) {
            throw new IOException("Stream has been already closed");
        }
        this.digester.update(((byte)v));
    }

    @Override
    public void write(byte[] arr_b, int v, int v1) {
        if(this.closed) {
            throw new IOException("Stream has been already closed");
        }
        this.digester.update(arr_b, v, v1);
    }
}

