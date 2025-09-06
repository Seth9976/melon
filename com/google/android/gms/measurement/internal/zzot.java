package com.google.android.gms.measurement.internal;

import android.net.Uri.Builder;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzil;
import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzis;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzot extends zzok {
    public zzot(zzpf zzpf0) {
        super(zzpf0);
    }

    public final zzos zza(String s) {
        zzpf zzpf0 = this.zzg;
        zzh zzh0 = zzpf0.zzj().zzu(s);
        if(zzh0 != null && zzh0.zzai()) {
            zzil zzil0 = zzis.zzb();
            zzil0.zzb(2);
            zzil0.zza(((zzin)Preconditions.checkNotNull(zzin.zzb(zzh0.zzaL()))));
            String s1 = zzh0.zzd();
            zzgl zzgl0 = zzpf0.zzh().zzb(s);
            if(zzgl0 != null) {
                zzh zzh1 = zzpf0.zzj().zzu(s);
                if(zzh1 != null && (zzgl0.zzp() && zzgl0.zzq().zzc() == 100 || this.zzu.zzk().zzaa(s, zzh1.zzay()) || !TextUtils.isEmpty(s1) && Math.abs(s1.hashCode() % 100) < zzgl0.zzq().zzc())) {
                    String s2 = zzh0.zzc();
                    zzil0.zzb(2);
                    zzgl zzgl1 = zzpf0.zzh().zzb(zzh0.zzc());
                    if(zzgl1 == null || !zzgl1.zzp()) {
                        this.zzu.zzaV().zzk().zzb("[sgtm] Missing sgtm_setting in remote config. appId", s2);
                        zzil0.zzc(4);
                    }
                    else {
                        HashMap hashMap0 = new HashMap();
                        if(!TextUtils.isEmpty(zzh0.zzay())) {
                            hashMap0.put("x-gtm-server-preview", zzh0.zzay());
                        }
                        zzin zzin0 = zzin.zzb(zzh0.zzaL());
                        if(zzin0 != null && zzin0 != zzin.zzb) {
                            zzil0.zza(zzin0);
                        }
                        else if(zzot.zzf(zzh0.zzc())) {
                            zzil0.zza(zzin.zzk);
                        }
                        else {
                            zzil0.zza(zzin.zzl);
                        }
                        new String("");
                        new String("");
                        zzil0.zzc(6);
                        this.zzu.zzaV().zzk().zzb("[sgtm] Local service, missing sgtm_server_url", zzh0.zzc());
                    }
                    String s3 = this.zzd(s);
                    Map map0 = Collections.EMPTY_MAP;
                    zzis zzis0 = (zzis)zzil0.zzbc();
                    return new zzos(s3, map0, zzlr.zza, zzis0);
                }
            }
            zzil0.zzc(3);
            String s4 = this.zzd(s);
            Map map1 = Collections.EMPTY_MAP;
            zzis zzis1 = (zzis)zzil0.zzbc();
            return new zzos(s4, map1, zzlr.zza, zzis1);
        }
        return new zzos(this.zzd(s), Collections.EMPTY_MAP, zzlr.zza, null);
    }

    public final boolean zzc(String s, zzin zzin0) {
        this.zzg();
        if(zzin0 == zzin.zzb && !zzot.zzf(s)) {
            zzgl zzgl0 = this.zzg.zzh().zzb(s);
            return zzgl0 != null && zzgl0.zzp() && false;
        }
        return false;
    }

    private final String zzd(String s) {
        String s1 = this.zzg.zzh().zzc(s);
        if(!TextUtils.isEmpty(s1)) {
            Uri uri0 = Uri.parse("https://app-measurement.com/a");
            Uri.Builder uri$Builder0 = uri0.buildUpon();
            uri$Builder0.authority(s1 + "." + uri0.getAuthority());
            return uri$Builder0.build().toString();
        }
        return "https://app-measurement.com/a";
    }

    // 去混淆评级： 中等(100)
    private static final boolean zzf(String s) {
        return false;
    }
}

