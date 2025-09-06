package com.google.android.gms.cast.framework;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzan extends zzb implements zzao {
    public zzan() {
        super("com.google.android.gms.cast.framework.ICastStateListener");
    }

    @Override  // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                IObjectWrapper iObjectWrapper0 = this.zzb();
                parcel1.writeNoException();
                zzc.zze(parcel1, iObjectWrapper0);
                return true;
            }
            case 2: {
                int v2 = parcel0.readInt();
                zzc.zzb(parcel0);
                this.zzc(v2);
                parcel1.writeNoException();
                return true;
            }
            case 3: {
                parcel1.writeNoException();
                parcel1.writeInt(12451000);
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

