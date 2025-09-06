package com.facebook.appevents.gps.ara;

import com.facebook.appevents.AppEvent;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;

public final class a implements Runnable {
    public final int a;
    public final String b;
    public final AppEvent c;

    public a(String s, AppEvent appEvent0, int v) {
        this.a = v;
        this.b = s;
        this.c = appEvent0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            OnDeviceProcessingManager.b(this.b, this.c);
            return;
        }
        GpsAraTriggersManager.registerTriggerAsync$lambda$0(this.b, this.c);
    }
}

