package com.iloen.melon.player.playlist.drawernew.composable;

import Cc.N1;
import Cc.e0;
import N0.M;
import P0.h;
import P0.i;
import P0.j;
import P0.k;
import T.d;
import T.e;
import androidx.compose.foundation.layout.a;
import androidx.compose.foundation.y;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.n;
import r0.q;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A1\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lr0/q;", "modifier", "", "title", "", "isSelected", "isBottomSheet", "Lie/H;", "DrawerAlyac", "(Lr0/q;Ljava/lang/String;ZZLandroidx/compose/runtime/l;II)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerAlyacKt {
    public static final void DrawerAlyac(@Nullable q q0, @NotNull String s, boolean z, boolean z1, @Nullable l l0, int v, int v1) {
        q q5;
        int v2;
        kotlin.jvm.internal.q.g(s, "title");
        p p0 = (p)l0;
        p0.c0(0x95BDF800);
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
            v2 |= (p0.h(z) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v2 |= (p0.h(z1) ? 0x800 : 0x400);
        }
        if(p0.Q(v2 & 1, (v2 & 0x493) != 1170)) {
            q q1 = (v1 & 1) == 0 ? q0 : n.a;
            int v3 = 0x7F06017A;  // color:green500e_support_high_contrast
            int v4 = 0x7F06048A;  // color:transparent
            if(!z1) {
                if(z) {
                    v4 = 0x7F06017A;  // color:green500e_support_high_contrast
                }
            }
            else if(z) {
                v4 = 0x7F06017F;  // color:green502s_support_high_contrast
            }
            if(!z1) {
                if(!z) {
                    v3 = 0x7F0604B1;  // color:white220e
                }
            }
            else if(z) {
                v3 = 0x7F06017F;  // color:green502s_support_high_contrast
            }
            else {
                v3 = 0x7F060152;  // color:gray200a
            }
            q q2 = androidx.compose.foundation.q.f(q1, e0.T(p0, v4), e.b(100.0f));
            y y0 = androidx.compose.foundation.q.a(e0.T(p0, v3), 0.5f);
            d d0 = e.b(100.0f);
            q q3 = a.k(androidx.compose.foundation.q.j(q2, y0.a, y0.b, d0), 12.0f, 7.0f);
            M m0 = M.p.d(r0.d.e, false);
            int v5 = p0.P;
            i0 i00 = p0.m();
            q q4 = r0.a.d(p0, q3);
            k.y.getClass();
            i i0 = j.b;
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h0);
            }
            w.x(p0, q4, j.d);
            N1.b(s, null, e0.T(p0, (!z1 || z ? 0x7F0604A1 : 0x7F06016D)), 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v2 >> 3 & 14 | 0xC00, 0, 0x1FFF2);  // color:white000e
            p0.p(true);
            q5 = q1;
        }
        else {
            p0.T();
            q5 = q0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new com.iloen.melon.player.playlist.drawernew.composable.a(q5, s, z, z1, v, v1);
        }
    }
}

