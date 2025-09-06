package k8;

import La.c;
import android.widget.TextView;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class z0 extends i implements n {
    public final TextView r;
    public final TextView w;

    public z0(TextView textView0, TextView textView1, Continuation continuation0) {
        this.r = textView0;
        this.w = textView1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new z0(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        ((z0)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        boolean z = ((Boolean)c.d.getValue()).booleanValue();
        int v = 8;
        this.r.setVisibility((z ? 0 : 8));
        if(z) {
            v = 0;
        }
        this.w.setVisibility(v);
        return H.a;
    }
}

