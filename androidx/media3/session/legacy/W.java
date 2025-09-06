package androidx.media3.session.legacy;

import android.os.IBinder;
import androidx.lifecycle.b;

public final class w implements Runnable {
    public final int a;
    public final z b;
    public final b c;

    public w(b b0, z z0, int v) {
        this.a = v;
        this.c = b0;
        this.b = z0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            IBinder iBinder0 = this.b.a.getBinder();
            n n0 = (n)((MediaBrowserServiceCompat)this.c.b).e.remove(iBinder0);
            if(n0 != null) {
                iBinder0.unlinkToDeath(n0, 0);
            }
            return;
        }
        IBinder iBinder1 = this.b.a.getBinder();
        n n1 = (n)((MediaBrowserServiceCompat)this.c.b).e.remove(iBinder1);
        if(n1 != null) {
            n1.e.getClass();
            ((z)n1.e).a.getBinder().unlinkToDeath(n1, 0);
        }
    }
}

