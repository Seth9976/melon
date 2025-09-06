package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbp implements RemoteCall {
    private final CurrentLocationRequest zza;
    private final CancellationToken zzb;

    public zzbp(CurrentLocationRequest currentLocationRequest0, CancellationToken cancellationToken0) {
        this.zza = currentLocationRequest0;
        this.zzb = cancellationToken0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzdz)object0).zzr(this.zza, this.zzb, ((TaskCompletionSource)object1));
    }
}

