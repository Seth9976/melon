package com.google.android.exoplayer2.ui;

import N1.q;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import androidx.core.app.NotificationCompat.Builder;
import com.google.android.exoplayer2.offline.Download;
import java.util.List;

public final class DownloadNotificationHelper {
    private static final int NULL_STRING_ID;
    private final Context context;
    private final NotificationCompat.Builder notificationBuilder;

    public DownloadNotificationHelper(Context context0, String s) {
        Context context1 = context0.getApplicationContext();
        this.context = context1;
        this.notificationBuilder = new NotificationCompat.Builder(context1, s);
    }

    public Notification buildDownloadCompletedNotification(int v, PendingIntent pendingIntent0, String s) {
        return this.buildEndStateNotification(v, pendingIntent0, s, string.exo_download_completed);
    }

    public Notification buildDownloadFailedNotification(int v, PendingIntent pendingIntent0, String s) {
        return this.buildEndStateNotification(v, pendingIntent0, s, string.exo_download_failed);
    }

    private Notification buildEndStateNotification(int v, PendingIntent pendingIntent0, String s, int v1) {
        return this.buildNotification(v, pendingIntent0, s, v1, 0, 0, false, false, true);
    }

    private Notification buildNotification(int v, PendingIntent pendingIntent0, String s, int v1, int v2, int v3, boolean z, boolean z1, boolean z2) {
        this.notificationBuilder.G.icon = v;
        q q0 = null;
        String s1 = v1 == 0 ? null : this.context.getResources().getString(v1);
        this.notificationBuilder.d(s1);
        NotificationCompat.Builder notificationCompat$Builder0 = this.notificationBuilder;
        notificationCompat$Builder0.g = pendingIntent0;
        if(s != null) {
            q0 = new q(0);
            q0.e = NotificationCompat.Builder.b(s);
        }
        notificationCompat$Builder0.g(q0);
        this.notificationBuilder.o = v2;
        this.notificationBuilder.p = v3;
        this.notificationBuilder.q = z;
        this.notificationBuilder.e(2, z1);
        this.notificationBuilder.k = z2;
        return this.notificationBuilder.a();
    }

    public Notification buildProgressNotification(int v, PendingIntent pendingIntent0, String s, List list0) {
        int v5;
        float f = 0.0f;
        boolean z = false;
        boolean z1 = false;
        boolean z2 = false;
        int v2 = 0;
        int v3 = 0;
        boolean z3 = true;
        for(int v1 = 0; v1 < list0.size(); ++v1) {
            Download download0 = (Download)list0.get(v1);
            int v4 = download0.state;
            if(v4 == 5) {
                z2 = true;
            }
            else if(v4 == 2 || v4 == 7) {
                float f1 = download0.getPercentDownloaded();
                if(f1 != -1.0f) {
                    f += f1;
                    z3 = false;
                }
                v3 |= (download0.getBytesDownloaded() <= 0L ? 0 : 1);
                ++v2;
                z1 = true;
            }
        }
        if(z1) {
            v5 = string.exo_download_downloading;
        }
        else {
            v5 = z2 ? string.exo_download_removing : 0;
        }
        if(z1) {
            if(z3 && v3 != 0) {
                z = true;
            }
            return this.buildNotification(v, pendingIntent0, s, v5, 100, ((int)(f / ((float)v2))), z, true, false);
        }
        return this.buildNotification(v, pendingIntent0, s, v5, 100, 0, true, true, false);
    }
}

