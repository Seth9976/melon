package z6;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.Shader.TileMode;
import y6.a;

public final class r extends w {
    public final t c;

    public r(t t0) {
        this.c = t0;
    }

    @Override  // z6.w
    public final void a(Matrix matrix0, a a0, int v, Canvas canvas0) {
        float f = this.c.f;
        float f1 = this.c.g;
        RectF rectF0 = new RectF(this.c.b, this.c.c, this.c.d, this.c.e);
        Paint paint0 = a0.b;
        boolean z = Float.compare(f1, 0.0f) < 0;
        Path path0 = a0.g;
        int[] arr_v = a.k;
        if(z) {
            arr_v[0] = 0;
            arr_v[1] = a0.f;
            arr_v[2] = a0.e;
            arr_v[3] = a0.d;
        }
        else {
            path0.rewind();
            path0.moveTo(rectF0.centerX(), rectF0.centerY());
            path0.arcTo(rectF0, f, f1);
            path0.close();
            float f2 = (float)(-v);
            rectF0.inset(f2, f2);
            arr_v[0] = 0;
            arr_v[1] = a0.d;
            arr_v[2] = a0.e;
            arr_v[3] = a0.f;
        }
        float f3 = rectF0.width();
        if(f3 / 2.0f <= 0.0f) {
            return;
        }
        float f4 = 1.0f - ((float)v) / (f3 / 2.0f);
        a.l[1] = f4;
        a.l[2] = (1.0f - f4) / 2.0f + f4;
        paint0.setShader(new RadialGradient(rectF0.centerX(), rectF0.centerY(), f3 / 2.0f, arr_v, a.l, Shader.TileMode.CLAMP));
        canvas0.save();
        canvas0.concat(matrix0);
        canvas0.scale(1.0f, rectF0.height() / rectF0.width());
        if(!z) {
            canvas0.clipPath(path0, Region.Op.DIFFERENCE);
            canvas0.drawPath(path0, a0.h);
        }
        canvas0.drawArc(rectF0, f, f1, true, paint0);
        canvas0.restore();
    }
}

