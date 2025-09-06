package kotlinx.coroutines;

import d5.n;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u0011\b\u0000\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u000B\u001A\u0004\u0018\u00010\bH ¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0012\u001A\u00020\u000F2\b\u0010\f\u001A\u0004\u0018\u00010\b2\u0006\u0010\u000E\u001A\u00020\rH\u0010¢\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0016\u001A\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0013\u001A\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u001B\u0010\u0019\u001A\u0004\u0018\u00010\r2\b\u0010\u0013\u001A\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001A\u001A\u00020\u000F¢\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001F\u001A\u00020\u000F2\u0006\u0010\u001C\u001A\u00020\rH\u0000¢\u0006\u0004\b\u001D\u0010\u001ER\u0016\u0010\u0005\u001A\u00020\u00048\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\u0005\u0010 R\u001A\u0010$\u001A\b\u0012\u0004\u0012\u00028\u00000!8 X \u0004¢\u0006\u0006\u001A\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "", "resumeMode", "<init>", "(I)V", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "takenState", "", "cause", "Lie/H;", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "state", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "run", "()V", "exception", "handleFatalException$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "handleFatalException", "I", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class DispatchedTask extends Task {
    public int resumeMode;

    public DispatchedTask(int v) {
        this.resumeMode = v;
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(@Nullable Object object0, @NotNull Throwable throwable0) {
    }

    @NotNull
    public abstract Continuation getDelegate$kotlinx_coroutines_core();

    @Nullable
    public Throwable getExceptionalResult$kotlinx_coroutines_core(@Nullable Object object0) {
        CompletedExceptionally completedExceptionally0 = object0 instanceof CompletedExceptionally ? ((CompletedExceptionally)object0) : null;
        return completedExceptionally0 == null ? null : completedExceptionally0.cause;
    }

    public Object getSuccessfulResult$kotlinx_coroutines_core(@Nullable Object object0) {
        return object0;
    }

    public final void handleFatalException$kotlinx_coroutines_core(@NotNull Throwable throwable0) {
        CoroutinesInternalError coroutinesInternalError0 = new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to \'handleFatalException\' method and report this incident to maintainers", throwable0);
        CoroutineExceptionHandlerKt.handleCoroutineException(this.getDelegate$kotlinx_coroutines_core().getContext(), coroutinesInternalError0);
    }

    @Override
    public final void run() {
        Job job0;
        Object object0;
        i i0;
        Continuation continuation1;
        try {
            Continuation continuation0 = this.getDelegate$kotlinx_coroutines_core();
            q.e(continuation0, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            continuation1 = ((DispatchedContinuation)continuation0).continuation;
            i0 = continuation1.getContext();
            object0 = ThreadContextKt.updateThreadContext(i0, ((DispatchedContinuation)continuation0).countOrElement);
            job0 = null;
            UndispatchedCoroutine undispatchedCoroutine0 = object0 == ThreadContextKt.NO_THREAD_ELEMENTS ? null : CoroutineContextKt.updateUndispatchedCompletion(continuation1, i0, object0);
        }
        catch(DispatchException dispatchException0) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getDelegate$kotlinx_coroutines_core().getContext(), dispatchException0.getCause());
            return;
        }
        catch(Throwable throwable0) {
            this.handleFatalException$kotlinx_coroutines_core(throwable0);
            return;
        }
        try {
            i i1 = continuation1.getContext();
            Object object1 = this.takeState$kotlinx_coroutines_core();
            Throwable throwable2 = this.getExceptionalResult$kotlinx_coroutines_core(object1);
            if(throwable2 == null && DispatchedTaskKt.isCancellableMode(this.resumeMode)) {
                job0 = (Job)i1.get(Job.Key);
            }
            if(job0 != null && !job0.isActive()) {
                CancellationException cancellationException0 = job0.getCancellationException();
                this.cancelCompletedResult$kotlinx_coroutines_core(object1, cancellationException0);
                continuation1.resumeWith(n.t(cancellationException0));
            }
            else if(throwable2 != null) {
                continuation1.resumeWith(n.t(throwable2));
            }
            else {
                continuation1.resumeWith(this.getSuccessfulResult$kotlinx_coroutines_core(object1));
            }
            goto label_26;
        }
        catch(Throwable throwable1) {
        }
        try {
            if(undispatchedCoroutine0 == null || undispatchedCoroutine0.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(i0, object0);
            }
            throw throwable1;
        label_26:
            if(undispatchedCoroutine0 == null || undispatchedCoroutine0.clearThreadContext()) {
                ThreadContextKt.restoreThreadContext(i0, object0);
            }
        }
        catch(DispatchException dispatchException0) {
            CoroutineExceptionHandlerKt.handleCoroutineException(this.getDelegate$kotlinx_coroutines_core().getContext(), dispatchException0.getCause());
        }
        catch(Throwable throwable0) {
            this.handleFatalException$kotlinx_coroutines_core(throwable0);
        }
    }

    @Nullable
    public abstract Object takeState$kotlinx_coroutines_core();
}

