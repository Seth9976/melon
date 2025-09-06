package com.google.android.gms.measurement.internal;

import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public final class zznm extends zzor {
    public final zzhd zza;
    public final zzhd zzb;
    public final zzhd zzc;
    public final zzhd zzd;
    public final zzhd zze;
    public final zzhd zzf;
    private final Map zzh;

    public zznm(zzpf zzpf0) {
        super(zzpf0);
        this.zzh = new HashMap();
        zzhg zzhg0 = this.zzu.zzd();
        Objects.requireNonNull(zzhg0);
        this.zza = new zzhd(zzhg0, "last_delete_stale", 0L);
        zzhg zzhg1 = this.zzu.zzd();
        Objects.requireNonNull(zzhg1);
        this.zzb = new zzhd(zzhg1, "last_delete_stale_batch", 0L);
        zzhg zzhg2 = this.zzu.zzd();
        Objects.requireNonNull(zzhg2);
        this.zzc = new zzhd(zzhg2, "backoff", 0L);
        zzhg zzhg3 = this.zzu.zzd();
        Objects.requireNonNull(zzhg3);
        this.zzd = new zzhd(zzhg3, "last_upload", 0L);
        zzhg zzhg4 = this.zzu.zzd();
        Objects.requireNonNull(zzhg4);
        this.zze = new zzhd(zzhg4, "last_upload_attempt", 0L);
        zzhg zzhg5 = this.zzu.zzd();
        Objects.requireNonNull(zzhg5);
        this.zzf = new zzhd(zzhg5, "midnight_offset", 0L);
    }

    @Override  // com.google.android.gms.measurement.internal.zzor
    public final boolean zzbb() {
        return false;
    }

    // 去混淆评级： 低(20)
    public final Pair zzc(String s, zzjk zzjk0) {
        return zzjk0.zzo(zzjj.zza) ? this.zzd(s) : new Pair("", Boolean.FALSE);
    }

    @Deprecated
    public final Pair zzd(String s) {
        zznl zznl1;
        Info advertisingIdClient$Info0;
        this.zzg();
        zzib zzib0 = this.zzu;
        long v = zzib0.zzaZ().elapsedRealtime();
        zznl zznl0 = (zznl)this.zzh.get(s);
        if(zznl0 != null && v < zznl0.zzc) {
            return new Pair(zznl0.zza, Boolean.valueOf(zznl0.zzb));
        }
        long v1 = zzib0.zzc().zzl(s, zzfx.zza) + v;
        try {
            try {
                advertisingIdClient$Info0 = null;
                advertisingIdClient$Info0 = AdvertisingIdClient.getAdvertisingIdInfo(zzib0.zzaY());
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
                if(zznl0 != null) {
                    long v2 = this.zzu.zzc().zzl(s, zzfx.zzb);
                    if(v < zznl0.zzc + v2) {
                        return new Pair(zznl0.zza, Boolean.valueOf(zznl0.zzb));
                    }
                }
            }
            if(advertisingIdClient$Info0 == null) {
                return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
            }
            String s1 = advertisingIdClient$Info0.getId();
            zznl1 = s1 == null ? new zznl("", advertisingIdClient$Info0.isLimitAdTrackingEnabled(), v1) : new zznl(s1, advertisingIdClient$Info0.isLimitAdTrackingEnabled(), v1);
        }
        catch(Exception exception0) {
            this.zzu.zzaV().zzj().zzb("Unable to get advertising id", exception0);
            zznl1 = new zznl("", false, v1);
        }
        this.zzh.put(s, zznl1);
        return new Pair(zznl1.zza, Boolean.valueOf(zznl1.zzb));
    }

    @Deprecated
    public final String zzf(String s, boolean z) {
        this.zzg();
        String s1 = z ? ((String)this.zzd(s).first) : "00000000-0000-0000-0000-000000000000";
        MessageDigest messageDigest0 = zzpo.zzO();
        return messageDigest0 == null ? null : String.format(Locale.US, "%032X", new BigInteger(1, messageDigest0.digest(s1.getBytes())));
    }
}

