package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.StatusCallback;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzam implements RemoteCall {
    private final PendingIntent zza;

    public zzam(PendingIntent pendingIntent0) {
        this.zza = pendingIntent0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzai zzai0 = new zzai(((TaskCompletionSource)object1));
        Preconditions.checkNotNull(zzai0, "ResultHolder not provided.");
        StatusCallback statusCallback0 = new StatusCallback(zzai0);
        ((zzv)((zzg)object0).getService()).zzk(this.zza, statusCallback0);
    }
}

