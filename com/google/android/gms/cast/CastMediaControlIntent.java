package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.CastUtils;
import java.util.Collection;
import java.util.Locale;

public final class CastMediaControlIntent {
    public static final String ACTION_SYNC_STATUS = "com.google.android.gms.cast.ACTION_SYNC_STATUS";
    public static final String DEFAULT_MEDIA_RECEIVER_APPLICATION_ID = "CC1AD845";
    public static final int ERROR_CODE_REQUEST_FAILED = 1;
    public static final int ERROR_CODE_SESSION_START_FAILED = 2;
    public static final int ERROR_CODE_TEMPORARILY_DISCONNECTED = 3;
    public static final String EXTRA_CAST_APPLICATION_ID = "com.google.android.gms.cast.EXTRA_CAST_APPLICATION_ID";
    public static final String EXTRA_CAST_LANGUAGE_CODE = "com.google.android.gms.cast.EXTRA_CAST_LANGUAGE_CODE";
    public static final String EXTRA_CAST_RELAUNCH_APPLICATION = "com.google.android.gms.cast.EXTRA_CAST_RELAUNCH_APPLICATION";
    public static final String EXTRA_CAST_STOP_APPLICATION_WHEN_SESSION_ENDS = "com.google.android.gms.cast.EXTRA_CAST_STOP_APPLICATION_WHEN_SESSION_ENDS";
    public static final String EXTRA_CUSTOM_DATA = "com.google.android.gms.cast.EXTRA_CUSTOM_DATA";
    public static final String EXTRA_DEBUG_LOGGING_ENABLED = "com.google.android.gms.cast.EXTRA_DEBUG_LOGGING_ENABLED";
    public static final String EXTRA_ERROR_CODE = "com.google.android.gms.cast.EXTRA_ERROR_CODE";

    public static String categoryForCast(String s) [...] // 潜在的解密器

    public static String categoryForCast(String s, Collection collection0) {
        if(s == null) {
            throw new IllegalArgumentException("applicationId cannot be null");
        }
        if(collection0 == null) {
            throw new IllegalArgumentException("namespaces cannot be null");
        }
        zzt zzt0 = new zzt(null);
        zzt.zza(zzt0, s);
        zzt.zzc(zzt0, collection0);
        return zzu.zza(zzt.zzd(zzt0));
    }

    public static String categoryForCast(Collection collection0) {
        if(collection0 == null) {
            throw new IllegalArgumentException("namespaces cannot be null");
        }
        zzt zzt0 = new zzt(null);
        zzt.zzc(zzt0, collection0);
        return zzu.zza(zzt.zzd(zzt0));
    }

    public static String categoryForRemotePlayback() {
        zzt.zzb(new zzt(null), "com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK");
        return "com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK////ALLOW_IPV6";
    }

    public static String categoryForRemotePlayback(String s) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("applicationId cannot be null or empty");
        }
        zzt zzt0 = new zzt(null);
        zzt.zzb(zzt0, "com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK");
        zzt.zza(zzt0, s);
        return zzu.zza(zzt.zzd(zzt0));
    }

    public static String languageTagForLocale(Locale locale0) {
        return CastUtils.zzb(locale0);
    }
}

