package com.kakao.tiara;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class TiaraLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    interface Callback {
        void onBackground();

        void onForeground();
    }

    private int activeActivities;
    private final Callback callback;
    private boolean foreground;

    public TiaraLifecycleCallbacks(Callback tiaraLifecycleCallbacks$Callback0) {
        this.callback = tiaraLifecycleCallbacks$Callback0;
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity0, Bundle bundle0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity0) {
        --this.activeActivities;
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity0) {
        ++this.activeActivities;
        if(!this.foreground) {
            this.foreground = true;
            this.callback.onForeground();
        }
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity0, Bundle bundle0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity0) {
        if(this.activeActivities == 0 && this.foreground) {
            this.foreground = false;
            this.callback.onBackground();
        }
    }
}

