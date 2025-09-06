package y0;

import A1.k;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;

public final class b implements q {
    public Canvas a;
    public Rect b;
    public Rect c;

    public b() {
        this.a = c.a;
    }

    @Override  // y0.q
    public final void a(L l0) {
        Canvas canvas0 = this.a;
        if(!(l0 instanceof g)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas0.clipPath(((g)l0).a, Region.Op.INTERSECT);
    }

    @Override  // y0.q
    public final void b(float f, float f1) {
        this.a.scale(f, f1);
    }

    @Override  // y0.q
    public final void d(x0.c c0, J j0) {
        this.a.saveLayer(c0.a, c0.b, c0.c, c0.d, ((Paint)((k)j0).c), 0x1F);
    }

    @Override  // y0.q
    public final void e(L l0, J j0) {
        Canvas canvas0 = this.a;
        if(!(l0 instanceof g)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas0.drawPath(((g)l0).a, ((Paint)((k)j0).c));
    }

    @Override  // y0.q
    public final void f(long v, long v1, J j0) {
        this.a.drawLine(Float.intBitsToFloat(((int)(v >> 0x20))), Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))), Float.intBitsToFloat(((int)(v1 >> 0x20))), Float.intBitsToFloat(((int)(v1 & 0xFFFFFFFFL))), ((Paint)((k)j0).c));
    }

    @Override  // y0.q
    public final void g(float f, float f1, float f2, float f3, float f4, float f5, J j0) {
        this.a.drawRoundRect(f, f1, f2, f3, f4, f5, ((Paint)((k)j0).c));
    }

    @Override  // y0.q
    public final void h(float f, float f1, float f2, float f3, int v) {
        this.a.clipRect(f, f1, f2, f3, (v == 0 ? Region.Op.DIFFERENCE : Region.Op.INTERSECT));
    }

    @Override  // y0.q
    public final void i(float f, float f1) {
        this.a.translate(f, f1);
    }

    @Override  // y0.q
    public final void j() {
        this.a.restore();
    }

    @Override  // y0.q
    public final void k(float f, float f1, float f2, float f3, J j0) {
        this.a.drawRect(f, f1, f2, f3, ((Paint)((k)j0).c));
    }

    @Override  // y0.q
    public final void l(float f, long v, J j0) {
        this.a.drawCircle(Float.intBitsToFloat(((int)(v >> 0x20))), Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))), f, ((Paint)((k)j0).c));
    }

    @Override  // y0.q
    public final void m() {
        M.n(this.a, true);
    }

    @Override  // y0.q
    public final void n(e e0, long v, long v1, long v2, J j0) {
        if(this.b == null) {
            this.b = new Rect();
            this.c = new Rect();
        }
        Canvas canvas0 = this.a;
        Bitmap bitmap0 = M.j(e0);
        Rect rect0 = this.b;
        kotlin.jvm.internal.q.d(rect0);
        rect0.left = (int)(v >> 0x20);
        rect0.top = (int)(v & 0xFFFFFFFFL);
        rect0.right = ((int)(v >> 0x20)) + ((int)(v1 >> 0x20));
        rect0.bottom = ((int)(v & 0xFFFFFFFFL)) + ((int)(v1 & 0xFFFFFFFFL));
        Rect rect1 = this.c;
        kotlin.jvm.internal.q.d(rect1);
        rect1.left = 0;
        rect1.top = 0;
        rect1.right = (int)(v2 >> 0x20);
        rect1.bottom = (int)(0xFFFFFFFFL & v2);
        canvas0.drawBitmap(bitmap0, rect0, rect1, ((Paint)((k)j0).c));
    }

    @Override  // y0.q
    public final void o(float f, float f1, float f2, float f3, float f4, float f5, boolean z, J j0) {
        this.a.drawArc(f, f1, f2, f3, f4, f5, z, ((Paint)((k)j0).c));
    }

    @Override  // y0.q
    public final void p(float f) {
        this.a.rotate(f);
    }

    @Override  // y0.q
    public final void q() {
        this.a.save();
    }

    @Override  // y0.q
    public final void r() {
        M.n(this.a, false);
    }

    @Override  // y0.q
    public final void s(float[] arr_f) {
        if(!M.p(arr_f)) {
            Matrix matrix0 = new Matrix();
            M.r(matrix0, arr_f);
            this.a.concat(matrix0);
        }
    }

    @Override  // y0.q
    public final void t(e e0, J j0) {
        this.a.drawBitmap(M.j(e0), 0.0f, 0.0f, ((Paint)((k)j0).c));
    }
}

