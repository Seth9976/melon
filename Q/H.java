package Q;

import I.G1;
import J0.L;
import J0.o;
import J0.u;
import J0.v;
import androidx.compose.runtime.O0;
import ie.H;
import java.util.Collection;
import java.util.List;
import kotlin.coroutines.Continuation;
import ne.a;
import we.n;
import x0.b;

public final class h extends oe.h implements n {
    public int B;
    public Object D;
    public final K E;
    public v r;
    public v w;

    public h(K k0, Continuation continuation0) {
        this.E = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new h(this.E, continuation0);
        continuation1.D = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h)this.create(((L)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        v v1;
        v v0;
        L l1;
        L l0;
        a a0 = a.a;
        K k0 = this.E;
        switch(this.B) {
            case 0: {
                d5.n.D(object0);
                l0 = (L)this.D;
                this.D = l0;
                this.B = 1;
                object0 = G1.b(l0, false, o.a, this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_13;
            }
            case 1: {
                l0 = (L)this.D;
                d5.n.D(object0);
            label_13:
                b b0 = new b(0L);
                ((O0)k0.c).setValue(b0);
                l1 = l0;
                v0 = null;
                v1 = (v)object0;
                goto label_32;
            }
            case 2: {
                v0 = this.w;
                v1 = this.r;
                l1 = (L)this.D;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            Object object1 = ((J0.n)object0).a;
            int v2 = ((Collection)object1).size();
            int v3 = 0;
            while(true) {
                if(v3 < v2) {
                    if(u.b(((v)((List)object1).get(v3)))) {
                        ++v3;
                        continue;
                    }
                    else {
                        break;
                    }
                }
                v0 = (v)((List)((J0.n)object0).a).get(0);
                break;
            }
        label_32:
            if(v0 == null) {
                this.D = l1;
                this.r = v1;
                this.w = null;
                this.B = 2;
                object0 = l1.a(o.a, this);
                if(object0 != a0) {
                    continue;
                }
                break;
            }
            goto label_40;
        }
        return a0;
    label_40:
        b b1 = new b(b.f(v0.c, v1.c));
        ((O0)k0.c).setValue(b1);
        return H.a;
    }
}

