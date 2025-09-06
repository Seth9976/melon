package com.google.android.gms.internal.auth_blockstore;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzt implements RemoteCall {
    public final zzaa zza;

    public zzt(zzaa zzaa0) {
        this.zza = zzaa0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzx zzx0 = new zzx(this.zza, ((TaskCompletionSource)object1));
        ((zzg)((zzf)object0).getService()).zzc(zzx0);
    }
}

