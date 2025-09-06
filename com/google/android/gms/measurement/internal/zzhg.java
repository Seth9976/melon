package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

final class zzhg extends zzje {
    static final Pair zza;
    public zzhe zzb;
    public final zzhd zzc;
    public final zzhd zzd;
    public final zzhf zze;
    public final zzhd zzf;
    public final zzhb zzg;
    public final zzhf zzh;
    public final zzhc zzi;
    public final zzhb zzj;
    public final zzhd zzk;
    public final zzhd zzl;
    public boolean zzm;
    public final zzhb zzn;
    public final zzhb zzo;
    public final zzhd zzp;
    public final zzhf zzq;
    public final zzhf zzr;
    public final zzhd zzs;
    public final zzhc zzt;
    private SharedPreferences zzv;
    private SharedPreferences zzw;
    private String zzx;
    private boolean zzy;
    private long zzz;

    static {
        zzhg.zza = new Pair("", 0L);
    }

    public zzhg(zzib zzib0) {
        super(zzib0);
        this.zzf = new zzhd(this, "session_timeout", 1800000L);
        this.zzg = new zzhb(this, "start_new_session", true);
        this.zzk = new zzhd(this, "last_pause_time", 0L);
        this.zzl = new zzhd(this, "session_id", 0L);
        this.zzh = new zzhf(this, "non_personalized_ads", null);
        this.zzi = new zzhc(this, "last_received_uri_timestamps_by_source", null);
        this.zzj = new zzhb(this, "allow_remote_dynamite", false);
        this.zzc = new zzhd(this, "first_open_time", 0L);
        this.zzd = new zzhd(this, "app_install_time", 0L);
        this.zze = new zzhf(this, "app_instance_id", null);
        this.zzn = new zzhb(this, "app_backgrounded", false);
        this.zzo = new zzhb(this, "deep_link_retrieval_complete", false);
        this.zzp = new zzhd(this, "deep_link_retrieval_attempts", 0L);
        this.zzq = new zzhf(this, "firebase_feature_rollouts", null);
        this.zzr = new zzhf(this, "deferred_attribution_cache", null);
        this.zzs = new zzhd(this, "deferred_attribution_cache_timestamp", 0L);
        this.zzt = new zzhc(this, "default_event_parameters", null);
    }

    @Override  // com.google.android.gms.measurement.internal.zzje
    public final boolean zza() {
        return true;
    }

    public final Pair zzb(String s) {
        this.zzg();
        if(this.zzl().zzo(zzjj.zza)) {
            zzib zzib0 = this.zzu;
            long v = zzib0.zzaZ().elapsedRealtime();
            String s1 = this.zzx;
            if(s1 != null && v < this.zzz) {
                return new Pair(s1, Boolean.valueOf(this.zzy));
            }
            this.zzz = zzib0.zzc().zzl(s, zzfx.zza) + v;
            try {
                Info advertisingIdClient$Info0 = AdvertisingIdClient.getAdvertisingIdInfo(zzib0.zzaY());
                this.zzx = "";
                String s2 = advertisingIdClient$Info0.getId();
                if(s2 != null) {
                    this.zzx = s2;
                }
                this.zzy = advertisingIdClient$Info0.isLimitAdTrackingEnabled();
                return new Pair(this.zzx, Boolean.valueOf(this.zzy));
            }
            catch(Exception exception0) {
            }
            this.zzu.zzaV().zzj().zzb("Unable to get advertising id", exception0);
            this.zzx = "";
            return new Pair("", Boolean.valueOf(this.zzy));
        }
        return new Pair("", Boolean.FALSE);
    }

    @Override  // com.google.android.gms.measurement.internal.zzje
    @EnsuresNonNull.List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    public final void zzba() {
        SharedPreferences sharedPreferences0 = this.zzu.zzaY().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzv = sharedPreferences0;
        boolean z = sharedPreferences0.getBoolean("has_been_opened", false);
        this.zzm = z;
        if(!z) {
            SharedPreferences.Editor sharedPreferences$Editor0 = this.zzv.edit();
            sharedPreferences$Editor0.putBoolean("has_been_opened", true);
            sharedPreferences$Editor0.apply();
        }
        this.zzb = new zzhe(this, "health_monitor", Math.max(0L, ((long)(((Long)zzfx.zzc.zzb(null))))), null);
    }

    public final SharedPreferences zzd() {
        this.zzg();
        this.zzw();
        Preconditions.checkNotNull(this.zzv);
        return this.zzv;
    }

    public final SharedPreferences zze() {
        this.zzg();
        this.zzw();
        if(this.zzw == null) {
            this.zzu.zzaV().zzk().zzb("Default prefs file", "com.iloen.melon_preferences");
            this.zzw = this.zzu.zzaY().getSharedPreferences("com.iloen.melon_preferences", 0);
        }
        return this.zzw;
    }

    public final SparseArray zzf() {
        Bundle bundle0 = this.zzi.zza();
        int[] arr_v = bundle0.getIntArray("uriSources");
        long[] arr_v1 = bundle0.getLongArray("uriTimestamps");
        if(arr_v != null && arr_v1 != null) {
            if(arr_v.length != arr_v1.length) {
                this.zzu.zzaV().zzb().zza("Trigger URI source and timestamp array lengths do not match");
                return new SparseArray();
            }
            SparseArray sparseArray0 = new SparseArray();
            for(int v = 0; v < arr_v.length; ++v) {
                sparseArray0.put(arr_v[v], ((long)arr_v1[v]));
            }
            return sparseArray0;
        }
        return new SparseArray();
    }

    public final void zzh(Boolean boolean0) {
        this.zzg();
        SharedPreferences.Editor sharedPreferences$Editor0 = this.zzd().edit();
        if(boolean0 == null) {
            sharedPreferences$Editor0.remove("measurement_enabled");
        }
        else {
            sharedPreferences$Editor0.putBoolean("measurement_enabled", boolean0.booleanValue());
        }
        sharedPreferences$Editor0.apply();
    }

    public final Boolean zzi() {
        this.zzg();
        return this.zzd().contains("measurement_enabled") ? Boolean.valueOf(this.zzd().getBoolean("measurement_enabled", true)) : null;
    }

    public final zzaz zzj() {
        this.zzg();
        return zzaz.zzg(this.zzd().getString("dma_consent_settings", null));
    }

    public final boolean zzk(int v) {
        return zzjk.zzu(v, this.zzd().getInt("consent_source", 100));
    }

    public final zzjk zzl() {
        this.zzg();
        return zzjk.zzf(this.zzd().getString("consent_settings", "G1"), this.zzd().getInt("consent_source", 100));
    }

    public final boolean zzm(zzoc zzoc0) {
        this.zzg();
        String s = this.zzd().getString("stored_tcf_param", "");
        String s1 = zzoc0.zza();
        if(!s1.equals(s)) {
            SharedPreferences.Editor sharedPreferences$Editor0 = this.zzd().edit();
            sharedPreferences$Editor0.putString("stored_tcf_param", s1);
            sharedPreferences$Editor0.apply();
            return true;
        }
        return false;
    }

    public final void zzn(boolean z) {
        this.zzg();
        this.zzu.zzaV().zzk().zzb("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor sharedPreferences$Editor0 = this.zzd().edit();
        sharedPreferences$Editor0.putBoolean("deferred_analytics_collection", z);
        sharedPreferences$Editor0.apply();
    }

    public final boolean zzo() {
        return this.zzv == null ? false : this.zzv.contains("deferred_analytics_collection");
    }

    public final boolean zzp(long v) {
        return v - this.zzf.zza() > this.zzk.zza();
    }
}

