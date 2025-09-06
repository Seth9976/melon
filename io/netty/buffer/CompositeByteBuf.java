package io.netty.buffer;

import H0.b;
import U4.x;
import androidx.appcompat.app.o;
import io.netty.util.ByteProcessor;
import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.RecyclableArrayList;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CompositeByteBuf extends AbstractReferenceCountedByteBuf implements Iterable {
    interface ByteWrapper {
        boolean isEmpty(Object arg1);

        ByteBuf wrap(Object arg1);
    }

    static final class Component {
        int adjustment;
        final ByteBuf buf;
        int endOffset;
        int offset;
        private ByteBuf slice;
        int srcAdjustment;
        final ByteBuf srcBuf;

        public Component(ByteBuf byteBuf0, int v, ByteBuf byteBuf1, int v1, int v2, int v3, ByteBuf byteBuf2) {
            this.srcBuf = byteBuf0;
            this.srcAdjustment = v - v2;
            this.buf = byteBuf1;
            this.adjustment = v1 - v2;
            this.offset = v2;
            this.endOffset = v2 + v3;
            this.slice = byteBuf2;
        }

        public static ByteBuf access$100(Component compositeByteBuf$Component0) {
            return compositeByteBuf$Component0.slice;
        }

        public static ByteBuf access$102(Component compositeByteBuf$Component0, ByteBuf byteBuf0) {
            compositeByteBuf$Component0.slice = byteBuf0;
            return byteBuf0;
        }

        public ByteBuf duplicate() {
            return this.srcBuf.duplicate();
        }

        public void free() {
            this.slice = null;
            this.srcBuf.release();
        }

        public int idx(int v) {
            return v + this.adjustment;
        }

        public ByteBuffer internalNioBuffer(int v, int v1) {
            return this.srcBuf.internalNioBuffer(this.srcIdx(v), v1);
        }

        public int length() {
            return this.endOffset - this.offset;
        }

        public void reposition(int v) {
            int v1 = v - this.offset;
            this.endOffset += v1;
            this.srcAdjustment -= v1;
            this.adjustment -= v1;
            this.offset = v;
        }

        public ByteBuf slice() {
            ByteBuf byteBuf0 = this.slice;
            if(byteBuf0 == null) {
                byteBuf0 = this.srcBuf.slice(this.srcIdx(this.offset), this.length());
                this.slice = byteBuf0;
            }
            return byteBuf0;
        }

        public int srcIdx(int v) {
            return v + this.srcAdjustment;
        }

        public void transferTo(ByteBuf byteBuf0) {
            byteBuf0.writeBytes(this.buf, this.idx(this.offset), this.length());
            this.free();
        }
    }

    final class CompositeByteBufIterator implements Iterator {
        private int index;
        private final int size;

        private CompositeByteBufIterator() {
            this.size = compositeByteBuf0.numComponents();
        }

        public CompositeByteBufIterator(io.netty.buffer.CompositeByteBuf.1 compositeByteBuf$10) {
        }

        @Override
        public boolean hasNext() {
            return this.size > this.index;
        }

        public ByteBuf next() {
            int v = CompositeByteBuf.this.numComponents();
            if(this.size != v) {
                throw new ConcurrentModificationException();
            }
            if(this.hasNext()) {
                try {
                    int v1 = this.index;
                    this.index = v1 + 1;
                    return CompositeByteBuf.this.components[v1].slice();
                }
                catch(IndexOutOfBoundsException unused_ex) {
                    throw new ConcurrentModificationException();
                }
            }
            throw new NoSuchElementException();
        }

        @Override
        public Object next() {
            return this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Read-Only");
        }
    }

    static final boolean $assertionsDisabled;
    static final ByteWrapper BYTE_ARRAY_WRAPPER;
    static final ByteWrapper BYTE_BUFFER_WRAPPER;
    private static final Iterator EMPTY_ITERATOR;
    private static final ByteBuffer EMPTY_NIO_BUFFER;
    private final ByteBufAllocator alloc;
    private int componentCount;
    private Component[] components;
    private final boolean direct;
    private boolean freed;
    private Component lastAccessed;
    private final int maxNumComponents;

    static {
        CompositeByteBuf.EMPTY_NIO_BUFFER = Unpooled.EMPTY_BUFFER.nioBuffer();
        CompositeByteBuf.EMPTY_ITERATOR = Collections.EMPTY_LIST.iterator();
        CompositeByteBuf.BYTE_ARRAY_WRAPPER = new ByteWrapper() {
            @Override  // io.netty.buffer.CompositeByteBuf$ByteWrapper
            public boolean isEmpty(Object object0) {
                return this.isEmpty(((byte[])object0));
            }

            public boolean isEmpty(byte[] arr_b) {
                return arr_b.length == 0;
            }

            @Override  // io.netty.buffer.CompositeByteBuf$ByteWrapper
            public ByteBuf wrap(Object object0) {
                return this.wrap(((byte[])object0));
            }

            public ByteBuf wrap(byte[] arr_b) {
                return Unpooled.wrappedBuffer(arr_b);
            }
        };
        CompositeByteBuf.BYTE_BUFFER_WRAPPER = new ByteWrapper() {
            @Override  // io.netty.buffer.CompositeByteBuf$ByteWrapper
            public boolean isEmpty(Object object0) {
                return this.isEmpty(((ByteBuffer)object0));
            }

            public boolean isEmpty(ByteBuffer byteBuffer0) {
                return !byteBuffer0.hasRemaining();
            }

            @Override  // io.netty.buffer.CompositeByteBuf$ByteWrapper
            public ByteBuf wrap(Object object0) {
                return this.wrap(((ByteBuffer)object0));
            }

            public ByteBuf wrap(ByteBuffer byteBuffer0) {
                return Unpooled.wrappedBuffer(byteBuffer0);
            }
        };
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator0) {
        super(0x7FFFFFFF);
        this.alloc = byteBufAllocator0;
        this.direct = false;
        this.maxNumComponents = 0;
        this.components = null;
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator0, boolean z, int v) {
        this(byteBufAllocator0, z, v, 0);
    }

    private CompositeByteBuf(ByteBufAllocator byteBufAllocator0, boolean z, int v, int v1) {
        super(0x7FFFFFFF);
        this.alloc = (ByteBufAllocator)ObjectUtil.checkNotNull(byteBufAllocator0, "alloc");
        if(v < 1) {
            throw new IllegalArgumentException("maxNumComponents: " + v + " (expected: >= 1)");
        }
        this.direct = z;
        this.maxNumComponents = v;
        this.components = CompositeByteBuf.newCompArray(v1, v);
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator0, boolean z, int v, ByteWrapper compositeByteBuf$ByteWrapper0, Object[] arr_object, int v1) {
        this(byteBufAllocator0, z, v, arr_object.length - v1);
        this.addComponents0(false, 0, compositeByteBuf$ByteWrapper0, arr_object, v1);
        this.consolidateIfNeeded();
        this.setIndex(0, this.capacity());
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator0, boolean z, int v, Iterable iterable0) {
        this(byteBufAllocator0, z, v, (iterable0 instanceof Collection ? ((Collection)iterable0).size() : 0));
        this.addComponents(false, 0, iterable0);
        this.setIndex(0, this.capacity());
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator0, boolean z, int v, ByteBuf[] arr_byteBuf) {
        this(byteBufAllocator0, z, v, arr_byteBuf, 0);
    }

    public CompositeByteBuf(ByteBufAllocator byteBufAllocator0, boolean z, int v, ByteBuf[] arr_byteBuf, int v1) {
        this(byteBufAllocator0, z, v, arr_byteBuf.length - v1);
        this.addComponents0(false, 0, arr_byteBuf, v1);
        this.consolidateIfNeeded();
        this.setIndex0(0, this.capacity());
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int v) {
        Component compositeByteBuf$Component0 = this.findComponent0(v);
        return compositeByteBuf$Component0.buf.getByte(compositeByteBuf$Component0.idx(v));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int _getInt(int v) {
        Component compositeByteBuf$Component0 = this.findComponent0(v);
        if(v + 4 <= compositeByteBuf$Component0.endOffset) {
            return compositeByteBuf$Component0.buf.getInt(compositeByteBuf$Component0.idx(v));
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
        Component compositeByteBuf$Component0 = this.findComponent0(v);
        if(v + 4 <= compositeByteBuf$Component0.endOffset) {
            return compositeByteBuf$Component0.buf.getIntLE(compositeByteBuf$Component0.idx(v));
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
        Component compositeByteBuf$Component0 = this.findComponent0(v);
        if(v + 8 <= compositeByteBuf$Component0.endOffset) {
            return compositeByteBuf$Component0.buf.getLong(compositeByteBuf$Component0.idx(v));
        }
        return this.order() == ByteOrder.BIG_ENDIAN ? (((long)this._getInt(v)) & 0xFFFFFFFFL) << 0x20 | ((long)this._getInt(v + 4)) & 0xFFFFFFFFL : ((long)this._getInt(v)) & 0xFFFFFFFFL | (0xFFFFFFFFL & ((long)this._getInt(v + 4))) << 0x20;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int v) {
        Component compositeByteBuf$Component0 = this.findComponent0(v);
        if(v + 8 <= compositeByteBuf$Component0.endOffset) {
            return compositeByteBuf$Component0.buf.getLongLE(compositeByteBuf$Component0.idx(v));
        }
        return this.order() == ByteOrder.BIG_ENDIAN ? ((long)this._getIntLE(v)) & 0xFFFFFFFFL | (0xFFFFFFFFL & ((long)this._getIntLE(v + 4))) << 0x20 : (((long)this._getIntLE(v)) & 0xFFFFFFFFL) << 0x20 | ((long)this._getIntLE(v + 4)) & 0xFFFFFFFFL;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public short _getShort(int v) {
        Component compositeByteBuf$Component0 = this.findComponent0(v);
        if(v + 2 <= compositeByteBuf$Component0.endOffset) {
            return compositeByteBuf$Component0.buf.getShort(compositeByteBuf$Component0.idx(v));
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
        Component compositeByteBuf$Component0 = this.findComponent0(v);
        if(v + 2 <= compositeByteBuf$Component0.endOffset) {
            return compositeByteBuf$Component0.buf.getShortLE(compositeByteBuf$Component0.idx(v));
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
        Component compositeByteBuf$Component0 = this.findComponent0(v);
        if(v + 3 <= compositeByteBuf$Component0.endOffset) {
            return compositeByteBuf$Component0.buf.getUnsignedMedium(compositeByteBuf$Component0.idx(v));
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
        Component compositeByteBuf$Component0 = this.findComponent0(v);
        if(v + 3 <= compositeByteBuf$Component0.endOffset) {
            return compositeByteBuf$Component0.buf.getUnsignedMediumLE(compositeByteBuf$Component0.idx(v));
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
        Component compositeByteBuf$Component0 = this.findComponent0(v);
        compositeByteBuf$Component0.buf.setByte(compositeByteBuf$Component0.idx(v), v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setInt(int v, int v1) {
        Component compositeByteBuf$Component0 = this.findComponent0(v);
        if(v + 4 <= compositeByteBuf$Component0.endOffset) {
            compositeByteBuf$Component0.buf.setInt(compositeByteBuf$Component0.idx(v), v1);
            return;
        }
        if(this.order() == ByteOrder.BIG_ENDIAN) {
            this._setShort(v, ((int)(((short)(v1 >>> 16)))));
            this._setShort(v + 2, ((int)(((short)v1))));
            return;
        }
        this._setShort(v, ((int)(((short)v1))));
        this._setShort(v + 2, ((int)(((short)(v1 >>> 16)))));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int v, int v1) {
        Component compositeByteBuf$Component0 = this.findComponent0(v);
        if(v + 4 <= compositeByteBuf$Component0.endOffset) {
            compositeByteBuf$Component0.buf.setIntLE(compositeByteBuf$Component0.idx(v), v1);
            return;
        }
        if(this.order() == ByteOrder.BIG_ENDIAN) {
            this._setShortLE(v, ((int)(((short)v1))));
            this._setShortLE(v + 2, ((int)(((short)(v1 >>> 16)))));
            return;
        }
        this._setShortLE(v, ((int)(((short)(v1 >>> 16)))));
        this._setShortLE(v + 2, ((int)(((short)v1))));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLong(int v, long v1) {
        Component compositeByteBuf$Component0 = this.findComponent0(v);
        if(v + 8 <= compositeByteBuf$Component0.endOffset) {
            compositeByteBuf$Component0.buf.setLong(compositeByteBuf$Component0.idx(v), v1);
            return;
        }
        if(this.order() == ByteOrder.BIG_ENDIAN) {
            this._setInt(v, ((int)(v1 >>> 0x20)));
            this._setInt(v + 4, ((int)v1));
            return;
        }
        this._setInt(v, ((int)v1));
        this._setInt(v + 4, ((int)(v1 >>> 0x20)));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int v, long v1) {
        Component compositeByteBuf$Component0 = this.findComponent0(v);
        if(v + 8 <= compositeByteBuf$Component0.endOffset) {
            compositeByteBuf$Component0.buf.setLongLE(compositeByteBuf$Component0.idx(v), v1);
            return;
        }
        if(this.order() == ByteOrder.BIG_ENDIAN) {
            this._setIntLE(v, ((int)v1));
            this._setIntLE(v + 4, ((int)(v1 >>> 0x20)));
            return;
        }
        this._setIntLE(v, ((int)(v1 >>> 0x20)));
        this._setIntLE(v + 4, ((int)v1));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int v, int v1) {
        Component compositeByteBuf$Component0 = this.findComponent0(v);
        if(v + 3 <= compositeByteBuf$Component0.endOffset) {
            compositeByteBuf$Component0.buf.setMedium(compositeByteBuf$Component0.idx(v), v1);
            return;
        }
        if(this.order() == ByteOrder.BIG_ENDIAN) {
            this._setShort(v, ((int)(((short)(v1 >> 8)))));
            this._setByte(v + 2, ((int)(((byte)v1))));
            return;
        }
        this._setShort(v, ((int)(((short)v1))));
        this._setByte(v + 2, ((int)(((byte)(v1 >>> 16)))));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int v, int v1) {
        Component compositeByteBuf$Component0 = this.findComponent0(v);
        if(v + 3 <= compositeByteBuf$Component0.endOffset) {
            compositeByteBuf$Component0.buf.setMediumLE(compositeByteBuf$Component0.idx(v), v1);
            return;
        }
        if(this.order() == ByteOrder.BIG_ENDIAN) {
            this._setShortLE(v, ((int)(((short)v1))));
            this._setByte(v + 2, ((int)(((byte)(v1 >>> 16)))));
            return;
        }
        this._setShortLE(v, ((int)(((short)(v1 >> 8)))));
        this._setByte(v + 2, ((int)(((byte)v1))));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShort(int v, int v1) {
        Component compositeByteBuf$Component0 = this.findComponent0(v);
        if(v + 2 <= compositeByteBuf$Component0.endOffset) {
            compositeByteBuf$Component0.buf.setShort(compositeByteBuf$Component0.idx(v), v1);
            return;
        }
        if(this.order() == ByteOrder.BIG_ENDIAN) {
            this._setByte(v, ((int)(((byte)(v1 >>> 8)))));
            this._setByte(v + 1, ((int)(((byte)v1))));
            return;
        }
        this._setByte(v, ((int)(((byte)v1))));
        this._setByte(v + 1, ((int)(((byte)(v1 >>> 8)))));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int v, int v1) {
        Component compositeByteBuf$Component0 = this.findComponent0(v);
        if(v + 2 <= compositeByteBuf$Component0.endOffset) {
            compositeByteBuf$Component0.buf.setShortLE(compositeByteBuf$Component0.idx(v), v1);
            return;
        }
        if(this.order() == ByteOrder.BIG_ENDIAN) {
            this._setByte(v, ((int)(((byte)v1))));
            this._setByte(v + 1, ((int)(((byte)(v1 >>> 8)))));
            return;
        }
        this._setByte(v, ((int)(((byte)(v1 >>> 8)))));
        this._setByte(v + 1, ((int)(((byte)v1))));
    }

    private void addComp(int v, Component compositeByteBuf$Component0) {
        this.shiftComps(v, 1);
        this.components[v] = compositeByteBuf$Component0;
    }

    public CompositeByteBuf addComponent(int v, ByteBuf byteBuf0) {
        return this.addComponent(false, v, byteBuf0);
    }

    public CompositeByteBuf addComponent(ByteBuf byteBuf0) {
        return this.addComponent(false, byteBuf0);
    }

    public CompositeByteBuf addComponent(boolean z, int v, ByteBuf byteBuf0) {
        ObjectUtil.checkNotNull(byteBuf0, "buffer");
        this.addComponent0(z, v, byteBuf0);
        this.consolidateIfNeeded();
        return this;
    }

    public CompositeByteBuf addComponent(boolean z, ByteBuf byteBuf0) {
        return this.addComponent(z, this.componentCount, byteBuf0);
    }

    private int addComponent0(boolean z, int v, ByteBuf byteBuf0) {
        try {
            boolean z1 = false;
            this.checkComponentIndex(v);
            Component compositeByteBuf$Component0 = this.newComponent(CompositeByteBuf.ensureAccessible(byteBuf0), 0);
            int v1 = compositeByteBuf$Component0.length();
            CompositeByteBuf.checkForOverflow(this.capacity(), v1);
            this.addComp(v, compositeByteBuf$Component0);
            z1 = true;
            if(v1 > 0 && v < this.componentCount - 1) {
                this.updateComponentOffsets(v);
            }
            else if(v > 0) {
                compositeByteBuf$Component0.reposition(this.components[v - 1].endOffset);
            }
            if(z) {
                this.writerIndex += v1;
            }
            return v;
        label_16:
            if(z1) {
                throw throwable0;
            }
        }
        catch(Throwable throwable0) {
            goto label_16;
        }
        byteBuf0.release();
        throw throwable0;
    }

    private CompositeByteBuf addComponents(boolean z, int v, Iterable iterable0) {
        if(iterable0 instanceof ByteBuf) {
            return this.addComponent(z, v, ((ByteBuf)iterable0));
        }
        ObjectUtil.checkNotNull(iterable0, "buffers");
        Iterator iterator0 = iterable0.iterator();
        try {
            this.checkComponentIndex(v);
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                if(((ByteBuf)object0) == null) {
                    break;
                }
                v = Math.min(this.addComponent0(z, v, ((ByteBuf)object0)) + 1, this.componentCount);
            }
        }
        finally {
            while(iterator0.hasNext()) {
                Object object1 = iterator0.next();
                ReferenceCountUtil.safeRelease(object1);
            }
        }
        this.consolidateIfNeeded();
        return this;
    }

    public CompositeByteBuf addComponents(int v, Iterable iterable0) {
        return this.addComponents(false, v, iterable0);
    }

    public CompositeByteBuf addComponents(int v, ByteBuf[] arr_byteBuf) {
        ObjectUtil.checkNotNull(arr_byteBuf, "buffers");
        this.addComponents0(false, v, arr_byteBuf, 0);
        this.consolidateIfNeeded();
        return this;
    }

    public CompositeByteBuf addComponents(Iterable iterable0) {
        return this.addComponents(false, iterable0);
    }

    public CompositeByteBuf addComponents(boolean z, Iterable iterable0) {
        return this.addComponents(z, this.componentCount, iterable0);
    }

    public CompositeByteBuf addComponents(boolean z, ByteBuf[] arr_byteBuf) {
        ObjectUtil.checkNotNull(arr_byteBuf, "buffers");
        this.addComponents0(z, this.componentCount, arr_byteBuf, 0);
        this.consolidateIfNeeded();
        return this;
    }

    public CompositeByteBuf addComponents(ByteBuf[] arr_byteBuf) {
        return this.addComponents(false, arr_byteBuf);
    }

    private int addComponents0(boolean z, int v, ByteWrapper compositeByteBuf$ByteWrapper0, Object[] arr_object, int v1) {
        this.checkComponentIndex(v);
        while(v1 < arr_object.length) {
            Object object0 = arr_object[v1];
            if(object0 == null) {
                break;
            }
            if(!compositeByteBuf$ByteWrapper0.isEmpty(object0)) {
                v = this.addComponent0(z, v, compositeByteBuf$ByteWrapper0.wrap(object0)) + 1;
                int v2 = this.componentCount;
                if(v > v2) {
                    v = v2;
                }
            }
            ++v1;
        }
        return v;
    }

    private CompositeByteBuf addComponents0(boolean z, int v, ByteBuf[] arr_byteBuf, int v1) {
        int v2 = arr_byteBuf.length - v1;
        int v3 = this.capacity();
        int v4 = 0;
        int v5 = v1;
        int v6 = 0;
        while(v5 < arr_byteBuf.length) {
            ByteBuf byteBuf0 = arr_byteBuf[v5];
            if(byteBuf0 == null) {
                break;
            }
            v6 += byteBuf0.readableBytes();
            CompositeByteBuf.checkForOverflow(v3, v6);
            ++v5;
        }
        try {
            this.checkComponentIndex(v);
            this.shiftComps(v, v2);
            if(v > 0) {
                v4 = this.components[v - 1].endOffset;
            }
            int v8;
            for(v8 = v; v1 < arr_byteBuf.length; ++v8) {
                ByteBuf byteBuf1 = arr_byteBuf[v1];
                if(byteBuf1 == null) {
                    break;
                }
                Component compositeByteBuf$Component0 = this.newComponent(CompositeByteBuf.ensureAccessible(byteBuf1), v4);
                this.components[v8] = compositeByteBuf$Component0;
                v4 = compositeByteBuf$Component0.endOffset;
                ++v1;
            }
            return this;
        }
        finally {
            if(v8 < this.componentCount) {
                int v9 = v2 + v;
                if(v8 < v9) {
                    this.removeCompRange(v8, v9);
                    while(v1 < arr_byteBuf.length) {
                        ReferenceCountUtil.safeRelease(arr_byteBuf[v1]);
                        ++v1;
                    }
                }
                this.updateComponentOffsets(v8);
            }
            if(z && v8 > v && v8 <= this.componentCount) {
                this.writerIndex = this.components[v8 - 1].endOffset - this.components[v].offset + this.writerIndex;
            }
        }
    }

    public CompositeByteBuf addFlattenedComponents(boolean z, ByteBuf byteBuf0) {
        int v10;
        ObjectUtil.checkNotNull(byteBuf0, "buffer");
        int v = byteBuf0.readerIndex();
        int v1 = byteBuf0.writerIndex();
        if(v == v1) {
            byteBuf0.release();
            return this;
        }
        if(!(byteBuf0 instanceof CompositeByteBuf)) {
            this.addComponent0(z, this.componentCount, byteBuf0);
            this.consolidateIfNeeded();
            return this;
        }
        CompositeByteBuf compositeByteBuf0 = byteBuf0 instanceof WrappedCompositeByteBuf ? ((CompositeByteBuf)byteBuf0.unwrap()) : ((CompositeByteBuf)byteBuf0);
        int v2 = v1 - v;
        compositeByteBuf0.checkIndex(v, v2);
        Component[] arr_compositeByteBuf$Component = compositeByteBuf0.components;
        int v3 = this.componentCount;
        int v4 = this.writerIndex;
        try {
            int v5 = compositeByteBuf0.toComponentIndex0(v);
            int v6 = this.capacity();
            while(true) {
                Component compositeByteBuf$Component0 = arr_compositeByteBuf$Component[v5];
                int v7 = Math.max(v, compositeByteBuf$Component0.offset);
                int v8 = Math.min(v1, compositeByteBuf$Component0.endOffset);
                int v9 = v8 - v7;
                if(v9 > 0) {
                    v10 = v8;
                    this.addComp(this.componentCount, new Component(compositeByteBuf$Component0.srcBuf.retain(), compositeByteBuf$Component0.srcIdx(v7), compositeByteBuf$Component0.buf, compositeByteBuf$Component0.idx(v7), v6, v9, null));
                }
                else {
                    v10 = v8;
                }
                if(v1 == v10) {
                    if(z) {
                        this.writerIndex = v2 + v4;
                    }
                    this.consolidateIfNeeded();
                    byteBuf0.release();
                    return this;
                }
                v6 += v9;
                ++v5;
            }
        label_37:
            if(z) {
                goto label_38;
            }
            goto label_39;
        }
        catch(Throwable throwable0) {
            goto label_37;
        }
    label_38:
        this.writerIndex = v4;
    label_39:
        for(int v11 = this.componentCount - 1; v11 >= v3; --v11) {
            this.components[v11].free();
            this.removeComp(v11);
        }
        throw throwable0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.alloc;
    }

    // 去混淆评级： 低(20)
    private ByteBuf allocBuffer(int v) {
        return this.direct ? this.alloc().directBuffer(v) : this.alloc().heapBuffer(v);
    }

    @Override  // io.netty.buffer.ByteBuf
    public byte[] array() {
        switch(this.componentCount) {
            case 0: {
                return EmptyArrays.EMPTY_BYTES;
            }
            case 1: {
                return this.components[0].buf.array();
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        switch(this.componentCount) {
            case 0: {
                return 0;
            }
            case 1: {
                Component compositeByteBuf$Component0 = this.components[0];
                return compositeByteBuf$Component0.idx(compositeByteBuf$Component0.buf.arrayOffset());
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.componentCount <= 0 ? 0 : this.components[this.componentCount - 1].endOffset;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int v) {
        return this.capacity(v);
    }

    public CompositeByteBuf capacity(int v) {
        this.checkNewCapacity(v);
        int v1 = this.componentCount;
        int v2 = this.capacity();
        if(v > v2) {
            this.addComponent0(false, v1, this.allocBuffer(v - v2).setIndex(0, v - v2));
            if(this.componentCount >= this.maxNumComponents) {
                this.consolidateIfNeeded();
                return this;
            }
        }
        else if(v < v2) {
            this.lastAccessed = null;
            int v3 = v1 - 1;
            int v4 = v2 - v;
            while(v3 >= 0) {
                Component compositeByteBuf$Component0 = this.components[v3];
                int v5 = compositeByteBuf$Component0.length();
                if(v4 < v5) {
                    compositeByteBuf$Component0.endOffset -= v4;
                    ByteBuf byteBuf0 = Component.access$100(compositeByteBuf$Component0);
                    if(byteBuf0 == null) {
                        break;
                    }
                    Component.access$102(compositeByteBuf$Component0, byteBuf0.slice(0, compositeByteBuf$Component0.length()));
                    break;
                }
                compositeByteBuf$Component0.free();
                v4 -= v5;
                --v3;
            }
            this.removeCompRange(v3 + 1, v1);
            if(this.readerIndex() > v) {
                this.setIndex0(v, v);
                return this;
            }
            if(this.writerIndex > v) {
                this.writerIndex = v;
            }
        }
        return this;
    }

    private void checkComponentIndex(int v) {
        this.ensureAccessible();
        if(v < 0 || v > this.componentCount) {
            throw new IndexOutOfBoundsException(String.format("cIndex: %d (expected: >= 0 && <= numComponents(%d))", v, this.componentCount));
        }
    }

    private void checkComponentIndex(int v, int v1) {
        this.ensureAccessible();
        if(v < 0 || v + v1 > this.componentCount) {
            throw new IndexOutOfBoundsException(String.format("cIndex: %d, numComponents: %d (expected: cIndex >= 0 && cIndex + numComponents <= totalNumComponents(%d))", v, v1, this.componentCount));
        }
    }

    private static void checkForOverflow(int v, int v1) {
        if(v + v1 < 0) {
            throw new IllegalArgumentException("Can\'t increase by " + v1 + " as capacity(" + v + ") would overflow 2147483647");
        }
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf clear() {
        return this.clear();
    }

    public CompositeByteBuf clear() {
        super.clear();
        return this;
    }

    private void clearComps() {
        this.removeCompRange(0, this.componentCount);
    }

    public ByteBuf component(int v) {
        this.checkComponentIndex(v);
        return this.components[v].duplicate();
    }

    public ByteBuf componentAtOffset(int v) {
        return this.findComponent(v).duplicate();
    }

    public CompositeByteBuf consolidate() {
        this.ensureAccessible();
        this.consolidate0(0, this.componentCount);
        return this;
    }

    public CompositeByteBuf consolidate(int v, int v1) {
        this.checkComponentIndex(v, v1);
        this.consolidate0(v, v1);
        return this;
    }

    private void consolidate0(int v, int v1) {
        if(v1 > 1) {
            int v2 = v + v1;
            ByteBuf byteBuf0 = this.allocBuffer(this.components[v2 - 1].endOffset - (v == 0 ? 0 : this.components[v].offset));
            for(int v3 = v; v3 < v2; ++v3) {
                this.components[v3].transferTo(byteBuf0);
            }
            this.lastAccessed = null;
            this.removeCompRange(v + 1, v2);
            Component[] arr_compositeByteBuf$Component = this.components;
            arr_compositeByteBuf$Component[v] = this.newComponent(byteBuf0, 0);
            if(v != 0 || v1 != this.componentCount) {
                this.updateComponentOffsets(v);
            }
        }
    }

    private void consolidateIfNeeded() {
        int v = this.componentCount;
        if(v > this.maxNumComponents) {
            this.consolidate0(0, v);
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf copy(int v, int v1) {
        this.checkIndex(v, v1);
        ByteBuf byteBuf0 = this.allocBuffer(v1);
        if(v1 != 0) {
            this.copyTo(v, v1, this.toComponentIndex0(v), byteBuf0);
        }
        return byteBuf0;
    }

    private void copyTo(int v, int v1, int v2, ByteBuf byteBuf0) {
        int v3 = 0;
        while(v1 > 0) {
            Component compositeByteBuf$Component0 = this.components[v2];
            int v4 = Math.min(v1, compositeByteBuf$Component0.endOffset - v);
            compositeByteBuf$Component0.buf.getBytes(compositeByteBuf$Component0.idx(v), byteBuf0, v3, v4);
            v += v4;
            v3 += v4;
            v1 -= v4;
            ++v2;
        }
        byteBuf0.writerIndex(byteBuf0.capacity());
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public void deallocate() {
        if(!this.freed) {
            this.freed = true;
            int v = this.componentCount;
            for(int v1 = 0; v1 < v; ++v1) {
                this.components[v1].free();
            }
        }
    }

    public List decompose(int v, int v1) {
        this.checkIndex(v, v1);
        if(v1 == 0) {
            return Collections.EMPTY_LIST;
        }
        int v2 = this.toComponentIndex0(v);
        Component compositeByteBuf$Component0 = this.components[v2];
        ByteBuf byteBuf0 = compositeByteBuf$Component0.srcBuf.slice(compositeByteBuf$Component0.srcIdx(v), Math.min(compositeByteBuf$Component0.endOffset - v, v1));
        int v3 = v1 - byteBuf0.readableBytes();
        if(v3 == 0) {
            return Collections.singletonList(byteBuf0);
        }
        List list0 = new ArrayList(this.componentCount - v2);
        ((ArrayList)list0).add(byteBuf0);
        do {
            ++v2;
            Component compositeByteBuf$Component1 = this.components[v2];
            ByteBuf byteBuf1 = compositeByteBuf$Component1.srcBuf.slice(compositeByteBuf$Component1.srcIdx(compositeByteBuf$Component1.offset), Math.min(compositeByteBuf$Component1.length(), v3));
            v3 -= byteBuf1.readableBytes();
            ((ArrayList)list0).add(byteBuf1);
        }
        while(v3 > 0);
        return list0;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf discardReadBytes() {
        return this.discardReadBytes();
    }

    public CompositeByteBuf discardReadBytes() {
        this.ensureAccessible();
        int v = this.readerIndex();
        if(v == 0) {
            return this;
        }
        int v1 = this.writerIndex();
        if(v == v1 && v1 == this.capacity()) {
            int v2 = this.componentCount;
            for(int v3 = 0; v3 < v2; ++v3) {
                this.components[v3].free();
            }
            this.lastAccessed = null;
            this.clearComps();
            this.setIndex(0, 0);
            this.adjustMarkers(v);
            return this;
        }
        int v4 = this.componentCount;
        Component compositeByteBuf$Component0 = null;
        int v5;
        for(v5 = 0; v5 < v4; ++v5) {
            compositeByteBuf$Component0 = this.components[v5];
            if(compositeByteBuf$Component0.endOffset > v) {
                break;
            }
            compositeByteBuf$Component0.free();
        }
        int v6 = v - compositeByteBuf$Component0.offset;
        compositeByteBuf$Component0.offset = 0;
        compositeByteBuf$Component0.endOffset -= v;
        compositeByteBuf$Component0.srcAdjustment += v;
        compositeByteBuf$Component0.adjustment += v;
        ByteBuf byteBuf0 = Component.access$100(compositeByteBuf$Component0);
        if(byteBuf0 != null) {
            Component.access$102(compositeByteBuf$Component0, byteBuf0.slice(v6, compositeByteBuf$Component0.length()));
        }
        if(this.lastAccessed != null && this.lastAccessed.endOffset <= v) {
            this.lastAccessed = null;
        }
        this.removeCompRange(0, v5);
        this.updateComponentOffsets(0);
        this.setIndex(0, v1 - v);
        this.adjustMarkers(v);
        return this;
    }

    public CompositeByteBuf discardReadComponents() {
        this.ensureAccessible();
        int v = this.readerIndex();
        if(v != 0) {
            int v1 = this.writerIndex();
            if(v == v1 && v1 == this.capacity()) {
                int v2 = this.componentCount;
                for(int v3 = 0; v3 < v2; ++v3) {
                    this.components[v3].free();
                }
                this.lastAccessed = null;
                this.clearComps();
                this.setIndex(0, 0);
                this.adjustMarkers(v);
                return this;
            }
            int v4 = this.componentCount;
            Component compositeByteBuf$Component0 = null;
            int v5;
            for(v5 = 0; v5 < v4; ++v5) {
                compositeByteBuf$Component0 = this.components[v5];
                if(compositeByteBuf$Component0.endOffset > v) {
                    break;
                }
                compositeByteBuf$Component0.free();
            }
            if(v5 != 0) {
                if(this.lastAccessed != null && this.lastAccessed.endOffset <= v) {
                    this.lastAccessed = null;
                }
                this.removeCompRange(0, v5);
                int v6 = compositeByteBuf$Component0.offset;
                this.updateComponentOffsets(0);
                this.setIndex(v - v6, v1 - v6);
                this.adjustMarkers(v6);
                return this;
            }
        }
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf discardSomeReadBytes() {
        return this.discardSomeReadBytes();
    }

    public CompositeByteBuf discardSomeReadBytes() {
        return this.discardReadComponents();
    }

    private static ByteBuf ensureAccessible(ByteBuf byteBuf0) {
        if(AbstractByteBuf.checkAccessible && !byteBuf0.isAccessible()) {
            throw new IllegalReferenceCountException(0);
        }
        return byteBuf0;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf ensureWritable(int v) {
        return this.ensureWritable(v);
    }

    public CompositeByteBuf ensureWritable(int v) {
        super.ensureWritable(v);
        return this;
    }

    private Component findComponent(int v) {
        Component compositeByteBuf$Component0 = this.lastAccessed;
        if(compositeByteBuf$Component0 != null && v >= compositeByteBuf$Component0.offset && v < compositeByteBuf$Component0.endOffset) {
            this.ensureAccessible();
            return compositeByteBuf$Component0;
        }
        this.checkIndex(v);
        return this.findIt(v);
    }

    private Component findComponent0(int v) {
        Component compositeByteBuf$Component0 = this.lastAccessed;
        return compositeByteBuf$Component0 == null || v < compositeByteBuf$Component0.offset || v >= compositeByteBuf$Component0.endOffset ? this.findIt(v) : compositeByteBuf$Component0;
    }

    private Component findIt(int v) {
        int v1 = this.componentCount;
        int v2 = 0;
        while(v2 <= v1) {
            int v3 = v2 + v1 >>> 1;
            Component compositeByteBuf$Component0 = this.components[v3];
            if(compositeByteBuf$Component0 == null) {
                throw new IllegalStateException("No component found for offset. Composite buffer layout might be outdated, e.g. from a discardReadBytes call.");
            }
            if(v >= compositeByteBuf$Component0.endOffset) {
                v2 = v3 + 1;
                continue;
            }
            if(v < compositeByteBuf$Component0.offset) {
                v1 = v3 - 1;
                continue;
            }
            this.lastAccessed = compositeByteBuf$Component0;
            return compositeByteBuf$Component0;
        }
        throw new Error("should not reach here");
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int forEachByteAsc0(int v, int v1, ByteProcessor byteProcessor0) {
        if(v1 <= v) {
            return -1;
        }
        int v2 = this.toComponentIndex0(v);
        int v3 = v1 - v;
        while(v3 > 0) {
            Component compositeByteBuf$Component0 = this.components[v2];
            if(compositeByteBuf$Component0.offset != compositeByteBuf$Component0.endOffset) {
                int v4 = compositeByteBuf$Component0.idx(v);
                int v5 = Math.min(v3, compositeByteBuf$Component0.endOffset - v);
                int v6 = compositeByteBuf$Component0.buf instanceof AbstractByteBuf ? ((AbstractByteBuf)compositeByteBuf$Component0.buf).forEachByteAsc0(v4, v4 + v5, byteProcessor0) : compositeByteBuf$Component0.buf.forEachByte(v4, v5, byteProcessor0);
                if(v6 != -1) {
                    return v6 - compositeByteBuf$Component0.adjustment;
                }
                v += v5;
                v3 -= v5;
            }
            ++v2;
        }
        return -1;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public int forEachByteDesc0(int v, int v1, ByteProcessor byteProcessor0) {
        if(v1 > v) {
            return -1;
        }
        int v2 = this.toComponentIndex0(v);
        int v3 = v + 1 - v1;
        while(v3 > 0) {
            Component compositeByteBuf$Component0 = this.components[v2];
            if(compositeByteBuf$Component0.offset != compositeByteBuf$Component0.endOffset) {
                int v4 = compositeByteBuf$Component0.idx(v3 + v1);
                int v5 = Math.min(v3, v4);
                int v6 = v4 - v5;
                int v7 = compositeByteBuf$Component0.buf instanceof AbstractByteBuf ? ((AbstractByteBuf)compositeByteBuf$Component0.buf).forEachByteDesc0(v4 - 1, v6, byteProcessor0) : compositeByteBuf$Component0.buf.forEachByteDesc(v6, v5, byteProcessor0);
                if(v7 != -1) {
                    return v7 - compositeByteBuf$Component0.adjustment;
                }
                v3 -= v5;
            }
            --v2;
        }
        return -1;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public byte getByte(int v) {
        Component compositeByteBuf$Component0 = this.findComponent(v);
        return compositeByteBuf$Component0.buf.getByte(compositeByteBuf$Component0.idx(v));
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

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0) {
        return this.getBytes(v, byteBuf0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1) {
        return this.getBytes(v, byteBuf0, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        return this.getBytes(v, byteBuf0, v1, v2);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        return this.getBytes(v, outputStream0, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        return this.getBytes(v, byteBuffer0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b) {
        return this.getBytes(v, arr_b);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        return this.getBytes(v, arr_b, v1, v2);
    }

    public CompositeByteBuf getBytes(int v, ByteBuf byteBuf0) {
        return this.getBytes(v, byteBuf0, byteBuf0.writableBytes());
    }

    public CompositeByteBuf getBytes(int v, ByteBuf byteBuf0, int v1) {
        this.getBytes(v, byteBuf0, byteBuf0.writerIndex(), v1);
        byteBuf0.writerIndex(byteBuf0.writerIndex() + v1);
        return this;
    }

    public CompositeByteBuf getBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.checkDstIndex(v, v2, v1, byteBuf0.capacity());
        if(v2 != 0) {
            for(int v3 = this.toComponentIndex0(v); v2 > 0; ++v3) {
                Component compositeByteBuf$Component0 = this.components[v3];
                int v4 = Math.min(v2, compositeByteBuf$Component0.endOffset - v);
                compositeByteBuf$Component0.buf.getBytes(compositeByteBuf$Component0.idx(v), byteBuf0, v1, v4);
                v += v4;
                v1 += v4;
                v2 -= v4;
            }
        }
        return this;
    }

    public CompositeByteBuf getBytes(int v, OutputStream outputStream0, int v1) {
        this.checkIndex(v, v1);
        if(v1 != 0) {
            for(int v2 = this.toComponentIndex0(v); v1 > 0; ++v2) {
                Component compositeByteBuf$Component0 = this.components[v2];
                int v3 = Math.min(v1, compositeByteBuf$Component0.endOffset - v);
                compositeByteBuf$Component0.buf.getBytes(compositeByteBuf$Component0.idx(v), outputStream0, v3);
                v += v3;
                v1 -= v3;
            }
        }
        return this;
    }

    public CompositeByteBuf getBytes(int v, ByteBuffer byteBuffer0) {
        int v1 = byteBuffer0.limit();
        int v2 = byteBuffer0.remaining();
        this.checkIndex(v, v2);
        if(v2 == 0) {
            return this;
        }
        int v3 = this.toComponentIndex0(v);
        try {
            while(v2 > 0) {
                Component compositeByteBuf$Component0 = this.components[v3];
                int v5 = Math.min(v2, compositeByteBuf$Component0.endOffset - v);
                byteBuffer0.limit(byteBuffer0.position() + v5);
                compositeByteBuf$Component0.buf.getBytes(compositeByteBuf$Component0.idx(v), byteBuffer0);
                v += v5;
                v2 -= v5;
                ++v3;
            }
            return this;
        }
        finally {
            byteBuffer0.limit(v1);
        }
    }

    public CompositeByteBuf getBytes(int v, byte[] arr_b) {
        return this.getBytes(v, arr_b, 0, arr_b.length);
    }

    public CompositeByteBuf getBytes(int v, byte[] arr_b, int v1, int v2) {
        this.checkDstIndex(v, v2, v1, arr_b.length);
        if(v2 != 0) {
            for(int v3 = this.toComponentIndex0(v); v2 > 0; ++v3) {
                Component compositeByteBuf$Component0 = this.components[v3];
                int v4 = Math.min(v2, compositeByteBuf$Component0.endOffset - v);
                compositeByteBuf$Component0.buf.getBytes(compositeByteBuf$Component0.idx(v), arr_b, v1, v4);
                v += v4;
                v1 += v4;
                v2 -= v4;
            }
        }
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        switch(this.componentCount) {
            case 0: {
                return true;
            }
            case 1: {
                return this.components[0].buf.hasArray();
            }
            default: {
                return false;
            }
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        switch(this.componentCount) {
            case 0: {
                return Unpooled.EMPTY_BUFFER.hasMemoryAddress();
            }
            case 1: {
                return this.components[0].buf.hasMemoryAddress();
            }
            default: {
                return false;
            }
        }
    }

    public ByteBuf internalComponent(int v) {
        this.checkComponentIndex(v);
        return this.components[v].slice();
    }

    public ByteBuf internalComponentAtOffset(int v) {
        return this.findComponent(v).slice();
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int v, int v1) {
        switch(this.componentCount) {
            case 0: {
                return CompositeByteBuf.EMPTY_NIO_BUFFER;
            }
            case 1: {
                return this.components[0].internalNioBuffer(v, v1);
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public boolean isAccessible() {
        return !this.freed;
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        int v = this.componentCount;
        if(v == 0) {
            return false;
        }
        for(int v1 = 0; v1 < v; ++v1) {
            if(!this.components[v1].buf.isDirect()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator iterator() {
        this.ensureAccessible();
        return this.componentCount == 0 ? CompositeByteBuf.EMPTY_ITERATOR : new CompositeByteBufIterator(this, null);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf markReaderIndex() {
        return this.markReaderIndex();
    }

    public CompositeByteBuf markReaderIndex() {
        super.markReaderIndex();
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf markWriterIndex() {
        return this.markWriterIndex();
    }

    public CompositeByteBuf markWriterIndex() {
        super.markWriterIndex();
        return this;
    }

    public int maxNumComponents() {
        return this.maxNumComponents;
    }

    @Override  // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        switch(this.componentCount) {
            case 0: {
                return Unpooled.EMPTY_BUFFER.memoryAddress();
            }
            case 1: {
                Component compositeByteBuf$Component0 = this.components[0];
                return compositeByteBuf$Component0.buf.memoryAddress() + ((long)compositeByteBuf$Component0.adjustment);
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
    }

    private static Component[] newCompArray(int v, int v1) {
        return new Component[Math.max(v, Math.min(16, v1))];
    }

    private Component newComponent(ByteBuf byteBuf0, int v) {
        int v4;
        int v3;
        int v1 = byteBuf0.readerIndex();
        int v2 = byteBuf0.readableBytes();
        ByteBuf byteBuf1;
        for(byteBuf1 = byteBuf0; byteBuf1 instanceof WrappedByteBuf || byteBuf1 instanceof SwappedByteBuf; byteBuf1 = byteBuf1.unwrap()) {
        }
        if(byteBuf1 instanceof AbstractUnpooledSlicedByteBuf) {
            v3 = ((AbstractUnpooledSlicedByteBuf)byteBuf1).idx(0) + v1;
            byteBuf1 = byteBuf1.unwrap();
            v4 = v3;
        }
        else if(byteBuf1 instanceof PooledSlicedByteBuf) {
            v3 = ((PooledSlicedByteBuf)byteBuf1).adjustment + v1;
            byteBuf1 = byteBuf1.unwrap();
            v4 = v3;
        }
        else {
            if(byteBuf1 instanceof DuplicatedByteBuf || byteBuf1 instanceof PooledDuplicatedByteBuf) {
                byteBuf1 = byteBuf1.unwrap();
            }
            v4 = v1;
        }
        ByteOrder byteOrder0 = ByteOrder.BIG_ENDIAN;
        return new Component(byteBuf0.order(byteOrder0), v1, byteBuf1.order(byteOrder0), v4, v, v2, (byteBuf0.capacity() == v2 ? byteBuf0 : null));
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int v, int v1) {
        this.checkIndex(v, v1);
        switch(this.componentCount) {
            case 0: {
                return CompositeByteBuf.EMPTY_NIO_BUFFER;
            }
            case 1: {
                Component compositeByteBuf$Component0 = this.components[0];
                ByteBuf byteBuf0 = compositeByteBuf$Component0.buf;
                if(byteBuf0.nioBufferCount() == 1) {
                    return byteBuf0.nioBuffer(compositeByteBuf$Component0.idx(v), v1);
                }
            }
        }
        ByteBuffer[] arr_byteBuffer = this.nioBuffers(v, v1);
        if(arr_byteBuffer.length == 1) {
            return arr_byteBuffer[0];
        }
        ByteBuffer byteBuffer0 = ByteBuffer.allocate(v1).order(this.order());
        for(int v2 = 0; v2 < arr_byteBuffer.length; ++v2) {
            byteBuffer0.put(arr_byteBuffer[v2]);
        }
        byteBuffer0.flip();
        return byteBuffer0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        int v1 = this.componentCount;
        switch(v1) {
            case 0: {
                return 1;
            }
            case 1: {
                return this.components[0].buf.nioBufferCount();
            }
            default: {
                int v2 = 0;
                for(int v = 0; v < v1; ++v) {
                    v2 += this.components[v].buf.nioBufferCount();
                }
                return v2;
            }
        }
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuffer[] nioBuffers() {
        return this.nioBuffers(this.readerIndex(), this.readableBytes());
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int v, int v1) {
        this.checkIndex(v, v1);
        if(v1 == 0) {
            return new ByteBuffer[]{CompositeByteBuf.EMPTY_NIO_BUFFER};
        }
        RecyclableArrayList recyclableArrayList0 = RecyclableArrayList.newInstance(this.componentCount);
        try {
            for(int v3 = this.toComponentIndex0(v); v1 > 0; ++v3) {
                Component compositeByteBuf$Component0 = this.components[v3];
                ByteBuf byteBuf0 = compositeByteBuf$Component0.buf;
                int v4 = Math.min(v1, compositeByteBuf$Component0.endOffset - v);
                switch(byteBuf0.nioBufferCount()) {
                    case 0: {
                        throw new UnsupportedOperationException();
                    }
                    case 1: {
                        recyclableArrayList0.add(byteBuf0.nioBuffer(compositeByteBuf$Component0.idx(v), v4));
                        break;
                    }
                    default: {
                        Collections.addAll(recyclableArrayList0, byteBuf0.nioBuffers(compositeByteBuf$Component0.idx(v), v4));
                        break;
                    }
                }
                v += v4;
                v1 -= v4;
            }
            return (ByteBuffer[])recyclableArrayList0.toArray(EmptyArrays.EMPTY_BYTE_BUFFERS);
        }
        finally {
            recyclableArrayList0.recycle();
        }
    }

    public int numComponents() {
        return this.componentCount;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0) {
        return this.readBytes(byteBuf0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0, int v) {
        return this.readBytes(byteBuf0, v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf0, int v, int v1) {
        return this.readBytes(byteBuf0, v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf readBytes(OutputStream outputStream0, int v) {
        return this.readBytes(outputStream0, v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer0) {
        return this.readBytes(byteBuffer0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf readBytes(byte[] arr_b) {
        return this.readBytes(arr_b);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf readBytes(byte[] arr_b, int v, int v1) {
        return this.readBytes(arr_b, v, v1);
    }

    public CompositeByteBuf readBytes(ByteBuf byteBuf0) {
        super.readBytes(byteBuf0, byteBuf0.writableBytes());
        return this;
    }

    public CompositeByteBuf readBytes(ByteBuf byteBuf0, int v) {
        super.readBytes(byteBuf0, v);
        return this;
    }

    public CompositeByteBuf readBytes(ByteBuf byteBuf0, int v, int v1) {
        super.readBytes(byteBuf0, v, v1);
        return this;
    }

    public CompositeByteBuf readBytes(OutputStream outputStream0, int v) {
        super.readBytes(outputStream0, v);
        return this;
    }

    public CompositeByteBuf readBytes(ByteBuffer byteBuffer0) {
        super.readBytes(byteBuffer0);
        return this;
    }

    public CompositeByteBuf readBytes(byte[] arr_b) {
        super.readBytes(arr_b, 0, arr_b.length);
        return this;
    }

    public CompositeByteBuf readBytes(byte[] arr_b, int v, int v1) {
        super.readBytes(arr_b, v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf readerIndex(int v) {
        return this.readerIndex(v);
    }

    public CompositeByteBuf readerIndex(int v) {
        super.readerIndex(v);
        return this;
    }

    private void removeComp(int v) {
        this.removeCompRange(v, v + 1);
    }

    private void removeCompRange(int v, int v1) {
        if(v >= v1) {
            return;
        }
        int v2 = this.componentCount;
        if(v1 < v2) {
            System.arraycopy(this.components, v1, this.components, v, v2 - v1);
        }
        int v3 = v2 - v1 + v;
        for(int v4 = v3; v4 < v2; ++v4) {
            this.components[v4] = null;
        }
        this.componentCount = v3;
    }

    public CompositeByteBuf removeComponent(int v) {
        this.checkComponentIndex(v);
        Component compositeByteBuf$Component0 = this.components[v];
        if(this.lastAccessed == compositeByteBuf$Component0) {
            this.lastAccessed = null;
        }
        compositeByteBuf$Component0.free();
        this.removeComp(v);
        if(compositeByteBuf$Component0.length() > 0) {
            this.updateComponentOffsets(v);
        }
        return this;
    }

    public CompositeByteBuf removeComponents(int v, int v1) {
        this.checkComponentIndex(v, v1);
        if(v1 != 0) {
            int v2 = v1 + v;
            boolean z = false;
            for(int v3 = v; v3 < v2; ++v3) {
                Component compositeByteBuf$Component0 = this.components[v3];
                if(compositeByteBuf$Component0.length() > 0) {
                    z = true;
                }
                if(this.lastAccessed == compositeByteBuf$Component0) {
                    this.lastAccessed = null;
                }
                compositeByteBuf$Component0.free();
            }
            this.removeCompRange(v, v2);
            if(z) {
                this.updateComponentOffsets(v);
            }
        }
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf resetReaderIndex() {
        return this.resetReaderIndex();
    }

    public CompositeByteBuf resetReaderIndex() {
        super.resetReaderIndex();
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf resetWriterIndex() {
        return this.resetWriterIndex();
    }

    public CompositeByteBuf resetWriterIndex() {
        super.resetWriterIndex();
        return this;
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public ByteBuf retain() {
        return this.retain();
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public ByteBuf retain(int v) {
        return this.retain(v);
    }

    public CompositeByteBuf retain() {
        super.retain();
        return this;
    }

    public CompositeByteBuf retain(int v) {
        super.retain(v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public ReferenceCounted retain() {
        return this.retain();
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public ReferenceCounted retain(int v) {
        return this.retain(v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setBoolean(int v, boolean z) {
        return this.setBoolean(v, z);
    }

    public CompositeByteBuf setBoolean(int v, boolean z) {
        return this.setByte(v, ((int)z));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setByte(int v, int v1) {
        return this.setByte(v, v1);
    }

    public CompositeByteBuf setByte(int v, int v1) {
        Component compositeByteBuf$Component0 = this.findComponent(v);
        compositeByteBuf$Component0.buf.setByte(compositeByteBuf$Component0.idx(v), v1);
        return this;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, InputStream inputStream0, int v1) {
        this.checkIndex(v, v1);
        if(v1 == 0) {
            return inputStream0.read(EmptyArrays.EMPTY_BYTES);
        }
        int v2 = this.toComponentIndex0(v);
        int v3 = 0;
        do {
            Component compositeByteBuf$Component0 = this.components[v2];
            int v4 = Math.min(v1, compositeByteBuf$Component0.endOffset - v);
            if(v4 == 0) {
                ++v2;
            }
            else {
                int v5 = compositeByteBuf$Component0.buf.setBytes(compositeByteBuf$Component0.idx(v), inputStream0, v4);
                if(v5 < 0) {
                    return v3 == 0 ? -1 : v3;
                }
                v += v5;
                v1 -= v5;
                v3 += v5;
                if(v5 == v4) {
                    ++v2;
                }
            }
        }
        while(v1 > 0);
        return v3;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, FileChannel fileChannel0, long v1, int v2) {
        this.checkIndex(v, v2);
        if(v2 == 0) {
            return fileChannel0.read(CompositeByteBuf.EMPTY_NIO_BUFFER, v1);
        }
        int v3 = this.toComponentIndex0(v);
        int v4 = 0;
        while(true) {
            Component compositeByteBuf$Component0 = this.components[v3];
            int v5 = Math.min(v2, compositeByteBuf$Component0.endOffset - v);
            if(v5 == 0) {
                ++v3;
            }
            else {
                int v6 = compositeByteBuf$Component0.buf.setBytes(compositeByteBuf$Component0.idx(v), fileChannel0, v1 + ((long)v4), v5);
                if(v6 == 0) {
                    break;
                }
                if(v6 < 0) {
                    return v4 == 0 ? -1 : v4;
                }
                v += v6;
                v2 -= v6;
                v4 += v6;
                if(v6 == v5) {
                    ++v3;
                }
            }
            if(v2 <= 0) {
                return v4;
            }
        }
        return v4;
    }

    @Override  // io.netty.buffer.ByteBuf
    public int setBytes(int v, ScatteringByteChannel scatteringByteChannel0, int v1) {
        this.checkIndex(v, v1);
        if(v1 == 0) {
            return scatteringByteChannel0.read(CompositeByteBuf.EMPTY_NIO_BUFFER);
        }
        int v2 = this.toComponentIndex0(v);
        int v3 = 0;
        while(true) {
            Component compositeByteBuf$Component0 = this.components[v2];
            int v4 = Math.min(v1, compositeByteBuf$Component0.endOffset - v);
            if(v4 == 0) {
                ++v2;
            }
            else {
                int v5 = compositeByteBuf$Component0.buf.setBytes(compositeByteBuf$Component0.idx(v), scatteringByteChannel0, v4);
                if(v5 == 0) {
                    break;
                }
                if(v5 < 0) {
                    return v3 == 0 ? -1 : v3;
                }
                v += v5;
                v1 -= v5;
                v3 += v5;
                if(v5 == v4) {
                    ++v2;
                }
            }
            if(v1 <= 0) {
                return v3;
            }
        }
        return v3;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0) {
        return this.setBytes(v, byteBuf0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1) {
        return this.setBytes(v, byteBuf0, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        return this.setBytes(v, byteBuf0, v1, v2);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        return this.setBytes(v, byteBuffer0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b) {
        return this.setBytes(v, arr_b);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        return this.setBytes(v, arr_b, v1, v2);
    }

    public CompositeByteBuf setBytes(int v, ByteBuf byteBuf0) {
        super.setBytes(v, byteBuf0, byteBuf0.readableBytes());
        return this;
    }

    public CompositeByteBuf setBytes(int v, ByteBuf byteBuf0, int v1) {
        super.setBytes(v, byteBuf0, v1);
        return this;
    }

    public CompositeByteBuf setBytes(int v, ByteBuf byteBuf0, int v1, int v2) {
        this.checkSrcIndex(v, v2, v1, byteBuf0.capacity());
        if(v2 != 0) {
            for(int v3 = this.toComponentIndex0(v); v2 > 0; ++v3) {
                Component compositeByteBuf$Component0 = this.components[v3];
                int v4 = Math.min(v2, compositeByteBuf$Component0.endOffset - v);
                compositeByteBuf$Component0.buf.setBytes(compositeByteBuf$Component0.idx(v), byteBuf0, v1, v4);
                v += v4;
                v1 += v4;
                v2 -= v4;
            }
        }
        return this;
    }

    public CompositeByteBuf setBytes(int v, ByteBuffer byteBuffer0) {
        int v1 = byteBuffer0.limit();
        int v2 = byteBuffer0.remaining();
        this.checkIndex(v, v2);
        if(v2 == 0) {
            return this;
        }
        int v3 = this.toComponentIndex0(v);
        try {
            while(v2 > 0) {
                Component compositeByteBuf$Component0 = this.components[v3];
                int v5 = Math.min(v2, compositeByteBuf$Component0.endOffset - v);
                byteBuffer0.limit(byteBuffer0.position() + v5);
                compositeByteBuf$Component0.buf.setBytes(compositeByteBuf$Component0.idx(v), byteBuffer0);
                v += v5;
                v2 -= v5;
                ++v3;
            }
            return this;
        }
        finally {
            byteBuffer0.limit(v1);
        }
    }

    public CompositeByteBuf setBytes(int v, byte[] arr_b) {
        return this.setBytes(v, arr_b, 0, arr_b.length);
    }

    public CompositeByteBuf setBytes(int v, byte[] arr_b, int v1, int v2) {
        this.checkSrcIndex(v, v2, v1, arr_b.length);
        if(v2 != 0) {
            for(int v3 = this.toComponentIndex0(v); v2 > 0; ++v3) {
                Component compositeByteBuf$Component0 = this.components[v3];
                int v4 = Math.min(v2, compositeByteBuf$Component0.endOffset - v);
                compositeByteBuf$Component0.buf.setBytes(compositeByteBuf$Component0.idx(v), arr_b, v1, v4);
                v += v4;
                v1 += v4;
                v2 -= v4;
            }
        }
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setChar(int v, int v1) {
        return this.setChar(v, v1);
    }

    public CompositeByteBuf setChar(int v, int v1) {
        return this.setShort(v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setDouble(int v, double f) {
        return this.setDouble(v, f);
    }

    public CompositeByteBuf setDouble(int v, double f) {
        return this.setLong(v, Double.doubleToRawLongBits(f));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setFloat(int v, float f) {
        return this.setFloat(v, f);
    }

    public CompositeByteBuf setFloat(int v, float f) {
        return this.setInt(v, Float.floatToRawIntBits(f));
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setIndex(int v, int v1) {
        return this.setIndex(v, v1);
    }

    public CompositeByteBuf setIndex(int v, int v1) {
        super.setIndex(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setInt(int v, int v1) {
        return this.setInt(v, v1);
    }

    public CompositeByteBuf setInt(int v, int v1) {
        this.checkIndex(v, 4);
        this._setInt(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setLong(int v, long v1) {
        return this.setLong(v, v1);
    }

    public CompositeByteBuf setLong(int v, long v1) {
        this.checkIndex(v, 8);
        this._setLong(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setMedium(int v, int v1) {
        return this.setMedium(v, v1);
    }

    public CompositeByteBuf setMedium(int v, int v1) {
        this.checkIndex(v, 3);
        this._setMedium(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setShort(int v, int v1) {
        return this.setShort(v, v1);
    }

    public CompositeByteBuf setShort(int v, int v1) {
        this.checkIndex(v, 2);
        this._setShort(v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf setZero(int v, int v1) {
        return this.setZero(v, v1);
    }

    public CompositeByteBuf setZero(int v, int v1) {
        super.setZero(v, v1);
        return this;
    }

    private void shiftComps(int v, int v1) {
        Component[] arr_compositeByteBuf$Component1;
        int v2 = this.componentCount;
        int v3 = v2 + v1;
        Component[] arr_compositeByteBuf$Component = this.components;
        if(v3 > arr_compositeByteBuf$Component.length) {
            int v4 = Math.max((v2 >> 1) + v2, v3);
            if(v == v2) {
                arr_compositeByteBuf$Component1 = (Component[])Arrays.copyOf(this.components, v4, Component[].class);
            }
            else {
                Component[] arr_compositeByteBuf$Component2 = new Component[v4];
                if(v > 0) {
                    System.arraycopy(this.components, 0, arr_compositeByteBuf$Component2, 0, v);
                }
                if(v < v2) {
                    System.arraycopy(this.components, v, arr_compositeByteBuf$Component2, v1 + v, v2 - v);
                }
                arr_compositeByteBuf$Component1 = arr_compositeByteBuf$Component2;
            }
            this.components = arr_compositeByteBuf$Component1;
        }
        else if(v < v2) {
            System.arraycopy(arr_compositeByteBuf$Component, v, arr_compositeByteBuf$Component, v1 + v, v2 - v);
        }
        this.componentCount = v3;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf skipBytes(int v) {
        return this.skipBytes(v);
    }

    public CompositeByteBuf skipBytes(int v) {
        super.skipBytes(v);
        return this;
    }

    public int toByteIndex(int v) {
        this.checkComponentIndex(v);
        return this.components[v].offset;
    }

    public int toComponentIndex(int v) {
        this.checkIndex(v);
        return this.toComponentIndex0(v);
    }

    private int toComponentIndex0(int v) {
        int v1 = this.componentCount;
        int v2 = 0;
        if(v == 0) {
            for(int v3 = 0; v3 < v1; ++v3) {
                if(this.components[v3].endOffset > 0) {
                    return v3;
                }
            }
        }
        if(v1 <= 2) {
            return v1 == 1 || v < this.components[0].endOffset ? 0 : 1;
        }
        while(v2 <= v1) {
            int v4 = v2 + v1 >>> 1;
            Component compositeByteBuf$Component0 = this.components[v4];
            if(v >= compositeByteBuf$Component0.endOffset) {
                v2 = v4 + 1;
                continue;
            }
            if(v < compositeByteBuf$Component0.offset) {
                v1 = v4 - 1;
                continue;
            }
            return v4;
        }
        throw new Error("should not reach here");
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public String toString() {
        return o.q(x.p(b.d(1, 0, super.toString()), ", components="), this.componentCount, ')');
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public ByteBuf touch() {
        return this.touch();
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public ByteBuf touch(Object object0) {
        return this.touch(object0);
    }

    public CompositeByteBuf touch() {
        return this;
    }

    public CompositeByteBuf touch(Object object0) {
        return this;
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public ReferenceCounted touch() {
        return this.touch();
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public ReferenceCounted touch(Object object0) {
        return this.touch(object0);
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    private void updateComponentOffsets(int v) {
        int v1 = this.componentCount;
        if(v1 > v) {
            int v2 = v <= 0 ? 0 : this.components[v - 1].endOffset;
            while(v < v1) {
                Component compositeByteBuf$Component0 = this.components[v];
                compositeByteBuf$Component0.reposition(v2);
                v2 = compositeByteBuf$Component0.endOffset;
                ++v;
            }
        }
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeBoolean(boolean z) {
        return this.writeBoolean(z);
    }

    public CompositeByteBuf writeBoolean(boolean z) {
        this.writeByte(((int)z));
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeByte(int v) {
        return this.writeByte(v);
    }

    public CompositeByteBuf writeByte(int v) {
        this.ensureWritable0(1);
        int v1 = this.writerIndex;
        this.writerIndex = v1 + 1;
        this._setByte(v1, v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0) {
        return this.writeBytes(byteBuf0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0, int v) {
        return this.writeBytes(byteBuf0, v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf0, int v, int v1) {
        return this.writeBytes(byteBuf0, v, v1);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer0) {
        return this.writeBytes(byteBuffer0);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeBytes(byte[] arr_b) {
        return this.writeBytes(arr_b);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeBytes(byte[] arr_b, int v, int v1) {
        return this.writeBytes(arr_b, v, v1);
    }

    public CompositeByteBuf writeBytes(ByteBuf byteBuf0) {
        super.writeBytes(byteBuf0, byteBuf0.readableBytes());
        return this;
    }

    public CompositeByteBuf writeBytes(ByteBuf byteBuf0, int v) {
        super.writeBytes(byteBuf0, v);
        return this;
    }

    public CompositeByteBuf writeBytes(ByteBuf byteBuf0, int v, int v1) {
        super.writeBytes(byteBuf0, v, v1);
        return this;
    }

    public CompositeByteBuf writeBytes(ByteBuffer byteBuffer0) {
        super.writeBytes(byteBuffer0);
        return this;
    }

    public CompositeByteBuf writeBytes(byte[] arr_b) {
        super.writeBytes(arr_b, 0, arr_b.length);
        return this;
    }

    public CompositeByteBuf writeBytes(byte[] arr_b, int v, int v1) {
        super.writeBytes(arr_b, v, v1);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeChar(int v) {
        return this.writeChar(v);
    }

    public CompositeByteBuf writeChar(int v) {
        super.writeShort(v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeDouble(double f) {
        return this.writeDouble(f);
    }

    public CompositeByteBuf writeDouble(double f) {
        super.writeLong(Double.doubleToRawLongBits(f));
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeFloat(float f) {
        return this.writeFloat(f);
    }

    public CompositeByteBuf writeFloat(float f) {
        super.writeInt(Float.floatToRawIntBits(f));
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeInt(int v) {
        return this.writeInt(v);
    }

    public CompositeByteBuf writeInt(int v) {
        super.writeInt(v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeLong(long v) {
        return this.writeLong(v);
    }

    public CompositeByteBuf writeLong(long v) {
        super.writeLong(v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeMedium(int v) {
        return this.writeMedium(v);
    }

    public CompositeByteBuf writeMedium(int v) {
        super.writeMedium(v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeShort(int v) {
        return this.writeShort(v);
    }

    public CompositeByteBuf writeShort(int v) {
        super.writeShort(v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writeZero(int v) {
        return this.writeZero(v);
    }

    public CompositeByteBuf writeZero(int v) {
        super.writeZero(v);
        return this;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf writerIndex(int v) {
        return this.writerIndex(v);
    }

    public CompositeByteBuf writerIndex(int v) {
        super.writerIndex(v);
        return this;
    }
}

