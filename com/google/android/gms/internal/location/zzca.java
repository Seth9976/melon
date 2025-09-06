package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzca implements RemoteCall {
    static final zzca zza;

    static {
        zzca.zza = new zzca();
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzdz)object0).zzB(((TaskCompletionSource)object1));
    }
}

