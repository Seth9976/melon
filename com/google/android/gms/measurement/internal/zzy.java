package com.google.android.gms.measurement.internal;

import androidx.collection.f;
import com.google.android.gms.internal.measurement.zzhf;
import com.google.android.gms.internal.measurement.zzhg;
import com.google.android.gms.internal.measurement.zzhp;
import com.google.android.gms.internal.measurement.zzhq;
import com.google.android.gms.internal.measurement.zzih;
import com.google.android.gms.internal.measurement.zzii;
import com.google.android.gms.internal.measurement.zzij;
import com.google.android.gms.internal.measurement.zzik;
import com.google.android.gms.internal.measurement.zzpq;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final class zzy {
    final zzad zza;
    private String zzb;
    private boolean zzc;
    private zzii zzd;
    private BitSet zze;
    private BitSet zzf;
    private Map zzg;
    private Map zzh;

    public zzy(zzad zzad0, String s, zzii zzii0, BitSet bitSet0, BitSet bitSet1, Map map0, Map map1, byte[] arr_b) {
        Objects.requireNonNull(zzad0);
        this.zza = zzad0;
        super();
        this.zzb = s;
        this.zze = bitSet0;
        this.zzf = bitSet1;
        this.zzg = map0;
        this.zzh = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        for(Object object0: map1.keySet()) {
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(((Long)map1.get(((Integer)object0))));
            this.zzh.put(((Integer)object0), arrayList0);
        }
        this.zzc = false;
        this.zzd = zzii0;
    }

    public zzy(zzad zzad0, String s, byte[] arr_b) {
        Objects.requireNonNull(zzad0);
        this.zza = zzad0;
        super();
        this.zzb = s;
        this.zzc = true;
        this.zze = new BitSet();
        this.zzf = new BitSet();
        this.zzg = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.zzh = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
    }

    public final void zza(zzab zzab0) {
        int v = zzab0.zza();
        if(zzab0.zzd != null) {
            this.zzf.set(v, true);
        }
        Boolean boolean0 = zzab0.zze;
        if(boolean0 != null) {
            this.zze.set(v, boolean0.booleanValue());
        }
        if(zzab0.zzf != null) {
            Integer integer0 = v;
            Long long0 = (Long)this.zzg.get(integer0);
            long v1 = (long)zzab0.zzf;
            if(long0 == null || v1 / 1000L > ((long)long0)) {
                this.zzg.put(integer0, ((long)(v1 / 1000L)));
            }
        }
        if(zzab0.zzg != null) {
            Integer integer1 = v;
            List list0 = (List)this.zzh.get(integer1);
            if(list0 == null) {
                list0 = new ArrayList();
                this.zzh.put(integer1, list0);
            }
            if(zzab0.zzb()) {
                list0.clear();
            }
            zzpq.zza();
            zzib zzib0 = this.zza.zzu;
            zzfw zzfw0 = zzfx.zzaF;
            if(zzib0.zzc().zzp(this.zzb, zzfw0) && zzab0.zzc()) {
                list0.clear();
            }
            zzpq.zza();
            if(zzib0.zzc().zzp(this.zzb, zzfw0)) {
                Long long1 = (long)(((long)zzab0.zzg) / 1000L);
                if(!list0.contains(long1)) {
                    list0.add(long1);
                }
            }
            else {
                list0.add(((long)(((long)zzab0.zzg) / 1000L)));
            }
        }
    }

    public final zzhg zzb(int v) {
        List list0;
        Iterable iterable0;
        zzhf zzhf0 = zzhg.zzh();
        zzhf0.zza(v);
        zzhf0.zzd(this.zzc);
        zzii zzii0 = this.zzd;
        if(zzii0 != null) {
            zzhf0.zzc(zzii0);
        }
        zzih zzih0 = zzii.zzi();
        zzih0.zzc(zzpj.zzp(this.zze));
        zzih0.zza(zzpj.zzp(this.zzf));
        Map map0 = this.zzg;
        if(map0 == null) {
            iterable0 = null;
        }
        else {
            ArrayList arrayList0 = new ArrayList(map0.size());
            for(Object object0: this.zzg.keySet()) {
                int v1 = (int)(((Integer)object0));
                Long long0 = (Long)this.zzg.get(((Integer)object0));
                if(long0 != null) {
                    zzhp zzhp0 = zzhq.zze();
                    zzhp0.zza(v1);
                    zzhp0.zzb(((long)long0));
                    arrayList0.add(((zzhq)zzhp0.zzbc()));
                }
            }
            iterable0 = arrayList0;
        }
        if(iterable0 != null) {
            zzih0.zze(iterable0);
        }
        Map map1 = this.zzh;
        if(map1 == null) {
            list0 = Collections.EMPTY_LIST;
        }
        else {
            ArrayList arrayList1 = new ArrayList(map1.size());
            for(Object object1: this.zzh.keySet()) {
                zzij zzij0 = zzik.zzf();
                zzij0.zza(((int)(((Integer)object1))));
                List list1 = (List)this.zzh.get(((Integer)object1));
                if(list1 != null) {
                    Collections.sort(list1);
                    zzij0.zzb(list1);
                }
                arrayList1.add(((zzik)zzij0.zzbc()));
            }
            list0 = arrayList1;
        }
        zzih0.zzg(list0);
        zzhf0.zzb(zzih0);
        return (zzhg)zzhf0.zzbc();
    }

    public final BitSet zzc() {
        return this.zze;
    }
}

