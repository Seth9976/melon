package kotlinx.coroutines.guava;

import M6.B;
import M6.s;
import d5.f;
import e1.u;
import ie.H;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import me.i;
import me.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\u001AU\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\"\u0010\t\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006¢\u0006\u0004\b\u000B\u0010\f\u001A\u0013\u0010\u000F\u001A\u00020\u000E*\u00020\rH\u0002¢\u0006\u0004\b\u000F\u0010\u0010\u001A \u0010\u0011\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\nH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "Lme/i;", "context", "Lkotlinx/coroutines/CoroutineStart;", "start", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "block", "LM6/B;", "future", "(Lkotlinx/coroutines/CoroutineScope;Lme/i;Lkotlinx/coroutines/CoroutineStart;Lwe/n;)LM6/B;", "Ljava/util/concurrent/ExecutionException;", "", "nonNullCause", "(Ljava/util/concurrent/ExecutionException;)Ljava/lang/Throwable;", "await", "(LM6/B;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-guava"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class ListenableFutureKt {
    @Nullable
    public static final Object await(@NotNull B b0, @NotNull Continuation continuation0) {
        try {
            if(b0.isDone()) {
                return f.H(b0);
            }
        }
        catch(ExecutionException executionException0) {
            throw ListenableFutureKt.nonNullCause(executionException0);
        }
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        b0.addListener(new ToContinuation(b0, cancellableContinuationImpl0), s.a);
        cancellableContinuationImpl0.invokeOnCancellation(new k() {
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((Throwable)object0));
                return H.a;
            }

            public final void invoke(Throwable throwable0) {
                b0.cancel(false);
            }
        });
        return cancellableContinuationImpl0.getResult();
    }

    @NotNull
    public static final B future(@NotNull CoroutineScope coroutineScope0, @NotNull i i0, @NotNull CoroutineStart coroutineStart0, @NotNull n n0) {
        ListenableFutureCoroutine listenableFutureCoroutine0 = new ListenableFutureCoroutine(CoroutineContextKt.newCoroutineContext(coroutineScope0, i0));
        listenableFutureCoroutine0.start(coroutineStart0, listenableFutureCoroutine0, n0);
        return listenableFutureCoroutine0.future;
    }

    public static B future$default(CoroutineScope coroutineScope0, i i0, CoroutineStart coroutineStart0, n n0, int v, Object object0) {
        if((v & 1) != 0) {
            i0 = j.a;
        }
        if((v & 2) != 0) {
            coroutineStart0 = CoroutineStart.DEFAULT;
        }
        return ListenableFutureKt.future(coroutineScope0, i0, coroutineStart0, n0);
    }

    private static final Throwable nonNullCause(ExecutionException executionException0) {
        Throwable throwable0 = executionException0.getCause();
        q.d(throwable0);
        return throwable0;
    }
}

