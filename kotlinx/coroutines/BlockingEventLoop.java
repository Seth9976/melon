package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001A\u00020\u0003X\u0094\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/BlockingEventLoop;", "Lkotlinx/coroutines/EventLoopImplBase;", "thread", "Ljava/lang/Thread;", "<init>", "(Ljava/lang/Thread;)V", "getThread", "()Ljava/lang/Thread;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class BlockingEventLoop extends EventLoopImplBase {
    @NotNull
    private final Thread thread;

    public BlockingEventLoop(@NotNull Thread thread0) {
        this.thread = thread0;
    }

    @Override  // kotlinx.coroutines.EventLoopImplPlatform
    @NotNull
    public Thread getThread() {
        return this.thread;
    }
}

