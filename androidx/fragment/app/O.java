package androidx.fragment.app;

import android.transition.Transition;

public final class o extends j {
    public final Object b;
    public final boolean c;
    public final Object d;

    public o(L0 l00, boolean z, boolean z1) {
        Object object1;
        boolean z2;
        Object object0;
        I i0 = l00.c;
        super(l00);
        if(l00.a != 2) {
            object0 = z ? i0.getReturnTransition() : i0.getExitTransition();
        }
        else if(z) {
            object0 = i0.getReenterTransition();
        }
        else {
            object0 = i0.getEnterTransition();
        }
        this.b = object0;
        if(l00.a != 2) {
            z2 = true;
        }
        else if(z) {
            z2 = i0.getAllowReturnTransitionOverlap();
        }
        else {
            z2 = i0.getAllowEnterTransitionOverlap();
        }
        this.c = z2;
        if(!z1) {
            object1 = null;
        }
        else if(z) {
            object1 = i0.getSharedElementReturnTransition();
        }
        else {
            object1 = i0.getSharedElementEnterTransition();
        }
        this.d = object1;
    }

    public final G0 b() {
        Object object0 = this.b;
        G0 g00 = this.c(object0);
        Object object1 = this.d;
        G0 g01 = this.c(object1);
        if(g00 != null && g01 != null && g00 != g01) {
            throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + this.a.c + " returned Transition " + object0 + " which uses a different Transition  type than its shared element transition " + object1).toString());
        }
        return g00 == null ? g01 : g00;
    }

    public final G0 c(Object object0) {
        if(object0 == null) {
            return null;
        }
        G0 g00 = z0.a;
        if(object0 instanceof Transition) {
            return g00;
        }
        G0 g01 = z0.b;
        if(g01 == null || !g01.g(object0)) {
            throw new IllegalArgumentException("Transition " + object0 + " for fragment " + this.a.c + " is not a valid framework Transition or AndroidX Transition");
        }
        return g01;
    }
}

