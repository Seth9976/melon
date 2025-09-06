package com.google.android.material.imageview;

import E6.a;
import P1.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Paint;
import android.graphics.Path.Direction;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.media3.exoplayer.a0;
import e1.n;
import z6.i;
import z6.o;
import z6.p;
import z6.y;

public class ShapeableImageView extends AppCompatImageView implements y {
    public boolean B;
    public final a0 a;
    public final RectF b;
    public final RectF c;
    public final Paint d;
    public final Paint e;
    public final Path f;
    public ColorStateList g;
    public i h;
    public o i;
    public float j;
    public final Path k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int r;
    public final int w;

    public ShapeableImageView(Context context0) {
        this(context0, null, 0);
    }

    public ShapeableImageView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public ShapeableImageView(Context context0, AttributeSet attributeSet0, int v) {
        super(a.a(context0, attributeSet0, v, 0x7F1404CE), attributeSet0, v);  // style:Widget.MaterialComponents.ShapeableImageView
        this.a = p.a;
        this.f = new Path();
        this.B = false;
        Context context1 = this.getContext();
        Paint paint0 = new Paint();
        this.e = paint0;
        paint0.setAntiAlias(true);
        paint0.setColor(-1);
        paint0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.b = new RectF();
        this.c = new RectF();
        this.k = new Path();
        TypedArray typedArray0 = context1.obtainStyledAttributes(attributeSet0, d6.a.Y, v, 0x7F1404CE);  // style:Widget.MaterialComponents.ShapeableImageView
        this.setLayerType(2, null);
        this.g = n.r(context1, typedArray0, 9);
        this.j = (float)typedArray0.getDimensionPixelSize(10, 0);
        int v1 = typedArray0.getDimensionPixelSize(0, 0);
        this.m = v1;
        this.n = v1;
        this.o = v1;
        this.l = typedArray0.getDimensionPixelSize(3, v1);
        this.m = typedArray0.getDimensionPixelSize(6, v1);
        this.n = typedArray0.getDimensionPixelSize(4, v1);
        this.o = typedArray0.getDimensionPixelSize(1, v1);
        this.r = typedArray0.getDimensionPixelSize(5, 0x80000000);
        this.w = typedArray0.getDimensionPixelSize(2, 0x80000000);
        typedArray0.recycle();
        Paint paint1 = new Paint();
        this.d = paint1;
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setAntiAlias(true);
        this.i = o.d(context1, attributeSet0, v, 0x7F1404CE).a();  // style:Widget.MaterialComponents.ShapeableImageView
        this.setOutlineProvider(new s6.a(this));
    }

    public final boolean c() {
        return this.getLayoutDirection() == 1;
    }

    public final void d(int v, int v1) {
        float f = (float)this.getPaddingLeft();
        float f1 = (float)this.getPaddingTop();
        int v2 = this.getPaddingRight();
        int v3 = this.getPaddingBottom();
        this.b.set(f, f1, ((float)(v - v2)), ((float)(v1 - v3)));
        this.a.b(this.i, 1.0f, this.b, null, this.f);
        this.k.rewind();
        this.k.addPath(this.f);
        this.c.set(0.0f, 0.0f, ((float)v), ((float)v1));
        this.k.addRect(this.c, Path.Direction.CCW);
    }

    public int getContentPaddingBottom() {
        return this.o;
    }

    public final int getContentPaddingEnd() {
        int v = this.w;
        if(v != 0x80000000) {
            return v;
        }
        return this.c() ? this.l : this.n;
    }

    public int getContentPaddingLeft() {
        if(this.r != 0x80000000 || this.w != 0x80000000) {
            if(this.c()) {
                int v = this.w;
                if(v != 0x80000000) {
                    return v;
                }
            }
            if(!this.c()) {
                return this.r == 0x80000000 ? this.l : this.r;
            }
        }
        return this.l;
    }

    public int getContentPaddingRight() {
        if(this.r != 0x80000000 || this.w != 0x80000000) {
            if(this.c()) {
                int v = this.r;
                if(v != 0x80000000) {
                    return v;
                }
            }
            if(!this.c()) {
                return this.w == 0x80000000 ? this.n : this.w;
            }
        }
        return this.n;
    }

    public final int getContentPaddingStart() {
        int v = this.r;
        if(v != 0x80000000) {
            return v;
        }
        return this.c() ? this.n : this.l;
    }

    public int getContentPaddingTop() {
        return this.m;
    }

    @Override  // android.view.View
    public int getPaddingBottom() {
        return super.getPaddingBottom() - this.getContentPaddingBottom();
    }

    @Override  // android.view.View
    public int getPaddingEnd() {
        return super.getPaddingEnd() - this.getContentPaddingEnd();
    }

    @Override  // android.view.View
    public int getPaddingLeft() {
        return super.getPaddingLeft() - this.getContentPaddingLeft();
    }

    @Override  // android.view.View
    public int getPaddingRight() {
        return super.getPaddingRight() - this.getContentPaddingRight();
    }

    @Override  // android.view.View
    public int getPaddingStart() {
        return super.getPaddingStart() - this.getContentPaddingStart();
    }

    @Override  // android.view.View
    public int getPaddingTop() {
        return super.getPaddingTop() - this.getContentPaddingTop();
    }

    public o getShapeAppearanceModel() {
        return this.i;
    }

    public ColorStateList getStrokeColor() {
        return this.g;
    }

    public float getStrokeWidth() {
        return this.j;
    }

    @Override  // android.widget.ImageView
    public final void onDraw(Canvas canvas0) {
        super.onDraw(canvas0);
        canvas0.drawPath(this.k, this.e);
        if(this.g != null) {
            Paint paint0 = this.d;
            paint0.setStrokeWidth(this.j);
            int v = this.g.getColorForState(this.getDrawableState(), this.g.getDefaultColor());
            if(this.j > 0.0f && v != 0) {
                paint0.setColor(v);
                canvas0.drawPath(this.f, paint0);
            }
        }
    }

    @Override  // android.widget.ImageView
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        if(this.B || !this.isLayoutDirectionResolved()) {
            return;
        }
        this.B = true;
        if(!this.isPaddingRelative() && this.r == 0x80000000 && this.w == 0x80000000) {
            this.setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            return;
        }
        this.setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
    }

    @Override  // android.view.View
    public final void onSizeChanged(int v, int v1, int v2, int v3) {
        super.onSizeChanged(v, v1, v2, v3);
        this.d(v, v1);
    }

    @Override  // android.view.View
    public final void setPadding(int v, int v1, int v2, int v3) {
        super.setPadding(this.getContentPaddingLeft() + v, this.getContentPaddingTop() + v1, this.getContentPaddingRight() + v2, this.getContentPaddingBottom() + v3);
    }

    @Override  // android.view.View
    public final void setPaddingRelative(int v, int v1, int v2, int v3) {
        super.setPaddingRelative(this.getContentPaddingStart() + v, this.getContentPaddingTop() + v1, this.getContentPaddingEnd() + v2, this.getContentPaddingBottom() + v3);
    }

    @Override  // z6.y
    public void setShapeAppearanceModel(o o0) {
        this.i = o0;
        i i0 = this.h;
        if(i0 != null) {
            i0.setShapeAppearanceModel(o0);
        }
        this.d(this.getWidth(), this.getHeight());
        this.invalidate();
        this.invalidateOutline();
    }

    public void setStrokeColor(ColorStateList colorStateList0) {
        this.g = colorStateList0;
        this.invalidate();
    }

    public void setStrokeColorResource(int v) {
        this.setStrokeColor(c.getColorStateList(this.getContext(), v));
    }

    public void setStrokeWidth(float f) {
        if(this.j != f) {
            this.j = f;
            this.invalidate();
        }
    }

    public void setStrokeWidthResource(int v) {
        this.setStrokeWidth(((float)this.getResources().getDimensionPixelSize(v)));
    }
}

