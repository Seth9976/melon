package b;

import Ic.h;
import P1.e;
import android.os.Build.VERSION;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.v;
import androidx.lifecycle.D;
import androidx.lifecycle.s;
import java.util.ListIterator;
import je.m;

public final class t {
    public final Runnable a;
    public final m b;
    public n c;
    public final OnBackInvokedCallback d;
    public OnBackInvokedDispatcher e;
    public boolean f;
    public boolean g;

    public t(Runnable runnable0) {
        this.a = runnable0;
        this.b = new m();
        int v = Build.VERSION.SDK_INT;
        if(v >= 33) {
            q q0 = v >= 34 ? new q(new o(this, 0), new o(this, 1), new p(this, 0), new p(this, 1)) : new v(new p(this, 2), 2);
            this.d = q0;
        }
    }

    public final void a(D d0, n n0) {
        kotlin.jvm.internal.q.g(n0, "onBackPressedCallback");
        androidx.lifecycle.t t0 = d0.getLifecycle();
        if(t0.b() == s.a) {
            return;
        }
        n0.addCancellable(new r(this, t0, n0));
        this.e();
        n0.setEnabledChangedCallback$activity_release(new h(0, this, t.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0, 7));
    }

    public final void b() {
        n n0 = this.c;
        if(n0 == null) {
            Object object0 = null;
            ListIterator listIterator0 = this.b.listIterator(this.b.size());
            while(listIterator0.hasPrevious()) {
                Object object1 = listIterator0.previous();
                if(((n)object1).isEnabled()) {
                    object0 = object1;
                    break;
                }
            }
            n0 = (n)object0;
        }
        this.c = null;
        if(n0 != null) {
            n0.handleOnBackCancelled();
        }
    }

    public final void c() {
        n n0 = this.c;
        if(n0 == null) {
            Object object0 = null;
            ListIterator listIterator0 = this.b.listIterator(this.b.b());
            while(listIterator0.hasPrevious()) {
                Object object1 = listIterator0.previous();
                if(((n)object1).isEnabled()) {
                    object0 = object1;
                    break;
                }
            }
            n0 = (n)object0;
        }
        this.c = null;
        if(n0 != null) {
            n0.handleOnBackPressed();
            return;
        }
        Runnable runnable0 = this.a;
        if(runnable0 != null) {
            runnable0.run();
        }
    }

    public final void d(boolean z) {
        OnBackInvokedDispatcher onBackInvokedDispatcher0 = this.e;
        if(onBackInvokedDispatcher0 != null) {
            OnBackInvokedCallback onBackInvokedCallback0 = this.d;
            if(onBackInvokedCallback0 != null) {
                if(z && !this.f) {
                    e.k(onBackInvokedDispatcher0, onBackInvokedCallback0);
                    this.f = true;
                    return;
                }
                if(!z && this.f) {
                    e.m(onBackInvokedDispatcher0, onBackInvokedCallback0);
                    this.f = false;
                }
            }
        }
    }

    public final void e() {
        boolean z = this.g;
        boolean z1 = false;
        m m0 = this.b;
        if(m0 == null || !m0.isEmpty()) {
            for(Object object0: m0) {
                if(((n)object0).isEnabled()) {
                    z1 = true;
                    break;
                }
                if(false) {
                    break;
                }
            }
        }
        this.g = z1;
        if(z1 != z && Build.VERSION.SDK_INT >= 33) {
            this.d(z1);
        }
    }
}

