package com.google.android.gms.internal.cast;

import android.os.Build;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

final class zzjg extends zziz {
    static final boolean zza;
    static final boolean zzb;
    static final boolean zzc;
    private static final AtomicReference zzd;
    private static final AtomicLong zze;
    private static final ConcurrentLinkedQueue zzf;
    private volatile zzii zzg;

    static {
        boolean z = false;
        zzjg.zza = false;
        zzjg.zzb = "goldfish".equals(Build.HARDWARE) || "ranchu".equals(Build.HARDWARE);
        if("eng".equals(Build.TYPE) || "userdebug".equals(Build.TYPE)) {
            z = true;
        }
        zzjg.zzc = z;
        zzjg.zzd = new AtomicReference();
        zzjg.zze = new AtomicLong();
        zzjg.zzf = new ConcurrentLinkedQueue();
    }

    private zzjg(String s) {
        super(s);
        if(!zzjg.zza && !zzjg.zzb) {
            if(zzjg.zzc) {
                this.zzg = zzjl.zzc().zzb(false).zza(this.zza());
                return;
            }
            this.zzg = null;
            return;
        }
        this.zzg = new zzja().zza(this.zza());
    }

    public static zzii zzb(String s) {
        AtomicReference atomicReference0 = zzjg.zzd;
        if(atomicReference0.get() != null) {
            return ((zzjb)atomicReference0.get()).zza(s);
        }
        int v = s.length();
        do {
            --v;
            if(v < 0) {
                break;
            }
            int v1 = s.charAt(v);
            if(v1 == 36) {
                s = s.replace('$', '.');
                break;
            }
        }
        while(v1 != 46);
        zzii zzii0 = new zzjg(s);
        ConcurrentLinkedQueue concurrentLinkedQueue0 = zzje.zza;
        concurrentLinkedQueue0.offer(zzii0);
        if(atomicReference0.get() != null) {
            zzjg zzjg0;
            while((zzjg0 = (zzjg)concurrentLinkedQueue0.poll()) != null) {
                zzjg0.zzg = ((zzjb)atomicReference0.get()).zza(zzjg0.zza());
            }
            if(((zzjf)zzjg.zzf.poll()) != null) {
                zzjg.zze.getAndDecrement();
                throw null;
            }
        }
        return zzii0;
    }
}

