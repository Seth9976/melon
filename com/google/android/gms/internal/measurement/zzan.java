package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

public final class zzan extends zzai implements zzak {
    protected final List zza;
    protected final List zzb;
    protected zzg zzc;

    private zzan(zzan zzan0) {
        super(zzan0.zzd);
        ArrayList arrayList0 = new ArrayList(zzan0.zza.size());
        this.zza = arrayList0;
        arrayList0.addAll(zzan0.zza);
        ArrayList arrayList1 = new ArrayList(zzan0.zzb.size());
        this.zzb = arrayList1;
        arrayList1.addAll(zzan0.zzb);
        this.zzc = zzan0.zzc;
    }

    public zzan(String s, List list0, List list1, zzg zzg0) {
        super(s);
        this.zza = new ArrayList();
        this.zzc = zzg0;
        if(!list0.isEmpty()) {
            for(Object object0: list0) {
                String s1 = ((zzao)object0).zzc();
                this.zza.add(s1);
            }
        }
        this.zzb = new ArrayList(list1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzai
    public final zzao zza(zzg zzg0, List list0) {
        zzg zzg1 = this.zzc.zzc();
        for(int v = 0; true; ++v) {
            List list1 = this.zza;
            if(v >= list1.size()) {
                break;
            }
            if(v < list0.size()) {
                zzg1.zzf(((String)list1.get(v)), zzg0.zza(((zzao)list0.get(v))));
            }
            else {
                zzg1.zzf(((String)list1.get(v)), zzao.zzf);
            }
        }
        for(Object object0: this.zzb) {
            zzao zzao0 = (zzao)object0;
            zzao zzao1 = zzg1.zza(zzao0);
            if(zzao1 instanceof zzap) {
                zzao1 = zzg1.zza(zzao0);
            }
            if(zzao1 instanceof zzag) {
                return ((zzag)zzao1).zzb();
            }
            if(false) {
                break;
            }
        }
        return zzao.zzf;
    }

    @Override  // com.google.android.gms.internal.measurement.zzai
    public final zzao zzt() {
        return new zzan(this);
    }
}

