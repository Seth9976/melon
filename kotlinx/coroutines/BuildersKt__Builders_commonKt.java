package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import me.e;
import me.i;
import me.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001AI\u0010\u000B\u001A\u00020\n*\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00012\b\b\u0002\u0010\u0004\u001A\u00020\u00032\"\u0010\t\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0004\b\u000B\u0010\f\u001AU\u0010\u000F\u001A\b\u0012\u0004\u0012\u00028\u00000\u000E\"\u0004\b\u0000\u0010\r*\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00012\b\b\u0002\u0010\u0004\u001A\u00020\u00032\"\u0010\t\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0004\b\u000F\u0010\u0010\u001AO\u0010\u0011\u001A\u00028\u0000\"\u0004\b\u0000\u0010\r2\u0006\u0010\u0002\u001A\u00020\u00012\"\u0010\t\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lme/i;", "context", "Lkotlinx/coroutines/CoroutineStart;", "start", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lie/H;", "", "block", "Lkotlinx/coroutines/Job;", "launch", "(Lkotlinx/coroutines/CoroutineScope;Lme/i;Lkotlinx/coroutines/CoroutineStart;Lwe/n;)Lkotlinx/coroutines/Job;", "T", "Lkotlinx/coroutines/Deferred;", "async", "(Lkotlinx/coroutines/CoroutineScope;Lme/i;Lkotlinx/coroutines/CoroutineStart;Lwe/n;)Lkotlinx/coroutines/Deferred;", "withContext", "(Lme/i;Lwe/n;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/BuildersKt")
abstract class BuildersKt__Builders_commonKt {
    @NotNull
    public static final Deferred async(@NotNull CoroutineScope coroutineScope0, @NotNull i i0, @NotNull CoroutineStart coroutineStart0, @NotNull n n0) {
        Deferred deferred0 = new DeferredCoroutine(CoroutineContextKt.newCoroutineContext(coroutineScope0, i0), true);
        ((AbstractCoroutine)deferred0).start(coroutineStart0, deferred0, n0);
        return deferred0;
    }

    public static Deferred async$default(CoroutineScope coroutineScope0, i i0, CoroutineStart coroutineStart0, n n0, int v, Object object0) {
        if((v & 1) != 0) {
            i0 = j.a;
        }
        if((v & 2) != 0) {
            coroutineStart0 = CoroutineStart.DEFAULT;
        }
        return BuildersKt.async(coroutineScope0, i0, coroutineStart0, n0);
    }

    @NotNull
    public static final Job launch(@NotNull CoroutineScope coroutineScope0, @NotNull i i0, @NotNull CoroutineStart coroutineStart0, @NotNull n n0) {
        Job job0 = new StandaloneCoroutine(CoroutineContextKt.newCoroutineContext(coroutineScope0, i0), true);
        ((AbstractCoroutine)job0).start(coroutineStart0, job0, n0);
        return job0;
    }

    public static Job launch$default(CoroutineScope coroutineScope0, i i0, CoroutineStart coroutineStart0, n n0, int v, Object object0) {
        if((v & 1) != 0) {
            i0 = j.a;
        }
        if((v & 2) != 0) {
            coroutineStart0 = CoroutineStart.DEFAULT;
        }
        return BuildersKt.launch(coroutineScope0, i0, coroutineStart0, n0);
    }

    @Nullable
    public static final Object withContext(@NotNull i i0, @NotNull n n0, @NotNull Continuation continuation0) {
        i i1 = continuation0.getContext();
        i i2 = CoroutineContextKt.newCoroutineContext(i1, i0);
        JobKt.ensureActive(i2);
        if(i2 == i1) {
            ScopeCoroutine scopeCoroutine0 = new ScopeCoroutine(i2, continuation0);
            return UndispatchedKt.startUndispatchedOrReturn(scopeCoroutine0, scopeCoroutine0, n0);
        }
        if(q.b(i2.get(e.a), i1.get(e.a))) {
            UndispatchedCoroutine undispatchedCoroutine0 = new UndispatchedCoroutine(i2, continuation0);
            i i3 = undispatchedCoroutine0.getContext();
            Object object0 = ThreadContextKt.updateThreadContext(i3, null);
            try {
                return UndispatchedKt.startUndispatchedOrReturn(undispatchedCoroutine0, undispatchedCoroutine0, n0);
            }
            finally {
                ThreadContextKt.restoreThreadContext(i3, object0);
            }
        }
        DispatchedCoroutine dispatchedCoroutine0 = new DispatchedCoroutine(i2, continuation0);
        CancellableKt.startCoroutineCancellable(n0, dispatchedCoroutine0, dispatchedCoroutine0);
        return dispatchedCoroutine0.getResult$kotlinx_coroutines_core();
    }
}

