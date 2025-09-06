package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzy;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbh implements RemoteCall {
    public final zzbr zza;
    public final String zzb;

    public zzbh(zzbr zzbr0, String s) {
        this.zza = zzbr0;
        this.zzb = s;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzbr.zzx(this.zza, this.zzb, ((zzy)object0), ((TaskCompletionSource)object1));
    }
}

