package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BI\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0014\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u001C\u0010\t\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u001E\u0010\u000F\u001A\u00020\u000E2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\fH\u0096@¢\u0006\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\"\u0010\u0006\u001A\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012R*\u0010\t\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/flow/DistinctFlowImpl;", "T", "Lkotlinx/coroutines/flow/Flow;", "upstream", "Lkotlin/Function1;", "", "keySelector", "Lkotlin/Function2;", "", "areEquivalent", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lwe/k;Lwe/n;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "Lie/H;", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "Lwe/k;", "Lwe/n;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class DistinctFlowImpl implements Flow {
    @NotNull
    public final n areEquivalent;
    @NotNull
    public final k keySelector;
    @NotNull
    private final Flow upstream;

    public DistinctFlowImpl(@NotNull Flow flow0, @NotNull k k0, @NotNull n n0) {
        this.upstream = flow0;
        this.keySelector = k0;
        this.areEquivalent = n0;
    }

    @Override  // kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull FlowCollector flowCollector0, @NotNull Continuation continuation0) {
        H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
        h0.a = NullSurrogateKt.NULL;
        kotlinx.coroutines.flow.DistinctFlowImpl.collect.2 distinctFlowImpl$collect$20 = new FlowCollector() {
            @Override  // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object object0, Continuation continuation0) {
                kotlinx.coroutines.flow.DistinctFlowImpl.collect.2.emit.1 distinctFlowImpl$collect$2$emit$10;
                if(continuation0 instanceof kotlinx.coroutines.flow.DistinctFlowImpl.collect.2.emit.1) {
                    distinctFlowImpl$collect$2$emit$10 = (kotlinx.coroutines.flow.DistinctFlowImpl.collect.2.emit.1)continuation0;
                    int v = distinctFlowImpl$collect$2$emit$10.label;
                    if((v & 0x80000000) == 0) {
                        distinctFlowImpl$collect$2$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                            int label;
                            Object result;

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                this.result = object0;
                                this.label |= 0x80000000;
                                return continuation0.emit(null, this);
                            }
                        };
                    }
                    else {
                        distinctFlowImpl$collect$2$emit$10.label = v ^ 0x80000000;
                    }
                }
                else {
                    distinctFlowImpl$collect$2$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        int label;
                        Object result;

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.emit(null, this);
                        }
                    };
                }
                Object object1 = distinctFlowImpl$collect$2$emit$10.result;
                a a0 = a.a;
                ie.H h0 = ie.H.a;
                switch(distinctFlowImpl$collect$2$emit$10.label) {
                    case 0: {
                        d5.n.D(object1);
                        Object object2 = h0.keySelector.invoke(object0);
                        Object object3 = flowCollector0.a;
                        if(object3 != NullSurrogateKt.NULL && ((Boolean)h0.areEquivalent.invoke(object3, object2)).booleanValue()) {
                            return h0;
                        }
                        flowCollector0.a = object2;
                        distinctFlowImpl$collect$2$emit$10.label = 1;
                        return this.$collector.emit(object0, distinctFlowImpl$collect$2$emit$10) == a0 ? a0 : h0;
                    }
                    case 1: {
                        d5.n.D(object1);
                        return h0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        };
        Object object0 = this.upstream.collect(distinctFlowImpl$collect$20, continuation0);
        return object0 == a.a ? object0 : ie.H.a;
    }
}

