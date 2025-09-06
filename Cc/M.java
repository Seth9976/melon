package Cc;

import Bc.d;
import N0.M;
import P0.h;
import P0.j;
import T.e;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec.Asset;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import r0.i;
import r0.n;
import r0.q;
import we.a;

public abstract class m {
    public static final void a(String s, float f, float f1, float f2, a a0, l l0, int v, int v1) {
        float f3;
        p p0 = (p)l0;
        p0.c0(0x1212D06F);
        int v2 = (v & 6) == 0 ? (p0.g(s) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.d(f) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.d(f1) ? 0x100 : 0x80);
        }
        if((v1 & 8) != 0) {
            v2 |= 0xC00;
        }
        else if((v & 0xC00) == 0) {
            v2 |= (p0.d(f2) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v2 |= (p0.i(a0) ? 0x4000 : 0x2000);
        }
        if(p0.Q((v2 | 0x30000) & 1, (74899 & (v2 | 0x30000)) != 74898)) {
            f3 = (v1 & 8) == 0 ? f2 : 0.5f;
            LottieCompositionResult lottieCompositionResult0 = RememberLottieCompositionKt.rememberLottieComposition(Asset.box-impl("animation/artist_pick_circle.json"), null, null, null, null, null, p0, 6, 62);
            d d0 = p0.N();
            if(((v2 | 0x30000) & 0xE000) == 0x4000 || d0 == k.a) {
                d0 = new d(1, a0);
                p0.l0(d0);
            }
            n n0 = n.a;
            q q0 = androidx.compose.foundation.q.n(n0, null, d0, 7);
            i i0 = r0.d.e;
            M m0 = M.p.d(i0, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
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
            q q2 = androidx.compose.foundation.layout.d.n(n0, f);
            LottieAnimationKt.LottieAnimation(((LottieComposition)lottieCompositionResult0.getValue()), q2, false, false, null, 0.0f, 0, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, p0, 0, 0, 0, 0x3FFFFC);
            q q3 = d5.n.o(androidx.compose.foundation.layout.d.n(n0, f1), e.a);
            q q4 = androidx.compose.foundation.q.i(f3, e0.T(p0, 0x7F0604AA), q3, e.a);  // color:white000s_support_high_contrast
            c1.n((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q4, i0), s, "", N0.j.b, false, 0x7F0807A2, null, null, null, 0.0f, null, 0, 0, false, false, p0, (v2 | 0x30000) << 3 & 0x70 | 0x30C00, 0, 0x7FD0);  // drawable:noimage_person_xmini
            p0.p(true);
        }
        else {
            p0.T();
            f3 = f2;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Cc.l(s, f, f1, f3, a0, v, v1);
        }
    }
}

