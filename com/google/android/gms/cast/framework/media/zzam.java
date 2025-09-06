package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzat;
import org.json.JSONObject;

final class zzam extends zzbg {
    final int zza;
    final long zzb;
    final JSONObject zzc;
    final RemoteMediaClient zzd;

    public zzam(RemoteMediaClient remoteMediaClient0, int v, long v1, JSONObject jSONObject0) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = jSONObject0;
        this.zzd = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zzd.zzd.zzA(zzat0, this.zza, this.zzb, null, 0, null, null, this.zzc);
    }
}

