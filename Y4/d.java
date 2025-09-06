package Y4;

import U4.D;
import U4.a;
import U4.w;
import U4.x;
import V4.h;
import android.app.job.JobInfo.Builder;
import android.app.job.JobInfo.TriggerContentUri;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest.Builder;
import android.net.NetworkRequest;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import androidx.appcompat.app.o;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.background.systemjob.SystemJobService;
import d5.i;
import d5.j;
import d5.q;
import d5.s;
import d5.t;
import e0.b;
import e5.f;
import e5.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import je.n;
import je.p;

public final class d implements h {
    public final Context a;
    public final JobScheduler b;
    public final c c;
    public final WorkDatabase d;
    public final a e;
    public static final String f;

    static {
        d.f = "WM-SystemJobScheduler";
    }

    public d(Context context0, WorkDatabase workDatabase0, a a0) {
        JobScheduler jobScheduler0 = Y4.a.b(context0);
        c c0 = new c(context0, a0.d, a0.l);
        super();
        this.a = context0;
        this.b = jobScheduler0;
        this.c = c0;
        this.d = workDatabase0;
        this.e = a0;
    }

    public static void a(JobScheduler jobScheduler0, int v) {
        try {
            jobScheduler0.cancel(v);
        }
        catch(Throwable throwable0) {
            w.e().d("WM-SystemJobScheduler", String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", v), throwable0);
        }
    }

    @Override  // V4.h
    public final void b(String s) {
        ArrayList arrayList1;
        JobScheduler jobScheduler0 = this.b;
        ArrayList arrayList0 = d.e(this.a, jobScheduler0);
        if(arrayList0 == null) {
            arrayList1 = null;
        }
        else {
            ArrayList arrayList2 = new ArrayList(2);
            for(Object object0: arrayList0) {
                JobInfo jobInfo0 = (JobInfo)object0;
                j j0 = d.f(jobInfo0);
                if(j0 != null && s.equals(j0.a)) {
                    arrayList2.add(jobInfo0.getId());
                }
            }
            arrayList1 = arrayList2;
        }
        if(arrayList1 != null && !arrayList1.isEmpty()) {
            for(Object object1: arrayList1) {
                d.a(jobScheduler0, ((int)(((Integer)object1))));
            }
            i i0 = this.d.d();
            WorkDatabase_Impl workDatabase_Impl0 = (WorkDatabase_Impl)i0.a;
            workDatabase_Impl0.assertNotSuspendingTransaction();
            d5.h h0 = (d5.h)i0.d;
            H4.h h1 = h0.a();
            h1.k(1, s);
            try {
                workDatabase_Impl0.beginTransaction();
                try {
                    h1.w();
                    workDatabase_Impl0.setTransactionSuccessful();
                }
                catch(Throwable throwable0) {
                    workDatabase_Impl0.endTransaction();
                    throw throwable0;
                }
                workDatabase_Impl0.endTransaction();
            }
            finally {
                h0.n(h1);
            }
        }
    }

    @Override  // V4.h
    public final boolean c() {
        return true;
    }

    @Override  // V4.h
    public final void d(q[] arr_q) {
        int v2;
        a a0 = this.e;
        WorkDatabase workDatabase0 = this.d;
        g g0 = new g(workDatabase0, 0);
        for(int v = 0; v < arr_q.length; ++v) {
            q q0 = arr_q[v];
            workDatabase0.beginTransaction();
            try {
                s s0 = workDatabase0.g();
                String s1 = q0.a;
                q q1 = s0.j(s1);
                if(q1 == null) {
                    w.e().h("WM-SystemJobScheduler", "Skipping scheduling " + s1 + " because it\'s no longer in the DB");
                }
                else if(q1.b == D.a) {
                    j j0 = t.i(q0);
                    d5.g g1 = workDatabase0.d().f(j0);
                    if(g1 == null) {
                        a0.getClass();
                        f f0 = new f(g0, a0.i);
                        Object object0 = g0.a.runInTransaction(f0);
                        kotlin.jvm.internal.q.f(object0, "workDatabase.runInTransa…d\n            }\n        )");
                        v2 = ((Number)object0).intValue();
                    }
                    else {
                        v2 = g1.c;
                    }
                    if(g1 == null) {
                        d5.g g2 = new d5.g(j0.a, j0.b, v2);
                        workDatabase0.d().g(g2);
                    }
                    this.g(q0, v2);
                }
                else {
                    w.e().h("WM-SystemJobScheduler", "Skipping scheduling " + s1 + " because it is no longer enqueued");
                }
                workDatabase0.setTransactionSuccessful();
            }
            finally {
                workDatabase0.endTransaction();
            }
        }
    }

    public static ArrayList e(Context context0, JobScheduler jobScheduler0) {
        List list0 = Y4.a.a(jobScheduler0);
        if(list0 == null) {
            return null;
        }
        ArrayList arrayList0 = new ArrayList(list0.size());
        ComponentName componentName0 = new ComponentName(context0, SystemJobService.class);
        for(Object object0: list0) {
            JobInfo jobInfo0 = (JobInfo)object0;
            if(componentName0.equals(jobInfo0.getService())) {
                arrayList0.add(jobInfo0);
            }
        }
        return arrayList0;
    }

    public static j f(JobInfo jobInfo0) {
        PersistableBundle persistableBundle0 = jobInfo0.getExtras();
        if(persistableBundle0 != null) {
            try {
                if(persistableBundle0.containsKey("EXTRA_WORK_SPEC_ID")) {
                    int v = persistableBundle0.getInt("EXTRA_WORK_SPEC_GENERATION", 0);
                    return new j(persistableBundle0.getString("EXTRA_WORK_SPEC_ID"), v);
                }
                return null;
            }
            catch(NullPointerException unused_ex) {
            }
        }
        return null;
    }

    public final void g(q q0, int v) {
        c c0 = this.c;
        c0.getClass();
        U4.d d0 = q0.j;
        PersistableBundle persistableBundle0 = new PersistableBundle();
        String s = q0.a;
        persistableBundle0.putString("EXTRA_WORK_SPEC_ID", s);
        persistableBundle0.putInt("EXTRA_WORK_SPEC_GENERATION", q0.t);
        persistableBundle0.putBoolean("EXTRA_IS_PERIODIC", q0.c());
        JobInfo.Builder jobInfo$Builder0 = new JobInfo.Builder(v, c0.a).setRequiresCharging(d0.c);
        boolean z = d0.d;
        JobInfo.Builder jobInfo$Builder1 = jobInfo$Builder0.setRequiresDeviceIdle(z).setExtras(persistableBundle0);
        NetworkRequest networkRequest0 = d0.a();
        int v1 = Build.VERSION.SDK_INT;
        int v2 = 0;
        if(v1 < 28 || networkRequest0 == null) {
            int v3 = d0.a;
            if(v1 < 30 || v3 != 6) {
                int v4 = 3;
                int v5 = b.b(v3);
                switch(v5) {
                    case 0: {
                        v4 = 0;
                        break;
                    }
                    case 1: {
                        v4 = 1;
                        break;
                    }
                    default: {
                        if(v5 == 2) {
                            v4 = 2;
                        }
                        else if(v5 != 3) {
                            v4 = 4;
                            if(v5 != 4) {
                                w.e().a("WM-SystemJobInfoConvert", "API version too low. Cannot convert network type value " + x.A(v3));
                                v4 = 1;
                            }
                        }
                    }
                }
                jobInfo$Builder1.setRequiredNetworkType(v4);
            }
            else {
                jobInfo$Builder1.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
            }
        }
        else {
            kotlin.jvm.internal.q.g(jobInfo$Builder1, "builder");
            jobInfo$Builder1.setRequiredNetwork(networkRequest0);
        }
        if(!z) {
            jobInfo$Builder1.setBackoffCriteria(q0.m, (q0.l == 2 ? 0 : 1));
        }
        long v6 = q0.a();
        c0.b.getClass();
        long v7 = Math.max(v6 - System.currentTimeMillis(), 0L);
        if(v1 <= 28) {
            jobInfo$Builder1.setMinimumLatency(v7);
        }
        else if(v7 > 0L) {
            jobInfo$Builder1.setMinimumLatency(v7);
        }
        else if(!q0.q && c0.c) {
            B0.q.p(jobInfo$Builder1);
        }
        if(d0.b()) {
            for(Object object0: d0.i) {
                jobInfo$Builder1.addTriggerContentUri(new JobInfo.TriggerContentUri(((U4.c)object0).a, ((int)((U4.c)object0).b)));
            }
            jobInfo$Builder1.setTriggerContentUpdateDelay(d0.g);
            jobInfo$Builder1.setTriggerContentMaxDelay(d0.h);
        }
        jobInfo$Builder1.setPersisted(false);
        int v8 = Build.VERSION.SDK_INT;
        jobInfo$Builder1.setRequiresBatteryNotLow(d0.e);
        jobInfo$Builder1.setRequiresStorageNotLow(d0.f);
        if(v8 >= 0x1F && q0.q && q0.k <= 0 && v7 <= 0L) {
            B0.t.o(jobInfo$Builder1);
        }
        if(v8 >= 35) {
            String s1 = q0.x;
            if(s1 != null) {
                jobInfo$Builder1.setTraceTag(s1);
            }
        }
        JobInfo jobInfo0 = jobInfo$Builder1.build();
        w.e().a("WM-SystemJobScheduler", "Scheduling work ID " + s + "Job ID " + v);
        try {
            if(this.b.schedule(jobInfo0) == 0) {
                w.e().h("WM-SystemJobScheduler", "Unable to schedule work ID " + s);
                if(q0.q && q0.r == 1) {
                    q0.q = false;
                    w.e().a("WM-SystemJobScheduler", "Scheduling a non-expedited job (work ID " + s + ")");
                    this.g(q0, v);
                }
            }
        }
        catch(IllegalStateException illegalStateException0) {
            Context context0 = this.a;
            kotlin.jvm.internal.q.g(context0, "context");
            kotlin.jvm.internal.q.g(this.d, "workDatabase");
            a a0 = this.e;
            kotlin.jvm.internal.q.g(a0, "configuration");
            int v9 = Build.VERSION.SDK_INT;
            int v10 = this.d.g().h().size();
            String s2 = "<faulty JobScheduler failed to getPendingJobs>";
            if(v9 >= 34) {
                JobScheduler jobScheduler0 = Y4.a.b(context0);
                List list0 = Y4.a.a(jobScheduler0);
                if(list0 != null) {
                    ArrayList arrayList0 = d.e(context0, jobScheduler0);
                    int v11 = arrayList0 == null ? 0 : list0.size() - arrayList0.size();
                    String s3 = null;
                    Object object1 = context0.getSystemService("jobscheduler");
                    kotlin.jvm.internal.q.e(object1, "null cannot be cast to non-null type android.app.job.JobScheduler");
                    ArrayList arrayList1 = d.e(context0, ((JobScheduler)object1));
                    if(arrayList1 != null) {
                        v2 = arrayList1.size();
                    }
                    if(v2 != 0) {
                        s3 = v2 + " from WorkManager in the default namespace";
                    }
                    s2 = p.q0(n.g0(new String[]{list0.size() + " jobs in \"androidx.work.systemjobscheduler\" namespace", (v11 == 0 ? null : v11 + " of which are not owned by WorkManager"), s3}), ",\n", null, null, null, 62);
                }
            }
            else {
                ArrayList arrayList2 = d.e(context0, Y4.a.b(context0));
                if(arrayList2 != null) {
                    s2 = arrayList2.size() + " jobs from WorkManager";
                }
            }
            StringBuilder stringBuilder0 = x.o((v9 < 0x1F ? 100 : 150), "JobScheduler ", " job limit exceeded.\nIn JobScheduler there are ", s2, ".\nThere are ");
            stringBuilder0.append(v10);
            stringBuilder0.append(" jobs tracked by WorkManager\'s database;\nthe Configuration limit is ");
            String s4 = o.q(stringBuilder0, a0.k, '.');
            w.e().c("WM-SystemJobScheduler", s4);
            throw new IllegalStateException(s4, illegalStateException0);
        }
        catch(Throwable throwable0) {
            w.e().d("WM-SystemJobScheduler", "Unable to schedule " + q0, throwable0);
        }
    }
}

