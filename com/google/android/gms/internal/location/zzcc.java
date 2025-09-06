package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcc implements RemoteCall {
    static final zzcc zza;

    static {
        zzcc.zza = new zzcc();
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzdz)object0).zzz(((TaskCompletionSource)object1));
    }
}

