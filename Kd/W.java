package kd;

import Cc.N1;
import Cc.e0;
import Cc.g1;
import M.n0;
import M.p0;
import N0.M;
import P0.h;
import P0.i;
import P0.j;
import P0.k;
import T.e;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.y;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ed.D;
import ie.H;
import kotlin.jvm.internal.q;
import r0.d;
import r0.n;
import we.a;
import we.o;

public final class w implements o {
    public final a a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final b0 e;
    public final b0 f;
    public final b0 g;
    public final a h;
    public final a i;

    public w(a a0, boolean z, boolean z1, int v, b0 b00, b0 b01, b0 b02, a a1, a a2) {
        this.a = a0;
        this.b = z;
        this.c = z1;
        this.d = v;
        this.e = b00;
        this.f = b01;
        this.g = b02;
        this.h = a1;
        this.i = a2;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        i i2;
        p p1;
        h h6;
        h h5;
        h h4;
        n n1;
        int v2;
        int v = (int)(((Integer)object2));
        r0.i i0 = d.f;
        q.g(((we.n)object0), "innerTextField");
        if((v & 6) == 0) {
            v |= (((p)(((l)object1))).i(((we.n)object0)) ? 4 : 2);
        }
        p p0 = (p)(((l)object1));
        if(p0.Q(v & 1, (v & 19) != 18)) {
            n n0 = n.a;
            r0.q q0 = d5.n.o(androidx.compose.foundation.layout.d.f(n0, 1.0f), e.b(20.0f));
            y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F0604B2), 1.0f);  // color:white300e_support_high_contrast
            T.d d0 = e.b(20.0f);
            r0.q q1 = r0.a.a(androidx.compose.foundation.layout.a.m(androidx.compose.foundation.q.j(q0, y0.a, y0.b, d0), 16.0f, 12.0f, 16.0f, 11.0f), new D(17, this.a));
            M m0 = M.p.d(d.d, false);
            int v1 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            k.y.getClass();
            i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            androidx.compose.runtime.w.x(p0, m0, h0);
            h h1 = j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !q.b(p0.N(), v1)) {
                A7.d.q(v1, p0, v1, h2);
            }
            h h3 = j.d;
            androidx.compose.runtime.w.x(p0, q2, h3);
            if(this.b) {
                b0 b00 = this.g;
                b b0 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
                if(this.c || this.d <= 5 || !((Boolean)this.e.getValue()).booleanValue()) {
                    v2 = v;
                    n1 = n0;
                    h4 = h1;
                    h5 = h2;
                    h6 = h0;
                    p1 = p0;
                    i2 = i1;
                    if(((String)b00.getValue()).length() == 0) {
                        p1.a0(0x5A76DBF0);
                        F.b(H0.e.Y(p1, 0x7F130734), p1, 0);  // string:music_wave_input_message "채팅을 입력해주세요."
                    }
                    else if(Tf.o.e1(((String)b00.getValue())).toString().length() == 0) {
                        p1.a0(0x5A79C02F);
                    }
                    else {
                        p1.a0(1518016163);
                        String s1 = H0.e.Y(p1, 0x7F13074A);  // string:music_wave_send_message "보내기"
                        long v4 = e0.T(p1, 0x7F060179);  // color:green490e
                        N1.b(s1, r0.a.a(b0.a(n1, i0), new g1(this.h, this.i, 6)), v4, 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p1, 0xC00, 0, 0x1FFF0);
                    }
                }
                else {
                    p0.a0(1517047041);
                    String s = (String)this.f.getValue();
                    v2 = v;
                    long v3 = e0.T(p0, 0x7F0604B7);  // color:white700e
                    h5 = h2;
                    h6 = h0;
                    h4 = h1;
                    n1 = n0;
                    i2 = i1;
                    N1.b(s, b0.a(androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 16.0f, 0.0f, 11), i0), v3, 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);
                    p1 = p0;
                    if(((String)b00.getValue()).length() == 0) {
                        p1.a0(0x5A738504);
                        F.b(H0.e.Y(p1, 0x7F130734), p1, 0);  // string:music_wave_input_message "채팅을 입력해주세요."
                    }
                    else {
                        p1.a0(0x59C10D8E);
                    }
                    p1.p(false);
                }
                p1.p(false);
            }
            else {
                p0.a0(0x5A68738B);
                F.b(H0.e.Y(p0, 0x7F13071D), p0, 0);  // string:music_wave_chat_not_available "채팅이 불가능합니다."
                p0.p(false);
                v2 = v;
                n1 = n0;
                h4 = h1;
                h5 = h2;
                h6 = h0;
                p1 = p0;
                i2 = i1;
            }
            r0.q q3 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.f(n1, 1.0f), 0.0f, 0.0f, 66.0f, 0.0f, 11);
            p0 p00 = n0.a(M.j.a, d.j, p1, 0);
            int v5 = p1.P;
            i0 i01 = p1.m();
            r0.q q4 = r0.a.d(p1, q3);
            p1.e0();
            if(p1.O) {
                p1.l(i2);
            }
            else {
                p1.o0();
            }
            androidx.compose.runtime.w.x(p1, p00, h6);
            androidx.compose.runtime.w.x(p1, i01, h4);
            if(p1.O || !q.b(p1.N(), v5)) {
                A7.d.q(v5, p1, v5, h5);
            }
            androidx.compose.runtime.w.x(p1, q4, h3);
            ((we.n)object0).invoke(p1, ((int)(v2 & 14)));
            p1.p(true);
            p1.p(true);
            return H.a;
        }
        p0.T();
        return H.a;
    }
}

