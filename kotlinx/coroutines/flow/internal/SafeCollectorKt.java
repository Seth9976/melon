package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import we.o;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"D\u0010\u0005\u001A,\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00008\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/coroutines/Continuation;", "Lie/H;", "emitFun", "Lwe/o;", "getEmitFun$annotations", "()V", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class SafeCollectorKt {
    @NotNull
    private static final o emitFun;

    static {
        q.e(SafeCollectorKt.emitFun.1.INSTANCE, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        N.e(3, SafeCollectorKt.emitFun.1.INSTANCE);
        SafeCollectorKt.emitFun = SafeCollectorKt.emitFun.1.INSTANCE;
    }

    public static final o access$getEmitFun$p() {
        return SafeCollectorKt.emitFun;
    }
}

