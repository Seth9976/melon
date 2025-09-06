package androidx.car.app;

import A.a;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.car.app.utils.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Objects;

public abstract class CarAppService extends Service {
    public final HashMap a;
    public AppInfo b;

    public CarAppService() {
        this.a = new HashMap();
    }

    public abstract a a();

    @Override  // android.app.Service
    public final void dump(FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        super.dump(fileDescriptor0, printWriter0, arr_s);
        for(int v = 0; v < arr_s.length; ++v) {
            if("AUTO_DRIVE".equals(arr_s[v])) {
                h.a(new f(this));
            }
        }
    }

    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        Bundle bundle0 = intent0.getExtras();
        SessionInfo sessionInfo0 = (bundle0 == null ? false : bundle0.containsKey("androidx.car.app.extra.SESSION_INFO_BUNDLE")) ? x1.a.r(intent0) : SessionInfo.DEFAULT_SESSION_INFO;
        synchronized(this.a) {
            if(!this.a.containsKey(sessionInfo0)) {
                CarAppBinder carAppBinder0 = new CarAppBinder(this, sessionInfo0);
                this.a.put(sessionInfo0, carAppBinder0);
            }
            IBinder iBinder0 = (CarAppBinder)this.a.get(sessionInfo0);
            Objects.requireNonNull(iBinder0);
            return iBinder0;
        }
    }

    @Override  // android.app.Service
    public final void onDestroy() {
        synchronized(this.a) {
            for(Object object0: this.a.values()) {
                ((CarAppBinder)object0).destroy();
            }
            this.a.clear();
        }
    }

    @Override  // android.app.Service
    public final boolean onUnbind(Intent intent0) {
        if(Log.isLoggable("CarApp", 3)) {
            Log.d("CarApp", "onUnbind intent: " + intent0);
        }
        Bundle bundle0 = intent0.getExtras();
        h.a(new g(0, this, ((bundle0 == null ? false : bundle0.containsKey("androidx.car.app.extra.SESSION_INFO_BUNDLE")) ? x1.a.r(intent0) : SessionInfo.DEFAULT_SESSION_INFO)));
        if(Log.isLoggable("CarApp", 3)) {
            Log.d("CarApp", "onUnbind completed");
        }
        return true;
    }
}

