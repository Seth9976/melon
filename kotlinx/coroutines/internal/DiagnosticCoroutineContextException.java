package kotlinx.coroutines.internal;

import kotlin.Metadata;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fR\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\r¨\u0006\u000E"}, d2 = {"Lkotlinx/coroutines/internal/DiagnosticCoroutineContextException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Lme/i;", "context", "<init>", "(Lme/i;)V", "", "getLocalizedMessage", "()Ljava/lang/String;", "", "fillInStackTrace", "()Ljava/lang/Throwable;", "Lme/i;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class DiagnosticCoroutineContextException extends RuntimeException {
    @Nullable
    private final transient i context;

    public DiagnosticCoroutineContextException(@NotNull i i0) {
        this.context = i0;
    }

    @Override
    @NotNull
    public Throwable fillInStackTrace() {
        this.setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override
    @NotNull
    public String getLocalizedMessage() {
        return String.valueOf(this.context);
    }
}

