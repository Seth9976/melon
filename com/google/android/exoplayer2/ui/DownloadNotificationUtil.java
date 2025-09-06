package com.google.android.exoplayer2.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import java.util.List;

@Deprecated
public final class DownloadNotificationUtil {
    public static Notification buildDownloadCompletedNotification(Context context0, int v, String s, PendingIntent pendingIntent0, String s1) {
        return new DownloadNotificationHelper(context0, s).buildDownloadCompletedNotification(v, pendingIntent0, s1);
    }

    public static Notification buildDownloadFailedNotification(Context context0, int v, String s, PendingIntent pendingIntent0, String s1) {
        return new DownloadNotificationHelper(context0, s).buildDownloadFailedNotification(v, pendingIntent0, s1);
    }

    public static Notification buildProgressNotification(Context context0, int v, String s, PendingIntent pendingIntent0, String s1, List list0) {
        return new DownloadNotificationHelper(context0, s).buildProgressNotification(v, pendingIntent0, s1, list0);
    }
}

