package com.google.android.gms.measurement.internal;

import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

public final class zzx {
    private final zzib zza;

    public zzx(zzib zzib0) {
        this.zza = zzib0;
    }

    public final void zza() {
        zzib zzib0 = this.zza;
        zzib0.zzaW().zzg();
        if(!this.zze()) {
            return;
        }
        if(this.zzd()) {
            zzib0.zzd().zzr.zzb(null);
            Bundle bundle0 = new Bundle();
            bundle0.putString("source", "(not set)");
            bundle0.putString("medium", "(not set)");
            bundle0.putString("_cis", "intent");
            bundle0.putLong("_cc", 1L);
            zzib0.zzj().zzF("auto", "_cmpx", bundle0);
        }
        else {
            String s = zzib0.zzd().zzr.zza();
            if(TextUtils.isEmpty(s)) {
                zzib0.zzaV().zzc().zza("Cache still valid but referrer not found");
            }
            else {
                long v = zzib0.zzd().zzs.zza();
                Uri uri0 = Uri.parse(s);
                Bundle bundle1 = new Bundle();
                Pair pair0 = new Pair(uri0.getPath(), bundle1);
                for(Object object0: uri0.getQueryParameterNames()) {
                    bundle1.putString(((String)object0), uri0.getQueryParameter(((String)object0)));
                }
                ((Bundle)pair0.second).putLong("_cc", (v / 3600000L - 1L) * 3600000L);
                String s1 = pair0.first == null ? "app" : ((String)pair0.first);
                zzib0.zzj().zzF(s1, "_cmp", ((Bundle)pair0.second));
            }
            zzib0.zzd().zzr.zzb(null);
        }
        zzib0.zzd().zzs.zzb(0L);
    }

    public final void zzb(String s, Bundle bundle0) {
        CharSequence charSequence0;
        zzib zzib0 = this.zza;
        zzib0.zzaW().zzg();
        if(!zzib0.zzB()) {
            if(bundle0.isEmpty()) {
                charSequence0 = null;
            }
            else {
                if(s.isEmpty()) {
                    s = "auto";
                }
                Uri.Builder uri$Builder0 = new Uri.Builder();
                uri$Builder0.path(s);
                for(Object object0: bundle0.keySet()) {
                    uri$Builder0.appendQueryParameter(((String)object0), bundle0.getString(((String)object0)));
                }
                charSequence0 = uri$Builder0.build().toString();
            }
            if(!TextUtils.isEmpty(charSequence0)) {
                zzib0.zzd().zzr.zzb(((String)charSequence0));
                zzhg zzhg0 = zzib0.zzd();
                long v = zzib0.zzaZ().currentTimeMillis();
                zzhg0.zzs.zzb(v);
            }
        }
    }

    public final void zzc() {
        if(this.zze() && this.zzd()) {
            this.zza.zzd().zzr.zzb(null);
        }
    }

    public final boolean zzd() {
        return this.zze() ? this.zza.zzaZ().currentTimeMillis() - this.zza.zzd().zzs.zza() > this.zza.zzc().zzl(null, zzfx.zzaj) : false;
    }

    public final boolean zze() {
        return this.zza.zzd().zzs.zza() > 0L;
    }
}

