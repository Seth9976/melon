package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdi implements zzdr {
    final ListenerHolder zza;
    final TaskCompletionSource zzb;

    public zzdi(zzdz zzdz0, ListenerHolder listenerHolder0, TaskCompletionSource taskCompletionSource0) {
        this.zza = listenerHolder0;
        this.zzb = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.location.zzdr
    public final ListenerHolder zza() {
        return this.zza;
    }

    @Override  // com.google.android.gms.internal.location.zzdr
    public final void zzb(ListenerHolder listenerHolder0) {
        throw new IllegalStateException();
    }

    @Override  // com.google.android.gms.internal.location.zzdr
    public final void zzc() {
        this.zzb.trySetResult(null);
    }
}

