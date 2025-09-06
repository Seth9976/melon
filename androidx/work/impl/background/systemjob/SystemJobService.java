package androidx.work.impl.background.systemjob;

import D2.E0;
import U4.w;
import V4.c;
import V4.k;
import V4.s;
import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.PersistableBundle;
import d5.j;
import d5.l;
import ea.a;
import java.util.Arrays;
import java.util.HashMap;

public class SystemJobService extends JobService implements c {
    public s a;
    public final HashMap b;
    public final E0 c;
    public a d;
    public static final String e;

    static {
        SystemJobService.e = "WM-SystemJobService";
    }

    public SystemJobService() {
        this.b = new HashMap();
        this.c = new E0(1);
    }

    public static void a(String s) {
        if(Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Cannot invoke " + s + " on a background thread");
        }
    }

    public static j b(JobParameters jobParameters0) {
        try {
            PersistableBundle persistableBundle0 = jobParameters0.getExtras();
            return persistableBundle0 == null || !persistableBundle0.containsKey("EXTRA_WORK_SPEC_ID") ? null : new j(persistableBundle0.getString("EXTRA_WORK_SPEC_ID"), persistableBundle0.getInt("EXTRA_WORK_SPEC_GENERATION"));
        }
        catch(NullPointerException unused_ex) {
        }
        return null;
    }

    @Override  // V4.c
    public final void e(j j0, boolean z) {
        SystemJobService.a("onExecuted");
        w.e().a("WM-SystemJobService", j0.a + " executed on JobScheduler");
        JobParameters jobParameters0 = (JobParameters)this.b.remove(j0);
        this.c.c(j0);
        if(jobParameters0 != null) {
            this.jobFinished(jobParameters0, z);
        }
    }

    @Override  // android.app.Service
    public final void onCreate() {
        super.onCreate();
        try {
            s s0 = s.c0(this.getApplicationContext());
            this.a = s0;
            this.d = new a(s0.m, s0.k);
            s0.m.a(this);
        }
        catch(IllegalStateException illegalStateException0) {
            Class class0 = this.getApplication().getClass();
            if(!Application.class.equals(class0)) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", illegalStateException0);
            }
            w.e().h("WM-SystemJobService", "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
        }
    }

    @Override  // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        s s0 = this.a;
        if(s0 != null) {
            s0.m.e(this);
        }
    }

    @Override  // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters0) {
        SystemJobService.a("onStartJob");
        if(this.a == null) {
            w.e().a("WM-SystemJobService", "WorkManager is not initialized; requesting retry.");
            this.jobFinished(jobParameters0, true);
            return false;
        }
        j j0 = SystemJobService.b(jobParameters0);
        if(j0 == null) {
            w.e().c("WM-SystemJobService", "WorkSpec id not found!");
            return false;
        }
        HashMap hashMap0 = this.b;
        if(hashMap0.containsKey(j0)) {
            w.e().a("WM-SystemJobService", "Job is already being executed by SystemJobService: " + j0);
            return false;
        }
        w.e().a("WM-SystemJobService", "onStartJob for " + j0);
        hashMap0.put(j0, jobParameters0);
        int v = Build.VERSION.SDK_INT;
        l l0 = new l(4);
        if(jobParameters0.getTriggeredContentUris() != null) {
            l0.c = Arrays.asList(jobParameters0.getTriggeredContentUris());
        }
        if(jobParameters0.getTriggeredContentAuthorities() != null) {
            l0.b = Arrays.asList(jobParameters0.getTriggeredContentAuthorities());
        }
        if(v >= 28) {
            P1.a.f(jobParameters0);
        }
        a a0 = this.d;
        k k0 = this.c.e(j0);
        a0.getClass();
        ((f5.a)a0.b).a(new I7.k(a0, k0, l0, 5));
        return true;
    }

    @Override  // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters0) {
        SystemJobService.a("onStopJob");
        if(this.a == null) {
            w.e().a("WM-SystemJobService", "WorkManager is not initialized; requesting retry.");
            return true;
        }
        j j0 = SystemJobService.b(jobParameters0);
        if(j0 == null) {
            w.e().c("WM-SystemJobService", "WorkSpec id not found!");
            return false;
        }
        w.e().a("WM-SystemJobService", "onStopJob for " + j0);
        this.b.remove(j0);
        k k0 = this.c.c(j0);
        if(k0 != null) {
            int v = Build.VERSION.SDK_INT < 0x1F ? 0xFFFFFE00 : V1.a.a(jobParameters0);
            a a0 = this.d;
            a0.getClass();
            a0.y(k0, v);
        }
        Object object0 = this.a.m.k;
        return !this.a.m.i.contains(j0.a);
    }
}

