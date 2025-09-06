package m1;

import androidx.compose.runtime.J;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.ui.tooling.ComposeViewAdapter;
import ie.H;
import kotlin.jvm.internal.r;
import m0.b;
import m0.c;
import we.a;
import we.n;

public final class k extends r implements n {
    public final a f;
    public final ComposeViewAdapter g;
    public final String h;
    public final String i;
    public final Class j;
    public final int k;
    public final long l;

    public k(a a0, ComposeViewAdapter composeViewAdapter0, String s, String s1, Class class0, int v, long v1) {
        this.f = a0;
        this.g = composeViewAdapter0;
        this.h = s;
        this.i = s1;
        this.j = class0;
        this.k = v;
        this.l = v1;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = ((Number)object1).intValue();
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            J.h(this.f, ((p)(((l)object0))));
            b b0 = c.e(320194433, ((p)(((l)object0))), new j(this.h, this.i, this.j, this.k, this.g, this.l));
            ComposeViewAdapter.a(this.g, b0, ((p)(((l)object0))), 6);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

