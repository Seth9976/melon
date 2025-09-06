package com.google.android.gms.internal.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class zzaj extends zzae implements List, RandomAccess {
    private static final zzan zza;
    public static final int zzd;

    static {
        zzaj.zza = new zzag(zzal.zza, 0);
    }

    @Override
    @Deprecated
    public final void add(int v, Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean addAll(int v, Collection collection0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object object0) {
        return this.indexOf(object0) >= 0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof List)) {
            return false;
        }
        int v = this.size();
        if(v != ((List)object0).size()) {
            return false;
        }
        if(((List)object0) instanceof RandomAccess) {
            for(int v1 = 0; v1 < v; ++v1) {
                if(!zzs.zza(this.get(v1), ((List)object0).get(v1))) {
                    return false;
                }
            }
            return true;
        }
        Iterator iterator0 = this.iterator();
        Iterator iterator1 = ((List)object0).iterator();
        while(iterator0.hasNext()) {
            if(!iterator1.hasNext()) {
                return false;
            }
            Object object1 = iterator0.next();
            Object object2 = iterator1.next();
            if(!zzs.zza(object1, object2)) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return !iterator1.hasNext();
    }

    @Override
    public final int hashCode() {
        int v = this.size();
        int v2 = 1;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 = v2 * 0x1F + this.get(v1).hashCode();
        }
        return v2;
    }

    @Override
    public int indexOf(Object object0) {
        if(object0 == null) {
            return -1;
        }
        int v = this.size();
        for(int v1 = 0; v1 < v; ++v1) {
            if(object0.equals(this.get(v1))) {
                return v1;
            }
        }
        return -1;
    }

    @Override  // com.google.android.gms.internal.common.zzae
    public final Iterator iterator() {
        return this.zzr(0);
    }

    @Override
    public int lastIndexOf(Object object0) {
        if(object0 == null) {
            return -1;
        }
        for(int v = this.size() - 1; v >= 0; --v) {
            if(object0.equals(this.get(v))) {
                return v;
            }
        }
        return -1;
    }

    @Override
    public final ListIterator listIterator() {
        return this.zzr(0);
    }

    @Override
    public final ListIterator listIterator(int v) {
        return this.zzr(v);
    }

    @Override
    @Deprecated
    public final Object remove(int v) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final Object set(int v, Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int v, int v1) {
        return this.zzi(v, v1);
    }

    @Override  // com.google.android.gms.internal.common.zzae
    public final zzam zza() {
        return this.zzr(0);
    }

    @Override  // com.google.android.gms.internal.common.zzae
    @Deprecated
    public final zzaj zze() {
        return this;
    }

    @Override  // com.google.android.gms.internal.common.zzae
    public int zzg(Object[] arr_object, int v) {
        int v1 = this.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            arr_object[v2] = this.get(v2);
        }
        return v1;
    }

    public zzaj zzh() {
        return this.size() <= 1 ? this : new zzah(this);
    }

    public zzaj zzi(int v, int v1) {
        zzt.zzd(v, v1, this.size());
        int v2 = v1 - v;
        if(v2 == this.size()) {
            return this;
        }
        return v2 == 0 ? zzal.zza : new zzai(this, v, v2);
    }

    public static zzaj zzj() {
        return zzal.zza;
    }

    public static zzaj zzk(Object object0) {
        Object[] arr_object = {object0};
        zzak.zza(arr_object, 1);
        return zzaj.zzq(arr_object, 1);
    }

    public static zzaj zzl(Object object0, Object object1) {
        Object[] arr_object = {object0, object1};
        zzak.zza(arr_object, 2);
        return zzaj.zzq(arr_object, 2);
    }

    public static zzaj zzm(Object object0, Object object1, Object object2) {
        Object[] arr_object = {object0, object1, object2};
        zzak.zza(arr_object, 3);
        return zzaj.zzq(arr_object, 3);
    }

    public static zzaj zzn(Object object0, Object object1, Object object2, Object object3, Object object4, Object object5) {
        Object[] arr_object = {object0, object1, object2, object3, object4, object5};
        zzak.zza(arr_object, 6);
        return zzaj.zzq(arr_object, 6);
    }

    public static zzaj zzo(Iterable iterable0) {
        iterable0.getClass();
        if(iterable0 instanceof Collection) {
            return zzaj.zzp(((Collection)iterable0));
        }
        Iterator iterator0 = iterable0.iterator();
        if(!iterator0.hasNext()) {
            return zzal.zza;
        }
        Object object0 = iterator0.next();
        if(!iterator0.hasNext()) {
            return zzaj.zzk(object0);
        }
        zzaf zzaf0 = new zzaf(4);
        zzaf0.zzb(object0);
        zzaf0.zzc(iterator0);
        return zzaf0.zzd();
    }

    public static zzaj zzp(Collection collection0) {
        if(collection0 instanceof zzae) {
            zzaj zzaj0 = ((zzae)collection0).zze();
            if(zzaj0.zzf()) {
                Object[] arr_object = zzaj0.toArray();
                return zzaj.zzq(arr_object, arr_object.length);
            }
            return zzaj0;
        }
        Object[] arr_object1 = collection0.toArray();
        zzak.zza(arr_object1, arr_object1.length);
        return zzaj.zzq(arr_object1, arr_object1.length);
    }

    public static zzaj zzq(Object[] arr_object, int v) {
        return v == 0 ? zzal.zza : new zzal(arr_object, v);
    }

    public final zzan zzr(int v) {
        zzt.zzc(v, this.size(), "index");
        return this.isEmpty() ? zzaj.zza : new zzag(this, v);
    }
}

