package v6;

import N4.b;
import android.animation.ObjectAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.provider.Settings.Global;
import java.util.ArrayList;

public abstract class l extends Drawable implements Animatable {
    public final Context a;
    public final e b;
    public a c;
    public ObjectAnimator d;
    public ObjectAnimator e;
    public ArrayList f;
    public boolean g;
    public float h;
    public final Paint i;
    public int j;
    public static final b k;

    static {
        l.k = new b("growFraction", 17, Float.class);
    }

    public l(Context context0, e e0) {
        this.i = new Paint();
        this.a = context0;
        this.b = e0;
        this.c = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.setAlpha(0xFF);
    }

    public static void a(l l0) {
        l0.super.setVisible(false, false);
    }

    public final float b() {
        return this.b.e == 0 && this.b.f == 0 ? 1.0f : this.h;
    }

    public final boolean c(boolean z, boolean z1, boolean z2) {
        a a0 = this.c;
        ContentResolver contentResolver0 = this.a.getContentResolver();
        a0.getClass();
        return !z2 || Settings.Global.getFloat(contentResolver0, "animator_duration_scale", 1.0f) <= 0.0f ? this.d(z, z1, false) : this.d(z, z1, true);
    }

    public boolean d(boolean z, boolean z1, boolean z2) {
        b b0 = l.k;
        if(this.d == null) {
            ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(this, b0, new float[]{0.0f, 1.0f});
            this.d = objectAnimator0;
            objectAnimator0.setDuration(500L);
            this.d.setInterpolator(e6.a.b);
            ObjectAnimator objectAnimator1 = this.d;
            if(objectAnimator1 != null && objectAnimator1.isRunning()) {
                throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
            }
            this.d = objectAnimator1;
            objectAnimator1.addListener(new k(this, 0));
        }
        if(this.e == null) {
            ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(this, b0, new float[]{1.0f, 0.0f});
            this.e = objectAnimator2;
            objectAnimator2.setDuration(500L);
            this.e.setInterpolator(e6.a.b);
            ObjectAnimator objectAnimator3 = this.e;
            if(objectAnimator3 != null && objectAnimator3.isRunning()) {
                throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
            }
            this.e = objectAnimator3;
            objectAnimator3.addListener(new k(this, 1));
        }
        if(this.isVisible() || z) {
            ObjectAnimator objectAnimator4 = z ? this.d : this.e;
            ObjectAnimator objectAnimator5 = z ? this.e : this.d;
            if(!z2) {
                if(objectAnimator5.isRunning()) {
                    boolean z3 = this.g;
                    this.g = true;
                    objectAnimator5.cancel();
                    this.g = z3;
                }
                if(objectAnimator4.isRunning()) {
                    objectAnimator4.end();
                    return super.setVisible(z, false);
                }
                boolean z4 = this.g;
                this.g = true;
                objectAnimator4.end();
                this.g = z4;
                return super.setVisible(z, false);
            }
            if(!objectAnimator4.isRunning()) {
                boolean z5 = !z || super.setVisible(true, false);
                e e0 = this.b;
                if(!z) {
                    if(e0.f != 0) {
                    label_45:
                        if(!z1 && objectAnimator4.isPaused()) {
                            objectAnimator4.resume();
                            return z5;
                        }
                        objectAnimator4.start();
                        return z5;
                    }
                }
                else if(e0.e != 0) {
                    goto label_45;
                }
                boolean z6 = this.g;
                this.g = true;
                objectAnimator4.end();
                this.g = z6;
                return z5;
            }
        }
        return false;
    }

    public final void e(c c0) {
        if(this.f != null && this.f.contains(c0)) {
            this.f.remove(c0);
            if(this.f.isEmpty()) {
                this.f = null;
            }
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.j;
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    // 去混淆评级： 低(30)
    @Override  // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.d != null && this.d.isRunning() || this.e != null && this.e.isRunning();
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setAlpha(int v) {
        this.j = v;
        this.invalidateSelf();
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter0) {
        this.i.setColorFilter(colorFilter0);
        this.invalidateSelf();
    }

    @Override  // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z1) {
        return this.c(z, z1, true);
    }

    @Override  // android.graphics.drawable.Animatable
    public final void start() {
        this.d(true, true, false);
    }

    @Override  // android.graphics.drawable.Animatable
    public final void stop() {
        this.d(false, true, false);
    }
}

