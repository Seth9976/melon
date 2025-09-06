package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;
import java.util.List;

public abstract class zzf extends zzb implements zzg {
    public zzf() {
        super("com.google.android.gms.cast.framework.media.INotificationActionsProvider");
    }

    @Override  // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                parcel1.writeNoException();
                parcel1.writeInt(12451000);
                return true;
            }
            case 2: {
                IObjectWrapper iObjectWrapper0 = this.zze();
                parcel1.writeNoException();
                zzc.zze(parcel1, iObjectWrapper0);
                return true;
            }
            case 3: {
                List list0 = this.zzf();
                parcel1.writeNoException();
                parcel1.writeTypedList(list0);
                return true;
            }
            case 4: {
                int[] arr_v = this.zzg();
                parcel1.writeNoException();
                parcel1.writeIntArray(arr_v);
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

