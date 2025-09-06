package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzfh;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zziu;
import com.google.android.gms.internal.measurement.zzpq;
import java.util.Objects;

final class zzac extends zzab {
    final zzad zza;
    private final zzfn zzh;

    public zzac(zzad zzad0, String s, int v, zzfn zzfn0) {
        Objects.requireNonNull(zzad0);
        this.zza = zzad0;
        super(s, v);
        this.zzh = zzfn0;
    }

    @Override  // com.google.android.gms.measurement.internal.zzab
    public final int zza() {
        return this.zzh.zzb();
    }

    @Override  // com.google.android.gms.measurement.internal.zzab
    public final boolean zzb() {
        return true;
    }

    @Override  // com.google.android.gms.measurement.internal.zzab
    public final boolean zzc() {
        return false;
    }

    public final boolean zzd(Long long0, Long long1, zziu zziu0, boolean z) {
        zzpq.zza();
        zzib zzib0 = this.zza.zzu;
        boolean z1 = zzib0.zzc().zzp(this.zzb, zzfx.zzaD);
        zzfn zzfn0 = this.zzh;
        boolean z2 = zzfn0.zzh();
        boolean z3 = zzfn0.zze() || zzfn0.zzf() || z2;
        Integer integer0 = null;
        if(z && !z3) {
            zzgr zzgr0 = zzib0.zzaV().zzk();
            Integer integer1 = this.zzc;
            if(zzfn0.zza()) {
                integer0 = zzfn0.zzb();
            }
            zzgr0.zzc("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", integer1, integer0);
            return true;
        }
        zzfh zzfh0 = zzfn0.zzd();
        boolean z4 = zzfh0.zzf();
        if(!zziu0.zzf()) {
            if(!zziu0.zzj()) {
                if(!zziu0.zzd()) {
                    zzib0.zzaV().zze().zzb("User property has no value, property", zzib0.zzl().zzc(""));
                }
                else if(zzfh0.zza()) {
                    integer0 = zzab.zze(zzab.zzf("", zzfh0.zzb(), zzib0.zzaV()), z4);
                }
                else if(!zzfh0.zzc()) {
                    zzib0.zzaV().zze().zzb("No string or number filter defined. property", zzib0.zzl().zzc(""));
                }
                else {
                    zzib0.zzaV().zze().zzc("Invalid user property value for Numeric number filter. property, value", zzib0.zzl().zzc(""), "");
                }
            }
            else if(!zzfh0.zzc()) {
                zzib0.zzaV().zze().zzb("No number filter for double property. property", zzib0.zzl().zzc(""));
            }
            else {
                integer0 = zzab.zze(zzab.zzh(zziu0.zzk(), zzfh0.zzd()), z4);
            }
        }
        else if(!zzfh0.zzc()) {
            zzib0.zzaV().zze().zzb("No number filter for long property. property", zzib0.zzl().zzc(""));
        }
        else {
            integer0 = zzab.zze(zzab.zzg(zziu0.zzg(), zzfh0.zzd()), z4);
        }
        zzgr zzgr1 = zzib0.zzaV().zzk();
        String s = integer0 == null ? "null" : integer0;
        zzgr1.zzb("Property filter result", s);
        if(integer0 == null) {
            return false;
        }
        this.zzd = Boolean.TRUE;
        if(z2 && !((Boolean)integer0).booleanValue()) {
            return true;
        }
        if(!z || zzfn0.zze()) {
            this.zze = integer0;
        }
        if(((Boolean)integer0).booleanValue() && z3 && zziu0.zza()) {
            long v = long0 == null ? zziu0.zzb() : ((long)long0);
            if(z1 && zzfn0.zze() && !zzfn0.zzf() && long1 != null) {
                v = (long)long1;
            }
            if(zzfn0.zzf()) {
                this.zzg = v;
                return true;
            }
            this.zzf = v;
        }
        return true;
    }
}

