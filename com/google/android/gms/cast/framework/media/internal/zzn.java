package com.google.android.gms.cast.framework.media.internal;

import N1.e;
import N1.l;
import N1.m;
import Y2.c;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat.Builder;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.R.string;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.ImagePicker;
import com.google.android.gms.cast.framework.media.NotificationAction;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.zzg;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzeo;
import com.google.android.gms.internal.cast.zzp;
import com.google.android.gms.internal.cast.zzpb;
import java.util.ArrayList;
import java.util.List;

final class zzn {
    private static final Logger zza;
    private final Context zzb;
    private final NotificationManager zzc;
    private final CastContext zzd;
    private final NotificationOptions zze;
    private final ImagePicker zzf;
    private final ComponentName zzg;
    private final ComponentName zzh;
    private List zzi;
    private int[] zzj;
    private final long zzk;
    private final zzb zzl;
    private final ImageHints zzm;
    private final Resources zzn;
    private zzl zzo;
    private zzm zzp;
    private Notification zzq;
    private m zzr;
    private m zzs;
    private m zzt;
    private m zzu;
    private m zzv;
    private m zzw;
    private m zzx;
    private m zzy;

    static {
        zzn.zza = new Logger("MediaNotificationProxy");
    }

    public zzn(Context context0) {
        this.zzi = new ArrayList();
        this.zzb = context0;
        NotificationManager notificationManager0 = (NotificationManager)context0.getSystemService("notification");
        this.zzc = notificationManager0;
        CastContext castContext0 = (CastContext)Preconditions.checkNotNull(CastContext.getSharedInstance());
        this.zzd = castContext0;
        CastMediaOptions castMediaOptions0 = (CastMediaOptions)Preconditions.checkNotNull(((CastOptions)Preconditions.checkNotNull(castContext0.getCastOptions())).getCastMediaOptions());
        NotificationOptions notificationOptions0 = (NotificationOptions)Preconditions.checkNotNull(castMediaOptions0.getNotificationOptions());
        this.zze = notificationOptions0;
        this.zzf = castMediaOptions0.getImagePicker();
        Resources resources0 = context0.getResources();
        this.zzn = resources0;
        this.zzg = new ComponentName(context0.getApplicationContext(), castMediaOptions0.getMediaIntentReceiverClassName());
        this.zzh = TextUtils.isEmpty(notificationOptions0.getTargetActivityClassName()) ? null : new ComponentName(context0.getApplicationContext(), notificationOptions0.getTargetActivityClassName());
        this.zzk = notificationOptions0.getSkipStepMs();
        int v = resources0.getDimensionPixelSize(notificationOptions0.zze());
        ImageHints imageHints0 = new ImageHints(1, v, v);
        this.zzm = imageHints0;
        this.zzl = new zzb(context0.getApplicationContext(), imageHints0);
        if(notificationManager0 != null) {
            NotificationChannel notificationChannel0 = new NotificationChannel("cast_media_notification", ((Context)Preconditions.checkNotNull(context0)).getResources().getString(string.media_notification_channel_name), 2);
            notificationChannel0.setShowBadge(false);
            notificationManager0.createNotificationChannel(notificationChannel0);
        }
        zzp.zzd(zzpb.zzad);
    }

    public static void zza(zzn zzn0, zzm zzm0) {
        zzn0.zzp = zzm0;
    }

    public static void zzb(zzn zzn0) {
        zzn0.zzg();
    }

    public final void zzc() {
        this.zzl.zza();
        NotificationManager notificationManager0 = this.zzc;
        if(notificationManager0 != null) {
            notificationManager0.cancel("castMediaNotification", 1);
        }
    }

    public final void zzd(CastDevice castDevice0, RemoteMediaClient remoteMediaClient0, MediaSessionCompat mediaSessionCompat0, boolean z) {
        WebImage webImage0;
        boolean z2;
        boolean z1;
        if(castDevice0 != null && remoteMediaClient0 != null && mediaSessionCompat0 != null) {
            MediaInfo mediaInfo0 = remoteMediaClient0.getMediaInfo();
            if(mediaInfo0 != null) {
                MediaMetadata mediaMetadata0 = mediaInfo0.getMetadata();
                if(mediaMetadata0 != null) {
                    MediaStatus mediaStatus0 = remoteMediaClient0.getMediaStatus();
                    if(mediaStatus0 == null) {
                        z1 = false;
                        z2 = false;
                    }
                    else {
                        int v = mediaStatus0.getQueueRepeatMode();
                        if(v == 1 || v == 2 || v == 3) {
                            z1 = true;
                            z2 = true;
                        }
                        else {
                            Integer integer0 = mediaStatus0.getIndexById(mediaStatus0.getCurrentItemId());
                            if(integer0 == null) {
                                z1 = false;
                                z2 = false;
                            }
                            else {
                                z1 = ((int)integer0) < mediaStatus0.getQueueItemCount() - 1;
                                z2 = ((int)integer0) > 0;
                            }
                        }
                    }
                    zzl zzl0 = new zzl(remoteMediaClient0.getPlayerState() == 2, mediaInfo0.getStreamType(), mediaMetadata0.getString("com.google.android.gms.cast.metadata.TITLE"), castDevice0.getFriendlyName(), mediaSessionCompat0.getSessionToken(), z1, z2);
                    if(z) {
                        this.zzo = zzl0;
                        this.zzg();
                    }
                    else {
                        zzl zzl1 = this.zzo;
                        if(zzl1 == null || zzl0.zzb != zzl1.zzb || zzl0.zzc != zzl1.zzc || !CastUtils.zze(zzl0.zzd, zzl1.zzd) || !CastUtils.zze(zzl0.zze, zzl1.zze) || zzl0.zzf != zzl1.zzf || zzl0.zzg != zzl1.zzg) {
                            this.zzo = zzl0;
                            this.zzg();
                        }
                    }
                    ImagePicker imagePicker0 = this.zzf;
                    if(imagePicker0 == null) {
                        webImage0 = mediaMetadata0.hasImages() ? ((WebImage)mediaMetadata0.getImages().get(0)) : null;
                    }
                    else {
                        webImage0 = imagePicker0.onPickImage(mediaMetadata0, this.zzm);
                    }
                    zzm zzm0 = new zzm(webImage0);
                    if(this.zzp == null || !CastUtils.zze(zzm0.zza, this.zzp.zza)) {
                        zzk zzk0 = new zzk(this, zzm0);
                        this.zzl.zzc(zzk0);
                        this.zzl.zzd(zzm0.zza);
                    }
                }
            }
        }
    }

    public static boolean zze(CastOptions castOptions0) {
        CastMediaOptions castMediaOptions0 = castOptions0.getCastMediaOptions();
        if(castMediaOptions0 == null) {
            return false;
        }
        NotificationOptions notificationOptions0 = castMediaOptions0.getNotificationOptions();
        if(notificationOptions0 == null) {
            return false;
        }
        zzg zzg0 = notificationOptions0.zzm();
        if(zzg0 == null) {
            return true;
        }
        List list0 = zzv.zzf(zzg0);
        int[] arr_v = zzv.zzg(zzg0);
        int v = list0 == null ? 0 : list0.size();
        if(list0 != null && !list0.isEmpty()) {
            if(list0.size() > 5) {
                zzn.zza.e("NotificationActionsProvider provides more than 5 actions.", new Object[0]);
                return false;
            }
            if(arr_v != null && arr_v.length != 0) {
                int v1 = 0;
                while(v1 < arr_v.length) {
                    int v2 = arr_v[v1];
                    if(v2 >= 0 && v2 < v) {
                        ++v1;
                        continue;
                    }
                    zzn.zza.e("NotificationActionsProviderprovides a compact view action whose index is out of bounds.", new Object[0]);
                    return false;
                }
                return true;
            }
            zzn.zza.e("NotificationActionsProvider doesn\'t provide any actions for compact view.", new Object[0]);
            return false;
        }
        zzn.zza.e("NotificationActionsProvider doesn\'t provide any action.", new Object[0]);
        return false;
    }

    private final m zzf(String s) {
        int v3;
        int v2;
        int v;
        switch(s) {
            case "com.google.android.gms.cast.framework.action.DISCONNECT": {
                v = 6;
                break;
            }
            case "com.google.android.gms.cast.framework.action.FORWARD": {
                v = 3;
                break;
            }
            case "com.google.android.gms.cast.framework.action.REWIND": {
                v = 4;
                break;
            }
            case "com.google.android.gms.cast.framework.action.SKIP_NEXT": {
                v = 1;
                break;
            }
            case "com.google.android.gms.cast.framework.action.SKIP_PREV": {
                v = 2;
                break;
            }
            case "com.google.android.gms.cast.framework.action.STOP_CASTING": {
                v = 5;
                break;
            }
            case "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK": {
                v = 0;
                break;
            }
            default: {
                v = -1;
            }
        }
        PendingIntent pendingIntent0 = null;
        switch(v) {
            case 0: {
                int v1 = this.zzo.zzc;
                if(this.zzo.zzb) {
                    if(this.zzs == null) {
                        if(v1 == 2) {
                            v2 = this.zze.getStopLiveStreamDrawableResId();
                            v3 = this.zze.getStopLiveStreamTitleResId();
                        }
                        else {
                            v2 = this.zze.getPauseDrawableResId();
                            v3 = this.zze.zzf();
                        }
                        Intent intent0 = new Intent("com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK");
                        intent0.setComponent(this.zzg);
                        PendingIntent pendingIntent1 = PendingIntent.getBroadcast(this.zzb, 0, intent0, zzeo.zza);
                        this.zzs = new l(v2, this.zzn.getString(v3), pendingIntent1).a();
                    }
                    return this.zzs;
                }
                if(this.zzr == null) {
                    Intent intent1 = new Intent("com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK");
                    intent1.setComponent(this.zzg);
                    PendingIntent pendingIntent2 = PendingIntent.getBroadcast(this.zzb, 0, intent1, zzeo.zza);
                    String s1 = this.zzn.getString(this.zze.zzg());
                    this.zzr = new l(this.zze.getPlayDrawableResId(), s1, pendingIntent2).a();
                }
                return this.zzr;
            }
            case 1: {
                boolean z = this.zzo.zzf;
                if(this.zzt == null) {
                    if(z) {
                        Intent intent2 = new Intent("com.google.android.gms.cast.framework.action.SKIP_NEXT");
                        intent2.setComponent(this.zzg);
                        pendingIntent0 = PendingIntent.getBroadcast(this.zzb, 0, intent2, zzeo.zza);
                    }
                    String s2 = this.zzn.getString(this.zze.zzk());
                    this.zzt = new l(this.zze.getSkipNextDrawableResId(), s2, pendingIntent0).a();
                }
                return this.zzt;
            }
            case 2: {
                boolean z1 = this.zzo.zzg;
                if(this.zzu == null) {
                    if(z1) {
                        Intent intent3 = new Intent("com.google.android.gms.cast.framework.action.SKIP_PREV");
                        intent3.setComponent(this.zzg);
                        pendingIntent0 = PendingIntent.getBroadcast(this.zzb, 0, intent3, zzeo.zza);
                    }
                    String s3 = this.zzn.getString(this.zze.zzl());
                    this.zzu = new l(this.zze.getSkipPrevDrawableResId(), s3, pendingIntent0).a();
                }
                return this.zzu;
            }
            case 3: {
                long v4 = this.zzk;
                if(this.zzv == null) {
                    Intent intent4 = new Intent("com.google.android.gms.cast.framework.action.FORWARD");
                    intent4.setComponent(this.zzg);
                    intent4.putExtra("googlecast-extra_skip_step_ms", v4);
                    PendingIntent pendingIntent3 = PendingIntent.getBroadcast(this.zzb, 0, intent4, zzeo.zza | 0x8000000);
                    int v5 = zzv.zza(this.zze, v4);
                    int v6 = zzv.zzb(this.zze, v4);
                    this.zzv = new l(v5, this.zzn.getString(v6), pendingIntent3).a();
                }
                return this.zzv;
            }
            case 4: {
                long v7 = this.zzk;
                if(this.zzw == null) {
                    Intent intent5 = new Intent("com.google.android.gms.cast.framework.action.REWIND");
                    intent5.setComponent(this.zzg);
                    intent5.putExtra("googlecast-extra_skip_step_ms", v7);
                    PendingIntent pendingIntent4 = PendingIntent.getBroadcast(this.zzb, 0, intent5, zzeo.zza | 0x8000000);
                    int v8 = zzv.zzc(this.zze, v7);
                    int v9 = zzv.zzd(this.zze, v7);
                    this.zzw = new l(v8, this.zzn.getString(v9), pendingIntent4).a();
                }
                return this.zzw;
            }
            case 5: {
                if(this.zzy == null) {
                    Intent intent6 = new Intent("com.google.android.gms.cast.framework.action.STOP_CASTING");
                    intent6.setComponent(this.zzg);
                    PendingIntent pendingIntent5 = PendingIntent.getBroadcast(this.zzb, 0, intent6, zzeo.zza);
                    String s4 = this.zzn.getString(this.zze.zza());
                    this.zzy = new l(this.zze.getDisconnectDrawableResId(), s4, pendingIntent5).a();
                }
                return this.zzy;
            }
            case 6: {
                if(this.zzx == null) {
                    Intent intent7 = new Intent("com.google.android.gms.cast.framework.action.DISCONNECT");
                    intent7.setComponent(this.zzg);
                    PendingIntent pendingIntent6 = PendingIntent.getBroadcast(this.zzb, 0, intent7, zzeo.zza);
                    String s5 = this.zzn.getString(this.zze.zza(), new Object[]{""});
                    this.zzx = new l(this.zze.getDisconnectDrawableResId(), s5, pendingIntent6).a();
                }
                return this.zzx;
            }
            default: {
                zzn.zza.e("Action: %s is not a pre-defined action.", new Object[]{s});
                return null;
            }
        }
    }

    private final void zzg() {
        m m0;
        PendingIntent pendingIntent0;
        Bitmap bitmap0;
        NotificationManager notificationManager0 = this.zzc;
        if(notificationManager0 != null && this.zzo != null) {
            zzm zzm0 = this.zzp;
            int[] arr_v = null;
            if(zzm0 == null) {
                bitmap0 = null;
            }
            else {
                bitmap0 = zzm0.zzb;
                if(bitmap0 == null || bitmap0.getWidth() <= 1 || bitmap0.getHeight() <= 1) {
                    bitmap0 = null;
                }
            }
            Context context0 = this.zzb;
            NotificationCompat.Builder notificationCompat$Builder0 = new NotificationCompat.Builder(context0, "cast_media_notification");
            notificationCompat$Builder0.f(bitmap0);
            NotificationOptions notificationOptions0 = this.zze;
            notificationCompat$Builder0.G.icon = notificationOptions0.getSmallIconDrawableResId();
            notificationCompat$Builder0.e = NotificationCompat.Builder.b(this.zzo.zzd);
            notificationCompat$Builder0.f = NotificationCompat.Builder.b(this.zzn.getString(notificationOptions0.getCastingToDeviceStringResId(), new Object[]{this.zzo.zze}));
            notificationCompat$Builder0.e(2, true);
            notificationCompat$Builder0.k = false;
            notificationCompat$Builder0.A = 1;
            ComponentName componentName0 = this.zzh;
            if(componentName0 == null) {
                pendingIntent0 = null;
            }
            else {
                Intent intent0 = new Intent();
                intent0.putExtra("targetActivity", componentName0);
                intent0.setAction(componentName0.flattenToString());
                intent0.setComponent(componentName0);
                ArrayList arrayList0 = new ArrayList();
                ComponentName componentName1 = intent0.getComponent();
                if(componentName1 == null) {
                    componentName1 = intent0.resolveActivity(context0.getPackageManager());
                }
                if(componentName1 != null) {
                    try {
                        int v = arrayList0.size();
                        for(Intent intent1 = e.a(context0, componentName1); intent1 != null; intent1 = e.a(context0, intent1.getComponent())) {
                            arrayList0.add(v, intent1);
                        }
                    }
                    catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                        Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                        throw new IllegalArgumentException(packageManager$NameNotFoundException0);
                    }
                }
                arrayList0.add(intent0);
                int v1 = zzeo.zza | 0x8000000;
                if(arrayList0.isEmpty()) {
                    throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
                }
                Intent[] arr_intent = (Intent[])arrayList0.toArray(new Intent[0]);
                arr_intent[0] = new Intent(arr_intent[0]).addFlags(0x1000C000);
                pendingIntent0 = PendingIntent.getActivities(context0, 1, arr_intent, v1, null);
            }
            if(pendingIntent0 != null) {
                notificationCompat$Builder0.g = pendingIntent0;
            }
            zzg zzg0 = notificationOptions0.zzm();
            if(zzg0 == null) {
                zzn.zza.d("actionsProvider == null", new Object[0]);
                this.zzi = new ArrayList();
                for(Object object1: notificationOptions0.getActions()) {
                    m m1 = this.zzf(((String)object1));
                    if(m1 != null) {
                        this.zzi.add(m1);
                    }
                }
                this.zzj = (int[])notificationOptions0.getCompatActionIndices().clone();
            }
            else {
                zzn.zza.d("actionsProvider != null", new Object[0]);
                int[] arr_v1 = zzv.zzg(zzg0);
                if(arr_v1 != null) {
                    arr_v = (int[])arr_v1.clone();
                }
                this.zzj = arr_v;
                List list0 = zzv.zzf(zzg0);
                this.zzi = new ArrayList();
                if(list0 != null) {
                    for(Object object0: list0) {
                        NotificationAction notificationAction0 = (NotificationAction)object0;
                        String s = notificationAction0.getAction();
                        if(s.equals("com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK") || s.equals("com.google.android.gms.cast.framework.action.SKIP_NEXT") || s.equals("com.google.android.gms.cast.framework.action.SKIP_PREV") || s.equals("com.google.android.gms.cast.framework.action.FORWARD") || s.equals("com.google.android.gms.cast.framework.action.REWIND") || s.equals("com.google.android.gms.cast.framework.action.STOP_CASTING") || s.equals("com.google.android.gms.cast.framework.action.DISCONNECT")) {
                            m0 = this.zzf(notificationAction0.getAction());
                        }
                        else {
                            Intent intent2 = new Intent(notificationAction0.getAction());
                            intent2.setComponent(this.zzg);
                            m0 = new l(notificationAction0.getIconResId(), notificationAction0.getContentDescription(), PendingIntent.getBroadcast(context0, 0, intent2, zzeo.zza)).a();
                        }
                        if(m0 != null) {
                            this.zzi.add(m0);
                        }
                    }
                }
            }
            for(Object object2: this.zzi) {
                m m2 = (m)object2;
                if(m2 != null) {
                    notificationCompat$Builder0.b.add(m2);
                }
            }
            c c0 = new c();
            int[] arr_v2 = this.zzj;
            if(arr_v2 != null) {
                c0.d = arr_v2;
            }
            Token mediaSessionCompat$Token0 = this.zzo.zza;
            if(mediaSessionCompat$Token0 != null) {
                c0.e = mediaSessionCompat$Token0;
            }
            notificationCompat$Builder0.g(c0);
            Notification notification0 = notificationCompat$Builder0.a();
            this.zzq = notification0;
            notificationManager0.notify("castMediaNotification", 1, notification0);
        }
    }
}

