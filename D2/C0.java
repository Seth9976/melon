package D2;

import androidx.glance.appwidget.GlanceAppWidgetManager;
import ie.H;
import java.util.Set;
import je.I;
import je.y;
import kotlin.coroutines.Continuation;
import oe.i;
import q2.b;
import q2.f;
import q2.h;
import we.n;

public final class c0 extends i implements n {
    public final String B;
    public Object r;
    public final String w;

    public c0(String s, String s1, Continuation continuation0) {
        this.w = s;
        this.B = s1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new c0(this.w, this.B, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((c0)this.create(((h)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        h h0 = (h)this.r;
        b b0 = h0.c();
        f f0 = GlanceAppWidgetManager.g;
        Set set0 = (Set)h0.b(f0);
        if(set0 == null) {
            set0 = y.a;
        }
        b0.h(f0, I.L(set0, this.w));
        b0.h(W.a(GlanceAppWidgetManager.d, this.w), this.B);
        return b0.d();
    }
}

