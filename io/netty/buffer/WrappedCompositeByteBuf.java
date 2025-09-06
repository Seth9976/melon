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
import java.util.Iterator;
import java.util.List;

class WrappedCompositeByteBuf extends CompositeByteBuf {
    private final CompositeByteBuf wrapped;

    public WrappedCompositeByteBuf(CompositeByteBuf compositeByteBuf0) {
        super(compositeByteBuf0.alloc());
        this.wrapped = compositeByteBuf0;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final byte _getByte(int v) {
        return this.wrapped._getByte(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final int _getInt(int v) {
        return this.wrapped._getInt(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final int _getIntLE(int v) {
        return this.wrapped._getIntLE(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final long _getLong(int v) {
        return this.wrapped._getLong(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final long _getLongLE(int v) {
        return this.wrapped._getLongLE(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final short _getShort(int v) {
        return this.wrapped._getShort(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final short _getShortLE(int v) {
        return this.wrapped._getShortLE(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final int _getUnsignedMedium(int v) {
        return this.wrapped._getUnsignedMedium(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final int _getUnsignedMediumLE(int v) {
        return this.wrapped._getUnsignedMediumLE(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final void _setByte(int v, int v1) {
        this.wrapped._setByte(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final void _setInt(int v, int v1) {
        this.wrapped._setInt(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final void _setIntLE(int v, int v1) {
        this.wrapped._setIntLE(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final void _setLong(int v, long v1) {
        this.wrapped._setLong(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final void _setLongLE(int v, long v1) {
        this.wrapped._setLongLE(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final void _setMedium(int v, int v1) {
        this.wrapped._setMedium(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final void _setMediumLE(int v, int v1) {
        this.wrapped._setMediumLE(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final void _setShort(int v, int v1) {
        this.wrapped._setShort(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final void _setShortLE(int v, int v1) {
        this.wrapped._setShortLE(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(int v, ByteBuf byteBuf0) {
        this.wrapped.addComponent(v, byteBuf0);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(ByteBuf byteBuf0) {
        this.wrapped.addComponent(byteBuf0);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(boolean z, int v, ByteBuf byteBuf0) {
        this.wrapped.addComponent(z, v, byteBuf0);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponent(boolean z, ByteBuf byteBuf0) {
        this.wrapped.addComponent(z, byteBuf0);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(int v, Iterable iterable0) {
        this.wrapped.addComponents(v, iterable0);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(int v, ByteBuf[] arr_byteBuf) {
        this.wrapped.addComponents(v, arr_byteBuf);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(Iterable iterable0) {
        this.wrapped.addComponents(iterable0);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(boolean z, Iterable iterable0) {
        this.wrapped.addComponents(z, iterable0);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(boolean z, ByteBuf[] arr_byteBuf) {
        this.wrapped.addComponents(z, arr_byteBuf);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addComponents(ByteBuf[] arr_byteBuf) {
        this.wrapped.addComponents(arr_byteBuf);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf addFlattenedComponents(boolean z, ByteBuf byteBuf0) {
        this.wrapped.addFlattenedComponents(z, byteBuf0);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final ByteBufAllocator alloc() {
        return this.wrapped.alloc();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final byte[] array() {
        return this.wrapped.array();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final int arrayOffset() {
        return this.wrapped.arrayOffset();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf asReadOnly() {
        return this.wrapped.asReadOnly();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int bytesBefore(byte b) {
        return this.wrapped.bytesBefore(b);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int bytesBefore(int v, byte b) {
        return this.wrapped.bytesBefore(v, b);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int bytesBefore(int v, int v1, byte b) {
        return this.wrapped.bytesBefore(v, v1, b);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final int capacity() {
        return this.wrapped.capacity();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf capacity(int v) {
        return this.capacity(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf capacity(int v) {
        this.wrapped.capacity(v);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf clear() {
        return this.clear();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final CompositeByteBuf clear() {
        this.wrapped.clear();
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final int compareTo(ByteBuf byteBuf0) {
        return this.wrapped.compareTo(byteBuf0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int compareTo(Object object0) {
        return this.compareTo(((ByteBuf)object0));
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final ByteBuf component(int v) {
        return this.wrapped.component(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final ByteBuf componentAtOffset(int v) {
        return this.wrapped.componentAtOffset(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf consolidate() {
        this.wrapped.consolidate();
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf consolidate(int v, int v1) {
        this.wrapped.consolidate(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf copy() {
        return this.wrapped.copy();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf copy(int v, int v1) {
        return this.wrapped.copy(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final void deallocate() {
        this.wrapped.deallocate();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public List decompose(int v, int v1) {
        return this.wrapped.decompose(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf discardReadBytes() {
        return this.discardReadBytes();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf discardReadBytes() {
        this.wrapped.discardReadBytes();
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf discardReadComponents() {
        this.wrapped.discardReadComponents();
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf discardSomeReadBytes() {
        return this.discardSomeReadBytes();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf discardSomeReadBytes() {
        this.wrapped.discardSomeReadBytes();
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf duplicate() {
        return this.wrapped.duplicate();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int ensureWritable(int v, boolean z) {
        return this.wrapped.ensureWritable(v, z);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf ensureWritable(int v) {
        return this.ensureWritable(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf ensureWritable(int v) {
        this.wrapped.ensureWritable(v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final boolean equals(Object object0) {
        return this.wrapped.equals(object0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int forEachByte(int v, int v1, ByteProcessor byteProcessor0) {
        return this.wrapped.forEachByte(v, v1, byteProcessor0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int forEachByte(ByteProcessor byteProcessor0) {
        return this.wrapped.forEachByte(byteProcessor0);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public int forEachByteAsc0(int v, int v1, ByteProcessor byteProcessor0) {
        return this.wrapped.forEachByteAsc0(v, v1, byteProcessor0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int forEachByteDesc(int v, int v1, ByteProcessor byteProcessor0) {
        return this.wrapped.forEachByteDesc(v, v1, byteProcessor0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int forEachByteDesc(ByteProcessor byteProcessor0) {
        return this.wrapped.forEachByteDesc(byteProcessor0);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public int forEachByteDesc0(int v, int v1, ByteProcessor byteProcessor0) {
        return this.wrapped.forEachByteDesc0(v, v1, byteProcessor0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public boolean getBoolean(int v) {
        return this.wrapped.getBoolean(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public byte getByte(int v) {
        return this.wrapped.getByte(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public int getBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        return this.wrapped.getBytes(v, fileChannel0, v1, v2);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public int getBytes(int v, GatheringByteChannel gatheringByteChannel0, int v1) {
        return this.wrapped.getBytes(v, gatheringByteChannel0, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0) {
        return this.getBytes(v, byteBuf0);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1) {
        return this.getBytes(v, byteBuf0, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        return this.getBytes(v, byteBuf0, v1, v2);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        return this.getBytes(v, outputStream0, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        return this.getBytes(v, byteBuffer0);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b) {
        return this.getBytes(v, arr_b);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        return this.getBytes(v, arr_b, v1, v2);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf getBytes(int v, ByteBuf byteBuf0) {
        this.wrapped.getBytes(v, byteBuf0);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf getBytes(int v, ByteBuf byteBuf0, int v1) {
        this.wrapped.getBytes(v, byteBuf0, v1);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.wrapped.getBytes(v, byteBuf0, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        this.wrapped.getBytes(v, outputStream0, v1);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        this.wrapped.getBytes(v, byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf getBytes(int v, byte[] arr_b) {
        this.wrapped.getBytes(v, arr_b);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        this.wrapped.getBytes(v, arr_b, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public char getChar(int v) {
        return this.wrapped.getChar(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public CharSequence getCharSequence(int v, int v1, Charset charset0) {
        return this.wrapped.getCharSequence(v, v1, charset0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public double getDouble(int v) {
        return this.wrapped.getDouble(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public float getFloat(int v) {
        return this.wrapped.getFloat(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getInt(int v) {
        return this.wrapped.getInt(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getIntLE(int v) {
        return this.wrapped.getIntLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long getLong(int v) {
        return this.wrapped.getLong(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long getLongLE(int v) {
        return this.wrapped.getLongLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getMedium(int v) {
        return this.wrapped.getMedium(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getMediumLE(int v) {
        return this.wrapped.getMediumLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short getShort(int v) {
        return this.wrapped.getShort(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short getShortLE(int v) {
        return this.wrapped.getShortLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short getUnsignedByte(int v) {
        return this.wrapped.getUnsignedByte(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long getUnsignedInt(int v) {
        return this.wrapped.getUnsignedInt(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long getUnsignedIntLE(int v) {
        return this.wrapped.getUnsignedIntLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getUnsignedMedium(int v) {
        return this.wrapped.getUnsignedMedium(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getUnsignedMediumLE(int v) {
        return this.wrapped.getUnsignedMediumLE(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getUnsignedShort(int v) {
        return this.wrapped.getUnsignedShort(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getUnsignedShortLE(int v) {
        return this.wrapped.getUnsignedShortLE(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final boolean hasArray() {
        return this.wrapped.hasArray();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final boolean hasMemoryAddress() {
        return this.wrapped.hasMemoryAddress();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int indexOf(int v, int v1, byte b) {
        return this.wrapped.indexOf(v, v1, b);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final ByteBuf internalComponent(int v) {
        return this.wrapped.internalComponent(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final ByteBuf internalComponentAtOffset(int v) {
        return this.wrapped.internalComponentAtOffset(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuffer internalNioBuffer(int v, int v1) {
        return this.wrapped.internalNioBuffer(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final boolean isAccessible() {
        return this.wrapped.isAccessible();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final boolean isDirect() {
        return this.wrapped.isDirect();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public boolean isReadOnly() {
        return this.wrapped.isReadOnly();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final boolean isReadable() {
        return this.wrapped.isReadable();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final boolean isReadable(int v) {
        return this.wrapped.isReadable(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final boolean isWritable() {
        return this.wrapped.isWritable();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final boolean isWritable(int v) {
        return this.wrapped.isWritable(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public Iterator iterator() {
        return this.wrapped.iterator();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf markReaderIndex() {
        return this.markReaderIndex();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final CompositeByteBuf markReaderIndex() {
        this.wrapped.markReaderIndex();
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf markWriterIndex() {
        return this.markWriterIndex();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final CompositeByteBuf markWriterIndex() {
        this.wrapped.markWriterIndex();
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final int maxCapacity() {
        return this.wrapped.maxCapacity();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int maxFastWritableBytes() {
        return this.wrapped.maxFastWritableBytes();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final int maxNumComponents() {
        return this.wrapped.maxNumComponents();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final int maxWritableBytes() {
        return this.wrapped.maxWritableBytes();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final long memoryAddress() {
        return this.wrapped.memoryAddress();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public SwappedByteBuf newSwappedByteBuf() {
        return this.wrapped.newSwappedByteBuf();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuffer nioBuffer() {
        return this.wrapped.nioBuffer();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuffer nioBuffer(int v, int v1) {
        return this.wrapped.nioBuffer(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public int nioBufferCount() {
        return this.wrapped.nioBufferCount();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuffer[] nioBuffers() {
        return this.wrapped.nioBuffers();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuffer[] nioBuffers(int v, int v1) {
        return this.wrapped.nioBuffers(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final int numComponents() {
        return this.wrapped.numComponents();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf order(ByteOrder byteOrder0) {
        return this.wrapped.order(byteOrder0);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final ByteOrder order() {
        return this.wrapped.order();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public boolean readBoolean() {
        return this.wrapped.readBoolean();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte readByte() {
        return this.wrapped.readByte();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int readBytes(FileChannel fileChannel0, long v, int v1) {
        return this.wrapped.readBytes(fileChannel0, v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel0, int v) {
        return this.wrapped.readBytes(gatheringByteChannel0, v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf readBytes(int v) {
        return this.wrapped.readBytes(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0) {
        return this.readBytes(byteBuf0);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0, int v) {
        return this.readBytes(byteBuf0, v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0, int v, int v1) {
        return this.readBytes(byteBuf0, v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf readBytes(OutputStream outputStream0, int v) {
        return this.readBytes(outputStream0, v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer0) {
        return this.readBytes(byteBuffer0);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf readBytes(byte[] arr_b) {
        return this.readBytes(arr_b);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf readBytes(byte[] arr_b, int v, int v1) {
        return this.readBytes(arr_b, v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf0) {
        this.wrapped.readBytes(byteBuf0);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf0, int v) {
        this.wrapped.readBytes(byteBuf0, v);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf0, int v, int v1) {
        this.wrapped.readBytes(byteBuf0, v, v1);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf readBytes(OutputStream outputStream0, int v) {
        this.wrapped.readBytes(outputStream0, v);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf readBytes(ByteBuffer byteBuffer0) {
        this.wrapped.readBytes(byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf readBytes(byte[] arr_b) {
        this.wrapped.readBytes(arr_b);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf readBytes(byte[] arr_b, int v, int v1) {
        this.wrapped.readBytes(arr_b, v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public char readChar() {
        return this.wrapped.readChar();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public CharSequence readCharSequence(int v, Charset charset0) {
        return this.wrapped.readCharSequence(v, charset0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public double readDouble() {
        return this.wrapped.readDouble();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public float readFloat() {
        return this.wrapped.readFloat();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int readInt() {
        return this.wrapped.readInt();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int readIntLE() {
        return this.wrapped.readIntLE();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long readLong() {
        return this.wrapped.readLong();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long readLongLE() {
        return this.wrapped.readLongLE();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int readMedium() {
        return this.wrapped.readMedium();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int readMediumLE() {
        return this.wrapped.readMediumLE();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf readRetainedSlice(int v) {
        return this.wrapped.readRetainedSlice(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short readShort() {
        return this.wrapped.readShort();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short readShortLE() {
        return this.wrapped.readShortLE();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf readSlice(int v) {
        return this.wrapped.readSlice(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short readUnsignedByte() {
        return this.wrapped.readUnsignedByte();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long readUnsignedInt() {
        return this.wrapped.readUnsignedInt();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long readUnsignedIntLE() {
        return this.wrapped.readUnsignedIntLE();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int readUnsignedMedium() {
        return this.wrapped.readUnsignedMedium();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int readUnsignedMediumLE() {
        return this.wrapped.readUnsignedMediumLE();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int readUnsignedShort() {
        return this.wrapped.readUnsignedShort();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int readUnsignedShortLE() {
        return this.wrapped.readUnsignedShortLE();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final int readableBytes() {
        return this.wrapped.readableBytes();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final int readerIndex() {
        return this.wrapped.readerIndex();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf readerIndex(int v) {
        return this.readerIndex(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final CompositeByteBuf readerIndex(int v) {
        this.wrapped.readerIndex(v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public final int refCnt() {
        return this.wrapped.refCnt();
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public boolean release() {
        return this.wrapped.release();
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public boolean release(int v) {
        return this.wrapped.release(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf removeComponent(int v) {
        this.wrapped.removeComponent(v);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf removeComponents(int v, int v1) {
        this.wrapped.removeComponents(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf resetReaderIndex() {
        return this.resetReaderIndex();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final CompositeByteBuf resetReaderIndex() {
        this.wrapped.resetReaderIndex();
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf resetWriterIndex() {
        return this.resetWriterIndex();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final CompositeByteBuf resetWriterIndex() {
        this.wrapped.resetWriterIndex();
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf retain() {
        return this.retain();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf retain(int v) {
        return this.retain(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf retain() {
        this.wrapped.retain();
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf retain(int v) {
        this.wrapped.retain(v);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ReferenceCounted retain() {
        return this.retain();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ReferenceCounted retain(int v) {
        return this.retain(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf retainedDuplicate() {
        return this.wrapped.retainedDuplicate();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf retainedSlice() {
        return this.wrapped.retainedSlice();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf retainedSlice(int v, int v1) {
        return this.wrapped.retainedSlice(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf setBoolean(int v, boolean z) {
        return this.setBoolean(v, z);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf setBoolean(int v, boolean z) {
        this.wrapped.setBoolean(v, z);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf setByte(int v, int v1) {
        return this.setByte(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf setByte(int v, int v1) {
        this.wrapped.setByte(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public int setBytes(int v, InputStream inputStream0, int v1) {
        return this.wrapped.setBytes(v, inputStream0, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public int setBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        return this.wrapped.setBytes(v, fileChannel0, v1, v2);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public int setBytes(int v, ScatteringByteChannel scatteringByteChannel0, int v1) {
        return this.wrapped.setBytes(v, scatteringByteChannel0, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0) {
        return this.setBytes(v, byteBuf0);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1) {
        return this.setBytes(v, byteBuf0, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        return this.setBytes(v, byteBuf0, v1, v2);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        return this.setBytes(v, byteBuffer0);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b) {
        return this.setBytes(v, arr_b);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        return this.setBytes(v, arr_b, v1, v2);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf setBytes(int v, ByteBuf byteBuf0) {
        this.wrapped.setBytes(v, byteBuf0);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf setBytes(int v, ByteBuf byteBuf0, int v1) {
        this.wrapped.setBytes(v, byteBuf0, v1);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.wrapped.setBytes(v, byteBuf0, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        this.wrapped.setBytes(v, byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf setBytes(int v, byte[] arr_b) {
        this.wrapped.setBytes(v, arr_b);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        this.wrapped.setBytes(v, arr_b, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf setChar(int v, int v1) {
        return this.setChar(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf setChar(int v, int v1) {
        this.wrapped.setChar(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int setCharSequence(int v, CharSequence charSequence0, Charset charset0) {
        return this.wrapped.setCharSequence(v, charSequence0, charset0);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf setDouble(int v, double f) {
        return this.setDouble(v, f);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf setDouble(int v, double f) {
        this.wrapped.setDouble(v, f);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf setFloat(int v, float f) {
        return this.setFloat(v, f);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf setFloat(int v, float f) {
        this.wrapped.setFloat(v, f);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf setIndex(int v, int v1) {
        return this.setIndex(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final CompositeByteBuf setIndex(int v, int v1) {
        this.wrapped.setIndex(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf setInt(int v, int v1) {
        return this.setInt(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf setInt(int v, int v1) {
        this.wrapped.setInt(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setIntLE(int v, int v1) {
        return this.wrapped.setIntLE(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf setLong(int v, long v1) {
        return this.setLong(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf setLong(int v, long v1) {
        this.wrapped.setLong(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setLongLE(int v, long v1) {
        return this.wrapped.setLongLE(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf setMedium(int v, int v1) {
        return this.setMedium(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf setMedium(int v, int v1) {
        this.wrapped.setMedium(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setMediumLE(int v, int v1) {
        return this.wrapped.setMediumLE(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf setShort(int v, int v1) {
        return this.setShort(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf setShort(int v, int v1) {
        this.wrapped.setShort(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setShortLE(int v, int v1) {
        return this.wrapped.setShortLE(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf setZero(int v, int v1) {
        return this.setZero(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf setZero(int v, int v1) {
        this.wrapped.setZero(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf skipBytes(int v) {
        return this.skipBytes(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf skipBytes(int v) {
        this.wrapped.skipBytes(v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf slice() {
        return this.wrapped.slice();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf slice(int v, int v1) {
        return this.wrapped.slice(v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final int toByteIndex(int v) {
        return this.wrapped.toByteIndex(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final int toComponentIndex(int v) {
        return this.wrapped.toComponentIndex(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final String toString() {
        return this.wrapped.toString();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public String toString(int v, int v1, Charset charset0) {
        return this.wrapped.toString(v, v1, charset0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public String toString(Charset charset0) {
        return this.wrapped.toString(charset0);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf touch() {
        return this.touch();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf touch(Object object0) {
        return this.touch(object0);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf touch() {
        this.wrapped.touch();
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf touch(Object object0) {
        this.wrapped.touch(object0);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ReferenceCounted touch() {
        return this.touch();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ReferenceCounted touch(Object object0) {
        return this.touch(object0);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final ByteBuf unwrap() {
        return this.wrapped;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final int writableBytes() {
        return this.wrapped.writableBytes();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf writeBoolean(boolean z) {
        return this.writeBoolean(z);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf writeBoolean(boolean z) {
        this.wrapped.writeBoolean(z);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf writeByte(int v) {
        return this.writeByte(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf writeByte(int v) {
        this.wrapped.writeByte(v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int writeBytes(InputStream inputStream0, int v) {
        return this.wrapped.writeBytes(inputStream0, v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int writeBytes(FileChannel fileChannel0, long v, int v1) {
        return this.wrapped.writeBytes(fileChannel0, v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel0, int v) {
        return this.wrapped.writeBytes(scatteringByteChannel0, v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0) {
        return this.writeBytes(byteBuf0);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0, int v) {
        return this.writeBytes(byteBuf0, v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0, int v, int v1) {
        return this.writeBytes(byteBuf0, v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer0) {
        return this.writeBytes(byteBuffer0);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf writeBytes(byte[] arr_b) {
        return this.writeBytes(arr_b);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf writeBytes(byte[] arr_b, int v, int v1) {
        return this.writeBytes(arr_b, v, v1);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf0) {
        this.wrapped.writeBytes(byteBuf0);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf0, int v) {
        this.wrapped.writeBytes(byteBuf0, v);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf0, int v, int v1) {
        this.wrapped.writeBytes(byteBuf0, v, v1);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf writeBytes(ByteBuffer byteBuffer0) {
        this.wrapped.writeBytes(byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf writeBytes(byte[] arr_b) {
        this.wrapped.writeBytes(arr_b);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf writeBytes(byte[] arr_b, int v, int v1) {
        this.wrapped.writeBytes(arr_b, v, v1);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf writeChar(int v) {
        return this.writeChar(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf writeChar(int v) {
        this.wrapped.writeChar(v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int writeCharSequence(CharSequence charSequence0, Charset charset0) {
        return this.wrapped.writeCharSequence(charSequence0, charset0);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf writeDouble(double f) {
        return this.writeDouble(f);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf writeDouble(double f) {
        this.wrapped.writeDouble(f);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf writeFloat(float f) {
        return this.writeFloat(f);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf writeFloat(float f) {
        this.wrapped.writeFloat(f);
        return this;
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf writeInt(int v) {
        return this.writeInt(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf writeInt(int v) {
        this.wrapped.writeInt(v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeIntLE(int v) {
        return this.wrapped.writeIntLE(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf writeLong(long v) {
        return this.writeLong(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf writeLong(long v) {
        this.wrapped.writeLong(v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeLongLE(long v) {
        return this.wrapped.writeLongLE(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf writeMedium(int v) {
        return this.writeMedium(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf writeMedium(int v) {
        this.wrapped.writeMedium(v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeMediumLE(int v) {
        return this.wrapped.writeMediumLE(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf writeShort(int v) {
        return this.writeShort(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf writeShort(int v) {
        this.wrapped.writeShort(v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeShortLE(int v) {
        return this.wrapped.writeShortLE(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf writeZero(int v) {
        return this.writeZero(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public CompositeByteBuf writeZero(int v) {
        this.wrapped.writeZero(v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final int writerIndex() {
        return this.wrapped.writerIndex();
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public ByteBuf writerIndex(int v) {
        return this.writerIndex(v);
    }

    @Override  // io.netty.buffer.CompositeByteBuf
    public final CompositeByteBuf writerIndex(int v) {
        this.wrapped.writerIndex(v);
        return this;
    }
}

