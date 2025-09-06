package com.google.android.gms.internal.cast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final class zzbc implements OnCompleteListener {
    public final zzbf zza;

    public zzbc(zzbf zzbf0) {
        this.zza = zzbf0;
    }

    @Override  // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task0) {
        zzbf.zzp(this.zza, task0);
    }
}

