package v6;

import N4.b;
import O4.c;
import Q0.a;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import java.util.ArrayList;

public final class s extends a {
    public ObjectAnimator c;
    public ObjectAnimator d;
    public final Interpolator[] e;
    public final LinearProgressIndicatorSpec f;
    public int g;
    public boolean h;
    public float i;
    public c j;
    public static final int[] k;
    public static final int[] l;
    public static final b m;

    static {
        s.k = new int[]{533, 567, 850, 750};
        s.l = new int[]{0x4F3, 1000, 333, 0};
        s.m = new b("animationFraction", 19, Float.class);
    }

    public s(Context context0, LinearProgressIndicatorSpec linearProgressIndicatorSpec0) {
        super(2);
        this.g = 0;
        this.j = null;
        this.f = linearProgressIndicatorSpec0;
        this.e = new Interpolator[]{AnimationUtils.loadInterpolator(context0, 0x7F01002F), AnimationUtils.loadInterpolator(context0, 0x7F010030), AnimationUtils.loadInterpolator(context0, 0x7F010031), AnimationUtils.loadInterpolator(context0, 0x7F010032)};  // anim:linear_indeterminate_line1_head_interpolator
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
    public final void t(v6.c c0) {
        this.j = c0;
    }

    @Override  // Q0.a
    public final void u() {
        if(this.d != null && !this.d.isRunning()) {
            this.c();
            if(((o)this.a).isVisible()) {
                this.d.setFloatValues(new float[]{this.i, 1.0f});
                this.d.setDuration(((long)((1.0f - this.i) * 1800.0f)));
                this.d.start();
            }
        }
    }

    @Override  // Q0.a
    public final void w() {
        b b0 = s.m;
        if(this.c == null) {
            ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(this, b0, new float[]{0.0f, 1.0f});
            this.c = objectAnimator0;
            objectAnimator0.setDuration(1800L);
            this.c.setInterpolator(null);
            this.c.setRepeatCount(-1);
            this.c.addListener(new r(this, 0));
        }
        if(this.d == null) {
            ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(this, b0, new float[]{1.0f});
            this.d = objectAnimator1;
            objectAnimator1.setDuration(1800L);
            this.d.setInterpolator(null);
            this.d.addListener(new r(this, 1));
        }
        this.y();
        this.c.start();
    }

    @Override  // Q0.a
    public final void x() {
        this.j = null;
    }

    public final void y() {
        this.g = 0;
        for(Object object0: ((ArrayList)this.b)) {
            ((m)object0).c = this.f.c[0];
        }
    }
}

