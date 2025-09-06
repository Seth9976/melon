package androidx.media3.session.legacy;

import E9.g;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.lifecycle.b;
import com.iloen.melon.utils.a;

public final class v implements Runnable {
    public final z a;
    public final String b;
    public final int c;
    public final int d;
    public final Bundle e;
    public final b f;

    public v(b b0, z z0, String s, int v, int v1, Bundle bundle0) {
        this.f = b0;
        this.a = z0;
        this.b = s;
        this.c = v;
        this.d = v1;
        this.e = bundle0;
    }

    @Override
    public final void run() {
        z z0 = this.a;
        IBinder iBinder0 = z0.a.getBinder();
        ((MediaBrowserServiceCompat)this.f.b).e.remove(iBinder0);
        MediaBrowserServiceCompat mediaBrowserServiceCompat0 = (MediaBrowserServiceCompat)this.f.b;
        String s = this.b;
        n n0 = new n(mediaBrowserServiceCompat0, s, this.c, this.d, z0);
        mediaBrowserServiceCompat0.f = n0;
        g g0 = mediaBrowserServiceCompat0.c(this.e);
        mediaBrowserServiceCompat0.f = null;
        if(g0 == null) {
            StringBuilder stringBuilder0 = a.n("No root for client ", s, " from service ");
            stringBuilder0.append("androidx.media3.session.legacy.v");
            Log.i("MBServiceCompat", stringBuilder0.toString());
            try {
                z0.b(2, null);
            }
            catch(RemoteException unused_ex) {
                Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + s);
            }
            return;
        }
        try {
            mediaBrowserServiceCompat0.e.put(iBinder0, n0);
            iBinder0.linkToDeath(n0, 0);
            MediaSessionCompat.Token mediaSessionCompat$Token0 = mediaBrowserServiceCompat0.h;
            if(mediaSessionCompat$Token0 != null) {
                z0.a(((String)g0.a), mediaSessionCompat$Token0, ((Bundle)g0.b));
            }
        }
        catch(RemoteException unused_ex) {
            Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + s);
            mediaBrowserServiceCompat0.e.remove(iBinder0);
        }
    }
}

