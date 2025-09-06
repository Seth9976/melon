package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0017\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0001\u001A\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0014\u0010\b\u001A\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"", "locked", "Lkotlinx/coroutines/sync/Mutex;", "Mutex", "(Z)Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/internal/Symbol;", "NO_OWNER", "Lkotlinx/coroutines/internal/Symbol;", "ON_LOCK_ALREADY_LOCKED_BY_OWNER", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class MutexKt {
    @NotNull
    private static final Symbol NO_OWNER;
    @NotNull
    private static final Symbol ON_LOCK_ALREADY_LOCKED_BY_OWNER;

    static {
        MutexKt.NO_OWNER = new Symbol("NO_OWNER");
        MutexKt.ON_LOCK_ALREADY_LOCKED_BY_OWNER = new Symbol("ALREADY_LOCKED_BY_OWNER");
    }

    @NotNull
    public static final Mutex Mutex(boolean z) {
        return new MutexImpl(z);
    }

    public static Mutex Mutex$default(boolean z, int v, Object object0) {
        if((v & 1) != 0) {
            z = false;
        }
        return MutexKt.Mutex(z);
    }
}

