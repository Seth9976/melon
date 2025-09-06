package kotlinx.coroutines.flow;

import d5.n;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A)\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001AG\u0010\t\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\"\u0010\b\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"", "T", "Lkotlinx/coroutines/flow/Flow;", "filterNotNull", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lie/H;", "action", "onEach", "(Lkotlinx/coroutines/flow/Flow;Lwe/n;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/flow/FlowKt")
abstract class FlowKt__TransformKt {
    @NotNull
    public static final Flow filterNotNull(@NotNull Flow flow0) {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__TransformKt.filterNotNull..inlined.unsafeTransform.1.2 flowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        kotlinx.coroutines.flow.FlowKt__TransformKt.filterNotNull..inlined.unsafeTransform.1.2.1 flowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$10;
                        if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt.filterNotNull..inlined.unsafeTransform.1.2.1) {
                            flowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$10 = (kotlinx.coroutines.flow.FlowKt__TransformKt.filterNotNull..inlined.unsafeTransform.1.2.1)continuation0;
                            int v = flowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$10.label;
                            if((v & 0x80000000) == 0) {
                                flowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                flowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$10.label = v ^ 0x80000000;
                            }
                        }
                        else {
                            flowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        Object object1 = flowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$10.result;
                        a a0 = a.a;
                        switch(flowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$10.label) {
                            case 0: {
                                n.D(object1);
                                FlowCollector flowCollector0 = this.$this_unsafeFlow;
                                if(object0 != null) {
                                    flowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$10.label = 1;
                                    if(flowCollector0.emit(object0, flowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$10) == a0) {
                                        return a0;
                                    }
                                }
                                return H.a;
                            }
                            case 1: {
                                n.D(object1);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                Object object0 = flow0.collect(flowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };
    }

    @NotNull
    public static final Flow onEach(@NotNull Flow flow0, @NotNull we.n n0) {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__TransformKt.onEach..inlined.unsafeTransform.1.2 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        FlowCollector flowCollector1;
                        Object object2;
                        kotlinx.coroutines.flow.FlowKt__TransformKt.onEach..inlined.unsafeTransform.1.2.1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$10;
                        if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt.onEach..inlined.unsafeTransform.1.2.1) {
                            flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$10 = (kotlinx.coroutines.flow.FlowKt__TransformKt.onEach..inlined.unsafeTransform.1.2.1)continuation0;
                            int v = flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$10.label;
                            if((v & 0x80000000) == 0) {
                                flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$10.label = v ^ 0x80000000;
                            }
                        }
                        else {
                            flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        Object object1 = flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$10.result;
                        a a0 = a.a;
                        switch(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$10.label) {
                            case 0: {
                                n.D(object1);
                                FlowCollector flowCollector0 = this.$action$inlined;
                                flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$10.L$0 = object0;
                                flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$10.L$1 = flowCollector0;
                                flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$10.label = 1;
                                if(this.$action$inlined.invoke(object0, flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$10) == a0) {
                                    return a0;
                                }
                                object2 = object0;
                                flowCollector1 = flowCollector0;
                                break;
                            }
                            case 1: {
                                flowCollector1 = (FlowCollector)flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$10.L$1;
                                object2 = flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$10.L$0;
                                n.D(object1);
                                break;
                            }
                            case 2: {
                                n.D(object1);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$10.L$0 = null;
                        flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$10.L$1 = null;
                        flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$10.label = 2;
                        return flowCollector1.emit(object2, flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$10) == a0 ? a0 : H.a;
                    }
                };
                Object object0 = flow0.collect(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };
    }
}

