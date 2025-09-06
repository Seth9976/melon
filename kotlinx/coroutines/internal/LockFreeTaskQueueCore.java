package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 .*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002/.B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u00A2\u0006\u0004\b\u0007\u0010\bJ3\u0010\f\u001A\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000B2\u0006\u0010\t\u001A\u00020\u00032\u0006\u0010\n\u001A\u00028\u0000H\u0002\u00A2\u0006\u0004\b\f\u0010\rJ3\u0010\u0010\u001A\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000B2\u0006\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0003H\u0002\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0013\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014J\'\u0010\u0016\u001A\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000B2\u0006\u0010\u0015\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b\u0016\u0010\u0017J\'\u0010\u0018\u001A\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000B2\u0006\u0010\u0015\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u0019\u001A\u00020\u0005\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0015\u0010\u001B\u001A\u00020\u00032\u0006\u0010\n\u001A\u00028\u0000\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u0004\u0018\u00010\u0001\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0013\u0010\u001F\u001A\b\u0012\u0004\u0012\u00028\u00000\u0000\u00A2\u0006\u0004\b\u001F\u0010 R\u0014\u0010\u0004\u001A\u00020\u00038\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0004\u0010!R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0006\u0010\"R\u0014\u0010#\u001A\u00020\u00038\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b#\u0010!R\u0011\u0010$\u001A\u00020\u00058F\u00A2\u0006\u0006\u001A\u0004\b$\u0010\u001AR\u0011\u0010\'\u001A\u00020\u00038F\u00A2\u0006\u0006\u001A\u0004\b%\u0010&R%\u0010)\u001A\u001C\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000B0(8\u0002X\u0082\u0004R\u000B\u0010+\u001A\u00020*8\u0002X\u0082\u0004R\u0013\u0010-\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010,8\u0002X\u0082\u0004\u00A8\u00060"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "E", "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", "index", "element", "Lkotlinx/coroutines/internal/Core;", "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "markFrozen", "()J", "state", "allocateOrGetNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateNextCopy", "close", "()Z", "addLast", "(Ljava/lang/Object;)I", "removeFirstOrNull", "()Ljava/lang/Object;", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "Z", "mask", "isEmpty", "getSize", "()I", "size", "Lkotlinx/atomicfu/AtomicRef;", "_next", "Lkotlinx/atomicfu/AtomicLong;", "_state", "Lkotlinx/atomicfu/AtomicArray;", "array", "Companion", "Placeholder", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class LockFreeTaskQueueCore {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u001C\u0010\u0006\u001A\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004H\u0086\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001A\u00020\u0004*\u00020\u00042\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0019\u0010\r\u001A\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001A\u00020\b\u00A2\u0006\u0004\b\r\u0010\u000BJ\u0011\u0010\u000E\u001A\u00020\b*\u00020\u0004\u00A2\u0006\u0004\b\u000E\u0010\u000FR\u0014\u0010\u0010\u001A\u00020\b8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001A\u00020\b8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001A\u00020\b8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001A\u00020\b8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001A\u00020\u00048\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\b8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001A\u00020\u00048\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001A\u00020\b8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001A\u001A\u00020\u00048\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u001A\u0010\u0016R\u0014\u0010\u001B\u001A\u00020\b8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u001B\u0010\u0011R\u0014\u0010\u001C\u001A\u00020\u00048\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u001C\u0010\u0016R\u0014\u0010\u001D\u001A\u00020\b8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u001D\u0010\u0011R\u0014\u0010\u001F\u001A\u00020\u001E8\u0006X\u0087\u0004\u00A2\u0006\u0006\n\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\b8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b!\u0010\u0011R\u0014\u0010\"\u001A\u00020\b8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\"\u0010\u0011R\u0014\u0010#\u001A\u00020\b8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b#\u0010\u0011\u00A8\u0006$"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "<init>", "()V", "", "other", "wo", "(JJ)J", "", "newHead", "updateHead", "(JI)J", "newTail", "updateTail", "addFailReason", "(J)I", "INITIAL_CAPACITY", "I", "CAPACITY_BITS", "MAX_CAPACITY_MASK", "HEAD_SHIFT", "HEAD_MASK", "J", "TAIL_SHIFT", "TAIL_MASK", "FROZEN_SHIFT", "FROZEN_MASK", "CLOSED_SHIFT", "CLOSED_MASK", "MIN_ADD_SPIN_CAPACITY", "Lkotlinx/coroutines/internal/Symbol;", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "ADD_SUCCESS", "ADD_FROZEN", "ADD_CLOSED", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final int addFailReason(long v) {
            return (v & 0x2000000000000000L) == 0L ? 1 : 2;
        }

        public final long updateHead(long v, int v1) {
            return v & 0xFFFFFFFFC0000000L | ((long)v1);
        }

        public final long updateTail(long v, int v1) {
            return this.wo(v, 0xFFFFFFFC0000000L) | ((long)v1) << 30;
        }

        public final long wo(long v, long v1) [...] // Inlined contents
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "<init>", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
    public static final class Placeholder {
        public final int index;

        public Placeholder(int v) {
            this.index = v;
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    public static final Symbol REMOVE_FROZEN;
    private volatile Object _next$volatile;
    private static final AtomicReferenceFieldUpdater _next$volatile$FU;
    private volatile long _state$volatile;
    private static final AtomicLongFieldUpdater _state$volatile$FU;
    private final AtomicReferenceArray array;
    private final int capacity;
    private final int mask;
    private final boolean singleConsumer;

    static {
        LockFreeTaskQueueCore.Companion = new Companion(null);
        LockFreeTaskQueueCore._next$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next$volatile");
        LockFreeTaskQueueCore._state$volatile$FU = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state$volatile");
        LockFreeTaskQueueCore.REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");
    }

    public LockFreeTaskQueueCore(int v, boolean z) {
        this.capacity = v;
        this.singleConsumer = z;
        this.mask = v - 1;
        this.array = new AtomicReferenceArray(v);
        if(v - 1 > 0x3FFFFFFF || (v & v - 1) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int addLast(@NotNull Object object0) {
        int v2;
        int v1;
        AtomicLongFieldUpdater atomicLongFieldUpdater0 = LockFreeTaskQueueCore._state$volatile$FU;
        do {
            while(true) {
                long v = atomicLongFieldUpdater0.get(this);
                if((0x3000000000000000L & v) != 0L) {
                    return LockFreeTaskQueueCore.Companion.addFailReason(v);
                }
                v1 = (int)((0xFFFFFFFC0000000L & v) >> 30);
                v2 = this.mask;
                if((v1 + 2 & v2) == (((int)(0x3FFFFFFFL & v)) & v2)) {
                    return 1;
                }
                if(this.singleConsumer || this.getArray().get(v1 & v2) == null) {
                    break;
                }
                if(this.capacity < 0x400 || (v1 - ((int)(0x3FFFFFFFL & v)) & 0x3FFFFFFF) > this.capacity >> 1) {
                    return 1;
                }
            }
        }
        while(!LockFreeTaskQueueCore._state$volatile$FU.compareAndSet(this, v, LockFreeTaskQueueCore.Companion.updateTail(v, v1 + 1 & 0x3FFFFFFF)));
        this.getArray().set(v1 & v2, object0);
        LockFreeTaskQueueCore lockFreeTaskQueueCore0 = this;
        while((LockFreeTaskQueueCore._state$volatile$FU.get(lockFreeTaskQueueCore0) & 0x1000000000000000L) != 0L) {
            lockFreeTaskQueueCore0 = lockFreeTaskQueueCore0.next().fillPlaceholder(v1, object0);
            if(lockFreeTaskQueueCore0 == null) {
                break;
            }
        }
        return 0;
    }

    private final LockFreeTaskQueueCore allocateNextCopy(long v) {
        LockFreeTaskQueueCore lockFreeTaskQueueCore0 = new LockFreeTaskQueueCore(this.capacity * 2, this.singleConsumer);
        for(int v1 = (int)(0x3FFFFFFFL & v); (v1 & this.mask) != (this.mask & ((int)((0xFFFFFFFC0000000L & v) >> 30))); ++v1) {
            Placeholder lockFreeTaskQueueCore$Placeholder0 = this.getArray().get(this.mask & v1);
            if(lockFreeTaskQueueCore$Placeholder0 == null) {
                lockFreeTaskQueueCore$Placeholder0 = new Placeholder(v1);
            }
            lockFreeTaskQueueCore0.getArray().set(lockFreeTaskQueueCore0.mask & v1, lockFreeTaskQueueCore$Placeholder0);
        }
        LockFreeTaskQueueCore.get_state$volatile$FU().set(lockFreeTaskQueueCore0, v & 0xEFFFFFFFFFFFFFFFL);
        return lockFreeTaskQueueCore0;
    }

    private final LockFreeTaskQueueCore allocateOrGetNextCopy(long v) {
        LockFreeTaskQueueCore lockFreeTaskQueueCore0;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater0 = LockFreeTaskQueueCore.get_next$volatile$FU();
        while(true) {
            lockFreeTaskQueueCore0 = (LockFreeTaskQueueCore)atomicReferenceFieldUpdater0.get(this);
            if(lockFreeTaskQueueCore0 != null) {
                break;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater1 = LockFreeTaskQueueCore.get_next$volatile$FU();
            LockFreeTaskQueueCore lockFreeTaskQueueCore1 = this.allocateNextCopy(v);
            while(!atomicReferenceFieldUpdater1.compareAndSet(this, null, lockFreeTaskQueueCore1) && atomicReferenceFieldUpdater1.get(this) == null) {
            }
        }
        return lockFreeTaskQueueCore0;
    }

    public final boolean close() {
        AtomicLongFieldUpdater atomicLongFieldUpdater0 = LockFreeTaskQueueCore._state$volatile$FU;
        do {
            long v = atomicLongFieldUpdater0.get(this);
            if(Long.compare(v & 0x2000000000000000L, 0L) != 0) {
                return true;
            }
            if((0x1000000000000000L & v) != 0L) {
                return false;
            }
        }
        while(!atomicLongFieldUpdater0.compareAndSet(this, v, 0x2000000000000000L | v));
        return true;
    }

    private final LockFreeTaskQueueCore fillPlaceholder(int v, Object object0) {
        Object object1 = this.getArray().get(this.mask & v);
        if(object1 instanceof Placeholder && ((Placeholder)object1).index == v) {
            this.getArray().set(v & this.mask, object0);
            return this;
        }
        return null;
    }

    private final AtomicReferenceArray getArray() {
        return this.array;
    }

    public final int getSize() {
        long v = LockFreeTaskQueueCore._state$volatile$FU.get(this);
        return ((int)((v & 0xFFFFFFFC0000000L) >> 30)) - ((int)(0x3FFFFFFFL & v)) & 0x3FFFFFFF;
    }

    private static final AtomicReferenceFieldUpdater get_next$volatile$FU() {
        return LockFreeTaskQueueCore._next$volatile$FU;
    }

    public final boolean isEmpty() {
        long v = LockFreeTaskQueueCore._state$volatile$FU.get(this);
        return ((int)(0x3FFFFFFFL & v)) == ((int)((v & 0xFFFFFFFC0000000L) >> 30));
    }

    private final long markFrozen() {
        long v;
        AtomicLongFieldUpdater atomicLongFieldUpdater0 = LockFreeTaskQueueCore._state$volatile$FU;
        do {
            v = atomicLongFieldUpdater0.get(this);
            if((v & 0x1000000000000000L) != 0L) {
                return v;
            }
        }
        while(!atomicLongFieldUpdater0.compareAndSet(this, v, 0x1000000000000000L | v));
        return 0x1000000000000000L | v;
    }

    @NotNull
    public final LockFreeTaskQueueCore next() {
        return this.allocateOrGetNextCopy(this.markFrozen());
    }

    @Nullable
    public final Object removeFirstOrNull() {
        int v1;
        Object object0;
        long v;
        AtomicLongFieldUpdater atomicLongFieldUpdater0 = LockFreeTaskQueueCore._state$volatile$FU;
        do {
            while(true) {
                v = atomicLongFieldUpdater0.get(this);
                if((0x1000000000000000L & v) != 0L) {
                    return LockFreeTaskQueueCore.REMOVE_FROZEN;
                }
                if((((int)((0xFFFFFFFC0000000L & v) >> 30)) & this.mask) == (this.mask & ((int)(0x3FFFFFFFL & v)))) {
                    return null;
                }
                object0 = this.getArray().get(this.mask & ((int)(0x3FFFFFFFL & v)));
                if(object0 != null) {
                    break;
                }
                if(this.singleConsumer) {
                    return null;
                }
            }
            if(object0 instanceof Placeholder) {
                return null;
            }
            v1 = ((int)(0x3FFFFFFFL & v)) + 1 & 0x3FFFFFFF;
            if(LockFreeTaskQueueCore._state$volatile$FU.compareAndSet(this, v, LockFreeTaskQueueCore.Companion.updateHead(v, v1))) {
                this.getArray().set(this.mask & ((int)(0x3FFFFFFFL & v)), null);
                return object0;
            }
        }
        while(!this.singleConsumer);
        LockFreeTaskQueueCore lockFreeTaskQueueCore0 = this;
        do {
            lockFreeTaskQueueCore0 = lockFreeTaskQueueCore0.removeSlowPath(((int)(0x3FFFFFFFL & v)), v1);
        }
        while(lockFreeTaskQueueCore0 != null);
        return object0;
    }

    private final LockFreeTaskQueueCore removeSlowPath(int v, int v1) {
        int v3;
        AtomicLongFieldUpdater atomicLongFieldUpdater0 = LockFreeTaskQueueCore._state$volatile$FU;
        do {
            long v2 = atomicLongFieldUpdater0.get(this);
            v3 = (int)(0x3FFFFFFFL & v2);
            if((0x1000000000000000L & v2) != 0L) {
                return this.next();
            }
        }
        while(!LockFreeTaskQueueCore._state$volatile$FU.compareAndSet(this, v2, LockFreeTaskQueueCore.Companion.updateHead(v2, v1)));
        this.getArray().set(this.mask & v3, null);
        return null;
    }
}

