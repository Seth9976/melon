package com.google.android.gms.cast.framework;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzad extends zzb implements zzae {
    public zzad() {
        super("com.google.android.gms.cast.framework.IAppVisibilityListener");
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
                this.zzd();
                parcel1.writeNoException();
                return true;
            }
            case 3: {
                this.zzc();
                parcel1.writeNoException();
                return true;
            }
            case 4: {
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

