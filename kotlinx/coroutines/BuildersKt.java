package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"}, k = 4, mv = {2, 1, 0}, xi = 0x30)
public abstract class BuildersKt {
    @NotNull
    public static final Deferred async(@NotNull CoroutineScope coroutineScope0, @NotNull i i0, @NotNull CoroutineStart coroutineStart0, @NotNull n n0) {
        return BuildersKt__Builders_commonKt.async(coroutineScope0, i0, coroutineStart0, n0);
    }

    @NotNull
    public static final Job launch(@NotNull CoroutineScope coroutineScope0, @NotNull i i0, @NotNull CoroutineStart coroutineStart0, @NotNull n n0) {
        return BuildersKt__Builders_commonKt.launch(coroutineScope0, i0, coroutineStart0, n0);
    }

    public static final Object runBlocking(@NotNull i i0, @NotNull n n0) {
        return BuildersKt__BuildersKt.runBlocking(i0, n0);
    }

    @Nullable
    public static final Object withContext(@NotNull i i0, @NotNull n n0, @NotNull Continuation continuation0) {
        return BuildersKt__Builders_commonKt.withContext(i0, n0, continuation0);
    }
}

