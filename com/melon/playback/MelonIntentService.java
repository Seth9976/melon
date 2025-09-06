package com.melon.playback;

import Ac.U;
import Nb.o;
import Qb.z;
import Td.b;
import Ub.q;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build.VERSION;
import androidx.core.app.NotificationCompat.Builder;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.playback.Actor;
import com.iloen.melon.playback.ServiceUtilKt;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import java.io.Serializable;
import k8.a;
import kc.s2;
import kotlin.Metadata;
import kotlin.jvm.internal.C;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import p8.e;
import y8.s;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/melon/playback/MelonIntentService;", "Landroidx/lifecycle/LifecycleService;", "<init>", "()V", "E9/w", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonIntentService extends Hilt_MelonIntentService {
    public final LogU d;
    public a e;
    public s2 f;
    public q g;
    public final z h;
    public s i;
    public static final int j;

    public MelonIntentService() {
        this.d = Companion.create$default(LogU.Companion, "MelonIntentService", false, Category.Playback, 2, null);
        this.h = new z(this, "MelonIntentService");
    }

    @Override  // com.melon.playback.Hilt_MelonIntentService
    public final void onCreate() {
        LogU.debug$default(this.d, "onCreate()", null, false, 6, null);
        super.onCreate();
        z z0 = this.h;
        z0.o(true);
        z0.a(new e(24));
        s2 s20 = this.f;
        if(s20 != null) {
            q q0 = this.g;
            if(q0 != null) {
                kotlin.jvm.internal.q.g(z0, "playerController");
                kotlin.jvm.internal.q.g(q0, "playbackManager");
                s s0 = new s();  // 初始化器: Ljava/lang/Object;-><init>()V
                s0.a = z0;
                s0.b = s20;
                s0.c = q0;
                this.i = s0;
                return;
            }
            kotlin.jvm.internal.q.m("playbackManager");
            throw null;
        }
        kotlin.jvm.internal.q.m("playlistManager");
        throw null;
    }

    @Override  // androidx.lifecycle.LifecycleService
    public final void onDestroy() {
        LogU.debug$default(this.d, "onDestroy()", null, false, 6, null);
        super.onDestroy();
        this.h.l();
        this.h.o(false);
    }

    @Override  // androidx.lifecycle.LifecycleService
    public final int onStartCommand(Intent intent0, int v, int v1) {
        Actor actor0;
        LogU.debug$default(this.d, "onStartCommand()", null, false, 6, null);
        DevLog.Companion.get("AutoPlay").put("MelonIntentService.onStartCommand() intent: " + intent0);
        Object object0 = this.getSystemService("notification");
        Serializable serializable0 = null;
        NotificationManager notificationManager0 = object0 instanceof NotificationManager ? ((NotificationManager)object0) : null;
        if(notificationManager0 != null) {
            if(notificationManager0.getNotificationChannel("10001") == null) {
                LogU.debug$default(this.d, "showDefaultNotification - createNotificationChannel: " + notificationManager0, null, false, 6, null);
                NotificationChannel notificationChannel0 = new NotificationChannel("10001", "Foreground Service", 0);
                notificationChannel0.setLockscreenVisibility(-1);
                notificationChannel0.setShowBadge(false);
                notificationManager0.createNotificationChannel(notificationChannel0);
            }
            Intent intent1 = new Intent("com.iloen.melon.intent.action.MAIN").addCategory("android.intent.category.DEFAULT").addFlags(0x10000000).putExtra("activitystartactionname", "service");
            kotlin.jvm.internal.q.f(intent1, "putExtra(...)");
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
            kotlin.jvm.internal.q.f(notification0, "build(...)");
            ServiceUtilKt.startForegroundShortService(this, 10001, notification0);
        }
        U u0 = new U(this, 28);
        LogU.debug$default(this.d, "processIntent()", null, false, 6, null);
        if(intent0 == null) {
            u0.invoke();
            return super.onStartCommand(null, v, v1);
        }
        if(!b.c(this)) {
            MelonAppBase.Companion.getClass();
            kotlin.jvm.internal.q.f("멜론 앱 사용을 위해서\n앱정보>권한 승인 후 이용해주세요.", "getString(...)");
            ToastManager.show("멜론 앱 사용을 위해서\n앱정보>권한 승인 후 이용해주세요.");
            u0.invoke();
            return super.onStartCommand(intent0, v, v1);
        }
        String s = intent0.getAction();
        C c0 = new C();  // 初始化器: Ljava/lang/Object;-><init>()V
        if(intent0.hasExtra("com.iloen.melon.intent.extra.actor")) {
            if(Build.VERSION.SDK_INT >= 34) {
                serializable0 = P1.e.f(intent0);
            }
            else {
                Serializable serializable1 = intent0.getSerializableExtra("com.iloen.melon.intent.extra.actor");
                if(Actor.class.isInstance(serializable1)) {
                    serializable0 = serializable1;
                }
            }
            actor0 = (Actor)serializable0;
            if(actor0 == null) {
                actor0 = Actor.Normal;
            }
        }
        else {
            actor0 = intent0.hasExtra("com.iloen.melon.intent.extra.actor.ordinal") ? ((Actor[])Actor.getEntries().toArray(new Actor[0]))[intent0.getIntExtra("com.iloen.melon.intent.extra.actor.ordinal", Actor.Normal.ordinal())] : Actor.Normal;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new o(this, actor0, s, u0, intent0, c0, null), 3, null);
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

