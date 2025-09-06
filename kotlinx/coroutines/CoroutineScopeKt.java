package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\u001A\u001C\u0010\u0003\u001A\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001A\r\u0010\u0005\u001A\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001AG\u0010\f\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u00072\"\u0010\u000B\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\f\u0010\r\u001A\u0015\u0010\u000E\u001A\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u000E\u0010\u000F\u001A#\u0010\u0014\u001A\u00020\u0013*\u00020\u00002\u0010\b\u0002\u0010\u0012\u001A\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011¢\u0006\u0004\b\u0014\u0010\u0015\u001A%\u0010\u0014\u001A\u00020\u0013*\u00020\u00002\u0006\u0010\u0017\u001A\u00020\u00162\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0014\u0010\u0019\u001A\u0011\u0010\u001A\u001A\u00020\u0013*\u00020\u0000¢\u0006\u0004\b\u001A\u0010\u001B\"\u001B\u0010\u001D\u001A\u00020\u001C*\u00020\u00008F¢\u0006\f\u0012\u0004\b\u001F\u0010\u001B\u001A\u0004\b\u001D\u0010\u001E¨\u0006 "}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lme/i;", "context", "plus", "(Lkotlinx/coroutines/CoroutineScope;Lme/i;)Lkotlinx/coroutines/CoroutineScope;", "MainScope", "()Lkotlinx/coroutines/CoroutineScope;", "R", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "block", "coroutineScope", "(Lwe/n;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CoroutineScope", "(Lme/i;)Lkotlinx/coroutines/CoroutineScope;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "Lie/H;", "cancel", "(Lkotlinx/coroutines/CoroutineScope;Ljava/util/concurrent/CancellationException;)V", "", "message", "", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;Ljava/lang/Throwable;)V", "ensureActive", "(Lkotlinx/coroutines/CoroutineScope;)V", "", "isActive", "(Lkotlinx/coroutines/CoroutineScope;)Z", "isActive$annotations", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class CoroutineScopeKt {
    @NotNull
    public static final CoroutineScope CoroutineScope(@NotNull i i0) {
        if(i0.get(Job.Key) == null) {
            i0 = i0.plus(JobKt__JobKt.Job$default(null, 1, null));
        }
        return new ContextScope(i0);
    }

    @NotNull
    public static final CoroutineScope MainScope() {
        return new ContextScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
    }

    public static final void cancel(@NotNull CoroutineScope coroutineScope0, @NotNull String s, @Nullable Throwable throwable0) {
        CoroutineScopeKt.cancel(coroutineScope0, ExceptionsKt.CancellationException(s, throwable0));
    }

    public static final void cancel(@NotNull CoroutineScope coroutineScope0, @Nullable CancellationException cancellationException0) {
        Job job0 = (Job)coroutineScope0.getCoroutineContext().get(Job.Key);
        if(job0 == null) {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + coroutineScope0).toString());
        }
        job0.cancel(cancellationException0);
    }

    public static void cancel$default(CoroutineScope coroutineScope0, String s, Throwable throwable0, int v, Object object0) {
        if((v & 2) != 0) {
            throwable0 = null;
        }
        CoroutineScopeKt.cancel(coroutineScope0, s, throwable0);
    }

    public static void cancel$default(CoroutineScope coroutineScope0, CancellationException cancellationException0, int v, Object object0) {
        if((v & 1) != 0) {
            cancellationException0 = null;
        }
        CoroutineScopeKt.cancel(coroutineScope0, cancellationException0);
    }

    @Nullable
    public static final Object coroutineScope(@NotNull n n0, @NotNull Continuation continuation0) {
        ScopeCoroutine scopeCoroutine0 = new ScopeCoroutine(continuation0.getContext(), continuation0);
        return UndispatchedKt.startUndispatchedOrReturn(scopeCoroutine0, scopeCoroutine0, n0);
    }

    public static final void ensureActive(@NotNull CoroutineScope coroutineScope0) {
        JobKt.ensureActive(coroutineScope0.getCoroutineContext());
    }

    public static final boolean isActive(@NotNull CoroutineScope coroutineScope0) {
        Job job0 = (Job)coroutineScope0.getCoroutineContext().get(Job.Key);
        return job0 == null ? true : job0.isActive();
    }

    @NotNull
    public static final CoroutineScope plus(@NotNull CoroutineScope coroutineScope0, @NotNull i i0) {
        return new ContextScope(coroutineScope0.getCoroutineContext().plus(i0));
    }
}

