package com.google.android.gms.internal.play_billing;

final class zzdu implements zzep {
    private static final zzea zza;
    private final zzea zzb;

    static {
        zzdu.zza = new zzds();
    }

    public zzdu() {
        zzea zzea0;
        zzcm zzcm0;
        try {
            zzcm0 = zzcm.zza();
            zzea0 = (zzea)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        }
        catch(Exception unused_ex) {
            zzea0 = zzdu.zza;
        }
        zzdt zzdt0 = new zzdt(new zzea[]{zzcm0, zzea0});
        super();
        this.zzb = zzdt0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzep
    public final zzeo zza(Class class0) {
        zzeq.zzr(class0);
        zzdz zzdz0 = this.zzb.zzb(class0);
        boolean z = zzdz0.zzb();
        Class class1 = zzcs.class;
        if(z) {
            return class1.isAssignableFrom(class0) ? zzeg.zzc(zzeq.zzn(), zzcg.zzb(), zzdz0.zza()) : zzeg.zzc(zzeq.zzm(), zzcg.zza(), zzdz0.zza());
        }
        if(class1.isAssignableFrom(class0)) {
            return zzdu.zzb(zzdz0) ? zzef.zzl(class0, zzdz0, zzej.zzb(), zzdq.zzd(), zzeq.zzn(), zzcg.zzb(), zzdy.zzb()) : zzef.zzl(class0, zzdz0, zzej.zzb(), zzdq.zzd(), zzeq.zzn(), null, zzdy.zzb());
        }
        return zzdu.zzb(zzdz0) ? zzef.zzl(class0, zzdz0, zzej.zza(), zzdq.zzc(), zzeq.zzm(), zzcg.zza(), zzdy.zza()) : zzef.zzl(class0, zzdz0, zzej.zza(), zzdq.zzc(), zzeq.zzm(), null, zzdy.zza());
    }

    private static boolean zzb(zzdz zzdz0) {
        return zzdz0.zzc() - 1 != 1;
    }
}

