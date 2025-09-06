package kotlinx.coroutines.flow;

import d5.n;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.internal.SafeCollector;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001E\u0010\t\u001A\u00020\b2\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0086@¢\u0006\u0004\b\t\u0010\nJ\u001E\u0010\u000B\u001A\u00020\b2\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006H¦@¢\u0006\u0004\b\u000B\u0010\n¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/flow/AbstractFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "", "<init>", "()V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "Lie/H;", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSafely", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public abstract class AbstractFlow implements Flow {
    @Override  // kotlinx.coroutines.flow.Flow
    @Nullable
    public final Object collect(@NotNull FlowCollector flowCollector0, @NotNull Continuation continuation0) {
        SafeCollector safeCollector1;
        Throwable throwable1;
        kotlinx.coroutines.flow.AbstractFlow.collect.1 abstractFlow$collect$10;
        if(continuation0 instanceof kotlinx.coroutines.flow.AbstractFlow.collect.1) {
            abstractFlow$collect$10 = (kotlinx.coroutines.flow.AbstractFlow.collect.1)continuation0;
            int v = abstractFlow$collect$10.label;
            if((v & 0x80000000) == 0) {
                abstractFlow$collect$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.collect(null, this);
                    }
                };
            }
            else {
                abstractFlow$collect$10.label = v ^ 0x80000000;
            }
        }
        else {
            abstractFlow$collect$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.collect(null, this);
                }
            };
        }
        Object object0 = abstractFlow$collect$10.result;
        a a0 = a.a;
        switch(abstractFlow$collect$10.label) {
            case 0: {
                n.D(object0);
                SafeCollector safeCollector0 = new SafeCollector(flowCollector0, abstractFlow$collect$10.getContext());
                try {
                    abstractFlow$collect$10.L$0 = safeCollector0;
                    abstractFlow$collect$10.label = 1;
                    if(this.collectSafely(safeCollector0, abstractFlow$collect$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    throwable1 = throwable0;
                    safeCollector1 = safeCollector0;
                    safeCollector1.releaseIntercepted();
                    throw throwable1;
                }
                safeCollector1 = safeCollector0;
                break;
            }
            case 1: {
                safeCollector1 = (SafeCollector)abstractFlow$collect$10.L$0;
                try {
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable1) {
                }
                safeCollector1.releaseIntercepted();
                throw throwable1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        safeCollector1.releaseIntercepted();
        return H.a;
    }

    @Nullable
    public abstract Object collectSafely(@NotNull FlowCollector arg1, @NotNull Continuation arg2);
}

