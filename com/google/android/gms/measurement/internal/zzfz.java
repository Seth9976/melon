package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbn;
import java.util.List;

public abstract class zzfz extends zzbm implements zzga {
    public zzfz() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override  // com.google.android.gms.internal.measurement.zzbm
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        zzgg zzgg0 = null;
        switch(v) {
            case 1: {
                zzbg zzbg0 = (zzbg)zzbn.zzb(parcel0, zzbg.CREATOR);
                zzr zzr0 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                zzbn.zzf(parcel0);
                this.zze(zzbg0, zzr0);
                parcel1.writeNoException();
                return true;
            }
            case 2: {
                zzpk zzpk0 = (zzpk)zzbn.zzb(parcel0, zzpk.CREATOR);
                zzr zzr1 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                zzbn.zzf(parcel0);
                this.zzf(zzpk0, zzr1);
                parcel1.writeNoException();
                return true;
            }
            case 4: {
                zzr zzr2 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                zzbn.zzf(parcel0);
                this.zzg(zzr2);
                parcel1.writeNoException();
                return true;
            }
            case 5: {
                zzbg zzbg1 = (zzbg)zzbn.zzb(parcel0, zzbg.CREATOR);
                String s = parcel0.readString();
                String s1 = parcel0.readString();
                zzbn.zzf(parcel0);
                this.zzh(zzbg1, s, s1);
                parcel1.writeNoException();
                return true;
            }
            case 6: {
                zzr zzr3 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                zzbn.zzf(parcel0);
                this.zzi(zzr3);
                parcel1.writeNoException();
                return true;
            }
            case 7: {
                zzr zzr4 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                boolean z = zzbn.zza(parcel0);
                zzbn.zzf(parcel0);
                List list0 = this.zzj(zzr4, z);
                parcel1.writeNoException();
                parcel1.writeTypedList(list0);
                return true;
            }
            case 9: {
                zzbg zzbg2 = (zzbg)zzbn.zzb(parcel0, zzbg.CREATOR);
                String s2 = parcel0.readString();
                zzbn.zzf(parcel0);
                byte[] arr_b = this.zzk(zzbg2, s2);
                parcel1.writeNoException();
                parcel1.writeByteArray(arr_b);
                return true;
            }
            case 10: {
                long v2 = parcel0.readLong();
                String s3 = parcel0.readString();
                String s4 = parcel0.readString();
                String s5 = parcel0.readString();
                zzbn.zzf(parcel0);
                this.zzl(v2, s3, s4, s5);
                parcel1.writeNoException();
                return true;
            }
            case 11: {
                zzr zzr5 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                zzbn.zzf(parcel0);
                String s6 = this.zzm(zzr5);
                parcel1.writeNoException();
                parcel1.writeString(s6);
                return true;
            }
            case 12: {
                zzah zzah0 = (zzah)zzbn.zzb(parcel0, zzah.CREATOR);
                zzr zzr6 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                zzbn.zzf(parcel0);
                this.zzn(zzah0, zzr6);
                parcel1.writeNoException();
                return true;
            }
            case 13: {
                zzah zzah1 = (zzah)zzbn.zzb(parcel0, zzah.CREATOR);
                zzbn.zzf(parcel0);
                this.zzo(zzah1);
                parcel1.writeNoException();
                return true;
            }
            case 14: {
                String s7 = parcel0.readString();
                String s8 = parcel0.readString();
                boolean z1 = zzbn.zza(parcel0);
                zzr zzr7 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                zzbn.zzf(parcel0);
                List list1 = this.zzp(s7, s8, z1, zzr7);
                parcel1.writeNoException();
                parcel1.writeTypedList(list1);
                return true;
            }
            case 15: {
                String s9 = parcel0.readString();
                String s10 = parcel0.readString();
                String s11 = parcel0.readString();
                boolean z2 = zzbn.zza(parcel0);
                zzbn.zzf(parcel0);
                List list2 = this.zzq(s9, s10, s11, z2);
                parcel1.writeNoException();
                parcel1.writeTypedList(list2);
                return true;
            }
            case 16: {
                String s12 = parcel0.readString();
                String s13 = parcel0.readString();
                zzr zzr8 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                zzbn.zzf(parcel0);
                List list3 = this.zzr(s12, s13, zzr8);
                parcel1.writeNoException();
                parcel1.writeTypedList(list3);
                return true;
            }
            case 17: {
                String s14 = parcel0.readString();
                String s15 = parcel0.readString();
                String s16 = parcel0.readString();
                zzbn.zzf(parcel0);
                List list4 = this.zzs(s14, s15, s16);
                parcel1.writeNoException();
                parcel1.writeTypedList(list4);
                return true;
            }
            case 18: {
                zzr zzr9 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                zzbn.zzf(parcel0);
                this.zzt(zzr9);
                parcel1.writeNoException();
                return true;
            }
            case 19: {
                Bundle bundle0 = (Bundle)zzbn.zzb(parcel0, Bundle.CREATOR);
                zzr zzr10 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                zzbn.zzf(parcel0);
                this.zzu(bundle0, zzr10);
                parcel1.writeNoException();
                return true;
            }
            case 20: {
                zzr zzr11 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                zzbn.zzf(parcel0);
                this.zzv(zzr11);
                parcel1.writeNoException();
                return true;
            }
            case 21: {
                zzr zzr12 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                zzbn.zzf(parcel0);
                zzao zzao0 = this.zzw(zzr12);
                parcel1.writeNoException();
                if(zzao0 == null) {
                    parcel1.writeInt(0);
                    return true;
                }
                parcel1.writeInt(1);
                zzao0.writeToParcel(parcel1, 1);
                return true;
            }
            case 24: {
                zzr zzr13 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                Bundle bundle1 = (Bundle)zzbn.zzb(parcel0, Bundle.CREATOR);
                zzbn.zzf(parcel0);
                List list5 = this.zzx(zzr13, bundle1);
                parcel1.writeNoException();
                parcel1.writeTypedList(list5);
                return true;
            }
            case 25: {
                zzr zzr14 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                zzbn.zzf(parcel0);
                this.zzy(zzr14);
                parcel1.writeNoException();
                return true;
            }
            case 26: {
                zzr zzr15 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                zzbn.zzf(parcel0);
                this.zzz(zzr15);
                parcel1.writeNoException();
                return true;
            }
            case 27: {
                zzr zzr16 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                zzbn.zzf(parcel0);
                this.zzA(zzr16);
                parcel1.writeNoException();
                return true;
            }
            case 29: {
                zzr zzr17 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                zzon zzon0 = (zzon)zzbn.zzb(parcel0, zzon.CREATOR);
                IBinder iBinder0 = parcel0.readStrongBinder();
                if(iBinder0 != null) {
                    IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    zzgg0 = iInterface0 instanceof zzgg ? ((zzgg)iInterface0) : new zzge(iBinder0);
                }
                zzbn.zzf(parcel0);
                this.zzB(zzr17, zzon0, zzgg0);
                parcel1.writeNoException();
                return true;
            }
            case 30: {
                zzr zzr18 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                zzaf zzaf0 = (zzaf)zzbn.zzb(parcel0, zzaf.CREATOR);
                zzbn.zzf(parcel0);
                this.zzC(zzr18, zzaf0);
                parcel1.writeNoException();
                return true;
            }
            case 0x1F: {
                zzr zzr19 = (zzr)zzbn.zzb(parcel0, zzr.CREATOR);
                Bundle bundle2 = (Bundle)zzbn.zzb(parcel0, Bundle.CREATOR);
                IBinder iBinder1 = parcel0.readStrongBinder();
                if(iBinder1 != null) {
                    IInterface iInterface1 = iBinder1.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    zzgg0 = iInterface1 instanceof zzgd ? ((zzgd)iInterface1) : new zzgb(iBinder1);
                }
                zzbn.zzf(parcel0);
                this.zzD(zzr19, bundle2, ((zzgd)zzgg0));
                parcel1.writeNoException();
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

