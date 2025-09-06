package com.google.android.gms.internal.cast;

import android.content.Context;
import android.widget.ImageView;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R.string;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;

public final class zzcp extends UIController {
    private final ImageView zza;
    private final String zzb;
    private final String zzc;
    private final Context zzd;
    private Listener zze;

    public zzcp(ImageView imageView0, Context context0) {
        this.zza = imageView0;
        Context context1 = context0.getApplicationContext();
        this.zzd = context1;
        this.zzb = context1.getString(string.cast_mute);
        this.zzc = context1.getString(string.cast_unmute);
        imageView0.setEnabled(false);
        this.zze = null;
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        this.zza();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSendingRemoteMediaRequest() {
        this.zza.setEnabled(false);
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession0) {
        if(this.zze == null) {
            this.zze = new zzco(this);
        }
        castSession0.addCastListener(this.zze);
        super.onSessionConnected(castSession0);
        this.zza();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        this.zza.setEnabled(false);
        CastSession castSession0 = CastContext.getSharedInstance(this.zzd).getSessionManager().getCurrentCastSession();
        if(castSession0 != null) {
            Listener cast$Listener0 = this.zze;
            if(cast$Listener0 != null) {
                castSession0.removeCastListener(cast$Listener0);
            }
        }
        super.onSessionEnded();
    }

    public final void zza() {
        CastSession castSession0 = CastContext.getSharedInstance(this.zzd).getSessionManager().getCurrentCastSession();
        if(castSession0 != null && castSession0.isConnected()) {
            RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
            if(remoteMediaClient0 == null || !remoteMediaClient0.hasMediaSession()) {
                this.zza.setEnabled(false);
            }
            else {
                this.zza.setEnabled(true);
            }
            boolean z = castSession0.isMute();
            this.zza.setSelected(z);
            this.zza.setContentDescription((z ? this.zzc : this.zzb));
            return;
        }
        this.zza.setEnabled(false);
    }
}

