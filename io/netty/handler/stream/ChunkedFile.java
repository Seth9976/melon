package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.RandomAccessFile;

public class ChunkedFile implements ChunkedInput {
    private final int chunkSize;
    private final long endOffset;
    private final RandomAccessFile file;
    private long offset;
    private final long startOffset;

    public ChunkedFile(File file0) {
        this(file0, 0x2000);
    }

    public ChunkedFile(File file0, int v) {
        this(new RandomAccessFile(file0, "r"), v);
    }

    public ChunkedFile(RandomAccessFile randomAccessFile0) {
        this(randomAccessFile0, 0x2000);
    }

    public ChunkedFile(RandomAccessFile randomAccessFile0, int v) {
        this(randomAccessFile0, 0L, randomAccessFile0.length(), v);
    }

    public ChunkedFile(RandomAccessFile randomAccessFile0, long v, long v1, int v2) {
        ObjectUtil.checkNotNull(randomAccessFile0, "file");
        ObjectUtil.checkPositiveOrZero(v, "offset");
        ObjectUtil.checkPositiveOrZero(v1, "length");
        ObjectUtil.checkPositive(v2, "chunkSize");
        this.file = randomAccessFile0;
        this.startOffset = v;
        this.offset = v;
        this.endOffset = v1 + v;
        this.chunkSize = v2;
        randomAccessFile0.seek(v);
    }

    @Override  // io.netty.handler.stream.ChunkedInput
    public void close() {
        this.file.close();
    }

    public long currentOffset() {
        return this.offset;
    }

    public long endOffset() {
        return this.endOffset;
    }

    @Override  // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() {
        return this.offset >= this.endOffset || !this.file.getChannel().isOpen();
    }

    @Override  // io.netty.handler.stream.ChunkedInput
    public long length() {
        return this.endOffset - this.startOffset;
    }

    @Override  // io.netty.handler.stream.ChunkedInput
    public long progress() {
        return this.offset - this.startOffset;
    }

    public ByteBuf readChunk(ByteBufAllocator byteBufAllocator0) {
        long v = this.offset;
        long v1 = this.endOffset;
        if(v >= v1) {
            return null;
        }
        int v2 = (int)Math.min(this.chunkSize, v1 - v);
        ByteBuf byteBuf0 = byteBufAllocator0.heapBuffer(v2);
        try {
            byte[] arr_b = byteBuf0.array();
            int v3 = byteBuf0.arrayOffset();
            this.file.readFully(arr_b, v3, v2);
            byteBuf0.writerIndex(v2);
            this.offset = v + ((long)v2);
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

    public long startOffset() {
        return this.startOffset;
    }
}

