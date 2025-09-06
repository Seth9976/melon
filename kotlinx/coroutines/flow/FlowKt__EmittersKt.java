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
import we.o;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\t\u001AM\u0010\b\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012(\u0010\u0007\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0002¢\u0006\u0004\b\b\u0010\t\u001AU\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000120\u0010\u0007\u001A,\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n¢\u0006\u0004\b\f\u0010\r\u001A\u0017\u0010\u000E\u001A\u00020\u0005*\u0006\u0012\u0002\b\u00030\u0003H\u0000¢\u0006\u0004\b\u000E\u0010\u000F\u001A\\\u0010\u0013\u001A\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000320\u0010\u0007\u001A,\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000BH\u0082@¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "Lie/H;", "", "action", "onStart", "(Lkotlinx/coroutines/flow/Flow;Lwe/n;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "", "onCompletion", "(Lkotlinx/coroutines/flow/Flow;Lwe/o;)Lkotlinx/coroutines/flow/Flow;", "ensureActive", "(Lkotlinx/coroutines/flow/FlowCollector;)V", "cause", "invokeSafely$FlowKt__EmittersKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lwe/o;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeSafely", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/flow/FlowKt")
abstract class FlowKt__EmittersKt {
    public static final void ensureActive(@NotNull FlowCollector flowCollector0) {
        if(flowCollector0 instanceof ThrowingCollector) {
            throw ((ThrowingCollector)flowCollector0).e;
        }
    }

    private static final Object invokeSafely$FlowKt__EmittersKt(FlowCollector flowCollector0, o o0, Throwable throwable0, Continuation continuation0) {
        kotlinx.coroutines.flow.FlowKt__EmittersKt.invokeSafely.1 flowKt__EmittersKt$invokeSafely$10;
        if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt.invokeSafely.1) {
            flowKt__EmittersKt$invokeSafely$10 = (kotlinx.coroutines.flow.FlowKt__EmittersKt.invokeSafely.1)continuation0;
            int v = flowKt__EmittersKt$invokeSafely$10.label;
            if((v & 0x80000000) == 0) {
                flowKt__EmittersKt$invokeSafely$10 = new c(continuation0) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(null, null, null, this);
                    }
                };
            }
            else {
                flowKt__EmittersKt$invokeSafely$10.label = v ^ 0x80000000;
            }
        }
        else {
            flowKt__EmittersKt$invokeSafely$10 = new c(continuation0) {
                Object L$0;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(null, null, null, this);
                }
            };
        }
        Object object0 = flowKt__EmittersKt$invokeSafely$10.result;
        a a0 = a.a;
        switch(flowKt__EmittersKt$invokeSafely$10.label) {
            case 0: {
                n.D(object0);
                try {
                    flowKt__EmittersKt$invokeSafely$10.L$0 = throwable0;
                    flowKt__EmittersKt$invokeSafely$10.label = 1;
                    if(o0.invoke(flowCollector0, throwable0, flowKt__EmittersKt$invokeSafely$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable1) {
                    goto label_23;
                }
                return H.a;
            }
            case 1: {
                throwable0 = (Throwable)flowKt__EmittersKt$invokeSafely$10.L$0;
                try {
                    n.D(object0);
                    return H.a;
                }
                catch(Throwable throwable1) {
                label_23:
                    if(throwable0 != null && throwable0 != throwable1) {
                        e2.a.q(throwable1, throwable0);
                    }
                    throw throwable1;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @NotNull
    public static final Flow onCompletion(@NotNull Flow flow0, @NotNull o o0) {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                SafeCollector safeCollector1;
                Throwable throwable2;
                kotlinx.coroutines.flow.FlowKt__EmittersKt.onCompletion..inlined.unsafeFlow.1 flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$10;
                kotlinx.coroutines.flow.FlowKt__EmittersKt.onCompletion..inlined.unsafeFlow.1.1 flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10;
                if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt.onCompletion..inlined.unsafeFlow.1.1) {
                    flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10 = (kotlinx.coroutines.flow.FlowKt__EmittersKt.onCompletion..inlined.unsafeFlow.1.1)continuation0;
                    int v = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10.label;
                    if((v & 0x80000000) == 0) {
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                            Object L$0;
                            Object L$1;
                            int label;
                            Object result;

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                this.result = object0;
                                this.label |= 0x80000000;
                                return continuation0.collect(null, this);
                            }
                        };
                    }
                    else {
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10.label = v ^ 0x80000000;
                    }
                }
                else {
                    flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
                        Object L$1;
                        int label;
                        Object result;

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.collect(null, this);
                        }
                    };
                }
                Object object0 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10.result;
                a a0 = a.a;
                switch(flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10.label) {
                    case 0: {
                        n.D(object0);
                        try {
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10.L$0 = this;
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10.L$1 = flowCollector0;
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10.label = 1;
                            if(flow0.collect(flowCollector0, flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10) == a0) {
                                return a0;
                            }
                        }
                        catch(Throwable throwable0) {
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$10 = this;
                            goto label_29;
                        }
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$10 = this;
                        goto label_35;
                    }
                    case 1: {
                        flowCollector0 = (FlowCollector)flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10.L$1;
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$10 = (kotlinx.coroutines.flow.FlowKt__EmittersKt.onCompletion..inlined.unsafeFlow.1)flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10.L$0;
                        try {
                            n.D(object0);
                            goto label_35;
                        }
                        catch(Throwable throwable0) {
                        }
                    label_29:
                        ThrowingCollector throwingCollector0 = new ThrowingCollector(throwable0);
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10.L$0 = throwable0;
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10.L$1 = null;
                        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10.label = 2;
                        if(FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(throwingCollector0, flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$10.$action$inlined, throwable0, flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10) != a0) {
                            throw throwable0;
                        }
                        return a0;
                    label_35:
                        SafeCollector safeCollector0 = new SafeCollector(flowCollector0, flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10.getContext());
                        try {
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10.L$0 = safeCollector0;
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10.L$1 = null;
                            flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10.label = 3;
                            if(flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$10.$action$inlined.invoke(safeCollector0, null, flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10) != a0) {
                                safeCollector1 = safeCollector0;
                                break;
                            }
                            return a0;
                        }
                        catch(Throwable throwable1) {
                            throwable2 = throwable1;
                            safeCollector1 = safeCollector0;
                            safeCollector1.releaseIntercepted();
                            throw throwable2;
                        }
                        safeCollector1 = safeCollector0;
                        break;
                    }
                    case 2: {
                        throwable0 = (Throwable)flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10.L$0;
                        n.D(object0);
                        throw throwable0;
                    }
                    case 3: {
                        safeCollector1 = (SafeCollector)flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$10.L$0;
                        try {
                            n.D(object0);
                            break;
                        }
                        catch(Throwable throwable2) {
                        }
                        safeCollector1.releaseIntercepted();
                        throw throwable2;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                safeCollector1.releaseIntercepted();
                return H.a;
            }
        };
    }

    @NotNull
    public static final Flow onStart(@NotNull Flow flow0, @NotNull we.n n0) {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                FlowCollector flowCollector1;
                kotlinx.coroutines.flow.FlowKt__EmittersKt.onStart..inlined.unsafeFlow.1 flowKt__EmittersKt$onStart$$inlined$unsafeFlow$10;
                SafeCollector safeCollector1;
                Throwable throwable1;
                kotlinx.coroutines.flow.FlowKt__EmittersKt.onStart..inlined.unsafeFlow.1.1 flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10;
                if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt.onStart..inlined.unsafeFlow.1.1) {
                    flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10 = (kotlinx.coroutines.flow.FlowKt__EmittersKt.onStart..inlined.unsafeFlow.1.1)continuation0;
                    int v = flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10.label;
                    if((v & 0x80000000) == 0) {
                        flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            int label;
                            Object result;

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                this.result = object0;
                                this.label |= 0x80000000;
                                return continuation0.collect(null, this);
                            }
                        };
                    }
                    else {
                        flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10.label = v ^ 0x80000000;
                    }
                }
                else {
                    flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        int label;
                        Object result;

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            this.result = object0;
                            this.label |= 0x80000000;
                            return continuation0.collect(null, this);
                        }
                    };
                }
                Object object0 = flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10.result;
                a a0 = a.a;
                switch(flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10.label) {
                    case 0: {
                        n.D(object0);
                        SafeCollector safeCollector0 = new SafeCollector(flowCollector0, flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10.getContext());
                        try {
                            flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10.L$0 = this;
                            flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10.L$1 = flowCollector0;
                            flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10.L$2 = safeCollector0;
                            flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10.label = 1;
                            if(n0.invoke(safeCollector0, flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10) == a0) {
                                return a0;
                            }
                        }
                        catch(Throwable throwable0) {
                            throwable1 = throwable0;
                            safeCollector1 = safeCollector0;
                            safeCollector1.releaseIntercepted();
                            throw throwable1;
                        }
                        flowKt__EmittersKt$onStart$$inlined$unsafeFlow$10 = this;
                        flowCollector1 = flowCollector0;
                        safeCollector1 = safeCollector0;
                        break;
                    }
                    case 1: {
                        safeCollector1 = (SafeCollector)flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10.L$2;
                        flowCollector1 = (FlowCollector)flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10.L$1;
                        flowKt__EmittersKt$onStart$$inlined$unsafeFlow$10 = (kotlinx.coroutines.flow.FlowKt__EmittersKt.onStart..inlined.unsafeFlow.1)flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10.L$0;
                        try {
                            n.D(object0);
                            break;
                        }
                        catch(Throwable throwable1) {
                        }
                        safeCollector1.releaseIntercepted();
                        throw throwable1;
                    }
                    case 2: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                safeCollector1.releaseIntercepted();
                flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10.L$0 = null;
                flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10.L$1 = null;
                flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10.L$2 = null;
                flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10.label = 2;
                return flowKt__EmittersKt$onStart$$inlined$unsafeFlow$10.$this_onStart$inlined.collect(flowCollector1, flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$10) == a0 ? a0 : H.a;
            }
        };
    }
}

