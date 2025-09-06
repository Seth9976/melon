package io.netty.buffer;

import io.netty.util.ByteProcessor;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

@Deprecated
public class SlicedByteBuf extends AbstractUnpooledSlicedByteBuf {
    private int length;

    public SlicedByteBuf(ByteBuf byteBuf0, int v, int v1) {
        super(byteBuf0, v, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBufAllocator alloc() {
        return super.alloc();
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public byte[] array() {
        return super.array();
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public int arrayOffset() {
        return super.arrayOffset();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.length;
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf capacity(int v) {
        return super.capacity(v);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf copy(int v, int v1) {
        return super.copy(v, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf duplicate() {
        return super.duplicate();
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public int forEachByte(int v, int v1, ByteProcessor byteProcessor0) {
        return super.forEachByte(v, v1, byteProcessor0);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public int forEachByteDesc(int v, int v1, ByteProcessor byteProcessor0) {
        return super.forEachByteDesc(v, v1, byteProcessor0);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public byte getByte(int v) {
        return super.getByte(v);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public int getBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        return super.getBytes(v, fileChannel0, v1, v2);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public int getBytes(int v, GatheringByteChannel gatheringByteChannel0, int v1) {
        return super.getBytes(v, gatheringByteChannel0, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        return super.getBytes(v, byteBuf0, v1, v2);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        return super.getBytes(v, outputStream0, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        return super.getBytes(v, byteBuffer0);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        return super.getBytes(v, arr_b, v1, v2);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public CharSequence getCharSequence(int v, int v1, Charset charset0) {
        return super.getCharSequence(v, v1, charset0);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public int getInt(int v) {
        return super.getInt(v);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public int getIntLE(int v) {
        return super.getIntLE(v);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public long getLong(int v) {
        return super.getLong(v);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public long getLongLE(int v) {
        return super.getLongLE(v);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public short getShort(int v) {
        return super.getShort(v);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public short getShortLE(int v) {
        return super.getShortLE(v);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public int getUnsignedMedium(int v) {
        return super.getUnsignedMedium(v);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public int getUnsignedMediumLE(int v) {
        return super.getUnsignedMediumLE(v);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public boolean hasArray() {
        return super.hasArray();
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public boolean hasMemoryAddress() {
        return super.hasMemoryAddress();
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public final void initLength(int v) {
        this.length = v;
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public boolean isDirect() {
        return super.isDirect();
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public final int length() {
        return this.length;
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public long memoryAddress() {
        return super.memoryAddress();
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuffer nioBuffer(int v, int v1) {
        return super.nioBuffer(v, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public int nioBufferCount() {
        return super.nioBufferCount();
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuffer[] nioBuffers(int v, int v1) {
        return super.nioBuffers(v, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    @Deprecated
    public ByteOrder order() {
        return super.order();
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf setByte(int v, int v1) {
        return super.setByte(v, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public int setBytes(int v, InputStream inputStream0, int v1) {
        return super.setBytes(v, inputStream0, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public int setBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        return super.setBytes(v, fileChannel0, v1, v2);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public int setBytes(int v, ScatteringByteChannel scatteringByteChannel0, int v1) {
        return super.setBytes(v, scatteringByteChannel0, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        return super.setBytes(v, byteBuf0, v1, v2);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        return super.setBytes(v, byteBuffer0);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        return super.setBytes(v, arr_b, v1, v2);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf setInt(int v, int v1) {
        return super.setInt(v, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf setIntLE(int v, int v1) {
        return super.setIntLE(v, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf setLong(int v, long v1) {
        return super.setLong(v, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf setLongLE(int v, long v1) {
        return super.setLongLE(v, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf setMedium(int v, int v1) {
        return super.setMedium(v, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf setMediumLE(int v, int v1) {
        return super.setMediumLE(v, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf setShort(int v, int v1) {
        return super.setShort(v, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf setShortLE(int v, int v1) {
        return super.setShortLE(v, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf slice(int v, int v1) {
        return super.slice(v, v1);
    }

    @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
    public ByteBuf unwrap() {
        return super.unwrap();
    }
}

