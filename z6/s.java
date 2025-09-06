package z6;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import y6.a;

public final class s extends w {
    public final u c;
    public final float d;
    public final float e;

    public s(u u0, float f, float f1) {
        this.c = u0;
        this.d = f;
        this.e = f1;
    }

    @Override  // z6.w
    public final void a(Matrix matrix0, a a0, int v, Canvas canvas0) {
        RectF rectF0 = new RectF(0.0f, 0.0f, ((float)Math.hypot(this.c.c - this.e, this.c.b - this.d)), 0.0f);
        this.a.set(matrix0);
        this.a.preTranslate(this.d, this.e);
        float f = this.b();
        this.a.preRotate(f);
        a0.getClass();
        rectF0.bottom += (float)v;
        rectF0.offset(0.0f, ((float)(-v)));
        a.i[0] = a0.f;
        a.i[1] = a0.e;
        a.i[2] = a0.d;
        LinearGradient linearGradient0 = new LinearGradient(rectF0.left, rectF0.top, rectF0.left, rectF0.bottom, a.i, a.j, Shader.TileMode.CLAMP);
        a0.c.setShader(linearGradient0);
        canvas0.save();
        canvas0.concat(this.a);
        canvas0.drawRect(rectF0, a0.c);
        canvas0.restore();
    }

    public final float b() {
        return (float)Math.toDegrees(Math.atan((this.c.c - this.e) / (this.c.b - this.d)));
    }
}

