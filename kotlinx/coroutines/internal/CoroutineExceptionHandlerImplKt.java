package kotlinx.coroutines.internal;

import Q0.W0;
import Sf.a;
import Sf.n;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A\u0017\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\" \u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"", "exception", "Lie/H;", "propagateExceptionFinalResort", "(Ljava/lang/Throwable;)V", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "platformExceptionHandlers", "Ljava/util/Collection;", "getPlatformExceptionHandlers", "()Ljava/util/Collection;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class CoroutineExceptionHandlerImplKt {
    @NotNull
    private static final Collection platformExceptionHandlers;

    static {
        Iterator iterator0 = ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator();
        q.g(iterator0, "<this>");
        CoroutineExceptionHandlerImplKt.platformExceptionHandlers = n.p0(new a(new W0(iterator0, 2)));
    }

    @NotNull
    public static final Collection getPlatformExceptionHandlers() {
        return CoroutineExceptionHandlerImplKt.platformExceptionHandlers;
    }

    public static final void propagateExceptionFinalResort(@NotNull Throwable throwable0) {
        Thread thread0 = Thread.currentThread();
        thread0.getUncaughtExceptionHandler().uncaughtException(thread0, throwable0);
    }
}

