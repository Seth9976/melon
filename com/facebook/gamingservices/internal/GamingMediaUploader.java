package com.facebook.gamingservices.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.HttpMethod;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@AutoHandleExceptions
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\u00042\u0006\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0007J.\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u000E\u001A\u00020\u000F2\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0007J.\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001A\u00020\u00112\b\u0010\n\u001A\u0004\u0018\u00010\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/gamingservices/internal/GamingMediaUploader;", "", "()V", "photoUploadEdge", "", "uploadToGamingServices", "Lcom/facebook/GraphRequestAsyncTask;", "caption", "imageBitmap", "Landroid/graphics/Bitmap;", "params", "Landroid/os/Bundle;", "callback", "Lcom/facebook/GraphRequest$Callback;", "imageUri", "Landroid/net/Uri;", "imageFile", "Ljava/io/File;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class GamingMediaUploader {
    @NotNull
    public static final GamingMediaUploader INSTANCE = null;
    @NotNull
    private static final String photoUploadEdge = "me/photos";

    static {
        GamingMediaUploader.INSTANCE = new GamingMediaUploader();
    }

    @NotNull
    public static final GraphRequestAsyncTask uploadToGamingServices(@Nullable String s, @NotNull Bitmap bitmap0, @Nullable Bundle bundle0, @Nullable Callback graphRequest$Callback0) {
        q.g(bitmap0, "imageBitmap");
        AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
        return GraphRequest.Companion.newUploadPhotoRequest(accessToken0, "me/photos", bitmap0, s, bundle0, graphRequest$Callback0).executeAsync();
    }

    @NotNull
    public static final GraphRequestAsyncTask uploadToGamingServices(@Nullable String s, @NotNull Uri uri0, @Nullable Bundle bundle0, @Nullable Callback graphRequest$Callback0) {
        q.g(uri0, "imageUri");
        if(Utility.isFileUri(uri0) || Utility.isContentUri(uri0)) {
            AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
            return GraphRequest.Companion.newUploadPhotoRequest(accessToken0, "me/photos", uri0, s, bundle0, graphRequest$Callback0).executeAsync();
        }
        Bundle bundle1 = new Bundle();
        if(bundle0 != null) {
            bundle1.putAll(bundle0);
        }
        bundle1.putString("url", uri0.toString());
        if(s != null && s.length() != 0) {
            bundle1.putString("caption", s);
        }
        return new GraphRequest(AccessToken.Companion.getCurrentAccessToken(), "me/photos", bundle1, HttpMethod.POST, graphRequest$Callback0, null, 0x20, null).executeAsync();
    }

    @NotNull
    public static final GraphRequestAsyncTask uploadToGamingServices(@Nullable String s, @NotNull File file0, @Nullable Bundle bundle0, @Nullable Callback graphRequest$Callback0) {
        q.g(file0, "imageFile");
        AccessToken accessToken0 = AccessToken.Companion.getCurrentAccessToken();
        return GraphRequest.Companion.newUploadPhotoRequest(accessToken0, "me/photos", file0, s, bundle0, graphRequest$Callback0).executeAsync();
    }
}

