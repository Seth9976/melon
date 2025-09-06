package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

final class AdvancedLeakAwareByteBuf extends SimpleLeakAwareByteBuf {
    private static final boolean ACQUIRE_AND_RELEASE_ONLY = false;
    private static final String PROP_ACQUIRE_AND_RELEASE_ONLY = "io.netty.leakDetection.acquireAndReleaseOnly";
    private static final InternalLogger logger;

    static {
        Class class0 = AdvancedLeakAwareByteBuf.class;
        InternalLogger internalLogger0 = InternalLoggerFactory.getInstance(class0);
        AdvancedLeakAwareByteBuf.logger = internalLogger0;
        boolean z = SystemPropertyUtil.getBoolean("io.netty.leakDetection.acquireAndReleaseOnly", false);
        AdvancedLeakAwareByteBuf.ACQUIRE_AND_RELEASE_ONLY = z;
        if(internalLogger0.isDebugEnabled()) {
            internalLogger0.debug("-D{}: {}", "io.netty.leakDetection.acquireAndReleaseOnly", Boolean.valueOf(z));
        }
        ResourceLeakDetector.addExclusions(class0, new String[]{"touch", "recordLeakNonRefCountingOperation"});
    }

    public AdvancedLeakAwareByteBuf(ByteBuf byteBuf0, ByteBuf byteBuf1, ResourceLeakTracker resourceLeakTracker0) {
        super(byteBuf0, byteBuf1, resourceLeakTracker0);
    }

    public AdvancedLeakAwareByteBuf(ByteBuf byteBuf0, ResourceLeakTracker resourceLeakTracker0) {
        super(byteBuf0, resourceLeakTracker0);
    }

    @Override  // io.netty.buffer.SimpleLeakAwareByteBuf
    public ByteBuf asReadOnly() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.asReadOnly();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int bytesBefore(byte b) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.bytesBefore(b);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int bytesBefore(int v, byte b) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.bytesBefore(v, b);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int bytesBefore(int v, int v1, byte b) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.bytesBefore(v, v1, b);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf capacity(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.capacity(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf copy() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.copy();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf copy(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.copy(v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf discardReadBytes() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.discardReadBytes();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf discardSomeReadBytes() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.discardSomeReadBytes();
    }

    @Override  // io.netty.buffer.SimpleLeakAwareByteBuf
    public ByteBuf duplicate() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.duplicate();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int ensureWritable(int v, boolean z) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.ensureWritable(v, z);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf ensureWritable(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.ensureWritable(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int forEachByte(int v, int v1, ByteProcessor byteProcessor0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByte(v, v1, byteProcessor0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int forEachByte(ByteProcessor byteProcessor0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByte(byteProcessor0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int forEachByteDesc(int v, int v1, ByteProcessor byteProcessor0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByteDesc(v, v1, byteProcessor0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int forEachByteDesc(ByteProcessor byteProcessor0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.forEachByteDesc(byteProcessor0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public boolean getBoolean(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBoolean(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public byte getByte(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getByte(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int getBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(v, fileChannel0, v1, v2);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int getBytes(int v, GatheringByteChannel gatheringByteChannel0, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(v, gatheringByteChannel0, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(v, byteBuf0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(v, byteBuf0, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(v, byteBuf0, v1, v2);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(v, outputStream0, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(v, byteBuffer0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(v, arr_b);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getBytes(v, arr_b, v1, v2);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public char getChar(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getChar(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public CharSequence getCharSequence(int v, int v1, Charset charset0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getCharSequence(v, v1, charset0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public double getDouble(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getDouble(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public float getFloat(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getFloat(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int getInt(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getInt(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int getIntLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getIntLE(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public long getLong(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getLong(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public long getLongLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getLongLE(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int getMedium(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getMedium(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int getMediumLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getMediumLE(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public short getShort(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getShort(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public short getShortLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getShortLE(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public short getUnsignedByte(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedByte(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public long getUnsignedInt(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedInt(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public long getUnsignedIntLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedIntLE(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int getUnsignedMedium(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedMedium(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int getUnsignedMediumLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedMediumLE(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int getUnsignedShort(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedShort(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int getUnsignedShortLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.getUnsignedShortLE(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int indexOf(int v, int v1, byte b) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.indexOf(v, v1, b);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuffer internalNioBuffer(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.internalNioBuffer(v, v1);
    }

    public AdvancedLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf0, ByteBuf byteBuf1, ResourceLeakTracker resourceLeakTracker0) {
        return new AdvancedLeakAwareByteBuf(byteBuf0, byteBuf1, resourceLeakTracker0);
    }

    @Override  // io.netty.buffer.SimpleLeakAwareByteBuf
    public SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf byteBuf0, ByteBuf byteBuf1, ResourceLeakTracker resourceLeakTracker0) {
        return this.newLeakAwareByteBuf(byteBuf0, byteBuf1, resourceLeakTracker0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuffer nioBuffer() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffer();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuffer nioBuffer(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffer(v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int nioBufferCount() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBufferCount();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuffer[] nioBuffers() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffers();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuffer[] nioBuffers(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.nioBuffers(v, v1);
    }

    @Override  // io.netty.buffer.SimpleLeakAwareByteBuf
    public ByteBuf order(ByteOrder byteOrder0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.order(byteOrder0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public boolean readBoolean() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBoolean();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public byte readByte() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readByte();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int readBytes(FileChannel fileChannel0, long v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(fileChannel0, v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel0, int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(gatheringByteChannel0, v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf readBytes(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0, int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf0, v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0, int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuf0, v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf readBytes(OutputStream outputStream0, int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(outputStream0, v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(byteBuffer0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf readBytes(byte[] arr_b) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(arr_b);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf readBytes(byte[] arr_b, int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readBytes(arr_b, v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public char readChar() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readChar();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public CharSequence readCharSequence(int v, Charset charset0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readCharSequence(v, charset0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public double readDouble() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readDouble();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public float readFloat() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readFloat();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int readInt() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readInt();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int readIntLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readIntLE();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public long readLong() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readLong();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public long readLongLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readLongLE();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int readMedium() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readMedium();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int readMediumLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readMediumLE();
    }

    @Override  // io.netty.buffer.SimpleLeakAwareByteBuf
    public ByteBuf readRetainedSlice(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readRetainedSlice(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public short readShort() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readShort();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public short readShortLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readShortLE();
    }

    @Override  // io.netty.buffer.SimpleLeakAwareByteBuf
    public ByteBuf readSlice(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readSlice(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public short readUnsignedByte() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedByte();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public long readUnsignedInt() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedInt();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public long readUnsignedIntLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedIntLE();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int readUnsignedMedium() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedMedium();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int readUnsignedMediumLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedMediumLE();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int readUnsignedShort() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedShort();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int readUnsignedShortLE() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.readUnsignedShortLE();
    }

    public static void recordLeakNonRefCountingOperation(ResourceLeakTracker resourceLeakTracker0) {
        if(!AdvancedLeakAwareByteBuf.ACQUIRE_AND_RELEASE_ONLY) {
            resourceLeakTracker0.record();
        }
    }

    @Override  // io.netty.buffer.SimpleLeakAwareByteBuf
    public boolean release() {
        this.leak.record();
        return super.release();
    }

    @Override  // io.netty.buffer.SimpleLeakAwareByteBuf
    public boolean release(int v) {
        this.leak.record();
        return super.release(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf retain() {
        this.leak.record();
        return super.retain();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf retain(int v) {
        this.leak.record();
        return super.retain(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ReferenceCounted retain() {
        return this.retain();
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ReferenceCounted retain(int v) {
        return this.retain(v);
    }

    @Override  // io.netty.buffer.SimpleLeakAwareByteBuf
    public ByteBuf retainedDuplicate() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.retainedDuplicate();
    }

    @Override  // io.netty.buffer.SimpleLeakAwareByteBuf
    public ByteBuf retainedSlice() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.retainedSlice();
    }

    @Override  // io.netty.buffer.SimpleLeakAwareByteBuf
    public ByteBuf retainedSlice(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.retainedSlice(v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setBoolean(int v, boolean z) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBoolean(v, z);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setByte(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setByte(v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int setBytes(int v, InputStream inputStream0, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(v, inputStream0, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int setBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(v, fileChannel0, v1, v2);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int setBytes(int v, ScatteringByteChannel scatteringByteChannel0, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(v, scatteringByteChannel0, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(v, byteBuf0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(v, byteBuf0, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(v, byteBuf0, v1, v2);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(v, byteBuffer0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(v, arr_b);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setBytes(v, arr_b, v1, v2);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setChar(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setChar(v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int setCharSequence(int v, CharSequence charSequence0, Charset charset0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setCharSequence(v, charSequence0, charset0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setDouble(int v, double f) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setDouble(v, f);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setFloat(int v, float f) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setFloat(v, f);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setInt(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setInt(v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setIntLE(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setIntLE(v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setLong(int v, long v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setLong(v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setLongLE(int v, long v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setLongLE(v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setMedium(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setMedium(v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setMediumLE(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setMediumLE(v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setShort(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setShort(v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setShortLE(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setShortLE(v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf setZero(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.setZero(v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf skipBytes(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.skipBytes(v);
    }

    @Override  // io.netty.buffer.SimpleLeakAwareByteBuf
    public ByteBuf slice() {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.slice();
    }

    @Override  // io.netty.buffer.SimpleLeakAwareByteBuf
    public ByteBuf slice(int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.slice(v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public String toString(int v, int v1, Charset charset0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.toString(v, v1, charset0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public String toString(Charset charset0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.toString(charset0);
    }

    @Override  // io.netty.buffer.SimpleLeakAwareByteBuf
    public ByteBuf touch() {
        this.leak.record();
        return this;
    }

    @Override  // io.netty.buffer.SimpleLeakAwareByteBuf
    public ByteBuf touch(Object object0) {
        this.leak.record(object0);
        return this;
    }

    @Override  // io.netty.buffer.SimpleLeakAwareByteBuf
    public ReferenceCounted touch() {
        return this.touch();
    }

    @Override  // io.netty.buffer.SimpleLeakAwareByteBuf
    public ReferenceCounted touch(Object object0) {
        return this.touch(object0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeBoolean(boolean z) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBoolean(z);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeByte(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeByte(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int writeBytes(InputStream inputStream0, int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(inputStream0, v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int writeBytes(FileChannel fileChannel0, long v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(fileChannel0, v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel0, int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(scatteringByteChannel0, v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0, int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf0, v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0, int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuf0, v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(byteBuffer0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeBytes(byte[] arr_b) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(arr_b);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeBytes(byte[] arr_b, int v, int v1) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeBytes(arr_b, v, v1);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeChar(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeChar(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public int writeCharSequence(CharSequence charSequence0, Charset charset0) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeCharSequence(charSequence0, charset0);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeDouble(double f) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeDouble(f);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeFloat(float f) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeFloat(f);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeInt(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeInt(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeIntLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeIntLE(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeLong(long v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeLong(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeLongLE(long v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeLongLE(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeMedium(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeMedium(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeMediumLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeMediumLE(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeShort(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeShort(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeShortLE(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeShortLE(v);
    }

    @Override  // io.netty.buffer.WrappedByteBuf
    public ByteBuf writeZero(int v) {
        AdvancedLeakAwareByteBuf.recordLeakNonRefCountingOperation(this.leak);
        return super.writeZero(v);
    }
}

