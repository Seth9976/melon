package com.google.android.gms.tasks;

final class zze implements Runnable {
    final Task zza;
    final zzf zzb;

    public zze(zzf zzf0, Task task0) {
        this.zzb = zzf0;
        this.zza = task0;
        super();
    }

    @Override
    public final void run() {
        Task task0;
        try {
            task0 = (Task)zzf.zza(this.zzb).then(this.zza);
        }
        catch(RuntimeExecutionException runtimeExecutionException0) {
            if(runtimeExecutionException0.getCause() instanceof Exception) {
                zzf.zzb(this.zzb).zza(((Exception)runtimeExecutionException0.getCause()));
                return;
            }
            zzf.zzb(this.zzb).zza(runtimeExecutionException0);
            return;
        }
        catch(Exception exception0) {
            zzf.zzb(this.zzb).zza(exception0);
            return;
        }
        if(task0 == null) {
            NullPointerException nullPointerException0 = new NullPointerException("Continuation returned null");
            this.zzb.onFailure(nullPointerException0);
            return;
        }
        task0.addOnSuccessListener(TaskExecutors.zza, this.zzb);
        task0.addOnFailureListener(TaskExecutors.zza, this.zzb);
        task0.addOnCanceledListener(TaskExecutors.zza, this.zzb);
    }
}

