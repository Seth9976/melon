package com.melon.playback;

import Nb.g;
import androidx.lifecycle.LifecycleService;
import ee.l;
import fe.b;

public abstract class Hilt_MelonBudsReceiverService extends LifecycleService implements b {
    public volatile l a;
    public final Object b;
    public boolean c;

    public Hilt_MelonBudsReceiverService() {
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
            g g0 = (g)this.generatedComponent();
            MelonBudsReceiverService melonBudsReceiverService0 = (MelonBudsReceiverService)this;
            g0.getClass();
        }
        super.onCreate();
    }
}

