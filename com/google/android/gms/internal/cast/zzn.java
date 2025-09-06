package com.google.android.gms.internal.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import java.math.BigInteger;
import java.util.Map;
import org.checkerframework.dataflow.qual.Pure;

public final class zzn {
    private static final Logger zza;
    private static final String zzb;
    private final String zzc;
    private final Map zzd;
    private final Map zze;

    static {
        zzn.zza = new Logger("ApplicationAnalyticsUtils");
        zzn.zzb = "22.1.0";
    }

    public zzn(Bundle bundle0, String s) {
        this.zzc = s;
        this.zzd = zzah.zza(bundle0, "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR");
        this.zze = zzah.zza(bundle0, "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON");
    }

    public final zzqe zza(zzm zzm0) {
        return (zzqe)this.zzh(zzm0).zzr();
    }

    public final zzqe zzb(zzm zzm0, boolean z) {
        zzqd zzqd0 = this.zzh(zzm0);
        zzn.zzi(zzqd0, z);
        return (zzqe)zzqd0.zzr();
    }

    public final zzqe zzc(zzm zzm0) {
        zzqd zzqd0 = this.zzh(zzm0);
        zzps zzps0 = zzpt.zzc(zzqd0.zza());
        zzps0.zzg(10);
        zzqd0.zze(((zzpt)zzps0.zzr()));
        zzn.zzi(zzqd0, true);
        return (zzqe)zzqd0.zzr();
    }

    public final zzqe zzd(zzm zzm0) {
        zzqd zzqd0 = this.zzh(zzm0);
        if(zzm0.zzp == 1) {
            zzps zzps0 = zzpt.zzc(zzqd0.zza());
            zzps0.zzg(17);
            zzqd0.zze(((zzpt)zzps0.zzr()));
        }
        return (zzqe)zzqd0.zzr();
    }

    @Pure
    public final zzqe zze(zzm zzm0, int v) {
        int v2;
        int v1;
        zzqd zzqd0 = this.zzh(zzm0);
        zzps zzps0 = zzpt.zzc(zzqd0.zza());
        Map map0 = this.zze;
        if(map0 == null) {
            v1 = v + 10000;
        }
        else {
            Integer integer0 = v;
            v1 = map0.containsKey(integer0) ? ((int)(((Integer)Preconditions.checkNotNull(((Integer)map0.get(integer0)))))) : v + 10000;
        }
        zzps0.zzg(v1);
        Map map1 = this.zzd;
        if(map1 == null) {
            v2 = v + 10000;
        }
        else {
            Integer integer1 = v;
            v2 = map1.containsKey(integer1) ? ((int)(((Integer)Preconditions.checkNotNull(((Integer)map1.get(integer1)))))) : v + 10000;
        }
        zzps0.zzc(v2);
        zzqd0.zze(((zzpt)zzps0.zzr()));
        return (zzqe)zzqd0.zzr();
    }

    public final zzqe zzf(zzm zzm0, int v, int v1) {
        zzqd zzqd0 = this.zzh(zzm0);
        zzps zzps0 = zzpt.zzc(zzqd0.zza());
        zzps0.zzj(v);
        zzps0.zzi(v1);
        zzqd0.zze(((zzpt)zzps0.zzr()));
        return (zzqe)zzqd0.zzr();
    }

    public final zzqe zzg(zzm zzm0, int v) {
        zzqd zzqd0 = this.zzh(zzm0);
        zzps zzps0 = zzpt.zzc(zzqd0.zza());
        zzps0.zzj(v);
        zzqd0.zze(((zzpt)zzps0.zzr()));
        return (zzqe)zzqd0.zzr();
    }

    private final zzqd zzh(zzm zzm0) {
        long v1;
        zzqd zzqd0 = zzqe.zzc();
        zzqd0.zzn(zzm0.zzd);
        int v = zzm0.zze;
        zzm0.zze = v + 1;
        zzqd0.zzh(v);
        String s = zzm0.zzc;
        if(s != null) {
            zzqd0.zzk(s);
        }
        zztu zztu0 = zztv.zza();
        if(!TextUtils.isEmpty(zzm0.zzh)) {
            zzqd0.zzg(zzm0.zzh);
            zztu0.zzc(zzm0.zzh);
        }
        if(!TextUtils.isEmpty(zzm0.zzi)) {
            zztu0.zzd(zzm0.zzi);
        }
        if(!TextUtils.isEmpty(zzm0.zzj)) {
            zztu0.zze(zzm0.zzj);
        }
        if(!TextUtils.isEmpty(zzm0.zzk)) {
            zztu0.zza(zzm0.zzk);
        }
        if(!TextUtils.isEmpty(zzm0.zzl)) {
            zztu0.zzb(zzm0.zzl);
        }
        if(!TextUtils.isEmpty(zzm0.zzm)) {
            zztu0.zzf(zzm0.zzm);
        }
        zztu0.zzg(zzbx.zza(zzm0.zzn));
        zzqd0.zzj(((zztv)zztu0.zzr()));
        zzpo zzpo0 = zzpp.zza();
        zzpo0.zzb("22.1.0");
        zzpo0.zza(this.zzc);
        zzqd0.zzb(((zzpp)zzpo0.zzr()));
        zzps zzps0 = zzpt.zza();
        if(zzm0.zzb != null) {
            zzrb zzrb0 = zzrc.zza();
            zzrb0.zza(zzm0.zzb);
            zzps0.zza(((zzrc)zzrb0.zzr()));
        }
        zzps0.zzf(false);
        String s1 = zzm0.zzf;
        if(s1 != null) {
            try {
                String s2 = s1.replace("-", "");
                v1 = new BigInteger(s2.substring(0, Math.min(16, s2.length())), 16).longValue();
            }
            catch(NumberFormatException numberFormatException0) {
                zzn.zza.w(numberFormatException0, "receiverSessionId %s is not valid for hash", new Object[]{s1});
                v1 = 0L;
            }
            zzps0.zzh(v1);
        }
        zzps0.zzb(zzm0.zzg);
        zzps0.zzd(zzm0.zzd());
        zzps0.zze(zzm0.zzo);
        zzqd0.zzd(zzps0);
        return zzqd0;
    }

    private static void zzi(zzqd zzqd0, boolean z) {
        zzps zzps0 = zzpt.zzc(zzqd0.zza());
        zzps0.zzf(z);
        zzqd0.zzd(zzps0);
    }
}

