package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import me.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001B\u0010\n\u001A\u00020\t2\n\u0010\b\u001A\u00060\u0006j\u0002`\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000ER\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000F¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/DispatcherExecutor;", "Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lie/H;", "execute", "(Ljava/lang/Runnable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineDispatcher;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class DispatcherExecutor implements Executor {
    @NotNull
    public final CoroutineDispatcher dispatcher;

    public DispatcherExecutor(@NotNull CoroutineDispatcher coroutineDispatcher0) {
        this.dispatcher = coroutineDispatcher0;
    }

    @Override
    public void execute(@NotNull Runnable runnable0) {
        j j0 = j.a;
        if(DispatchedContinuationKt.safeIsDispatchNeeded(this.dispatcher, j0)) {
            DispatchedContinuationKt.safeDispatch(this.dispatcher, j0, runnable0);
            return;
        }
        runnable0.run();
    }

    // 去混淆评级： 低(20)
    @Override
    @NotNull
    public String toString() {
        return "CoroutineDispatcher@7a7c10a";
    }
}

