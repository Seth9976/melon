package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A\u001F\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0001\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001A!\u0010\n\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u00062\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000B\"\u0014\u0010\f\u001A\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r\"\u0014\u0010\u000F\u001A\u00020\u000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010\"\u0014\u0010\u0011\u001A\u00020\u000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010\"\u0014\u0010\u0012\u001A\u00020\u000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010\"\u0014\u0010\u0013\u001A\u00020\u000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010\"\u0014\u0010\u0014\u001A\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\r¨\u0006\u0015"}, d2 = {"", "permits", "acquiredPermits", "Lkotlinx/coroutines/sync/Semaphore;", "Semaphore", "(II)Lkotlinx/coroutines/sync/Semaphore;", "", "id", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "prev", "createSegment", "(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", "MAX_SPIN_CYCLES", "I", "Lkotlinx/coroutines/internal/Symbol;", "PERMIT", "Lkotlinx/coroutines/internal/Symbol;", "TAKEN", "BROKEN", "CANCELLED", "SEGMENT_SIZE", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class SemaphoreKt {
    @NotNull
    private static final Symbol BROKEN;
    @NotNull
    private static final Symbol CANCELLED;
    private static final int MAX_SPIN_CYCLES;
    @NotNull
    private static final Symbol PERMIT;
    private static final int SEGMENT_SIZE;
    @NotNull
    private static final Symbol TAKEN;

    static {
        SemaphoreKt.MAX_SPIN_CYCLES = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        SemaphoreKt.PERMIT = new Symbol("PERMIT");
        SemaphoreKt.TAKEN = new Symbol("TAKEN");
        SemaphoreKt.BROKEN = new Symbol("BROKEN");
        SemaphoreKt.CANCELLED = new Symbol("CANCELLED");
        SemaphoreKt.SEGMENT_SIZE = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
    }

    @NotNull
    public static final Semaphore Semaphore(int v, int v1) {
        return new SemaphoreImpl(v, v1);
    }

    public static Semaphore Semaphore$default(int v, int v1, int v2, Object object0) {
        if((v2 & 2) != 0) {
            v1 = 0;
        }
        return SemaphoreKt.Semaphore(v, v1);
    }

    public static final int access$getMAX_SPIN_CYCLES$p() [...] // 潜在的解密器

    public static final int access$getSEGMENT_SIZE$p() [...] // 潜在的解密器

    private static final SemaphoreSegment createSegment(long v, SemaphoreSegment semaphoreSegment0) {
        return new SemaphoreSegment(v, semaphoreSegment0, 0);
    }
}

