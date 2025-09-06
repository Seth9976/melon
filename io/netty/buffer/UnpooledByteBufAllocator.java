package io.netty.buffer;

import io.netty.util.internal.LongCounter;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.nio.ByteBuffer;

public final class UnpooledByteBufAllocator extends AbstractByteBufAllocator implements ByteBufAllocatorMetricProvider {
    static final class InstrumentedUnpooledDirectByteBuf extends UnpooledDirectByteBuf {
        public InstrumentedUnpooledDirectByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator0, int v, int v1) {
            super(unpooledByteBufAllocator0, v, v1);
        }

        @Override  // io.netty.buffer.UnpooledDirectByteBuf
        public ByteBuffer allocateDirect(int v) {
            ByteBuffer byteBuffer0 = super.allocateDirect(v);
            ((UnpooledByteBufAllocator)this.alloc()).incrementDirect(byteBuffer0.capacity());
            return byteBuffer0;
        }

        @Override  // io.netty.buffer.UnpooledDirectByteBuf
        public void freeDirect(ByteBuffer byteBuffer0) {
            super.freeDirect(byteBuffer0);
            ((UnpooledByteBufAllocator)this.alloc()).decrementDirect(byteBuffer0.capacity());
        }
    }

    static final class InstrumentedUnpooledHeapByteBuf extends UnpooledHeapByteBuf {
        public InstrumentedUnpooledHeapByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator0, int v, int v1) {
            super(unpooledByteBufAllocator0, v, v1);
        }

        @Override  // io.netty.buffer.UnpooledHeapByteBuf
        public byte[] allocateArray(int v) {
            byte[] arr_b = super.allocateArray(v);
            ((UnpooledByteBufAllocator)this.alloc()).incrementHeap(arr_b.length);
            return arr_b;
        }

        @Override  // io.netty.buffer.UnpooledHeapByteBuf
        public void freeArray(byte[] arr_b) {
            super.freeArray(arr_b);
            ((UnpooledByteBufAllocator)this.alloc()).decrementHeap(arr_b.length);
        }
    }

    static final class InstrumentedUnpooledUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
        public InstrumentedUnpooledUnsafeDirectByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator0, int v, int v1) {
            super(unpooledByteBufAllocator0, v, v1);
        }

        @Override  // io.netty.buffer.UnpooledDirectByteBuf
        public ByteBuffer allocateDirect(int v) {
            ByteBuffer byteBuffer0 = super.allocateDirect(v);
            ((UnpooledByteBufAllocator)this.alloc()).incrementDirect(byteBuffer0.capacity());
            return byteBuffer0;
        }

        @Override  // io.netty.buffer.UnpooledDirectByteBuf
        public void freeDirect(ByteBuffer byteBuffer0) {
            super.freeDirect(byteBuffer0);
            ((UnpooledByteBufAllocator)this.alloc()).decrementDirect(byteBuffer0.capacity());
        }
    }

    static final class InstrumentedUnpooledUnsafeHeapByteBuf extends UnpooledUnsafeHeapByteBuf {
        public InstrumentedUnpooledUnsafeHeapByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator0, int v, int v1) {
            super(unpooledByteBufAllocator0, v, v1);
        }

        @Override  // io.netty.buffer.UnpooledUnsafeHeapByteBuf
        public byte[] allocateArray(int v) {
            byte[] arr_b = super.allocateArray(v);
            ((UnpooledByteBufAllocator)this.alloc()).incrementHeap(arr_b.length);
            return arr_b;
        }

        @Override  // io.netty.buffer.UnpooledHeapByteBuf
        public void freeArray(byte[] arr_b) {
            super.freeArray(arr_b);
            ((UnpooledByteBufAllocator)this.alloc()).decrementHeap(arr_b.length);
        }
    }

    static final class InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf extends UnpooledUnsafeNoCleanerDirectByteBuf {
        public InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf(UnpooledByteBufAllocator unpooledByteBufAllocator0, int v, int v1) {
            super(unpooledByteBufAllocator0, v, v1);
        }

        @Override  // io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf
        public ByteBuffer allocateDirect(int v) {
            ByteBuffer byteBuffer0 = super.allocateDirect(v);
            ((UnpooledByteBufAllocator)this.alloc()).incrementDirect(byteBuffer0.capacity());
            return byteBuffer0;
        }

        @Override  // io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf
        public void freeDirect(ByteBuffer byteBuffer0) {
            super.freeDirect(byteBuffer0);
            ((UnpooledByteBufAllocator)this.alloc()).decrementDirect(byteBuffer0.capacity());
        }

        @Override  // io.netty.buffer.UnpooledUnsafeNoCleanerDirectByteBuf
        public ByteBuffer reallocateDirect(ByteBuffer byteBuffer0, int v) {
            ByteBuffer byteBuffer1 = super.reallocateDirect(byteBuffer0, v);
            ((UnpooledByteBufAllocator)this.alloc()).incrementDirect(byteBuffer1.capacity() - byteBuffer0.capacity());
            return byteBuffer1;
        }
    }

    static final class UnpooledByteBufAllocatorMetric implements ByteBufAllocatorMetric {
        final LongCounter directCounter;
        final LongCounter heapCounter;

        private UnpooledByteBufAllocatorMetric() {
            this.directCounter = PlatformDependent.newLongCounter();
            this.heapCounter = PlatformDependent.newLongCounter();
        }

        public UnpooledByteBufAllocatorMetric(io.netty.buffer.UnpooledByteBufAllocator.1 unpooledByteBufAllocator$10) {
        }

        @Override
        public String toString() {
            return StringUtil.simpleClassName(this) + "(usedHeapMemory: " + this.usedHeapMemory() + "; usedDirectMemory: " + this.usedDirectMemory() + ')';
        }

        @Override  // io.netty.buffer.ByteBufAllocatorMetric
        public long usedDirectMemory() {
            return this.directCounter.value();
        }

        @Override  // io.netty.buffer.ByteBufAllocatorMetric
        public long usedHeapMemory() {
            return this.heapCounter.value();
        }
    }

    public static final UnpooledByteBufAllocator DEFAULT;
    private final boolean disableLeakDetector;
    private final UnpooledByteBufAllocatorMetric metric;
    private final boolean noCleaner;

    static {
        UnpooledByteBufAllocator.DEFAULT = new UnpooledByteBufAllocator(false);
    }

    public UnpooledByteBufAllocator(boolean z) {
        this(z, false);
    }

    public UnpooledByteBufAllocator(boolean z, boolean z1) {
        this(z, z1, PlatformDependent.useDirectBufferNoCleaner());
    }

    public UnpooledByteBufAllocator(boolean z, boolean z1, boolean z2) {
        super(z);
        this.metric = new UnpooledByteBufAllocatorMetric(null);
        this.disableLeakDetector = z1;
        this.noCleaner = false;
    }

    @Override  // io.netty.buffer.AbstractByteBufAllocator
    public CompositeByteBuf compositeDirectBuffer(int v) {
        CompositeByteBuf compositeByteBuf0 = new CompositeByteBuf(this, true, v);
        return this.disableLeakDetector ? compositeByteBuf0 : AbstractByteBufAllocator.toLeakAwareBuffer(compositeByteBuf0);
    }

    @Override  // io.netty.buffer.AbstractByteBufAllocator
    public CompositeByteBuf compositeHeapBuffer(int v) {
        CompositeByteBuf compositeByteBuf0 = new CompositeByteBuf(this, false, v);
        return this.disableLeakDetector ? compositeByteBuf0 : AbstractByteBufAllocator.toLeakAwareBuffer(compositeByteBuf0);
    }

    public void decrementDirect(int v) {
        this.metric.directCounter.add(((long)(-v)));
    }

    public void decrementHeap(int v) {
        this.metric.heapCounter.add(((long)(-v)));
    }

    public void incrementDirect(int v) {
        this.metric.directCounter.add(((long)v));
    }

    public void incrementHeap(int v) {
        this.metric.heapCounter.add(((long)v));
    }

    @Override  // io.netty.buffer.ByteBufAllocator
    public boolean isDirectBufferPooled() {
        return false;
    }

    @Override  // io.netty.buffer.ByteBufAllocatorMetricProvider
    public ByteBufAllocatorMetric metric() {
        return this.metric;
    }

    @Override  // io.netty.buffer.AbstractByteBufAllocator
    public ByteBuf newDirectBuffer(int v, int v1) {
        ByteBuf byteBuf0;
        if(this.noCleaner) {
            byteBuf0 = new InstrumentedUnpooledUnsafeNoCleanerDirectByteBuf(this, v, v1);
            return this.disableLeakDetector ? byteBuf0 : AbstractByteBufAllocator.toLeakAwareBuffer(byteBuf0);
        }
        byteBuf0 = new InstrumentedUnpooledUnsafeDirectByteBuf(this, v, v1);
        return this.disableLeakDetector ? byteBuf0 : AbstractByteBufAllocator.toLeakAwareBuffer(byteBuf0);
    }

    @Override  // io.netty.buffer.AbstractByteBufAllocator
    public ByteBuf newHeapBuffer(int v, int v1) {
        return PlatformDependent.hasUnsafe() ? new InstrumentedUnpooledUnsafeHeapByteBuf(this, v, v1) : new InstrumentedUnpooledHeapByteBuf(this, v, v1);
    }

    class io.netty.buffer.UnpooledByteBufAllocator.1 {
    }

}

