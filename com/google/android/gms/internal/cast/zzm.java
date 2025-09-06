package com.google.android.gms.internal.cast;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import com.google.android.gms.cast.internal.Logger;

public final class zzm {
    public static long zza;
    public String zzb;
    public String zzc;
    public long zzd;
    public int zze;
    public String zzf;
    public int zzg;
    public String zzh;
    public String zzi;
    public String zzj;
    public String zzk;
    public String zzl;
    public String zzm;
    public int zzn;
    public boolean zzo;
    public int zzp;
    private static final Logger zzq;
    private final zzaf zzr;

    static {
        zzm.zzq = new Logger("ApplicationAnalyticsSession");
        zzm.zza = System.currentTimeMillis();
    }

    private zzm(zzaf zzaf0) {
        this.zzh = "";
        this.zzi = "";
        this.zzj = "";
        this.zzk = "";
        this.zzl = "";
        this.zzm = "";
        this.zzn = 0;
        this.zzd = zzm.zza;
        this.zze = 1;
        this.zzr = zzaf0;
    }

    public static zzm zza(zzaf zzaf0) {
        zzm zzm0 = new zzm(zzaf0);
        ++zzm.zza;
        return zzm0;
    }

    public static zzm zzb(SharedPreferences sharedPreferences0, zzaf zzaf0) {
        if(sharedPreferences0 != null) {
            zzm zzm0 = new zzm(zzaf0);
            zzm0.zzo = sharedPreferences0.getBoolean("is_output_switcher_enabled", false);
            if(sharedPreferences0.contains("application_id")) {
                zzm0.zzb = sharedPreferences0.getString("application_id", "");
                if(sharedPreferences0.contains("receiver_metrics_id")) {
                    zzm0.zzc = sharedPreferences0.getString("receiver_metrics_id", "");
                    if(sharedPreferences0.contains("analytics_session_id")) {
                        zzm0.zzd = sharedPreferences0.getLong("analytics_session_id", 0L);
                        if(sharedPreferences0.contains("event_sequence_number")) {
                            zzm0.zze = sharedPreferences0.getInt("event_sequence_number", 0);
                            if(sharedPreferences0.contains("receiver_session_id")) {
                                zzm0.zzf = sharedPreferences0.getString("receiver_session_id", "");
                                zzm0.zzg = sharedPreferences0.getInt("device_capabilities", 0);
                                zzm0.zzh = sharedPreferences0.getString("device_model_name", "");
                                zzm0.zzi = sharedPreferences0.getString("manufacturer", "");
                                zzm0.zzj = sharedPreferences0.getString("product_name", "");
                                zzm0.zzk = sharedPreferences0.getString("build_type", "");
                                zzm0.zzl = sharedPreferences0.getString("cast_build_version", "");
                                zzm0.zzm = sharedPreferences0.getString("system_build_number", "");
                                zzm0.zzn = sharedPreferences0.getInt("device_category", 0);
                                zzm0.zzp = sharedPreferences0.getInt("analytics_session_start_type", 0);
                                return zzm0;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public final void zzc(SharedPreferences sharedPreferences0) {
        if(sharedPreferences0 == null) {
            return;
        }
        zzm.zzq.d("Save the ApplicationAnalyticsSession to SharedPreferences %s", new Object[]{sharedPreferences0});
        SharedPreferences.Editor sharedPreferences$Editor0 = sharedPreferences0.edit();
        sharedPreferences$Editor0.putString("application_id", this.zzb);
        sharedPreferences$Editor0.putString("receiver_metrics_id", this.zzc);
        sharedPreferences$Editor0.putLong("analytics_session_id", this.zzd);
        sharedPreferences$Editor0.putInt("event_sequence_number", this.zze);
        sharedPreferences$Editor0.putString("receiver_session_id", this.zzf);
        sharedPreferences$Editor0.putInt("device_capabilities", this.zzg);
        sharedPreferences$Editor0.putString("device_model_name", this.zzh);
        sharedPreferences$Editor0.putString("manufacturer", this.zzi);
        sharedPreferences$Editor0.putString("product_name", this.zzj);
        sharedPreferences$Editor0.putString("build_type", this.zzk);
        sharedPreferences$Editor0.putString("cast_build_version", this.zzl);
        sharedPreferences$Editor0.putString("system_build_number", this.zzm);
        sharedPreferences$Editor0.putInt("device_category", this.zzn);
        sharedPreferences$Editor0.putInt("analytics_session_start_type", this.zzp);
        sharedPreferences$Editor0.putBoolean("is_output_switcher_enabled", this.zzo);
        sharedPreferences$Editor0.apply();
    }

    public final boolean zzd() {
        return this.zzr.zzf();
    }
}

