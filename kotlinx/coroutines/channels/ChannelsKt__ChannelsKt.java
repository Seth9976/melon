package kotlinx.coroutines.channels;

import ie.H;
import ie.o;
import ie.p;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import org.jetbrains.annotations.NotNull;
import we.n;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A+\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001A\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"E", "Lkotlinx/coroutines/channels/SendChannel;", "element", "Lkotlinx/coroutines/channels/ChannelResult;", "Lie/H;", "trySendBlocking", "(Lkotlinx/coroutines/channels/SendChannel;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {2, 1, 0}, xi = 0x30, xs = "kotlinx/coroutines/channels/ChannelsKt")
abstract class ChannelsKt__ChannelsKt {
    @NotNull
    public static final Object trySendBlocking(@NotNull SendChannel sendChannel0, Object object0) {
        Object object1 = sendChannel0.trySend-JP2dKIU(object0);
        if(!(object1 instanceof Failed)) {
            H h0 = (H)object1;
            return ChannelResult.Companion.success-JP2dKIU(H.a);
        }
        return ((ChannelResult)BuildersKt__BuildersKt.runBlocking$default(null, new n(sendChannel0, object0, null) {
            final Object $element;
            final SendChannel $this_trySendBlocking;
            private Object L$0;
            int label;

            {
                this.$this_trySendBlocking = sendChannel0;
                this.$element = object0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new kotlinx.coroutines.channels.ChannelsKt__ChannelsKt.trySendBlocking.2(this.$this_trySendBlocking, this.$element, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((kotlinx.coroutines.channels.ChannelsKt__ChannelsKt.trySendBlocking.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                H h1;
                a a0 = a.a;
                H h0 = H.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                        try {
                            this.label = 1;
                            if(this.$this_trySendBlocking.send(this.$element, this) == a0) {
                                return a0;
                            label_9:
                                d5.n.D(object0);
                            }
                            break;
                        }
                        catch(Throwable throwable0) {
                            h1 = d5.n.t(throwable0);
                            goto label_15;
                        }
                    }
                    case 1: {
                        goto label_9;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                h1 = h0;
            label_15:
                if(!(h1 instanceof o)) {
                    return ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(h0));
                }
                Throwable throwable1 = p.a(h1);
                return ChannelResult.box-impl(ChannelResult.Companion.closed-JP2dKIU(throwable1));
            }
        }, 1, null)).unbox-impl();
    }
}

