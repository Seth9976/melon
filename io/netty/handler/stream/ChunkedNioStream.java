package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;

public class ChunkedNioStream implements ChunkedInput {
    private final ByteBuffer byteBuffer;
    private final int chunkSize;
    private final ReadableByteChannel in;
    private long offset;

    public ChunkedNioStream(ReadableByteChannel readableByteChannel0) {
        this(readableByteChannel0, 0x2000);
    }

    public ChunkedNioStream(ReadableByteChannel readableByteChannel0, int v) {
        this.in = (ReadableByteChannel)ObjectUtil.checkNotNull(readableByteChannel0, "in");
        this.chunkSize = ObjectUtil.checkPositive(v, "chunkSize");
        this.byteBuffer = ByteBuffer.allocate(v);
    }

    @Override  // io.netty.handler.stream.ChunkedInput
    public void close() {
        this.in.close();
    }

    @Override  // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() {
        if(this.byteBuffer.position() > 0) {
            return false;
        }
        if(this.in.isOpen()) {
            int v = this.in.read(this.byteBuffer);
            if(v < 0) {
                return true;
            }
            this.offset += (long)v;
            return false;
        }
        return true;
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
        if(this.isEndOfInput()) {
            return null;
        }
        int v = this.byteBuffer.position();
        do {
            int v1 = this.in.read(this.byteBuffer);
            if(v1 < 0) {
                break;
            }
            v += v1;
            this.offset += (long)v1;
        }
        while(v != this.chunkSize);
        this.byteBuffer.flip();
        ByteBuf byteBuf0 = byteBufAllocator0.buffer(this.byteBuffer.remaining());
        try {
            byteBuf0.writeBytes(this.byteBuffer);
            this.byteBuffer.clear();
            return byteBuf0;
        }
        catch(Throwable throwable0) {
            byteBuf0.release();
            throw throwable0;
        }
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

