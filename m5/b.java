package m5;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable;
import df.v;
import u5.f;
import ye.a;

public final class b extends Drawable implements Animatable, Drawable.Callback {
    public final Drawable a;
    public final f b;
    public float c;
    public float d;
    public float e;

    public b(Drawable drawable0, f f0) {
        this.a = drawable0;
        this.b = f0;
        this.e = 1.0f;
        drawable0.setCallback(this);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas0) {
        int v = canvas0.save();
        try {
            canvas0.translate(this.c, this.d);
            canvas0.scale(this.e, this.e);
            this.a.draw(canvas0);
        }
        finally {
            canvas0.restoreToCount(v);
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.a.getAlpha();
    }

    @Override  // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.a.getColorFilter();
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.a.getIntrinsicHeight();
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.a.getIntrinsicWidth();
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.a.getOpacity();
    }

    @Override  // android.graphics.drawable.Drawable$Callback
    public final void invalidateDrawable(Drawable drawable0) {
        this.invalidateSelf();
    }

    // 去混淆评级： 低(20)
    @Override  // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.a instanceof Animatable && ((Animatable)this.a).isRunning();
    }

    @Override  // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect0) {
        Drawable drawable0 = this.a;
        int v = drawable0.getIntrinsicWidth();
        int v1 = drawable0.getIntrinsicHeight();
        if(v > 0 && v1 > 0) {
            int v2 = rect0.width();
            int v3 = rect0.height();
            double f = v.r(v, v1, v2, v3, this.b);
            int v4 = a.U((((double)v2) - ((double)v) * f) / 2.0);
            int v5 = a.U((((double)v3) - ((double)v1) * f) / 2.0);
            drawable0.setBounds(v4, v5, v + v4, v1 + v5);
            this.c = (float)rect0.left;
            this.d = (float)rect0.top;
            this.e = (float)f;
            return;
        }
        drawable0.setBounds(rect0);
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 1.0f;
    }

    @Override  // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int v) {
        return this.a.setLevel(v);
    }

    @Override  // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] arr_v) {
        return this.a.setState(arr_v);
    }

    @Override  // android.graphics.drawable.Drawable$Callback
    public final void scheduleDrawable(Drawable drawable0, Runnable runnable0, long v) {
        this.scheduleSelf(runnable0, v);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setAlpha(int v) {
        this.a.setAlpha(v);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter0) {
        this.a.setColorFilter(colorFilter0);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setTint(int v) {
        this.a.setTint(v);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setTintBlendMode(BlendMode blendMode0) {
        com.iloen.melon.utils.player.a.l(this.a, blendMode0);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList0) {
        this.a.setTintList(colorStateList0);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.a.setTintMode(porterDuff$Mode0);
    }

    @Override  // android.graphics.drawable.Animatable
    public final void start() {
        Drawable drawable0 = this.a;
        if(drawable0 instanceof Animatable) {
            ((Animatable)drawable0).start();
        }
    }

    @Override  // android.graphics.drawable.Animatable
    public final void stop() {
        Drawable drawable0 = this.a;
        if(drawable0 instanceof Animatable) {
            ((Animatable)drawable0).stop();
        }
    }

    @Override  // android.graphics.drawable.Drawable$Callback
    public final void unscheduleDrawable(Drawable drawable0, Runnable runnable0) {
        this.unscheduleSelf(runnable0);
    }
}

