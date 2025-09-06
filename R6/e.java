package r6;

import android.animation.Animator;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import pc.t;

public final class e extends a {
    public boolean g;
    public final ExtendedFloatingActionButton h;

    public e(ExtendedFloatingActionButton extendedFloatingActionButton0, t t0) {
        this.h = extendedFloatingActionButton0;
        super(extendedFloatingActionButton0, t0);
    }

    @Override  // r6.a
    public final int c() {
        return 0x7F02001D;  // animator:mtrl_extended_fab_hide_motion_spec
    }

    @Override  // r6.a
    public final void d() {
        super.d();
        this.g = true;
    }

    @Override  // r6.a
    public final void e() {
        this.d.b = null;
        ExtendedFloatingActionButton extendedFloatingActionButton0 = this.h;
        extendedFloatingActionButton0.E = 0;
        if(!this.g) {
            extendedFloatingActionButton0.setVisibility(8);
        }
    }

    @Override  // r6.a
    public final void f(Animator animator0) {
        t t0 = this.d;
        Animator animator1 = (Animator)t0.b;
        if(animator1 != null) {
            animator1.cancel();
        }
        t0.b = animator0;
        this.g = false;
        this.h.setVisibility(0);
        this.h.E = 1;
    }

    @Override  // r6.a
    public final void g() {
        this.h.setVisibility(8);
    }

    @Override  // r6.a
    public final boolean h() {
        return this.h.getVisibility() == 0 ? this.h.E == 1 : this.h.E != 2;
    }
}

