package L5;

import C0.b;
import Hc.k;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import d3.g;
import kotlin.jvm.internal.q;
import y0.M;

public abstract class c {
    public static final Object a;

    static {
        k k0 = new k(6);
        c.a = g.P(ie.k.c, k0);
    }

    public static final C0.c a(Drawable drawable0, l l0) {
        b b0;
        ((p)l0).a0(0x68B6FB29);
        ((p)l0).a0(0x113DDC63);
        boolean z = ((p)l0).g(drawable0);
        Object object0 = ((p)l0).N();
        if(z || object0 == androidx.compose.runtime.k.a) {
            if(drawable0 == null) {
                object0 = d.a;
            }
            else {
                if(drawable0 instanceof ColorDrawable) {
                    b0 = new b(M.c(((ColorDrawable)drawable0).getColor()));
                }
                else {
                    Drawable drawable1 = drawable0.mutate();
                    q.f(drawable1, "mutate(...)");
                    b0 = new L5.b(drawable1);
                }
                object0 = b0;
            }
            ((p)l0).l0(object0);
        }
        ((p)l0).p(false);
        ((p)l0).p(false);
        return (C0.c)object0;
    }
}

