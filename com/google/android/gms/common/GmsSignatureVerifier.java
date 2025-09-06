package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.common.zzaj;
import java.util.HashMap;

@KeepForSdk
@ShowFirstParty
public class GmsSignatureVerifier {
    private static final zzab zza;
    private static final zzab zzb;
    private static final HashMap zzc;

    static {
        zzaa zzaa0 = new zzaa();
        zzaa0.zza("com.google.android.gms");
        zzaa0.zzb(204200000L);
        zzaa0.zzc(zzaj.zzm(zzo.zzf.zzc(), zzo.zzd.zzc(), zzo.zzb.zzc()));
        zzaa0.zzd(zzaj.zzm(zzo.zze.zzc(), zzo.zzc.zzc(), zzo.zza.zzc()));
        GmsSignatureVerifier.zza = zzaa0.zze();
        zzaa zzaa1 = new zzaa();
        zzaa1.zza("com.android.vending");
        zzaa1.zzb(82240000L);
        zzaa1.zzc(zzaj.zzk(zzo.zzf.zzc()));
        zzaa1.zzd(zzaj.zzl(zzo.zze.zzc(), zzo.zzc.zzc()));
        GmsSignatureVerifier.zzb = zzaa1.zze();
        GmsSignatureVerifier.zzc = new HashMap();
    }
}

