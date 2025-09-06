package com.google.android.gms.internal.location;

import android.os.Parcel;

public abstract class zzq extends zzb implements zzr {
    public zzq() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override  // com.google.android.gms.internal.location.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                zzl zzl0 = (zzl)zzc.zza(parcel0, zzl.CREATOR);
                zzc.zzd(parcel0);
                this.zzd(zzl0);
                return true;
            }
            case 2: {
                this.zze();
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

