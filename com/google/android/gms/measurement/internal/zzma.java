package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdf;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public final class zzma extends zzg {
    protected zzlt zza;
    private volatile zzlt zzb;
    private volatile zzlt zzc;
    private final Map zzd;
    private zzdf zze;
    private volatile boolean zzf;
    private volatile zzlt zzg;
    private zzlt zzh;
    private boolean zzi;
    private final Object zzj;

    public zzma(zzib zzib0) {
        super(zzib0);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    private final void zzA(zzlt zzlt0, boolean z, long v) {
        this.zzu.zzw().zzc(this.zzu.zzaZ().elapsedRealtime());
        boolean z1 = zzlt0 != null && zzlt0.zzd;
        if(this.zzu.zzh().zzb.zzd(z1, z, v) && zzlt0 != null) {
            zzlt0.zzd = false;
        }
    }

    private final zzlt zzB(zzdf zzdf0) {
        Preconditions.checkNotNull(zzdf0);
        Integer integer0 = zzdf0.zza;
        Map map0 = this.zzd;
        zzlt zzlt0 = (zzlt)map0.get(integer0);
        if(zzlt0 == null) {
            zzlt zzlt1 = new zzlt(null, this.zzi(zzdf0.zzb, "Activity"), this.zzu.zzk().zzd());
            map0.put(integer0, zzlt1);
            zzlt0 = zzlt1;
        }
        return this.zzg == null ? zzlt0 : this.zzg;
    }

    @Override  // com.google.android.gms.measurement.internal.zzg
    public final boolean zze() {
        return false;
    }

    public final zzlt zzh(boolean z) {
        this.zzb();
        this.zzg();
        if(!z) {
            return this.zza;
        }
        return this.zza == null ? this.zzh : this.zza;
    }

    public final String zzi(String s, String s1) {
        if(s == null) {
            return "Activity";
        }
        String[] arr_s = s.split("\\.");
        String s2 = arr_s.length <= 0 ? "" : arr_s[arr_s.length - 1];
        return s2.length() <= this.zzu.zzc().zze(null, false) ? s2 : s2.substring(0, this.zzu.zzc().zze(null, false));
    }

    public final void zzj(Bundle bundle0, long v) {
        String s1;
        String s;
        synchronized(this.zzj) {
            if(this.zzi) {
                s = bundle0.getString("screen_name");
                if(s == null || s.length() > 0 && s.length() <= this.zzu.zzc().zze(null, false)) {
                    s1 = bundle0.getString("screen_class");
                    if(s1 == null || s1.length() > 0 && s1.length() <= this.zzu.zzc().zze(null, false)) {
                        if(s1 == null) {
                            s1 = this.zze == null ? "Activity" : this.zzi(this.zze.zzb, "Activity");
                        }
                        zzlt zzlt0 = this.zzb;
                        if(this.zzf && zzlt0 != null) {
                            this.zzf = false;
                            if(Objects.equals(zzlt0.zzb, s1) && Objects.equals(zzlt0.zza, s)) {
                                this.zzu.zzaV().zzh().zza("Ignoring call to log screen view event with duplicate parameters.");
                                return;
                            }
                        }
                        goto label_16;
                    }
                    this.zzu.zzaV().zzh().zzb("Invalid screen class length for screen view. Length", s1.length());
                    return;
                }
                this.zzu.zzaV().zzh().zzb("Invalid screen name length for screen view. Length", s.length());
                return;
            }
            this.zzu.zzaV().zzh().zza("Cannot log screen view event when the app is in the background.");
            return;
        }
        return;
    label_16:
        this.zzu.zzaV().zzk().zzc("Logging screen view with name, class", (s == null ? "null" : s), (s1 == null ? "null" : s1));
        zzlt zzlt1 = this.zzb == null ? this.zzc : this.zzb;
        zzlt zzlt2 = new zzlt(s, s1, this.zzu.zzk().zzd(), true, v);
        this.zzb = zzlt2;
        this.zzc = zzlt1;
        this.zzg = zzlt2;
        long v1 = this.zzu.zzaZ().elapsedRealtime();
        this.zzu.zzaW().zzj(new zzlu(this, bundle0, zzlt2, zzlt1, v1));
    }

    @Deprecated
    public final void zzk(zzdf zzdf0, String s, String s1) {
        zzib zzib0 = this.zzu;
        if(!zzib0.zzc().zzv()) {
            zzib0.zzaV().zzh().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzlt zzlt0 = this.zzb;
        if(zzlt0 == null) {
            zzib0.zzaV().zzh().zza("setCurrentScreen cannot be called while no activity active");
            return;
        }
        Map map0 = this.zzd;
        Integer integer0 = zzdf0.zza;
        if(map0.get(integer0) == null) {
            zzib0.zzaV().zzh().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if(s1 == null) {
            s1 = this.zzi(zzdf0.zzb, "Activity");
        }
        if(Objects.equals(zzlt0.zzb, s1) && Objects.equals(zzlt0.zza, s)) {
            zzib0.zzaV().zzh().zza("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if(s != null && (s.length() <= 0 || s.length() > zzib0.zzc().zze(null, false))) {
            zzib0.zzaV().zzh().zzb("Invalid screen name length in setCurrentScreen. Length", s.length());
            return;
        }
        if(s1 != null && (s1.length() <= 0 || s1.length() > zzib0.zzc().zze(null, false))) {
            zzib0.zzaV().zzh().zzb("Invalid class name length in setCurrentScreen. Length", s1.length());
            return;
        }
        zzib0.zzaV().zzk().zzc("Setting current screen to name, class", (s == null ? "null" : s), s1);
        zzlt zzlt1 = new zzlt(s, s1, zzib0.zzk().zzd());
        map0.put(integer0, zzlt1);
        this.zzy(zzdf0.zzb, zzlt1, true);
    }

    public final zzlt zzl() {
        return this.zzb;
    }

    public final void zzm(zzdf zzdf0, Bundle bundle0) {
        if(this.zzu.zzc().zzv() && bundle0 != null) {
            Bundle bundle1 = bundle0.getBundle("com.google.app_measurement.screen_service");
            if(bundle1 != null) {
                zzlt zzlt0 = new zzlt(bundle1.getString("name"), bundle1.getString("referrer_name"), bundle1.getLong("id"));
                this.zzd.put(zzdf0.zza, zzlt0);
            }
        }
    }

    public final void zzn(zzdf zzdf0) {
        Object object0 = this.zzj;
        synchronized(object0) {
            this.zzi = true;
            if(!Objects.equals(zzdf0, this.zze)) {
                __monitor_enter(object0);
                goto label_5;
            }
            goto label_16;
        }
    label_5:
        this.zze = zzdf0;
        this.zzf = false;
        __monitor_exit(object0);
        try {
            zzib zzib0 = this.zzu;
            if(zzib0.zzc().zzv()) {
                this.zzg = null;
                zzib0.zzaW().zzj(new zzlz(this));
            }
        }
        catch(Throwable throwable0) {
            __monitor_exit(object0);
            throw throwable0;
        }
    label_16:
        __monitor_exit(object0);
        zzib zzib1 = this.zzu;
        if(!zzib1.zzc().zzv()) {
            this.zzb = this.zzg;
            zzib1.zzaW().zzj(new zzlw(this));
            return;
        }
        zzlt zzlt0 = this.zzB(zzdf0);
        this.zzy(zzdf0.zzb, zzlt0, false);
        zzd zzd0 = this.zzu.zzw();
        long v = zzd0.zzu.zzaZ().elapsedRealtime();
        zzd0.zzu.zzaW().zzj(new zzc(zzd0, v));
    }

    public final void zzp(zzdf zzdf0) {
        synchronized(this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        zzib zzib0 = this.zzu;
        long v = zzib0.zzaZ().elapsedRealtime();
        if(!zzib0.zzc().zzv()) {
            this.zzb = null;
            zzib0.zzaW().zzj(new zzlx(this, v));
            return;
        }
        zzlt zzlt0 = this.zzB(zzdf0);
        this.zzc = this.zzb;
        this.zzb = null;
        zzib0.zzaW().zzj(new zzly(this, zzlt0, v));
    }

    public final void zzq(zzdf zzdf0, Bundle bundle0) {
        if(this.zzu.zzc().zzv() && bundle0 != null) {
            zzlt zzlt0 = (zzlt)this.zzd.get(zzdf0.zza);
            if(zzlt0 != null) {
                Bundle bundle1 = new Bundle();
                bundle1.putLong("id", zzlt0.zzc);
                bundle1.putString("name", zzlt0.zza);
                bundle1.putString("referrer_name", zzlt0.zzb);
                bundle0.putBundle("com.google.app_measurement.screen_service", bundle1);
            }
        }
    }

    public final void zzs(zzdf zzdf0) {
        synchronized(this.zzj) {
            if(Objects.equals(this.zze, zzdf0)) {
                this.zze = null;
            }
        }
        if(!this.zzu.zzc().zzv()) {
            return;
        }
        this.zzd.remove(zzdf0.zza);
    }

    public final void zzt(Bundle bundle0, zzlt zzlt0, zzlt zzlt1, long v) {
        bundle0.remove("screen_name");
        bundle0.remove("screen_class");
        this.zzz(zzlt0, zzlt1, v, true, this.zzu.zzk().zzF(null, "screen_view", bundle0, null, false));
    }

    public final void zzu(zzlt zzlt0, zzlt zzlt1, long v, boolean z, Bundle bundle0) {
        this.zzz(zzlt0, zzlt1, v, z, null);
    }

    public final void zzv(zzlt zzlt0, boolean z, long v) {
        this.zzA(zzlt0, false, v);
    }

    public final zzlt zzw() {
        return this.zzh;
    }

    public final void zzx(zzlt zzlt0) {
        this.zzh = null;
    }

    private final void zzy(String s, zzlt zzlt0, boolean z) {
        zzlt zzlt2;
        zzlt zzlt1 = this.zzb == null ? this.zzc : this.zzb;
        if(zzlt0.zzb == null) {
            String s1 = s == null ? null : this.zzi(s, "Activity");
            zzlt2 = new zzlt(zzlt0.zza, s1, zzlt0.zzc, zzlt0.zze, zzlt0.zzf);
        }
        else {
            zzlt2 = zzlt0;
        }
        this.zzc = this.zzb;
        this.zzb = zzlt2;
        long v = this.zzu.zzaZ().elapsedRealtime();
        this.zzu.zzaW().zzj(new zzlv(this, zzlt2, zzlt1, v, z));
    }

    private final void zzz(zzlt zzlt0, zzlt zzlt1, long v, boolean z, Bundle bundle0) {
        long v4;
        this.zzg();
        boolean z1 = false;
        boolean z2 = zzlt1 == null || zzlt1.zzc != zzlt0.zzc || !Objects.equals(zzlt1.zzb, zzlt0.zzb) || !Objects.equals(zzlt1.zza, zzlt0.zza);
        if(z && this.zza != null) {
            z1 = true;
        }
        if(z2) {
            Bundle bundle1 = bundle0 == null ? new Bundle() : new Bundle(bundle0);
            zzpo.zzav(zzlt0, bundle1, true);
            if(zzlt1 != null) {
                String s = zzlt1.zza;
                if(s != null) {
                    bundle1.putString("_pn", s);
                }
                String s1 = zzlt1.zzb;
                if(s1 != null) {
                    bundle1.putString("_pc", s1);
                }
                bundle1.putLong("_pi", zzlt1.zzc);
            }
            if(z1) {
                zzob zzob0 = this.zzu.zzh();
                long v1 = v - zzob0.zzb.zzb;
                zzob0.zzb.zzb = v;
                if(v1 > 0L) {
                    this.zzu.zzk().zzak(bundle1, v1);
                }
            }
            zzib zzib0 = this.zzu;
            if(!zzib0.zzc().zzv()) {
                bundle1.putLong("_mst", 1L);
            }
            String s2 = zzlt0.zze ? "app" : "auto";
            long v2 = zzib0.zzaZ().currentTimeMillis();
            if(zzlt0.zze) {
                long v3 = zzlt0.zzf;
                v4 = v3 == 0L ? v2 : v3;
            }
            else {
                v4 = v2;
            }
            this.zzu.zzj().zzG(s2, "_vs", v4, bundle1);
        }
        if(z1) {
            this.zzA(this.zza, true, v);
        }
        this.zza = zzlt0;
        if(zzlt0.zze) {
            this.zzh = zzlt0;
        }
        this.zzu.zzt().zzG(zzlt0);
    }
}

