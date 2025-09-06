package com.google.android.gms.cast.framework;

import android.os.Bundle;
import com.google.android.gms.tasks.OnSuccessListener;

public final class zzh implements OnSuccessListener {
    public final CastContext zza;

    public zzh(CastContext castContext0) {
        this.zza = castContext0;
    }

    @Override  // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object object0) {
        CastContext.zze(this.zza, ((Bundle)object0));
    }
}

