package kotlinx.coroutines.internal;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0017\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007*\f\b\u0000\u0010\t\"\u00020\b2\u00020\b*\u001E\b\u0000\u0010\f\u001A\u0004\b\u0000\u0010\n\"\b\u0012\u0004\u0012\u00028\u00000\u000B2\b\u0012\u0004\u0012\u00028\u00000\u000B¨\u0006\r"}, d2 = {"Ljava/util/concurrent/Executor;", "executor", "", "removeFutureOnCancel", "(Ljava/util/concurrent/Executor;)Z", "Ljava/lang/reflect/Method;", "REMOVE_FUTURE_ON_CANCEL", "Ljava/lang/reflect/Method;", "Ljava/util/concurrent/locks/ReentrantLock;", "ReentrantLock", "T", "Ljava/util/concurrent/atomic/AtomicReference;", "WorkaroundAtomicReference", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class ConcurrentKt {
    @Nullable
    private static final Method REMOVE_FUTURE_ON_CANCEL;

    static {
        Method method0 = null;
        try {
            method0 = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", Boolean.TYPE);
        }
        catch(Throwable unused_ex) {
        }
        ConcurrentKt.REMOVE_FUTURE_ON_CANCEL = method0;
    }

    public static final boolean removeFutureOnCancel(@NotNull Executor executor0) {
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor0 = executor0 instanceof ScheduledThreadPoolExecutor ? ((ScheduledThreadPoolExecutor)executor0) : null;
            if(scheduledThreadPoolExecutor0 == null) {
                return false;
            }
            Method method0 = ConcurrentKt.REMOVE_FUTURE_ON_CANCEL;
            if(method0 == null) {
                return false;
            }
            method0.invoke(scheduledThreadPoolExecutor0, Boolean.TRUE);
            return true;
        }
        catch(Throwable unused_ex) {
            return false;
        }
    }
}

