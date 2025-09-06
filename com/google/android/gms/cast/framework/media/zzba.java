package com.google.android.gms.cast.framework.media;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;

public final class zzba implements OnFailureListener {
    public final zzbb zza;
    public final long zzb;

    public zzba(zzbb zzbb0, long v) {
        this.zza = zzbb0;
        this.zzb = v;
    }

    @Override  // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exception0) {
        int v = exception0 instanceof ApiException ? ((ApiException)exception0).getStatusCode() : 13;
        this.zza.zza.zzd.zzP(this.zzb, v);
    }
}

