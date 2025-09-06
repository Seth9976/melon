package org.apache.http.impl.io;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class SessionOutputBufferImpl implements BufferInfo, SessionOutputBuffer {
    private static final byte[] CRLF;
    private ByteBuffer bbuf;
    private final ByteArrayBuffer buffer;
    private final CharsetEncoder encoder;
    private final int fragementSizeHint;
    private final HttpTransportMetricsImpl metrics;
    private OutputStream outstream;

    static {
        SessionOutputBufferImpl.CRLF = new byte[]{13, 10};
    }

    public SessionOutputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl0, int v) {
        this(httpTransportMetricsImpl0, v, v, null);
    }

    public SessionOutputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl0, int v, int v1, CharsetEncoder charsetEncoder0) {
        Args.positive(v, "Buffer size");
        Args.notNull(httpTransportMetricsImpl0, "HTTP transport metrcis");
        this.metrics = httpTransportMetricsImpl0;
        this.buffer = new ByteArrayBuffer(v);
        if(v1 < 0) {
            v1 = 0;
        }
        this.fragementSizeHint = v1;
        this.encoder = charsetEncoder0;
    }

    @Override  // org.apache.http.io.BufferInfo
    public int available() {
        return this.capacity() - this.length();
    }

    public void bind(OutputStream outputStream0) {
        this.outstream = outputStream0;
    }

    @Override  // org.apache.http.io.BufferInfo
    public int capacity() {
        return this.buffer.capacity();
    }

    @Override  // org.apache.http.io.SessionOutputBuffer
    public void flush() {
        this.flushBuffer();
        this.flushStream();
    }

    private void flushBuffer() {
        int v = this.buffer.length();
        if(v > 0) {
            this.streamWrite(this.buffer.buffer(), 0, v);
            this.buffer.clear();
            this.metrics.incrementBytesTransferred(((long)v));
        }
    }

    private void flushStream() {
        OutputStream outputStream0 = this.outstream;
        if(outputStream0 != null) {
            outputStream0.flush();
        }
    }

    @Override  // org.apache.http.io.SessionOutputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }

    private void handleEncodingResult(CoderResult coderResult0) {
        if(coderResult0.isError()) {
            coderResult0.throwException();
        }
        this.bbuf.flip();
        while(this.bbuf.hasRemaining()) {
            this.write(this.bbuf.get());
        }
        this.bbuf.compact();
    }

    public boolean isBound() {
        return this.outstream != null;
    }

    @Override  // org.apache.http.io.BufferInfo
    public int length() {
        return this.buffer.length();
    }

    private void streamWrite(byte[] arr_b, int v, int v1) {
        Asserts.notNull(this.outstream, "Output stream");
        this.outstream.write(arr_b, v, v1);
    }

    @Override  // org.apache.http.io.SessionOutputBuffer
    public void write(int v) {
        if(this.fragementSizeHint > 0) {
            if(this.buffer.isFull()) {
                this.flushBuffer();
            }
            this.buffer.append(v);
            return;
        }
        this.flushBuffer();
        this.outstream.write(v);
    }

    @Override  // org.apache.http.io.SessionOutputBuffer
    public void write(byte[] arr_b) {
        if(arr_b == null) {
            return;
        }
        this.write(arr_b, 0, arr_b.length);
    }

    @Override  // org.apache.http.io.SessionOutputBuffer
    public void write(byte[] arr_b, int v, int v1) {
        if(arr_b == null) {
            return;
        }
        if(v1 <= this.fragementSizeHint && v1 <= this.buffer.capacity()) {
            int v2 = this.buffer.length();
            if(v1 > this.buffer.capacity() - v2) {
                this.flushBuffer();
            }
            this.buffer.append(arr_b, v, v1);
            return;
        }
        this.flushBuffer();
        this.streamWrite(arr_b, v, v1);
        this.metrics.incrementBytesTransferred(((long)v1));
    }

    private void writeEncoded(CharBuffer charBuffer0) {
        if(!charBuffer0.hasRemaining()) {
            return;
        }
        if(this.bbuf == null) {
            this.bbuf = ByteBuffer.allocate(0x400);
        }
        this.encoder.reset();
        while(charBuffer0.hasRemaining()) {
            this.handleEncodingResult(this.encoder.encode(charBuffer0, this.bbuf, true));
        }
        this.handleEncodingResult(this.encoder.flush(this.bbuf));
        this.bbuf.clear();
    }

    @Override  // org.apache.http.io.SessionOutputBuffer
    public void writeLine(String s) {
        if(s == null) {
            return;
        }
        if(s.length() > 0) {
            if(this.encoder == null) {
                for(int v = 0; v < s.length(); ++v) {
                    this.write(s.charAt(v));
                }
            }
            else {
                this.writeEncoded(CharBuffer.wrap(s));
            }
        }
        this.write(SessionOutputBufferImpl.CRLF);
    }

    @Override  // org.apache.http.io.SessionOutputBuffer
    public void writeLine(CharArrayBuffer charArrayBuffer0) {
        int v = 0;
        if(charArrayBuffer0 == null) {
            return;
        }
        if(this.encoder == null) {
            for(int v1 = charArrayBuffer0.length(); v1 > 0; v1 -= v3) {
                int v2 = this.buffer.length();
                int v3 = Math.min(this.buffer.capacity() - v2, v1);
                if(v3 > 0) {
                    this.buffer.append(charArrayBuffer0, v, v3);
                }
                if(this.buffer.isFull()) {
                    this.flushBuffer();
                }
                v += v3;
            }
        }
        else {
            this.writeEncoded(CharBuffer.wrap(charArrayBuffer0.buffer(), 0, charArrayBuffer0.length()));
        }
        this.write(SessionOutputBufferImpl.CRLF);
    }
}

