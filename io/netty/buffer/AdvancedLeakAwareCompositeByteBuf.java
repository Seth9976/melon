package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakTracker;
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

final class AdvancedLeakAwareCompositeByteBuf extends SimpleLeakAwareCompositeByteBuf {
    public AdvancedLeakAwareCompositeByteBuf(CompositeByteBuf compositeByteBuf0, ResourceLeakTracker resourceLeakTracker0) {
        super(compositeByteBuf0, resourceLeakTracker0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf addComponent(int v, ByteBuf byteBuf0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponent(v, byteBuf0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf addComponent(ByteBuf byteBuf0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponent(byteBuf0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf addComponent(boolean z, int v, ByteBuf byteBuf0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponent(z, v, byteBuf0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf addComponent(boolean z, ByteBuf byteBuf0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponent(z, byteBuf0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf addComponents(int v, Iterable iterable0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponents(v, iterable0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf addComponents(int v, ByteBuf[] arr_byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponents(v, arr_byteBuf);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf addComponents(Iterable iterable0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponents(iterable0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf addComponents(boolean z, Iterable iterable0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponents(z, iterable0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf addComponents(boolean z, ByteBuf[] arr_byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponents(z, arr_byteBuf);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf addComponents(ByteBuf[] arr_byteBuf) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addComponents(arr_byteBuf);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf addFlattenedComponents(boolean z, ByteBuf byteBuf0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.addFlattenedComponents(z, byteBuf0);
    }

    @Override  // io.netty.buffer.SimpleLeakAwareCompositeByteBuf
    public ByteBuf asReadOnly() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.asReadOnly();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int bytesBefore(byte b) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.bytesBefore(b);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int bytesBefore(int v, byte b) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.bytesBefore(v, b);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int bytesBefore(int v, int v1, byte b) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.bytesBefore(v, v1, b);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf capacity(int v) {
        return this.capacity(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf capacity(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.capacity(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf consolidate() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.consolidate();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf consolidate(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.consolidate(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf copy() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.copy();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf copy(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.copy(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public List decompose(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.decompose(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf discardReadBytes() {
        return this.discardReadBytes();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf discardReadBytes() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.discardReadBytes();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf discardReadComponents() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.discardReadComponents();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf discardSomeReadBytes() {
        return this.discardSomeReadBytes();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf discardSomeReadBytes() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.discardSomeReadBytes();
    }

    @Override  // io.netty.buffer.SimpleLeakAwareCompositeByteBuf
    public ByteBuf duplicate() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.duplicate();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int ensureWritable(int v, boolean z) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.ensureWritable(v, z);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf ensureWritable(int v) {
        return this.ensureWritable(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf ensureWritable(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.ensureWritable(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int forEachByte(int v, int v1, ByteProcessor byteProcessor0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByte(v, v1, byteProcessor0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int forEachByte(ByteProcessor byteProcessor0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByte(byteProcessor0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int forEachByteDesc(int v, int v1, ByteProcessor byteProcessor0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByteDesc(v, v1, byteProcessor0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int forEachByteDesc(ByteProcessor byteProcessor0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByteDesc(byteProcessor0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public boolean getBoolean(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBoolean(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public byte getByte(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getByte(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int getBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(v, fileChannel0, v1, v2);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int getBytes(int v, GatheringByteChannel gatheringByteChannel0, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(v, gatheringByteChannel0, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0) {
        return this.getBytes(v, byteBuf0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1) {
        return this.getBytes(v, byteBuf0, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        return this.getBytes(v, byteBuf0, v1, v2);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        return this.getBytes(v, outputStream0, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        return this.getBytes(v, byteBuffer0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b) {
        return this.getBytes(v, arr_b);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        return this.getBytes(v, arr_b, v1, v2);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf getBytes(int v, ByteBuf byteBuf0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(v, byteBuf0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf getBytes(int v, ByteBuf byteBuf0, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(v, byteBuf0, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(v, byteBuf0, v1, v2);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(v, outputStream0, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(v, byteBuffer0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf getBytes(int v, byte[] arr_b) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(v, arr_b);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(v, arr_b, v1, v2);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public char getChar(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getChar(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CharSequence getCharSequence(int v, int v1, Charset charset0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getCharSequence(v, v1, charset0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public double getDouble(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getDouble(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public float getFloat(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getFloat(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int getInt(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getInt(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int getIntLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getIntLE(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public long getLong(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getLong(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public long getLongLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getLongLE(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int getMedium(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getMedium(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int getMediumLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getMediumLE(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public short getShort(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getShort(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public short getShortLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getShortLE(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public short getUnsignedByte(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedByte(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public long getUnsignedInt(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedInt(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public long getUnsignedIntLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedIntLE(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int getUnsignedMedium(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedMedium(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int getUnsignedMediumLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedMediumLE(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int getUnsignedShort(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedShort(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int getUnsignedShortLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedShortLE(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int indexOf(int v, int v1, byte b) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.indexOf(v, v1, b);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuffer internalNioBuffer(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.internalNioBuffer(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public boolean isReadOnly() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.isReadOnly();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public Iterator iterator() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.iterator();
    }

    public AdvancedLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf0, ByteBuf byteBuf1, ResourceLeakTracker resourceLeakTracker0) {
        return new AdvancedLeakAwareByteBuf(byteBuf0, byteBuf1, resourceLeakTracker0);
    }

    @Override  // io.netty.buffer.SimpleLeakAwareCompositeByteBuf
    public SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf0, ByteBuf byteBuf1, ResourceLeakTracker resourceLeakTracker0) {
        return this.newLeakAwareByteBuf(byteBuf0, byteBuf1, resourceLeakTracker0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuffer nioBuffer() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffer();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuffer nioBuffer(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffer(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int nioBufferCount() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBufferCount();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuffer[] nioBuffers() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffers();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuffer[] nioBuffers(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffers(v, v1);
    }

    @Override  // io.netty.buffer.SimpleLeakAwareCompositeByteBuf
    public ByteBuf order(ByteOrder byteOrder0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.order(byteOrder0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public boolean readBoolean() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBoolean();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public byte readByte() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readByte();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int readBytes(FileChannel fileChannel0, long v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(fileChannel0, v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel0, int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(gatheringByteChannel0, v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf readBytes(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0) {
        return this.readBytes(byteBuf0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0, int v) {
        return this.readBytes(byteBuf0, v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0, int v, int v1) {
        return this.readBytes(byteBuf0, v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf readBytes(OutputStream outputStream0, int v) {
        return this.readBytes(outputStream0, v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer0) {
        return this.readBytes(byteBuffer0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf readBytes(byte[] arr_b) {
        return this.readBytes(arr_b);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf readBytes(byte[] arr_b, int v, int v1) {
        return this.readBytes(arr_b, v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf0, int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf0, v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf readBytes(ByteBuf byteBuf0, int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf0, v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf readBytes(OutputStream outputStream0, int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(outputStream0, v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf readBytes(ByteBuffer byteBuffer0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuffer0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf readBytes(byte[] arr_b) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(arr_b);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf readBytes(byte[] arr_b, int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(arr_b, v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public char readChar() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readChar();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CharSequence readCharSequence(int v, Charset charset0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readCharSequence(v, charset0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public double readDouble() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readDouble();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public float readFloat() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readFloat();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int readInt() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readInt();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int readIntLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readIntLE();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public long readLong() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readLong();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public long readLongLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readLongLE();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int readMedium() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readMedium();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int readMediumLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readMediumLE();
    }

    @Override  // io.netty.buffer.SimpleLeakAwareCompositeByteBuf
    public ByteBuf readRetainedSlice(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readRetainedSlice(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public short readShort() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readShort();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public short readShortLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readShortLE();
    }

    @Override  // io.netty.buffer.SimpleLeakAwareCompositeByteBuf
    public ByteBuf readSlice(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readSlice(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public short readUnsignedByte() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedByte();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public long readUnsignedInt() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedInt();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public long readUnsignedIntLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedIntLE();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int readUnsignedMedium() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedMedium();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int readUnsignedMediumLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedMediumLE();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int readUnsignedShort() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedShort();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int readUnsignedShortLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedShortLE();
    }

    @Override  // io.netty.buffer.SimpleLeakAwareCompositeByteBuf
    public boolean release() {
        this.leak.record();
        return super.release();
    }

    @Override  // io.netty.buffer.SimpleLeakAwareCompositeByteBuf
    public boolean release(int v) {
        this.leak.record();
        return super.release(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf removeComponent(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.removeComponent(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf removeComponents(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.removeComponents(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf retain() {
        return this.retain();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf retain(int v) {
        return this.retain(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf retain() {
        this.leak.record();
        return super.retain();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf retain(int v) {
        this.leak.record();
        return super.retain(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ReferenceCounted retain() {
        return this.retain();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ReferenceCounted retain(int v) {
        return this.retain(v);
    }

    @Override  // io.netty.buffer.SimpleLeakAwareCompositeByteBuf
    public ByteBuf retainedDuplicate() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.retainedDuplicate();
    }

    @Override  // io.netty.buffer.SimpleLeakAwareCompositeByteBuf
    public ByteBuf retainedSlice() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.retainedSlice();
    }

    @Override  // io.netty.buffer.SimpleLeakAwareCompositeByteBuf
    public ByteBuf retainedSlice(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.retainedSlice(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setBoolean(int v, boolean z) {
        return this.setBoolean(v, z);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf setBoolean(int v, boolean z) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBoolean(v, z);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setByte(int v, int v1) {
        return this.setByte(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf setByte(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setByte(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int setBytes(int v, InputStream inputStream0, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(v, inputStream0, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int setBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(v, fileChannel0, v1, v2);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int setBytes(int v, ScatteringByteChannel scatteringByteChannel0, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(v, scatteringByteChannel0, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0) {
        return this.setBytes(v, byteBuf0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1) {
        return this.setBytes(v, byteBuf0, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        return this.setBytes(v, byteBuf0, v1, v2);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        return this.setBytes(v, byteBuffer0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b) {
        return this.setBytes(v, arr_b);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        return this.setBytes(v, arr_b, v1, v2);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf setBytes(int v, ByteBuf byteBuf0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(v, byteBuf0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf setBytes(int v, ByteBuf byteBuf0, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(v, byteBuf0, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(v, byteBuf0, v1, v2);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(v, byteBuffer0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf setBytes(int v, byte[] arr_b) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(v, arr_b);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(v, arr_b, v1, v2);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setChar(int v, int v1) {
        return this.setChar(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf setChar(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setChar(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int setCharSequence(int v, CharSequence charSequence0, Charset charset0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setCharSequence(v, charSequence0, charset0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setDouble(int v, double f) {
        return this.setDouble(v, f);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf setDouble(int v, double f) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setDouble(v, f);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setFloat(int v, float f) {
        return this.setFloat(v, f);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf setFloat(int v, float f) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setFloat(v, f);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setInt(int v, int v1) {
        return this.setInt(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf setInt(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setInt(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setIntLE(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setIntLE(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setLong(int v, long v1) {
        return this.setLong(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf setLong(int v, long v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setLong(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setLongLE(int v, long v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setLongLE(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setMedium(int v, int v1) {
        return this.setMedium(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf setMedium(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setMedium(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setMediumLE(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setMediumLE(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setShort(int v, int v1) {
        return this.setShort(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf setShort(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setShort(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setShortLE(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setShortLE(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf setZero(int v, int v1) {
        return this.setZero(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf setZero(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setZero(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf skipBytes(int v) {
        return this.skipBytes(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf skipBytes(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.skipBytes(v);
    }

    @Override  // io.netty.buffer.SimpleLeakAwareCompositeByteBuf
    public ByteBuf slice() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.slice();
    }

    @Override  // io.netty.buffer.SimpleLeakAwareCompositeByteBuf
    public ByteBuf slice(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.slice(v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public String toString(int v, int v1, Charset charset0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.toString(v, v1, charset0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public String toString(Charset charset0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.toString(charset0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf touch() {
        return this.touch();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf touch(Object object0) {
        return this.touch(object0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf touch() {
        this.leak.record();
        return this;
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf touch(Object object0) {
        this.leak.record(object0);
        return this;
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ReferenceCounted touch() {
        return this.touch();
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ReferenceCounted touch(Object object0) {
        return this.touch(object0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeBoolean(boolean z) {
        return this.writeBoolean(z);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf writeBoolean(boolean z) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBoolean(z);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeByte(int v) {
        return this.writeByte(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf writeByte(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeByte(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int writeBytes(InputStream inputStream0, int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(inputStream0, v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int writeBytes(FileChannel fileChannel0, long v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(fileChannel0, v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel0, int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(scatteringByteChannel0, v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0) {
        return this.writeBytes(byteBuf0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0, int v) {
        return this.writeBytes(byteBuf0, v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0, int v, int v1) {
        return this.writeBytes(byteBuf0, v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer0) {
        return this.writeBytes(byteBuffer0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeBytes(byte[] arr_b) {
        return this.writeBytes(arr_b);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeBytes(byte[] arr_b, int v, int v1) {
        return this.writeBytes(arr_b, v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf0, int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf0, v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf writeBytes(ByteBuf byteBuf0, int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf0, v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf writeBytes(ByteBuffer byteBuffer0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuffer0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf writeBytes(byte[] arr_b) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(arr_b);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf writeBytes(byte[] arr_b, int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(arr_b, v, v1);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeChar(int v) {
        return this.writeChar(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf writeChar(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeChar(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public int writeCharSequence(CharSequence charSequence0, Charset charset0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeCharSequence(charSequence0, charset0);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeDouble(double f) {
        return this.writeDouble(f);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf writeDouble(double f) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeDouble(f);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeFloat(float f) {
        return this.writeFloat(f);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf writeFloat(float f) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeFloat(f);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeInt(int v) {
        return this.writeInt(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf writeInt(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeInt(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeIntLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeIntLE(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeLong(long v) {
        return this.writeLong(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf writeLong(long v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeLong(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeLongLE(long v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeLongLE(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeMedium(int v) {
        return this.writeMedium(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf writeMedium(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeMedium(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeMediumLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeMediumLE(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeShort(int v) {
        return this.writeShort(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf writeShort(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeShort(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeShortLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeShortLE(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public ByteBuf writeZero(int v) {
        return this.writeZero(v);
    }

    @Override  // io.netty.buffer.WrappedCompositeByteBuf
    public CompositeByteBuf writeZero(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeZero(v);
    }
}

