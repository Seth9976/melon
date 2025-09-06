package I;

import J0.v;
import android.content.Context;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ie.H;
import kotlin.jvm.internal.r;
import we.k;

public final class e extends r implements k {
    public final int f;
    public static final e g;
    public static final e h;
    public static final e i;
    public static final e j;
    public static final e k;

    static {
        e.g = new e(1, 0);
        e.h = new e(1, 1);
        e.i = new e(1, 2);
        e.j = new e(1, 3);
        e.k = new e(1, 4);
    }

    public e(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.f) {
            case 0: {
                ((i0)object0).getClass();
                if(!((Context)w.u(((i0)object0), AndroidCompositionLocals_androidKt.b)).getPackageManager().hasSystemFeature("android.software.leanback")) {
                    d.a.getClass();
                    return c.c;
                }
                return g.b;
            }
            case 1: {
                v v0 = (v)object0;
                return true;
            }
            case 2: {
                ((Number)object0).longValue();
                return H.a;
            }
            case 3: {
                return ((v)object0).i == 2 ? Boolean.valueOf(((boolean)0)) : Boolean.valueOf(((boolean)1));
            }
            default: {
                ((Number)object0).floatValue();
                return H.a;
            }
        }
    }
}

