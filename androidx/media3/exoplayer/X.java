package androidx.media3.exoplayer;

import A3.l;
import H6.e;
import android.os.Looper;
import androidx.media3.session.D0;
import androidx.media3.session.Q;
import androidx.media3.session.b0;
import androidx.media3.session.d1;
import androidx.media3.session.o1;
import androidx.media3.session.v0;
import androidx.media3.session.w0;
import b3.P;
import b3.q;
import e3.b;
import e3.j;
import java.util.List;
import java.util.Objects;

public final class x implements e, D0, b0, d1, e3.e, j {
    public final int a;

    public x(int v) {
        this.a = v;
        super();
    }

    @Override  // androidx.media3.session.d1
    public void a(o1 o10, w0 w00, List list0) {
        if(this.a != 21) {
            o10.O(list0);
            return;
        }
        o10.O(list0);
    }

    @Override  // e3.e
    public void accept(Object object0) {
        switch(this.a) {
            case 13: {
                ((o1)object0).pause();
                return;
            }
            case 14: {
                ((o1)object0).m();
                return;
            }
            case 15: {
                ((o1)object0).r();
                return;
            }
            case 16: {
                ((o1)object0).S();
                return;
            }
            case 17: {
                ((o1)object0).k();
                return;
            }
            case 18: {
                ((o1)object0).c();
                return;
            }
            case 19: {
                ((o1)object0).R();
                return;
            }
            case 20: {
                ((o1)object0).t();
                return;
            }
            case 22: {
                ((o1)object0).e();
                return;
            }
            case 24: {
                ((o1)object0).stop();
                return;
            }
            case 25: {
                ((o1)object0).prepare();
                return;
            }
            case 26: {
                ((o1)object0).seekToDefaultPosition();
                return;
            }
            default: {
                ((o1)object0).b();
            }
        }
    }

    @Override  // H6.e
    public Object apply(Object object0) {
        return ((q)object0).a + ": " + ((q)object0).b;
    }

    @Override  // androidx.media3.session.b0
    public void b(Q q0) {
        switch(this.a) {
            case 4: {
                if(q0.isConnected()) {
                    q0.a.getClass();
                    b.j(Looper.myLooper() == q0.a.e.getLooper());
                    q0.a.d.getClass();
                }
                return;
            }
            case 5: {
                x x0 = new x(0);
                q0.h.g(26, x0);
                return;
            }
            case 6: {
                Objects.requireNonNull(q0.a);
                l l0 = new l(q0.a, 18);
                q0.a.f0(l0);
                return;
            }
            case 7: {
                throw new ClassCastException();
            }
            case 8: {
                if(q0.isConnected()) {
                    q0.a.getClass();
                    b.j(Looper.myLooper() == q0.a.e.getLooper());
                    q0.a.d.getClass();
                }
                return;
            }
            default: {
                if(q0.isConnected()) {
                    q0.a.getClass();
                    b.j(Looper.myLooper() == q0.a.e.getLooper());
                    q0.a.d.getClass();
                }
            }
        }
    }

    @Override  // androidx.media3.session.D0
    public void h(v0 v00, int v) {
        switch(this.a) {
            case 10: {
                v00.getClass();
                return;
            }
            case 11: {
                v00.getClass();
                return;
            }
            default: {
                v00.e(v);
            }
        }
    }

    @Override  // e3.j
    public void invoke(Object object0) {
        if(this.a != 0) {
            ((P)object0).w(1);
            return;
        }
        ((P)object0).onRenderedFirstFrame();
    }
}

