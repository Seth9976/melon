package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0017\u0010\u0002\u001A\u00020\u00002\u0006\u0010\u0001\u001A\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0014\u0010\u0007\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006*\u001E\b\u0002\u0010\n\u001A\u0004\b\u0000\u0010\b\"\b\u0012\u0004\u0012\u00028\u00000\t2\b\u0012\u0004\u0012\u00028\u00000\t¨\u0006\u000B"}, d2 = {"", "timeMillis", "delayToNanos", "(J)J", "Lkotlinx/coroutines/internal/Symbol;", "DISPOSED_TASK", "Lkotlinx/coroutines/internal/Symbol;", "CLOSED_EMPTY", "T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Queue", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class EventLoop_commonKt {
    @NotNull
    private static final Symbol CLOSED_EMPTY;
    @NotNull
    private static final Symbol DISPOSED_TASK;

    static {
        EventLoop_commonKt.DISPOSED_TASK = new Symbol("REMOVED_TASK");
        EventLoop_commonKt.CLOSED_EMPTY = new Symbol("CLOSED_EMPTY");
    }

    public static final Symbol access$getCLOSED_EMPTY$p() {
        return EventLoop_commonKt.CLOSED_EMPTY;
    }

    public static final Symbol access$getDISPOSED_TASK$p() {
        return EventLoop_commonKt.DISPOSED_TASK;
    }

    public static final long delayToNanos(long v) {
        if(v <= 0L) {
            return 0L;
        }
        return v < 0x8637BD05AF6L ? v * 1000000L : 0x7FFFFFFFFFFFFFFFL;
    }
}

