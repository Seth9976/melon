package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u001B\u0010\u0004\u001A\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbortFlowException;", "", "owner", "Lie/H;", "checkOwnership", "(Lkotlinx/coroutines/flow/internal/AbortFlowException;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class FlowExceptions_commonKt {
    public static final void checkOwnership(@NotNull AbortFlowException abortFlowException0, @NotNull Object object0) {
        if(abortFlowException0.owner != object0) {
            throw abortFlowException0;
        }
    }
}

