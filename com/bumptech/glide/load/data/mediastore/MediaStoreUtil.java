package com.bumptech.glide.load.data.mediastore;

import android.net.Uri;

public final class MediaStoreUtil {
    private static final int MINI_THUMB_HEIGHT = 0x180;
    private static final int MINI_THUMB_WIDTH = 0x200;

    // 去混淆评级： 低(20)
    public static boolean isAndroidPickerUri(Uri uri0) {
        return MediaStoreUtil.isMediaStoreUri(uri0) && uri0.getPathSegments().contains("picker");
    }

    // 去混淆评级： 低(20)
    public static boolean isMediaStoreImageUri(Uri uri0) {
        return MediaStoreUtil.isMediaStoreUri(uri0) && !MediaStoreUtil.isVideoUri(uri0);
    }

    // 去混淆评级： 低(20)
    public static boolean isMediaStoreUri(Uri uri0) {
        return uri0 != null && "content".equals(uri0.getScheme()) && "media".equals(uri0.getAuthority());
    }

    // 去混淆评级： 低(20)
    public static boolean isMediaStoreVideoUri(Uri uri0) {
        return MediaStoreUtil.isMediaStoreUri(uri0) && MediaStoreUtil.isVideoUri(uri0);
    }

    public static boolean isThumbnailSize(int v, int v1) {
        return v != 0x80000000 && v1 != 0x80000000 && v <= 0x200 && v1 <= 0x180;
    }

    private static boolean isVideoUri(Uri uri0) {
        return uri0.getPathSegments().contains("video");
    }
}

