package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatchersKt;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\b\u001A\u000F\u0010\u0001\u001A\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0004\u001A\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005\" \u0010\u0006\u001A\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\t\u0010\n\u001A\u0004\b\b\u0010\u0002¨\u0006\u000B"}, d2 = {"Lkotlinx/coroutines/Delay;", "initializeDefaultDelay", "()Lkotlinx/coroutines/Delay;", "", "defaultMainDelayOptIn", "Z", "DefaultDelay", "Lkotlinx/coroutines/Delay;", "getDefaultDelay", "getDefaultDelay$annotations", "()V", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class DefaultExecutorKt {
    @NotNull
    private static final Delay DefaultDelay;
    private static final boolean defaultMainDelayOptIn;

    static {
        DefaultExecutorKt.defaultMainDelayOptIn = SystemPropsKt.systemProp("kotlinx.coroutines.main.delay", false);
        DefaultExecutorKt.DefaultDelay = DefaultExecutorKt.initializeDefaultDelay();
    }

    @NotNull
    public static final Delay getDefaultDelay() {
        return DefaultExecutorKt.DefaultDelay;
    }

    private static final Delay initializeDefaultDelay() {
        if(!DefaultExecutorKt.defaultMainDelayOptIn) {
            return DefaultExecutor.INSTANCE;
        }
        MainCoroutineDispatcher mainCoroutineDispatcher0 = Dispatchers.getMain();
        return !MainDispatchersKt.isMissing(mainCoroutineDispatcher0) && mainCoroutineDispatcher0 instanceof Delay ? ((Delay)mainCoroutineDispatcher0) : DefaultExecutor.INSTANCE;
    }
}

