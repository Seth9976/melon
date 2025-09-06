package o0;

import androidx.media3.session.legacy.V;
import ie.H;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;

public final class a extends r implements we.a {
    public final b f;
    public final l g;
    public final i h;
    public final String i;
    public final Object j;
    public final Object[] k;

    public a(b b0, l l0, i i0, String s, Object object0, Object[] arr_object) {
        this.f = b0;
        this.g = l0;
        this.h = i0;
        this.i = s;
        this.j = object0;
        this.k = arr_object;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        int v1;
        b b0 = this.f;
        i i0 = this.h;
        int v = 1;
        if(b0.b == i0) {
            v1 = 0;
        }
        else {
            b0.b = i0;
            v1 = 1;
        }
        String s = this.i;
        if(q.b(b0.c, s)) {
            v = v1;
        }
        else {
            b0.c = s;
        }
        b0.a = this.g;
        b0.d = this.j;
        b0.e = this.k;
        h h0 = b0.f;
        if(h0 != null && v != 0) {
            ((V)h0).E();
            b0.f = null;
            b0.a();
        }
        return H.a;
    }
}

