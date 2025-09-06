package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

final class zzkw implements Runnable {
    final boolean zza;
    final Uri zzb;
    final String zzc;
    final String zzd;
    final zzkx zze;

    public zzkw(zzkx zzkx0, boolean z, Uri uri0, String s, String s1) {
        this.zza = z;
        this.zzb = uri0;
        this.zzc = s;
        this.zzd = s1;
        Objects.requireNonNull(zzkx0);
        this.zze = zzkx0;
        super();
    }

    @Override
    public final void run() {
        zzib zzib1;
        Bundle bundle0;
        zzkx zzkx0 = this.zze;
        zzli zzli0 = zzkx0.zza;
        zzli0.zzg();
        String s = this.zzd;
        Uri uri0 = this.zzb;
        try {
            zzib zzib0 = zzli0.zzu;
            zzpo zzpo0 = zzib0.zzk();
            if(TextUtils.isEmpty(s)) {
                bundle0 = null;
            }
            else if(!s.contains("gclid") && !s.contains("gbraid") && !s.contains("utm_campaign") && !s.contains("utm_source") && !s.contains("utm_medium") && !s.contains("utm_id") && !s.contains("dclid") && !s.contains("srsltid") && !s.contains("sfmc_id")) {
                zzpo0.zzu.zzaV().zzj().zza("Activity created with data \'referrer\' without required params");
                bundle0 = null;
            }
            else {
                bundle0 = zzpo0.zzi(Uri.parse(("https://google.com/search?" + s)));
                if(bundle0 != null) {
                    bundle0.putString("_cis", "referrer");
                }
            }
            String s1 = this.zzc;
            if(this.zza) {
                Bundle bundle1 = zzib0.zzk().zzi(uri0);
                if(bundle1 == null) {
                    zzib1 = zzib0;
                }
                else {
                    bundle1.putString("_cis", "intent");
                    if(bundle1.containsKey("gclid") || bundle0 == null || !bundle0.containsKey("gclid")) {
                        zzib1 = zzib0;
                    }
                    else {
                        zzib1 = zzib0;
                        bundle1.putString("_cer", "gclid=" + bundle0.getString("gclid"));
                    }
                    zzli0.zzF(s1, "_cmp", bundle1);
                    zzli0.zzb.zzb(s1, bundle1);
                }
            }
            else {
                zzib1 = zzib0;
            }
            if(!TextUtils.isEmpty(s)) {
                zzib1.zzaV().zzj().zzb("Activity created with referrer", s);
                if(zzib1.zzc().zzp(null, zzfx.zzaG)) {
                    goto label_41;
                }
                if(!s.contains("gclid") || !s.contains("utm_campaign") && !s.contains("utm_source") && !s.contains("utm_medium") && !s.contains("utm_term") && !s.contains("utm_content")) {
                    zzib1.zzaV().zzj().zza("Activity created with data \'referrer\' without required params");
                    return;
                label_41:
                    if(bundle0 == null) {
                        zzib1.zzaV().zzj().zzb("Referrer does not contain valid parameters", s);
                    }
                    else {
                        zzli0.zzF(s1, "_cmp", bundle0);
                        zzli0.zzb.zzb(s1, bundle0);
                    }
                    zzli0.zzK("auto", "_ldl", null, true);
                    return;
                }
                else if(!TextUtils.isEmpty(s)) {
                    zzli0.zzK("auto", "_ldl", s, true);
                    return;
                }
            }
            return;
        }
        catch(RuntimeException runtimeException0) {
        }
        zzkx0.zza.zzu.zzaV().zzb().zzb("Throwable caught in handleReferrerForOnActivityCreated", runtimeException0);
    }
}

