package com.google.android.gms.stats;

import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;

@KeepForSdk
@ShowFirstParty
public abstract class GCoreWakefulBroadcastReceiver extends WakefulBroadcastReceiver {
    @KeepForSdk
    public static boolean completeWakefulIntent(Context context0, Intent intent0) {
        return intent0 == null ? false : WakefulBroadcastReceiver.completeWakefulIntent(intent0);
    }
}

