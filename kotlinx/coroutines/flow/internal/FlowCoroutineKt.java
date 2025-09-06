package kotlinx.coroutines.flow.internal;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import ne.a;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;
import we.o;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A<\u0010\u0006\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u00002$\b\u0001\u0010\u0005\u001A\u001E\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001H\u0080@¢\u0006\u0004\b\u0006\u0010\u0007\u001AM\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u000B\"\u0004\b\u0000\u0010\u000020\b\u0001\u0010\u0005\u001A*\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bH\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"R", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "block", "flowScope", "(Lwe/n;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lie/H;", "Lkotlinx/coroutines/flow/Flow;", "scopedFlow", "(Lwe/o;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class FlowCoroutineKt {
    @Nullable
    public static final Object flowScope(@NotNull n n0, @NotNull Continuation continuation0) {
        FlowCoroutine flowCoroutine0 = new FlowCoroutine(continuation0.getContext(), continuation0);
        return UndispatchedKt.startUndispatchedOrReturn(flowCoroutine0, flowCoroutine0, n0);
    }

    @NotNull
    public static final Flow scopedFlow(@NotNull o o0) {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                Object object0 = FlowCoroutineKt.flowScope(new kotlinx.coroutines.flow.internal.FlowCoroutineKt.scopedFlow.1.1(o0, flowCollector0, null), continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 1, 0})
        @e(c = "kotlinx.coroutines.flow.internal.FlowCoroutineKt$scopedFlow$1$1", f = "FlowCoroutine.kt", l = {0x2F}, m = "invokeSuspend")
        final class kotlinx.coroutines.flow.internal.FlowCoroutineKt.scopedFlow.1.1 extends i implements n {
            final o $block;
            final FlowCollector $this_flow;
            private Object L$0;
            int label;

            public kotlinx.coroutines.flow.internal.FlowCoroutineKt.scopedFlow.1.1(o o0, FlowCollector flowCollector0, Continuation continuation0) {
                this.$block = o0;
                this.$this_flow = flowCollector0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new kotlinx.coroutines.flow.internal.FlowCoroutineKt.scopedFlow.1.1(this.$block, this.$this_flow, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((kotlinx.coroutines.flow.internal.FlowCoroutineKt.scopedFlow.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        return this.$block.invoke(((CoroutineScope)this.L$0), this.$this_flow, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }

    }
}

