package kotlinx.coroutines;

import d5.n;
import ie.p;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A!\u0010\u0003\u001A\u0004\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001A-\u0010\u0003\u001A\u0004\u0018\u00010\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\n\u0010\u0006\u001A\u0006\u0012\u0002\b\u00030\u0005H\u0000¢\u0006\u0004\b\u0003\u0010\u0007\u001A3\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\b\u0010\b\u001A\u0004\u0018\u00010\u00022\f\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\tH\u0000¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"T", "Lie/p;", "", "toState", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/CancellableContinuation;", "caller", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "state", "Lkotlin/coroutines/Continuation;", "uCont", "recoverResult", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class CompletionStateKt {
    @NotNull
    public static final Object recoverResult(@Nullable Object object0, @NotNull Continuation continuation0) {
        return object0 instanceof CompletedExceptionally ? n.t(((CompletedExceptionally)object0).cause) : object0;
    }

    @Nullable
    public static final Object toState(@NotNull Object object0) {
        Throwable throwable0 = p.a(object0);
        return throwable0 == null ? object0 : new CompletedExceptionally(throwable0, false, 2, null);
    }

    @Nullable
    public static final Object toState(@NotNull Object object0, @NotNull CancellableContinuation cancellableContinuation0) {
        Throwable throwable0 = p.a(object0);
        return throwable0 == null ? object0 : new CompletedExceptionally(throwable0, false, 2, null);
    }
}

