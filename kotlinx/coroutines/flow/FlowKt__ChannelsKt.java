package kotlinx.coroutines.flow;

import d5.n;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A.\u0010\u0005\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006\u001A6\u0010\u000B\u001A\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001A\u00020\u0007H\u0082@¢\u0006\u0004\b\t\u0010\n\u001A#\u0010\r\u001A\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "channel", "Lie/H;", "emitAll", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "consume", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "Lkotlinx/coroutines/flow/Flow;", "receiveAsFlow", "(Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/flow/FlowKt")
abstract class FlowKt__ChannelsKt {
    @Nullable
    public static final Object emitAll(@NotNull FlowCollector flowCollector0, @NotNull ReceiveChannel receiveChannel0, @NotNull Continuation continuation0) {
        Object object0 = FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(flowCollector0, receiveChannel0, true, continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    private static final Object emitAllImpl$FlowKt__ChannelsKt(FlowCollector flowCollector0, ReceiveChannel receiveChannel0, boolean z, Continuation continuation0) {
        FlowCollector flowCollector1;
        ChannelIterator channelIterator1;
        ChannelIterator channelIterator0;
        kotlinx.coroutines.flow.FlowKt__ChannelsKt.emitAllImpl.1 flowKt__ChannelsKt$emitAllImpl$10;
        if(continuation0 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt.emitAllImpl.1) {
            flowKt__ChannelsKt$emitAllImpl$10 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt.emitAllImpl.1)continuation0;
            int v = flowKt__ChannelsKt$emitAllImpl$10.label;
            if((v & 0x80000000) == 0) {
                flowKt__ChannelsKt$emitAllImpl$10 = new c(continuation0) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    boolean Z$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(null, null, false, this);
                    }
                };
            }
            else {
                flowKt__ChannelsKt$emitAllImpl$10.label = v ^ 0x80000000;
            }
        }
        else {
            flowKt__ChannelsKt$emitAllImpl$10 = new c(continuation0) {
                Object L$0;
                Object L$1;
                Object L$2;
                boolean Z$0;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return FlowKt__ChannelsKt.emitAllImpl$FlowKt__ChannelsKt(null, null, false, this);
                }
            };
        }
        Object object0 = flowKt__ChannelsKt$emitAllImpl$10.result;
        a a0 = a.a;
        switch(flowKt__ChannelsKt$emitAllImpl$10.label) {
            case 0: {
                n.D(object0);
                FlowKt.ensureActive(flowCollector0);
                try {
                    channelIterator0 = receiveChannel0.iterator();
                    goto label_30;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 1: {
                z = flowKt__ChannelsKt$emitAllImpl$10.Z$0;
                channelIterator1 = (ChannelIterator)flowKt__ChannelsKt$emitAllImpl$10.L$2;
                receiveChannel0 = (ReceiveChannel)flowKt__ChannelsKt$emitAllImpl$10.L$1;
                flowCollector1 = (FlowCollector)flowKt__ChannelsKt$emitAllImpl$10.L$0;
                try {
                    n.D(object0);
                    goto label_40;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 2: {
                z = flowKt__ChannelsKt$emitAllImpl$10.Z$0;
                channelIterator1 = (ChannelIterator)flowKt__ChannelsKt$emitAllImpl$10.L$2;
                receiveChannel0 = (ReceiveChannel)flowKt__ChannelsKt$emitAllImpl$10.L$1;
                flowCollector1 = (FlowCollector)flowKt__ChannelsKt$emitAllImpl$10.L$0;
                try {
                    n.D(object0);
                    while(true) {
                        channelIterator0 = channelIterator1;
                        flowCollector0 = flowCollector1;
                    label_30:
                        flowKt__ChannelsKt$emitAllImpl$10.L$0 = flowCollector0;
                        flowKt__ChannelsKt$emitAllImpl$10.L$1 = receiveChannel0;
                        flowKt__ChannelsKt$emitAllImpl$10.L$2 = channelIterator0;
                        flowKt__ChannelsKt$emitAllImpl$10.Z$0 = z;
                        flowKt__ChannelsKt$emitAllImpl$10.label = 1;
                        Object object1 = channelIterator0.hasNext(flowKt__ChannelsKt$emitAllImpl$10);
                        if(object1 != a0) {
                            flowCollector1 = flowCollector0;
                            channelIterator1 = channelIterator0;
                            object0 = object1;
                        label_40:
                            if(!((Boolean)object0).booleanValue()) {
                                goto label_53;
                            }
                            Object object2 = channelIterator1.next();
                            flowKt__ChannelsKt$emitAllImpl$10.L$0 = flowCollector1;
                            flowKt__ChannelsKt$emitAllImpl$10.L$1 = receiveChannel0;
                            flowKt__ChannelsKt$emitAllImpl$10.L$2 = channelIterator1;
                            flowKt__ChannelsKt$emitAllImpl$10.Z$0 = z;
                            flowKt__ChannelsKt$emitAllImpl$10.label = 2;
                            if(flowCollector1.emit(object2, flowKt__ChannelsKt$emitAllImpl$10) != a0) {
                                continue;
                            }
                        }
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(z) {
            ChannelsKt.cancelConsumed(receiveChannel0, throwable0);
        }
        throw throwable0;
    label_53:
        if(z) {
            ChannelsKt.cancelConsumed(receiveChannel0, null);
        }
        return H.a;
    }

    @NotNull
    public static final Flow receiveAsFlow(@NotNull ReceiveChannel receiveChannel0) {
        return new ChannelAsFlow(receiveChannel0, false, null, 0, null, 28, null);
    }
}

