package Fc;

import Cc.c1;
import Cc.e0;
import M.c;
import P0.h;
import P0.j;
import P0.k;
import android.net.Uri;
import android.text.Html;
import androidx.compose.foundation.layout.d;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.w;
import com.iloen.melon.lyric.LyricsInfo;
import ie.H;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.r;
import r0.n;
import r0.q;
import we.p;
import y0.M;

public final class i extends r implements p {
    public final int f;
    public final List g;
    public final List h;

    public i(List list0, int v, List list1) {
        this.f = v;
        this.g = list0;
        this.h = list1;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        if(this.f != 0) {
            int v = ((Number)object1).intValue();
            int v1 = ((Number)object3).intValue();
            int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v1 : v1;
            if((v1 & 0x30) == 0) {
                v2 |= (((androidx.compose.runtime.p)(((l)object2))).e(v) ? 0x20 : 16);
            }
            androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)(((l)object2));
            if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                Object object4 = this.g.get(v);
                p0.a0(0xF10B6433);
                n n0 = n.a;
                if(v == 0) {
                    p0.a0(0xF10B38F7);
                    c.d(p0, d.c(d.q(n0, 30.0f), 1.0f));
                }
                else {
                    p0.a0(0xF0B32BD9);
                }
                p0.p(false);
                q q0 = androidx.compose.foundation.q.f(e0.M(d.h(d.s(n0, 0.0f, 240.0f, 1), 240.0f), 0x7F06014A, 6.0f), e0.T(p0, 0x7F060141), M.a);  // color:gray100a
                N0.M m0 = M.p.d(r0.d.e, false);
                int v3 = p0.P;
                i0 i00 = p0.m();
                q q1 = r0.a.d(p0, q0);
                k.y.getClass();
                P0.i i0 = j.b;
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
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h0);
                }
                w.x(p0, q1, j.d);
                c1.n(null, ((Uri)object4), null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0, 0, 0x7FFD);
                p0.p(true);
                if(v == this.h.size() - 1) {
                    p0.a0(-250076585);
                    c.d(p0, d.c(d.q(n0, 30.0f), 1.0f));
                }
                else {
                    p0.a0(0xF0B32BD9);
                }
                p0.p(false);
                p0.p(false);
                return H.a;
            }
            p0.T();
            return H.a;
        }
        int v4 = ((Number)object1).intValue();
        int v5 = ((Number)object3).intValue();
        int v6 = (v5 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v5 : v5;
        if((v5 & 0x30) == 0) {
            v6 |= (((androidx.compose.runtime.p)(((l)object2))).e(v4) ? 0x20 : 16);
        }
        if(((androidx.compose.runtime.p)(((l)object2))).Q(v6 & 1, (v6 & 0x93) != 0x92)) {
            LyricsInfo lyricsInfo0 = (LyricsInfo)this.g.get(v4);
            ((androidx.compose.runtime.p)(((l)object2))).a0(0xEA94179E);
            Pattern pattern0 = Pattern.compile("\n");
            kotlin.jvm.internal.q.f(pattern0, "compile(...)");
            kotlin.jvm.internal.q.g(lyricsInfo0.b, "input");
            String s = pattern0.matcher(lyricsInfo0.b).replaceAll("<br>");
            kotlin.jvm.internal.q.f(s, "replaceAll(...)");
            E9.h.b(Html.fromHtml(s, 0).toString(), false, v4 == this.h.size() - 1, false, ((androidx.compose.runtime.p)(((l)object2))), 0x30, 8);
            ((androidx.compose.runtime.p)(((l)object2))).p(false);
            return H.a;
        }
        ((androidx.compose.runtime.p)(((l)object2))).T();
        return H.a;
    }
}

