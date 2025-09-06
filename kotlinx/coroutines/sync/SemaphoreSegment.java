package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Segment;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\u00052\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001A\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0019\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00178\u0006¨\u0006\u001A"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreSegment;", "Lkotlinx/coroutines/internal/Segment;", "", "id", "prev", "", "pointers", "<init>", "(JLkotlinx/coroutines/sync/SemaphoreSegment;I)V", "index", "", "cause", "Lme/i;", "context", "Lie/H;", "onCancellation", "(ILjava/lang/Throwable;Lme/i;)V", "", "toString", "()Ljava/lang/String;", "getNumberOfSlots", "()I", "numberOfSlots", "Lkotlinx/atomicfu/AtomicArray;", "", "acquirers", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class SemaphoreSegment extends Segment {
    private final AtomicReferenceArray acquirers;

    public SemaphoreSegment(long v, @Nullable SemaphoreSegment semaphoreSegment0, int v1) {
        super(v, semaphoreSegment0, v1);
        this.acquirers = new AtomicReferenceArray(16);
    }

    public final AtomicReferenceArray getAcquirers() {
        return this.acquirers;
    }

    // 去混淆评级： 低(20)
    @Override  // kotlinx.coroutines.internal.Segment
    public int getNumberOfSlots() {
        return 16;
    }

    @Override  // kotlinx.coroutines.internal.Segment
    public void onCancellation(int v, @Nullable Throwable throwable0, @NotNull i i0) {
        this.getAcquirers().set(v, SemaphoreKt.CANCELLED);
        this.onSlotCleaned();
    }

    @Override
    @NotNull
    public String toString() {
        return "SemaphoreSegment[id=" + this.id + ", hashCode=" + this.hashCode() + ']';
    }
}

