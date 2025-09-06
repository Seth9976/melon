package com.google.android.gms.cast.framework.media.internal;

import com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback;

final class zzs extends Callback {
    final zzu zza;

    public zzs(zzu zzu0, zzt zzt0) {
        this.zza = zzu0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void onAdBreakStatusUpdated() {
        this.zza.zzl(false);
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void onMetadataUpdated() {
        this.zza.zzl(false);
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void onPreloadStatusUpdated() {
        this.zza.zzl(false);
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void onQueueStatusUpdated() {
        this.zza.zzl(false);
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Callback
    public final void onStatusUpdated() {
        this.zza.zzl(false);
    }
}

