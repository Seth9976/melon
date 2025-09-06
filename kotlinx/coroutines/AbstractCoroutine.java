package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0005B\u001F\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\t\u001A\u00020\b\u0012\u0006\u0010\n\u001A\u00020\b\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00028\u0000H\u0014\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0014\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0013\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0017\u001A\u00020\u0016H\u0014\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001B\u001A\u00020\u000E2\b\u0010\u001A\u001A\u0004\u0018\u00010\u0019H\u0004\u00A2\u0006\u0004\b\u001B\u0010\u0010J\u001B\u0010\u001E\u001A\u00020\u000E2\f\u0010\u001D\u001A\b\u0012\u0004\u0012\u00028\u00000\u001C\u00A2\u0006\u0004\b\u001E\u0010\u0010J\u0019\u0010\u001F\u001A\u00020\u000E2\b\u0010\u001A\u001A\u0004\u0018\u00010\u0019H\u0014\u00A2\u0006\u0004\b\u001F\u0010\u0010J\u0017\u0010#\u001A\u00020\u000E2\u0006\u0010 \u001A\u00020\u0011H\u0000\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010%\u001A\u00020\u0016H\u0010\u00A2\u0006\u0004\b$\u0010\u0018JG\u0010(\u001A\u00020\u000E\"\u0004\b\u0001\u0010&2\u0006\u0010(\u001A\u00020\'2\u0006\u0010)\u001A\u00028\u00012\"\u0010+\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00190*\u00A2\u0006\u0004\b(\u0010,R\u001D\u0010-\u001A\u00020\u00068\u0006\u00A2\u0006\u0012\n\u0004\b-\u0010.\u0012\u0004\b1\u00102\u001A\u0004\b/\u00100R\u0014\u00104\u001A\u00020\u00068VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b3\u00100R\u0014\u00105\u001A\u00020\b8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b5\u00106\u00A8\u00067"}, d2 = {"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "Lme/i;", "parentContext", "", "initParentJob", "active", "<init>", "(Lme/i;ZZ)V", "value", "Lie/H;", "onCompleted", "(Ljava/lang/Object;)V", "", "cause", "handled", "onCancelled", "(Ljava/lang/Throwable;Z)V", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "", "state", "onCompletionInternal", "Lie/p;", "result", "resumeWith", "afterResume", "exception", "handleOnCompletionException$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "handleOnCompletionException", "nameString$kotlinx_coroutines_core", "nameString", "R", "Lkotlinx/coroutines/CoroutineStart;", "start", "receiver", "Lkotlin/Function2;", "block", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lwe/n;)V", "context", "Lme/i;", "getContext", "()Lme/i;", "getContext$annotations", "()V", "getCoroutineContext", "coroutineContext", "isActive", "()Z", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class AbstractCoroutine extends JobSupport implements Continuation, CoroutineScope, Job {
    @NotNull
    private final i context;

    public AbstractCoroutine(@NotNull i i0, boolean z, boolean z1) {
        super(z1);
        if(z) {
            this.initParentJob(((Job)i0.get(Job.Key)));
        }
        this.context = i0.plus(this);
    }

    public void afterResume(@Nullable Object object0) {
        this.afterCompletion(object0);
    }

    @Override  // kotlinx.coroutines.JobSupport
    @NotNull
    public String cancellationExceptionMessage() {
        return DebugStringsKt.getClassSimpleName(this) + " was cancelled";
    }

    @Override  // kotlin.coroutines.Continuation
    @NotNull
    public final i getContext() {
        return this.context;
    }

    @Override  // kotlinx.coroutines.CoroutineScope
    @NotNull
    public i getCoroutineContext() {
        return this.context;
    }

    @Override  // kotlinx.coroutines.JobSupport
    public final void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable throwable0) {
        CoroutineExceptionHandlerKt.handleCoroutineException(this.context, throwable0);
    }

    @Override  // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    @Override  // kotlinx.coroutines.JobSupport
    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        return super.nameString$kotlinx_coroutines_core();
    }

    public void onCancelled(@NotNull Throwable throwable0, boolean z) {
    }

    public void onCompleted(Object object0) {
    }

    @Override  // kotlinx.coroutines.JobSupport
    public final void onCompletionInternal(@Nullable Object object0) {
        if(object0 instanceof CompletedExceptionally) {
            boolean z = ((CompletedExceptionally)object0).getHandled();
            this.onCancelled(((CompletedExceptionally)object0).cause, z);
            return;
        }
        this.onCompleted(object0);
    }

    @Override  // kotlin.coroutines.Continuation
    public final void resumeWith(@NotNull Object object0) {
        Object object1 = this.makeCompletingOnce$kotlinx_coroutines_core(CompletionStateKt.toState(object0));
        if(object1 == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            return;
        }
        this.afterResume(object1);
    }

    public final void start(@NotNull CoroutineStart coroutineStart0, Object object0, @NotNull n n0) {
        coroutineStart0.invoke(n0, object0, this);
    }
}

