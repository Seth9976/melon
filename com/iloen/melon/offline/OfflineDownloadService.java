package com.iloen.melon.offline;

import Q8.d;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.NotificationCompat.Builder;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.playback.ServiceUtilKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.NotificationHelper;
import d3.g;
import ie.r;
import jd.e3;
import k8.t;
import k9.f;
import k9.j;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/offline/OfflineDownloadService;", "Landroid/app/Service;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class OfflineDownloadService extends Service {
    public final r a;
    public static final LogU b;

    static {
        OfflineDownloadService.b = new LogU("OfflineDownloadService");
    }

    public OfflineDownloadService() {
        this.a = g.Q(new e3(this, 5));
    }

    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        LogU.debug$default(OfflineDownloadService.b, "onBind()", null, false, 6, null);
        return null;
    }

    @Override  // android.app.Service
    public final void onCreate() {
        super.onCreate();
        LogU.debug$default(OfflineDownloadService.b, "onCreate()", null, false, 6, null);
    }

    @Override  // android.app.Service
    public final void onDestroy() {
        LogU.debug$default(OfflineDownloadService.b, "onDestroy()", null, false, 6, null);
        j.d();
        this.stopForeground(1);
        super.onDestroy();
    }

    @Override  // android.app.Service
    public final int onStartCommand(Intent intent0, int v, int v1) {
        Notification notification0 = null;
        String s = intent0 == null ? null : intent0.getAction();
        LogU.debug$default(OfflineDownloadService.b, "onStartCommand() action: " + s, null, false, 6, null);
        if(q.b(s, "com.iloen.melon.intent.action.offlinedownload.start")) {
            try {
                ((NotificationHelper)this.a.getValue()).makeChannelId(2, "102", "알림 플레이어", Boolean.FALSE);
                Intent intent1 = new Intent("com.iloen.melon.intent.action.MAIN").addCategory("android.intent.category.DEFAULT").addFlags(0x10000000).putExtra("activitystartactionname", "service");
                q.f(intent1, "putExtra(...)");
                PendingIntent pendingIntent0 = PendingIntent.getActivity(this, 0, intent1, 0x4000000);
                PendingIntent pendingIntent1 = PendingIntent.getService(this, 0, new Intent(this, OfflineDownloadService.class).setAction("com.iloen.melon.intent.action.offlinedownload.stop"), 0x4000000);
                MelonAppBase.Companion.getClass();
                NotificationCompat.Builder notificationCompat$Builder0 = new NotificationCompat.Builder(t.a().getContext(), "102");
                notificationCompat$Builder0.G.icon = 0x7F08060A;  // drawable:icon_noti
                notificationCompat$Builder0.g = pendingIntent0;
                notificationCompat$Builder0.e(2, false);
                notificationCompat$Builder0.k = false;
                notificationCompat$Builder0.A = -1;
                notificationCompat$Builder0.e(16, true);
                notificationCompat$Builder0.f = NotificationCompat.Builder.b("오프라인 파일 저장 중");
                notificationCompat$Builder0.h("오프라인 파일 저장 중");
                notificationCompat$Builder0.G.deleteIntent = pendingIntent1;
                notificationCompat$Builder0.E = 1;
                notification0 = notificationCompat$Builder0.a();
            }
            catch(Exception exception0) {
                LogU.Companion.e("OfflineDownloadService", "showNotification()", exception0);
            }
            if(notification0 != null) {
                ServiceUtilKt.startForegroundDataSync(this, 10004, notification0);
                return 2;
            }
        }
        else if(q.b(s, "com.iloen.melon.intent.action.offlinedownload.stop")) {
            d.a.d();
            this.stopForeground(1);
            this.stopSelf();
        }
        return 2;
    }

    @Override  // android.app.Service
    public final void onTaskRemoved(Intent intent0) {
        super.onTaskRemoved(intent0);
        LogU.debug$default(OfflineDownloadService.b, "onTaskRemoved()", null, false, 6, null);
        j.d();
        this.stopForeground(1);
        this.stopSelf();
    }

    @Override  // android.app.Service
    public final void onTimeout(int v, int v1) {
        super.onTimeout(v, v1);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new f(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        this.stopSelf();
    }
}

