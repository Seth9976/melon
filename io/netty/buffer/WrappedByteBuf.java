package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

class WrappedByteBuf extends ByteBuf {
    protected final ByteBuf buf;

    public WrappedByteBuf(ByteBuf byteBuf0) {
        this.buf = (ByteBuf)ObjectUtil.checkNotNull(byteBuf0, "buf");
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return this.buf.alloc();
    }

    @Override  // io.netty.buffer.ByteBuf
    public byte[] array() {
        return this.buf.array();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return this.buf.arrayOffset();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return this.buf.asReadOnly();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int bytesBefore(byte b) {
        return this.buf.bytesBefore(b);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int bytesBefore(int v, byte b) {
        return this.buf.bytesBefore(v, b);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int bytesBefore(int v, int v1, byte b) {
        return this.buf.bytesBefore(v, v1, b);
    }

    @Override  // io.netty.buffer.ByteBuf
    public final int capacity() {
        return this.buf.capacity();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int v) {
        this.buf.capacity(v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf clear() {
        this.buf.clear();
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int compareTo(ByteBuf byteBuf0) {
        return this.buf.compareTo(byteBuf0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int compareTo(Object object0) {
        return this.compareTo(((ByteBuf)object0));
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        return this.buf.copy();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf copy(int v, int v1) {
        return this.buf.copy(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf discardReadBytes() {
        this.buf.discardReadBytes();
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        this.buf.discardSomeReadBytes();
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return this.buf.duplicate();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int ensureWritable(int v, boolean z) {
        return this.buf.ensureWritable(v, z);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int v) {
        this.buf.ensureWritable(v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean equals(Object object0) {
        return this.buf.equals(object0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int forEachByte(int v, int v1, ByteProcessor byteProcessor0) {
        return this.buf.forEachByte(v, v1, byteProcessor0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor0) {
        return this.buf.forEachByte(byteProcessor0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int forEachByteDesc(int v, int v1, ByteProcessor byteProcessor0) {
        return this.buf.forEachByteDesc(v, v1, byteProcessor0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor byteProcessor0) {
        return this.buf.forEachByteDesc(byteProcessor0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean getBoolean(int v) {
        return this.buf.getBoolean(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public byte getByte(int v) {
        return this.buf.getByte(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        return this.buf.getBytes(v, fileChannel0, v1, v2);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, GatheringByteChannel gatheringByteChannel0, int v1) {
        return this.buf.getBytes(v, gatheringByteChannel0, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0) {
        this.buf.getBytes(v, byteBuf0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1) {
        this.buf.getBytes(v, byteBuf0, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.buf.getBytes(v, byteBuf0, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        this.buf.getBytes(v, outputStream0, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        this.buf.getBytes(v, byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b) {
        this.buf.getBytes(v, arr_b);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        this.buf.getBytes(v, arr_b, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public char getChar(int v) {
        return this.buf.getChar(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int v, int v1, Charset charset0) {
        return this.buf.getCharSequence(v, v1, charset0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public double getDouble(int v) {
        return this.buf.getDouble(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public float getFloat(int v) {
        return this.buf.getFloat(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getInt(int v) {
        return this.buf.getInt(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getIntLE(int v) {
        return this.buf.getIntLE(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public long getLong(int v) {
        return this.buf.getLong(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public long getLongLE(int v) {
        return this.buf.getLongLE(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getMedium(int v) {
        return this.buf.getMedium(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getMediumLE(int v) {
        return this.buf.getMediumLE(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public short getShort(int v) {
        return this.buf.getShort(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public short getShortLE(int v) {
        return this.buf.getShortLE(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public short getUnsignedByte(int v) {
        return this.buf.getUnsignedByte(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public long getUnsignedInt(int v) {
        return this.buf.getUnsignedInt(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int v) {
        return this.buf.getUnsignedIntLE(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int v) {
        return this.buf.getUnsignedMedium(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int v) {
        return this.buf.getUnsignedMediumLE(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getUnsignedShort(int v) {
        return this.buf.getUnsignedShort(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int v) {
        return this.buf.getUnsignedShortLE(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return this.buf.hasArray();
    }

    @Override  // io.netty.buffer.ByteBuf
    public final boolean hasMemoryAddress() {
        return this.buf.hasMemoryAddress();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int hashCode() {
        return this.buf.hashCode();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int indexOf(int v, int v1, byte b) {
        return this.buf.indexOf(v, v1, b);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int v, int v1) {
        return this.buf.internalNioBuffer(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public final boolean isAccessible() {
        return this.buf.isAccessible();
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isContiguous() {
        return this.buf.isContiguous();
    }

    @Override  // io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return this.buf.isDirect();
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return this.buf.isReadOnly();
    }

    @Override  // io.netty.buffer.ByteBuf
    public final boolean isReadable() {
        return this.buf.isReadable();
    }

    @Override  // io.netty.buffer.ByteBuf
    public final boolean isReadable(int v) {
        return this.buf.isReadable(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public final boolean isWritable() {
        return this.buf.isWritable();
    }

    @Override  // io.netty.buffer.ByteBuf
    public final boolean isWritable(int v) {
        return this.buf.isWritable(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf markReaderIndex() {
        this.buf.markReaderIndex();
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf markWriterIndex() {
        this.buf.markWriterIndex();
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final int maxCapacity() {
        return this.buf.maxCapacity();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int maxFastWritableBytes() {
        return this.buf.maxFastWritableBytes();
    }

    @Override  // io.netty.buffer.ByteBuf
    public final int maxWritableBytes() {
        return this.buf.maxWritableBytes();
    }

    @Override  // io.netty.buffer.ByteBuf
    public final long memoryAddress() {
        return this.buf.memoryAddress();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        return this.buf.nioBuffer();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int v, int v1) {
        return this.buf.nioBuffer(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.buf.nioBufferCount();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return this.buf.nioBuffers();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int v, int v1) {
        return this.buf.nioBuffers(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder0) {
        return this.buf.order(byteOrder0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteOrder order() {
        return this.buf.order();
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        return this.buf.readBoolean();
    }

    @Override  // io.netty.buffer.ByteBuf
    public byte readByte() {
        return this.buf.readByte();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel0, long v, int v1) {
        return this.buf.readBytes(fileChannel0, v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel0, int v) {
        return this.buf.readBytes(gatheringByteChannel0, v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int v) {
        return this.buf.readBytes(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0) {
        this.buf.readBytes(byteBuf0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0, int v) {
        this.buf.readBytes(byteBuf0, v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0, int v, int v1) {
        this.buf.readBytes(byteBuf0, v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream outputStream0, int v) {
        this.buf.readBytes(outputStream0, v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer0) {
        this.buf.readBytes(byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] arr_b) {
        this.buf.readBytes(arr_b);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] arr_b, int v, int v1) {
        this.buf.readBytes(arr_b, v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public char readChar() {
        return this.buf.readChar();
    }

    @Override  // io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int v, Charset charset0) {
        return this.buf.readCharSequence(v, charset0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public double readDouble() {
        return this.buf.readDouble();
    }

    @Override  // io.netty.buffer.ByteBuf
    public float readFloat() {
        return this.buf.readFloat();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readInt() {
        return this.buf.readInt();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readIntLE() {
        return this.buf.readIntLE();
    }

    @Override  // io.netty.buffer.ByteBuf
    public long readLong() {
        return this.buf.readLong();
    }

    @Override  // io.netty.buffer.ByteBuf
    public long readLongLE() {
        return this.buf.readLongLE();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readMedium() {
        return this.buf.readMedium();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readMediumLE() {
        return this.buf.readMediumLE();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int v) {
        return this.buf.readRetainedSlice(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public short readShort() {
        return this.buf.readShort();
    }

    @Override  // io.netty.buffer.ByteBuf
    public short readShortLE() {
        return this.buf.readShortLE();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int v) {
        return this.buf.readSlice(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        return this.buf.readUnsignedByte();
    }

    @Override  // io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        return this.buf.readUnsignedInt();
    }

    @Override  // io.netty.buffer.ByteBuf
    public long readUnsignedIntLE() {
        return this.buf.readUnsignedIntLE();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readUnsignedMedium() {
        return this.buf.readUnsignedMedium();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        return this.buf.readUnsignedMediumLE();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        return this.buf.readUnsignedShort();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        return this.buf.readUnsignedShortLE();
    }

    @Override  // io.netty.buffer.ByteBuf
    public final int readableBytes() {
        return this.buf.readableBytes();
    }

    @Override  // io.netty.buffer.ByteBuf
    public final int readerIndex() {
        return this.buf.readerIndex();
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf readerIndex(int v) {
        this.buf.readerIndex(v);
        return this;
    }

    @Override  // io.netty.util.ReferenceCounted
    public final int refCnt() {
        return this.buf.refCnt();
    }

    @Override  // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.buf.release();
    }

    @Override  // io.netty.util.ReferenceCounted
    public boolean release(int v) {
        return this.buf.release(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf resetReaderIndex() {
        this.buf.resetReaderIndex();
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf resetWriterIndex() {
        this.buf.resetWriterIndex();
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf retain() {
        this.buf.retain();
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf retain(int v) {
        this.buf.retain(v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ReferenceCounted retain() {
        return this.retain();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ReferenceCounted retain(int v) {
        return this.retain(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return this.buf.retainedDuplicate();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return this.buf.retainedSlice();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int v, int v1) {
        return this.buf.retainedSlice(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBoolean(int v, boolean z) {
        this.buf.setBoolean(v, z);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setByte(int v, int v1) {
        this.buf.setByte(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, InputStream inputStream0, int v1) {
        return this.buf.setBytes(v, inputStream0, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        return this.buf.setBytes(v, fileChannel0, v1, v2);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, ScatteringByteChannel scatteringByteChannel0, int v1) {
        return this.buf.setBytes(v, scatteringByteChannel0, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0) {
        this.buf.setBytes(v, byteBuf0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1) {
        this.buf.setBytes(v, byteBuf0, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.buf.setBytes(v, byteBuf0, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        this.buf.setBytes(v, byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b) {
        this.buf.setBytes(v, arr_b);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        this.buf.setBytes(v, arr_b, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setChar(int v, int v1) {
        this.buf.setChar(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setCharSequence(int v, CharSequence charSequence0, Charset charset0) {
        return this.buf.setCharSequence(v, charSequence0, charset0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setDouble(int v, double f) {
        this.buf.setDouble(v, f);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setFloat(int v, float f) {
        this.buf.setFloat(v, f);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int v, int v1) {
        this.buf.setIndex(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setInt(int v, int v1) {
        this.buf.setInt(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int v, int v1) {
        this.buf.setIntLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setLong(int v, long v1) {
        this.buf.setLong(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int v, long v1) {
        this.buf.setLongLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int v, int v1) {
        this.buf.setMedium(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int v, int v1) {
        this.buf.setMediumLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setShort(int v, int v1) {
        this.buf.setShort(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int v, int v1) {
        this.buf.setShortLE(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setZero(int v, int v1) {
        this.buf.setZero(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int v) {
        this.buf.skipBytes(v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return this.buf.slice();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf slice(int v, int v1) {
        return this.buf.slice(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public String toString() {
        return StringUtil.simpleClassName(this) + '(' + this.buf.toString() + ')';
    }

    @Override  // io.netty.buffer.ByteBuf
    public String toString(int v, int v1, Charset charset0) {
        return this.buf.toString(v, v1, charset0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public String toString(Charset charset0) {
        return this.buf.toString(charset0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf touch() {
        this.buf.touch();
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf touch(Object object0) {
        this.buf.touch(object0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ReferenceCounted touch() {
        return this.touch();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ReferenceCounted touch(Object object0) {
        return this.touch(object0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf unwrap() {
        return this.buf;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final int writableBytes() {
        return this.buf.writableBytes();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBoolean(boolean z) {
        this.buf.writeBoolean(z);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int v) {
        this.buf.writeByte(v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int writeBytes(InputStream inputStream0, int v) {
        return this.buf.writeBytes(inputStream0, v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel fileChannel0, long v, int v1) {
        return this.buf.writeBytes(fileChannel0, v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel0, int v) {
        return this.buf.writeBytes(scatteringByteChannel0, v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0) {
        this.buf.writeBytes(byteBuf0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0, int v) {
        this.buf.writeBytes(byteBuf0, v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0, int v, int v1) {
        this.buf.writeBytes(byteBuf0, v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer0) {
        this.buf.writeBytes(byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] arr_b) {
        this.buf.writeBytes(arr_b);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] arr_b, int v, int v1) {
        this.buf.writeBytes(arr_b, v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeChar(int v) {
        this.buf.writeChar(v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence0, Charset charset0) {
        return this.buf.writeCharSequence(charSequence0, charset0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeDouble(double f) {
        this.buf.writeDouble(f);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeFloat(float f) {
        this.buf.writeFloat(f);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int v) {
        this.buf.writeInt(v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int v) {
        this.buf.writeIntLE(v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long v) {
        this.buf.writeLong(v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long v) {
        this.buf.writeLongLE(v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int v) {
        this.buf.writeMedium(v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int v) {
        this.buf.writeMediumLE(v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int v) {
        this.buf.writeShort(v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int v) {
        this.buf.writeShortLE(v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int v) {
        this.buf.writeZero(v);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final int writerIndex() {
        return this.buf.writerIndex();
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuf writerIndex(int v) {
        this.buf.writerIndex(v);
        return this;
    }
}

