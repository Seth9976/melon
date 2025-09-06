package com.iloen.melon.playback.voicealarm;

import androidx.lifecycle.LifecycleService;
import ee.l;
import fe.b;

public abstract class Hilt_AlarmPlayService extends LifecycleService implements b {
    private volatile l componentManager;
    private final Object componentManagerLock;
    private boolean injected;

    public Hilt_AlarmPlayService() {
        this.componentManagerLock = new Object();
        this.injected = false;
    }

    public final l componentManager() {
        if(this.componentManager == null) {
            Object object0 = this.componentManagerLock;
            synchronized(object0) {
                if(this.componentManager == null) {
                    this.componentManager = this.createComponentManager();
                }
            }
        }
        return this.componentManager;
    }

    public b componentManager() {
        return this.componentManager();
    }

    public l createComponentManager() {
        return new l(this);
    }

    @Override  // fe.b
    public final Object generatedComponent() {
        return this.componentManager().generatedComponent();
    }

    public void inject() {
        if(!this.injected) {
            this.injected = true;
            ((AlarmPlayService_GeneratedInjector)this.generatedComponent()).injectAlarmPlayService(((AlarmPlayService)this));
        }
    }

    @Override  // androidx.lifecycle.LifecycleService
    public void onCreate() {
        this.inject();
        super.onCreate();
    }
}

