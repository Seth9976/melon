package G;

import androidx.compose.runtime.b0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelResult;
import ne.a;
import we.n;

public final class i extends oe.i implements n {
    public Object B;
    public final Channel D;
    public final e E;
    public final b0 G;
    public final b0 I;
    public ChannelIterator r;
    public int w;

    public i(Channel channel0, e e0, b0 b00, b0 b01, Continuation continuation0) {
        this.D = channel0;
        this.E = e0;
        this.G = b00;
        this.I = b01;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new i(this.D, this.E, this.G, this.I, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope1;
        ChannelIterator channelIterator0;
        a a0 = a.a;
        Channel channel0 = this.D;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                CoroutineScope coroutineScope0 = (CoroutineScope)this.B;
                channelIterator0 = channel0.iterator();
                coroutineScope1 = coroutineScope0;
                goto label_16;
            }
            case 1: {
                channelIterator0 = this.r;
                coroutineScope1 = (CoroutineScope)this.B;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(((Boolean)object0).booleanValue()) {
            Object object1 = channelIterator0.next();
            Object object2 = ChannelResult.getOrNull-impl(channel0.tryReceive-PtdJZtk());
            BuildersKt__Builders_commonKt.launch$default(coroutineScope1, null, null, new h((object2 == null ? object1 : object2), this.E, this.G, this.I, null), 3, null);
        label_16:
            this.B = coroutineScope1;
            this.r = channelIterator0;
            this.w = 1;
            object0 = channelIterator0.hasNext(this);
            if(object0 != a0) {
                continue;
            }
            return a0;
        }
        return H.a;
    }
}

