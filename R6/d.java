package r6;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import e6.f;
import pc.t;

public final class d extends a {
    public final g g;
    public final boolean h;
    public final ExtendedFloatingActionButton i;

    public d(ExtendedFloatingActionButton extendedFloatingActionButton0, t t0, g g0, boolean z) {
        this.i = extendedFloatingActionButton0;
        super(extendedFloatingActionButton0, t0);
        this.g = g0;
        this.h = z;
    }

    @Override  // r6.a
    public final AnimatorSet a() {
        f f0 = this.f;
        if(f0 == null) {
            if(this.e == null) {
                int v = this.c();
                this.e = f.b(this.a, v);
            }
            f0 = this.e;
            f0.getClass();
        }
        boolean z = f0.g("width");
        g g0 = this.g;
        ExtendedFloatingActionButton extendedFloatingActionButton0 = this.i;
        if(z) {
            PropertyValuesHolder[] arr_propertyValuesHolder = f0.e("width");
            arr_propertyValuesHolder[0].setFloatValues(new float[]{((float)extendedFloatingActionButton0.getWidth()), ((float)g0.getWidth())});
            f0.h("width", arr_propertyValuesHolder);
        }
        if(f0.g("height")) {
            PropertyValuesHolder[] arr_propertyValuesHolder1 = f0.e("height");
            arr_propertyValuesHolder1[0].setFloatValues(new float[]{((float)extendedFloatingActionButton0.getHeight()), ((float)g0.getHeight())});
            f0.h("height", arr_propertyValuesHolder1);
        }
        if(f0.g("paddingStart")) {
            PropertyValuesHolder[] arr_propertyValuesHolder2 = f0.e("paddingStart");
            arr_propertyValuesHolder2[0].setFloatValues(new float[]{((float)extendedFloatingActionButton0.getPaddingStart()), ((float)g0.getPaddingStart())});
            f0.h("paddingStart", arr_propertyValuesHolder2);
        }
        if(f0.g("paddingEnd")) {
            PropertyValuesHolder[] arr_propertyValuesHolder3 = f0.e("paddingEnd");
            arr_propertyValuesHolder3[0].setFloatValues(new float[]{((float)extendedFloatingActionButton0.getPaddingEnd()), ((float)g0.getPaddingEnd())});
            f0.h("paddingEnd", arr_propertyValuesHolder3);
        }
        if(f0.g("labelOpacity")) {
            PropertyValuesHolder[] arr_propertyValuesHolder4 = f0.e("labelOpacity");
            float f1 = 1.0f;
            float f2 = this.h ? 0.0f : 1.0f;
            if(!this.h) {
                f1 = 0.0f;
            }
            arr_propertyValuesHolder4[0].setFloatValues(new float[]{f2, f1});
            f0.h("labelOpacity", arr_propertyValuesHolder4);
        }
        return this.b(f0);
    }

    // 去混淆评级： 低(20)
    @Override  // r6.a
    public final int c() {
        return this.h ? 0x7F02001C : 0x7F02001B;  // animator:mtrl_extended_fab_change_size_expand_motion_spec
    }

    @Override  // r6.a
    public final void e() {
        this.d.b = null;
        this.i.c0 = false;
        this.i.setHorizontallyScrolling(false);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.i.getLayoutParams();
        if(viewGroup$LayoutParams0 == null) {
            return;
        }
        viewGroup$LayoutParams0.width = this.g.c().width;
        viewGroup$LayoutParams0.height = this.g.c().height;
    }

    @Override  // r6.a
    public final void f(Animator animator0) {
        t t0 = this.d;
        Animator animator1 = (Animator)t0.b;
        if(animator1 != null) {
            animator1.cancel();
        }
        t0.b = animator0;
        this.i.b0 = this.h;
        this.i.c0 = true;
        this.i.setHorizontallyScrolling(true);
    }

    @Override  // r6.a
    public final void g() {
        ExtendedFloatingActionButton extendedFloatingActionButton0 = this.i;
        boolean z = this.h;
        extendedFloatingActionButton0.b0 = z;
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = extendedFloatingActionButton0.getLayoutParams();
        if(viewGroup$LayoutParams0 == null) {
            return;
        }
        if(!z) {
            extendedFloatingActionButton0.f0 = viewGroup$LayoutParams0.width;
            extendedFloatingActionButton0.g0 = viewGroup$LayoutParams0.height;
        }
        viewGroup$LayoutParams0.width = this.g.c().width;
        viewGroup$LayoutParams0.height = this.g.c().height;
        extendedFloatingActionButton0.setPaddingRelative(this.g.getPaddingStart(), extendedFloatingActionButton0.getPaddingTop(), this.g.getPaddingEnd(), extendedFloatingActionButton0.getPaddingBottom());
        extendedFloatingActionButton0.requestLayout();
    }

    @Override  // r6.a
    public final boolean h() {
        return this.h == this.i.b0 || this.i.getIcon() == null || TextUtils.isEmpty(this.i.getText());
    }
}

