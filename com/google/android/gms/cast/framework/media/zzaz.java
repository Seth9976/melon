package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzat;
import org.json.JSONObject;

final class zzaz extends zzbg {
    final double zza;
    final JSONObject zzb;
    final RemoteMediaClient zzc;

    public zzaz(RemoteMediaClient remoteMediaClient0, double f, JSONObject jSONObject0) {
        this.zza = f;
        this.zzb = jSONObject0;
        this.zzc = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zzc.zzd.zzE(zzat0, this.zza, this.zzb);
    }
}

