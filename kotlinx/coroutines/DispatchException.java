package kotlinx.coroutines;

import kotlin.Metadata;
import me.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001F\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u001A\u0010\u0004\u001A\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000B\u001A\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lkotlinx/coroutines/DispatchException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "cause", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lme/i;", "context", "<init>", "(Ljava/lang/Throwable;Lkotlinx/coroutines/CoroutineDispatcher;Lme/i;)V", "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class DispatchException extends Exception {
    @NotNull
    private final Throwable cause;

    public DispatchException(@NotNull Throwable throwable0, @NotNull CoroutineDispatcher coroutineDispatcher0, @NotNull i i0) {
        super("Coroutine dispatcher " + coroutineDispatcher0 + " threw an exception, context = " + i0, throwable0);
        this.cause = throwable0;
    }

    @Override
    @NotNull
    public Throwable getCause() {
        return this.cause;
    }
}

