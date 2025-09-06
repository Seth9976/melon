package com.melon.data.newlogin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.iloen.melon.utils.log.LogU;

public class AuthenticationService extends Service {
    public Authenticator a;

    @Override  // android.app.Service
    public final IBinder onBind(Intent intent0) {
        LogU.d("AuthenticationService", "onBind() ");
        return this.a.getIBinder();
    }

    @Override  // android.app.Service
    public final void onCreate() {
        LogU.d("AuthenticationService", "onCreate() ");
        this.a = new Authenticator(this);
    }

    @Override  // android.app.Service
    public final void onDestroy() {
        LogU.d("AuthenticationService", "onDestroy() ");
    }
}

