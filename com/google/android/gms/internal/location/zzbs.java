package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbs implements RemoteCall {
    private final PendingIntent zza;
    private final LocationRequest zzb;

    public zzbs(PendingIntent pendingIntent0, LocationRequest locationRequest0) {
        this.zza = pendingIntent0;
        this.zzb = locationRequest0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzdz)object0).zzu(this.zza, this.zzb, ((TaskCompletionSource)object1));
    }
}

