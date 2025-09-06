package kotlinx.coroutines.flow;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B1\u0012(\u0010\b\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003¢\u0006\u0004\b\t\u0010\nJ\u001E\u0010\f\u001A\u00020\u00062\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096@¢\u0006\u0004\b\f\u0010\rR6\u0010\b\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000E¨\u0006\u000F"}, d2 = {"Lkotlinx/coroutines/flow/SafeFlow;", "T", "Lkotlinx/coroutines/flow/AbstractFlow;", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "Lie/H;", "", "block", "<init>", "(Lwe/n;)V", "collector", "collectSafely", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lwe/n;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class SafeFlow extends AbstractFlow {
    @NotNull
    private final n block;

    public SafeFlow(@NotNull n n0) {
        this.block = n0;
    }

    @Override  // kotlinx.coroutines.flow.AbstractFlow
    @Nullable
    public Object collectSafely(@NotNull FlowCollector flowCollector0, @NotNull Continuation continuation0) {
        Object object0 = this.block.invoke(flowCollector0, continuation0);
        return object0 == a.a ? object0 : H.a;
    }
}

