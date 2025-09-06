package y6;

import S1.c;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path;

public final class a {
    public final Paint a;
    public final Paint b;
    public final Paint c;
    public int d;
    public int e;
    public int f;
    public final Path g;
    public final Paint h;
    public static final int[] i;
    public static final float[] j;
    public static final int[] k;
    public static final float[] l;

    static {
        a.i = new int[3];
        a.j = new float[]{0.0f, 0.5f, 1.0f};
        a.k = new int[4];
        a.l = new float[]{0.0f, 0.0f, 0.5f, 1.0f};
    }

    public a() {
        this.g = new Path();
        Paint paint0 = new Paint();
        this.h = paint0;
        this.a = new Paint();
        this.a(0xFF000000);
        paint0.setColor(0);
        Paint paint1 = new Paint(4);
        this.b = paint1;
        paint1.setStyle(Paint.Style.FILL);
        this.c = new Paint(paint1);
    }

    public final void a(int v) {
        this.d = c.k(v, 68);
        this.e = c.k(v, 20);
        this.f = c.k(v, 0);
        this.a.setColor(this.d);
    }
}

