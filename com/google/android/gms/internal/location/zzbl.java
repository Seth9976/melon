package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbl implements RemoteCall {
    private final Location zza;

    public zzbl(Location location0) {
        this.zza = location0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzdz)object0).zzA(this.zza, ((TaskCompletionSource)object1));
    }
}

