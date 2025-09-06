package qd;

import Cc.e0;
import M.v;
import O.F;
import O.I;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.c;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.ui.input.nestedscroll.a;
import com.iloen.melon.lyric.LyricsInfo;
import d9.h;
import e1.m;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;
import r0.n;
import we.k;
import we.o;

public final class x implements o {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final h d;
    public final b0 e;
    public final k f;
    public final a0 g;
    public final b0 h;
    public final b0 i;

    public x(boolean z, boolean z1, boolean z2, h h0, b0 b00, k k0, a0 a00, b0 b01, b0 b02) {
        this.a = z;
        this.b = z1;
        this.c = z2;
        this.d = h0;
        this.e = b00;
        this.f = k0;
        this.g = a00;
        this.h = b01;
        this.i = b02;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        h h1;
        b0 b03;
        int v = (int)(((Integer)object2));
        q.g(((v)object0), "$this$BoxWithConstraints");
        if((v & 6) == 0) {
            v |= (((p)(((l)object1))).g(((v)object0)) ? 4 : 2);
        }
        p p0 = (p)(((l)object1));
        if(p0.Q(v & 1, (v & 19) != 18)) {
            F f0 = I.a(0, 0, 3, p0);
            if(this.a) {
                p0.a0(1025472405);
                r0.q q0 = n.a;
                b0 b00 = this.e;
                a0 a00 = this.g;
                List list0 = w.a;
                if(!this.b || this.c) {
                    p0.a0(1025440940);
                    FillElement fillElement1 = d.c;
                    if(((c)(((v)object0))).b() > 100.0f) {
                        p0.a0(1025670061);
                        q0 = e0.S(q0, f0, E9.h.t(p0, 0x7F070410));  // dimen:player_lyric_view_expended_fading_height
                    }
                    else {
                        p0.a0(0x3D27068A);
                    }
                    p0.p(false);
                    r0.q q2 = fillElement1.then(q0);
                    List list2 = (List)b00.getValue();
                    if(list2 != null) {
                        list0 = new ArrayList(je.q.Q(10, list2));
                        for(Object object3: list2) {
                            ((ArrayList)list0).add(((LyricsInfo)object3).b);
                        }
                    }
                    qd.I.e(q2, f0, list0, qd.I.f(((K0)a00).m()), p0, 0);
                }
                else {
                    p0.a0(0x3D2D2F8B);
                    h h0 = this.d;
                    b0 b01 = m.x(h0.h, p0);
                    E e0 = p0.N();
                    b0 b02 = this.h;
                    V v1 = androidx.compose.runtime.k.a;
                    if(e0 == v1) {
                        e0 = new E(b02);
                        p0.l0(e0);
                    }
                    if(((Boolean)b02.getValue()).booleanValue()) {
                        p0.a0(1026864925);
                        Integer integer0 = (Integer)b01.getValue();
                        boolean z = p0.g(b00);
                        boolean z1 = p0.g(b01);
                        boolean z2 = p0.g(f0);
                        D d0 = p0.N();
                        if((z | z1 | ((v & 14) == 4 ? 1 : 0) | z2) != 0 || d0 == v1) {
                            h1 = h0;
                            b03 = b01;
                            D d1 = new D(b00, b03, ((v)object0), f0, null);
                            p0.l0(d1);
                            d0 = d1;
                        }
                        else {
                            b03 = b01;
                            h1 = h0;
                        }
                        J.d(p0, integer0, d0);
                    }
                    else {
                        b03 = b01;
                        h1 = h0;
                        p0.a0(1019767258);
                    }
                    p0.p(false);
                    FillElement fillElement0 = d.c;
                    if(((c)(((v)object0))).b() > 100.0f) {
                        p0.a0(0x3D46024D);
                        q0 = e0.S(q0, f0, E9.h.t(p0, 0x7F070410));  // dimen:player_lyric_view_expended_fading_height
                    }
                    else {
                        p0.a0(1028295978);
                    }
                    p0.p(false);
                    r0.q q1 = a.a(fillElement0.then(q0), e0, null);
                    List list1 = (List)b00.getValue();
                    if(list1 != null) {
                        list0 = je.p.P0(list1);
                    }
                    qd.J j0 = qd.I.f(((K0)a00).m());
                    Integer integer1 = (Integer)b03.getValue();
                    qd.I.c(q1, f0, list0, j0, (integer1 == null ? 0 : ((int)integer1)), ((Boolean)this.i.getValue()).booleanValue(), h1, this.f, p0, 0);
                }
                p0.p(false);
            }
            else {
                p0.a0(1019767258);
            }
            p0.p(false);
            return H.a;
        }
        p0.T();
        return H.a;
    }
}

