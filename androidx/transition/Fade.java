package androidx.transition;

import N4.L;
import N4.b0;
import N4.e0;
import N4.p;
import R1.a;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class Fade extends Visibility {
    public Fade(int v) {
        this.S(v);
    }

    public Fade(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, L.d);
        this.S(a.d(typedArray0, ((XmlResourceParser)attributeSet0), "fadingMode", 0, this.b0));
        typedArray0.recycle();
    }

    @Override  // androidx.transition.Visibility
    public final Animator Q(ViewGroup viewGroup0, View view0, b0 b00, b0 b01) {
        e0.a.getClass();
        return this.T(view0, Fade.U(b00, 0.0f), 1.0f);
    }

    @Override  // androidx.transition.Visibility
    public final Animator R(ViewGroup viewGroup0, View view0, b0 b00, b0 b01) {
        e0.a.getClass();
        Animator animator0 = this.T(view0, Fade.U(b00, 1.0f), 0.0f);
        if(animator0 == null) {
            e0.b(view0, Fade.U(b01, 1.0f));
        }
        return animator0;
    }

    public final ObjectAnimator T(View view0, float f, float f1) {
        if(f == f1) {
            return null;
        }
        e0.b(view0, f);
        ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(view0, e0.b, new float[]{f1});
        p p0 = new p(view0);
        objectAnimator0.addListener(p0);
        this.o().a(p0);
        return objectAnimator0;
    }

    public static float U(b0 b00, float f) {
        if(b00 != null) {
            Float float0 = (Float)b00.a.get("android:fade:transitionAlpha");
            return float0 == null ? f : ((float)float0);
        }
        return f;
    }

    @Override  // androidx.transition.Visibility
    public final void g(b0 b00) {
        Visibility.O(b00);
        View view0 = b00.b;
        Float float0 = (Float)view0.getTag(0x7F0A0BE2);  // id:transition_pause_alpha
        if(float0 == null) {
            float0 = view0.getVisibility() == 0 ? e0.a.g(view0) : 0.0f;
        }
        b00.a.put("android:fade:transitionAlpha", float0);
    }

    @Override  // androidx.transition.Transition
    public final boolean t() {
        return true;
    }
}

