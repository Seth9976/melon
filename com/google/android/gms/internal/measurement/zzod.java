package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzod extends AbstractMap {
    private Object[] zza;
    private int zzb;
    private Map zzc;
    private boolean zzd;
    private volatile zzoc zze;
    private Map zzf;

    private zzod() {
        this.zzc = Collections.EMPTY_MAP;
        this.zzf = Collections.EMPTY_MAP;
    }

    public zzod(byte[] arr_b) {
        this.zzc = Collections.EMPTY_MAP;
        this.zzf = Collections.EMPTY_MAP;
    }

    @Override
    public final void clear() {
        this.zzn();
        if(this.zzb != 0) {
            this.zza = null;
            this.zzb = 0;
        }
        if(!this.zzc.isEmpty()) {
            this.zzc.clear();
        }
    }

    @Override
    public final boolean containsKey(Object object0) {
        return this.zzm(((Comparable)object0)) >= 0 || this.zzc.containsKey(((Comparable)object0));
    }

    @Override
    public final Set entrySet() {
        if(this.zze == null) {
            this.zze = new zzoc(this, null);
        }
        return this.zze;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzod)) {
            return super.equals(object0);
        }
        int v = this.size();
        if(v == ((zzod)object0).size()) {
            int v1 = this.zzb;
            if(v1 == ((zzod)object0).zzb) {
                for(int v2 = 0; v2 < v1; ++v2) {
                    if(!this.zzd(v2).equals(((zzod)object0).zzd(v2))) {
                        return false;
                    }
                }
                return v1 == v ? true : this.zzc.equals(((zzod)object0).zzc);
            }
            return this.entrySet().equals(((zzod)object0).entrySet());
        }
        return false;
    }

    @Override
    public final Object get(Object object0) {
        int v = this.zzm(((Comparable)object0));
        return v < 0 ? this.zzc.get(((Comparable)object0)) : ((zzoa)this.zza[v]).getValue();
    }

    @Override
    public final int hashCode() {
        int v = this.zzb;
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += this.zza[v1].hashCode();
        }
        return this.zzc.size() <= 0 ? v2 : this.zzc.hashCode() + v2;
    }

    @Override
    public final Object put(Object object0, Object object1) {
        return this.zzf(((Comparable)object0), object1);
    }

    @Override
    public final Object remove(Object object0) {
        this.zzn();
        int v = this.zzm(((Comparable)object0));
        if(v >= 0) {
            return this.zzl(v);
        }
        return this.zzc.isEmpty() ? null : this.zzc.remove(((Comparable)object0));
    }

    @Override
    public final int size() {
        return this.zzc.size() + this.zzb;
    }

    public void zza() {
        if(!this.zzd) {
            this.zzc = this.zzc.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.zzc);
            this.zzf = this.zzf.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(this.zzf);
            this.zzd = true;
        }
    }

    public final boolean zzb() {
        return this.zzd;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final Map.Entry zzd(int v) {
        if(v >= this.zzb) {
            throw new ArrayIndexOutOfBoundsException(v);
        }
        return (zzoa)this.zza[v];
    }

    // 去混淆评级： 低(20)
    public final Iterable zze() {
        return this.zzc.isEmpty() ? Collections.EMPTY_SET : this.zzc.entrySet();
    }

    public final Object zzf(Comparable comparable0, Object object0) {
        this.zzn();
        int v = this.zzm(comparable0);
        if(v >= 0) {
            return ((zzoa)this.zza[v]).setValue(object0);
        }
        this.zzn();
        if(this.zza == null) {
            this.zza = new Object[16];
        }
        if(-(v + 1) >= 16) {
            return this.zzo().put(comparable0, object0);
        }
        if(this.zzb == 16) {
            zzoa zzoa0 = (zzoa)this.zza[15];
            this.zzb = 15;
            this.zzo().put(zzoa0.zza(), zzoa0.getValue());
        }
        System.arraycopy(this.zza, -(v + 1), this.zza, -v, 15 - -(v + 1));
        Object[] arr_object = this.zza;
        arr_object[-(v + 1)] = new zzoa(this, comparable0, object0);
        ++this.zzb;
        return null;
    }

    public final Object zzg(int v) {
        return this.zzl(v);
    }

    public final void zzh() {
        this.zzn();
    }

    public final Object[] zzi() {
        return this.zza;
    }

    public final int zzj() {
        return this.zzb;
    }

    public final Map zzk() {
        return this.zzc;
    }

    private final Object zzl(int v) {
        this.zzn();
        Object object0 = ((zzoa)this.zza[v]).getValue();
        System.arraycopy(this.zza, v + 1, this.zza, v, this.zzb - v - 1);
        --this.zzb;
        if(!this.zzc.isEmpty()) {
            Iterator iterator0 = this.zzo().entrySet().iterator();
            Object[] arr_object = this.zza;
            int v1 = this.zzb;
            Object object1 = iterator0.next();
            arr_object[v1] = new zzoa(this, ((Comparable)((Map.Entry)object1).getKey()), ((Map.Entry)object1).getValue());
            ++this.zzb;
            iterator0.remove();
        }
        return object0;
    }

    private final int zzm(Comparable comparable0) {
        int v = this.zzb;
        int v1 = v - 1;
        int v2 = 0;
        if(v1 >= 0) {
            int v3 = comparable0.compareTo(((zzoa)this.zza[v1]).zza());
            if(v3 > 0) {
                return -(v + 1);
            }
            if(v3 == 0) {
                return v1;
            }
        }
        while(v2 <= v1) {
            int v4 = (v2 + v1) / 2;
            int v5 = comparable0.compareTo(((zzoa)this.zza[v4]).zza());
            if(v5 < 0) {
                v1 = v4 - 1;
                continue;
            }
            if(v5 > 0) {
                v2 = v4 + 1;
                continue;
            }
            return v4;
        }
        return -(v2 + 1);
    }

    private final void zzn() {
        if(this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap zzo() {
        this.zzn();
        if(this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap0 = new TreeMap();
            this.zzc = treeMap0;
            this.zzf = treeMap0.descendingMap();
        }
        return (SortedMap)this.zzc;
    }
}

