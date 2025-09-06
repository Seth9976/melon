package com.facebook.gamingservices.cloudgaming;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.GraphRequest.Callback;
import com.facebook.gamingservices.internal.GamingMediaUploader;
import java.io.File;
import k8.Y;

public abstract class AppToUserNotificationSender {
    private static Bundle getParameters() {
        return Y.b("upload_source", "A2U");
    }

    public static void scheduleAppToUserNotification(String s, String s1, Bitmap bitmap0, int v, String s2, Callback graphRequest$Callback0) {
        MediaUploadCallback mediaUploadCallback0 = new MediaUploadCallback(s, s1, v, s2, graphRequest$Callback0);
        GamingMediaUploader.uploadToGamingServices("A2U Image", bitmap0, AppToUserNotificationSender.getParameters(), mediaUploadCallback0);
    }

    public static void scheduleAppToUserNotification(String s, String s1, Uri uri0, int v, String s2, Callback graphRequest$Callback0) {
        MediaUploadCallback mediaUploadCallback0 = new MediaUploadCallback(s, s1, v, s2, graphRequest$Callback0);
        GamingMediaUploader.uploadToGamingServices("A2U Image", uri0, AppToUserNotificationSender.getParameters(), mediaUploadCallback0);
    }

    public static void scheduleAppToUserNotification(String s, String s1, File file0, int v, String s2, Callback graphRequest$Callback0) {
        MediaUploadCallback mediaUploadCallback0 = new MediaUploadCallback(s, s1, v, s2, graphRequest$Callback0);
        GamingMediaUploader.uploadToGamingServices("A2U Image", file0, AppToUserNotificationSender.getParameters(), mediaUploadCallback0);
    }
}

