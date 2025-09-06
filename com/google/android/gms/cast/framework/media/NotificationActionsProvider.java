package com.google.android.gms.cast.framework.media;

import android.content.Context;
import java.util.List;

public abstract class NotificationActionsProvider {
    private final Context zza;
    private final zzg zzb;

    public NotificationActionsProvider(Context context0) {
        this.zzb = new zzu(this, null);
        this.zza = context0.getApplicationContext();
    }

    public Context getApplicationContext() {
        return this.zza;
    }

    public abstract int[] getCompactViewActionIndices();

    public abstract List getNotificationActions();

    public final zzg zza() {
        return this.zzb;
    }
}

