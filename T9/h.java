package t9;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class h extends i implements n {
    public final o B;
    public final Context r;
    public final int w;

    public h(Context context0, int v, o o0, Continuation continuation0) {
        this.r = context0;
        this.w = v;
        this.B = o0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((h)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        View view0 = LayoutInflater.from(this.r).inflate(0x7F0D0030, null, false);  // layout:app_to_app_share_bg
        view0.findViewById(0x7F0A0702).setBackgroundColor(this.w);  // id:layout_bg
        Bitmap bitmap0 = o.a(this.B, view0);
        return o.b(this.B, this.r, bitmap0, "facebook_share_bg.png");
    }
}

