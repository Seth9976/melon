package com.google.android.gms.internal.cast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnFailureListener;

public final class zzbp implements OnFailureListener {
    public final zzbq zza;

    public zzbp(zzbq zzbq0, zzbr zzbr0) {
        this.zza = zzbq0;
    }

    @Override  // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exception0) {
        Status status0 = new Status(8, "unknown error");
        if(exception0 instanceof ApiException) {
            status0 = new Status(((ApiException)exception0).getStatusCode(), ((ApiException)exception0).getMessage());
        }
        this.zza.setResult(status0);
    }
}

