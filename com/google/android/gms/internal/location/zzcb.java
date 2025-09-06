package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcb implements RemoteCall {
    static final zzcb zza;

    static {
        zzcb.zza = new zzcb();
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzdz)object0).zzy(((TaskCompletionSource)object1));
    }
}

