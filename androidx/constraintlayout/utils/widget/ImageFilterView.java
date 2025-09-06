package androidx.constraintlayout.utils.widget;

import J1.b;
import J1.c;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path.Direction;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.q;
import d5.w;

public class ImageFilterView extends AppCompatImageView {
    public final c a;
    public boolean b;
    public Drawable c;
    public Drawable d;
    public float e;
    public float f;
    public float g;
    public Path h;
    public ViewOutlineProvider i;
    public RectF j;
    public final Drawable[] k;
    public LayerDrawable l;
    public float m;
    public float n;
    public float o;
    public float r;

    public ImageFilterView(Context context0) {
        super(context0);
        this.a = new c();
        this.b = true;
        this.c = null;
        this.d = null;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = NaNf;
        this.k = new Drawable[2];
        this.m = NaNf;
        this.n = NaNf;
        this.o = NaNf;
        this.r = NaNf;
    }

    public ImageFilterView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = new c();
        this.b = true;
        this.c = null;
        this.d = null;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = NaNf;
        this.k = new Drawable[2];
        this.m = NaNf;
        this.n = NaNf;
        this.o = NaNf;
        this.r = NaNf;
        this.c(context0, attributeSet0);
    }

    public ImageFilterView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = new c();
        this.b = true;
        this.c = null;
        this.d = null;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = NaNf;
        this.k = new Drawable[2];
        this.m = NaNf;
        this.n = NaNf;
        this.o = NaNf;
        this.r = NaNf;
        this.c(context0, attributeSet0);
    }

    public final void c(Context context0, AttributeSet attributeSet0) {
        if(attributeSet0 != null) {
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, q.j);
            int v = typedArray0.getIndexCount();
            this.c = typedArray0.getDrawable(0);
            for(int v1 = 0; v1 < v; ++v1) {
                switch(typedArray0.getIndex(v1)) {
                    case 2: {
                        this.setBrightness(typedArray0.getFloat(2, 0.0f));
                        break;
                    }
                    case 3: {
                        this.setContrast(typedArray0.getFloat(3, 0.0f));
                        break;
                    }
                    case 4: {
                        this.e = typedArray0.getFloat(4, 0.0f);
                        break;
                    }
                    case 5: {
                        this.setImagePanX(typedArray0.getFloat(5, this.m));
                        break;
                    }
                    case 6: {
                        this.setImagePanY(typedArray0.getFloat(6, this.n));
                        break;
                    }
                    case 7: {
                        this.setImageRotate(typedArray0.getFloat(7, this.r));
                        break;
                    }
                    case 8: {
                        this.setImageZoom(typedArray0.getFloat(8, this.o));
                        break;
                    }
                    case 9: {
                        this.setOverlay(typedArray0.getBoolean(9, this.b));
                        break;
                    }
                    case 10: {
                        this.setRound(typedArray0.getDimension(10, 0.0f));
                        break;
                    }
                    case 11: {
                        this.setRoundPercent(typedArray0.getFloat(11, 0.0f));
                        break;
                    }
                    case 12: {
                        this.setSaturation(typedArray0.getFloat(12, 0.0f));
                        break;
                    }
                    case 13: {
                        this.setWarmth(typedArray0.getFloat(13, 0.0f));
                    }
                }
            }
            typedArray0.recycle();
            Drawable drawable0 = this.getDrawable();
            this.d = drawable0;
            Drawable[] arr_drawable = this.k;
            if(this.c != null && drawable0 != null) {
                Drawable drawable1 = this.getDrawable().mutate();
                this.d = drawable1;
                arr_drawable[0] = drawable1;
                arr_drawable[1] = this.c.mutate();
                LayerDrawable layerDrawable0 = new LayerDrawable(arr_drawable);
                this.l = layerDrawable0;
                layerDrawable0.getDrawable(1).setAlpha(((int)(this.e * 255.0f)));
                if(!this.b) {
                    this.l.getDrawable(0).setAlpha(((int)((1.0f - this.e) * 255.0f)));
                }
                super.setImageDrawable(this.l);
                return;
            }
            Drawable drawable2 = this.getDrawable();
            this.d = drawable2;
            if(drawable2 != null) {
                Drawable drawable3 = drawable2.mutate();
                this.d = drawable3;
                arr_drawable[0] = drawable3;
            }
        }
    }

    public final void d() {
        float f = 0.0f;
        if(Float.isNaN(this.m) && Float.isNaN(this.n) && Float.isNaN(this.o) && Float.isNaN(this.r)) {
            return;
        }
        float f1 = Float.isNaN(this.m) ? 0.0f : this.m;
        float f2 = Float.isNaN(this.n) ? 0.0f : this.n;
        float f3 = Float.isNaN(this.o) ? 1.0f : this.o;
        if(!Float.isNaN(this.r)) {
            f = this.r;
        }
        Matrix matrix0 = new Matrix();
        matrix0.reset();
        float f4 = (float)this.getDrawable().getIntrinsicWidth();
        float f5 = (float)this.getDrawable().getIntrinsicHeight();
        float f6 = (float)this.getWidth();
        float f7 = (float)this.getHeight();
        float f8 = f3 * (f4 * f7 < f5 * f6 ? f6 / f4 : f7 / f5);
        matrix0.postScale(f8, f8);
        matrix0.postTranslate(((f6 - f4 * f8) * f1 + f6 - f4 * f8) * 0.5f, ((f7 - f8 * f5) * f2 + f7 - f8 * f5) * 0.5f);
        matrix0.postRotate(f, f6 / 2.0f, f7 / 2.0f);
        this.setImageMatrix(matrix0);
        this.setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final void e() {
        if(Float.isNaN(this.m) && Float.isNaN(this.n) && Float.isNaN(this.o) && Float.isNaN(this.r)) {
            this.setScaleType(ImageView.ScaleType.FIT_CENTER);
            return;
        }
        this.d();
    }

    public float getBrightness() {
        return this.a.d;
    }

    public float getContrast() {
        return this.a.f;
    }

    public float getCrossfade() {
        return this.e;
    }

    public float getImagePanX() {
        return this.m;
    }

    public float getImagePanY() {
        return this.n;
    }

    public float getImageRotate() {
        return this.r;
    }

    public float getImageZoom() {
        return this.o;
    }

    public float getRound() {
        return this.g;
    }

    public float getRoundPercent() {
        return this.f;
    }

    public float getSaturation() {
        return this.a.e;
    }

    public float getWarmth() {
        return this.a.g;
    }

    @Override  // android.view.View
    public final void layout(int v, int v1, int v2, int v3) {
        super.layout(v, v1, v2, v3);
        this.d();
    }

    public void setAltImageDrawable(Drawable drawable0) {
        Drawable drawable1 = drawable0.mutate();
        this.c = drawable1;
        this.k[0] = this.d;
        this.k[1] = drawable1;
        LayerDrawable layerDrawable0 = new LayerDrawable(this.k);
        this.l = layerDrawable0;
        super.setImageDrawable(layerDrawable0);
        this.setCrossfade(this.e);
    }

    public void setAltImageResource(int v) {
        Drawable drawable0 = w.B(this.getContext(), v);
        this.c = drawable0;
        this.setAltImageDrawable(drawable0);
    }

    public void setBrightness(float f) {
        this.a.d = f;
        this.a.a(this);
    }

    public void setContrast(float f) {
        this.a.f = f;
        this.a.a(this);
    }

    public void setCrossfade(float f) {
        this.e = f;
        if(this.k != null) {
            if(!this.b) {
                this.l.getDrawable(0).setAlpha(((int)((1.0f - this.e) * 255.0f)));
            }
            this.l.getDrawable(1).setAlpha(((int)(this.e * 255.0f)));
            super.setImageDrawable(this.l);
        }
    }

    @Override  // androidx.appcompat.widget.AppCompatImageView
    public void setImageDrawable(Drawable drawable0) {
        if(this.c != null && drawable0 != null) {
            Drawable drawable1 = drawable0.mutate();
            this.d = drawable1;
            this.k[0] = drawable1;
            this.k[1] = this.c;
            LayerDrawable layerDrawable0 = new LayerDrawable(this.k);
            this.l = layerDrawable0;
            super.setImageDrawable(layerDrawable0);
            this.setCrossfade(this.e);
            return;
        }
        super.setImageDrawable(drawable0);
    }

    public void setImagePanX(float f) {
        this.m = f;
        this.e();
    }

    public void setImagePanY(float f) {
        this.n = f;
        this.e();
    }

    @Override  // androidx.appcompat.widget.AppCompatImageView
    public void setImageResource(int v) {
        if(this.c != null) {
            Drawable drawable0 = w.B(this.getContext(), v).mutate();
            this.d = drawable0;
            this.k[0] = drawable0;
            this.k[1] = this.c;
            LayerDrawable layerDrawable0 = new LayerDrawable(this.k);
            this.l = layerDrawable0;
            super.setImageDrawable(layerDrawable0);
            this.setCrossfade(this.e);
            return;
        }
        super.setImageResource(v);
    }

    public void setImageRotate(float f) {
        this.r = f;
        this.e();
    }

    public void setImageZoom(float f) {
        this.o = f;
        this.e();
    }

    private void setOverlay(boolean z) {
        this.b = z;
    }

    public void setRound(float f) {
        if(Float.isNaN(f)) {
            this.g = f;
            float f1 = this.f;
            this.f = -1.0f;
            this.setRoundPercent(f1);
            return;
        }
        boolean z = Float.compare(this.g, f) != 0;
        this.g = f;
        if(f == 0.0f) {
            this.setClipToOutline(false);
        }
        else {
            if(this.h == null) {
                this.h = new Path();
            }
            if(this.j == null) {
                this.j = new RectF();
            }
            if(this.i == null) {
                b b0 = new b(this, 1);
                this.i = b0;
                this.setOutlineProvider(b0);
            }
            this.setClipToOutline(true);
            int v = this.getWidth();
            int v1 = this.getHeight();
            this.j.set(0.0f, 0.0f, ((float)v), ((float)v1));
            this.h.reset();
            this.h.addRoundRect(this.j, this.g, this.g, Path.Direction.CW);
        }
        if(z) {
            this.invalidateOutline();
        }
    }

    public void setRoundPercent(float f) {
        boolean z = Float.compare(this.f, f) != 0;
        this.f = f;
        if(f == 0.0f) {
            this.setClipToOutline(false);
        }
        else {
            if(this.h == null) {
                this.h = new Path();
            }
            if(this.j == null) {
                this.j = new RectF();
            }
            if(this.i == null) {
                b b0 = new b(this, 0);
                this.i = b0;
                this.setOutlineProvider(b0);
            }
            this.setClipToOutline(true);
            int v = this.getWidth();
            int v1 = this.getHeight();
            float f1 = ((float)Math.min(v, v1)) * this.f / 2.0f;
            this.j.set(0.0f, 0.0f, ((float)v), ((float)v1));
            this.h.reset();
            this.h.addRoundRect(this.j, f1, f1, Path.Direction.CW);
        }
        if(z) {
            this.invalidateOutline();
        }
    }

    public void setSaturation(float f) {
        this.a.e = f;
        this.a.a(this);
    }

    public void setWarmth(float f) {
        this.a.g = f;
        this.a.a(this);
    }
}

