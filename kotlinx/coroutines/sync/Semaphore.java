package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002H¦@¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0005\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001A\u00020\u00078&X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lkotlinx/coroutines/sync/Semaphore;", "", "Lie/H;", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "()V", "", "getAvailablePermits", "()I", "availablePermits", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface Semaphore {
    @Nullable
    Object acquire(@NotNull Continuation arg1);

    int getAvailablePermits();

    void release();
}

