package com.google.android.gms.common.stats;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

@KeepForSdk
@Deprecated
public class WakeLockTracker {
    private static final WakeLockTracker zza;

    static {
        WakeLockTracker.zza = new WakeLockTracker();
    }

    @KeepForSdk
    public static WakeLockTracker getInstance() {
        return WakeLockTracker.zza;
    }

    @KeepForSdk
    public void registerAcquireEvent(Context context0, Intent intent0, String s, String s1, String s2, int v, String s3) {
    }

    @KeepForSdk
    public void registerDeadlineEvent(Context context0, String s, String s1, String s2, int v, List list0, boolean z, long v1) {
    }

    @KeepForSdk
    public void registerEvent(Context context0, String s, int v, String s1, String s2, String s3, int v1, List list0) {
    }

    @KeepForSdk
    public void registerEvent(Context context0, String s, int v, String s1, String s2, String s3, int v1, List list0, long v2) {
    }

    @KeepForSdk
    public void registerReleaseEvent(Context context0, Intent intent0) {
    }
}

