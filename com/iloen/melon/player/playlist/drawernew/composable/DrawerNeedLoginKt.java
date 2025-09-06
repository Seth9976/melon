package com.iloen.melon.player.playlist.drawernew.composable;

import Cc.N1;
import Cc.e0;
import H0.e;
import K.m;
import M.c;
import M.y;
import N0.M;
import P0.h;
import P0.i;
import P0.j;
import P0.k;
import Q0.k0;
import U4.x;
import U8.z;
import androidx.compose.foundation.Q0;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.utils.Navigator;
import ie.H;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import r0.a;
import r0.n;
import r0.q;
import r8.f;
import we.o;
import y0.s;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u000F\u0010\u0001\u001A\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lie/H;", "DrawerNeedLogin", "(Landroidx/compose/runtime/l;I)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerNeedLoginKt {
    public static final void DrawerNeedLogin(@Nullable l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0xF931FECA);
        if(p0.Q(v & 1, v != 0)) {
            n n0 = n.a;
            q q0 = d.f(n0, 1.0f);
            M m0 = M.p.d(r0.d.a, false);
            int v1 = p0.P;
            i0 i00 = p0.m();
            q q1 = a.d(p0, q0);
            k.y.getClass();
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v1)) {
                A7.d.q(v1, p0, v1, h2);
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            Q0 q00 = androidx.compose.foundation.q.t(p0);
            q q2 = androidx.compose.foundation.q.x(d.t(androidx.compose.foundation.q.f(n0, s.f, y0.M.a), 2), q00, false, 14);
            y y0 = M.w.a(M.j.c, r0.d.n, p0, 0x30);
            int v2 = p0.P;
            i0 i01 = p0.m();
            q q3 = a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            w.x(p0, q3, h3);
            q q4 = x.s(n0, 142.0f, p0, n0, 1.0f);
            N1.b(e.Y(p0, 0x7F1308D0), q4, e0.T(p0, 0x7F0604B7), 15.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FDF0);  // string:required_login "로그인이 필요한 서비스입니다."
            c.d(p0, d.h(n0, 20.0f));
            String s = e.Y(p0, 0x7F13051D);  // string:login "로그인"
            long v3 = e0.T(p0, 0x7F0604A1);  // color:white000e
            q q5 = d.h(d.q(n0, 69.0f), 36.0f);
            androidx.compose.foundation.y y1 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F0604B1), 0.5f);  // color:white220e
            T.d d0 = T.e.b(21.0f);
            N1.b(s, a.a(d.t(androidx.compose.foundation.q.j(q5, y1.a, y1.b, d0), 2), new o() {
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final q invoke(q q0, l l0, int v) {
                    kotlin.jvm.internal.q.g(q0, "$this$composed");
                    ((p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((p)l0).k(k0.i);
                    m m0 = ((p)l0).N();
                    if(m0 == androidx.compose.runtime.k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    X0.i i0 = new X0.i(0);
                    com.iloen.melon.player.playlist.drawernew.composable.DrawerNeedLoginKt.DrawerNeedLogin.lambda.2.lambda.1..inlined.noRippleClickable-YQRRFTQ.default.1.1 drawerNeedLoginKt$DrawerNeedLogin$lambda$2$lambda$1$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new we.a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(this.a);
                            Navigator.openLoginView(f.f);
                        }
                    };
                    q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, null, i0, drawerNeedLoginKt$DrawerNeedLogin$lambda$2$lambda$1$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            }), v3, 14.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF0);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new z(v, 13, 0);
        }
    }
}

