package com.google.android.gms.cast;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

final class zzdj implements ResultCallback {
    final zzdk zza;
    private final long zzb;

    public zzdj(zzdk zzdk0, long v) {
        this.zza = zzdk0;
        super();
        this.zzb = v;
    }

    @Override  // com.google.android.gms.common.api.ResultCallback
    public final void onResult(Result result0) {
        if(!((Status)result0).isSuccess()) {
            this.zza.zza.zzb.zzP(this.zzb, ((Status)result0).getStatusCode());
        }
    }
}

