package kotlinx.coroutines.internal;

import e1.u;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CompletionStateKt;
import me.i;
import oe.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001D\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\f\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000E\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0014¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0014¢\u0006\u0004\b\u0012\u0010\u000FR\u001A\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0013R\u0019\u0010\u0016\u001A\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048F¢\u0006\u0006\u001A\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001A\u00020\u00178DX\u0084\u0004¢\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lkotlinx/coroutines/internal/ScopeCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Loe/d;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lme/i;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lme/i;Lkotlin/coroutines/Continuation;)V", "", "state", "Lie/H;", "afterCompletion", "(Ljava/lang/Object;)V", "afterCompletionUndispatched", "()V", "afterResume", "Lkotlin/coroutines/Continuation;", "getCallerFrame", "()Loe/d;", "callerFrame", "", "isScopedCoroutine", "()Z", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public class ScopeCoroutine extends AbstractCoroutine implements d {
    @NotNull
    public final Continuation uCont;

    public ScopeCoroutine(@NotNull i i0, @NotNull Continuation continuation0) {
        super(i0, true, true);
        this.uCont = continuation0;
    }

    @Override  // kotlinx.coroutines.JobSupport
    public void afterCompletion(@Nullable Object object0) {
        DispatchedContinuationKt.resumeCancellableWith(u.D(this.uCont), CompletionStateKt.recoverResult(object0, this.uCont));
    }

    public void afterCompletionUndispatched() {
    }

    @Override  // kotlinx.coroutines.AbstractCoroutine
    public void afterResume(@Nullable Object object0) {
        Object object1 = CompletionStateKt.recoverResult(object0, this.uCont);
        this.uCont.resumeWith(object1);
    }

    // 去混淆评级： 低(20)
    @Override  // oe.d
    @Nullable
    public final d getCallerFrame() {
        return this.uCont instanceof d ? ((d)this.uCont) : null;
    }

    @Override  // kotlinx.coroutines.JobSupport
    public final boolean isScopedCoroutine() {
        return true;
    }
}

