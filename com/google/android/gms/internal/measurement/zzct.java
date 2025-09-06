package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;

public abstract class zzct extends zzbm implements zzcu {
    public zzct() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override  // com.google.android.gms.internal.measurement.zzbm
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 1) {
            Bundle bundle0 = (Bundle)zzbn.zzb(parcel0, Bundle.CREATOR);
            zzbn.zzf(parcel0);
            this.zzb(bundle0);
            parcel1.writeNoException();
            return true;
        }
        return false;
    }
}

