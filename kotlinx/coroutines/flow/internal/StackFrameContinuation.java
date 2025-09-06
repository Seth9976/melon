package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import me.i;
import oe.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001D\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001D\u0010\r\u001A\u00020\f2\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u001A\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000FR\u001A\u0010\u0007\u001A\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0015\u001A\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/flow/internal/StackFrameContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Loe/d;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "uCont", "Lme/i;", "context", "<init>", "(Lkotlin/coroutines/Continuation;Lme/i;)V", "Lie/p;", "result", "Lie/H;", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/coroutines/Continuation;", "Lme/i;", "getContext", "()Lme/i;", "getCallerFrame", "()Loe/d;", "callerFrame", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class StackFrameContinuation implements Continuation, d {
    @NotNull
    private final i context;
    @NotNull
    private final Continuation uCont;

    public StackFrameContinuation(@NotNull Continuation continuation0, @NotNull i i0) {
        this.uCont = continuation0;
        this.context = i0;
    }

    // 去混淆评级： 低(20)
    @Override  // oe.d
    @Nullable
    public d getCallerFrame() {
        return this.uCont instanceof d ? ((d)this.uCont) : null;
    }

    @Override  // kotlin.coroutines.Continuation
    @NotNull
    public i getContext() {
        return this.context;
    }

    @Override  // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object object0) {
        this.uCont.resumeWith(object0);
    }
}

