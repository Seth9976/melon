package com.melon.playback;

import Qb.z;
import Td.b;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import androidx.core.app.NotificationCompat.Builder;
import androidx.media3.session.v;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.request.InflowPvLogDummyReq.Params.Builder;
import com.iloen.melon.net.v4x.request.InflowPvLogDummyReq;
import com.iloen.melon.playback.ServiceUtilKt;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import p8.O;
import p8.e;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/melon/playback/MelonBudsReceiverService;", "Landroidx/lifecycle/LifecycleService;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonBudsReceiverService extends Hilt_MelonBudsReceiverService {
    public final LogU d;
    public final z e;

    public MelonBudsReceiverService() {
        this.d = Companion.create$default(LogU.Companion, "MelonBudsReceiverService", false, Category.Playback, 2, null);
        this.e = new z(this, "MelonBudsReceiverService");
    }

    @Override  // com.melon.playback.Hilt_MelonBudsReceiverService
    public final void onCreate() {
        LogU.debug$default(this.d, "onCreate()", null, false, 6, null);
        super.onCreate();
        this.e.o(true);
        e e0 = new e(24);
        this.e.a(e0);
    }

    @Override  // androidx.lifecycle.LifecycleService
    public final void onDestroy() {
        LogU.debug$default(this.d, "onDestroy()", null, false, 6, null);
        super.onDestroy();
        this.e.l();
        this.e.o(false);
    }

    @Override  // androidx.lifecycle.LifecycleService
    public final int onStartCommand(Intent intent0, int v, int v1) {
        LogU.debug$default(this.d, "onStartCommand()", null, false, 6, null);
        if(intent0 != null) {
            intent0.getAction();
        }
        LogU.debug$default(this.d, "showDefaultNotification()", null, false, 6, null);
        Object object0 = this.getSystemService("notification");
        NotificationManager notificationManager0 = object0 instanceof NotificationManager ? ((NotificationManager)object0) : null;
        boolean z = false;
        if(notificationManager0 != null) {
            if(notificationManager0.getNotificationChannel("10001") == null) {
                LogU.debug$default(this.d, "showDefaultNotification - createNotificationChannel: " + notificationManager0, null, false, 6, null);
                NotificationChannel notificationChannel0 = new NotificationChannel("10001", "Foreground Service", 0);
                notificationChannel0.setLockscreenVisibility(-1);
                notificationChannel0.setShowBadge(false);
                notificationManager0.createNotificationChannel(notificationChannel0);
            }
            Intent intent1 = new Intent("com.iloen.melon.intent.action.MAIN").addCategory("android.intent.category.DEFAULT").addFlags(0x10000000).putExtra("activitystartactionname", "service");
            q.f(intent1, "putExtra(...)");
            PendingIntent pendingIntent0 = PendingIntent.getActivity(this, 0, intent1, 0x4000000);
            NotificationCompat.Builder notificationCompat$Builder0 = new NotificationCompat.Builder(this, "10001");
            notificationCompat$Builder0.G.icon = 0x7F08060A;  // drawable:icon_noti
            notificationCompat$Builder0.g = pendingIntent0;
            notificationCompat$Builder0.k = false;
            notificationCompat$Builder0.A = -1;
            notificationCompat$Builder0.e(16, true);
            notificationCompat$Builder0.f = NotificationCompat.Builder.b("멜론앱이 실행 중입니다.");
            notificationCompat$Builder0.E = 1;
            Notification notification0 = notificationCompat$Builder0.a();
            q.f(notification0, "build(...)");
            ServiceUtilKt.startForegroundShortService(this, 10001, notification0);
        }
        if(intent0 == null) {
            LogU.debug$default(this.d, "processIntent() intent is null", null, false, 6, null);
            this.stopForeground(1);
            return super.onStartCommand(null, v, v1);
        }
        if(!b.c(this)) {
            LogU.debug$default(this.d, "processIntent() no permission", null, false, 6, null);
            MelonAppBase.Companion.getClass();
            q.f("멜론 앱 사용을 위해서\n앱정보>권한 승인 후 이용해주세요.", "getString(...)");
            ToastManager.show("멜론 앱 사용을 위해서\n앱정보>권한 승인 후 이용해주세요.");
            this.stopForeground(1);
            return super.onStartCommand(intent0, v, v1);
        }
        String s = intent0.getAction();
        LogU.debug$default(this.d, "processIntent() action= " + s, null, false, 6, null);
        q.f("com.samsung.accessory.earbuds.action.SEND_PUI_EVENT", "getString(...)");
        if("com.samsung.accessory.earbuds.action.SEND_PUI_EVENT".equals(s)) {
            O.a(new InflowPvLogDummyReq(this, new Builder("W60700").build()));
            z z1 = this.e;
            v v2 = z1.h();
            if(v2 != null) {
                z = v2.isPlaying();
            }
            if(!z) {
                z1.s();
            }
            this.stopForeground(1);
        }
        return super.onStartCommand(intent0, v, v1);
    }

    @Override  // android.app.Service
    public final void onTaskRemoved(Intent intent0) {
        LogU.debug$default(this.d, "onTaskRemoved()", null, false, 6, null);
        this.stopForeground(1);
        this.stopSelf();
    }

    @Override  // android.app.Service
    public final void onTimeout(int v) {
        LogU.debug$default(this.d, "onTimeout()", null, false, 6, null);
        this.stopForeground(1);
        this.stopSelf();
    }
}

