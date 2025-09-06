package k1;

import android.graphics.Canvas;
import android.graphics.Paint;
import e.k;
import ie.H;
import kotlin.jvm.internal.r;
import x0.d;
import x0.e;
import y0.I;
import y0.L;
import y0.g;
import y0.j;

public final class a extends r implements we.a {
    public final long f;
    public final int g;
    public final Canvas h;
    public final Paint i;
    public final int j;
    public final float k;

    public a(b b0, long v, int v1, Canvas canvas0, Paint paint0, int v2, float f) {
        this.f = v;
        this.g = v1;
        this.h = canvas0;
        this.i = paint0;
        this.j = v2;
        this.k = f;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        int v = this.g;
        float f = e.c(this.f);
        long v1 = ((long)Float.floatToRawIntBits(f / 2.0f)) << 0x20 | ((long)Float.floatToRawIntBits(f / 2.0f)) & 0xFFFFFFFFL;
        d d0 = e1.b.j(k.d(0L, this.f), v1, v1, v1, v1);
        new I(d0);
        float f1 = (float)this.j;
        Canvas canvas0 = this.h;
        Paint paint0 = this.i;
        float f2 = this.k;
        if(!e1.b.E(d0)) {
            g g0 = j.a();
            L.a(g0, d0);
            canvas0.save();
            canvas0.translate(f1, f2 - d0.a() / 2.0f);
            canvas0.drawPath(g0.a, paint0);
            canvas0.restore();
            return H.a;
        }
        float f3 = Float.intBitsToFloat(((int)(d0.e >> 0x20)));
        canvas0.drawRoundRect(f1, f2 - d0.a() / 2.0f, d0.b() * ((float)v) + f1, d0.a() / 2.0f + f2, f3, f3, paint0);
        return H.a;
    }
}

