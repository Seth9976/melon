package o8;

import N1.l;
import N1.m;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.NotificationCompat.Builder;
import com.iloen.melon.playback.voicealarm.AlarmPlayService;
import kotlin.jvm.internal.q;

public final class a {
    public final Context a;
    public final NotificationManager b;

    public a(AlarmPlayService alarmPlayService0) {
        this.a = alarmPlayService0;
        Object object0 = alarmPlayService0.getSystemService("notification");
        this.b = object0 instanceof NotificationManager ? ((NotificationManager)object0) : null;
    }

    public final Notification a(String s) {
        q.g(s, "content");
        NotificationManager notificationManager0 = this.b;
        if(notificationManager0 == null) {
            return null;
        }
        NotificationChannel notificationChannel0 = notificationManager0.getNotificationChannel("107");
        Context context0 = this.a;
        if(notificationChannel0 == null) {
            q.f("멜론 알람 시작", "getString(...)");
            notificationManager0.createNotificationChannel(new NotificationChannel("107", "멜론 알람 시작", 4));
        }
        Intent intent0 = new Intent();
        intent0.setAction("com.iloen.melon.intent.action.setting.alarm.list");
        intent0.addCategory("android.intent.category.DEFAULT");
        intent0.addFlags(0x10008000);
        PendingIntent pendingIntent0 = PendingIntent.getActivity(context0, 0, intent0, 0xC000000);
        Intent intent1 = new Intent(context0, AlarmPlayService.class);
        intent1.setAction("com.iloen.melon.intent.action.ALARM_STOP");
        PendingIntent pendingIntent1 = PendingIntent.getService(context0, 0, intent1, 0xC000000);
        m m0 = new l(null, "알람 중지", pendingIntent1, new Bundle()).a();
        NotificationCompat.Builder notificationCompat$Builder0 = new NotificationCompat.Builder(context0, "107");
        notificationCompat$Builder0.G.icon = 0x7F08060A;  // drawable:icon_noti
        notificationCompat$Builder0.e = NotificationCompat.Builder.b("보이스 알람 시작");
        notificationCompat$Builder0.f = NotificationCompat.Builder.b(s);
        notificationCompat$Builder0.h(s);
        notificationCompat$Builder0.x = "alarm";
        notificationCompat$Builder0.r = "com.iloen.melon.ALARM_GROUP_KEY";
        notificationCompat$Builder0.g = pendingIntent0;
        notificationCompat$Builder0.G.deleteIntent = pendingIntent1;
        notificationCompat$Builder0.e(2, true);
        notificationCompat$Builder0.b.add(m0);
        Notification notification0 = notificationCompat$Builder0.a();
        q.f(notification0, "build(...)");
        notificationManager0.notify(13001, notification0);
        return notification0;
    }
}

