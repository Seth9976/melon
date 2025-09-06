package com.google.android.gms.cast.framework;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.dynamic.IObjectWrapper;

@ShowFirstParty
public final class zzac {
    private static final Logger zza;
    private final zzaq zzb;

    static {
        zzac.zza = new Logger("DiscoveryManager");
    }

    public zzac(zzaq zzaq0) {
        this.zzb = zzaq0;
    }

    public final IObjectWrapper zza() {
        try {
            return this.zzb.zze();
        }
        catch(RemoteException remoteException0) {
            zzac.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"getWrappedThis", "zzaq"});
            return null;
        }
    }
}

