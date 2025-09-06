package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzat;
import org.json.JSONObject;

final class zzak extends zzbg {
    final int zza;
    final JSONObject zzb;
    final RemoteMediaClient zzc;

    public zzak(RemoteMediaClient remoteMediaClient0, int v, JSONObject jSONObject0) {
        this.zza = v;
        this.zzb = jSONObject0;
        this.zzc = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zzc.zzd.zzA(zzat0, 0, -1L, null, 0, null, this.zza, this.zzb);
    }
}

