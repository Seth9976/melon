package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.Callable;

public final class zzc {
    final zzf zza;
    zzg zzb;
    final zzab zzc;
    private final zzz zzd;

    public zzc() {
        zzf zzf0 = new zzf();
        super();
        this.zza = zzf0;
        this.zzb = zzf0.zzb.zzc();
        this.zzc = new zzab();
        this.zzd = new zzz();
        zzb zzb0 = () -> new zzv(this.zzd);
        zzf0.zzd.zza("internal.registerCallback", zzb0);
        zza zza0 = new zza(this);
        zzf0.zzd.zza("internal.eventLogger", zza0);
    }

    public final void zza(String s, Callable callable0) {
        this.zza.zzd.zza(s, callable0);
    }

    public final boolean zzb(zzaa zzaa0) {
        try {
            this.zzc.zzb(zzaa0);
            zzah zzah0 = new zzah(0.0);
            this.zza.zzc.zze("runtime.counter", zzah0);
            zzg zzg0 = this.zzb.zzc();
            this.zzd.zzb(zzg0, this.zzc);
            return !this.zzc() && !this.zzd() ? false : true;
        }
        catch(Throwable throwable0) {
            throw new zzd(throwable0);
        }
    }

    public final boolean zzc() {
        return !this.zzc.zzc().equals(this.zzc.zza());
    }

    public final boolean zzd() {
        return !this.zzc.zzf().isEmpty();
    }

    public final zzab zze() {
        return this.zzc;
    }

    public final void zzf(zzja zzja0) {
        zzai zzai0;
        try {
            zzf zzf0 = this.zza;
            this.zzb = zzf0.zzb.zzc();
            if(zzf0.zza(this.zzb, ((zzje[])zzja0.zza().toArray(new zzje[0]))) instanceof zzag) {
                throw new IllegalStateException("Program loading failed");
            }
            Iterator iterator0 = zzja0.zzb().zza().iterator();
            while(true) {
                if(!iterator0.hasNext()) {
                    return;
                }
                Object object0 = iterator0.next();
                for(Object object1: ((zziy)object0).zzb()) {
                    zzao zzao0 = zzf0.zza(this.zzb, new zzje[]{((zzje)object1)});
                    if(!(zzao0 instanceof zzal)) {
                        throw new IllegalArgumentException("Invalid rule definition");
                    }
                    zzg zzg0 = this.zzb;
                    if(zzg0.zzd("")) {
                        zzao zzao1 = zzg0.zzh("");
                        if(!(zzao1 instanceof zzai)) {
                            throw new IllegalStateException("Invalid function name: ");
                        }
                        zzai0 = (zzai)zzao1;
                    }
                    else {
                        zzai0 = null;
                    }
                    if(zzai0 == null) {
                        throw new IllegalStateException("Rule function is undefined: ");
                    }
                    zzai0.zza(this.zzb, Collections.singletonList(zzao0));
                }
            }
        }
        catch(Throwable throwable0) {
        }
        throw new zzd(throwable0);
    }

    // 检测为 Lambda 实现
    public final zzai zzg() [...]
}

