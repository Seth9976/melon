package com.melon.playback;

import A3.l;
import Ac.U;
import Cc.h0;
import E9.w;
import G8.i;
import Nb.j0;
import Nb.k0;
import Nb.l0;
import Nb.n0;
import R8.m;
import U4.x;
import a7.c;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.IBinder;
import androidx.car.app.connection.CarConnection;
import androidx.core.app.NotificationCompat.Builder;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import androidx.media3.session.DefaultMediaNotificationProvider.Builder;
import androidx.media3.session.DefaultMediaNotificationProvider;
import androidx.media3.session.f0;
import androidx.media3.session.w0;
import androidx.media3.session.y0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.database.core.LocalPlaylistDatabase_Impl;
import com.iloen.melon.drm.AbsDcfController;
import com.iloen.melon.eventbus.EventActivityState.EventActivityPaused;
import com.iloen.melon.eventbus.EventActivityState.EventActivityResumed;
import com.iloen.melon.eventbus.EventActivityState;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.mediastore.MelonMediaScannerReceiver;
import com.iloen.melon.playback.ServiceUtilKt;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.FloatingLyricHelper;
import d3.g;
import e3.b;
import ie.r;
import java.util.ArrayList;
import jc.j;
import k8.Y;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mb.k;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\n\u000BB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/melon/playback/PlaybackLibraryService;", "Landroidx/media3/session/MediaLibraryService;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "<init>", "()V", "Lcom/iloen/melon/eventbus/EventActivityState;", "event", "Lie/H;", "onEventBackgroundThread", "(Lcom/iloen/melon/eventbus/EventActivityState;)V", "Nb/j0", "I7/c", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaybackLibraryService extends Hilt_PlaybackLibraryService implements SharedPreferences.OnSharedPreferenceChangeListener {
    public CoroutineScope B;
    public SharedPreferences D;
    public K E;
    public final r G;
    public MelonMediaScannerReceiver I;
    public static final int M;
    public static final int N;
    public final LogU m;
    public final r n;
    public final r o;
    public k r;
    public f0 w;

    static {
        PlaybackLibraryService.M = 101;
        PlaybackLibraryService.N = 200;
    }

    public PlaybackLibraryService() {
        this.m = Companion.create$default(LogU.Companion, "PlaybackLibraryService", false, Category.Playback, 2, null);
        this.n = g.Q(new Hc.k(12));
        this.o = g.Q(new U(this, 29));
        this.G = g.Q(new Hc.k(this, 13));
    }

    @Override  // androidx.media3.session.MediaLibraryService
    public final f0 f(w0 w00) {
        return this.m();
    }

    @Override  // androidx.media3.session.MediaLibraryService
    public final f0 j(w0 w00) {
        return this.m();
    }

    public static final void k(PlaybackLibraryService playbackLibraryService0) {
        LogU.debug$default(playbackLibraryService0.m, "stopForegroundWithDefaultNotification()", null, false, 6, null);
        LogU.debug$default(playbackLibraryService0.m, "showDefaultNotification()", null, false, 6, null);
        Object object0 = playbackLibraryService0.getSystemService("notification");
        NotificationManager notificationManager0 = object0 instanceof NotificationManager ? ((NotificationManager)object0) : null;
        if(notificationManager0 != null) {
            if(notificationManager0.getNotificationChannel("10001") == null) {
                LogU.debug$default(playbackLibraryService0.m, "showDefaultNotification - createNotificationChannel: " + notificationManager0, null, false, 6, null);
                NotificationChannel notificationChannel0 = new NotificationChannel("10001", "Foreground Service", 0);
                notificationChannel0.setLockscreenVisibility(-1);
                notificationChannel0.setShowBadge(false);
                notificationManager0.createNotificationChannel(notificationChannel0);
            }
            Intent intent0 = new Intent("com.iloen.melon.intent.action.MAIN").addCategory("android.intent.category.DEFAULT").addFlags(0x10000000).putExtra("activitystartactionname", "service");
            q.f(intent0, "putExtra(...)");
            PendingIntent pendingIntent0 = PendingIntent.getActivity(playbackLibraryService0, 0, intent0, 0x4000000);
            NotificationCompat.Builder notificationCompat$Builder0 = new NotificationCompat.Builder(Y.a(MelonAppBase.Companion), "10001");
            notificationCompat$Builder0.G.icon = 0x7F08060A;  // drawable:icon_noti
            notificationCompat$Builder0.g = pendingIntent0;
            notificationCompat$Builder0.k = false;
            notificationCompat$Builder0.A = -1;
            notificationCompat$Builder0.e(16, true);
            notificationCompat$Builder0.f = NotificationCompat.Builder.b("멜론앱이 실행 중입니다.");
            notificationCompat$Builder0.E = 1;
            Notification notification0 = notificationCompat$Builder0.a();
            q.f(notification0, "build(...)");
            ServiceUtilKt.startForegroundMediaPlayback(playbackLibraryService0, 10001, notification0);
        }
        playbackLibraryService0.l().postDelayed(new l(playbackLibraryService0, 8), 100L);
    }

    public final j0 l() {
        return (j0)this.o.getValue();
    }

    public final f0 m() {
        f0 f00 = this.w;
        if(f00 != null) {
            return f00;
        }
        q.m("session");
        throw null;
    }

    @Override  // androidx.media3.session.MediaLibraryService
    public final IBinder onBind(Intent intent0) {
        String s = x.e(this.m().a.e().size(), "onBind() session.connectedControllers.size: ");
        LogU.info$default(this.m, s, null, false, 6, null);
        return super.onBind(intent0);
    }

    @Override  // com.melon.playback.Hilt_PlaybackLibraryService
    public final void onCreate() {
        super.onCreate();
        LogU.info$default(this.m, "onCreate()", null, false, 6, null);
        j.c("Service.onCreate()");
        c.a().b("playback_create");
        SharedPreferences sharedPreferences0 = this.getSharedPreferences("com.iloen.melon.tablet.Preference.SETTING", 0);
        if(sharedPreferences0 != null) {
            sharedPreferences0.registerOnSharedPreferenceChangeListener(this);
            this.D = sharedPreferences0;
        }
        this.l().sendEmptyMessage(1);
        CoroutineScope coroutineScope0 = this.B;
        if(coroutineScope0 != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope0, Dispatchers.getMain(), null, new n0(this, null), 2, null);
            IntentFilter intentFilter0 = new IntentFilter();
            intentFilter0.addAction("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intentFilter0.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
            intentFilter0.addDataScheme("file");
            MelonMediaScannerReceiver melonMediaScannerReceiver0 = new MelonMediaScannerReceiver();
            this.I = melonMediaScannerReceiver0;
            w.S(this, melonMediaScannerReceiver0, intentFilter0, null);
            if(q.b(Environment.getExternalStorageState(), "mounted")) {
                try {
                    i.a.f();
                    w.N(((LocalPlaylistDatabase_Impl)i.a().a), false, true, new h0(-1L, 5));
                }
                catch(Exception exception0) {
                    LogU.error$default(this.m, exception0.toString(), null, false, 6, null);
                }
            }
            EventBusHelper.register(this);
            CarConnection carConnection0 = new CarConnection(this);
            M m0 = (M)this.G.getValue();
            carConnection0.a.observeForever(m0);
            this.E = carConnection0.a;
            I7.c c0 = new I7.c(this, 12);
            synchronized(this.a) {
                this.h = c0;
                Builder defaultMediaNotificationProvider$Builder0 = new Builder(this);
                defaultMediaNotificationProvider$Builder0.d = 0x7F13079D;  // string:notification_channel_player "알림 플레이어"
                defaultMediaNotificationProvider$Builder0.c = "101";
                defaultMediaNotificationProvider$Builder0.b = new androidx.media3.exoplayer.x(2);
                b.j(!defaultMediaNotificationProvider$Builder0.e);
                DefaultMediaNotificationProvider defaultMediaNotificationProvider0 = new DefaultMediaNotificationProvider(defaultMediaNotificationProvider$Builder0.a, defaultMediaNotificationProvider$Builder0.b, defaultMediaNotificationProvider$Builder0.c, defaultMediaNotificationProvider$Builder0.d);
                defaultMediaNotificationProvider$Builder0.e = true;
                __monitor_enter(this.a);
                this.f = defaultMediaNotificationProvider0;
            }
            return;
        }
        q.m("lifecycleScope");
        throw null;
    }

    @Override  // androidx.media3.session.MediaSessionService
    public final void onDestroy() {
        LogU.info$default(this.m, "onDestroy()", null, false, 6, null);
        j.c("Service.onDestroy()");
        f0 f00 = this.m();
        try {
            synchronized(y0.b) {
                y0.c.remove(f00.a.i);
            }
            f00.a.E();
        }
        catch(Exception unused_ex) {
        }
        this.m().a().release();
        LogU.info$default(this.m, "releaseResource()", null, false, 6, null);
        c.a().b("playback_destroy");
        K k0 = this.E;
        if(k0 != null) {
            k0.removeObserver(((M)this.G.getValue()));
        }
        this.E = null;
        j0 j00 = this.l();
        int v1 = PlaybackLibraryService.N;
        if(j00.hasMessages(v1)) {
            this.l().removeMessages(v1);
        }
        FloatingLyricHelper.requestStopFloatingLyric();
        CoroutineScope coroutineScope0 = this.B;
        if(coroutineScope0 != null) {
            CoroutineScopeKt.cancel$default(coroutineScope0, "Service destroyed", null, 2, null);
            this.l().sendEmptyMessage(2);
            SharedPreferences sharedPreferences0 = this.D;
            if(sharedPreferences0 != null) {
                sharedPreferences0.unregisterOnSharedPreferenceChangeListener(this);
            }
            this.D = null;
            MelonAppBase.Companion.getClass();
            t.a().getRequestQueue().cancelAll("PlaybackLibraryService");
            MelonMediaScannerReceiver melonMediaScannerReceiver0 = this.I;
            if(melonMediaScannerReceiver0 != null) {
                this.unregisterReceiver(melonMediaScannerReceiver0);
            }
            this.I = null;
            EventBusHelper.unregister(this);
            synchronized(this.a) {
                this.h = null;
            }
            super.onDestroy();
            return;
        }
        q.m("lifecycleScope");
        throw null;
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public final void onEventBackgroundThread(@NotNull EventActivityState eventActivityState0) {
        q.g(eventActivityState0, "event");
        if(!(eventActivityState0.mActivity instanceof r8.b) || !((r8.b)eventActivityState0.mActivity).isLockScreen()) {
            int v = PlaybackLibraryService.N;
            if(eventActivityState0 instanceof EventActivityPaused) {
                if(this.l().hasMessages(v)) {
                    this.l().removeMessages(v);
                }
                this.l().sendEmptyMessageDelayed(v, 500L);
                return;
            }
            if(eventActivityState0 instanceof EventActivityResumed) {
                if(this.l().hasMessages(v)) {
                    this.l().removeMessages(v);
                }
                FloatingLyricHelper.requestStopFloatingLyric();
            }
        }
    }

    @Override  // android.content.SharedPreferences$OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences0, String s) {
        if(s != null && "virtualMin".equals(s)) {
            try {
                AbsDcfController absDcfController0 = m.a(this, m.a);
                absDcfController0.b = sharedPreferences0 == null ? null : sharedPreferences0.getString(s, "88888888888");
            }
            finally {
                m.b(this);
            }
        }
    }

    @Override  // androidx.media3.session.MediaSessionService
    public final int onStartCommand(Intent intent0, int v, int v1) {
        LogU.debug$default(this.m, "onStartCommand() intent: " + intent0 + ", flags: " + v + ", startId: " + v1, null, false, 6, null);
        if(!Td.b.c(this)) {
            LogU.debug$default(this.m, "onStartCommand() no permission", null, false, 6, null);
            q.d("멜론 앱 사용을 위해서\n앱정보>권한 승인 후 이용해주세요.");
            ToastManager.show("멜론 앱 사용을 위해서\n앱정보>권한 승인 후 이용해주세요.");
            CoroutineScope coroutineScope0 = this.B;
            if(coroutineScope0 != null) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope0, Dispatchers.getMain().getImmediate(), null, new k0(this, null), 2, null);
                super.onStartCommand(intent0, v, v1);
                return 1;
            }
            q.m("lifecycleScope");
            throw null;
        }
        else if(q.b((intent0 == null ? null : intent0.getAction()), "android.intent.action.MEDIA_BUTTON")) {
            CoroutineScope coroutineScope1 = this.B;
            if(coroutineScope1 != null) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope1, Dispatchers.getMain().getImmediate(), null, new l0(this, null), 2, null);
                super.onStartCommand(intent0, v, v1);
                return 1;
            }
            q.m("lifecycleScope");
            throw null;
        }
        super.onStartCommand(intent0, v, v1);
        return 1;
    }

    @Override  // androidx.media3.session.MediaSessionService
    public final void onTaskRemoved(Intent intent0) {
        super.onTaskRemoved(intent0);
        boolean z = this.m().a().isPlaying();
        LogU.info$default(this.m, "onTaskRemoved() isPlaying: " + z + ", rootIntent: " + intent0, null, false, 6, null);
        if(!this.m().a().isPlaying()) {
            LogU.debug$default(this.m, "onTaskRemoved() not playing. request stopSelf()", null, false, 6, null);
            ArrayList arrayList0 = this.d();
            for(int v = 0; v < arrayList0.size(); ++v) {
                ((y0)arrayList0.get(v)).a().setPlayWhenReady(false);
            }
            this.stopSelf();
        }
    }

    @Override  // android.app.Service
    public final boolean onUnbind(Intent intent0) {
        String s = x.e(this.m().a.e().size(), "onUnbind() session.connectedControllers.size: ");
        LogU.info$default(this.m, s, null, false, 6, null);
        return super.onUnbind(intent0);
    }
}

