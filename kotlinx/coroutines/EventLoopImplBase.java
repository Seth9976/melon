package kotlinx.coroutines;

import ie.H;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u00012\u00020\u0002:\u0004>?@AB\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0004J%\u0010\u000B\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00072\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00050\tH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ#\u0010\u0011\u001A\u00020\u00102\u0006\u0010\b\u001A\u00020\u00072\n\u0010\u000F\u001A\u00060\rj\u0002`\u000EH\u0004\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001A\u00020\u00052\u0006\u0010\u0016\u001A\u00020\u00152\n\u0010\u000F\u001A\u00060\rj\u0002`\u000E\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u001B\u0010\u001A\u001A\u00020\u00052\n\u0010\u0019\u001A\u00060\rj\u0002`\u000EH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u001D\u0010\u001F\u001A\u00020\u00052\u0006\u0010\u001C\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u001D\u00A2\u0006\u0004\b\u001F\u0010 J\u000F\u0010!\u001A\u00020\u0005H\u0004\u00A2\u0006\u0004\b!\u0010\u0004J\u001B\u0010#\u001A\u00020\"2\n\u0010\u0019\u001A\u00060\rj\u0002`\u000EH\u0002\u00A2\u0006\u0004\b#\u0010$J\u0017\u0010%\u001A\n\u0018\u00010\rj\u0004\u0018\u0001`\u000EH\u0002\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010\'\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b\'\u0010\u0004J\u000F\u0010(\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b(\u0010\u0004J\u0017\u0010)\u001A\u00020\"2\u0006\u0010\u0019\u001A\u00020\u001DH\u0002\u00A2\u0006\u0004\b)\u0010*J\u001F\u0010,\u001A\u00020+2\u0006\u0010\u001C\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u001DH\u0002\u00A2\u0006\u0004\b,\u0010-J\u000F\u0010.\u001A\u00020\u0005H\u0002\u00A2\u0006\u0004\b.\u0010\u0004R\u0014\u0010/\u001A\u00020\"8TX\u0094\u0004\u00A2\u0006\u0006\u001A\u0004\b/\u00100R\u0014\u00102\u001A\u00020\u00078TX\u0094\u0004\u00A2\u0006\u0006\u001A\u0004\b1\u0010\u0014R$\u00104\u001A\u00020\"2\u0006\u00103\u001A\u00020\"8B@BX\u0082\u000E\u00A2\u0006\f\u001A\u0004\b4\u00100\"\u0004\b5\u00106R\u0013\u00109\u001A\n\u0012\u0006\u0012\u0004\u0018\u000108078\u0002X\u0082\u0004R\u0013\u0010;\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010:078\u0002X\u0082\u0004R\u000B\u0010=\u001A\u00020<8\u0002X\u0082\u0004\u00A8\u0006B"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;", "<init>", "()V", "Lie/H;", "shutdown", "", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "processNextEvent", "()J", "Lme/i;", "context", "dispatch", "(Lme/i;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "resetAll", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "dequeue", "()Ljava/lang/Runnable;", "enqueueDelayedTasks", "closeQueue", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "rescheduleAllDelayed", "isEmpty", "()Z", "getNextTime", "nextTime", "value", "isCompleted", "setCompleted", "(Z)V", "Lkotlinx/atomicfu/AtomicRef;", "", "_queue", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "_delayed", "Lkotlinx/atomicfu/AtomicBoolean;", "_isCompleted", "DelayedTask", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTaskQueue", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\rR\u001A\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000E¨\u0006\u000F"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "", "nanoTime", "Lkotlinx/coroutines/CancellableContinuation;", "Lie/H;", "cont", "<init>", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "()V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CancellableContinuation;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    final class DelayedResumeTask extends DelayedTask {
        @NotNull
        private final CancellableContinuation cont;

        public DelayedResumeTask(long v, @NotNull CancellableContinuation cancellableContinuation0) {
            super(v);
            this.cont = cancellableContinuation0;
        }

        @Override
        public void run() {
            this.cont.resumeUndispatched(EventLoopImplBase.this, H.a);
        }

        @Override  // kotlinx.coroutines.EventLoopImplBase$DelayedTask
        @NotNull
        public String toString() {
            return super.toString() + this.cont;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001B\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\u0010\u0006\u001A\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u0018\u0010\u0006\u001A\u00060\u0004j\u0002`\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000F¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "", "nanoTime", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "<init>", "(JLjava/lang/Runnable;)V", "Lie/H;", "run", "()V", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Runnable;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    static final class DelayedRunnableTask extends DelayedTask {
        @NotNull
        private final Runnable block;

        public DelayedRunnableTask(long v, @NotNull Runnable runnable0) {
            super(v);
            this.block = runnable0;
        }

        @Override
        public void run() {
            this.block.run();
        }

        @Override  // kotlinx.coroutines.EventLoopImplBase$DelayedTask
        @NotNull
        public String toString() {
            return super.toString() + this.block;
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u00052\u00060\u0006j\u0002`\u0007B\u000F\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\u0018\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ\u0015\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0018\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\b2\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001B\u001A\u00020\u001A¢\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001E\u001A\u00020\u001DH\u0016¢\u0006\u0004\b\u001E\u0010\u001FR\u0016\u0010\t\u001A\u00020\b8\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\t\u0010 R\u0018\u0010!\u001A\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010#\u001A\u00020\r8\u0016@\u0016X\u0096\u000E¢\u0006\u0012\n\u0004\b#\u0010$\u001A\u0004\b%\u0010&\"\u0004\b\'\u0010(R0\u0010/\u001A\b\u0012\u0002\b\u0003\u0018\u00010)2\f\u0010*\u001A\b\u0012\u0002\b\u0003\u0018\u00010)8V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00060"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "", "nanoTime", "<init>", "(J)V", "other", "", "compareTo", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "now", "", "timeToExecute", "(J)Z", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "delayed", "Lkotlinx/coroutines/EventLoopImplBase;", "eventLoop", "scheduleTask", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;Lkotlinx/coroutines/EventLoopImplBase;)I", "Lie/H;", "dispose", "()V", "", "toString", "()Ljava/lang/String;", "J", "_heap", "Ljava/lang/Object;", "index", "I", "getIndex", "()I", "setIndex", "(I)V", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "value", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "heap", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static abstract class DelayedTask implements Comparable, Runnable, DisposableHandle, ThreadSafeHeapNode {
        @Nullable
        private volatile Object _heap;
        private int index;
        public long nanoTime;

        public DelayedTask(long v) {
            this.nanoTime = v;
            this.index = -1;
        }

        @Override
        public int compareTo(Object object0) {
            return this.compareTo(((DelayedTask)object0));
        }

        public int compareTo(@NotNull DelayedTask eventLoopImplBase$DelayedTask0) {
            int v = Long.compare(this.nanoTime - eventLoopImplBase$DelayedTask0.nanoTime, 0L);
            if(v > 0) {
                return 1;
            }
            return v >= 0 ? 0 : -1;
        }

        @Override  // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            __monitor_enter(this);
            try {
                Object object0 = this._heap;
                if(object0 != EventLoop_commonKt.access$getDISPOSED_TASK$p()) {
                    DelayedTaskQueue eventLoopImplBase$DelayedTaskQueue0 = object0 instanceof DelayedTaskQueue ? ((DelayedTaskQueue)object0) : null;
                    if(eventLoopImplBase$DelayedTaskQueue0 != null) {
                        eventLoopImplBase$DelayedTaskQueue0.remove(this);
                    }
                    this._heap = EventLoop_commonKt.access$getDISPOSED_TASK$p();
                    goto label_11;
                }
                goto label_13;
            }
            catch(Throwable throwable0) {
            }
            __monitor_exit(this);
            throw throwable0;
        label_11:
            __monitor_exit(this);
            return;
        label_13:
            __monitor_exit(this);
        }

        // 去混淆评级： 低(20)
        @Override  // kotlinx.coroutines.internal.ThreadSafeHeapNode
        @Nullable
        public ThreadSafeHeap getHeap() {
            return this._heap instanceof ThreadSafeHeap ? ((ThreadSafeHeap)this._heap) : null;
        }

        @Override  // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public int getIndex() {
            return this.index;
        }

        public final int scheduleTask(long v, @NotNull DelayedTaskQueue eventLoopImplBase$DelayedTaskQueue0, @NotNull EventLoopImplBase eventLoopImplBase0) {
            synchronized(this) {
                if(this._heap == EventLoop_commonKt.access$getDISPOSED_TASK$p()) {
                    return 2;
                }
                __monitor_enter(eventLoopImplBase$DelayedTaskQueue0);
                try {
                    DelayedTask eventLoopImplBase$DelayedTask0 = (DelayedTask)eventLoopImplBase$DelayedTaskQueue0.firstImpl();
                    if(!eventLoopImplBase0.isCompleted()) {
                        if(eventLoopImplBase$DelayedTask0 == null) {
                            eventLoopImplBase$DelayedTaskQueue0.timeNow = v;
                        }
                        else {
                            long v2 = eventLoopImplBase$DelayedTask0.nanoTime;
                            if(v2 - v < 0L) {
                                v = v2;
                            }
                            if(v - eventLoopImplBase$DelayedTaskQueue0.timeNow > 0L) {
                                eventLoopImplBase$DelayedTaskQueue0.timeNow = v;
                            }
                        }
                        long v3 = eventLoopImplBase$DelayedTaskQueue0.timeNow;
                        if(this.nanoTime - v3 < 0L) {
                            this.nanoTime = v3;
                        }
                        eventLoopImplBase$DelayedTaskQueue0.addImpl(this);
                        goto label_27;
                    }
                    goto label_30;
                }
                catch(Throwable throwable0) {
                }
                __monitor_exit(eventLoopImplBase$DelayedTaskQueue0);
                throw throwable0;
            label_27:
                __monitor_exit(eventLoopImplBase$DelayedTaskQueue0);
                return 0;
            label_30:
                __monitor_exit(eventLoopImplBase$DelayedTaskQueue0);
                return 1;
            }
        }

        @Override  // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setHeap(@Nullable ThreadSafeHeap threadSafeHeap0) {
            if(this._heap == EventLoop_commonKt.access$getDISPOSED_TASK$p()) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            this._heap = threadSafeHeap0;
        }

        @Override  // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setIndex(int v) {
            this.index = v;
        }

        public final boolean timeToExecute(long v) {
            return v - this.nanoTime >= 0L;
        }

        @Override
        @NotNull
        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0003\u001A\u00020\u00048\u0006@\u0006X\u0087\u000E¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "<init>", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class DelayedTaskQueue extends ThreadSafeHeap {
        public long timeNow;

        public DelayedTaskQueue(long v) {
            this.timeNow = v;
        }
    }

    private volatile Object _delayed$volatile;
    private static final AtomicReferenceFieldUpdater _delayed$volatile$FU;
    private volatile int _isCompleted$volatile;
    private static final AtomicIntegerFieldUpdater _isCompleted$volatile$FU;
    private volatile Object _queue$volatile;
    private static final AtomicReferenceFieldUpdater _queue$volatile$FU;

    static {
        EventLoopImplBase._queue$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue$volatile");
        EventLoopImplBase._delayed$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed$volatile");
        EventLoopImplBase._isCompleted$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(EventLoopImplBase.class, "_isCompleted$volatile");
    }

    private final void closeQueue() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = EventLoopImplBase.get_queue$volatile$FU();
        while(true) {
            Object object0 = atomicReferenceFieldUpdater0.get(this);
            if(object0 == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = EventLoopImplBase.get_queue$volatile$FU();
                Symbol symbol0 = EventLoop_commonKt.access$getCLOSED_EMPTY$p();
                do {
                    if(atomicReferenceFieldUpdater1.compareAndSet(this, null, symbol0)) {
                        return;
                    }
                }
                while(atomicReferenceFieldUpdater1.get(this) == null);
            }
            else {
                if(object0 instanceof LockFreeTaskQueueCore) {
                    ((LockFreeTaskQueueCore)object0).close();
                    return;
                }
                if(object0 == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                    return;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore0 = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore0.addLast(((Runnable)object0));
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = EventLoopImplBase.get_queue$volatile$FU();
                do {
                    if(atomicReferenceFieldUpdater2.compareAndSet(this, object0, lockFreeTaskQueueCore0)) {
                        return;
                    }
                }
                while(atomicReferenceFieldUpdater2.get(this) == object0);
            }
        }
    }

    private final Runnable dequeue() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = EventLoopImplBase.get_queue$volatile$FU();
        while(true) {
            Object object0 = atomicReferenceFieldUpdater0.get(this);
            if(object0 == null) {
                return null;
            }
            if(object0 instanceof LockFreeTaskQueueCore) {
                Object object1 = ((LockFreeTaskQueueCore)object0).removeFirstOrNull();
                if(object1 != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                    return (Runnable)object1;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = EventLoopImplBase.get_queue$volatile$FU();
                LockFreeTaskQueueCore lockFreeTaskQueueCore0 = ((LockFreeTaskQueueCore)object0).next();
                while(!atomicReferenceFieldUpdater1.compareAndSet(this, object0, lockFreeTaskQueueCore0) && atomicReferenceFieldUpdater1.get(this) == object0) {
                }
            }
            else {
                if(object0 == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                    return null;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = EventLoopImplBase.get_queue$volatile$FU();
                do {
                    if(atomicReferenceFieldUpdater2.compareAndSet(this, object0, null)) {
                        return (Runnable)object0;
                    }
                }
                while(atomicReferenceFieldUpdater2.get(this) == object0);
            }
        }
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(@NotNull i i0, @NotNull Runnable runnable0) {
        this.enqueue(runnable0);
    }

    public void enqueue(@NotNull Runnable runnable0) {
        this.enqueueDelayedTasks();
        if(this.enqueueImpl(runnable0)) {
            this.unpark();
            return;
        }
        DefaultExecutor.INSTANCE.enqueue(runnable0);
    }

    private final void enqueueDelayedTasks() {
        DelayedTaskQueue eventLoopImplBase$DelayedTaskQueue0 = (DelayedTaskQueue)EventLoopImplBase.get_delayed$volatile$FU().get(this);
        if(eventLoopImplBase$DelayedTaskQueue0 != null && !eventLoopImplBase$DelayedTaskQueue0.isEmpty()) {
            long v = System.nanoTime();
            do {
                __monitor_enter(eventLoopImplBase$DelayedTaskQueue0);
                try {
                    ThreadSafeHeapNode threadSafeHeapNode0 = null;
                    ThreadSafeHeapNode threadSafeHeapNode1 = eventLoopImplBase$DelayedTaskQueue0.firstImpl();
                    if(threadSafeHeapNode1 == null) {
                        goto label_15;
                    }
                    else {
                        if((((DelayedTask)threadSafeHeapNode1).timeToExecute(v) ? this.enqueueImpl(((DelayedTask)threadSafeHeapNode1)) : false)) {
                            threadSafeHeapNode0 = eventLoopImplBase$DelayedTaskQueue0.removeAtImpl(0);
                        }
                        goto label_13;
                    }
                    continue;
                }
                catch(Throwable throwable0) {
                }
                __monitor_exit(eventLoopImplBase$DelayedTaskQueue0);
                throw throwable0;
            label_13:
                __monitor_exit(eventLoopImplBase$DelayedTaskQueue0);
                continue;
            label_15:
                __monitor_exit(eventLoopImplBase$DelayedTaskQueue0);
            }
            while(((DelayedTask)threadSafeHeapNode0) != null);
        }
    }

    private final boolean enqueueImpl(Runnable runnable0) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = EventLoopImplBase._queue$volatile$FU;
        while(true) {
            Object object0 = atomicReferenceFieldUpdater0.get(this);
            if(this.isCompleted()) {
                return false;
            }
            if(object0 == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = EventLoopImplBase._queue$volatile$FU;
                do {
                    if(atomicReferenceFieldUpdater1.compareAndSet(this, null, runnable0)) {
                        return true;
                    }
                }
                while(atomicReferenceFieldUpdater1.get(this) == null);
            }
            else {
                if(object0 instanceof LockFreeTaskQueueCore) {
                    int v = ((LockFreeTaskQueueCore)object0).addLast(runnable0);
                    switch(v) {
                        case 0: {
                            return true;
                        label_15:
                            if(v != 2) {
                                continue;
                            }
                            return false;
                        }
                        case 1: {
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = EventLoopImplBase._queue$volatile$FU;
                            LockFreeTaskQueueCore lockFreeTaskQueueCore0 = ((LockFreeTaskQueueCore)object0).next();
                            while(!atomicReferenceFieldUpdater2.compareAndSet(this, object0, lockFreeTaskQueueCore0) && atomicReferenceFieldUpdater2.get(this) == object0) {
                            }
                            continue;
                        }
                        default: {
                            goto label_15;
                        }
                    }
                }
                if(object0 == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) {
                    return false;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore1 = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore1.addLast(((Runnable)object0));
                lockFreeTaskQueueCore1.addLast(runnable0);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = EventLoopImplBase._queue$volatile$FU;
                do {
                    if(atomicReferenceFieldUpdater3.compareAndSet(this, object0, lockFreeTaskQueueCore1)) {
                        return true;
                    }
                }
                while(atomicReferenceFieldUpdater3.get(this) == object0);
            }
        }
    }

    @Override  // kotlinx.coroutines.EventLoop
    public long getNextTime() {
        if(super.getNextTime() == 0L) {
            return 0L;
        }
        Object object0 = EventLoopImplBase._queue$volatile$FU.get(this);
        if(object0 != null) {
            if(!(object0 instanceof LockFreeTaskQueueCore)) {
                return object0 == EventLoop_commonKt.access$getCLOSED_EMPTY$p() ? 0x7FFFFFFFFFFFFFFFL : 0L;
            }
            else if(!((LockFreeTaskQueueCore)object0).isEmpty()) {
                return 0L;
            }
        }
        DelayedTaskQueue eventLoopImplBase$DelayedTaskQueue0 = (DelayedTaskQueue)EventLoopImplBase._delayed$volatile$FU.get(this);
        if(eventLoopImplBase$DelayedTaskQueue0 != null) {
            DelayedTask eventLoopImplBase$DelayedTask0 = (DelayedTask)eventLoopImplBase$DelayedTaskQueue0.peek();
            if(eventLoopImplBase$DelayedTask0 != null) {
                long v = eventLoopImplBase$DelayedTask0.nanoTime - System.nanoTime();
                return v >= 0L ? v : 0L;
            }
        }
        return 0x7FFFFFFFFFFFFFFFL;
    }

    @Override  // kotlinx.coroutines.Delay
    @NotNull
    public DisposableHandle invokeOnTimeout(long v, @NotNull Runnable runnable0, @NotNull i i0) {
        return DefaultImpls.invokeOnTimeout(this, v, runnable0, i0);
    }

    private final boolean isCompleted() {
        return EventLoopImplBase._isCompleted$volatile$FU.get(this) == 1;
    }

    public boolean isEmpty() {
        if(!this.isUnconfinedQueueEmpty()) {
            return false;
        }
        DelayedTaskQueue eventLoopImplBase$DelayedTaskQueue0 = (DelayedTaskQueue)EventLoopImplBase._delayed$volatile$FU.get(this);
        if(eventLoopImplBase$DelayedTaskQueue0 != null && !eventLoopImplBase$DelayedTaskQueue0.isEmpty()) {
            return false;
        }
        Object object0 = EventLoopImplBase._queue$volatile$FU.get(this);
        if(object0 == null) {
            return true;
        }
        return object0 instanceof LockFreeTaskQueueCore ? ((LockFreeTaskQueueCore)object0).isEmpty() : object0 == EventLoop_commonKt.access$getCLOSED_EMPTY$p();
    }

    @Override  // kotlinx.coroutines.EventLoop
    public long processNextEvent() {
        if(this.processUnconfinedEvent()) {
            return 0L;
        }
        this.enqueueDelayedTasks();
        Runnable runnable0 = this.dequeue();
        if(runnable0 != null) {
            runnable0.run();
            return 0L;
        }
        return this.getNextTime();
    }

    private final void rescheduleAllDelayed() {
        long v = System.nanoTime();
        DelayedTaskQueue eventLoopImplBase$DelayedTaskQueue0;
        while((eventLoopImplBase$DelayedTaskQueue0 = (DelayedTaskQueue)EventLoopImplBase._delayed$volatile$FU.get(this)) != null) {
            DelayedTask eventLoopImplBase$DelayedTask0 = (DelayedTask)eventLoopImplBase$DelayedTaskQueue0.removeFirstOrNull();
            if(eventLoopImplBase$DelayedTask0 == null) {
                break;
            }
            this.reschedule(v, eventLoopImplBase$DelayedTask0);
        }
    }

    public final void resetAll() {
        EventLoopImplBase._queue$volatile$FU.set(this, null);
        EventLoopImplBase._delayed$volatile$FU.set(this, null);
    }

    public final void schedule(long v, @NotNull DelayedTask eventLoopImplBase$DelayedTask0) {
        switch(this.scheduleImpl(v, eventLoopImplBase$DelayedTask0)) {
            case 0: {
                if(this.shouldUnpark(eventLoopImplBase$DelayedTask0)) {
                    this.unpark();
                }
                break;
            }
            case 1: {
                this.reschedule(v, eventLoopImplBase$DelayedTask0);
                return;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("unexpected result");
            }
        }
    }

    private final int scheduleImpl(long v, DelayedTask eventLoopImplBase$DelayedTask0) {
        if(this.isCompleted()) {
            return 1;
        }
        DelayedTaskQueue eventLoopImplBase$DelayedTaskQueue0 = (DelayedTaskQueue)EventLoopImplBase._delayed$volatile$FU.get(this);
        if(eventLoopImplBase$DelayedTaskQueue0 == null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = EventLoopImplBase._delayed$volatile$FU;
            DelayedTaskQueue eventLoopImplBase$DelayedTaskQueue1 = new DelayedTaskQueue(v);
            while(!atomicReferenceFieldUpdater0.compareAndSet(this, null, eventLoopImplBase$DelayedTaskQueue1) && atomicReferenceFieldUpdater0.get(this) == null) {
            }
            Object object0 = EventLoopImplBase._delayed$volatile$FU.get(this);
            q.d(object0);
            eventLoopImplBase$DelayedTaskQueue0 = (DelayedTaskQueue)object0;
        }
        return eventLoopImplBase$DelayedTask0.scheduleTask(v, eventLoopImplBase$DelayedTaskQueue0, this);
    }

    @NotNull
    public final DisposableHandle scheduleInvokeOnTimeout(long v, @NotNull Runnable runnable0) {
        long v1 = EventLoop_commonKt.delayToNanos(v);
        if(v1 < 0x3FFFFFFFFFFFFFFFL) {
            long v2 = System.nanoTime();
            DisposableHandle disposableHandle0 = new DelayedRunnableTask(v1 + v2, runnable0);
            this.schedule(v2, ((DelayedTask)disposableHandle0));
            return disposableHandle0;
        }
        return NonDisposableHandle.INSTANCE;
    }

    @Override  // kotlinx.coroutines.Delay
    public void scheduleResumeAfterDelay(long v, @NotNull CancellableContinuation cancellableContinuation0) {
        long v1 = EventLoop_commonKt.delayToNanos(v);
        if(v1 < 0x3FFFFFFFFFFFFFFFL) {
            long v2 = System.nanoTime();
            DelayedResumeTask eventLoopImplBase$DelayedResumeTask0 = new DelayedResumeTask(this, v1 + v2, cancellableContinuation0);
            this.schedule(v2, eventLoopImplBase$DelayedResumeTask0);
            CancellableContinuationKt.disposeOnCancellation(cancellableContinuation0, eventLoopImplBase$DelayedResumeTask0);
        }
    }

    private final void setCompleted(boolean z) {
        EventLoopImplBase._isCompleted$volatile$FU.set(this, ((int)z));
    }

    private final boolean shouldUnpark(DelayedTask eventLoopImplBase$DelayedTask0) {
        DelayedTaskQueue eventLoopImplBase$DelayedTaskQueue0 = (DelayedTaskQueue)EventLoopImplBase._delayed$volatile$FU.get(this);
        return (eventLoopImplBase$DelayedTaskQueue0 == null ? null : ((DelayedTask)eventLoopImplBase$DelayedTaskQueue0.peek())) == eventLoopImplBase$DelayedTask0;
    }

    @Override  // kotlinx.coroutines.EventLoop
    public void shutdown() {
        ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        this.setCompleted(true);
        this.closeQueue();
        while(this.processNextEvent() <= 0L) {
        }
        this.rescheduleAllDelayed();
    }
}

