package kotlinx.coroutines;

import ie.m;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import me.e;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001D\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000E\u001A\u00020\t2\u0006\u0010\u0004\u001A\u00020\u00032\b\u0010\r\u001A\u0004\u0018\u00010\f¢\u0006\u0004\b\u000E\u0010\u000FJ\r\u0010\u0011\u001A\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u000BJ\u0019\u0010\u0015\u001A\u00020\t2\b\u0010\u0014\u001A\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u0015\u0010\u0016R(\u0010\u0019\u001A\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u0016\u0010\u001B\u001A\u00020\u00108\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2 = {"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lme/i;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lme/i;Lkotlin/coroutines/Continuation;)V", "Lie/H;", "clearThreadLocal", "()V", "", "oldValue", "saveThreadContext", "(Lme/i;Ljava/lang/Object;)V", "", "clearThreadContext", "()Z", "afterCompletionUndispatched", "state", "afterResume", "(Ljava/lang/Object;)V", "Ljava/lang/ThreadLocal;", "Lie/m;", "threadStateToRecover", "Ljava/lang/ThreadLocal;", "threadLocalIsSet", "Z", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class UndispatchedCoroutine extends ScopeCoroutine {
    private volatile boolean threadLocalIsSet;
    @NotNull
    private final ThreadLocal threadStateToRecover;

    public UndispatchedCoroutine(@NotNull i i0, @NotNull Continuation continuation0) {
        super((i0.get(UndispatchedMarker.INSTANCE) == null ? i0.plus(UndispatchedMarker.INSTANCE) : i0), continuation0);
        this.threadStateToRecover = new ThreadLocal();
        if(!(continuation0.getContext().get(e.a) instanceof CoroutineDispatcher)) {
            Object object0 = ThreadContextKt.updateThreadContext(i0, null);
            ThreadContextKt.restoreThreadContext(i0, object0);
            this.saveThreadContext(i0, object0);
        }
    }

    @Override  // kotlinx.coroutines.internal.ScopeCoroutine
    public void afterCompletionUndispatched() {
        this.clearThreadLocal();
    }

    @Override  // kotlinx.coroutines.internal.ScopeCoroutine
    public void afterResume(@Nullable Object object0) {
        this.clearThreadLocal();
        Object object1 = CompletionStateKt.recoverResult(object0, this.uCont);
        Continuation continuation0 = this.uCont;
        i i0 = continuation0.getContext();
        UndispatchedCoroutine undispatchedCoroutine0 = null;
        Object object2 = ThreadContextKt.updateThreadContext(i0, null);
        if(object2 != ThreadContextKt.NO_THREAD_ELEMENTS) {
            undispatchedCoroutine0 = CoroutineContextKt.updateUndispatchedCompletion(continuation0, i0, object2);
        }
        try {
            this.uCont.resumeWith(object1);
        }
        catch(Throwable throwable0) {
            if(undispatchedCoroutine0 == null || undispatchedCoroutine0.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(i0, object2);
            }
            throw throwable0;
        }
        if(undispatchedCoroutine0 != null && !undispatchedCoroutine0.clearThreadContext()) {
            return;
        }
        ThreadContextKt.restoreThreadContext(i0, object2);
    }

    public final boolean clearThreadContext() {
        int v = !this.threadLocalIsSet || this.threadStateToRecover.get() != null ? 0 : 1;
        this.threadStateToRecover.remove();
        return v ^ 1;
    }

    private final void clearThreadLocal() {
        if(this.threadLocalIsSet) {
            m m0 = (m)this.threadStateToRecover.get();
            if(m0 != null) {
                ThreadContextKt.restoreThreadContext(((i)m0.a), m0.b);
            }
            this.threadStateToRecover.remove();
        }
    }

    public final void saveThreadContext(@NotNull i i0, @Nullable Object object0) {
        this.threadLocalIsSet = true;
        m m0 = new m(i0, object0);
        this.threadStateToRecover.set(m0);
    }
}

