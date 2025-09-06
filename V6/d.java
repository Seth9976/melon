package v6;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.provider.Settings.Global;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import com.google.android.material.internal.B;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class d extends ProgressBar {
    public final e a;
    public int b;
    public final boolean c;
    public final int d;
    public a e;
    public boolean f;
    public int g;
    public final b h;
    public final b i;
    public final c j;
    public final c k;

    public d(Context context0, AttributeSet attributeSet0, int v, int v1) {
        super(E6.a.a(context0, attributeSet0, v, 0x7F1404CD), attributeSet0, v);  // style:Widget.MaterialComponents.ProgressIndicator
        this.f = false;
        this.g = 4;
        this.h = new b(this, 0);
        this.i = new b(this, 1);
        this.j = new c(this, 0);
        this.k = new c(this, 1);
        Context context1 = this.getContext();
        this.a = this.a(context1, attributeSet0);
        TypedArray typedArray0 = B.m(context1, attributeSet0, d6.a.d, v, v1, new int[0]);
        typedArray0.getInt(6, -1);
        this.d = Math.min(typedArray0.getInt(4, -1), 1000);
        typedArray0.recycle();
        this.e = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.c = true;
    }

    public abstract e a(Context arg1, AttributeSet arg2);

    public void b(int v) {
        if(!this.isIndeterminate()) {
            super.setProgress(v);
            if(this.getProgressDrawable() != null) {
                this.getProgressDrawable().jumpToCurrentState();
            }
        }
        else if(this.getProgressDrawable() != null) {
            this.b = v;
            this.f = true;
            if(this.getIndeterminateDrawable().isVisible()) {
                a a0 = this.e;
                ContentResolver contentResolver0 = this.getContext().getContentResolver();
                a0.getClass();
                if(Settings.Global.getFloat(contentResolver0, "animator_duration_scale", 1.0f) != 0.0f) {
                    this.getIndeterminateDrawable().m.u();
                    return;
                }
            }
            o o0 = this.getIndeterminateDrawable();
            this.j.a(o0);
        }
    }

    public final boolean c() {
        if(this.isAttachedToWindow() && this.getWindowVisibility() == 0) {
            for(View view0 = this; view0.getVisibility() == 0; view0 = (View)viewParent0) {
                ViewParent viewParent0 = view0.getParent();
                if(viewParent0 == null) {
                    return this.getWindowVisibility() == 0;
                }
                if(!(viewParent0 instanceof View)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override  // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        return this.isIndeterminate() ? this.getIndeterminateDrawable() : this.getProgressDrawable();
    }

    private n getCurrentDrawingDelegate() {
        if(this.isIndeterminate()) {
            return this.getIndeterminateDrawable() == null ? null : this.getIndeterminateDrawable().l;
        }
        return this.getProgressDrawable() == null ? null : this.getProgressDrawable().l;
    }

    public int getHideAnimationBehavior() {
        return this.a.f;
    }

    @Override  // android.widget.ProgressBar
    public Drawable getIndeterminateDrawable() {
        return this.getIndeterminateDrawable();
    }

    public o getIndeterminateDrawable() {
        return (o)super.getIndeterminateDrawable();
    }

    public int[] getIndicatorColor() {
        return this.a.c;
    }

    public int getIndicatorTrackGapSize() {
        return this.a.g;
    }

    @Override  // android.widget.ProgressBar
    public Drawable getProgressDrawable() {
        return this.getProgressDrawable();
    }

    public j getProgressDrawable() {
        return (j)super.getProgressDrawable();
    }

    public int getShowAnimationBehavior() {
        return this.a.e;
    }

    public int getTrackColor() {
        return this.a.d;
    }

    public int getTrackCornerRadius() {
        return this.a.b;
    }

    public int getTrackThickness() {
        return this.a.a;
    }

    @Override  // android.view.View
    public final void invalidate() {
        super.invalidate();
        if(this.getCurrentDrawable() != null) {
            this.getCurrentDrawable().invalidateSelf();
        }
    }

    @Override  // android.widget.ProgressBar
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(this.getProgressDrawable() != null && this.getIndeterminateDrawable() != null) {
            this.getIndeterminateDrawable().m.t(this.j);
        }
        j j0 = this.getProgressDrawable();
        c c0 = this.k;
        if(j0 != null) {
            j j1 = this.getProgressDrawable();
            if(j1.f == null) {
                j1.f = new ArrayList();
            }
            if(!j1.f.contains(c0)) {
                j1.f.add(c0);
            }
        }
        if(this.getIndeterminateDrawable() != null) {
            o o0 = this.getIndeterminateDrawable();
            if(o0.f == null) {
                o0.f = new ArrayList();
            }
            if(!o0.f.contains(c0)) {
                o0.f.add(c0);
            }
        }
        if(this.c()) {
            if(this.d > 0) {
                SystemClock.uptimeMillis();
            }
            this.setVisibility(0);
        }
    }

    @Override  // android.widget.ProgressBar
    public final void onDetachedFromWindow() {
        this.removeCallbacks(this.i);
        this.removeCallbacks(this.h);
        ((l)this.getCurrentDrawable()).c(false, false, false);
        o o0 = this.getIndeterminateDrawable();
        c c0 = this.k;
        if(o0 != null) {
            this.getIndeterminateDrawable().e(c0);
            this.getIndeterminateDrawable().m.x();
        }
        if(this.getProgressDrawable() != null) {
            this.getProgressDrawable().e(c0);
        }
        super.onDetachedFromWindow();
    }

    @Override  // android.widget.ProgressBar
    public final void onDraw(Canvas canvas0) {
        synchronized(this) {
            int v1 = canvas0.save();
            if(this.getPaddingLeft() != 0 || this.getPaddingTop() != 0) {
                canvas0.translate(((float)this.getPaddingLeft()), ((float)this.getPaddingTop()));
            }
            if(this.getPaddingRight() != 0 || this.getPaddingBottom() != 0) {
                canvas0.clipRect(0, 0, this.getWidth() - (this.getPaddingLeft() + this.getPaddingRight()), this.getHeight() - (this.getPaddingTop() + this.getPaddingBottom()));
            }
            this.getCurrentDrawable().draw(canvas0);
            canvas0.restoreToCount(v1);
        }
    }

    @Override  // android.widget.ProgressBar
    public final void onMeasure(int v, int v1) {
        synchronized(this) {
            n n0 = this.getCurrentDrawingDelegate();
            if(n0 == null) {
                return;
            }
            this.setMeasuredDimension((n0.f() >= 0 ? n0.f() + this.getPaddingLeft() + this.getPaddingRight() : View.getDefaultSize(this.getSuggestedMinimumWidth(), v)), (n0.e() >= 0 ? n0.e() + this.getPaddingTop() + this.getPaddingBottom() : View.getDefaultSize(this.getSuggestedMinimumHeight(), v1)));
        }
    }

    @Override  // android.view.View
    public final void onVisibilityChanged(View view0, int v) {
        super.onVisibilityChanged(view0, v);
        if(!this.c) {
            return;
        }
        ((l)this.getCurrentDrawable()).c(this.c(), false, v == 0);
    }

    @Override  // android.view.View
    public final void onWindowVisibilityChanged(int v) {
        super.onWindowVisibilityChanged(v);
        if(!this.c) {
            return;
        }
        ((l)this.getCurrentDrawable()).c(this.c(), false, false);
    }

    public void setAnimatorDurationScaleProvider(a a0) {
        this.e = a0;
        if(this.getProgressDrawable() != null) {
            this.getProgressDrawable().c = a0;
        }
        if(this.getIndeterminateDrawable() != null) {
            this.getIndeterminateDrawable().c = a0;
        }
    }

    public void setHideAnimationBehavior(int v) {
        this.a.f = v;
        this.invalidate();
    }

    @Override  // android.widget.ProgressBar
    public void setIndeterminate(boolean z) {
        synchronized(this) {
            if(z == this.isIndeterminate()) {
                return;
            }
            l l0 = (l)this.getCurrentDrawable();
            if(l0 != null) {
                l0.c(false, false, false);
            }
            super.setIndeterminate(z);
            l l1 = (l)this.getCurrentDrawable();
            if(l1 != null) {
                l1.c(this.c(), false, false);
            }
            if(l1 instanceof o && this.c()) {
                ((o)l1).m.w();
            }
            this.f = false;
        }
    }

    @Override  // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable0) {
        if(drawable0 == null) {
            super.setIndeterminateDrawable(null);
            return;
        }
        if(!(drawable0 instanceof o)) {
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
        ((l)drawable0).c(false, false, false);
        super.setIndeterminateDrawable(drawable0);
    }

    public void setIndicatorColor(int[] arr_v) {
        if(arr_v.length == 0) {
            arr_v = new int[]{e1.n.o(this.getContext(), 0x7F040182, -1)};  // attr:colorPrimary
        }
        if(!Arrays.equals(this.getIndicatorColor(), arr_v)) {
            this.a.c = arr_v;
            this.getIndeterminateDrawable().m.n();
            this.invalidate();
        }
    }

    public void setIndicatorTrackGapSize(int v) {
        e e0 = this.a;
        if(e0.g != v) {
            e0.g = v;
            e0.a();
            this.invalidate();
        }
    }

    @Override  // android.widget.ProgressBar
    public void setProgress(int v) {
        synchronized(this) {
            if(this.isIndeterminate()) {
                return;
            }
            this.b(v);
        }
    }

    @Override  // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable0) {
        if(drawable0 == null) {
            super.setProgressDrawable(null);
            return;
        }
        if(!(drawable0 instanceof j)) {
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
        ((j)drawable0).c(false, false, false);
        super.setProgressDrawable(((j)drawable0));
        ((j)drawable0).setLevel(((int)(((float)this.getProgress()) / ((float)this.getMax()) * 10000.0f)));
    }

    public void setShowAnimationBehavior(int v) {
        this.a.e = v;
        this.invalidate();
    }

    public void setTrackColor(int v) {
        e e0 = this.a;
        if(e0.d != v) {
            e0.d = v;
            this.invalidate();
        }
    }

    public void setTrackCornerRadius(int v) {
        e e0 = this.a;
        if(e0.b != v) {
            e0.b = Math.min(v, e0.a / 2);
            this.invalidate();
        }
    }

    public void setTrackThickness(int v) {
        e e0 = this.a;
        if(e0.a != v) {
            e0.a = v;
            this.requestLayout();
        }
    }

    public void setVisibilityAfterHide(int v) {
        if(v != 0 && v != 4 && v != 8) {
            throw new IllegalArgumentException("The component\'s visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
        }
        this.g = v;
    }
}

