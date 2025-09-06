package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcw implements RemoteCall {
    private final GeofencingRequest zza;
    private final PendingIntent zzb;

    public zzcw(GeofencingRequest geofencingRequest0, PendingIntent pendingIntent0) {
        this.zza = geofencingRequest0;
        this.zzb = pendingIntent0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzdz)object0).zzE(this.zza, this.zzb, ((TaskCompletionSource)object1));
    }
}

