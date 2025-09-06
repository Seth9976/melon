package com.iloen.melon.player.playlist.mixup;

import Cc.H3;
import Cc.N1;
import Cc.e0;
import De.I;
import K.m;
import M.b;
import M.j;
import M.n0;
import M.p0;
import M.y;
import P0.i;
import Q0.k0;
import U4.x;
import U8.z;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import com.melon.playlist.mixup.DjMalrangInfo;
import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.e;
import r0.h;
import r0.n;
import we.a;
import we.o;
import y0.M;
import y0.s;

@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000B\u001A/\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00002\u000E\b\u0002\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001A\u000F\u0010\b\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001A_\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u000E\b\u0002\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u000E\b\u0002\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u000E\b\u0002\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u000E\b\u0002\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001AW\u0010\u0015\u001A\u00020\u00042\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u000E\b\u0002\u0010\u000E\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u000E\b\u0002\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u000E\b\u0002\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0014\u001A\u00020\u0000H\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"", "mainTitle", "subTitle", "Lkotlin/Function0;", "Lie/H;", "onClickAdd", "SourceTitleCommon", "(Ljava/lang/String;Ljava/lang/String;Lwe/a;Landroidx/compose/runtime/l;II)V", "SourceTitleCommonPreview", "(Landroidx/compose/runtime/l;I)V", "Lcom/melon/playlist/mixup/DjMalrangInfo;", "djMalrangInfo", "", "isCurrentPlaylist", "onClickList", "onClickContent", "onLongClickContent", "onClickOtherRecommend", "SourceTitleForDjMalrang", "(Lcom/melon/playlist/mixup/DjMalrangInfo;ZLwe/a;Lwe/a;Lwe/a;Lwe/a;Landroidx/compose/runtime/l;II)V", "impressionId", "SourceTitleForDjMalrangDebug", "(Lcom/melon/playlist/mixup/DjMalrangInfo;ZLwe/a;Lwe/a;Lwe/a;Ljava/lang/String;Landroidx/compose/runtime/l;II)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class MixUpComposablesKt {
    public static final void SourceTitleCommon(@NotNull String s, @NotNull String s1, @Nullable a a0, @Nullable l l0, int v, int v1) {
        a a2;
        a a1;
        q.g(s, "mainTitle");
        q.g(s1, "subTitle");
        p p0 = (p)l0;
        p0.c0(0x6F97370C);
        int v2 = (v & 6) == 0 ? (p0.g(s) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.g(s1) ? 0x20 : 16);
        }
        if((v1 & 4) != 0) {
            v2 |= 0x180;
        }
        else if((v & 0x180) == 0) {
            v2 |= (p0.i(a0) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            V v3 = k.a;
            if((v1 & 4) == 0) {
                a1 = a0;
            }
            else {
                e e0 = p0.N();
                if(e0 == v3) {
                    e0 = new e(24);
                    p0.l0(e0);
                }
                a1 = e0;
            }
            String s2 = x.l(H0.e.Y(p0, 0x7F130B85), " : ", s, ", ", s1);  // string:talkback_mixup_source "믹스업 플레이리스트 출처 정보"
            n n0 = n.a;
            r0.q q0 = androidx.compose.foundation.q.q(androidx.compose.foundation.layout.a.n(d.f(d.h(n0, 60.0f), 1.0f), 20.0f, 0.0f, 20.0f, 0.0f, 10), true, null);
            boolean z = p0.g(s2);
            c c0 = p0.N();
            if(z || c0 == v3) {
                c0 = new c(s2, 0);
                p0.l0(c0);
            }
            r0.q q1 = X0.n.c(q0, false, c0);
            h h0 = r0.d.k;
            b b0 = j.a;
            p0 p00 = n0.a(b0, h0, p0, 0x30);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            P0.h h1 = P0.j.f;
            w.x(p0, p00, h1);
            P0.h h2 = P0.j.e;
            w.x(p0, i00, h2);
            P0.h h3 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h3);
            }
            P0.h h4 = P0.j.d;
            w.x(p0, q2, h4);
            r0.q q3 = androidx.compose.foundation.layout.a.n(new LayoutWeightElement(1.0f, true), 0.0f, 0.0f, 20.0f, 0.0f, 11);
            com.iloen.melon.player.playlist.common.h h5 = p0.N();
            if(h5 == v3) {
                h5 = new com.iloen.melon.player.playlist.common.h(10);
                p0.l0(h5);
            }
            r0.q q4 = X0.n.c(q3, false, h5);
            y y0 = M.w.a(j.e, r0.d.m, p0, 6);
            int v5 = p0.P;
            i0 i01 = p0.m();
            r0.q q5 = r0.a.d(p0, q4);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h1);
            w.x(p0, i01, h2);
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h3);
            }
            w.x(p0, q5, h4);
            N1.b(s, null, e0.T(p0, 0x7F0604A1), 15.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v2 & 14 | 0x30C00, 0xC30, 120786);  // color:white000e
            M.c.d(p0, d.h(n0, 4.0f));
            N1.b(s1, null, e0.T(p0, 0x7F0604B7), 13.0f, null, null, 0L, null, 0.0f, 2, false, 0, 0, null, null, p0, v2 >> 3 & 14 | 0xC00, 0x30, 0x1F7F2);  // color:white700e
            p0.p(true);
            androidx.compose.foundation.y y1 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F0604B1), 0.5f);  // color:white220e
            T.d d0 = T.e.b(4.0f);
            r0.q q6 = r0.a.a(androidx.compose.foundation.layout.a.m(androidx.compose.foundation.q.j(n0, y1.a, y1.b, d0), 5.0f, 5.0f, 9.0f, 5.0f), new o() {
                @Override  // we.o
                public Object invoke(Object object0, Object object1, Object object2) {
                    return this.invoke(((r0.q)object0), ((l)object1), ((Number)object2).intValue());
                }

                public final r0.q invoke(r0.q q0, l l0, int v) {
                    q.g(q0, "$this$composed");
                    ((p)l0).a0(0x1FF03545);
                    w0.h h0 = (w0.h)((p)l0).k(k0.i);
                    m m0 = ((p)l0).N();
                    if(m0 == k.a) {
                        m0 = androidx.appcompat.app.o.d(((p)l0));
                    }
                    X0.i i0 = new X0.i(0);
                    com.iloen.melon.player.playlist.mixup.MixUpComposablesKt.SourceTitleCommon.lambda.9..inlined.noRippleClickable-YQRRFTQ.default.1.1 mixUpComposablesKt$SourceTitleCommon$lambda$9$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
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
                    r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, null, i0, mixUpComposablesKt$SourceTitleCommon$lambda$9$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            p0 p01 = n0.a(b0, h0, p0, 0x30);
            int v6 = p0.P;
            i0 i02 = p0.m();
            r0.q q7 = r0.a.d(p0, q6);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p01, h1);
            w.x(p0, i02, h2);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h3);
            }
            w.x(p0, q7, h4);
            r0.q q8 = d.o(n0, 18.0f, 18.0f);
            androidx.compose.foundation.q.c(I.Q(0x7F080142, p0, 6), null, q8, null, null, 0.0f, null, p0, 0x1B0, 120);  // drawable:btn_common_follow_18_off_w
            N1.b(H0.e.Y(p0, 0x7F1300E8), null, e0.T(p0, 0x7F0604A1), 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:all_add "전체담기"
            p0.p(true);
            p0.p(true);
            a2 = a1;
        }
        else {
            p0.T();
            a2 = a0;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new H3(s, s1, a2, v, v1, 14);
        }
    }

    public static final void SourceTitleCommonPreview(@Nullable l l0, int v) {
        ((p)l0).c0(0x1892821C);
        if(((p)l0).Q(v & 1, v != 0)) {
            MixUpComposablesKt.SourceTitleCommon("My Daily Mix 4", "재생중인 플레이리스트", null, ((p)l0), 54, 4);
        }
        else {
            ((p)l0).T();
        }
        androidx.compose.runtime.n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new z(v, 14, 0);
        }
    }

    public static final void SourceTitleForDjMalrang(@NotNull DjMalrangInfo djMalrangInfo0, boolean z, @Nullable a a0, @Nullable a a1, @Nullable a a2, @Nullable a a3, @Nullable l l0, int v, int v1) {
        a a11;
        a a10;
        a a9;
        a a8;
        a a7;
        a a6;
        a a5;
        a a4;
        q.g(djMalrangInfo0, "djMalrangInfo");
        p p0 = (p)l0;
        p0.c0(-1501303826);
        int v2 = (v & 6) == 0 ? (p0.g(djMalrangInfo0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v1 & 4) != 0) {
            v2 |= 0x180;
        }
        else if((v & 0x180) == 0) {
            v2 |= (p0.i(a0) ? 0x100 : 0x80);
        }
        if((v1 & 8) != 0) {
            v2 |= 0xC00;
        }
        else if((v & 0xC00) == 0) {
            v2 |= (p0.i(a1) ? 0x800 : 0x400);
        }
        if((v1 & 16) != 0) {
            v2 |= 0x6000;
        }
        else if((v & 0x6000) == 0) {
            v2 |= (p0.i(a2) ? 0x4000 : 0x2000);
        }
        if((v1 & 0x20) != 0) {
            v2 |= 0x30000;
        }
        else if((0x30000 & v) == 0) {
            v2 |= (p0.i(a3) ? 0x20000 : 0x10000);
        }
        if(p0.Q(v2 & 1, (74899 & v2) != 74898)) {
            V v3 = k.a;
            if((v1 & 4) == 0) {
                a4 = a0;
            }
            else {
                e e0 = p0.N();
                if(e0 == v3) {
                    e0 = new e(24);
                    p0.l0(e0);
                }
                a4 = e0;
            }
            if((v1 & 8) == 0) {
                a5 = a1;
            }
            else {
                e e1 = p0.N();
                if(e1 == v3) {
                    e1 = new e(24);
                    p0.l0(e1);
                }
                a5 = e1;
            }
            if((v1 & 16) == 0) {
                a6 = a2;
            }
            else {
                e e2 = p0.N();
                if(e2 == v3) {
                    e2 = new e(24);
                    p0.l0(e2);
                }
                a6 = e2;
            }
            if((v1 & 0x20) == 0) {
                a7 = a3;
            }
            else {
                e e3 = p0.N();
                if(e3 == v3) {
                    e3 = new e(24);
                    p0.l0(e3);
                }
                a7 = e3;
            }
            n n0 = n.a;
            r0.q q0 = d.t(d.f(n0, 1.0f), 3);
            y y0 = M.w.a(j.c, r0.d.m, p0, 0);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q1, P0.j.d);
            a8 = a4;
            e0.s(d.h(d.f(n0, 1.0f), E9.h.t(p0, 0x7F0700ED)), (z ? djMalrangInfo0.i : null), djMalrangInfo0.a, djMalrangInfo0.d, djMalrangInfo0.b, djMalrangInfo0.c, a8, a5, a6, a7, p0, v2 << 12 & 0x7FF80000, 0);  // dimen:dj_malrang_player_recommend_area_height
            A7.d.v(n0, 4.0f, p0, true);
            a9 = a5;
            a10 = a6;
            a11 = a7;
        }
        else {
            p0.T();
            a8 = a0;
            a9 = a1;
            a10 = a2;
            a11 = a3;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.mixup.b(djMalrangInfo0, z, a8, a9, a10, a11, v, v1, 1);
        }
    }

    public static final void SourceTitleForDjMalrangDebug(@NotNull DjMalrangInfo djMalrangInfo0, boolean z, @Nullable a a0, @Nullable a a1, @Nullable a a2, @NotNull String s, @Nullable l l0, int v, int v1) {
        a a8;
        a a7;
        a a5;
        a a4;
        a a3;
        q.g(djMalrangInfo0, "djMalrangInfo");
        q.g(s, "impressionId");
        p p0 = (p)l0;
        p0.c0(2004996460);
        int v2 = (v & 6) == 0 ? (p0.g(djMalrangInfo0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v1 & 4) != 0) {
            v2 |= 0x180;
        }
        else if((v & 0x180) == 0) {
            v2 |= (p0.i(a0) ? 0x100 : 0x80);
        }
        if((v1 & 8) != 0) {
            v2 |= 0xC00;
        }
        else if((v & 0xC00) == 0) {
            v2 |= (p0.i(a1) ? 0x800 : 0x400);
        }
        if((v1 & 16) != 0) {
            v2 |= 0x6000;
        }
        else if((v & 0x6000) == 0) {
            v2 |= (p0.i(a2) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v2 |= (p0.g(s) ? 0x20000 : 0x10000);
        }
        if(p0.Q(v2 & 1, (74899 & v2) != 74898)) {
            V v3 = k.a;
            if((v1 & 4) == 0) {
                a3 = a0;
            }
            else {
                e e0 = p0.N();
                if(e0 == v3) {
                    e0 = new e(24);
                    p0.l0(e0);
                }
                a3 = e0;
            }
            if((v1 & 8) == 0) {
                a4 = a1;
            }
            else {
                e e1 = p0.N();
                if(e1 == v3) {
                    e1 = new e(24);
                    p0.l0(e1);
                }
                a4 = e1;
            }
            if((v1 & 16) == 0) {
                a5 = a2;
            }
            else {
                e e2 = p0.N();
                if(e2 == v3) {
                    e2 = new e(24);
                    p0.l0(e2);
                }
                a5 = e2;
            }
            b0 b00 = p0.N();
            if(b00 == v3) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            n n0 = n.a;
            r0.q q0 = d.t(d.f(n0, 1.0f), 3);
            y y0 = M.w.a(j.c, r0.d.m, p0, 0);
            int v4 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            P0.h h0 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q1, P0.j.d);
            com.iloen.melon.player.playlist.mixup.a a6 = p0.N();
            if(a6 == v3) {
                a6 = new com.iloen.melon.player.playlist.mixup.a(b00, 0);
                p0.l0(a6);
            }
            MixUpComposablesKt.SourceTitleForDjMalrang(djMalrangInfo0, z, a3, a4, a6, a5, p0, v2 & 14 | 0x6000 | v2 & 0x70 | v2 & 0x380 | v2 & 0x1C00 | v2 << 3 & 0x70000, 0);
            if(((Boolean)b00.getValue()).booleanValue()) {
                p0.a0(1905640078);
                N1.b(("playlistId: " + djMalrangInfo0.e + "," + ("poolId: " + djMalrangInfo0.f + ",") + ("playlistType: " + djMalrangInfo0.g + ",") + ("titleKey: " + djMalrangInfo0.h)), androidx.compose.foundation.q.f(androidx.compose.foundation.layout.a.l(n0, 14.0f, 0.0f, 2), s.b, M.a), e0.T(p0, 0x7F0604A1), 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // color:white000e
                M.c.d(p0, d.h(n0, 3.0f));
                N1.b(("impressionId(curPlayable): " + s), androidx.compose.foundation.q.f(androidx.compose.foundation.layout.a.l(n0, 14.0f, 0.0f, 2), s.b, M.a), e0.T(p0, 0x7F0604A1), 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // color:white000e
            }
            else {
                p0.a0(0x71342A40);
            }
            p0.p(false);
            p0.p(true);
            a7 = a4;
            a8 = a3;
        }
        else {
            p0.T();
            a8 = a0;
            a7 = a1;
            a5 = a2;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.mixup.b(djMalrangInfo0, z, a8, a7, a5, s, v, v1, 0);
        }
    }
}

