package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcu;
import java.util.List;
import java.util.Objects;

final class zzmb implements Runnable {
    final String zza;
    final String zzb;
    final zzr zzc;
    final boolean zzd;
    final zzcu zze;
    final zznk zzf;

    public zzmb(zznk zznk0, String s, String s1, zzr zzr0, boolean z, zzcu zzcu0) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = zzr0;
        this.zzd = z;
        this.zze = zzcu0;
        Objects.requireNonNull(zznk0);
        this.zzf = zznk0;
        super();
    }

    @Override
    public final void run() {
        RemoteException remoteException1;
        Bundle bundle1;
        zzga zzga0;
        zznk zznk0;
        Bundle bundle0 = new Bundle();
        try {
            zznk0 = this.zzf;
            zzga0 = zznk0.zzZ();
            if(zzga0 == null) {
                zznk0.zzu.zzaV().zzb().zzc("Failed to get user properties; not connected to service", this.zza, this.zzb);
                goto label_5;
            }
            goto label_7;
        }
        catch(RemoteException remoteException0) {
            bundle1 = bundle0;
            remoteException1 = remoteException0;
            goto label_36;
        }
        catch(Throwable throwable0) {
            this.zzf.zzu.zzk().zzaq(this.zze, bundle0);
            throw throwable0;
        }
    label_5:
        zznk0.zzu.zzk().zzaq(this.zze, bundle0);
        return;
        try {
        label_7:
            Preconditions.checkNotNull(this.zzc);
            List list0 = zzga0.zzp(this.zza, this.zzb, this.zzd, this.zzc);
            bundle1 = new Bundle();
            if(list0 != null) {
                for(Object object0: list0) {
                    zzpk zzpk0 = (zzpk)object0;
                    String s = zzpk0.zze;
                    if(s == null) {
                        Long long0 = zzpk0.zzd;
                        if(long0 == null) {
                            Double double0 = zzpk0.zzg;
                            if(double0 == null) {
                                continue;
                            }
                            bundle1.putDouble(zzpk0.zzb, ((double)double0));
                        }
                        else {
                            bundle1.putLong(zzpk0.zzb, ((long)long0));
                        }
                    }
                    else {
                        bundle1.putString(zzpk0.zzb, s);
                    }
                }
            }
        }
        catch(RemoteException remoteException0) {
            bundle1 = bundle0;
            remoteException1 = remoteException0;
            goto label_36;
        }
        catch(Throwable throwable0) {
            this.zzf.zzu.zzk().zzaq(this.zze, bundle0);
            throw throwable0;
        }
        try {
            zznk0.zzV();
            goto label_44;
        }
        catch(RemoteException remoteException1) {
            try {
            label_36:
                this.zzf.zzu.zzaV().zzb().zzc("Failed to get user properties; remote exception", this.zza, remoteException1);
            }
            catch(Throwable throwable1) {
                throwable0 = throwable1;
                bundle0 = bundle1;
                this.zzf.zzu.zzk().zzaq(this.zze, bundle0);
                throw throwable0;
            }
            this.zzf.zzu.zzk().zzaq(this.zze, bundle1);
            return;
        }
        catch(Throwable throwable1) {
            throwable0 = throwable1;
            bundle0 = bundle1;
        }
        this.zzf.zzu.zzk().zzaq(this.zze, bundle0);
        throw throwable0;
    label_44:
        zznk0.zzu.zzk().zzaq(this.zze, bundle1);
    }
}

