package com.kakao.emoticon.cache.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

class StrictLineReader implements Closeable {
    private static final byte CR = 13;
    private static final byte LF = 10;
    private byte[] buf;
    private final Charset charset;
    private int end;
    private final InputStream in;
    private int pos;

    public StrictLineReader(InputStream inputStream0, int v, Charset charset0) {
        if(inputStream0 == null || charset0 == null) {
            throw null;
        }
        if(v < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if(!charset0.equals(Util.US_ASCII)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.in = inputStream0;
        this.charset = charset0;
        this.buf = new byte[v];
    }

    public StrictLineReader(InputStream inputStream0, Charset charset0) {
        this(inputStream0, 0x2000, charset0);
    }

    @Override
    public void close() {
        synchronized(this.in) {
            if(this.buf != null) {
                this.buf = null;
                this.in.close();
            }
        }
    }

    private void fillBuf() {
        int v = this.in.read(this.buf, 0, this.buf.length);
        if(v == -1) {
            throw new EOFException();
        }
        this.pos = 0;
        this.end = v;
    }

    public boolean hasUnterminatedLine() {
        return this.end == -1;
    }

    public String readLine() {
        int v4;
        int v3;
        synchronized(this.in) {
            if(this.buf != null) {
                if(this.pos >= this.end) {
                    this.fillBuf();
                }
                for(int v1 = this.pos; v1 != this.end; ++v1) {
                    byte[] arr_b = this.buf;
                    if(arr_b[v1] == 10) {
                        int v2 = this.pos;
                        if(v1 == v2) {
                            v3 = v1;
                        }
                        else {
                            v3 = v1 - 1;
                            if(arr_b[v3] != 13) {
                                v3 = v1;
                            }
                        }
                        String s = new String(arr_b, v2, v3 - v2, this.charset.name());
                        this.pos = v1 + 1;
                        return s;
                    }
                }
                com.kakao.emoticon.cache.disklrucache.StrictLineReader.1 strictLineReader$10 = new ByteArrayOutputStream(this.end - this.pos + 80) {
                    @Override
                    public String toString() {
                        int v = this.count <= 0 || this.buf[this.count - 1] != 13 ? this.count : this.count - 1;
                        try {
                            return new String(this.buf, 0, v, StrictLineReader.this.charset.name());
                        }
                        catch(UnsupportedEncodingException unsupportedEncodingException0) {
                            throw new AssertionError(unsupportedEncodingException0);
                        }
                    }
                };
                do {
                    strictLineReader$10.write(this.buf, this.pos, this.end - this.pos);
                    this.end = -1;
                    this.fillBuf();
                    v4 = this.pos;
                label_30:
                }
                while(v4 == this.end);
                byte[] arr_b1 = this.buf;
                if(arr_b1[v4] != 10) {
                    ++v4;
                    goto label_30;
                }
                int v5 = this.pos;
                if(v4 != v5) {
                    strictLineReader$10.write(arr_b1, v5, v4 - v5);
                }
                this.pos = v4 + 1;
                return strictLineReader$10.toString();
            }
        }
        throw new IOException("LineReader is closed");
    }
}

