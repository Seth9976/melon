package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzbj implements RemoteCall {
    private final LastLocationRequest zza;

    public zzbj(LastLocationRequest lastLocationRequest0) {
        this.zza = lastLocationRequest0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        ((zzdz)object0).zzq(this.zza, ((TaskCompletionSource)object1));
    }
}

