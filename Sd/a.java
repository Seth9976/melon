package sd;

import Cc.c1;
import Cc.e0;
import H0.e;
import M.t;
import N0.M;
import P0.h;
import P0.i;
import P0.j;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.E;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import b0.Q;
import ie.H;
import jd.e3;
import kotlin.jvm.internal.q;
import r0.n;
import we.o;
import y0.k;

public final class a implements o {
    public final int a;

    public a(int v) {
        this.a = v;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        switch(this.a) {
            case 0: {
                int v1 = (int)(((Integer)object2));
                q.g(((t)object0), "$this$RepeatingButton");
                if((v1 & 6) == 0) {
                    v1 |= (((p)(((l)object1))).g(((t)object0)) ? 4 : 2);
                }
                if(((p)(((l)object1))).Q(v1 & 1, (v1 & 19) != 18)) {
                    c1.n(((t)object0).a(d.n(n.a, 28.0f), r0.d.e), 0x7F080215, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)(((l)object1))), 25008, 0, 0x7FE8);  // drawable:btn_miniplayer_back
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
            case 1: {
                int v2 = (int)(((Integer)object2));
                q.g(((t)object0), "$this$RepeatingButton");
                if((v2 & 6) == 0) {
                    v2 |= (((p)(((l)object1))).g(((t)object0)) ? 4 : 2);
                }
                if(((p)(((l)object1))).Q(v2 & 1, (v2 & 19) != 18)) {
                    c1.n(((t)object0).a(d.n(n.a, 28.0f), r0.d.e), 0x7F080216, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)(((l)object1))), 25008, 0, 0x7FE8);  // drawable:btn_miniplayer_next
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
            case 2: {
                int v3 = (int)(((Integer)object2));
                q.g(((t)object0), "$this$PressedAlphaChangeButton");
                if((v3 & 6) == 0) {
                    v3 |= (((p)(((l)object1))).g(((t)object0)) ? 4 : 2);
                }
                if(((p)(((l)object1))).Q(v3 & 1, (v3 & 19) != 18)) {
                    c1.n(((t)object0).a(d.n(androidx.compose.foundation.layout.a.n(n.a, 8.0f, 0.0f, 16.0f, 0.0f, 10), 28.0f), r0.d.e), 0x7F080219, e.Y(((p)(((l)object1))), 0x7F130B80), null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)(((l)object1))), 0x6030, 0, 0x7FE8);  // drawable:btn_miniplayer_playlist
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
            case 3: {
                int v4 = (int)(((Integer)object2));
                q.g(((t)object0), "$this$PressedAlphaChangeButton");
                if((v4 & 6) == 0) {
                    v4 |= (((p)(((l)object1))).g(((t)object0)) ? 4 : 2);
                }
                if(((p)(((l)object1))).Q(v4 & 1, (v4 & 19) != 18)) {
                    c1.n(((t)object0).a(d.n(androidx.compose.foundation.layout.a.n(n.a, 8.0f, 0.0f, 16.0f, 0.0f, 10), 28.0f), r0.d.e), 0x7F08021A, e.Y(((p)(((l)object1))), 0x7F130BC3), null, false, 0, null, null, null, 0.0f, new k(e0.T(((p)(((l)object1))), 0x7F06015D), 5), 0, 0, false, false, ((p)(((l)object1))), 0x6030, 0, 31720);  // drawable:btn_miniplayer_station_close
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
            case 4: {
                int v5 = (int)(((Integer)object2));
                q.g(((Q)object0), "sliderState");
                if((v5 & 6) == 0) {
                    v5 |= (((v5 & 8) == 0 ? ((p)(((l)object1))).g(((Q)object0)) : ((p)(((l)object1))).i(((Q)object0))) ? 4 : 2);
                }
                p p0 = (p)(((l)object1));
                if(p0.Q(v5 & 1, (v5 & 19) != 18)) {
                    E e0 = p0.N();
                    if(e0 == androidx.compose.runtime.k.a) {
                        e0 = w.i(new e3(((Q)object0), 17));
                        p0.l0(e0);
                    }
                    n n0 = n.a;
                    r0.q q0 = d.h(d.f(n0, 1.0f), 4.0f);
                    M m0 = M.p.d(r0.d.a, false);
                    int v6 = p0.P;
                    i0 i00 = p0.m();
                    r0.q q1 = r0.a.d(p0, q0);
                    P0.k.y.getClass();
                    i i0 = j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i0);
                    }
                    else {
                        p0.o0();
                    }
                    w.x(p0, m0, j.f);
                    w.x(p0, i00, j.e);
                    h h0 = j.g;
                    if(p0.O || !q.b(p0.N(), v6)) {
                        A7.d.q(v6, p0, v6, h0);
                    }
                    w.x(p0, q1, j.d);
                    M.p.a(androidx.compose.foundation.q.f(d.c(d.f(n0, 1.0f), 1.0f), e0.T(p0, 0x7F0604BB), T.e.a), p0, 0);  // color:white_10
                    M.p.a(androidx.compose.foundation.q.f(d.c(d.f(n0, ((Number)e0.getValue()).floatValue()), 1.0f), e0.T(p0, 0x7F06017A), T.e.a), p0, 0);  // color:green500e_support_high_contrast
                    p0.p(true);
                    return H.a;
                }
                p0.T();
                return H.a;
            }
            case 5: {
                int v7 = (int)(((Integer)object2));
                q.g(((t)object0), "$this$RepeatingButton");
                if(((p)(((l)object1))).Q(v7 & 1, (v7 & 17) != 16)) {
                    c1.n(d.h(d.q(n.a, 58.0f), 55.0f), 0x7F0800F0, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)(((l)object1))), 54, 0, 0x7FFC);  // drawable:btn_audio_control_back
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
            default: {
                int v = (int)(((Integer)object2));
                q.g(((t)object0), "$this$RepeatingButton");
                if(((p)(((l)object1))).Q(v & 1, (v & 17) != 16)) {
                    c1.n(d.h(d.q(n.a, 58.0f), 55.0f), 0x7F0800F1, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)(((l)object1))), 54, 0, 0x7FFC);  // drawable:btn_audio_control_next
                    return H.a;
                }
                ((p)(((l)object1))).T();
                return H.a;
            }
        }
    }
}

