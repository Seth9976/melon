package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.H;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001A\u00020\u00042\b\b\u0002\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\n\u0010\u000BJ)\u0010\u0012\u001A\u00020\u00112\n\u0010\u000E\u001A\u00060\fj\u0002`\r2\u000E\u0010\u0010\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000F\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u0014\u0010\u0006J\u0015\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0016\u001A\u00020\u0015\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001A\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u001D\u0010\u001C\u001A\u0004\u0018\u00010\u00042\n\u0010\u000E\u001A\u00060\fj\u0002`\rH\u0002\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0019\u0010\u001F\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u001E\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\u001F\u0010 J!\u0010\"\u001A\u0004\u0018\u00010\u00042\u0006\u0010!\u001A\u00020\f2\u0006\u0010\u001E\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\"\u0010#J+\u0010$\u001A\u00020\u00112\n\u0010\u000E\u001A\u00060\fj\u0002`\r2\u000E\u0010\u0010\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000FH\u0002\u00A2\u0006\u0004\b$\u0010\u0013J\u0017\u0010&\u001A\u00020\b2\u0006\u0010%\u001A\u00020\u0015H\u0002\u00A2\u0006\u0004\b&\u0010\'J\u0011\u0010(\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b(\u0010\u0006J\u0015\u0010)\u001A\u00020\u0017*\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b)\u0010*R\u001C\u0010,\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040+8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00100\u001A\u00020\f8@X\u0080\u0004\u00A2\u0006\u0006\u001A\u0004\b.\u0010/R\u0014\u00102\u001A\u00020\f8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b1\u0010/R\u0013\u00104\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004038\u0002X\u0082\u0004R\u000B\u00106\u001A\u0002058\u0002X\u0082\u0004R\u000B\u00107\u001A\u0002058\u0002X\u0082\u0004R\u000B\u00108\u001A\u0002058\u0002X\u0082\u0004\u00A8\u00069"}, d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "", "Lkotlinx/coroutines/scheduling/StealingMode;", "stealingMode", "Lkotlin/jvm/internal/H;", "stolenTaskRef", "", "trySteal", "(ILkotlin/jvm/internal/H;)J", "pollBlocking", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "Lie/H;", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "stealWithExclusiveMode", "(I)Lkotlinx/coroutines/scheduling/Task;", "onlyBlocking", "pollWithExclusiveMode", "(Z)Lkotlinx/coroutines/scheduling/Task;", "index", "tryExtractFromTheMiddle", "(IZ)Lkotlinx/coroutines/scheduling/Task;", "tryStealLastScheduled", "queue", "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "pollBuffer", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "getSize$kotlinx_coroutines_core", "()I", "size", "getBufferSize", "bufferSize", "Lkotlinx/atomicfu/AtomicRef;", "lastScheduledTask", "Lkotlinx/atomicfu/AtomicInt;", "producerIndex", "consumerIndex", "blockingTasksInBuffer", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class WorkQueue {
    private volatile int blockingTasksInBuffer$volatile;
    private static final AtomicIntegerFieldUpdater blockingTasksInBuffer$volatile$FU;
    @NotNull
    private final AtomicReferenceArray buffer;
    private volatile int consumerIndex$volatile;
    private static final AtomicIntegerFieldUpdater consumerIndex$volatile$FU;
    private volatile Object lastScheduledTask$volatile;
    private static final AtomicReferenceFieldUpdater lastScheduledTask$volatile$FU;
    private volatile int producerIndex$volatile;
    private static final AtomicIntegerFieldUpdater producerIndex$volatile$FU;

    static {
        WorkQueue.lastScheduledTask$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask$volatile");
        WorkQueue.producerIndex$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex$volatile");
        WorkQueue.consumerIndex$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex$volatile");
        WorkQueue.blockingTasksInBuffer$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer$volatile");
    }

    public WorkQueue() {
        this.buffer = new AtomicReferenceArray(0x80);
    }

    @Nullable
    public final Task add(@NotNull Task task0, boolean z) {
        if(z) {
            return this.addLast(task0);
        }
        Task task1 = (Task)WorkQueue.lastScheduledTask$volatile$FU.getAndSet(this, task0);
        return task1 == null ? null : this.addLast(task1);
    }

    private final Task addLast(Task task0) {
        if(this.getBufferSize() == 0x7F) {
            return task0;
        }
        if(task0.taskContext) {
            WorkQueue.getBlockingTasksInBuffer$volatile$FU().incrementAndGet(this);
        }
        int v = WorkQueue.getProducerIndex$volatile$FU().get(this);
        while(this.buffer.get(v & 0x7F) != null) {
            Thread.yield();
        }
        this.buffer.lazySet(v & 0x7F, task0);
        WorkQueue.getProducerIndex$volatile$FU().incrementAndGet(this);
        return null;
    }

    private final void decrementIfBlocking(Task task0) {
        if(task0 != null && task0.taskContext) {
            WorkQueue.blockingTasksInBuffer$volatile$FU.decrementAndGet(this);
        }
    }

    private final int getBufferSize() {
        return WorkQueue.getProducerIndex$volatile$FU().get(this) - WorkQueue.getConsumerIndex$volatile$FU().get(this);
    }

    public final int getSize$kotlinx_coroutines_core() {
        return WorkQueue.lastScheduledTask$volatile$FU.get(this) == null ? this.getBufferSize() : this.getBufferSize() + 1;
    }

    public final void offloadAllWorkTo(@NotNull GlobalQueue globalQueue0) {
        Task task0 = (Task)WorkQueue.lastScheduledTask$volatile$FU.getAndSet(this, null);
        if(task0 != null) {
            globalQueue0.addLast(task0);
        }
        while(this.pollTo(globalQueue0)) {
        }
    }

    @Nullable
    public final Task poll() {
        Task task0 = (Task)WorkQueue.lastScheduledTask$volatile$FU.getAndSet(this, null);
        return task0 == null ? this.pollBuffer() : task0;
    }

    @Nullable
    public final Task pollBlocking() {
        return this.pollWithExclusiveMode(true);
    }

    private final Task pollBuffer() {
        Task task0;
        int v;
        do {
            do {
                v = WorkQueue.consumerIndex$volatile$FU.get(this);
                if(v - WorkQueue.producerIndex$volatile$FU.get(this) == 0) {
                    return null;
                }
            }
            while(!WorkQueue.consumerIndex$volatile$FU.compareAndSet(this, v, v + 1));
            task0 = (Task)this.buffer.getAndSet(v & 0x7F, null);
        }
        while(task0 == null);
        this.decrementIfBlocking(task0);
        return task0;
    }

    private final boolean pollTo(GlobalQueue globalQueue0) {
        Task task0 = this.pollBuffer();
        if(task0 == null) {
            return false;
        }
        globalQueue0.addLast(task0);
        return true;
    }

    private final Task pollWithExclusiveMode(boolean z) {
        Task task1;
        while(true) {
            Task task0 = (Task)WorkQueue.lastScheduledTask$volatile$FU.get(this);
            if(task0 == null || task0.taskContext != z) {
                break;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = WorkQueue.lastScheduledTask$volatile$FU;
            do {
                if(atomicReferenceFieldUpdater0.compareAndSet(this, task0, null)) {
                    return task0;
                }
            }
            while(atomicReferenceFieldUpdater0.get(this) == task0);
        }
        int v = WorkQueue.consumerIndex$volatile$FU.get(this);
        int v1 = WorkQueue.producerIndex$volatile$FU.get(this);
        do {
            if(v == v1 || z && WorkQueue.blockingTasksInBuffer$volatile$FU.get(this) == 0) {
                return null;
            }
            --v1;
            task1 = this.tryExtractFromTheMiddle(v1, z);
        }
        while(task1 == null);
        return task1;
    }

    private final Task stealWithExclusiveMode(int v) {
        Task task0;
        int v1 = WorkQueue.consumerIndex$volatile$FU.get(this);
        int v2 = WorkQueue.producerIndex$volatile$FU.get(this);
        boolean z = true;
        if(v != 1) {
            z = false;
        }
        while(true) {
            if(v1 == v2 || z && WorkQueue.blockingTasksInBuffer$volatile$FU.get(this) == 0) {
                return null;
            }
            task0 = this.tryExtractFromTheMiddle(v1, z);
            if(task0 != null) {
                break;
            }
            ++v1;
        }
        return task0;
    }

    private final Task tryExtractFromTheMiddle(int v, boolean z) {
        Task task0 = (Task)this.buffer.get(v & 0x7F);
        if(task0 != null && task0.taskContext == z) {
            AtomicReferenceArray atomicReferenceArray0 = this.buffer;
            while(true) {
                if(atomicReferenceArray0.compareAndSet(v & 0x7F, task0, null)) {
                    if(z) {
                        WorkQueue.blockingTasksInBuffer$volatile$FU.decrementAndGet(this);
                    }
                    return task0;
                }
                if(atomicReferenceArray0.get(v & 0x7F) != task0) {
                    break;
                }
            }
        }
        return null;
    }

    public final long trySteal(int v, @NotNull H h0) {
        Task task0 = v == 3 ? this.pollBuffer() : this.stealWithExclusiveMode(v);
        if(task0 != null) {
            h0.a = task0;
            return -1L;
        }
        return this.tryStealLastScheduled(v, h0);
    }

    private final long tryStealLastScheduled(int v, H h0) {
        while(true) {
            Task task0 = (Task)WorkQueue.lastScheduledTask$volatile$FU.get(this);
            if(task0 == null) {
                return -2L;
            }
            if(((task0.taskContext ? 1 : 2) & v) == 0) {
                return -2L;
            }
            long v1 = TasksKt.schedulerTimeSource.nanoTime() - task0.submissionTime;
            long v2 = TasksKt.WORK_STEALING_TIME_RESOLUTION_NS;
            if(v1 < v2) {
                return v2 - v1;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = WorkQueue.lastScheduledTask$volatile$FU;
            do {
                if(atomicReferenceFieldUpdater0.compareAndSet(this, task0, null)) {
                    h0.a = task0;
                    return -1L;
                }
            }
            while(atomicReferenceFieldUpdater0.get(this) == task0);
        }
    }
}

