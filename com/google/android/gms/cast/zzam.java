package com.google.android.gms.cast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

final class zzam implements OnCompleteListener {
    final CastRemoteDisplayLocalService zza;

    public zzam(CastRemoteDisplayLocalService castRemoteDisplayLocalService0) {
        this.zza = castRemoteDisplayLocalService0;
        super();
    }

    @Override  // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task0) {
        if(task0.isSuccessful()) {
            this.zza.zzv("remote display stopped");
        }
        else {
            this.zza.zzv("Unable to stop the remote display, result unsuccessful");
            Callbacks castRemoteDisplayLocalService$Callbacks0 = (Callbacks)this.zza.zzg.get();
            if(castRemoteDisplayLocalService$Callbacks0 != null) {
                castRemoteDisplayLocalService$Callbacks0.onRemoteDisplaySessionError(new Status(2202));
            }
        }
        CastRemoteDisplayLocalService.zzj(this.zza, null);
    }
}

