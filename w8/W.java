package w8;

import B2.h;
import B2.n;
import J2.s;
import V4.u;
import a.a;
import android.content.Context;
import android.net.Uri;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.iloen.melon.playback.Playable;
import ie.H;
import kc.s2;
import kotlin.jvm.internal.q;
import m0.b;
import m0.c;
import ob.z;
import we.o;

public final class w implements o {
    public final A a;
    public final s2 b;
    public final z c;
    public final int d;
    public final boolean e;
    public final boolean f;

    public w(A a0, s2 s20, z z0, int v, boolean z1, boolean z2) {
        this.a = a0;
        this.b = s20;
        this.c = z0;
        this.d = v;
        this.e = z1;
        this.f = z2;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        z z5;
        ((Integer)object2).getClass();
        q.g(((s)object0), "$this$Row");
        p p0 = (p)(((l)object1));
        Object object3 = p0.k(h.b);
        b0 b00 = p0.N();
        V v0 = k.a;
        if(b00 == v0) {
            b00 = androidx.compose.runtime.w.s(null);
            p0.l0(b00);
        }
        b0 b01 = p0.N();
        if(b01 == v0) {
            b01 = androidx.compose.runtime.w.s(null);
            p0.l0(b01);
        }
        b0 b02 = p0.N();
        if(b02 == v0) {
            b02 = androidx.compose.runtime.w.s("");
            p0.l0(b02);
        }
        b0 b03 = p0.N();
        if(b03 == v0) {
            b03 = androidx.compose.runtime.w.s(null);
            p0.l0(b03);
        }
        b0 b04 = p0.N();
        if(b04 == v0) {
            b04 = androidx.compose.runtime.w.s(Boolean.FALSE);
            p0.l0(b04);
        }
        b0 b05 = p0.N();
        if(b05 == v0) {
            b05 = androidx.compose.runtime.w.s(Boolean.FALSE);
            p0.l0(b05);
        }
        b0 b06 = p0.N();
        if(b06 == v0) {
            b06 = androidx.compose.runtime.w.s(Boolean.FALSE);
            p0.l0(b06);
        }
        b0 b07 = p0.N();
        if(b07 == v0) {
            b07 = androidx.compose.runtime.w.s(Boolean.TRUE);
            p0.l0(b07);
        }
        s2 s20 = this.b;
        Object object4 = androidx.compose.runtime.w.e(w0.p(s20, p0), "", null, p0, 0x30, 2).getValue();
        boolean z = p0.i(s20);
        boolean z1 = p0.i(((Context)object3));
        z z2 = this.c;
        boolean z3 = p0.i(z2);
        w8.z z4 = p0.N();
        if((z | z1 | z3) != 0 || z4 == v0) {
            w8.z z6 = new w8.z(s20, ((Context)object3), z2, b00, b01, b02, b03, b04, b05, b06, b07, null);
            z5 = z2;
            p0.l0(z6);
            z4 = z6;
        }
        else {
            z5 = z2;
        }
        J.d(p0, object4, z4);
        Object object5 = b01.getValue();
        Object object6 = b03.getValue();
        boolean z7 = ((Boolean)b04.getValue()).booleanValue();
        this.a.o(((Playable)object5), ((Uri)object6), z7, ((float)this.d), this.e, false, p0, 0, 0x20);
        a.i(u.J(B2.l.a, 8.0f), p0, 0);
        n n0 = u.n(B2.l.a);
        b b0 = c.e(0x6CBA0D68, p0, new x(this.f, this.a, z5, s20, this.e, b02, b05, b06, b07));
        P4.a.a(n0, !this.f, 0, b0, p0, 0xC00, 4);
        return H.a;
    }
}

