package com.google.android.gms.internal.cast;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class zzjw extends AbstractMap {
    private static final Comparator zza;
    private final Object[] zzb;
    private final int[] zzc;
    private final Set zzd;
    private Integer zze;
    private String zzf;

    static {
        zzjw.zza = new zzjt();
    }

    public zzjw(List list0) {
        this.zzd = new zzjv(this, -1);
        this.zze = null;
        this.zzf = null;
        Iterator iterator0 = list0.iterator();
        if(!iterator0.hasNext()) {
            int v = list0.size();
            Object[] arr_object = new Object[v];
            Iterator iterator1 = list0.iterator();
            if(!iterator1.hasNext()) {
                if(v > 16 && v * 9 > 0) {
                    arr_object = Arrays.copyOf(arr_object, 0);
                }
                this.zzb = arr_object;
                this.zzc = new int[]{0};
                return;
            }
            iterator1.next();
            throw null;
        }
        iterator0.next();
        throw null;
    }

    @Override
    public final Set entrySet() {
        return this.zzd;
    }

    @Override
    public final int hashCode() {
        if(this.zze == null) {
            this.zze = super.hashCode();
        }
        return (int)this.zze;
    }

    @Override
    public final String toString() {
        if(this.zzf == null) {
            this.zzf = super.toString();
        }
        return this.zzf;
    }

    public static Comparator zza() {
        return zzjw.zza;
    }

    public static int[] zzb(zzjw zzjw0) {
        return zzjw0.zzc;
    }

    public static Object[] zzc(zzjw zzjw0) {
        return zzjw0.zzb;
    }
}

