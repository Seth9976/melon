package com.bumptech.glide.manager;

import androidx.lifecycle.C;
import androidx.lifecycle.D;
import androidx.lifecycle.N;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import com.bumptech.glide.util.Util;
import java.util.HashSet;
import java.util.Set;

final class LifecycleLifecycle implements C, Lifecycle {
    private final t lifecycle;
    private final Set lifecycleListeners;

    public LifecycleLifecycle(t t0) {
        this.lifecycleListeners = new HashSet();
        this.lifecycle = t0;
        t0.a(this);
    }

    @Override  // com.bumptech.glide.manager.Lifecycle
    public void addListener(LifecycleListener lifecycleListener0) {
        this.lifecycleListeners.add(lifecycleListener0);
        if(this.lifecycle.b() == s.a) {
            lifecycleListener0.onDestroy();
            return;
        }
        if(this.lifecycle.b().a(s.d)) {
            lifecycleListener0.onStart();
            return;
        }
        lifecycleListener0.onStop();
    }

    @N(r.ON_DESTROY)
    public void onDestroy(D d0) {
        for(Object object0: Util.getSnapshot(this.lifecycleListeners)) {
            ((LifecycleListener)object0).onDestroy();
        }
        d0.getLifecycle().c(this);
    }

    @N(r.ON_START)
    public void onStart(D d0) {
        for(Object object0: Util.getSnapshot(this.lifecycleListeners)) {
            ((LifecycleListener)object0).onStart();
        }
    }

    @N(r.ON_STOP)
    public void onStop(D d0) {
        for(Object object0: Util.getSnapshot(this.lifecycleListeners)) {
            ((LifecycleListener)object0).onStop();
        }
    }

    @Override  // com.bumptech.glide.manager.Lifecycle
    public void removeListener(LifecycleListener lifecycleListener0) {
        this.lifecycleListeners.remove(lifecycleListener0);
    }
}

