package kotlinx.coroutines.intrinsics;

import e1.u;
import i.n.i.b.a.s.e.M3;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.DispatchException;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import me.i;
import oe.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\u001AQ\u0010\b\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\u0005\u001A\u00028\u00002\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00010\u0003H\u0000¢\u0006\u0004\b\b\u0010\t\u001AS\u0010\f\u001A\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0005\u001A\u00028\u00012\"\u0010\u000B\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0000¢\u0006\u0004\b\f\u0010\r\u001AS\u0010\u000E\u001A\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0005\u001A\u00028\u00012\"\u0010\u000B\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0000¢\u0006\u0004\b\u000E\u0010\r\u001A[\u0010\u0011\u001A\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u0005\u001A\u00028\u00012\"\u0010\u000B\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001A\u001F\u0010\u0015\u001A\u00020\u000F*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0014\u001A\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001A\u001F\u0010\u001A\u001A\u00020\u0019*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0018\u001A\u00020\u0017H\u0002¢\u0006\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2 = {"R", "T", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "receiver", "completion", "Lie/H;", "startCoroutineUndispatched", "(Lwe/n;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "block", "startUndispatchedOrReturn", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Object;Lwe/n;)Ljava/lang/Object;", "startUndispatchedOrReturnIgnoreTimeout", "", "alwaysRethrow", "startUndspatched", "(Lkotlinx/coroutines/internal/ScopeCoroutine;ZLjava/lang/Object;Lwe/n;)Ljava/lang/Object;", "", "cause", "notOwnTimeout", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/DispatchException;", "e", "", "dispatchExceptionAndMakeCompleting", "(Lkotlinx/coroutines/internal/ScopeCoroutine;Lkotlinx/coroutines/DispatchException;)Ljava/lang/Void;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class UndispatchedKt {
    private static final Void dispatchExceptionAndMakeCompleting(ScopeCoroutine scopeCoroutine0, DispatchException dispatchException0) {
        scopeCoroutine0.makeCompleting$kotlinx_coroutines_core(new CompletedExceptionally(dispatchException0.getCause(), false, 2, null));
        throw dispatchException0.getCause();
    }

    private static final boolean notOwnTimeout(ScopeCoroutine scopeCoroutine0, Throwable throwable0) {
        return !(throwable0 instanceof TimeoutCancellationException) || ((TimeoutCancellationException)throwable0).coroutine != scopeCoroutine0;
    }

    public static final void startCoroutineUndispatched(@NotNull n n0, Object object0, @NotNull Continuation continuation0) {
        Object object2;
        q.g(continuation0, "completion");
        try {
            i i0 = continuation0.getContext();
            Object object1 = ThreadContextKt.updateThreadContext(i0, null);
            try {
                if(n0 instanceof a) {
                    N.e(2, n0);
                    object2 = n0.invoke(object0, continuation0);
                }
                else {
                    object2 = u.X(n0, object0, continuation0);
                }
            }
            finally {
                ThreadContextKt.restoreThreadContext(i0, object1);
            }
        }
        catch(Throwable throwable0) {
            if(throwable0 instanceof DispatchException) {
                throwable0 = ((DispatchException)throwable0).getCause();
            }
            continuation0.resumeWith(d5.n.t(throwable0));
            return;
        }
        if(object2 != ne.a.a) {
            continuation0.resumeWith(object2);
        }
    }

    @Nullable
    public static final Object startUndispatchedOrReturn(@NotNull ScopeCoroutine scopeCoroutine0, Object object0, @NotNull n n0) {
        return UndispatchedKt.startUndspatched(scopeCoroutine0, true, object0, n0);
    }

    @Nullable
    public static final Object startUndispatchedOrReturnIgnoreTimeout(@NotNull ScopeCoroutine scopeCoroutine0, Object object0, @NotNull n n0) {
        return UndispatchedKt.startUndspatched(scopeCoroutine0, false, object0, n0);
    }

    private static final Object startUndspatched(ScopeCoroutine scopeCoroutine0, boolean z, Object object0, n n0) {
        CompletedExceptionally completedExceptionally0;
        try {
            if(n0 instanceof a) {
                N.e(2, n0);
                completedExceptionally0 = n0.invoke(object0, scopeCoroutine0);
            }
            else {
                completedExceptionally0 = u.X(n0, object0, scopeCoroutine0);
            }
            goto label_12;
        }
        catch(DispatchException dispatchException0) {
        }
        catch(Throwable throwable0) {
            goto label_11;
        }
        UndispatchedKt.dispatchExceptionAndMakeCompleting(scopeCoroutine0, dispatchException0);
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    label_11:
        completedExceptionally0 = new CompletedExceptionally(throwable0, false, 2, null);
    label_12:
        ne.a a0 = ne.a.a;
        if(completedExceptionally0 != a0) {
            Object object1 = scopeCoroutine0.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally0);
            if(object1 != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                scopeCoroutine0.afterCompletionUndispatched();
                if(object1 instanceof CompletedExceptionally) {
                    if(z || UndispatchedKt.notOwnTimeout(scopeCoroutine0, ((CompletedExceptionally)object1).cause)) {
                        throw ((CompletedExceptionally)object1).cause;
                    }
                    if(completedExceptionally0 instanceof CompletedExceptionally) {
                        throw completedExceptionally0.cause;
                    }
                    return completedExceptionally0;
                }
                return JobSupportKt.unboxState(object1);
            }
        }
        return a0;
    }
}

