package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u001B\b\u0000\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0010\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\b\u0010\nR\u0016\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u000B¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "", "message", "Lkotlinx/coroutines/Job;", "coroutine", "<init>", "(Ljava/lang/String;Lkotlinx/coroutines/Job;)V", "(Ljava/lang/String;)V", "Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class TimeoutCancellationException extends CancellationException {
    @Nullable
    public final transient Job coroutine;

    public TimeoutCancellationException(@NotNull String s) {
        this(s, null);
    }

    public TimeoutCancellationException(@NotNull String s, @Nullable Job job0) {
        super(s);
        this.coroutine = job0;
    }
}

