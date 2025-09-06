package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;

public class ChunkedNioFile implements ChunkedInput {
    private final int chunkSize;
    private final long endOffset;
    private final FileChannel in;
    private long offset;
    private final long startOffset;

    public ChunkedNioFile(File file0) {
        this(new RandomAccessFile(file0, "r").getChannel());
    }

    public ChunkedNioFile(File file0, int v) {
        this(new RandomAccessFile(file0, "r").getChannel(), v);
    }

    public ChunkedNioFile(FileChannel fileChannel0) {
        this(fileChannel0, 0x2000);
    }

    public ChunkedNioFile(FileChannel fileChannel0, int v) {
        this(fileChannel0, 0L, fileChannel0.size(), v);
    }

    public ChunkedNioFile(FileChannel fileChannel0, long v, long v1, int v2) {
        ObjectUtil.checkNotNull(fileChannel0, "in");
        ObjectUtil.checkPositiveOrZero(v, "offset");
        ObjectUtil.checkPositiveOrZero(v1, "length");
        ObjectUtil.checkPositive(v2, "chunkSize");
        if(!fileChannel0.isOpen()) {
            throw new ClosedChannelException();
        }
        this.in = fileChannel0;
        this.chunkSize = v2;
        this.startOffset = v;
        this.offset = v;
        this.endOffset = v + v1;
    }

    @Override  // io.netty.handler.stream.ChunkedInput
    public void close() {
        this.in.close();
    }

    public long currentOffset() {
        return this.offset;
    }

    public long endOffset() {
        return this.endOffset;
    }

    @Override  // io.netty.handler.stream.ChunkedInput
    public boolean isEndOfInput() {
        return this.offset >= this.endOffset || !this.in.isOpen();
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
        ByteBuf byteBuf0 = byteBufAllocator0.buffer(v2);
        int v3 = 0;
        try {
            do {
                int v4 = byteBuf0.writeBytes(this.in, ((long)v3) + v, v2 - v3);
                if(v4 < 0) {
                    break;
                }
                v3 += v4;
            }
            while(v3 != v2);
            this.offset += (long)v3;
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

