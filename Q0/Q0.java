package Q0;

import androidx.collection.L;
import ie.H;
import jeb.synthetic.FIN;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import ne.a;
import oe.i;
import p0.m;
import we.n;

public final class q0 extends i implements n {
    public int B;
    public final Channel D;
    public ReceiveChannel r;
    public ChannelIterator w;

    public q0(Channel channel0, Continuation continuation0) {
        this.D = channel0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new q0(this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((q0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    // This method was un-flattened
    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ReceiveChannel receiveChannel0;
        a a0 = a.a;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                receiveChannel0 = this.D;
                try {
                    ChannelIterator channelIterator0 = receiveChannel0.iterator();
                    goto label_24;
                label_7:
                    channelIterator0 = this.w;
                    receiveChannel0 = this.r;
                    d5.n.D(object0);
                    while(true) {
                        if(!((Boolean)object0).booleanValue()) {
                            goto label_33;
                        }
                        H h0 = (H)channelIterator0.next();
                        r0.b.set(false);
                        Object object1 = m.b;
                        __monitor_enter(object1);
                        int v = FIN.finallyOpen$NT();
                        L l0 = m.i.h;
                        if(l0 == null || !l0.h()) {
                            FIN.finallyExec$NT(v);
                        }
                        else {
                            FIN.finallyCodeBegin$NT(v);
                            __monitor_exit(object1);
                            FIN.finallyCodeEnd$NT(v);
                            m.a();
                        }
                    label_24:
                        this.r = receiveChannel0;
                        this.w = channelIterator0;
                        this.B = 1;
                        object0 = channelIterator0.hasNext(this);
                        if(object0 != a0) {
                            continue;
                        }
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 1: {
                goto label_7;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        ChannelsKt.cancelConsumed(receiveChannel0, throwable0);
        throw throwable0;
    label_33:
        ChannelsKt.cancelConsumed(receiveChannel0, null);
        return H.a;
    }
}

