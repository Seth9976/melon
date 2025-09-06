package com.iloen.melon.playback;

import a7.c;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import c2.n0;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.a;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001A!\u0010\u0006\u001A\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001A!\u0010\r\u001A\u00020\u0005*\u00020\b2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\r\u0010\u000E\u001A!\u0010\u000F\u001A\u00020\u0005*\u00020\b2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\u000F\u0010\u000E\u001A!\u0010\u0010\u001A\u00020\u0005*\u00020\b2\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\u0010\u0010\u000E¨\u0006\u0011"}, d2 = {"Landroid/content/Context;", "Landroid/content/Intent;", "intent", "", "caller", "Lie/H;", "startForegroundServiceWithLog", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)V", "Landroid/app/Service;", "", "id", "Landroid/app/Notification;", "notification", "startForegroundMediaPlayback", "(Landroid/app/Service;ILandroid/app/Notification;)V", "startForegroundDataSync", "startForegroundShortService", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class ServiceUtilKt {
    public static final void startForegroundDataSync(@NotNull Service service0, int v, @NotNull Notification notification0) {
        q.g(service0, "<this>");
        q.g(notification0, "notification");
        n0.p(service0, v, notification0);
    }

    public static final void startForegroundMediaPlayback(@NotNull Service service0, int v, @NotNull Notification notification0) {
        q.g(service0, "<this>");
        q.g(notification0, "notification");
        a.k(service0, v, notification0);
    }

    public static final void startForegroundServiceWithLog(@NotNull Context context0, @NotNull Intent intent0, @NotNull String s) {
        q.g(context0, "<this>");
        q.g(intent0, "intent");
        q.g(s, "caller");
        c.a().b("context.startForegroundService() - caller: " + s);
        LogU.Companion.d("ServiceUtil", "context.startForegroundService() - caller: " + s);
        context0.startForegroundService(intent0);
    }

    public static final void startForegroundShortService(@NotNull Service service0, int v, @NotNull Notification notification0) {
        q.g(service0, "<this>");
        q.g(notification0, "notification");
        service0.startForeground(v, notification0);
    }
}

