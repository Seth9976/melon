package kotlinx.coroutines.internal;

import i.n.i.b.a.s.e.M3;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\u001A!\u0010\u0004\u001A\u00020\u0003*\u00020\u00002\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00000\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001A\u0013\u0010\u0007\u001A\u00020\u0006*\u00020\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001A\'\u0010\u000E\u001A\u00020\r2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0002¢\u0006\u0004\b\u000E\u0010\u000F\u001A\u000F\u0010\u0011\u001A\u00020\u0010H\u0000¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherFactory;", "", "factories", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "tryCreateDispatcher", "(Lkotlinx/coroutines/internal/MainDispatcherFactory;Ljava/util/List;)Lkotlinx/coroutines/MainCoroutineDispatcher;", "", "isMissing", "(Lkotlinx/coroutines/MainCoroutineDispatcher;)Z", "", "cause", "", "errorHint", "Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "createMissingDispatcher", "(Ljava/lang/Throwable;Ljava/lang/String;)Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "", "throwMissingMainDispatcherException", "()Ljava/lang/Void;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class MainDispatchersKt {
    private static final MissingMainCoroutineDispatcher createMissingDispatcher(Throwable throwable0, String s) {
        if(throwable0 != null) {
            throw throwable0;
        }
        MainDispatchersKt.throwMissingMainDispatcherException();
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    public static MissingMainCoroutineDispatcher createMissingDispatcher$default(Throwable throwable0, String s, int v, Object object0) {
        if((v & 1) != 0) {
            throwable0 = null;
        }
        if((v & 2) != 0) {
            s = null;
        }
        return MainDispatchersKt.createMissingDispatcher(throwable0, s);
    }

    public static final boolean isMissing(@NotNull MainCoroutineDispatcher mainCoroutineDispatcher0) {
        return mainCoroutineDispatcher0.getImmediate() instanceof MissingMainCoroutineDispatcher;
    }

    @NotNull
    public static final Void throwMissingMainDispatcherException() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. \'kotlinx-coroutines-android\' and ensure it has the same version as \'kotlinx-coroutines-core\'");
    }

    @NotNull
    public static final MainCoroutineDispatcher tryCreateDispatcher(@NotNull MainDispatcherFactory mainDispatcherFactory0, @NotNull List list0) {
        try {
            return mainDispatcherFactory0.createDispatcher(list0);
        }
        catch(Throwable throwable0) {
            return MainDispatchersKt.createMissingDispatcher(throwable0, mainDispatcherFactory0.hintOnError());
        }
    }
}

