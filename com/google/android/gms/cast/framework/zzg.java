package com.google.android.gms.cast.framework;

import android.os.Bundle;
import com.google.android.gms.tasks.OnSuccessListener;

public final class zzg implements OnSuccessListener {
    public final CastContext zza;

    public zzg(CastContext castContext0) {
        this.zza = castContext0;
    }

    @Override  // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object object0) {
        CastContext.zzf(this.zza, ((Bundle)object0));
    }
}

