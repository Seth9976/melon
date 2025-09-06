package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

public final class zzl extends zzal {
    private final zzab zzb;

    public zzl(zzab zzab0) {
        this.zzb = zzab0;
    }

    @Override  // com.google.android.gms.internal.measurement.zzal
    public final zzao zzcA(String s, zzg zzg0, List list0) {
        int v;
        switch(s) {
            case "getEventName": {
                zzh.zza("getEventName", 0, list0);
                return new zzas(this.zzb.zzc().zzb());
            }
            case "getParamValue": {
                zzh.zza("getParamValue", 1, list0);
                String s1 = zzg0.zza(((zzao)list0.get(0))).zzc();
                return zzi.zza(this.zzb.zzc().zze(s1));
            }
            case "getParams": {
                zzh.zza("getParams", 0, list0);
                Map map0 = this.zzb.zzc().zzf();
                zzao zzao0 = new zzal();
                for(Object object0: map0.keySet()) {
                    ((zzal)zzao0).zzm(((String)object0), zzi.zza(map0.get(((String)object0))));
                }
                return zzao0;
            }
            case "getTimestamp": {
                zzh.zza("getTimestamp", 0, list0);
                return new zzah(((double)this.zzb.zzc().zza()));
            }
            case "setEventName": {
                zzh.zza("setEventName", 1, list0);
                zzao zzao1 = zzg0.zza(((zzao)list0.get(0)));
                if(zzao.zzf.equals(zzao1) || zzao.zzg.equals(zzao1)) {
                    throw new IllegalArgumentException("Illegal event name");
                }
                String s2 = zzao1.zzc();
                this.zzb.zzc().zzc(s2);
                return new zzas(zzao1.zzc());
            }
            case "setParamValue": {
                v = 5;
                break;
            }
            default: {
                v = -1;
                break;
            }
        }
        if(v != 5) {
            return super.zzcA(s, zzg0, list0);
        }
        zzh.zza("setParamValue", 2, list0);
        String s3 = zzg0.zza(((zzao)list0.get(0))).zzc();
        zzao zzao2 = zzg0.zza(((zzao)list0.get(1)));
        Object object1 = zzh.zzj(zzao2);
        this.zzb.zzc().zzd(s3, object1);
        return zzao2;
    }
}

