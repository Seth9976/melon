package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.ScopeCoroutine;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\n\b\u0001\u0010\u0002 \u0000*\u00028\u00002\b\u0012\u0004\u0012\u00028\u00010\u00032\u00060\u0004j\u0002`\u0005B\u001D\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u0012\u001A\u00020\u000FH\u0010¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0007\u001A\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/TimeoutCoroutine;", "U", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "time", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(JLkotlin/coroutines/Continuation;)V", "Lie/H;", "run", "()V", "", "nameString$kotlinx_coroutines_core", "()Ljava/lang/String;", "nameString", "J", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class TimeoutCoroutine extends ScopeCoroutine implements Runnable {
    public final long time;

    public TimeoutCoroutine(long v, @NotNull Continuation continuation0) {
        super(continuation0.getContext(), continuation0);
        this.time = v;
    }

    @Override  // kotlinx.coroutines.AbstractCoroutine
    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        return super.nameString$kotlinx_coroutines_core() + "(timeMillis=" + this.time + ')';
    }

    @Override
    public void run() {
        Delay delay0 = DelayKt.getDelay(this.getContext());
        this.cancelCoroutine(TimeoutKt.TimeoutCancellationException(this.time, delay0, this));
    }
}

