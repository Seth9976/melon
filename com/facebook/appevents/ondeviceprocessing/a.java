package com.facebook.appevents.ondeviceprocessing;

import android.content.Context;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettingsManager;

public final class a implements Runnable {
    public final int a;
    public final String b;
    public final Context c;
    public final String d;

    public a(Context context0, String s, String s1) {
        this.a = 1;
        super();
        this.b = s;
        this.c = context0;
        this.d = s1;
    }

    public a(Context context0, String s, String s1, int v) {
        this.a = v;
        this.c = context0;
        this.b = s;
        this.d = s1;
        super();
    }

    @Override
    public final void run() {
        switch(this.a) {
            case 0: {
                OnDeviceProcessingManager.sendInstallEventAsync$lambda$0(this.c, this.b, this.d);
                return;
            }
            case 1: {
                FetchedAppGateKeepersManager.a(this.c, this.b, this.d);
                return;
            }
            default: {
                FetchedAppSettingsManager.a(this.c, this.b, this.d);
            }
        }
    }
}

