package y0;

import android.graphics.Matrix;
import android.graphics.Path.FillType;
import android.graphics.Path.Op;
import android.graphics.Path;
import android.graphics.RectF;
import kotlin.jvm.internal.q;
import x0.c;

public final class g implements L {
    public final Path a;
    public RectF b;
    public float[] c;
    public Matrix d;

    public g(Path path0) {
        this.a = path0;
    }

    public final c c() {
        if(this.b == null) {
            this.b = new RectF();
        }
        RectF rectF0 = this.b;
        q.d(rectF0);
        this.a.computeBounds(rectF0, true);
        return new c(rectF0.left, rectF0.top, rectF0.right, rectF0.bottom);
    }

    public final void d(float f, float f1) {
        this.a.lineTo(f, f1);
    }

    public final void e(float f, float f1) {
        this.a.moveTo(f, f1);
    }

    public final boolean f(L l0, L l1, int v) {
        Path.Op path$Op0;
        if(v == 0) {
            path$Op0 = Path.Op.DIFFERENCE;
        }
        else {
            switch(v) {
                case 1: {
                    path$Op0 = Path.Op.INTERSECT;
                    break;
                }
                case 2: {
                    path$Op0 = Path.Op.UNION;
                    break;
                }
                case 4: {
                    path$Op0 = Path.Op.REVERSE_DIFFERENCE;
                    break;
                }
                default: {
                    path$Op0 = Path.Op.XOR;
                }
            }
        }
        if(!(l0 instanceof g)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        Path path0 = ((g)l0).a;
        if(!(l1 instanceof g)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        return this.a.op(path0, ((g)l1).a, path$Op0);
    }

    public final void g() {
        this.a.reset();
    }

    public final void h(int v) {
        this.a.setFillType((v == 1 ? Path.FillType.EVEN_ODD : Path.FillType.WINDING));
    }

    public final void i(long v) {
        Matrix matrix0 = this.d;
        if(matrix0 == null) {
            this.d = new Matrix();
        }
        else {
            q.d(matrix0);
            matrix0.reset();
        }
        Matrix matrix1 = this.d;
        q.d(matrix1);
        matrix1.setTranslate(Float.intBitsToFloat(((int)(v >> 0x20))), Float.intBitsToFloat(((int)(v & 0xFFFFFFFFL))));
        Matrix matrix2 = this.d;
        q.d(matrix2);
        this.a.transform(matrix2);
    }
}

