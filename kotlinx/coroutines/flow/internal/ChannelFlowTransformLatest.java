package kotlinx.coroutines.flow.internal;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import me.i;
import me.j;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;
import we.o;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003Bc\u0012.\u0010\t\u001A*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004\u0012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00028\u00000\n\u0012\b\b\u0002\u0010\r\u001A\u00020\f\u0012\b\b\u0002\u0010\u000F\u001A\u00020\u000E\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00010\u00142\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u0010H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u001E\u0010\u0018\u001A\u00020\u00072\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0094@¢\u0006\u0004\b\u0018\u0010\u0019R<\u0010\t\u001A*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001A¨\u0006\u001B"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowTransformLatest;", "T", "R", "Lkotlinx/coroutines/flow/internal/ChannelFlowOperator;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "Lie/H;", "", "transform", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lme/i;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lwe/o;Lkotlinx/coroutines/flow/Flow;Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "create", "(Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "collector", "flowCollect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lwe/o;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class ChannelFlowTransformLatest extends ChannelFlowOperator {
    @NotNull
    private final o transform;

    public ChannelFlowTransformLatest(@NotNull o o0, @NotNull Flow flow0, @NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        super(flow0, i0, v, bufferOverflow0);
        this.transform = o0;
    }

    public ChannelFlowTransformLatest(o o0, Flow flow0, i i0, int v, BufferOverflow bufferOverflow0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 4) != 0) {
            i0 = j.a;
        }
        if((v1 & 8) != 0) {
            v = -2;
        }
        if((v1 & 16) != 0) {
            bufferOverflow0 = BufferOverflow.SUSPEND;
        }
        this(o0, flow0, i0, v, bufferOverflow0);
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public ChannelFlow create(@NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        return new ChannelFlowTransformLatest(this.transform, this.flow, i0, v, bufferOverflow0);
    }

    @Override  // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    @Nullable
    public Object flowCollect(@NotNull FlowCollector flowCollector0, @NotNull Continuation continuation0) {
        Object object0 = CoroutineScopeKt.coroutineScope(new n(flowCollector0, null) {
            final FlowCollector $collector;
            private Object L$0;
            int label;

            {
                ChannelFlowTransformLatest.this = channelFlowTransformLatest0;
                this.$collector = flowCollector0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest.flowCollect.3(ChannelFlowTransformLatest.this, this.$collector, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest.flowCollect.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest.flowCollect.3.1 channelFlowTransformLatest$flowCollect$3$10 = new FlowCollector() {
                            @Override  // kotlinx.coroutines.flow.FlowCollector
                            public final Object emit(Object object0, Continuation continuation0) {
                                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest.flowCollect.3.1 channelFlowTransformLatest$flowCollect$3$10;
                                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest.flowCollect.3.1.emit.1 channelFlowTransformLatest$flowCollect$3$1$emit$10;
                                if(continuation0 instanceof kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest.flowCollect.3.1.emit.1) {
                                    channelFlowTransformLatest$flowCollect$3$1$emit$10 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest.flowCollect.3.1.emit.1)continuation0;
                                    int v = channelFlowTransformLatest$flowCollect$3$1$emit$10.label;
                                    if((v & 0x80000000) == 0) {
                                        channelFlowTransformLatest$flowCollect$3$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                            Object L$0;
                                            Object L$1;
                                            Object L$2;
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
                                        channelFlowTransformLatest$flowCollect$3$1$emit$10.label = v ^ 0x80000000;
                                    }
                                }
                                else {
                                    channelFlowTransformLatest$flowCollect$3$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                        Object L$0;
                                        Object L$1;
                                        Object L$2;
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
                                Object object1 = channelFlowTransformLatest$flowCollect$3$1$emit$10.result;
                                a a0 = a.a;
                                switch(channelFlowTransformLatest$flowCollect$3$1$emit$10.label) {
                                    case 0: {
                                        d5.n.D(object1);
                                        Job job0 = (Job)coroutineScope0.a;
                                        if(job0 != null) {
                                            job0.cancel(new ChildCancelledException());
                                            channelFlowTransformLatest$flowCollect$3$1$emit$10.L$0 = this;
                                            channelFlowTransformLatest$flowCollect$3$1$emit$10.L$1 = object0;
                                            channelFlowTransformLatest$flowCollect$3$1$emit$10.L$2 = job0;
                                            channelFlowTransformLatest$flowCollect$3$1$emit$10.label = 1;
                                            if(job0.join(channelFlowTransformLatest$flowCollect$3$1$emit$10) == a0) {
                                                return a0;
                                            }
                                        }
                                        channelFlowTransformLatest$flowCollect$3$10 = this;
                                        break;
                                    }
                                    case 1: {
                                        Job job1 = (Job)channelFlowTransformLatest$flowCollect$3$1$emit$10.L$2;
                                        object0 = channelFlowTransformLatest$flowCollect$3$1$emit$10.L$1;
                                        channelFlowTransformLatest$flowCollect$3$10 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest.flowCollect.3.1)channelFlowTransformLatest$flowCollect$3$1$emit$10.L$0;
                                        d5.n.D(object1);
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest.flowCollect.3.1.2 channelFlowTransformLatest$flowCollect$3$1$20 = new n(channelFlowTransformLatest$flowCollect$3$10.$collector, object0, null) {
                                    final FlowCollector $collector;
                                    final Object $value;
                                    int label;

                                    {
                                        ChannelFlowTransformLatest.this = channelFlowTransformLatest0;
                                        this.$collector = flowCollector0;
                                        this.$value = object0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest.flowCollect.3.1.2(ChannelFlowTransformLatest.this, this.$collector, this.$value, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest.flowCollect.3.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        a a0 = a.a;
                                        switch(this.label) {
                                            case 0: {
                                                d5.n.D(object0);
                                                this.label = 1;
                                                return ChannelFlowTransformLatest.this.transform.invoke(this.$collector, this.$value, this) == a0 ? a0 : H.a;
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
                                };
                                channelFlowTransformLatest$flowCollect$3$10.$previousFlow.a = BuildersKt__Builders_commonKt.launch$default(channelFlowTransformLatest$flowCollect$3$10.$$this$coroutineScope, null, CoroutineStart.UNDISPATCHED, channelFlowTransformLatest$flowCollect$3$1$20, 1, null);
                                return H.a;
                            }
                        };
                        this.label = 1;
                        return ChannelFlowTransformLatest.this.flow.collect(channelFlowTransformLatest$flowCollect$3$10, this) == a0 ? a0 : H.a;
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
        }, continuation0);
        return object0 == a.a ? object0 : H.a;
    }
}

