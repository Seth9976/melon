package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaError;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzbh implements MediaChannelResult {
    private final Status zza;
    private final JSONObject zzb;
    private final MediaError zzc;

    public zzbh(Status status0, JSONObject jSONObject0, MediaError mediaError0) {
        this.zza = status0;
        this.zzb = jSONObject0;
        this.zzc = mediaError0;
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$MediaChannelResult
    public final JSONObject getCustomData() {
        return this.zzb;
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$MediaChannelResult
    public final MediaError getMediaError() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}

