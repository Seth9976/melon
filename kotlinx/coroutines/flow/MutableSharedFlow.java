package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003J\u0018\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0004\u001A\u00028\u0000H¦@¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0004\u001A\u00028\u0000H&¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\u0005H\'¢\u0006\u0004\b\u000B\u0010\fR\u001A\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u000E0\r8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/flow/MutableSharedFlow;", "T", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "Lie/H;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "tryEmit", "(Ljava/lang/Object;)Z", "resetReplayCache", "()V", "Lkotlinx/coroutines/flow/StateFlow;", "", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "subscriptionCount", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface MutableSharedFlow extends FlowCollector, SharedFlow {
    @Override  // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    Object emit(Object arg1, @NotNull Continuation arg2);

    @NotNull
    StateFlow getSubscriptionCount();

    void resetReplayCache();

    boolean tryEmit(Object arg1);
}

