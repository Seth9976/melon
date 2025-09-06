package androidx.fragment.app;

import java.util.ArrayList;

public final class j0 implements i0 {
    public final int a;
    public final int b;
    public final l0 c;

    public j0(l0 l00, int v, int v1) {
        this.c = l00;
        this.a = v;
        this.b = v1;
    }

    @Override  // androidx.fragment.app.i0
    public final boolean a(ArrayList arrayList0, ArrayList arrayList1) {
        return this.c.A == null || this.a >= 0 || !this.c.A.getChildFragmentManager().Y(-1, 0) ? this.c.Z(arrayList0, arrayList1, this.a, this.b) : false;
    }
}

