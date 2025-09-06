package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzy;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbb implements RemoteCall {
    public final zzbr zza;
    public final String zzb;
    public final String zzc;

    public zzbb(zzbr zzbr0, String s, String s1, zzbs zzbs0) {
        this.zza = zzbr0;
        this.zzb = s;
        this.zzc = s1;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzbr.zzB(this.zza, this.zzb, this.zzc, null, ((zzy)object0), ((TaskCompletionSource)object1));
    }
}

