package V4;

import android.content.Context;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import e5.j;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;

public final class n extends i implements we.n {
    public boolean r;
    public final Context w;

    public n(Context context0, Continuation continuation0) {
        this.w = context0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new n(this.w, continuation0);
        continuation1.r = ((Boolean)object0).booleanValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        ((n)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        j.a(this.w, RescheduleReceiver.class, this.r);
        return H.a;
    }
}

