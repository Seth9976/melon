package com.google.android.gms.internal.measurement;

import com.iloen.melon.utils.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzae implements zzak, zzao, Iterable {
    final SortedMap zza;
    final Map zzb;

    public zzae() {
        this.zza = new TreeMap();
        this.zzb = new TreeMap();
    }

    public zzae(List list0) {
        if(list0 != null) {
            for(int v = 0; v < list0.size(); ++v) {
                this.zzn(v, ((zzao)list0.get(v)));
            }
        }
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof zzae)) {
            return false;
        }
        if(this.zzh() != ((zzae)object0).zzh()) {
            return false;
        }
        SortedMap sortedMap0 = this.zza;
        if(sortedMap0.isEmpty()) {
            return ((zzae)object0).zza.isEmpty();
        }
        for(int v = (int)(((Integer)sortedMap0.firstKey())); v <= ((int)(((Integer)sortedMap0.lastKey()))); ++v) {
            if(!this.zzl(v).equals(((zzae)object0).zzl(v))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final int hashCode() {
        return this.zza.hashCode() * 0x1F;
    }

    @Override
    public final Iterator iterator() {
        return new zzad(this);
    }

    // 去混淆评级： 低(20)
    @Override
    public final String toString() {
        return "";
    }

    public final List zzb() {
        List list0 = new ArrayList(this.zzh());
        for(int v = 0; v < this.zzh(); ++v) {
            ((ArrayList)list0).add(this.zzl(v));
        }
        return list0;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        return "";
    }

    // 去混淆评级： 高(200)
    @Override  // com.google.android.gms.internal.measurement.zzao
    public final zzao zzcA(String s, zzg zzg0, List list0) {
        return "concat".equals(s) || "every".equals(s) || "filter".equals(s) || "forEach".equals(s) || "indexOf".equals(s) || "join".equals(s) || "lastIndexOf".equals(s) || "map".equals(s) || "pop".equals(s) || "push".equals(s) || "reduce".equals(s) || "reduceRight".equals(s) || "reverse".equals(s) || "shift".equals(s) || "slice".equals(s) || "some".equals(s) || "sort".equals(s) || "splice".equals(s) || "toString".equals(s) || "unshift".equals(s) ? zzba.zza(s, this, zzg0, list0) : zzak.zzu(this, new zzas(s), zzg0, list0);
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        SortedMap sortedMap0 = this.zza;
        if(sortedMap0.size() == 1) {
            return this.zzl(0).zzd();
        }
        return sortedMap0.size() > 0 ? NaN : 0.0;
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        return true;
    }

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return new zzac(this, this.zza.keySet().iterator(), this.zzb.keySet().iterator());
    }

    public final Iterator zzg() {
        return this.zza.keySet().iterator();
    }

    // 去混淆评级： 低(20)
    public final int zzh() {
        return this.zza.isEmpty() ? 0 : ((int)(((Integer)this.zza.lastKey()))) + 1;
    }

    public final int zzi() {
        return this.zza.size();
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.internal.measurement.zzak
    public final boolean zzj(String s) {
        return "length".equals(s) || this.zzb.containsKey(s);
    }

    @Override  // com.google.android.gms.internal.measurement.zzak
    public final zzao zzk(String s) {
        if("length".equals(s)) {
            return new zzah(((double)this.zzh()));
        }
        if(this.zzj(s)) {
            zzao zzao0 = (zzao)this.zzb.get(s);
            return zzao0 == null ? zzao.zzf : zzao0;
        }
        return zzao.zzf;
    }

    public final zzao zzl(int v) {
        if(v >= this.zzh()) {
            throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
        }
        if(this.zzo(v)) {
            zzao zzao0 = (zzao)this.zza.get(v);
            return zzao0 == null ? zzao.zzf : zzao0;
        }
        return zzao.zzf;
    }

    @Override  // com.google.android.gms.internal.measurement.zzak
    public final void zzm(String s, zzao zzao0) {
        if(zzao0 == null) {
            this.zzb.remove(s);
            return;
        }
        this.zzb.put(s, zzao0);
    }

    @RequiresNonNull({"elements"})
    public final void zzn(int v, zzao zzao0) {
        if(v > 0x7ED4) {
            throw new IllegalStateException("Array too large");
        }
        if(v < 0) {
            throw new IndexOutOfBoundsException(a.k(v, "Out of bounds index: ", new StringBuilder(String.valueOf(v).length() + 21)));
        }
        if(zzao0 == null) {
            this.zza.remove(v);
            return;
        }
        this.zza.put(v, zzao0);
    }

    public final boolean zzo(int v) {
        if(v >= 0) {
            SortedMap sortedMap0 = this.zza;
            if(v <= ((int)(((Integer)sortedMap0.lastKey())))) {
                return sortedMap0.containsKey(v);
            }
        }
        throw new IndexOutOfBoundsException(a.k(v, "Out of bounds index: ", new StringBuilder(String.valueOf(v).length() + 21)));
    }

    public final void zzp() {
        this.zza.clear();
    }

    public final void zzq(int v, zzao zzao0) {
        if(v < 0) {
            throw new IllegalArgumentException(a.k(v, "Invalid value index: ", new StringBuilder(String.valueOf(v).length() + 21)));
        }
        if(v >= this.zzh()) {
            this.zzn(v, zzao0);
            return;
        }
        SortedMap sortedMap0 = this.zza;
        for(int v1 = (int)(((Integer)sortedMap0.lastKey())); v1 >= v; --v1) {
            Integer integer0 = v1;
            zzao zzao1 = (zzao)sortedMap0.get(integer0);
            if(zzao1 != null) {
                this.zzn(v1 + 1, zzao1);
                sortedMap0.remove(integer0);
            }
        }
        this.zzn(v, zzao0);
    }

    public final void zzr(int v) {
        SortedMap sortedMap0 = this.zza;
        int v1 = (int)(((Integer)sortedMap0.lastKey()));
        if(v <= v1 && v >= 0) {
            sortedMap0.remove(v);
            if(v == v1) {
                Integer integer0 = (int)(v - 1);
                if(!sortedMap0.containsKey(integer0) && v - 1 >= 0) {
                    sortedMap0.put(integer0, zzao.zzf);
                }
            }
            else {
                while(true) {
                    ++v;
                    if(v > ((int)(((Integer)sortedMap0.lastKey())))) {
                        break;
                    }
                    Integer integer1 = v;
                    zzao zzao0 = (zzao)sortedMap0.get(integer1);
                    if(zzao0 != null) {
                        sortedMap0.put(((int)(v - 1)), zzao0);
                        sortedMap0.remove(integer1);
                    }
                }
            }
        }
    }

    public final String zzs(String s) [...] // 潜在的解密器

    @Override  // com.google.android.gms.internal.measurement.zzao
    public final zzao zzt() {
        zzao zzao0 = new zzae();
        for(Object object0: this.zza.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            if(map$Entry0.getValue() instanceof zzak) {
                Integer integer0 = (Integer)map$Entry0.getKey();
                zzao zzao1 = (zzao)map$Entry0.getValue();
                zzao0.zza.put(integer0, zzao1);
            }
            else {
                Integer integer1 = (Integer)map$Entry0.getKey();
                zzao zzao2 = ((zzao)map$Entry0.getValue()).zzt();
                zzao0.zza.put(integer1, zzao2);
            }
        }
        return zzao0;
    }
}

