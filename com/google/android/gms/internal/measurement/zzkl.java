package com.google.android.gms.internal.measurement;

import H6.f;
import H6.k;
import android.content.Context;
import android.net.Uri;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import y5.a;

public abstract class zzkl {
    final zzkf zza;
    final String zzb;
    public static final int zzc = 0;
    private static final Object zzd = null;
    @Nullable
    private static volatile zzkg zze = null;
    private static volatile boolean zzf = false;
    private Object zzg;
    private static final AtomicInteger zzh;
    private volatile int zzi;
    private volatile Object zzj;
    private volatile boolean zzk;

    static {
        zzkl.zzd = new Object();
        new AtomicReference();
        a.o(zzkj.zza, "BuildInfo must be non-null");
        zzkl.zzh = new AtomicInteger();
    }

    public zzkl(zzkf zzkf0, String s, Object object0, boolean z, byte[] arr_b) {
        this.zzi = -1;
        if(zzkf0.zza == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zza = zzkf0;
        this.zzb = s;
        this.zzg = object0;
        this.zzk = false;
    }

    @Nullable
    public abstract Object zza(Object arg1);

    public static void zzb(Context context0) {
        if(zzkl.zze == null && context0 != null) {
            Object object0 = zzkl.zzd;
            synchronized(object0) {
                if(zzkl.zze == null) {
                    synchronized(object0) {
                        zzkg zzkg0 = zzkl.zze;
                        Context context1 = context0.getApplicationContext();
                        if(context1 != null) {
                            context0 = context1;
                        }
                        if(zzkg0 == null || zzkg0.zza() != context0) {
                            if(zzkg0 != null) {
                                zzjq.zzd();
                                zzkn.zzb();
                                zzjx.zzc();
                            }
                            zzkl.zze = new zzjn(context0, B.a.T(new zzkk(context0)));
                            zzkl.zzh.incrementAndGet();
                        }
                    }
                }
            }
        }
    }

    public static void zzc() {
        zzkl.zzh.incrementAndGet();
    }

    public final Object zzd() {
        Object object2;
        String s;
        int v = zzkl.zzh.get();
        if(this.zzi < v) {
            synchronized(this) {
                if(this.zzi < v) {
                    zzkg zzkg0 = zzkl.zze;
                    f f0 = H6.a.a;
                    Object object0 = null;
                    if(zzkg0 == null || zzkg0.zzb() == null) {
                        s = null;
                    }
                    else {
                        k k0 = zzkg0.zzb();
                        k0.getClass();
                        f0 = (f)k0.get();
                        s = f0.b() ? ((zzjs)f0.a()).zza(this.zza.zza, null, this.zza.zzc, this.zzb) : null;
                    }
                    a.s("Must call PhenotypeFlagInitializer.maybeInit() first", zzkg0 != null);
                    zzkf zzkf0 = this.zza;
                    Uri uri0 = zzkf0.zza;
                    if(uri0 != null) {
                        zzjq zzjq0 = zzjz.zza(zzkg0.zza(), uri0) ? zzjq.zza(zzkg0.zza().getContentResolver(), uri0, zzki.zza) : null;
                        if(zzjq0 == null) {
                            object2 = null;
                        }
                        else {
                            Object object1 = zzjq0.zze(this.zzb);
                            object2 = object1 == null ? null : this.zza(object1);
                        }
                        if(object2 == null) {
                            if(!zzkf0.zzd) {
                                String s1 = zzjx.zza(zzkg0.zza()).zzb(this.zzb);
                                if(s1 != null) {
                                    object0 = this.zza(s1);
                                }
                            }
                            object2 = object0 == null ? this.zzg : object0;
                        }
                        if(f0.b()) {
                            object2 = s == null ? this.zzg : this.zza(s);
                        }
                        this.zzj = object2;
                        this.zzi = v;
                        return this.zzj;
                    }
                    zzkg0.zza();
                    throw null;
                }
            }
        }
        return this.zzj;
    }
}

