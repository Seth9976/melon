package com.iloen.melon.fragments.detail.ui;

import A0.c;
import Bd.e;
import Cb.i;
import Cc.N1;
import Cc.e0;
import M.j;
import M.p0;
import M.v;
import M.w;
import M.y;
import P0.h;
import W8.a;
import W8.b;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Paint.Align;
import android.text.TextPaint;
import androidx.appcompat.app.o;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.media3.session.legacy.V;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import ie.H;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r0.g;
import r0.n;
import r0.q;
import r1.f;
import wc.u;
import y0.L;
import y0.M;
import y0.s;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0002\b\b\u001A\u0017\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0001\u001A\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001A%\u0010\f\u001A\u00020\u00022\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001A\u00020\bH\u0003¢\u0006\u0004\b\n\u0010\u000B\u001A\'\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001A\u001F\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0015\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001A9\u0010!\u001A\u00020\u0002*\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u001B2\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u001D\u001A\u00020\u00172\u0006\u0010\u001E\u001A\u00020\rH\u0002¢\u0006\u0004\b\u001F\u0010 \u001A+\u0010(\u001A\u00020\u0002*\u00020\u001A2\u0006\u0010\"\u001A\u00020\u00122\u0006\u0010#\u001A\u00020\u00172\u0006\u0010%\u001A\u00020$H\u0002¢\u0006\u0004\b&\u0010\'\u001A;\u0010/\u001A\u00020\u0002*\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010)\u001A\u00020\u00102\u0006\u0010*\u001A\u00020\u00122\u0006\u0010+\u001A\u00020\r2\u0006\u0010,\u001A\u00020\u0010H\u0002¢\u0006\u0004\b-\u0010.\u001A3\u00105\u001A\u00020\u0002*\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010)\u001A\u0002002\u0006\u00101\u001A\u00020\u00122\u0006\u00102\u001A\u00020\u0017H\u0002¢\u0006\u0004\b3\u00104\u001A\u0017\u00106\u001A\u00020\u00022\u0006\u0010)\u001A\u000200H\u0002¢\u0006\u0004\b6\u00107¨\u00068"}, d2 = {"Lcom/iloen/melon/fragments/detail/ui/ListeningUiState;", "uiState", "Lie/H;", "ListeningGraph", "(Lcom/iloen/melon/fragments/detail/ui/ListeningUiState;Landroidx/compose/runtime/l;I)V", "", "Lcom/iloen/melon/fragments/detail/ui/ListeningAge;", "listeningAges", "Lr1/f;", "windowWidth", "DrawGraphCanvas-ziNgDLE", "(Ljava/util/List;FLandroidx/compose/runtime/l;I)V", "DrawGraphCanvas", "", "columnWidthPx", "columnMarginPx", "", "index", "Lx0/b;", "getColumnOffset", "(FFI)J", "maxBarHeightPx", "percent", "Lx0/e;", "getBarSize", "(FI)J", "LA0/f;", "Landroid/content/Context;", "context", "guideColumnSize", "columnInterval", "drawGraph-yzxVdVo", "(LA0/f;Landroid/content/Context;Ljava/util/List;JF)V", "drawGraph", "offset", "size", "Ly0/o;", "brush", "drawGraphBar-4L21HEs", "(LA0/f;JJLy0/o;)V", "drawGraphBar", "text", "textOffset", "textWidth", "textColor", "drawTopText-F0iM_J4", "(LA0/f;Landroid/content/Context;IJFI)V", "drawTopText", "", "columnOffset", "columnSize", "drawBottomText-S-AsslU", "(LA0/f;Landroid/content/Context;Ljava/lang/String;JJ)V", "drawBottomText", "logMessage", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class ListeningGraphKt {
    private static final void DrawGraphCanvas-ziNgDLE(List list0, float f, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(0x7BD40F06);
        int v1 = (v & 6) == 0 ? (p0.i(list0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.d(f) ? 0x20 : 16);
        }
        if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            Configuration configuration0 = (Configuration)p0.k(AndroidCompositionLocals_androidKt.a);
            long v2 = ((long)Float.floatToRawIntBits(e0.a0(42.0f, p0))) << 0x20 | ((long)Float.floatToRawIntBits(e0.a0(142.0f, p0))) & 0xFFFFFFFFL;
            float f1 = e0.a0(f - 80.0f, p0) - Float.intBitsToFloat(((int)(v2 >> 0x20))) * 6.0f;
            float f2 = -e0.a0(2.5f, p0);
            if(f1 < f2 * 5.0f) {
                p0.a0(176895105);
            }
            else {
                p0.a0(0xA8BC6E8);
                f2 = f1 / 5.0f;
                if(f2 > e0.a0(30.0f, p0)) {
                    p0.a0(177029304);
                    f2 = e0.a0(30.0f, p0);
                }
                else {
                    p0.a0(177070782);
                }
                p0.p(false);
            }
            p0.p(false);
            float f3 = ((float)(list0.size() - 1)) * f2 + Float.intBitsToFloat(((int)(v2 >> 0x20))) * ((float)list0.size());
            p0.a0(0xD70CEC9F);
            StringBuilder stringBuilder0 = new StringBuilder();
            stringBuilder0.append("DrawGraphCanvas() WindowWidth: " + f.b(f));
            i.m(stringBuilder0);
            stringBuilder0.append("canvasContentsWidth: " + f.b(e0.Y(f3, p0)));
            i.m(stringBuilder0);
            stringBuilder0.append("totalColumnInterval: " + f.b(e0.Y(f1, p0)));
            i.m(stringBuilder0);
            stringBuilder0.append("columnInterval: " + f.b(e0.Y(f2, p0)));
            p0.p(false);
            ListeningGraphKt.logMessage(stringBuilder0.toString());
            float f4 = e0.Y(Float.intBitsToFloat(((int)(v2 & 0xFFFFFFFFL))), p0);
            q q0 = d.h(n.a, f4);
            float f5 = e0.a0(f - 80.0f, p0);
            if(f5 < f3) {
                f5 = f3;
            }
            q q1 = d.q(q0, e0.Y(f5, p0));
            boolean z = p0.d(f3);
            boolean z1 = p0.i(context0);
            boolean z2 = p0.i(list0);
            boolean z3 = p0.f(v2);
            boolean z4 = p0.d(f2);
            b b0 = p0.N();
            if((z | z1 | z2 | z3 | z4) != 0 || b0 == k.a) {
                b b1 = (A0.f f2) -> ListeningGraphKt.DrawGraphCanvas_ziNgDLE$lambda$15$lambda$14(f3, context0, list0, v2, f2, f2);
                p0.l0(b1);
                b0 = b1;
            }
            androidx.compose.foundation.q.b(q1, b0, p0, 0);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = (l l0, int v1) -> ListeningGraphKt.DrawGraphCanvas_ziNgDLE$lambda$16(list0, f, v, l0, v1);
        }
    }

    private static final H DrawGraphCanvas_ziNgDLE$lambda$15$lambda$14(float f, Context context0, List list0, long v, float f1, A0.f f2) {
        kotlin.jvm.internal.q.g(f2, "$this$Canvas");
        float f3 = Float.compare(Float.intBitsToFloat(((int)(f2.c() >> 0x20))), f) <= 0 ? 0.0f : (Float.intBitsToFloat(((int)(f2.c() >> 0x20))) - f) / 2.0f;
        V v1 = f2.a0();
        long v2 = v1.l();
        v1.h().q();
        try {
            c.N(((c)v1.a), f3);
            ListeningGraphKt.drawGraph-yzxVdVo(f2, context0, list0, v, f1);
        }
        catch(Throwable throwable0) {
            o.y(v1, v2);
            throw throwable0;
        }
        v1.h().j();
        v1.x(v2);
        float f4 = Float.intBitsToFloat(((int)(f2.c() & 0xFFFFFFFFL))) - ((float)ViewUtilsKt.dpToPx(27));
        float f5 = Float.intBitsToFloat(((int)(f2.c() >> 0x20)));
        A0.f.k0(f2, M.c(ColorUtils.getColor(context0, 0x7F06014A)), ((long)Float.floatToRawIntBits(f4)) & 0xFFFFFFFFL, ((long)Float.floatToRawIntBits(f5)) << 0x20 | 0xFFFFFFFFL & ((long)Float.floatToRawIntBits(f4)), f2.Y(0.5f), 0, null, 0x1F0);  // color:gray100a
        return H.a;
    }

    private static final H DrawGraphCanvas_ziNgDLE$lambda$16(List list0, float f, int v, l l0, int v1) {
        ListeningGraphKt.DrawGraphCanvas-ziNgDLE(list0, f, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    public static final void ListeningGraph(@NotNull ListeningUiState listeningUiState0, @Nullable l l0, int v) {
        kotlin.jvm.internal.q.g(listeningUiState0, "uiState");
        ((p)l0).c0(0x4ABF269);
        int v1 = (v & 6) == 0 ? (((p)l0).i(listeningUiState0) ? 4 : 2) | v : v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            M.c.a(d.f(n.a, 1.0f), null, false, m0.c.e(0xF205B33F, ((p)l0), new e(listeningUiState0, 13)), ((p)l0), 0xC06, 6);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new a(listeningUiState0, v, 0);
        }
    }

    private static final H ListeningGraph$lambda$10(ListeningUiState listeningUiState0, int v, l l0, int v1) {
        ListeningGraphKt.ListeningGraph(listeningUiState0, l0, (v | 1) & -920350135 | ((0x24924924 & (v | 1)) >> 1 | 306783378 & (v | 1)) | (306783378 & (v | 1)) << 1 & (0x24924924 & (v | 1)));
        return H.a;
    }

    private static final H ListeningGraph$lambda$9(ListeningUiState listeningUiState0, v v0, l l0, int v1) {
        long v12;
        int v8;
        g g0 = r0.d.m;
        kotlin.jvm.internal.q.g(v0, "$this$BoxWithConstraints");
        int v2 = (v1 & 6) == 0 ? v1 | (((p)l0).g(v0) ? 4 : 2) : v1;
        p p0 = (p)l0;
        if(p0.Q(v2 & 1, (v2 & 19) != 18)) {
            float f = ((androidx.compose.foundation.layout.c)v0).c();
            ListeningGraphKt.logMessage(va.e.b("ListeningGraph windowWidth: ", f.b(f)));
            n n0 = n.a;
            q q0 = androidx.compose.foundation.q.u(androidx.compose.foundation.layout.a.m(d5.n.o(androidx.compose.foundation.q.f(d.f(androidx.compose.foundation.layout.a.n(n0, 20.0f, 0.0f, 20.0f, 0.0f, 10), 1.0f), e0.T(p0, 0x7F06013E), T.e.b(4.0f)), T.e.b(4.0f)), 20.0f, 24.0f, 20.0f, 18.0f), androidx.compose.foundation.q.t(p0), true, false);  // color:gray000s
            M.d d0 = j.c;
            y y0 = w.a(d0, g0, p0, 0);
            int v3 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = P0.j.b;
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
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            h h3 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q1, h3);
            p0 p00 = M.n0.a(j.a, r0.d.j, p0, 0);
            int v4 = p0.P;
            i0 i01 = p0.m();
            q q2 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p00, h0);
            androidx.compose.runtime.w.x(p0, i01, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            androidx.compose.runtime.w.x(p0, q2, h3);
            q q3 = d.q(n0, 110.0f);
            y y1 = w.a(d0, g0, p0, 0);
            int v5 = p0.P;
            i0 i02 = p0.m();
            q q4 = r0.a.d(p0, q3);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, y1, h0);
            androidx.compose.runtime.w.x(p0, i02, h1);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h2);
            }
            androidx.compose.runtime.w.x(p0, q4, h3);
            N1.b("", null, e0.T(p0, 0x7F060160), 13.0f, e1.y.f, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);  // color:gray600s_support_high_contrast
            M.c.d(p0, d.h(n0, 8.0f));
            Iterator iterator0 = listeningUiState0.getListeningAges().iterator();
            if(!iterator0.hasNext()) {
                throw new NoSuchElementException();
            }
            Object object0 = iterator0.next();
            if(iterator0.hasNext()) {
                int v6 = ((ListeningAge)object0).getPercentage();
                while(true) {
                    Object object1 = iterator0.next();
                    int v7 = ((ListeningAge)object1).getPercentage();
                    if(v6 < v7) {
                        object0 = object1;
                        v6 = v7;
                    }
                    if(!iterator0.hasNext()) {
                        break;
                    }
                }
            }
            Iterable iterable0 = listeningUiState0.getListeningAges();
            if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                v8 = 0;
                for(Object object2: iterable0) {
                    if(((ListeningAge)object2).getPercentage() == ((ListeningAge)object0).getPercentage()) {
                        ++v8;
                        if(v8 < 0) {
                            e.k.N();
                            throw null;
                        }
                        if(false) {
                            break;
                        }
                    }
                }
            }
            else {
                v8 = 0;
            }
            N1.b((v8 <= 1 ? ((ListeningAge)object0).getTitle() : ""), null, e0.T(p0, 0x7F06016D), 18.0f, e1.y.g, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);  // color:gray900s
            e1.y y2 = e1.y.g;
            p0.p(true);
            M.c.d(p0, d.q(n0, 20.0f));
            y y3 = w.a(j.c, g0, p0, 0);
            int v9 = p0.P;
            i0 i03 = p0.m();
            q q5 = r0.a.d(p0, n0);
            P0.k.y.getClass();
            P0.i i1 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h4 = P0.j.f;
            androidx.compose.runtime.w.x(p0, y3, h4);
            h h5 = P0.j.e;
            androidx.compose.runtime.w.x(p0, i03, h5);
            h h6 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v9)) {
                A7.d.q(v9, p0, v9, h6);
            }
            h h7 = P0.j.d;
            androidx.compose.runtime.w.x(p0, q5, h7);
            N1.b("", null, e0.T(p0, 0x7F060160), 13.0f, e1.y.f, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);  // color:gray600s_support_high_contrast
            M.c.d(p0, d.h(n0, 8.0f));
            p0 p01 = M.n0.a(j.a, r0.d.l, p0, 0x30);
            int v10 = p0.P;
            i0 i04 = p0.m();
            q q6 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            androidx.compose.runtime.w.x(p0, p01, h4);
            androidx.compose.runtime.w.x(p0, i04, h5);
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v10)) {
                A7.d.q(v10, p0, v10, h6);
            }
            androidx.compose.runtime.w.x(p0, q6, h7);
            long v11 = e0.T(p0, 0x7F06017C);  // color:green500s_support_high_contrast
            N1.b(listeningUiState0.getGenderInfo().getPrimary().getTitle(), null, e0.T(p0, 0x7F06016D), 18.0f, y2, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);  // color:gray900s
            M.c.d(p0, d.q(n0, 4.0f));
            String s = listeningUiState0.getGenderInfo().getPrimary().getPercent();
            String s1 = "0";
            if(s.length() == 0) {
                s = "0";
            }
            N1.b((s + "%"), null, v11, 14.0f, y2, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);
            if(f >= 360.0f) {
                p0.a0(0x1069E3A3);
                if(kotlin.jvm.internal.q.b(listeningUiState0.getGenderInfo().getPrimary().getPercent(), listeningUiState0.getGenderInfo().getSecondary().getPercent())) {
                    p0.a0(0x106B5A6C);
                    p0.p(false);
                    v12 = v11;
                }
                else {
                    v12 = A7.d.f(p0, 0x106C9DBE, 0x7F060160, p0, false);  // color:gray600s_support_high_contrast
                }
                M.c.d(p0, d.q(n0, 6.0f));
                N1.b(listeningUiState0.getGenderInfo().getSecondary().getTitle(), null, e0.T(p0, 0x7F06016D), 18.0f, y2, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);  // color:gray900s
                M.c.d(p0, d.q(n0, 4.0f));
                String s2 = listeningUiState0.getGenderInfo().getSecondary().getPercent();
                if(s2.length() != 0) {
                    s1 = s2;
                }
                N1.b((s1 + "%"), null, v12, 14.0f, y2, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C00, 0, 0x1FFD2);
            }
            else {
                p0.a0(0xFFE64B8);
            }
            p0.p(false);
            A7.d.s(p0, true, true, true);
            M.c.d(p0, d.h(n0, 10.0f));
            ListeningGraphKt.DrawGraphCanvas-ziNgDLE(listeningUiState0.getListeningAges(), f, p0, 0);
            p0.p(true);
            return H.a;
        }
        p0.T();
        return H.a;
    }

    // 检测为 Lambda 实现
    public static H a(float f, Context context0, List list0, long v, float f1, A0.f f2) [...]

    // 检测为 Lambda 实现
    public static H c(List list0, float f, int v, l l0, int v1) [...]

    public static H d(ListeningUiState listeningUiState0, int v, l l0, int v1) {
        return ListeningGraphKt.ListeningGraph$lambda$10(listeningUiState0, v, l0, v1);
    }

    private static final void drawBottomText-S-AsslU(A0.f f0, Context context0, String s, long v, long v1) {
        TextPaint textPaint0 = new TextPaint();
        textPaint0.setTextSize(((float)ViewUtilsKt.dpToPx(12)));
        textPaint0.setTextAlign(Paint.Align.CENTER);
        textPaint0.setTypeface(d5.f.G(context0));
        textPaint0.setColor(ColorUtils.getColor(context0, 0x7F06015D));  // color:gray500s_support_high_contrast
        float f1 = Float.intBitsToFloat(((int)(0xFFFFFFFFL & v1))) - textPaint0.getFontMetrics().bottom;
        y0.c.a(f0.a0().h()).drawText(s, Float.intBitsToFloat(((int)(v1 >> 0x20))) / 2.0f + Float.intBitsToFloat(((int)(v >> 0x20))), f1, textPaint0);
    }

    private static final void drawGraph-yzxVdVo(A0.f f0, Context context0, List list0, long v, float f1) {
        Iterator iterator0 = list0.iterator();
        if(!iterator0.hasNext()) {
            throw new NoSuchElementException();
        }
        Object object0 = iterator0.next();
        if(iterator0.hasNext()) {
            int v1 = ((ListeningAge)object0).getPercentage();
            while(true) {
                Object object1 = iterator0.next();
                int v2 = ((ListeningAge)object1).getPercentage();
                if(v1 < v2) {
                    object0 = object1;
                    v1 = v2;
                }
                if(!iterator0.hasNext()) {
                    break;
                }
            }
        }
        List list1 = e.k.A(new s[]{new s(M.c(ColorUtils.getColor(context0, 0x7F060172, 0.4f))), new s(M.c(ColorUtils.getColor(context0, 0x7F060172, 0.1f))), new s(M.c(ColorUtils.getColor(context0, 0x7F060172, 0.0f)))});  // color:gray990s
        List list2 = e.k.A(new s[]{new s(M.c(ColorUtils.getColor(context0, 0x7F06017C, 1.0f))), new s(M.c(ColorUtils.getColor(context0, 0x7F06017C, 0.4f))), new s(M.c(ColorUtils.getColor(context0, 0x7F06017C, 0.0f)))});  // color:green500s_support_high_contrast
        int v3 = 0;
        for(Object object2: list0) {
            if(v3 >= 0) {
                long v4 = ListeningGraphKt.getColumnOffset(Float.intBitsToFloat(((int)(v >> 0x20))), f1, v3);
                float f2 = Float.intBitsToFloat(((int)(f0.c() & 0xFFFFFFFFL))) - f0.Y(47.0f);
                long v5 = ListeningGraphKt.getBarSize(f2, ((ListeningAge)object2).getPercentage());
                int v6 = (int)(v5 & 0xFFFFFFFFL);
                long v7 = ((long)Float.floatToRawIntBits((Float.intBitsToFloat(((int)(v >> 0x20))) - Float.intBitsToFloat(((int)(v5 >> 0x20)))) / 2.0f + Float.intBitsToFloat(((int)(v4 >> 0x20))))) << 0x20 | ((long)Float.floatToRawIntBits(f2 - Float.intBitsToFloat(((int)(v5 & 0xFFFFFFFFL))) + f0.Y(20.0f))) & 0xFFFFFFFFL;
                if(((ListeningAge)object2).getPercentage() > 0) {
                    ListeningGraphKt.drawGraphBar-4L21HEs(f0, v7, v5, u.f((((ListeningAge)object0).getPercentage() == ((ListeningAge)object2).getPercentage() ? list2 : list1), Float.intBitsToFloat(((int)(v7 & 0xFFFFFFFFL))), Float.intBitsToFloat(v6) + Float.intBitsToFloat(((int)(v7 & 0xFFFFFFFFL))), 8));
                }
                ListeningGraphKt.drawTopText-F0iM_J4(f0, context0, ((ListeningAge)object2).getPercentage(), ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v7 & 0xFFFFFFFFL))) - f0.Y(20.0f))) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(v4 >> 0x20))))) << 0x20, Float.intBitsToFloat(((int)(v >> 0x20))), ColorUtils.getColor(context0, (((ListeningAge)object0).getPercentage() == ((ListeningAge)object2).getPercentage() ? 0x7F06016D : 0x7F060160)));  // color:gray900s
                ListeningGraphKt.drawBottomText-S-AsslU(f0, context0, ((ListeningAge)object2).getTitle(), v4, v);
                ++v3;
                continue;
            }
            e.k.O();
            throw null;
        }
    }

    private static final void drawGraphBar-4L21HEs(A0.f f0, long v, long v1, y0.o o0) {
        float f1 = Float.intBitsToFloat(((int)(v1 >> 0x20)));
        long v2 = ((long)Float.floatToRawIntBits(f1 / 2.0f)) << 0x20 | 0xFFFFFFFFL & ((long)Float.floatToRawIntBits(f1 / 2.0f));
        x0.c c0 = e.k.d(v, v1);
        y0.g g0 = y0.j.a();
        L.a(g0, e1.b.k(c0, v2, v2));
        A0.f.M(f0, g0, o0, 0.0f, null, 60);
    }

    private static final void drawTopText-F0iM_J4(A0.f f0, Context context0, int v, long v1, float f1, int v2) {
        TextPaint textPaint0 = new TextPaint();
        textPaint0.setTextSize(((float)ViewUtilsKt.dpToPx(12)));
        textPaint0.setTextAlign(Paint.Align.CENTER);
        textPaint0.setTypeface(d5.f.G(context0));
        textPaint0.setColor(v2);
        int v3 = ViewUtilsKt.dpToPx(14);
        y0.c.a(f0.a0().h()).drawText(v + "%", f1 / 2.0f + Float.intBitsToFloat(((int)(v1 >> 0x20))), Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))) + ((float)v3), textPaint0);
    }

    private static final long getBarSize(float f, int v) {
        return ((long)Float.floatToRawIntBits(f * ((float)v) / 100.0f)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(ViewUtilsKt.dpToPx(24))) << 0x20;
    }

    // 去混淆评级： 低(20)
    private static final long getColumnOffset(float f, float f1, int v) {
        return v <= 0 ? 0L : ((long)Float.floatToRawIntBits((f + f1) * ((float)v))) << 0x20;
    }

    private static final void logMessage(String s) {
    }
}

