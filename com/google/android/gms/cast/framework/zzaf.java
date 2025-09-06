package com.google.android.gms.cast.framework;

import android.os.Parcel;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzaf extends zzb implements zzag {
    public zzaf() {
        super("com.google.android.gms.cast.framework.ICastConnectionController");
    }

    @Override  // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                String s2 = parcel0.readString();
                String s3 = parcel0.readString();
                zzc.zzb(parcel0);
                this.zzc(s2, s3);
                parcel1.writeNoException();
                return true;
            }
            case 2: {
                String s1 = parcel0.readString();
                LaunchOptions launchOptions0 = (LaunchOptions)zzc.zza(parcel0, LaunchOptions.CREATOR);
                zzc.zzb(parcel0);
                this.zzd(s1, launchOptions0);
                parcel1.writeNoException();
                return true;
            }
            case 3: {
                String s = parcel0.readString();
                zzc.zzb(parcel0);
                this.zze(s);
                parcel1.writeNoException();
                return true;
            }
            case 4: {
                int v2 = parcel0.readInt();
                zzc.zzb(parcel0);
                this.zzb(v2);
                parcel1.writeNoException();
                return true;
            }
            case 5: {
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

