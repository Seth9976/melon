package com.iloen.melon.fragments.shortform;

import Cc.H3;
import Cc.c1;
import Cc.e0;
import N0.M;
import P0.h;
import P0.i;
import P0.j;
import P0.k;
import U8.z;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import ie.H;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.a;
import r0.n;
import r0.q;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001A)\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001A\u000F\u0010\b\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lr0/q;", "modifier", "", "patternType", "colorSetType", "Lie/H;", "TrendMusicWaveBackgroundPattern", "(Lr0/q;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/l;II)V", "PreviewTrendMusicWaveBackgroundPattern", "(Landroidx/compose/runtime/l;I)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class TrendMusicWaveBackgroundPatternKt {
    public static final void PreviewTrendMusicWaveBackgroundPattern(@Nullable l l0, int v) {
        ((p)l0).c0(0x9101D2C8);
        if(((p)l0).Q(v & 1, v != 0)) {
            TrendMusicWaveBackgroundPatternKt.TrendMusicWaveBackgroundPattern(d.h(d.q(n.a, 360.0f), 330.0f), "B", "C", ((p)l0), 438, 0);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new z(v, 5, 0);
        }
    }

    private static final H PreviewTrendMusicWaveBackgroundPattern$lambda$2(int v, l l0, int v1) {
        TrendMusicWaveBackgroundPatternKt.PreviewTrendMusicWaveBackgroundPattern(l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    public static final void TrendMusicWaveBackgroundPattern(@Nullable q q0, @NotNull String s, @NotNull String s1, @Nullable l l0, int v, int v1) {
        q q5;
        int v2;
        kotlin.jvm.internal.q.g(s, "patternType");
        kotlin.jvm.internal.q.g(s1, "colorSetType");
        p p0 = (p)l0;
        p0.c0(0xBE0201D);
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
            v2 |= (p0.g(s1) ? 0x100 : 0x80);
        }
        if(p0.Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            n n0 = n.a;
            q q1 = (v1 & 1) == 0 ? q0 : n0;
            PatternType patternType0 = PatternType.Companion.fromString(s);
            if(patternType0 == null) {
                patternType0 = TypeA.INSTANCE;
            }
            ColorSet colorSet0 = ColorSet.Companion.fromString(s1);
            if(colorSet0 == null) {
                colorSet0 = com.iloen.melon.fragments.shortform.ColorSet.TypeA.INSTANCE;
            }
            List list0 = patternType0.getImages();
            List list1 = colorSet0.getColors();
            M m0 = M.p.d(r0.d.h, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q2 = a.d(p0, q1);
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h0);
            }
            w.x(p0, q2, j.d);
            q q3 = d.f(n0, 1.0f);
            int v4 = ((Number)je.p.k0(list0)).intValue();
            y0.k k0 = new y0.k(e0.T(p0, ((Number)je.p.k0(list1)).intValue()), 5);
            c1.n(q3, v4, null, N0.j.b, false, 0, null, null, null, 0.0f, k0, 0, 0, false, false, p0, 0xC06, 0, 0x7BF4);
            q q4 = d.f(n0, 1.0f);
            int v5 = ((Number)je.p.s0(list0)).intValue();
            y0.k k1 = new y0.k(e0.T(p0, ((Number)je.p.s0(list1)).intValue()), 5);
            c1.n(q4, v5, null, N0.j.b, false, 0, null, null, null, 0.0f, k1, 0, 0, false, false, p0, 0xC06, 0, 0x7BF4);
            p0.p(true);
            q5 = q1;
        }
        else {
            p0.T();
            q5 = q0;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new H3(q5, s, s1, v, v1, 10);
        }
    }

    private static final H TrendMusicWaveBackgroundPattern$lambda$1(q q0, String s, String s1, int v, int v1, l l0, int v2) {
        TrendMusicWaveBackgroundPatternKt.TrendMusicWaveBackgroundPattern(q0, s, s1, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)), v1);
        return H.a;
    }

    public static H b(int v, l l0, int v1) {
        return TrendMusicWaveBackgroundPatternKt.PreviewTrendMusicWaveBackgroundPattern$lambda$2(v, l0, v1);
    }
}

