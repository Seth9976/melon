package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.internal.common.zzaf;
import com.google.android.gms.internal.common.zzaj;
import com.google.android.gms.internal.common.zzan;
import com.google.android.gms.internal.common.zzt;
import java.util.Arrays;
import java.util.Set;
import javax.annotation.Nullable;

@KeepForSdk
@ShowFirstParty
public class GoogleSignatureVerifier {
    @Nullable
    private static GoogleSignatureVerifier zza;
    private final Context zzb;
    private volatile String zzc;
    @Nullable
    private static volatile Set zzd;
    @Nullable
    private static volatile Set zze;

    public GoogleSignatureVerifier(Context context0) {
        this.zzb = context0.getApplicationContext();
    }

    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(Context context0) {
        Preconditions.checkNotNull(context0);
        synchronized(GoogleSignatureVerifier.class) {
            if(GoogleSignatureVerifier.zza == null) {
                zzo.zza(context0);
                GoogleSignatureVerifier.zza = new GoogleSignatureVerifier(context0);
            }
            return GoogleSignatureVerifier.zza;
        }
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo0) {
        if(packageInfo0 == null) {
            return false;
        }
        if(GoogleSignatureVerifier.zza(packageInfo0, false)) {
            return true;
        }
        if(GoogleSignatureVerifier.zza(packageInfo0, true)) {
            if(GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren\'t accepted on this build.");
        }
        return false;
    }

    @KeepForSdk
    @ShowFirstParty
    public boolean isPackageGoogleSigned(@Nullable String s) {
        zzy zzy0 = this.zzb(s, false, false);
        zzy0.zze();
        return zzy0.zza;
    }

    @KeepForSdk
    @ShowFirstParty
    public boolean isUidGoogleSigned(int v) {
        zzy zzy0;
        String[] arr_s = this.zzb.getPackageManager().getPackagesForUid(v);
        if(arr_s == null || arr_s.length == 0) {
            zzy0 = zzy.zzc("no pkgs");
        }
        else {
            zzy0 = null;
            for(int v1 = 0; v1 < arr_s.length; ++v1) {
                zzy0 = this.zzb(arr_s[v1], false, false);
                if(zzy0.zza) {
                    zzy0.zze();
                    return zzy0.zza;
                }
            }
            Preconditions.checkNotNull(zzy0);
        }
        zzy0.zze();
        return zzy0.zza;
    }

    @Deprecated
    public static final boolean zza(PackageInfo packageInfo0, boolean z) {
        zzaj zzaj1;
        if(packageInfo0 == null) {
            return false;
        }
        if(z && ("com.android.vending".equals(packageInfo0.packageName) || "com.google.android.gms".equals(packageInfo0.packageName))) {
            ApplicationInfo applicationInfo0 = packageInfo0.applicationInfo;
            if(applicationInfo0 == null) {
                z = false;
            }
            else if((applicationInfo0.flags & 0x81) != 0) {
                z = true;
            }
            else {
                z = false;
            }
        }
        try {
            zzaj zzaj0 = z ? zzn.zzc : zzn.zzb;
            if(Build.VERSION.SDK_INT < 28) {
                byte[] arr_b = packageInfo0.signatures == null || packageInfo0.signatures.length != 1 ? null : packageInfo0.signatures[0].toByteArray();
                zzaj1 = arr_b == null ? zzaj.zzj() : zzaj.zzk(arr_b);
            }
            else {
                zzt.zza(true);
                SigningInfo signingInfo0 = packageInfo0.signingInfo;
                if(signingInfo0 == null || signingInfo0.hasMultipleSigners() || signingInfo0.getSigningCertificateHistory() == null) {
                    zzaj1 = zzaj.zzj();
                }
                else {
                    zzaf zzaf0 = new zzaf();
                    Signature[] arr_signature = signingInfo0.getSigningCertificateHistory();
                    for(int v = 0; v < arr_signature.length; ++v) {
                        zzaf0.zzb(arr_signature[v].toByteArray());
                    }
                    zzaj1 = zzaf0.zzd();
                }
            }
            if(!zzaj1.isEmpty()) {
                zzaj zzaj2 = zzaj1.zzh();
                int v1 = zzaj2.size();
                for(int v2 = 0; v2 < v1; ++v2) {
                    byte[] arr_b1 = (byte[])zzaj2.get(v2);
                    zzan zzan0 = zzaj0.zzr(0);
                    while(zzan0.hasNext()) {
                        Object object0 = zzan0.next();
                        if(Arrays.equals(arr_b1, ((byte[])object0))) {
                            return true;
                        }
                        if(false) {
                            break;
                        }
                    }
                }
                return false;
            }
        }
        catch(IllegalArgumentException unused_ex) {
        }
        Log.i("GoogleSignatureVerifier", "package info is not set correctly");
        return (z ? GoogleSignatureVerifier.zzc(packageInfo0, zzn.zza) : GoogleSignatureVerifier.zzc(packageInfo0, new zzj[]{zzn.zza[0]})) != null;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private final zzy zzb(@Nullable String s, boolean z, boolean z1) {
        PackageInfo packageInfo0;
        zzy zzy0;
        if(s == null) {
            return zzy.zzc("null pkg");
        }
        if(!s.equals(this.zzc)) {
            StrictMode.ThreadPolicy strictMode$ThreadPolicy0 = StrictMode.allowThreadDiskReads();
            try {
                zzo.zzb();
                boolean z2 = zzo.zzg.zzg();
            }
            catch(LoadingException | RemoteException dynamiteModule$LoadingException0) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", dynamiteModule$LoadingException0);
                goto label_22;
            }
            finally {
                StrictMode.setThreadPolicy(strictMode$ThreadPolicy0);
            }
            if(z2) {
                zzv zzv0 = new zzv(null);
                zzv0.zza(s);
                zzv0.zzb(GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb));
                zzv0.zzc(true);
                zzy0 = zzo.zzc(zzv0.zzd());
            }
            else {
                try {
                label_22:
                    int v1 = Build.VERSION.SDK_INT < 28 ? 0x40 : 0x8000040;
                    packageInfo0 = this.zzb.getPackageManager().getPackageInfo(s, v1);
                }
                catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                    return zzy.zzd(("no pkg " + s), packageManager$NameNotFoundException0);
                }
                boolean z3 = GooglePlayServicesUtilLight.honorsDebugCertificates(this.zzb);
                if(packageInfo0 == null) {
                    zzy0 = zzy.zzc("null pkg");
                }
                else if(packageInfo0.signatures == null || packageInfo0.signatures.length != 1) {
                    zzy0 = zzy.zzc("single cert required");
                }
                else {
                    zzk zzk0 = new zzk(packageInfo0.signatures[0].toByteArray());
                    String s1 = packageInfo0.packageName;
                    zzy zzy1 = zzo.zzd(s1, zzk0, z3, false);
                    zzy0 = !zzy1.zza || (packageInfo0.applicationInfo == null || (packageInfo0.applicationInfo.flags & 2) == 0 || !zzo.zzd(s1, zzk0, false, true).zza) ? zzy1 : zzy.zzc("debuggable release cert app rejected");
                }
            }
            if(zzy0.zza) {
                this.zzc = s;
            }
            return zzy0;
        }
        return zzy.zzb();
    }

    @Nullable
    private static zzj zzc(PackageInfo packageInfo0, zzj[] arr_zzj) {
        Signature[] arr_signature = packageInfo0.signatures;
        if(arr_signature != null) {
            if(arr_signature.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzk zzk0 = new zzk(packageInfo0.signatures[0].toByteArray());
            for(int v = 0; v < arr_zzj.length; ++v) {
                if(arr_zzj[v].equals(zzk0)) {
                    return arr_zzj[v];
                }
            }
        }
        return null;
    }
}

