package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.internal.MathUtil;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

abstract class AbstractUnpooledSlicedByteBuf extends AbstractDerivedByteBuf {
    private final int adjustment;
    private final ByteBuf buffer;

    public AbstractUnpooledSlicedByteBuf(ByteBuf byteBuf0, int v, int v1) {
        super(v1);
        AbstractUnpooledSlicedByteBuf.checkSliceOutOfBounds(v, v1, byteBuf0);
        if(byteBuf0 instanceof AbstractUnpooledSlicedByteBuf) {
            this.buffer = ((AbstractUnpooledSlicedByteBuf)byteBuf0).buffer;
            this.adjustment = ((AbstractUnpooledSlicedByteBuf)byteBuf0).adjustment + v;
        }
        else {
            this.buffer = byteBuf0 instanceof DuplicatedByteBuf ? byteBuf0.unwrap() : byteBuf0;
            this.adjustment = v;
        }
        this.initLength(v1);
        this.writerIndex(v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int v) {
        return this.unwrap().getByte(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getInt(int v) {
        return this.unwrap().getInt(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int v) {
        return this.unwrap().getIntLE(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLong(int v) {
        return this.unwrap().getLong(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int v) {
        return this.unwrap().getLongLE(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShort(int v) {
        return this.unwrap().getShort(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int v) {
        return this.unwrap().getShortLE(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int v) {
        return this.unwrap().getUnsignedMedium(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int v) {
        return this.unwrap().getUnsignedMediumLE(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setByte(int v, int v1) {
        this.unwrap().setByte(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setInt(int v, int v1) {
        this.unwrap().setInt(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int v, int v1) {
        this.unwrap().setIntLE(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLong(int v, long v1) {
        this.unwrap().setLong(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int v, long v1) {
        this.unwrap().setLongLE(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int v, int v1) {
        this.unwrap().setMedium(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int v, int v1) {
        this.unwrap().setMediumLE(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShort(int v, int v1) {
        this.unwrap().setShort(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int v, int v1) {
        this.unwrap().setShortLE(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.unwrap().alloc();
    }

    @Override  // io.netty.buffer.ByteBuf
    public byte[] array() {
        return this.unwrap().array();
    }

    @Override  // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return this.idx(this.unwrap().arrayOffset());
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int v) {
        throw new UnsupportedOperationException("sliced buffer");
    }

    public static void checkSliceOutOfBounds(int v, int v1, ByteBuf byteBuf0) {
        if(MathUtil.isOutOfBounds(v, v1, byteBuf0.capacity())) {
            throw new IndexOutOfBoundsException(byteBuf0 + ".slice(" + v + ", " + v1 + ')');
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf copy(int v, int v1) {
        this.checkIndex0(v, v1);
        return this.unwrap().copy(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf duplicate() {
        return this.unwrap().duplicate().setIndex(this.idx(this.readerIndex()), this.idx(this.writerIndex()));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int forEachByte(int v, int v1, ByteProcessor byteProcessor0) {
        this.checkIndex0(v, v1);
        int v2 = this.unwrap().forEachByte(this.idx(v), v1, byteProcessor0);
        return v2 < this.adjustment ? -1 : v2 - this.adjustment;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int forEachByteDesc(int v, int v1, ByteProcessor byteProcessor0) {
        this.checkIndex0(v, v1);
        int v2 = this.unwrap().forEachByteDesc(this.idx(v), v1, byteProcessor0);
        return v2 < this.adjustment ? -1 : v2 - this.adjustment;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte getByte(int v) {
        this.checkIndex0(v, 1);
        return this.unwrap().getByte(this.idx(v));
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        this.checkIndex0(v, v2);
        return this.unwrap().getBytes(this.idx(v), fileChannel0, v1, v2);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, GatheringByteChannel gatheringByteChannel0, int v1) {
        this.checkIndex0(v, v1);
        return this.unwrap().getBytes(this.idx(v), gatheringByteChannel0, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.checkIndex0(v, v2);
        this.unwrap().getBytes(this.idx(v), byteBuf0, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        this.checkIndex0(v, v1);
        this.unwrap().getBytes(this.idx(v), outputStream0, v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        this.checkIndex0(v, byteBuffer0.remaining());
        this.unwrap().getBytes(this.idx(v), byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        this.checkIndex0(v, v2);
        this.unwrap().getBytes(this.idx(v), arr_b, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public CharSequence getCharSequence(int v, int v1, Charset charset0) {
        this.checkIndex0(v, v1);
        return this.unwrap().getCharSequence(this.idx(v), v1, charset0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getInt(int v) {
        this.checkIndex0(v, 4);
        return this.unwrap().getInt(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getIntLE(int v) {
        this.checkIndex0(v, 4);
        return this.unwrap().getIntLE(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long getLong(int v) {
        this.checkIndex0(v, 8);
        return this.unwrap().getLong(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long getLongLE(int v) {
        this.checkIndex0(v, 8);
        return this.unwrap().getLongLE(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short getShort(int v) {
        this.checkIndex0(v, 2);
        return this.unwrap().getShort(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short getShortLE(int v) {
        this.checkIndex0(v, 2);
        return this.unwrap().getShortLE(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getUnsignedMedium(int v) {
        this.checkIndex0(v, 3);
        return this.unwrap().getUnsignedMedium(this.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int getUnsignedMediumLE(int v) {
        this.checkIndex0(v, 3);
        return this.unwrap().getUnsignedMediumLE(this.idx(v));
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return this.unwrap().hasArray();
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return this.unwrap().hasMemoryAddress();
    }

    public final int idx(int v) {
        return v + this.adjustment;
    }

    public void initLength(int v) {
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return this.unwrap().isDirect();
    }

    public int length() {
        return this.capacity();
    }

    @Override  // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return this.unwrap().memoryAddress() + ((long)this.adjustment);
    }

    @Override  // io.netty.buffer.AbstractDerivedByteBuf
    public ByteBuffer nioBuffer(int v, int v1) {
        this.checkIndex0(v, v1);
        return this.unwrap().nioBuffer(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.unwrap().nioBufferCount();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int v, int v1) {
        this.checkIndex0(v, v1);
        return this.unwrap().nioBuffers(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    @Deprecated
    public ByteOrder order() {
        return this.unwrap().order();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setByte(int v, int v1) {
        this.checkIndex0(v, 1);
        this.unwrap().setByte(this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, InputStream inputStream0, int v1) {
        this.checkIndex0(v, v1);
        return this.unwrap().setBytes(this.idx(v), inputStream0, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        this.checkIndex0(v, v2);
        return this.unwrap().setBytes(this.idx(v), fileChannel0, v1, v2);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, ScatteringByteChannel scatteringByteChannel0, int v1) {
        this.checkIndex0(v, v1);
        return this.unwrap().setBytes(this.idx(v), scatteringByteChannel0, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.checkIndex0(v, v2);
        this.unwrap().setBytes(this.idx(v), byteBuf0, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        this.checkIndex0(v, byteBuffer0.remaining());
        this.unwrap().setBytes(this.idx(v), byteBuffer0);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        this.checkIndex0(v, v2);
        this.unwrap().setBytes(this.idx(v), arr_b, v1, v2);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setInt(int v, int v1) {
        this.checkIndex0(v, 4);
        this.unwrap().setInt(this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setIntLE(int v, int v1) {
        this.checkIndex0(v, 4);
        this.unwrap().setIntLE(this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setLong(int v, long v1) {
        this.checkIndex0(v, 8);
        this.unwrap().setLong(this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setLongLE(int v, long v1) {
        this.checkIndex0(v, 8);
        this.unwrap().setLongLE(this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setMedium(int v, int v1) {
        this.checkIndex0(v, 3);
        this.unwrap().setMedium(this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setMediumLE(int v, int v1) {
        this.checkIndex0(v, 3);
        this.unwrap().setMediumLE(this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setShort(int v, int v1) {
        this.checkIndex0(v, 2);
        this.unwrap().setShort(this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setShortLE(int v, int v1) {
        this.checkIndex0(v, 2);
        this.unwrap().setShortLE(this.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf slice(int v, int v1) {
        this.checkIndex0(v, v1);
        return this.unwrap().slice(this.idx(v), v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return this.buffer;
    }
}

