package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdb implements RemoteCall {
    private final LocationSettingsRequest zza;

    public zzdb(LocationSettingsRequest locationSettingsRequest0) {
        this.zza = locationSettingsRequest0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        Preconditions.checkArgument(this.zza != null, "locationSettingsRequest can\'t be null");
        ((zzv)((zzdz)object0).getService()).zzD(this.zza, new zzde(((TaskCompletionSource)object1)), null);
    }
}

