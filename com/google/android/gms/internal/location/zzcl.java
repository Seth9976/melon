package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcl implements RemoteCall {
    private final ListenerHolder zza;
    private final DeviceOrientationRequest zzb;

    public zzcl(ListenerHolder listenerHolder0, DeviceOrientationRequest deviceOrientationRequest0) {
        this.zza = listenerHolder0;
        this.zzb = deviceOrientationRequest0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzdz)object0).zzC(this.zza, this.zzb, ((TaskCompletionSource)object1));
    }
}

