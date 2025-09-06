package p;

import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;

public final class b extends k {
    public final Context a;

    public b(Context context0) {
        this.a = context0;
    }

    @Override  // p.k
    public final void onCustomTabsServiceConnected(ComponentName componentName0, d d0) {
        try {
            d0.a.warmup(0L);
        }
        catch(RemoteException unused_ex) {
        }
        this.a.unbindService(this);
    }

    @Override  // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName0) {
    }
}

