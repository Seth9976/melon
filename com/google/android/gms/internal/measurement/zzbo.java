package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class zzbo extends zzbl implements zzbq {
    public zzbo(IBinder iBinder0) {
        super(iBinder0, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override  // com.google.android.gms.internal.measurement.zzbq
    public final Bundle zze(Bundle bundle0) {
        Parcel parcel0 = this.zza();
        zzbn.zzc(parcel0, bundle0);
        Parcel parcel1 = this.zzP(1, parcel0);
        Bundle bundle1 = (Bundle)zzbn.zzb(parcel1, Bundle.CREATOR);
        parcel1.recycle();
        return bundle1;
    }
}

