package com.google.android.gms.internal.auth_blockstore;

import com.google.android.gms.auth.blockstore.DeleteBytesRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzp implements RemoteCall {
    public final zzaa zza;
    public final DeleteBytesRequest zzb;

    public zzp(zzaa zzaa0, DeleteBytesRequest deleteBytesRequest0) {
        this.zza = zzaa0;
        this.zzb = deleteBytesRequest0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzy zzy0 = new zzy(this.zza, ((TaskCompletionSource)object1));
        ((zzg)((zzf)object0).getService()).zza(zzy0, this.zzb);
    }
}

