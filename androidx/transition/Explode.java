package androidx.transition;

import N4.L;
import N4.b0;
import N4.o;
import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class Explode extends Visibility {
    public final int[] d0;
    public static final DecelerateInterpolator e0;
    public static final AccelerateInterpolator f0;

    static {
        Explode.e0 = new DecelerateInterpolator();
        Explode.f0 = new AccelerateInterpolator();
    }

    public Explode(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.d0 = new int[2];
        this.I = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // androidx.transition.Visibility
    public final Animator Q(ViewGroup viewGroup0, View view0, b0 b00, b0 b01) {
        if(b01 == null) {
            return null;
        }
        Rect rect0 = (Rect)b01.a.get("android:explode:screenBounds");
        float f = view0.getTranslationX();
        float f1 = view0.getTranslationY();
        this.T(viewGroup0, rect0, this.d0);
        return L.d(view0, b01, rect0.left, rect0.top, f + ((float)this.d0[0]), f1 + ((float)this.d0[1]), f, f1, Explode.e0, this);
    }

    @Override  // androidx.transition.Visibility
    public final Animator R(ViewGroup viewGroup0, View view0, b0 b00, b0 b01) {
        float f3;
        float f2;
        if(b00 == null) {
            return null;
        }
        Rect rect0 = (Rect)b00.a.get("android:explode:screenBounds");
        int v = rect0.left;
        int v1 = rect0.top;
        float f = view0.getTranslationX();
        float f1 = view0.getTranslationY();
        int[] arr_v = (int[])b00.b.getTag(0x7F0A0BE3);  // id:transition_position
        if(arr_v == null) {
            f2 = f;
            f3 = f1;
        }
        else {
            int v2 = arr_v[0];
            f2 = ((float)(v2 - rect0.left)) + f;
            f3 = ((float)(arr_v[1] - rect0.top)) + f1;
            rect0.offsetTo(v2, arr_v[1]);
        }
        this.T(viewGroup0, rect0, this.d0);
        return L.d(view0, b00, v, v1, f, f1, f2 + ((float)this.d0[0]), f3 + ((float)this.d0[1]), Explode.f0, this);
    }

    public final void T(ViewGroup viewGroup0, Rect rect0, int[] arr_v) {
        int v5;
        int v3;
        viewGroup0.getLocationOnScreen(this.d0);
        int v = this.d0[0];
        int v1 = this.d0[1];
        Rect rect1 = this.M == null ? null : this.M.i();
        if(rect1 == null) {
            int v2 = viewGroup0.getWidth();
            v3 = Math.round(viewGroup0.getTranslationX()) + (v2 / 2 + v);
            int v4 = viewGroup0.getHeight();
            v5 = Math.round(viewGroup0.getTranslationY()) + (v4 / 2 + v1);
        }
        else {
            v3 = rect1.centerX();
            v5 = rect1.centerY();
        }
        float f = (float)(rect0.centerX() - v3);
        float f1 = (float)(rect0.centerY() - v5);
        if(f == 0.0f && f1 == 0.0f) {
            f = ((float)(Math.random() * 2.0)) - 1.0f;
            f1 = ((float)(Math.random() * 2.0)) - 1.0f;
        }
        float f2 = (float)Math.sqrt(f1 * f1 + f * f);
        float f3 = (float)Math.max(v3 - v, viewGroup0.getWidth() - (v3 - v));
        float f4 = (float)Math.max(v5 - v1, viewGroup0.getHeight() - (v5 - v1));
        float f5 = (float)Math.sqrt(f4 * f4 + f3 * f3);
        arr_v[0] = Math.round(f / f2 * f5);
        arr_v[1] = Math.round(f5 * (f1 / f2));
    }

    public final void U(b0 b00) {
        b00.b.getLocationOnScreen(this.d0);
        int v = this.d0[0];
        int v1 = this.d0[1];
        Rect rect0 = new Rect(v, v1, b00.b.getWidth() + v, b00.b.getHeight() + v1);
        b00.a.put("android:explode:screenBounds", rect0);
    }

    @Override  // androidx.transition.Visibility
    public final void d(b0 b00) {
        Visibility.O(b00);
        this.U(b00);
    }

    @Override  // androidx.transition.Visibility
    public final void g(b0 b00) {
        Visibility.O(b00);
        this.U(b00);
    }

    @Override  // androidx.transition.Transition
    public final boolean t() {
        return true;
    }
}

