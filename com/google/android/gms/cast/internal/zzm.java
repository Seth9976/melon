package com.google.android.gms.cast.internal;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzm extends zzaf {
    final TaskCompletionSource zza;

    public zzm(zzn zzn0, TaskCompletionSource taskCompletionSource0) {
        this.zza = taskCompletionSource0;
        super();
    }

    @Override  // com.google.android.gms.cast.internal.zzag
    public final void zzb(Bundle bundle0) {
        this.zza.setResult(bundle0);
    }
}

