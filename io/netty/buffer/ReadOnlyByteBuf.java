package io.netty.buffer;

import io.netty.util.ByteProcessor;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

@Deprecated
public class ReadOnlyByteBuf extends AbstractDerivedByteBuf {
    private final ByteBuf buffer;

    public ReadOnlyByteBuf(ByteBuf byteBuf0) {
        super(byteBuf0.maxCapacity());
        this.buffer = byteBuf0 instanceof ReadOnlyByteBuf || byteBuf0 instanceof DuplicatedByteBuf ? byteBuf0.unwrap() : byteBuf0;
        this.setIndex(byteBuf0.readerIndex(), byteBuf0.writerIndex());
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int v) {
        return this.unwrap().getByte(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getInt(int v) {
        return this.unwrap().getInt(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int v) {
        return this.unwrap().getIntLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLong(int v) {
        return this.unwrap().getLong(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int v) {
        return this.unwrap().getLongLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShort(int v) {
        return this.unwrap().getShort(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int v) {
        return this.unwrap().getShortLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int v) {
        return this.unwrap().getUnsignedMedium(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int v) {
        return this.unwrap().getUnsignedMediumLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setByte(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setInt(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLong(int v, long v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int v, long v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShort(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.unwrap().alloc();
    }

    @Override  // io.netty.buffer.ByteBuf
    public byte[] array() {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf asReadOnly() {
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.unwrap().capacity();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int v) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf copy(int v, int v1) {
        return this.unwrap().copy(v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf discardReadBytes() {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf duplicate() {
        return new ReadOnlyByteBuf(this);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int ensureWritable(int v, boolean z) {
        return 1;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf ensureWritable(int v) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int forEachByte(int v, int v1, ByteProcessor byteProcessor0) {
        return this.unwrap().forEachByte(v, v1, byteProcessor0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int forEachByteDesc(int v, int v1, ByteProcessor byteProcessor0) {
        return this.unwrap().forEachByteDesc(v, v1, byteProcessor0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte getByte(int v) {
        return this.unwrap().getByte(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        return this.unwrap().getBytes(v, fileChannel0, v1, v2);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, GatheringByteChannel gatheringByteChannel0, int v1) {
        return this.unwrap().getBytes(v, gatheringByteChannel0, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.unwrap().getBytes(v, byteBuf0, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        this.unwrap().getBytes(v, outputStream0, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        this.unwrap().getBytes(v, byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        this.unwrap().getBytes(v, arr_b, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getInt(int v) {
        return this.unwrap().getInt(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getIntLE(int v) {
        return this.unwrap().getIntLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long getLong(int v) {
        return this.unwrap().getLong(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long getLongLE(int v) {
        return this.unwrap().getLongLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short getShort(int v) {
        return this.unwrap().getShort(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short getShortLE(int v) {
        return this.unwrap().getShortLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getUnsignedMedium(int v) {
        return this.unwrap().getUnsignedMedium(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getUnsignedMediumLE(int v) {
        return this.unwrap().getUnsignedMediumLE(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return false;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return this.unwrap().hasMemoryAddress();
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return this.unwrap().isDirect();
    }

    @Override  // io.netty.buffer.AbstractDerivedByteBuf
    public boolean isReadOnly() {
        return true;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public boolean isWritable() {
        return false;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public boolean isWritable(int v) {
        return false;
    }

    @Override  // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return this.unwrap().memoryAddress();
    }

    @Override  // io.netty.buffer.AbstractDerivedByteBuf
    public ByteBuffer nioBuffer(int v, int v1) {
        return this.unwrap().nioBuffer(v, v1).asReadOnlyBuffer();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.unwrap().nioBufferCount();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int v, int v1) {
        return this.unwrap().nioBuffers(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    @Deprecated
    public ByteOrder order() {
        return this.unwrap().order();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setByte(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, InputStream inputStream0, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, ScatteringByteChannel scatteringByteChannel0, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setInt(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setIntLE(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setLong(int v, long v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setLongLE(int v, long v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setMedium(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setMediumLE(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setShort(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setShortLE(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf slice(int v, int v1) {
        return Unpooled.unmodifiableBuffer(this.unwrap().slice(v, v1));
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return this.buffer;
    }
}

