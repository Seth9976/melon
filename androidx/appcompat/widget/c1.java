package androidx.appcompat.widget;

import k.m;

public final class c1 implements Runnable {
    public final int a;
    public final Toolbar b;

    public c1(Toolbar toolbar0, int v) {
        this.a = v;
        this.b = toolbar0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            this.b.n();
            return;
        }
        f1 f10 = this.b.l0;
        m m0 = f10 == null ? null : f10.b;
        if(m0 != null) {
            m0.collapseActionView();
        }
    }
}

