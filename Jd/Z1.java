package jd;

import android.view.MotionEvent;
import ie.H;
import kotlin.jvm.internal.q;
import w0.h;
import we.k;
import x0.b;

public final class z1 implements k {
    public final int a;
    public final h b;

    public z1(h h0, int v) {
        this.a = v;
        this.b = h0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            b b0 = (b)object0;
            h.a(this.b);
            return H.a;
        }
        q.g(((MotionEvent)object0), "it");
        if(((MotionEvent)object0).getAction() == 0) {
            h.a(this.b);
        }
        return false;
    }
}

