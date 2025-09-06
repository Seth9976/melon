package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

final class zzcv implements RemoteCall {
    private final List zza;

    public zzcv(List list0) {
        this.zza = list0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzdz)object0).zzF(zzem.zza(this.zza), ((TaskCompletionSource)object1));
    }
}

