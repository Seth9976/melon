package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzkt extends AbstractList implements zzmn {
    private boolean zza;

    public zzkt(boolean z) {
        this.zza = z;
    }

    @Override
    public void add(int v, Object object0) {
        this.zzcF();
        super.add(v, object0);
    }

    @Override
    public boolean add(Object object0) {
        this.zzcF();
        return super.add(object0);
    }

    @Override
    public final boolean addAll(int v, Collection collection0) {
        this.zzcF();
        return super.addAll(v, collection0);
    }

    @Override
    public boolean addAll(Collection collection0) {
        this.zzcF();
        return super.addAll(collection0);
    }

    @Override
    public final void clear() {
        this.zzcF();
        super.clear();
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof List)) {
            return false;
        }
        if(!(object0 instanceof RandomAccess)) {
            return super.equals(object0);
        }
        int v = this.size();
        if(v == ((List)object0).size()) {
            for(int v1 = 0; v1 < v; ++v1) {
                if(!this.get(v1).equals(((List)object0).get(v1))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int v = this.size();
        int v2 = 1;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 = v2 * 0x1F + this.get(v1).hashCode();
        }
        return v2;
    }

    @Override
    public Object remove(int v) {
        this.zzcF();
        return super.remove(v);
    }

    @Override
    public final boolean remove(Object object0) {
        this.zzcF();
        int v = this.indexOf(object0);
        if(v == -1) {
            return false;
        }
        this.remove(v);
        return true;
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        this.zzcF();
        return super.removeAll(collection0);
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        this.zzcF();
        return super.retainAll(collection0);
    }

    @Override
    public Object set(int v, Object object0) {
        this.zzcF();
        return super.set(v, object0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzmn
    public final boolean zza() {
        return this.zza;
    }

    @Override  // com.google.android.gms.internal.measurement.zzmn
    public final void zzb() {
        if(this.zza) {
            this.zza = false;
        }
    }

    public final void zzcF() {
        if(!this.zza) {
            throw new UnsupportedOperationException();
        }
    }
}

