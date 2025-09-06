package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaError;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzbf implements MediaChannelResult {
    final Status zza;

    public zzbf(zzbg zzbg0, Status status0) {
        this.zza = status0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$MediaChannelResult
    public final JSONObject getCustomData() {
        return null;
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$MediaChannelResult
    public final MediaError getMediaError() {
        return null;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }
}

