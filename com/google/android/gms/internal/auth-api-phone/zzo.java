package com.google.android.gms.internal.auth-api-phone;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzo extends zzf {
    final TaskCompletionSource zza;

    public zzo(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.internal.auth-api-phone.zzg
    public final void zzb(PendingIntent pendingIntent0, Status status0) {
        zzp.zzb.i("InternalMissedCallRetrieverClient#onMissedCallRetrieverResult invoked with status: %s", new Object[]{(status0 == null ? null : status0.getStatusCode())});
        TaskUtil.setResultOrApiException(status0, pendingIntent0, this.zza);
    }
}

