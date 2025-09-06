package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\b\u001A#\u0010\u0002\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001A=\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b\u001AY\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00052\u001C\u0010\f\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u000B0\nH\u0002¢\u0006\u0004\b\r\u0010\u000E\"$\u0010\u000F\u001A\u0012\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010\"*\u0010\u0011\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u000B0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "distinctUntilChanged", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "K", "Lkotlin/Function1;", "keySelector", "distinctUntilChangedBy", "(Lkotlinx/coroutines/flow/Flow;Lwe/k;)Lkotlinx/coroutines/flow/Flow;", "", "Lkotlin/Function2;", "", "areEquivalent", "distinctUntilChangedBy$FlowKt__DistinctKt", "(Lkotlinx/coroutines/flow/Flow;Lwe/k;Lwe/n;)Lkotlinx/coroutines/flow/Flow;", "defaultKeySelector", "Lwe/k;", "defaultAreEquivalent", "Lwe/n;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/flow/FlowKt")
abstract class FlowKt__DistinctKt {
    @NotNull
    private static final n defaultAreEquivalent;
    @NotNull
    private static final k defaultKeySelector;

    static {
        FlowKt__DistinctKt.defaultKeySelector = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        FlowKt__DistinctKt.defaultAreEquivalent = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static Object b(Object object0) {
        return object0;
    }

    private static final boolean defaultAreEquivalent$lambda$1$FlowKt__DistinctKt(Object object0, Object object1) {
        return q.b(object0, object1);
    }

    private static final Object defaultKeySelector$lambda$0$FlowKt__DistinctKt(Object object0) [...] // Inlined contents

    // 去混淆评级： 低(20)
    @NotNull
    public static final Flow distinctUntilChanged(@NotNull Flow flow0) {
        return flow0 instanceof StateFlow ? flow0 : FlowKt__DistinctKt.distinctUntilChangedBy$FlowKt__DistinctKt(flow0, FlowKt__DistinctKt.defaultKeySelector, FlowKt__DistinctKt.defaultAreEquivalent);
    }

    @NotNull
    public static final Flow distinctUntilChangedBy(@NotNull Flow flow0, @NotNull k k0) {
        return FlowKt__DistinctKt.distinctUntilChangedBy$FlowKt__DistinctKt(flow0, k0, FlowKt__DistinctKt.defaultAreEquivalent);
    }

    private static final Flow distinctUntilChangedBy$FlowKt__DistinctKt(Flow flow0, k k0, n n0) {
        return flow0 instanceof DistinctFlowImpl && ((DistinctFlowImpl)flow0).keySelector == k0 && ((DistinctFlowImpl)flow0).areEquivalent == n0 ? flow0 : new DistinctFlowImpl(flow0, k0, n0);
    }
}

