package org.apache.http.impl.io;

import U4.x;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.TruncatedChunkException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class ChunkedInputStreamHC4 extends InputStream {
    private static final int BUFFER_SIZE = 0x800;
    private static final int CHUNK_CRLF = 3;
    private static final int CHUNK_DATA = 2;
    private static final int CHUNK_LEN = 1;
    private final CharArrayBuffer buffer;
    private int chunkSize;
    private boolean closed;
    private boolean eof;
    private Header[] footers;
    private final SessionInputBuffer in;
    private int pos;
    private int state;

    public ChunkedInputStreamHC4(SessionInputBuffer sessionInputBuffer0) {
        this.eof = false;
        this.closed = false;
        this.footers = new Header[0];
        this.in = (SessionInputBuffer)Args.notNull(sessionInputBuffer0, "Session input buffer");
        this.pos = 0;
        this.buffer = new CharArrayBuffer(16);
        this.state = 1;
    }

    // 去混淆评级： 低(20)
    @Override
    public int available() {
        return this.in instanceof BufferInfo ? Math.min(((BufferInfo)this.in).length(), this.chunkSize - this.pos) : 0;
    }

    @Override
    public void close() {
        if(!this.closed) {
            try {
                if(!this.eof) {
                    while(this.read(new byte[0x800]) >= 0) {
                    }
                }
            }
            finally {
                this.eof = true;
                this.closed = true;
            }
        }
    }

    private int getChunkSize() {
        int v = this.state;
        if(v != 1) {
            if(v != 3) {
                throw new IllegalStateException("Inconsistent codec state");
            }
            this.buffer.clear();
            if(this.in.readLine(this.buffer) == -1) {
                return 0;
            }
            if(!this.buffer.isEmpty()) {
                throw new MalformedChunkCodingException("Unexpected content at the end of chunk");
            }
            this.state = 1;
        }
        this.buffer.clear();
        if(this.in.readLine(this.buffer) == -1) {
            return 0;
        }
        int v1 = this.buffer.indexOf(59);
        if(v1 < 0) {
            v1 = this.buffer.length();
        }
        try {
            return Integer.parseInt(this.buffer.substringTrimmed(0, v1), 16);
        }
        catch(NumberFormatException unused_ex) {
            throw new MalformedChunkCodingException("Bad chunk header");
        }
    }

    public Header[] getFooters() {
        return (Header[])this.footers.clone();
    }

    private void nextChunk() {
        int v = this.getChunkSize();
        this.chunkSize = v;
        if(v < 0) {
            throw new MalformedChunkCodingException("Negative chunk size");
        }
        this.state = 2;
        this.pos = 0;
        if(v == 0) {
            this.eof = true;
            this.parseTrailerHeaders();
        }
    }

    private void parseTrailerHeaders() {
        try {
            this.footers = AbstractMessageParserHC4.parseHeaders(this.in, -1, -1, null);
        }
        catch(HttpException httpException0) {
            MalformedChunkCodingException malformedChunkCodingException0 = new MalformedChunkCodingException("Invalid footer: " + httpException0.getMessage());
            malformedChunkCodingException0.initCause(httpException0);
            throw malformedChunkCodingException0;
        }
    }

    @Override
    public int read() {
        if(this.closed) {
            throw new IOException("Attempted read from closed stream.");
        }
        if(this.eof) {
            return -1;
        }
        if(this.state != 2) {
            this.nextChunk();
            if(this.eof) {
                return -1;
            }
        }
        int v = this.in.read();
        if(v != -1) {
            int v1 = this.pos + 1;
            this.pos = v1;
            if(v1 >= this.chunkSize) {
                this.state = 3;
            }
        }
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
        if(this.eof) {
            return -1;
        }
        if(this.state != 2) {
            this.nextChunk();
            if(this.eof) {
                return -1;
            }
        }
        int v2 = this.in.read(arr_b, v, Math.min(v1, this.chunkSize - this.pos));
        if(v2 != -1) {
            int v3 = this.pos + v2;
            this.pos = v3;
            if(v3 >= this.chunkSize) {
                this.state = 3;
            }
            return v2;
        }
        this.eof = true;
        StringBuilder stringBuilder0 = new StringBuilder("Truncated chunk ( expected size: ");
        stringBuilder0.append(this.chunkSize);
        stringBuilder0.append("; actual size: ");
        throw new TruncatedChunkException(x.g(this.pos, ")", stringBuilder0));
    }
}

