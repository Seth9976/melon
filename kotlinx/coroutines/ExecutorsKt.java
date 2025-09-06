package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u0013\u0010\u0004\u001A\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001A\u0013\u0010\u0004\u001A\u00020\u0006*\u00020\u0005H\u0007¢\u0006\u0004\b\u0002\u0010\u0007\u001A\u0011\u0010\b\u001A\u00020\u0005*\u00020\u0006¢\u0006\u0004\b\b\u0010\t*\f\b\u0007\u0010\n\"\u00020\u00012\u00020\u0001¨\u0006\u000B"}, d2 = {"Ljava/util/concurrent/ExecutorService;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "from", "(Ljava/util/concurrent/ExecutorService;)Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "asCoroutineDispatcher", "Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Ljava/util/concurrent/Executor;)Lkotlinx/coroutines/CoroutineDispatcher;", "asExecutor", "(Lkotlinx/coroutines/CoroutineDispatcher;)Ljava/util/concurrent/Executor;", "CloseableCoroutineDispatcher", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class ExecutorsKt {
    @NotNull
    public static final Executor asExecutor(@NotNull CoroutineDispatcher coroutineDispatcher0) {
        ExecutorCoroutineDispatcher executorCoroutineDispatcher0 = coroutineDispatcher0 instanceof ExecutorCoroutineDispatcher ? ((ExecutorCoroutineDispatcher)coroutineDispatcher0) : null;
        if(executorCoroutineDispatcher0 != null) {
            Executor executor0 = executorCoroutineDispatcher0.getExecutor();
            if(executor0 != null) {
                return executor0;
            }
        }
        return new DispatcherExecutor(coroutineDispatcher0);
    }

    @NotNull
    public static final CoroutineDispatcher from(@NotNull Executor executor0) {
        DispatcherExecutor dispatcherExecutor0 = executor0 instanceof DispatcherExecutor ? ((DispatcherExecutor)executor0) : null;
        if(dispatcherExecutor0 != null) {
            CoroutineDispatcher coroutineDispatcher0 = dispatcherExecutor0.dispatcher;
            if(coroutineDispatcher0 != null) {
                return coroutineDispatcher0;
            }
        }
        return new ExecutorCoroutineDispatcherImpl(executor0);
    }

    @NotNull
    public static final ExecutorCoroutineDispatcher from(@NotNull ExecutorService executorService0) {
        return new ExecutorCoroutineDispatcherImpl(executorService0);
    }
}

