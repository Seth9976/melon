package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.StatusCallback;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzal implements RemoteCall {
    private final ActivityTransitionRequest zza;
    private final PendingIntent zzb;

    public zzal(ActivityTransitionRequest activityTransitionRequest0, PendingIntent pendingIntent0) {
        this.zza = activityTransitionRequest0;
        this.zzb = pendingIntent0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzai zzai0 = new zzai(((TaskCompletionSource)object1));
        Preconditions.checkNotNull(this.zza, "activityTransitionRequest must be specified.");
        Preconditions.checkNotNull(this.zzb, "PendingIntent must be specified.");
        Preconditions.checkNotNull(zzai0, "ResultHolder not provided.");
        StatusCallback statusCallback0 = new StatusCallback(zzai0);
        ((zzv)((zzg)object0).getService()).zzj(this.zza, this.zzb, statusCallback0);
    }
}

