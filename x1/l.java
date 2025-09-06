package x1;

import Q0.s;
import android.os.Handler;
import android.os.Looper;
import ie.H;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.a;
import we.k;

public final class l extends r implements k {
    public final int f;
    public final m g;

    public l(m m0, int v) {
        this.f = v;
        this.g = m0;
        super(1);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            H h0 = (H)object0;
            this.g.d = true;
            return H.a;
        }
        if(q.b(Looper.myLooper(), Looper.getMainLooper())) {
            ((a)object0).invoke();
            return H.a;
        }
        m m0 = this.g;
        Handler handler0 = m0.b;
        if(handler0 == null) {
            handler0 = new Handler(Looper.getMainLooper());
            m0.b = handler0;
        }
        handler0.post(new s(5, ((a)object0)));
        return H.a;
    }
}

