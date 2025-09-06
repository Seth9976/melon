package com.google.android.gms.internal.auth-api-phone;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzs implements RemoteCall {
    public final zzz zza;

    public zzs(zzz zzz0) {
        this.zza = zzz0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzx zzx0 = new zzx(this.zza, ((TaskCompletionSource)object1));
        ((zzk)((zzaf)object0).getService()).zzc(zzx0);
    }
}

