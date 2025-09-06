package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import Kc.g;
import Q5.j;
import Q5.u;
import a6.a;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import d5.m;

public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    public static final int a;

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        String s = intent0.getData().getQueryParameter("backendName");
        String s1 = intent0.getData().getQueryParameter("extras");
        int v = (int)Integer.valueOf(intent0.getData().getQueryParameter("priority"));
        int v1 = intent0.getExtras().getInt("attemptNumber");
        u.b(context0);
        m m0 = j.a();
        m0.w(s);
        m0.d = a.b(v);
        if(s1 != null) {
            m0.c = Base64.decode(s1, 0);
        }
        u u0 = u.a();
        j j0 = m0.e();
        A5.a a0 = new A5.a(8);
        g g0 = new g(u0.d, j0, v1, a0);
        u0.d.e.execute(g0);
    }
}

