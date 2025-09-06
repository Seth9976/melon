package m1;

import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.ui.tooling.ComposeViewAdapter;
import ie.H;
import kotlin.jvm.internal.r;
import n1.q;
import we.n;

public final class j extends r implements n {
    public final String f;
    public final String g;
    public final Class h;
    public final int i;
    public final ComposeViewAdapter j;
    public final long k;

    public j(String s, String s1, Class class0, int v, ComposeViewAdapter composeViewAdapter0, long v1) {
        this.f = s;
        this.g = s1;
        this.h = class0;
        this.i = v;
        this.j = composeViewAdapter0;
        this.k = v1;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = ((Number)object1).intValue();
        p p0 = (p)(((l)object0));
        if(p0.Q(v & 1, (v & 3) != 2)) {
            String s = this.f;
            boolean z = p0.g(s);
            String s1 = this.g;
            boolean z1 = p0.g(s1);
            boolean z2 = p0.i(p0);
            boolean z3 = p0.i(this.h);
            boolean z4 = p0.e(this.i);
            ComposeViewAdapter composeViewAdapter0 = this.j;
            boolean z5 = p0.i(composeViewAdapter0);
            i i0 = p0.N();
            V v1 = k.a;
            if((z | z1 | z2 | z3 | z4 | z5) != 0 || i0 == v1) {
                i i1 = new i(s, s1, p0, this.h, this.i, composeViewAdapter0, 0);
                p0.l0(i1);
                i0 = i1;
            }
            if(this.k >= 0L) {
                p0.a0(-967474306);
                if(p0.i(composeViewAdapter0) || p0.N() == v1) {
                    p0.l0(new X.k(composeViewAdapter0, 23));
                }
                composeViewAdapter0.setClock$ui_tooling_release(new q());
            }
            else {
                p0.a0(-966247109);
            }
            p0.p(false);
            i0.invoke();
            return H.a;
        }
        p0.T();
        return H.a;
    }
}

