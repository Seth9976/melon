package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"kotlinx/coroutines/JobKt__JobKt"}, d2 = {}, k = 4, mv = {2, 1, 0}, xi = 0x30)
public abstract class JobKt {
    @NotNull
    public static final CompletableJob Job(@Nullable Job job0) {
        return JobKt__JobKt.Job(job0);
    }

    public static final void cancel(@NotNull Job job0, @NotNull String s, @Nullable Throwable throwable0) {
        JobKt__JobKt.cancel(job0, s, throwable0);
    }

    public static final void cancel(@NotNull i i0, @Nullable CancellationException cancellationException0) {
        JobKt__JobKt.cancel(i0, cancellationException0);
    }

    @Nullable
    public static final Object cancelAndJoin(@NotNull Job job0, @NotNull Continuation continuation0) {
        return JobKt__JobKt.cancelAndJoin(job0, continuation0);
    }

    @NotNull
    public static final DisposableHandle disposeOnCompletion(@NotNull Job job0, @NotNull DisposableHandle disposableHandle0) {
        return JobKt__JobKt.disposeOnCompletion(job0, disposableHandle0);
    }

    public static final void ensureActive(@NotNull Job job0) {
        JobKt__JobKt.ensureActive(job0);
    }

    public static final void ensureActive(@NotNull i i0) {
        JobKt__JobKt.ensureActive(i0);
    }

    @NotNull
    public static final Job getJob(@NotNull i i0) {
        return JobKt__JobKt.getJob(i0);
    }

    @NotNull
    public static final DisposableHandle invokeOnCompletion(@NotNull Job job0, boolean z, @NotNull JobNode jobNode0) {
        return JobKt__JobKt.invokeOnCompletion(job0, z, jobNode0);
    }

    public static final boolean isActive(@NotNull i i0) {
        return JobKt__JobKt.isActive(i0);
    }
}

