package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.collection.f;
import b3.Z;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

public final class zzd extends zzf {
    private final Map zza;
    private final Map zzb;
    private long zzc;

    public zzd(zzib zzib0) {
        super(zzib0);
        this.zzb = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.zza = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
    }

    public final void zza(String s, long v) {
        if(s != null && s.length() != 0) {
            this.zzu.zzaW().zzj(new zza(this, s, v));
            return;
        }
        Z.u(this.zzu, "Ad unit id must be a non-empty string");
    }

    public final void zzb(String s, long v) {
        if(s != null && s.length() != 0) {
            this.zzu.zzaW().zzj(new zzb(this, s, v));
            return;
        }
        Z.u(this.zzu, "Ad unit id must be a non-empty string");
    }

    public final void zzc(long v) {
        zzlt zzlt0 = this.zzu.zzs().zzh(false);
        Map map0 = this.zza;
        for(Object object0: map0.keySet()) {
            this.zzi(((String)object0), v - ((long)(((Long)map0.get(((String)object0))))), zzlt0);
        }
        if(!map0.isEmpty()) {
            this.zzh(v - this.zzc, zzlt0);
        }
        this.zzj(v);
    }

    public final void zzd(String s, long v) {
        this.zzg();
        Preconditions.checkNotEmpty(s);
        Map map0 = this.zzb;
        if(map0.isEmpty()) {
            this.zzc = v;
        }
        Integer integer0 = (Integer)map0.get(s);
        if(integer0 != null) {
            map0.put(s, ((int)(((int)integer0) + 1)));
            return;
        }
        if(map0.size() >= 100) {
            Z.A(this.zzu, "Too many ads visible");
            return;
        }
        map0.put(s, 1);
        this.zza.put(s, v);
    }

    public final void zze(String s, long v) {
        this.zzg();
        Preconditions.checkNotEmpty(s);
        Map map0 = this.zzb;
        Integer integer0 = (Integer)map0.get(s);
        if(integer0 != null) {
            zzlt zzlt0 = this.zzu.zzs().zzh(false);
            int v1 = (int)integer0;
            if(v1 - 1 == 0) {
                map0.remove(s);
                Map map1 = this.zza;
                Long long0 = (Long)map1.get(s);
                if(long0 == null) {
                    Z.u(this.zzu, "First ad unit exposure time was never set");
                }
                else {
                    map1.remove(s);
                    this.zzi(s, v - ((long)long0), zzlt0);
                }
                if(map0.isEmpty()) {
                    long v2 = this.zzc;
                    if(v2 == 0L) {
                        Z.u(this.zzu, "First ad exposure time was never set");
                        return;
                    }
                    this.zzh(v - v2, zzlt0);
                    this.zzc = 0L;
                }
                return;
            }
            map0.put(s, ((int)(v1 - 1)));
            return;
        }
        this.zzu.zzaV().zzb().zzb("Call to endAdUnitExposure for unknown ad unit id", s);
    }

    public final void zzf(long v) {
        this.zzj(v);
    }

    private final void zzh(long v, zzlt zzlt0) {
        if(zzlt0 == null) {
            this.zzu.zzaV().zzk().zza("Not logging ad exposure. No active activity");
            return;
        }
        if(v < 1000L) {
            this.zzu.zzaV().zzk().zzb("Not logging ad exposure. Less than 1000 ms. exposure", v);
            return;
        }
        Bundle bundle0 = new Bundle();
        bundle0.putLong("_xt", v);
        zzpo.zzav(zzlt0, bundle0, true);
        this.zzu.zzj().zzF("am", "_xa", bundle0);
    }

    private final void zzi(String s, long v, zzlt zzlt0) {
        if(zzlt0 == null) {
            this.zzu.zzaV().zzk().zza("Not logging ad unit exposure. No active activity");
            return;
        }
        if(v < 1000L) {
            this.zzu.zzaV().zzk().zzb("Not logging ad unit exposure. Less than 1000 ms. exposure", v);
            return;
        }
        Bundle bundle0 = new Bundle();
        bundle0.putString("_ai", s);
        bundle0.putLong("_xt", v);
        zzpo.zzav(zzlt0, bundle0, true);
        this.zzu.zzj().zzF("am", "_xu", bundle0);
    }

    private final void zzj(long v) {
        Map map0 = this.zza;
        for(Object object0: map0.keySet()) {
            map0.put(((String)object0), v);
        }
        if(!map0.isEmpty()) {
            this.zzc = v;
        }
    }
}

