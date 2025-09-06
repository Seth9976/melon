package androidx.browser.trusted;

import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.IBinder;
import java.util.Locale;
import q.a;
import q.b;

public abstract class TrustedWebActivityService extends Service {
    public NotificationManager a;
    public int b;
    public final b c;

    public TrustedWebActivityService() {
        this.b = -1;
        this.c = new b(this);
    }

    public static String a(String s) {
        return s.toLowerCase(Locale.ROOT).replace(' ', '_') + "_channel_id";
    }

    public abstract a b();

    public final int c() {
        try {
            Bundle bundle0 = this.getPackageManager().getServiceInfo(new ComponentName(this, this.getClass()), 0x80).metaData;
            return bundle0 == null ? -1 : bundle0.getInt("android.support.customtabs.trusted.SMALL_ICON", -1);
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            return -1;
        }
    }

    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        return this.c;
    }

    @Override  // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.a = (NotificationManager)this.getSystemService("notification");
    }

    @Override  // android.app.Service
    public final boolean onUnbind(Intent intent0) {
        this.b = -1;
        return super.onUnbind(intent0);
    }
}

