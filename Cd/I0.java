package cd;

import Cc.e0;
import M.j;
import M.w;
import M.y;
import N0.M;
import P0.h;
import P0.i;
import P0.k;
import Zc.c;
import android.content.Context;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.V;
import androidx.compose.runtime.c1;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import bd.s;
import com.google.firebase.b;
import com.iloen.melon.net.v5x.response.FlexibleRes.BadgeType;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import java.util.List;
import kotlin.jvm.internal.q;
import r0.a;
import r0.n;

public abstract class i0 {
    public static final void a(j0 j00, l l0, int v) {
        boolean z1;
        q.g(j00, "uiState");
        Content flexibleRes$RESPONSE$Flexible$Content0 = j00.b;
        p p0 = (p)l0;
        p0.c0(0xCA98B30F);
        int v1 = (p0.i(j00) ? 4 : 2) | v;
        if(p0.Q(v1 & 1, (v1 & 3) != 2)) {
            c1 c10 = AndroidCompositionLocals_androidKt.b;
            boolean z = ScreenUtils.isDarkMode(((Context)p0.k(c10)));
            n n0 = n.a;
            r0.q q0 = d.f(n0, 1.0f);
            y y0 = w.a(j.c, r0.d.m, p0, 0);
            int v2 = p0.P;
            androidx.compose.runtime.i0 i00 = p0.m();
            r0.q q1 = a.d(p0, q0);
            k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y0, h0);
            h h1 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i00, h1);
            h h2 = P0.j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            s s0 = j00.a;
            if(s0 == null) {
                p0.a0(0x40421E07);
            }
            else {
                p0.a0(0x40421E08);
                b.j(s0, p0, 0);
            }
            p0.p(false);
            r0.q q2 = androidx.compose.foundation.layout.a.l(n0, 20.0f, 0.0f, 2);
            M m0 = M.p.d(r0.d.a, false);
            int v3 = p0.P;
            androidx.compose.runtime.i0 i01 = p0.m();
            r0.q q3 = a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, m0, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            androidx.compose.runtime.w.x(p0, q3, h3);
            String s1 = flexibleRes$RESPONSE$Flexible$Content0.getImgUrl();
            if(s1 == null) {
                s1 = "";
            }
            Long long0 = flexibleRes$RESPONSE$Flexible$Content0.getLiveStartDate();
            long v4 = long0 == null ? 0L : ((long)long0);
            String s2 = flexibleRes$RESPONSE$Flexible$Content0.getTitle() == null ? "" : flexibleRes$RESPONSE$Flexible$Content0.getTitle();
            String s3 = flexibleRes$RESPONSE$Flexible$Content0.getSubTitle() == null ? "" : flexibleRes$RESPONSE$Flexible$Content0.getSubTitle();
            BadgeType flexibleRes$BadgeType0 = flexibleRes$RESPONSE$Flexible$Content0.getBadgeType();
            String s4 = flexibleRes$RESPONSE$Flexible$Content0.getViewCountText() == null ? "" : flexibleRes$RESPONSE$Flexible$Content0.getViewCountText();
            List list0 = flexibleRes$RESPONSE$Flexible$Content0.getChatList();
            if(list0 == null) {
                list0 = je.w.a;
            }
            long v5 = y0.M.c(ColorUtils.getColorFromHexStr(((Context)p0.k(c10)), flexibleRes$RESPONSE$Flexible$Content0.getBgColor(), 0x7F060142));  // color:gray030s
            String s5 = flexibleRes$RESPONSE$Flexible$Content0.getImgUrl();
            if(s5 == null || s5.length() == 0) {
                z1 = false;
            }
            else {
                String s6 = flexibleRes$RESPONSE$Flexible$Content0.getBgColor();
                z1 = s6 == null || s6.length() == 0 ? false : true;
            }
            String s7 = flexibleRes$RESPONSE$Flexible$Content0.getBgColor();
            long v6 = e0.T(p0, (s7 != null && s7.length() != 0 || z ? 0x7F0604A1 : 0x7F06016D));  // color:white000e
            String s8 = flexibleRes$RESPONSE$Flexible$Content0.getBgColor();
            long v7 = e0.T(p0, (s8 != null && s8.length() != 0 || z ? 0x7F0604A1 : 0x7F06016D));  // color:white000e
            String s9 = flexibleRes$RESPONSE$Flexible$Content0.getBgColor();
            long v8 = e0.T(p0, (s9 == null || s9.length() == 0 ? 0x7F06015D : 0x7F0604B7));  // color:gray500s_support_high_contrast
            String s10 = flexibleRes$RESPONSE$Flexible$Content0.getBgColor();
            long v9 = e0.T(p0, (s10 != null && s10.length() != 0 || z ? 0x7F0604A1 : 0x7F06016D));  // color:white000e
            boolean z2 = p0.i(j00);
            h0 h00 = p0.N();
            V v10 = androidx.compose.runtime.k.a;
            if(z2 || h00 == v10) {
                h00 = new h0(j00, 0);
                p0.l0(h00);
            }
            boolean z3 = p0.i(j00);
            h0 h01 = p0.N();
            if(z3 || h01 == v10) {
                h01 = new h0(j00, 1);
                p0.l0(h01);
            }
            bd.y.b(s1, v4, s2, s3, flexibleRes$BadgeType0, s4, list0, v5, v6, v7, v8, v9, z1, h00, h01, p0, 0);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new c(j00, v, 12);
        }
    }
}

