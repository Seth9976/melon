package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.util.List;

public class ResourceDrawableDecoder implements ResourceDecoder {
    private static final String ANDROID_PACKAGE_NAME = "android";
    private static final int ID_PATH_SEGMENTS = 1;
    private static final int MISSING_RESOURCE_ID = 0;
    private static final int NAME_PATH_SEGMENT_INDEX = 1;
    private static final int NAME_URI_PATH_SEGMENTS = 2;
    private static final int RESOURCE_ID_SEGMENT_INDEX;
    public static final Option THEME;
    private static final int TYPE_PATH_SEGMENT_INDEX;
    private final Context context;

    static {
        ResourceDrawableDecoder.THEME = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.Theme");
    }

    public ResourceDrawableDecoder(Context context0) {
        this.context = context0.getApplicationContext();
    }

    public Resource decode(Uri uri0, int v, int v1, Options options0) {
        String s = uri0.getAuthority();
        if(TextUtils.isEmpty(s)) {
            throw new IllegalStateException("Package name for " + uri0 + " is null or empty");
        }
        Context context0 = this.findContextForPackage(uri0, s);
        int v2 = this.findResourceIdFromUri(context0, uri0);
        Resources.Theme resources$Theme0 = ((String)Preconditions.checkNotNull(s)).equals("com.iloen.melon") ? ((Resources.Theme)options0.get(ResourceDrawableDecoder.THEME)) : null;
        return resources$Theme0 == null ? NonOwnedDrawableResource.newInstance(DrawableDecoderCompat.getDrawable(this.context, context0, v2)) : NonOwnedDrawableResource.newInstance(DrawableDecoderCompat.getDrawable(this.context, v2, resources$Theme0));
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        return this.decode(((Uri)object0), v, v1, options0);
    }

    private Context findContextForPackage(Uri uri0, String s) {
        if(s.equals("com.iloen.melon")) {
            return this.context;
        }
        try {
            return this.context.createPackageContext(s, 0);
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            if(!s.contains("com.iloen.melon")) {
                throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri0, packageManager$NameNotFoundException0);
            }
            return this.context;
        }
    }

    private int findResourceIdFromResourceIdUri(Uri uri0) {
        List list0 = uri0.getPathSegments();
        try {
            return Integer.parseInt(((String)list0.get(0)));
        }
        catch(NumberFormatException numberFormatException0) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri0, numberFormatException0);
        }
    }

    private int findResourceIdFromTypeAndNameResourceUri(Context context0, Uri uri0) {
        List list0 = uri0.getPathSegments();
        String s = uri0.getAuthority();
        String s1 = (String)list0.get(0);
        String s2 = (String)list0.get(1);
        int v = context0.getResources().getIdentifier(s2, s1, s);
        if(v == 0) {
            v = Resources.getSystem().getIdentifier(s2, s1, "android");
        }
        if(v == 0) {
            throw new IllegalArgumentException("Failed to find resource id for: " + uri0);
        }
        return v;
    }

    private int findResourceIdFromUri(Context context0, Uri uri0) {
        List list0 = uri0.getPathSegments();
        if(list0.size() == 2) {
            return this.findResourceIdFromTypeAndNameResourceUri(context0, uri0);
        }
        if(list0.size() != 1) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri0);
        }
        return this.findResourceIdFromResourceIdUri(uri0);
    }

    public boolean handles(Uri uri0, Options options0) {
        String s = uri0.getScheme();
        return s != null && s.equals("android.resource");
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.handles(((Uri)object0), options0);
    }
}

