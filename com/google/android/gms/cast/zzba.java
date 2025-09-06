package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzy;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzba implements RemoteCall {
    public final zzbr zza;
    public final boolean zzb;

    public zzba(zzbr zzbr0, boolean z) {
        this.zza = zzbr0;
        this.zzb = z;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzbr.zzy(this.zza, this.zzb, ((zzy)object0), ((TaskCompletionSource)object1));
    }
}

