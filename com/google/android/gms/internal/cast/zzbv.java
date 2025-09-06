package com.google.android.gms.internal.cast;

import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzbv implements Runnable {
    public final TaskCompletionSource zza;

    public zzbv(TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
    }

    @Override
    public final void run() {
        zzbw.zzc(this.zza);
    }
}

