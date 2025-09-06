package androidx.transition;

import N4.H;
import N4.I;
import N4.J;
import N4.K;
import N4.L;
import N4.b0;
import R1.a;
import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import org.xmlpull.v1.XmlPullParser;

public class Slide extends Visibility {
    public final K d0;
    public static final DecelerateInterpolator e0;
    public static final AccelerateInterpolator f0;
    public static final I g0;
    public static final I h0;
    public static final J i0;
    public static final I j0;
    public static final I k0;
    public static final J l0;

    static {
        Slide.e0 = new DecelerateInterpolator();
        Slide.f0 = new AccelerateInterpolator();
        Slide.g0 = new I(0);
        Slide.h0 = new I(1);
        Slide.i0 = new J(0);
        Slide.j0 = new I(2);
        Slide.k0 = new I(3);
        Slide.l0 = new J(1);
    }

    public Slide(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        J j0 = Slide.l0;
        this.d0 = j0;
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, L.f);
        int v = a.d(typedArray0, ((XmlPullParser)attributeSet0), "slideEdge", 0, 80);
        typedArray0.recycle();
        switch(v) {
            case 3: {
                this.d0 = Slide.g0;
                break;
            }
            case 5: {
                this.d0 = Slide.j0;
                break;
            }
            case 0x30: {
                this.d0 = Slide.i0;
                break;
            }
            case 80: {
                this.d0 = j0;
                break;
            }
            case 0x800003: {
                this.d0 = Slide.h0;
                break;
            }
            case 0x800005: {
                this.d0 = Slide.k0;
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid slide direction");
            }
        }
        H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
        h0.u = v;
        this.I = h0;
    }

    @Override  // androidx.transition.Visibility
    public final Animator Q(ViewGroup viewGroup0, View view0, b0 b00, b0 b01) {
        if(b01 == null) {
            return null;
        }
        int[] arr_v = (int[])b01.a.get("android:slide:screenPosition");
        float f = view0.getTranslationX();
        float f1 = view0.getTranslationY();
        float f2 = this.d0.b(viewGroup0, view0);
        float f3 = this.d0.a(viewGroup0, view0);
        return L.d(view0, b01, arr_v[0], arr_v[1], f2, f3, f, f1, Slide.e0, this);
    }

    @Override  // androidx.transition.Visibility
    public final Animator R(ViewGroup viewGroup0, View view0, b0 b00, b0 b01) {
        if(b00 == null) {
            return null;
        }
        int[] arr_v = (int[])b00.a.get("android:slide:screenPosition");
        float f = view0.getTranslationX();
        float f1 = view0.getTranslationY();
        float f2 = this.d0.b(viewGroup0, view0);
        float f3 = this.d0.a(viewGroup0, view0);
        return L.d(view0, b00, arr_v[0], arr_v[1], f, f1, f2, f3, Slide.f0, this);
    }

    @Override  // androidx.transition.Visibility
    public final void d(b0 b00) {
        Visibility.O(b00);
        int[] arr_v = new int[2];
        b00.b.getLocationOnScreen(arr_v);
        b00.a.put("android:slide:screenPosition", arr_v);
    }

    @Override  // androidx.transition.Visibility
    public final void g(b0 b00) {
        Visibility.O(b00);
        int[] arr_v = new int[2];
        b00.b.getLocationOnScreen(arr_v);
        b00.a.put("android:slide:screenPosition", arr_v);
    }

    @Override  // androidx.transition.Transition
    public final boolean t() {
        return true;
    }
}

