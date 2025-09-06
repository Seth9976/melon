package k1;

import A0.h;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import kotlin.jvm.internal.q;
import r1.c;
import ye.a;

public final class b implements LeadingMarginSpan {
    public final float a;
    public final float b;
    public final int c;
    public final int d;

    public b(float f, float f1, float f2, c c0, float f3) {
        this.a = f;
        this.b = f1;
        int v = a.V(f + f2);
        this.c = v;
        this.d = a.V(f3) - v;
    }

    @Override  // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas canvas0, Paint paint0, int v, int v1, int v2, int v3, int v4, CharSequence charSequence0, int v5, int v6, boolean z, Layout layout0) {
        if(canvas0 != null) {
            int v7 = v - this.c >= 0 ? v - this.c : 0;
            q.e(charSequence0, "null cannot be cast to non-null type android.text.Spanned");
            if(((Spanned)charSequence0).getSpanStart(this) == v5 && paint0 != null) {
                Paint.Style paint$Style0 = paint0.getStyle();
                if(h.b.equals(h.b)) {
                    paint0.setStyle(Paint.Style.FILL);
                }
                k1.a a0 = new k1.a(this, ((long)Float.floatToRawIntBits(this.b)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(this.a)) << 0x20, v1, canvas0, paint0, v7, ((float)(v2 + v4)) / 2.0f);
                Integer integer0 = paint0.getAlpha();
                paint0.setAlpha(0xFF);
                a0.invoke();
                if(integer0 != null) {
                    paint0.setAlpha(integer0.intValue());
                }
                paint0.setStyle(paint$Style0);
            }
        }
    }

    @Override  // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean z) {
        return this.d < 0 ? Math.abs(this.d) : 0;
    }
}

