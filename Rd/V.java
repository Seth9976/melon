package rd;

import Cc.a0;
import Cc.c1;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ed.D;
import ie.H;
import kotlin.jvm.internal.r;
import ud.q;
import ud.s;
import we.a;
import we.n;
import x1.e;
import x1.j;

public final class v extends r implements n {
    public final int f;
    public final b0 g;
    public final j h;
    public final a i;
    public final a j;
    public final n k;
    public final boolean l;
    public final a m;
    public final n n;
    public final a o;
    public final a r;
    public final a w;

    public v(b0 b00, j j0, a a0, a a1, a a2, n n0, boolean z, a a3, a a4, n n1, a a5) {
        this.f = 0;
        this.g = b00;
        this.h = j0;
        this.i = a0;
        this.j = a1;
        this.m = a2;
        this.k = n0;
        this.l = z;
        this.o = a3;
        this.r = a4;
        this.n = n1;
        this.w = a5;
        super(2);
    }

    public v(b0 b00, j j0, a a0, a a1, n n0, boolean z, a a2, n n1, a a3, a a4, a a5) {
        this.f = 1;
        this.g = b00;
        this.h = j0;
        this.i = a0;
        this.j = a1;
        this.k = n0;
        this.l = z;
        this.m = a2;
        this.n = n1;
        this.o = a3;
        this.r = a4;
        this.w = a5;
        super(2);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        V v2;
        a a2;
        e e5;
        if(this.f != 0) {
            H h0 = H.a;
            if((((Number)object1).intValue() & 3) == 2 && ((p)(((l)object0))).D()) {
                ((p)(((l)object0))).T();
                return h0;
            }
            this.g.setValue(h0);
            j j0 = this.h;
            int v = j0.b;
            j0.h();
            ((p)(((l)object0))).a0(0xB1B4DCE1);
            wa.a a0 = j0.f();
            e e0 = ((j)a0.a).e();
            e e1 = ((j)a0.a).e();
            e e2 = ((j)a0.a).e();
            e e3 = ((j)a0.a).e();
            e e4 = ((j)a0.a).e();
            q q0 = ((p)(((l)object0))).N();
            V v1 = k.a;
            if(q0 == v1) {
                q0 = q.b;
                ((p)(((l)object0))).l0(q0);
            }
            r0.n n0 = r0.n.a;
            r0.q q1 = j.b(n0, e0, q0);
            String s = H0.e.Y(((p)(((l)object0))), 0x7F130BD4);  // string:talkback_player_prev "이전곡"
            String s1 = H0.e.Y(((p)(((l)object0))), 0x7F130BC2);  // string:talkback_player_change_to_prev "이전곡으로 변경"
            String s2 = H0.e.Y(((p)(((l)object0))), 0x7F130BD8);  // string:talkback_player_rewind "뒤로감기"
            a a1 = this.j;
            boolean z = ((p)(((l)object0))).g(a1);
            Af.k k0 = ((p)(((l)object0))).N();
            if(z || k0 == v1) {
                e5 = e1;
                k0 = new Af.k(8, a1);
                ((p)(((l)object0))).l0(k0);
            }
            else {
                e5 = e1;
            }
            n n1 = this.k;
            boolean z1 = ((p)(((l)object0))).g(n1);
            ud.r r0 = ((p)(((l)object0))).N();
            if(z1 || r0 == v1) {
                a2 = k0;
                r0 = new ud.r(n1, 1);
                ((p)(((l)object0))).l0(r0);
            }
            else {
                a2 = k0;
            }
            c1.K(q1, a2, r0, 0L, 0.0f, s, s1, s2, ud.a.b, ((p)(((l)object0))), 0x6000000, 24);
            r0.q q2 = r0.a.a(d.h(d.q(n0, 58.0f), 55.0f), new D(29, this.o));
            boolean z2 = ((p)(((l)object0))).g(e0);
            boolean z3 = ((p)(((l)object0))).g(e2);
            rd.p p0 = ((p)(((l)object0))).N();
            if(z2 || z3 || p0 == v1) {
                p0 = new rd.p(e0, e2, 24);
                ((p)(((l)object0))).l0(p0);
            }
            c1.n(j.b(q2, e5, p0), 0x7F0800F5, H0.e.Y(((p)(((l)object0))), 0x7F130BDA), null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)(((l)object0))), 0x30, 0, 0x7FF8);  // drawable:btn_audio_control_seek_prev
            boolean z4 = this.l;
            r0.q q3 = r0.a.a(d.h(d.q(n0, 58.0f), 55.0f), new s(0, this.r));
            q q4 = ((p)(((l)object0))).N();
            if(q4 == v1) {
                q4 = q.d;
                ((p)(((l)object0))).l0(q4);
            }
            c1.n(j.b(q3, e2, q4), ((int)(z4 ? 0x7F0800F2 : 0x7F0800F3)), H0.e.Y(((p)(((l)object0))), (z4 ? 0x7F130BD2 : 0x7F130BD3)), null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)(((l)object0))), 0, 0, 0x7FF8);  // drawable:btn_audio_control_pause
            r0.q q5 = r0.a.a(d.h(d.q(n0, 58.0f), 55.0f), new s(1, this.w));
            boolean z5 = ((p)(((l)object0))).g(e2);
            boolean z6 = ((p)(((l)object0))).g(e4);
            rd.p p1 = ((p)(((l)object0))).N();
            if(z5 || z6) {
                v2 = v1;
                p1 = new rd.p(e2, e4, 25);
                ((p)(((l)object0))).l0(p1);
            }
            else {
                v2 = v1;
                if(p1 == v2) {
                    p1 = new rd.p(e2, e4, 25);
                    ((p)(((l)object0))).l0(p1);
                }
            }
            c1.n(j.b(q5, e3, p1), 0x7F0800F4, H0.e.Y(((p)(((l)object0))), 0x7F130BD9), null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((p)(((l)object0))), 0x30, 0, 0x7FF8);  // drawable:btn_audio_control_seek_next
            q q6 = ((p)(((l)object0))).N();
            if(q6 == v2) {
                q6 = q.c;
                ((p)(((l)object0))).l0(q6);
            }
            r0.q q7 = j.b(n0, e4, q6);
            String s3 = H0.e.Y(((p)(((l)object0))), 0x7F130BD0);  // string:talkback_player_next "다음곡"
            String s4 = H0.e.Y(((p)(((l)object0))), 0x7F130BC1);  // string:talkback_player_change_to_next "다음곡으로 변경"
            String s5 = H0.e.Y(((p)(((l)object0))), 0x7F130BC9);  // string:talkback_player_fast_forward "빨리감기"
            a a3 = this.m;
            boolean z7 = ((p)(((l)object0))).g(a3);
            Af.k k1 = ((p)(((l)object0))).N();
            if(z7 || k1 == v2) {
                k1 = new Af.k(7, a3);
                ((p)(((l)object0))).l0(k1);
            }
            n n2 = this.n;
            boolean z8 = ((p)(((l)object0))).g(n2);
            ud.r r1 = ((p)(((l)object0))).N();
            if(z8 || r1 == v2) {
                r1 = new ud.r(n2, 0);
                ((p)(((l)object0))).l0(r1);
            }
            c1.K(q7, k1, r1, 0L, 0.0f, s3, s4, s5, ud.a.c, ((p)(((l)object0))), 0x6000000, 24);
            ((p)(((l)object0))).p(false);
            if(j0.b != v) {
                J.h(this.i, ((p)(((l)object0))));
            }
            return h0;
        }
        H h1 = H.a;
        if((((Number)object1).intValue() & 3) == 2 && ((p)(((l)object0))).D()) {
            ((p)(((l)object0))).T();
            return h1;
        }
        this.g.setValue(h1);
        j j1 = this.h;
        int v3 = j1.b;
        j1.h();
        p p2 = (p)(((l)object0));
        p2.a0(-1470920590);
        wa.a a4 = j1.f();
        e e6 = ((j)a4.a).e();
        e e7 = ((j)a4.a).e();
        e e8 = ((j)a4.a).e();
        e e9 = ((j)a4.a).e();
        e e10 = ((j)a4.a).e();
        rd.j j2 = p2.N();
        V v4 = k.a;
        if(j2 == v4) {
            j2 = rd.j.g;
            p2.l0(j2);
        }
        r0.n n3 = r0.n.a;
        x.a(r0.a.a(j.b(n3, e6, j2), new a0(0, 0, H0.e.Y(p2, 0x7F130B12), this.j, true)), p2, 0);  // string:talkback_dj_malrang_bad_button_click_label "다음 곡으로 넘어가며 다음번 추천곡 재생 시 해당 곡 
                                                                                                  // 제외"
        boolean z9 = p2.g(e6);
        boolean z10 = p2.g(e8);
        rd.p p3 = p2.N();
        if(z9 || z10 || p3 == v4) {
            p3 = new rd.p(e6, e8, 8);
            p2.l0(p3);
        }
        c1.E(j.b(n3, e7, p3), this.m, this.k, p2, 0);
        rd.j j3 = p2.N();
        if(j3 == v4) {
            j3 = rd.j.h;
            p2.l0(j3);
        }
        c1.z(0, p2, j.b(n3, e8, j3), this.o, this.l);
        boolean z11 = p2.g(e8);
        boolean z12 = p2.g(e10);
        rd.p p4 = p2.N();
        if(z11 || z12 || p4 == v4) {
            p4 = new rd.p(e8, e10, 9);
            p2.l0(p4);
        }
        c1.x(j.b(n3, e9, p4), this.r, this.n, p2, 0);
        rd.j j4 = p2.N();
        if(j4 == v4) {
            j4 = rd.j.i;
            p2.l0(j4);
        }
        x.e(r0.a.a(j.b(n3, e10, j4), new a0(0, 0, H0.e.Y(p2, 0x7F130B14), this.w, true)), p2, 0);  // string:talkback_dj_malrang_good_button_click_label "다음 번 추천곡 재생 시 참고하여 반영"
        p2.p(false);
        if(j1.b != v3) {
            J.h(this.i, p2);
        }
        return h1;
    }
}

