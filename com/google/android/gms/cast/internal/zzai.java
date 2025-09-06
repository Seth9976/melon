package com.google.android.gms.cast.internal;

import android.os.Parcel;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzai extends zzb implements zzaj {
    public zzai() {
        super("com.google.android.gms.cast.internal.ICastDeviceControllerListener");
    }

    @Override  // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                int v2 = parcel0.readInt();
                zzc.zzb(parcel0);
                this.zzk(v2);
                return true;
            }
            case 2: {
                ApplicationMetadata applicationMetadata0 = (ApplicationMetadata)zzc.zza(parcel0, ApplicationMetadata.CREATOR);
                String s = parcel0.readString();
                String s1 = parcel0.readString();
                boolean z = zzc.zzf(parcel0);
                zzc.zzb(parcel0);
                this.zzb(applicationMetadata0, s, s1, z);
                return true;
            }
            case 3: {
                int v3 = parcel0.readInt();
                zzc.zzb(parcel0);
                this.zzc(v3);
                return true;
            }
            case 4: {
                String s2 = parcel0.readString();
                double f = parcel0.readDouble();
                boolean z1 = zzc.zzf(parcel0);
                zzc.zzb(parcel0);
                this.zzn(s2, f, z1);
                return true;
            }
            case 5: {
                String s3 = parcel0.readString();
                String s4 = parcel0.readString();
                zzc.zzb(parcel0);
                this.zzp(s3, s4);
                return true;
            }
            case 6: {
                String s5 = parcel0.readString();
                byte[] arr_b = parcel0.createByteArray();
                zzc.zzb(parcel0);
                this.zzh(s5, arr_b);
                return true;
            }
            case 7: {
                int v4 = parcel0.readInt();
                zzc.zzb(parcel0);
                this.zze(v4);
                return true;
            }
            case 8: {
                int v5 = parcel0.readInt();
                zzc.zzb(parcel0);
                this.zzg(v5);
                return true;
            }
            case 9: {
                int v6 = parcel0.readInt();
                zzc.zzb(parcel0);
                this.zzd(v6);
                return true;
            }
            case 10: {
                String s6 = parcel0.readString();
                long v7 = parcel0.readLong();
                int v8 = parcel0.readInt();
                zzc.zzb(parcel0);
                this.zzm(s6, v7, v8);
                return true;
            }
            case 11: {
                String s7 = parcel0.readString();
                long v9 = parcel0.readLong();
                zzc.zzb(parcel0);
                this.zzl(s7, v9);
                return true;
            }
            case 12: {
                zza zza0 = (zza)zzc.zza(parcel0, zza.CREATOR);
                zzc.zzb(parcel0);
                this.zzf(zza0);
                return true;
            }
            case 13: {
                zzac zzac0 = (zzac)zzc.zza(parcel0, zzac.CREATOR);
                zzc.zzb(parcel0);
                this.zzj(zzac0);
                return true;
            }
            case 14: {
                int v10 = parcel0.readInt();
                zzc.zzb(parcel0);
                this.zzi(v10);
                return true;
            }
            case 15: {
                int v11 = parcel0.readInt();
                zzc.zzb(parcel0);
                this.zzo(v11);
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

