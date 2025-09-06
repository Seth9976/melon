package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class ActivityLifecycleObserver {
    @KeepForSdk
    public static final ActivityLifecycleObserver of(Activity activity0) {
        return new zab(zaa.zaa(activity0));
    }

    @KeepForSdk
    public abstract ActivityLifecycleObserver onStopCallOnce(Runnable arg1);
}

