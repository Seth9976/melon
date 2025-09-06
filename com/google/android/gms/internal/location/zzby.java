package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.location.LastLocationRequest.Builder;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzby implements RemoteCall {
    static final zzby zza;

    static {
        zzby.zza = new zzby();
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzdz)object0).zzq(new Builder().build(), ((TaskCompletionSource)object1));
    }
}

