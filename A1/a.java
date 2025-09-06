package a1;

import T7.b;
import W.m;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.SegmentFinder;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.text.TextUtils;
import androidx.compose.runtime.O0;
import b1.f;
import b1.i;
import c2.Y;
import i.n.i.b.a.s.e.M3;
import i1.c;
import java.util.ArrayList;
import je.w;
import k1.d;
import kotlin.jvm.internal.q;
import l1.j;
import l1.l;
import r1.o;
import x0.e;
import y0.P;

public final class a {
    public final c a;
    public final int b;
    public final long c;
    public final i d;
    public final CharSequence e;
    public final Object f;

    public a(c c0, int v, int v1, long v2) {
        w w0;
        x0.c c1;
        float f7;
        float f5;
        float f2;
        d[] arr_d;
        int v17;
        TextUtils.TruncateAt textUtils$TruncateAt1;
        M m2;
        int v14;
        TextUtils.TruncateAt textUtils$TruncateAt0;
        int v13;
        int v12;
        M m1;
        int v11;
        int v10;
        int v9;
        int v7;
        int v5;
        this.a = c0;
        this.b = v;
        this.c = v2;
        if(r1.a.i(v2) != 0 || r1.a.j(v2) != 0) {
            g1.a.a("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        if(v < 1) {
            g1.a.a("maxLines should be greater than 0");
        }
        U u0 = c0.b;
        CharSequence charSequence0 = c0.h;
        if(v1 == 2 && (!o.a(u0.a.h, 0x100000000L) && !o.a(u0.a.h, o.c) && (u0.b.a != 0x80000000 && u0.b.a != 4 && u0.b.a != 5) && charSequence0.length() != 0)) {
            Spannable spannable0 = charSequence0 instanceof Spannable ? ((Spannable)charSequence0) : null;
            if(spannable0 == null) {
                spannable0 = new SpannableString(charSequence0);
            }
            charSequence0 = spannable0;
            if(!f.f(((Spanned)charSequence0), d1.c.class)) {
                ((Spannable)charSequence0).setSpan(new d1.c(), charSequence0.length() - 1, charSequence0.length() - 1, 33);  // 初始化器: Ljava/lang/Object;-><init>()V
            }
        }
        this.e = charSequence0;
        D d0 = u0.b;
        M m0 = u0.a;
        int v3 = d0.a;
        int v4 = 3;
        switch(v3) {
            case 1: {
                v5 = 3;
                break;
            }
            case 2: {
                v5 = 4;
                break;
            }
            case 3: {
                v5 = 2;
                break;
            }
            case 6: {
                v5 = 1;
                break;
            }
            default: {
                v5 = 0;
            }
        }
        int v6 = v3 == 4 ? 1 : 0;
        if(d0.h != 2) {
            v7 = 0;
        }
        else if(Build.VERSION.SDK_INT <= 0x20) {
            v7 = 2;
        }
        else {
            v7 = 4;
        }
        int v8 = d0.g;
        switch(v8 & 0xFF) {
            case 2: {
                v9 = v8;
                v10 = v6;
                v11 = 1;
                break;
            }
            case 3: {
                v9 = v8;
                v10 = v6;
                v11 = 2;
                break;
            }
            default: {
                v9 = v8;
                v10 = v6;
                v11 = 0;
            }
        }
        switch(v9 >> 8 & 0xFF) {
            case 2: {
                v4 = 1;
                break;
            }
            case 3: {
                v4 = 2;
                break;
            }
            case 4: {
                break;
            }
            default: {
                v4 = 0;
            }
        }
        if((v9 >> 16 & 0xFF) == 2) {
            m1 = m0;
            v12 = v5;
            v13 = 1;
        }
        else {
            m1 = m0;
            v12 = v5;
            v13 = 0;
        }
        if(v1 == 2) {
            textUtils$TruncateAt0 = TextUtils.TruncateAt.END;
            goto label_78;
        }
        else {
            switch(v1) {
                case 4: {
                    textUtils$TruncateAt0 = TextUtils.TruncateAt.START;
                    goto label_78;
                }
                case 5: {
                    textUtils$TruncateAt0 = TextUtils.TruncateAt.MIDDLE;
                label_78:
                    v14 = v7;
                    m2 = m1;
                    textUtils$TruncateAt1 = textUtils$TruncateAt0;
                    break;
                }
                default: {
                    v14 = v7;
                    m2 = m1;
                    textUtils$TruncateAt1 = null;
                }
            }
        }
        i i0 = this.a(v12, v10, textUtils$TruncateAt1, v, v14, v11, v4, v13, charSequence0);
        Layout layout0 = i0.f;
        if(Build.VERSION.SDK_INT >= 35 || c0.g.getLetterSpacing() == 0.0f) {
            v17 = v12;
        }
        else if((v1 == 4 || v1 == 5) && layout0.getEllipsisCount(0) > 0) {
            int v15 = layout0.getEllipsisStart(0);
            int v16 = layout0.getEllipsisCount(0);
            v17 = v12;
            i0 = this.a(v17, v10, textUtils$TruncateAt1, v, v14, v11, v4, v13, TextUtils.concat(new CharSequence[]{charSequence0.subSequence(0, v15), "…", charSequence0.subSequence(v16 + v15, charSequence0.length())}));
        }
        else {
            v17 = v12;
        }
        int v18 = i0.g;
        if(v1 == 2 && i0.a() > r1.a.g(v2) && v > 1) {
            int v19 = r1.a.g(v2);
            int v20;
            for(v20 = 0; true; ++v20) {
                if(v20 >= v18) {
                    v20 = v18;
                    break;
                }
                if(i0.e(v20) > ((float)v19)) {
                    break;
                }
            }
            if(v20 >= 0 && v20 != this.b) {
                i0 = this.a(v17, v10, textUtils$TruncateAt1, (v20 >= 1 ? v20 : 1), v14, v11, v4, v13, this.e);
            }
        }
        this.d = i0;
        y0.o o0 = m2.a.c();
        float f = this.b();
        float f1 = m2.a.a();
        this.a.g.c(o0, ((long)Float.floatToRawIntBits(f)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(this.d())) << 0x20, f1);
        Layout layout1 = this.d.f;
        if(layout1.getText() instanceof Spanned) {
            CharSequence charSequence1 = layout1.getText();
            q.e(charSequence1, "null cannot be cast to non-null type android.text.Spanned");
            int v21 = ((Spanned)charSequence1).length();
            Class class0 = d.class;
            if(((Spanned)charSequence1).nextSpanTransition(-1, v21, class0) == ((Spanned)charSequence1).length()) {
                arr_d = null;
            }
            else {
                CharSequence charSequence2 = layout1.getText();
                q.e(charSequence2, "null cannot be cast to non-null type android.text.Spanned");
                arr_d = (d[])((Spanned)charSequence2).getSpans(0, layout1.getText().length(), class0);
            }
        }
        else {
            arr_d = null;
        }
        if(arr_d != null) {
            Y y0 = q.j(arr_d);
            while(y0.hasNext()) {
                d d1 = (d)y0.next();
                e e0 = new e(((long)Float.floatToRawIntBits(this.b())) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(this.d())) << 0x20);
                ((O0)d1.c).setValue(e0);
            }
        }
        CharSequence charSequence3 = this.e;
        if(charSequence3 instanceof Spanned) {
            Object[] arr_object = ((Spanned)charSequence3).getSpans(0, charSequence3.length(), d1.i.class);
            ArrayList arrayList0 = new ArrayList(arr_object.length);
            for(int v22 = 0; v22 < arr_object.length; ++v22) {
                d1.i i1 = (d1.i)arr_object[v22];
                int v23 = ((Spanned)charSequence3).getSpanStart(i1);
                int v24 = ((Spanned)charSequence3).getSpanEnd(i1);
                int v25 = this.d.f.getLineForOffset(v23);
                if(this.d.f.getEllipsisCount(v25) > 0 && v24 > this.d.f.getEllipsisStart(v25) || v24 > this.d.f(v25) || v25 >= this.b) {
                    c1 = null;
                }
                else {
                    switch((this.d.f.isRtlCharAt(v23) ? j.b : j.a).ordinal()) {
                        case 0: {
                            f2 = this.d.h(v23, false);
                            break;
                        }
                        case 1: {
                            float f3 = this.d.h(v23, false);
                            if(!i1.j) {
                                g1.a.c("PlaceholderSpan is not laid out yet.");
                            }
                            f2 = f3 - ((float)i1.h);
                            break;
                        }
                        default: {
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                    }
                    if(!i1.j) {
                        g1.a.c("PlaceholderSpan is not laid out yet.");
                    }
                    float f4 = ((float)i1.h) + f2;
                    i i2 = this.d;
                    switch(i1.f) {
                        case 0: {
                            f5 = i2.d(v25) - ((float)i1.b());
                            break;
                        }
                        case 1: {
                            f5 = i2.g(v25);
                            break;
                        }
                        case 2: {
                            f5 = i2.e(v25) - ((float)i1.b());
                            break;
                        }
                        case 3: {
                            float f6 = i2.g(v25);
                            f5 = (i2.e(v25) + f6 - ((float)i1.b())) / 2.0f;
                            break;
                        }
                        case 4: {
                            f7 = (float)i1.a().ascent;
                            f5 = i2.d(v25) + f7;
                            break;
                        }
                        case 5: {
                            float f8 = (float)i1.a().descent;
                            f5 = i2.d(v25) + f8 - ((float)i1.b());
                            break;
                        }
                        case 6: {
                            Paint.FontMetricsInt paint$FontMetricsInt0 = i1.a();
                            f7 = (float)((paint$FontMetricsInt0.ascent + paint$FontMetricsInt0.descent - i1.b()) / 2);
                            f5 = i2.d(v25) + f7;
                            break;
                        }
                        default: {
                            throw new IllegalStateException("unexpected verticalAlignment");
                        }
                    }
                    c1 = new x0.c(f2, f5, f4, ((float)i1.b()) + f5);
                }
                arrayList0.add(c1);
            }
            w0 = arrayList0;
        }
        else {
            w0 = w.a;
        }
        this.f = w0;
    }

    public final i a(int v, int v1, TextUtils.TruncateAt textUtils$TruncateAt0, int v2, int v3, int v4, int v5, int v6, CharSequence charSequence0) {
        float f = this.d();
        i1.d d0 = this.a.g;
        int v7 = this.a.l;
        b1.e e0 = this.a.i;
        H h0 = this.a.b.c;
        if(h0 != null) {
            return h0.a == null ? new i(charSequence0, f, d0, v, textUtils$TruncateAt0, v7, false, v2, v4, v5, v6, v3, v1, e0) : new i(charSequence0, f, d0, v, textUtils$TruncateAt0, v7, h0.a.a, v2, v4, v5, v6, v3, v1, e0);
        }
        return new i(charSequence0, f, d0, v, textUtils$TruncateAt0, v7, false, v2, v4, v5, v6, v3, v1, e0);
    }

    public final float b() {
        return (float)this.d.a();
    }

    public final long c(x0.c c0, int v, b b0) {
        x9.b b1;
        int[] arr_v;
        RectF rectF0 = y0.M.x(c0);
        F.e e0 = new F.e(b0, 15);
        i i0 = this.d;
        TextPaint textPaint0 = i0.a;
        Layout layout0 = i0.f;
        int v1 = Build.VERSION.SDK_INT;
        if(v1 >= 34) {
            SegmentFinder segmentFinder0 = v == 1 ? new c1.a(new x9.b(layout0.getText(), i0.j())) : m.l(m.k(layout0.getText(), textPaint0));
            arr_v = layout0.getRangeForRect(rectF0, segmentFinder0, new b1.a(e0));
            return arr_v == null ? T.b : t.b(arr_v[0], arr_v[1]);
        }
        H8.i i1 = i0.c();
        if(v == 1) {
            b1 = new x9.b(layout0.getText(), i0.j());
        }
        else {
            CharSequence charSequence0 = layout0.getText();
            b1 = v1 >= 29 ? new c1.b(charSequence0, textPaint0) : new c1.c(charSequence0);
        }
        int v2 = layout0.getLineForVertical(((int)rectF0.top));
        if(rectF0.top > i0.e(v2)) {
            ++v2;
            if(v2 < i0.g) {
                goto label_26;
            }
        }
        else {
        label_26:
            int v3 = v2;
            int v4 = layout0.getLineForVertical(((int)rectF0.bottom));
            if(v4 != 0 || rectF0.bottom >= i0.g(0)) {
                int v5;
                for(v5 = f.e(i0, layout0, i1, v3, rectF0, b1, e0, true); v5 == -1 && v3 < v4; v5 = f.e(i0, layout0, i1, v3, rectF0, b1, e0, true)) {
                    ++v3;
                }
                if(v5 != -1) {
                    int v6 = v4;
                    int v7;
                    for(v7 = f.e(i0, layout0, i1, v6, rectF0, b1, e0, false); v7 == -1 && v3 < v6; v7 = f.e(i0, layout0, i1, v6, rectF0, b1, e0, false)) {
                        --v6;
                    }
                    if(v7 != -1) {
                        arr_v = new int[]{b1.c(v5 + 1), b1.d(v7 - 1)};
                        return arr_v == null ? T.b : t.b(arr_v[0], arr_v[1]);
                    }
                }
            }
        }
        throw new NullPointerException();
    }

    public final float d() {
        return (float)r1.a.h(this.c);
    }

    public final void e(y0.q q0) {
        Canvas canvas0 = y0.c.a(q0);
        i i0 = this.d;
        if(i0.d) {
            canvas0.save();
            canvas0.clipRect(0.0f, 0.0f, this.d(), this.b());
        }
        int v = i0.h;
        if(canvas0.getClipBounds(i0.p)) {
            if(v != 0) {
                canvas0.translate(0.0f, ((float)v));
            }
            b1.j.a.a = canvas0;
            i0.f.draw(b1.j.a);
            if(v != 0) {
                canvas0.translate(0.0f, -1.0f * ((float)v));
            }
        }
        if(i0.d) {
            canvas0.restore();
        }
    }

    public final void f(y0.q q0, long v, P p0, l l0, A0.e e0) {
        int v1 = this.a.g.c;
        this.a.g.d(v);
        this.a.g.f(p0);
        this.a.g.g(l0);
        this.a.g.e(e0);
        this.a.g.b(3);
        this.e(q0);
        this.a.g.b(v1);
    }

    public final void g(y0.q q0, y0.o o0, float f, P p0, l l0, A0.e e0) {
        int v = this.a.g.c;
        float f1 = this.b();
        this.a.g.c(o0, ((long)Float.floatToRawIntBits(f1)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(this.d())) << 0x20, f);
        this.a.g.f(p0);
        this.a.g.g(l0);
        this.a.g.e(e0);
        this.a.g.b(3);
        this.e(q0);
        this.a.g.b(v);
    }
}

