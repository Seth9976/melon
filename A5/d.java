package a5;

import Z4.i;
import android.os.Build.VERSION;
import b5.a;
import b5.e;
import kotlin.jvm.internal.q;

public final class d extends c {
    public final int b;
    public final int c;

    public d(a a0) {
        this.b = 1;
        q.g(a0, "tracker");
        super(a0);
        this.c = 5;
    }

    public d(e e0, int v) {
        this.b = v;
        switch(v) {
            case 2: {
                q.g(e0, "tracker");
                super(e0);
                this.c = 7;
                return;
            }
            case 3: {
                q.g(e0, "tracker");
                super(e0);
                this.c = 7;
                return;
            }
            case 4: {
                q.g(e0, "tracker");
                super(e0);
                this.c = 9;
                return;
            }
            default: {
                q.g(e0, "tracker");
                super(e0);
                this.c = 6;
            }
        }
    }

    @Override  // a5.e
    public final boolean b(d5.q q0) {
        switch(this.b) {
            case 0: {
                q.g(q0, "workSpec");
                return q0.j.c;
            }
            case 1: {
                q.g(q0, "workSpec");
                return q0.j.e;
            }
            case 2: {
                q.g(q0, "workSpec");
                return q0.j.a == 2;
            }
            case 3: {
                q.g(q0, "workSpec");
                int v = q0.j.a;
                return v == 3 || Build.VERSION.SDK_INT >= 30 && v == 6;
            }
            default: {
                q.g(q0, "workSpec");
                return q0.j.f;
            }
        }
    }

    @Override  // a5.c
    public final int d() {
        switch(this.b) {
            case 0: {
                return this.c;
            }
            case 1: {
                return this.c;
            }
            case 2: {
                return this.c;
            }
            case 3: {
                return this.c;
            }
            default: {
                return this.c;
            }
        }
    }

    @Override  // a5.c
    public final boolean e(Object object0) {
        switch(this.b) {
            case 0: {
                return !((Boolean)object0).booleanValue();
            }
            case 1: {
                return !((Boolean)object0).booleanValue();
            }
            case 2: {
                q.g(((i)object0), "value");
                return !((i)object0).a || !((i)object0).b;
            }
            case 3: {
                q.g(((i)object0), "value");
                return !((i)object0).a || ((i)object0).c;
            }
            default: {
                return !((Boolean)object0).booleanValue();
            }
        }
    }
}

