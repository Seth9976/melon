package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzat;
import org.json.JSONObject;

final class zzav extends zzbg {
    final JSONObject zza;
    final RemoteMediaClient zzb;

    public zzav(RemoteMediaClient remoteMediaClient0, JSONObject jSONObject0) {
        this.zza = jSONObject0;
        this.zzb = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zzb.zzd.zzr(zzat0, this.zza);
    }
}

