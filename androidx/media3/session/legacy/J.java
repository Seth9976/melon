package androidx.media3.session.legacy;

import Q0.a;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import x9.c;

public final class j {
    public final i a;
    public static final boolean b;

    static {
        j.b = Log.isLoggable("MediaBrowserCompat", 3);
    }

    public j(Context context0, ComponentName componentName0, a a0, Bundle bundle0) {
        this.a = new i(context0, componentName0, a0, bundle0);
    }

    public final void a() {
        i i0 = this.a;
        c c0 = i0.f;
        if(c0 != null) {
            Messenger messenger0 = i0.g;
            if(messenger0 != null) {
                try {
                    c0.f(7, null, messenger0);
                }
                catch(RemoteException unused_ex) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
        }
        i0.b.disconnect();
    }
}

