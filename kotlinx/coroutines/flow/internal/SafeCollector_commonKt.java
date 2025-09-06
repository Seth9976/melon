package kotlinx.coroutines.flow.internal;

import C8.a;
import kotlin.Metadata;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.ScopeCoroutine;
import me.g;
import me.h;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u001F\u0010\u0004\u001A\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001A\"\u0010\b\u001A\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0080\u0010¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "Lme/i;", "currentContext", "Lie/H;", "checkContext", "(Lkotlinx/coroutines/flow/internal/SafeCollector;Lme/i;)V", "Lkotlinx/coroutines/Job;", "collectJob", "transitiveCoroutineParent", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class SafeCollector_commonKt {
    public static int a(SafeCollector safeCollector0, int v, g g0) {
        return SafeCollector_commonKt.checkContext$lambda$0(safeCollector0, v, g0);
    }

    public static final void checkContext(@NotNull SafeCollector safeCollector0, @NotNull i i0) {
        if(((Number)i0.fold(0, new a(safeCollector0, 29))).intValue() != safeCollector0.collectContextSize) {
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector0.collectContext + ",\n\t\tbut emission happened in " + i0 + ".\n\t\tPlease refer to \'flow\' documentation or use \'flowOn\' instead").toString());
        }
    }

    private static final int checkContext$lambda$0(SafeCollector safeCollector0, int v, g g0) {
        h h0 = g0.getKey();
        g g1 = safeCollector0.collectContext.get(h0);
        if(h0 != Job.Key) {
            return g0 == g1 ? v + 1 : 0x80000000;
        }
        Job job0 = SafeCollector_commonKt.transitiveCoroutineParent(((Job)g0), ((Job)g1));
        if(job0 != ((Job)g1)) {
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + job0 + ", expected child of " + ((Job)g1) + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use \'channelFlow\' builder instead of \'flow\'").toString());
        }
        return ((Job)g1) == null ? v : v + 1;
    }

    @Nullable
    public static final Job transitiveCoroutineParent(@Nullable Job job0, @Nullable Job job1) {
        while(true) {
            if(job0 == null) {
                return null;
            }
            if(job0 == job1 || !(job0 instanceof ScopeCoroutine)) {
                return job0;
            }
            job0 = ((ScopeCoroutine)job0).getParent();
        }
    }
}

