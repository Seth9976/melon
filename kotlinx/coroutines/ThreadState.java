package kotlinx.coroutines;

import i.n.i.b.a.s.e.M3;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000E\u001A\u00020\u000B¢\u0006\u0004\b\u000E\u0010\u0003J\u0019\u0010\u0011\u001A\u00020\u000B2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0015\u001A\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0018\u001A\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001D\u001A\u00020\u001A8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u000B\u0010\u001F\u001A\u00020\u001E8\u0002X\u0082\u0004¨\u0006 "}, d2 = {"Lkotlinx/coroutines/ThreadState;", "Lkotlinx/coroutines/JobNode;", "<init>", "()V", "", "state", "", "invalidState", "(I)Ljava/lang/Void;", "Lkotlinx/coroutines/Job;", "job", "Lie/H;", "setup", "(Lkotlinx/coroutines/Job;)V", "clearInterrupt", "", "cause", "invoke", "(Ljava/lang/Throwable;)V", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "targetThread", "Ljava/lang/Thread;", "Lkotlinx/coroutines/DisposableHandle;", "cancelHandle", "Lkotlinx/coroutines/DisposableHandle;", "", "getOnCancelling", "()Z", "onCancelling", "Lkotlinx/atomicfu/AtomicInt;", "_state", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class ThreadState extends JobNode {
    private volatile int _state$volatile;
    private static final AtomicIntegerFieldUpdater _state$volatile$FU;
    @Nullable
    private DisposableHandle cancelHandle;
    private final Thread targetThread;

    static {
        ThreadState._state$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadState.class, "_state$volatile");
    }

    public ThreadState() {
        this.targetThread = Thread.currentThread();
    }

    public final void clearInterrupt() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater0 = ThreadState._state$volatile$FU;
        while(true) {
            int v = atomicIntegerFieldUpdater0.get(this);
            switch(v) {
                case 0: {
                    if(ThreadState._state$volatile$FU.compareAndSet(this, 0, 1)) {
                        DisposableHandle disposableHandle0 = this.cancelHandle;
                        if(disposableHandle0 != null) {
                            disposableHandle0.dispose();
                        }
                        return;
                    }
                    if(false) {
                        Thread.interrupted();
                        return;
                    }
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    Thread.interrupted();
                    return;
                }
                default: {
                    this.invalidState(v);
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
    }

    @Override  // kotlinx.coroutines.JobNode
    public boolean getOnCancelling() {
        return true;
    }

    private final Void invalidState(int v) {
        throw new IllegalStateException(("Illegal state " + v).toString());
    }

    @Override  // kotlinx.coroutines.JobNode
    public void invoke(@Nullable Throwable throwable0) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater0 = ThreadState._state$volatile$FU;
        do {
            int v = atomicIntegerFieldUpdater0.get(this);
            if(v != 0) {
                if(v != 1 && v != 2 && v != 3) {
                    this.invalidState(v);
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                return;
            }
        }
        while(!ThreadState._state$volatile$FU.compareAndSet(this, 0, 2));
        this.targetThread.interrupt();
        ThreadState._state$volatile$FU.set(this, 3);
    }

    public final void setup(@NotNull Job job0) {
        this.cancelHandle = JobKt__JobKt.invokeOnCompletion$default(job0, false, this, 1, null);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater0 = ThreadState._state$volatile$FU;
    alab1:
        while(true) {
            int v = atomicIntegerFieldUpdater0.get(this);
            switch(v) {
                case 0: {
                    if(!ThreadState._state$volatile$FU.compareAndSet(this, 0, 0)) {
                        break;
                    }
                    break alab1;
                }
                case 2: 
                case 3: {
                    break alab1;
                }
                default: {
                    this.invalidState(v);
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
    }
}

