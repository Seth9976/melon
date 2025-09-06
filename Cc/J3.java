package Cc;

import androidx.activity.ComponentActivity;
import androidx.compose.runtime.b0;
import androidx.lifecycle.B;
import androidx.lifecycle.D;
import androidx.lifecycle.i;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import c2.o;
import c2.p;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;

public final class j3 implements B {
    public final int a;
    public final Object b;
    public final Object c;

    public j3(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // androidx.lifecycle.B
    public final void onStateChanged(D d0, r r0) {
        switch(this.a) {
            case 0: {
                s s0 = ((t)this.b).b();
                ((b0)this.c).setValue(s0);
                return;
            }
            case 1: {
                u u0 = (u)this.b;
                Job job0 = (Job)this.c;
                if(d0.getLifecycle().b() == s.a) {
                    DefaultImpls.cancel$default(job0, null, 1, null);
                    u0.a();
                    return;
                }
                s s1 = d0.getLifecycle().b();
                i i0 = u0.c;
                if(s1.compareTo(u0.b) < 0) {
                    i0.a = true;
                    return;
                }
                if(i0.a) {
                    if(i0.b) {
                        throw new IllegalStateException("Cannot resume a finished dispatcher");
                    }
                    i0.a = false;
                    i0.a();
                    return;
                }
                return;
            }
            case 2: {
                ComponentActivity.addObserverForBackInvoker$lambda$7(((b.t)this.b), ((ComponentActivity)this.c), d0, r0);
                return;
            }
            default: {
                o o0 = (o)this.b;
                p p0 = (p)this.c;
                o0.getClass();
                if(r0 == r.ON_DESTROY) {
                    o0.b(p0);
                }
            }
        }
    }
}

