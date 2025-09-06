package com.google.android.gms.measurement.internal;

import android.os.Build.VERSION;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzht;
import com.google.android.gms.internal.measurement.zzhu;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zzhw;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzid;
import com.google.android.gms.internal.measurement.zzie;
import com.google.android.gms.internal.measurement.zzig;
import com.google.android.gms.internal.measurement.zzit;
import com.google.android.gms.internal.measurement.zziu;
import com.google.android.gms.internal.measurement.zzqu;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

final class zzis implements Callable {
    final zzbg zza;
    final String zzb;
    final zzjc zzc;

    public zzis(zzjc zzjc0, zzbg zzbg0, String s) {
        this.zza = zzbg0;
        this.zzb = s;
        Objects.requireNonNull(zzjc0);
        this.zzc = zzjc0;
        super();
    }

    @Override
    public final Object call() {
        byte[] arr_b1;
        zzhz zzhz1;
        long v1;
        zzbc zzbc1;
        String s7;
        Bundle bundle1;
        zzpf zzpf3;
        zzic zzic1;
        zzib zzib2;
        zzh zzh1;
        zzpm zzpm0;
        zzpf zzpf1;
        byte[] arr_b;
        zzic zzic0;
        zzh zzh0;
        this.zzc.zzL().zzY();
        zzlo zzlo0 = this.zzc.zzL().zzn();
        zzlo0.zzg();
        zzib zzib0 = zzlo0.zzu;
        zzib.zzL();
        zzbg zzbg0 = this.zza;
        Preconditions.checkNotNull(zzbg0);
        String s = this.zzb;
        Preconditions.checkNotEmpty(s);
        String s1 = zzbg0.zza;
        if(!"_iap".equals(s1) && !"_iapx".equals(s1)) {
            zzlo0.zzu.zzaV().zzj().zzc("Generating a payload for this event is not available. package_name, event_name", s, s1);
            return null;
        }
        zzpf zzpf0 = zzlo0.zzg;
        zzhz zzhz0 = com.google.android.gms.internal.measurement.zzib.zzh();
        zzpf0.zzj().zzb();
        try {
            zzh0 = zzpf0.zzj().zzu(s);
            if(zzh0 == null) {
                goto label_201;
            }
            else {
                if(zzh0.zzD()) {
                    zzic0 = zzid.zzaE();
                    zzic0.zza(1);
                    zzic0.zzC("android");
                    if(!TextUtils.isEmpty(zzh0.zzc())) {
                        zzic0.zzL(zzh0.zzc());
                    }
                    if(!TextUtils.isEmpty(zzh0.zzv())) {
                        zzic0.zzJ(((String)Preconditions.checkNotNull(zzh0.zzv())));
                    }
                    if(!TextUtils.isEmpty(zzh0.zzr())) {
                        zzic0.zzM(((String)Preconditions.checkNotNull(zzh0.zzr())));
                    }
                    if(zzh0.zzt() != 0xFFFFFFFF80000000L) {
                        zzic0.zzaj(((int)zzh0.zzt()));
                    }
                    zzic0.zzN(zzh0.zzx());
                    zzic0.zzar(zzh0.zzB());
                    String s2 = zzh0.zzf();
                    if(!TextUtils.isEmpty(s2)) {
                        zzic0.zzad(s2);
                    }
                    zzic0.zzay(zzh0.zzak());
                    zzjk zzjk0 = zzlo0.zzg.zzB(s);
                    zzic0.zzY(zzh0.zzz());
                    if(zzib0.zzB()) {
                        String s3 = zzic0.zzK();
                        if(zzlo0.zzu.zzc().zzC(s3) && zzjk0.zzo(zzjj.zza) && !TextUtils.isEmpty(null)) {
                            zzic0.zzam(null);
                        }
                    }
                    zzic0.zzat(zzjk0.zzk());
                    if(zzjk0.zzo(zzjj.zza) && zzh0.zzac()) {
                        Pair pair0 = zzpf0.zzq().zzc(zzh0.zzc(), zzjk0);
                        if(zzh0.zzac() && !TextUtils.isEmpty(((CharSequence)pair0.first))) {
                            try {
                                zzic0.zzQ(zzlo.zzc(((String)pair0.first), Long.toString(zzbg0.zzd)));
                            }
                            catch(SecurityException securityException0) {
                                zzlo0.zzu.zzaV().zzj().zzb("Resettable device id encryption failed", securityException0.getMessage());
                                arr_b = new byte[0];
                                goto label_67;
                            }
                            Object object0 = pair0.second;
                            if(object0 != null) {
                                zzic0.zzT(((Boolean)object0).booleanValue());
                            }
                        }
                    }
                    zzlo0.zzu.zzu().zzw();
                    zzic0.zzF(Build.MODEL);
                    zzlo0.zzu.zzu().zzw();
                    zzic0.zzE(Build.VERSION.RELEASE);
                    zzic0.zzI(((int)zzlo0.zzu.zzu().zzb()));
                    zzic0.zzH(zzlo0.zzu.zzu().zzc());
                    try {
                        if(zzjk0.zzo(zzjj.zzb) && zzh0.zzd() != null) {
                            zzic0.zzW(zzlo.zzc(((String)Preconditions.checkNotNull(zzh0.zzd())), Long.toString(zzbg0.zzd)));
                        }
                        goto label_69;
                    }
                    catch(SecurityException securityException1) {
                        zzlo0.zzu.zzaV().zzj().zzb("app instance id encryption failed", securityException1.getMessage());
                        arr_b = new byte[0];
                        goto label_67;
                    }
                }
                goto label_198;
            }
            goto label_207;
        }
        catch(Throwable throwable0) {
            zzlo0.zzg.zzj().zzd();
            throw throwable0;
        }
    label_67:
        zzlo0.zzg.zzj().zzd();
        return arr_b;
        try {
        label_69:
            if(!TextUtils.isEmpty(zzh0.zzl())) {
                zzic0.zzah(((String)Preconditions.checkNotNull(zzh0.zzl())));
            }
            String s4 = zzh0.zzc();
            zzpf1 = zzlo0.zzg;
            List list0 = zzpf1.zzj().zzn(s4);
            Iterator iterator0 = list0.iterator();
            while(true) {
                if(!iterator0.hasNext()) {
                    zzpm0 = null;
                    break;
                }
                Object object1 = iterator0.next();
                zzpm zzpm1 = (zzpm)object1;
                if("_lte".equals(zzpm1.zzc)) {
                    zzpm0 = zzpm1;
                    break;
                }
            }
            if(zzpm0 == null || zzpm0.zze == null) {
                zzpm zzpm2 = new zzpm(s4, "auto", "_lte", zzlo0.zzu.zzaZ().currentTimeMillis(), 0L);
                list0.add(zzpm2);
                zzpf1.zzj().zzl(zzpm2);
            }
            zziu[] arr_zziu = new zziu[list0.size()];
            for(int v = 0; v < list0.size(); ++v) {
                zzit zzit0 = zziu.zzm();
                zzit0.zzb(((zzpm)list0.get(v)).zzc);
                zzit0.zza(((zzpm)list0.get(v)).zzd);
                zzpf1.zzp().zzc(zzit0, ((zzpm)list0.get(v)).zze);
                arr_zziu[v] = (zziu)zzit0.zzbc();
            }
            zzic0.zzq(Arrays.asList(arr_zziu));
            zzpf zzpf2 = zzlo0.zzg;
            zzpf2.zzI(zzh0, zzic0);
            zzpf2.zzJ(zzh0, zzic0);
            zzgu zzgu0 = zzgu.zza(zzbg0);
            zzib zzib1 = zzlo0.zzu;
            zzpo zzpo0 = zzib1.zzk();
            Bundle bundle0 = zzgu0.zzd;
            zzpo0.zzI(bundle0, zzpf1.zzj().zzW(s));
            zzib1.zzk().zzG(zzgu0, zzib1.zzc().zzd(s));
            bundle0.putLong("_c", 1L);
            zzib1.zzaV().zzj().zza("Marking in-app purchase as real-time");
            bundle0.putLong("_r", 1L);
            String s5 = zzbg0.zzc;
            bundle0.putString("_o", s5);
            if(zzib1.zzk().zzaa(zzic0.zzK(), zzh0.zzay())) {
                zzib1.zzk().zzM(bundle0, "_dbg", 1L);
                zzib1.zzk().zzM(bundle0, "_r", 1L);
            }
            zzav zzav0 = zzpf1.zzj();
            String s6 = zzbg0.zza;
            zzbc zzbc0 = zzav0.zzf(s, s6);
            if(zzbc0 == null) {
                zzh1 = zzh0;
                zzib2 = zzib1;
                zzic1 = zzic0;
                zzpf3 = zzpf2;
                bundle1 = bundle0;
                s7 = s5;
                zzbc1 = new zzbc(s, s6, 0L, 0L, 0L, zzbg0.zzd, 0L, null, null, null, null);
                v1 = 0L;
                zzhz1 = zzhz0;
            }
            else {
                zzpf3 = zzpf2;
                zzh1 = zzh0;
                zzib2 = zzib1;
                zzic1 = zzic0;
                bundle1 = bundle0;
                s7 = s5;
                zzhz1 = zzhz0;
                zzbc1 = zzbc0.zza(zzbg0.zzd);
                v1 = zzbc0.zzf;
            }
            zzpf1.zzj().zzh(zzbc1);
            zzbb zzbb0 = new zzbb(zzlo0.zzu, s7, s, s6, zzbg0.zzd, v1, bundle1);
            zzhr zzhr0 = zzhs.zzk();
            zzhr0.zzo(zzbb0.zzd);
            zzhr0.zzl(zzbb0.zzb);
            zzhr0.zzq(zzbb0.zze);
            zzbe zzbe0 = zzbb0.zzf;
            zzbd zzbd0 = new zzbd(zzbe0);
            while(zzbd0.hasNext()) {
                String s8 = zzbd0.zza();
                zzhv zzhv0 = zzhw.zzn();
                zzhv0.zzb(s8);
                Object object2 = zzbe0.zza(s8);
                if(object2 != null) {
                    zzpf1.zzp().zzd(zzhv0, object2);
                    zzhr0.zzg(zzhv0);
                }
            }
            zzic1.zzg(zzhr0);
            zzie zzie0 = zzig.zza();
            zzht zzht0 = zzhu.zza();
            zzht0.zzb(zzbc1.zzc);
            zzht0.zza(s6);
            zzie0.zza(zzht0);
            zzic1.zzap(zzie0);
            zzic1.zzaf(zzpf1.zzm().zzb(zzh1.zzc(), Collections.EMPTY_LIST, zzic1.zzk(), zzhr0.zzn(), zzhr0.zzn(), false));
            if(zzhr0.zzm()) {
                zzic1.zzv(zzhr0.zzn());
                zzic1.zzx(zzhr0.zzn());
            }
            long v2 = zzh1.zzp();
            int v3 = Long.compare(v2, 0L);
            if(v3 != 0) {
                zzic1.zzA(v2);
            }
            long v4 = zzh1.zzn();
            if(v4 != 0L) {
                zzic1.zzy(v4);
            }
            else if(v3 != 0) {
                zzic1.zzy(v2);
            }
            String s9 = zzh1.zzh();
            zzqu.zza();
            if(zzib2.zzc().zzp(s, zzfx.zzaM) && s9 != null) {
                zzic1.zzau(s9);
            }
            zzh1.zzL();
            zzic1.zzZ(((int)zzh1.zzG()));
            zzib2.zzc().zzi();
            zzic1.zzO(130000L);
            zzic1.zzs(zzib2.zzaZ().currentTimeMillis());
            zzic1.zzae(true);
            zzpf3.zzS(zzic1.zzK(), zzic1);
            zzhz1.zze(zzic1);
            zzh1.zzo(zzic1.zzu());
            zzh1.zzq(zzic1.zzw());
            zzpf1.zzj().zzv(zzh1, false, false);
            zzpf1.zzj().zzc();
        }
        catch(Throwable throwable0) {
            zzlo0.zzg.zzj().zzd();
            throw throwable0;
        }
        zzpf1.zzj().zzd();
        try {
            return zzpf1.zzp().zzv(((com.google.android.gms.internal.measurement.zzib)zzhz1.zzbc()).zzcc());
        }
        catch(IOException iOException0) {
            zzlo0.zzu.zzaV().zzb().zzc("Data loss. Failed to bundle and serialize. appId", zzgt.zzl(s), iOException0);
            return null;
        }
        try {
        label_198:
            zzlo0.zzu.zzaV().zzj().zzb("Log and bundle disabled. package_name", s);
            arr_b1 = new byte[0];
            goto label_207;
        label_201:
            zzlo0.zzu.zzaV().zzj().zzb("Log and bundle not available. package_name", s);
            arr_b1 = new byte[0];
        }
        catch(Throwable throwable0) {
            zzlo0.zzg.zzj().zzd();
            throw throwable0;
        }
    label_207:
        zzpf0.zzj().zzd();
        return arr_b1;
    }
}

