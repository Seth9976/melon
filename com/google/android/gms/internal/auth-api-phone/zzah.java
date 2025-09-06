package com.google.android.gms.internal.auth-api-phone;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzah implements RemoteCall {
    public final zzak zza;
    public final String zzb;

    public zzah(zzak zzak0, String s) {
        this.zza = zzak0;
        this.zzb = s;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzk zzk0 = (zzk)((zzaf)object0).getService();
        zzaj zzaj0 = new zzaj(this.zza, ((TaskCompletionSource)object1));
        zzk0.zzh(this.zzb, zzaj0);
    }
}

