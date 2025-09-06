package com.google.android.gms.cast.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzaf extends zzb implements zzag {
    public zzaf() {
        super("com.google.android.gms.cast.internal.IBundleCallback");
    }

    @Override  // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 1) {
            Bundle bundle0 = (Bundle)zzc.zza(parcel0, Bundle.CREATOR);
            zzc.zzb(parcel0);
            this.zzb(bundle0);
            return true;
        }
        return false;
    }
}

