package com.melon.download.normal;

import Bb.c;
import N1.z;
import Tf.v;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat.Builder;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/melon/download/normal/DownloadNotification;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DownloadNotification {
    public final Context a;
    public final z b;

    public DownloadNotification(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.a = context0;
        this.b = new z(context0);
    }

    public final void a() {
        z z0 = this.b;
        if(z0.b.getNotificationChannel("102") == null) {
            NotificationChannel notificationChannel0 = new NotificationChannel("102", "다운로드", 1);
            notificationChannel0.enableLights(false);
            notificationChannel0.enableVibration(false);
            notificationChannel0.setShowBadge(false);
            z0.b.createNotificationChannel(notificationChannel0);
        }
    }

    public final PendingIntent b(Intent intent0) {
        PendingIntent pendingIntent0 = PendingIntent.getActivity(this.a, 0, intent0, 0x2000000);
        q.f(pendingIntent0, "getActivity(...)");
        return pendingIntent0;
    }

    public final void c(c c0) {
        this.a();
        Intent intent0 = new Intent();
        Q1.c.Z(intent0, "com.iloen.melon.MELON_DOWNLOAD", 2);
        intent0.addCategory("android.intent.category.DEFAULT");
        intent0.addFlags(0x10000000);
        NotificationCompat.Builder notificationCompat$Builder0 = new NotificationCompat.Builder(this.a, "102");
        notificationCompat$Builder0.G.icon = 0x7F080438;  // drawable:ic_etc_indicator_downloading
        notificationCompat$Builder0.d("다운로드 중입니다.");
        notificationCompat$Builder0.G.when = System.currentTimeMillis();
        notificationCompat$Builder0.k = true;
        notificationCompat$Builder0.e(2, true);
        notificationCompat$Builder0.e(8, true);
        q.f("[%1$s] %2$s", "getString(...)");
        String s = c0.d;
        String s1 = "";
        if(s.length() == 0) {
            s = "";
        }
        else {
            String s2 = s.toUpperCase(Locale.ROOT);
            q.f(s2, "toUpperCase(...)");
            if(v.r0(s2, "FLAC", false)) {
                s = "FLAC";
            }
        }
        notificationCompat$Builder0.c(String.format("[%1$s] %2$s", Arrays.copyOf(new Object[]{s, c0.j}, 2)));
        long v = c0.q;
        long v1 = c0.r;
        if(v > 0L) {
            s1 = ((long)Math.floor(((double)(v1 * 100L)) / ((double)v))) + "%";
            q.f(s1, "toString(...)");
        }
        notificationCompat$Builder0.n = NotificationCompat.Builder.b(s1);
        notificationCompat$Builder0.o = (int)c0.q;
        notificationCompat$Builder0.p = (int)c0.r;
        notificationCompat$Builder0.q = false;
        notificationCompat$Builder0.h(c0.j);
        notificationCompat$Builder0.g = this.b(intent0);
        try {
            Notification notification0 = notificationCompat$Builder0.a();
            this.b.a(900, notification0);
        }
        catch(SecurityException unused_ex) {
        }
    }
}

