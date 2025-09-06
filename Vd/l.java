package vd;

import Cc.N1;
import Cc.e0;
import M.y;
import N0.M;
import P0.h;
import P0.i;
import P0.j;
import a1.g;
import a1.t;
import android.content.Context;
import androidx.compose.foundation.Q0;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.a;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.E;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ie.H;
import r0.q;
import r1.c;
import r1.f;
import rd.S;
import wc.u;
import we.n;
import y0.s;

public final class l implements n {
    public final int a;
    public final float b;
    public final float c;
    public final b0 d;
    public final b0 e;
    public final Object f;

    public l(float f, float f1, b0 b00, b0 b01, b0 b02) {
        this.a = 0;
        super();
        this.b = f;
        this.c = f1;
        this.d = b00;
        this.e = b01;
        this.f = b02;
    }

    public l(float f, float f1, c c0, b0 b00, b0 b01, Context context0) {
        this.a = 1;
        super();
        this.b = f;
        this.c = f1;
        this.f = c0;
        this.d = b00;
        this.e = b01;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        b0 b01;
        H h0 = H.a;
        V v0 = k.a;
        b b0 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
        Object object2 = this.f;
        if(this.a != 0) {
            int v1 = (int)(((Integer)object1));
            p p0 = (p)(((androidx.compose.runtime.l)object0));
            if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
                q q0 = a.n(r0.n.a, 0.0f, 0.0f, 0.0f, this.b, 7);
                r0.n n0 = r0.n.a;
                float f = this.c;
                q q1 = d.j(q0, 0.0f, f, 1);
                M m0 = M.p.d(r0.d.a, false);
                int v2 = p0.P;
                i0 i00 = p0.m();
                q q2 = r0.a.d(p0, q1);
                P0.k.y.getClass();
                i i0 = j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                h h1 = j.f;
                w.x(p0, m0, h1);
                h h2 = j.e;
                w.x(p0, i00, h2);
                h h3 = j.g;
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                    A7.d.q(v2, p0, v2, h3);
                }
                h h4 = j.d;
                w.x(p0, q2, h4);
                Q0 q00 = androidx.compose.foundation.q.t(p0);
                E e0 = p0.N();
                if(e0 == v0) {
                    e0 = w.i(new S(q00, 3));
                    p0.l0(e0);
                }
                q q3 = androidx.compose.foundation.q.x(d.f(n0, 1.0f), q00, false, 14);
                boolean z = p0.g(((c)object2));
                gd.d d0 = p0.N();
                b0 b00 = this.e;
                if(z || d0 == v0) {
                    b01 = b00;
                    d0 = new gd.d(((c)object2), f, this.d, b01, 1);
                    p0.l0(d0);
                }
                else {
                    b01 = b00;
                }
                q q4 = androidx.compose.ui.layout.a.f(q3, d0);
                y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
                int v3 = p0.P;
                i0 i01 = p0.m();
                q q5 = r0.a.d(p0, q4);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, y0, h1);
                w.x(p0, i01, h2);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h3);
                }
                w.x(p0, q5, h4);
                N1.b("", n0, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // color:gray900s
                long v4 = e0.T(p0, 0x7F06016D);  // color:gray900s
                N1.b("", a.n(n0, 0.0f, 12.0f, 0.0f, 0.0f, 13), v4, 15.0f, null, null, 0L, null, 21.0f, 0, false, 0, 0, null, null, p0, 0xC30, 6, 0x1FBF0);
                long v5 = e0.T(p0, 0x7F060160);  // color:gray600s_support_high_contrast
                N1.b("", a.n(n0, 0.0f, 18.0f, 0.0f, 0.0f, 13), v5, 12.0f, null, null, 0L, null, 18.0f, 0, false, 0, 0, null, null, p0, 0xC30, 6, 0x1FBF0);
                p0.a0(0x3195AEE8);
                p0.p(false);
                M.c.d(p0, d.h(n0, 26.0f));
                p0.p(true);
                if(!((Boolean)b01.getValue()).booleanValue() || !((Boolean)e0.getValue()).booleanValue()) {
                    p0.a0(0x6B17F432);
                }
                else {
                    p0.a0(0x6BA4FBB1);
                    M.p.a(b0.a(androidx.compose.foundation.q.e(d.h(d.f(n0, 1.0f), 60.0f), u.f(e.k.A(new s[]{new s(e0.T(p0, 0x7F06048A)), new s(e0.T(p0, 0x7F0604AB))}), 0.0f, 0.0f, 14), null, 6), r0.d.h), p0, 0);  // color:transparent
                }
                p0.p(false);
                p0.p(true);
                return h0;
            }
            p0.T();
            return h0;
        }
        int v6 = (int)(((Integer)object1));
        p p1 = (p)(((androidx.compose.runtime.l)object0));
        if(p1.Q(v6 & 1, (v6 & 3) != 2)) {
            r0.n n1 = r0.n.a;
            q q6 = d.j(d.f(a.n(n1, 0.0f, 0.0f, 0.0f, this.b, 7), 1.0f), 0.0f, this.c, 1);
            M m1 = M.p.d(r0.d.a, false);
            int v7 = p1.P;
            i0 i02 = p1.m();
            q q7 = r0.a.d(p1, q6);
            P0.k.y.getClass();
            i i1 = j.b;
            p1.e0();
            if(p1.O) {
                p1.l(i1);
            }
            else {
                p1.o0();
            }
            h h5 = j.f;
            w.x(p1, m1, h5);
            h h6 = j.e;
            w.x(p1, i02, h6);
            h h7 = j.g;
            if(p1.O || !kotlin.jvm.internal.q.b(p1.N(), v7)) {
                A7.d.q(v7, p1, v7, h7);
            }
            h h8 = j.d;
            w.x(p1, q7, h8);
            Q0 q01 = androidx.compose.foundation.q.t(p1);
            E e1 = p1.N();
            if(e1 == v0) {
                e1 = w.i(new S(q01, 1));
                p1.l0(e1);
            }
            q q8 = androidx.compose.foundation.q.x(d.f(n1, 1.0f), q01, false, 14);
            vd.k k0 = p1.N();
            if(k0 == v0) {
                k0 = new vd.k(this.d, 1);
                p1.l0(k0);
            }
            q q9 = androidx.compose.ui.layout.a.f(q8, k0);
            y y1 = M.w.a(M.j.c, r0.d.n, p1, 0x30);
            int v8 = p1.P;
            i0 i03 = p1.m();
            q q10 = r0.a.d(p1, q9);
            p1.e0();
            if(p1.O) {
                p1.l(i1);
            }
            else {
                p1.o0();
            }
            w.x(p1, y1, h5);
            w.x(p1, i03, h6);
            if(p1.O || !kotlin.jvm.internal.q.b(p1.N(), v8)) {
                A7.d.q(v8, p1, v8, h7);
            }
            w.x(p1, q10, h8);
            Context context0 = (Context)p1.k(AndroidCompositionLocals_androidKt.b);
            q q11 = d.f(n1, 1.0f);
            kotlin.jvm.internal.q.f("글 작성 시 주의사항", "getString(...)");
            float f1 = ((f)this.e.getValue()).a;
            N1.b("글 작성 시 주의사항", q11, e0.T(p1, 0x7F060165), f1, null, null, 0L, new l1.k(5), 0.0f, 0, false, 0, 0, null, null, p1, 0x30, 0, 0x1FDF0);  // color:gray800s
            M.c.d(p1, d.h(n1, 9.0f));
            kotlin.jvm.internal.q.f("1. 욕설, 비방, 음란성, 도배글 등 다른 고객님들께 불쾌감을 주는 글은 사전고지 없이 삭제될 수 있습니다.", "getString(...)");
            float f2 = ((f)this.e.getValue()).a;
            N1.b("1. 욕설, 비방, 음란성, 도배글 등 다른 고객님들께 불쾌감을 주는 글은 사전고지 없이 삭제될 수 있습니다.", null, e0.T(p1, 0x7F060165), f2, null, null, 0L, new l1.k(5), 21.0f, 0, false, 0, 0, null, null, p1, 0, 6, 0x1F9F2);  // color:gray800s
            M.c.d(p1, d.h(n1, 9.0f));
            kotlin.jvm.internal.q.f("2. 게시된 글의 저작권은 글을 작성한 회원에게 있으며 게시물로 인해 발생하는 문제는 게시자 본인에게 책임이 있습니다.", "getString(...)");
            float f3 = ((f)this.e.getValue()).a;
            N1.b("2. 게시된 글의 저작권은 글을 작성한 회원에게 있으며 게시물로 인해 발생하는 문제는 게시자 본인에게 책임이 있습니다.", null, e0.T(p1, 0x7F060165), f3, null, null, 0L, new l1.k(5), 21.0f, 0, false, 0, 0, null, null, p1, 0, 6, 0x1F9F2);  // color:gray800s
            M.c.d(p1, d.h(n1, 9.0f));
            kotlin.jvm.internal.q.f("3. 게시판에 고객님의 <u>연락처, 주소 등의 개인정보가 포함된 글</u>을 올리실 경우에는 타인에게 해당 정보가 노출될 수 있으니 게재를 삼가 하여 주시기 바랍니다.", "getString(...)");
            g g0 = t.h("3. 게시판에 고객님의 <u>연락처, 주소 등의 개인정보가 포함된 글</u>을 올리실 경우에는 타인에게 해당 정보가 노출될 수 있으니 게재를 삼가 하여 주시기 바랍니다.", null, 6);
            float f4 = ((f)this.e.getValue()).a;
            N1.a(g0, null, e0.T(p1, 0x7F060165), f4, null, null, 0L, new l1.k(5), 21.0f, 0, false, 0, 0, null, null, null, p1, 0, 6, 0x3F9F2);  // color:gray800s
            M.c.d(p1, d.h(n1, 26.0f));
            p1.p(true);
            if(!((Boolean)((b0)object2).getValue()).booleanValue() || !((Boolean)e1.getValue()).booleanValue()) {
                p1.a0(0x68C3E92A);
            }
            else {
                p1.a0(1779964905);
                M.p.a(b0.a(androidx.compose.foundation.q.e(d.h(d.f(n1, 1.0f), 60.0f), u.f(e.k.A(new s[]{new s(e0.T(p1, 0x7F06048A)), new s(e0.T(p1, 0x7F0604AB))}), 0.0f, 0.0f, 14), null, 6), r0.d.h), p1, 0);  // color:transparent
            }
            p1.p(false);
            p1.p(true);
            return h0;
        }
        p1.T();
        return h0;
    }
}

