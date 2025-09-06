package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0017\u0010\u0001\u001A\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001A\u0017\u0010\u0003\u001A\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0002\"\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0014\u0010\u0007\u001A\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006\"\u0014\u0010\b\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0006\"\u0014\u0010\t\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0006\"\u0014\u0010\n\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0006\"\u0014\u0010\f\u001A\u00020\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r\"\u0014\u0010\u000E\u001A\u00020\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\r¨\u0006\u000F"}, d2 = {"", "boxIncomplete", "(Ljava/lang/Object;)Ljava/lang/Object;", "unboxState", "Lkotlinx/coroutines/internal/Symbol;", "COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "COMPLETING_WAITING_CHILDREN", "COMPLETING_RETRY", "TOO_LATE_TO_CANCEL", "SEALED", "Lkotlinx/coroutines/Empty;", "EMPTY_NEW", "Lkotlinx/coroutines/Empty;", "EMPTY_ACTIVE", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class JobSupportKt {
    @NotNull
    private static final Symbol COMPLETING_ALREADY;
    @NotNull
    private static final Symbol COMPLETING_RETRY;
    @NotNull
    public static final Symbol COMPLETING_WAITING_CHILDREN;
    @NotNull
    private static final Empty EMPTY_ACTIVE;
    @NotNull
    private static final Empty EMPTY_NEW;
    @NotNull
    private static final Symbol SEALED;
    @NotNull
    private static final Symbol TOO_LATE_TO_CANCEL;

    static {
        JobSupportKt.COMPLETING_ALREADY = new Symbol("COMPLETING_ALREADY");
        JobSupportKt.COMPLETING_WAITING_CHILDREN = new Symbol("COMPLETING_WAITING_CHILDREN");
        JobSupportKt.COMPLETING_RETRY = new Symbol("COMPLETING_RETRY");
        JobSupportKt.TOO_LATE_TO_CANCEL = new Symbol("TOO_LATE_TO_CANCEL");
        JobSupportKt.SEALED = new Symbol("SEALED");
        JobSupportKt.EMPTY_NEW = new Empty(false);
        JobSupportKt.EMPTY_ACTIVE = new Empty(true);
    }

    public static final Symbol access$getCOMPLETING_ALREADY$p() {
        return JobSupportKt.COMPLETING_ALREADY;
    }

    public static final Symbol access$getCOMPLETING_RETRY$p() {
        return JobSupportKt.COMPLETING_RETRY;
    }

    public static final Empty access$getEMPTY_ACTIVE$p() {
        return JobSupportKt.EMPTY_ACTIVE;
    }

    public static final Empty access$getEMPTY_NEW$p() {
        return JobSupportKt.EMPTY_NEW;
    }

    public static final Symbol access$getSEALED$p() {
        return JobSupportKt.SEALED;
    }

    public static final Symbol access$getTOO_LATE_TO_CANCEL$p() {
        return JobSupportKt.TOO_LATE_TO_CANCEL;
    }

    @Nullable
    public static final Object boxIncomplete(@Nullable Object object0) {
        return object0 instanceof Incomplete ? new IncompleteStateBox(((Incomplete)object0)) : object0;
    }

    @Nullable
    public static final Object unboxState(@Nullable Object object0) {
        IncompleteStateBox incompleteStateBox0 = object0 instanceof IncompleteStateBox ? ((IncompleteStateBox)object0) : null;
        if(incompleteStateBox0 != null) {
            Incomplete incomplete0 = incompleteStateBox0.state;
            if(incomplete0 != null) {
                return incomplete0;
            }
        }
        return object0;
    }
}

