package p;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService.Stub;
import androidx.browser.customtabs.CustomTabsService;
import java.util.List;

public final class i extends Stub {
    public final CustomTabsService a;

    public i(CustomTabsService customTabsService0) {
        this.a = customTabsService0;
        super();
    }

    public static PendingIntent C0(Bundle bundle0) {
        if(bundle0 == null) {
            return null;
        }
        PendingIntent pendingIntent0 = (PendingIntent)bundle0.getParcelable("android.support.customtabs.extra.SESSION_ID");
        bundle0.remove("android.support.customtabs.extra.SESSION_ID");
        return pendingIntent0;
    }

    public final boolean D0(ICustomTabsCallback iCustomTabsCallback0, PendingIntent pendingIntent0) {
        m m0 = new m(iCustomTabsCallback0, pendingIntent0);
        try {
            h h0 = new h(this, m0);
            synchronized(this.a.a) {
                iCustomTabsCallback0.asBinder().linkToDeath(h0, 0);
                IBinder iBinder0 = iCustomTabsCallback0.asBinder();
                this.a.a.put(iBinder0, h0);
            }
            return this.a.c();
        }
        catch(RemoteException unused_ex) {
            return false;
        }
    }

    @Override  // android.support.customtabs.ICustomTabsService
    public final Bundle extraCommand(String s, Bundle bundle0) {
        return this.a.a();
    }

    @Override  // android.support.customtabs.ICustomTabsService
    public final boolean isEngagementSignalsApiAvailable(ICustomTabsCallback iCustomTabsCallback0, Bundle bundle0) {
        if(iCustomTabsCallback0 == null && i.C0(bundle0) == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        return false;
    }

    @Override  // android.support.customtabs.ICustomTabsService
    public final boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback0, Uri uri0, Bundle bundle0, List list0) {
        if(iCustomTabsCallback0 == null && i.C0(bundle0) == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        return this.a.b();
    }

    @Override  // android.support.customtabs.ICustomTabsService
    public final boolean newSession(ICustomTabsCallback iCustomTabsCallback0) {
        return this.D0(iCustomTabsCallback0, null);
    }

    @Override  // android.support.customtabs.ICustomTabsService
    public final boolean newSessionWithExtras(ICustomTabsCallback iCustomTabsCallback0, Bundle bundle0) {
        return this.D0(iCustomTabsCallback0, i.C0(bundle0));
    }

    @Override  // android.support.customtabs.ICustomTabsService
    public final int postMessage(ICustomTabsCallback iCustomTabsCallback0, String s, Bundle bundle0) {
        if(iCustomTabsCallback0 == null && i.C0(bundle0) == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        return this.a.d();
    }

    @Override  // android.support.customtabs.ICustomTabsService
    public final boolean receiveFile(ICustomTabsCallback iCustomTabsCallback0, Uri uri0, int v, Bundle bundle0) {
        if(iCustomTabsCallback0 == null && i.C0(bundle0) == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        return this.a.e();
    }

    @Override  // android.support.customtabs.ICustomTabsService
    public final boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback0, Uri uri0) {
        if(iCustomTabsCallback0 == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        new Bundle();
        return this.a.f();
    }

    @Override  // android.support.customtabs.ICustomTabsService
    public final boolean requestPostMessageChannelWithExtras(ICustomTabsCallback iCustomTabsCallback0, Uri uri0, Bundle bundle0) {
        if(iCustomTabsCallback0 == null && i.C0(bundle0) == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        if(bundle0 != null) {
            if(Build.VERSION.SDK_INT >= 33) {
                Uri uri1 = (Uri)a.a(bundle0, "target_origin", Uri.class);
                return this.a.f();
            }
            Uri uri2 = (Uri)bundle0.getParcelable("target_origin");
        }
        return this.a.f();
    }

    @Override  // android.support.customtabs.ICustomTabsService
    public final boolean setEngagementSignalsCallback(ICustomTabsCallback iCustomTabsCallback0, IBinder iBinder0, Bundle bundle0) {
        android.support.customtabs.IEngagementSignalsCallback.Stub.asInterface(iBinder0);
        if(iCustomTabsCallback0 == null && i.C0(bundle0) == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        return false;
    }

    @Override  // android.support.customtabs.ICustomTabsService
    public final boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback0, Bundle bundle0) {
        if(iCustomTabsCallback0 == null && i.C0(bundle0) == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        return this.a.g();
    }

    @Override  // android.support.customtabs.ICustomTabsService
    public final boolean validateRelationship(ICustomTabsCallback iCustomTabsCallback0, int v, Uri uri0, Bundle bundle0) {
        if(iCustomTabsCallback0 == null && i.C0(bundle0) == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        return this.a.h();
    }

    @Override  // android.support.customtabs.ICustomTabsService
    public final boolean warmup(long v) {
        return this.a.i();
    }
}

