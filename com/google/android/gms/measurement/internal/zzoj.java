package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import com.google.android.gms.internal.measurement.zzcg;
import com.google.android.gms.internal.measurement.zzch;

public final class zzoj extends zzor {
    private final AlarmManager zza;
    private zzay zzb;
    private Integer zzc;

    public zzoj(zzpf zzpf0) {
        super(zzpf0);
        this.zza = (AlarmManager)this.zzu.zzaY().getSystemService("alarm");
    }

    @Override  // com.google.android.gms.measurement.internal.zzor
    public final boolean zzbb() {
        AlarmManager alarmManager0 = this.zza;
        if(alarmManager0 != null) {
            alarmManager0.cancel(this.zzj());
        }
        this.zzh();
        return false;
    }

    public final void zzc(long v) {
        this.zzay();
        zzib zzib0 = this.zzu;
        Context context0 = zzib0.zzaY();
        if(!zzpo.zzau(context0)) {
            zzib0.zzaV().zzj().zza("Receiver not registered/enabled");
        }
        if(!zzpo.zzQ(context0, false)) {
            zzib0.zzaV().zzj().zza("Service not registered/enabled");
        }
        this.zzd();
        zzib0.zzaV().zzk().zzb("Scheduling upload, millis", v);
        zzib0.zzaZ().elapsedRealtime();
        if(v < Math.max(0L, ((long)(((Long)zzfx.zzL.zzb(null))))) && !this.zzf().zzc()) {
            this.zzf().zzb(v);
        }
        Context context1 = zzib0.zzaY();
        ComponentName componentName0 = new ComponentName(context1, "com.google.android.gms.measurement.AppMeasurementJobService");
        int v1 = this.zzi();
        PersistableBundle persistableBundle0 = new PersistableBundle();
        persistableBundle0.putString("action", "com.google.android.gms.measurement.UPLOAD");
        zzch.zza(context1, new JobInfo.Builder(v1, componentName0).setMinimumLatency(v).setOverrideDeadline(v + v).setExtras(persistableBundle0).build(), "com.google.android.gms", "UploadAlarm");
    }

    public final void zzd() {
        this.zzay();
        this.zzu.zzaV().zzk().zza("Unscheduling upload");
        AlarmManager alarmManager0 = this.zza;
        if(alarmManager0 != null) {
            alarmManager0.cancel(this.zzj());
        }
        this.zzf().zzd();
        this.zzh();
    }

    private final zzay zzf() {
        if(this.zzb == null) {
            this.zzb = new zzoi(this, this.zzg.zzaf());
        }
        return this.zzb;
    }

    @TargetApi(24)
    private final void zzh() {
        JobScheduler jobScheduler0 = (JobScheduler)this.zzu.zzaY().getSystemService("jobscheduler");
        if(jobScheduler0 != null) {
            jobScheduler0.cancel(this.zzi());
        }
    }

    private final int zzi() {
        if(this.zzc == null) {
            this.zzc = 0x4E5C84B1;
        }
        return (int)this.zzc;
    }

    private final PendingIntent zzj() {
        Context context0 = this.zzu.zzaY();
        return PendingIntent.getBroadcast(context0, 0, new Intent().setClassName(context0, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), zzcg.zza);
    }
}

