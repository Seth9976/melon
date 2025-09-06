package kotlinx.coroutines.flow;

import d5.n;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.F;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0002\b\u0005\u001A+\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001AG\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\n\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0004\b\u000B\u0010\f\u001AG\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\n\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0004\b\r\u0010\f¨\u0006\u000E"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "", "count", "drop", "(Lkotlinx/coroutines/flow/Flow;I)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "predicate", "dropWhile", "(Lkotlinx/coroutines/flow/Flow;Lwe/n;)Lkotlinx/coroutines/flow/Flow;", "takeWhile", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/flow/FlowKt")
abstract class FlowKt__LimitKt {
    @NotNull
    public static final Flow drop(@NotNull Flow flow0, int v) {
        if(v < 0) {
            throw new IllegalArgumentException(("Drop count should be non-negative, but had " + v).toString());
        }
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__LimitKt.drop.2.1 flowKt__LimitKt$drop$2$10 = new kotlinx.coroutines.flow.FlowKt__LimitKt.drop.2.1(new F(), v, flowCollector0);  // 初始化器: Ljava/lang/Object;-><init>()V
                Object object0 = flow0.collect(flowKt__LimitKt$drop$2$10, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
        final class kotlinx.coroutines.flow.FlowKt__LimitKt.drop.2.1 implements FlowCollector {
            public kotlinx.coroutines.flow.FlowKt__LimitKt.drop.2.1(F f0, int v, FlowCollector flowCollector0) {
            }

            @Override  // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object object0, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__LimitKt.drop.2.1.emit.1 flowKt__LimitKt$drop$2$1$emit$10;
                if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt.drop.2.1.emit.1) {
                    flowKt__LimitKt$drop$2$1$emit$10 = (kotlinx.coroutines.flow.FlowKt__LimitKt.drop.2.1.emit.1)continuation0;
                    int v = flowKt__LimitKt$drop$2$1$emit$10.label;
                    if((v & 0x80000000) == 0) {
                        flowKt__LimitKt$drop$2$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        flowKt__LimitKt$drop$2$1$emit$10.label = v ^ 0x80000000;
                    }
                }
                else {
                    flowKt__LimitKt$drop$2$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                Object object1 = flowKt__LimitKt$drop$2$1$emit$10.result;
                a a0 = a.a;
                H h0 = H.a;
                switch(flowKt__LimitKt$drop$2$1$emit$10.label) {
                    case 0: {
                        n.D(object1);
                        F f0 = this.$skipped;
                        int v1 = f0.a;
                        if(v1 >= this.$count) {
                            flowKt__LimitKt$drop$2$1$emit$10.label = 1;
                            return this.$this_flow.emit(object0, flowKt__LimitKt$drop$2$1$emit$10) == a0 ? a0 : h0;
                        }
                        f0.a = v1 + 1;
                        return h0;
                    }
                    case 1: {
                        n.D(object1);
                        return h0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }

    }

    @NotNull
    public static final Flow dropWhile(@NotNull Flow flow0, @NotNull we.n n0) {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__LimitKt.dropWhile.1.1 flowKt__LimitKt$dropWhile$1$10 = new kotlinx.coroutines.flow.FlowKt__LimitKt.dropWhile.1.1(new C(), flowCollector0, n0);  // 初始化器: Ljava/lang/Object;-><init>()V
                Object object0 = flow0.collect(flowKt__LimitKt$dropWhile$1$10, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
        final class kotlinx.coroutines.flow.FlowKt__LimitKt.dropWhile.1.1 implements FlowCollector {
            public kotlinx.coroutines.flow.FlowKt__LimitKt.dropWhile.1.1(C c0, FlowCollector flowCollector0, we.n n0) {
            }

            @Override  // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object object0, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__LimitKt.dropWhile.1.1 flowKt__LimitKt$dropWhile$1$10;
                kotlinx.coroutines.flow.FlowKt__LimitKt.dropWhile.1.1.emit.1 flowKt__LimitKt$dropWhile$1$1$emit$10;
                if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt.dropWhile.1.1.emit.1) {
                    flowKt__LimitKt$dropWhile$1$1$emit$10 = (kotlinx.coroutines.flow.FlowKt__LimitKt.dropWhile.1.1.emit.1)continuation0;
                    int v = flowKt__LimitKt$dropWhile$1$1$emit$10.label;
                    if((v & 0x80000000) == 0) {
                        flowKt__LimitKt$dropWhile$1$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        flowKt__LimitKt$dropWhile$1$1$emit$10.label = v ^ 0x80000000;
                    }
                }
                else {
                    flowKt__LimitKt$dropWhile$1$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                Object object1 = flowKt__LimitKt$dropWhile$1$1$emit$10.result;
                a a0 = a.a;
                H h0 = H.a;
                switch(flowKt__LimitKt$dropWhile$1$1$emit$10.label) {
                    case 0: {
                        n.D(object1);
                        if(this.$matched.a) {
                            flowKt__LimitKt$dropWhile$1$1$emit$10.label = 1;
                            return this.$this_flow.emit(object0, flowKt__LimitKt$dropWhile$1$1$emit$10) == a0 ? a0 : h0;
                        }
                        flowKt__LimitKt$dropWhile$1$1$emit$10.L$0 = this;
                        flowKt__LimitKt$dropWhile$1$1$emit$10.L$1 = object0;
                        flowKt__LimitKt$dropWhile$1$1$emit$10.label = 2;
                        object1 = this.$predicate.invoke(object0, flowKt__LimitKt$dropWhile$1$1$emit$10);
                        if(object1 == a0) {
                            return a0;
                        }
                        flowKt__LimitKt$dropWhile$1$10 = this;
                        break;
                    }
                    case 1: {
                        n.D(object1);
                        return h0;
                    }
                    case 2: {
                        object0 = flowKt__LimitKt$dropWhile$1$1$emit$10.L$1;
                        flowKt__LimitKt$dropWhile$1$10 = (kotlinx.coroutines.flow.FlowKt__LimitKt.dropWhile.1.1)flowKt__LimitKt$dropWhile$1$1$emit$10.L$0;
                        n.D(object1);
                        break;
                    }
                    case 3: {
                        n.D(object1);
                        return h0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                if(!((Boolean)object1).booleanValue()) {
                    flowKt__LimitKt$dropWhile$1$10.$matched.a = true;
                    flowKt__LimitKt$dropWhile$1$1$emit$10.L$0 = null;
                    flowKt__LimitKt$dropWhile$1$1$emit$10.L$1 = null;
                    flowKt__LimitKt$dropWhile$1$1$emit$10.label = 3;
                    if(flowKt__LimitKt$dropWhile$1$10.$this_flow.emit(object0, flowKt__LimitKt$dropWhile$1$1$emit$10) == a0) {
                        return a0;
                    }
                }
                return h0;
            }
        }

    }

    @NotNull
    public static final Flow takeWhile(@NotNull Flow flow0, @NotNull we.n n0) {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__LimitKt.takeWhile.lambda.6..inlined.collectWhile.1 flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$10;
                kotlinx.coroutines.flow.FlowKt__LimitKt.takeWhile..inlined.unsafeFlow.1.1 flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$10;
                if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt.takeWhile..inlined.unsafeFlow.1.1) {
                    flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$10 = (kotlinx.coroutines.flow.FlowKt__LimitKt.takeWhile..inlined.unsafeFlow.1.1)continuation0;
                    int v = flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$10.label;
                    if((v & 0x80000000) == 0) {
                        flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                            Object L$0;
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
                        flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$10.label = v ^ 0x80000000;
                    }
                }
                else {
                    flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                        Object L$0;
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
                Object object0 = flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$10.result;
                a a0 = a.a;
                switch(flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$10.label) {
                    case 0: {
                        n.D(object0);
                        kotlinx.coroutines.flow.FlowKt__LimitKt.takeWhile.lambda.6..inlined.collectWhile.1 flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$11 = new kotlinx.coroutines.flow.FlowKt__LimitKt.takeWhile.lambda.6..inlined.collectWhile.1(n0, flowCollector0);
                        try {
                            flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$10.L$0 = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$11;
                            flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$10.label = 1;
                            return flow0.collect(flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$11, flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$10) == a0 ? a0 : H.a;
                        }
                        catch(AbortFlowException abortFlowException0) {
                            flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$10 = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$11;
                        }
                        FlowExceptions_commonKt.checkOwnership(abortFlowException0, flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$10);
                        JobKt.ensureActive(flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$10.getContext());
                        return H.a;
                    }
                    case 1: {
                        flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$10 = (kotlinx.coroutines.flow.FlowKt__LimitKt.takeWhile.lambda.6..inlined.collectWhile.1)flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$10.L$0;
                        try {
                            n.D(object0);
                        }
                        catch(AbortFlowException abortFlowException0) {
                            FlowExceptions_commonKt.checkOwnership(abortFlowException0, flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$10);
                            JobKt.ensureActive(flowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$10.getContext());
                        }
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        };

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0018\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0002\u001A\u00028\u0000H\u0096@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "Lie/H;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
        public final class kotlinx.coroutines.flow.FlowKt__LimitKt.takeWhile.lambda.6..inlined.collectWhile.1 implements FlowCollector {
            public kotlinx.coroutines.flow.FlowKt__LimitKt.takeWhile.lambda.6..inlined.collectWhile.1(we.n n0, FlowCollector flowCollector0) {
            }

            @Override  // kotlinx.coroutines.flow.FlowCollector
            public Object emit(Object object0, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__LimitKt.takeWhile.lambda.6..inlined.collectWhile.1 flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$10;
                Object object4;
                Object object3;
                kotlinx.coroutines.flow.FlowKt__LimitKt.takeWhile.lambda.6..inlined.collectWhile.1.1 flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10;
                if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt.takeWhile.lambda.6..inlined.collectWhile.1.1) {
                    flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10 = (kotlinx.coroutines.flow.FlowKt__LimitKt.takeWhile.lambda.6..inlined.collectWhile.1.1)continuation0;
                    int v = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10.label;
                    if((v & 0x80000000) == 0) {
                        flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10.label = v ^ 0x80000000;
                    }
                }
                else {
                    flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                Object object1 = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10.result;
                a a0 = a.a;
                boolean z = true;
                switch(flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10.label) {
                    case 0: {
                        n.D(object1);
                        flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10.L$0 = this;
                        flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10.L$1 = object0;
                        flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10.label = 1;
                        Object object2 = this.$predicate$inlined.invoke(object0, flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10);
                        if(object2 == a0) {
                            return a0;
                        }
                        object3 = object2;
                        object4 = object0;
                        flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$10 = this;
                        goto label_30;
                    }
                    case 1: {
                        Object object5 = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10.L$1;
                        kotlinx.coroutines.flow.FlowKt__LimitKt.takeWhile.lambda.6..inlined.collectWhile.1 flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$11 = (kotlinx.coroutines.flow.FlowKt__LimitKt.takeWhile.lambda.6..inlined.collectWhile.1)flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10.L$0;
                        n.D(object1);
                        object4 = object5;
                        flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$10 = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$11;
                        object3 = object1;
                    label_30:
                        if(((Boolean)object3).booleanValue()) {
                            flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10.L$0 = flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$10;
                            flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10.L$1 = null;
                            flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10.label = 2;
                            if(flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$10.$this_flow$inlined.emit(object4, flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10) == a0) {
                                return a0;
                            }
                        }
                        else {
                            z = false;
                        }
                        break;
                    }
                    case 2: {
                        flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$10 = (kotlinx.coroutines.flow.FlowKt__LimitKt.takeWhile.lambda.6..inlined.collectWhile.1)flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1$10.L$0;
                        n.D(object1);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                if(!z) {
                    throw new AbortFlowException(flowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$10);
                }
                return H.a;
            }
        }

    }
}

