package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzdb extends zzdn {
    final MediaInfo zza;
    final boolean zzb;
    final long zzc;
    final long[] zzd;
    final JSONObject zze;
    final RemoteMediaPlayer zzf;

    public zzdb(RemoteMediaPlayer remoteMediaPlayer0, GoogleApiClient googleApiClient0, MediaInfo mediaInfo0, boolean z, long v, long[] arr_v, JSONObject jSONObject0) {
        this.zza = mediaInfo0;
        this.zzb = z;
        this.zzc = v;
        this.zzd = arr_v;
        this.zze = jSONObject0;
        this.zzf = remoteMediaPlayer0;
        super(remoteMediaPlayer0, googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.zzdn
    public final void zza(zzx zzx0) {
        synchronized(this.zzf.zza) {
            zzat zzat0 = this.zzb();
            Builder mediaLoadRequestData$Builder0 = new Builder();
            mediaLoadRequestData$Builder0.setMediaInfo(this.zza);
            mediaLoadRequestData$Builder0.setAutoplay(Boolean.valueOf(this.zzb));
            mediaLoadRequestData$Builder0.setCurrentTime(this.zzc);
            mediaLoadRequestData$Builder0.setActiveTrackIds(this.zzd);
            mediaLoadRequestData$Builder0.setCustomData(this.zze);
            MediaLoadRequestData mediaLoadRequestData0 = mediaLoadRequestData$Builder0.build();
            this.zzf.zzb.zzp(zzat0, mediaLoadRequestData0);
        }
    }
}

