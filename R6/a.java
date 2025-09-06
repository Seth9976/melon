package r6;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import d5.n;
import e6.e;
import e6.f;
import java.util.ArrayList;
import pc.t;

public abstract class a {
    public final Context a;
    public final ExtendedFloatingActionButton b;
    public final ArrayList c;
    public final t d;
    public f e;
    public f f;

    public a(ExtendedFloatingActionButton extendedFloatingActionButton0, t t0) {
        this.c = new ArrayList();
        this.b = extendedFloatingActionButton0;
        this.a = extendedFloatingActionButton0.getContext();
        this.d = t0;
    }

    public AnimatorSet a() {
        f f0 = this.f;
        if(f0 == null) {
            if(this.e == null) {
                int v = this.c();
                this.e = f.b(this.a, v);
            }
            f0 = this.e;
            f0.getClass();
        }
        return this.b(f0);
    }

    public final AnimatorSet b(f f0) {
        ArrayList arrayList0 = new ArrayList();
        boolean z = f0.g("opacity");
        ExtendedFloatingActionButton extendedFloatingActionButton0 = this.b;
        if(z) {
            arrayList0.add(f0.d("opacity", extendedFloatingActionButton0, View.ALPHA));
        }
        if(f0.g("scale")) {
            arrayList0.add(f0.d("scale", extendedFloatingActionButton0, View.SCALE_Y));
            arrayList0.add(f0.d("scale", extendedFloatingActionButton0, View.SCALE_X));
        }
        if(f0.g("width")) {
            arrayList0.add(f0.d("width", extendedFloatingActionButton0, ExtendedFloatingActionButton.h0));
        }
        if(f0.g("height")) {
            arrayList0.add(f0.d("height", extendedFloatingActionButton0, ExtendedFloatingActionButton.i0));
        }
        if(f0.g("paddingStart")) {
            arrayList0.add(f0.d("paddingStart", extendedFloatingActionButton0, ExtendedFloatingActionButton.j0));
        }
        if(f0.g("paddingEnd")) {
            arrayList0.add(f0.d("paddingEnd", extendedFloatingActionButton0, ExtendedFloatingActionButton.k0));
        }
        if(f0.g("labelOpacity")) {
            arrayList0.add(f0.d("labelOpacity", extendedFloatingActionButton0, new e(this)));
        }
        AnimatorSet animatorSet0 = new AnimatorSet();
        n.y(animatorSet0, arrayList0);
        return animatorSet0;
    }

    public abstract int c();

    public void d() {
        this.d.b = null;
    }

    public abstract void e();

    public abstract void f(Animator arg1);

    public abstract void g();

    public abstract boolean h();
}

