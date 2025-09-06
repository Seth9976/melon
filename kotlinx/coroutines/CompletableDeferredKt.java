package kotlinx.coroutines;

import ie.p;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A+\u0010\u0005\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001A%\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"T", "Lkotlinx/coroutines/CompletableDeferred;", "Lie/p;", "result", "", "completeWith", "(Lkotlinx/coroutines/CompletableDeferred;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/Job;", "parent", "CompletableDeferred", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/CompletableDeferred;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class CompletableDeferredKt {
    @NotNull
    public static final CompletableDeferred CompletableDeferred(@Nullable Job job0) {
        return new CompletableDeferredImpl(job0);
    }

    public static CompletableDeferred CompletableDeferred$default(Job job0, int v, Object object0) {
        if((v & 1) != 0) {
            job0 = null;
        }
        return CompletableDeferredKt.CompletableDeferred(job0);
    }

    public static final boolean completeWith(@NotNull CompletableDeferred completableDeferred0, @NotNull Object object0) {
        Throwable throwable0 = p.a(object0);
        return throwable0 == null ? completableDeferred0.complete(object0) : completableDeferred0.completeExceptionally(throwable0);
    }
}

