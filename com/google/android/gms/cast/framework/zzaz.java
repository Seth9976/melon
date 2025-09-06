package com.google.android.gms.cast.framework;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzaz extends zzb implements zzba {
    public zzaz() {
        super("com.google.android.gms.cast.framework.ISessionManagerListener");
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
                IObjectWrapper iObjectWrapper1 = Stub.asInterface(parcel0.readStrongBinder());
                zzc.zzb(parcel0);
                this.zzj(iObjectWrapper1);
                parcel1.writeNoException();
                return true;
            }
            case 3: {
                IObjectWrapper iObjectWrapper2 = Stub.asInterface(parcel0.readStrongBinder());
                String s = parcel0.readString();
                zzc.zzb(parcel0);
                this.zzi(iObjectWrapper2, s);
                parcel1.writeNoException();
                return true;
            }
            case 4: {
                IObjectWrapper iObjectWrapper3 = Stub.asInterface(parcel0.readStrongBinder());
                int v2 = parcel0.readInt();
                zzc.zzb(parcel0);
                this.zzh(iObjectWrapper3, v2);
                parcel1.writeNoException();
                return true;
            }
            case 5: {
                IObjectWrapper iObjectWrapper4 = Stub.asInterface(parcel0.readStrongBinder());
                zzc.zzb(parcel0);
                this.zzd(iObjectWrapper4);
                parcel1.writeNoException();
                return true;
            }
            case 6: {
                IObjectWrapper iObjectWrapper5 = Stub.asInterface(parcel0.readStrongBinder());
                int v3 = parcel0.readInt();
                zzc.zzb(parcel0);
                this.zzc(iObjectWrapper5, v3);
                parcel1.writeNoException();
                return true;
            }
            case 7: {
                IObjectWrapper iObjectWrapper6 = Stub.asInterface(parcel0.readStrongBinder());
                String s1 = parcel0.readString();
                zzc.zzb(parcel0);
                this.zzg(iObjectWrapper6, s1);
                parcel1.writeNoException();
                return true;
            }
            case 8: {
                IObjectWrapper iObjectWrapper7 = Stub.asInterface(parcel0.readStrongBinder());
                boolean z = zzc.zzf(parcel0);
                zzc.zzb(parcel0);
                this.zzf(iObjectWrapper7, z);
                parcel1.writeNoException();
                return true;
            }
            case 9: {
                IObjectWrapper iObjectWrapper8 = Stub.asInterface(parcel0.readStrongBinder());
                int v4 = parcel0.readInt();
                zzc.zzb(parcel0);
                this.zze(iObjectWrapper8, v4);
                parcel1.writeNoException();
                return true;
            }
            case 10: {
                IObjectWrapper iObjectWrapper9 = Stub.asInterface(parcel0.readStrongBinder());
                int v5 = parcel0.readInt();
                zzc.zzb(parcel0);
                this.zzk(iObjectWrapper9, v5);
                parcel1.writeNoException();
                return true;
            }
            case 11: {
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

