package C1;

import D1.d;
import F1.e;
import F1.j;
import java.util.ArrayList;
import java.util.Collections;
import x1.s;

public class g extends b implements d {
    public final s k0;
    public final int l0;
    public final ArrayList m0;

    public g(s s0, int v) {
        super(s0);
        this.m0 = new ArrayList();
        this.k0 = s0;
        this.l0 = v;
    }

    @Override  // C1.b
    public final e a() {
        return this.s();
    }

    @Override  // C1.b, D1.d
    public void apply() {
    }

    public final void q(Object[] arr_object) {
        Collections.addAll(this.m0, arr_object);
    }

    public final void r() {
        super.apply();
    }

    public j s() {
        return null;
    }
}

