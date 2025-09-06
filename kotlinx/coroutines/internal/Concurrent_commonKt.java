package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\"D\u0010\u0003\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u00022\u0006\u0010\u0003\u001A\u00028\u00008@@@X\u0080\u000E¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001A\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"T", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/internal/WorkaroundAtomicReference;", "value", "getValue", "(Ljava/util/concurrent/atomic/AtomicReference;)Ljava/lang/Object;", "setValue", "(Ljava/util/concurrent/atomic/AtomicReference;Ljava/lang/Object;)V", "getValue$annotations", "(Ljava/util/concurrent/atomic/AtomicReference;)V", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class Concurrent_commonKt {
    public static final Object getValue(@NotNull AtomicReference atomicReference0) {
        return atomicReference0.get();
    }

    public static final void setValue(@NotNull AtomicReference atomicReference0, Object object0) {
        atomicReference0.set(object0);
    }
}

