package com.google.android.gms.flags;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.internal.flags.zzb;

public abstract class zzd extends zzb implements zze {
    public zzd() {
        super("com.google.android.gms.flags.IFlagProvider");
    }

    public static zze asInterface(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
        return iInterface0 instanceof zze ? ((zze)iInterface0) : new zzc(iBinder0);
    }

    @Override  // com.google.android.gms.internal.flags.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                this.init(Stub.asInterface(parcel0.readStrongBinder()));
                parcel1.writeNoException();
                return true;
            }
            case 2: {
                boolean z = this.getBooleanFlagValue(parcel0.readString(), com.google.android.gms.internal.flags.zzc.zzc(parcel0), parcel0.readInt());
                parcel1.writeNoException();
                com.google.android.gms.internal.flags.zzc.zza(parcel1, z);
                return true;
            }
            case 3: {
                int v3 = this.getIntFlagValue(parcel0.readString(), parcel0.readInt(), parcel0.readInt());
                parcel1.writeNoException();
                parcel1.writeInt(v3);
                return true;
            }
            case 4: {
                long v2 = this.getLongFlagValue(parcel0.readString(), parcel0.readLong(), parcel0.readInt());
                parcel1.writeNoException();
                parcel1.writeLong(v2);
                return true;
            }
            case 5: {
                String s = this.getStringFlagValue(parcel0.readString(), parcel0.readString(), parcel0.readInt());
                parcel1.writeNoException();
                parcel1.writeString(s);
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

