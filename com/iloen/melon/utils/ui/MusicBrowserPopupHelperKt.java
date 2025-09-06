package com.iloen.melon.utils.ui;

import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.m3;
import K.m;
import M.n0;
import M.p0;
import M.y;
import P0.j;
import Q0.k0;
import T.e;
import U8.z;
import X0.i;
import a1.U;
import a1.g;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.iloen.melon.utils.StringUtils;
import ie.H;
import java.util.Arrays;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import r0.d;
import r0.n;
import r0.q;
import w0.h;
import wc.u;
import we.a;
import we.o;
import y0.M;
import y0.s;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001A\u009D\u0001\u0010\u0013\u001A\u00020\f2\b\b\u0002\u0010\u0001\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00002\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\n\u001A\u00020\t2\u0010\b\u0002\u0010\r\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B2\u0010\b\u0002\u0010\u000E\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B2\u0010\b\u0002\u0010\u000F\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000B2\u0010\b\u0002\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000BH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001A\u000F\u0010\u0014\u001A\u00020\fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"La1/g;", "text1", "text2", "Ly0/s;", "bgColor", "", "isBasicType", "showLoginButton", "isSimpleLoginAvailable", "", "simpleLoginUserId", "Lkotlin/Function0;", "Lie/H;", "onComponentShown", "onBannerClick", "onCloseClick", "onLoginClick", "FloatingBanner-Lb_0hxI", "(La1/g;La1/g;JZZZLjava/lang/String;Lwe/a;Lwe/a;Lwe/a;Lwe/a;Landroidx/compose/runtime/l;III)V", "FloatingBanner", "FloatingBannerPreview", "(Landroidx/compose/runtime/l;I)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class MusicBrowserPopupHelperKt {
    public static final void FloatingBanner-Lb_0hxI(@Nullable g g0, @Nullable g g1, long v, boolean z, boolean z1, boolean z2, @Nullable String s, @Nullable a a0, @Nullable a a1, @Nullable a a2, @Nullable a a3, @Nullable l l0, int v1, int v2, int v3) {
        boolean z7;
        a a13;
        a a12;
        long v15;
        g g7;
        g g6;
        String s2;
        a a11;
        a a10;
        boolean z6;
        a a9;
        g g5;
        g g4;
        a a8;
        int v9;
        int v8;
        int v7;
        int v6;
        boolean z4;
        boolean z3;
        long v5;
        int v4;
        p p0 = (p)l0;
        p0.c0(18407035);
        if((v3 & 1) == 0) {
            v4 = (v1 & 6) == 0 ? (p0.g(g0) ? 4 : 2) | v1 : v1;
        }
        else {
            v4 = v1 | 6;
        }
        if((v3 & 2) != 0) {
            v4 |= 0x30;
        }
        else if((v1 & 0x30) == 0) {
            v4 |= (p0.g(g1) ? 0x20 : 16);
        }
        if((v3 & 4) != 0) {
            v4 |= 0x180;
            v5 = v;
        }
        else if((v1 & 0x180) == 0) {
            v5 = v;
            v4 |= (p0.f(v5) ? 0x100 : 0x80);
        }
        else {
            v5 = v;
        }
        if((v3 & 8) != 0) {
            v4 |= 0xC00;
            z3 = z;
        }
        else if((v1 & 0xC00) == 0) {
            z3 = z;
            v4 |= (p0.h(z3) ? 0x800 : 0x400);
        }
        else {
            z3 = z;
        }
        if((v3 & 16) != 0) {
            v4 |= 0x6000;
        }
        else if((v1 & 0x6000) == 0) {
            v4 |= (p0.h(z1) ? 0x4000 : 0x2000);
        }
        if((v3 & 0x20) == 0) {
            z4 = z2;
            if((v1 & 0x30000) == 0) {
                v4 |= (p0.h(z4) ? 0x20000 : 0x10000);
            }
        }
        else {
            v4 |= 0x30000;
            z4 = z2;
        }
        if((v3 & 0x40) != 0) {
            v4 |= 0x180000;
        }
        else if((v1 & 0x180000) == 0) {
            v4 |= (p0.g(s) ? 0x100000 : 0x80000);
        }
        if((v3 & 0x80) != 0) {
            v4 |= 0xC00000;
        }
        else if((v1 & 0xC00000) == 0) {
            v4 |= (p0.i(a0) ? 0x800000 : 0x400000);
        }
        if((v3 & 0x100) != 0) {
            v4 |= 0x6000000;
            v6 = v3 & 0x100;
        }
        else if((v1 & 0x6000000) == 0) {
            v6 = v3 & 0x100;
            v4 |= (p0.i(a1) ? 0x4000000 : 0x2000000);
        }
        else {
            v6 = v3 & 0x100;
        }
        if((v3 & 0x200) != 0) {
            v4 |= 0x30000000;
            v7 = v3 & 0x200;
        }
        else if((v1 & 0x30000000) == 0) {
            v7 = v3 & 0x200;
            v4 |= (p0.i(a2) ? 0x20000000 : 0x10000000);
        }
        else {
            v7 = v3 & 0x200;
        }
        if((v3 & 0x400) != 0) {
            v8 = v2 | 6;
            v9 = v3 & 0x400;
        }
        else if((v2 & 6) == 0) {
            v9 = v3 & 0x400;
            v8 = v2 | (p0.i(a3) ? 4 : 2);
        }
        else {
            v9 = v3 & 0x400;
            v8 = v2;
        }
        String s1 = "";
        if(p0.Q(v4 & 1, (v4 & 306783379) != 306783378 || (v8 & 3) != 2)) {
            g g2 = (v3 & 1) == 0 ? g0 : new g("");
            g g3 = (v3 & 2) == 0 ? g1 : new g("");
            long v10 = (v3 & 4) == 0 ? v5 : s.b;
            if((v3 & 8) != 0) {
                z3 = false;
            }
            boolean z5 = (v3 & 16) == 0 ? z1 : true;
            if((v3 & 0x20) != 0) {
                z4 = false;
            }
            if((v3 & 0x40) == 0) {
                s1 = s;
            }
            a a4 = (v3 & 0x80) == 0 ? a0 : null;
            a a5 = v6 == 0 ? a1 : null;
            a a6 = v7 == 0 ? a2 : null;
            a a7 = v9 == 0 ? a3 : null;
            n n0 = n.a;
            q q0 = e0.L(androidx.compose.foundation.layout.a.k(n0, 20.0f, 10.0f), 0x7F0604AE);  // color:white120e
            u u0 = M.a;
            q q1 = androidx.compose.foundation.q.f(q0, v10, u0);
            f f0 = p0.N();
            if((v4 & 0x1C00000) == 0x800000 || f0 == k.a) {
                f0 = new f(a4, 6);
                p0.l0(f0);
            }
            q q2 = r0.a.a(m3.b(q1, f0), new o() {
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final q invoke(q q0, l l0, int v) {
                    kotlin.jvm.internal.q.g(q0, "$this$composed");
                    ((p)l0).a0(0x1FF03545);
                    h h0 = (h)((p)l0).k(k0.i);
                    m m0 = ((p)l0).N();
                    if(m0 == k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    i i0 = new i(0);
                    com.iloen.melon.utils.ui.MusicBrowserPopupHelperKt.FloatingBanner-Lb_0hxI..inlined.noRippleClickable-YQRRFTQ.default.1.1 musicBrowserPopupHelperKt$FloatingBanner-Lb_0hxI$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            h.a(this.d);
                            a a0 = this.b;
                            if(a0 != null) {
                                a0.invoke();
                            }
                        }
                    };
                    q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, null, i0, musicBrowserPopupHelperKt$FloatingBanner-Lb_0hxI$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            N0.M m0 = M.p.d(d.a, false);
            int v11 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            P0.i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h0 = j.f;
            w.x(p0, m0, h0);
            P0.h h1 = j.e;
            w.x(p0, i00, h1);
            P0.h h2 = j.g;
            if(p0.O) {
                a8 = a4;
                A7.d.q(v11, p0, v11, h2);
            }
            else {
                a8 = a4;
                if(!kotlin.jvm.internal.q.b(p0.N(), v11)) {
                    A7.d.q(v11, p0, v11, h2);
                }
            }
            P0.h h3 = j.d;
            w.x(p0, q3, h3);
            q q4 = androidx.compose.foundation.layout.a.m(androidx.compose.foundation.layout.d.f(n0, 1.0f), 16.0f, 16.0f, 4.0f, 16.0f);
            p0 p00 = n0.a(M.j.a, d.k, p0, 0x30);
            int v12 = p0.P;
            i0 i01 = p0.m();
            q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v12)) {
                A7.d.q(v12, p0, v12, h2);
            }
            w.x(p0, q5, h3);
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
            y y0 = M.w.a(M.j.c, d.m, p0, 0);
            int v13 = p0.P;
            i0 i02 = p0.m();
            q q6 = r0.a.d(p0, layoutWeightElement0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v13)) {
                A7.d.q(v13, p0, v13, h2);
            }
            w.x(p0, q6, h3);
            if(z4) {
                p0.a0(0xF7410ABA);
                N1.b(String.format("", Arrays.copyOf(new Object[]{StringUtils.getTrimmed(s1, 9)}, 1)), null, e0.T(p0, 0x7F0604A1), 15.0f, null, null, 0L, null, 20.0f, 0, false, 2, 0, null, null, p0, 0xC00, 0xC06, 0x1DBF2);  // color:white000e
                p0.p(false);
                g4 = g3;
                g5 = g2;
            }
            else {
                p0.a0(0xF748E0A5);
                if(z3) {
                    p0.a0(-146203095);
                    N1.a(g2, null, e0.T(p0, 0x7F0604A1), 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, null, p0, v4 & 14 | 0xC00, 0xC30, 0x3D7F2);  // color:white000e
                    p0.p(false);
                    g4 = g3;
                    g5 = g2;
                }
                else {
                    p0.a0(-145839806);
                    N1.a(g2, null, e0.T(p0, 0x7F0604A1), 15.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, null, p0, v4 & 14 | 0xC00, 0xC30, 0x3D7F2);  // color:white000e
                    g5 = g2;
                    N1.a(g3, null, e0.T(p0, 0x7F0604A1), 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, null, p0, 14 & v4 >> 3 | 0xC00, 0xC30, 0x3D7F2);  // color:white000e
                    g4 = g3;
                    p0.p(false);
                }
                p0.p(false);
            }
            p0.p(true);
            if(z5 || z4) {
                p0.a0(0x9D549A07);
                a9 = a7;
                q q7 = r0.a.a(androidx.compose.foundation.q.f(d5.n.o(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.h(n0, 32.0f), 10.0f, 0.0f, 2), e.b(16.0f)), e0.T(p0, 0x7F0604A1), u0), new o() {  // color:white000e
                    @Override  // we.o
                    public Object invoke(Object object0, Object object1, Object object2) {
                        return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
                    }

                    public final q invoke(q q0, l l0, int v) {
                        kotlin.jvm.internal.q.g(q0, "$this$composed");
                        ((p)l0).a0(0x1FF03545);
                        h h0 = (h)((p)l0).k(k0.i);
                        m m0 = ((p)l0).N();
                        if(m0 == k.a) {
                            m0 = androidx.appcompat.app.o.d(((p)l0));
                        }
                        i i0 = new i(0);
                        com.iloen.melon.utils.ui.MusicBrowserPopupHelperKt.FloatingBanner_Lb_0hxI.lambda.8.lambda.7..inlined.noRippleClickable-YQRRFTQ.default.1.1 musicBrowserPopupHelperKt$FloatingBanner_Lb_0hxI$lambda$8$lambda$7$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                h.a(this.d);
                                a a0 = this.b;
                                if(a0 != null) {
                                    a0.invoke();
                                }
                            }
                        };
                        q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, null, i0, musicBrowserPopupHelperKt$FloatingBanner_Lb_0hxI$lambda$8$lambda$7$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                        ((p)l0).p(false);
                        return q1;
                    }
                });
                N0.M m1 = M.p.d(d.e, false);
                int v14 = p0.P;
                i0 i03 = p0.m();
                q q8 = r0.a.d(p0, q7);
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m1, h0);
                w.x(p0, i03, h1);
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v14)) {
                    A7.d.q(v14, p0, v14, h2);
                }
                w.x(p0, q8, h3);
                q q9 = androidx.compose.foundation.layout.a.l(n0, 13.0f, 0.0f, 2);
                U u1 = new U(0L, 0L, null, null, 0L, null, 0, e0.N(2.0f, p0), 0xFDFFFF);
                N1.b("", q9, e0.T(p0, 0x7F060144), 13.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, u1, p0, 0x30C30, 0, 0xFFD0);  // color:gray050e
                p0.p(true);
                p0.p(false);
            }
            else {
                p0.a0(-1713222307);
                p0.p(false);
                a9 = a7;
            }
            c1.n(r0.a.a(androidx.compose.foundation.layout.d.n(n0, 28.0f), new o() {
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final q invoke(q q0, l l0, int v) {
                    kotlin.jvm.internal.q.g(q0, "$this$composed");
                    ((p)l0).a0(0x1FF03545);
                    h h0 = (h)((p)l0).k(k0.i);
                    m m0 = ((p)l0).N();
                    if(m0 == k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    i i0 = new i(0);
                    com.iloen.melon.utils.ui.MusicBrowserPopupHelperKt.FloatingBanner_Lb_0hxI.lambda.8.lambda.7..inlined.noRippleClickable-YQRRFTQ.default.2.1 musicBrowserPopupHelperKt$FloatingBanner_Lb_0hxI$lambda$8$lambda$7$$inlined$noRippleClickable-YQRRFTQ$default$2$10 = new a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            h.a(this.d);
                            a a0 = this.b;
                            if(a0 != null) {
                                a0.invoke();
                            }
                        }
                    };
                    q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, null, i0, musicBrowserPopupHelperKt$FloatingBanner_Lb_0hxI$lambda$8$lambda$7$$inlined$noRippleClickable-YQRRFTQ$default$2$10);
                    ((p)l0).p(false);
                    return q1;
                }
            }), 0x7F0801A5, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x30, 0, 0x7FFC);  // drawable:btn_floating_banner_close
            p0.p(true);
            p0.p(true);
            z6 = z5;
            a10 = a8;
            a11 = a5;
            s2 = s1;
            g6 = g5;
            g7 = g4;
            v15 = v10;
            a12 = a9;
            a13 = a6;
            z7 = z3;
        }
        else {
            p0.T();
            z6 = z1;
            a11 = a1;
            g6 = g0;
            z7 = z3;
            g7 = g1;
            v15 = v5;
            s2 = s;
            a10 = a0;
            a13 = a2;
            a12 = a3;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.utils.ui.l(g6, g7, v15, z7, z6, z4, s2, a10, a11, a13, a12, v1, v2, v3);
        }
    }

    public static final void FloatingBannerPreview(@Nullable l l0, int v) {
        ((p)l0).c0(0x8AD0F437);
        if(((p)l0).Q(v & 1, v != 0)) {
            g g0 = new g("플로팅 배너");
            g g1 = new g("플로팅 배너");
            long v1 = e0.T(((p)l0), 0x7F06017A);  // color:green500e_support_high_contrast
            p8.e e0 = ((p)l0).N();
            V v2 = k.a;
            if(e0 == v2) {
                e0 = new p8.e(24);
                ((p)l0).l0(e0);
            }
            p8.e e1 = ((p)l0).N();
            if(e1 == v2) {
                e1 = new p8.e(24);
                ((p)l0).l0(e1);
            }
            p8.e e2 = ((p)l0).N();
            if(e2 == v2) {
                e2 = new p8.e(24);
                ((p)l0).l0(e2);
            }
            MusicBrowserPopupHelperKt.FloatingBanner-Lb_0hxI(g0, g1, v1, false, true, true, null, null, e0, e1, e2, ((p)l0), 0x36036C36, 6, 0xC0);
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new z(v, 19, 0);
        }
    }
}

