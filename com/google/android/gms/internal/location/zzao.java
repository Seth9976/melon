package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.location.SleepSegmentRequest;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzao implements RemoteCall {
    private final zzaj zza;
    private final PendingIntent zzb;
    private final SleepSegmentRequest zzc;

    public zzao(zzaj zzaj0, PendingIntent pendingIntent0, SleepSegmentRequest sleepSegmentRequest0) {
        this.zza = zzaj0;
        this.zzb = pendingIntent0;
        this.zzc = sleepSegmentRequest0;
    }

    @Override  // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object object0, Object object1) {
        zzah zzah0 = new zzah(this.zza, ((TaskCompletionSource)object1));
        ((zzv)((zzg)object0).getService()).zzm(this.zzb, this.zzc, zzah0);
    }
}

