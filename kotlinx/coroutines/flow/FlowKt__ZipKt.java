package kotlinx.coroutines.flow;

import d5.n;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.internal.CombineKt;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import we.a;
import we.o;
import we.p;
import we.q;
import we.r;

@Metadata(d1 = {"\u0000>\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\u001Ai\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00010\u00032(\u0010\b\u001A$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0007\u00A2\u0006\u0004\b\t\u0010\n\u001Ak\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u00022\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00010\u00032(\u0010\b\u001A$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005\u00A2\u0006\u0004\b\u000B\u0010\n\u001A\u0087\u0001\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00030\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u00022\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00020\u000320\b\u0001\u0010\b\u001A*\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000F\u00A2\u0006\u0004\b\u000B\u0010\u0010\u001A\u009F\u0001\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00040\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0011\"\u0004\b\u0004\u0010\u00022\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00030\u000324\u0010\b\u001A0\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00040\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0013\u00A2\u0006\u0004\b\u000B\u0010\u0014\u001A\u00B9\u0001\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00050\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u0011\"\u0004\b\u0004\u0010\u0015\"\u0004\b\u0005\u0010\u00022\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00010\u00032\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00028\u00020\u00032\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00028\u00030\u00032\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00028\u00040\u00032:\u0010\b\u001A6\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00050\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0017\u00A2\u0006\u0004\b\u000B\u0010\u0018\u001A#\u0010\u001E\u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001B0\u001A\"\u0004\b\u0000\u0010\u0019H\u0002\u00A2\u0006\u0004\b\u001C\u0010\u001D\u00A8\u0006\u001F"}, d2 = {"T1", "T2", "R", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "transform", "flowCombine", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lwe/o;)Lkotlinx/coroutines/flow/Flow;", "combine", "flow2", "T3", "flow3", "Lkotlin/Function4;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lwe/p;)Lkotlinx/coroutines/flow/Flow;", "T4", "flow4", "Lkotlin/Function5;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lwe/q;)Lkotlinx/coroutines/flow/Flow;", "T5", "flow5", "Lkotlin/Function6;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lwe/r;)Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlin/Function0;", "", "nullArrayFactory$FlowKt__ZipKt", "()Lwe/a;", "nullArrayFactory", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/flow/FlowKt")
abstract class FlowKt__ZipKt {
    @NotNull
    public static final Flow combine(@NotNull Flow flow0, @NotNull Flow flow1, @NotNull Flow flow2, @NotNull Flow flow3, @NotNull Flow flow4, @NotNull r r0) {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                a a0 = FlowKt__ZipKt.nullArrayFactory$FlowKt__ZipKt();
                kotlinx.coroutines.flow.FlowKt__ZipKt.combine..inlined.combineUnsafe.FlowKt__ZipKt.3.2 flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$20 = new o(r0) {
                    final r $transform$inlined;
                    private Object L$0;
                    Object L$1;
                    int label;

                    {
                        this.$transform$inlined = r0;
                        super(3, continuation0);
                    }

                    @Override  // we.o
                    public Object invoke(Object object0, Object object1, Object object2) {
                        return this.invoke(((FlowCollector)object0), ((Object[])object1), ((Continuation)object2));
                    }

                    public final Object invoke(FlowCollector flowCollector0, Object[] arr_object, Continuation continuation0) {
                        kotlinx.coroutines.flow.FlowKt__ZipKt.combine..inlined.combineUnsafe.FlowKt__ZipKt.3.2 flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$20 = new kotlinx.coroutines.flow.FlowKt__ZipKt.combine..inlined.combineUnsafe.FlowKt__ZipKt.3.2(continuation0, this.$transform$inlined);
                        flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$20.L$0 = flowCollector0;
                        flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$20.L$1 = arr_object;
                        return flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$20.invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        FlowCollector flowCollector0;
                        ne.a a0 = ne.a.a;
                        switch(this.label) {
                            case 0: {
                                n.D(object0);
                                flowCollector0 = (FlowCollector)this.L$0;
                                Object[] arr_object = (Object[])this.L$1;
                                this.L$0 = flowCollector0;
                                this.label = 1;
                                object0 = this.$transform$inlined.c(arr_object[0], arr_object[1], arr_object[2], arr_object[3], arr_object[4], this);
                                if(object0 == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 1: {
                                flowCollector0 = (FlowCollector)this.L$0;
                                n.D(object0);
                                break;
                            }
                            case 2: {
                                n.D(object0);
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
                };
                Object object0 = CombineKt.combineInternal(flowCollector0, new Flow[]{flow0, flow1, flow2, flow3, flow4}, a0, flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$20, continuation0);
                return object0 == ne.a.a ? object0 : H.a;
            }
        };
    }

    @NotNull
    public static final Flow combine(@NotNull Flow flow0, @NotNull Flow flow1, @NotNull Flow flow2, @NotNull Flow flow3, @NotNull q q0) {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                a a0 = FlowKt__ZipKt.nullArrayFactory$FlowKt__ZipKt();
                kotlinx.coroutines.flow.FlowKt__ZipKt.combine..inlined.combineUnsafe.FlowKt__ZipKt.2.2 flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$20 = new o(q0) {
                    final q $transform$inlined;
                    private Object L$0;
                    Object L$1;
                    int label;

                    {
                        this.$transform$inlined = q0;
                        super(3, continuation0);
                    }

                    @Override  // we.o
                    public Object invoke(Object object0, Object object1, Object object2) {
                        return this.invoke(((FlowCollector)object0), ((Object[])object1), ((Continuation)object2));
                    }

                    public final Object invoke(FlowCollector flowCollector0, Object[] arr_object, Continuation continuation0) {
                        kotlinx.coroutines.flow.FlowKt__ZipKt.combine..inlined.combineUnsafe.FlowKt__ZipKt.2.2 flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$20 = new kotlinx.coroutines.flow.FlowKt__ZipKt.combine..inlined.combineUnsafe.FlowKt__ZipKt.2.2(continuation0, this.$transform$inlined);
                        flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$20.L$0 = flowCollector0;
                        flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$20.L$1 = arr_object;
                        return flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$20.invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        FlowCollector flowCollector0;
                        ne.a a0 = ne.a.a;
                        switch(this.label) {
                            case 0: {
                                n.D(object0);
                                flowCollector0 = (FlowCollector)this.L$0;
                                Object[] arr_object = (Object[])this.L$1;
                                this.L$0 = flowCollector0;
                                this.label = 1;
                                object0 = this.$transform$inlined.invoke(arr_object[0], arr_object[1], arr_object[2], arr_object[3], this);
                                if(object0 == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 1: {
                                flowCollector0 = (FlowCollector)this.L$0;
                                n.D(object0);
                                break;
                            }
                            case 2: {
                                n.D(object0);
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
                };
                Object object0 = CombineKt.combineInternal(flowCollector0, new Flow[]{flow0, flow1, flow2, flow3}, a0, flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$20, continuation0);
                return object0 == ne.a.a ? object0 : H.a;
            }
        };
    }

    @NotNull
    public static final Flow combine(@NotNull Flow flow0, @NotNull Flow flow1, @NotNull Flow flow2, @NotNull p p0) {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                a a0 = FlowKt__ZipKt.nullArrayFactory$FlowKt__ZipKt();
                kotlinx.coroutines.flow.FlowKt__ZipKt.combine..inlined.combineUnsafe.FlowKt__ZipKt.1.2 flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$20 = new o(p0) {
                    final p $transform$inlined;
                    private Object L$0;
                    Object L$1;
                    int label;

                    {
                        this.$transform$inlined = p0;
                        super(3, continuation0);
                    }

                    @Override  // we.o
                    public Object invoke(Object object0, Object object1, Object object2) {
                        return this.invoke(((FlowCollector)object0), ((Object[])object1), ((Continuation)object2));
                    }

                    public final Object invoke(FlowCollector flowCollector0, Object[] arr_object, Continuation continuation0) {
                        kotlinx.coroutines.flow.FlowKt__ZipKt.combine..inlined.combineUnsafe.FlowKt__ZipKt.1.2 flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$20 = new kotlinx.coroutines.flow.FlowKt__ZipKt.combine..inlined.combineUnsafe.FlowKt__ZipKt.1.2(continuation0, this.$transform$inlined);
                        flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$20.L$0 = flowCollector0;
                        flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$20.L$1 = arr_object;
                        return flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$20.invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        FlowCollector flowCollector0;
                        ne.a a0 = ne.a.a;
                        switch(this.label) {
                            case 0: {
                                n.D(object0);
                                flowCollector0 = (FlowCollector)this.L$0;
                                Object[] arr_object = (Object[])this.L$1;
                                this.L$0 = flowCollector0;
                                this.label = 1;
                                object0 = this.$transform$inlined.invoke(arr_object[0], arr_object[1], arr_object[2], this);
                                if(object0 == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 1: {
                                flowCollector0 = (FlowCollector)this.L$0;
                                n.D(object0);
                                break;
                            }
                            case 2: {
                                n.D(object0);
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
                };
                Object object0 = CombineKt.combineInternal(flowCollector0, new Flow[]{flow0, flow1, flow2}, a0, flowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$20, continuation0);
                return object0 == ne.a.a ? object0 : H.a;
            }
        };
    }

    @NotNull
    public static final Flow combine(@NotNull Flow flow0, @NotNull Flow flow1, @NotNull o o0) {
        return FlowKt.flowCombine(flow0, flow1, o0);
    }

    @NotNull
    public static final Flow flowCombine(@NotNull Flow flow0, @NotNull Flow flow1, @NotNull o o0) {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                Object object0 = CombineKt.combineInternal(flowCollector0, new Flow[]{flow0, flow1}, FlowKt__ZipKt.nullArrayFactory$FlowKt__ZipKt(), new kotlinx.coroutines.flow.FlowKt__ZipKt.combine.1.1(o0, null), continuation0);
                return object0 == ne.a.a ? object0 : H.a;
            }
        };

        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001A\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000E\u0010\u0004\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"R", "Lkotlinx/coroutines/flow/FlowCollector;", "", "", "it", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/Array;)V"}, k = 3, mv = {2, 1, 0})
        @e(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", l = {29, 29}, m = "invokeSuspend")
        final class kotlinx.coroutines.flow.FlowKt__ZipKt.combine.1.1 extends i implements o {
            final o $transform;
            private Object L$0;
            Object L$1;
            int label;

            public kotlinx.coroutines.flow.FlowKt__ZipKt.combine.1.1(o o0, Continuation continuation0) {
                this.$transform = o0;
                super(3, continuation0);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), ((Object[])object1), ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, Object[] arr_object, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__ZipKt.combine.1.1 flowKt__ZipKt$combine$1$10 = new kotlinx.coroutines.flow.FlowKt__ZipKt.combine.1.1(this.$transform, continuation0);
                flowKt__ZipKt$combine$1$10.L$0 = flowCollector0;
                flowKt__ZipKt$combine$1$10.L$1 = arr_object;
                return flowKt__ZipKt$combine$1$10.invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                FlowCollector flowCollector0;
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        flowCollector0 = (FlowCollector)this.L$0;
                        Object[] arr_object = (Object[])this.L$1;
                        this.L$0 = flowCollector0;
                        this.label = 1;
                        object0 = this.$transform.invoke(arr_object[0], arr_object[1], this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        flowCollector0 = (FlowCollector)this.L$0;
                        n.D(object0);
                        break;
                    }
                    case 2: {
                        n.D(object0);
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
        }

    }

    private static final a nullArrayFactory$FlowKt__ZipKt() {
        return () -> null;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 0x30)
        final class kotlinx.coroutines.flow.FlowKt__ZipKt.nullArrayFactory.1 implements a {
            public static final kotlinx.coroutines.flow.FlowKt__ZipKt.nullArrayFactory.1 INSTANCE;

            static {
                kotlinx.coroutines.flow.FlowKt__ZipKt.nullArrayFactory.1.INSTANCE = new kotlinx.coroutines.flow.FlowKt__ZipKt.nullArrayFactory.1();
            }

            public kotlinx.coroutines.flow.FlowKt__ZipKt.nullArrayFactory.1() {
                super();
            }

            // 检测为 Lambda 实现
            @Override  // we.a
            public Object invoke() [...]

            public final Void invoke() [...] // Inlined contents
        }

    }
}

