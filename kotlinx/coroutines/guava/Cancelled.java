package kotlinx.coroutines.guava;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/guava/Cancelled;", "", "exception", "Ljava/util/concurrent/CancellationException;", "<init>", "(Ljava/util/concurrent/CancellationException;)V", "kotlinx-coroutines-guava"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class Cancelled {
    @NotNull
    public final CancellationException exception;

    public Cancelled(@NotNull CancellationException cancellationException0) {
        this.exception = cancellationException0;
    }
}

