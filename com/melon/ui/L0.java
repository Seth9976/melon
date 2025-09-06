package com.melon.ui;

import De.w;
import kotlin.jvm.internal.q;
import p8.s;
import sf.j;
import ze.a;

public final class l0 extends a {
    public final int b;
    public final Object c;

    public l0(n0 n00) {
        this.b = 0;
        this.c = n00;
        super(null);
    }

    public l0(Object object0, j j0) {
        this.b = 1;
        this.c = j0;
        super(object0);
    }

    @Override  // ze.a
    public void a(w w0, Object object0, Object object1) {
        if(this.b != 0) {
            super.a(w0, object0, object1);
            return;
        }
        q.g(w0, "property");
        s s0 = (s)object0;
        if(((s)object1) != null) {
            e0 e00 = new e0(((s)object1));
            ((n0)this.c).sendUiEvent(e00);
        }
    }

    @Override  // ze.a
    public void b(w w0) {
        if(this.b != 1) {
            super.b(w0);
            return;
        }
        q.g(w0, "property");
        if(((j)this.c).a) {
            throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
        }
    }
}

