package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.view.View;
import android.view.ViewDebug.ExportedProperty;
import android.widget.RemoteViews.RemoteView;
import k8.t1;

@RemoteViews.RemoteView
public class VerticalProgressBar extends View {
    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR;
        public int a;
        public int b;

        static {
            SavedState.CREATOR = new u1();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        @Override  // android.view.View$BaseSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeInt(this.a);
            parcel0.writeInt(this.b);
        }
    }

    public final int a;
    public final int b;
    public final int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public Drawable h;
    public Drawable i;
    public Bitmap j;
    public final boolean k;
    public C0 l;
    public final long m;
    public static final int n;

    public VerticalProgressBar(Context context0) {
        this(context0, null);
    }

    public VerticalProgressBar(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x1010077);
    }

    public VerticalProgressBar(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.m = Thread.currentThread().getId();
        this.g = 100;
        this.e = -1;
        this.f = -1;
        this.a = 24;
        this.b = 0x30;
        this.c = 24;
        this.d = 0x30;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.x, v, 0);
        this.k = true;
        Drawable drawable0 = typedArray0.getDrawable(5);
        if(drawable0 != null) {
            this.setProgressDrawable(this.e(drawable0, false));
        }
        this.a = typedArray0.getDimensionPixelSize(6, this.a);
        this.b = typedArray0.getDimensionPixelSize(0, this.b);
        this.c = typedArray0.getDimensionPixelSize(7, this.c);
        this.d = typedArray0.getDimensionPixelSize(1, this.d);
        this.setMax(typedArray0.getInt(2, this.g));
        this.setProgress(typedArray0.getInt(3, this.e));
        this.setSecondaryProgress(typedArray0.getInt(4, this.f));
        this.k = false;
        typedArray0.recycle();
    }

    public final void a(int v, int v1, boolean z) {
        synchronized(this) {
            float f = this.g <= 0 ? 0.0f : ((float)v1) / ((float)this.g);
            Drawable drawable0 = this.i;
            if(drawable0 == null) {
                this.invalidate();
            }
            else {
                Drawable drawable1 = drawable0 instanceof LayerDrawable ? ((LayerDrawable)drawable0).findDrawableByLayerId(v) : null;
                if(drawable1 != null) {
                    drawable0 = drawable1;
                }
                drawable0.setLevel(((int)(10000.0f * f)));
            }
            if(v == 0x102000D) {
                this.b(f, z);
            }
        }
    }

    public void b(float f, boolean z) {
    }

    public final void c(int v, int v1, boolean z) {
        synchronized(this) {
            if(this.m == Thread.currentThread().getId()) {
                this.a(v, v1, z);
            }
            else {
                C0 c00 = this.l;
                if(c00 == null) {
                    c00 = new C0(this, v, v1, z);
                }
                else {
                    this.l = null;
                    c00.b = v;
                    c00.c = v1;
                    c00.d = z;
                }
                this.post(c00);
            }
        }
    }

    public final void d(int v, boolean z) {
        synchronized(this) {
            if(v < 0) {
                v = 0;
            }
            int v2 = this.g;
            if(v > v2) {
                v = v2;
            }
            if(v != this.e) {
                this.e = v;
                this.c(0x102000D, v, z);
            }
        }
    }

    @Override  // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] arr_v = this.getDrawableState();
        if(this.h != null && this.h.isStateful()) {
            this.h.setState(arr_v);
        }
    }

    public final Drawable e(Drawable drawable0, boolean z) {
        if(drawable0 instanceof LayerDrawable) {
            int v = ((LayerDrawable)drawable0).getNumberOfLayers();
            Drawable[] arr_drawable = new Drawable[v];
            for(int v2 = 0; v2 < v; ++v2) {
                int v3 = ((LayerDrawable)drawable0).getId(v2);
                arr_drawable[v2] = this.e(((LayerDrawable)drawable0).getDrawable(v2), v3 == 0x102000D || v3 == 0x102000F);
            }
            Drawable drawable1 = new LayerDrawable(arr_drawable);
            for(int v1 = 0; v1 < v; ++v1) {
                ((LayerDrawable)drawable1).setId(v1, ((LayerDrawable)drawable0).getId(v1));
            }
            return drawable1;
        }
        if(drawable0 instanceof StateListDrawable) {
            return new StateListDrawable();
        }
        if(drawable0 instanceof BitmapDrawable) {
            Bitmap bitmap0 = ((BitmapDrawable)drawable0).getBitmap();
            if(this.j == null) {
                this.j = bitmap0;
            }
            drawable0 = new ShapeDrawable(this.getDrawableShape());
            if(z) {
                return new ClipDrawable(drawable0, 0x30, 2);
            }
        }
        return drawable0;
    }

    public Drawable getCurrentDrawable() {
        return this.i;
    }

    public Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    @ViewDebug.ExportedProperty
    public int getMax() {
        synchronized(this) {
        }
        return this.g;
    }

    @ViewDebug.ExportedProperty
    public int getProgress() {
        synchronized(this) {
        }
        return this.e;
    }

    public Drawable getProgressDrawable() {
        return this.h;
    }

    @ViewDebug.ExportedProperty
    public int getSecondaryProgress() {
        synchronized(this) {
        }
        return this.f;
    }

    @Override  // android.view.View
    public final void invalidateDrawable(Drawable drawable0) {
        if(this.verifyDrawable(drawable0)) {
            Rect rect0 = drawable0.getBounds();
            int v = this.getPaddingLeft();
            int v1 = this.getPaddingTop();
            this.invalidate(rect0.left + v, rect0.top + v1, rect0.right + v, rect0.bottom + v1);
            return;
        }
        super.invalidateDrawable(drawable0);
    }

    @Override  // android.view.View
    public void onDraw(Canvas canvas0) {
        synchronized(this) {
            super.onDraw(canvas0);
            Drawable drawable0 = this.i;
            if(drawable0 != null) {
                canvas0.save();
                canvas0.translate(((float)this.getPaddingLeft()), ((float)this.getPaddingTop()));
                drawable0.draw(canvas0);
                canvas0.restore();
            }
        }
    }

    @Override  // android.view.View
    public void onMeasure(int v, int v1) {
        int v6;
        int v4;
        synchronized(this) {
            Drawable drawable0 = this.i;
            if(drawable0 == null) {
                v4 = 0;
                v6 = 0;
            }
            else {
                int v3 = drawable0.getIntrinsicWidth();
                v4 = Math.max(this.a, Math.min(this.b, v3));
                int v5 = Math.min(this.d, drawable0.getIntrinsicHeight());
                v6 = Math.max(this.c, v5);
            }
            int v7 = this.getPaddingLeft();
            int v8 = this.getPaddingRight();
            int v9 = this.getPaddingTop();
            int v10 = this.getPaddingBottom();
            this.setMeasuredDimension(View.resolveSize(v7 + v8 + v4, v), View.resolveSize(v9 + v10 + v6, v1));
        }
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        super.onRestoreInstanceState(((SavedState)parcelable0).getSuperState());
        this.setProgress(((SavedState)parcelable0).a);
        this.setSecondaryProgress(((SavedState)parcelable0).b);
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.a = this.e;
        parcelable0.b = this.f;
        return parcelable0;
    }

    @Override  // android.view.View
    public void onSizeChanged(int v, int v1, int v2, int v3) {
        int v4 = this.getPaddingRight();
        int v5 = this.getPaddingLeft();
        int v6 = this.getPaddingBottom();
        int v7 = this.getPaddingTop();
        Drawable drawable0 = this.h;
        if(drawable0 != null) {
            drawable0.setBounds(this.getPaddingLeft(), this.getPaddingTop(), v - v4 - v5, v1 - v6 - v7);
        }
    }

    @Override  // android.view.View
    public final void postInvalidate() {
        if(!this.k) {
            super.postInvalidate();
        }
    }

    public void setMax(int v) {
        synchronized(this) {
            if(v < 0) {
                v = 0;
            }
            if(v != this.g) {
                this.g = v;
                this.postInvalidate();
                if(this.e > v) {
                    this.e = v;
                    this.c(0x102000D, v, false);
                }
            }
        }
    }

    public void setProgress(int v) {
        synchronized(this) {
            this.d(v, false);
        }
    }

    public void setProgressDrawable(Drawable drawable0) {
        if(drawable0 != null) {
            drawable0.setCallback(this);
            int v = drawable0.getMinimumHeight();
            if(this.d < v) {
                this.d = v;
                this.requestLayout();
            }
        }
        this.h = drawable0;
        this.i = drawable0;
        this.postInvalidate();
    }

    public void setSecondaryProgress(int v) {
        synchronized(this) {
            if(v < 0) {
                v = 0;
            }
            int v2 = this.g;
            if(v > v2) {
                v = v2;
            }
            if(v != this.f) {
                this.f = v;
                this.c(0x102000F, v, false);
            }
        }
    }

    @Override  // android.view.View
    public void setVisibility(int v) {
        if(this.getVisibility() != v) {
            super.setVisibility(v);
        }
    }

    @Override  // android.view.View
    public boolean verifyDrawable(Drawable drawable0) {
        return drawable0 == this.h || super.verifyDrawable(drawable0);
    }
}

