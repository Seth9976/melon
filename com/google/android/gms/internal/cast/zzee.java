package com.google.android.gms.internal.cast;

import android.view.Display;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult;
import com.google.android.gms.common.api.Status;

final class zzee implements CastRemoteDisplaySessionResult {
    private final Status zza;
    private final Display zzb;

    public zzee(Display display0) {
        this.zza = Status.RESULT_SUCCESS;
        this.zzb = display0;
    }

    public zzee(Status status0) {
        this.zza = status0;
        this.zzb = null;
    }

    @Override  // com.google.android.gms.cast.CastRemoteDisplay$CastRemoteDisplaySessionResult
    public final Display getPresentationDisplay() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}

