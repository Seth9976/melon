package com.facebook.gamingservices;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.AccessToken;
import com.facebook.GraphRequest.Callback;
import com.facebook.GraphRequest;
import java.io.File;

public class GamingImageUploader {
    private Context context;
    private static final String photoUploadEdge = "me/photos";

    public GamingImageUploader(Context context0) {
        this.context = context0;
    }

    public void uploadToMediaLibrary(String s, Bitmap bitmap0, boolean z) {
        this.uploadToMediaLibrary(s, bitmap0, z, null);
    }

    public void uploadToMediaLibrary(String s, Bitmap bitmap0, boolean z, Callback graphRequest$Callback0) {
        AccessToken accessToken0 = AccessToken.getCurrentAccessToken();
        Callback graphRequest$Callback1 = z ? new OpenGamingMediaDialog(this.context, graphRequest$Callback0) : graphRequest$Callback0;
        GraphRequest.newUploadPhotoRequest(accessToken0, "me/photos", bitmap0, s, null, graphRequest$Callback1).executeAsync();
    }

    public void uploadToMediaLibrary(String s, Uri uri0, boolean z) {
        this.uploadToMediaLibrary(s, uri0, z, null);
    }

    public void uploadToMediaLibrary(String s, Uri uri0, boolean z, Callback graphRequest$Callback0) {
        AccessToken accessToken0 = AccessToken.getCurrentAccessToken();
        Callback graphRequest$Callback1 = z ? new OpenGamingMediaDialog(this.context, graphRequest$Callback0) : graphRequest$Callback0;
        GraphRequest.newUploadPhotoRequest(accessToken0, "me/photos", uri0, s, null, graphRequest$Callback1).executeAsync();
    }

    public void uploadToMediaLibrary(String s, File file0, boolean z) {
        this.uploadToMediaLibrary(s, file0, z, null);
    }

    public void uploadToMediaLibrary(String s, File file0, boolean z, Callback graphRequest$Callback0) {
        AccessToken accessToken0 = AccessToken.getCurrentAccessToken();
        Callback graphRequest$Callback1 = z ? new OpenGamingMediaDialog(this.context, graphRequest$Callback0) : graphRequest$Callback0;
        GraphRequest.newUploadPhotoRequest(accessToken0, "me/photos", file0, s, null, graphRequest$Callback1).executeAsync();
    }
}

