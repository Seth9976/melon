package com.google.android.gms.internal.auth-api-phone;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzt implements RemoteCall {
    public final zzz zza;
    public final String zzb;

    public zzt(zzz zzz0, String s) {
        this.zza = zzz0;
        this.zzb = s;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzy zzy0 = new zzy(this.zza, ((TaskCompletionSource)object1));
        ((zzk)((zzaf)object0).getService()).zzd(this.zzb, zzy0);
    }
}

