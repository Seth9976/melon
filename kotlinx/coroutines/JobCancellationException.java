package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B!\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0012\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u0003H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0015\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001A\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\t\u001A\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "", "message", "", "cause", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V", "fillInStackTrace", "()Ljava/lang/Throwable;", "toString", "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "_job", "Lkotlinx/coroutines/Job;", "getJob$kotlinx_coroutines_core", "()Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class JobCancellationException extends CancellationException {
    @Nullable
    private final transient Job _job;

    public JobCancellationException(@NotNull String s, @Nullable Throwable throwable0, @NotNull Job job0) {
        super(s);
        this._job = job0;
        if(throwable0 != null) {
            this.initCause(throwable0);
        }
    }

    // 去混淆评级： 低(40)
    @Override
    public boolean equals(@Nullable Object object0) {
        return object0 == this || object0 instanceof JobCancellationException && q.b(((JobCancellationException)object0).getMessage(), this.getMessage()) && q.b(((JobCancellationException)object0).getJob$kotlinx_coroutines_core(), this.getJob$kotlinx_coroutines_core()) && q.b(((JobCancellationException)object0).getCause(), this.getCause());
    }

    @Override
    @NotNull
    public Throwable fillInStackTrace() {
        this.setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @NotNull
    public final Job getJob$kotlinx_coroutines_core() {
        Job job0 = this._job;
        return job0 == null ? NonCancellable.INSTANCE : job0;
    }

    @Override
    public int hashCode() {
        String s = this.getMessage();
        q.d(s);
        int v = s.hashCode();
        Job job0 = this.getJob$kotlinx_coroutines_core();
        int v1 = 0;
        int v2 = job0 == null ? 0 : job0.hashCode();
        Throwable throwable0 = this.getCause();
        if(throwable0 != null) {
            v1 = throwable0.hashCode();
        }
        return (v * 0x1F + v2) * 0x1F + v1;
    }

    @Override
    @NotNull
    public String toString() {
        return super.toString() + "; job=" + this.getJob$kotlinx_coroutines_core();
    }
}

