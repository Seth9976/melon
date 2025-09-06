package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzy;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzaz implements RemoteCall {
    public final zzbr zza;
    public final MessageReceivedCallback zzb;
    public final String zzc;

    public zzaz(zzbr zzbr0, MessageReceivedCallback cast$MessageReceivedCallback0, String s) {
        this.zza = zzbr0;
        this.zzb = cast$MessageReceivedCallback0;
        this.zzc = s;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzbr.zzw(this.zza, this.zzb, this.zzc, ((zzy)object0), ((TaskCompletionSource)object1));
    }
}

