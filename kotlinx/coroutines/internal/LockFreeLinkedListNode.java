package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.DebugStringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0006J \u0010\t\u001A\u00060\u0000j\u0002`\u00072\n\u0010\b\u001A\u00060\u0000j\u0002`\u0007H\u0082\u0010\u00A2\u0006\u0004\b\t\u0010\nJ\u001B\u0010\r\u001A\u00020\f2\n\u0010\u000B\u001A\u00060\u0000j\u0002`\u0007H\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0018\u0010\u000F\u001A\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0007H\u0082\u0010\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0019\u0010\u0013\u001A\u00020\u00122\n\u0010\u0011\u001A\u00060\u0000j\u0002`\u0007\u00A2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001A\u00020\u00122\n\u0010\u0011\u001A\u00060\u0000j\u0002`\u00072\u0006\u0010\u0016\u001A\u00020\u0015\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001A\u001A\u00020\f2\u0006\u0010\u0019\u001A\u00020\u0015\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\'\u0010\u001C\u001A\u00020\u00122\n\u0010\u0011\u001A\u00060\u0000j\u0002`\u00072\n\u0010\u000B\u001A\u00060\u0000j\u0002`\u0007H\u0001\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001E\u001A\u00020\u0012H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0017\u0010 \u001A\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0007H\u0001\u00A2\u0006\u0004\b \u0010\u0010J\u000F\u0010\"\u001A\u00020!H\u0016\u00A2\u0006\u0004\b\"\u0010#R\u0014\u0010$\u001A\u00020\u00128VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b$\u0010\u001FR\u0011\u0010\u000B\u001A\u00020\u00018F\u00A2\u0006\u0006\u001A\u0004\b%\u0010&R\u0015\u0010(\u001A\u00060\u0000j\u0002`\u00078F\u00A2\u0006\u0006\u001A\u0004\b\'\u0010\u0010R\u0015\u0010*\u001A\u00060\u0000j\u0002`\u00078F\u00A2\u0006\u0006\u001A\u0004\b)\u0010\u0010R\u0011\u0010,\u001A\b\u0012\u0004\u0012\u00020\u00010+8\u0002X\u0082\u0004R\u0011\u0010-\u001A\b\u0012\u0004\u0012\u00020\u00000+8\u0002X\u0082\u0004R\u0013\u0010.\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040+8\u0002X\u0082\u0004\u00A8\u0006/"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "<init>", "()V", "Lkotlinx/coroutines/internal/Removed;", "removed", "()Lkotlinx/coroutines/internal/Removed;", "Lkotlinx/coroutines/internal/Node;", "current", "findPrevNonRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "next", "Lie/H;", "finishAdd", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "correctPrev", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "node", "", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "", "permissionsBitmask", "addLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;I)Z", "forbiddenElementsBit", "close", "(I)V", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "remove", "()Z", "removeOrNext", "", "toString", "()Ljava/lang/String;", "isRemoved", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "Lkotlinx/atomicfu/AtomicRef;", "_next", "_prev", "_removedRef", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public class LockFreeLinkedListNode {
    private volatile Object _next$volatile;
    private static final AtomicReferenceFieldUpdater _next$volatile$FU;
    private volatile Object _prev$volatile;
    private static final AtomicReferenceFieldUpdater _prev$volatile$FU;
    private volatile Object _removedRef$volatile;
    private static final AtomicReferenceFieldUpdater _removedRef$volatile$FU;

    static {
        LockFreeLinkedListNode._next$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next$volatile");
        LockFreeLinkedListNode._prev$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev$volatile");
        LockFreeLinkedListNode._removedRef$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef$volatile");
    }

    public LockFreeLinkedListNode() {
        this._next$volatile = this;
        this._prev$volatile = this;
    }

    public final boolean addLast(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode0, int v) {
        do {
            LockFreeLinkedListNode lockFreeLinkedListNode1 = this.getPrevNode();
            if(lockFreeLinkedListNode1 instanceof ListClosed) {
                return (((ListClosed)lockFreeLinkedListNode1).forbiddenElementsBitmask & v) == 0 && lockFreeLinkedListNode1.addLast(lockFreeLinkedListNode0, v);
            }
        }
        while(!lockFreeLinkedListNode1.addNext(lockFreeLinkedListNode0, this));
        return true;
    }

    public final boolean addNext(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode0, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode1) {
        LockFreeLinkedListNode._prev$volatile$FU.set(lockFreeLinkedListNode0, this);
        LockFreeLinkedListNode._next$volatile$FU.set(lockFreeLinkedListNode0, lockFreeLinkedListNode1);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = LockFreeLinkedListNode._next$volatile$FU;
        do {
            if(atomicReferenceFieldUpdater0.compareAndSet(this, lockFreeLinkedListNode1, lockFreeLinkedListNode0)) {
                lockFreeLinkedListNode0.finishAdd(lockFreeLinkedListNode1);
                return true;
            }
        }
        while(atomicReferenceFieldUpdater0.get(this) == lockFreeLinkedListNode1);
        return false;
    }

    public final boolean addOneIfEmpty(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode0) {
        LockFreeLinkedListNode._prev$volatile$FU.set(lockFreeLinkedListNode0, this);
        LockFreeLinkedListNode._next$volatile$FU.set(lockFreeLinkedListNode0, this);
        while(true) {
            if(this.getNext() != this) {
                return false;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = LockFreeLinkedListNode._next$volatile$FU;
            do {
                if(atomicReferenceFieldUpdater0.compareAndSet(this, this, lockFreeLinkedListNode0)) {
                    lockFreeLinkedListNode0.finishAdd(this);
                    return true;
                }
            }
            while(atomicReferenceFieldUpdater0.get(this) == this);
        }
    }

    public final void close(int v) {
        this.addLast(new ListClosed(v), v);
    }

    private final LockFreeLinkedListNode correctPrev() {
        LockFreeLinkedListNode lockFreeLinkedListNode1;
    alab1:
        while(true) {
            LockFreeLinkedListNode lockFreeLinkedListNode0 = (LockFreeLinkedListNode)LockFreeLinkedListNode.get_prev$volatile$FU().get(this);
            lockFreeLinkedListNode1 = lockFreeLinkedListNode0;
            while(true) {
                LockFreeLinkedListNode lockFreeLinkedListNode2 = null;
            label_3:
                Object object0 = LockFreeLinkedListNode.get_next$volatile$FU().get(lockFreeLinkedListNode1);
                if(object0 == this) {
                    if(lockFreeLinkedListNode0 == lockFreeLinkedListNode1) {
                        return lockFreeLinkedListNode1;
                    }
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = LockFreeLinkedListNode.get_prev$volatile$FU();
                    do {
                        if(atomicReferenceFieldUpdater0.compareAndSet(this, lockFreeLinkedListNode0, lockFreeLinkedListNode1)) {
                            return lockFreeLinkedListNode1;
                        }
                    }
                    while(atomicReferenceFieldUpdater0.get(this) == lockFreeLinkedListNode0);
                    break;
                }
                if(this.isRemoved()) {
                    return null;
                }
                if(!(object0 instanceof Removed)) {
                    q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                    lockFreeLinkedListNode2 = lockFreeLinkedListNode1;
                    lockFreeLinkedListNode1 = (LockFreeLinkedListNode)object0;
                    goto label_3;
                }
                if(lockFreeLinkedListNode2 == null) {
                    break alab1;
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = LockFreeLinkedListNode.get_next$volatile$FU();
                LockFreeLinkedListNode lockFreeLinkedListNode3 = ((Removed)object0).ref;
            label_22:
                if(!atomicReferenceFieldUpdater1.compareAndSet(lockFreeLinkedListNode2, lockFreeLinkedListNode1, lockFreeLinkedListNode3)) {
                    if(atomicReferenceFieldUpdater1.get(lockFreeLinkedListNode2) == lockFreeLinkedListNode1) {
                        goto label_22;
                    }
                    break;
                }
                lockFreeLinkedListNode1 = lockFreeLinkedListNode2;
            }
        }
        lockFreeLinkedListNode1 = (LockFreeLinkedListNode)LockFreeLinkedListNode.get_prev$volatile$FU().get(lockFreeLinkedListNode1);
        goto label_3;
    }

    private final LockFreeLinkedListNode findPrevNonRemoved(LockFreeLinkedListNode lockFreeLinkedListNode0) {
        while(lockFreeLinkedListNode0.isRemoved()) {
            lockFreeLinkedListNode0 = (LockFreeLinkedListNode)LockFreeLinkedListNode.get_prev$volatile$FU().get(lockFreeLinkedListNode0);
        }
        return lockFreeLinkedListNode0;
    }

    private final void finishAdd(LockFreeLinkedListNode lockFreeLinkedListNode0) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = LockFreeLinkedListNode.get_prev$volatile$FU();
        while(true) {
            LockFreeLinkedListNode lockFreeLinkedListNode1 = (LockFreeLinkedListNode)atomicReferenceFieldUpdater0.get(lockFreeLinkedListNode0);
            if(this.getNext() != lockFreeLinkedListNode0) {
                break;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = LockFreeLinkedListNode.get_prev$volatile$FU();
        label_4:
            if(atomicReferenceFieldUpdater1.compareAndSet(lockFreeLinkedListNode0, lockFreeLinkedListNode1, this)) {
                if(!this.isRemoved()) {
                    break;
                }
                lockFreeLinkedListNode0.correctPrev();
                return;
            }
            if(atomicReferenceFieldUpdater1.get(lockFreeLinkedListNode0) != lockFreeLinkedListNode1) {
                continue;
            }
            if(false) {
                break;
            }
            goto label_4;
        }
    }

    @NotNull
    public final Object getNext() {
        return LockFreeLinkedListNode._next$volatile$FU.get(this);
    }

    @NotNull
    public final LockFreeLinkedListNode getNextNode() {
        Object object0 = this.getNext();
        Removed removed0 = object0 instanceof Removed ? ((Removed)object0) : null;
        if(removed0 != null) {
            LockFreeLinkedListNode lockFreeLinkedListNode0 = removed0.ref;
            if(lockFreeLinkedListNode0 != null) {
                return lockFreeLinkedListNode0;
            }
        }
        q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        return (LockFreeLinkedListNode)object0;
    }

    @NotNull
    public final LockFreeLinkedListNode getPrevNode() {
        LockFreeLinkedListNode lockFreeLinkedListNode0 = this.correctPrev();
        return lockFreeLinkedListNode0 == null ? this.findPrevNonRemoved(((LockFreeLinkedListNode)LockFreeLinkedListNode._prev$volatile$FU.get(this))) : lockFreeLinkedListNode0;
    }

    public boolean isRemoved() {
        return this.getNext() instanceof Removed;
    }

    public boolean remove() {
        return this.removeOrNext() == null;
    }

    @Nullable
    public final LockFreeLinkedListNode removeOrNext() {
        while(true) {
            Object object0 = this.getNext();
            if(object0 instanceof Removed) {
                return ((Removed)object0).ref;
            }
            if(object0 == this) {
                return (LockFreeLinkedListNode)object0;
            }
            q.e(object0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
            Removed removed0 = ((LockFreeLinkedListNode)object0).removed();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = LockFreeLinkedListNode._next$volatile$FU;
            do {
                if(atomicReferenceFieldUpdater0.compareAndSet(this, object0, removed0)) {
                    ((LockFreeLinkedListNode)object0).correctPrev();
                    return null;
                }
            }
            while(atomicReferenceFieldUpdater0.get(this) == object0);
        }
    }

    private final Removed removed() {
        Removed removed0 = (Removed)LockFreeLinkedListNode._removedRef$volatile$FU.get(this);
        if(removed0 == null) {
            removed0 = new Removed(this);
            LockFreeLinkedListNode._removedRef$volatile$FU.set(this, removed0);
        }
        return removed0;
    }

    @Override
    @NotNull
    public String toString() {
        return new x() {
            {
                super(object0, DebugStringsKt.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", 1);
            }

            @Override  // De.r
            public Object get() {
                return DebugStringsKt.getClassSimpleName(this.receiver);
            }
        } + '@' + DebugStringsKt.getHexAddress(this);
    }
}

