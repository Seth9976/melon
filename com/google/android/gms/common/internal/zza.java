package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;

abstract class zza extends zzc {
    public final int zza;
    public final Bundle zzb;
    final BaseGmsClient zzc;

    public zza(BaseGmsClient baseGmsClient0, int v, Bundle bundle0) {
        Objects.requireNonNull(baseGmsClient0);
        this.zzc = baseGmsClient0;
        super(baseGmsClient0, Boolean.TRUE);
        this.zza = v;
        this.zzb = bundle0;
    }

    public abstract boolean zza();

    public abstract void zzb(ConnectionResult arg1);

    @Override  // com.google.android.gms.common.internal.zzc
    public final void zzc(Object object0) {
        Boolean boolean0 = (Boolean)object0;
        int v = this.zza;
        PendingIntent pendingIntent0 = null;
        if(v == 0) {
            if(!this.zza()) {
                this.zzc.zzd(1, null);
                this.zzb(new ConnectionResult(8, null));
            }
            return;
        }
        this.zzc.zzd(1, null);
        Bundle bundle0 = this.zzb;
        if(bundle0 != null) {
            pendingIntent0 = (PendingIntent)bundle0.getParcelable("pendingIntent");
        }
        this.zzb(new ConnectionResult(v, pendingIntent0));
    }
}

