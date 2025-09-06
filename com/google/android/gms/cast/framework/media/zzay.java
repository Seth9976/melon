package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzat;
import org.json.JSONObject;

final class zzay extends zzbg {
    final boolean zza;
    final JSONObject zzb;
    final RemoteMediaClient zzc;

    public zzay(RemoteMediaClient remoteMediaClient0, boolean z, JSONObject jSONObject0) {
        this.zza = z;
        this.zzb = jSONObject0;
        this.zzc = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zzc.zzd.zzF(zzat0, this.zza, this.zzb);
    }
}

