package com.google.android.gms.internal.auth_blockstore;

import com.google.android.gms.auth.blockstore.RetrieveBytesRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzs implements RemoteCall {
    public final zzaa zza;
    public final RetrieveBytesRequest zzb;

    public zzs(zzaa zzaa0, RetrieveBytesRequest retrieveBytesRequest0) {
        this.zza = zzaa0;
        this.zzb = retrieveBytesRequest0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzw zzw0 = new zzw(this.zza, ((TaskCompletionSource)object1));
        ((zzg)((zzf)object0).getService()).zzd(zzw0, this.zzb);
    }
}

