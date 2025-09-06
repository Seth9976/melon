package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ReferenceCounted;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

public abstract class ByteBuf implements ByteBufConvertible, ReferenceCounted, Comparable {
    public abstract ByteBufAllocator alloc();

    public abstract byte[] array();

    public abstract int arrayOffset();

    @Override  // io.netty.buffer.ByteBufConvertible
    public ByteBuf asByteBuf() {
        return this;
    }

    public abstract ByteBuf asReadOnly();

    public abstract int bytesBefore(byte arg1);

    public abstract int bytesBefore(int arg1, byte arg2);

    public abstract int bytesBefore(int arg1, int arg2, byte arg3);

    public abstract int capacity();

    public abstract ByteBuf capacity(int arg1);

    public abstract ByteBuf clear();

    public abstract int compareTo(ByteBuf arg1);

    @Override
    public int compareTo(Object object0) {
        return this.compareTo(((ByteBuf)object0));
    }

    public abstract ByteBuf copy();

    public abstract ByteBuf copy(int arg1, int arg2);

    public abstract ByteBuf discardReadBytes();

    public abstract ByteBuf discardSomeReadBytes();

    public abstract ByteBuf duplicate();

    public abstract int ensureWritable(int arg1, boolean arg2);

    public abstract ByteBuf ensureWritable(int arg1);

    @Override
    public abstract boolean equals(Object arg1);

    public abstract int forEachByte(int arg1, int arg2, ByteProcessor arg3);

    public abstract int forEachByte(ByteProcessor arg1);

    public abstract int forEachByteDesc(int arg1, int arg2, ByteProcessor arg3);

    public abstract int forEachByteDesc(ByteProcessor arg1);

    public abstract boolean getBoolean(int arg1);

    public abstract byte getByte(int arg1);

    public abstract int getBytes(int arg1, FileChannel arg2, long arg3, int arg4);

    public abstract int getBytes(int arg1, GatheringByteChannel arg2, int arg3);

    public abstract ByteBuf getBytes(int arg1, ByteBuf arg2);

    public abstract ByteBuf getBytes(int arg1, ByteBuf arg2, int arg3);

    public abstract ByteBuf getBytes(int arg1, ByteBuf arg2, int arg3, int arg4);

    public abstract ByteBuf getBytes(int arg1, OutputStream arg2, int arg3);

    public abstract ByteBuf getBytes(int arg1, ByteBuffer arg2);

    public abstract ByteBuf getBytes(int arg1, byte[] arg2);

    public abstract ByteBuf getBytes(int arg1, byte[] arg2, int arg3, int arg4);

    public abstract char getChar(int arg1);

    public abstract CharSequence getCharSequence(int arg1, int arg2, Charset arg3);

    public abstract double getDouble(int arg1);

    public double getDoubleLE(int v) {
        return Double.longBitsToDouble(this.getLongLE(v));
    }

    public abstract float getFloat(int arg1);

    public float getFloatLE(int v) {
        return Float.intBitsToFloat(this.getIntLE(v));
    }

    public abstract int getInt(int arg1);

    public abstract int getIntLE(int arg1);

    public abstract long getLong(int arg1);

    public abstract long getLongLE(int arg1);

    public abstract int getMedium(int arg1);

    public abstract int getMediumLE(int arg1);

    public abstract short getShort(int arg1);

    public abstract short getShortLE(int arg1);

    public abstract short getUnsignedByte(int arg1);

    public abstract long getUnsignedInt(int arg1);

    public abstract long getUnsignedIntLE(int arg1);

    public abstract int getUnsignedMedium(int arg1);

    public abstract int getUnsignedMediumLE(int arg1);

    public abstract int getUnsignedShort(int arg1);

    public abstract int getUnsignedShortLE(int arg1);

    public abstract boolean hasArray();

    public abstract boolean hasMemoryAddress();

    @Override
    public abstract int hashCode();

    public abstract int indexOf(int arg1, int arg2, byte arg3);

    public abstract ByteBuffer internalNioBuffer(int arg1, int arg2);

    public boolean isAccessible() {
        return this.refCnt() != 0;
    }

    public boolean isContiguous() {
        return false;
    }

    public abstract boolean isDirect();

    public abstract boolean isReadOnly();

    public abstract boolean isReadable();

    public abstract boolean isReadable(int arg1);

    public abstract boolean isWritable();

    public abstract boolean isWritable(int arg1);

    public abstract ByteBuf markReaderIndex();

    public abstract ByteBuf markWriterIndex();

    public abstract int maxCapacity();

    public int maxFastWritableBytes() {
        return this.writableBytes();
    }

    public abstract int maxWritableBytes();

    public abstract long memoryAddress();

    public abstract ByteBuffer nioBuffer();

    public abstract ByteBuffer nioBuffer(int arg1, int arg2);

    public abstract int nioBufferCount();

    public abstract ByteBuffer[] nioBuffers();

    public abstract ByteBuffer[] nioBuffers(int arg1, int arg2);

    @Deprecated
    public abstract ByteBuf order(ByteOrder arg1);

    @Deprecated
    public abstract ByteOrder order();

    public abstract boolean readBoolean();

    public abstract byte readByte();

    public abstract int readBytes(FileChannel arg1, long arg2, int arg3);

    public abstract int readBytes(GatheringByteChannel arg1, int arg2);

    public abstract ByteBuf readBytes(int arg1);

    public abstract ByteBuf readBytes(ByteBuf arg1);

    public abstract ByteBuf readBytes(ByteBuf arg1, int arg2);

    public abstract ByteBuf readBytes(ByteBuf arg1, int arg2, int arg3);

    public abstract ByteBuf readBytes(OutputStream arg1, int arg2);

    public abstract ByteBuf readBytes(ByteBuffer arg1);

    public abstract ByteBuf readBytes(byte[] arg1);

    public abstract ByteBuf readBytes(byte[] arg1, int arg2, int arg3);

    public abstract char readChar();

    public abstract CharSequence readCharSequence(int arg1, Charset arg2);

    public abstract double readDouble();

    public double readDoubleLE() {
        return Double.longBitsToDouble(this.readLongLE());
    }

    public abstract float readFloat();

    public float readFloatLE() {
        return Float.intBitsToFloat(this.readIntLE());
    }

    public abstract int readInt();

    public abstract int readIntLE();

    public abstract long readLong();

    public abstract long readLongLE();

    public abstract int readMedium();

    public abstract int readMediumLE();

    public abstract ByteBuf readRetainedSlice(int arg1);

    public abstract short readShort();

    public abstract short readShortLE();

    public abstract ByteBuf readSlice(int arg1);

    public abstract short readUnsignedByte();

    public abstract long readUnsignedInt();

    public abstract long readUnsignedIntLE();

    public abstract int readUnsignedMedium();

    public abstract int readUnsignedMediumLE();

    public abstract int readUnsignedShort();

    public abstract int readUnsignedShortLE();

    public abstract int readableBytes();

    public abstract int readerIndex();

    public abstract ByteBuf readerIndex(int arg1);

    public abstract ByteBuf resetReaderIndex();

    public abstract ByteBuf resetWriterIndex();

    public abstract ByteBuf retain();

    public abstract ByteBuf retain(int arg1);

    @Override  // io.netty.util.ReferenceCounted
    public ReferenceCounted retain() {
        return this.retain();
    }

    @Override  // io.netty.util.ReferenceCounted
    public ReferenceCounted retain(int v) {
        return this.retain(v);
    }

    public abstract ByteBuf retainedDuplicate();

    public abstract ByteBuf retainedSlice();

    public abstract ByteBuf retainedSlice(int arg1, int arg2);

    public abstract ByteBuf setBoolean(int arg1, boolean arg2);

    public abstract ByteBuf setByte(int arg1, int arg2);

    public abstract int setBytes(int arg1, InputStream arg2, int arg3);

    public abstract int setBytes(int arg1, FileChannel arg2, long arg3, int arg4);

    public abstract int setBytes(int arg1, ScatteringByteChannel arg2, int arg3);

    public abstract ByteBuf setBytes(int arg1, ByteBuf arg2);

    public abstract ByteBuf setBytes(int arg1, ByteBuf arg2, int arg3);

    public abstract ByteBuf setBytes(int arg1, ByteBuf arg2, int arg3, int arg4);

    public abstract ByteBuf setBytes(int arg1, ByteBuffer arg2);

    public abstract ByteBuf setBytes(int arg1, byte[] arg2);

    public abstract ByteBuf setBytes(int arg1, byte[] arg2, int arg3, int arg4);

    public abstract ByteBuf setChar(int arg1, int arg2);

    public abstract int setCharSequence(int arg1, CharSequence arg2, Charset arg3);

    public abstract ByteBuf setDouble(int arg1, double arg2);

    public ByteBuf setDoubleLE(int v, double f) {
        return this.setLongLE(v, Double.doubleToRawLongBits(f));
    }

    public abstract ByteBuf setFloat(int arg1, float arg2);

    public ByteBuf setFloatLE(int v, float f) {
        return this.setIntLE(v, Float.floatToRawIntBits(f));
    }

    public abstract ByteBuf setIndex(int arg1, int arg2);

    public abstract ByteBuf setInt(int arg1, int arg2);

    public abstract ByteBuf setIntLE(int arg1, int arg2);

    public abstract ByteBuf setLong(int arg1, long arg2);

    public abstract ByteBuf setLongLE(int arg1, long arg2);

    public abstract ByteBuf setMedium(int arg1, int arg2);

    public abstract ByteBuf setMediumLE(int arg1, int arg2);

    public abstract ByteBuf setShort(int arg1, int arg2);

    public abstract ByteBuf setShortLE(int arg1, int arg2);

    public abstract ByteBuf setZero(int arg1, int arg2);

    public abstract ByteBuf skipBytes(int arg1);

    public abstract ByteBuf slice();

    public abstract ByteBuf slice(int arg1, int arg2);

    @Override
    public abstract String toString();

    public abstract String toString(int arg1, int arg2, Charset arg3);

    public abstract String toString(Charset arg1);

    public abstract ByteBuf touch();

    public abstract ByteBuf touch(Object arg1);

    @Override  // io.netty.util.ReferenceCounted
    public ReferenceCounted touch() {
        return this.touch();
    }

    @Override  // io.netty.util.ReferenceCounted
    public ReferenceCounted touch(Object object0) {
        return this.touch(object0);
    }

    public abstract ByteBuf unwrap();

    public abstract int writableBytes();

    public abstract ByteBuf writeBoolean(boolean arg1);

    public abstract ByteBuf writeByte(int arg1);

    public abstract int writeBytes(InputStream arg1, int arg2);

    public abstract int writeBytes(FileChannel arg1, long arg2, int arg3);

    public abstract int writeBytes(ScatteringByteChannel arg1, int arg2);

    public abstract ByteBuf writeBytes(ByteBuf arg1);

    public abstract ByteBuf writeBytes(ByteBuf arg1, int arg2);

    public abstract ByteBuf writeBytes(ByteBuf arg1, int arg2, int arg3);

    public abstract ByteBuf writeBytes(ByteBuffer arg1);

    public abstract ByteBuf writeBytes(byte[] arg1);

    public abstract ByteBuf writeBytes(byte[] arg1, int arg2, int arg3);

    public abstract ByteBuf writeChar(int arg1);

    public abstract int writeCharSequence(CharSequence arg1, Charset arg2);

    public abstract ByteBuf writeDouble(double arg1);

    public ByteBuf writeDoubleLE(double f) {
        return this.writeLongLE(Double.doubleToRawLongBits(f));
    }

    public abstract ByteBuf writeFloat(float arg1);

    public ByteBuf writeFloatLE(float f) {
        return this.writeIntLE(Float.floatToRawIntBits(f));
    }

    public abstract ByteBuf writeInt(int arg1);

    public abstract ByteBuf writeIntLE(int arg1);

    public abstract ByteBuf writeLong(long arg1);

    public abstract ByteBuf writeLongLE(long arg1);

    public abstract ByteBuf writeMedium(int arg1);

    public abstract ByteBuf writeMediumLE(int arg1);

    public abstract ByteBuf writeShort(int arg1);

    public abstract ByteBuf writeShortLE(int arg1);

    public abstract ByteBuf writeZero(int arg1);

    public abstract int writerIndex();

    public abstract ByteBuf writerIndex(int arg1);
}

