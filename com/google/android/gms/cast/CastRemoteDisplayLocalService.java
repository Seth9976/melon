package com.google.android.gms.cast;

import N1.m;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Display;
import androidx.core.app.NotificationCompat.Builder;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.cast.zzeo;
import com.google.android.gms.internal.cast.zzet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import l4.G;
import l4.H;
import l4.O;
import l4.Q;

@SuppressLint({"ForegroundServiceType"})
@Deprecated
public abstract class CastRemoteDisplayLocalService extends Service {
    public interface Callbacks {
        void onRemoteDisplayMuteStateChanged(boolean arg1);

        void onRemoteDisplaySessionEnded(CastRemoteDisplayLocalService arg1);

        void onRemoteDisplaySessionError(Status arg1);

        void onRemoteDisplaySessionStarted(CastRemoteDisplayLocalService arg1);

        void onServiceCreated(CastRemoteDisplayLocalService arg1);
    }

    public static final class NotificationSettings {
        public static final class Builder {
            private final NotificationSettings zza;

            public Builder() {
                this.zza = new NotificationSettings(null);
            }

            public NotificationSettings build() {
                NotificationSettings castRemoteDisplayLocalService$NotificationSettings0 = this.zza;
                if(castRemoteDisplayLocalService$NotificationSettings0.zza != null) {
                    if(!TextUtils.isEmpty(castRemoteDisplayLocalService$NotificationSettings0.zzc)) {
                        throw new IllegalArgumentException("notificationTitle requires using the default notification");
                    }
                    if(!TextUtils.isEmpty(castRemoteDisplayLocalService$NotificationSettings0.zzd)) {
                        throw new IllegalArgumentException("notificationText requires using the default notification");
                    }
                    if(castRemoteDisplayLocalService$NotificationSettings0.zzb != null) {
                        throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                    }
                }
                else if(TextUtils.isEmpty(castRemoteDisplayLocalService$NotificationSettings0.zzc) && TextUtils.isEmpty(castRemoteDisplayLocalService$NotificationSettings0.zzd) && castRemoteDisplayLocalService$NotificationSettings0.zzb == null) {
                    throw new IllegalArgumentException("At least an argument must be provided");
                }
                return castRemoteDisplayLocalService$NotificationSettings0;
            }

            public Builder setNotification(Notification notification0) {
                this.zza.zza = notification0;
                return this;
            }

            public Builder setNotificationPendingIntent(PendingIntent pendingIntent0) {
                this.zza.zzb = pendingIntent0;
                return this;
            }

            public Builder setNotificationText(String s) {
                this.zza.zzd = s;
                return this;
            }

            public Builder setNotificationTitle(String s) {
                this.zza.zzc = s;
                return this;
            }
        }

        private Notification zza;
        private PendingIntent zzb;
        private String zzc;
        private String zzd;

        private NotificationSettings() {
            throw null;
        }

        public NotificationSettings(NotificationSettings castRemoteDisplayLocalService$NotificationSettings0, zzap zzap0) {
            this.zza = castRemoteDisplayLocalService$NotificationSettings0.zza;
            this.zzb = castRemoteDisplayLocalService$NotificationSettings0.zzb;
            this.zzc = castRemoteDisplayLocalService$NotificationSettings0.zzc;
            this.zzd = castRemoteDisplayLocalService$NotificationSettings0.zzd;
        }

        public NotificationSettings(zzap zzap0) {
        }
    }

    public static class Options {
        @Configuration
        int zza;

        public Options() {
            this.zza = 2;
        }

        @Configuration
        public int getConfigPreset() {
            return this.zza;
        }

        public void setConfigPreset(@Configuration int v) {
            this.zza = v;
        }
    }

    private static final Logger zza;
    private static final int zzb;
    private static final Object zzc;
    private static final AtomicBoolean zzd;
    @SuppressLint({"StaticFieldLeak"})
    private static CastRemoteDisplayLocalService zze;
    private String zzf;
    private WeakReference zzg;
    private zzao zzh;
    private NotificationSettings zzi;
    private Notification zzj;
    private boolean zzk;
    private PendingIntent zzl;
    private CastDevice zzm;
    private Display zzn;
    private Context zzo;
    private ServiceConnection zzp;
    private Handler zzq;
    private Q zzr;
    private boolean zzs;
    private CastRemoteDisplayClient zzt;
    private final H zzu;
    private final IBinder zzv;

    static {
        CastRemoteDisplayLocalService.zza = new Logger("CastRDLocalService");
        CastRemoteDisplayLocalService.zzb = id.cast_notification_id;
        CastRemoteDisplayLocalService.zzc = new Object();
        CastRemoteDisplayLocalService.zzd = new AtomicBoolean(false);
    }

    public CastRemoteDisplayLocalService() {
        this.zzs = false;
        this.zzu = new zzaf(this);
        this.zzv = new zzan(this);
    }

    public Display getCastRemoteDisplay() {
        return this.zzn;
    }

    public static CastRemoteDisplayLocalService getInstance() {
        synchronized(CastRemoteDisplayLocalService.zzc) {
        }
        return CastRemoteDisplayLocalService.zze;
    }

    @Override  // android.app.Service
    public IBinder onBind(Intent intent0) {
        this.zzv("onBind");
        return this.zzv;
    }

    @Override  // android.app.Service
    public void onCreate() {
        this.zzv("onCreate");
        super.onCreate();
        zzet zzet0 = new zzet(this.getMainLooper());
        this.zzq = zzet0;
        zzet0.postDelayed(new zzag(this), 100L);
        if(this.zzt == null) {
            this.zzt = CastRemoteDisplay.getClient(this);
        }
        NotificationManager notificationManager0 = (NotificationManager)this.getSystemService(NotificationManager.class);
        NotificationChannel notificationChannel0 = new NotificationChannel("cast_remote_display_local_service", this.getString(string.cast_notification_default_channel_name), 2);
        notificationChannel0.setShowBadge(false);
        notificationManager0.createNotificationChannel(notificationChannel0);
    }

    public abstract void onCreatePresentation(Display arg1);

    public abstract void onDismissPresentation();

    @Override  // android.app.Service
    public int onStartCommand(Intent intent0, int v, int v1) {
        this.zzv("onStartCommand");
        this.zzs = true;
        return 2;
    }

    public static void setDebugEnabled() {
        CastRemoteDisplayLocalService.zza.zzb(true);
    }

    public static void startService(Context context0, Class class0, String s, CastDevice castDevice0, NotificationSettings castRemoteDisplayLocalService$NotificationSettings0, Callbacks castRemoteDisplayLocalService$Callbacks0) {
        CastRemoteDisplayLocalService.startServiceWithOptions(context0, class0, s, castDevice0, new Options(), castRemoteDisplayLocalService$NotificationSettings0, castRemoteDisplayLocalService$Callbacks0);
    }

    public static void startServiceWithOptions(Context context0, Class class0, String s, CastDevice castDevice0, Options castRemoteDisplayLocalService$Options0, NotificationSettings castRemoteDisplayLocalService$NotificationSettings0, Callbacks castRemoteDisplayLocalService$Callbacks0) {
        Logger logger0 = CastRemoteDisplayLocalService.zza;
        logger0.d("Starting Service", new Object[0]);
        synchronized(CastRemoteDisplayLocalService.zzc) {
            if(CastRemoteDisplayLocalService.zze != null) {
                logger0.w("An existing service had not been stopped before starting one", new Object[0]);
                CastRemoteDisplayLocalService.zzw(true);
            }
        }
        try {
            ComponentName componentName0 = new ComponentName(context0, class0);
            ServiceInfo serviceInfo0 = context0.getPackageManager().getServiceInfo(componentName0, 0x80);
            if(serviceInfo0 != null && serviceInfo0.exported) {
                throw new IllegalStateException("The service must not be exported, verify the manifest configuration");
            }
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            throw new IllegalStateException("Service not found, did you forget to configure it in the manifest?", packageManager$NameNotFoundException0);
        }
        Preconditions.checkNotNull(context0, "activityContext is required.");
        Preconditions.checkNotNull(class0, "serviceClass is required.");
        Preconditions.checkNotNull(s, "applicationId is required.");
        Preconditions.checkNotNull(castDevice0, "device is required.");
        Preconditions.checkNotNull(castRemoteDisplayLocalService$Options0, "options is required.");
        Preconditions.checkNotNull(castRemoteDisplayLocalService$NotificationSettings0, "notificationSettings is required.");
        Preconditions.checkNotNull(castRemoteDisplayLocalService$Callbacks0, "callbacks is required.");
        if(NotificationSettings.zza(castRemoteDisplayLocalService$NotificationSettings0) == null && NotificationSettings.zzb(castRemoteDisplayLocalService$NotificationSettings0) == null) {
            throw new IllegalArgumentException("notificationSettings: Either the notification or the notificationPendingIntent must be provided");
        }
        if(CastRemoteDisplayLocalService.zzd.getAndSet(true)) {
            logger0.e("Service is already being started, startService has been called twice", new Object[0]);
            return;
        }
        Intent intent0 = new Intent(context0, class0);
        context0.startService(intent0);
        ConnectionTracker.getInstance().bindService(context0, intent0, new zzah(s, castDevice0, castRemoteDisplayLocalService$Options0, castRemoteDisplayLocalService$NotificationSettings0, context0, castRemoteDisplayLocalService$Callbacks0), 0x40);
    }

    public static void stopService() {
        CastRemoteDisplayLocalService.zzw(false);
    }

    // 去混淆评级： 低(30)
    @Deprecated
    public void updateNotificationSettings(NotificationSettings castRemoteDisplayLocalService$NotificationSettings0) {
    }

    public static void zzi(CastRemoteDisplayLocalService castRemoteDisplayLocalService0, Context context0) {
        castRemoteDisplayLocalService0.zzo = null;
    }

    public static void zzj(CastRemoteDisplayLocalService castRemoteDisplayLocalService0, Display display0) {
        castRemoteDisplayLocalService0.zzn = null;
    }

    public static void zzk(CastRemoteDisplayLocalService castRemoteDisplayLocalService0, ServiceConnection serviceConnection0) {
        castRemoteDisplayLocalService0.zzp = null;
    }

    public static void zzl(CastRemoteDisplayLocalService castRemoteDisplayLocalService0, Display display0) {
        if(display0 == null) {
            CastRemoteDisplayLocalService.zza.e("Cast Remote Display session created without display", new Object[0]);
            return;
        }
        castRemoteDisplayLocalService0.zzn = display0;
        if(castRemoteDisplayLocalService0.zzk) {
            Notification notification0 = castRemoteDisplayLocalService0.zzu(true);
            castRemoteDisplayLocalService0.zzj = notification0;
            castRemoteDisplayLocalService0.startForeground(CastRemoteDisplayLocalService.zzb, notification0);
        }
        Callbacks castRemoteDisplayLocalService$Callbacks0 = (Callbacks)castRemoteDisplayLocalService0.zzg.get();
        if(castRemoteDisplayLocalService$Callbacks0 != null) {
            castRemoteDisplayLocalService$Callbacks0.onRemoteDisplaySessionStarted(castRemoteDisplayLocalService0);
        }
        Preconditions.checkNotNull(castRemoteDisplayLocalService0.zzn, "display is required.");
        castRemoteDisplayLocalService0.onCreatePresentation(castRemoteDisplayLocalService0.zzn);
    }

    public static void zzn(CastRemoteDisplayLocalService castRemoteDisplayLocalService0, String s) {
        CastRemoteDisplayLocalService.zza.e("[Instance: %s] %s", new Object[]{castRemoteDisplayLocalService0, "The local service has not been been started, stopping it"});
    }

    public static void zzo(CastRemoteDisplayLocalService castRemoteDisplayLocalService0) {
        Callbacks castRemoteDisplayLocalService$Callbacks0 = (Callbacks)castRemoteDisplayLocalService0.zzg.get();
        if(castRemoteDisplayLocalService$Callbacks0 != null) {
            castRemoteDisplayLocalService$Callbacks0.onRemoteDisplaySessionError(new Status(2200));
        }
        CastRemoteDisplayLocalService.stopService();
    }

    public static void zzq(CastRemoteDisplayLocalService castRemoteDisplayLocalService0, NotificationSettings castRemoteDisplayLocalService$NotificationSettings0) {
        Preconditions.checkMainThread("updateNotificationSettingsInternal must be called on the main thread");
        if(castRemoteDisplayLocalService0.zzi == null) {
            throw new IllegalStateException("No current notification settings to update");
        }
        if(castRemoteDisplayLocalService0.zzk) {
            if(NotificationSettings.zza(castRemoteDisplayLocalService$NotificationSettings0) != null) {
                throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
            }
            if(NotificationSettings.zzb(castRemoteDisplayLocalService$NotificationSettings0) != null) {
                NotificationSettings.zzf(castRemoteDisplayLocalService0.zzi, NotificationSettings.zzb(castRemoteDisplayLocalService$NotificationSettings0));
            }
            if(!TextUtils.isEmpty(NotificationSettings.zzd(castRemoteDisplayLocalService$NotificationSettings0))) {
                NotificationSettings.zzh(castRemoteDisplayLocalService0.zzi, NotificationSettings.zzd(castRemoteDisplayLocalService$NotificationSettings0));
            }
            if(!TextUtils.isEmpty(NotificationSettings.zzc(castRemoteDisplayLocalService$NotificationSettings0))) {
                NotificationSettings.zzg(castRemoteDisplayLocalService0.zzi, NotificationSettings.zzc(castRemoteDisplayLocalService$NotificationSettings0));
            }
            castRemoteDisplayLocalService0.zzj = castRemoteDisplayLocalService0.zzu(true);
        }
        else {
            Preconditions.checkNotNull(NotificationSettings.zza(castRemoteDisplayLocalService$NotificationSettings0), "notification is required.");
            Notification notification0 = NotificationSettings.zza(castRemoteDisplayLocalService$NotificationSettings0);
            castRemoteDisplayLocalService0.zzj = notification0;
            NotificationSettings.zze(castRemoteDisplayLocalService0.zzi, notification0);
        }
        castRemoteDisplayLocalService0.startForeground(CastRemoteDisplayLocalService.zzb, castRemoteDisplayLocalService0.zzj);
    }

    public static void zzr(boolean z) {
        CastRemoteDisplayLocalService.zzw(false);
    }

    public static boolean zzt(CastRemoteDisplayLocalService castRemoteDisplayLocalService0, String s, CastDevice castDevice0, Options castRemoteDisplayLocalService$Options0, NotificationSettings castRemoteDisplayLocalService$NotificationSettings0, Context context0, ServiceConnection serviceConnection0, Callbacks castRemoteDisplayLocalService$Callbacks0) {
        castRemoteDisplayLocalService0.zzv("startRemoteDisplaySession");
        Preconditions.checkMainThread("Starting the Cast Remote Display must be done on the main thread");
        synchronized(CastRemoteDisplayLocalService.zzc) {
            if(CastRemoteDisplayLocalService.zze != null) {
                CastRemoteDisplayLocalService.zza.w("An existing service had not been stopped before starting one", new Object[0]);
                return false;
            }
            goto label_8;
        }
        return false;
    label_8:
        CastRemoteDisplayLocalService.zze = castRemoteDisplayLocalService0;
        castRemoteDisplayLocalService0.zzg = new WeakReference(castRemoteDisplayLocalService$Callbacks0);
        castRemoteDisplayLocalService0.zzf = s;
        castRemoteDisplayLocalService0.zzm = castDevice0;
        castRemoteDisplayLocalService0.zzo = context0;
        castRemoteDisplayLocalService0.zzp = serviceConnection0;
        if(castRemoteDisplayLocalService0.zzr == null) {
            castRemoteDisplayLocalService0.zzr = Q.d(castRemoteDisplayLocalService0.getApplicationContext());
        }
        Preconditions.checkNotNull(castRemoteDisplayLocalService0.zzf, "applicationId is required.");
        String s1 = CastMediaControlIntent.categoryForCast(castRemoteDisplayLocalService0.zzf);
        if(s1 == null) {
            throw new IllegalArgumentException("category must not be null");
        }
        ArrayList arrayList0 = new ArrayList();
        if(!arrayList0.contains(s1)) {
            arrayList0.add(s1);
        }
        Bundle bundle0 = new Bundle();
        bundle0.putStringArrayList("controlCategories", arrayList0);
        G g0 = new G(bundle0, arrayList0);
        castRemoteDisplayLocalService0.zzv("addMediaRouterCallback");
        castRemoteDisplayLocalService0.zzr.a(g0, castRemoteDisplayLocalService0.zzu, 4);
        castRemoteDisplayLocalService0.zzj = NotificationSettings.zza(castRemoteDisplayLocalService$NotificationSettings0);
        castRemoteDisplayLocalService0.zzh = new zzao(null);
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT");
        intentFilter0.addAction("com.google.android.gms.cast.remote_display.ACTION_SESSION_ENDED");
        castRemoteDisplayLocalService0.registerReceiver(castRemoteDisplayLocalService0.zzh, intentFilter0, 4);
        NotificationSettings castRemoteDisplayLocalService$NotificationSettings1 = new NotificationSettings(castRemoteDisplayLocalService$NotificationSettings0, null);
        castRemoteDisplayLocalService0.zzi = castRemoteDisplayLocalService$NotificationSettings1;
        if(NotificationSettings.zza(castRemoteDisplayLocalService$NotificationSettings1) == null) {
            castRemoteDisplayLocalService0.zzk = true;
            castRemoteDisplayLocalService0.zzj = castRemoteDisplayLocalService0.zzu(false);
        }
        else {
            castRemoteDisplayLocalService0.zzk = false;
            castRemoteDisplayLocalService0.zzj = NotificationSettings.zza(castRemoteDisplayLocalService0.zzi);
        }
        castRemoteDisplayLocalService0.startForeground(CastRemoteDisplayLocalService.zzb, castRemoteDisplayLocalService0.zzj);
        castRemoteDisplayLocalService0.zzv("startRemoteDisplay");
        Intent intent0 = new Intent("com.google.android.gms.cast.remote_display.ACTION_SESSION_ENDED");
        Preconditions.checkNotNull(castRemoteDisplayLocalService0.zzo, "activityContext is required.");
        intent0.setPackage("com.iloen.melon");
        PendingIntent pendingIntent0 = PendingIntent.getBroadcast(castRemoteDisplayLocalService0, 0, intent0, zzeo.zza);
        zzak zzak0 = new zzak(castRemoteDisplayLocalService0);
        Preconditions.checkNotNull(castRemoteDisplayLocalService0.zzf, "applicationId is required.");
        castRemoteDisplayLocalService0.zzt.zze(castDevice0, castRemoteDisplayLocalService0.zzf, castRemoteDisplayLocalService$Options0.getConfigPreset(), pendingIntent0, zzak0).addOnCompleteListener(new zzal(castRemoteDisplayLocalService0));
        Callbacks castRemoteDisplayLocalService$Callbacks1 = (Callbacks)castRemoteDisplayLocalService0.zzg.get();
        if(castRemoteDisplayLocalService$Callbacks1 == null) {
            return true;
        }
        castRemoteDisplayLocalService$Callbacks1.onServiceCreated(castRemoteDisplayLocalService0);
        return true;
    }

    private final Notification zzu(boolean z) {
        int v1;
        int v;
        this.zzv("createDefaultNotification");
        String s = this.zzi.zzc;
        String s1 = this.zzi.zzd;
        if(z) {
            v = string.cast_notification_connected_message;
            v1 = drawable.cast_ic_notification_on;
        }
        else {
            v = string.cast_notification_connecting_message;
            v1 = drawable.cast_ic_notification_connecting;
        }
        if(TextUtils.isEmpty(s)) {
            s = (String)this.getPackageManager().getApplicationLabel(this.getApplicationInfo());
        }
        if(TextUtils.isEmpty(s1)) {
            s1 = this.getString(v, new Object[]{this.zzm.getFriendlyName()});
        }
        NotificationCompat.Builder notificationCompat$Builder0 = new NotificationCompat.Builder(this, "cast_remote_display_local_service");
        notificationCompat$Builder0.e = NotificationCompat.Builder.b(s);
        notificationCompat$Builder0.f = NotificationCompat.Builder.b(s1);
        notificationCompat$Builder0.g = this.zzi.zzb;
        notificationCompat$Builder0.G.icon = v1;
        notificationCompat$Builder0.e(2, true);
        String s2 = this.getString(string.cast_notification_disconnect);
        if(this.zzl == null) {
            Preconditions.checkNotNull(this.zzo, "activityContext is required.");
            Intent intent0 = new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT");
            intent0.setPackage("com.iloen.melon");
            this.zzl = PendingIntent.getBroadcast(this, 0, intent0, zzeo.zza | 0x8000000);
        }
        m m0 = new m(0x1080038, s2, this.zzl);
        notificationCompat$Builder0.b.add(m0);
        return notificationCompat$Builder0.a();
    }

    private final void zzv(String s) {
        CastRemoteDisplayLocalService.zza.d("[Instance: %s] %s", new Object[]{this, s});
    }

    private static void zzw(boolean z) {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService0;
        Logger logger0 = CastRemoteDisplayLocalService.zza;
        logger0.d("Stopping Service", new Object[0]);
        CastRemoteDisplayLocalService.zzd.set(false);
        synchronized(CastRemoteDisplayLocalService.zzc) {
            castRemoteDisplayLocalService0 = CastRemoteDisplayLocalService.zze;
            if(castRemoteDisplayLocalService0 == null) {
                logger0.e("Service is already being stopped", new Object[0]);
                return;
            }
            CastRemoteDisplayLocalService.zze = null;
        }
        if(castRemoteDisplayLocalService0.zzq != null) {
            if(Looper.myLooper() != Looper.getMainLooper()) {
                castRemoteDisplayLocalService0.zzq.post(new zzai(castRemoteDisplayLocalService0, z));
                return;
            }
            castRemoteDisplayLocalService0.zzx(z);
        }
    }

    private final void zzx(boolean z) {
        this.zzv("Stopping Service");
        Preconditions.checkMainThread("stopServiceInstanceInternal must be called on the main thread");
        if(!z && this.zzr != null) {
            this.zzv("Setting default route");
            this.zzr.getClass();
            Q.b();
            O o0 = Q.c().w;
            if(o0 == null) {
                throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
            }
            o0.l(true);
        }
        if(this.zzh != null) {
            this.zzv("Unregistering notification receiver");
            this.unregisterReceiver(this.zzh);
        }
        this.zzv("stopRemoteDisplaySession");
        this.zzv("stopRemoteDisplay");
        this.zzt.stopRemoteDisplay().addOnCompleteListener(new zzam(this));
        Callbacks castRemoteDisplayLocalService$Callbacks0 = (Callbacks)this.zzg.get();
        if(castRemoteDisplayLocalService$Callbacks0 != null) {
            castRemoteDisplayLocalService$Callbacks0.onRemoteDisplaySessionEnded(this);
        }
        this.onDismissPresentation();
        this.zzv("Stopping the remote display Service");
        this.stopForeground(true);
        this.stopSelf();
        if(this.zzr != null) {
            Preconditions.checkMainThread("CastRemoteDisplayLocalService calls must be done on the main thread");
            this.zzv("removeMediaRouterCallback");
            this.zzr.j(this.zzu);
        }
        Context context0 = this.zzo;
        ServiceConnection serviceConnection0 = this.zzp;
        if(context0 != null && serviceConnection0 != null) {
            try {
                ConnectionTracker.getInstance().unbindService(context0, serviceConnection0);
            }
            catch(IllegalArgumentException unused_ex) {
                this.zzv("No need to unbind service, already unbound");
            }
        }
        this.zzp = null;
        this.zzo = null;
        this.zzf = null;
        this.zzj = null;
        this.zzn = null;
    }
}

