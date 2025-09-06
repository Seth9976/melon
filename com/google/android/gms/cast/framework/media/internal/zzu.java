package com.google.android.gms.cast.framework.media.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.MediaMetadataCompat.Builder;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat.CustomAction;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.R.string;
import com.google.android.gms.cast.framework.ReconnectionService;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImagePicker;
import com.google.android.gms.cast.framework.media.NotificationAction;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.zzg;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.cast.zzbf;
import com.google.android.gms.internal.cast.zzeo;
import com.google.android.gms.internal.cast.zzet;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzu {
    public static final int zza;
    private static final Logger zzb;
    private final Context zzc;
    private final CastOptions zzd;
    private final zzbf zze;
    private final SessionManager zzf;
    private final NotificationOptions zzg;
    private final ComponentName zzh;
    private final ComponentName zzi;
    private final zzb zzj;
    private final zzb zzk;
    private final zzn zzl;
    private final Handler zzm;
    private final Runnable zzn;
    private final Callback zzo;
    private RemoteMediaClient zzp;
    private CastDevice zzq;
    private MediaSessionCompat zzr;
    private android.support.v4.media.session.MediaSessionCompat.Callback zzs;
    private boolean zzt;
    private CustomAction zzu;
    private CustomAction zzv;
    private CustomAction zzw;
    private CustomAction zzx;

    static {
        zzu.zzb = new Logger("MediaSessionManager");
    }

    public zzu(Context context0, CastOptions castOptions0, zzbf zzbf0) {
        this.zzc = context0;
        this.zzd = castOptions0;
        this.zze = zzbf0;
        CastContext castContext0 = CastContext.getSharedInstance();
        zzn zzn0 = null;
        this.zzf = castContext0 == null ? null : castContext0.getSessionManager();
        CastMediaOptions castMediaOptions0 = castOptions0.getCastMediaOptions();
        this.zzg = castMediaOptions0 == null ? null : castMediaOptions0.getNotificationOptions();
        this.zzo = new zzs(this, null);
        String s = castMediaOptions0 == null ? null : castMediaOptions0.getExpandedControllerActivityClassName();
        this.zzh = TextUtils.isEmpty(s) ? null : new ComponentName(context0, s);
        String s1 = castMediaOptions0 == null ? null : castMediaOptions0.getMediaIntentReceiverClassName();
        this.zzi = TextUtils.isEmpty(s1) ? null : new ComponentName(context0, s1);
        zzb zzb0 = new zzb(context0);
        this.zzj = zzb0;
        zzb0.zzc(new zzp(this));
        zzb zzb1 = new zzb(context0);
        this.zzk = zzb1;
        zzb1.zzc(new zzq(this));
        this.zzm = new zzet(Looper.getMainLooper());
        if(zzn.zze(castOptions0)) {
            zzn0 = new zzn(context0);
        }
        this.zzl = zzn0;
        this.zzn = () -> this.zzq(false);
    }

    public static ComponentName zza(zzu zzu0) {
        return zzu0.zzi;
    }

    public static Context zzb(zzu zzu0) {
        return zzu0.zzc;
    }

    public static SessionManager zzc(zzu zzu0) {
        return zzu0.zzf;
    }

    public static NotificationOptions zzd(zzu zzu0) {
        return zzu0.zzg;
    }

    public static RemoteMediaClient zze(zzu zzu0) {
        return zzu0.zzp;
    }

    public static Logger zzf() {
        return zzu.zzb;
    }

    // 检测为 Lambda 实现
    public static void zzg(zzu zzu0) [...]

    public final void zzh(RemoteMediaClient remoteMediaClient0, CastDevice castDevice0) {
        CastMediaOptions castMediaOptions0 = this.zzd == null ? null : this.zzd.getCastMediaOptions();
        if(!this.zzt && this.zzd != null && castMediaOptions0 != null && this.zzg != null && remoteMediaClient0 != null && castDevice0 != null) {
            ComponentName componentName0 = this.zzi;
            if(componentName0 != null) {
                this.zzp = remoteMediaClient0;
                remoteMediaClient0.registerCallback(this.zzo);
                this.zzq = castDevice0;
                Intent intent0 = new Intent("android.intent.action.MEDIA_BUTTON");
                intent0.setComponent(componentName0);
                Context context0 = this.zzc;
                PendingIntent pendingIntent0 = PendingIntent.getBroadcast(context0, 0, intent0, zzeo.zza);
                if(castMediaOptions0.getMediaSessionEnabled()) {
                    MediaSessionCompat mediaSessionCompat0 = new MediaSessionCompat(context0, "CastMediaSession", componentName0, pendingIntent0);
                    this.zzr = mediaSessionCompat0;
                    this.zzt(0, null);
                    if(this.zzq != null && !TextUtils.isEmpty(this.zzq.getFriendlyName())) {
                        mediaSessionCompat0.setMetadata(new Builder().putString("android.media.metadata.ALBUM_ARTIST", context0.getResources().getString(string.cast_casting_to_device, new Object[]{this.zzq.getFriendlyName()})).build());
                    }
                    zzr zzr0 = new zzr(this);
                    this.zzs = zzr0;
                    mediaSessionCompat0.setCallback(zzr0);
                    mediaSessionCompat0.setActive(true);
                    this.zze.zzt(mediaSessionCompat0);
                }
                this.zzt = true;
                this.zzl(false);
                return;
            }
        }
        zzu.zzb.d("skip attaching media session", new Object[0]);
    }

    public final void zzi(int v) {
        if(this.zzt) {
            this.zzt = false;
            RemoteMediaClient remoteMediaClient0 = this.zzp;
            if(remoteMediaClient0 != null) {
                remoteMediaClient0.unregisterCallback(this.zzo);
            }
            this.zze.zzt(null);
            zzb zzb0 = this.zzj;
            if(zzb0 != null) {
                zzb0.zza();
            }
            zzb zzb1 = this.zzk;
            if(zzb1 != null) {
                zzb1.zza();
            }
            MediaSessionCompat mediaSessionCompat0 = this.zzr;
            if(mediaSessionCompat0 != null) {
                mediaSessionCompat0.setCallback(null);
                this.zzr.setMetadata(new Builder().build());
                this.zzt(0, null);
            }
            MediaSessionCompat mediaSessionCompat1 = this.zzr;
            if(mediaSessionCompat1 != null) {
                mediaSessionCompat1.setActive(false);
                this.zzr.release();
                this.zzr = null;
            }
            this.zzp = null;
            this.zzq = null;
            this.zzs = null;
            this.zzr();
            if(v == 0) {
                this.zzs();
            }
        }
    }

    public final void zzj(Bitmap bitmap0, int v) {
        MediaSessionCompat mediaSessionCompat0 = this.zzr;
        if(mediaSessionCompat0 == null) {
            return;
        }
        if(bitmap0 == null || bitmap0.getWidth() <= 1 || bitmap0.getHeight() <= 1) {
            bitmap0 = Bitmap.createBitmap(2, 2, Bitmap.Config.ARGB_8888);
            bitmap0.eraseColor(0);
        }
        mediaSessionCompat0.setMetadata(this.zzo().putBitmap((v == 0 ? "android.media.metadata.DISPLAY_ICON" : "android.media.metadata.ALBUM_ART"), bitmap0).build());
    }

    public final void zzk(CastDevice castDevice0) {
        zzu.zzb.i("update Cast device to %s", new Object[]{castDevice0});
        this.zzq = castDevice0;
        this.zzl(false);
    }

    public final void zzl(boolean z) {
        RemoteMediaClient remoteMediaClient0 = this.zzp;
        if(remoteMediaClient0 != null) {
            int v = remoteMediaClient0.zza();
            MediaInfo mediaInfo0 = remoteMediaClient0.getMediaInfo();
            if(remoteMediaClient0.isLoadingNextItem()) {
                MediaQueueItem mediaQueueItem0 = remoteMediaClient0.getLoadingItem();
                if(mediaQueueItem0 != null && mediaQueueItem0.getMedia() != null) {
                    mediaInfo0 = mediaQueueItem0.getMedia();
                }
            }
            this.zzt(v, mediaInfo0);
            if(!remoteMediaClient0.hasMediaSession()) {
                this.zzr();
                this.zzs();
                return;
            }
            if(v != 0) {
                zzn zzn0 = this.zzl;
                if(zzn0 != null) {
                    zzu.zzb.d("Update media notification.", new Object[0]);
                    zzn0.zzd(this.zzq, this.zzp, this.zzr, z);
                }
                if(!remoteMediaClient0.isLoadingNextItem()) {
                    this.zzq(true);
                }
            }
        }
    }

    private final long zzm(String s, int v, Bundle bundle0) {
        int v1;
        switch(s) {
            case "com.google.android.gms.cast.framework.action.SKIP_NEXT": {
                v1 = 2;
                break;
            }
            case "com.google.android.gms.cast.framework.action.SKIP_PREV": {
                v1 = 1;
                break;
            }
            case "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK": {
                v1 = 0;
                break;
            }
            default: {
                v1 = -1;
            }
        }
        if(v1 != 0) {
            switch(v1) {
                case 1: {
                    if(this.zzp != null && this.zzp.zzu()) {
                        return 16L;
                    }
                    bundle0.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", true);
                    return 0L;
                }
                case 2: {
                    if(this.zzp != null && this.zzp.zzt()) {
                        return 0x20L;
                    }
                    bundle0.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", true);
                    return 0L;
                }
                default: {
                    return 0L;
                }
            }
        }
        if(v == 3) {
            return 0x202L;
        }
        return v == 2 ? 0x204L : 0x200L;
    }

    private final Uri zzn(MediaMetadata mediaMetadata0, int v) {
        WebImage webImage0;
        CastMediaOptions castMediaOptions0 = this.zzd.getCastMediaOptions();
        ImagePicker imagePicker0 = castMediaOptions0 == null ? null : castMediaOptions0.getImagePicker();
        if(imagePicker0 != null) {
            webImage0 = imagePicker0.onPickImage(mediaMetadata0, v);
            return webImage0 == null ? null : webImage0.getUrl();
        }
        webImage0 = mediaMetadata0.hasImages() ? ((WebImage)mediaMetadata0.getImages().get(0)) : null;
        return webImage0 == null ? null : webImage0.getUrl();
    }

    private final Builder zzo() {
        MediaMetadataCompat mediaMetadataCompat0 = this.zzr == null ? null : this.zzr.getController().getMetadata();
        return mediaMetadataCompat0 == null ? new Builder() : new Builder(mediaMetadataCompat0);
    }

    private final void zzp(android.support.v4.media.session.PlaybackStateCompat.Builder playbackStateCompat$Builder0, String s, NotificationAction notificationAction0) {
        CustomAction playbackStateCompat$CustomAction0;
        switch(s) {
            case "com.google.android.gms.cast.framework.action.DISCONNECT": {
                if(this.zzx == null) {
                    NotificationOptions notificationOptions2 = this.zzg;
                    if(notificationOptions2 != null) {
                        this.zzx = new android.support.v4.media.session.PlaybackStateCompat.CustomAction.Builder("com.google.android.gms.cast.framework.action.DISCONNECT", this.zzc.getResources().getString(notificationOptions2.zza()), notificationOptions2.getDisconnectDrawableResId()).build();
                    }
                }
                playbackStateCompat$CustomAction0 = this.zzx;
                break;
            }
            case "com.google.android.gms.cast.framework.action.FORWARD": {
                if(this.zzu == null) {
                    NotificationOptions notificationOptions3 = this.zzg;
                    if(notificationOptions3 != null) {
                        long v3 = notificationOptions3.getSkipStepMs();
                        int v4 = zzv.zzb(notificationOptions3, v3);
                        int v5 = zzv.zza(notificationOptions3, v3);
                        this.zzu = new android.support.v4.media.session.PlaybackStateCompat.CustomAction.Builder("com.google.android.gms.cast.framework.action.FORWARD", this.zzc.getResources().getString(v4), v5).build();
                    }
                }
                playbackStateCompat$CustomAction0 = this.zzu;
                break;
            }
            case "com.google.android.gms.cast.framework.action.REWIND": {
                if(this.zzv == null) {
                    NotificationOptions notificationOptions0 = this.zzg;
                    if(notificationOptions0 != null) {
                        long v = notificationOptions0.getSkipStepMs();
                        int v1 = zzv.zzd(notificationOptions0, v);
                        int v2 = zzv.zzc(notificationOptions0, v);
                        this.zzv = new android.support.v4.media.session.PlaybackStateCompat.CustomAction.Builder("com.google.android.gms.cast.framework.action.REWIND", this.zzc.getResources().getString(v1), v2).build();
                    }
                }
                playbackStateCompat$CustomAction0 = this.zzv;
                break;
            }
            case "com.google.android.gms.cast.framework.action.STOP_CASTING": {
                if(this.zzw == null) {
                    NotificationOptions notificationOptions1 = this.zzg;
                    if(notificationOptions1 != null) {
                        this.zzw = new android.support.v4.media.session.PlaybackStateCompat.CustomAction.Builder("com.google.android.gms.cast.framework.action.STOP_CASTING", this.zzc.getResources().getString(notificationOptions1.zza()), notificationOptions1.getDisconnectDrawableResId()).build();
                    }
                }
                playbackStateCompat$CustomAction0 = this.zzw;
                break;
            }
            default: {
                playbackStateCompat$CustomAction0 = notificationAction0 == null ? null : new android.support.v4.media.session.PlaybackStateCompat.CustomAction.Builder(s, notificationAction0.getContentDescription(), notificationAction0.getIconResId()).build();
            }
        }
        if(playbackStateCompat$CustomAction0 != null) {
            playbackStateCompat$Builder0.addCustomAction(playbackStateCompat$CustomAction0);
        }
    }

    @RequiresNonNull({"appContext", "handler", "options"})
    private final void zzq(boolean z) {
        if(this.zzd.getEnableReconnectionService()) {
            Runnable runnable0 = this.zzn;
            if(runnable0 != null) {
                this.zzm.removeCallbacks(runnable0);
            }
            Intent intent0 = new Intent(this.zzc, ReconnectionService.class);
            intent0.setPackage("com.iloen.melon");
            try {
                this.zzc.startService(intent0);
            }
            catch(IllegalStateException unused_ex) {
                if(z) {
                    this.zzm.postDelayed(this.zzn, 1000L);
                }
            }
        }
    }

    private final void zzr() {
        zzn zzn0 = this.zzl;
        if(zzn0 != null) {
            zzu.zzb.d("Stopping media notification.", new Object[0]);
            zzn0.zzc();
        }
    }

    private final void zzs() {
        if(!this.zzd.getEnableReconnectionService()) {
            return;
        }
        this.zzm.removeCallbacks(this.zzn);
        Intent intent0 = new Intent(this.zzc, ReconnectionService.class);
        intent0.setPackage("com.iloen.melon");
        this.zzc.stopService(intent0);
    }

    private final void zzt(int v, MediaInfo mediaInfo0) {
        PendingIntent pendingIntent0;
        PlaybackStateCompat playbackStateCompat0;
        MediaSessionCompat mediaSessionCompat0 = this.zzr;
        if(mediaSessionCompat0 != null) {
            Bundle bundle0 = new Bundle();
            android.support.v4.media.session.PlaybackStateCompat.Builder playbackStateCompat$Builder0 = new android.support.v4.media.session.PlaybackStateCompat.Builder();
            RemoteMediaClient remoteMediaClient0 = this.zzp;
            long v1 = 0L;
            if(remoteMediaClient0 == null || this.zzl == null) {
                playbackStateCompat0 = playbackStateCompat$Builder0.build();
            }
            else {
                playbackStateCompat$Builder0.setState(v, (remoteMediaClient0.zza() != 0 && !remoteMediaClient0.isLiveStream() ? remoteMediaClient0.getApproximateStreamPosition() : 0L), 1.0f);
                if(v == 0) {
                    playbackStateCompat0 = playbackStateCompat$Builder0.build();
                }
                else {
                    NotificationOptions notificationOptions0 = this.zzg;
                    zzg zzg0 = notificationOptions0 == null ? null : notificationOptions0.zzm();
                    long v2 = this.zzp != null && !this.zzp.isLiveStream() && !this.zzp.isPlayingAd() ? 0x100L : 0L;
                    if(zzg0 != null) {
                        List list0 = zzv.zzf(zzg0);
                        if(list0 != null) {
                            for(Object object0: list0) {
                                NotificationAction notificationAction0 = (NotificationAction)object0;
                                String s = notificationAction0.getAction();
                                if(zzu.zzu(s)) {
                                    v2 |= this.zzm(s, v, bundle0);
                                }
                                else {
                                    this.zzp(playbackStateCompat$Builder0, s, notificationAction0);
                                }
                            }
                        }
                    }
                    else if(notificationOptions0 != null) {
                        for(Object object1: notificationOptions0.getActions()) {
                            String s1 = (String)object1;
                            if(zzu.zzu(s1)) {
                                v2 |= this.zzm(s1, v, bundle0);
                            }
                            else {
                                this.zzp(playbackStateCompat$Builder0, s1, null);
                            }
                        }
                    }
                    playbackStateCompat0 = playbackStateCompat$Builder0.setActions(v2).build();
                }
            }
            mediaSessionCompat0.setPlaybackState(playbackStateCompat0);
            NotificationOptions notificationOptions1 = this.zzg;
            if(notificationOptions1 != null && notificationOptions1.zzp()) {
                bundle0.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", true);
            }
            if(notificationOptions1 != null && notificationOptions1.zzo()) {
                bundle0.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", true);
            }
            if(bundle0.containsKey("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS") || bundle0.containsKey("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT")) {
                mediaSessionCompat0.setExtras(bundle0);
            }
            if(v == 0) {
                mediaSessionCompat0.setMetadata(new Builder().build());
                return;
            }
            if(this.zzp != null) {
                ComponentName componentName0 = this.zzh;
                if(componentName0 == null) {
                    pendingIntent0 = null;
                }
                else {
                    Intent intent0 = new Intent();
                    intent0.setComponent(componentName0);
                    pendingIntent0 = PendingIntent.getActivity(this.zzc, 0, intent0, zzeo.zza | 0x8000000);
                }
                if(pendingIntent0 != null) {
                    mediaSessionCompat0.setSessionActivity(pendingIntent0);
                }
            }
            if(this.zzp != null) {
                MediaSessionCompat mediaSessionCompat1 = this.zzr;
                if(mediaSessionCompat1 != null && mediaInfo0 != null) {
                    MediaMetadata mediaMetadata0 = mediaInfo0.getMetadata();
                    if(mediaMetadata0 != null) {
                        if(this.zzp == null || !this.zzp.isLiveStream()) {
                            v1 = mediaInfo0.getStreamDuration();
                        }
                        String s2 = mediaMetadata0.getString("com.google.android.gms.cast.metadata.TITLE");
                        String s3 = mediaMetadata0.getString("com.google.android.gms.cast.metadata.SUBTITLE");
                        Builder mediaMetadataCompat$Builder0 = this.zzo().putLong("android.media.metadata.DURATION", v1);
                        if(s2 != null) {
                            mediaMetadataCompat$Builder0.putString("android.media.metadata.TITLE", s2);
                            mediaMetadataCompat$Builder0.putString("android.media.metadata.DISPLAY_TITLE", s2);
                        }
                        if(s3 != null) {
                            mediaMetadataCompat$Builder0.putString("android.media.metadata.DISPLAY_SUBTITLE", s3);
                        }
                        mediaSessionCompat1.setMetadata(mediaMetadataCompat$Builder0.build());
                        Uri uri0 = this.zzn(mediaMetadata0, 0);
                        if(uri0 == null) {
                            this.zzj(null, 0);
                        }
                        else {
                            this.zzj.zzd(uri0);
                        }
                        Uri uri1 = this.zzn(mediaMetadata0, 3);
                        if(uri1 != null) {
                            this.zzk.zzd(uri1);
                            return;
                        }
                        this.zzj(null, 3);
                    }
                }
            }
        }
    }

    // 去混淆评级： 低(30)
    private static final boolean zzu(String s) {
        return TextUtils.equals(s, "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK") || TextUtils.equals(s, "com.google.android.gms.cast.framework.action.SKIP_PREV") || TextUtils.equals(s, "com.google.android.gms.cast.framework.action.SKIP_NEXT");
    }
}

