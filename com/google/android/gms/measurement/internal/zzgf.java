package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbn;

public abstract class zzgf extends zzbm implements zzgg {
    public zzgf() {
        super("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override  // com.google.android.gms.internal.measurement.zzbm
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 2) {
            zzop zzop0 = (zzop)zzbn.zzb(parcel0, zzop.CREATOR);
            zzbn.zzf(parcel0);
            this.zze(zzop0);
            return true;
        }
        return false;
    }
}

