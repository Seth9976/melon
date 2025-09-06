package kotlinx.coroutines.flow;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import me.i;
import me.j;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BO\u0012(\u0010\b\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003\u0012\b\b\u0002\u0010\n\u001A\u00020\t\u0012\b\b\u0002\u0010\f\u001A\u00020\u000B\u0012\b\b\u0002\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000F\u0010\u0010J\u001E\u0010\u0012\u001A\u00020\u00062\f\u0010\u0011\u001A\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0094@¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0015\u001A\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0014¢\u0006\u0004\b\u0015\u0010\u0016R6\u0010\b\u001A$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0017¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/flow/CallbackFlowBuilder;", "T", "Lkotlinx/coroutines/flow/ChannelFlowBuilder;", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "Lie/H;", "", "block", "Lme/i;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lwe/n;Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)V", "scope", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "create", "(Lme/i;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lwe/n;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
final class CallbackFlowBuilder extends ChannelFlowBuilder {
    @NotNull
    private final n block;

    public CallbackFlowBuilder(@NotNull n n0, @NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        super(n0, i0, v, bufferOverflow0);
        this.block = n0;
    }

    public CallbackFlowBuilder(n n0, i i0, int v, BufferOverflow bufferOverflow0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            i0 = j.a;
        }
        if((v1 & 4) != 0) {
            v = -2;
        }
        if((v1 & 8) != 0) {
            bufferOverflow0 = BufferOverflow.SUSPEND;
        }
        this(n0, i0, v, bufferOverflow0);
    }

    @Override  // kotlinx.coroutines.flow.ChannelFlowBuilder
    @Nullable
    public Object collectTo(@NotNull ProducerScope producerScope0, @NotNull Continuation continuation0) {
        kotlinx.coroutines.flow.CallbackFlowBuilder.collectTo.1 callbackFlowBuilder$collectTo$10;
        if(continuation0 instanceof kotlinx.coroutines.flow.CallbackFlowBuilder.collectTo.1) {
            callbackFlowBuilder$collectTo$10 = (kotlinx.coroutines.flow.CallbackFlowBuilder.collectTo.1)continuation0;
            int v = callbackFlowBuilder$collectTo$10.label;
            if((v & 0x80000000) == 0) {
                callbackFlowBuilder$collectTo$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.collectTo(null, this);
                    }
                };
            }
            else {
                callbackFlowBuilder$collectTo$10.label = v ^ 0x80000000;
            }
        }
        else {
            callbackFlowBuilder$collectTo$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.collectTo(null, this);
                }
            };
        }
        Object object0 = callbackFlowBuilder$collectTo$10.result;
        a a0 = a.a;
        switch(callbackFlowBuilder$collectTo$10.label) {
            case 0: {
                d5.n.D(object0);
                callbackFlowBuilder$collectTo$10.L$0 = producerScope0;
                callbackFlowBuilder$collectTo$10.label = 1;
                if(super.collectTo(producerScope0, callbackFlowBuilder$collectTo$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                producerScope0 = (ProducerScope)callbackFlowBuilder$collectTo$10.L$0;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!producerScope0.isClosedForSend()) {
            throw new IllegalStateException("\'awaitClose { yourCallbackOrListener.cancel() }\' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
        }
        return H.a;
    }

    @Override  // kotlinx.coroutines.flow.ChannelFlowBuilder
    @NotNull
    public ChannelFlow create(@NotNull i i0, int v, @NotNull BufferOverflow bufferOverflow0) {
        return new CallbackFlowBuilder(this.block, i0, v, bufferOverflow0);
    }
}

