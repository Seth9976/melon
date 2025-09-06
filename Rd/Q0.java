package rd;

import android.graphics.drawable.BitmapDrawable;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import m4.e;
import oe.i;
import we.n;

public final class q0 extends i implements n {
    public final BitmapDrawable r;

    public q0(BitmapDrawable bitmapDrawable0, Continuation continuation0) {
        this.r = bitmapDrawable0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new q0(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((q0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        return new e(this.r.getBitmap()).a().e;
    }
}

