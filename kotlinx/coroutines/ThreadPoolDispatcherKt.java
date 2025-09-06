package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"kotlinx/coroutines/ThreadPoolDispatcherKt__MultithreadedDispatchers_commonKt", "kotlinx/coroutines/ThreadPoolDispatcherKt__ThreadPoolDispatcherKt"}, k = 4, mv = {2, 1, 0}, xi = 0x30)
public abstract class ThreadPoolDispatcherKt {
    @NotNull
    public static final ExecutorCoroutineDispatcher newFixedThreadPoolContext(int v, @NotNull String s) {
        return ThreadPoolDispatcherKt__ThreadPoolDispatcherKt.newFixedThreadPoolContext(v, s);
    }

    @NotNull
    public static final ExecutorCoroutineDispatcher newSingleThreadContext(@NotNull String s) {
        return ThreadPoolDispatcherKt__MultithreadedDispatchers_commonKt.newSingleThreadContext(s);
    }
}

