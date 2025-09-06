package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.view.Surface;

public abstract class zzej extends zzb implements zzek {
    public zzej() {
        super("com.google.android.gms.cast.remote_display.ICastRemoteDisplayCallbacks");
    }

    @Override  // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                int v3 = parcel0.readInt();
                int v4 = parcel0.readInt();
                Surface surface0 = (Surface)zzc.zza(parcel0, Surface.CREATOR);
                zzc.zzb(parcel0);
                this.zzb(v3, v4, surface0);
                break;
            }
            case 2: {
                int v2 = parcel0.readInt();
                zzc.zzb(parcel0);
                this.zzd(v2);
                break;
            }
            case 3: {
                this.zzf();
                break;
            }
            case 4: {
                this.zzc();
                break;
            }
            case 5: {
                boolean z = zzc.zzf(parcel0);
                zzc.zzb(parcel0);
                this.zze(z);
                break;
            }
            default: {
                return false;
            }
        }
        parcel1.writeNoException();
        return true;
    }
}

