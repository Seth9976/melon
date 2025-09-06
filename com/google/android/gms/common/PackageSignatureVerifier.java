package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.signatureverification.SignatureVerificationConfigurationProvider;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;

@KeepForSdk
@ShowFirstParty
public class PackageSignatureVerifier {
    static volatile zzac zza;
    private static zzad zzb;

    @KeepForSdk
    @ShowFirstParty
    public PackageVerificationResult queryPackageSignatureVerified(Context context0, String s) {
        boolean z = GooglePlayServicesUtilLight.honorsDebugCertificates(context0);
        PackageSignatureVerifier.zza(context0);
        StrictMode.ThreadPolicy strictMode$ThreadPolicy0 = StrictMode.allowThreadDiskReads();
        try {
            zzo.zzb();
            boolean z1 = zzo.zzg.zzi();
        }
        catch(LoadingException | RemoteException dynamiteModule$LoadingException0) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", dynamiteModule$LoadingException0);
            throw new zzae();
        }
        finally {
            StrictMode.setThreadPolicy(strictMode$ThreadPolicy0);
        }
        if(!z1) {
            throw new zzae();
        }
        SignatureVerificationConfigurationProvider.zza().zza();
        String s1 = s + (z ? "-1" : "-0");
        if(PackageSignatureVerifier.zza != null && PackageSignatureVerifier.zza.zza().equals(s1)) {
            return PackageSignatureVerifier.zza.zzb();
        }
        PackageSignatureVerifier.zza(context0);
        zzv zzv0 = new zzv(null);
        zzv0.zza(s);
        zzv0.zzb(z);
        zzv0.zzc(false);
        zzy zzy0 = zzo.zzc(zzv0.zzd());
        if(zzy0.zza) {
            PackageVerificationResult packageVerificationResult0 = PackageVerificationResult.zzd(s, zzy0.zzd, null);
            PackageSignatureVerifier.zza = new zzac(s1, packageVerificationResult0);
            return packageVerificationResult0;
        }
        Preconditions.checkNotNull(zzy0.zzb);
        return PackageVerificationResult.zza(s, zzy0.zzb, zzy0.zzc, null);
    }

    @KeepForSdk
    @ShowFirstParty
    public PackageVerificationResult queryPackageSignatureVerifiedWithRetry(Context context0, String s) {
        try {
            PackageVerificationResult packageVerificationResult0 = this.queryPackageSignatureVerified(context0, s);
            packageVerificationResult0.zzc();
            return packageVerificationResult0;
        }
        catch(SecurityException securityException0) {
            PackageVerificationResult packageVerificationResult1 = this.queryPackageSignatureVerified(context0, s);
            if(packageVerificationResult1.zzb()) {
                Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", securityException0);
            }
            return packageVerificationResult1;
        }
    }

    private static zzad zza(Context context0) {
        synchronized(PackageSignatureVerifier.class) {
            if(PackageSignatureVerifier.zzb == null) {
                PackageSignatureVerifier.zzb = new zzad(context0);
            }
            return PackageSignatureVerifier.zzb;
        }
    }
}

