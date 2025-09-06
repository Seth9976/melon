package kotlinx.coroutines;

import kotlin.Metadata;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ#\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u000B\u001A\u00020\n2\n\u0010\u0011\u001A\u00060\u000Fj\u0002`\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/Unconfined;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "", "parallelism", "", "name", "limitedParallelism", "(ILjava/lang/String;)Lkotlinx/coroutines/CoroutineDispatcher;", "Lme/i;", "context", "", "isDispatchNeeded", "(Lme/i;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lie/H;", "dispatch", "(Lme/i;Ljava/lang/Runnable;)V", "toString", "()Ljava/lang/String;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class Unconfined extends CoroutineDispatcher {
    @NotNull
    public static final Unconfined INSTANCE;

    static {
        Unconfined.INSTANCE = new Unconfined();
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(@NotNull i i0, @NotNull Runnable runnable0) {
        YieldContext yieldContext0 = (YieldContext)i0.get(YieldContext.Key);
        if(yieldContext0 == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        yieldContext0.dispatcherWasUnconfined = true;
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(@NotNull i i0) {
        return false;
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public CoroutineDispatcher limitedParallelism(int v, @Nullable String s) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}

