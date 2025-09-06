package d0;

import A0.c;
import A0.d;
import G.z0;
import P0.K;
import androidx.appcompat.app.o;
import androidx.media3.session.legacy.V;
import ie.H;
import kotlin.jvm.internal.r;
import we.k;

public final class e extends r implements k {
    public final int f;
    public static final e g;
    public static final e h;

    static {
        e.g = new e(1, 0);
        e.h = new e(1, 1);
    }

    public e(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.f != 0) {
            return new s(new G.e(((Number)object0).floatValue(), z0.a, null, 12));
        }
        V v0 = ((K)(((d)object0))).a.b;
        long v1 = v0.l();
        v0.h().q();
        try {
            ((V)((c)v0.a).b).h().h(-3.402823E+38f, 0.0f, 3.402823E+38f, 3.402823E+38f, 1);
            ((K)(((d)object0))).a();
            return H.a;
        }
        finally {
            o.y(v0, v1);
        }
    }
}

