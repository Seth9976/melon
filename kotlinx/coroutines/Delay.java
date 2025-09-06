package kotlinx.coroutines;

import e1.u;
import ie.H;
import ie.d;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import me.i;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J%\u0010\u0007\u001A\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u00022\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0003\u001A\u00020\u00022\n\u0010\u000B\u001A\u00060\tj\u0002`\n2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/Delay;", "", "", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "Lie/H;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lme/i;", "context", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnTimeout", "(JLjava/lang/Runnable;Lme/i;)Lkotlinx/coroutines/DisposableHandle;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface Delay {
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
    public static abstract class DefaultImpls {
        @d
        @Nullable
        public static Object delay(@NotNull Delay delay0, long v, @NotNull Continuation continuation0) {
            H h0 = H.a;
            if(Long.compare(v, 0L) <= 0) {
                return h0;
            }
            CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
            cancellableContinuationImpl0.initCancellability();
            delay0.scheduleResumeAfterDelay(v, cancellableContinuationImpl0);
            Object object0 = cancellableContinuationImpl0.getResult();
            return object0 == a.a ? object0 : h0;
        }

        @NotNull
        public static DisposableHandle invokeOnTimeout(@NotNull Delay delay0, long v, @NotNull Runnable runnable0, @NotNull i i0) {
            return DefaultExecutorKt.getDefaultDelay().invokeOnTimeout(v, runnable0, i0);
        }
    }

    @NotNull
    DisposableHandle invokeOnTimeout(long arg1, @NotNull Runnable arg2, @NotNull i arg3);

    void scheduleResumeAfterDelay(long arg1, @NotNull CancellableContinuation arg2);
}

