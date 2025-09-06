package com.google.android.gms.cast;

import android.hardware.display.DisplayManager;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.cast.zzeg;
import com.google.android.gms.internal.cast.zzel;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzab extends zzad {
    final TaskCompletionSource zza;
    final zzeg zzb;
    final CastRemoteDisplayClient zzc;
    final zzak zzd;

    public zzab(CastRemoteDisplayClient castRemoteDisplayClient0, TaskCompletionSource taskCompletionSource0, zzeg zzeg0, zzak zzak0) {
        this.zza = taskCompletionSource0;
        this.zzb = zzeg0;
        this.zzd = zzak0;
        this.zzc = castRemoteDisplayClient0;
        super(null);
    }

    @Override  // com.google.android.gms.cast.zzad
    public final void zzb(int v, int v1, Surface surface0) {
        CastRemoteDisplayClient castRemoteDisplayClient0 = this.zzc;
        castRemoteDisplayClient0.zzc.d("onConnected", new Object[0]);
        Object object0 = castRemoteDisplayClient0.getApplicationContext().getSystemService("display");
        if(((DisplayManager)object0) == null) {
            castRemoteDisplayClient0.zzc.e("Unable to get the display manager", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        CastRemoteDisplayClient.zzd(castRemoteDisplayClient0);
        castRemoteDisplayClient0.zzd = ((DisplayManager)object0).createVirtualDisplay("private_display", v, v1, Math.min(v, v1) * 320 / 1080, surface0, 2);
        if(castRemoteDisplayClient0.zzd == null) {
            castRemoteDisplayClient0.zzc.e("Unable to create virtual display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        Display display0 = castRemoteDisplayClient0.zzd.getDisplay();
        if(display0 == null) {
            castRemoteDisplayClient0.zzc.e("Virtual display does not have a display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        try {
            ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(this.zzb.getContext()).build();
            ((zzel)this.zzb.getService()).zzf(this, display0.getDisplayId(), ApiMetadata.fromComplianceOptions(complianceOptions0));
        }
        catch(RemoteException | IllegalStateException unused_ex) {
            this.zzc.zzc.e("Unable to provision the route\'s new virtual Display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
        }
    }

    @Override  // com.google.android.gms.cast.zzad
    public final void zzc() {
        CastRemoteDisplayClient castRemoteDisplayClient0 = this.zzc;
        castRemoteDisplayClient0.zzc.d("onConnectedWithDisplay", new Object[0]);
        if(castRemoteDisplayClient0.zzd == null) {
            castRemoteDisplayClient0.zzc.e("There is no virtual display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        Display display0 = castRemoteDisplayClient0.zzd.getDisplay();
        if(display0 != null) {
            TaskUtil.setResultOrApiException(Status.RESULT_SUCCESS, display0, this.zza);
            return;
        }
        castRemoteDisplayClient0.zzc.e("Virtual display no longer has a display", new Object[0]);
        TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
    }

    @Override  // com.google.android.gms.cast.zzad
    public final void zzd(int v) {
        this.zzc.zzc.d("onError: %d", new Object[]{v});
        CastRemoteDisplayClient.zzd(this.zzc);
        TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
    }

    @Override  // com.google.android.gms.cast.zzad
    public final void zze(boolean z) {
        this.zzc.zzc.d("onRemoteDisplayMuteStateChanged: %b", new Object[]{Boolean.valueOf(z)});
        zzak zzak0 = this.zzd;
        if(zzak0 != null) {
            zzak0.zza.zzv("onRemoteDisplayMuteStateChanged: " + z);
            Callbacks castRemoteDisplayLocalService$Callbacks0 = (Callbacks)zzak0.zza.zzg.get();
            if(castRemoteDisplayLocalService$Callbacks0 != null) {
                castRemoteDisplayLocalService$Callbacks0.onRemoteDisplayMuteStateChanged(z);
            }
        }
    }
}

