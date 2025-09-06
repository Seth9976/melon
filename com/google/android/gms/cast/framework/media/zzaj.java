package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzat;
import org.json.JSONObject;

final class zzaj extends zzbg {
    final JSONObject zza;
    final RemoteMediaClient zzb;

    public zzaj(RemoteMediaClient remoteMediaClient0, JSONObject jSONObject0) {
        this.zza = jSONObject0;
        this.zzb = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zzb.zzd.zzA(zzat0, 0, -1L, null, 1, null, null, this.zza);
    }
}

