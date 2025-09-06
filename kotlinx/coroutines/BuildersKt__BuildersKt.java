package kotlinx.coroutines;

import kotlin.Metadata;
import me.e;
import me.f;
import me.i;
import me.j;
import org.jetbrains.annotations.NotNull;
import we.n;

@Metadata(d1 = {"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001AN\u0010\b\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00012\"\u0010\u0007\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"T", "Lme/i;", "context", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "block", "runBlocking", "(Lme/i;Lwe/n;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/BuildersKt")
abstract class BuildersKt__BuildersKt {
    public static final Object runBlocking(@NotNull i i0, @NotNull n n0) {
        i i2;
        EventLoop eventLoop0;
        Thread thread0 = Thread.currentThread();
        f f0 = (f)i0.get(e.a);
        if(f0 == null) {
            eventLoop0 = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
            i i1 = i0.plus(eventLoop0);
            i2 = CoroutineContextKt.newCoroutineContext(() -> j.a, i1);
        }
        else {
            if(f0 instanceof EventLoop) {
                EventLoop eventLoop1 = (EventLoop)f0;
            }
            eventLoop0 = ThreadLocalEventLoop.INSTANCE.currentOrNull$kotlinx_coroutines_core();
            i2 = CoroutineContextKt.newCoroutineContext(() -> j.a, i0);
        }
        BlockingCoroutine blockingCoroutine0 = new BlockingCoroutine(i2, thread0, eventLoop0);
        blockingCoroutine0.start(CoroutineStart.DEFAULT, blockingCoroutine0, n0);
        return blockingCoroutine0.joinBlocking();
    }

    public static Object runBlocking$default(i i0, n n0, int v, Object object0) {
        if((v & 1) != 0) {
            i0 = j.a;
        }
        return BuildersKt.runBlocking(i0, n0);
    }
}

