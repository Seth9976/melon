package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzat;
import org.json.JSONObject;

final class zzag extends zzbg {
    final int[] zza;
    final int zzb;
    final JSONObject zzc;
    final RemoteMediaClient zzd;

    public zzag(RemoteMediaClient remoteMediaClient0, int[] arr_v, int v, JSONObject jSONObject0) {
        this.zza = arr_v;
        this.zzb = v;
        this.zzc = jSONObject0;
        this.zzd = remoteMediaClient0;
        super(remoteMediaClient0, false);
    }

    @Override  // com.google.android.gms.cast.framework.media.zzbg
    public final void zza() {
        zzat zzat0 = this.zzb();
        this.zzd.zzd.zzz(zzat0, this.zza, this.zzb, this.zzc);
    }
}

