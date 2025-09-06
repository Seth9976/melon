package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import we.a;

public final class x implements Runnable {
    public final int a;
    public final Object b;

    public x(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                ((I)this.b).mViewLifecycleOwner.f.a(((I)this.b).mSavedViewRegistryState);
                ((I)this.b).mSavedViewRegistryState = null;
                return;
            }
            case 1: {
                q.g(((H)this.b), "$seekCancelLambda");
                a a0 = (a)((H)this.b).a;
                if(a0 != null) {
                    a0.invoke();
                }
                return;
            }
            case 2: {
                z0.a(4, ((ArrayList)this.b));
                return;
            }
            case 3: {
                n n0 = (n)this.b;
                if(l0.P(2)) {
                    Log.v("FragmentManager", "Transition for all operations has completed");
                }
                for(Object object1: n0.c) {
                    ((o)object1).a.c(n0);
                }
                return;
            }
            default: {
                for(Object object0: ((l0)this.b).o) {
                    ((h0)object0).onBackStackChangeCancelled();
                }
            }
        }
    }
}

