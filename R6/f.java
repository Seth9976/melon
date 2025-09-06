package r6;

import android.animation.Animator;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import pc.t;

public final class f extends a {
    public final ExtendedFloatingActionButton g;

    public f(ExtendedFloatingActionButton extendedFloatingActionButton0, t t0) {
        this.g = extendedFloatingActionButton0;
        super(extendedFloatingActionButton0, t0);
    }

    @Override  // r6.a
    public final int c() {
        return 0x7F02001E;  // animator:mtrl_extended_fab_show_motion_spec
    }

    @Override  // r6.a
    public final void e() {
        this.d.b = null;
        this.g.E = 0;
    }

    @Override  // r6.a
    public final void f(Animator animator0) {
        t t0 = this.d;
        Animator animator1 = (Animator)t0.b;
        if(animator1 != null) {
            animator1.cancel();
        }
        t0.b = animator0;
        this.g.setVisibility(0);
        this.g.E = 2;
    }

    @Override  // r6.a
    public final void g() {
        this.g.setVisibility(0);
        this.g.setAlpha(1.0f);
        this.g.setScaleY(1.0f);
        this.g.setScaleX(1.0f);
    }

    @Override  // r6.a
    public final boolean h() {
        return this.g.getVisibility() == 0 ? this.g.E != 1 : this.g.E == 2;
    }
}

