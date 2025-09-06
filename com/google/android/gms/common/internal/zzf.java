package com.google.android.gms.common.internal;

import A7.d;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;

public final class zzf extends zza {
    public final IBinder zze;
    final BaseGmsClient zzf;

    public zzf(BaseGmsClient baseGmsClient0, int v, IBinder iBinder0, Bundle bundle0) {
        Objects.requireNonNull(baseGmsClient0);
        this.zzf = baseGmsClient0;
        super(baseGmsClient0, v, bundle0);
        this.zze = iBinder0;
    }

    @Override  // com.google.android.gms.common.internal.zza
    public final boolean zza() {
        String s;
        try {
            Preconditions.checkNotNull(this.zze);
            s = this.zze.getInterfaceDescriptor();
        }
        catch(RemoteException unused_ex) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
        BaseGmsClient baseGmsClient0 = this.zzf;
        if(!baseGmsClient0.getServiceDescriptor().equals(s)) {
            String s1 = baseGmsClient0.getServiceDescriptor();
            Log.w("GmsClient", d.n(new StringBuilder(String.valueOf(s1).length() + 34 + String.valueOf(s).length()), "service descriptor mismatch: ", s1, " vs. ", s));
            return false;
        }
        IInterface iInterface0 = baseGmsClient0.createServiceInterface(this.zze);
        if(iInterface0 != null && (baseGmsClient0.zze(2, 4, iInterface0) || baseGmsClient0.zze(3, 4, iInterface0))) {
            baseGmsClient0.zzn(null);
            Bundle bundle0 = baseGmsClient0.getConnectionHint();
            if(baseGmsClient0.zzk() != null) {
                baseGmsClient0.zzk().onConnected(bundle0);
            }
            return true;
        }
        return false;
    }

    @Override  // com.google.android.gms.common.internal.zza
    public final void zzb(ConnectionResult connectionResult0) {
        BaseGmsClient baseGmsClient0 = this.zzf;
        if(baseGmsClient0.zzl() != null) {
            baseGmsClient0.zzl().onConnectionFailed(connectionResult0);
        }
        baseGmsClient0.onConnectionFailed(connectionResult0);
    }
}

