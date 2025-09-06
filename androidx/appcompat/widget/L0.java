package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable;

public final class l0 extends Drawable implements Drawable.Callback {
    public Drawable a;
    public boolean b;

    public final void a(Canvas canvas0) {
        this.a.draw(canvas0);
    }

    public final void b(float f, float f1) {
        this.a.setHotspot(f, f1);
    }

    public final void c(int v, int v1, int v2, int v3) {
        this.a.setHotspotBounds(v, v1, v2, v3);
    }

    // 去混淆评级： 低(20)
    public final boolean d(boolean z, boolean z1) {
        return super.setVisible(z, z1) || this.a.setVisible(z, z1);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas0) {
        if(this.b) {
            this.a(canvas0);
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    @Override  // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.a.getCurrent();
    }

    @Override  // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.a.getIntrinsicHeight();
    }

    @Override  // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.a.getIntrinsicWidth();
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.a.getMinimumHeight();
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.a.getMinimumWidth();
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.a.getOpacity();
    }

    @Override  // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect0) {
        return this.a.getPadding(rect0);
    }

    @Override  // android.graphics.drawable.Drawable
    public final int[] getState() {
        return this.a.getState();
    }

    @Override  // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        return this.a.getTransparentRegion();
    }

    @Override  // android.graphics.drawable.Drawable$Callback
    public final void invalidateDrawable(Drawable drawable0) {
        this.invalidateSelf();
    }

    @Override  // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.a.isAutoMirrored();
    }

    @Override  // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return this.a.isStateful();
    }

    @Override  // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        this.a.jumpToCurrentState();
    }

    @Override  // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect0) {
        this.a.setBounds(rect0);
    }

    @Override  // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int v) {
        return this.a.setLevel(v);
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
    public final void setAutoMirrored(boolean z) {
        this.a.setAutoMirrored(z);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setChangingConfigurations(int v) {
        this.a.setChangingConfigurations(v);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter0) {
        this.a.setColorFilter(colorFilter0);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setDither(boolean z) {
        this.a.setDither(z);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z) {
        this.a.setFilterBitmap(z);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setHotspot(float f, float f1) {
        if(this.b) {
            this.b(f, f1);
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int v, int v1, int v2, int v3) {
        if(this.b) {
            this.c(v, v1, v2, v3);
        }
    }

    // 去混淆评级： 低(20)
    @Override  // android.graphics.drawable.Drawable
    public final boolean setState(int[] arr_v) {
        return this.b ? this.a.setState(arr_v) : false;
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setTint(int v) {
        this.a.setTint(v);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList0) {
        this.a.setTintList(colorStateList0);
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode porterDuff$Mode0) {
        this.a.setTintMode(porterDuff$Mode0);
    }

    // 去混淆评级： 低(20)
    @Override  // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z1) {
        return this.b ? this.d(z, z1) : false;
    }

    @Override  // android.graphics.drawable.Drawable$Callback
    public final void unscheduleDrawable(Drawable drawable0, Runnable runnable0) {
        this.unscheduleSelf(runnable0);
    }
}

