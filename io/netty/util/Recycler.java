package io.netty.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.ExitCondition;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Supplier;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.WaitStrategy;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jetbrains.annotations.VisibleForTesting;

public abstract class Recycler {
    static final class BlockingMessageQueue implements MessagePassingQueue {
        private final Queue deque;
        private final int maxCapacity;

        public BlockingMessageQueue(int v) {
            this.maxCapacity = v;
            this.deque = new ArrayDeque();
        }

        @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public int capacity() {
            return this.maxCapacity;
        }

        @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public void clear() {
            synchronized(this) {
                this.deque.clear();
            }
        }

        @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public int drain(Consumer messagePassingQueue$Consumer0) {
            throw new UnsupportedOperationException();
        }

        @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public int drain(Consumer messagePassingQueue$Consumer0, int v) {
            int v1;
            for(v1 = 0; v1 < v; ++v1) {
                Object object0 = this.poll();
                if(object0 == null) {
                    break;
                }
                messagePassingQueue$Consumer0.accept(object0);
            }
            return v1;
        }

        @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public void drain(Consumer messagePassingQueue$Consumer0, WaitStrategy messagePassingQueue$WaitStrategy0, ExitCondition messagePassingQueue$ExitCondition0) {
            throw new UnsupportedOperationException();
        }

        @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public int fill(Supplier messagePassingQueue$Supplier0) {
            throw new UnsupportedOperationException();
        }

        @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public int fill(Supplier messagePassingQueue$Supplier0, int v) {
            throw new UnsupportedOperationException();
        }

        @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public void fill(Supplier messagePassingQueue$Supplier0, WaitStrategy messagePassingQueue$WaitStrategy0, ExitCondition messagePassingQueue$ExitCondition0) {
            throw new UnsupportedOperationException();
        }

        @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public boolean isEmpty() {
            synchronized(this) {
            }
            return this.deque.isEmpty();
        }

        @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public boolean offer(Object object0) {
            synchronized(this) {
                return this.deque.size() == this.maxCapacity ? false : this.deque.offer(object0);
            }
        }

        @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public Object peek() {
            synchronized(this) {
                return this.deque.peek();
            }
        }

        @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public Object poll() {
            synchronized(this) {
                return this.deque.poll();
            }
        }

        @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public boolean relaxedOffer(Object object0) {
            return this.offer(object0);
        }

        @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public Object relaxedPeek() {
            return this.peek();
        }

        @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public Object relaxedPoll() {
            return this.poll();
        }

        @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
        public int size() {
            synchronized(this) {
            }
            return this.deque.size();
        }
    }

    static final class DefaultHandle extends EnhancedHandle {
        static final boolean $assertionsDisabled = false;
        private static final int STATE_AVAILABLE = 1;
        private static final int STATE_CLAIMED;
        private static final AtomicIntegerFieldUpdater STATE_UPDATER;
        private final LocalPool localPool;
        private volatile int state;
        private Object value;

        static {
            DefaultHandle.STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(DefaultHandle.class, "state");
        }

        public DefaultHandle(LocalPool recycler$LocalPool0) {
            super(null);
            this.localPool = recycler$LocalPool0;
        }

        public Object get() {
            return this.value;
        }

        @Override  // io.netty.util.internal.ObjectPool$Handle
        public void recycle(Object object0) {
            if(object0 != this.value) {
                throw new IllegalArgumentException("object does not belong to handle");
            }
            this.localPool.release(this, true);
        }

        public void set(Object object0) {
            this.value = object0;
        }

        public void toAvailable() {
            if(DefaultHandle.STATE_UPDATER.getAndSet(this, 1) == 1) {
                throw new IllegalStateException("Object has been recycled already.");
            }
        }

        public void toClaimed() {
            DefaultHandle.STATE_UPDATER.lazySet(this, 0);
        }

        @Override  // io.netty.util.Recycler$EnhancedHandle
        public void unguardedRecycle(Object object0) {
            if(object0 != this.value) {
                throw new IllegalArgumentException("object does not belong to handle");
            }
            this.localPool.release(this, false);
        }

        public void unguardedToAvailable() {
            if(this.state == 1) {
                throw new IllegalStateException("Object has been recycled already.");
            }
            DefaultHandle.STATE_UPDATER.lazySet(this, 1);
        }
    }

    public static abstract class EnhancedHandle implements Handle {
        private EnhancedHandle() {
        }

        public EnhancedHandle(io.netty.util.Recycler.1 recycler$10) {
        }

        public abstract void unguardedRecycle(Object arg1);
    }

    public interface Handle extends io.netty.util.internal.ObjectPool.Handle {
    }

    static final class LocalPool implements Consumer {
        private final ArrayDeque batch;
        private final int chunkSize;
        private volatile Thread owner;
        private volatile MessagePassingQueue pooledHandles;
        private int ratioCounter;
        private final int ratioInterval;

        public LocalPool(int v, int v1, int v2) {
            this.ratioInterval = v1;
            this.chunkSize = v2;
            this.batch = new ArrayDeque(v2);
            this.owner = Thread.currentThread();
            this.pooledHandles = (MessagePassingQueue)PlatformDependent.newMpscQueue(v2, v);
            this.ratioCounter = v1;
        }

        public void accept(DefaultHandle recycler$DefaultHandle0) {
            this.batch.addLast(recycler$DefaultHandle0);
        }

        @Override  // io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue$Consumer
        public void accept(Object object0) {
            this.accept(((DefaultHandle)object0));
        }

        public static MessagePassingQueue access$400(LocalPool recycler$LocalPool0) {
            return recycler$LocalPool0.pooledHandles;
        }

        public static MessagePassingQueue access$402(LocalPool recycler$LocalPool0, MessagePassingQueue messagePassingQueue0) {
            recycler$LocalPool0.pooledHandles = messagePassingQueue0;
            return messagePassingQueue0;
        }

        public static Thread access$502(LocalPool recycler$LocalPool0, Thread thread0) {
            recycler$LocalPool0.owner = thread0;
            return thread0;
        }

        public static ArrayDeque access$600(LocalPool recycler$LocalPool0) {
            return recycler$LocalPool0.batch;
        }

        public DefaultHandle claim() {
            MessagePassingQueue messagePassingQueue0 = this.pooledHandles;
            if(messagePassingQueue0 == null) {
                return null;
            }
            if(this.batch.isEmpty()) {
                messagePassingQueue0.drain(this, this.chunkSize);
            }
            DefaultHandle recycler$DefaultHandle0 = (DefaultHandle)this.batch.pollFirst();
            if(recycler$DefaultHandle0 != null) {
                recycler$DefaultHandle0.toClaimed();
            }
            return recycler$DefaultHandle0;
        }

        // 去混淆评级： 低(40)
        private static boolean isTerminated(Thread thread0) {
            return thread0.getState() == Thread.State.TERMINATED;
        }

        public DefaultHandle newHandle() {
            int v = this.ratioCounter + 1;
            this.ratioCounter = v;
            if(v >= this.ratioInterval) {
                this.ratioCounter = 0;
                return new DefaultHandle(this);
            }
            return null;
        }

        public void release(DefaultHandle recycler$DefaultHandle0, boolean z) {
            if(z) {
                recycler$DefaultHandle0.toAvailable();
            }
            else {
                recycler$DefaultHandle0.unguardedToAvailable();
            }
            Thread thread0 = this.owner;
            if(thread0 != null && Thread.currentThread() == thread0 && this.batch.size() < this.chunkSize) {
                this.accept(recycler$DefaultHandle0);
                return;
            }
            if(thread0 != null && LocalPool.isTerminated(thread0)) {
                this.owner = null;
                this.pooledHandles = null;
                return;
            }
            MessagePassingQueue messagePassingQueue0 = this.pooledHandles;
            if(messagePassingQueue0 != null) {
                messagePassingQueue0.relaxedOffer(recycler$DefaultHandle0);
            }
        }
    }

    private static final boolean BATCH_FAST_TL_ONLY = false;
    private static final boolean BLOCKING_POOL = false;
    private static final int DEFAULT_INITIAL_MAX_CAPACITY_PER_THREAD = 0x1000;
    private static final int DEFAULT_MAX_CAPACITY_PER_THREAD;
    private static final int DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD;
    private static final EnhancedHandle NOOP_HANDLE;
    private static final int RATIO;
    private final int chunkSize;
    private final int interval;
    private static final InternalLogger logger;
    private final int maxCapacityPerThread;
    private final FastThreadLocal threadLocal;

    static {
        InternalLogger internalLogger0 = InternalLoggerFactory.getInstance(Recycler.class);
        Recycler.logger = internalLogger0;
        Recycler.NOOP_HANDLE = new EnhancedHandle() {
            {
                super(null);
            }

            @Override  // io.netty.util.internal.ObjectPool$Handle
            public void recycle(Object object0) {
            }

            @Override
            public String toString() {
                return "NOOP_HANDLE";
            }

            @Override  // io.netty.util.Recycler$EnhancedHandle
            public void unguardedRecycle(Object object0) {
            }
        };
        int v = 0x1000;
        int v1 = SystemPropertyUtil.getInt("io.netty.recycler.maxCapacityPerThread", SystemPropertyUtil.getInt("io.netty.recycler.maxCapacity", 0x1000));
        if(v1 >= 0) {
            v = v1;
        }
        Recycler.DEFAULT_MAX_CAPACITY_PER_THREAD = v;
        int v2 = SystemPropertyUtil.getInt("io.netty.recycler.chunkSize", 0x20);
        Recycler.DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD = v2;
        int v3 = Math.max(0, SystemPropertyUtil.getInt("io.netty.recycler.ratio", 8));
        Recycler.RATIO = v3;
        boolean z = SystemPropertyUtil.getBoolean("io.netty.recycler.blocking", false);
        Recycler.BLOCKING_POOL = z;
        boolean z1 = SystemPropertyUtil.getBoolean("io.netty.recycler.batchFastThreadLocalOnly", true);
        Recycler.BATCH_FAST_TL_ONLY = z1;
        if(internalLogger0.isDebugEnabled()) {
            if(v == 0) {
                internalLogger0.debug("-Dio.netty.recycler.maxCapacityPerThread: disabled");
                internalLogger0.debug("-Dio.netty.recycler.ratio: disabled");
                internalLogger0.debug("-Dio.netty.recycler.chunkSize: disabled");
                internalLogger0.debug("-Dio.netty.recycler.blocking: disabled");
                internalLogger0.debug("-Dio.netty.recycler.batchFastThreadLocalOnly: disabled");
                return;
            }
            internalLogger0.debug("-Dio.netty.recycler.maxCapacityPerThread: {}", v);
            internalLogger0.debug("-Dio.netty.recycler.ratio: {}", v3);
            internalLogger0.debug("-Dio.netty.recycler.chunkSize: {}", v2);
            internalLogger0.debug("-Dio.netty.recycler.blocking: {}", Boolean.valueOf(z));
            internalLogger0.debug("-Dio.netty.recycler.batchFastThreadLocalOnly: {}", Boolean.valueOf(z1));
        }
    }

    public Recycler() {
        this(Recycler.DEFAULT_MAX_CAPACITY_PER_THREAD);
    }

    public Recycler(int v) {
        this(v, Recycler.RATIO, Recycler.DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    @Deprecated
    public Recycler(int v, int v1) {
        this(v, Recycler.RATIO, Recycler.DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    public Recycler(int v, int v1, int v2) {
        this.threadLocal = new FastThreadLocal() {
            public LocalPool initialValue() {
                return new LocalPool(Recycler.this.maxCapacityPerThread, Recycler.this.interval, Recycler.this.chunkSize);
            }

            @Override  // io.netty.util.concurrent.FastThreadLocal
            public Object initialValue() {
                return this.initialValue();
            }

            public void onRemoval(LocalPool recycler$LocalPool0) {
                super.onRemoval(recycler$LocalPool0);
                LocalPool.access$402(recycler$LocalPool0, null);
                LocalPool.access$502(recycler$LocalPool0, null);
                LocalPool.access$400(recycler$LocalPool0).clear();
            }

            @Override  // io.netty.util.concurrent.FastThreadLocal
            public void onRemoval(Object object0) {
                this.onRemoval(((LocalPool)object0));
            }
        };
        this.interval = Math.max(0, v1);
        if(v <= 0) {
            this.maxCapacityPerThread = 0;
            this.chunkSize = 0;
            return;
        }
        int v3 = Math.max(4, v);
        this.maxCapacityPerThread = v3;
        this.chunkSize = Math.max(2, Math.min(v2, v3 >> 1));
    }

    @Deprecated
    public Recycler(int v, int v1, int v2, int v3) {
        this(v, v2, Recycler.DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    @Deprecated
    public Recycler(int v, int v1, int v2, int v3, int v4) {
        this(v, v2, Recycler.DEFAULT_QUEUE_CHUNK_SIZE_PER_THREAD);
    }

    public static boolean access$700() [...] // 潜在的解密器

    public static boolean access$800() [...] // 潜在的解密器

    public final Object get() {
        if(this.maxCapacityPerThread == 0) {
            return this.newObject(Recycler.NOOP_HANDLE);
        }
        LocalPool recycler$LocalPool0 = (LocalPool)this.threadLocal.get();
        DefaultHandle recycler$DefaultHandle0 = recycler$LocalPool0.claim();
        if(recycler$DefaultHandle0 == null) {
            DefaultHandle recycler$DefaultHandle1 = recycler$LocalPool0.newHandle();
            if(recycler$DefaultHandle1 != null) {
                Object object0 = this.newObject(recycler$DefaultHandle1);
                recycler$DefaultHandle1.set(object0);
                return object0;
            }
            return this.newObject(Recycler.NOOP_HANDLE);
        }
        return recycler$DefaultHandle0.get();
    }

    public abstract Object newObject(Handle arg1);

    @Deprecated
    public final boolean recycle(Object object0, Handle recycler$Handle0) {
        if(recycler$Handle0 == Recycler.NOOP_HANDLE) {
            return false;
        }
        recycler$Handle0.recycle(object0);
        return true;
    }

    @VisibleForTesting
    public final int threadLocalSize() {
        LocalPool recycler$LocalPool0 = (LocalPool)this.threadLocal.getIfExists();
        return recycler$LocalPool0 == null ? 0 : LocalPool.access$600(recycler$LocalPool0).size() + LocalPool.access$400(recycler$LocalPool0).size();
    }
}

