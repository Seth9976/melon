package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbn;
import java.util.ArrayList;

public abstract class zzgc extends zzbm implements zzgd {
    public zzgc() {
        super("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override  // com.google.android.gms.internal.measurement.zzbm
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 2) {
            ArrayList arrayList0 = parcel0.createTypedArrayList(zzog.CREATOR);
            zzbn.zzf(parcel0);
            this.zze(arrayList0);
            return true;
        }
        return false;
    }
}

