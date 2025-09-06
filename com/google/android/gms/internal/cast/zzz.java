package com.google.android.gms.internal.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zzaa;
import com.google.android.gms.common.util.DefaultClock;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class zzz {
    CastSession zza;
    public int zzb;
    public static final int zzc;
    private static final Logger zzd;
    private static final String zze;
    private static long zzf;
    private final zzgr zzg;
    private final List zzh;
    private final List zzi;
    private final List zzj;
    private final Map zzk;
    private final zzh zzl;
    private final String zzm;
    private final long zzn;
    private final long zzo;
    private String zzp;
    private String zzq;
    private zzr zzr;
    private String zzs;
    private String zzt;
    private String zzu;
    private String zzv;
    private String zzw;
    private String zzx;
    private int zzy;

    static {
        zzz.zzd = new Logger("SessionFlowSummary");
        zzz.zze = "22.1.0";
        zzz.zzf = System.currentTimeMillis();
    }

    private zzz(zzh zzh0, String s) {
        this.zzg = zzgu.zza(new zzy());
        this.zzh = Collections.synchronizedList(new ArrayList());
        this.zzi = Collections.synchronizedList(new ArrayList());
        this.zzj = Collections.synchronizedList(new ArrayList());
        this.zzk = Collections.synchronizedMap(new HashMap());
        this.zzb = 0;
        this.zzl = zzh0;
        this.zzm = s;
        this.zzn = DefaultClock.getInstance().currentTimeMillis();
        long v = zzz.zzf;
        zzz.zzf = v + 1L;
        this.zzo = v;
    }

    public static zzz zza(zzh zzh0, String s) {
        return new zzz(zzh0, s);
    }

    public final void zzb(zzbz zzbz0) {
        zzbz0.zzb(this.zzn);
        this.zzj.add(zzbz0);
    }

    public final void zzc(zzcb zzcb0) {
        zzcb0.zzb(this.zzn);
        this.zzh.add(zzcb0);
    }

    public final void zzd(zzab zzab0) {
        zzab0.zzb(this.zzn);
        this.zzi.add(zzab0);
    }

    public final void zze() {
        ++this.zzy;
    }

    public final void zzf() {
        long v;
        CastSession castSession0 = this.zza;
        if(castSession0 != null) {
            castSession0.zzj(null);
            this.zza = null;
        }
        zzqd zzqd0 = zzqe.zzc();
        zzqd0.zzn(this.zzo);
        String s = this.zzq;
        if(s != null) {
            zzqd0.zzk(s);
        }
        zztu zztu0 = zztv.zza();
        if(!TextUtils.isEmpty(this.zzs)) {
            zzqd0.zzg(this.zzs);
            zztu0.zzc(this.zzs);
        }
        if(!TextUtils.isEmpty(this.zzt)) {
            zztu0.zzd(this.zzt);
        }
        if(!TextUtils.isEmpty(this.zzu)) {
            zztu0.zze(this.zzu);
        }
        if(!TextUtils.isEmpty(this.zzv)) {
            zztu0.zza(this.zzv);
        }
        if(!TextUtils.isEmpty(this.zzw)) {
            zztu0.zzb(this.zzw);
        }
        if(!TextUtils.isEmpty(this.zzx)) {
            zztu0.zzf(this.zzx);
        }
        zztu0.zzg(zzbx.zza(this.zzb));
        zzqd0.zzj(((zztv)zztu0.zzr()));
        zzpo zzpo0 = zzpp.zza();
        zzpo0.zzb("22.1.0");
        zzpo0.zza(this.zzm);
        zzqd0.zzb(((zzpp)zzpo0.zzr()));
        zzql zzql0 = zzqm.zza();
        String s1 = (String)this.zzg.zza();
        if(s1 != null) {
            zzrb zzrb0 = zzrc.zza();
            zzrb0.zza(s1);
            zzql0.zzf(((zzrc)zzrb0.zzr()));
        }
        String s2 = this.zzp;
        if(s2 != null) {
            try {
                String s3 = s2.replace("-", "");
                v = new BigInteger(s3.substring(0, Math.min(16, s3.length())), 16).longValue();
            }
            catch(NumberFormatException numberFormatException0) {
                zzz.zzd.w(numberFormatException0, "receiverSessionId %s is not valid for hash", new Object[]{s2});
                v = 0L;
            }
            zzql0.zzh(v);
        }
        List list0 = this.zzh;
        if(!list0.isEmpty()) {
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: list0) {
                arrayList0.add(((zzcb)object0).zza());
            }
            zzql0.zza(arrayList0);
        }
        List list1 = this.zzi;
        if(!list1.isEmpty()) {
            ArrayList arrayList1 = new ArrayList();
            for(Object object1: list1) {
                arrayList1.add(((zzab)object1).zza());
            }
            zzql0.zzd(arrayList1);
        }
        List list2 = this.zzj;
        if(!list2.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            for(Object object2: list2) {
                arrayList2.add(((zzbz)object2).zza());
            }
            zzql0.zzb(arrayList2);
        }
        if(this.zzr != null) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(this.zzr.zza());
            zzql0.zzc(arrayList3);
        }
        Map map0 = this.zzk;
        if(!map0.isEmpty()) {
            ArrayList arrayList4 = new ArrayList();
            for(Object object3: map0.values()) {
                arrayList4.add(((zzad)object3).zza());
            }
            zzql0.zze(arrayList4);
        }
        zzql0.zzg(this.zzy);
        zzqd0.zzm(((zzqm)zzql0.zzr()));
        zzqe zzqe0 = (zzqe)zzqd0.zzr();
        this.zzl.zzf(zzqe0, 0xE9);
    }

    public final void zzg(CastSession castSession0) {
        if(castSession0 == null) {
            this.zzj(2);
            return;
        }
        CastDevice castDevice0 = castSession0.getCastDevice();
        if(castDevice0 == null) {
            this.zzj(3);
            return;
        }
        this.zza = castSession0;
        String s = this.zzq;
        if(s == null) {
            this.zzq = castDevice0.zzd();
            this.zzs = castDevice0.getModelName();
            this.zzb = castDevice0.zzb();
            zzaa zzaa0 = castDevice0.zzc();
            if(zzaa0 != null) {
                this.zzt = zzaa0.zzc();
                this.zzu = zzaa0.zzd();
                this.zzv = zzaa0.zza();
                this.zzw = zzaa0.zzb();
                this.zzx = zzaa0.zze();
            }
            castSession0.zzm();
            return;
        }
        if(!TextUtils.equals(s, castDevice0.zzd())) {
            this.zzj(5);
        }
    }

    public final void zzh(String s) {
        String s1 = this.zzp;
        if(s1 == null) {
            this.zzp = s;
            return;
        }
        if(!TextUtils.equals(s, s1)) {
            this.zzj(4);
        }
    }

    public final void zzi(zzr zzr0) {
        if(this.zzr != null && this.zzr.zzc()) {
            return;
        }
        zzr0.zzb(this.zzn);
        this.zzr = zzr0;
    }

    public final void zzj(int v) {
        Map map0 = this.zzk;
        Integer integer0 = (int)(v - 1);
        zzad zzad0 = (zzad)map0.get(integer0);
        if(zzad0 == null) {
            zzad zzad1 = new zzad(new zzac(v));
            zzad1.zzc(this.zzn);
            map0.put(integer0, zzad1);
            return;
        }
        zzad0.zzb();
    }
}

