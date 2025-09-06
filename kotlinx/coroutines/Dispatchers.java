package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0005\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001A\u0004\b\u0007\u0010\bR \u0010\n\u001A\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u0012\u0004\b\f\u0010\u0003\u001A\u0004\b\u000B\u0010\bR\u001A\u0010\u0011\u001A\u00020\r8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0003\u001A\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0014\u001A\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0003\u001A\u0004\b\u0012\u0010\b¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/Dispatchers;", "", "<init>", "()V", "Lkotlinx/coroutines/CoroutineDispatcher;", "Default", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault$annotations", "Unconfined", "getUnconfined", "getUnconfined$annotations", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain$annotations", "Main", "getIO", "getIO$annotations", "IO", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class Dispatchers {
    @NotNull
    private static final CoroutineDispatcher Default;
    @NotNull
    public static final Dispatchers INSTANCE;
    @NotNull
    private static final CoroutineDispatcher Unconfined;

    static {
        Dispatchers.INSTANCE = new Dispatchers();
        Dispatchers.Default = DefaultScheduler.INSTANCE;
        Dispatchers.Unconfined = Unconfined.INSTANCE;
    }

    @NotNull
    public static final CoroutineDispatcher getDefault() {
        return Dispatchers.Default;
    }

    @NotNull
    public static final CoroutineDispatcher getIO() {
        return DefaultIoScheduler.INSTANCE;
    }

    @NotNull
    public static final MainCoroutineDispatcher getMain() {
        return MainDispatcherLoader.dispatcher;
    }
}

