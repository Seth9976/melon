package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzdj extends zzba implements zzdk, RandomAccess {
    @Deprecated
    public static final zzdk zza;
    private static final zzdj zzb;
    private final List zzc;

    static {
        zzdj zzdj0 = new zzdj(false);
        zzdj.zzb = zzdj0;
        zzdj.zza = zzdj0;
    }

    public zzdj() {
        this(10);
    }

    public zzdj(int v) {
        ArrayList arrayList0 = new ArrayList(v);
        super(true);
        this.zzc = arrayList0;
    }

    private zzdj(ArrayList arrayList0) {
        super(true);
        this.zzc = arrayList0;
    }

    private zzdj(boolean z) {
        super(false);
        this.zzc = Collections.EMPTY_LIST;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzba
    public final void add(int v, Object object0) {
        this.zza();
        this.zzc.add(v, ((String)object0));
        ++this.modCount;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzba
    public final boolean addAll(int v, Collection collection0) {
        this.zza();
        if(collection0 instanceof zzdk) {
            collection0 = ((zzdk)collection0).zzh();
        }
        boolean z = this.zzc.addAll(v, collection0);
        ++this.modCount;
        return z;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzba
    public final boolean addAll(Collection collection0) {
        return this.addAll(this.size(), collection0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzba
    public final void clear() {
        this.zza();
        this.zzc.clear();
        ++this.modCount;
    }

    @Override
    public final Object get(int v) {
        return this.zzg(v);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzba
    public final Object remove(int v) {
        this.zza();
        Object object0 = this.zzc.remove(v);
        ++this.modCount;
        return zzdj.zzi(object0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzba
    public final Object set(int v, Object object0) {
        this.zza();
        return zzdj.zzi(this.zzc.set(v, ((String)object0)));
    }

    @Override
    public final int size() {
        return this.zzc.size();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcz
    public final zzcz zzd(int v) {
        if(v < this.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList0 = new ArrayList(v);
        arrayList0.addAll(this.zzc);
        return new zzdj(arrayList0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdk
    public final zzdk zze() {
        return this.zzc() ? new zzfk(this) : this;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdk
    public final Object zzf(int v) {
        return this.zzc.get(v);
    }

    public final String zzg(int v) {
        Object object0 = this.zzc.get(v);
        if(object0 instanceof String) {
            return (String)object0;
        }
        if(object0 instanceof zzbq) {
            String s = ((zzbq)object0).zzm(zzda.zzb);
            if(((zzbq)object0).zzi()) {
                this.zzc.set(v, s);
            }
            return s;
        }
        String s1 = zzda.zzd(((byte[])object0));
        if(zzfu.zzd(((byte[])object0))) {
            this.zzc.set(v, s1);
        }
        return s1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdk
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    private static String zzi(Object object0) {
        if(object0 instanceof String) {
            return (String)object0;
        }
        return object0 instanceof zzbq ? ((zzbq)object0).zzm(zzda.zzb) : zzda.zzd(((byte[])object0));
    }
}

