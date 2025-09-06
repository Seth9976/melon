package androidx.car.app;

import android.util.Log;

public final class f implements Runnable {
    public final CarAppService a;

    public f(CarAppService carAppService0) {
        this.a = carAppService0;
    }

    @Override
    public final void run() {
        synchronized(this.a.a) {
            for(Object object0: this.a.a.values()) {
                CarAppBinder carAppBinder0 = (CarAppBinder)object0;
                if(Log.isLoggable("CarApp", 3)) {
                    Log.d("CarApp", "Executing onAutoDriveEnabled for " + carAppBinder0.getCurrentSessionInfo());
                }
            }
        }
    }
}

