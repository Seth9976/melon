package com.google.android.gms.internal.cast;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class zzhg extends zzhc implements List, RandomAccess {
    private static final zzhx zza;
    public static final int zzd;

    static {
        zzhg.zza = new zzhe(zzhn.zza, 0);
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

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final boolean contains(Object object0) {
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
                if(!zzgm.zza(this.get(v1), ((List)object0).get(v1))) {
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
            if(!zzgm.zza(object1, object2)) {
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
    public final int indexOf(Object object0) {
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

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final Iterator iterator() {
        return this.zzl(0);
    }

    @Override
    public final int lastIndexOf(Object object0) {
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
        return this.zzl(0);
    }

    @Override
    public final ListIterator listIterator(int v) {
        return this.zzl(v);
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
        return this.zzh(v, v1);
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public int zza(Object[] arr_object, int v) {
        int v1 = this.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            arr_object[v2] = this.get(v2);
        }
        return v1;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    @Deprecated
    public final zzhg zzd() {
        return this;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public final zzhw zze() {
        return this.zzl(0);
    }

    public zzhg zzh(int v, int v1) {
        zzgo.zzd(v, v1, this.size());
        int v2 = v1 - v;
        if(v2 == this.size()) {
            return this;
        }
        return v2 == 0 ? zzhn.zza : new zzhf(this, v, v2);
    }

    public static zzhg zzi(Object[] arr_object, int v) {
        return v == 0 ? zzhn.zza : new zzhn(arr_object, v);
    }

    public static zzhg zzj(Collection collection0) {
        if(collection0 instanceof zzhc) {
            zzhg zzhg0 = ((zzhc)collection0).zzd();
            if(zzhg0.zzf()) {
                Object[] arr_object = zzhg0.toArray();
                return zzhg.zzi(arr_object, arr_object.length);
            }
            return zzhg0;
        }
        Object[] arr_object1 = collection0.toArray();
        zzhm.zzb(arr_object1, arr_object1.length);
        return zzhg.zzi(arr_object1, arr_object1.length);
    }

    public static zzhg zzk(Object object0, Object object1) {
        Object[] arr_object = {"com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK", "com.google.android.gms.cast.framework.action.STOP_CASTING"};
        zzhm.zzb(arr_object, 2);
        return zzhg.zzi(arr_object, 2);
    }

    public final zzhx zzl(int v) {
        zzgo.zzb(v, this.size(), "index");
        return this.isEmpty() ? zzhg.zza : new zzhe(this, v);
    }
}

