package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import b3.Z;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class zzal extends zzjd {
    private Boolean zza;
    private String zzb;
    private zzak zzc;
    private Boolean zzd;

    public zzal(zzib zzib0) {
        super(zzib0);
        this.zzc = (String s, String s1) -> null;
    }

    public final String zzA() {
        return this.zzK("debug.firebase.analytics.app", "");
    }

    public final String zzB() {
        return this.zzK("debug.deferred.deeplink", "");
    }

    public final boolean zzC(String s) {
        return "1".equals(this.zzc.zza(s, "gaia_collection_enabled"));
    }

    public final boolean zzD(String s) {
        return "1".equals(this.zzc.zza(s, "measurement.event_sampling_enabled"));
    }

    public final boolean zzE() {
        if(this.zza == null) {
            Boolean boolean0 = this.zzr("app_measurement_lite");
            this.zza = boolean0;
            if(boolean0 == null) {
                this.zza = Boolean.FALSE;
            }
        }
        return this.zza.booleanValue() || !this.zzu.zzp();
    }

    public static final long zzF() {
        return (long)(((Long)zzfx.zzd.zzb(null)));
    }

    public static final int zzG() {
        return Math.max(0, ((int)(((Integer)zzfx.zzi.zzb(null)))));
    }

    public static final long zzH() {
        return (long)(((int)(((Integer)zzfx.zzk.zzb(null)))));
    }

    public static final long zzI() {
        return (long)(((Long)zzfx.zzR.zzb(null)));
    }

    public static final long zzJ() {
        return (long)(((Long)zzfx.zzM.zzb(null)));
    }

    private final String zzK(String s, String s1) {
        try {
            String s2 = (String)Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, s, "");
            Preconditions.checkNotNull(s2);
            return s2;
        }
        catch(ClassNotFoundException classNotFoundException0) {
            this.zzu.zzaV().zzb().zzb("Could not find SystemProperties class", classNotFoundException0);
            return "";
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            this.zzu.zzaV().zzb().zzb("Could not find SystemProperties.get() method", noSuchMethodException0);
            return "";
        }
        catch(IllegalAccessException illegalAccessException0) {
            this.zzu.zzaV().zzb().zzb("Could not access SystemProperties.get()", illegalAccessException0);
            return "";
        }
        catch(InvocationTargetException invocationTargetException0) {
            this.zzu.zzaV().zzb().zzb("SystemProperties.get() threw an exception", invocationTargetException0);
            return "";
        }
    }

    public final void zza(zzak zzak0) {
        this.zzc = zzak0;
    }

    public final String zzb() {
        return "FA";
    }

    // 去混淆评级： 低(20)
    public final int zzc() {
        return this.zzu.zzk().zzag(201500000, true) ? 100 : 25;
    }

    public final int zzd(String s) {
        return this.zzn(s, zzfx.zzX, 25, 100);
    }

    // 去混淆评级： 低(20)
    public final int zze(String s, boolean z) {
        return z ? this.zzn(s, zzfx.zzah, 100, 500) : 500;
    }

    public final int zzf(String s, boolean z) {
        return Math.max(this.zze(s, z), 0x100);
    }

    public final int zzh(String s) {
        return this.zzn(s, zzfx.zzW, 500, 2000);
    }

    public final long zzi() {
        return 130000L;
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean zzj() {
        if(this.zzd == null) {
            synchronized(this) {
                if(this.zzd == null) {
                    boolean z = false;
                    zzib zzib0 = this.zzu;
                    ApplicationInfo applicationInfo0 = zzib0.zzaY().getApplicationInfo();
                    String s = ProcessUtils.getMyProcessName();
                    if(applicationInfo0 != null) {
                        if(applicationInfo0.processName != null && applicationInfo0.processName.equals(s)) {
                            z = true;
                        }
                        this.zzd = Boolean.valueOf(z);
                    }
                    if(this.zzd == null) {
                        this.zzd = Boolean.TRUE;
                        zzib0.zzaV().zzb().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzd.booleanValue();
    }

    // 去混淆评级： 低(20)
    public final String zzk(String s, zzfw zzfw0) {
        return TextUtils.isEmpty(s) ? ((String)zzfw0.zzb(null)) : ((String)zzfw0.zzb(this.zzc.zza(s, zzfw0.zza())));
    }

    public final long zzl(String s, zzfw zzfw0) {
        if(TextUtils.isEmpty(s)) {
            return (long)(((Long)zzfw0.zzb(null)));
        }
        String s1 = this.zzc.zza(s, zzfw0.zza());
        if(TextUtils.isEmpty(s1)) {
            return (long)(((Long)zzfw0.zzb(null)));
        }
        try {
            return (long)(((Long)zzfw0.zzb(Long.parseLong(s1))));
        }
        catch(NumberFormatException unused_ex) {
            return (long)(((Long)zzfw0.zzb(null)));
        }
    }

    public final int zzm(String s, zzfw zzfw0) {
        if(TextUtils.isEmpty(s)) {
            return (int)(((Integer)zzfw0.zzb(null)));
        }
        String s1 = this.zzc.zza(s, zzfw0.zza());
        if(TextUtils.isEmpty(s1)) {
            return (int)(((Integer)zzfw0.zzb(null)));
        }
        try {
            return (int)(((Integer)zzfw0.zzb(Integer.parseInt(s1))));
        }
        catch(NumberFormatException unused_ex) {
            return (int)(((Integer)zzfw0.zzb(null)));
        }
    }

    public final int zzn(String s, zzfw zzfw0, int v, int v1) {
        return Math.max(Math.min(this.zzm(s, zzfw0), v1), v);
    }

    public final double zzo(String s, zzfw zzfw0) {
        if(TextUtils.isEmpty(s)) {
            return (double)(((Double)zzfw0.zzb(null)));
        }
        String s1 = this.zzc.zza(s, zzfw0.zza());
        if(TextUtils.isEmpty(s1)) {
            return (double)(((Double)zzfw0.zzb(null)));
        }
        try {
            return (double)(((Double)zzfw0.zzb(Double.parseDouble(s1))));
        }
        catch(NumberFormatException unused_ex) {
            return (double)(((Double)zzfw0.zzb(null)));
        }
    }

    public final boolean zzp(String s, zzfw zzfw0) {
        if(TextUtils.isEmpty(s)) {
            return ((Boolean)zzfw0.zzb(null)).booleanValue();
        }
        String s1 = this.zzc.zza(s, zzfw0.zza());
        return TextUtils.isEmpty(s1) ? ((Boolean)zzfw0.zzb(null)).booleanValue() : ((Boolean)zzfw0.zzb(Boolean.valueOf("1".equals(s1)))).booleanValue();
    }

    public final Bundle zzq() {
        try {
            zzib zzib0 = this.zzu;
            if(zzib0.zzaY().getPackageManager() == null) {
                zzib0.zzaV().zzb().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo0 = Wrappers.packageManager(zzib0.zzaY()).getApplicationInfo("com.iloen.melon", 0x80);
            if(applicationInfo0 == null) {
                zzib0.zzaV().zzb().zza("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
            return applicationInfo0.metaData;
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
        }
        this.zzu.zzaV().zzb().zzb("Failed to load metadata: Package name not found", packageManager$NameNotFoundException0);
        return null;
    }

    public final Boolean zzr(String s) {
        Preconditions.checkNotEmpty(s);
        Bundle bundle0 = this.zzq();
        if(bundle0 == null) {
            Z.u(this.zzu, "Failed to load metadata: Metadata bundle is null");
            return null;
        }
        return bundle0.containsKey(s) ? Boolean.valueOf(bundle0.getBoolean(s)) : null;
    }

    public final List zzs(String s) {
        Integer integer0;
        new String("analytics.safelisted_events");
        Bundle bundle0 = this.zzq();
        if(bundle0 == null) {
            Z.u(this.zzu, "Failed to load metadata: Metadata bundle is null");
            integer0 = null;
        }
        else {
            integer0 = bundle0.containsKey("analytics.safelisted_events") ? bundle0.getInt("analytics.safelisted_events") : null;
        }
        if(integer0 != null) {
            try {
                String[] arr_s = this.zzu.zzaY().getResources().getStringArray(((int)integer0));
                return arr_s == null ? null : Arrays.asList(arr_s);
            }
            catch(Resources.NotFoundException resources$NotFoundException0) {
                this.zzu.zzaV().zzb().zzb("Failed to load string array from metadata: resource not found", resources$NotFoundException0);
            }
        }
        return null;
    }

    public final boolean zzt() {
        Boolean boolean0 = this.zzr("firebase_analytics_collection_deactivated");
        return boolean0 != null && boolean0.booleanValue();
    }

    public final boolean zzu() {
        Boolean boolean0 = this.zzr("google_analytics_adid_collection_enabled");
        return boolean0 == null || boolean0.booleanValue();
    }

    public final boolean zzv() {
        Boolean boolean0 = this.zzr("google_analytics_automatic_screen_reporting_enabled");
        return boolean0 == null || boolean0.booleanValue();
    }

    public final zzjh zzw(String s, boolean z) {
        Object object0;
        Preconditions.checkNotEmpty(s);
        zzib zzib0 = this.zzu;
        Bundle bundle0 = this.zzq();
        if(bundle0 == null) {
            Z.u(zzib0, "Failed to load metadata: Metadata bundle is null");
            object0 = null;
        }
        else {
            object0 = bundle0.get(s);
        }
        if(object0 == null) {
            return zzjh.zza;
        }
        if(Boolean.TRUE.equals(object0)) {
            return zzjh.zzd;
        }
        if(Boolean.FALSE.equals(object0)) {
            return zzjh.zzc;
        }
        if(z && "eu_consent_policy".equals(object0)) {
            return zzjh.zzb;
        }
        zzib0.zzaV().zze().zzb("Invalid manifest metadata for", s);
        return zzjh.zza;
    }

    public final boolean zzx() {
        Boolean boolean0 = this.zzr("google_analytics_sgtm_upload_enabled");
        return boolean0 == null ? false : boolean0.booleanValue();
    }

    public final void zzy(String s) {
        this.zzb = s;
    }

    public final String zzz() {
        return this.zzb;
    }
}

