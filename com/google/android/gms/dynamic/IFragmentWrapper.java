package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public interface IFragmentWrapper extends IInterface {
    public static abstract class Stub extends zzb implements IFragmentWrapper {
        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        public static IFragmentWrapper asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return iInterface0 instanceof IFragmentWrapper ? ((IFragmentWrapper)iInterface0) : new zza(iBinder0);
        }

        @Override  // com.google.android.gms.internal.common.zzb
        public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
            switch(v) {
                case 2: {
                    IObjectWrapper iObjectWrapper0 = this.zzb();
                    parcel1.writeNoException();
                    zzc.zze(parcel1, iObjectWrapper0);
                    return true;
                }
                case 3: {
                    Bundle bundle0 = this.zzc();
                    parcel1.writeNoException();
                    zzc.zzd(parcel1, bundle0);
                    return true;
                }
                case 4: {
                    int v2 = this.zzd();
                    parcel1.writeNoException();
                    parcel1.writeInt(v2);
                    return true;
                }
                case 5: {
                    IFragmentWrapper iFragmentWrapper0 = this.zze();
                    parcel1.writeNoException();
                    zzc.zze(parcel1, iFragmentWrapper0);
                    return true;
                }
                case 6: {
                    IObjectWrapper iObjectWrapper1 = this.zzf();
                    parcel1.writeNoException();
                    zzc.zze(parcel1, iObjectWrapper1);
                    return true;
                }
                case 7: {
                    boolean z = this.zzg();
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z));
                    return true;
                }
                case 8: {
                    String s = this.zzh();
                    parcel1.writeNoException();
                    parcel1.writeString(s);
                    return true;
                }
                case 9: {
                    IFragmentWrapper iFragmentWrapper1 = this.zzi();
                    parcel1.writeNoException();
                    zzc.zze(parcel1, iFragmentWrapper1);
                    return true;
                }
                case 10: {
                    int v3 = this.zzj();
                    parcel1.writeNoException();
                    parcel1.writeInt(v3);
                    return true;
                }
                case 11: {
                    boolean z1 = this.zzk();
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z1));
                    return true;
                }
                case 12: {
                    IObjectWrapper iObjectWrapper2 = this.zzl();
                    parcel1.writeNoException();
                    zzc.zze(parcel1, iObjectWrapper2);
                    return true;
                }
                case 13: {
                    boolean z2 = this.zzm();
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z2));
                    return true;
                }
                case 14: {
                    boolean z3 = this.zzn();
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z3));
                    return true;
                }
                case 15: {
                    boolean z4 = this.zzo();
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z4));
                    return true;
                }
                case 16: {
                    boolean z5 = this.zzp();
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z5));
                    return true;
                }
                case 17: {
                    boolean z6 = this.zzq();
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z6));
                    return true;
                }
                case 18: {
                    boolean z7 = this.zzr();
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z7));
                    return true;
                }
                case 19: {
                    boolean z8 = this.zzs();
                    parcel1.writeNoException();
                    parcel1.writeInt(((int)z8));
                    return true;
                }
                case 20: {
                    IObjectWrapper iObjectWrapper3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel0.readStrongBinder());
                    zzc.zzf(parcel0);
                    this.zzt(iObjectWrapper3);
                    parcel1.writeNoException();
                    return true;
                }
                case 21: {
                    boolean z9 = zzc.zza(parcel0);
                    zzc.zzf(parcel0);
                    this.zzu(z9);
                    parcel1.writeNoException();
                    return true;
                }
                case 22: {
                    boolean z10 = zzc.zza(parcel0);
                    zzc.zzf(parcel0);
                    this.zzv(z10);
                    parcel1.writeNoException();
                    return true;
                }
                case 23: {
                    boolean z11 = zzc.zza(parcel0);
                    zzc.zzf(parcel0);
                    this.zzw(z11);
                    parcel1.writeNoException();
                    return true;
                }
                case 24: {
                    boolean z12 = zzc.zza(parcel0);
                    zzc.zzf(parcel0);
                    this.zzx(z12);
                    parcel1.writeNoException();
                    return true;
                }
                case 25: {
                    Intent intent0 = (Intent)zzc.zzb(parcel0, Intent.CREATOR);
                    zzc.zzf(parcel0);
                    this.zzy(intent0);
                    parcel1.writeNoException();
                    return true;
                }
                case 26: {
                    Intent intent1 = (Intent)zzc.zzb(parcel0, Intent.CREATOR);
                    int v4 = parcel0.readInt();
                    zzc.zzf(parcel0);
                    this.zzz(intent1, v4);
                    parcel1.writeNoException();
                    return true;
                }
                case 27: {
                    IObjectWrapper iObjectWrapper4 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel0.readStrongBinder());
                    zzc.zzf(parcel0);
                    this.zzA(iObjectWrapper4);
                    parcel1.writeNoException();
                    return true;
                }
                default: {
                    return false;
                }
            }
        }
    }

    void zzA(IObjectWrapper arg1);

    IObjectWrapper zzb();

    Bundle zzc();

    int zzd();

    IFragmentWrapper zze();

    IObjectWrapper zzf();

    boolean zzg();

    String zzh();

    IFragmentWrapper zzi();

    int zzj();

    boolean zzk();

    IObjectWrapper zzl();

    boolean zzm();

    boolean zzn();

    boolean zzo();

    boolean zzp();

    boolean zzq();

    boolean zzr();

    boolean zzs();

    void zzt(IObjectWrapper arg1);

    void zzu(boolean arg1);

    void zzv(boolean arg1);

    void zzw(boolean arg1);

    void zzx(boolean arg1);

    void zzy(Intent arg1);

    void zzz(Intent arg1, int arg2);
}

