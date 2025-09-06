package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzdf extends zzdn {
    final long zza;
    final int zzb;
    final JSONObject zzc;
    final RemoteMediaPlayer zzd;

    public zzdf(RemoteMediaPlayer remoteMediaPlayer0, GoogleApiClient googleApiClient0, long v, int v1, JSONObject jSONObject0) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = jSONObject0;
        this.zzd = remoteMediaPlayer0;
        super(remoteMediaPlayer0, googleApiClient0);
    }

    @Override  // com.google.android.gms.cast.zzdn
    public final void zza(zzx zzx0) {
        zzat zzat0 = this.zzb();
        Builder mediaSeekOptions$Builder0 = new Builder();
        mediaSeekOptions$Builder0.setPosition(this.zza);
        mediaSeekOptions$Builder0.setResumeState(this.zzb);
        mediaSeekOptions$Builder0.setCustomData(this.zzc);
        MediaSeekOptions mediaSeekOptions0 = mediaSeekOptions$Builder0.build();
        this.zzd.zzb.zzC(zzat0, mediaSeekOptions0);
    }
}

