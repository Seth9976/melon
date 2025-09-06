package androidx.media3.session;

import android.content.ComponentName;
import android.os.Bundle;
import android.util.Log;
import androidx.media3.session.legacy.E;
import androidx.media3.session.legacy.j;

public final class U implements Runnable {
    public final int a;
    public final Y b;

    public U(Y y0, int v) {
        this.a = v;
        this.b = y0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            ComponentName componentName0 = this.b.c.a.d();
            V v0 = new V(this.b);
            Bundle bundle0 = this.b.b.c.a0();
            j j0 = new j(this.b.a, componentName0, v0, bundle0);
            this.b.i = j0;
            Log.d("MediaBrowserCompat", "Connecting to a MediaBrowserService.");
            j0.a.b.connect();
            return;
        }
        Y y0 = this.b;
        if(((E)y0.h.a).e.a() == null) {
            y0.i0();
        }
    }
}

