package com.iloen.melon.utils.system;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat.Builder;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.log.LogU;

public class NotificationHelper {
    public static class NotificationInfo {
        public boolean hasLargeIcon;
        public Notification notif;

    }

    public interface NotificationUpdateListener {
        void onUpdate(Notification arg1);
    }

    public final NotificationManager a;
    protected Context mContext;
    protected int mLargeIconHeight;
    protected int mLargeIconWidth;

    public NotificationHelper(Context context0) {
        this.mContext = context0.getApplicationContext();
        this.a = (NotificationManager)context0.getSystemService("notification");
        Resources resources0 = context0.getResources();
        this.mLargeIconWidth = resources0.getDimensionPixelSize(0x7F0703FA);  // dimen:notification_large_icon_width
        this.mLargeIconHeight = resources0.getDimensionPixelSize(0x7F0703F9);  // dimen:notification_large_icon_height
    }

    public void cancel(int v) {
        LogU.d("NotificationHelper", "cancel");
        this.a.cancel(v);
    }

    public void clearPlayDebugNotification() {
    }

    public void debugMessage(int v, String s, String s1) {
        this.makeChannelId(1, "1", "디버그", Boolean.FALSE);
        Intent intent0 = new Intent("com.iloen.melon.intent.action.MAIN");
        intent0.addFlags(0x10000000);
        PendingIntent pendingIntent0 = PendingIntent.getActivity(this.mContext, 0, intent0, 0x4000000);
        NotificationCompat.Builder notificationCompat$Builder0 = new NotificationCompat.Builder(this.mContext, "1");
        notificationCompat$Builder0.e = NotificationCompat.Builder.b(s);
        notificationCompat$Builder0.f = NotificationCompat.Builder.b(s1);
        notificationCompat$Builder0.G.icon = 0x7F08060A;  // drawable:icon_noti
        notificationCompat$Builder0.h(s1);
        notificationCompat$Builder0.G.when = System.currentTimeMillis();
        notificationCompat$Builder0.g = pendingIntent0;
        Notification notification0 = notificationCompat$Builder0.a();
        this.a.notify(v, notification0);
    }

    public void debugMessage(String s, String s1) {
        Intent intent0 = new Intent("com.iloen.melon.intent.action.MAIN");
        intent0.addFlags(0x10000000);
        PendingIntent pendingIntent0 = PendingIntent.getActivity(this.mContext, 0, intent0, 0x4000000);
        NotificationCompat.Builder notificationCompat$Builder0 = new NotificationCompat.Builder(this.mContext);
        notificationCompat$Builder0.e = NotificationCompat.Builder.b(s);
        notificationCompat$Builder0.f = NotificationCompat.Builder.b(s1);
        notificationCompat$Builder0.G.icon = 0x7F08060A;  // drawable:icon_noti
        notificationCompat$Builder0.h(s1);
        notificationCompat$Builder0.G.when = System.currentTimeMillis();
        notificationCompat$Builder0.g = pendingIntent0;
        notificationCompat$Builder0.e(16, true);
        Notification notification0 = notificationCompat$Builder0.a();
        this.a.notify(1, notification0);
    }

    public void debugServiceShow(Class class0, CharSequence charSequence0) {
        LogU.d("NotificationHelper", "debugServiceShow");
    }

    public void debugServiceStart(Class class0) {
        LogU.d("NotificationHelper", "debugServiceStart");
        this.debugServiceShow(class0, class0.getSimpleName() + " started");
    }

    public void debugServiceStop(Class class0) {
        LogU.d("NotificationHelper", "debugServiceStop");
    }

    public void deleteChannel(String s) {
        NotificationManager notificationManager0 = this.a;
        if(notificationManager0.getNotificationChannel(s) != null) {
            notificationManager0.deleteNotificationChannel(s);
        }
    }

    public Boolean hasNotification() {
        StatusBarNotification[] arr_statusBarNotification = ((NotificationManager)this.mContext.getSystemService("notification")).getActiveNotifications();
        if(arr_statusBarNotification != null && arr_statusBarNotification.length > 0) {
            for(int v = 0; v < arr_statusBarNotification.length; ++v) {
                if(arr_statusBarNotification[v].getId() == 101) {
                    return true;
                }
            }
        }
        return false;
    }

    public void makeChannelId(int v, String s, String s1, Boolean boolean0) {
        NotificationManager notificationManager0 = this.a;
        NotificationChannel notificationChannel0 = notificationManager0.getNotificationChannel(s);
        if(notificationChannel0 == null) {
            NotificationChannel notificationChannel1 = new NotificationChannel(s, s1, v);
            notificationChannel1.enableLights(false);
            notificationChannel1.enableVibration(false);
            notificationChannel1.setShowBadge(boolean0.booleanValue());
            if("101".equals(s)) {
                notificationChannel1.setLockscreenVisibility(1);
            }
            notificationManager0.createNotificationChannel(notificationChannel1);
            return;
        }
        if(!notificationChannel0.canShowBadge() && boolean0.booleanValue()) {
            this.deleteChannel(s);
            this.makeChannelId(v, s, s1, Boolean.TRUE);
        }
    }

    public void notifyNotification(int v, Notification notification0) {
        LogU.d("NotificationHelper", "notify");
        this.a.notify(v, notification0);
    }

    public void showPlayDebugNotification(Playable playable0, String s) {
    }
}

