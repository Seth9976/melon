package com.google.android.gms.cast.framework.media.internal;

import android.os.RemoteException;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.zzg;
import com.google.android.gms.cast.internal.Logger;
import java.util.List;

public final class zzv {
    private static final Logger zza;

    static {
        zzv.zza = new Logger("MediaSessionUtils");
    }

    public static int zza(NotificationOptions notificationOptions0, long v) {
        int v1 = notificationOptions0.getForwardDrawableResId();
        if(Long.compare(v, 10000L) == 0) {
            return notificationOptions0.getForward10DrawableResId();
        }
        return v == 30000L ? notificationOptions0.getForward30DrawableResId() : v1;
    }

    public static int zzb(NotificationOptions notificationOptions0, long v) {
        int v1 = notificationOptions0.zzd();
        if(Long.compare(v, 10000L) == 0) {
            return notificationOptions0.zzb();
        }
        return v == 30000L ? notificationOptions0.zzc() : v1;
    }

    public static int zzc(NotificationOptions notificationOptions0, long v) {
        int v1 = notificationOptions0.getRewindDrawableResId();
        if(Long.compare(v, 10000L) == 0) {
            return notificationOptions0.getRewind10DrawableResId();
        }
        return v == 30000L ? notificationOptions0.getRewind30DrawableResId() : v1;
    }

    public static int zzd(NotificationOptions notificationOptions0, long v) {
        int v1 = notificationOptions0.zzj();
        if(Long.compare(v, 10000L) == 0) {
            return notificationOptions0.zzh();
        }
        return v == 30000L ? notificationOptions0.zzi() : v1;
    }

    public static String zze(MediaMetadata mediaMetadata0) {
        if(!mediaMetadata0.containsKey("com.google.android.gms.cast.metadata.SUBTITLE")) {
            switch(mediaMetadata0.getMediaType()) {
                case 1: {
                    return mediaMetadata0.getString("com.google.android.gms.cast.metadata.STUDIO");
                }
                case 2: {
                    return mediaMetadata0.getString("com.google.android.gms.cast.metadata.SERIES_TITLE");
                }
                case 3: {
                    if(!mediaMetadata0.containsKey("com.google.android.gms.cast.metadata.ARTIST")) {
                        if(mediaMetadata0.containsKey("com.google.android.gms.cast.metadata.ALBUM_ARTIST")) {
                            return mediaMetadata0.getString("com.google.android.gms.cast.metadata.ALBUM_ARTIST");
                        }
                        return mediaMetadata0.containsKey("com.google.android.gms.cast.metadata.COMPOSER") ? mediaMetadata0.getString("com.google.android.gms.cast.metadata.COMPOSER") : mediaMetadata0.getString("com.google.android.gms.cast.metadata.SUBTITLE");
                    }
                    break;
                }
                case 4: {
                    break;
                }
                default: {
                    return mediaMetadata0.getString("com.google.android.gms.cast.metadata.SUBTITLE");
                }
            }
            return mediaMetadata0.getString("com.google.android.gms.cast.metadata.ARTIST");
        }
        return mediaMetadata0.getString("com.google.android.gms.cast.metadata.SUBTITLE");
    }

    public static List zzf(zzg zzg0) {
        try {
            return zzg0.zzf();
        }
        catch(RemoteException remoteException0) {
            zzv.zza.e(remoteException0, "Unable to call %s on %s.", new Object[]{"getNotificationActions", "zzg"});
            return null;
        }
    }

    public static int[] zzg(zzg zzg0) {
        try {
            return zzg0.zzg();
        }
        catch(RemoteException remoteException0) {
            zzv.zza.e(remoteException0, "Unable to call %s on %s.", new Object[]{"getCompactViewActionIndices", "zzg"});
            return null;
        }
    }
}

