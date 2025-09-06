package com.google.android.gms.cast.framework.media;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

final class zzu extends zzf {
    final NotificationActionsProvider zza;

    public zzu(NotificationActionsProvider notificationActionsProvider0, zzv zzv0) {
        this.zza = notificationActionsProvider0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.media.zzg
    public final IObjectWrapper zze() {
        return ObjectWrapper.wrap(this.zza);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzg
    public final List zzf() {
        return this.zza.getNotificationActions();
    }

    @Override  // com.google.android.gms.cast.framework.media.zzg
    public final int[] zzg() {
        return this.zza.getCompactViewActionIndices();
    }
}

