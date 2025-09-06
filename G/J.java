package G;

import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import we.k;

public abstract class j {
    public static final a0 a;

    static {
        j.a = f.q(0.0f, 7, null);
        f.q(0.0f, 3, new r1.f(0.1f));
    }

    public static final b1 a(float f, x0 x00, String s, l l0) {
        return j.c(new r1.f(f), z0.c, x00, null, s, null, l0, 0x6000, 8);
    }

    public static final b1 b(float f, o o0, String s, k k0, l l0, int v, int v1) {
        a0 a00 = j.a;
        if((v1 & 2) != 0) {
            o0 = a00;
        }
        if((v1 & 8) != 0) {
            s = "FloatAnimation";
        }
        if((v1 & 16) != 0) {
            k0 = null;
        }
        if(o0 == a00) {
            ((p)l0).a0(0x4316AAD7);
            boolean z = ((p)l0).d(0.01f);
            a0 a01 = ((p)l0).N();
            if(z || a01 == androidx.compose.runtime.k.a) {
                a01 = f.q(0.0f, 3, 0.01f);
                ((p)l0).l0(a01);
            }
            ((p)l0).p(false);
            return j.c(f, z0.a, a01, 0.01f, s, k0, l0, v << 3 & 0x7E000, 0);
        }
        ((p)l0).a0(0x4318583D);
        ((p)l0).p(false);
        return j.c(f, z0.a, o0, 0.01f, s, k0, l0, v << 3 & 0x7E000, 0);
    }

    public static final b1 c(Object object0, y0 y00, o o0, Float float0, String s, k k0, l l0, int v, int v1) {
        if((v1 & 8) != 0) {
            float0 = null;
        }
        p p0 = (p)l0;
        b0 b00 = p0.N();
        V v2 = androidx.compose.runtime.k.a;
        if(b00 == v2) {
            b00 = w.s(null);
            p0.l0(b00);
        }
        e e0 = p0.N();
        if(e0 == v2) {
            e0 = new e(object0, y00, float0, s);
            p0.l0(e0);
        }
        b0 b01 = w.w(k0, p0);
        if(float0 != null && o0 instanceof a0 && !q.b(((a0)o0).c, float0)) {
            o0 = new a0(((a0)o0).a, ((a0)o0).b, float0);
        }
        b0 b02 = w.w(o0, p0);
        Channel channel0 = p0.N();
        if(channel0 == v2) {
            channel0 = ChannelKt.Channel$default(-1, null, null, 6, null);
            p0.l0(channel0);
        }
        boolean z = p0.i(channel0);
        boolean z1 = p0.i(object0);
        g g0 = p0.N();
        if(z || z1 || g0 == v2) {
            g0 = new g(0, channel0, object0);
            p0.l0(g0);
        }
        J.h(g0, p0);
        boolean z2 = p0.i(channel0);
        boolean z3 = p0.i(e0);
        boolean z4 = p0.g(b02);
        boolean z5 = p0.g(b01);
        i i0 = p0.N();
        if((z2 | z3 | z4 | z5) != 0 || i0 == v2) {
            i i1 = new i(channel0, e0, b02, b01, null);
            p0.l0(i1);
            i0 = i1;
        }
        J.d(p0, channel0, i0);
        b1 b10 = (b1)b00.getValue();
        return b10 == null ? e0.c : b10;
    }
}

