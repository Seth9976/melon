package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzy;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbe implements RemoteCall {
    public final zzbr zza;
    public final String zzb;
    public final String zzc;

    public zzbe(zzbr zzbr0, String s, String s1, String s2) {
        this.zza = zzbr0;
        this.zzb = s1;
        this.zzc = s2;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzbr.zzA(this.zza, null, this.zzb, this.zzc, ((zzy)object0), ((TaskCompletionSource)object1));
    }
}

