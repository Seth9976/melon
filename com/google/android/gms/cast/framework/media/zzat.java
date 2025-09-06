package com.google.android.gms.cast.framework.media;

import org.json.JSONObject;

final class zzat extends zzbg {
    final JSONObject zza;
    final RemoteMediaClient zzb;

    public zzat(RemoteMediaClient remoteMediaClient0, JSONObject jSONObject0) {
        this.zza = jSONObject0;
        this.zzb = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        com.google.android.gms.cast.internal.zzat zzat0 = this.zzb();
        this.zzb.zzd.zzq(zzat0, this.zza);
    }
}

