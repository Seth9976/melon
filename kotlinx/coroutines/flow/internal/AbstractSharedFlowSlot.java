package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000B\u0018\u00010\n0\t2\u0006\u0010\u0005\u001A\u00028\u0000H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "F", "", "<init>", "()V", "flow", "", "allocateLocked", "(Ljava/lang/Object;)Z", "", "Lkotlin/coroutines/Continuation;", "Lie/H;", "freeLocked", "(Ljava/lang/Object;)[Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class AbstractSharedFlowSlot {
    public abstract boolean allocateLocked(Object arg1);

    @NotNull
    public abstract Continuation[] freeLocked(Object arg1);
}

