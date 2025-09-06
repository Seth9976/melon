package com.facebook;

import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEventQueue;
import com.facebook.appevents.FlushStatistics;
import com.facebook.appevents.SessionEventsState;
import com.facebook.login.DeviceAuthDialog;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a implements Callback {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;

    public a(Object object0, Object object1, Object object2, Object object3, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        this.e = object3;
        super();
    }

    @Override  // com.facebook.GraphRequest$Callback
    public final void onCompleted(GraphResponse graphResponse0) {
        switch(this.a) {
            case 0: {
                AccessTokenManager.refreshCurrentAccessTokenImpl$lambda$1(((AtomicBoolean)this.b), ((HashSet)this.c), ((HashSet)this.d), ((HashSet)this.e), graphResponse0);
                return;
            }
            case 1: {
                AppEventQueue.e(((AccessTokenAppIdPair)this.b), ((GraphRequest)this.c), ((SessionEventsState)this.d), ((FlushStatistics)this.e), graphResponse0);
                return;
            }
            default: {
                DeviceAuthDialog.s(((DeviceAuthDialog)this.b), ((String)this.c), ((Date)this.d), ((Date)this.e), graphResponse0);
            }
        }
    }
}

