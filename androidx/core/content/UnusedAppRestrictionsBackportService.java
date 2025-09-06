package androidx.core.content;

import P1.h;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public abstract class UnusedAppRestrictionsBackportService extends Service {
    public final h a;

    public UnusedAppRestrictionsBackportService() {
        this.a = new h(this);
    }

    public abstract void a();

    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        return this.a;
    }
}

