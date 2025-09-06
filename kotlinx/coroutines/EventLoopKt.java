package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u000F\u0010\u0001\u001A\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/EventLoop;", "createEventLoop", "()Lkotlinx/coroutines/EventLoop;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class EventLoopKt {
    @NotNull
    public static final EventLoop createEventLoop() {
        return new BlockingEventLoop(Thread.currentThread());
    }
}

