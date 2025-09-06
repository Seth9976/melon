package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class zzcs extends zzbl implements zzcu {
    public zzcs(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override  // com.google.android.gms.internal.measurement.zzcu
    public final void zzb(Bundle bundle0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, bundle0);
        this.zzc(1, parcel0);
    }
}

