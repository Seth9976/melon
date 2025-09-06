package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.Segment;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001B\u0012\u0012\u0010\u0005\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\r\u001A\u00020\f2\n\u0010\t\u001A\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u000B\u001A\u00020\nH\u0096\u0001¢\u0006\u0004\b\r\u0010\u000ER \u0010\u0005\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000F¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/channels/ReceiveCatching;", "E", "Lkotlinx/coroutines/Waiter;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlinx/coroutines/channels/ChannelResult;", "cont", "<init>", "(Lkotlinx/coroutines/CancellableContinuationImpl;)V", "Lkotlinx/coroutines/internal/Segment;", "segment", "", "index", "Lie/H;", "invokeOnCancellation", "(Lkotlinx/coroutines/internal/Segment;I)V", "Lkotlinx/coroutines/CancellableContinuationImpl;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class ReceiveCatching implements Waiter {
    @NotNull
    public final CancellableContinuationImpl cont;

    public ReceiveCatching(@NotNull CancellableContinuationImpl cancellableContinuationImpl0) {
        this.cont = cancellableContinuationImpl0;
    }

    @Override  // kotlinx.coroutines.Waiter
    public void invokeOnCancellation(@NotNull Segment segment0, int v) {
        this.cont.invokeOnCancellation(segment0, v);
    }
}

