package com.iloen.melon.fragments.melonchart.ui;

import Cc.N1;
import Cc.c1;
import Cc.e0;
import K.m;
import M.n0;
import M.p0;
import M.y;
import P0.j;
import Q0.k0;
import T.d;
import T.e;
import Tf.v;
import U4.x;
import U8.z;
import Vb.i;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.utils.color.ColorUtils;
import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;
import r0.n;
import w0.h;
import we.a;
import we.o;
import y0.M;
import y0.s;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001AU\u0010\t\u001A\u00020\u00072\b\u0010\u0001\u001A\u0004\u0018\u00010\u00002\b\u0010\u0002\u001A\u0004\u0018\u00010\u00002\b\u0010\u0003\u001A\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00002\u000E\b\u0002\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¢\u0006\u0004\b\t\u0010\n\u001A\u000F\u0010\u000B\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"", "text1", "text2", "imgUrl", "imgAltText", "bgColor", "Lkotlin/Function0;", "Lie/H;", "onClick", "Hot100Banner", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lwe/a;Landroidx/compose/runtime/l;II)V", "Hot100BannerPreview", "(Landroidx/compose/runtime/l;I)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class Hot100BannerKt {
    public static final void Hot100Banner(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable a a0, @Nullable l l0, int v, int v1) {
        a a2;
        String s8;
        long v3;
        a a1;
        String s5;
        p p0 = (p)l0;
        p0.c0(0x215AF064);
        int v2 = (v & 6) == 0 ? (p0.g(s) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.g(s1) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.g(s2) ? 0x100 : 0x80);
        }
        if((v1 & 8) != 0) {
            v2 |= 0xC00;
            s5 = s3;
        }
        else if((v & 0xC00) == 0) {
            s5 = s3;
            v2 |= (p0.g(s5) ? 0x800 : 0x400);
        }
        else {
            s5 = s3;
        }
        if((v1 & 16) != 0) {
            v2 |= 0x6000;
        }
        else if((v & 0x6000) == 0) {
            v2 |= (p0.g(s4) ? 0x4000 : 0x2000);
        }
        if((v1 & 0x20) != 0) {
            v2 |= 0x30000;
        }
        else if((0x30000 & v) == 0) {
            v2 |= (p0.i(a0) ? 0x20000 : 0x10000);
        }
        if(p0.Q(v2 & 1, (74899 & v2) != 74898)) {
            String s6 = (v1 & 8) == 0 ? s5 : "배너";
            String s7 = (v1 & 16) == 0 ? s4 : "";
            if((v1 & 0x20) == 0) {
                a1 = a0;
            }
            else {
                i i0 = p0.N();
                if(i0 == k.a) {
                    i0 = new i(28);
                    p0.l0(i0);
                }
                a1 = i0;
            }
            try {
                q.d(s7);
                v3 = M.c(ColorUtils.getColorFromHexStr((v.r0(s7, "#", false) ? s7 : "#" + s7)));
            }
            catch(Exception unused_ex) {
                v3 = s.f;
            }
            d d0 = e.b(4.0f);
            n n0 = n.a;
            r0.q q0 = d5.n.o(androidx.compose.foundation.layout.d.c(androidx.compose.foundation.layout.d.f(n0, 1.0f), 1.0f), d0);
            r0.q q1 = r0.a.a(androidx.compose.foundation.q.f(androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F06014A), q0, d0), v3, M.a), new o() {  // color:gray100a
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final r0.q invoke(r0.q q0, l l0, int v) {
                    q.g(q0, "$this$composed");
                    ((p)l0).a0(0x1FF03545);
                    h h0 = (h)((p)l0).k(k0.i);
                    m m0 = ((p)l0).N();
                    if(m0 == k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    X0.i i0 = new X0.i(0);
                    com.iloen.melon.fragments.melonchart.ui.Hot100BannerKt.Hot100Banner..inlined.noRippleClickable-YQRRFTQ.default.1.1 hot100BannerKt$Hot100Banner$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            h.a(this.$onClick$inlined);
                            this.$onClick$inlined.invoke();
                        }
                    };
                    r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, s6, i0, hot100BannerKt$Hot100Banner$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            N0.M m0 = M.p.d(r0.d.a, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            P0.i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            P0.h h0 = j.f;
            w.x(p0, m0, h0);
            P0.h h1 = j.e;
            w.x(p0, i00, h1);
            P0.h h2 = j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            P0.h h3 = j.d;
            w.x(p0, q2, h3);
            r0.q q3 = androidx.compose.foundation.layout.a.n(androidx.compose.foundation.layout.d.c(androidx.compose.foundation.layout.d.f(n0, 1.0f), 1.0f), 20.0f, 0.0f, 5.0f, 0.0f, 10);
            p0 p00 = n0.a(M.j.a, r0.d.j, p0, 0);
            int v5 = p0.P;
            i0 i01 = p0.m();
            r0.q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q4, h3);
            r0.q q5 = androidx.compose.foundation.layout.d.c(androidx.compose.foundation.layout.d.f(n0, 1.0f).then(new LayoutWeightElement(1.0f, true)), 1.0f);
            y y0 = M.w.a(M.j.e, r0.d.m, p0, 6);
            int v6 = p0.P;
            i0 i02 = p0.m();
            r0.q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            w.x(p0, q6, h3);
            N1.b((s == null ? "" : s), x.s(n0, 1.0f, p0, n0, 1.0f), e0.T(p0, 0x7F06017A), 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);  // color:green500e_support_high_contrast
            N1.b((s1 == null ? "" : s1), x.s(n0, 4.0f, p0, n0, 1.0f), e0.T(p0, 0x7F0604A1), 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);  // color:white000e
            p0.p(true);
            c1.m(androidx.compose.foundation.layout.d.n(n0, 64.0f), s2, null, N0.j.b, false, 0, 0, null, 0.0f, null, null, null, p0, v2 >> 3 & 0x70 | 0x6C06, 0, 0x1FE4);
            p0.p(true);
            p0.p(true);
            s8 = s7;
            s5 = s6;
            a2 = a1;
        }
        else {
            p0.T();
            a2 = a0;
            s8 = s4;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = (l l0, int v2) -> Hot100BannerKt.Hot100Banner$lambda$6(s, s1, s2, s5, s8, a2, v, v1, l0, v2);
        }
    }

    private static final H Hot100Banner$lambda$1$lambda$0() {
        return H.a;
    }

    private static final H Hot100Banner$lambda$6(String s, String s1, String s2, String s3, String s4, a a0, int v, int v1, l l0, int v2) {
        Hot100BannerKt.Hot100Banner(s, s1, s2, s3, s4, a0, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)), v1);
        return H.a;
    }

    public static final void Hot100BannerPreview(@Nullable l l0, int v) {
        ((p)l0).c0(0x254B2BFB);
        if(((p)l0).Q(v & 1, v != 0)) {
            Hot100BannerKt.Hot100Banner("HOT100 그래프", "100일 내 발매곡의 실시간 정보", "https://sandbox-cdnimg.melon.co.kr/svc/images/bn/202304261009418364.jpg/melon/optimize/90", null, "#320EC4", null, ((p)l0), 25014, 40);
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new z(v, 4, 0);
        }
    }

    private static final H Hot100BannerPreview$lambda$7(int v, l l0, int v1) {
        Hot100BannerKt.Hot100BannerPreview(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    public static H b(int v, l l0, int v1) {
        return Hot100BannerKt.Hot100BannerPreview$lambda$7(v, l0, v1);
    }

    // 检测为 Lambda 实现
    public static H c(String s, String s1, String s2, String s3, String s4, a a0, int v, int v1, l l0, int v2) [...]
}

