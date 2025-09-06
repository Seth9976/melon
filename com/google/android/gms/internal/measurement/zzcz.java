package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class zzcz extends zzbm implements zzda {
    public zzcz() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override  // com.google.android.gms.internal.measurement.zzbm
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                String s = parcel0.readString();
                String s1 = parcel0.readString();
                Parcelable parcelable0 = zzbn.zzb(parcel0, Bundle.CREATOR);
                long v2 = parcel0.readLong();
                zzbn.zzf(parcel0);
                this.zze(s, s1, ((Bundle)parcelable0), v2);
                parcel1.writeNoException();
                return true;
            }
            case 2: {
                int v3 = this.zzf();
                parcel1.writeNoException();
                parcel1.writeInt(v3);
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

