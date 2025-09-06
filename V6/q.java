package v6;

import A6.h;
import N4.b;
import Q0.a;
import android.animation.ObjectAnimator;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import java.util.ArrayList;

public final class q extends a {
    public ObjectAnimator c;
    public final P2.a d;
    public final LinearProgressIndicatorSpec e;
    public int f;
    public boolean g;
    public float h;
    public static final b i;

    static {
        q.i = new b("animationFraction", 18, Float.class);
    }

    public q(LinearProgressIndicatorSpec linearProgressIndicatorSpec0) {
        super(3);
        this.f = 1;
        this.e = linearProgressIndicatorSpec0;
        this.d = new P2.a(1);
    }

    @Override  // Q0.a
    public final void c() {
        ObjectAnimator objectAnimator0 = this.c;
        if(objectAnimator0 != null) {
            objectAnimator0.cancel();
        }
    }

    @Override  // Q0.a
    public final void n() {
        this.y();
    }

    @Override  // Q0.a
    public final void t(c c0) {
    }

    @Override  // Q0.a
    public final void u() {
    }

    @Override  // Q0.a
    public final void w() {
        if(this.c == null) {
            ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(this, q.i, new float[]{0.0f, 1.0f});
            this.c = objectAnimator0;
            objectAnimator0.setDuration(333L);
            this.c.setInterpolator(null);
            this.c.setRepeatCount(-1);
            this.c.addListener(new h(this, 13));
        }
        this.y();
        this.c.start();
    }

    @Override  // Q0.a
    public final void x() {
    }

    public final void y() {
        this.g = true;
        this.f = 1;
        for(Object object0: ((ArrayList)this.b)) {
            ((m)object0).c = this.e.c[0];
            ((m)object0).d = this.e.g / 2;
        }
    }
}

