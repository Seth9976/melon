package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import b3.Z;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.internal.measurement.zzrg;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class zzgh extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private final long zzh;
    private List zzi;
    private String zzj;
    private int zzk;
    private String zzl;
    private String zzm;
    private long zzn;
    private String zzo;

    public zzgh(zzib zzib0, long v, long v1) {
        super(zzib0);
        this.zzn = 0L;
        this.zzo = null;
        this.zzg = v;
        this.zzh = v1;
    }

    @Override  // com.google.android.gms.measurement.internal.zzg
    public final boolean zze() {
        return true;
    }

    @Override  // com.google.android.gms.measurement.internal.zzg
    @EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    public final void zzf() {
        String s3;
        zzib zzib0 = this.zzu;
        zzib0.zzaV().zzk().zzc("sdkVersion bundled with app, dynamiteVersion", this.zzh, this.zzg);
        PackageManager packageManager0 = zzib0.zzaY().getPackageManager();
        String s = "";
        int v = 0x80000000;
        String s1 = "Unknown";
        String s2 = "unknown";
        if(packageManager0 == null) {
            zzib0.zzaV().zzb().zzb("PackageManager is null, app identity information might be inaccurate. appId", zzgt.zzl("com.iloen.melon"));
            goto label_25;
        }
        else {
            try {
                s2 = packageManager0.getInstallerPackageName("com.iloen.melon");
            }
            catch(IllegalArgumentException unused_ex) {
                this.zzu.zzaV().zzb().zzb("Error retrieving app installer package name. appId", zzgt.zzl("com.iloen.melon"));
            }
            if(s2 == null) {
                s2 = "manual_install";
            }
            else if("com.android.vending".equals(s2)) {
                s2 = "";
            }
            try {
                PackageInfo packageInfo0 = packageManager0.getPackageInfo("com.iloen.melon", 0);
                if(packageInfo0 == null) {
                label_25:
                    s3 = "Unknown";
                }
                else {
                    CharSequence charSequence0 = packageManager0.getApplicationLabel(packageInfo0.applicationInfo);
                    s3 = TextUtils.isEmpty(charSequence0) ? "Unknown" : charSequence0.toString();
                    s1 = packageInfo0.versionName;
                    v = packageInfo0.versionCode;
                }
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
                this.zzu.zzaV().zzb().zzc("Error retrieving package info. appId, appName", zzgt.zzl("com.iloen.melon"), "Unknown");
                s3 = "Unknown";
            }
        }
        this.zza = "com.iloen.melon";
        this.zzd = s2;
        this.zzb = s1;
        this.zzc = v;
        this.zze = s3;
        this.zzf = 0L;
        zzib zzib1 = this.zzu;
        int v1 = zzib1.zzC();
        switch(v1) {
            case 0: {
                this.zzu.zzaV().zzk().zza("App measurement collection enabled");
                break;
            }
            case 1: {
                this.zzu.zzaV().zzi().zza("App measurement deactivated via the manifest");
                break;
            }
            case 3: {
                this.zzu.zzaV().zzi().zza("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                break;
            }
            case 4: {
                this.zzu.zzaV().zzi().zza("App measurement disabled via the manifest");
                break;
            }
            case 6: {
                this.zzu.zzaV().zzh().zza("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                break;
            }
            case 7: {
                this.zzu.zzaV().zzi().zza("App measurement disabled via the global data collection setting");
                break;
            }
            case 8: {
                this.zzu.zzaV().zzi().zza("App measurement disabled due to denied storage consent");
                break;
            }
            default: {
                this.zzu.zzaV().zzi().zza("App measurement disabled");
                this.zzu.zzaV().zzc().zza("Invalid scion state in identity");
            }
        }
        try {
            this.zzl = "";
            zzib zzib2 = this.zzu;
            String s4 = zzls.zza(zzib2.zzaY(), "google_app_id", zzib1.zzq());
            if(!TextUtils.isEmpty(s4)) {
                s = s4;
            }
            this.zzl = s;
            if(v1 == 0) {
                zzib2.zzaV().zzk().zzc("App measurement enabled for app package, google app id", this.zza, this.zzl);
            }
        }
        catch(IllegalStateException illegalStateException0) {
            this.zzu.zzaV().zzb().zzc("Fetching Google App Id failed with exception. appId", zzgt.zzl("com.iloen.melon"), illegalStateException0);
        }
        this.zzi = null;
        zzib zzib3 = this.zzu;
        List list0 = zzib3.zzc().zzs("analytics.safelisted_events");
        if(list0 == null) {
            this.zzi = null;
        }
        else if(list0.isEmpty()) {
            zzib3.zzaV().zzh().zza("Safelisted event list is empty. Ignoring");
        }
        else {
            for(Object object0: list0) {
                if(zzib3.zzk().zzk("safelisted event", ((String)object0))) {
                    continue;
                }
                goto label_80;
            }
            this.zzi = list0;
        }
    label_80:
        if(packageManager0 != null) {
            this.zzk = InstantApps.isInstantApp(zzib3.zzaY());
            return;
        }
        this.zzk = 0;
    }

    public final zzr zzh(String s) {
        int v12;
        long v11;
        boolean z5;
        String s8;
        long v9;
        String s5;
        Object object0;
        Class class0;
        zzib zzib1;
        PackageManagerWrapper packageManagerWrapper0;
        long v3;
        this.zzg();
        String s1 = this.zzj();
        String s2 = this.zzk();
        this.zzb();
        String s3 = this.zzb;
        this.zzb();
        long v = (long)this.zzc;
        this.zzb();
        Preconditions.checkNotNull(this.zzd);
        String s4 = this.zzd;
        zzib zzib0 = this.zzu;
        zzib0.zzc().zzi();
        this.zzb();
        this.zzg();
        long v1 = this.zzf;
        if(Long.compare(v1, 0L) == 0) {
            zzpo zzpo0 = this.zzu.zzk();
            Context context0 = zzib0.zzaY();
            zzpo0.zzg();
            Preconditions.checkNotNull(context0);
            new String("com.iloen.melon");
            PackageManager packageManager0 = context0.getPackageManager();
            MessageDigest messageDigest0 = zzpo.zzO();
            long v2 = -1L;
            if(messageDigest0 == null) {
                Z.u(zzpo0.zzu, "Could not get MD5 instance");
                v3 = 0L;
                v1 = -1L;
            }
            else if(packageManager0 == null) {
                v3 = 0L;
                v1 = 0L;
            }
            else {
                try {
                    if(zzpo0.zzad(context0, "com.iloen.melon")) {
                        v3 = 0L;
                        v2 = 0L;
                    }
                    else {
                        packageManagerWrapper0 = Wrappers.packageManager(context0);
                        zzib1 = zzpo0.zzu;
                        v3 = 0L;
                        goto label_34;
                    }
                    goto label_50;
                }
                catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                    v3 = 0L;
                    zzpo0.zzu.zzaV().zzb().zzb("Package name not found", packageManager$NameNotFoundException0);
                    v1 = 0L;
                    goto label_54;
                }
                try {
                label_34:
                    Signature[] arr_signature = packageManagerWrapper0.getPackageInfo("com.iloen.melon", 0x40).signatures;
                    if(arr_signature == null || arr_signature.length <= 0) {
                        zzib1.zzaV().zze().zza("Could not get signatures");
                    }
                    else {
                        v2 = zzpo.zzP(messageDigest0.digest(arr_signature[0].toByteArray()));
                    }
                    goto label_50;
                }
                catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                    zzpo0.zzu.zzaV().zzb().zzb("Package name not found", packageManager$NameNotFoundException0);
                    v1 = 0L;
                    goto label_54;
                }
                try {
                    v3 = 0L;
                    v2 = 0L;
                }
                catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                    v3 = 0L;
                    zzpo0.zzu.zzaV().zzb().zzb("Package name not found", packageManager$NameNotFoundException0);
                    v1 = 0L;
                    goto label_54;
                }
            label_50:
                v1 = v2;
            }
        label_54:
            this.zzf = v1;
        }
        else {
            v3 = 0L;
        }
        zzib zzib2 = this.zzu;
        boolean z = zzib2.zzB();
        int v4 = !zzib2.zzd().zzm;
        this.zzg();
        if(zzib2.zzB()) {
            zzrg.zza();
            if(zzib2.zzc().zzp(null, zzfx.zzaH)) {
                this.zzu.zzaV().zzk().zza("Disabled IID for tests.");
                goto label_76;
            }
            else {
                try {
                    class0 = zzib2.zzaY().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                    if(class0 == null) {
                        goto label_76;
                    }
                    else {
                        goto label_68;
                    }
                    goto label_77;
                }
                catch(ClassNotFoundException unused_ex) {
                    goto label_76;
                }
                try {
                label_68:
                    object0 = class0.getDeclaredMethod("getInstance", Context.class).invoke(null, this.zzu.zzaY());
                }
                catch(Exception unused_ex) {
                    this.zzu.zzaV().zzf().zza("Failed to obtain Firebase Analytics instance");
                    goto label_76;
                }
                if(object0 == null) {
                    goto label_76;
                }
                else {
                    try {
                        s5 = (String)class0.getDeclaredMethod("getFirebaseInstanceId", null).invoke(object0, null);
                    }
                    catch(Exception unused_ex) {
                        this.zzu.zzaV().zzh().zza("Failed to retrieve Firebase Instance Id");
                        goto label_76;
                    }
                }
            }
        }
        else {
        label_76:
            s5 = null;
        }
    label_77:
        long v5 = this.zzu.zzd().zzc.zza();
        long v6 = v5 == 0L ? this.zzu.zza : Math.min(this.zzu.zza, v5);
        this.zzb();
        int v7 = this.zzk;
        boolean z1 = this.zzu.zzc().zzu();
        zzhg zzhg0 = this.zzu.zzd();
        zzhg0.zzg();
        SharedPreferences sharedPreferences0 = zzhg0.zzd();
        zzib zzib3 = this.zzu;
        boolean z2 = sharedPreferences0.getBoolean("deferred_analytics_collection", false);
        boolean z3 = zzib3.zzc().zzw("google_analytics_default_allow_ad_personalization_signals", true) != zzjh.zzd;
        long v8 = this.zzg;
        Boolean boolean0 = Boolean.valueOf(z3);
        List list0 = this.zzi;
        String s6 = zzib3.zzd().zzl().zzl();
        if(this.zzj == null) {
            this.zzj = zzib3.zzk().zzaw();
        }
        String s7 = this.zzj;
        if(zzib3.zzd().zzl().zzo(zzjj.zzb)) {
            this.zzg();
            v9 = v8;
            if(this.zzn != 0L) {
                long v10 = zzib3.zzaZ().currentTimeMillis() - this.zzn;
                if(this.zzm != null && v10 > 86400000L && this.zzo == null) {
                    this.zzi();
                }
            }
            if(this.zzm == null) {
                this.zzi();
            }
            s8 = this.zzm;
        }
        else {
            v9 = v8;
            s8 = null;
        }
        boolean z4 = zzib3.zzc().zzx();
        zzpo zzpo1 = zzib3.zzk();
        String s9 = this.zzj();
        zzib zzib4 = zzpo1.zzu;
        if(zzib4.zzaY().getPackageManager() == null) {
            z5 = z4;
            v11 = 0L;
        }
        else {
            try {
                z5 = z4;
                if(Wrappers.packageManager(zzib4.zzaY()).getApplicationInfo(s9, 0) == null) {
                    goto label_123;
                }
                else {
                    v12 = 35;
                }
            }
            catch(PackageManager.NameNotFoundException unused_ex) {
                zzpo1.zzu.zzaV().zzi().zzb("PackageManager failed to find running app: app_id", s9);
                v12 = 0;
            }
            goto label_124;
        label_123:
            v12 = 0;
        label_124:
            v11 = (long)v12;
        }
        int v13 = this.zzu.zzd().zzl().zzb();
        String s10 = this.zzu.zzd().zzj().zze();
        zzql.zza();
        zzib zzib5 = this.zzu;
        int v14 = this.zzu.zzc().zzp(null, zzfx.zzaQ) ? zzib5.zzk().zzU() : 0;
        zzql.zza();
        if(zzib5.zzc().zzp(null, zzfx.zzaQ)) {
            v3 = zzib5.zzk().zzV();
        }
        String s11 = new zze(zzib5.zzc().zzw("google_analytics_default_allow_ad_personalization_signals", true)).zzb();
        int v15 = this.zzu.zzx().zzj().zza();
        return new zzr(s1, s2, s3, v, s4, 130000L, v1, s, z, ((boolean)v4), s5, v6, v7, z1, z2, boolean0, v9, list0, s6, s7, s8, z5, v11, v13, s10, v14, v3, zzib5.zzc().zzz(), s11, this.zzu.zza, v15);
    }

    public final void zzi() {
        String s;
        this.zzg();
        zzib zzib0 = this.zzu;
        if(zzib0.zzd().zzl().zzo(zzjj.zzb)) {
            byte[] arr_b = new byte[16];
            zzib0.zzk().zzf().nextBytes(arr_b);
            s = String.format(Locale.US, "%032x", new BigInteger(1, arr_b));
        }
        else {
            zzib0.zzaV().zzj().zza("Analytics Storage consent is not granted");
            s = null;
        }
        zzib0.zzaV().zzj().zza("Resetting session stitching token to " + (s == null ? "null" : "not null"));
        this.zzm = s;
        this.zzn = zzib0.zzaZ().currentTimeMillis();
    }

    public final String zzj() {
        this.zzb();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    public final String zzk() {
        this.zzg();
        this.zzb();
        Preconditions.checkNotNull(this.zzl);
        return this.zzl;
    }

    public final String zzl() {
        this.zzb();
        Preconditions.checkNotNull(this.zze);
        return this.zze;
    }

    public final int zzm() {
        this.zzb();
        return this.zzc;
    }

    public final long zzn() {
        return this.zzh;
    }

    public final int zzo() {
        this.zzb();
        return this.zzk;
    }

    public final List zzp() {
        return this.zzi;
    }

    public final boolean zzq(String s) {
        boolean z = this.zzo != null && !this.zzo.equals(s);
        this.zzo = s;
        return z;
    }
}

