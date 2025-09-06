package org.apache.http.impl.io;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import org.apache.http.MessageConstraintException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.config.MessageConstraints;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class SessionInputBufferImpl implements BufferInfo, SessionInputBuffer {
    private final byte[] buffer;
    private int bufferlen;
    private int bufferpos;
    private CharBuffer cbuf;
    private final MessageConstraints constraints;
    private final CharsetDecoder decoder;
    private InputStream instream;
    private final ByteArrayBuffer linebuffer;
    private final HttpTransportMetricsImpl metrics;
    private final int minChunkLimit;

    public SessionInputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl0, int v) {
        this(httpTransportMetricsImpl0, v, v, null, null);
    }

    public SessionInputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl0, int v, int v1, MessageConstraints messageConstraints0, CharsetDecoder charsetDecoder0) {
        Args.notNull(httpTransportMetricsImpl0, "HTTP transport metrcis");
        Args.positive(v, "Buffer size");
        this.metrics = httpTransportMetricsImpl0;
        this.buffer = new byte[v];
        this.bufferpos = 0;
        this.bufferlen = 0;
        if(v1 < 0) {
            v1 = 0x200;
        }
        this.minChunkLimit = v1;
        if(messageConstraints0 == null) {
            messageConstraints0 = MessageConstraints.DEFAULT;
        }
        this.constraints = messageConstraints0;
        this.linebuffer = new ByteArrayBuffer(v);
        this.decoder = charsetDecoder0;
    }

    private int appendDecoded(CharArrayBuffer charArrayBuffer0, ByteBuffer byteBuffer0) {
        int v = 0;
        if(!byteBuffer0.hasRemaining()) {
            return 0;
        }
        if(this.cbuf == null) {
            this.cbuf = CharBuffer.allocate(0x400);
        }
        this.decoder.reset();
        while(byteBuffer0.hasRemaining()) {
            v += this.handleDecodingResult(this.decoder.decode(byteBuffer0, this.cbuf, true), charArrayBuffer0, byteBuffer0);
        }
        int v1 = this.handleDecodingResult(this.decoder.flush(this.cbuf), charArrayBuffer0, byteBuffer0);
        this.cbuf.clear();
        return v + v1;
    }

    @Override  // org.apache.http.io.BufferInfo
    public int available() {
        return this.capacity() - this.length();
    }

    public void bind(InputStream inputStream0) {
        this.instream = inputStream0;
    }

    @Override  // org.apache.http.io.BufferInfo
    public int capacity() {
        return this.buffer.length;
    }

    public void clear() {
        this.bufferpos = 0;
        this.bufferlen = 0;
    }

    public int fillBuffer() {
        int v = this.bufferpos;
        if(v > 0) {
            int v1 = this.bufferlen - v;
            if(v1 > 0) {
                System.arraycopy(this.buffer, v, this.buffer, 0, v1);
            }
            this.bufferpos = 0;
            this.bufferlen = v1;
        }
        int v2 = this.bufferlen;
        int v3 = this.streamRead(this.buffer, v2, this.buffer.length - v2);
        if(v3 == -1) {
            return -1;
        }
        this.bufferlen = v2 + v3;
        this.metrics.incrementBytesTransferred(((long)v3));
        return v3;
    }

    @Override  // org.apache.http.io.SessionInputBuffer
    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }

    private int handleDecodingResult(CoderResult coderResult0, CharArrayBuffer charArrayBuffer0, ByteBuffer byteBuffer0) {
        if(coderResult0.isError()) {
            coderResult0.throwException();
        }
        this.cbuf.flip();
        int v = this.cbuf.remaining();
        while(this.cbuf.hasRemaining()) {
            charArrayBuffer0.append(this.cbuf.get());
        }
        this.cbuf.compact();
        return v;
    }

    public boolean hasBufferedData() {
        return this.bufferpos < this.bufferlen;
    }

    public boolean isBound() {
        return this.instream != null;
    }

    @Override  // org.apache.http.io.SessionInputBuffer
    public boolean isDataAvailable(int v) {
        return this.hasBufferedData();
    }

    @Override  // org.apache.http.io.BufferInfo
    public int length() {
        return this.bufferlen - this.bufferpos;
    }

    private int lineFromLineBuffer(CharArrayBuffer charArrayBuffer0) {
        int v = this.linebuffer.length();
        if(v > 0) {
            if(this.linebuffer.byteAt(v - 1) == 10) {
                --v;
            }
            if(v > 0 && this.linebuffer.byteAt(v - 1) == 13) {
                --v;
            }
        }
        if(this.decoder == null) {
            charArrayBuffer0.append(this.linebuffer, 0, v);
        }
        else {
            v = this.appendDecoded(charArrayBuffer0, ByteBuffer.wrap(this.linebuffer.buffer(), 0, v));
        }
        this.linebuffer.clear();
        return v;
    }

    private int lineFromReadBuffer(CharArrayBuffer charArrayBuffer0, int v) {
        int v1 = this.bufferpos;
        this.bufferpos = v + 1;
        if(v > v1 && this.buffer[v - 1] == 13) {
            --v;
        }
        int v2 = v - v1;
        if(this.decoder == null) {
            charArrayBuffer0.append(this.buffer, v1, v2);
            return v2;
        }
        return this.appendDecoded(charArrayBuffer0, ByteBuffer.wrap(this.buffer, v1, v2));
    }

    private int locateLF() {
        for(int v = this.bufferpos; v < this.bufferlen; ++v) {
            if(this.buffer[v] == 10) {
                return v;
            }
        }
        return -1;
    }

    @Override  // org.apache.http.io.SessionInputBuffer
    public int read() {
        while(!this.hasBufferedData()) {
            if(this.fillBuffer() == -1) {
                return -1;
            }
            if(false) {
                break;
            }
        }
        int v = this.bufferpos;
        this.bufferpos = v + 1;
        return this.buffer[v] & 0xFF;
    }

    @Override  // org.apache.http.io.SessionInputBuffer
    public int read(byte[] arr_b) {
        return arr_b == null ? 0 : this.read(arr_b, 0, arr_b.length);
    }

    @Override  // org.apache.http.io.SessionInputBuffer
    public int read(byte[] arr_b, int v, int v1) {
        if(arr_b == null) {
            return 0;
        }
        if(this.hasBufferedData()) {
            int v2 = Math.min(v1, this.bufferlen - this.bufferpos);
            System.arraycopy(this.buffer, this.bufferpos, arr_b, v, v2);
            this.bufferpos += v2;
            return v2;
        }
        if(v1 > this.minChunkLimit) {
            int v3 = this.streamRead(arr_b, v, v1);
            if(v3 > 0) {
                this.metrics.incrementBytesTransferred(((long)v3));
            }
            return v3;
        }
        while(!this.hasBufferedData()) {
            if(this.fillBuffer() == -1) {
                return -1;
            }
            if(false) {
                break;
            }
        }
        int v4 = Math.min(v1, this.bufferlen - this.bufferpos);
        System.arraycopy(this.buffer, this.bufferpos, arr_b, v, v4);
        this.bufferpos += v4;
        return v4;
    }

    @Override  // org.apache.http.io.SessionInputBuffer
    public int readLine(CharArrayBuffer charArrayBuffer0) {
        Args.notNull(charArrayBuffer0, "Char array buffer");
        int v = 0;
        boolean z = true;
        while(z) {
            int v1 = this.locateLF();
            if(v1 == -1) {
                if(this.hasBufferedData()) {
                    this.linebuffer.append(this.buffer, this.bufferpos, this.bufferlen - this.bufferpos);
                    this.bufferpos = this.bufferlen;
                }
                v = this.fillBuffer();
                if(v == -1) {
                    z = false;
                }
            }
            else {
                if(this.linebuffer.isEmpty()) {
                    return this.lineFromReadBuffer(charArrayBuffer0, v1);
                }
                this.linebuffer.append(this.buffer, this.bufferpos, v1 + 1 - this.bufferpos);
                this.bufferpos = v1 + 1;
                z = false;
            }
            int v2 = this.constraints.getMaxLineLength();
            if(v2 > 0 && this.linebuffer.length() >= v2) {
                throw new MessageConstraintException("Maximum line length limit exceeded");
            }
            if(false) {
                break;
            }
        }
        return v != -1 || !this.linebuffer.isEmpty() ? this.lineFromLineBuffer(charArrayBuffer0) : -1;
    }

    @Override  // org.apache.http.io.SessionInputBuffer
    public String readLine() {
        CharArrayBuffer charArrayBuffer0 = new CharArrayBuffer(0x40);
        return this.readLine(charArrayBuffer0) == -1 ? null : charArrayBuffer0.toString();
    }

    private int streamRead(byte[] arr_b, int v, int v1) {
        Asserts.notNull(this.instream, "Input stream");
        return this.instream.read(arr_b, v, v1);
    }
}

