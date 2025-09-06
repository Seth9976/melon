package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.collection.f;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfh;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhw;
import com.google.android.gms.internal.measurement.zzpq;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

final class zzaa extends zzab {
    final zzad zza;
    private final zzff zzh;

    public zzaa(zzad zzad0, String s, int v, zzff zzff0) {
        Objects.requireNonNull(zzad0);
        this.zza = zzad0;
        super(s, v);
        this.zzh = zzff0;
    }

    @Override  // com.google.android.gms.measurement.internal.zzab
    public final int zza() {
        return this.zzh.zzb();
    }

    @Override  // com.google.android.gms.measurement.internal.zzab
    public final boolean zzb() {
        return false;
    }

    @Override  // com.google.android.gms.measurement.internal.zzab
    public final boolean zzc() {
        return this.zzh.zzg();
    }

    public final boolean zzd(Long long0, Long long1, zzhs zzhs0, long v, zzbc zzbc0, boolean z) {
        zzpq.zza();
        zzad zzad0 = this.zza;
        zzib zzib0 = zzad0.zzu;
        String s = this.zzb;
        boolean z1 = zzib0.zzc().zzp(s, zzfx.zzaF);
        zzff zzff0 = this.zzh;
        long v1 = zzff0.zzm() ? zzbc0.zze : v;
        Integer integer0 = null;
        if(Log.isLoggable(zzib0.zzaV().zzn(), 2)) {
            zzib0.zzaV().zzk().zzd("Evaluating filter. audience, filter, event", this.zzc, (zzff0.zza() ? zzff0.zzb() : null), zzib0.zzl().zza(""));
            zzib0.zzaV().zzk().zzb("Filter definition", zzad0.zzg.zzp().zzj(zzff0));
        }
        if(zzff0.zza() && zzff0.zzb() <= 0x100) {
            boolean z2 = zzff0.zzi() || zzff0.zzj() || zzff0.zzm();
            if(z && !z2) {
                zzgr zzgr0 = zzib0.zzaV().zzk();
                Integer integer1 = this.zzc;
                if(zzff0.zza()) {
                    integer0 = zzff0.zzb();
                }
                zzgr0.zzc("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", integer1, integer0);
                return true;
            }
            if(zzff0.zzg()) {
                Boolean boolean0 = zzab.zzg(v1, zzff0.zzh());
                if(boolean0 != null) {
                    if(!boolean0.booleanValue()) {
                        integer0 = Boolean.FALSE;
                        goto label_56;
                    }
                    goto label_26;
                }
            }
            else {
            label_26:
                HashSet hashSet0 = new HashSet();
                Iterator iterator0 = zzff0.zzd().iterator();
                if(iterator0.hasNext()) {
                    iterator0.next();
                    zzib0.zzaV().zze().zzb("null or empty param name in filter. event", zzib0.zzl().zza(""));
                }
                else {
                    f f0 = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
                    for(Object object0: zzhs0.zza()) {
                        zzhw zzhw0 = (zzhw)object0;
                        if(!hashSet0.contains("")) {
                            continue;
                        }
                        if(zzhw0.zze()) {
                            f0.put("", (zzhw0.zze() ? zzhw0.zzf() : null));
                            continue;
                        }
                        if(zzhw0.zzi()) {
                            f0.put("", (zzhw0.zzi() ? zzhw0.zzj() : null));
                            continue;
                        }
                        if(zzhw0.zzc()) {
                            f0.put("", "");
                            continue;
                        }
                        zzib0.zzaV().zze().zzc("Unknown value for param. event, param", zzib0.zzl().zza(""), zzib0.zzl().zzb(""));
                        goto label_56;
                    }
                    Iterator iterator2 = zzff0.zzd().iterator();
                    if(iterator2.hasNext()) {
                        Object object1 = iterator2.next();
                        boolean z3 = !((zzfh)object1).zze() || !((zzfh)object1).zzf();
                        zzib0.zzaV().zze().zzb("Event has empty param name. event", zzib0.zzl().zza(""));
                    }
                    else {
                        integer0 = Boolean.TRUE;
                    }
                }
            }
        label_56:
            zzgr zzgr1 = zzib0.zzaV().zzk();
            String s1 = integer0 == null ? "null" : integer0;
            zzgr1.zzb("Event filter result", s1);
            if(integer0 == null) {
                return false;
            }
            this.zzd = Boolean.TRUE;
            if(((Boolean)integer0).booleanValue()) {
                this.zze = Boolean.TRUE;
                if(z2 && zzhs0.zze()) {
                    Long long2 = zzhs0.zzf();
                    if(zzff0.zzj()) {
                        if(z1 && zzff0.zzg()) {
                            long2 = long0;
                        }
                        this.zzg = long2;
                        return true;
                    }
                    if(z1 && zzff0.zzg()) {
                        long2 = long1;
                    }
                    this.zzf = long2;
                }
            }
            return true;
        }
        zzgr zzgr2 = zzib0.zzaV().zze();
        Object object2 = zzgt.zzl(s);
        if(zzff0.zza()) {
            integer0 = zzff0.zzb();
        }
        zzgr2.zzc("Invalid event filter ID. appId, id", object2, String.valueOf(integer0));
        return false;
    }
}

