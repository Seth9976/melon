package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadLocalKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0007\u001A\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\n\u001A\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\u0004H\u0000¢\u0006\u0004\b\f\u0010\rR(\u0010\u0011\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000Fj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u000B\u001A\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0006¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/ThreadLocalEventLoop;", "", "<init>", "()V", "Lkotlinx/coroutines/EventLoop;", "currentOrNull$kotlinx_coroutines_core", "()Lkotlinx/coroutines/EventLoop;", "currentOrNull", "Lie/H;", "resetEventLoop$kotlinx_coroutines_core", "resetEventLoop", "eventLoop", "setEventLoop$kotlinx_coroutines_core", "(Lkotlinx/coroutines/EventLoop;)V", "setEventLoop", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "ref", "Ljava/lang/ThreadLocal;", "getEventLoop$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class ThreadLocalEventLoop {
    @NotNull
    public static final ThreadLocalEventLoop INSTANCE;
    @NotNull
    private static final ThreadLocal ref;

    static {
        ThreadLocalEventLoop.INSTANCE = new ThreadLocalEventLoop();
        ThreadLocalEventLoop.ref = ThreadLocalKt.commonThreadLocal(new Symbol("ThreadLocalEventLoop"));
    }

    @Nullable
    public final EventLoop currentOrNull$kotlinx_coroutines_core() {
        return (EventLoop)ThreadLocalEventLoop.ref.get();
    }

    @NotNull
    public final EventLoop getEventLoop$kotlinx_coroutines_core() {
        ThreadLocal threadLocal0 = ThreadLocalEventLoop.ref;
        EventLoop eventLoop0 = (EventLoop)threadLocal0.get();
        if(eventLoop0 == null) {
            eventLoop0 = EventLoopKt.createEventLoop();
            threadLocal0.set(eventLoop0);
        }
        return eventLoop0;
    }

    public final void resetEventLoop$kotlinx_coroutines_core() {
        ThreadLocalEventLoop.ref.set(null);
    }

    public final void setEventLoop$kotlinx_coroutines_core(@NotNull EventLoop eventLoop0) {
        ThreadLocalEventLoop.ref.set(eventLoop0);
    }
}

