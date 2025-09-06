package com.iloen.melon.player.playlist.common;

import Cc.H3;
import Cc.J0;
import Cc.N1;
import Cc.a0;
import Cc.c1;
import Cc.e0;
import De.I;
import H0.e;
import K.m;
import M.c;
import M.j;
import M.n0;
import M.p0;
import N0.M;
import P0.h;
import P0.i;
import Q0.k0;
import android.content.Context;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionSpec.Asset;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.artistchannel.viewholder.f;
import com.iloen.melon.playback.playlist.db.d;
import e1.F;
import ie.H;
import kotlin.Metadata;
import oc.c0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.n;
import r0.q;
import we.a;
import we.o;
import y0.s;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001AC\u0010\n\u001A\u00020\b2\b\b\u0002\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00042\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000B\u001A3\u0010\u0010\u001A\u00020\b2\u0006\u0010\r\u001A\u00020\f2\f\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001A/\u0010\u0013\u001A\u00020\b2\b\b\u0002\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0012\u001A\u00020\u00042\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001A/\u0010\u0018\u001A\u00020\b2\b\b\u0002\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0016\u001A\u00020\u00152\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001C²\u0006\u000E\u0010\u001B\u001A\u0004\u0018\u00010\u001A8\nX\u008A\u0084\u0002"}, d2 = {"Lr0/q;", "modifier", "", "isSelected", "", "textWhenUnselected", "textWhenSelected", "Lkotlin/Function0;", "Lie/H;", "onClick", "AllSelectButton", "(Lr0/q;ZLjava/lang/String;Ljava/lang/String;Lwe/a;Landroidx/compose/runtime/l;II)V", "Loc/c0;", "sectionSelectState", "onSectionSelectButtonClick", "onCancelClick", "SectionSelectButton", "(Loc/c0;Lwe/a;Lwe/a;Landroidx/compose/runtime/l;I)V", "orderText", "SortButton", "(Lr0/q;Ljava/lang/String;Lwe/a;Landroidx/compose/runtime/l;II)V", "LIb/b;", "offlineState", "action", "OfflineButton", "(Lr0/q;LIb/b;Lwe/a;Landroidx/compose/runtime/l;II)V", "Lcom/airbnb/lottie/LottieComposition;", "circleComposition", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistCommonHeaderComposableKt {
    public static final void AllSelectButton(@Nullable q q0, boolean z, @Nullable String s, @Nullable String s1, @NotNull a a0, @Nullable l l0, int v, int v1) {
        q q5;
        String s8;
        String s7;
        String s4;
        int v4;
        String s3;
        q q1;
        int v3;
        String s2;
        int v2;
        kotlin.jvm.internal.q.g(a0, "onClick");
        p p0 = (p)l0;
        p0.c0(0xFFBE28DA);
        if((v1 & 1) == 0) {
            v2 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        }
        else {
            v2 = v | 6;
        }
        if((v & 0x30) == 0) {
            v2 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            if((v1 & 4) == 0) {
                s2 = s;
                v3 = p0.g(s2) ? 0x100 : 0x80;
            }
            else {
                s2 = s;
                v3 = 0x80;
            }
            v2 |= v3;
        }
        else {
            s2 = s;
        }
        if((v & 0xC00) == 0) {
            v2 |= ((v1 & 8) != 0 || !p0.g(s1) ? 0x400 : 0x800);
        }
        if((v & 0x6000) == 0) {
            v2 |= (p0.i(a0) ? 0x4000 : 0x2000);
        }
        if(p0.Q(v2 & 1, (v2 & 9363) != 9362)) {
            p0.V();
            n n0 = n.a;
            if((v & 1) == 0 || p0.B()) {
                q q2 = (v1 & 1) == 0 ? q0 : n0;
                if((v1 & 4) != 0) {
                    s2 = e.Y(p0, 0x7F130914);  // string:select_all "전체선택"
                    v2 &= -897;
                }
                if((v1 & 8) == 0) {
                    s3 = s1;
                    q1 = q2;
                    v4 = v2;
                    s4 = s2;
                }
                else {
                    v4 = v2 & 0xFFFFE3FF;
                    s4 = s2;
                    s3 = e.Y(p0, 0x7F1310D9);  // string:unselect_selection "선택해제"
                    q1 = q2;
                }
            }
            else {
                p0.T();
                if((v1 & 4) != 0) {
                    v2 &= -897;
                }
                if((v1 & 8) != 0) {
                    v2 &= 0xFFFFE3FF;
                }
                q1 = q0;
                s3 = s1;
                v4 = v2;
                s4 = s2;
            }
            p0.q();
            String s5 = z ? l1.h(p0, 303609317, 0x7F130C7A, p0, false) : l1.h(p0, 0x1219D087, 0x7F130C41, p0, false);  // string:talkback_unselect_all "전체선택해제"
            String s6 = z ? s3 : s4;
            boolean z1 = p0.g(s6);
            d d0 = p0.N();
            V v5 = k.a;
            if(z1 || d0 == v5) {
                d0 = new d(s6, 5);
                p0.l0(d0);
            }
            q q3 = r0.a.a(X0.n.c(q1, true, d0), new a0(0, 0, s5, a0, true));
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v6 = p0.P;
            i0 i00 = p0.m();
            q q4 = r0.a.d(p0, q3);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h0);
            }
            w.x(p0, q4, P0.j.d);
            c.d(p0, androidx.compose.foundation.layout.d.q(n0, 20.0f));
            e0.k(androidx.compose.foundation.layout.d.n(n0, 18.0f), z, p0, v4 & 0x70 | 6);
            c.d(p0, androidx.compose.foundation.layout.d.q(n0, 8.0f));
            f f0 = p0.N();
            if(f0 == v5) {
                f0 = new f(29);
                p0.l0(f0);
            }
            N1.b(s6, X0.n.b(n0, f0), e0.T(p0, 0x7F0604A1), 14.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);  // color:white000e
            p0.p(true);
            s7 = s4;
            s8 = s3;
            q5 = q1;
        }
        else {
            p0.T();
            q5 = q0;
            s8 = s1;
            s7 = s2;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new b(q5, z, s7, s8, a0, v, v1);
        }
    }

    public static final void OfflineButton(@Nullable q q0, @NotNull Ib.b b0, @NotNull a a0, @Nullable l l0, int v, int v1) {
        q q10;
        boolean z1;
        s s2;
        int v4;
        s s0;
        int v3;
        int v2;
        r0.i i0 = r0.d.f;
        kotlin.jvm.internal.q.g(b0, "offlineState");
        kotlin.jvm.internal.q.g(a0, "action");
        p p0 = (p)l0;
        p0.c0(0x1409F572);
        if((v1 & 1) == 0) {
            v2 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        }
        else {
            v2 = v | 6;
        }
        if((v & 0x30) == 0) {
            v2 |= (p0.e(b0.ordinal()) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.i(a0) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            n n0 = n.a;
            q q1 = (v1 & 1) == 0 ? q0 : n0;
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            boolean z = b0.a;
            if(z) {
                p0.a0(-219256609);
                p0.p(false);
                v3 = 0x7F080183;  // drawable:btn_cpplaylist_offlineplay_on
                s0 = null;
            }
            else {
                p0.a0(0xF2F03D62);
                s s1 = new s(e0.T(p0, 0x7F0604AF));  // color:white160e_support_high_contrast
                p0.p(false);
                s0 = s1;
                v3 = 0x7F080181;  // drawable:btn_cpplaylist_offlineplay_off
            }
            if(z) {
                p0.a0(0xF2F4317C);
                p0.p(false);
                v4 = 0x7F080184;  // drawable:btn_cpplaylist_offlineplay_on_circle
                s2 = null;
            }
            else {
                p0.a0(0xF2F6119F);
                s s3 = new s(e0.T(p0, 0x7F0604B2));  // color:white300e_support_high_contrast
                p0.p(false);
                s2 = s3;
                v4 = 0x7F080182;  // drawable:btn_cpplaylist_offlineplay_off_circle
            }
            LottieCompositionResult lottieCompositionResult0 = RememberLottieCompositionKt.rememberLottieComposition(Asset.box-impl("animation/circle.json"), null, null, null, null, null, p0, 6, 62);
            int v5 = b0 == Ib.b.d ? 1 : 0;
            r0.h h0 = r0.d.k;
            f f0 = p0.N();
            V v6 = k.a;
            if(f0 == v6) {
                f0 = new f(28);
                p0.l0(f0);
            }
            q q2 = r0.a.a(e0.Q(X0.n.c(q1, false, f0), ((boolean)(v5 ^ 1))), new o() {
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final q invoke(q q0, l l0, int v) {
                    kotlin.jvm.internal.q.g(q0, "$this$composed");
                    ((p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((p)l0).k(k0.i);
                    m m0 = ((p)l0).N();
                    if(m0 == k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    X0.i i0 = new X0.i(0);
                    com.iloen.melon.player.playlist.common.PlaylistCommonHeaderComposableKt.OfflineButton..inlined.noRippleClickable-YQRRFTQ.default.1.1 playlistCommonHeaderComposableKt$OfflineButton$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(this.d);
                            if(!this.e) {
                                this.c.invoke();
                            }
                        }
                    };
                    q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, null, i0, playlistCommonHeaderComposableKt$OfflineButton$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            p0 p00 = n0.a(j.a, h0, p0, 0x30);
            int v7 = p0.P;
            i0 i00 = p0.m();
            q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h1 = P0.j.f;
            w.x(p0, p00, h1);
            h h2 = P0.j.e;
            w.x(p0, i00, h2);
            h h3 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v7)) {
                A7.d.q(v7, p0, v7, h3);
            }
            h h4 = P0.j.d;
            w.x(p0, q3, h4);
            q q4 = androidx.compose.foundation.layout.d.o(n0, 22.0f, 14.0f);
            M m0 = M.p.d(r0.d.a, false);
            int v8 = p0.P;
            i0 i01 = p0.m();
            q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, h1);
            w.x(p0, i01, h2);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h3);
            }
            w.x(p0, q5, h4);
            androidx.compose.foundation.q.c(I.Q(v3, p0, 0), null, null, null, null, 0.0f, (s0 == null ? null : new y0.k(s0.a, 5)), p0, 0x30, 60);
            Ib.b.b.getClass();
            int v9 = -2;
            androidx.compose.foundation.layout.b b1 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            if(b0 == Ib.b.h) {
                p0.a0(0x601BB455);
                q q6 = b1.a(androidx.compose.foundation.layout.a.h(androidx.compose.foundation.layout.d.n(n0, 9.0f), -2.0f, 0.0f, 2), i0);
                LottieAnimationKt.LottieAnimation(((LottieComposition)lottieCompositionResult0.getValue()), q6, false, false, null, 0.0f, 0x7FFFFFFF, false, false, false, false, null, false, false, null, null, null, false, false, null, false, null, p0, 0x180000, 0, 0, 0x3FFFBC);
                p0.p(false);
                z1 = z;
            }
            else {
                p0.a0(0x60214294);
                q q7 = b1.a(androidx.compose.foundation.layout.d.o(n0, 10.0f, 10.0f), i0);
                if(!z) {
                    v9 = -10;
                }
                q q8 = androidx.compose.foundation.layout.a.h(q7, ((float)v9), 0.0f, 2);
                z1 = z;
                androidx.compose.foundation.q.c(I.Q(v4, p0, 0), null, q8, null, null, 0.0f, (s2 == null ? null : new y0.k(s2.a, 5)), p0, 0x30, 56);
                p0.p(false);
            }
            p0.p(true);
            c.d(p0, androidx.compose.foundation.layout.d.q(n0, 4.0f));
            boolean z2 = p0.h(z1);
            boolean z3 = p0.i(context0);
            J0 j00 = p0.N();
            if(z2 || z3 || j00 == v6) {
                j00 = new J0(context0, 1, z1);
                p0.l0(j00);
            }
            q q9 = X0.n.c(n0, false, j00);
            kotlin.jvm.internal.q.f("오프라인 재생", "getString(...)");
            N1.b("오프라인 재생", q9, e0.T(p0, 0x7F0604A1), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);  // color:white000e
            p0.p(true);
            q10 = q1;
        }
        else {
            p0.T();
            q10 = q0;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new H3(q10, b0, a0, v, v1, 13);
        }
    }

    public static final void SectionSelectButton(@NotNull c0 c00, @NotNull a a0, @NotNull a a1, @Nullable l l0, int v) {
        p p0;
        r0.h h0 = r0.d.k;
        kotlin.jvm.internal.q.g(c00, "sectionSelectState");
        kotlin.jvm.internal.q.g(a0, "onSectionSelectButtonClick");
        kotlin.jvm.internal.q.g(a1, "onCancelClick");
        ((p)l0).c0(-1440709515);
        int v1 = (v & 6) == 0 ? (((p)l0).e(c00.ordinal()) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (((p)l0).i(a0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (((p)l0).i(a1) ? 0x100 : 0x80);
        }
        if(((p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            c0.a.getClass();
            boolean z = F.u(c00);
            String s = z ? l1.h(((p)l0), -568700999, 0x7F130199, ((p)l0), false) : l1.h(((p)l0), -568643060, 0x7F130912, ((p)l0), false);  // string:cancel "취소"
            n n0 = n.a;
            if(z) {
                ((p)l0).a0(0xDE1CD2BB);
                q q0 = androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.d.q(n0, 48.0f), 24.0f);
                N1.b(s, r0.a.a(androidx.compose.foundation.layout.d.v(androidx.compose.foundation.layout.d.t(androidx.compose.foundation.q.i(0.5f, e0.T(((p)l0), 0x7F0604B1), q0, T.e.b(15.0f)), 2), r0.d.n, 2), new o() {  // color:white220e
                    @Override  // we.o
                    public Object invoke(Object object0, Object object1, Object object2) {
                        return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
                    }

                    public final q invoke(q q0, l l0, int v) {
                        kotlin.jvm.internal.q.g(q0, "$this$composed");
                        ((p)l0).a0(0x1FF03545);
                        w0.h h0 = (w0.h)((p)l0).k(k0.i);
                        m m0 = ((p)l0).N();
                        if(m0 == k.a) {
                            m0 = androidx.appcompat.app.o.d(((p)l0));
                        }
                        X0.i i0 = new X0.i(0);
                        com.iloen.melon.player.playlist.common.PlaylistCommonHeaderComposableKt.SectionSelectButton..inlined.noRippleClickable-YQRRFTQ.default.1.1 playlistCommonHeaderComposableKt$SectionSelectButton$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                w0.h.a(this.d);
                                this.b.invoke();
                            }
                        };
                        q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, null, i0, playlistCommonHeaderComposableKt$SectionSelectButton$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                        ((p)l0).p(false);
                        return q1;
                    }
                }), e0.T(((p)l0), 0x7F0604A1), 13.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, ((p)l0), 0xC00, 0, 0x1FDF0);  // color:white000e
                p0 = (p)l0;
            }
            else {
                ((p)l0).a0(0xDE276C90);
                int v2 = c00 == c0.c ? 1 : 0;
                q q1 = r0.a.a(e2.a.r(n0, (v2 == 0 ? 1.0f : 0.3f)), new o() {
                    @Override  // we.o
                    public Object invoke(Object object0, Object object1, Object object2) {
                        return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
                    }

                    public final q invoke(q q0, l l0, int v) {
                        kotlin.jvm.internal.q.g(q0, "$this$composed");
                        ((p)l0).a0(0x1FF03545);
                        w0.h h0 = (w0.h)((p)l0).k(k0.i);
                        m m0 = ((p)l0).N();
                        if(m0 == k.a) {
                            m0 = androidx.appcompat.app.o.d(((p)l0));
                        }
                        X0.i i0 = new X0.i(0);
                        com.iloen.melon.player.playlist.common.PlaylistCommonHeaderComposableKt.SectionSelectButton..inlined.noRippleClickable-YQRRFTQ.default.2.1 playlistCommonHeaderComposableKt$SectionSelectButton$$inlined$noRippleClickable-YQRRFTQ$default$2$10 = new a() {
                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                w0.h.a(this.d);
                                if(this.e) {
                                    this.c.invoke();
                                }
                            }
                        };
                        q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, null, i0, playlistCommonHeaderComposableKt$SectionSelectButton$$inlined$noRippleClickable-YQRRFTQ$default$2$10);
                        ((p)l0).p(false);
                        return q1;
                    }
                });
                p0 p00 = n0.a(j.a, h0, ((p)l0), 0x30);
                int v3 = ((p)l0).P;
                i0 i00 = ((p)l0).m();
                q q2 = r0.a.d(((p)l0), q1);
                P0.k.y.getClass();
                i i0 = P0.j.b;
                ((p)l0).e0();
                if(((p)l0).O) {
                    ((p)l0).l(i0);
                }
                else {
                    ((p)l0).o0();
                }
                w.x(((p)l0), p00, P0.j.f);
                w.x(((p)l0), i00, P0.j.e);
                h h1 = P0.j.g;
                if(((p)l0).O || !kotlin.jvm.internal.q.b(((p)l0).N(), v3)) {
                    A7.d.q(v3, ((p)l0), v3, h1);
                }
                w.x(((p)l0), q2, P0.j.d);
                androidx.compose.foundation.q.c(I.Q(0x7F080189, ((p)l0), 6), null, androidx.compose.foundation.layout.d.o(n0, 18.0f, 16.0f), null, null, 0.0f, null, ((p)l0), 0x1B0, 120);  // drawable:btn_cppplatlist_intervalselesct
                N1.b(s, null, A7.d.g(n0, 4.0f, ((p)l0), 0x7F0604A1, ((p)l0)), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, ((p)l0), 0xC00, 0, 0x1FFF2);  // color:white000e
                p0 = (p)l0;
                p0.p(true);
            }
            p0.p(false);
        }
        else {
            p0 = (p)l0;
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Ac.e(c00, a0, a1, v, 9);
        }
    }

    public static final void SortButton(@Nullable q q0, @NotNull String s, @NotNull a a0, @Nullable l l0, int v, int v1) {
        q q5;
        int v2;
        kotlin.jvm.internal.q.g(s, "orderText");
        kotlin.jvm.internal.q.g(a0, "onClick");
        p p0 = (p)l0;
        p0.c0(0xEBE7F78);
        if((v1 & 1) == 0) {
            v2 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        }
        else {
            v2 = v | 6;
        }
        if((v & 0x30) == 0) {
            v2 |= (p0.g(s) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.i(a0) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            n n0 = n.a;
            q q1 = (v1 & 1) == 0 ? q0 : n0;
            String s1 = e.Y(p0, 0x7F130BF8);  // string:talkback_playlist_sort_open "정렬 기준 열기"
            q q2 = r0.a.a(q1, new o() {
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final q invoke(q q0, l l0, int v) {
                    kotlin.jvm.internal.q.g(q0, "$this$composed");
                    ((p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((p)l0).k(k0.i);
                    m m0 = ((p)l0).N();
                    if(m0 == k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    X0.i i0 = new X0.i(0);
                    com.iloen.melon.player.playlist.common.PlaylistCommonHeaderComposableKt.SortButton..inlined.noRippleClickable-YQRRFTQ.default.1.1 playlistCommonHeaderComposableKt$SortButton$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            w0.h.a(this.d);
                            this.b.invoke();
                        }
                    };
                    q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, null, i0, playlistCommonHeaderComposableKt$SortButton$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            boolean z = p0.g(s1);
            d d0 = p0.N();
            if(z || d0 == k.a) {
                d0 = new d(s1, 4);
                p0.l0(d0);
            }
            q q3 = X0.n.c(q2, false, d0);
            p0 p00 = n0.a(j.a, r0.d.k, p0, 0x30);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q4 = r0.a.d(p0, q3);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q4, P0.j.d);
            c1.n(androidx.compose.foundation.layout.d.n(n0, 14.0f), 0x7F08017D, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 54, 0, 0x7FFC);  // drawable:btn_common_toggle_14_w
            long v4 = e0.T(p0, 0x7F0604A1);  // color:white000e
            N1.b(s, androidx.compose.foundation.layout.a.n(n0, 4.0f, 0.0f, 0.0f, 0.0f, 14), v4, 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v2 >> 3 & 14 | 0xC30, 0, 0x1FFF0);
            p0.p(true);
            q5 = q1;
        }
        else {
            p0.T();
            q5 = q0;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new H3(q5, s, a0, v, v1, 12);
        }
    }
}

