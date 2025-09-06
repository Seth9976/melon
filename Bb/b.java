package bb;

import H8.q;
import com.iloen.melon.net.v6x.response.MusicWaveSubscribeInfoRes.RESPONSE;
import com.iloen.melon.net.v6x.response.MusicWaveSubscribeInfoRes;
import e1.u;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import mb.k;
import ne.a;
import oe.i;
import ta.L;
import va.e0;
import we.n;

public final class b extends i implements n {
    public Object B;
    public final q D;
    public final String E;
    public final String G;
    public MusicWaveSubscribeInfoRes r;
    public int w;

    public b(q q0, String s, String s1, Continuation continuation0) {
        this.D = q0;
        this.E = s;
        this.G = s1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new b(this.D, this.E, this.G, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        MusicWaveSubscribeInfoRes musicWaveSubscribeInfoRes0;
        FlowCollector flowCollector0 = (FlowCollector)this.B;
        a a0 = a.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                L l0 = (L)this.D.f;
                String s = u.v(((e0)(((k)this.D.e))).j());
                this.B = flowCollector0;
                this.w = 1;
                object0 = l0.q(this.E, this.G, s, this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_15;
            }
            case 1: {
                d5.n.D(object0);
            label_15:
                musicWaveSubscribeInfoRes0 = (MusicWaveSubscribeInfoRes)object0;
                h h0 = new h(musicWaveSubscribeInfoRes0.notification, true);
                this.B = flowCollector0;
                this.r = musicWaveSubscribeInfoRes0;
                this.w = 2;
                if(flowCollector0.emit(h0, this) == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                musicWaveSubscribeInfoRes0 = this.r;
                d5.n.D(object0);
                break;
            }
            case 3: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        RESPONSE musicWaveSubscribeInfoRes$RESPONSE0 = musicWaveSubscribeInfoRes0.getResponse();
        m m0 = new m(e.k.z(new g("", (musicWaveSubscribeInfoRes$RESPONSE0 == null ? false : kotlin.jvm.internal.q.b(musicWaveSubscribeInfoRes$RESPONSE0.isSubscribe(), Boolean.TRUE)))));
        this.B = null;
        this.r = null;
        this.w = 3;
        return flowCollector0.emit(m0, this) == a0 ? a0 : H.a;
    }
}

