package kotlinx.coroutines.tasks;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/tasks/DirectExecutor;", "Ljava/util/concurrent/Executor;", "<init>", "()V", "Ljava/lang/Runnable;", "r", "Lie/H;", "execute", "(Ljava/lang/Runnable;)V", "kotlinx-coroutines-play-services"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class DirectExecutor implements Executor {
    @NotNull
    public static final DirectExecutor INSTANCE;

    static {
        DirectExecutor.INSTANCE = new DirectExecutor();
    }

    // 检测为 Lambda 实现
    @Override
    public void execute(@NotNull Runnable runnable0) [...]
}

