package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000B\u001A\u00020\u00032\u0006\u0010\n\u001A\u00028\u0000¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u0004\u0018\u00018\u0000¢\u0006\u0004\b\r\u0010\u000ER\u0011\u0010\u0012\u001A\u00020\u000F8F¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R!\u0010\u0016\u001A\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00000\u0014j\b\u0012\u0004\u0012\u00028\u0000`\u00150\u00138\u0002X\u0082\u0004¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "", "E", "", "singleConsumer", "<init>", "(Z)V", "Lie/H;", "close", "()V", "element", "addLast", "(Ljava/lang/Object;)Z", "removeFirstOrNull", "()Ljava/lang/Object;", "", "getSize", "()I", "size", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Lkotlinx/coroutines/internal/Core;", "_cur", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public class LockFreeTaskQueue {
    private volatile Object _cur$volatile;
    private static final AtomicReferenceFieldUpdater _cur$volatile$FU;

    static {
        LockFreeTaskQueue._cur$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur$volatile");
    }

    public LockFreeTaskQueue(boolean z) {
        this._cur$volatile = new LockFreeTaskQueueCore(8, z);
    }

    public final boolean addLast(@NotNull Object object0) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = LockFreeTaskQueue._cur$volatile$FU;
        while(true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore0 = (LockFreeTaskQueueCore)atomicReferenceFieldUpdater0.get(this);
            int v = lockFreeTaskQueueCore0.addLast(object0);
            switch(v) {
                case 0: {
                    return true;
                label_6:
                    if(v != 2) {
                        continue;
                    }
                    return false;
                }
                case 1: {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = LockFreeTaskQueue._cur$volatile$FU;
                    LockFreeTaskQueueCore lockFreeTaskQueueCore1 = lockFreeTaskQueueCore0.next();
                    break;
                }
                default: {
                    goto label_6;
                }
            }
        label_10:
            if(!atomicReferenceFieldUpdater1.compareAndSet(this, lockFreeTaskQueueCore0, lockFreeTaskQueueCore1) && atomicReferenceFieldUpdater1.get(this) == lockFreeTaskQueueCore0) {
                break;
            }
        }
        goto label_10;
    }

    public final void close() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = LockFreeTaskQueue._cur$volatile$FU;
        while(true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore0 = (LockFreeTaskQueueCore)atomicReferenceFieldUpdater0.get(this);
            if(lockFreeTaskQueueCore0.close()) {
                break;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = LockFreeTaskQueue._cur$volatile$FU;
            LockFreeTaskQueueCore lockFreeTaskQueueCore1 = lockFreeTaskQueueCore0.next();
            while(!atomicReferenceFieldUpdater1.compareAndSet(this, lockFreeTaskQueueCore0, lockFreeTaskQueueCore1) && atomicReferenceFieldUpdater1.get(this) == lockFreeTaskQueueCore0) {
            }
        }
    }

    public final int getSize() {
        return ((LockFreeTaskQueueCore)LockFreeTaskQueue._cur$volatile$FU.get(this)).getSize();
    }

    @Nullable
    public final Object removeFirstOrNull() {
        Object object0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = LockFreeTaskQueue._cur$volatile$FU;
        while(true) {
            LockFreeTaskQueueCore lockFreeTaskQueueCore0 = (LockFreeTaskQueueCore)atomicReferenceFieldUpdater0.get(this);
            object0 = lockFreeTaskQueueCore0.removeFirstOrNull();
            if(object0 != LockFreeTaskQueueCore.REMOVE_FROZEN) {
                break;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = LockFreeTaskQueue._cur$volatile$FU;
            LockFreeTaskQueueCore lockFreeTaskQueueCore1 = lockFreeTaskQueueCore0.next();
            while(!atomicReferenceFieldUpdater1.compareAndSet(this, lockFreeTaskQueueCore0, lockFreeTaskQueueCore1) && atomicReferenceFieldUpdater1.get(this) == lockFreeTaskQueueCore0) {
            }
        }
        return object0;
    }
}

