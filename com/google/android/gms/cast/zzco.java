package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzco extends zzdn {
    final MediaQueueItem[] zza;
    final int zzb;
    final int zzc;
    final long zzd;
    final JSONObject zze;
    final RemoteMediaPlayer zzf;

    public zzco(RemoteMediaPlayer remoteMediaPlayer0, GoogleApiClient googleApiClient0, MediaQueueItem[] arr_mediaQueueItem, int v, int v1, long v2, JSONObject jSONObject0) {
        this.zza = arr_mediaQueueItem;
        this.zzb = v;
        this.zzc = v1;
        this.zzd = v2;
        this.zze = jSONObject0;
        this.zzf = remoteMediaPlayer0;
        super(remoteMediaPlayer0, googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.zzdn
    public final void zza(zzx zzx0) {
        zzat zzat0 = this.zzb();
        this.zzf.zzb.zzx(zzat0, this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }
}

