package org.apache.http.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class DeflateInputStream extends InputStream {
    static class DeflateStream extends InflaterInputStream {
        private boolean closed;

        public DeflateStream(InputStream inputStream0, Inflater inflater0) {
            super(inputStream0, inflater0);
            this.closed = false;
        }

        @Override
        public void close() {
            if(this.closed) {
                return;
            }
            this.closed = true;
            this.inf.end();
            super.close();
        }
    }

    private InputStream sourceStream;

    public DeflateInputStream(InputStream inputStream0) {
        byte[] arr_b = new byte[6];
        PushbackInputStream pushbackInputStream0 = new PushbackInputStream(inputStream0, 6);
        int v = pushbackInputStream0.read(arr_b);
        if(v == -1) {
            throw new IOException("Unable to read the response");
        }
        Inflater inflater0 = new Inflater();
        try {
            try {
                int v1;
                while((v1 = inflater0.inflate(new byte[1])) == 0) {
                    if(inflater0.finished()) {
                        throw new IOException("Unable to read the response");
                    }
                    if(inflater0.needsDictionary()) {
                        break;
                    }
                    if(inflater0.needsInput()) {
                        inflater0.setInput(arr_b);
                    }
                }
                if(v1 == -1) {
                    throw new IOException("Unable to read the response");
                }
                pushbackInputStream0.unread(arr_b, 0, v);
                this.sourceStream = new DeflateStream(pushbackInputStream0, new Inflater());
                goto label_27;
            }
            catch(DataFormatException unused_ex) {
            }
            pushbackInputStream0.unread(arr_b, 0, v);
            this.sourceStream = new DeflateStream(pushbackInputStream0, new Inflater(true));
        }
        catch(Throwable throwable0) {
            inflater0.end();
            throw throwable0;
        }
        inflater0.end();
        return;
    label_27:
        inflater0.end();
    }

    @Override
    public int available() {
        return this.sourceStream.available();
    }

    @Override
    public void close() {
        this.sourceStream.close();
    }

    @Override
    public void mark(int v) {
        this.sourceStream.mark(v);
    }

    @Override
    public boolean markSupported() {
        return this.sourceStream.markSupported();
    }

    @Override
    public int read() {
        return this.sourceStream.read();
    }

    @Override
    public int read(byte[] arr_b) {
        return this.sourceStream.read(arr_b);
    }

    @Override
    public int read(byte[] arr_b, int v, int v1) {
        return this.sourceStream.read(arr_b, v, v1);
    }

    @Override
    public void reset() {
        this.sourceStream.reset();
    }

    @Override
    public long skip(long v) {
        return this.sourceStream.skip(v);
    }
}

