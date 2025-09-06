package a3;

import M6.s;
import M6.x;
import android.os.Bundle;
import android.os.Looper;
import androidx.media3.exoplayer.V;
import androidx.media3.session.b0;
import androidx.media3.session.o1;
import androidx.media3.session.s1;
import androidx.media3.session.t;
import androidx.media3.session.v;
import b3.P;
import b3.Q;
import e3.b;
import e3.e;
import e3.j;
import i3.a;

public final class f implements b0, e, j {
    public final int a;
    public final int b;

    public f(int v, int v1) {
        this.a = v1;
        this.b = v;
        super();
    }

    public f(int v, s1 s10, Bundle bundle0) {
        this.a = 4;
        super();
        this.b = v;
    }

    public f(a a0, int v, Q q0, Q q1) {
        this.a = 9;
        super();
        this.b = v;
    }

    @Override  // e3.e
    public void accept(Object object0) {
        switch(this.a) {
            case 5: {
                ((o1)object0).n(this.b);
                return;
            }
            case 6: {
                ((o1)object0).f(this.b);
                return;
            }
            case 7: {
                ((o1)object0).setRepeatMode(this.b);
                return;
            }
            default: {
                ((o1)object0).Q(this.b);
            }
        }
    }

    @Override  // androidx.media3.session.b0
    public void b(androidx.media3.session.Q q0) {
        v v0 = q0.a;
        if(!q0.isConnected()) {
            return;
        }
        v0.getClass();
        b.j(Looper.myLooper() == v0.e.getLooper());
        v0.d.getClass();
        x x0 = t.q();
        x0.addListener(new V(q0, x0, this.b, 1), s.a);
    }

    @Override  // e3.j
    public void invoke(Object object0) {
        switch(this.a) {
            case 0: {
                ((P)object0).onRepeatModeChanged(this.b);
                return;
            }
            case 1: {
                ((P)object0).w(this.b);
                return;
            }
            case 2: {
                ((P)object0).onRepeatModeChanged(this.b);
                return;
            }
            case 3: {
                ((P)object0).onRepeatModeChanged(this.b);
                return;
            }
            default: {
                ((i3.b)object0).getClass();
                int v = this.b;
                if(v == 1) {
                    ((i3.j)(((i3.b)object0))).u = true;
                }
                ((i3.j)(((i3.b)object0))).k = v;
            }
        }
    }
}

