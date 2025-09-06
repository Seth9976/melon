package com.google.firebase.messaging;

import V6.b;
import V6.c;
import W6.a;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.BaseBundle;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.e;
import java.util.ArrayDeque;
import k8.Y;

public final class k implements Application.ActivityLifecycleCallbacks {
    public final ArrayDeque a;

    public k() {
        this.a = new ArrayDeque(10);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity0, Bundle bundle0) {
        BaseBundle baseBundle0;
        Intent intent0 = activity0.getIntent();
        if(intent0 != null) {
            try {
                ArrayDeque arrayDeque0 = this.a;
                baseBundle0 = null;
                Bundle bundle1 = intent0.getExtras();
                if(bundle1 == null) {
                    goto label_16;
                }
                else {
                    String s = bundle1.getString("google.message_id");
                    if(s == null) {
                        s = bundle1.getString("message_id");
                    }
                    if(TextUtils.isEmpty(s)) {
                        baseBundle0 = bundle1.getBundle("gcm.n.analytics_data");
                        goto label_16;
                    }
                    else if(!arrayDeque0.contains(s)) {
                        arrayDeque0.add(s);
                        baseBundle0 = bundle1.getBundle("gcm.n.analytics_data");
                        goto label_16;
                    }
                }
                return;
            }
            catch(RuntimeException runtimeException0) {
            }
            Log.w("FirebaseMessaging", "Failed trying to get analytics data from Intent extras.", runtimeException0);
        label_16:
            if((baseBundle0 == null ? false : "1".equals(baseBundle0.getString("google.c.a.e")))) {
                if(baseBundle0 != null) {
                    if("1".equals(baseBundle0.getString("google.c.a.tc"))) {
                        b b0 = (b)e.c().b(b.class);
                        if(Log.isLoggable("FirebaseMessaging", 3)) {
                            Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
                        }
                        if(b0 == null) {
                            Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
                        }
                        else {
                            String s1 = baseBundle0.getString("google.c.a.c_id");
                            if(a.a("fcm") && a.c("fcm", "_ln")) {
                                ((c)b0).a.setUserProperty("fcm", "_ln", s1);
                            }
                            Bundle bundle2 = Y.c("source", "Firebase", "medium", "notification");
                            bundle2.putString("campaign", s1);
                            ((c)b0).a("fcm", "_cmp", bundle2);
                        }
                    }
                    else if(Log.isLoggable("FirebaseMessaging", 3)) {
                        Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
                    }
                }
                Q1.c.K(((Bundle)baseBundle0), "_no");
            }
        }
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity0, Bundle bundle0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity0) {
    }
}

