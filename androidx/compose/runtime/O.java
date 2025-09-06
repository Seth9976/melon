package androidx.compose.runtime;

import p0.r;

public final class o {
    public final int a;
    public final Object b;

    public o(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    public final void a() {
        if(this.a != 0) {
            --((r)this.b).j;
            return;
        }
        --((p)this.b).z;
    }

    public final void b() {
        if(this.a != 0) {
            ++((r)this.b).j;
            return;
        }
        ++((p)this.b).z;
    }
}

