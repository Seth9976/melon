package io.netty.buffer;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

public class UnpooledDirectByteBuf extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator alloc;
    ByteBuffer buffer;
    private int capacity;
    private boolean doNotFree;
    private ByteBuffer tmpNioBuf;

    public UnpooledDirectByteBuf(ByteBufAllocator byteBufAllocator0, int v, int v1) {
        super(v1);
        ObjectUtil.checkNotNull(byteBufAllocator0, "alloc");
        ObjectUtil.checkPositiveOrZero(v, "initialCapacity");
        ObjectUtil.checkPositiveOrZero(v1, "maxCapacity");
        if(v > v1) {
            throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", v, v1));
        }
        this.alloc = byteBufAllocator0;
        this.setByteBuffer(this.allocateDirect(v), false);
    }

    public UnpooledDirectByteBuf(ByteBufAllocator byteBufAllocator0, ByteBuffer byteBuffer0, int v) {
        this(byteBufAllocator0, byteBuffer0, v, false, true);
    }

    public UnpooledDirectByteBuf(ByteBufAllocator byteBufAllocator0, ByteBuffer byteBuffer0, int v, boolean z, boolean z1) {
        super(v);
        ObjectUtil.checkNotNull(byteBufAllocator0, "alloc");
        ObjectUtil.checkNotNull(byteBuffer0, "initialBuffer");
        if(!byteBuffer0.isDirect()) {
            throw new IllegalArgumentException("initialBuffer is not a direct buffer.");
        }
        if(byteBuffer0.isReadOnly()) {
            throw new IllegalArgumentException("initialBuffer is a read-only buffer.");
        }
        int v1 = byteBuffer0.remaining();
        if(v1 > v) {
            throw new IllegalArgumentException(String.format("initialCapacity(%d) > maxCapacity(%d)", v1, v));
        }
        this.alloc = byteBufAllocator0;
        this.doNotFree = !z;
        if(z1) {
            byteBuffer0 = byteBuffer0.slice();
        }
        this.setByteBuffer(byteBuffer0.order(ByteOrder.BIG_ENDIAN), false);
        this.writerIndex(v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int v) {
        return this.buffer.get(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getInt(int v) {
        return this.buffer.getInt(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int v) {
        return ByteBufUtil.swapInt(this.buffer.getInt(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLong(int v) {
        return this.buffer.getLong(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int v) {
        return ByteBufUtil.swapLong(this.buffer.getLong(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShort(int v) {
        return this.buffer.getShort(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int v) {
        return ByteBufUtil.swapShort(this.buffer.getShort(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int v) {
        int v1 = this.getByte(v);
        int v2 = this.getByte(v + 1);
        return this.getByte(v + 2) & 0xFF | ((v1 & 0xFF) << 16 | (v2 & 0xFF) << 8);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int v) {
        int v1 = this.getByte(v);
        int v2 = this.getByte(v + 1);
        return (this.getByte(v + 2) & 0xFF) << 16 | (v1 & 0xFF | (v2 & 0xFF) << 8);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setByte(int v, int v1) {
        this.buffer.put(v, ((byte)v1));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setInt(int v, int v1) {
        this.buffer.putInt(v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int v, int v1) {
        this.buffer.putInt(v, ByteBufUtil.swapInt(v1));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLong(int v, long v1) {
        this.buffer.putLong(v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int v, long v1) {
        this.buffer.putLong(v, ByteBufUtil.swapLong(v1));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int v, int v1) {
        this.setByte(v, ((int)(((byte)(v1 >>> 16)))));
        this.setByte(v + 1, ((int)(((byte)(v1 >>> 8)))));
        this.setByte(v + 2, ((int)(((byte)v1))));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int v, int v1) {
        this.setByte(v, ((int)(((byte)v1))));
        this.setByte(v + 1, ((int)(((byte)(v1 >>> 8)))));
        this.setByte(v + 2, ((int)(((byte)(v1 >>> 16)))));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShort(int v, int v1) {
        this.buffer.putShort(v, ((short)v1));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int v, int v1) {
        this.buffer.putShort(v, ByteBufUtil.swapShort(((short)v1)));
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    public ByteBuffer allocateDirect(int v) {
        return ByteBuffer.allocateDirect(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public byte[] array() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override  // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override  // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.capacity;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int v) {
        this.checkNewCapacity(v);
        int v1 = this.capacity;
        if(v == v1) {
            return this;
        }
        if(v <= v1) {
            this.trimIndicesToCapacity(v);
            v1 = v;
        }
        ByteBuffer byteBuffer0 = this.buffer;
        ByteBuffer byteBuffer1 = this.allocateDirect(v);
        byteBuffer0.position(0).limit(v1);
        byteBuffer1.position(0).limit(v1);
        byteBuffer1.put(byteBuffer0).clear();
        this.setByteBuffer(byteBuffer1, true);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf copy(int v, int v1) {
        this.ensureAccessible();
        try {
            ByteBuffer byteBuffer0 = (ByteBuffer)this.buffer.duplicate().clear().position(v).limit(v + v1);
            return this.alloc().directBuffer(v1, this.maxCapacity()).writeBytes(byteBuffer0);
        }
        catch(IllegalArgumentException unused_ex) {
            throw new IndexOutOfBoundsException("Too many bytes to read - Need " + (v + v1));
        }
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public void deallocate() {
        ByteBuffer byteBuffer0 = this.buffer;
        if(byteBuffer0 != null) {
            this.buffer = null;
            if(!this.doNotFree) {
                this.freeDirect(byteBuffer0);
            }
        }
    }

    public void freeDirect(ByteBuffer byteBuffer0) {
        PlatformDependent.freeDirectBuffer(byteBuffer0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte getByte(int v) {
        this.ensureAccessible();
        return this._getByte(v);
    }

    private int getBytes(int v, FileChannel fileChannel0, long v1, int v2, boolean z) {
        this.ensureAccessible();
        if(v2 == 0) {
            return 0;
        }
        ByteBuffer byteBuffer0 = z ? this.internalNioBuffer() : this.buffer.duplicate();
        byteBuffer0.clear().position(v).limit(v + v2);
        return fileChannel0.write(byteBuffer0, v1);
    }

    private int getBytes(int v, GatheringByteChannel gatheringByteChannel0, int v1, boolean z) {
        this.ensureAccessible();
        if(v1 == 0) {
            return 0;
        }
        ByteBuffer byteBuffer0 = z ? this.internalNioBuffer() : this.buffer.duplicate();
        byteBuffer0.clear().position(v).limit(v + v1);
        return gatheringByteChannel0.write(byteBuffer0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        return this.getBytes(v, fileChannel0, v1, v2, false);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, GatheringByteChannel gatheringByteChannel0, int v1) {
        return this.getBytes(v, gatheringByteChannel0, v1, false);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.checkDstIndex(v, v2, v1, byteBuf0.capacity());
        if(byteBuf0.hasArray()) {
            this.getBytes(v, byteBuf0.array(), byteBuf0.arrayOffset() + v1, v2);
            return this;
        }
        if(byteBuf0.nioBufferCount() > 0) {
            ByteBuffer[] arr_byteBuffer = byteBuf0.nioBuffers(v1, v2);
            for(int v3 = 0; v3 < arr_byteBuffer.length; ++v3) {
                ByteBuffer byteBuffer0 = arr_byteBuffer[v3];
                this.getBytes(v, byteBuffer0);
                v += byteBuffer0.remaining();
            }
            return this;
        }
        byteBuf0.setBytes(v1, this, v, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        this.getBytes(v, outputStream0, v1, false);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        this.getBytes(v, byteBuffer0, false);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        this.getBytes(v, arr_b, v1, v2, false);
        return this;
    }

    public void getBytes(int v, OutputStream outputStream0, int v1, boolean z) {
        this.ensureAccessible();
        if(v1 == 0) {
            return;
        }
        ByteBufUtil.readBytes(this.alloc(), (z ? this.internalNioBuffer() : this.buffer.duplicate()), v, v1, outputStream0);
    }

    public void getBytes(int v, ByteBuffer byteBuffer0, boolean z) {
        this.checkIndex(v, byteBuffer0.remaining());
        ByteBuffer byteBuffer1 = z ? this.internalNioBuffer() : this.buffer.duplicate();
        byteBuffer1.clear().position(v).limit(byteBuffer0.remaining() + v);
        byteBuffer0.put(byteBuffer1);
    }

    public void getBytes(int v, byte[] arr_b, int v1, int v2, boolean z) {
        this.checkDstIndex(v, v2, v1, arr_b.length);
        ByteBuffer byteBuffer0 = z ? this.internalNioBuffer() : this.buffer.duplicate();
        byteBuffer0.clear().position(v).limit(v + v2);
        byteBuffer0.get(arr_b, v1, v2);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getInt(int v) {
        this.ensureAccessible();
        return this._getInt(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long getLong(int v) {
        this.ensureAccessible();
        return this._getLong(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short getShort(int v) {
        this.ensureAccessible();
        return this._getShort(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getUnsignedMedium(int v) {
        this.ensureAccessible();
        return this._getUnsignedMedium(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return false;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return false;
    }

    private ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer0 = this.tmpNioBuf;
        if(byteBuffer0 == null) {
            byteBuffer0 = this.buffer.duplicate();
            this.tmpNioBuf = byteBuffer0;
        }
        return byteBuffer0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int v, int v1) {
        this.checkIndex(v, v1);
        return (ByteBuffer)this.internalNioBuffer().clear().position(v).limit(v + v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public final boolean isContiguous() {
        return true;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override  // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int v, int v1) {
        this.checkIndex(v, v1);
        return ((ByteBuffer)this.buffer.duplicate().position(v).limit(v + v1)).slice();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return 1;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int v, int v1) {
        return new ByteBuffer[]{this.nioBuffer(v, v1)};
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int readBytes(FileChannel fileChannel0, long v, int v1) {
        this.checkReadableBytes(v1);
        int v2 = this.getBytes(this.readerIndex, fileChannel0, v, v1, true);
        this.readerIndex += v2;
        return v2;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel0, int v) {
        this.checkReadableBytes(v);
        int v1 = this.getBytes(this.readerIndex, gatheringByteChannel0, v, true);
        this.readerIndex += v1;
        return v1;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf readBytes(OutputStream outputStream0, int v) {
        this.checkReadableBytes(v);
        this.getBytes(this.readerIndex, outputStream0, v, true);
        this.readerIndex += v;
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer0) {
        int v = byteBuffer0.remaining();
        this.checkReadableBytes(v);
        this.getBytes(this.readerIndex, byteBuffer0, true);
        this.readerIndex += v;
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf readBytes(byte[] arr_b, int v, int v1) {
        this.checkReadableBytes(v1);
        this.getBytes(this.readerIndex, arr_b, v, v1, true);
        this.readerIndex += v1;
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setByte(int v, int v1) {
        this.ensureAccessible();
        this._setByte(v, v1);
        return this;
    }

    public void setByteBuffer(ByteBuffer byteBuffer0, boolean z) {
        if(z) {
            ByteBuffer byteBuffer1 = this.buffer;
            if(byteBuffer1 != null) {
                if(this.doNotFree) {
                    this.doNotFree = false;
                }
                else {
                    this.freeDirect(byteBuffer1);
                }
            }
        }
        this.buffer = byteBuffer0;
        this.tmpNioBuf = null;
        this.capacity = byteBuffer0.remaining();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, InputStream inputStream0, int v1) {
        this.ensureAccessible();
        if(this.buffer.hasArray()) {
            return inputStream0.read(this.buffer.array(), this.buffer.arrayOffset() + v, v1);
        }
        byte[] arr_b = ByteBufUtil.threadLocalTempArray(v1);
        int v2 = inputStream0.read(arr_b, 0, v1);
        if(v2 <= 0) {
            return v2;
        }
        ByteBuffer byteBuffer0 = this.internalNioBuffer();
        byteBuffer0.clear().position(v);
        byteBuffer0.put(arr_b, 0, v2);
        return v2;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        this.ensureAccessible();
        ByteBuffer byteBuffer0 = this.internalNioBuffer();
        byteBuffer0.clear().position(v).limit(v + v2);
        try {
            return fileChannel0.read(byteBuffer0, v1);
        }
        catch(ClosedChannelException unused_ex) {
            return -1;
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, ScatteringByteChannel scatteringByteChannel0, int v1) {
        this.ensureAccessible();
        ByteBuffer byteBuffer0 = this.internalNioBuffer();
        byteBuffer0.clear().position(v).limit(v + v1);
        try {
            return scatteringByteChannel0.read(byteBuffer0);
        }
        catch(ClosedChannelException unused_ex) {
            return -1;
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.checkSrcIndex(v, v2, v1, byteBuf0.capacity());
        if(byteBuf0.nioBufferCount() > 0) {
            ByteBuffer[] arr_byteBuffer = byteBuf0.nioBuffers(v1, v2);
            for(int v3 = 0; v3 < arr_byteBuffer.length; ++v3) {
                ByteBuffer byteBuffer0 = arr_byteBuffer[v3];
                this.setBytes(v, byteBuffer0);
                v += byteBuffer0.remaining();
            }
            return this;
        }
        byteBuf0.getBytes(v1, this, v, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        this.ensureAccessible();
        ByteBuffer byteBuffer1 = this.internalNioBuffer();
        if(byteBuffer0 == byteBuffer1) {
            byteBuffer0 = byteBuffer0.duplicate();
        }
        byteBuffer1.clear().position(v).limit(byteBuffer0.remaining() + v);
        byteBuffer1.put(byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        this.checkSrcIndex(v, v2, v1, arr_b.length);
        ByteBuffer byteBuffer0 = this.internalNioBuffer();
        byteBuffer0.clear().position(v).limit(v + v2);
        byteBuffer0.put(arr_b, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setInt(int v, int v1) {
        this.ensureAccessible();
        this._setInt(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setLong(int v, long v1) {
        this.ensureAccessible();
        this._setLong(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setMedium(int v, int v1) {
        this.ensureAccessible();
        this._setMedium(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setShort(int v, int v1) {
        this.ensureAccessible();
        this._setShort(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }
}

