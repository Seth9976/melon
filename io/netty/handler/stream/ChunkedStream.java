package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.io.InputStream;
import java.io.PushbackInputStream;
import jeb.synthetic.FIN;

public class ChunkedStream implements ChunkedInput {
    static final int DEFAULT_CHUNK_SIZE = 0x2000;
    private final int chunkSize;
    private boolean closed;
    private final PushbackInputStream in;
    private long offset;

    public ChunkedStream(InputStream inputStream0) {
        this(inputStream0, 0x2000);
    }

    public ChunkedStream(InputStream inputStream0, int v) {
        ObjectUtil.checkNotNull(inputStream0, "in");
        ObjectUtil.checkPositive(v, "chunkSize");
        this.in = inputStream0 instanceof PushbackInputStream ? ((PushbackInputStream)inputStream0) : new PushbackInputStream(inputStream0);
        this.chunkSize = v;
    }

    @Override  // io.netty.handler.stream.ChunkedInput
    public void close() {
        this.closed = true;
        this.in.close();
    }

    @Override  // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() {
        if(this.closed) {
            return true;
        }
        if(this.in.available() > 0) {
            return false;
        }
        int v = this.in.read();
        if(v < 0) {
            return true;
        }
        this.in.unread(v);
        return false;
    }

    @Override  // io.netty.handler.stream.ChunkedInput
    public long length() {
        return -1L;
    }

    @Override  // io.netty.handler.stream.ChunkedInput
    public long progress() {
        return this.offset;
    }

    public ByteBuf readChunk(ByteBufAllocator byteBufAllocator0) {
        int v;
        if(this.isEndOfInput()) {
            return null;
        }
        if(this.in.available() <= 0) {
            v = this.chunkSize;
        }
        else {
            int v1 = this.in.available();
            v = Math.min(this.chunkSize, v1);
        }
        ByteBuf byteBuf0 = byteBufAllocator0.buffer(v);
        int v2 = FIN.finallyOpen$NT();
        int v3 = byteBuf0.writeBytes(this.in, v);
        if(v3 < 0) {
            FIN.finallyCodeBegin$NT(v2);
            byteBuf0.release();
            FIN.finallyCodeEnd$NT(v2);
            return null;
        }
        this.offset += (long)v3;
        return byteBuf0;
    }

    @Deprecated
    public ByteBuf readChunk(ChannelHandlerContext channelHandlerContext0) {
        return this.readChunk(channelHandlerContext0.alloc());
    }

    @Override  // io.netty.handler.stream.ChunkedInput
    public Object readChunk(ByteBufAllocator byteBufAllocator0) {
        return this.readChunk(byteBufAllocator0);
    }

    @Override  // io.netty.handler.stream.ChunkedInput
    @Deprecated
    public Object readChunk(ChannelHandlerContext channelHandlerContext0) {
        return this.readChunk(channelHandlerContext0);
    }

    public long transferredBytes() {
        return this.offset;
    }
}

