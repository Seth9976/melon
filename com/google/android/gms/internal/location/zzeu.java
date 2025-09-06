package com.google.android.gms.internal.location;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import javax.annotation.CheckForNull;

public abstract class zzeu extends AbstractCollection implements Serializable {
    private static final Object[] zza;

    static {
        zzeu.zza = new Object[0];
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
    public Iterator iterator() {
        return this.zza();
    }

    @Override
    @Deprecated
    public final boolean remove(@CheckForNull Object object0) {
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
        return this.toArray(zzeu.zza);
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        arr_object.getClass();
        int v = this.size();
        if(arr_object.length < v) {
            Object[] arr_object1 = this.zzb();
            if(arr_object1 == null) {
                if(arr_object.length != 0) {
                    arr_object = Arrays.copyOf(arr_object, 0);
                }
                arr_object = Arrays.copyOf(arr_object, v);
                this.zzg(arr_object, 0);
                return arr_object;
            }
            return Arrays.copyOfRange(arr_object1, this.zzc(), this.zzd(), arr_object.getClass());
        }
        else if(arr_object.length > v) {
            arr_object[v] = null;
        }
        this.zzg(arr_object, 0);
        return arr_object;
    }

    public abstract zzez zza();

    @CheckForNull
    public Object[] zzb() {
        throw null;
    }

    public int zzc() {
        throw null;
    }

    public int zzd() {
        throw null;
    }

    public zzex zze() {
        throw null;
    }

    public abstract boolean zzf();

    public int zzg(Object[] arr_object, int v) {
        throw null;
    }
}

