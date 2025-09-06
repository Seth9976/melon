package com.google.android.gms.internal.auth-api-phone;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzaa implements RemoteCall {
    public final zzad zza;

    public zzaa(zzad zzad0) {
        this.zza = zzad0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzac zzac0 = new zzac(this.zza, ((TaskCompletionSource)object1));
        ((zzk)((zzaf)object0).getService()).zzf(zzac0);
    }
}

