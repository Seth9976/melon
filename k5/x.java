package k5;

import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.a;
import we.n;

public final class x extends i implements n {
    public final a B;
    public final Drawable r;
    public final a w;

    public x(Drawable drawable0, a a0, a a1, Continuation continuation0) {
        this.r = drawable0;
        this.w = a0;
        this.B = a1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new x(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((x)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        x5.a a0 = new x5.a(this.w, this.B);
        ((AnimatedImageDrawable)this.r).registerAnimationCallback(a0);
        return H.a;
    }
}

