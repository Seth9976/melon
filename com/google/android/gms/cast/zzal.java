package com.google.android.gms.cast;

import android.content.Context;
import android.content.ServiceConnection;
import android.view.Display;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

final class zzal implements OnCompleteListener {
    final CastRemoteDisplayLocalService zza;

    public zzal(CastRemoteDisplayLocalService castRemoteDisplayLocalService0) {
        this.zza = castRemoteDisplayLocalService0;
        super();
    }

    @Override  // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task0) {
        if(!task0.isSuccessful()) {
            CastRemoteDisplayLocalService.zza.e("Connection was not successful", new Object[0]);
            CastRemoteDisplayLocalService.zzo(this.zza);
            return;
        }
        CastRemoteDisplayLocalService.zza.d("startRemoteDisplay successful", new Object[0]);
        synchronized(CastRemoteDisplayLocalService.zzc) {
            if(CastRemoteDisplayLocalService.zze == null) {
                CastRemoteDisplayLocalService.zza.d("Remote Display started but session already cancelled", new Object[0]);
                CastRemoteDisplayLocalService.zzo(this.zza);
                return;
            }
        }
        Display display0 = (Display)task0.getResult();
        CastRemoteDisplayLocalService.zzl(this.zza, display0);
        CastRemoteDisplayLocalService.zzd.set(false);
        Context context0 = this.zza.zzo;
        ServiceConnection serviceConnection0 = this.zza.zzp;
        if(context0 != null && serviceConnection0 != null) {
            try {
                ConnectionTracker.getInstance().unbindService(context0, serviceConnection0);
            }
            catch(IllegalArgumentException unused_ex) {
                CastRemoteDisplayLocalService.zza.d("No need to unbind service, already unbound", new Object[0]);
            }
        }
        CastRemoteDisplayLocalService.zzk(this.zza, null);
        CastRemoteDisplayLocalService.zzi(this.zza, null);
    }
}

