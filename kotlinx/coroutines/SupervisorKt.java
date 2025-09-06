package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001A\u0019\u0010\u0003\u001A\u00020\u00022\n\b\u0002\u0010\u0001\u001A\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001AG\u0010\u000B\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u00052\"\u0010\n\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006H\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/CompletableJob;", "SupervisorJob", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/CompletableJob;", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "block", "supervisorScope", "(Lwe/n;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class SupervisorKt {
    @NotNull
    public static final CompletableJob SupervisorJob(@Nullable Job job0) {
        return new SupervisorJobImpl(job0);
    }

    public static CompletableJob SupervisorJob$default(Job job0, int v, Object object0) {
        if((v & 1) != 0) {
            job0 = null;
        }
        return SupervisorKt.SupervisorJob(job0);
    }

    @Nullable
    public static final Object supervisorScope(@NotNull n n0, @NotNull Continuation continuation0) {
        SupervisorCoroutine supervisorCoroutine0 = new SupervisorCoroutine(continuation0.getContext(), continuation0);
        return UndispatchedKt.startUndispatchedOrReturn(supervisorCoroutine0, supervisorCoroutine0, n0);
    }
}

