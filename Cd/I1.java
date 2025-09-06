package cd;

import Bd.x;
import Cc.c1;
import Cc.q0;
import M.c;
import M.g;
import M.j0;
import M.j;
import M.y;
import Nc.Y;
import O.F;
import O.I;
import P0.h;
import P0.i;
import Zc.N;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import b9.a;
import bd.s;
import com.google.firebase.b;
import com.iloen.melon.net.v4x.common.HeaderBase;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINECONTENT;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import r0.n;

public abstract class i1 {
    public static final void a(String s, b1 b10, l l0, int v) {
        ((p)l0).c0(0x5FCFBC39);
        int v1 = (((p)l0).g(s) ? 4 : 2) | v | (((p)l0).i(b10) ? 0x20 : 16);
        boolean z = false;
        if(((p)l0).Q(v1 & 1, (v1 & 19) != 18)) {
            MAGAZINECONTENT mainMusicRes$RESPONSE$MAGAZINECONTENT0 = b10.a;
            String s1 = mainMusicRes$RESPONSE$MAGAZINECONTENT0.getImgUrl();
            String s2 = "";
            if(s1 == null) {
                s1 = "";
            }
            String s3 = mainMusicRes$RESPONSE$MAGAZINECONTENT0.getTitle() == null ? "" : mainMusicRes$RESPONSE$MAGAZINECONTENT0.getTitle();
            String s4 = mainMusicRes$RESPONSE$MAGAZINECONTENT0.getSubTitle();
            if(s4 != null) {
                s2 = s4;
            }
            boolean z1 = ((p)l0).i(b10);
            a a0 = ((p)l0).N();
            V v2 = k.a;
            if(z1 || a0 == v2) {
                a0 = new a(b10, 11);
                ((p)l0).l0(a0);
            }
            boolean z2 = ((p)l0).i(b10);
            if((v1 & 14) == 4) {
                z = true;
            }
            N n0 = ((p)l0).N();
            if(z2 || z || n0 == v2) {
                n0 = new N(4, b10, s);
                ((p)l0).l0(n0);
            }
            q0.b(s1, s3, null, null, s2, null, null, false, null, 255.0f, 0.0f, 0x7F08064B, 0.0f, 0.0f, 2, 1, null, a0, null, n0, null, 0, false, ((p)l0), 0x30000000, 0x36030, 16070124);  // drawable:img_magazine_logo_01
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new Y(s, b10, v, 26);
        }
    }

    public static final void b(j1 j10, l l0, int v) {
        b0 b02;
        q.g(j10, "uiState");
        Object object0 = j10.b;
        p p0 = (p)l0;
        p0.c0(596165270);
        int v1 = (p0.i(j10) ? 4 : 2) | v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            b0 b00 = p0.N();
            V v2 = k.a;
            if(b00 == v2) {
                b00 = w.s(((List)object0).get(0));
                p0.l0(b00);
            }
            b0 b01 = p0.N();
            if(b01 == v2) {
                b01 = w.s(((List)j10.c).get(0));
                p0.l0(b01);
            }
            F f0 = I.a(0, 0, 3, p0);
            CoroutineScope coroutineScope0 = p0.N();
            if(coroutineScope0 == v2) {
                coroutineScope0 = J.i(p0);
                p0.l0(coroutineScope0);
            }
            n n0 = n.a;
            r0.q q0 = d.f(n0, 1.0f);
            y y0 = M.w.a(j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q1, P0.j.d);
            HeaderBase headerBase0 = j10.a == null ? null : j10.a.a;
            if(headerBase0 == null) {
                p0.a0(0x603D338F);
            }
            else {
                p0.a0(0x603D3390);
                boolean z = p0.i(j10);
                f1 f10 = p0.N();
                if(z || f10 == v2) {
                    f10 = new f1(j10, 0);
                    p0.l0(f10);
                }
                boolean z1 = p0.i(j10);
                f1 f11 = p0.N();
                if(z1 || f11 == v2) {
                    f11 = new f1(j10, 1);
                    p0.l0(f11);
                }
                b.j(new s(headerBase0, f10, f11, null, 0x4FE), p0, 0);
            }
            p0.p(false);
            c.d(p0, d.h(n0, 3.0f));
            boolean z2 = p0.i(j10);
            boolean z3 = p0.i(coroutineScope0);
            boolean z4 = p0.g(f0);
            x x0 = p0.N();
            if((z2 | z3 | z4) == 0 && x0 != v2) {
                b02 = b01;
            }
            else {
                b02 = b01;
                x x1 = new x(b00, j10, b02, coroutineScope0, f0, 3);
                p0.l0(x1);
                x0 = x1;
            }
            c1.N(((List)object0), null, 0, null, x0, p0, 0x180, 10);
            c.d(p0, d.h(n0, 12.0f));
            g g0 = j.h(12.0f);
            j0 j00 = androidx.compose.foundation.layout.a.a(20.0f, 0.0f, 2);
            Cc.i1 i10 = p0.N();
            if(i10 == v2) {
                i10 = new Cc.i1(b02, b00, 1);
                p0.l0(i10);
            }
            c1.q(null, f0, j00, g0, null, null, false, i10, p0, 0x6006180, 0xE9);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Zc.c(j10, v, 21);
        }
    }
}

