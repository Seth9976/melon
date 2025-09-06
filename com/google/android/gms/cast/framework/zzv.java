package com.google.android.gms.cast.framework;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final class zzv implements OnCompleteListener {
    public final zzx zza;

    public zzv(zzx zzx0) {
        this.zza = zzx0;
    }

    @Override  // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task0) {
        CastSession.zzi(this.zza.zza, "launchApplication", task0);
    }
}

