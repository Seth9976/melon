package androidx.media3.session;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.session.MediaSession.Token;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import b3.F;
import e3.b;
import java.util.List;

public final class y1 {
    public final x1 a;
    public static final String b;
    public static final String c;

    static {
        F.a("media3.session");
        y1.b = "0";
        y1.c = "1";
    }

    public y1(int v, int v1, int v2, String s, m m0, Bundle bundle0, MediaSession.Token mediaSession$Token0) {
        s.getClass();
        IBinder iBinder0 = m0.asBinder();
        bundle0.getClass();
        this.a = new z1(v, 0, v1, v2, s, "", null, iBinder0, bundle0, mediaSession$Token0);
    }

    public y1(Context context0, ComponentName componentName0) {
        b.h(context0, "context must not be null");
        int v2;
        int v1;
        int v;
        PackageManager packageManager0 = context0.getPackageManager();
        String s = componentName0.getPackageName();
        try {
            v = -1;
            v = packageManager0.getApplicationInfo(s, 0).uid;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
        boolean z = false;
        if(y1.a(packageManager0, "androidx.media3.session.MediaLibraryService", componentName0)) {
            z = true;
            v1 = 2;
        }
        else if(y1.a(packageManager0, "androidx.media3.session.MediaSessionService", componentName0)) {
            z = true;
            v1 = 1;
        }
        if(z) {
            v2 = v1;
        }
        else if(y1.a(packageManager0, "android.media.browse.MediaBrowserService", componentName0)) {
            v2 = 101;
        }
        else {
            throw new IllegalArgumentException("Failed to resolve SessionToken for " + componentName0 + ". Manifest doesn\'t declare one of either MediaSessionService, MediaLibraryService, MediaBrowserService or MediaBrowserServiceCompat. Use service\'s full name.");
        }
        if(v2 != 101) {
            this.a = new z1(v, v2, 0, 0, componentName0.getPackageName(), componentName0.getClassName(), componentName0, null, Bundle.EMPTY, null);
            return;
        }
        this.a = new A1(null, v, 101, componentName0, componentName0.getPackageName(), Bundle.EMPTY);
    }

    public static boolean a(PackageManager packageManager0, String s, ComponentName componentName0) {
        Intent intent0 = new Intent(s);
        intent0.setPackage(componentName0.getPackageName());
        List list0 = packageManager0.queryIntentServices(intent0, 0x80);
        if(list0 != null) {
            for(int v = 0; v < list0.size(); ++v) {
                ResolveInfo resolveInfo0 = (ResolveInfo)list0.get(v);
                if(resolveInfo0 != null && (resolveInfo0.serviceInfo != null && TextUtils.equals(resolveInfo0.serviceInfo.name, componentName0.getClassName()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Bundle b() {
        Bundle bundle0 = new Bundle();
        x1 x10 = this.a;
        if(x10 instanceof z1) {
            bundle0.putInt("0", 0);
        }
        else {
            bundle0.putInt("0", 1);
        }
        bundle0.putBundle("1", x10.toBundle());
        return bundle0;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof y1 ? this.a.equals(((y1)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return this.a.toString();
    }
}

