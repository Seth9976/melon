package com.google.android.gms.internal.auth-api-phone;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzag implements RemoteCall {
    public final zzak zza;

    public zzag(zzak zzak0) {
        this.zza = zzak0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzk)((zzaf)object0).getService()).zzg(new zzai(this.zza, ((TaskCompletionSource)object1)));
    }
}

