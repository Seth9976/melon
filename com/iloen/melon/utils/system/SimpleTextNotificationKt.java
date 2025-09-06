package com.iloen.melon.utils.system;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.core.app.NotificationCompat.Builder;
import com.iloen.melon.MelonAppBase;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u001D\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0001\u001A\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "title", "content", "Lie/H;", "showSimpleTextNotification", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class SimpleTextNotificationKt {
    public static final void showSimpleTextNotification(@NotNull CharSequence charSequence0, @NotNull CharSequence charSequence1) {
        q.g(charSequence0, "title");
        q.g(charSequence1, "content");
        t t0 = MelonAppBase.Companion;
        t0.getClass();
        Context context0 = t.a().getContext();
        t0.getClass();
        NotificationManager notificationManager0 = (NotificationManager)t.a().getContext().getSystemService("notification");
        if(notificationManager0 != null && notificationManager0.getNotificationChannel("105") == null) {
            NotificationChannel notificationChannel0 = new NotificationChannel("105", "기본", 2);
            notificationChannel0.enableLights(false);
            notificationChannel0.enableVibration(false);
            notificationChannel0.setShowBadge(false);
            notificationManager0.createNotificationChannel(notificationChannel0);
        }
        NotificationCompat.Builder notificationCompat$Builder0 = new NotificationCompat.Builder(context0, "105");
        notificationCompat$Builder0.G.icon = 0x7F08060A;  // drawable:icon_noti
        notificationCompat$Builder0.e = NotificationCompat.Builder.b(charSequence0);
        notificationCompat$Builder0.f = NotificationCompat.Builder.b(charSequence1);
        N1.q q0 = new N1.q(0);
        q0.e = NotificationCompat.Builder.b(charSequence1);
        notificationCompat$Builder0.g(q0);
        notificationCompat$Builder0.k = false;
        notificationCompat$Builder0.j = -1;
        notificationCompat$Builder0.A = -1;
        notificationCompat$Builder0.e(16, true);
        Notification notification0 = notificationCompat$Builder0.a();
        q.f(notification0, "build(...)");
        t0.getClass();
        NotificationManager notificationManager1 = (NotificationManager)t.a().getContext().getSystemService("notification");
        if(notificationManager1 != null) {
            notificationManager1.notify(11000, notification0);
        }
    }
}

