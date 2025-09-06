package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.NotCompleted;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000*\u000E\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B!\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\b\u0010\u0006\u001A\u0004\u0018\u00018\u0000\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0000¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u0010\u001A\u00020\u000BH\u0000¢\u0006\u0004\b\u000F\u0010\rJ)\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0011\u001A\u00020\u00072\b\u0010\u0013\u001A\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001A\u00020\u0014H&¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001A\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u0014\u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001BR\u0014\u0010\u001E\u001A\u00020\u00078&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001F\u001A\u00020\u000B8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010\rR\u000B\u0010!\u001A\u00020 8\u0002X\u0082\u0004¨\u0006\""}, d2 = {"Lkotlinx/coroutines/internal/Segment;", "S", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "Lkotlinx/coroutines/NotCompleted;", "", "id", "prev", "", "pointers", "<init>", "(JLkotlinx/coroutines/internal/Segment;I)V", "", "tryIncPointers$kotlinx_coroutines_core", "()Z", "tryIncPointers", "decPointers$kotlinx_coroutines_core", "decPointers", "index", "", "cause", "Lme/i;", "context", "Lie/H;", "onCancellation", "(ILjava/lang/Throwable;Lme/i;)V", "onSlotCleaned", "()V", "J", "getNumberOfSlots", "()I", "numberOfSlots", "isRemoved", "Lkotlinx/atomicfu/AtomicInt;", "cleanedAndPointers", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class Segment extends ConcurrentLinkedListNode implements NotCompleted {
    private volatile int cleanedAndPointers$volatile;
    private static final AtomicIntegerFieldUpdater cleanedAndPointers$volatile$FU;
    public final long id;

    static {
        Segment.cleanedAndPointers$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(Segment.class, "cleanedAndPointers$volatile");
    }

    public Segment(long v, @Nullable Segment segment0, int v1) {
        super(segment0);
        this.id = v;
        this.cleanedAndPointers$volatile = v1 << 16;
    }

    public final boolean decPointers$kotlinx_coroutines_core() {
        return Segment.cleanedAndPointers$volatile$FU.addAndGet(this, 0xFFFF0000) == this.getNumberOfSlots() && !this.isTail();
    }

    public abstract int getNumberOfSlots();

    @Override  // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    public boolean isRemoved() {
        return Segment.cleanedAndPointers$volatile$FU.get(this) == this.getNumberOfSlots() && !this.isTail();
    }

    public abstract void onCancellation(int arg1, @Nullable Throwable arg2, @NotNull i arg3);

    public final void onSlotCleaned() {
        if(Segment.cleanedAndPointers$volatile$FU.incrementAndGet(this) == this.getNumberOfSlots()) {
            this.remove();
        }
    }

    public final boolean tryIncPointers$kotlinx_coroutines_core() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater0 = Segment.cleanedAndPointers$volatile$FU;
        do {
            int v = atomicIntegerFieldUpdater0.get(this);
            if(v == this.getNumberOfSlots() && !this.isTail()) {
                return false;
            }
        }
        while(!atomicIntegerFieldUpdater0.compareAndSet(this, v, v + 0x10000));
        return true;
    }
}

