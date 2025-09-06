package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.iloen.melon.utils.log.LogU;
import k8.t1;

public class BorderImageView extends MelonImageView {
    public final Paint f;
    public int g;
    public int h;
    public final RectF i;
    public final RectF j;
    public Path k;
    public float l;
    public float m;

    public BorderImageView(Context context0) {
        this(context0, null, 0);
    }

    public BorderImageView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public BorderImageView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.i = new RectF();
        this.j = new RectF();
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.d, v, 0);
        try {
            this.g = typedArray0.getDimensionPixelSize(2, 0);
            this.h = typedArray0.getColor(1, 0);
            Drawable drawable0 = typedArray0.getDrawable(0);
            if(drawable0 != null) {
                this.setImageDrawable(drawable0);
            }
        }
        catch(Exception exception0) {
            LogU.w("BorderImagerView", exception0.toString());
        }
        finally {
            typedArray0.recycle();
        }
        Paint paint0 = new Paint(5);
        this.f = paint0;
        paint0.setColor(this.h);
        this.f.setStrokeWidth(((float)this.g));
        this.f.setStyle(Paint.Style.STROKE);
    }

    public final void c() {
        int v = this.getPaddingLeft();
        int v1 = this.getPaddingTop();
        this.j.set(((float)v), ((float)v1), this.l + ((float)v), this.m + ((float)v1));
        float f = (float)(this.g / 2);
        this.i.set(((float)(v + this.g / 2)), ((float)(this.g / 2 + v1)), ((float)v) + (this.l - f), ((float)v1) + (this.m - f));
        Path path0 = new Path();
        this.k = path0;
        path0.addArc(this.i, 0.0f, 360.0f);
    }

    public int getBorderColor() {
        return this.h;
    }

    public int getBorderWidth() {
        return this.g;
    }

    @Override  // com.iloen.melon.custom.MelonImageView
    public final void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
        if(this.g > 0) {
            float f = (float)Color.alpha(this.h);
            float f1 = this.getAlpha();
            this.f.setAlpha(((int)(f1 * f)));
            canvas0.drawPath(this.k, this.f);
        }
    }

    @Override  // android.widget.ImageView
    public final void onMeasure(int v, int v1) {
        int v2 = View.getDefaultSize(this.getSuggestedMinimumHeight(), v1);
        int v3 = View.getDefaultSize(this.getSuggestedMinimumWidth(), v);
        int v4 = Math.min(v3, v2);
        this.setMeasuredDimension(v4, v4);
        this.m = ((float)v2) - ((float)this.getPaddingTop()) - ((float)this.getPaddingBottom());
        float f = ((float)v3) - ((float)this.getPaddingLeft()) - ((float)this.getPaddingRight());
        float f1 = Math.min(this.m, f);
        this.m = f1;
        this.l = f1;
        this.c();
    }

    public void setBorderColor(int v) {
        this.h = v;
        this.f.setColor(v);
        this.c();
    }

    public void setBorderWidth(int v) {
        this.g = v;
        this.f.setStrokeWidth(((float)v));
        this.c();
    }
}

