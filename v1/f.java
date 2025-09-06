package v1;

import N0.v;
import Q0.s;
import android.os.Handler;
import android.os.Looper;
import ie.H;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import r1.l;
import we.a;
import we.k;

public final class f extends r implements k {
    public final int f;
    public final m g;

    public f(m m0, int v) {
        this.f = v;
        this.g = m0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.f) {
            case 0: {
                v v0 = ((v)object0).X();
                q.d(v0);
                this.g.l(v0);
                return H.a;
            }
            case 1: {
                l l0 = new l(((l)object0).a);
                this.g.setPopupContentSize-fhxjrPA(l0);
                this.g.m();
                return H.a;
            }
            default: {
                m m0 = this.g;
                Handler handler0 = m0.getHandler();
                if((handler0 == null ? null : handler0.getLooper()) == Looper.myLooper()) {
                    ((a)object0).invoke();
                    return H.a;
                }
                Handler handler1 = m0.getHandler();
                if(handler1 != null) {
                    handler1.post(new s(4, ((a)object0)));
                }
                return H.a;
            }
        }
    }
}

