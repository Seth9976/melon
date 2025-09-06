package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class zzdm extends zzdq {
    private static final Class zza;

    static {
        zzdm.zza = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();
    }

    private zzdm() {
        throw null;
    }

    public zzdm(zzdl zzdl0) {
        super(null);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdq
    public final void zza(Object object0, long v) {
        List list1;
        List list0 = (List)zzfp.zzf(object0, v);
        if(list0 instanceof zzdk) {
            list1 = ((zzdk)list0).zze();
            zzfp.zzs(object0, v, list1);
            return;
        }
        Class class0 = list0.getClass();
        if(!zzdm.zza.isAssignableFrom(class0)) {
            if(!(list0 instanceof zzek) || !(list0 instanceof zzcz)) {
                list1 = Collections.unmodifiableList(list0);
                zzfp.zzs(object0, v, list1);
            }
            else if(((zzcz)list0).zzc()) {
                ((zzcz)list0).zzb();
            }
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdq
    public final void zzb(Object object0, Object object1, long v) {
        ArrayList arrayList0;
        List list0 = (List)zzfp.zzf(object1, v);
        int v1 = list0.size();
        List list1 = (List)zzfp.zzf(object0, v);
        if(list1.isEmpty()) {
            if(list1 instanceof zzdk) {
                list1 = new zzdj(v1);
            }
            else if(!(list1 instanceof zzek) || !(list1 instanceof zzcz)) {
                list1 = new ArrayList(v1);
            }
            else {
                list1 = ((zzcz)list1).zzd(v1);
            }
            zzfp.zzs(object0, v, list1);
        }
        else {
            Class class0 = list1.getClass();
            if(zzdm.zza.isAssignableFrom(class0)) {
                arrayList0 = new ArrayList(list1.size() + v1);
                arrayList0.addAll(list1);
                zzfp.zzs(object0, v, arrayList0);
                list1 = arrayList0;
            }
            else if(list1 instanceof zzfk) {
                arrayList0 = new zzdj(list1.size() + v1);
                ((zzdj)arrayList0).addAll(((zzdj)arrayList0).size(), ((zzfk)list1));
                zzfp.zzs(object0, v, arrayList0);
                list1 = arrayList0;
            }
            else if(list1 instanceof zzek && list1 instanceof zzcz && !((zzcz)list1).zzc()) {
                list1 = ((zzcz)list1).zzd(list1.size() + v1);
                zzfp.zzs(object0, v, list1);
            }
        }
        int v2 = list1.size();
        if(v2 > 0 && list0.size() > 0) {
            list1.addAll(list0);
        }
        if(v2 > 0) {
            list0 = list1;
        }
        zzfp.zzs(object0, v, list0);
    }
}

