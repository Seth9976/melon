package com.google.android.gms.cast;

import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzdo implements MediaChannelResult {
    private final Status zza;
    private final JSONObject zzb;

    public zzdo(Status status0, JSONObject jSONObject0) {
        this.zza = status0;
        this.zzb = jSONObject0;
    }

    @Override  // com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult
    public final JSONObject getCustomData() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}

