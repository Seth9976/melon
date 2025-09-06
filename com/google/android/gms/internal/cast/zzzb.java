package com.google.android.gms.internal.cast;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzzb extends AbstractSet {
    final zzzd zza;

    public zzzb(zzzd zzzd0, zzzc zzzc0) {
        this.zza = zzzd0;
        super();
    }

    @Override
    public final boolean add(Object object0) {
        if(!this.contains(((Map.Entry)object0))) {
            Comparable comparable0 = (Comparable)((Map.Entry)object0).getKey();
            Object object1 = ((Map.Entry)object0).getValue();
            this.zza.zzf(comparable0, object1);
            return true;
        }
        return false;
    }

    @Override
    public final void clear() {
        this.zza.clear();
    }

    @Override
    public final boolean contains(Object object0) {
        Object object1 = ((Map.Entry)object0).getKey();
        Object object2 = this.zza.get(object1);
        Object object3 = ((Map.Entry)object0).getValue();
        return object2 == object3 || object2 != null && object2.equals(object3);
    }

    @Override
    public final Iterator iterator() {
        return new zzza(this.zza, null);
    }

    @Override
    public final boolean remove(Object object0) {
        if(this.contains(((Map.Entry)object0))) {
            Object object1 = ((Map.Entry)object0).getKey();
            this.zza.remove(object1);
            return true;
        }
        return false;
    }

    @Override
    public final int size() {
        return this.zza.size();
    }
}

