package lb;

import Cb.j;
import Za.b;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import oe.i;
import ua.u;
import we.n;

public final class a extends i implements n {
    public Object B;
    public final boolean D;
    public final b E;
    public final String G;
    public final String I;
    public ResponseV6Res r;
    public int w;

    public a(boolean z, b b0, String s, String s1, Continuation continuation0) {
        this.D = z;
        this.E = b0;
        this.G = s;
        this.I = s1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new a(this.D, this.E, this.G, this.I, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((a)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ResponseV6Res responseV6Res0;
        u u0 = this.E.a;
        FlowCollector flowCollector0 = (FlowCollector)this.B;
        ne.a a0 = ne.a.a;
        boolean z = this.D;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                String s = this.I;
                String s1 = this.G;
                if(z) {
                    this.B = flowCollector0;
                    this.w = 1;
                    object0 = u0.n(s1, s, this);
                    if(object0 != a0) {
                        responseV6Res0 = (ResponseV6Res)object0;
                        goto label_32;
                    }
                }
                else {
                    this.B = flowCollector0;
                    this.w = 2;
                    object0 = u0.a(s1, s, this);
                    if(object0 != a0) {
                        responseV6Res0 = (ResponseV6Res)object0;
                    label_32:
                        lb.b b0 = new lb.b((responseV6Res0 == null ? null : responseV6Res0.notification));
                        this.B = flowCollector0;
                        this.r = responseV6Res0;
                        this.w = 3;
                        if(flowCollector0.emit(b0, this) != a0) {
                        label_37:
                            if(responseV6Res0 == null || !j.d(responseV6Res0)) {
                                return H.a;
                            }
                            d d0 = new d(z);
                            this.B = null;
                            this.r = null;
                            this.w = 4;
                            if(flowCollector0.emit(d0, this) != a0) {
                                return H.a;
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                responseV6Res0 = (ResponseV6Res)object0;
                goto label_32;
            }
            case 2: {
                d5.n.D(object0);
                responseV6Res0 = (ResponseV6Res)object0;
                goto label_32;
            }
            case 3: {
                responseV6Res0 = this.r;
                d5.n.D(object0);
                goto label_37;
            }
            case 4: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

