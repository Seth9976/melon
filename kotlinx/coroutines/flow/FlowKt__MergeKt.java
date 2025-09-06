package kotlinx.coroutines.flow;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.internal.SystemPropsKt;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import we.n;
import we.o;

@Metadata(d1 = {"\u0000@\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u001C\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u001AU\u0010\u0007\u001A\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022(\u0010\u0006\u001A$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0007\u00A2\u0006\u0004\b\u0007\u0010\b\u001A+\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0002H\u0007\u00A2\u0006\u0004\b\t\u0010\n\u001A)\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u000B\u00A2\u0006\u0004\b\f\u0010\r\u001A9\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u001E\u0010\u000F\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u000E\"\b\u0012\u0004\u0012\u00028\u00000\u0002\u00A2\u0006\u0004\b\f\u0010\u0010\u001A]\u0010\u0014\u001A\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000220\b\u0001\u0010\u0006\u001A*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0011H\u0007\u00A2\u0006\u0004\b\u0014\u0010\u0015\u001AQ\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022$\b\u0001\u0010\u0006\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0007\u00A2\u0006\u0004\b\u0016\u0010\b\" \u0010\u0018\u001A\u00020\u00178\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001A\u0010\u001B\u00A8\u0006\u001E"}, d2 = {"T", "R", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "transform", "flatMapConcat", "(Lkotlinx/coroutines/flow/Flow;Lwe/n;)Lkotlinx/coroutines/flow/Flow;", "flattenConcat", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "", "merge", "(Ljava/lang/Iterable;)Lkotlinx/coroutines/flow/Flow;", "", "flows", "([Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lie/H;", "transformLatest", "(Lkotlinx/coroutines/flow/Flow;Lwe/o;)Lkotlinx/coroutines/flow/Flow;", "mapLatest", "", "DEFAULT_CONCURRENCY", "I", "getDEFAULT_CONCURRENCY", "()I", "getDEFAULT_CONCURRENCY$annotations", "()V", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/flow/FlowKt")
abstract class FlowKt__MergeKt {
    private static final int DEFAULT_CONCURRENCY;

    static {
        FlowKt__MergeKt.DEFAULT_CONCURRENCY = SystemPropsKt.systemProp("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, 0x7FFFFFFF);
    }

    @NotNull
    public static final Flow flatMapConcat(@NotNull Flow flow0, @NotNull n n0) {
        return FlowKt.flattenConcat(new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__MergeKt.flatMapConcat..inlined.map.1.2 flowKt__MergeKt$flatMapConcat$$inlined$map$1$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        FlowCollector flowCollector1;
                        kotlinx.coroutines.flow.FlowKt__MergeKt.flatMapConcat..inlined.map.1.2.1 flowKt__MergeKt$flatMapConcat$$inlined$map$1$2$10;
                        if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt.flatMapConcat..inlined.map.1.2.1) {
                            flowKt__MergeKt$flatMapConcat$$inlined$map$1$2$10 = (kotlinx.coroutines.flow.FlowKt__MergeKt.flatMapConcat..inlined.map.1.2.1)continuation0;
                            int v = flowKt__MergeKt$flatMapConcat$$inlined$map$1$2$10.label;
                            if((v & 0x80000000) == 0) {
                                flowKt__MergeKt$flatMapConcat$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                    Object L$0;
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
                                flowKt__MergeKt$flatMapConcat$$inlined$map$1$2$10.label = v ^ 0x80000000;
                            }
                        }
                        else {
                            flowKt__MergeKt$flatMapConcat$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                Object L$0;
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
                        Object object1 = flowKt__MergeKt$flatMapConcat$$inlined$map$1$2$10.result;
                        a a0 = a.a;
                        switch(flowKt__MergeKt$flatMapConcat$$inlined$map$1$2$10.label) {
                            case 0: {
                                d5.n.D(object1);
                                FlowCollector flowCollector0 = this.$transform$inlined$1;
                                flowKt__MergeKt$flatMapConcat$$inlined$map$1$2$10.L$0 = flowCollector0;
                                flowKt__MergeKt$flatMapConcat$$inlined$map$1$2$10.label = 1;
                                Object object2 = this.$transform$inlined.invoke(object0, flowKt__MergeKt$flatMapConcat$$inlined$map$1$2$10);
                                if(object2 == a0) {
                                    return a0;
                                }
                                object1 = object2;
                                flowCollector1 = flowCollector0;
                                break;
                            }
                            case 1: {
                                flowCollector1 = (FlowCollector)flowKt__MergeKt$flatMapConcat$$inlined$map$1$2$10.L$0;
                                d5.n.D(object1);
                                break;
                            }
                            case 2: {
                                d5.n.D(object1);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        flowKt__MergeKt$flatMapConcat$$inlined$map$1$2$10.L$0 = null;
                        flowKt__MergeKt$flatMapConcat$$inlined$map$1$2$10.label = 2;
                        return flowCollector1.emit(object1, flowKt__MergeKt$flatMapConcat$$inlined$map$1$2$10) == a0 ? a0 : H.a;
                    }
                };
                Object object0 = flow0.collect(flowKt__MergeKt$flatMapConcat$$inlined$map$1$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        });
    }

    @NotNull
    public static final Flow flattenConcat(@NotNull Flow flow0) {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__MergeKt.flattenConcat.1.1 flowKt__MergeKt$flattenConcat$1$10 = new kotlinx.coroutines.flow.FlowKt__MergeKt.flattenConcat.1.1(flowCollector0);
                Object object0 = flow0.collect(flowKt__MergeKt$flattenConcat$1$10, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
        final class kotlinx.coroutines.flow.FlowKt__MergeKt.flattenConcat.1.1 implements FlowCollector {
            public kotlinx.coroutines.flow.FlowKt__MergeKt.flattenConcat.1.1(FlowCollector flowCollector0) {
            }

            @Override  // kotlinx.coroutines.flow.FlowCollector
            public Object emit(Object object0, Continuation continuation0) {
                return this.emit(((Flow)object0), continuation0);
            }

            public final Object emit(Flow flow0, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__MergeKt.flattenConcat.1.1.emit.1 flowKt__MergeKt$flattenConcat$1$1$emit$10;
                if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt.flattenConcat.1.1.emit.1) {
                    flowKt__MergeKt$flattenConcat$1$1$emit$10 = (kotlinx.coroutines.flow.FlowKt__MergeKt.flattenConcat.1.1.emit.1)continuation0;
                    int v = flowKt__MergeKt$flattenConcat$1$1$emit$10.label;
                    if((v & 0x80000000) == 0) {
                        flowKt__MergeKt$flattenConcat$1$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        flowKt__MergeKt$flattenConcat$1$1$emit$10.label = v ^ 0x80000000;
                    }
                }
                else {
                    flowKt__MergeKt$flattenConcat$1$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                Object object0 = flowKt__MergeKt$flattenConcat$1$1$emit$10.result;
                a a0 = a.a;
                switch(flowKt__MergeKt$flattenConcat$1$1$emit$10.label) {
                    case 0: {
                        d5.n.D(object0);
                        flowKt__MergeKt$flattenConcat$1$1$emit$10.label = 1;
                        return FlowKt.emitAll(this.$this_flow, flow0, flowKt__MergeKt$flattenConcat$1$1$emit$10) == a0 ? a0 : H.a;
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

    @NotNull
    public static final Flow mapLatest(@NotNull Flow flow0, @NotNull n n0) {
        return FlowKt.transformLatest(flow0, new o(n0, null) {
            final n $transform;
            private Object L$0;
            Object L$1;
            int label;

            {
                this.$transform = n0;
                super(3, continuation0);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), object1, ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, Object object0, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__MergeKt.mapLatest.1 flowKt__MergeKt$mapLatest$10 = new kotlinx.coroutines.flow.FlowKt__MergeKt.mapLatest.1(this.$transform, continuation0);
                flowKt__MergeKt$mapLatest$10.L$0 = flowCollector0;
                flowKt__MergeKt$mapLatest$10.L$1 = object0;
                return flowKt__MergeKt$mapLatest$10.invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                FlowCollector flowCollector0;
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        flowCollector0 = (FlowCollector)this.L$0;
                        this.L$0 = flowCollector0;
                        this.label = 1;
                        object0 = this.$transform.invoke(this.L$1, this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        flowCollector0 = (FlowCollector)this.L$0;
                        d5.n.D(object0);
                        break;
                    }
                    case 2: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                this.L$0 = null;
                this.label = 2;
                return flowCollector0.emit(object0, this) == a0 ? a0 : H.a;
            }
        });
    }

    @NotNull
    public static final Flow merge(@NotNull Iterable iterable0) {
        return new ChannelLimitedFlowMerge(iterable0, null, 0, null, 14, null);
    }

    @NotNull
    public static final Flow merge(@NotNull Flow[] arr_flow) {
        return FlowKt.merge(je.n.M(arr_flow));
    }

    @NotNull
    public static final Flow transformLatest(@NotNull Flow flow0, @NotNull o o0) {
        return new ChannelFlowTransformLatest(o0, flow0, null, 0, null, 28, null);
    }
}

