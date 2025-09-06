package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzdg extends zzs {
    final TaskCompletionSource zza;

    public zzdg(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.location.zzt
    public final void zzb(int v, String[] arr_s) {
        TaskUtil.setResultOrApiException(new Status(GeofenceStatusCodes.zza(v)), this.zza);
    }

    @Override  // com.google.android.gms.internal.location.zzt
    public final void zzc(int v, String[] arr_s) {
        TaskUtil.setResultOrApiException(new Status(GeofenceStatusCodes.zza(v)), this.zza);
    }

    @Override  // com.google.android.gms.internal.location.zzt
    public final void zzd(int v, PendingIntent pendingIntent0) {
        TaskUtil.setResultOrApiException(new Status(GeofenceStatusCodes.zza(v)), this.zza);
    }
}

