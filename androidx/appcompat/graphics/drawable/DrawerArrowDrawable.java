package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import g.a;

public class DrawerArrowDrawable extends Drawable {
    public final Paint a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final boolean f;
    public final Path g;
    public final int h;
    public float i;
    public final float j;
    public final int k;
    public static final float l;

    static {
        DrawerArrowDrawable.l = 0.785398f;
    }

    public DrawerArrowDrawable(Context context0) {
        Paint paint0 = new Paint();
        this.a = paint0;
        this.g = new Path();
        this.k = 2;
        paint0.setStyle(Paint.Style.STROKE);
        paint0.setStrokeJoin(Paint.Join.MITER);
        paint0.setStrokeCap(Paint.Cap.BUTT);
        paint0.setAntiAlias(true);
        TypedArray typedArray0 = context0.getTheme().obtainStyledAttributes(null, a.o, 0x7F040225, 0x7F1400E0);  // attr:drawerArrowStyle
        int v = typedArray0.getColor(3, 0);
        if(v != paint0.getColor()) {
            paint0.setColor(v);
            this.invalidateSelf();
        }
        float f = typedArray0.getDimension(7, 0.0f);
        if(paint0.getStrokeWidth() != f) {
            paint0.setStrokeWidth(f);
            this.j = (float)(Math.cos(DrawerArrowDrawable.l) * ((double)(f / 2.0f)));
            this.invalidateSelf();
        }
        boolean z = typedArray0.getBoolean(6, true);
        if(this.f != z) {
            this.f = z;
            this.invalidateSelf();
        }
        float f1 = (float)Math.round(typedArray0.getDimension(5, 0.0f));
        if(f1 != this.e) {
            this.e = f1;
            this.invalidateSelf();
        }
        this.h = typedArray0.getDimensionPixelSize(4, 0);
        this.c = (float)Math.round(typedArray0.getDimension(2, 0.0f));
        this.b = (float)Math.round(typedArray0.getDimension(0, 0.0f));
        this.d = typedArray0.getDimension(1, 0.0f);
        typedArray0.recycle();
    }

    public static float a(float f, float f1, float f2) {
        return (f1 - f) * f2 + f;
    }

    @Override  // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas0) {
        Rect rect0 = this.getBounds();
        boolean z = false;
        switch(this.k) {
            case 0: {
                break;
            }
            case 1: {
                z = true;
                break;
            }
            case 3: {
                if(this.getLayoutDirection() == 0) {
                    z = true;
                }
                break;
            }
            default: {
                if(this.getLayoutDirection() == 1) {
                    z = true;
                }
            }
        }
        float f = DrawerArrowDrawable.a(this.c, ((float)Math.sqrt(this.b * this.b * 2.0f)), this.i);
        float f1 = DrawerArrowDrawable.a(this.c, this.d, this.i);
        float f2 = (float)Math.round(DrawerArrowDrawable.a(0.0f, this.j, this.i));
        float f3 = DrawerArrowDrawable.a(0.0f, DrawerArrowDrawable.l, this.i);
        float f4 = DrawerArrowDrawable.a((z ? 0.0f : -180.0f), (z ? 180.0f : 0.0f), this.i);
        float f5 = (float)Math.round(Math.cos(f3) * ((double)f));
        float f6 = (float)Math.round(Math.sin(f3) * ((double)f));
        Path path0 = this.g;
        path0.rewind();
        Paint paint0 = this.a;
        float f7 = paint0.getStrokeWidth();
        float f8 = DrawerArrowDrawable.a(this.e + f7, -this.j, this.i);
        path0.moveTo(-f1 / 2.0f + f2, 0.0f);
        path0.rLineTo(f1 - f2 * 2.0f, 0.0f);
        path0.moveTo(-f1 / 2.0f, f8);
        path0.rLineTo(f5, f6);
        path0.moveTo(-f1 / 2.0f, -f8);
        path0.rLineTo(f5, -f6);
        path0.close();
        canvas0.save();
        float f9 = paint0.getStrokeWidth();
        float f10 = ((float)rect0.height()) - 3.0f * f9;
        canvas0.translate(((float)rect0.centerX()), f9 * 1.5f + this.e + ((float)(((int)(f10 - this.e * 2.0f)) / 4 * 2)));
        if(this.f) {
            canvas0.rotate(f4 * ((float)(z ? -1 : 1)));
        }
        else if(z) {
            canvas0.rotate(180.0f);
        }
        canvas0.drawPath(path0, paint0);
        canvas0.restore();
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.h;
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.h;
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setAlpha(int v) {
        Paint paint0 = this.a;
        if(v != paint0.getAlpha()) {
            paint0.setAlpha(v);
            this.invalidateSelf();
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter0) {
        this.a.setColorFilter(colorFilter0);
        this.invalidateSelf();
    }
}

