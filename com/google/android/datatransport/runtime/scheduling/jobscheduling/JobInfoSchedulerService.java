package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import Kc.g;
import Q5.j;
import Q5.u;
import a6.a;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import d5.m;

public class JobInfoSchedulerService extends JobService {
    public static final int a;

    @Override  // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters0) {
        String s = jobParameters0.getExtras().getString("backendName");
        String s1 = jobParameters0.getExtras().getString("extras");
        int v = jobParameters0.getExtras().getInt("priority");
        int v1 = jobParameters0.getExtras().getInt("attemptNumber");
        u.b(this.getApplicationContext());
        m m0 = j.a();
        m0.w(s);
        m0.d = a.b(v);
        if(s1 != null) {
            m0.c = Base64.decode(s1, 0);
        }
        u u0 = u.a();
        j j0 = m0.e();
        A3.m m1 = new A3.m(6, this, jobParameters0);
        g g0 = new g(u0.d, j0, v1, m1);
        u0.d.e.execute(g0);
        return true;
    }

    @Override  // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters0) {
        return true;
    }
}

