package cd;

import H0.e;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.a0;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import m4.g;
import oe.i;

public final class n extends i implements we.n {
    public final Drawable r;
    public final a0 w;

    public n(Drawable drawable0, a0 a00, Continuation continuation0) {
        this.r = drawable0;
        this.w = a00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new n(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((n)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        Bitmap bitmap0 = e.a0(this.r);
        if(bitmap0 != null) {
            Bitmap bitmap1 = bitmap0.copy(Bitmap.Config.ARGB_8888, true);
            if(bitmap1 != null) {
                m4.e e0 = new m4.e(bitmap1);
                e0.a = 24;
                g g0 = e0.a().a(m4.i.h);
                ((K0)this.w).n((g0 == null ? 0 : g0.d));
            }
        }
        return H.a;
    }
}

