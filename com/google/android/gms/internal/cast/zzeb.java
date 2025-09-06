package com.google.android.gms.internal.cast;

import android.hardware.display.DisplayManager;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.common.api.Status;

public final class zzeb extends zzea {
    final zzed zza;
    private final zzei zzb;

    public zzeb(zzed zzed0, zzei zzei0) {
        this.zza = zzed0;
        super();
        this.zzb = zzei0;
    }

    @Override  // com.google.android.gms.internal.cast.zzea
    public final void zzb(int v, int v1, Surface surface0) {
        zzef.zzb().d("onConnected", new Object[0]);
        zzei zzei0 = this.zzb;
        Object object0 = zzei0.getContext().getSystemService("display");
        if(((DisplayManager)object0) == null) {
            zzef.zzb().e("Unable to get the display manager", new Object[0]);
            zzee zzee0 = new zzee(Status.RESULT_INTERNAL_ERROR);
            this.zza.setResult(zzee0);
            return;
        }
        zzed zzed0 = this.zza;
        zzef zzef0 = zzed0.zzc;
        zzef.zzf(zzef0);
        zzef.zze(zzef0, ((DisplayManager)object0).createVirtualDisplay("private_display", v, v1, (v >= v1 ? v1 : v) * 320 / 1080, surface0, 2));
        if(zzef.zza(zzef0) == null) {
            zzef.zzb().e("Unable to create virtual display", new Object[0]);
            zzed0.setResult(new zzee(Status.RESULT_INTERNAL_ERROR));
            return;
        }
        if(zzef.zza(zzef0).getDisplay() != null) {
            try {
                int v2 = zzef.zza(zzef0).getDisplay().getDisplayId();
                ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(zzei0.getContext()).build();
                ((zzel)zzei0.getService()).zzf(this, v2, ApiMetadata.fromComplianceOptions(complianceOptions0));
            }
            catch(RemoteException | IllegalStateException unused_ex) {
                zzef.zzb().e("Unable to provision the route\'s new virtual Display", new Object[0]);
                zzee zzee1 = new zzee(Status.RESULT_INTERNAL_ERROR);
                this.zza.setResult(zzee1);
            }
            return;
        }
        zzef.zzb().e("Virtual display does not have a display", new Object[0]);
        zzed0.setResult(new zzee(Status.RESULT_INTERNAL_ERROR));
    }

    @Override  // com.google.android.gms.internal.cast.zzea
    public final void zzc() {
        zzef.zzb().d("onConnectedWithDisplay", new Object[0]);
        zzed zzed0 = this.zza;
        zzef zzef0 = zzed0.zzc;
        if(zzef.zza(zzef0) == null) {
            zzef.zzb().e("There is no virtual display", new Object[0]);
            zzed0.setResult(new zzee(Status.RESULT_INTERNAL_ERROR));
            return;
        }
        Display display0 = zzef.zza(zzef0).getDisplay();
        if(display0 != null) {
            zzed0.setResult(new zzee(display0));
            return;
        }
        zzef.zzb().e("Virtual display no longer has a display", new Object[0]);
        zzed0.setResult(new zzee(Status.RESULT_INTERNAL_ERROR));
    }

    @Override  // com.google.android.gms.internal.cast.zzea
    public final void zzd(int v) {
        zzef.zzb().d("onError: %d", new Object[]{v});
        zzef.zzf(this.zza.zzc);
        zzee zzee0 = new zzee(Status.RESULT_INTERNAL_ERROR);
        this.zza.setResult(zzee0);
    }
}

