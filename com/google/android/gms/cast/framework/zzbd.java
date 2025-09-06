package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzbd extends zzb implements zzbe {
    public zzbd() {
        super("com.google.android.gms.cast.framework.ISessionProxy");
    }

    @Override  // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                IObjectWrapper iObjectWrapper0 = this.zzc();
                parcel1.writeNoException();
                zzc.zze(parcel1, iObjectWrapper0);
                return true;
            }
            case 2: {
                Bundle bundle0 = (Bundle)zzc.zza(parcel0, Bundle.CREATOR);
                zzc.zzb(parcel0);
                this.zzh(bundle0);
                parcel1.writeNoException();
                return true;
            }
            case 3: {
                Bundle bundle1 = (Bundle)zzc.zza(parcel0, Bundle.CREATOR);
                zzc.zzb(parcel0);
                this.zzg(bundle1);
                parcel1.writeNoException();
                return true;
            }
            case 4: {
                boolean z = zzc.zzf(parcel0);
                zzc.zzb(parcel0);
                this.zzd(z);
                parcel1.writeNoException();
                return true;
            }
            case 5: {
                long v2 = this.zzb();
                parcel1.writeNoException();
                parcel1.writeLong(v2);
                return true;
            }
            case 6: {
                parcel1.writeNoException();
                parcel1.writeInt(12451000);
                return true;
            }
            case 7: {
                Bundle bundle2 = (Bundle)zzc.zza(parcel0, Bundle.CREATOR);
                zzc.zzb(parcel0);
                this.zzf(bundle2);
                parcel1.writeNoException();
                return true;
            }
            case 8: {
                Bundle bundle3 = (Bundle)zzc.zza(parcel0, Bundle.CREATOR);
                zzc.zzb(parcel0);
                this.zze(bundle3);
                parcel1.writeNoException();
                return true;
            }
            case 9: {
                Bundle bundle4 = (Bundle)zzc.zza(parcel0, Bundle.CREATOR);
                zzc.zzb(parcel0);
                this.zzi(bundle4);
                parcel1.writeNoException();
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

