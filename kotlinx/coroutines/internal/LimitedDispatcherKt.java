package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\u001A\u0013\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001A\u001D\u0010\u0007\u001A\u00020\u0004*\u00020\u00042\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "Lie/H;", "checkParallelism", "(I)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "", "name", "namedOrThis", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/String;)Lkotlinx/coroutines/CoroutineDispatcher;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class LimitedDispatcherKt {
    public static final void checkParallelism(int v) {
        if(v < 1) {
            throw new IllegalArgumentException(("Expected positive parallelism level, but got " + v).toString());
        }
    }

    @NotNull
    public static final CoroutineDispatcher namedOrThis(@NotNull CoroutineDispatcher coroutineDispatcher0, @Nullable String s) {
        return s != null ? new NamedDispatcher(coroutineDispatcher0, s) : coroutineDispatcher0;
    }
}

