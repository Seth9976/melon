package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001A\u00020\bH\u0016J\u001A\u0010\t\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\bH\u0016J\n\u0010\r\u001A\u0004\u0018\u00010\bH\u0005R\u0012\u0010\u0004\u001A\u00020\u0000X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u000E"}, d2 = {"Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "toString", "", "limitedParallelism", "parallelism", "", "name", "toStringInternalImpl", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    @NotNull
    public abstract MainCoroutineDispatcher getImmediate();

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public CoroutineDispatcher limitedParallelism(int v, @Nullable String s) {
        LimitedDispatcherKt.checkParallelism(v);
        return LimitedDispatcherKt.namedOrThis(this, s);
    }

    @Override  // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        String s = this.toStringInternalImpl();
        return s == null ? DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this) : s;
    }

    @Nullable
    public final String toStringInternalImpl() {
        MainCoroutineDispatcher mainCoroutineDispatcher1;
        MainCoroutineDispatcher mainCoroutineDispatcher0 = Dispatchers.getMain();
        if(this == mainCoroutineDispatcher0) {
            return "Dispatchers.Main";
        }
        try {
            mainCoroutineDispatcher1 = null;
            mainCoroutineDispatcher1 = mainCoroutineDispatcher0.getImmediate();
        }
        catch(UnsupportedOperationException unused_ex) {
        }
        return this == mainCoroutineDispatcher1 ? "Dispatchers.Main.immediate" : null;
    }
}

