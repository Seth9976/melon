package kotlinx.coroutines;

import kotlin.Metadata;
import me.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001A\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/GlobalScope;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "Lme/i;", "getCoroutineContext", "()Lme/i;", "coroutineContext", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class GlobalScope implements CoroutineScope {
    @NotNull
    public static final GlobalScope INSTANCE;

    static {
        GlobalScope.INSTANCE = new GlobalScope();
    }

    // 检测为 Lambda 实现
    @Override  // kotlinx.coroutines.CoroutineScope
    @NotNull
    public i getCoroutineContext() [...]
}

