package com.google.android.gms.internal.auth-api-phone;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzu implements RemoteCall {
    public final zzz zza;

    public zzu(zzz zzz0) {
        this.zza = zzz0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzw zzw0 = new zzw(this.zza, ((TaskCompletionSource)object1));
        ((zzk)((zzaf)object0).getService()).zze(zzw0);
    }
}

