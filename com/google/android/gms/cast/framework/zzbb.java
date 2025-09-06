package com.google.android.gms.cast.framework;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzbb extends zzb implements zzbc {
    public zzbb() {
        super("com.google.android.gms.cast.framework.ISessionProvider");
    }

    @Override  // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                String s = parcel0.readString();
                zzc.zzb(parcel0);
                IObjectWrapper iObjectWrapper0 = this.zzb(s);
                parcel1.writeNoException();
                zzc.zze(parcel1, iObjectWrapper0);
                return true;
            }
            case 2: {
                boolean z = this.zzd();
                parcel1.writeNoException();
                parcel1.writeInt(((int)z));
                return true;
            }
            case 3: {
                String s1 = this.zzc();
                parcel1.writeNoException();
                parcel1.writeString(s1);
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

