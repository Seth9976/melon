package com.iloen.melon.eventbus;

import android.app.Activity;

@Deprecated(forRemoval = true, since = "[ActivityLifecycleEvent] 사용하세요")
public class EventActivityState {
    public static class EventActivityPaused extends EventActivityState {
        public EventActivityPaused(Activity activity0) {
            super(activity0);
        }
    }

    public static class EventActivityResumed extends EventActivityState {
        public EventActivityResumed(Activity activity0) {
            super(activity0);
        }
    }

    public static class EventActivityStarted extends EventActivityState {
        public EventActivityStarted(Activity activity0) {
            super(activity0);
        }
    }

    public static class EventActivityStopped extends EventActivityState {
        public EventActivityStopped(Activity activity0) {
            super(activity0);
        }
    }

    public final Activity mActivity;

    public EventActivityState(Activity activity0) {
        this.mActivity = activity0;
    }
}

