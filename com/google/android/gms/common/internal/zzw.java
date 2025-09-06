package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public abstract class zzw extends zzb implements zzx {
    public zzw() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    @Override  // com.google.android.gms.internal.common.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                IObjectWrapper iObjectWrapper0 = this.zzd();
                parcel1.writeNoException();
                zzc.zze(parcel1, iObjectWrapper0);
                return true;
            }
            case 2: {
                int v2 = this.zze();
                parcel1.writeNoException();
                parcel1.writeInt(v2);
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static zzx zzg(IBinder iBinder0) {
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return iInterface0 instanceof zzx ? ((zzx)iInterface0) : new zzv(iBinder0);
    }
}

