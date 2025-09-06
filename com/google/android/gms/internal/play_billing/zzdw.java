package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

public final class zzdw extends LinkedHashMap {
    private static final zzdw zza;
    private boolean zzb;

    static {
        zzdw zzdw0 = new zzdw();
        zzdw.zza = zzdw0;
        zzdw0.zzb = false;
    }

    private zzdw() {
        this.zzb = true;
    }

    private zzdw(Map map0) {
        super(map0);
        this.zzb = true;
    }

    @Override
    public final void clear() {
        this.zzg();
        super.clear();
    }

    // 去混淆评级： 低(20)
    @Override
    public final Set entrySet() {
        return this.isEmpty() ? Collections.EMPTY_SET : super.entrySet();
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 instanceof Map) {
            if(this == ((Map)object0)) {
                return true;
            }
            if(this.size() == ((Map)object0).size()) {
                for(Object object1: this.entrySet()) {
                    if(!((Map)object0).containsKey(((Map.Entry)object1).getKey())) {
                        return false;
                    }
                    Object object2 = ((Map.Entry)object1).getValue();
                    Object object3 = ((Map)object0).get(((Map.Entry)object1).getKey());
                    if((!(object2 instanceof byte[]) || !(object3 instanceof byte[]) ? object2.equals(object3) : Arrays.equals(((byte[])object2), ((byte[])object3)))) {
                        continue;
                    }
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        for(Object object0: this.entrySet()) {
            int v1 = zzdw.zzf(((Map.Entry)object0).getKey());
            v += zzdw.zzf(((Map.Entry)object0).getValue()) ^ v1;
        }
        return v;
    }

    @Override
    public final Object put(Object object0, Object object1) {
        this.zzg();
        object0.getClass();
        object1.getClass();
        return super.put(object0, object1);
    }

    @Override
    public final void putAll(Map map0) {
        this.zzg();
        for(Object object0: map0.keySet()) {
            object0.getClass();
            map0.get(object0).getClass();
        }
        super.putAll(map0);
    }

    @Override
    public final Object remove(Object object0) {
        this.zzg();
        return super.remove(object0);
    }

    public static zzdw zza() {
        return zzdw.zza;
    }

    // 去混淆评级： 低(20)
    public final zzdw zzb() {
        return this.isEmpty() ? new zzdw() : new zzdw(this);
    }

    public final void zzc() {
        this.zzb = false;
    }

    public final void zzd(zzdw zzdw0) {
        this.zzg();
        if(!zzdw0.isEmpty()) {
            this.putAll(zzdw0);
        }
    }

    public final boolean zze() {
        return this.zzb;
    }

    private static int zzf(Object object0) {
        if(object0 instanceof byte[]) {
            int v = ((byte[])object0).length;
            int v1 = zzda.zzb(v, ((byte[])object0), 0, v);
            return v1 == 0 ? 1 : v1;
        }
        if(object0 instanceof zzcu) {
            throw new UnsupportedOperationException();
        }
        return object0.hashCode();
    }

    private final void zzg() {
        if(!this.zzb) {
            throw new UnsupportedOperationException();
        }
    }
}

