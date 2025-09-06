package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbt implements RemoteCall {
    private final zzbh zza;
    private final LocationRequest zzb;

    public zzbt(zzbh zzbh0, LocationRequest locationRequest0) {
        this.zza = zzbh0;
        this.zzb = locationRequest0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzdz)object0).zzs(this.zza, this.zzb, ((TaskCompletionSource)object1));
    }
}

