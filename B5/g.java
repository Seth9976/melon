package b5;

import U4.w;
import Z4.d;
import android.content.Context;
import android.net.ConnectivityManager;
import f5.a;
import kotlin.jvm.internal.q;

public final class g extends e {
    public final ConnectivityManager f;
    public final d g;

    public g(Context context0, a a0) {
        super(context0, a0);
        Object object0 = this.b.getSystemService("connectivity");
        q.e(object0, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.f = (ConnectivityManager)object0;
        this.g = new d(this, 1);
    }

    @Override  // b5.e
    public final Object a() {
        return h.a(this.f);
    }

    @Override  // b5.e
    public final void c() {
        try {
            w.e().a("WM-NetworkStateTracker", "Registering network callback");
            q.g(this.f, "<this>");
            q.g(this.g, "networkCallback");
            this.f.registerDefaultNetworkCallback(this.g);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            w.e().d("WM-NetworkStateTracker", "Received exception while registering network callback", illegalArgumentException0);
        }
        catch(SecurityException securityException0) {
            w.e().d("WM-NetworkStateTracker", "Received exception while registering network callback", securityException0);
        }
    }

    @Override  // b5.e
    public final void d() {
        try {
            w.e().a("WM-NetworkStateTracker", "Unregistering network callback");
            q.g(this.f, "<this>");
            q.g(this.g, "networkCallback");
            this.f.unregisterNetworkCallback(this.g);
        }
        catch(IllegalArgumentException illegalArgumentException0) {
            w.e().d("WM-NetworkStateTracker", "Received exception while unregistering network callback", illegalArgumentException0);
        }
        catch(SecurityException securityException0) {
            w.e().d("WM-NetworkStateTracker", "Received exception while unregistering network callback", securityException0);
        }
    }
}

