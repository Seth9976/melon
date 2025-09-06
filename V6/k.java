package v6;

import O4.c;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;

public final class k extends AnimatorListenerAdapter {
    public final int a;
    public final l b;

    public k(l l0, int v) {
        this.a = v;
        this.b = l0;
        super();
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationEnd(Animator animator0) {
        if(this.a != 1) {
            super.onAnimationEnd(animator0);
            return;
        }
        super.onAnimationEnd(animator0);
        l l0 = this.b;
        l.a(l0);
        ArrayList arrayList0 = l0.f;
        if(arrayList0 != null && !l0.g) {
            for(Object object0: arrayList0) {
                ((c)object0).a(l0);
            }
        }
    }

    @Override  // android.animation.AnimatorListenerAdapter
    public void onAnimationStart(Animator animator0) {
        if(this.a != 0) {
            super.onAnimationStart(animator0);
            return;
        }
        super.onAnimationStart(animator0);
        l l0 = this.b;
        ArrayList arrayList0 = l0.f;
        if(arrayList0 != null && !l0.g) {
            for(Object object0: arrayList0) {
                ((c)object0).b(l0);
            }
        }
    }
}

