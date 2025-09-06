package com.google.android.exoplayer2.scheduler;

import android.annotation.TargetApi;
import android.app.job.JobInfo.Builder;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

@TargetApi(21)
public final class PlatformScheduler implements Scheduler {
    public static final class PlatformSchedulerService extends JobService {
        @Override  // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters0) {
            PersistableBundle persistableBundle0 = jobParameters0.getExtras();
            if(new Requirements(persistableBundle0.getInt("requirements")).checkRequirements(this)) {
                String s = persistableBundle0.getString("service_action");
                String s1 = persistableBundle0.getString("service_package");
                Intent intent0 = new Intent(((String)Assertions.checkNotNull(s))).setPackage(s1);
                stringBuilder0.toString();
                Util.startForegroundService(this, intent0);
                return false;
            }
            this.jobFinished(jobParameters0, true);
            return false;
        }

        @Override  // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters0) {
            return false;
        }
    }

    private static final boolean DEBUG = false;
    private static final String KEY_REQUIREMENTS = "requirements";
    private static final String KEY_SERVICE_ACTION = "service_action";
    private static final String KEY_SERVICE_PACKAGE = "service_package";
    private static final String TAG = "PlatformScheduler";
    private final int jobId;
    private final JobScheduler jobScheduler;
    private final ComponentName jobServiceComponentName;

    public PlatformScheduler(Context context0, int v) {
        Context context1 = context0.getApplicationContext();
        this.jobId = v;
        this.jobServiceComponentName = new ComponentName(context1, PlatformSchedulerService.class);
        this.jobScheduler = (JobScheduler)context1.getSystemService("jobscheduler");
    }

    public static void access$000(String s) {
    }

    private static JobInfo buildJobInfo(int v, ComponentName componentName0, Requirements requirements0, String s, String s1) {
        JobInfo.Builder jobInfo$Builder0 = new JobInfo.Builder(v, componentName0);
        if(requirements0.isUnmeteredNetworkRequired()) {
            jobInfo$Builder0.setRequiredNetworkType(2);
        }
        else if(requirements0.isNetworkRequired()) {
            jobInfo$Builder0.setRequiredNetworkType(1);
        }
        jobInfo$Builder0.setRequiresDeviceIdle(requirements0.isIdleRequired());
        jobInfo$Builder0.setRequiresCharging(requirements0.isChargingRequired());
        jobInfo$Builder0.setPersisted(true);
        PersistableBundle persistableBundle0 = new PersistableBundle();
        persistableBundle0.putString("service_action", s);
        persistableBundle0.putString("service_package", s1);
        persistableBundle0.putInt("requirements", requirements0.getRequirements());
        jobInfo$Builder0.setExtras(persistableBundle0);
        return jobInfo$Builder0.build();
    }

    @Override  // com.google.android.exoplayer2.scheduler.Scheduler
    public boolean cancel() {
        this.jobScheduler.cancel(this.jobId);
        return true;
    }

    private static void logd(String s) {
    }

    @Override  // com.google.android.exoplayer2.scheduler.Scheduler
    public boolean schedule(Requirements requirements0, String s, String s1) {
        JobInfo jobInfo0 = PlatformScheduler.buildJobInfo(this.jobId, this.jobServiceComponentName, requirements0, s1, s);
        int v = this.jobScheduler.schedule(jobInfo0);
        stringBuilder0.toString();
        return v == 1;
    }
}

