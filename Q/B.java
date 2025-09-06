package q;

import N1.z;
import android.app.Notification.Builder;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.StatusBarNotification;
import android.support.customtabs.trusted.ITrustedWebActivityService.Stub;
import androidx.browser.trusted.TrustedWebActivityService;
import df.d;

public final class b extends Stub {
    public final TrustedWebActivityService a;

    public b(TrustedWebActivityService trustedWebActivityService0) {
        this.a = trustedWebActivityService0;
        super();
    }

    public final void C0() {
        TrustedWebActivityService trustedWebActivityService0 = this.a;
        int v = trustedWebActivityService0.b;
        if(v != -1) {
            if(v != Binder.getCallingUid()) {
                throw new SecurityException("Caller is not verified as Trusted Web Activity provider.");
            }
            return;
        }
        trustedWebActivityService0.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        trustedWebActivityService0.b();
        throw null;
    }

    @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
    public final Bundle areNotificationsEnabled(Bundle bundle0) {
        boolean z = false;
        this.C0();
        d.m(bundle0, "android.support.customtabs.trusted.CHANNEL_NAME");
        String s = bundle0.getString("android.support.customtabs.trusted.CHANNEL_NAME");
        TrustedWebActivityService trustedWebActivityService0 = this.a;
        if(trustedWebActivityService0.a == null) {
            throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
        }
        if(new z(trustedWebActivityService0).b.areNotificationsEnabled()) {
            NotificationChannel notificationChannel0 = trustedWebActivityService0.a.getNotificationChannel(TrustedWebActivityService.a(s));
            if(notificationChannel0 == null || notificationChannel0.getImportance() != 0) {
                z = true;
            }
        }
        Bundle bundle1 = new Bundle();
        bundle1.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", z);
        return bundle1;
    }

    @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
    public final void cancelNotification(Bundle bundle0) {
        this.C0();
        d.m(bundle0, "android.support.customtabs.trusted.PLATFORM_TAG");
        d.m(bundle0, "android.support.customtabs.trusted.PLATFORM_ID");
        String s = bundle0.getString("android.support.customtabs.trusted.PLATFORM_TAG");
        int v = bundle0.getInt("android.support.customtabs.trusted.PLATFORM_ID");
        NotificationManager notificationManager0 = this.a.a;
        if(notificationManager0 == null) {
            throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
        }
        notificationManager0.cancel(s, v);
    }

    @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
    public final Bundle extraCommand(String s, Bundle bundle0, IBinder iBinder0) {
        this.C0();
        if(iBinder0 != null) {
            android.support.customtabs.trusted.ITrustedWebActivityCallback.Stub.asInterface(iBinder0);
        }
        this.a.getClass();
        return null;
    }

    @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
    public final Bundle getActiveNotifications() {
        this.C0();
        NotificationManager notificationManager0 = this.a.a;
        if(notificationManager0 == null) {
            throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
        }
        StatusBarNotification[] arr_statusBarNotification = notificationManager0.getActiveNotifications();
        Bundle bundle0 = new Bundle();
        bundle0.putParcelableArray("android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS", arr_statusBarNotification);
        return bundle0;
    }

    @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
    public final Bundle getSmallIconBitmap() {
        this.C0();
        TrustedWebActivityService trustedWebActivityService0 = this.a;
        int v = trustedWebActivityService0.c();
        Bundle bundle0 = new Bundle();
        if(v == -1) {
            return bundle0;
        }
        bundle0.putParcelable("android.support.customtabs.trusted.SMALL_ICON_BITMAP", BitmapFactory.decodeResource(trustedWebActivityService0.getResources(), v));
        return bundle0;
    }

    @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
    public final int getSmallIconId() {
        this.C0();
        return this.a.c();
    }

    @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
    public final Bundle notifyNotificationWithChannel(Bundle bundle0) {
        Notification notification1;
        boolean z = false;
        this.C0();
        d.m(bundle0, "android.support.customtabs.trusted.PLATFORM_TAG");
        d.m(bundle0, "android.support.customtabs.trusted.PLATFORM_ID");
        d.m(bundle0, "android.support.customtabs.trusted.NOTIFICATION");
        d.m(bundle0, "android.support.customtabs.trusted.CHANNEL_NAME");
        String s = bundle0.getString("android.support.customtabs.trusted.PLATFORM_TAG");
        int v = bundle0.getInt("android.support.customtabs.trusted.PLATFORM_ID");
        Notification notification0 = (Notification)bundle0.getParcelable("android.support.customtabs.trusted.NOTIFICATION");
        String s1 = bundle0.getString("android.support.customtabs.trusted.CHANNEL_NAME");
        TrustedWebActivityService trustedWebActivityService0 = this.a;
        if(trustedWebActivityService0.a == null) {
            throw new IllegalStateException("TrustedWebActivityService has not been properly initialized. Did onCreate() call super.onCreate()?");
        }
        if(new z(trustedWebActivityService0).b.areNotificationsEnabled()) {
            String s2 = TrustedWebActivityService.a(s1);
            NotificationManager notificationManager0 = trustedWebActivityService0.a;
            notificationManager0.createNotificationChannel(new NotificationChannel(s2, s1, 3));
            if(notificationManager0.getNotificationChannel(s2).getImportance() == 0) {
                notification1 = null;
            }
            else {
                Notification.Builder notification$Builder0 = Notification.Builder.recoverBuilder(trustedWebActivityService0, notification0);
                notification$Builder0.setChannelId(s2);
                notification1 = notification$Builder0.build();
            }
            NotificationChannel notificationChannel0 = trustedWebActivityService0.a.getNotificationChannel(s2);
            if(notificationChannel0 == null || notificationChannel0.getImportance() != 0) {
                trustedWebActivityService0.a.notify(s, v, notification1);
                z = true;
            }
        }
        Bundle bundle1 = new Bundle();
        bundle1.putBoolean("android.support.customtabs.trusted.NOTIFICATION_SUCCESS", z);
        return bundle1;
    }
}

