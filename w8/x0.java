package w8;

import android.os.Bundle;
import com.iloen.melon.appwidget.GlanceHomeWidgetReceiver;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import q2.b;
import we.n;

public final class x0 extends i implements n {
    public final GlanceHomeWidgetReceiver B;
    public Object r;
    public final Bundle w;

    public x0(Bundle bundle0, GlanceHomeWidgetReceiver glanceHomeWidgetReceiver0, Continuation continuation0) {
        this.w = bundle0;
        this.B = glanceHomeWidgetReceiver0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new x0(this.w, this.B, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((x0)this.create(((b)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        b b0 = (b)this.r;
        d5.n.D(object0);
        int v = this.w.getInt("appWidgetMinHeight");
        int v1 = this.B.c().u();
        if(v < v1) {
            b0.g(w0.d, Boolean.TRUE);
            b0.g(w0.e, new Integer(v));
            return H.a;
        }
        b0.g(w0.d, Boolean.FALSE);
        b0.g(w0.e, new Integer(v1));
        return H.a;
    }
}

