package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001A\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"NULL", "Lkotlinx/coroutines/internal/Symbol;", "UNINITIALIZED", "DONE", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class NullSurrogateKt {
    @NotNull
    public static final Symbol DONE;
    @NotNull
    public static final Symbol NULL;
    @NotNull
    public static final Symbol UNINITIALIZED;

    static {
        NullSurrogateKt.NULL = new Symbol("NULL");
        NullSurrogateKt.UNINITIALIZED = new Symbol("UNINITIALIZED");
        NullSurrogateKt.DONE = new Symbol("DONE");
    }
}

