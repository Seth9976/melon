package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdc implements RemoteCall {
    static final zzdc zza;

    static {
        zzdc.zza = new zzdc();
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzv)((zzdz)object0).getService()).zzE(new zzdm(((TaskCompletionSource)object1)));
    }
}

