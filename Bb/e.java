package bb;

import Cb.j;
import H8.q;
import com.iloen.melon.net.HttpResponse;
import e.k;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oe.i;
import ta.L;
import we.n;

public final class e extends i implements n {
    public Object B;
    public final q D;
    public final String E;
    public final String G;
    public final boolean I;
    public HttpResponse r;
    public int w;

    public e(q q0, String s, String s1, boolean z, Continuation continuation0) {
        this.D = q0;
        this.E = s;
        this.G = s1;
        this.I = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new e(this.D, this.E, this.G, this.I, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        HttpResponse httpResponse0;
        FlowCollector flowCollector0 = (FlowCollector)this.B;
        a a0 = a.a;
        boolean z = this.I;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                this.B = flowCollector0;
                this.w = 1;
                object0 = ((L)this.D.f).v(this.E, this.G, (z ? "Y" : "N"), this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_14;
            }
            case 1: {
                d5.n.D(object0);
            label_14:
                httpResponse0 = (HttpResponse)object0;
                h h0 = new h(httpResponse0.notification, true);
                this.B = flowCollector0;
                this.r = httpResponse0;
                this.w = 2;
                if(flowCollector0.emit(h0, this) == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                httpResponse0 = this.r;
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
        if(j.d(httpResponse0)) {
            m m0 = new m(k.z(new g("", z)));
            this.B = null;
            this.r = null;
            this.w = 3;
            if(flowCollector0.emit(m0, this) == a0) {
                return a0;
            }
        }
        return H.a;
    }
}

