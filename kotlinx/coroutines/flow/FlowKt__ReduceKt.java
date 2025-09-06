package kotlinx.coroutines.flow;

import H0.b;
import d5.n;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0004\u001A \u0010\u0002\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@¢\u0006\u0004\b\u0002\u0010\u0003\u001AD\u0010\u0002\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\b\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086@¢\u0006\u0004\b\u0002\u0010\t\u001A\"\u0010\n\u001A\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@¢\u0006\u0004\b\n\u0010\u0003¨\u0006\u000B"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "first", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "predicate", "(Lkotlinx/coroutines/flow/Flow;Lwe/n;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstOrNull", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/flow/FlowKt")
abstract class FlowKt__ReduceKt {
    @Nullable
    public static final Object first(@NotNull Flow flow0, @NotNull Continuation continuation0) {
        kotlinx.coroutines.flow.FlowKt__ReduceKt.first..inlined.collectWhile.1 flowKt__ReduceKt$first$$inlined$collectWhile$11;
        AbortFlowException abortFlowException1;
        H h1;
        kotlinx.coroutines.flow.FlowKt__ReduceKt.first.1 flowKt__ReduceKt$first$10;
        if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.first.1) {
            flowKt__ReduceKt$first$10 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.first.1)continuation0;
            int v = flowKt__ReduceKt$first$10.label;
            if((v & 0x80000000) == 0) {
                flowKt__ReduceKt$first$10 = new c(continuation0) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return FlowKt.first(null, this);
                    }
                };
            }
            else {
                flowKt__ReduceKt$first$10.label = v ^ 0x80000000;
            }
        }
        else {
            flowKt__ReduceKt$first$10 = new c(continuation0) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return FlowKt.first(null, this);
                }
            };
        }
        Object object0 = flowKt__ReduceKt$first$10.result;
        a a0 = a.a;
        switch(flowKt__ReduceKt$first$10.label) {
            case 0: {
                H h0 = b.p(object0);
                h0.a = NullSurrogateKt.NULL;
                kotlinx.coroutines.flow.FlowKt__ReduceKt.first..inlined.collectWhile.1 flowKt__ReduceKt$first$$inlined$collectWhile$10 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(Object object0, Continuation continuation0) {
                        h0.a = object0;
                        throw new AbortFlowException(this);
                    }
                };
                try {
                    flowKt__ReduceKt$first$10.L$0 = h0;
                    flowKt__ReduceKt$first$10.L$1 = flowKt__ReduceKt$first$$inlined$collectWhile$10;
                    flowKt__ReduceKt$first$10.label = 1;
                    if(flow0.collect(flowKt__ReduceKt$first$$inlined$collectWhile$10, flowKt__ReduceKt$first$10) == a0) {
                        return a0;
                    }
                }
                catch(AbortFlowException abortFlowException0) {
                    h1 = h0;
                    abortFlowException1 = abortFlowException0;
                    flowKt__ReduceKt$first$$inlined$collectWhile$11 = flowKt__ReduceKt$first$$inlined$collectWhile$10;
                    FlowExceptions_commonKt.checkOwnership(abortFlowException1, flowKt__ReduceKt$first$$inlined$collectWhile$11);
                    JobKt.ensureActive(flowKt__ReduceKt$first$10.getContext());
                    break;
                }
                h1 = h0;
                break;
            }
            case 1: {
                flowKt__ReduceKt$first$$inlined$collectWhile$11 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.first..inlined.collectWhile.1)flowKt__ReduceKt$first$10.L$1;
                h1 = (H)flowKt__ReduceKt$first$10.L$0;
                try {
                    n.D(object0);
                    break;
                }
                catch(AbortFlowException abortFlowException1) {
                }
                FlowExceptions_commonKt.checkOwnership(abortFlowException1, flowKt__ReduceKt$first$$inlined$collectWhile$11);
                JobKt.ensureActive(flowKt__ReduceKt$first$10.getContext());
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Object object1 = h1.a;
        if(object1 == NullSurrogateKt.NULL) {
            throw new NoSuchElementException("Expected at least one element");
        }
        return object1;
    }

    @Nullable
    public static final Object first(@NotNull Flow flow0, @NotNull we.n n0, @NotNull Continuation continuation0) {
        kotlinx.coroutines.flow.FlowKt__ReduceKt.first..inlined.collectWhile.2 flowKt__ReduceKt$first$$inlined$collectWhile$21;
        AbortFlowException abortFlowException1;
        H h1;
        kotlinx.coroutines.flow.FlowKt__ReduceKt.first.3 flowKt__ReduceKt$first$30;
        if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.first.3) {
            flowKt__ReduceKt$first$30 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.first.3)continuation0;
            int v = flowKt__ReduceKt$first$30.label;
            if((v & 0x80000000) == 0) {
                flowKt__ReduceKt$first$30 = new c(continuation0) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return FlowKt.first(null, null, this);
                    }
                };
            }
            else {
                flowKt__ReduceKt$first$30.label = v ^ 0x80000000;
            }
        }
        else {
            flowKt__ReduceKt$first$30 = new c(continuation0) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return FlowKt.first(null, null, this);
                }
            };
        }
        Object object0 = flowKt__ReduceKt$first$30.result;
        a a0 = a.a;
        switch(flowKt__ReduceKt$first$30.label) {
            case 0: {
                H h0 = b.p(object0);
                h0.a = NullSurrogateKt.NULL;
                kotlinx.coroutines.flow.FlowKt__ReduceKt.first..inlined.collectWhile.2 flowKt__ReduceKt$first$$inlined$collectWhile$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(Object object0, Continuation continuation0) {
                        kotlinx.coroutines.flow.FlowKt__ReduceKt.first..inlined.collectWhile.2 flowKt__ReduceKt$first$$inlined$collectWhile$20;
                        kotlinx.coroutines.flow.FlowKt__ReduceKt.first..inlined.collectWhile.2.1 flowKt__ReduceKt$first$$inlined$collectWhile$2$10;
                        if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.first..inlined.collectWhile.2.1) {
                            flowKt__ReduceKt$first$$inlined$collectWhile$2$10 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.first..inlined.collectWhile.2.1)continuation0;
                            int v = flowKt__ReduceKt$first$$inlined$collectWhile$2$10.label;
                            if((v & 0x80000000) == 0) {
                                flowKt__ReduceKt$first$$inlined$collectWhile$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                    Object L$0;
                                    Object L$1;
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
                                flowKt__ReduceKt$first$$inlined$collectWhile$2$10.label = v ^ 0x80000000;
                            }
                        }
                        else {
                            flowKt__ReduceKt$first$$inlined$collectWhile$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                Object L$0;
                                Object L$1;
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
                        Object object1 = flowKt__ReduceKt$first$$inlined$collectWhile$2$10.result;
                        a a0 = a.a;
                        switch(flowKt__ReduceKt$first$$inlined$collectWhile$2$10.label) {
                            case 0: {
                                n.D(object1);
                                flowKt__ReduceKt$first$$inlined$collectWhile$2$10.L$0 = this;
                                flowKt__ReduceKt$first$$inlined$collectWhile$2$10.L$1 = object0;
                                flowKt__ReduceKt$first$$inlined$collectWhile$2$10.label = 1;
                                object1 = n0.invoke(object0, flowKt__ReduceKt$first$$inlined$collectWhile$2$10);
                                if(object1 == a0) {
                                    return a0;
                                }
                                flowKt__ReduceKt$first$$inlined$collectWhile$20 = this;
                                break;
                            }
                            case 1: {
                                object0 = flowKt__ReduceKt$first$$inlined$collectWhile$2$10.L$1;
                                flowKt__ReduceKt$first$$inlined$collectWhile$20 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.first..inlined.collectWhile.2)flowKt__ReduceKt$first$$inlined$collectWhile$2$10.L$0;
                                n.D(object1);
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        if(!((Boolean)object1).booleanValue()) {
                            return ie.H.a;
                        }
                        flowKt__ReduceKt$first$$inlined$collectWhile$20.$result$inlined.a = object0;
                        throw new AbortFlowException(flowKt__ReduceKt$first$$inlined$collectWhile$20);
                    }
                };
                try {
                    flowKt__ReduceKt$first$30.L$0 = h0;
                    flowKt__ReduceKt$first$30.L$1 = flowKt__ReduceKt$first$$inlined$collectWhile$20;
                    flowKt__ReduceKt$first$30.label = 1;
                    if(flow0.collect(flowKt__ReduceKt$first$$inlined$collectWhile$20, flowKt__ReduceKt$first$30) == a0) {
                        return a0;
                    }
                }
                catch(AbortFlowException abortFlowException0) {
                    h1 = h0;
                    abortFlowException1 = abortFlowException0;
                    flowKt__ReduceKt$first$$inlined$collectWhile$21 = flowKt__ReduceKt$first$$inlined$collectWhile$20;
                    FlowExceptions_commonKt.checkOwnership(abortFlowException1, flowKt__ReduceKt$first$$inlined$collectWhile$21);
                    JobKt.ensureActive(flowKt__ReduceKt$first$30.getContext());
                    break;
                }
                h1 = h0;
                break;
            }
            case 1: {
                flowKt__ReduceKt$first$$inlined$collectWhile$21 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.first..inlined.collectWhile.2)flowKt__ReduceKt$first$30.L$1;
                h1 = (H)flowKt__ReduceKt$first$30.L$0;
                try {
                    n.D(object0);
                    break;
                }
                catch(AbortFlowException abortFlowException1) {
                }
                FlowExceptions_commonKt.checkOwnership(abortFlowException1, flowKt__ReduceKt$first$$inlined$collectWhile$21);
                JobKt.ensureActive(flowKt__ReduceKt$first$30.getContext());
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Object object1 = h1.a;
        if(object1 == NullSurrogateKt.NULL) {
            throw new NoSuchElementException("Expected at least one element matching the predicate");
        }
        return object1;
    }

    @Nullable
    public static final Object firstOrNull(@NotNull Flow flow0, @NotNull Continuation continuation0) {
        kotlinx.coroutines.flow.FlowKt__ReduceKt.firstOrNull..inlined.collectWhile.1 flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$11;
        AbortFlowException abortFlowException1;
        H h1;
        kotlinx.coroutines.flow.FlowKt__ReduceKt.firstOrNull.1 flowKt__ReduceKt$firstOrNull$10;
        if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__ReduceKt.firstOrNull.1) {
            flowKt__ReduceKt$firstOrNull$10 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.firstOrNull.1)continuation0;
            int v = flowKt__ReduceKt$firstOrNull$10.label;
            if((v & 0x80000000) == 0) {
                flowKt__ReduceKt$firstOrNull$10 = new c(continuation0) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return FlowKt.firstOrNull(null, this);
                    }
                };
            }
            else {
                flowKt__ReduceKt$firstOrNull$10.label = v ^ 0x80000000;
            }
        }
        else {
            flowKt__ReduceKt$firstOrNull$10 = new c(continuation0) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return FlowKt.firstOrNull(null, this);
                }
            };
        }
        Object object0 = flowKt__ReduceKt$firstOrNull$10.result;
        a a0 = a.a;
        switch(flowKt__ReduceKt$firstOrNull$10.label) {
            case 0: {
                H h0 = b.p(object0);
                kotlinx.coroutines.flow.FlowKt__ReduceKt.firstOrNull..inlined.collectWhile.1 flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$10 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(Object object0, Continuation continuation0) {
                        h0.a = object0;
                        throw new AbortFlowException(this);
                    }
                };
                try {
                    flowKt__ReduceKt$firstOrNull$10.L$0 = h0;
                    flowKt__ReduceKt$firstOrNull$10.L$1 = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$10;
                    flowKt__ReduceKt$firstOrNull$10.label = 1;
                    return flow0.collect(flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$10, flowKt__ReduceKt$firstOrNull$10) == a0 ? a0 : h0.a;
                }
                catch(AbortFlowException abortFlowException0) {
                    h1 = h0;
                    abortFlowException1 = abortFlowException0;
                    flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$11 = flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$10;
                    FlowExceptions_commonKt.checkOwnership(abortFlowException1, flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$11);
                    JobKt.ensureActive(flowKt__ReduceKt$firstOrNull$10.getContext());
                    return h1.a;
                }
            }
            case 1: {
                flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$11 = (kotlinx.coroutines.flow.FlowKt__ReduceKt.firstOrNull..inlined.collectWhile.1)flowKt__ReduceKt$firstOrNull$10.L$1;
                h1 = (H)flowKt__ReduceKt$firstOrNull$10.L$0;
                try {
                    n.D(object0);
                    return h1.a;
                }
                catch(AbortFlowException abortFlowException1) {
                }
                FlowExceptions_commonKt.checkOwnership(abortFlowException1, flowKt__ReduceKt$firstOrNull$$inlined$collectWhile$11);
                JobKt.ensureActive(flowKt__ReduceKt$firstOrNull$10.getContext());
                return h1.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

