package com.google.android.gms.tasks;

final class zzc implements Runnable {
    final Task zza;
    final zzd zzb;

    public zzc(zzd zzd0, Task task0) {
        this.zzb = zzd0;
        this.zza = task0;
        super();
    }

    @Override
    public final void run() {
        Object object0;
        if(this.zza.isCanceled()) {
            zzd.zzb(this.zzb).zzc();
            return;
        }
        try {
            object0 = zzd.zza(this.zzb).then(this.zza);
        }
        catch(RuntimeExecutionException runtimeExecutionException0) {
            if(runtimeExecutionException0.getCause() instanceof Exception) {
                zzd.zzb(this.zzb).zza(((Exception)runtimeExecutionException0.getCause()));
                return;
            }
            zzd.zzb(this.zzb).zza(runtimeExecutionException0);
            return;
        }
        catch(Exception exception0) {
            zzd.zzb(this.zzb).zza(exception0);
            return;
        }
        zzd.zzb(this.zzb).zzb(object0);
    }
}

