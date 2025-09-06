package com.iloen.melon.player.playlist.common;

import Cc.N1;
import Cc.e0;
import K.m;
import N0.M;
import P0.j;
import Q0.k0;
import T.d;
import X0.i;
import androidx.compose.foundation.y;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.e;
import r0.n;
import w0.h;
import we.a;
import we.o;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001AE\u0010\f\u001A\u00020\b2\u0006\u0010\u0001\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00052\u000E\b\u0002\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000B¨\u0006\r"}, d2 = {"", "text", "Ly0/s;", "borderColor", "textColor", "Lr1/f;", "textSize", "Lkotlin/Function0;", "Lie/H;", "onClickButton", "EmptyPlaylistCommonButton-PEIptTM", "(Ljava/lang/String;JJFLwe/a;Landroidx/compose/runtime/l;II)V", "EmptyPlaylistCommonButton", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistCommonEmptyComposablesKt {
    public static final void EmptyPlaylistCommonButton-PEIptTM(@NotNull String s, long v, long v1, float f, @Nullable a a0, @Nullable l l0, int v2, int v3) {
        long v11;
        long v10;
        a a2;
        float f2;
        long v7;
        a a1;
        long v6;
        int v5;
        long v8;
        float f1;
        q.g(s, "text");
        p p0 = (p)l0;
        p0.c0(0xCDF0E956);
        int v4 = (v2 & 6) == 0 ? (p0.g(s) ? 4 : 2) | v2 : v2;
        if((v2 & 0x30) == 0) {
            v4 |= ((v3 & 2) != 0 || !p0.f(v) ? 16 : 0x20);
        }
        if((v2 & 0x180) == 0) {
            v4 |= ((v3 & 4) != 0 || !p0.f(v1) ? 0x80 : 0x100);
        }
        if((v3 & 8) != 0) {
            v4 |= 0xC00;
            f1 = f;
        }
        else if((v2 & 0xC00) == 0) {
            f1 = f;
            v4 |= (p0.d(f1) ? 0x800 : 0x400);
        }
        else {
            f1 = f;
        }
        if((v3 & 16) != 0) {
            v4 |= 0x6000;
        }
        else if((v2 & 0x6000) == 0) {
            v4 |= (p0.i(a0) ? 0x4000 : 0x2000);
        }
        if(p0.Q(v4 & 1, (v4 & 9363) != 9362)) {
            p0.V();
            if((v2 & 1) == 0 || p0.B()) {
                if((v3 & 2) == 0) {
                    v8 = v;
                }
                else {
                    v8 = e0.T(p0, 0x7F0604B1);  // color:white220e
                    v4 &= 0xFFFFFF8F;
                }
                if((v3 & 4) == 0) {
                    v6 = v1;
                }
                else {
                    v6 = e0.T(p0, 0x7F0604A1);  // color:white000e
                    v4 &= -897;
                }
                if((v3 & 8) != 0) {
                    f1 = 14.0f;
                }
                if((v3 & 16) == 0) {
                    v5 = v4;
                    a1 = a0;
                }
                else {
                    e e0 = p0.N();
                    if(e0 == k.a) {
                        e0 = new e(24);
                        p0.l0(e0);
                    }
                    v5 = v4;
                    a1 = e0;
                }
                v7 = v8;
            }
            else {
                p0.T();
                if((v3 & 2) != 0) {
                    v4 &= 0xFFFFFF8F;
                }
                if((v3 & 4) != 0) {
                    v4 &= -897;
                }
                v5 = v4;
                v6 = v1;
                a1 = a0;
                v7 = v;
            }
            p0.q();
            y y0 = androidx.compose.foundation.q.a(v7, 0.5f);
            d d0 = T.e.b(21.0f);
            n n0 = n.a;
            r0.q q0 = r0.a.a(androidx.compose.foundation.q.j(n0, y0.a, y0.b, d0), new o() {
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
                    i i0 = new i(0);
                    com.iloen.melon.player.playlist.common.PlaylistCommonEmptyComposablesKt.EmptyPlaylistCommonButton-PEIptTM..inlined.noRippleClickable-YQRRFTQ.default.1.1 playlistCommonEmptyComposablesKt$EmptyPlaylistCommonButton-PEIptTM$$inlined$noRippleClickable-YQRRFTQ$default$1$10 = new a() {
                        @Override  // we.a
                        public Object invoke() {
                            this.invoke();
                            return H.a;
                        }

                        public final void invoke() {
                            h.a(this.d);
                            this.b.invoke();
                        }
                    };
                    r0.q q1 = androidx.compose.foundation.q.l(q0, m0, null, true, null, i0, playlistCommonEmptyComposablesKt$EmptyPlaylistCommonButton-PEIptTM$$inlined$noRippleClickable-YQRRFTQ$default$1$10);
                    ((p)l0).p(false);
                    return q1;
                }
            });
            M m0 = M.p.d(r0.d.a, false);
            int v9 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
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
            P0.h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v9)) {
                A7.d.q(v9, p0, v9, h0);
            }
            w.x(p0, q1, j.d);
            N1.b(s, androidx.compose.foundation.layout.a.m(n0, 16.0f, 10.0f, 16.0f, 9.0f), v6, f1, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v5 & 8078, 0, 0x1FFF0);
            p0.p(true);
            f2 = f1;
            a2 = a1;
            v10 = v6;
            v11 = v7;
        }
        else {
            p0.T();
            v11 = v;
            v10 = v1;
            f2 = f1;
            a2 = a0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.common.a(s, v11, v10, f2, a2, v2, v3);
        }
    }
}

