package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

public final class EmptyByteBuf extends ByteBuf {
    private static final ByteBuffer EMPTY_BYTE_BUFFER = null;
    private static final long EMPTY_BYTE_BUFFER_ADDRESS = 0L;
    static final int EMPTY_BYTE_BUF_HASH_CODE = 1;
    private final ByteBufAllocator alloc;
    private final ByteOrder order;
    private final String str;
    private EmptyByteBuf swapped;

    static {
        ByteBuffer byteBuffer0 = ByteBuffer.allocateDirect(0);
        EmptyByteBuf.EMPTY_BYTE_BUFFER = byteBuffer0;
        long v = 0L;
        try {
            if(PlatformDependent.hasUnsafe()) {
                v = PlatformDependent.directBufferAddress(byteBuffer0);
            }
        }
        catch(Throwable unused_ex) {
        }
        EmptyByteBuf.EMPTY_BYTE_BUFFER_ADDRESS = v;
    }

    public EmptyByteBuf(ByteBufAllocator byteBufAllocator0) {
        this(byteBufAllocator0, ByteOrder.BIG_ENDIAN);
    }

    private EmptyByteBuf(ByteBufAllocator byteBufAllocator0, ByteOrder byteOrder0) {
        this.alloc = (ByteBufAllocator)ObjectUtil.checkNotNull(byteBufAllocator0, "alloc");
        this.order = byteOrder0;
        this.str = StringUtil.simpleClassName(this) + (byteOrder0 == ByteOrder.BIG_ENDIAN ? "BE" : "LE");
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    @Override  // io.netty.buffer.ByteBuf
    public byte[] array() {
        return EmptyArrays.EMPTY_BYTES;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return Unpooled.unmodifiableBuffer(this);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int bytesBefore(byte b) {
        return -1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int bytesBefore(int v, byte b) {
        this.checkLength(v);
        return -1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int bytesBefore(int v, int v1, byte b) {
        this.checkIndex(v, v1);
        return -1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int capacity() {
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int v) {
        throw new ReadOnlyBufferException();
    }

    private ByteBuf checkIndex(int v) {
        if(v != 0) {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    private ByteBuf checkIndex(int v, int v1) {
        ObjectUtil.checkPositiveOrZero(v1, "length");
        if(v != 0 || v1 != 0) {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    private ByteBuf checkLength(int v) {
        ObjectUtil.checkPositiveOrZero(v, "length");
        if(v != 0) {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf clear() {
        return this;
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.buffer.ByteBuf
    public int compareTo(ByteBuf byteBuf0) {
        return byteBuf0.isReadable() ? -1 : 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int compareTo(Object object0) {
        return this.compareTo(((ByteBuf)object0));
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf copy(int v, int v1) {
        return this.checkIndex(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf discardReadBytes() {
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int ensureWritable(int v, boolean z) {
        ObjectUtil.checkPositiveOrZero(v, "minWritableBytes");
        return v == 0 ? 0 : 1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int v) {
        ObjectUtil.checkPositiveOrZero(v, "minWritableBytes");
        if(v != 0) {
            throw new IndexOutOfBoundsException();
        }
        return this;
    }

    // 去混淆评级： 低(20)
    @Override  // io.netty.buffer.ByteBuf
    public boolean equals(Object object0) {
        return object0 instanceof ByteBuf && !((ByteBuf)object0).isReadable();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int forEachByte(int v, int v1, ByteProcessor byteProcessor0) {
        this.checkIndex(v, v1);
        return -1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor0) {
        return -1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int forEachByteDesc(int v, int v1, ByteProcessor byteProcessor0) {
        this.checkIndex(v, v1);
        return -1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor byteProcessor0) {
        return -1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean getBoolean(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public byte getByte(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        this.checkIndex(v, v2);
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, GatheringByteChannel gatheringByteChannel0, int v1) {
        this.checkIndex(v, v1);
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0) {
        return this.checkIndex(v, byteBuf0.writableBytes());
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1) {
        return this.checkIndex(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        return this.checkIndex(v, v2);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        return this.checkIndex(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        return this.checkIndex(v, byteBuffer0.remaining());
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b) {
        return this.checkIndex(v, arr_b.length);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        return this.checkIndex(v, v2);
    }

    @Override  // io.netty.buffer.ByteBuf
    public char getChar(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int v, int v1, Charset charset0) {
        this.checkIndex(v, v1);
        return null;
    }

    @Override  // io.netty.buffer.ByteBuf
    public double getDouble(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public float getFloat(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getInt(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getIntLE(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public long getLong(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public long getLongLE(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getMedium(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getMediumLE(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public short getShort(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public short getShortLE(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public short getUnsignedByte(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public long getUnsignedInt(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getUnsignedShort(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return true;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() [...] // 潜在的解密器

    @Override  // io.netty.buffer.ByteBuf
    public int hashCode() {
        return 1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int indexOf(int v, int v1, byte b) {
        this.checkIndex(v);
        this.checkIndex(v1);
        return -1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int v, int v1) {
        return EmptyByteBuf.EMPTY_BYTE_BUFFER;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isContiguous() {
        return true;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return false;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isReadable() {
        return false;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isReadable(int v) {
        return false;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isWritable() {
        return false;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isWritable(int v) {
        return false;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf markReaderIndex() {
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf markWriterIndex() {
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int maxWritableBytes() {
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        if(!this.hasMemoryAddress()) {
            throw new UnsupportedOperationException();
        }
        return EmptyByteBuf.EMPTY_BYTE_BUFFER_ADDRESS;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        return EmptyByteBuf.EMPTY_BYTE_BUFFER;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int v, int v1) {
        this.checkIndex(v, v1);
        return this.nioBuffer();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return 1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return new ByteBuffer[]{EmptyByteBuf.EMPTY_BYTE_BUFFER};
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int v, int v1) {
        this.checkIndex(v, v1);
        return this.nioBuffers();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder0) {
        if(ObjectUtil.checkNotNull(byteOrder0, "endianness") == this.order()) {
            return this;
        }
        ByteBuf byteBuf0 = this.swapped;
        if(byteBuf0 != null) {
            return byteBuf0;
        }
        EmptyByteBuf emptyByteBuf0 = new EmptyByteBuf(this.alloc(), byteOrder0);
        this.swapped = emptyByteBuf0;
        return emptyByteBuf0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return this.order;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public byte readByte() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel0, long v, int v1) {
        this.checkLength(v1);
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel0, int v) {
        this.checkLength(v);
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int v) {
        return this.checkLength(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0) {
        return this.checkLength(byteBuf0.writableBytes());
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0, int v) {
        return this.checkLength(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0, int v, int v1) {
        return this.checkLength(v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream outputStream0, int v) {
        return this.checkLength(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer0) {
        return this.checkLength(byteBuffer0.remaining());
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] arr_b) {
        return this.checkLength(arr_b.length);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] arr_b, int v, int v1) {
        return this.checkLength(v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public char readChar() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int v, Charset charset0) {
        this.checkLength(v);
        return "";
    }

    @Override  // io.netty.buffer.ByteBuf
    public double readDouble() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public float readFloat() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readInt() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readIntLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public long readLong() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public long readLongLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readMedium() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readMediumLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int v) {
        return this.checkLength(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public short readShort() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public short readShortLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int v) {
        return this.checkLength(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public long readUnsignedIntLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readUnsignedMedium() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readableBytes() {
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int readerIndex() {
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf readerIndex(int v) {
        return this.checkIndex(v);
    }

    @Override  // io.netty.util.ReferenceCounted
    public int refCnt() {
        return 1;
    }

    @Override  // io.netty.util.ReferenceCounted
    public boolean release() {
        return false;
    }

    @Override  // io.netty.util.ReferenceCounted
    public boolean release(int v) {
        return false;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf resetReaderIndex() {
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf resetWriterIndex() {
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf retain() [...] // Inlined contents

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf retain(int v) [...] // Inlined contents

    @Override  // io.netty.buffer.ByteBuf
    public ReferenceCounted retain() {
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ReferenceCounted retain(int v) {
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int v, int v1) {
        return this.checkIndex(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBoolean(int v, boolean z) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setByte(int v, int v1) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, InputStream inputStream0, int v1) {
        this.checkIndex(v, v1);
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        this.checkIndex(v, v2);
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, ScatteringByteChannel scatteringByteChannel0, int v1) {
        this.checkIndex(v, v1);
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1) {
        return this.checkIndex(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        return this.checkIndex(v, v2);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        return this.checkIndex(v, byteBuffer0.remaining());
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b) {
        return this.checkIndex(v, arr_b.length);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        return this.checkIndex(v, v2);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setChar(int v, int v1) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setCharSequence(int v, CharSequence charSequence0, Charset charset0) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setDouble(int v, double f) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setFloat(int v, float f) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int v, int v1) {
        this.checkIndex(v);
        this.checkIndex(v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setInt(int v, int v1) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int v, int v1) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setLong(int v, long v1) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int v, long v1) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int v, int v1) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int v, int v1) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setShort(int v, int v1) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int v, int v1) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setZero(int v, int v1) {
        return this.checkIndex(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int v) {
        return this.checkLength(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf slice(int v, int v1) {
        return this.checkIndex(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public String toString() {
        return this.str;
    }

    @Override  // io.netty.buffer.ByteBuf
    public String toString(int v, int v1, Charset charset0) {
        this.checkIndex(v, v1);
        return "";
    }

    @Override  // io.netty.buffer.ByteBuf
    public String toString(Charset charset0) [...] // Inlined contents

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf touch() [...] // Inlined contents

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf touch(Object object0) [...] // Inlined contents

    @Override  // io.netty.buffer.ByteBuf
    public ReferenceCounted touch() {
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ReferenceCounted touch(Object object0) {
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int writableBytes() {
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBoolean(boolean z) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int writeBytes(InputStream inputStream0, int v) {
        this.checkLength(v);
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel fileChannel0, long v, int v1) {
        this.checkLength(v1);
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel0, int v) {
        this.checkLength(v);
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0) {
        return this.checkLength(byteBuf0.readableBytes());
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0, int v) {
        return this.checkLength(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0, int v, int v1) {
        return this.checkLength(v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer0) {
        return this.checkLength(byteBuffer0.remaining());
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] arr_b) {
        return this.checkLength(arr_b.length);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] arr_b, int v, int v1) {
        return this.checkLength(v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeChar(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence0, Charset charset0) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeDouble(double f) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeFloat(float f) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int v) {
        throw new IndexOutOfBoundsException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int v) {
        return this.checkLength(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int writerIndex() {
        return 0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf writerIndex(int v) {
        return this.checkIndex(v);
    }
}

