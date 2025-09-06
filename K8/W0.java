package k8;

import La.c;
import android.widget.TextView;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class w0 extends i implements n {
    public final TextView r;

    public w0(TextView textView0, Continuation continuation0) {
        this.r = textView0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new w0(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        ((w0)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        int v = ((Boolean)c.a.getValue()).booleanValue() ? 0 : 8;
        this.r.setVisibility(v);
        return H.a;
    }
}

