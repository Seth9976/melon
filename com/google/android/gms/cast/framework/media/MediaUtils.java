package com.google.android.gms.cast.framework.media;

import android.annotation.TargetApi;
import android.net.Uri;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaTrack;
import com.google.android.gms.common.images.WebImage;
import java.util.Locale;

public class MediaUtils {
    public static Uri getImageUri(MediaInfo mediaInfo0, int v) {
        if(mediaInfo0 != null) {
            MediaMetadata mediaMetadata0 = mediaInfo0.getMetadata();
            return mediaMetadata0 == null || mediaMetadata0.getImages() == null || mediaMetadata0.getImages().size() <= v ? null : ((WebImage)mediaMetadata0.getImages().get(v)).getUrl();
        }
        return null;
    }

    public static String getImageUrl(MediaInfo mediaInfo0, int v) {
        Uri uri0 = MediaUtils.getImageUri(mediaInfo0, v);
        return uri0 == null ? null : uri0.toString();
    }

    @TargetApi(21)
    @Deprecated
    public static Locale getTrackLanguage(MediaTrack mediaTrack0) {
        String s = mediaTrack0.getLanguage();
        return s == null ? null : Locale.forLanguageTag(s);
    }
}

