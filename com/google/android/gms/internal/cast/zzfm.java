package com.google.android.gms.internal.cast;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;

public abstract class zzfm extends zzb implements zzfn {
    public zzfm() {
        super("com.google.android.gms.usagereporting.internal.IUsageReportingCallbacks");
    }

    @Override  // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 2: {
                Status status0 = (Status)zzc.zza(parcel0, Status.CREATOR);
                zzfk zzfk0 = (zzfk)zzc.zza(parcel0, zzfk.CREATOR);
                zzc.zzb(parcel0);
                this.zzb(status0, zzfk0);
                return true;
            }
            case 3: {
                Status status1 = (Status)zzc.zza(parcel0, Status.CREATOR);
                zzc.zzb(parcel0);
                this.zzm(status1);
                return true;
            }
            case 4: {
                Status status2 = (Status)zzc.zza(parcel0, Status.CREATOR);
                zzc.zzb(parcel0);
                this.zzj(status2);
                return true;
            }
            case 5: {
                Status status3 = (Status)zzc.zza(parcel0, Status.CREATOR);
                zzc.zzb(parcel0);
                this.zzo(status3);
                return true;
            }
            case 6: {
                Status status4 = (Status)zzc.zza(parcel0, Status.CREATOR);
                ArrayList arrayList0 = parcel0.createStringArrayList();
                zzc.zzb(parcel0);
                this.zze(status4, arrayList0);
                return true;
            }
            case 7: {
                Status status5 = (Status)zzc.zza(parcel0, Status.CREATOR);
                zzc.zzb(parcel0);
                this.zzk(status5);
                return true;
            }
            case 8: {
                Status status6 = (Status)zzc.zza(parcel0, Status.CREATOR);
                boolean z = zzc.zzf(parcel0);
                zzew zzew0 = (zzew)zzc.zza(parcel0, zzew.CREATOR);
                zzc.zzb(parcel0);
                this.zzc(status6, z, zzew0);
                return true;
            }
            case 9: {
                Status status7 = (Status)zzc.zza(parcel0, Status.CREATOR);
                zzew zzew1 = (zzew)zzc.zza(parcel0, zzew.CREATOR);
                zzc.zzb(parcel0);
                this.zzh(status7, zzew1);
                return true;
            }
            case 10: {
                PendingIntent pendingIntent0 = (PendingIntent)zzc.zza(parcel0, PendingIntent.CREATOR);
                zzc.zzb(parcel0);
                this.zzf(pendingIntent0);
                return true;
            }
            case 11: {
                Status status8 = (Status)zzc.zza(parcel0, Status.CREATOR);
                zzc.zzb(parcel0);
                this.zzl(status8);
                return true;
            }
            case 12: {
                Status status9 = (Status)zzc.zza(parcel0, Status.CREATOR);
                zzey zzey0 = (zzey)zzc.zza(parcel0, zzey.CREATOR);
                zzc.zzb(parcel0);
                this.zzg(status9, zzey0);
                return true;
            }
            case 13: {
                Status status10 = (Status)zzc.zza(parcel0, Status.CREATOR);
                zzc.zzb(parcel0);
                this.zzn(status10);
                return true;
            }
            case 14: {
                Status status11 = (Status)zzc.zza(parcel0, Status.CREATOR);
                zzff zzff0 = (zzff)zzc.zza(parcel0, zzff.CREATOR);
                zzc.zzb(parcel0);
                this.zzi(status11, zzff0);
                return true;
            }
            case 15: {
                Status status12 = (Status)zzc.zza(parcel0, Status.CREATOR);
                zzew zzew2 = (zzew)zzc.zza(parcel0, zzew.CREATOR);
                zzc.zzb(parcel0);
                this.zzd(status12, zzew2);
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

