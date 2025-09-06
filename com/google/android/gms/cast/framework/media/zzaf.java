package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzat;
import org.json.JSONObject;

final class zzaf extends zzbg {
    final int[] zza;
    final JSONObject zzb;
    final RemoteMediaClient zzc;

    public zzaf(RemoteMediaClient remoteMediaClient0, int[] arr_v, JSONObject jSONObject0) {
        this.zza = arr_v;
        this.zzb = jSONObject0;
        this.zzc = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zzc.zzd.zzy(zzat0, this.zza, this.zzb);
    }
}

