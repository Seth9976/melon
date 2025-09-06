package com.google.android.exoplayer2.util;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SuppressLint({"InlinedApi"})
public final class NotificationUtil {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Importance {
    }

    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;

    @Deprecated
    public static void createNotificationChannel(Context context0, String s, int v, int v1) {
        NotificationUtil.createNotificationChannel(context0, s, v, 0, v1);
    }

    public static void createNotificationChannel(Context context0, String s, int v, int v1, int v2) {
        if(Util.SDK_INT >= 26) {
            NotificationManager notificationManager0 = (NotificationManager)context0.getSystemService("notification");
            NotificationChannel notificationChannel0 = new NotificationChannel(s, context0.getString(v), v2);
            if(v1 != 0) {
                notificationChannel0.setDescription(context0.getString(v1));
            }
            notificationManager0.createNotificationChannel(notificationChannel0);
        }
    }

    public static void setNotification(Context context0, int v, Notification notification0) {
        NotificationManager notificationManager0 = (NotificationManager)context0.getSystemService("notification");
        if(notification0 != null) {
            notificationManager0.notify(v, notification0);
            return;
        }
        notificationManager0.cancel(v);
    }
}

