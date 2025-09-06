package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001A\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\u000B\u0010\fJ\r\u0010\r\u001A\u00020\u0007¢\u0006\u0004\b\r\u0010\u000EJ\r\u0010\u000F\u001A\u00020\n¢\u0006\u0004\b\u000F\u0010\fR\u0016\u0010\u0012\u001A\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001A\u0004\u0018\u00018\u00008BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001A\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0019\u001A\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0014R\u0011\u0010\u001A\u001A\u00020\u00078F¢\u0006\u0006\u001A\u0004\b\u001A\u0010\u000ER\u0013\u0010\u0003\u001A\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u0014R\u0014\u0010\u001C\u001A\u00020\u00078&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u000ER\u0013\u0010\u001E\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001D8\u0002X\u0082\u0004R\u0013\u0010\u001F\u001A\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u001D8\u0002X\u0082\u0004¨\u0006 "}, d2 = {"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "", "prev", "<init>", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)V", "value", "", "trySetNext", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Z", "Lie/H;", "cleanPrev", "()V", "markAsClosed", "()Z", "remove", "getNextOrClosed", "()Ljava/lang/Object;", "nextOrClosed", "getAliveSegmentLeft", "()Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "aliveSegmentLeft", "getAliveSegmentRight", "aliveSegmentRight", "getNext", "next", "isTail", "getPrev", "isRemoved", "Lkotlinx/atomicfu/AtomicRef;", "_next", "_prev", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class ConcurrentLinkedListNode {
    private volatile Object _next$volatile;
    private static final AtomicReferenceFieldUpdater _next$volatile$FU;
    private volatile Object _prev$volatile;
    private static final AtomicReferenceFieldUpdater _prev$volatile$FU;

    static {
        ConcurrentLinkedListNode._next$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_next$volatile");
        ConcurrentLinkedListNode._prev$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(ConcurrentLinkedListNode.class, Object.class, "_prev$volatile");
    }

    public ConcurrentLinkedListNode(@Nullable ConcurrentLinkedListNode concurrentLinkedListNode0) {
        this._prev$volatile = concurrentLinkedListNode0;
    }

    public final void cleanPrev() {
        ConcurrentLinkedListNode.get_prev$volatile$FU().set(this, null);
    }

    private final ConcurrentLinkedListNode getAliveSegmentLeft() {
        ConcurrentLinkedListNode concurrentLinkedListNode0;
        for(concurrentLinkedListNode0 = this.getPrev(); concurrentLinkedListNode0 != null && concurrentLinkedListNode0.isRemoved(); concurrentLinkedListNode0 = (ConcurrentLinkedListNode)ConcurrentLinkedListNode.get_prev$volatile$FU().get(concurrentLinkedListNode0)) {
        }
        return concurrentLinkedListNode0;
    }

    private final ConcurrentLinkedListNode getAliveSegmentRight() {
        ConcurrentLinkedListNode concurrentLinkedListNode0 = this.getNext();
        q.d(concurrentLinkedListNode0);
        while(concurrentLinkedListNode0.isRemoved()) {
            ConcurrentLinkedListNode concurrentLinkedListNode1 = concurrentLinkedListNode0.getNext();
            if(concurrentLinkedListNode1 == null) {
                break;
            }
            concurrentLinkedListNode0 = concurrentLinkedListNode1;
        }
        return concurrentLinkedListNode0;
    }

    @Nullable
    public final ConcurrentLinkedListNode getNext() {
        Object object0 = this.getNextOrClosed();
        return object0 == ConcurrentLinkedListKt.CLOSED ? null : ((ConcurrentLinkedListNode)object0);
    }

    private final Object getNextOrClosed() {
        return ConcurrentLinkedListNode.get_next$volatile$FU().get(this);
    }

    @Nullable
    public final ConcurrentLinkedListNode getPrev() {
        return (ConcurrentLinkedListNode)ConcurrentLinkedListNode.get_prev$volatile$FU().get(this);
    }

    private static final AtomicReferenceFieldUpdater get_prev$volatile$FU() {
        return ConcurrentLinkedListNode._prev$volatile$FU;
    }

    public abstract boolean isRemoved();

    public final boolean isTail() {
        return this.getNext() == null;
    }

    public final boolean markAsClosed() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = ConcurrentLinkedListNode.get_next$volatile$FU();
        Symbol symbol0 = ConcurrentLinkedListKt.CLOSED;
        do {
            if(atomicReferenceFieldUpdater0.compareAndSet(this, null, symbol0)) {
                return true;
            }
        }
        while(atomicReferenceFieldUpdater0.get(this) == null);
        return false;
    }

    public final void remove() {
        if(!this.isTail()) {
            while(true) {
                ConcurrentLinkedListNode concurrentLinkedListNode0 = this.getAliveSegmentLeft();
                ConcurrentLinkedListNode concurrentLinkedListNode1 = this.getAliveSegmentRight();
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = ConcurrentLinkedListNode.get_prev$volatile$FU();
                while(true) {
                    Object object0 = atomicReferenceFieldUpdater0.get(concurrentLinkedListNode1);
                    ConcurrentLinkedListNode concurrentLinkedListNode2 = ((ConcurrentLinkedListNode)object0) == null ? null : concurrentLinkedListNode0;
                label_6:
                    if(atomicReferenceFieldUpdater0.compareAndSet(concurrentLinkedListNode1, object0, concurrentLinkedListNode2)) {
                        break;
                    }
                    if(atomicReferenceFieldUpdater0.get(concurrentLinkedListNode1) != object0) {
                        continue;
                    }
                    if(false) {
                        break;
                    }
                    goto label_6;
                }
                if(concurrentLinkedListNode0 != null) {
                    ConcurrentLinkedListNode._next$volatile$FU.set(concurrentLinkedListNode0, concurrentLinkedListNode1);
                }
                if((!concurrentLinkedListNode1.isRemoved() || concurrentLinkedListNode1.isTail()) && (concurrentLinkedListNode0 == null || !concurrentLinkedListNode0.isRemoved())) {
                    break;
                }
            }
        }
    }

    public final boolean trySetNext(@NotNull ConcurrentLinkedListNode concurrentLinkedListNode0) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = ConcurrentLinkedListNode.get_next$volatile$FU();
        do {
            if(atomicReferenceFieldUpdater0.compareAndSet(this, null, concurrentLinkedListNode0)) {
                return true;
            }
        }
        while(atomicReferenceFieldUpdater0.get(this) == null);
        return false;
    }
}

