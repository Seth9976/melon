package com.google.android.gms.internal.cast;

import com.google.android.gms.tasks.OnFailureListener;

public final class zzbi implements OnFailureListener {
    public final zzbn zza;

    public zzbi(zzbn zzbn0) {
        this.zza = zzbn0;
    }

    @Override  // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exception0) {
        zzbn.zzd(this.zza, exception0);
    }
}

