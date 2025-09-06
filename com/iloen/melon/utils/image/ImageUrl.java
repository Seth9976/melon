package com.iloen.melon.utils.image;

import A8.M;
import android.content.ContentUris;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Video.Thumbnails;
import android.text.TextUtils;
import com.iloen.melon.premium.PremiumContentsEntity;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import i9.n;
import java.io.File;
import k9.i;

public class ImageUrl {
    public static final Uri a;
    public static final Uri b;

    static {
        ImageUrl.a = Uri.parse("content://media/external/audio/albumart");
        ImageUrl.b = n.b;
    }

    public static Uri a(MelonImageSource melonImageSource0, String s, String s1) {
        String s2;
        Uri uri0 = Uri.EMPTY;
        if(TextUtils.isEmpty(s)) {
            LogU.e("ImageUrl", "invalid albumId");
            return uri0;
        }
        if(MelonImageSource.INTERNAL.equals(melonImageSource0)) {
            long v = StringUtils.getLong(s);
            uri0 = ContentUris.withAppendedId(ImageUrl.a, v);
        }
        else if(MelonImageSource.MELONDCF.equals(melonImageSource0)) {
            long v1 = StringUtils.getLong(s);
            uri0 = ContentUris.withAppendedId(ImageUrl.b, v1);
        }
        else if(MelonImageSource.NETWORK.equals(melonImageSource0)) {
            if(s.length() < 8) {
                int v2 = s.length();
                s2 = s;
                for(int v3 = 0; v3 < 8 - v2; ++v3) {
                    s2 = "0" + s2;
                }
            }
            else {
                s2 = s;
            }
            uri0 = Uri.parse((M.r + "/" + s2.substring(0, 3) + "/" + s2.substring(3, 5) + "/" + s2.substring(5, 8) + "/" + s + s1));
        }
        else {
            LogU.e("ImageUrl", "Invalid album art source: " + melonImageSource0);
        }
        LogU.v("ImageUrl", "getAlbumImageUri - " + uri0);
        return uri0;
    }

    public static Uri getAlbumLargeUri(MelonImageSource melonImageSource0, String s) {
        return ImageUrl.a(melonImageSource0, s, "_500.jpg");
    }

    public static Uri getAlbumMediumUri(MelonImageSource melonImageSource0, String s) {
        return ImageUrl.a(melonImageSource0, s, ".jpg");
    }

    public static Uri getAlbumSmallUri(MelonImageSource melonImageSource0, String s) {
        return ImageUrl.a(melonImageSource0, s, "_th.jpg");
    }

    public static Uri getBestVideoThumbnailUri(long v, String s) {
        if(ImageUtils.b == null) {
            try {
                ImageUtils.b = Boolean.FALSE;
                MediaMetadataRetriever.class.getMethod("setDataSource", String.class);
                MediaMetadataRetriever.class.getMethod("getFrameAtTime", Long.TYPE);
                MediaMetadataRetriever.class.getMethod("release", null);
                ImageUtils.b = Boolean.TRUE;
            }
            catch(Exception exception0) {
                LogU.w("ImageUtils", exception0.toString());
            }
            LogU.i("ImageUtils", "isMediaMetadataRetrieverSupported:" + ImageUtils.b);
        }
        if(ImageUtils.b.booleanValue()) {
            return Uri.parse(s);
        }
        return Environment.getExternalStorageState() == "mounted" ? ContentUris.withAppendedId(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, v) : ContentUris.withAppendedId(MediaStore.Video.Thumbnails.INTERNAL_CONTENT_URI, v);
    }

    public static String getOfflineImagePath(MelonImageFetcherType melonImageFetcherType0, PremiumContentsEntity premiumContentsEntity0) {
        String s = premiumContentsEntity0.l;
        String s1 = premiumContentsEntity0.k;
        LogU.d("ImageUrl", "getOfflineImagePath() albumImgLarge: " + s + ", albumImgThumb: " + s1);
        return !MelonImageFetcherType.Small.equals(melonImageFetcherType0) || TextUtils.isEmpty(s1) ? s : s1;
    }

    public static Uri getOfflinePlaylistImagePath(String s) {
        String s1 = i.d(new String[]{s});
        File file0 = TextUtils.isEmpty(s1) ? null : new File(i.c(2), s1);
        return file0.exists() ? Uri.fromFile(file0) : Uri.EMPTY;
    }
}

