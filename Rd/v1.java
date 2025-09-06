package rd;

import Ac.N;
import Pc.e;
import com.iloen.melon.playback.Playable;
import e1.m;
import ie.H;
import ie.r;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import oe.i;
import we.n;

public final class v1 extends i implements n {
    public final K1 B;
    public final e D;
    public int r;
    public int w;

    public v1(K1 k10, e e0, Continuation continuation0) {
        this.B = k10;
        this.D = e0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new v1(this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((v1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v1;
        int v;
        K1 k10 = this.B;
        r r0 = k10.M;
        a a0 = a.a;
        H h0 = H.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                Object object1 = k10.getUiState().getValue();
                D0 d00 = object1 instanceof D0 ? ((D0)object1) : null;
                if(d00 != null) {
                    Playable playable0 = d00.f;
                    v = !d00.j;
                    if(playable0 != null) {
                        String s = k10.getMenuId();
                        this.r = v;
                        this.w = 1;
                        Flow flow0 = k10.i.p(((boolean)v), s, k10.p, playable0);
                        if(flow0 == a0) {
                            return a0;
                        }
                        v1 = v;
                        object0 = flow0;
                        goto label_23;
                    }
                    goto label_33;
                }
                break;
            }
            case 1: {
                v1 = this.r;
                d5.n.D(object0);
            label_23:
                N n0 = new N(k10, 27);
                this.r = v1;
                this.w = 2;
                if(((Flow)object0).collect(n0, this) == a0) {
                    return a0;
                }
                v = v1;
                goto label_33;
            }
            case 2: {
                int v2 = this.r;
                d5.n.D(object0);
                v = v2;
            label_33:
                e e0 = this.D;
                if(e0.equals(I0.a)) {
                    if(v != 0) {
                        B0 b00 = k10.h();
                        m.F(new z0(b00, ((Playable)b00.b.invoke()), 5)).track();
                        return h0;
                    }
                    B0 b01 = k10.h();
                    m.F(new z0(b01, ((Playable)b01.b.invoke()), 3)).track();
                    return h0;
                }
                if(e0.equals(J0.a)) {
                    if(v != 0) {
                        e0 e00 = (e0)r0.getValue();
                        m.F(new d0(e00, ((Playable)e00.b.invoke()), 4)).track();
                        return h0;
                    }
                    e0 e01 = (e0)r0.getValue();
                    m.F(new d0(e01, ((Playable)e01.b.invoke()), 3)).track();
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }
}

