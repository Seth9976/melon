package w8;

import com.iloen.melon.utils.preference.MelonPrefs;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import q2.b;
import we.n;

public final class u0 extends i implements n {
    public Object r;
    public final w0 w;

    public u0(w0 w00, Continuation continuation0) {
        this.w = w00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new u0(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((u0)this.create(((b)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        b b0 = (b)this.r;
        d5.n.D(object0);
        boolean z = MelonPrefs.getInstance().getInt(this.w.r(), 0) == 1;
        b0.g(w0.f, Boolean.valueOf(z));
        Float float0 = new Float(((float)(100 - MelonPrefs.getInstance().getInt(this.w.q(), 30))) / 100.0f);
        b0.g(w0.g, float0);
        return H.a;
    }
}

