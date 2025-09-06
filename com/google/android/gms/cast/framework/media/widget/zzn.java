package com.google.android.gms.cast.framework.media.widget;

import com.google.android.gms.cast.framework.R.string;
import com.google.android.gms.cast.framework.media.RemoteMediaClient.Listener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;

final class zzn implements Listener {
    final ExpandedControllerActivity zza;

    public zzn(ExpandedControllerActivity expandedControllerActivity0, zzp zzp0) {
        this.zza = expandedControllerActivity0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Listener
    public final void onAdBreakStatusUpdated() {
        this.zza.zzp();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Listener
    public final void onMetadataUpdated() {
        this.zza.zzo();
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Listener
    public final void onPreloadStatusUpdated() {
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Listener
    public final void onQueueStatusUpdated() {
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Listener
    public final void onSendingRemoteMediaRequest() {
        String s = this.zza.getResources().getString(string.cast_expanded_controller_loading);
        this.zza.zzw.setText(s);
    }

    @Override  // com.google.android.gms.cast.framework.media.RemoteMediaClient$Listener
    public final void onStatusUpdated() {
        ExpandedControllerActivity expandedControllerActivity0 = this.zza;
        RemoteMediaClient remoteMediaClient0 = expandedControllerActivity0.zzj();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession()) {
            expandedControllerActivity0.zzd = false;
            expandedControllerActivity0.zzn();
            expandedControllerActivity0.zzp();
            return;
        }
        if(!expandedControllerActivity0.zzd) {
            expandedControllerActivity0.finish();
        }
    }
}

