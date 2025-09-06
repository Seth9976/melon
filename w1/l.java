package w1;

import va.e;

public final class l extends i {
    public final m h;

    public l(m m0) {
        this.h = m0;
    }

    @Override  // w1.i
    public final String g() {
        j j0 = (j)this.h.a.get();
        return j0 == null ? "Completer object has been garbage collected, future will fail soon" : e.d(new StringBuilder("tag=["), j0.a, "]");
    }
}

