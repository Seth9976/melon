package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzfb implements RemoteCall {
    public final zzfd zza;

    public zzfb(zzfd zzfd0) {
        this.zza = zzfd0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzfc zzfc0 = new zzfc(this.zza, ((TaskCompletionSource)object1));
        ((zzfp)((zzfv)object0).getService()).zze(zzfc0);
    }
}

