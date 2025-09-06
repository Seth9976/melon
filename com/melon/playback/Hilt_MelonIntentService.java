package com.melon.playback;

import Nb.p;
import Ub.q;
import androidx.lifecycle.LifecycleService;
import ee.l;
import fe.b;
import k8.a;
import k8.j;
import kc.s2;

public abstract class Hilt_MelonIntentService extends LifecycleService implements b {
    public volatile l a;
    public final Object b;
    public boolean c;

    public Hilt_MelonIntentService() {
        this.b = new Object();
        this.c = false;
    }

    @Override  // fe.b
    public final Object generatedComponent() {
        if(this.a == null) {
            Object object0 = this.b;
            synchronized(object0) {
                if(this.a == null) {
                    this.a = new l(this);
                }
            }
        }
        return this.a.generatedComponent();
    }

    @Override  // androidx.lifecycle.LifecycleService
    public void onCreate() {
        if(!this.c) {
            this.c = true;
            p p0 = (p)this.generatedComponent();
            ((MelonIntentService)this).e = (a)((j)p0).b.l.get();
            ((MelonIntentService)this).f = (s2)((j)p0).b.w.get();
            ((MelonIntentService)this).g = (q)((j)p0).b.u.get();
        }
        super.onCreate();
    }
}

