package com.iloen.melon.activity.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView.ScaleType;
import android.widget.ImageView;

abstract class ImageViewTouchBase extends ImageView {
    public final Matrix a;
    public final Matrix b;
    public final Matrix c;
    public final float[] d;
    public final b e;
    public int f;
    public int g;
    public float h;
    public final Handler i;
    public f j;

    public ImageViewTouchBase(Context context0) {
        super(context0);
        this.a = new Matrix();
        this.b = new Matrix();
        this.c = new Matrix();
        this.d = new float[9];
        this.e = new b(null);
        this.f = -1;
        this.g = -1;
        this.i = new Handler(Looper.getMainLooper());
        this.j = null;
        this.setScaleType(ImageView.ScaleType.MATRIX);
    }

    public ImageViewTouchBase(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = new Matrix();
        this.b = new Matrix();
        this.c = new Matrix();
        this.d = new float[9];
        this.e = new b(null);
        this.f = -1;
        this.g = -1;
        this.i = new Handler(Looper.getMainLooper());
        this.j = null;
        this.setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final void a() {
        float f4;
        b b0 = this.e;
        if(((Bitmap)b0.a) == null) {
            return;
        }
        Matrix matrix0 = this.getImageViewMatrix();
        float f = 0.0f;
        RectF rectF0 = new RectF(0.0f, 0.0f, ((float)((Bitmap)b0.a).getWidth()), ((float)((Bitmap)b0.a).getHeight()));
        matrix0.mapRect(rectF0);
        float f1 = rectF0.height();
        float f2 = rectF0.width();
        float f3 = (float)this.getHeight();
        if(Float.compare(f1, f3) < 0) {
            f4 = (f3 - f1) / 2.0f - rectF0.top;
        }
        else {
            float f5 = rectF0.top;
            if(f5 > 0.0f) {
                f4 = -f5;
            }
            else {
                f4 = rectF0.bottom < f3 ? ((float)this.getHeight()) - rectF0.bottom : 0.0f;
            }
        }
        float f6 = (float)this.getWidth();
        if(f2 < f6) {
            f = (f6 - f2) / 2.0f - rectF0.left;
        }
        else {
            float f7 = rectF0.left;
            if(f7 > 0.0f) {
                f = -f7;
            }
            else {
                float f8 = rectF0.right;
                if(f8 < f6) {
                    f = f6 - f8;
                }
            }
        }
        this.c(f, f4);
        this.setImageMatrix(this.getImageViewMatrix());
    }

    public final void b(b b0, Matrix matrix0) {
        float f = (float)this.getWidth();
        float f1 = (float)this.getHeight();
        float f2 = (float)((Bitmap)b0.a).getWidth();
        float f3 = (float)((Bitmap)b0.a).getHeight();
        matrix0.reset();
        float f4 = Math.min(Math.min(f / f2, 3.0f), Math.min(f1 / f3, 3.0f));
        matrix0.postConcat(new Matrix());
        matrix0.postScale(f4, f4);
        matrix0.postTranslate((f - f2 * f4) / 2.0f, (f1 - f3 * f4) / 2.0f);
    }

    public void c(float f, float f1) {
        this.b.postTranslate(f, f1);
    }

    public final void d(Bitmap bitmap0) {
        super.setImageBitmap(bitmap0);
        Drawable drawable0 = this.getDrawable();
        if(drawable0 != null) {
            drawable0.setDither(true);
        }
        this.e.a = bitmap0;
    }

    public void e(b b0) {
        if(this.getWidth() <= 0) {
            this.j = new f(this, b0, 2);
            return;
        }
        Matrix matrix0 = this.a;
        if(((Bitmap)b0.a) == null) {
            matrix0.reset();
            this.setImageBitmap(null);
        }
        else {
            this.b(b0, matrix0);
            this.d(((Bitmap)b0.a));
        }
        this.b.reset();
        this.setImageMatrix(this.getImageViewMatrix());
        Bitmap bitmap0 = (Bitmap)this.e.a;
        this.h = bitmap0 == null ? 1.0f : Math.max(((float)bitmap0.getWidth()) / ((float)this.f), ((float)((Bitmap)this.e.a).getHeight()) / ((float)this.g)) * 4.0f;
    }

    public void f(float f, float f1, float f2) {
        float f3 = this.h;
        if(f > f3) {
            f = f3;
        }
        float f4 = this.getScale();
        this.b.postScale(f / f4, f / f4, f1, f2);
        this.setImageMatrix(this.getImageViewMatrix());
        this.a();
    }

    public Matrix getImageViewMatrix() {
        this.c.set(this.a);
        this.c.postConcat(this.b);
        return this.c;
    }

    public float getScale() {
        this.b.getValues(this.d);
        return this.d[0];
    }

    @Override  // android.view.View
    public boolean onKeyDown(int v, KeyEvent keyEvent0) {
        if(v == 4 && keyEvent0.getRepeatCount() == 0) {
            keyEvent0.startTracking();
            return true;
        }
        return super.onKeyDown(v, keyEvent0);
    }

    @Override  // android.view.View
    public boolean onKeyUp(int v, KeyEvent keyEvent0) {
        if(v == 4 && keyEvent0.isTracking() && !keyEvent0.isCanceled() && this.getScale() > 1.0f) {
            this.f(1.0f, ((float)this.getWidth()) / 2.0f, ((float)this.getHeight()) / 2.0f);
            return true;
        }
        return super.onKeyUp(v, keyEvent0);
    }

    @Override  // android.view.View
    public void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        this.f = v2 - v;
        this.g = v3 - v1;
        f f0 = this.j;
        if(f0 != null) {
            this.j = null;
            f0.run();
        }
        b b0 = this.e;
        if(((Bitmap)b0.a) != null) {
            this.b(b0, this.a);
            this.setImageMatrix(this.getImageViewMatrix());
        }
    }

    @Override  // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap0) {
        this.d(bitmap0);
    }
}

