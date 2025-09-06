package com.google.android.gms.internal.cast;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R.string;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;

public final class zzcq extends UIController {
    private final ImageView zza;
    private final View zzb;
    private final boolean zzc;
    private final Drawable zzd;
    private final String zze;
    private final Drawable zzf;
    private final String zzg;
    private final Drawable zzh;
    private final String zzi;
    private boolean zzj;

    public zzcq(ImageView imageView0, Context context0, Drawable drawable0, Drawable drawable1, Drawable drawable2, View view0, boolean z) {
        this.zzj = false;
        this.zza = imageView0;
        this.zzd = drawable0;
        this.zzf = drawable1;
        if(drawable2 != null) {
            drawable1 = drawable2;
        }
        this.zzh = drawable1;
        this.zze = context0.getString(string.cast_play);
        this.zzg = context0.getString(string.cast_pause);
        this.zzi = context0.getString(string.cast_stop);
        this.zzb = view0;
        this.zzc = z;
        imageView0.setEnabled(false);
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        this.zzc();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSendingRemoteMediaRequest() {
        this.zzb(true);
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession0) {
        super.onSessionConnected(castSession0);
        this.zzc();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        this.zza.setEnabled(false);
        super.onSessionEnded();
    }

    private final void zza(Drawable drawable0, String s) {
        ImageView imageView0 = this.zza;
        boolean z = drawable0.equals(imageView0.getDrawable());
        imageView0.setImageDrawable(drawable0);
        imageView0.setContentDescription(s);
        imageView0.setVisibility(0);
        imageView0.setEnabled(true);
        View view0 = this.zzb;
        if(view0 != null) {
            view0.setVisibility(8);
        }
        if(!z && this.zzj) {
            imageView0.sendAccessibilityEvent(8);
        }
    }

    @TargetApi(21)
    private final void zzb(boolean z) {
        this.zzj = this.zza.isAccessibilityFocused();
        View view0 = this.zzb;
        int v = 0;
        if(view0 != null) {
            view0.setVisibility(0);
            if(this.zzj) {
                view0.sendAccessibilityEvent(8);
            }
        }
        ImageView imageView0 = this.zza;
        if(this.zzc) {
            v = 4;
        }
        imageView0.setVisibility(v);
        imageView0.setEnabled(!z);
    }

    private final void zzc() {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession()) {
            if(remoteMediaClient0.isPlaying()) {
                if(remoteMediaClient0.isLiveStream()) {
                    this.zza(this.zzh, this.zzi);
                    return;
                }
                this.zza(this.zzf, this.zzg);
                return;
            }
            if(remoteMediaClient0.isBuffering()) {
                this.zzb(false);
                return;
            }
            if(remoteMediaClient0.isPaused()) {
                this.zza(this.zzd, this.zze);
                return;
            }
            if(remoteMediaClient0.isLoadingNextItem()) {
                this.zzb(true);
            }
            return;
        }
        this.zza.setEnabled(false);
    }
}

