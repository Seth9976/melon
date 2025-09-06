package com.google.android.material.bottomappbar;

import U4.w;
import V4.G;
import V4.k;
import androidx.appcompat.widget.ActionMenuView;
import java.util.Set;
import kotlin.jvm.internal.q;

public final class f implements Runnable {
    public final int a;
    public final boolean b;
    public final int c;
    public final Object d;
    public final Object e;

    public f(V4.f f0, k k0, boolean z, int v) {
        this.a = 1;
        q.g(f0, "processor");
        q.g(k0, "token");
        super();
        this.d = f0;
        this.e = k0;
        this.b = z;
        this.c = v;
    }

    public f(BottomAppBar bottomAppBar0, ActionMenuView actionMenuView0, int v, boolean z) {
        this.a = 0;
        super();
        this.e = bottomAppBar0;
        this.d = actionMenuView0;
        this.c = v;
        this.b = z;
    }

    @Override
    public final void run() {
        G g0;
        G g1;
        boolean z;
        if(this.a != 0) {
            if(this.b) {
                ((V4.f)this.d).getClass();
                String s = ((k)this.e).a.a;
                synchronized(((V4.f)this.d).k) {
                    g0 = ((V4.f)this.d).b(s);
                }
                z = V4.f.d(s, g0, this.c);
            }
            else {
                V4.f f0 = (V4.f)this.d;
                k k0 = (k)this.e;
                int v1 = this.c;
                f0.getClass();
                String s1 = k0.a.a;
                Object object0 = f0.k;
                synchronized(object0) {
                    if(f0.f.get(s1) == null) {
                        Set set0 = (Set)f0.h.get(s1);
                        if(set0 == null || !set0.contains(k0)) {
                            z = false;
                        }
                        else {
                            g1 = f0.b(s1);
                            z = V4.f.d(s1, g1, v1);
                        }
                    }
                    else {
                        w.e().a("WM-Processor", "Ignored stopWork. WorkerWrapper " + s1 + " is in foreground");
                        z = false;
                    }
                    w.e().a("WM-StopWorkRunnable", "StopWorkRunnable for " + ((k)this.e).a.a + "; Processor.stopWork = " + z);
                    return;
                }
                z = V4.f.d(s1, g1, v1);
                w.e().a("WM-StopWorkRunnable", "StopWorkRunnable for " + ((k)this.e).a.a + "; Processor.stopWork = " + z);
                return;
            }
            w.e().a("WM-StopWorkRunnable", "StopWorkRunnable for " + ((k)this.e).a.a + "; Processor.stopWork = " + z);
            return;
        }
        float f1 = (float)((BottomAppBar)this.e).D(((ActionMenuView)this.d), this.c, this.b);
        ((ActionMenuView)this.d).setTranslationX(f1);
    }
}

