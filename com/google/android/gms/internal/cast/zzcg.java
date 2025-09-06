package com.google.android.gms.internal.cast;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueItem;
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

public final class zzcg extends UIController {
    private final ImageView zza;
    private final ImageHints zzb;
    private final Bitmap zzc;
    private final ImagePicker zzd;
    private final zzb zze;

    public zzcg(ImageView imageView0, Context context0, ImageHints imageHints0, int v) {
        zzb zzb0 = new zzb(context0.getApplicationContext());
        super();
        this.zza = imageView0;
        this.zzb = imageHints0;
        this.zzc = BitmapFactory.decodeResource(context0.getResources(), v);
        CastContext castContext0 = CastContext.zzb(context0);
        ImagePicker imagePicker0 = null;
        if(castContext0 != null) {
            CastMediaOptions castMediaOptions0 = castContext0.getCastOptions().getCastMediaOptions();
            if(castMediaOptions0 != null) {
                imagePicker0 = castMediaOptions0.getImagePicker();
            }
        }
        this.zzd = imagePicker0;
        this.zze = zzb0;
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onMediaStatusUpdated() {
        this.zzb();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionConnected(CastSession castSession0) {
        super.onSessionConnected(castSession0);
        zzcf zzcf0 = new zzcf(this);
        this.zze.zzc(zzcf0);
        this.zza.setImageBitmap(this.zzc);
        this.zzb();
    }

    @Override  // com.google.android.gms.cast.framework.media.uicontroller.UIController
    public final void onSessionEnded() {
        this.zze.zza();
        this.zza.setImageBitmap(this.zzc);
        super.onSessionEnded();
    }

    private final void zzb() {
        RemoteMediaClient remoteMediaClient0 = this.getRemoteMediaClient();
        if(remoteMediaClient0 != null && remoteMediaClient0.hasMediaSession()) {
            MediaQueueItem mediaQueueItem0 = remoteMediaClient0.getPreloadedItem();
            Uri uri0 = null;
            if(mediaQueueItem0 != null) {
                MediaInfo mediaInfo0 = mediaQueueItem0.getMedia();
                if(mediaInfo0 != null) {
                    ImagePicker imagePicker0 = this.zzd;
                    MediaMetadata mediaMetadata0 = mediaInfo0.getMetadata();
                    if(imagePicker0 == null || mediaMetadata0 == null) {
                        uri0 = MediaUtils.getImageUri(mediaInfo0, 0);
                    }
                    else {
                        WebImage webImage0 = imagePicker0.onPickImage(mediaMetadata0, this.zzb);
                        uri0 = webImage0 == null || webImage0.getUrl() == null ? MediaUtils.getImageUri(mediaInfo0, 0) : webImage0.getUrl();
                    }
                }
            }
            if(uri0 == null) {
                this.zza.setImageBitmap(this.zzc);
                return;
            }
            this.zze.zzd(uri0);
            return;
        }
        this.zza.setImageBitmap(this.zzc);
    }
}

