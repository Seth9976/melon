package com.google.android.gms.internal.cast;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class zzal extends zzb implements zzam {
    public zzal() {
        super("com.google.android.gms.cast.framework.internal.IMediaRouter");
    }

    @Override  // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        zzao zzao0;
        switch(v) {
            case 1: {
                Bundle bundle0 = (Bundle)zzc.zza(parcel0, Bundle.CREATOR);
                IBinder iBinder0 = parcel0.readStrongBinder();
                if(iBinder0 == null) {
                    zzao0 = null;
                }
                else {
                    IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.cast.framework.internal.IMediaRouterCallback");
                    zzao0 = iInterface0 instanceof zzao ? ((zzao)iInterface0) : new zzan(iBinder0);
                }
                zzc.zzb(parcel0);
                this.zze(bundle0, zzao0);
                parcel1.writeNoException();
                return true;
            }
            case 2: {
                Bundle bundle1 = (Bundle)zzc.zza(parcel0, Bundle.CREATOR);
                int v2 = parcel0.readInt();
                zzc.zzb(parcel0);
                this.zzd(bundle1, v2);
                parcel1.writeNoException();
                return true;
            }
            case 3: {
                Bundle bundle2 = (Bundle)zzc.zza(parcel0, Bundle.CREATOR);
                zzc.zzb(parcel0);
                this.zzg(bundle2);
                parcel1.writeNoException();
                return true;
            }
            case 4: {
                Bundle bundle3 = (Bundle)zzc.zza(parcel0, Bundle.CREATOR);
                int v3 = parcel0.readInt();
                zzc.zzb(parcel0);
                boolean z = this.zzm(bundle3, v3);
                parcel1.writeNoException();
                parcel1.writeInt(((int)z));
                return true;
            }
            case 5: {
                String s = parcel0.readString();
                zzc.zzb(parcel0);
                this.zzi(s);
                parcel1.writeNoException();
                return true;
            }
            case 6: {
                this.zzh();
                parcel1.writeNoException();
                return true;
            }
            case 7: {
                boolean z1 = this.zzl();
                parcel1.writeNoException();
                parcel1.writeInt(((int)z1));
                return true;
            }
            case 8: {
                String s1 = parcel0.readString();
                zzc.zzb(parcel0);
                Bundle bundle4 = this.zzb(s1);
                parcel1.writeNoException();
                zzc.zzd(parcel1, bundle4);
                return true;
            }
            case 9: {
                String s2 = this.zzc();
                parcel1.writeNoException();
                parcel1.writeString(s2);
                return true;
            }
            case 10: {
                parcel1.writeNoException();
                parcel1.writeInt(12451000);
                return true;
            }
            case 11: {
                this.zzf();
                parcel1.writeNoException();
                return true;
            }
            case 12: {
                boolean z2 = this.zzk();
                parcel1.writeNoException();
                parcel1.writeInt(((int)z2));
                return true;
            }
            case 13: {
                int v4 = parcel0.readInt();
                zzc.zzb(parcel0);
                this.zzj(v4);
                parcel1.writeNoException();
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

