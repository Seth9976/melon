package com.iloen.melon.player.playlist.common.scrollbar;

import Cc.G3;
import F.f0;
import G.f;
import I.X0;
import K.j;
import K.m;
import androidx.appcompat.app.o;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import kotlin.Metadata;
import m0.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.n;
import r0.q;
import we.k;
import y0.s;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\u001A9\u0010\t\u001A\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\b\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u0010²\u0006\u000E\u0010\u0002\u001A\u00020\u000B8\n@\nX\u008A\u008E\u0002²\u0006\f\u0010\r\u001A\u00020\f8\nX\u008A\u0084\u0002²\u0006\f\u0010\u000E\u001A\u00020\f8\nX\u008A\u0084\u0002²\u0006\f\u0010\u000F\u001A\u00020\f8\nX\u008A\u0084\u0002"}, d2 = {"LI/X0;", "Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollbarState;", "state", "Lkotlin/Function1;", "", "Lie/H;", "onThumbMoved", "Lr0/q;", "modifier", "DraggableScrollbar", "(LI/X0;Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollbarState;Lwe/k;Lr0/q;Landroidx/compose/runtime/l;II)V", "Lcom/iloen/melon/player/playlist/common/scrollbar/ThumbState;", "", "pressed", "hovered", "dragged", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class AppScrollbarsKt {
    public static final void DraggableScrollbar(@NotNull X0 x00, @NotNull ScrollbarState scrollbarState0, @NotNull k k0, @Nullable q q0, @Nullable l l0, int v, int v1) {
        q q2;
        kotlin.jvm.internal.q.g(x00, "<this>");
        kotlin.jvm.internal.q.g(scrollbarState0, "state");
        kotlin.jvm.internal.q.g(k0, "onThumbMoved");
        ((p)l0).c0(0xEF21322F);
        int v2 = (v & 6) == 0 ? (((p)l0).i(x00) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (((p)l0).g(scrollbarState0) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (((p)l0).i(k0) ? 0x100 : 0x80);
        }
        if((v1 & 4) != 0) {
            v2 |= 0xC00;
        }
        else if((v & 0xC00) == 0) {
            v2 |= (((p)l0).g(q0) ? 0x800 : 0x400);
        }
        if(((p)l0).Q(v2 & 1, (v2 & 0x493) != 1170)) {
            q q1 = (v1 & 4) == 0 ? q0 : n.a;
            m m0 = ((p)l0).N();
            if(m0 == androidx.compose.runtime.k.a) {
                m0 = o.d(((p)l0));
            }
            ScrollbarKt.Scrollbar-jIwJxvA(scrollbarState0, q1, m0, 0.0f, k0, c.e(0xABBBCF99, ((p)l0), new a(x00, m0)), ((p)l0), v2 >> 3 & 14 | 0x30180 | v2 >> 6 & 0x70 | v2 << 6 & 0xE000, 8);
            q2 = q1;
        }
        else {
            ((p)l0).T();
            q2 = q0;
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new G3(x00, scrollbarState0, k0, q2, v, v1);
        }
    }

    public static final void a(X0 x00, K.l l0, l l1, int v) {
        long v3;
        p p0 = (p)l1;
        p0.c0(0x3289FCF1);
        int v1 = (p0.i(x00) ? 4 : 2) | v;
        boolean z = true;
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            b0 b00 = p0.N();
            V v2 = androidx.compose.runtime.k.a;
            if(b00 == v2) {
                b00 = w.s(ThumbState.Dormant);
                p0.l0(b00);
            }
            b0 b01 = ye.a.u(l0, p0, 6);
            b0 b02 = p0.N();
            if(b02 == v2) {
                b02 = w.s(Boolean.FALSE);
                p0.l0(b02);
            }
            j j0 = p0.N();
            if(j0 == v2) {
                j0 = new j(l0, b02, null);
                p0.l0(j0);
            }
            J.d(p0, l0, j0);
            b0 b03 = x1.a.n(l0, p0, 6);
            if(!x00.d() && !x00.c() || !((Boolean)b01.getValue()).booleanValue() && !((Boolean)b02.getValue()).booleanValue() && !((Boolean)b03.getValue()).booleanValue() && !x00.b()) {
                z = false;
            }
            Boolean boolean0 = Boolean.valueOf(z);
            boolean z1 = p0.h(z);
            AppScrollbarsKt.DraggableScrollbarThumb.1.1 appScrollbarsKt$DraggableScrollbarThumb$1$10 = p0.N();
            if(z1 || appScrollbarsKt$DraggableScrollbarThumb$1$10 == v2) {
                appScrollbarsKt$DraggableScrollbarThumb$1$10 = new AppScrollbarsKt.DraggableScrollbarThumb.1.1(b00, null, z);
                p0.l0(appScrollbarsKt$DraggableScrollbarThumb$1$10);
            }
            J.d(p0, boolean0, appScrollbarsKt$DraggableScrollbarThumb$1$10);
            ThumbState thumbState0 = (ThumbState)b00.getValue();
            ThumbState thumbState1 = ThumbState.Active;
            q q0 = d.c(d.q(n.a, (thumbState0 == thumbState1 ? 30.0f : 0.0f)), 1.0f);
            ThumbState thumbState2 = (ThumbState)b00.getValue();
            if(thumbState2 == thumbState1) {
                v3 = A7.d.f(p0, 0x40843170, 0x7F0604A4, p0, false);  // color:white000e_40
            }
            else {
                p0.a0(1082406867);
                p0.p(false);
                v3 = s.f;
            }
            b1 b10 = f0.b(v3, f.r((thumbState2 == thumbState1 ? 0 : 500), 0, null, 6), "Scrollbar thumb color", p0, 8);
            boolean z2 = p0.g(b10);
            AppScrollbarsKt.scrollThumb.1.1 appScrollbarsKt$scrollThumb$1$10 = p0.N();
            if(z2 || appScrollbarsKt$scrollThumb$1$10 == v2) {
                appScrollbarsKt$scrollThumb$1$10 = new AppScrollbarsKt.scrollThumb.1.1(b10);
                p0.l0(appScrollbarsKt$scrollThumb$1$10);
            }
            M.p.a(q0.then(new ScrollThumbElement(appScrollbarsKt$scrollThumb$1$10)), p0, 0);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new a(x00, l0, v);
        }
    }

    public static final ThumbState access$DraggableScrollbarThumb$lambda$4(b0 b00) {
        return (ThumbState)b00.getValue();
    }

    public static final void access$DraggableScrollbarThumb$lambda$5(b0 b00, ThumbState thumbState0) {
        b00.setValue(thumbState0);
    }
}

