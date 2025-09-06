package com.google.android.gms.common.signatureverification;

public final class zzd {
    private static SignatureVerificationConfiguration zza;

    public static void zza(SignatureVerificationConfiguration signatureVerificationConfiguration0) {
        synchronized(zzd.class) {
            if(zzd.zza == null) {
                zzd.zza = signatureVerificationConfiguration0;
                return;
            }
        }
        throw new IllegalStateException("Redundantly setting SignatureVerificationConfiguration");
    }

    public static SignatureVerificationConfiguration zzb() {
        return zzd.zzc();
    }

    private static SignatureVerificationConfiguration zzc() {
        synchronized(zzd.class) {
            if(zzd.zza == null) {
                zzd.zza(new zzb());
            }
            return zzd.zza;
        }
    }
}

