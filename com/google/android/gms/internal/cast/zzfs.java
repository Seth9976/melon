package com.google.android.gms.internal.cast;

import android.util.Log;
import com.google.android.gms.common.api.Status;

final class zzfs extends zzfr {
    private zzfs() {
        throw null;
    }

    public zzfs(zzfu zzfu0) {
    }

    @Override  // com.google.android.gms.internal.cast.zzfr
    public final void zzo(Status status0) {
        if(!status0.isSuccess()) {
            Log.e("UsageReportingClientImp", "disconnect(): Could not unregister listener: status=" + status0);
        }
    }
}

