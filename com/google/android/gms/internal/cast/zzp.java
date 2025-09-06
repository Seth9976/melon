package com.google.android.gms.internal.cast;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzp {
    private static final Logger zza;
    private static final String zzb;
    private static zzp zzc;
    private final zzh zzd;
    private final SharedPreferences zze;
    private final String zzf;
    private final Runnable zzg;
    private final Handler zzh;
    private final Set zzi;
    private final Set zzj;
    private final Clock zzk;
    private long zzl;

    static {
        zzp.zza = new Logger("FeatureUsageAnalytics");
        zzp.zzb = "22.1.0";
    }

    private zzp(SharedPreferences sharedPreferences0, zzh zzh0, String s) {
        this.zze = sharedPreferences0;
        this.zzd = zzh0;
        this.zzf = s;
        this.zzk = DefaultClock.getInstance();
        this.zzi = new HashSet();
        this.zzj = new HashSet();
        this.zzh = new zzet(Looper.getMainLooper());
        this.zzg = () -> {
            Set set0 = this.zzi;
            if(!set0.isEmpty()) {
                Set set1 = this.zzj;
                long v = set1.equals(set0) ? 172800000L : 86400000L;
                long v1 = this.zzf();
                if(this.zzl == 0L || v1 - this.zzl >= v) {
                    zzp.zza.d("Upload the feature usage report.", new Object[0]);
                    zzpo zzpo0 = zzpp.zza();
                    zzpo0.zzb("22.1.0");
                    zzpo0.zza(this.zzf);
                    zzpp zzpp0 = (zzpp)zzpo0.zzr();
                    ArrayList arrayList0 = new ArrayList();
                    arrayList0.addAll(set0);
                    zzpi zzpi0 = zzpj.zza();
                    zzpi0.zza(arrayList0);
                    zzpi0.zzb(zzpp0);
                    zzpj zzpj0 = (zzpj)zzpi0.zzr();
                    zzqd zzqd0 = zzqe.zzc();
                    zzqd0.zzc(zzpj0);
                    zzqe zzqe0 = (zzqe)zzqd0.zzr();
                    this.zzd.zzf(zzqe0, 0xF3);
                    SharedPreferences sharedPreferences0 = this.zze;
                    SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
                    if(!set1.equals(set0)) {
                        set1.clear();
                        set1.addAll(set0);
                        for(Object object0: set1) {
                            String s = Integer.toString(((zzpb)object0).zza());
                            String s1 = this.zzh(s);
                            String s2 = zzp.zzb("feature_usage_timestamp_reported_feature_", s);
                            if(!TextUtils.equals(s1, s2)) {
                                long v2 = sharedPreferences0.getLong(s1, 0L);
                                sharedPreferences$Editor0.remove(s1);
                                if(v2 != 0L) {
                                    sharedPreferences$Editor0.putLong(s2, v2);
                                }
                            }
                        }
                    }
                    this.zzl = v1;
                    sharedPreferences$Editor0.putLong("feature_usage_last_report_time", v1).apply();
                }
            }
        };
    }

    public static zzp zza(SharedPreferences sharedPreferences0, zzh zzh0, String s) {
        synchronized(zzp.class) {
            if(zzp.zzc == null) {
                zzp.zzc = new zzp(sharedPreferences0, zzh0, s);
            }
            return zzp.zzc;
        }
    }

    public static String zzb(String s, String s1) {
        return s + s1;
    }

    // 检测为 Lambda 实现
    public static void zzc(zzp zzp0) [...]

    public static void zzd(zzpb zzpb0) {
        if(zzh.zza) {
            zzp zzp0 = zzp.zzc;
            if(zzp0 != null) {
                zzp0.zze.edit().putLong(zzp0.zzh(Integer.toString(zzpb0.zza())), zzp0.zzf()).apply();
                zzp0.zzi.add(zzpb0);
                zzp0.zzj();
            }
        }
    }

    public final void zze() {
        SharedPreferences sharedPreferences0 = this.zze;
        Set set0 = this.zzi;
        String s = sharedPreferences0.getString("feature_usage_sdk_version", null);
        String s1 = sharedPreferences0.getString("feature_usage_package_name", null);
        set0.clear();
        Set set1 = this.zzj;
        set1.clear();
        this.zzl = 0L;
        if("22.1.0".equals(s) && this.zzf.equals(s1)) {
            this.zzl = sharedPreferences0.getLong("feature_usage_last_report_time", 0L);
            long v = this.zzf();
            HashSet hashSet0 = new HashSet();
            for(Object object0: sharedPreferences0.getAll().keySet()) {
                String s2 = (String)object0;
                if(s2.startsWith("feature_usage_timestamp_")) {
                    long v1 = sharedPreferences0.getLong(s2, 0L);
                    if(v1 != 0L && v - v1 > 1209600000L) {
                        hashSet0.add(s2);
                    }
                    else if(s2.startsWith("feature_usage_timestamp_reported_feature_")) {
                        zzpb zzpb0 = zzp.zzg(s2.substring(41));
                        if(zzpb0 == null) {
                            continue;
                        }
                        set1.add(zzpb0);
                        set0.add(zzpb0);
                    }
                    else if(s2.startsWith("feature_usage_timestamp_detected_feature_")) {
                        zzpb zzpb1 = zzp.zzg(s2.substring(41));
                        if(zzpb1 != null) {
                            set0.add(zzpb1);
                        }
                    }
                }
            }
            this.zzi(hashSet0);
            Preconditions.checkNotNull(this.zzh);
            Preconditions.checkNotNull(this.zzg);
            this.zzj();
            return;
        }
        HashSet hashSet1 = new HashSet();
        for(Object object1: sharedPreferences0.getAll().keySet()) {
            String s3 = (String)object1;
            if(s3.startsWith("feature_usage_timestamp_")) {
                hashSet1.add(s3);
            }
        }
        hashSet1.add("feature_usage_last_report_time");
        this.zzi(hashSet1);
        sharedPreferences0.edit().putString("feature_usage_sdk_version", "22.1.0").putString("feature_usage_package_name", this.zzf).apply();
    }

    private final long zzf() {
        return ((Clock)Preconditions.checkNotNull(this.zzk)).currentTimeMillis();
    }

    private static zzpb zzg(String s) {
        try {
            switch(Integer.parseInt(s)) {
                case 0: {
                    return zzpb.zza;
                }
                case 1: {
                    return zzpb.zzb;
                }
                case 2: {
                    return zzpb.zzc;
                }
                case 3: {
                    return zzpb.zzd;
                }
                case 4: {
                    return zzpb.zze;
                }
                case 5: {
                    return zzpb.zzf;
                }
                case 6: {
                    return zzpb.zzg;
                }
                case 7: {
                    return zzpb.zzh;
                }
                case 8: {
                    return zzpb.zzi;
                }
                case 9: {
                    return zzpb.zzj;
                }
                case 10: {
                    return zzpb.zzk;
                }
                case 11: {
                    return zzpb.zzl;
                }
                case 12: {
                    return zzpb.zzm;
                }
                case 13: {
                    return zzpb.zzn;
                }
                case 14: {
                    return zzpb.zzo;
                }
                case 15: {
                    return zzpb.zzp;
                }
                case 16: {
                    return zzpb.zzq;
                }
                case 17: {
                    return zzpb.zzr;
                }
                case 18: {
                    return zzpb.zzs;
                }
                case 19: {
                    return zzpb.zzt;
                }
                case 20: {
                    return zzpb.zzu;
                }
                case 21: {
                    return zzpb.zzv;
                }
                case 22: {
                    return zzpb.zzw;
                }
                case 23: {
                    return zzpb.zzx;
                }
                case 24: {
                    return zzpb.zzy;
                }
                case 25: {
                    return zzpb.zzz;
                }
                case 26: {
                    return zzpb.zzA;
                }
                case 27: {
                    return zzpb.zzB;
                }
                case 28: {
                    return zzpb.zzC;
                }
                case 29: {
                    return zzpb.zzD;
                }
                case 30: {
                    return zzpb.zzE;
                }
                case 0x1F: {
                    return zzpb.zzF;
                }
                case 0x20: {
                    return zzpb.zzG;
                }
                case 33: {
                    return zzpb.zzH;
                }
                case 34: {
                    return zzpb.zzI;
                }
                case 35: {
                    return zzpb.zzJ;
                }
                case 36: {
                    return zzpb.zzK;
                }
                case 37: {
                    return zzpb.zzL;
                }
                case 38: {
                    return zzpb.zzM;
                }
                case 39: {
                    return zzpb.zzN;
                }
                case 40: {
                    return zzpb.zzO;
                }
                case 41: {
                    return zzpb.zzP;
                }
                case 42: {
                    return zzpb.zzQ;
                }
                case 43: {
                    return zzpb.zzR;
                }
                case 44: {
                    return zzpb.zzS;
                }
                case 45: {
                    return zzpb.zzT;
                }
                case 46: {
                    return zzpb.zzU;
                }
                case 0x2F: {
                    return zzpb.zzV;
                }
                case 0x30: {
                    return zzpb.zzW;
                }
                case 49: {
                    return zzpb.zzX;
                }
                case 50: {
                    return zzpb.zzY;
                }
                case 51: {
                    return zzpb.zzZ;
                }
                case 52: {
                    return zzpb.zzaa;
                }
                case 53: {
                    return zzpb.zzab;
                }
                case 54: {
                    return zzpb.zzac;
                }
                case 55: {
                    return zzpb.zzad;
                }
                case 56: {
                    return zzpb.zzae;
                }
                case 57: {
                    return zzpb.zzaf;
                }
                default: {
                    return null;
                }
            }
        }
        catch(NumberFormatException unused_ex) {
            return zzpb.zza;
        }
    }

    @RequiresNonNull({"sharedPreferences"})
    private final String zzh(String s) {
        String s1 = zzp.zzb("feature_usage_timestamp_reported_feature_", s);
        return this.zze.contains(s1) ? s1 : zzp.zzb("feature_usage_timestamp_detected_feature_", s);
    }

    private final void zzi(Set set0) {
        if(set0.isEmpty()) {
            return;
        }
        SharedPreferences.Editor sharedPreferences$Editor0 = this.zze.edit();
        for(Object object0: set0) {
            sharedPreferences$Editor0.remove(((String)object0));
        }
        sharedPreferences$Editor0.apply();
    }

    @RequiresNonNull({"handler", "reportFeatureUsageRunnable"})
    private final void zzj() {
        this.zzh.post(this.zzg);
    }
}

