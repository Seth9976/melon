package com.google.android.gms.measurement.internal;

final class zznv implements Runnable {
    private final zznw zza;

    public zznv(zznw zznw0) {
        this.zza = zznw0;
    }

    @Override
    public final void run() {
        zznw zznw0 = this.zza;
        zzob zzob0 = zznw0.zzc.zza;
        zzob0.zzg();
        zzib zzib0 = zzob0.zzu;
        zzib0.zzaV().zzj().zza("Application going to the background");
        zzib0.zzd().zzn.zzb(true);
        zzob0.zzh(true);
        if(!zzib0.zzc().zzv()) {
            zzob0.zzb.zzd(false, false, zznw0.zzb);
            zzob0.zzb.zzb(zznw0.zzb);
        }
        zzib0.zzaV().zzi().zzb("Application backgrounded at: timestamp_millis", zznw0.zza);
        zzib zzib1 = zzob0.zzu;
        zzli zzli0 = zzib1.zzj();
        zzli0.zzg();
        zzib zzib2 = zzli0.zzu;
        zzli0.zzb();
        zznk zznk0 = zzib2.zzt();
        zznk0.zzg();
        zznk0.zzb();
        if(!zznk0.zzK() || zznk0.zzu.zzk().zzah() >= 242600) {
            zzib2.zzt().zzF();
        }
        if(zzib0.zzc().zzp(null, zzfx.zzaN)) {
            long v = zzib0.zzk().zzaa("com.iloen.melon", zzib0.zzc().zzz()) ? 1000L : zzib0.zzc().zzl("com.iloen.melon", zzfx.zzD);
            zzib0.zzaV().zzk().zzb("[sgtm] Scheduling batch upload with minimum latency in millis", v);
            zzib1.zzx().zzh(v);
        }
    }
}

