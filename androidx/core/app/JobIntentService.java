package androidx.core.app;

import N1.h;
import N1.i;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.HashMap;

@Deprecated
public abstract class JobIntentService extends Service {
    public i a;
    public h b;

    static {
        new HashMap();
    }

    public abstract void a();

    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        return this.a == null ? null : this.a.getBinder();
    }

    @Override  // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.a = new i(this);
    }

    @Override  // android.app.Service
    public final int onStartCommand(Intent intent0, int v, int v1) {
        return 2;
    }
}

