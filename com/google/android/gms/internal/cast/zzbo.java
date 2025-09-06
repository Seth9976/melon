package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnSuccessListener;

public final class zzbo implements OnSuccessListener {
    public final zzbq zza;

    public zzbo(zzbq zzbq0, zzbr zzbr0) {
        this.zza = zzbq0;
    }

    @Override  // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object object0) {
        Void void0 = (Void)object0;
        Status status0 = new Status(0);
        this.zza.setResult(status0);
    }
}

