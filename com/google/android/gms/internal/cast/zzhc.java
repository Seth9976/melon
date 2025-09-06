package com.google.android.gms.internal.cast;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;

public abstract class zzhc extends AbstractCollection implements Serializable {
    private static final Object[] zza;

    static {
        zzhc.zza = new Object[0];
    }

    @Override
    @Deprecated
    public final boolean add(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean addAll(Collection collection0) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public abstract boolean contains(Object arg1);

    @Override
    public Iterator iterator() {
        return this.zze();
    }

    @Override
    @Deprecated
    public final boolean remove(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean removeAll(Collection collection0) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean retainAll(Collection collection0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Spliterator spliterator() {
        return Spliterators.spliterator(this, 0x510);
    }

    @Override
    public final Object[] toArray() {
        return this.toArray(zzhc.zza);
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        arr_object.getClass();
        int v = this.size();
        if(arr_object.length < v) {
            Object[] arr_object1 = this.zzg();
            if(arr_object1 == null) {
                if(arr_object.length != 0) {
                    arr_object = Arrays.copyOf(arr_object, 0);
                }
                arr_object = Arrays.copyOf(arr_object, v);
                this.zza(arr_object, 0);
                return arr_object;
            }
            return Arrays.copyOfRange(arr_object1, this.zzc(), this.zzb(), arr_object.getClass());
        }
        else if(arr_object.length > v) {
            arr_object[v] = null;
        }
        this.zza(arr_object, 0);
        return arr_object;
    }

    public int zza(Object[] arr_object, int v) {
        throw null;
    }

    public int zzb() {
        throw new UnsupportedOperationException();
    }

    public int zzc() {
        throw new UnsupportedOperationException();
    }

    public zzhg zzd() {
        throw null;
    }

    public abstract zzhw zze();

    public abstract boolean zzf();

    public Object[] zzg() {
        return null;
    }
}

