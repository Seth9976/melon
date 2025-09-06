package com.google.android.gms.internal.cast;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.ImagePicker;
import com.google.android.gms.cast.framework.media.MediaUtils;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.internal.zzb;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.common.images.WebImage;

public final class zzcj extends UIController {
    private final ImageView zza;
    private final ImageHints zzb;
    private final Bitmap zzc;
    private final View zzd;
    private final ImagePicker zze;
    private final zzci zzf;
    private final zzb zzg;

    public zzcj(ImageView imageView0, Context context0, ImageHints imageHints0, int v, View view0, zzci zzci0) {
        this.zza = imageView0;
        this.zzb = imageHints0;
        this.zzf = zzci0;
        ImagePicker imagePicker0 = null;
        this.zzc = v == 0 ? null : BitmapFactory.decodeResource(context0.getResources(), v);
        this.zzd = view0;
        CastContext castContext0 = CastContext.zzb(context0);
        if(castContext0 != null) {
            CastMediaOptions castMediaOptions0 = castContext0.getCastOptions().getCastMediaOptions();
            if(castMediaOptions0 != null) {
                imagePicker0 = castMediaOptions0.getImagePicker();
            }
        }
        this.zze = imagePicker0;
        this.zzg = new zzb(context0.getApplicationContext());
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        this.zze();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession0) {
        super.onSessionConnected(castSession0);
        zzch zzch0 = new zzch(this);
        this.zzg.zzc(zzch0);
        this.zzd();
        this.zze();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        this.zzg.zza();
        this.zzd();
        super.onSessionEnded();
    }

    public static ImageView zzb(zzcj zzcj0) {
        return zzcj0.zza;
    }

    public static zzci zzc(zzcj zzcj0) {
        return zzcj0.zzf;
    }

    private final void zzd() {
        View view0 = this.zzd;
        if(view0 != null) {
            view0.setVisibility(0);
            this.zza.setVisibility(4);
        }
        Bitmap bitmap0 = this.zzc;
        if(bitmap0 != null) {
            this.zza.setImageBitmap(bitmap0);
        }
    }

    private final void zze() {
        Uri uri0;
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession()) {
            MediaInfo mediaInfo0 = remoteMediaClient0.getMediaInfo();
            if(mediaInfo0 == null) {
                uri0 = null;
            }
            else {
                ImagePicker imagePicker0 = this.zze;
                MediaMetadata mediaMetadata0 = mediaInfo0.getMetadata();
                if(imagePicker0 == null || mediaMetadata0 == null) {
                    uri0 = MediaUtils.getImageUri(mediaInfo0, 0);
                }
                else {
                    WebImage webImage0 = imagePicker0.onPickImage(mediaMetadata0, this.zzb);
                    uri0 = webImage0 == null || webImage0.getUrl() == null ? MediaUtils.getImageUri(mediaInfo0, 0) : webImage0.getUrl();
                }
            }
            if(uri0 == null) {
                this.zzd();
                return;
            }
            this.zzg.zzd(uri0);
            return;
        }
        this.zzd();
    }
}

