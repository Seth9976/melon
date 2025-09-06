package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzy;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzax implements RemoteCall {
    public final zzbr zza;
    public final double zzb;

    public zzax(zzbr zzbr0, double f) {
        this.zza = zzbr0;
        this.zzb = f;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzbr.zzz(this.zza, this.zzb, ((zzy)object0), ((TaskCompletionSource)object1));
    }
}

