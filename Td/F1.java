package td;

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

public final class f1 extends i implements n {
    public final t1 B;
    public final e D;
    public int r;
    public int w;

    public f1(t1 t10, e e0, Continuation continuation0) {
        this.B = t10;
        this.D = e0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new f1(this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        int v1;
        int v;
        t1 t10 = this.B;
        r r0 = t10.I;
        a a0 = a.a;
        H h0 = H.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                Object object1 = t10.getUiState().getValue();
                p0 p00 = object1 instanceof p0 ? ((p0)object1) : null;
                if(p00 != null) {
                    Playable playable0 = p00.b;
                    v = !p00.h;
                    if(playable0 != null) {
                        String s = t10.getMenuId();
                        this.r = v;
                        this.w = 1;
                        object0 = t10.g.p(((boolean)v), s, p00.a, playable0);
                        if(object0 == a0) {
                            return a0;
                        }
                        v1 = v;
                        goto label_22;
                    }
                    goto label_32;
                }
                break;
            }
            case 1: {
                v1 = this.r;
                d5.n.D(object0);
            label_22:
                N n0 = new N(t10, 29);
                this.r = v1;
                this.w = 2;
                if(((Flow)object0).collect(n0, this) == a0) {
                    return a0;
                }
                v = v1;
                goto label_32;
            }
            case 2: {
                int v2 = this.r;
                d5.n.D(object0);
                v = v2;
            label_32:
                e e0 = this.D;
                if(e0.equals(r0.a)) {
                    if(v != 0) {
                        n0 n00 = t10.f();
                        m.F(new l0(n00, ((Playable)n00.b.invoke()), 0)).track();
                        return h0;
                    }
                    n0 n01 = t10.f();
                    m.F(new l0(n01, ((Playable)n01.b.invoke()), 1)).track();
                    return h0;
                }
                if(e0.equals(s0.a)) {
                    if(v != 0) {
                        g0 g00 = (g0)r0.getValue();
                        m.F(new e0(g00, ((Playable)g00.b.invoke()), 0)).track();
                        return h0;
                    }
                    g0 g01 = (g0)r0.getValue();
                    m.F(new e0(g01, ((Playable)g01.b.invoke()), 2)).track();
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

