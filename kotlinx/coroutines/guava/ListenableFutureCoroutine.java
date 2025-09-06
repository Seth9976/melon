package kotlinx.coroutines.guava;

import kotlin.Metadata;
import kotlinx.coroutines.AbstractCoroutine;
import me.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00028\u0000H\u0014¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000F\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0014¢\u0006\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00000\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/guava/ListenableFutureCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lme/i;", "context", "<init>", "(Lme/i;)V", "value", "Lie/H;", "onCompleted", "(Ljava/lang/Object;)V", "", "cause", "", "handled", "onCancelled", "(Ljava/lang/Throwable;Z)V", "Lkotlinx/coroutines/guava/JobListenableFuture;", "future", "Lkotlinx/coroutines/guava/JobListenableFuture;", "kotlinx-coroutines-guava"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class ListenableFutureCoroutine extends AbstractCoroutine {
    @NotNull
    public final JobListenableFuture future;

    public ListenableFutureCoroutine(@NotNull i i0) {
        super(i0, true, true);
        this.future = new JobListenableFuture(this);
    }

    @Override  // kotlinx.coroutines.AbstractCoroutine
    public void onCancelled(@NotNull Throwable throwable0, boolean z) {
        this.future.completeExceptionallyOrCancel(throwable0);
    }

    @Override  // kotlinx.coroutines.AbstractCoroutine
    public void onCompleted(Object object0) {
        this.future.complete(object0);
    }
}

