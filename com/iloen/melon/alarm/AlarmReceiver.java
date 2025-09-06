package com.iloen.melon.alarm;

import Db.i;
import E9.w;
import Nc.f;
import Qb.z;
import Tf.o;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.PowerManager.WakeLock;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat.Builder;
import androidx.media3.session.legacy.V;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.playback.ServiceUtilKt;
import com.iloen.melon.playback.voicealarm.AlarmPlayService;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MusicAlarmPrefsHelper;
import com.iloen.melon.utils.system.ToastManager;
import d5.t;
import java.util.ArrayList;
import java.util.Calendar;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import ld.j;
import o8.c;
import o8.d;
import o8.e;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/alarm/AlarmReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AlarmReceiver extends BroadcastReceiver {
    public static final int a;

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        q.g(context0, "context");
        if(intent0 != null) {
            String s = intent0.getAction();
            if(s != null) {
                Companion logU$Companion0 = LogU.Companion;
                logU$Companion0.d("AlarmReceiver", " onReceive() >> [2025년 09월 06일 11:27:01] action: " + s);
                PendingIntent pendingIntent0 = null;
                if("com.iloen.melon.intent.action.PLAYBACK_STOP_TIMER".equals(s)) {
                    long v = MelonSettingInfo.getMelonTimer();
                    if(v > Calendar.getInstance().getTimeInMillis()) {
                        logU$Companion0.d("AlarmReceiver", "onReceive() trigger at early time.");
                        if(TextUtils.isEmpty("com.iloen.melon.intent.action.PLAYBACK_STOP_TIMER")) {
                            logU$Companion0.w("AlarmTrigger", "getPendingBroadcastIntent() invalid parameter.");
                        }
                        else {
                            Intent intent1 = new Intent(context0, AlarmReceiver.class);
                            intent1.setAction("com.iloen.melon.intent.action.PLAYBACK_STOP_TIMER");
                            pendingIntent0 = PendingIntent.getBroadcast(context0, 0, intent1, 0x1C000000);
                            q.f(pendingIntent0, "getBroadcast(...)");
                        }
                        c.a(context0, pendingIntent0);
                        c.e(context0, pendingIntent0, v);
                        return;
                    }
                    j j0 = new j(6);
                    Context context1 = context0.getApplicationContext();
                    q.f(context1, "getApplicationContext(...)");
                    V v1 = new V(context1, "From Alarm");
                    i.a(((i)v1.b), null, new f(v1, 8), 3);
                    z z0 = (z)v1.c;
                    z0.o(true);
                    z0.a(new Dc.i(12, j0, z0));
                    return;
                }
                if(o.v0(s, "com.iloen.melon.intent.action.AUTO_PLAY_TIMER", false)) {
                    int v2 = intent0.getIntExtra("id", 0);
                    if(v2 != 0) {
                        MusicAlarmPrefsHelper musicAlarmPrefsHelper0 = MusicAlarmPrefsHelper.INSTANCE;
                        d d0 = musicAlarmPrefsHelper0.getAlarm(v2);
                        if(d0 != null) {
                            com.iloen.melon.utils.log.DevLog.Companion devLog$Companion0 = DevLog.Companion;
                            devLog$Companion0.get("AutoPlay").put("AlarmReceiver.onAutoPlayAlarmProc() musicAlarm : " + d0);
                            if(d0.e && !d0.h) {
                                c.f(e.d(d0), d0.a, false);
                            }
                            if(d0.e) {
                                boolean[] arr_z = d0.f;
                                if(arr_z[Calendar.getInstance().get(7) - 1]) {
                                    Calendar calendar0 = Calendar.getInstance();
                                    calendar0.set(11, d0.b);
                                    calendar0.set(12, d0.c);
                                    if(Math.abs(calendar0.getTimeInMillis() - System.currentTimeMillis()) < 60000L) {
                                        devLog$Companion0.get("AutoPlay").put("AlarmReceiver.onAutoPlayAlarmProc() musicAlarm : " + e.f(d0));
                                        if(t.h == null) {
                                            PowerManager powerManager0 = (PowerManager)context0.getSystemService("power");
                                            if(powerManager0 != null && !powerManager0.isScreenOn()) {
                                                PowerManager.WakeLock powerManager$WakeLock0 = powerManager0.newWakeLock(0x3000001A, "melonapp:AutoPlayWakeLock");
                                                t.h = powerManager$WakeLock0;
                                                powerManager$WakeLock0.acquire(10000L);
                                            }
                                        }
                                        AudioManager audioManager0 = (AudioManager)context0.getSystemService("audio");
                                        if(audioManager0 == null) {
                                            logU$Companion0.d("AlarmTrigger", "startAutoPlayMusic am is not available");
                                        }
                                        else {
                                            audioManager0.setStreamVolume(3, d0.d, 0);
                                            Y.t("startAutoPlayMusic = ", audioManager0.getStreamVolume(3), logU$Companion0, "AlarmTrigger");
                                        }
                                        logU$Companion0.d("AlarmTrigger", "startMusicAlarm " + d0);
                                        int v3 = d0.i;
                                        if(v3 == 2 && d0.m != null) {
                                            Intent intent2 = new Intent(Y.a(MelonAppBase.Companion), AlarmPlayService.class).putExtra("com.iloen.melon.intent.extra.musicalarm", d0.a());
                                            q.f(intent2, "putExtra(...)");
                                            ServiceUtilKt.startForegroundServiceWithLog(context0, intent2, "AlarmTrigger.startMusicAlarm() - voiceAlarm");
                                        }
                                        else if(v3 != 1 || (d0.g == null || d0.g.length() == 0) || (d0.j == null || d0.j.length() == 0) || (d0.k == null || d0.k.length() == 0)) {
                                            ServiceUtilKt.startForegroundServiceWithLog(context0, w.u("com.iloen.melon.intent.action.playservice.autoplay"), "AlarmTrigger.startMusicAlarm() - current");
                                        }
                                        else {
                                            String s1 = d0.g;
                                            String s2 = "";
                                            if(s1 == null) {
                                                s1 = "";
                                            }
                                            String s3 = d0.j == null ? "" : d0.j;
                                            String s4 = d0.k;
                                            if(s4 != null) {
                                                s2 = s4;
                                            }
                                            ServiceUtilKt.startForegroundServiceWithLog(context0, w.v(s1, s3, s2), "AlarmTrigger.startMusicAlarm() - mixup");
                                        }
                                        if(d0.i != 2) {
                                            Object object0 = context0.getSystemService("notification");
                                            NotificationManager notificationManager0 = object0 instanceof NotificationManager ? ((NotificationManager)object0) : null;
                                            String s5 = e.a(d0);
                                            if(notificationManager0 != null) {
                                                if(notificationManager0.getNotificationChannel("107") == null) {
                                                    q.f("멜론 알람 시작", "getString(...)");
                                                    notificationManager0.createNotificationChannel(new NotificationChannel("107", "멜론 알람 시작", 4));
                                                }
                                                Intent intent3 = new Intent();
                                                intent3.setAction("com.iloen.melon.intent.action.setting.alarm.list");
                                                intent3.addCategory("android.intent.category.DEFAULT");
                                                intent3.addFlags(0x10008000);
                                                PendingIntent pendingIntent1 = PendingIntent.getActivity(context0, 0, intent3, 0xC000000);
                                                NotificationCompat.Builder notificationCompat$Builder0 = new NotificationCompat.Builder(context0, "107");
                                                notificationCompat$Builder0.G.icon = 0x7F08060A;  // drawable:icon_noti
                                                notificationCompat$Builder0.e = NotificationCompat.Builder.b("멜론 알람 시작");
                                                notificationCompat$Builder0.f = NotificationCompat.Builder.b(s5);
                                                notificationCompat$Builder0.h(s5);
                                                notificationCompat$Builder0.x = "alarm";
                                                notificationCompat$Builder0.r = "com.iloen.melon.ALARM_GROUP_KEY";
                                                notificationCompat$Builder0.g = pendingIntent1;
                                                notificationCompat$Builder0.e(16, true);
                                                Notification notification0 = notificationCompat$Builder0.a();
                                                q.f(notification0, "build(...)");
                                                notificationManager0.notify(((int)System.currentTimeMillis()), notification0);
                                            }
                                            if(notificationManager0 != null) {
                                                NotificationCompat.Builder notificationCompat$Builder1 = new NotificationCompat.Builder(context0, "107");
                                                notificationCompat$Builder1.G.icon = 0x7F08060A;  // drawable:icon_noti
                                                notificationCompat$Builder1.e = NotificationCompat.Builder.b("멜론 알람 시작");
                                                notificationCompat$Builder1.h("멜론 알람 시작");
                                                N1.q q0 = new N1.q(1);
                                                q0.e = new ArrayList();
                                                notificationCompat$Builder1.g(q0);
                                                notificationCompat$Builder1.r = "com.iloen.melon.ALARM_GROUP_KEY";
                                                notificationCompat$Builder1.s = true;
                                                Notification notification1 = notificationCompat$Builder1.a();
                                                q.f(notification1, "build(...)");
                                                notificationManager0.notify(13000, notification1);
                                            }
                                            ToastManager.show(e.a(d0));
                                        }
                                    }
                                }
                            }
                            if(d0.h) {
                                d0.e = false;
                                musicAlarmPrefsHelper0.updateAlarm(d0);
                            }
                        }
                    }
                }
            }
        }
    }
}

