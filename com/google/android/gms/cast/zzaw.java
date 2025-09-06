package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzy;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzaw implements RemoteCall {
    public final zzbr zza;
    public final String zzb;
    public final LaunchOptions zzc;

    public zzaw(zzbr zzbr0, String s, LaunchOptions launchOptions0) {
        this.zza = zzbr0;
        this.zzb = s;
        this.zzc = launchOptions0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzbr.zzv(this.zza, this.zzb, this.zzc, ((zzy)object0), ((TaskCompletionSource)object1));
    }
}

