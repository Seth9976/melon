package io.netty.buffer;

import H0.b;
import U4.x;
import androidx.appcompat.app.o;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.RecyclableArrayList;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.Collections;
import jeb.synthetic.FIN;

final class FixedCompositeByteBuf extends AbstractReferenceCountedByteBuf {
    static final class Component extends WrappedByteBuf {
        private final int endOffset;
        private final int index;
        private final int offset;

        public Component(int v, int v1, ByteBuf byteBuf0) {
            super(byteBuf0);
            this.index = v;
            this.offset = v1;
            this.endOffset = byteBuf0.readableBytes() + v1;
        }

        public static int access$000(Component fixedCompositeByteBuf$Component0) {
            return fixedCompositeByteBuf$Component0.offset;
        }

        public static int access$100(Component fixedCompositeByteBuf$Component0) {
            return fixedCompositeByteBuf$Component0.endOffset;
        }

        public static int access$200(Component fixedCompositeByteBuf$Component0) {
            return fixedCompositeByteBuf$Component0.index;
        }
    }

    private static final ByteBuf[] EMPTY;
    private final ByteBufAllocator allocator;
    private final ByteBuf[] buffers;
    private final int capacity;
    private final boolean direct;
    private final int nioBufferCount;
    private final ByteOrder order;

    static {
        FixedCompositeByteBuf.EMPTY = new ByteBuf[]{Unpooled.EMPTY_BUFFER};
    }

    public FixedCompositeByteBuf(ByteBufAllocator byteBufAllocator0, ByteBuf[] arr_byteBuf) {
        super(0x7FFFFFFF);
        if(arr_byteBuf.length == 0) {
            this.buffers = FixedCompositeByteBuf.EMPTY;
            this.order = ByteOrder.BIG_ENDIAN;
            this.nioBufferCount = 1;
            this.capacity = 0;
            this.direct = Unpooled.EMPTY_BUFFER.isDirect();
        }
        else {
            ByteBuf byteBuf0 = arr_byteBuf[0];
            this.buffers = arr_byteBuf;
            int v1 = byteBuf0.nioBufferCount();
            int v2 = byteBuf0.readableBytes();
            this.order = byteBuf0.order();
            boolean z = true;
            for(int v = 1; v < arr_byteBuf.length; ++v) {
                ByteBuf byteBuf1 = arr_byteBuf[v];
                if(byteBuf1.order() != this.order) {
                    throw new IllegalArgumentException("All ByteBufs need to have same ByteOrder");
                }
                v1 += byteBuf1.nioBufferCount();
                v2 += byteBuf1.readableBytes();
                if(!byteBuf1.isDirect()) {
                    z = false;
                }
            }
            this.nioBufferCount = v1;
            this.capacity = v2;
            this.direct = z;
        }
        this.setIndex(0, this.capacity());
        this.allocator = byteBufAllocator0;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int v) {
        Component fixedCompositeByteBuf$Component0 = this.findComponent(v);
        return fixedCompositeByteBuf$Component0.buf.getByte(v - Component.access$000(fixedCompositeByteBuf$Component0));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getInt(int v) {
        Component fixedCompositeByteBuf$Component0 = this.findComponent(v);
        if(v + 4 <= Component.access$100(fixedCompositeByteBuf$Component0)) {
            return fixedCompositeByteBuf$Component0.buf.getInt(v - Component.access$000(fixedCompositeByteBuf$Component0));
        }
        if(this.order() == ByteOrder.BIG_ENDIAN) {
            int v1 = this._getShort(v);
            return this._getShort(v + 2) & 0xFFFF | (v1 & 0xFFFF) << 16;
        }
        int v2 = this._getShort(v);
        return (this._getShort(v + 2) & 0xFFFF) << 16 | v2 & 0xFFFF;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int v) {
        Component fixedCompositeByteBuf$Component0 = this.findComponent(v);
        if(v + 4 <= Component.access$100(fixedCompositeByteBuf$Component0)) {
            return fixedCompositeByteBuf$Component0.buf.getIntLE(v - Component.access$000(fixedCompositeByteBuf$Component0));
        }
        if(this.order() == ByteOrder.BIG_ENDIAN) {
            int v1 = this._getShortLE(v);
            return (this._getShortLE(v + 2) & 0xFFFF) << 16 | v1 & 0xFFFF;
        }
        int v2 = this._getShortLE(v);
        return this._getShortLE(v + 2) & 0xFFFF | (v2 & 0xFFFF) << 16;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLong(int v) {
        Component fixedCompositeByteBuf$Component0 = this.findComponent(v);
        if(v + 8 <= Component.access$100(fixedCompositeByteBuf$Component0)) {
            return fixedCompositeByteBuf$Component0.buf.getLong(v - Component.access$000(fixedCompositeByteBuf$Component0));
        }
        return this.order() == ByteOrder.BIG_ENDIAN ? (((long)this._getInt(v)) & 0xFFFFFFFFL) << 0x20 | ((long)this._getInt(v + 4)) & 0xFFFFFFFFL : ((long)this._getInt(v)) & 0xFFFFFFFFL | (0xFFFFFFFFL & ((long)this._getInt(v + 4))) << 0x20;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int v) {
        Component fixedCompositeByteBuf$Component0 = this.findComponent(v);
        if(v + 8 <= Component.access$100(fixedCompositeByteBuf$Component0)) {
            return fixedCompositeByteBuf$Component0.buf.getLongLE(v - Component.access$000(fixedCompositeByteBuf$Component0));
        }
        return this.order() == ByteOrder.BIG_ENDIAN ? ((long)this._getIntLE(v)) & 0xFFFFFFFFL | (0xFFFFFFFFL & ((long)this._getIntLE(v + 4))) << 0x20 : (((long)this._getIntLE(v)) & 0xFFFFFFFFL) << 0x20 | ((long)this._getIntLE(v + 4)) & 0xFFFFFFFFL;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShort(int v) {
        Component fixedCompositeByteBuf$Component0 = this.findComponent(v);
        if(v + 2 <= Component.access$100(fixedCompositeByteBuf$Component0)) {
            return fixedCompositeByteBuf$Component0.buf.getShort(v - Component.access$000(fixedCompositeByteBuf$Component0));
        }
        if(this.order() == ByteOrder.BIG_ENDIAN) {
            int v1 = this._getByte(v);
            return (short)(this._getByte(v + 1) & 0xFF | (v1 & 0xFF) << 8);
        }
        int v2 = this._getByte(v);
        return (short)((this._getByte(v + 1) & 0xFF) << 8 | v2 & 0xFF);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int v) {
        Component fixedCompositeByteBuf$Component0 = this.findComponent(v);
        if(v + 2 <= Component.access$100(fixedCompositeByteBuf$Component0)) {
            return fixedCompositeByteBuf$Component0.buf.getShortLE(v - Component.access$000(fixedCompositeByteBuf$Component0));
        }
        if(this.order() == ByteOrder.BIG_ENDIAN) {
            int v1 = this._getByte(v);
            return (short)((this._getByte(v + 1) & 0xFF) << 8 | v1 & 0xFF);
        }
        int v2 = this._getByte(v);
        return (short)(this._getByte(v + 1) & 0xFF | (v2 & 0xFF) << 8);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int v) {
        Component fixedCompositeByteBuf$Component0 = this.findComponent(v);
        if(v + 3 <= Component.access$100(fixedCompositeByteBuf$Component0)) {
            return fixedCompositeByteBuf$Component0.buf.getUnsignedMedium(v - Component.access$000(fixedCompositeByteBuf$Component0));
        }
        if(this.order() == ByteOrder.BIG_ENDIAN) {
            int v1 = this._getShort(v);
            return this._getByte(v + 2) & 0xFF | (v1 & 0xFFFF) << 8;
        }
        int v2 = this._getShort(v);
        return (this._getByte(v + 2) & 0xFF) << 16 | v2 & 0xFFFF;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int v) {
        Component fixedCompositeByteBuf$Component0 = this.findComponent(v);
        if(v + 3 <= Component.access$100(fixedCompositeByteBuf$Component0)) {
            return fixedCompositeByteBuf$Component0.buf.getUnsignedMediumLE(v - Component.access$000(fixedCompositeByteBuf$Component0));
        }
        if(this.order() == ByteOrder.BIG_ENDIAN) {
            int v1 = this._getShortLE(v);
            return (this._getByte(v + 2) & 0xFF) << 16 | v1 & 0xFFFF;
        }
        int v2 = this._getShortLE(v);
        return this._getByte(v + 2) & 0xFF | (v2 & 0xFFFF) << 8;
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
        return this.allocator;
    }

    @Override  // io.netty.buffer.ByteBuf
    public byte[] array() {
        switch(this.buffers.length) {
            case 0: {
                return EmptyArrays.EMPTY_BYTES;
            }
            case 1: {
                return this.buffer(0).array();
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        switch(this.buffers.length) {
            case 0: {
                return 0;
            }
            case 1: {
                return this.buffer(0).arrayOffset();
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
    }

    private ByteBuf buffer(int v) {
        ByteBuf byteBuf0 = this.buffers[v];
        return byteBuf0 instanceof Component ? ((Component)byteBuf0).buf : byteBuf0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.capacity;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int v) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf copy(int v, int v1) {
        this.checkIndex(v, v1);
        ByteBuf byteBuf0 = this.alloc().buffer(v1);
        try {
            byteBuf0.writeBytes(this, v, v1);
            return byteBuf0;
        }
        catch(Throwable throwable0) {
            byteBuf0.release();
            throw throwable0;
        }
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public void deallocate() {
        for(int v = 0; v < this.buffers.length; ++v) {
            this.buffer(v).release();
        }
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf discardReadBytes() {
        throw new ReadOnlyBufferException();
    }

    private Component findComponent(int v) {
        Component fixedCompositeByteBuf$Component0;
        int v2 = 0;
        for(int v1 = 0; true; ++v1) {
            ByteBuf[] arr_byteBuf = this.buffers;
            if(v1 >= arr_byteBuf.length) {
                break;
            }
            ByteBuf byteBuf0 = arr_byteBuf[v1];
            if(byteBuf0 instanceof Component) {
                fixedCompositeByteBuf$Component0 = (Component)byteBuf0;
                byteBuf0 = ((Component)byteBuf0).buf;
            }
            else {
                fixedCompositeByteBuf$Component0 = null;
            }
            v2 += byteBuf0.readableBytes();
            if(v < v2) {
                if(fixedCompositeByteBuf$Component0 == null) {
                    Component fixedCompositeByteBuf$Component1 = new Component(v1, v2 - byteBuf0.readableBytes(), byteBuf0);
                    this.buffers[v1] = fixedCompositeByteBuf$Component1;
                    return fixedCompositeByteBuf$Component1;
                }
                return fixedCompositeByteBuf$Component0;
            }
        }
        throw new IllegalStateException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte getByte(int v) {
        return this._getByte(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        if(this.nioBufferCount() == 1) {
            return fileChannel0.write(this.internalNioBuffer(v, v2), v1);
        }
        ByteBuffer[] arr_byteBuffer = this.nioBuffers(v, v2);
        long v3 = 0L;
        for(int v4 = 0; v4 < arr_byteBuffer.length; ++v4) {
            v3 += (long)fileChannel0.write(arr_byteBuffer[v4], v1 + v3);
        }
        return v3 <= 0x7FFFFFFFL ? ((int)v3) : 0x7FFFFFFF;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int getBytes(int v, GatheringByteChannel gatheringByteChannel0, int v1) {
        if(this.nioBufferCount() == 1) {
            return gatheringByteChannel0.write(this.internalNioBuffer(v, v1));
        }
        long v2 = gatheringByteChannel0.write(this.nioBuffers(v, v1));
        return v2 <= 0x7FFFFFFFL ? ((int)v2) : 0x7FFFFFFF;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.checkDstIndex(v, v2, v1, byteBuf0.capacity());
        if(v2 != 0) {
            Component fixedCompositeByteBuf$Component0 = this.findComponent(v);
            int v3 = Component.access$200(fixedCompositeByteBuf$Component0);
            int v4 = Component.access$000(fixedCompositeByteBuf$Component0);
            for(ByteBuf byteBuf1 = fixedCompositeByteBuf$Component0.buf; true; byteBuf1 = this.buffer(v3)) {
                int v5 = v - v4;
                int v6 = Math.min(v2, byteBuf1.readableBytes() - v5);
                byteBuf1.getBytes(v5, byteBuf0, v1, v6);
                v += v6;
                v1 += v6;
                v2 -= v6;
                v4 += byteBuf1.readableBytes();
                if(v2 <= 0) {
                    break;
                }
                ++v3;
            }
        }
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        this.checkIndex(v, v1);
        if(v1 != 0) {
            Component fixedCompositeByteBuf$Component0 = this.findComponent(v);
            int v2 = Component.access$200(fixedCompositeByteBuf$Component0);
            int v3 = Component.access$000(fixedCompositeByteBuf$Component0);
            for(ByteBuf byteBuf0 = fixedCompositeByteBuf$Component0.buf; true; byteBuf0 = this.buffer(v2)) {
                int v4 = v - v3;
                int v5 = Math.min(v1, byteBuf0.readableBytes() - v4);
                byteBuf0.getBytes(v4, outputStream0, v5);
                v += v5;
                v1 -= v5;
                v3 += byteBuf0.readableBytes();
                if(v1 <= 0) {
                    break;
                }
                ++v2;
            }
        }
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        int v1 = byteBuffer0.limit();
        int v2 = byteBuffer0.remaining();
        this.checkIndex(v, v2);
        if(v2 == 0) {
            return this;
        }
        try {
            Component fixedCompositeByteBuf$Component0 = this.findComponent(v);
            int v4 = Component.access$200(fixedCompositeByteBuf$Component0);
            int v5 = Component.access$000(fixedCompositeByteBuf$Component0);
            for(ByteBuf byteBuf0 = fixedCompositeByteBuf$Component0.buf; true; byteBuf0 = this.buffer(v4)) {
                int v6 = v - v5;
                int v7 = Math.min(v2, byteBuf0.readableBytes() - v6);
                byteBuffer0.limit(byteBuffer0.position() + v7);
                byteBuf0.getBytes(v6, byteBuffer0);
                v += v7;
                v2 -= v7;
                v5 += byteBuf0.readableBytes();
                if(v2 <= 0) {
                    break;
                }
                ++v4;
            }
            return this;
        }
        finally {
            byteBuffer0.limit(v1);
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        this.checkDstIndex(v, v2, v1, arr_b.length);
        if(v2 != 0) {
            Component fixedCompositeByteBuf$Component0 = this.findComponent(v);
            int v3 = Component.access$200(fixedCompositeByteBuf$Component0);
            int v4 = Component.access$000(fixedCompositeByteBuf$Component0);
            for(ByteBuf byteBuf0 = fixedCompositeByteBuf$Component0.buf; true; byteBuf0 = this.buffer(v3)) {
                int v5 = v - v4;
                int v6 = Math.min(v2, byteBuf0.readableBytes() - v5);
                byteBuf0.getBytes(v5, arr_b, v1, v6);
                v += v6;
                v1 += v6;
                v2 -= v6;
                v4 += byteBuf0.readableBytes();
                if(v2 <= 0) {
                    break;
                }
                ++v3;
            }
        }
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        switch(this.buffers.length) {
            case 0: {
                return true;
            }
            case 1: {
                return this.buffer(0).hasArray();
            }
            default: {
                return false;
            }
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        switch(this.buffers.length) {
            case 0: {
                return Unpooled.EMPTY_BUFFER.hasMemoryAddress();
            }
            case 1: {
                return this.buffer(0).hasMemoryAddress();
            }
            default: {
                return false;
            }
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int v, int v1) {
        if(this.buffers.length != 1) {
            throw new UnsupportedOperationException();
        }
        return this.buffer(0).internalNioBuffer(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return this.direct;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public boolean isWritable() {
        return false;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public boolean isWritable(int v) {
        return false;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int maxCapacity() {
        return this.capacity;
    }

    @Override  // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        switch(this.buffers.length) {
            case 0: {
                return Unpooled.EMPTY_BUFFER.memoryAddress();
            }
            case 1: {
                return this.buffer(0).memoryAddress();
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int v, int v1) {
        this.checkIndex(v, v1);
        if(this.buffers.length == 1) {
            ByteBuf byteBuf0 = this.buffer(0);
            if(byteBuf0.nioBufferCount() == 1) {
                return byteBuf0.nioBuffer(v, v1);
            }
        }
        ByteBuffer byteBuffer0 = ByteBuffer.allocate(v1).order(this.order());
        ByteBuffer[] arr_byteBuffer = this.nioBuffers(v, v1);
        for(int v2 = 0; v2 < arr_byteBuffer.length; ++v2) {
            byteBuffer0.put(arr_byteBuffer[v2]);
        }
        byteBuffer0.flip();
        return byteBuffer0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.nioBufferCount;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int v, int v1) {
        this.checkIndex(v, v1);
        if(v1 == 0) {
            return EmptyArrays.EMPTY_BYTE_BUFFERS;
        }
        RecyclableArrayList recyclableArrayList0 = RecyclableArrayList.newInstance(this.buffers.length);
        int v2 = FIN.finallyOpen$NT();
        Component fixedCompositeByteBuf$Component0 = this.findComponent(v);
        int v3 = Component.access$200(fixedCompositeByteBuf$Component0);
        int v4 = Component.access$000(fixedCompositeByteBuf$Component0);
        ByteBuf byteBuf0 = fixedCompositeByteBuf$Component0.buf;
        while(true) {
            int v5 = v - v4;
            int v6 = Math.min(v1, byteBuf0.readableBytes() - v5);
            switch(byteBuf0.nioBufferCount()) {
                case 0: {
                    FIN.finallyExec$NT(v2);
                    throw new UnsupportedOperationException();
                label_15:
                    Collections.addAll(recyclableArrayList0, byteBuf0.nioBuffers(v5, v6));
                    break;
                }
                case 1: {
                    recyclableArrayList0.add(byteBuf0.nioBuffer(v5, v6));
                    break;
                }
                default: {
                    goto label_15;
                }
            }
            v += v6;
            v1 -= v6;
            v4 += byteBuf0.readableBytes();
            if(v1 <= 0) {
                ByteBuffer[] arr_byteBuffer = (ByteBuffer[])recyclableArrayList0.toArray(EmptyArrays.EMPTY_BYTE_BUFFERS);
                FIN.finallyCodeBegin$NT(v2);
                recyclableArrayList0.recycle();
                FIN.finallyCodeEnd$NT(v2);
                return arr_byteBuffer;
            }
            ++v3;
            byteBuf0 = this.buffer(v3);
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return this.order;
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
    public ByteBuf setLong(int v, long v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setMedium(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setShort(int v, int v1) {
        throw new ReadOnlyBufferException();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public String toString() {
        return o.q(x.p(b.d(1, 0, super.toString()), ", components="), this.buffers.length, ')');
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }
}

