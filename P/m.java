package p;

import android.app.PendingIntent;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsCallback;

public final class m {
    public final ICustomTabsCallback a;
    public final PendingIntent b;

    public m(ICustomTabsCallback iCustomTabsCallback0, PendingIntent pendingIntent0) {
        if(iCustomTabsCallback0 == null && pendingIntent0 == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.a = iCustomTabsCallback0;
        this.b = pendingIntent0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 instanceof m) {
            PendingIntent pendingIntent0 = ((m)object0).b;
            int v = 1;
            PendingIntent pendingIntent1 = this.b;
            if(pendingIntent0 != null) {
                v = 0;
            }
            if((pendingIntent1 == null ? 1 : 0) == v) {
                if(pendingIntent1 != null) {
                    return pendingIntent1.equals(pendingIntent0);
                }
                ICustomTabsCallback iCustomTabsCallback0 = this.a;
                if(iCustomTabsCallback0 == null) {
                    throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
                }
                IBinder iBinder0 = iCustomTabsCallback0.asBinder();
                ICustomTabsCallback iCustomTabsCallback1 = ((m)object0).a;
                if(iCustomTabsCallback1 == null) {
                    throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
                }
                return iBinder0.equals(iCustomTabsCallback1.asBinder());
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        PendingIntent pendingIntent0 = this.b;
        if(pendingIntent0 != null) {
            return pendingIntent0.hashCode();
        }
        ICustomTabsCallback iCustomTabsCallback0 = this.a;
        if(iCustomTabsCallback0 == null) {
            throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
        }
        return iCustomTabsCallback0.asBinder().hashCode();
    }
}

