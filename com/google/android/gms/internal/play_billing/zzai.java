package com.google.android.gms.internal.play_billing;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

public abstract class zzai extends zzaf implements List, RandomAccess {
    private static final zzaw zza;
    public static final int zzd;

    static {
        zzai.zza = new zzag(zzao.zza, 0);
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

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    public final boolean contains(@CheckForNull Object object0) {
        return this.indexOf(object0) >= 0;
    }

    @Override
    public final boolean equals(@CheckForNull Object object0) {
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
                if(!zzz.zza(this.get(v1), ((List)object0).get(v1))) {
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
            if(!zzz.zza(object1, object2)) {
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
    public final int indexOf(@CheckForNull Object object0) {
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

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    public final Iterator iterator() {
        return this.zzl(0);
    }

    @Override
    public final int lastIndexOf(@CheckForNull Object object0) {
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

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    public int zza(Object[] arr_object, int v) {
        int v1 = this.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            arr_object[v2] = this.get(v2);
        }
        return v1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    @Deprecated
    public final zzai zzd() {
        return this;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzaf
    public final zzav zze() {
        return this.zzl(0);
    }

    public zzai zzh(int v, int v1) {
        zzaa.zzd(v, v1, this.size());
        int v2 = v1 - v;
        if(v2 == this.size()) {
            return this;
        }
        return v2 == 0 ? zzao.zza : new zzah(this, v, v2);
    }

    public static zzai zzi(Object[] arr_object, int v) {
        return v == 0 ? zzao.zza : new zzao(arr_object, v);
    }

    public static zzai zzj(Collection collection0) {
        if(collection0 instanceof zzaf) {
            zzai zzai0 = ((zzaf)collection0).zzd();
            if(zzai0.zzf()) {
                Object[] arr_object = zzai0.toArray();
                return zzai.zzi(arr_object, arr_object.length);
            }
            return zzai0;
        }
        Object[] arr_object1 = collection0.toArray();
        for(int v = 0; v < arr_object1.length; ++v) {
            if(arr_object1[v] == null) {
                throw new NullPointerException("at index " + v);
            }
        }
        return zzai.zzi(arr_object1, arr_object1.length);
    }

    public static zzai zzk() {
        return zzao.zza;
    }

    public final zzaw zzl(int v) {
        zzaa.zzb(v, this.size(), "index");
        return this.isEmpty() ? zzai.zza : new zzag(this, v);
    }
}

