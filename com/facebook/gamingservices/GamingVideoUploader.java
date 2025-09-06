package com.facebook.gamingservices;

import android.content.Context;
import android.net.Uri;
import com.facebook.GraphRequest.OnProgressCallback;
import com.facebook.share.internal.VideoUploader;
import com.facebook.share.model.ShareVideo.Builder;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;

public class GamingVideoUploader {
    private Context context;

    public GamingVideoUploader(Context context0) {
        this.context = context0;
    }

    public void uploadToMediaLibrary(String s, Uri uri0) {
        this.uploadToMediaLibrary(s, uri0, null);
    }

    public void uploadToMediaLibrary(String s, Uri uri0, OnProgressCallback graphRequest$OnProgressCallback0) {
        this.uploadToMediaLibrary(s, uri0, false, graphRequest$OnProgressCallback0);
    }

    public void uploadToMediaLibrary(String s, Uri uri0, boolean z, OnProgressCallback graphRequest$OnProgressCallback0) {
        ShareVideo shareVideo0 = new Builder().setLocalUrl(uri0).build();
        ShareVideoContent shareVideoContent0 = new com.facebook.share.model.ShareVideoContent.Builder().setVideo(shareVideo0).setContentDescription(s).build();
        if(z) {
            graphRequest$OnProgressCallback0 = new OpenGamingMediaDialog(this.context, graphRequest$OnProgressCallback0);
        }
        VideoUploader.uploadAsyncWithProgressCallback(shareVideoContent0, graphRequest$OnProgressCallback0);
    }
}

