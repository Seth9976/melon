package io.netty.buffer;

import io.netty.util.Recycler.EnhancedHandle;
import io.netty.util.internal.ObjectPool.Handle;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

abstract class AbstractPooledDerivedByteBuf extends AbstractReferenceCountedByteBuf {
    static final class PooledNonRetainedDuplicateByteBuf extends UnpooledDuplicatedByteBuf {
        private final ByteBuf referenceCountDelegate;

        public PooledNonRetainedDuplicateByteBuf(ByteBuf byteBuf0, AbstractByteBuf abstractByteBuf0) {
            super(abstractByteBuf0);
            this.referenceCountDelegate = byteBuf0;
        }

        @Override  // io.netty.buffer.AbstractByteBuf
        public ByteBuf duplicate() {
            this.ensureAccessible();
            return new PooledNonRetainedDuplicateByteBuf(this.referenceCountDelegate, this);
        }

        @Override  // io.netty.buffer.AbstractDerivedByteBuf
        public boolean isAccessible0() {
            return this.referenceCountDelegate.isAccessible();
        }

        @Override  // io.netty.buffer.AbstractDerivedByteBuf
        public int refCnt0() {
            return this.referenceCountDelegate.refCnt();
        }

        @Override  // io.netty.buffer.AbstractDerivedByteBuf
        public boolean release0() {
            return this.referenceCountDelegate.release();
        }

        @Override  // io.netty.buffer.AbstractDerivedByteBuf
        public boolean release0(int v) {
            return this.referenceCountDelegate.release(v);
        }

        @Override  // io.netty.buffer.AbstractDerivedByteBuf
        public ByteBuf retain0() {
            this.referenceCountDelegate.retain();
            return this;
        }

        @Override  // io.netty.buffer.AbstractDerivedByteBuf
        public ByteBuf retain0(int v) {
            this.referenceCountDelegate.retain(v);
            return this;
        }

        @Override  // io.netty.buffer.AbstractByteBuf
        public ByteBuf retainedDuplicate() {
            return PooledDuplicatedByteBuf.newInstance(this.unwrap(), this, this.readerIndex(), this.writerIndex());
        }

        @Override  // io.netty.buffer.AbstractByteBuf
        public ByteBuf retainedSlice() {
            return this.retainedSlice(this.readerIndex(), this.capacity());
        }

        @Override  // io.netty.buffer.AbstractByteBuf
        public ByteBuf retainedSlice(int v, int v1) {
            return PooledSlicedByteBuf.newInstance(this.unwrap(), this, v, v1);
        }

        @Override  // io.netty.buffer.DuplicatedByteBuf
        public ByteBuf slice(int v, int v1) {
            this.checkIndex(v, v1);
            AbstractByteBuf abstractByteBuf0 = this.unwrap();
            return new PooledNonRetainedSlicedByteBuf(this.referenceCountDelegate, abstractByteBuf0, v, v1);
        }

        @Override  // io.netty.buffer.AbstractDerivedByteBuf
        public ByteBuf touch0() {
            this.referenceCountDelegate.touch();
            return this;
        }

        @Override  // io.netty.buffer.AbstractDerivedByteBuf
        public ByteBuf touch0(Object object0) {
            this.referenceCountDelegate.touch(object0);
            return this;
        }
    }

    static final class PooledNonRetainedSlicedByteBuf extends UnpooledSlicedByteBuf {
        private final ByteBuf referenceCountDelegate;

        public PooledNonRetainedSlicedByteBuf(ByteBuf byteBuf0, AbstractByteBuf abstractByteBuf0, int v, int v1) {
            super(abstractByteBuf0, v, v1);
            this.referenceCountDelegate = byteBuf0;
        }

        @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
        public ByteBuf duplicate() {
            this.ensureAccessible();
            AbstractByteBuf abstractByteBuf0 = this.unwrap();
            return new PooledNonRetainedDuplicateByteBuf(this.referenceCountDelegate, abstractByteBuf0).setIndex(this.idx(this.readerIndex()), this.idx(this.writerIndex()));
        }

        @Override  // io.netty.buffer.AbstractDerivedByteBuf
        public boolean isAccessible0() {
            return this.referenceCountDelegate.isAccessible();
        }

        @Override  // io.netty.buffer.AbstractDerivedByteBuf
        public int refCnt0() {
            return this.referenceCountDelegate.refCnt();
        }

        @Override  // io.netty.buffer.AbstractDerivedByteBuf
        public boolean release0() {
            return this.referenceCountDelegate.release();
        }

        @Override  // io.netty.buffer.AbstractDerivedByteBuf
        public boolean release0(int v) {
            return this.referenceCountDelegate.release(v);
        }

        @Override  // io.netty.buffer.AbstractDerivedByteBuf
        public ByteBuf retain0() {
            this.referenceCountDelegate.retain();
            return this;
        }

        @Override  // io.netty.buffer.AbstractDerivedByteBuf
        public ByteBuf retain0(int v) {
            this.referenceCountDelegate.retain(v);
            return this;
        }

        @Override  // io.netty.buffer.AbstractByteBuf
        public ByteBuf retainedDuplicate() {
            return PooledDuplicatedByteBuf.newInstance(this.unwrap(), this, this.idx(this.readerIndex()), this.idx(this.writerIndex()));
        }

        @Override  // io.netty.buffer.AbstractByteBuf
        public ByteBuf retainedSlice() {
            return this.retainedSlice(0, this.capacity());
        }

        @Override  // io.netty.buffer.AbstractByteBuf
        public ByteBuf retainedSlice(int v, int v1) {
            return PooledSlicedByteBuf.newInstance(this.unwrap(), this, this.idx(v), v1);
        }

        @Override  // io.netty.buffer.AbstractUnpooledSlicedByteBuf
        public ByteBuf slice(int v, int v1) {
            this.checkIndex(v, v1);
            AbstractByteBuf abstractByteBuf0 = this.unwrap();
            return new PooledNonRetainedSlicedByteBuf(this.referenceCountDelegate, abstractByteBuf0, this.idx(v), v1);
        }

        @Override  // io.netty.buffer.AbstractDerivedByteBuf
        public ByteBuf touch0() {
            this.referenceCountDelegate.touch();
            return this;
        }

        @Override  // io.netty.buffer.AbstractDerivedByteBuf
        public ByteBuf touch0(Object object0) {
            this.referenceCountDelegate.touch(object0);
            return this;
        }
    }

    static final boolean $assertionsDisabled;
    private ByteBuf parent;
    private final EnhancedHandle recyclerHandle;
    private AbstractByteBuf rootParent;

    public AbstractPooledDerivedByteBuf(Handle objectPool$Handle0) {
        super(0);
        this.recyclerHandle = (EnhancedHandle)objectPool$Handle0;
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return this.unwrap().alloc();
    }

    @Override  // io.netty.buffer.ByteBuf
    public byte[] array() {
        return this.unwrap().array();
    }

    @Override  // io.netty.buffer.AbstractReferenceCountedByteBuf
    public final void deallocate() {
        ByteBuf byteBuf0 = this.parent;
        this.recyclerHandle.unguardedRecycle(this);
        byteBuf0.release();
    }

    public final ByteBuf duplicate0() {
        this.ensureAccessible();
        return new PooledNonRetainedDuplicateByteBuf(this, this.unwrap());
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return this.unwrap().hasArray();
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return this.unwrap().hasMemoryAddress();
    }

    public final AbstractPooledDerivedByteBuf init(AbstractByteBuf abstractByteBuf0, ByteBuf byteBuf0, int v, int v1, int v2) {
        byteBuf0.retain();
        this.parent = byteBuf0;
        this.rootParent = abstractByteBuf0;
        try {
            this.maxCapacity(v2);
            this.setIndex0(v, v1);
            this.resetRefCnt();
            return this;
        }
        catch(Throwable throwable0) {
            this.rootParent = null;
            this.parent = null;
            byteBuf0.release();
            throw throwable0;
        }
    }

    @Override  // io.netty.buffer.ByteBuf
    public final ByteBuffer internalNioBuffer(int v, int v1) {
        return this.nioBuffer(v, v1);
    }

    @Override  // io.netty.buffer.ByteBuf
    public boolean isContiguous() {
        return this.unwrap().isContiguous();
    }

    @Override  // io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return this.unwrap().isDirect();
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public boolean isReadOnly() {
        return this.unwrap().isReadOnly();
    }

    @Override  // io.netty.buffer.ByteBuf
    public final int nioBufferCount() {
        return this.unwrap().nioBufferCount();
    }

    @Override  // io.netty.buffer.ByteBuf
    @Deprecated
    public final ByteOrder order() {
        return this.unwrap().order();
    }

    public final void parent(ByteBuf byteBuf0) {
        this.parent = byteBuf0;
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public final ByteBuf retainedSlice() {
        int v = this.readerIndex();
        return this.retainedSlice(v, this.writerIndex() - v);
    }

    @Override  // io.netty.buffer.AbstractByteBuf
    public ByteBuf slice(int v, int v1) {
        this.ensureAccessible();
        return new PooledNonRetainedSlicedByteBuf(this, this.unwrap(), v, v1);
    }

    public final AbstractByteBuf unwrap() {
        return this.rootParent;
    }

    @Override  // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return this.unwrap();
    }
}

