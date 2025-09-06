package com.iloen.melon.popup;

import Cc.N1;
import Cc.c1;
import Cc.e0;
import De.I;
import K.m;
import M.c;
import M.n0;
import M.p0;
import M.y;
import P0.h;
import P0.i;
import P0.j;
import P0.k;
import Q0.k0;
import T.e;
import U8.z;
import android.content.res.Configuration;
import androidx.compose.foundation.Q0;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.foundation.q;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.custom.l1;
import ie.H;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import r0.g;
import r0.n;
import wc.u;
import we.a;
import we.o;
import y0.M;
import y0.s;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001A3\u0010\u0004\u001A\u00020\u00012\u0010\b\u0002\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00002\u0010\b\u0002\u0010\u0003\u001A\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001A\u000F\u0010\u0006\u001A\u00020\u0001H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/Function0;", "Lie/H;", "onBannerButtonClick", "onCloseButtonClick", "BottomSheetDialogScreen", "(Lwe/a;Lwe/a;Landroidx/compose/runtime/l;II)V", "PreviewMalrangServiceGuidePopup", "(Landroidx/compose/runtime/l;I)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class MalrangServiceGuidePopupKt {
    public static final void BottomSheetDialogScreen(@Nullable a a0, @Nullable a a1, @Nullable l l0, int v, int v1) {
        a a6;
        a a5;
        a a4;
        a a3;
        a a2;
        int v2;
        p p0 = (p)l0;
        p0.c0(0x12306F5E);
        if((v1 & 1) != 0) {
            v2 = v | 6;
            a2 = a0;
        }
        else if((v & 6) == 0) {
            a2 = a0;
            v2 = v | (p0.i(a2) ? 4 : 2);
        }
        else {
            a2 = a0;
            v2 = v;
        }
        if((v1 & 2) != 0) {
            v2 |= 0x30;
            a3 = a1;
        }
        else if((v & 0x30) == 0) {
            a3 = a1;
            v2 |= (p0.i(a3) ? 0x20 : 16);
        }
        else {
            a3 = a1;
        }
        if(p0.Q(v2 & 1, (v2 & 19) != 18)) {
            if((v1 & 1) != 0) {
                a2 = null;
            }
            if((v1 & 2) != 0) {
                a3 = null;
            }
            int v3 = ((Configuration)p0.k(AndroidCompositionLocals_androidKt.a)).orientation;
            Q0 q00 = q.t(p0);
            n n0 = n.a;
            r0.q q0 = q.f(d5.n.o(d.h(d.f(n0, 1.0f), 454.0f), e.d(12.0f, 12.0f, 0.0f, 0.0f, 12)), e0.T(p0, 0x7F0604AB), M.a);  // color:white001s
            N0.M m0 = M.p.d(r0.d.a, false);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            k.y.getClass();
            u u0 = M.a;
            i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            r0.q q2 = androidx.compose.foundation.layout.a.m(q.x(d.f(n0, 1.0f), q00, v3 == 2, 12), 20.0f, 32.0f, 20.0f, 10.0f);
            g g0 = r0.d.n;
            M.d d0 = M.j.c;
            y y0 = M.w.a(d0, g0, p0, 0x30);
            int v5 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            w.x(p0, q3, h3);
            p0 p00 = n0.a(M.j.a, r0.d.j, p0, 0x30);
            int v6 = p0.P;
            i0 i02 = p0.m();
            r0.q q4 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            w.x(p0, q4, h3);
            N1.b(l1.s(n0, 29.0f, p0, 0x7F13032C, p0), null, e0.T(p0, 0x7F06016D), 22.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);  // string:dj_malrang_guide_popup_title "DJ 말랑이"
            c.d(p0, d.q(n0, 3.0f));
            c1.n(d.n(n0, 26.0f), 0x7F0805B5, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:ic_popup_beta
            l1.y(p0, true, n0, 10.0f, p0);
            N1.b(H0.e.Y(p0, 0x7F13032B), null, e0.T(p0, 0x7F06016D), 16.0f, null, null, 0L, new l1.k(3), 23.0f, 0, false, 0, 0, null, null, p0, 0xC00, 6, 0x1F9F2);  // string:dj_malrang_guide_popup_description "어떤 음악을 들을지 고민될땐 내 취향의\n음악을 추천해주는 DJ 말랑이를 
                                                                                                                                                                     // 만나보세요!"
            c.d(p0, d.h(n0, 24.0f));
            c1.n(d.h(d.q(n0, 280.0f), 240.0f), 0x7F08066D, null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC36, 0, 0x7FF4);  // drawable:img_popup_simple
            A7.d.v(n0, 68.0f, p0, true);
            r0.q q5 = androidx.compose.foundation.layout.a.n(d.f(n0, 1.0f), 20.0f, 0.0f, 20.0f, 0.0f, 10);
            b b0 = (b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            r0.q q6 = b0.a(q5, r0.d.h);
            y y1 = M.w.a(d0, g0, p0, 0x30);
            int v7 = p0.P;
            i0 i03 = p0.m();
            r0.q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y1, h0);
            w.x(p0, i03, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h2);
            }
            w.x(p0, q7, h3);
            r0.q q8 = d.h(d.f(n0, 1.0f), 40.0f);
            int v8 = 0x7F06048A;  // color:transparent
            s s0 = new s(e0.T(p0, 0x7F06048A));  // color:transparent
            if(q00.d()) {
                v8 = 0x7F0604AB;  // color:white001s
            }
            c.d(p0, q.e(q8, u.f(e.k.A(new s[]{s0, new s(e0.T(p0, v8))}), 0.0f, 0.0f, 14), null, 6));
            r0.q q9 = d.h(d.f(n0, 1.0f), 48.0f);
            Z.j j0 = Z.a.a(e0.T(p0, 0x7F06017A), p0, 0, 14);  // color:green500e_support_high_contrast
            com.iloen.melon.popup.e e0 = p0.N();
            if((v2 & 14) == 4 || e0 == androidx.compose.runtime.k.a) {
                a4 = a2;
                e0 = new com.iloen.melon.popup.e(3, a4);
                p0.l0(e0);
            }
            else {
                a4 = a2;
            }
            H0.e.b(e0, q9, false, null, null, j0, null, ComposableSingletons.MalrangServiceGuidePopupKt.INSTANCE.getLambda$-147550719$app_playstoreProdRelease(), p0, 0x30000030, 380);
            c.d(p0, q.f(d.f(d.h(n0, (v3 == 2 ? 16.0f : 20.0f)), 1.0f), e0.T(p0, 0x7F0604AB), u0));  // color:white001s
            p0.p(true);
            r0.q q10 = r0.a.a(b0.a(androidx.compose.foundation.layout.a.j(d.h(d.q(n0, 50.0f), 54.0f), 4.0f), r0.d.c), new o() {
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final r0.q invoke(r0.q q0, l l0, int v) {
                    kotlin.jvm.internal.q.g(q0, "$this$composed");
                    ((p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((p)l0).k(k0.i);
                    m m0 = ((p)l0).N();
                    if(m0 == androidx.compose.runtime.k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    X0.i i0 = new X0.i(0);
                    com.iloen.melon.popup.MalrangServiceGuidePopupKt.BottomSheetDialogScreen.lambda.6..inlined.noRippleClickable-YQRRFTQ.default.1.1 malrangServiceGuidePopupKt$BottomSheetDialogScreen$lambda$6$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(this.d);
                            a a0 = this.b;
                            if(a0 != null) {
                                a0.invoke();
                            }
                        }
                    };
                    r0.q q1 = q.l(q0, m0, null, true, null, i0, malrangServiceGuidePopupKt$BottomSheetDialogScreen$lambda$6$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            q.c(I.Q(0x7F0801D1, p0, 6), H0.e.Y(p0, 0x7F130AE8), q10, null, null, 0.0f, new y0.k(e0.T(p0, 0x7F06016D), 5), p0, 0, 56);  // drawable:btn_gnb_close_w
            p0.p(true);
            a5 = a3;
            a6 = a4;
        }
        else {
            p0.T();
            a6 = a2;
            a5 = a3;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.music.s(a6, a5, v, v1, 1);
        }
    }

    public static final void PreviewMalrangServiceGuidePopup(@Nullable l l0, int v) {
        ((p)l0).c0(0xFB1044D1);
        if(((p)l0).Q(v & 1, v != 0)) {
            MalrangServiceGuidePopupKt.BottomSheetDialogScreen(null, null, ((p)l0), 0, 3);
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new z(v, 18, 0);
        }
    }
}

