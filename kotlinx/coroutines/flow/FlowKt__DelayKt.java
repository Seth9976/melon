package kotlinx.coroutines.flow;

import d5.n;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.G;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ChannelResult.Failed;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.internal.ChildCancelledException;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectImplementation;
import oe.c;
import org.jetbrains.annotations.NotNull;
import we.k;
import we.o;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A-\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001A9\u0010\u0004\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0003\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0006H\u0007¢\u0006\u0004\b\u0004\u0010\u0007\u001A9\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0007\u001A-\u0010\f\u001A\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u000B\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\f\u0010\u0005\u001A!\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00100\u000F*\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0002H\u0000¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "", "timeoutMillis", "debounce", "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function1;", "(Lkotlinx/coroutines/flow/Flow;Lwe/k;)Lkotlinx/coroutines/flow/Flow;", "timeoutMillisSelector", "debounceInternal$FlowKt__DelayKt", "debounceInternal", "periodMillis", "sample", "Lkotlinx/coroutines/CoroutineScope;", "delayMillis", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lie/H;", "fixedPeriodTicker", "(Lkotlinx/coroutines/CoroutineScope;J)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/flow/FlowKt")
abstract class FlowKt__DelayKt {
    public static long a(long v, Object object0) {
        return v;
    }

    @NotNull
    public static final Flow debounce(@NotNull Flow flow0, long v) {
        int v1 = Long.compare(v, 0L);
        if(v1 < 0) {
            throw new IllegalArgumentException("Debounce timeout should not be negative");
        }
        return v1 == 0 ? flow0 : FlowKt__DelayKt.debounceInternal$FlowKt__DelayKt(flow0, new a(v));
    }

    @NotNull
    public static final Flow debounce(@NotNull Flow flow0, @NotNull k k0) {
        return FlowKt__DelayKt.debounceInternal$FlowKt__DelayKt(flow0, k0);
    }

    private static final long debounce$lambda$1$FlowKt__DelayKt(long v, Object object0) [...] // Inlined contents

    private static final Flow debounceInternal$FlowKt__DelayKt(Flow flow0, k k0) {
        return FlowCoroutineKt.scopedFlow(new o(k0, flow0, null) {
            final Flow $this_debounceInternal;
            final k $timeoutMillisSelector;
            private Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;

            {
                this.$timeoutMillisSelector = k0;
                this.$this_debounceInternal = flow0;
                super(3, continuation0);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((CoroutineScope)object0), ((FlowCollector)object1), ((Continuation)object2));
            }

            public final Object invoke(CoroutineScope coroutineScope0, FlowCollector flowCollector0, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1 flowKt__DelayKt$debounceInternal$10 = new kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1(this.$timeoutMillisSelector, this.$this_debounceInternal, continuation0);
                flowKt__DelayKt$debounceInternal$10.L$0 = coroutineScope0;
                flowKt__DelayKt$debounceInternal$10.L$1 = flowCollector0;
                return flowKt__DelayKt$debounceInternal$10.invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                FlowCollector flowCollector2;
                ReceiveChannel receiveChannel2;
                kotlin.jvm.internal.H h1;
                G g0;
                ReceiveChannel receiveChannel1;
                FlowCollector flowCollector1;
                kotlin.jvm.internal.H h0;
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                        FlowCollector flowCollector0 = (FlowCollector)this.L$1;
                        ReceiveChannel receiveChannel0 = ProduceKt.produce$default(coroutineScope0, null, 0, new we.n(null) {
                            final Flow $this_debounceInternal;
                            private Object L$0;
                            int label;

                            {
                                this.$this_debounceInternal = flow0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.values.1(this.$this_debounceInternal, continuation0);
                                continuation1.L$0 = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((ProducerScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
                                return ((kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.values.1)this.create(producerScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        n.D(object0);
                                        kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.values.1.1 flowKt__DelayKt$debounceInternal$1$values$1$10 = new FlowCollector() {
                                            @Override  // kotlinx.coroutines.flow.FlowCollector
                                            public final Object emit(Object object0, Continuation continuation0) {
                                                kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.values.1.1.emit.1 flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10;
                                                if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.values.1.1.emit.1) {
                                                    flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10 = (kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.values.1.1.emit.1)continuation0;
                                                    int v = flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10.label;
                                                    if((v & 0x80000000) == 0) {
                                                        flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                                        flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10.label = v ^ 0x80000000;
                                                    }
                                                }
                                                else {
                                                    flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                                Object object1 = flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10.result;
                                                ne.a a0 = ne.a.a;
                                                switch(flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10.label) {
                                                    case 0: {
                                                        n.D(object1);
                                                        ProducerScope producerScope0 = this.$$this$produce;
                                                        if(object0 == null) {
                                                            object0 = NullSurrogateKt.NULL;
                                                        }
                                                        flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10.label = 1;
                                                        return producerScope0.send(object0, flowKt__DelayKt$debounceInternal$1$values$1$1$emit$10) == a0 ? a0 : H.a;
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
                                        this.label = 1;
                                        return this.$this_debounceInternal.collect(flowKt__DelayKt$debounceInternal$1$values$1$10, this) == a0 ? a0 : H.a;
                                    }
                                    case 1: {
                                        n.D(object0);
                                        return H.a;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        }, 3, null);
                        h0 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                        flowCollector1 = flowCollector0;
                        receiveChannel1 = receiveChannel0;
                        goto label_25;
                    }
                    case 1: {
                        g0 = (G)this.L$3;
                        h0 = (kotlin.jvm.internal.H)this.L$2;
                        receiveChannel1 = (ReceiveChannel)this.L$1;
                        flowCollector1 = (FlowCollector)this.L$0;
                        n.D(object0);
                        h0.a = null;
                        goto label_47;
                    }
                    case 2: {
                        h1 = (kotlin.jvm.internal.H)this.L$2;
                        receiveChannel2 = (ReceiveChannel)this.L$1;
                        flowCollector2 = (FlowCollector)this.L$0;
                        n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                while(true) {
                    flowCollector1 = flowCollector2;
                    receiveChannel1 = receiveChannel2;
                    h0 = h1;
                label_25:
                    Object object1 = h0.a;
                    if(object1 == NullSurrogateKt.DONE) {
                        break;
                    }
                    g0 = new G();  // 初始化器: Ljava/lang/Object;-><init>()V
                    if(object1 != null) {
                        k k0 = this.$timeoutMillisSelector;
                        Symbol symbol0 = NullSurrogateKt.NULL;
                        if(object1 == symbol0) {
                            object1 = null;
                        }
                        long v = ((Number)k0.invoke(object1)).longValue();
                        g0.a = v;
                        int v1 = Long.compare(v, 0L);
                        if(v1 < 0) {
                            throw new IllegalArgumentException("Debounce timeout should not be negative");
                        }
                        if(v1 == 0) {
                            this.L$0 = flowCollector1;
                            this.L$1 = receiveChannel1;
                            this.L$2 = h0;
                            this.L$3 = g0;
                            this.label = 1;
                            if(flowCollector1.emit((h0.a == symbol0 ? null : h0.a), this) == a0) {
                                return a0;
                            }
                            h0.a = null;
                        }
                    }
                label_47:
                    h1 = h0;
                    receiveChannel2 = receiveChannel1;
                    flowCollector2 = flowCollector1;
                    SelectImplementation selectImplementation0 = new SelectImplementation(this.getContext());
                    if(h1.a != null) {
                        OnTimeoutKt.onTimeout(selectImplementation0, g0.a, new k(h1, null) {
                            final FlowCollector $downstream;
                            final kotlin.jvm.internal.H $lastValue;
                            int label;

                            {
                                this.$downstream = flowCollector0;
                                this.$lastValue = h0;
                                super(1, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Continuation continuation0) {
                                return new kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.3.1(this.$downstream, this.$lastValue, continuation0);
                            }

                            @Override  // we.k
                            public Object invoke(Object object0) {
                                return this.invoke(((Continuation)object0));
                            }

                            public final Object invoke(Continuation continuation0) {
                                return ((kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.3.1)this.create(continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        n.D(object0);
                                        this.label = 1;
                                        if(this.$downstream.emit((this.$lastValue.a == NullSurrogateKt.NULL ? null : this.$lastValue.a), this) == a0) {
                                            return a0;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        n.D(object0);
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                this.$lastValue.a = null;
                                return H.a;
                            }
                        });
                    }
                    selectImplementation0.invoke(receiveChannel2.getOnReceiveCatching(), new we.n(flowCollector2, null) {
                        final FlowCollector $downstream;
                        final kotlin.jvm.internal.H $lastValue;
                        Object L$0;
                        Object L$1;
                        int label;

                        {
                            this.$lastValue = h0;
                            this.$downstream = flowCollector0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            Continuation continuation1 = new kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.3.2(this.$lastValue, this.$downstream, continuation0);
                            continuation1.L$0 = object0;
                            return continuation1;
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke-WpGqRn0(((ChannelResult)object0).unbox-impl(), ((Continuation)object1));
                        }

                        public final Object invoke-WpGqRn0(Object object0, Continuation continuation0) {
                            return ((kotlinx.coroutines.flow.FlowKt__DelayKt.debounceInternal.1.3.2)this.create(ChannelResult.box-impl(object0), continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            kotlin.jvm.internal.H h0;
                            ne.a a0 = ne.a.a;
                            switch(this.label) {
                                case 0: {
                                    n.D(object0);
                                    Object object1 = ((ChannelResult)this.L$0).unbox-impl();
                                    h0 = this.$lastValue;
                                    if(!(object1 instanceof Failed)) {
                                        h0.a = object1;
                                    }
                                    FlowCollector flowCollector0 = this.$downstream;
                                    if(!(object1 instanceof Failed)) {
                                        return H.a;
                                    }
                                    Throwable throwable0 = ChannelResult.exceptionOrNull-impl(object1);
                                    if(throwable0 != null) {
                                        throw throwable0;
                                    }
                                    Object object2 = h0.a;
                                    if(object2 != null) {
                                        if(object2 == NullSurrogateKt.NULL) {
                                            object2 = null;
                                        }
                                        this.L$0 = object1;
                                        this.L$1 = h0;
                                        this.label = 1;
                                        if(flowCollector0.emit(object2, this) == a0) {
                                            return a0;
                                        }
                                    }
                                    break;
                                }
                                case 1: {
                                    kotlin.jvm.internal.H h1 = (kotlin.jvm.internal.H)this.L$1;
                                    n.D(object0);
                                    h0 = h1;
                                    break;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                            h0.a = NullSurrogateKt.DONE;
                            return H.a;
                        }
                    });
                    this.L$0 = flowCollector2;
                    this.L$1 = receiveChannel2;
                    this.L$2 = h1;
                    this.L$3 = null;
                    this.label = 2;
                    if(selectImplementation0.doSelect(this) != a0) {
                        continue;
                    }
                    return a0;
                }
                return H.a;
            }
        });
    }

    @NotNull
    public static final ReceiveChannel fixedPeriodTicker(@NotNull CoroutineScope coroutineScope0, long v) {
        return ProduceKt.produce$default(coroutineScope0, null, 0, new we.n(v, null) {
            final long $delayMillis;
            private Object L$0;
            int label;

            {
                this.$delayMillis = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new kotlinx.coroutines.flow.FlowKt__DelayKt.fixedPeriodTicker.1(this.$delayMillis, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((ProducerScope)object0), ((Continuation)object1));
            }

            public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
                return ((kotlinx.coroutines.flow.FlowKt__DelayKt.fixedPeriodTicker.1)this.create(producerScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ProducerScope producerScope0;
                ne.a a0 = ne.a.a;
            alab1:
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        producerScope0 = (ProducerScope)this.L$0;
                        this.L$0 = producerScope0;
                        this.label = 1;
                        if(DelayKt.delay(this.$delayMillis, this) != a0) {
                            goto label_17;
                        }
                        break;
                    }
                    case 2: {
                        producerScope0 = (ProducerScope)this.L$0;
                        n.D(object0);
                        while(true) {
                            this.L$0 = producerScope0;
                            this.label = 3;
                            if(DelayKt.delay(this.$delayMillis, this) == a0) {
                                break alab1;
                            }
                        label_17:
                            SendChannel sendChannel0 = producerScope0.getChannel();
                            this.L$0 = producerScope0;
                            this.label = 2;
                            if(sendChannel0.send(H.a, this) != a0) {
                                continue;
                            }
                            break alab1;
                        }
                    }
                    case 1: 
                    case 3: {
                        producerScope0 = (ProducerScope)this.L$0;
                        n.D(object0);
                        goto label_17;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return a0;
            }
        }, 1, null);
    }

    @NotNull
    public static final Flow sample(@NotNull Flow flow0, long v) {
        if(v <= 0L) {
            throw new IllegalArgumentException("Sample period should be positive");
        }
        return FlowCoroutineKt.scopedFlow(new o(v, flow0, null) {
            final long $periodMillis;
            final Flow $this_sample;
            private Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;

            {
                this.$periodMillis = v;
                this.$this_sample = flow0;
                super(3, continuation0);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((CoroutineScope)object0), ((FlowCollector)object1), ((Continuation)object2));
            }

            public final Object invoke(CoroutineScope coroutineScope0, FlowCollector flowCollector0, Continuation continuation0) {
                kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2 flowKt__DelayKt$sample$20 = new kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2(this.$periodMillis, this.$this_sample, continuation0);
                flowKt__DelayKt$sample$20.L$0 = coroutineScope0;
                flowKt__DelayKt$sample$20.L$1 = flowCollector0;
                return flowKt__DelayKt$sample$20.invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                FlowCollector flowCollector1;
                kotlin.jvm.internal.H h1;
                ReceiveChannel receiveChannel2;
                ReceiveChannel receiveChannel1;
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                        FlowCollector flowCollector0 = (FlowCollector)this.L$1;
                        ReceiveChannel receiveChannel0 = ProduceKt.produce$default(coroutineScope0, null, -1, new we.n(null) {
                            final Flow $this_sample;
                            private Object L$0;
                            int label;

                            {
                                this.$this_sample = flow0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.values.1(this.$this_sample, continuation0);
                                continuation1.L$0 = object0;
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((ProducerScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(ProducerScope producerScope0, Continuation continuation0) {
                                return ((kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.values.1)this.create(producerScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        n.D(object0);
                                        kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.values.1.1 flowKt__DelayKt$sample$2$values$1$10 = new FlowCollector() {
                                            @Override  // kotlinx.coroutines.flow.FlowCollector
                                            public final Object emit(Object object0, Continuation continuation0) {
                                                kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.values.1.1.emit.1 flowKt__DelayKt$sample$2$values$1$1$emit$10;
                                                if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.values.1.1.emit.1) {
                                                    flowKt__DelayKt$sample$2$values$1$1$emit$10 = (kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.values.1.1.emit.1)continuation0;
                                                    int v = flowKt__DelayKt$sample$2$values$1$1$emit$10.label;
                                                    if((v & 0x80000000) == 0) {
                                                        flowKt__DelayKt$sample$2$values$1$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                                        flowKt__DelayKt$sample$2$values$1$1$emit$10.label = v ^ 0x80000000;
                                                    }
                                                }
                                                else {
                                                    flowKt__DelayKt$sample$2$values$1$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                                Object object1 = flowKt__DelayKt$sample$2$values$1$1$emit$10.result;
                                                ne.a a0 = ne.a.a;
                                                switch(flowKt__DelayKt$sample$2$values$1$1$emit$10.label) {
                                                    case 0: {
                                                        n.D(object1);
                                                        ProducerScope producerScope0 = this.$$this$produce;
                                                        if(object0 == null) {
                                                            object0 = NullSurrogateKt.NULL;
                                                        }
                                                        flowKt__DelayKt$sample$2$values$1$1$emit$10.label = 1;
                                                        return producerScope0.send(object0, flowKt__DelayKt$sample$2$values$1$1$emit$10) == a0 ? a0 : H.a;
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
                                        this.label = 1;
                                        return this.$this_sample.collect(flowKt__DelayKt$sample$2$values$1$10, this) == a0 ? a0 : H.a;
                                    }
                                    case 1: {
                                        n.D(object0);
                                        return H.a;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        }, 1, null);
                        kotlin.jvm.internal.H h0 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                        receiveChannel1 = receiveChannel0;
                        receiveChannel2 = FlowKt.fixedPeriodTicker(coroutineScope0, this.$periodMillis);
                        h1 = h0;
                        flowCollector1 = flowCollector0;
                        break;
                    }
                    case 1: {
                        receiveChannel2 = (ReceiveChannel)this.L$3;
                        h1 = (kotlin.jvm.internal.H)this.L$2;
                        receiveChannel1 = (ReceiveChannel)this.L$1;
                        flowCollector1 = (FlowCollector)this.L$0;
                        n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                while(h1.a != NullSurrogateKt.DONE) {
                    SelectImplementation selectImplementation0 = new SelectImplementation(this.getContext());
                    selectImplementation0.invoke(receiveChannel1.getOnReceiveCatching(), new we.n(receiveChannel2, null) {
                        final kotlin.jvm.internal.H $lastValue;
                        final ReceiveChannel $ticker;
                        Object L$0;
                        int label;

                        {
                            this.$lastValue = h0;
                            this.$ticker = receiveChannel0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            Continuation continuation1 = new kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.1.1(this.$lastValue, this.$ticker, continuation0);
                            continuation1.L$0 = object0;
                            return continuation1;
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke-WpGqRn0(((ChannelResult)object0).unbox-impl(), ((Continuation)object1));
                        }

                        public final Object invoke-WpGqRn0(Object object0, Continuation continuation0) {
                            return ((kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.1.1)this.create(ChannelResult.box-impl(object0), continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            n.D(object0);
                            Object object1 = ((ChannelResult)this.L$0).unbox-impl();
                            kotlin.jvm.internal.H h0 = this.$lastValue;
                            if(!(object1 instanceof Failed)) {
                                h0.a = object1;
                            }
                            ReceiveChannel receiveChannel0 = this.$ticker;
                            if(object1 instanceof Failed) {
                                Throwable throwable0 = ChannelResult.exceptionOrNull-impl(object1);
                                if(throwable0 != null) {
                                    throw throwable0;
                                }
                                receiveChannel0.cancel(new ChildCancelledException());
                                h0.a = NullSurrogateKt.DONE;
                                return H.a;
                            }
                            return H.a;
                        }
                    });
                    selectImplementation0.invoke(receiveChannel2.getOnReceive(), new we.n(flowCollector1, null) {
                        final FlowCollector $downstream;
                        final kotlin.jvm.internal.H $lastValue;
                        int label;

                        {
                            this.$lastValue = h0;
                            this.$downstream = flowCollector0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.1.2(this.$lastValue, this.$downstream, continuation0);
                        }

                        public final Object invoke(H h0, Continuation continuation0) {
                            return ((kotlinx.coroutines.flow.FlowKt__DelayKt.sample.2.1.2)this.create(h0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((H)object0), ((Continuation)object1));
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            ne.a a0 = ne.a.a;
                            H h0 = H.a;
                            switch(this.label) {
                                case 0: {
                                    n.D(object0);
                                    kotlin.jvm.internal.H h1 = this.$lastValue;
                                    Object object1 = h1.a;
                                    if(object1 == null) {
                                        return h0;
                                    }
                                    h1.a = null;
                                    FlowCollector flowCollector0 = this.$downstream;
                                    if(object1 == NullSurrogateKt.NULL) {
                                        object1 = null;
                                    }
                                    this.label = 1;
                                    return flowCollector0.emit(object1, this) == a0 ? a0 : h0;
                                }
                                case 1: {
                                    n.D(object0);
                                    return h0;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    });
                    this.L$0 = flowCollector1;
                    this.L$1 = receiveChannel1;
                    this.L$2 = h1;
                    this.L$3 = receiveChannel2;
                    this.label = 1;
                    if(selectImplementation0.doSelect(this) == a0) {
                        return a0;
                    }
                    if(false) {
                        break;
                    }
                }
                return H.a;
            }
        });
    }
}

