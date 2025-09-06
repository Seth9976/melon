package t9;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class x extends i implements n {
    public final z B;
    public final Context r;
    public final int w;

    public x(Context context0, int v, z z0, Continuation continuation0) {
        this.r = context0;
        this.w = v;
        this.B = z0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new x(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((x)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        Bitmap bitmap0 = BitmapFactory.decodeResource(this.r.getResources(), this.w);
        q.f(bitmap0, "decodeResource(...)");
        return z.b(this.B, this.r, bitmap0, "insta_share_bg.png");
    }
}

