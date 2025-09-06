package kotlinx.coroutines.flow.internal;

import ie.H;
import java.util.concurrent.atomic.AtomicInteger;
import je.A;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel.DefaultImpls;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;
import we.n;
import we.o;

@Metadata(d1 = {"\u00004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u008A\u0001\u0010\r\u001A\u00020\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\u0010\u0005\u001A\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00032\u0016\u0010\u0007\u001A\u0012\u0012\u000E\u0012\f\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0018\u00010\u00030\u000624\u0010\f\u001A0\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\bH\u0081@¢\u0006\u0004\b\r\u0010\u000E*\u001C\b\u0002\u0010\u0010\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u000F2\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u000F¨\u0006\u0011"}, d2 = {"R", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlinx/coroutines/flow/Flow;", "flows", "Lkotlin/Function0;", "arrayFactory", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "Lie/H;", "", "transform", "combineInternal", "(Lkotlinx/coroutines/flow/FlowCollector;[Lkotlinx/coroutines/flow/Flow;Lwe/a;Lwe/o;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lje/A;", "Update", "kotlinx-coroutines-core"}, k = 2, mv = {2, 1, 0}, xi = 0x30)
public abstract class CombineKt {
    @Nullable
    public static final Object combineInternal(@NotNull FlowCollector flowCollector0, @NotNull Flow[] arr_flow, @NotNull a a0, @NotNull o o0, @NotNull Continuation continuation0) {
        Object object0 = FlowCoroutineKt.flowScope(new n(arr_flow, a0, o0, flowCollector0, null) {
            final a $arrayFactory;
            final Flow[] $flows;
            final FlowCollector $this_combineInternal;
            final o $transform;
            int I$0;
            int I$1;
            private Object L$0;
            Object L$1;
            Object L$2;
            int label;

            {
                this.$flows = arr_flow;
                this.$arrayFactory = a0;
                this.$transform = o0;
                this.$this_combineInternal = flowCollector0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new kotlinx.coroutines.flow.internal.CombineKt.combineInternal.2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((kotlinx.coroutines.flow.internal.CombineKt.combineInternal.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                Object object1;
                Channel channel2;
                byte[] arr_b1;
                int v4;
                int v3;
                Channel channel1;
                int v2;
                byte[] arr_b;
                Object[] arr_object;
                int v;
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                        v = this.$flows.length;
                        if(v == 0) {
                            return H.a;
                        }
                        arr_object = new Object[v];
                        je.n.c0(0, v, NullSurrogateKt.UNINITIALIZED, arr_object);
                        Channel channel0 = ChannelKt.Channel$default(v, null, null, 6, null);
                        AtomicInteger atomicInteger0 = new AtomicInteger(v);
                        for(int v1 = 0; v1 < v; ++v1) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(v1, atomicInteger0, channel0, null) {
                                final Flow[] $flows;
                                final int $i;
                                final AtomicInteger $nonClosed;
                                final Channel $resultChannel;
                                int label;

                                {
                                    this.$flows = arr_flow;
                                    this.$i = v;
                                    this.$nonClosed = atomicInteger0;
                                    this.$resultChannel = channel0;
                                    super(2, continuation0);
                                }

                                @Override  // oe.a
                                public final Continuation create(Object object0, Continuation continuation0) {
                                    return new kotlinx.coroutines.flow.internal.CombineKt.combineInternal.2.1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, continuation0);
                                }

                                @Override  // we.n
                                public Object invoke(Object object0, Object object1) {
                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                }

                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                    return ((kotlinx.coroutines.flow.internal.CombineKt.combineInternal.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                }

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    ne.a a0 = ne.a.a;
                                    switch(this.label) {
                                        case 0: {
                                            d5.n.D(object0);
                                            try {
                                                Flow flow0 = this.$flows[this.$i];
                                                kotlinx.coroutines.flow.internal.CombineKt.combineInternal.2.1.1 combineKt$combineInternal$2$1$10 = new FlowCollector() {
                                                    @Override  // kotlinx.coroutines.flow.FlowCollector
                                                    public final Object emit(Object object0, Continuation continuation0) {
                                                        kotlinx.coroutines.flow.internal.CombineKt.combineInternal.2.1.1.emit.1 combineKt$combineInternal$2$1$1$emit$10;
                                                        if(continuation0 instanceof kotlinx.coroutines.flow.internal.CombineKt.combineInternal.2.1.1.emit.1) {
                                                            combineKt$combineInternal$2$1$1$emit$10 = (kotlinx.coroutines.flow.internal.CombineKt.combineInternal.2.1.1.emit.1)continuation0;
                                                            int v = combineKt$combineInternal$2$1$1$emit$10.label;
                                                            if((v & 0x80000000) == 0) {
                                                                combineKt$combineInternal$2$1$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                                                combineKt$combineInternal$2$1$1$emit$10.label = v ^ 0x80000000;
                                                            }
                                                        }
                                                        else {
                                                            combineKt$combineInternal$2$1$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                                        Object object1 = combineKt$combineInternal$2$1$1$emit$10.result;
                                                        ne.a a0 = ne.a.a;
                                                        switch(combineKt$combineInternal$2$1$1$emit$10.label) {
                                                            case 0: {
                                                                d5.n.D(object1);
                                                                A a1 = new A(this.$i, object0);
                                                                combineKt$combineInternal$2$1$1$emit$10.label = 1;
                                                                if(this.$i.send(a1, combineKt$combineInternal$2$1$1$emit$10) == a0) {
                                                                    return a0;
                                                                }
                                                                break;
                                                            }
                                                            case 1: {
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
                                                        combineKt$combineInternal$2$1$1$emit$10.label = 2;
                                                        return YieldKt.yield(combineKt$combineInternal$2$1$1$emit$10) == a0 ? a0 : H.a;
                                                    }
                                                };
                                                this.label = 1;
                                                if(flow0.collect(combineKt$combineInternal$2$1$10, this) == a0) {
                                                    return a0;
                                                label_9:
                                                    d5.n.D(object0);
                                                }
                                                break;
                                            }
                                            catch(Throwable throwable0) {
                                                goto label_12;
                                            }
                                        }
                                        case 1: {
                                            goto label_9;
                                        label_12:
                                            if(this.$nonClosed.decrementAndGet() == 0) {
                                                DefaultImpls.close$default(this.$resultChannel, null, 1, null);
                                            }
                                            throw throwable0;
                                        }
                                        default: {
                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                        }
                                    }
                                    if(this.$nonClosed.decrementAndGet() == 0) {
                                        DefaultImpls.close$default(this.$resultChannel, null, 1, null);
                                    }
                                    return H.a;
                                }
                            }, 3, null);
                        }
                        arr_b = new byte[v];
                        v2 = 0;
                        channel1 = channel0;
                        break;
                    }
                    case 1: {
                        v3 = this.I$1;
                        v4 = this.I$0;
                        arr_b1 = (byte[])this.L$2;
                        channel2 = (Channel)this.L$1;
                        Object[] arr_object1 = (Object[])this.L$0;
                        d5.n.D(object0);
                        object1 = ((ChannelResult)object0).unbox-impl();
                        arr_object = arr_object1;
                        goto label_52;
                    }
                    case 2: 
                    case 3: {
                        int v5 = this.I$1;
                        int v6 = this.I$0;
                        byte[] arr_b2 = (byte[])this.L$2;
                        Channel channel3 = (Channel)this.L$1;
                        Object[] arr_object2 = (Object[])this.L$0;
                        d5.n.D(object0);
                        v2 = v5;
                        v = v6;
                        arr_b = arr_b2;
                        channel1 = channel3;
                        arr_object = arr_object2;
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                while(true) {
                    this.L$0 = arr_object;
                    this.L$1 = channel1;
                    this.L$2 = arr_b;
                    this.I$0 = v;
                    this.I$1 = (byte)(v2 + 1);
                    this.label = 1;
                    object1 = channel1.receiveCatching-JP2dKIU(this);
                    if(object1 == a0) {
                        break;
                    }
                    v4 = v;
                    v3 = (byte)(v2 + 1);
                    channel2 = channel1;
                    arr_b1 = arr_b;
                label_52:
                    A a1 = (A)ChannelResult.getOrNull-impl(object1);
                    if(a1 == null) {
                        return H.a;
                    }
                    while(true) {
                        int v7 = a1.a;
                        Object object2 = arr_object[v7];
                        arr_object[v7] = a1.b;
                        if(object2 == NullSurrogateKt.UNINITIALIZED) {
                            --v4;
                        }
                        if(arr_b1[v7] == v3) {
                            break;
                        }
                        arr_b1[v7] = (byte)v3;
                        A a2 = (A)ChannelResult.getOrNull-impl(channel2.tryReceive-PtdJZtk());
                        if(a2 == null) {
                            break;
                        }
                        a1 = a2;
                    }
                    if(v4 == 0) {
                        Object[] arr_object3 = (Object[])this.$arrayFactory.invoke();
                        if(arr_object3 == null) {
                            this.L$0 = arr_object;
                            this.L$1 = channel2;
                            this.L$2 = arr_b1;
                            this.I$0 = 0;
                            this.I$1 = v3;
                            this.label = 2;
                            if(this.$transform.invoke(this.$this_combineInternal, arr_object, this) == a0) {
                                return a0;
                            }
                        }
                        else {
                            je.n.Y(arr_object, 0, arr_object3, 0, 14);
                            this.L$0 = arr_object;
                            this.L$1 = channel2;
                            this.L$2 = arr_b1;
                            this.I$0 = 0;
                            this.I$1 = v3;
                            this.label = 3;
                            if(this.$transform.invoke(this.$this_combineInternal, arr_object3, this) != a0) {
                                goto label_85;
                            }
                            break;
                        }
                    }
                label_85:
                    v2 = v3;
                    v = v4;
                    arr_b = arr_b1;
                    channel1 = channel2;
                }
                return a0;
            }
        }, continuation0);
        return object0 == ne.a.a ? object0 : H.a;
    }
}

