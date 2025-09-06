package com.google.android.gms.internal.auth_blockstore;

import com.google.android.gms.auth.blockstore.StoreBytesData;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzq implements RemoteCall {
    public final zzaa zza;
    public final StoreBytesData zzb;

    public zzq(zzaa zzaa0, StoreBytesData storeBytesData0) {
        this.zza = zzaa0;
        this.zzb = storeBytesData0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzv zzv0 = new zzv(this.zza, ((TaskCompletionSource)object1));
        ((zzg)((zzf)object0).getService()).zze(zzv0, this.zzb);
    }
}

