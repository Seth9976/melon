package com.google.android.gms.cast;

import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzdm implements MediaChannelResult {
    final Status zza;

    public zzdm(zzdn zzdn0, Status status0) {
        this.zza = status0;
        super();
    }

    @Override  // com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult
    public final JSONObject getCustomData() {
        return null;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}

