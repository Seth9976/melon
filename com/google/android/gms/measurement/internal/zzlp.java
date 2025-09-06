package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobInfo.Builder;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.PersistableBundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzin;

public final class zzlp extends zzg {
    private JobScheduler zza;

    public zzlp(zzib zzib0) {
        super(zzib0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzg
    public final boolean zze() {
        return true;
    }

    @Override  // com.google.android.gms.measurement.internal.zzg
    @TargetApi(24)
    public final void zzf() {
        this.zza = (JobScheduler)this.zzu.zzaY().getSystemService("jobscheduler");
    }

    @TargetApi(24)
    public final void zzh(long v) {
        this.zzb();
        this.zzg();
        if(this.zza != null && this.zza.getPendingJob(this.zzi()) != null) {
            this.zzu.zzaV().zzk().zza("[sgtm] There\'s an existing pending job, skip this schedule.");
            return;
        }
        zzin zzin0 = this.zzj();
        if(zzin0 == zzin.zzb) {
            this.zzu.zzaV().zzk().zzb("[sgtm] Scheduling Scion upload, millis", v);
            PersistableBundle persistableBundle0 = new PersistableBundle();
            persistableBundle0.putString("action", "com.google.android.gms.measurement.SCION_UPLOAD");
            JobInfo jobInfo0 = new JobInfo.Builder(this.zzi(), new ComponentName(this.zzu.zzaY(), "com.google.android.gms.measurement.AppMeasurementJobService")).setRequiredNetworkType(1).setMinimumLatency(v).setOverrideDeadline(v + v).setExtras(persistableBundle0).build();
            int v1 = ((JobScheduler)Preconditions.checkNotNull(this.zza)).schedule(jobInfo0);
            this.zzu.zzaV().zzk().zzb("[sgtm] Scion upload job scheduled with result", (v1 == 1 ? "SUCCESS" : "FAILURE"));
            return;
        }
        this.zzu.zzaV().zzk().zzb("[sgtm] Not eligible for Scion upload", zzin0.name());
    }

    // 去混淆评级： 低(20)
    public final int zzi() {
        return 907043185;
    }

    public final zzin zzj() {
        this.zzb();
        this.zzg();
        if(this.zza != null) {
            zzib zzib0 = this.zzu;
            if(zzib0.zzc().zzx()) {
                zzib zzib1 = this.zzu;
                if(zzib1.zzv().zzn() >= 119000L) {
                    if(!zzpo.zzR(zzib0.zzaY(), "com.google.android.gms.measurement.AppMeasurementJobService")) {
                        return zzin.zzc;
                    }
                    return zzib1.zzt().zzK() ? zzin.zzb : zzin.zze;
                }
                return zzin.zzf;
            }
            return zzin.zzh;
        }
        return zzin.zzg;
    }
}

