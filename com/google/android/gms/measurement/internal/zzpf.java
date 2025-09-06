package com.google.android.gms.measurement.internal;

import W.m;
import android.app.BroadcastOptions;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.collection.V;
import androidx.collection.f;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzgf;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgx;
import com.google.android.gms.internal.measurement.zzhe;
import com.google.android.gms.internal.measurement.zzhh;
import com.google.android.gms.internal.measurement.zzhk;
import com.google.android.gms.internal.measurement.zzhl;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zzhw;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzid;
import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzis;
import com.google.android.gms.internal.measurement.zzit;
import com.google.android.gms.internal.measurement.zziu;
import com.google.android.gms.internal.measurement.zzjq;
import com.google.android.gms.internal.measurement.zzka;
import com.google.android.gms.internal.measurement.zzkl;
import com.google.android.gms.internal.measurement.zzme;
import com.google.android.gms.internal.measurement.zzmq;
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.internal.measurement.zzqu;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import jeb.synthetic.TWR;
import k8.Y;

public final class zzpf implements zzjf {
    private List zzA;
    private long zzB;
    private final Map zzC;
    private final Map zzD;
    private final Map zzE;
    private final Map zzF;
    private zzlt zzG;
    private String zzH;
    private zzay zzI;
    private long zzJ;
    private final zzpn zzK;
    long zza;
    private static volatile zzpf zzb;
    private final zzhs zzc;
    private final zzgy zzd;
    private zzav zze;
    private zzha zzf;
    private zzoj zzg;
    private zzad zzh;
    private final zzpj zzi;
    private zzlo zzj;
    private zznm zzk;
    private final zzot zzl;
    private zzhj zzm;
    private final zzib zzn;
    private final AtomicBoolean zzo;
    private boolean zzp;
    private List zzq;
    private final Deque zzr;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private FileLock zzx;
    private FileChannel zzy;
    private List zzz;

    public zzpf(zzpg zzpg0, zzib zzib0) {
        this.zzo = new AtomicBoolean(false);
        this.zzr = new LinkedList();
        this.zzF = new HashMap();
        this.zzK = new zzpa(this);
        Preconditions.checkNotNull(zzpg0);
        this.zzn = zzib.zzy(zzpg0.zza, null, null);
        this.zzB = -1L;
        this.zzl = new zzot(this);
        zzpj zzpj0 = new zzpj(this);
        zzpj0.zzaz();
        this.zzi = zzpj0;
        zzgy zzgy0 = new zzgy(this);
        zzgy0.zzaz();
        this.zzd = zzgy0;
        zzhs zzhs0 = new zzhs(this);
        zzhs0.zzaz();
        this.zzc = zzhs0;
        this.zzC = new HashMap();
        this.zzD = new HashMap();
        this.zzE = new HashMap();
        this.zzaW().zzj(new zzou(this, zzpg0));
    }

    public final void zzA(String s, zzjk zzjk0) {
        this.zzaW().zzg();
        this.zzu();
        this.zzC.put(s, zzjk0);
        this.zzj().zzab(s, zzjk0);
    }

    public final zzjk zzB(String s) {
        this.zzaW().zzg();
        this.zzu();
        zzjk zzjk0 = (zzjk)this.zzC.get(s);
        if(zzjk0 == null) {
            zzjk0 = this.zzj().zzZ(s);
            if(zzjk0 == null) {
                zzjk0 = zzjk.zza;
            }
            this.zzA(s, zzjk0);
        }
        return zzjk0;
    }

    public final long zzC() {
        long v = this.zzaZ().currentTimeMillis();
        zznm zznm0 = this.zzk;
        zznm0.zzay();
        zznm0.zzg();
        zzhd zzhd0 = zznm0.zzf;
        long v1 = zzhd0.zza();
        if(v1 == 0L) {
            v1 = ((long)zznm0.zzu.zzk().zzf().nextInt(86400000)) + 1L;
            zzhd0.zzb(v1);
        }
        return (v + v1) / 1000L / 60L / 60L / 24L;
    }

    public final void zzD(zzbg zzbg0, String s) {
        zzh zzh0 = this.zzj().zzu(s);
        if(zzh0 != null && !TextUtils.isEmpty(zzh0.zzr())) {
            Boolean boolean0 = this.zzaM(zzh0);
            if(boolean0 != null) {
                if(!boolean0.booleanValue()) {
                    this.zzaV().zzb().zzb("App version does not match; dropping event. appId", zzgt.zzl(s));
                    return;
                }
            }
            else if(!"_ui".equals(zzbg0.zza)) {
                this.zzaV().zze().zzb("Could not find package. appId", zzgt.zzl(s));
            }
            this.zzE(zzbg0, new zzr(s, zzh0.zzf(), zzh0.zzr(), zzh0.zzt(), zzh0.zzv(), zzh0.zzx(), zzh0.zzz(), null, zzh0.zzD(), false, zzh0.zzl(), 0L, 0, zzh0.zzac(), false, zzh0.zzae(), zzh0.zzB(), zzh0.zzag(), this.zzB(s).zzl(), "", null, zzh0.zzai(), zzh0.zzak(), this.zzB(s).zzb(), this.zzx(s).zze(), zzh0.zzao(), zzh0.zzaw(), zzh0.zzay(), zzh0.zzaH(), 0L, zzh0.zzaL()));
            return;
        }
        this.zzaV().zzj().zzb("No app data available; dropping event", s);
    }

    public final void zzE(zzbg zzbg0, zzr zzr0) {
        Preconditions.checkNotEmpty(zzr0.zza);
        zzgu zzgu0 = zzgu.zza(zzbg0);
        zzpo zzpo0 = this.zzt();
        Bundle bundle0 = this.zzj().zzW(zzr0.zza);
        zzpo0.zzI(zzgu0.zzd, bundle0);
        this.zzt().zzG(zzgu0, this.zzd().zzd(zzr0.zza));
        zzbg zzbg1 = zzgu0.zzb();
        if(!this.zzd().zzp(null, zzfx.zzbg) && "_cmp".equals(zzbg1.zza)) {
            zzbe zzbe0 = zzbg1.zzb;
            if("referrer API v2".equals(zzbe0.zzd("_cis"))) {
                String s = zzbe0.zzd("gclid");
                if(!TextUtils.isEmpty(s)) {
                    this.zzab(new zzpk("_lgclid", zzbg1.zzd, s, "auto"), zzr0);
                }
            }
        }
        this.zzF(zzbg1, zzr0);
    }

    public final void zzF(zzbg zzbg0, zzr zzr0) {
        List list3;
        List list2;
        List list1;
        zzbg zzbg2;
        Preconditions.checkNotNull(zzr0);
        String s = zzr0.zza;
        Preconditions.checkNotEmpty(s);
        this.zzaW().zzg();
        this.zzu();
        long v = zzbg0.zzd;
        zzgu zzgu0 = zzgu.zza(zzbg0);
        this.zzaW().zzg();
        zzpo.zzav((this.zzG != null && (this.zzH != null && this.zzH.equals(s)) ? this.zzG : null), zzgu0.zzd, false);
        zzbg zzbg1 = zzgu0.zzb();
        this.zzp();
        if(!zzpj.zzD(zzbg1, zzr0)) {
            return;
        }
        if(!zzr0.zzh) {
            this.zzan(zzr0);
            return;
        }
        List list0 = zzr0.zzr;
        if(list0 == null) {
            zzbg2 = zzbg1;
        }
        else {
            String s1 = zzbg1.zza;
            if(list0.contains(s1)) {
                Bundle bundle0 = zzbg1.zzb.zzf();
                bundle0.putLong("ga_safelisted", 1L);
                zzbg2 = new zzbg(s1, new zzbe(bundle0), zzbg1.zzc, zzbg1.zzd);
                goto label_27;
            }
            this.zzaV().zzj().zzd("Dropping non-safelisted event. appId, event name, origin", s, zzbg1.zza, zzbg1.zzc);
            return;
        }
    label_27:
        this.zzj().zzb();
        try {
            String s2 = zzbg2.zza;
            if("_s".equals(s2) && !this.zzj().zzQ(s, "_s") && ((long)zzbg2.zzb.zzb("_sid")) != 0L) {
                if(this.zzj().zzQ(s, "_f") || this.zzj().zzQ(s, "_v")) {
                    this.zzj().zzY(s, null, "_sid", this.zzG(s, zzbg2));
                }
                else {
                    this.zzj().zzY(s, ((long)(this.zzaZ().currentTimeMillis() - 15000L)), "_sid", this.zzG(s, zzbg2));
                }
            }
            zzav zzav0 = this.zzj();
            Preconditions.checkNotEmpty(s);
            zzav0.zzg();
            zzav0.zzay();
            int v2 = Long.compare(v, 0L);
            if(v2 < 0) {
                zzav0.zzu.zzaV().zze().zzc("Invalid time querying timed out conditional properties", zzgt.zzl(s), v);
                list1 = Collections.EMPTY_LIST;
            }
            else {
                list1 = zzav0.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{s, String.valueOf(v)});
            }
            for(Object object0: list1) {
                zzah zzah0 = (zzah)object0;
                if(zzah0 != null) {
                    this.zzaV().zzk().zzd("User property timed out", zzah0.zza, this.zzn.zzl().zzc(zzah0.zzc.zzb), zzah0.zzc.zza());
                    zzbg zzbg3 = zzah0.zzg;
                    if(zzbg3 != null) {
                        this.zzH(new zzbg(zzbg3, v), zzr0);
                    }
                    this.zzj().zzr(s, zzah0.zzc.zzb);
                }
            }
            zzav zzav1 = this.zzj();
            Preconditions.checkNotEmpty(s);
            zzav1.zzg();
            zzav1.zzay();
            if(v2 < 0) {
                zzav1.zzu.zzaV().zze().zzc("Invalid time querying expired conditional properties", zzgt.zzl(s), v);
                list2 = Collections.EMPTY_LIST;
            }
            else {
                list2 = zzav1.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{s, String.valueOf(v)});
            }
            ArrayList arrayList0 = new ArrayList(list2.size());
            for(Object object1: list2) {
                zzah zzah1 = (zzah)object1;
                if(zzah1 != null) {
                    this.zzaV().zzk().zzd("User property expired", zzah1.zza, this.zzn.zzl().zzc(zzah1.zzc.zzb), zzah1.zzc.zza());
                    this.zzj().zzk(s, zzah1.zzc.zzb);
                    zzbg zzbg4 = zzah1.zzk;
                    if(zzbg4 != null) {
                        arrayList0.add(zzbg4);
                    }
                    this.zzj().zzr(s, zzah1.zzc.zzb);
                }
            }
            for(Object object2: arrayList0) {
                this.zzH(new zzbg(((zzbg)object2), v), zzr0);
            }
            zzav zzav2 = this.zzj();
            Preconditions.checkNotEmpty(s);
            Preconditions.checkNotEmpty(s2);
            zzav2.zzg();
            zzav2.zzay();
            if(v2 < 0) {
                zzav2.zzu.zzaV().zze().zzd("Invalid time querying triggered conditional properties", zzgt.zzl(s), zzav2.zzu.zzl().zza(s2), v);
                list3 = Collections.EMPTY_LIST;
            }
            else {
                list3 = zzav2.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{s, s2, String.valueOf(v)});
            }
            ArrayList arrayList1 = new ArrayList(list3.size());
            for(Object object3: list3) {
                zzah zzah2 = (zzah)object3;
                if(zzah2 != null) {
                    zzpk zzpk0 = zzah2.zzc;
                    String s3 = (String)Preconditions.checkNotNull(zzah2.zza);
                    String s4 = zzah2.zzb;
                    Object object4 = Preconditions.checkNotNull(zzpk0.zza());
                    zzpm zzpm0 = new zzpm(s3, s4, zzpk0.zzb, v, object4);
                    if(this.zzj().zzl(zzpm0)) {
                        this.zzaV().zzk().zzd("User property triggered", zzah2.zza, this.zzn.zzl().zzc(zzpm0.zzc), zzpm0.zze);
                    }
                    else {
                        this.zzaV().zzb().zzd("Too many active user properties, ignoring", zzgt.zzl(zzah2.zza), this.zzn.zzl().zzc(zzpm0.zzc), zzpm0.zze);
                    }
                    zzbg zzbg5 = zzah2.zzi;
                    if(zzbg5 != null) {
                        arrayList1.add(zzbg5);
                    }
                    zzah2.zzc = new zzpk(zzpm0);
                    zzah2.zze = true;
                    this.zzj().zzp(zzah2);
                }
            }
            this.zzH(zzbg2, zzr0);
            for(Object object5: arrayList1) {
                this.zzH(new zzbg(((zzbg)object5), v), zzr0);
            }
            this.zzj().zzc();
        }
        finally {
            this.zzj().zzd();
        }
    }

    public final Bundle zzG(String s, zzbg zzbg0) {
        Bundle bundle0 = new Bundle();
        bundle0.putLong("_sid", ((long)zzbg0.zzb.zzb("_sid")));
        zzpm zzpm0 = this.zzj().zzm(s, "_sno");
        if(zzpm0 != null) {
            Object object0 = zzpm0.zze;
            if(object0 instanceof Long) {
                bundle0.putLong("_sno", ((long)(((Long)object0))));
            }
        }
        return bundle0;
    }

    public final void zzH(zzbg zzbg0, zzr zzr0) {
        long v4;
        zzbg zzbg2;
        zzpm zzpm1;
        int v22;
        long v21;
        zzjj zzjj1;
        ArrayList arrayList0;
        zzbc zzbc1;
        zzbb zzbb2;
        String s8;
        zzib zzib0;
        long v14;
        zzar zzar0;
        long v8;
        Preconditions.checkNotNull(zzr0);
        String s = zzr0.zza;
        Preconditions.checkNotEmpty(s);
        long v = System.nanoTime();
        this.zzaW().zzg();
        this.zzu();
        this.zzp();
        if(zzpj.zzD(zzbg0, zzr0)) {
            if(!zzr0.zzh) {
                this.zzan(zzr0);
                return;
            }
            zzhs zzhs0 = this.zzh();
            String s1 = zzbg0.zza;
            if(!zzhs0.zzj(s, s1)) {
                goto label_28;
            }
            this.zzaV().zze().zzc("Dropping blocked event. appId", zzgt.zzl(s), this.zzn.zzl().zza(s1));
            if(this.zzh().zzn(s) || this.zzh().zzo(s)) {
                zzh zzh0 = this.zzj().zzu(s);
                if(zzh0 != null) {
                    long v1 = Math.max(zzh0.zzJ(), zzh0.zzH());
                    long v2 = Math.abs(this.zzaZ().currentTimeMillis() - v1);
                    this.zzd();
                    if(v2 > ((long)(((Long)zzfx.zzN.zzb(null))))) {
                        this.zzaV().zzj().zza("Fetching config for blocked app");
                        this.zzV(zzh0);
                        return;
                    label_28:
                        zzgu zzgu0 = zzgu.zza(zzbg0);
                        this.zzt().zzG(zzgu0, this.zzd().zzd(s));
                        int v3 = this.zzd().zzn(s, zzfx.zzag, 10, 35);
                        Bundle bundle0 = zzgu0.zzd;
                        for(Object object0: new TreeSet(bundle0.keySet())) {
                            String s2 = (String)object0;
                            if("items".equals(s2)) {
                                this.zzt().zzH(bundle0.getParcelableArray(s2), v3);
                            }
                        }
                        zzbg zzbg1 = zzgu0.zzb();
                        if(Log.isLoggable(this.zzaV().zzn(), 2)) {
                            this.zzaV().zzk().zzb("Logging event", this.zzn.zzl().zzd(zzbg1));
                        }
                        this.zzj().zzb();
                        try {
                            this.zzan(zzr0);
                            String s3 = zzbg1.zza;
                            boolean z = "ecommerce_purchase".equals(s3) || ("purchase".equals(s3) || "refund".equals(s3));
                            if("_iap".equals(s3)) {
                            label_49:
                                zzbe zzbe0 = zzbg1.zzb;
                                String s4 = zzbe0.zzd("currency");
                                if(z) {
                                    double f = ((double)zzbe0.zzc("value")) * 1000000.0;
                                    if(f == 0.0) {
                                        f = ((double)(((long)zzbe0.zzb("value")))) * 1000000.0;
                                    }
                                    if(f > 9223372036854776000.0 || f < -9223372036854776000.0) {
                                        this.zzaV().zze().zzc("Data lost. Currency value is too big. appId", zzgt.zzl(s), f);
                                        this.zzj().zzc();
                                        goto label_393;
                                    label_93:
                                        zzbg2 = zzbg1;
                                    label_94:
                                        String s6 = zzbg2.zza;
                                        boolean z1 = zzpo.zzh(s6);
                                        boolean z2 = "_err".equals(s6);
                                        this.zzt();
                                        zzbe zzbe1 = zzbg2.zzb;
                                        if(zzbe1 == null) {
                                            v8 = 0L;
                                        }
                                        else {
                                            v8 = 0L;
                                            zzbd zzbd0 = new zzbd(zzbe1);
                                            while(zzbd0.hasNext()) {
                                                Object object2 = zzbe1.zza(zzbd0.zza());
                                                if(object2 instanceof Parcelable[]) {
                                                    v8 += (long)((Parcelable[])object2).length;
                                                }
                                            }
                                        }
                                        zzar0 = this.zzj().zzx(this.zzC(), s, v8 + 1L, true, z1, false, z2, false, false, false);
                                        long v9 = zzar0.zzb;
                                        this.zzd();
                                        long v10 = v9 - zzal.zzH();
                                        if(Long.compare(v10, 0L) > 0) {
                                            goto label_386;
                                        }
                                        else if(z1) {
                                            long v11 = zzar0.zza;
                                            this.zzd();
                                            long v12 = v11 - ((long)(((int)(((Integer)zzfx.zzm.zzb(null))))));
                                            if(v12 <= 0L) {
                                                goto label_120;
                                            }
                                            else {
                                                goto label_381;
                                            }
                                        }
                                        else {
                                        label_120:
                                            if(z2) {
                                                long v13 = zzar0.zzd - ((long)Math.max(0, Math.min(1000000, this.zzd().zzm(zzr0.zza, zzfx.zzl))));
                                                if(v13 <= 0L) {
                                                    goto label_123;
                                                }
                                                else {
                                                    goto label_377;
                                                }
                                            }
                                            else {
                                            label_123:
                                                Bundle bundle1 = zzbe1.zzf();
                                                zzpo zzpo0 = this.zzt();
                                                String s7 = zzbg2.zzc;
                                                zzpo0.zzM(bundle1, "_o", s7);
                                                if(this.zzt().zzaa(s, zzr0.zzB)) {
                                                    this.zzt().zzM(bundle1, "_dbg", 1L);
                                                    this.zzt().zzM(bundle1, "_r", 1L);
                                                }
                                                if("_s".equals(s6)) {
                                                    zzpm zzpm2 = this.zzj().zzm(zzr0.zza, "_sno");
                                                    if(zzpm2 != null) {
                                                        Object object3 = zzpm2.zze;
                                                        if(object3 instanceof Long) {
                                                            this.zzt().zzM(bundle1, "_sno", object3);
                                                        }
                                                    }
                                                }
                                                if(this.zzd().zzp(null, zzfx.zzaX) && Objects.equals(s7, "am") && Objects.equals(s6, "_ai")) {
                                                    Object object4 = bundle1.get("value");
                                                    if(object4 instanceof String) {
                                                        try {
                                                            double f1 = Double.parseDouble(((String)object4));
                                                            bundle1.remove("value");
                                                            bundle1.putDouble("value", f1);
                                                        }
                                                        catch(NumberFormatException unused_ex) {
                                                        }
                                                    }
                                                }
                                                zzav zzav1 = this.zzj();
                                                Preconditions.checkNotEmpty(s);
                                                zzav1.zzg();
                                                zzav1.zzay();
                                                try {
                                                    v14 = (long)zzav1.zze().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{s, String.valueOf(Math.max(0, Math.min(1000000, zzav1.zzu.zzc().zzm(s, zzfx.zzp))))});
                                                }
                                                catch(SQLiteException sQLiteException1) {
                                                    zzav1.zzu.zzaV().zzb().zzc("Error deleting over the limit events. appId", zzgt.zzl(s), sQLiteException1);
                                                    v14 = 0L;
                                                }
                                                if(v14 > 0L) {
                                                    this.zzaV().zze().zzc("Data lost. Too many events stored on disk, deleted. appId", zzgt.zzl(s), v14);
                                                }
                                                zzib0 = this.zzn;
                                                zzbb zzbb0 = new zzbb(zzib0, zzbg2.zzc, s, zzbg2.zza, zzbg2.zzd, 0L, bundle1);
                                                zzav zzav2 = this.zzj();
                                                s8 = zzbb0.zzb;
                                                zzbc zzbc0 = zzav2.zzf(s, s8);
                                                if(zzbc0 != null) {
                                                    zzbb zzbb1 = zzbb0.zza(zzib0, zzbc0.zzf);
                                                    zzbb2 = zzbb1;
                                                    zzbc1 = zzbc0.zza(zzbb1.zzd);
                                                }
                                                else if(this.zzj().zzU(s) < ((long)this.zzd().zzh(s)) || !z1) {
                                                    zzbc1 = new zzbc(s, s8, 0L, 0L, 0L, zzbb0.zzd, 0L, null, null, null, null);
                                                    zzbb2 = zzbb0;
                                                }
                                                else {
                                                    goto label_374;
                                                }
                                                this.zzj().zzh(zzbc1);
                                                this.zzaW().zzg();
                                                this.zzu();
                                                Preconditions.checkNotNull(zzbb2);
                                                Preconditions.checkNotNull(zzr0);
                                                Preconditions.checkNotEmpty(zzbb2.zza);
                                                String s9 = zzr0.zza;
                                                Preconditions.checkArgument(zzbb2.zza.equals(s9));
                                                zzic zzic0 = zzid.zzaE();
                                                zzic0.zza(1);
                                                zzic0.zzC("android");
                                                if(!TextUtils.isEmpty(s9)) {
                                                    zzic0.zzL(s9);
                                                }
                                                String s10 = zzr0.zzd;
                                                if(!TextUtils.isEmpty(s10)) {
                                                    zzic0.zzJ(s10);
                                                }
                                                String s11 = zzr0.zzc;
                                                if(!TextUtils.isEmpty(s11)) {
                                                    zzic0.zzM(s11);
                                                }
                                                String s12 = zzr0.zzu;
                                                if(!TextUtils.isEmpty(s12)) {
                                                    zzic0.zzau(s12);
                                                }
                                                long v15 = zzr0.zzj;
                                                if(v15 != 0xFFFFFFFF80000000L) {
                                                    zzic0.zzaj(((int)v15));
                                                }
                                                zzic0.zzN(zzr0.zze);
                                                String s13 = zzr0.zzb;
                                                if(!TextUtils.isEmpty(s13)) {
                                                    zzic0.zzad(s13);
                                                }
                                                zzjk zzjk0 = this.zzB(((String)Preconditions.checkNotNull(s9))).zzs(zzjk.zzf(zzr0.zzs, 100));
                                                zzic0.zzat(zzjk0.zzk());
                                                zzql.zza();
                                                if(this.zzd().zzp(s9, zzfx.zzaP) && this.zzt().zzX(s9)) {
                                                    zzic0.zzaH(zzr0.zzz);
                                                    long v16 = zzjk0.zzo(zzjj.zza) || zzr0.zzA == 0L ? zzr0.zzA : zzr0.zzA & -2L | 0x20L;
                                                    zzic0.zzaz(v16 == 1L);
                                                    if(v16 != 0L) {
                                                        com.google.android.gms.internal.measurement.zzhd zzhd0 = zzhe.zzh();
                                                        zzhd0.zza((v16 & 1L) != 0L);
                                                        zzhd0.zzb((v16 & 2L) != 0L);
                                                        zzhd0.zzc((v16 & 4L) != 0L);
                                                        zzhd0.zzd((v16 & 8L) != 0L);
                                                        zzhd0.zze((v16 & 16L) != 0L);
                                                        zzhd0.zzf((0x20L & v16) != 0L);
                                                        zzhd0.zzg((v16 & 0x40L) != 0L);
                                                        zzic0.zzaI(((zzhe)zzhd0.zzbc()));
                                                    }
                                                }
                                                long v17 = zzr0.zzf;
                                                if(v17 != 0L) {
                                                    zzic0.zzY(v17);
                                                }
                                                zzic0.zzar(zzr0.zzq);
                                                zzpj zzpj0 = this.zzp();
                                                zzjq zzjq0 = zzjq.zza(zzpj0.zzg.zzn.zzaY().getContentResolver(), zzka.zza("com.google.android.gms.measurement"), () -> zzkl.zzc());
                                                Map map0 = zzjq0 == null ? Collections.EMPTY_MAP : zzjq0.zzb();
                                                if(map0 != null && !map0.isEmpty()) {
                                                    arrayList0 = new ArrayList();
                                                    int v18 = (int)(((Integer)zzfx.zzaf.zzb(null)));
                                                    for(Object object5: map0.entrySet()) {
                                                        Map.Entry map$Entry0 = (Map.Entry)object5;
                                                        if(((String)map$Entry0.getKey()).startsWith("measurement.id.")) {
                                                            try {
                                                                int v19 = Integer.parseInt(((String)map$Entry0.getValue()));
                                                                if(v19 == 0) {
                                                                    continue;
                                                                }
                                                                arrayList0.add(v19);
                                                                if(arrayList0.size() < v18) {
                                                                    continue;
                                                                }
                                                                zzpj0.zzu.zzaV().zze().zzb("Too many experiment IDs. Number of IDs", arrayList0.size());
                                                                break;
                                                            }
                                                            catch(NumberFormatException numberFormatException0) {
                                                                zzpj0.zzu.zzaV().zze().zzb("Experiment ID NumberFormatException", numberFormatException0);
                                                            }
                                                        }
                                                    }
                                                    if(arrayList0.isEmpty()) {
                                                        arrayList0 = null;
                                                    }
                                                }
                                                else {
                                                    arrayList0 = null;
                                                }
                                                if(arrayList0 != null) {
                                                    zzic0.zzaq(arrayList0);
                                                }
                                                if(this.zzd().zzp(null, zzfx.zzbb)) {
                                                    zzic0.zzaP("");
                                                }
                                                String s14 = zzr0.zza;
                                                zzjk zzjk1 = this.zzB(((String)Preconditions.checkNotNull(s14))).zzs(zzjk.zzf(zzr0.zzs, 100));
                                                zzjj zzjj0 = zzjj.zza;
                                                if(!zzjk1.zzo(zzjj0) || !zzr0.zzn) {
                                                    zzjj1 = zzjj0;
                                                }
                                                else {
                                                    Pair pair0 = this.zzk.zzc(s14, zzjk1);
                                                    if(TextUtils.isEmpty(((CharSequence)pair0.first))) {
                                                        zzjj1 = zzjj0;
                                                    }
                                                    else {
                                                        zzic0.zzQ(((String)pair0.first));
                                                        Object object6 = pair0.second;
                                                        if(object6 != null) {
                                                            zzic0.zzT(((Boolean)object6).booleanValue());
                                                        }
                                                        if(zzbb2.zzb.equals("_fx") || ((String)pair0.first).equals("00000000-0000-0000-0000-000000000000")) {
                                                            zzjj1 = zzjj0;
                                                        }
                                                        else {
                                                            zzh zzh1 = this.zzj().zzu(s14);
                                                            if(zzh1 == null || !zzh1.zzaq()) {
                                                                zzjj1 = zzjj0;
                                                            }
                                                            else {
                                                                this.zzR(s14, false, null, null);
                                                                Bundle bundle2 = new Bundle();
                                                                Long long0 = zzh1.zzas();
                                                                if(long0 == null) {
                                                                    zzjj1 = zzjj0;
                                                                }
                                                                else {
                                                                    zzjj1 = zzjj0;
                                                                    bundle2.putLong("_pfo", Math.max(0L, ((long)long0)));
                                                                }
                                                                Long long1 = zzh1.zzau();
                                                                if(long1 != null) {
                                                                    bundle2.putLong("_uwa", ((long)long1));
                                                                }
                                                                bundle2.putLong("_r", 1L);
                                                                this.zzK.zza(s14, "_fx", bundle2);
                                                            }
                                                        }
                                                    }
                                                }
                                                zzib zzib1 = this.zzn;
                                                zzib1.zzu().zzw();
                                                zzic0.zzF(Build.MODEL);
                                                zzib1.zzu().zzw();
                                                zzic0.zzE(Build.VERSION.RELEASE);
                                                zzic0.zzI(((int)zzib1.zzu().zzb()));
                                                zzic0.zzH(zzib1.zzu().zzc());
                                                zzic0.zzay(zzr0.zzw);
                                                if(zzib1.zzB() && !TextUtils.isEmpty(null)) {
                                                    zzic0.zzam(null);
                                                }
                                                zzh zzh2 = this.zzj().zzu(s14);
                                                if(zzh2 == null) {
                                                    zzh2 = new zzh(zzib1, s14);
                                                    zzh2.zze(this.zzK(zzjk1));
                                                    zzh2.zzm(zzr0.zzk);
                                                    zzh2.zzg(zzr0.zzb);
                                                    if(zzjk1.zzo(zzjj1)) {
                                                        zzh2.zzk(this.zzk.zzf(s14, zzr0.zzn));
                                                    }
                                                    zzh2.zzF(0L);
                                                    zzh2.zzo(0L);
                                                    zzh2.zzq(0L);
                                                    zzh2.zzs(zzr0.zzc);
                                                    zzh2.zzu(zzr0.zzj);
                                                    zzh2.zzw(zzr0.zzd);
                                                    zzh2.zzy(zzr0.zze);
                                                    zzh2.zzA(zzr0.zzf);
                                                    zzh2.zzE(zzr0.zzh);
                                                    zzh2.zzC(zzr0.zzq);
                                                    this.zzj().zzv(zzh2, false, false);
                                                }
                                                if(zzjk1.zzo(zzjj.zzb) && !TextUtils.isEmpty(zzh2.zzd())) {
                                                    zzic0.zzW(((String)Preconditions.checkNotNull(zzh2.zzd())));
                                                }
                                                if(!TextUtils.isEmpty(zzh2.zzl())) {
                                                    zzic0.zzah(((String)Preconditions.checkNotNull(zzh2.zzl())));
                                                }
                                                List list0 = this.zzj().zzn(s14);
                                                for(int v20 = 0; v20 < list0.size(); ++v20) {
                                                    zzit zzit0 = zziu.zzm();
                                                    zzit0.zzb(((zzpm)list0.get(v20)).zzc);
                                                    zzit0.zza(((zzpm)list0.get(v20)).zzd);
                                                    this.zzp().zzc(zzit0, ((zzpm)list0.get(v20)).zze);
                                                    zzic0.zzp(zzit0);
                                                    if("_sid".equals(((zzpm)list0.get(v20)).zzc) && zzh2.zzam() != 0L && this.zzp().zzu(zzr0.zzu) != zzh2.zzam()) {
                                                        zzic0.zzav();
                                                    }
                                                }
                                                try {
                                                    zzav zzav3 = this.zzj();
                                                    zzme zzme0 = zzic0.zzbc();
                                                    zzav3.zzg();
                                                    zzav3.zzay();
                                                    Preconditions.checkNotNull(((zzid)zzme0));
                                                    Preconditions.checkNotEmpty("");
                                                    byte[] arr_b = ((zzid)zzme0).zzcc();
                                                    v21 = zzav3.zzg.zzp().zzt(arr_b);
                                                    ContentValues contentValues0 = new ContentValues();
                                                    contentValues0.put("app_id", "");
                                                    contentValues0.put("metadata_fingerprint", v21);
                                                    contentValues0.put("metadata", arr_b);
                                                    try {
                                                        zzav3.zze().insertWithOnConflict("raw_events_metadata", null, contentValues0, 4);
                                                    }
                                                    catch(SQLiteException sQLiteException2) {
                                                        zzav3.zzu.zzaV().zzb().zzc("Error storing raw event metadata. appId", zzgt.zzl(""), sQLiteException2);
                                                        throw sQLiteException2;
                                                    }
                                                }
                                                catch(IOException iOException0) {
                                                    this.zzaV().zzb().zzc("Data loss. Failed to insert raw event metadata. appId", zzgt.zzl(zzic0.zzK()), iOException0);
                                                    this.zzj().zzc();
                                                    goto label_370;
                                                }
                                                zzav zzav4 = this.zzj();
                                                zzbd zzbd1 = new zzbd(zzbb2.zzf);
                                                while(true) {
                                                    if(zzbd1.hasNext()) {
                                                        if("_r".equals(zzbd1.zza())) {
                                                            v22 = 1;
                                                            break;
                                                        }
                                                    }
                                                    else if(!this.zzh().zzk(zzbb2.zza, zzbb2.zzb) || this.zzj().zzw(this.zzC(), zzbb2.zza, false, false, false, false, false, false, false).zze >= ((long)this.zzd().zzm(zzbb2.zza, zzfx.zzo))) {
                                                        v22 = 0;
                                                        break;
                                                    }
                                                    else {
                                                        v22 = 1;
                                                        break;
                                                    }
                                                }
                                                zzav4.zzg();
                                                zzav4.zzay();
                                                Preconditions.checkNotNull(zzbb2);
                                                String s15 = zzbb2.zza;
                                                Preconditions.checkNotEmpty(s15);
                                                byte[] arr_b1 = zzav4.zzg.zzp().zzh(zzbb2).zzcc();
                                                ContentValues contentValues1 = new ContentValues();
                                                contentValues1.put("app_id", s15);
                                                contentValues1.put("name", zzbb2.zzb);
                                                contentValues1.put("timestamp", zzbb2.zzd);
                                                contentValues1.put("metadata_fingerprint", v21);
                                                contentValues1.put("data", arr_b1);
                                                contentValues1.put("realtime", v22);
                                                try {
                                                    if(zzav4.zze().insert("raw_events", null, contentValues1) == -1L) {
                                                        zzav4.zzu.zzaV().zzb().zzb("Failed to insert raw event (got -1). appId", zzgt.zzl(s15));
                                                    }
                                                    else {
                                                        goto label_368;
                                                    }
                                                }
                                                catch(SQLiteException sQLiteException3) {
                                                    zzav4.zzu.zzaV().zzb().zzc("Error storing raw event. appId", zzgt.zzl(zzbb2.zza), sQLiteException3);
                                                }
                                                this.zzj().zzc();
                                                goto label_370;
                                            label_368:
                                                this.zza = 0L;
                                                this.zzj().zzc();
                                                goto label_370;
                                            }
                                        }
                                    }
                                    else {
                                        v4 = Math.round(f);
                                        if("refund".equals(s3)) {
                                            v4 = -v4;
                                        }
                                    label_61:
                                        if(TextUtils.isEmpty(s4)) {
                                            goto label_93;
                                        }
                                        else {
                                            String s5 = s4.toUpperCase(Locale.US);
                                            if(s5.matches("[A-Z]{3}")) {
                                                zzpm zzpm0 = this.zzj().zzm(s, "_ltv_" + s5);
                                                if(zzpm0 == null) {
                                                label_74:
                                                    zzav zzav0 = this.zzj();
                                                    int v6 = this.zzd().zzm(s, zzfx.zzT);
                                                    Preconditions.checkNotEmpty(s);
                                                    zzav0.zzg();
                                                    zzav0.zzay();
                                                    try {
                                                        zzav0.zze().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like \'!_ltv!_%\' escape \'!\'order by set_timestamp desc limit ?,10);", new String[]{s, s, String.valueOf(v6 - 1)});
                                                    }
                                                    catch(SQLiteException sQLiteException0) {
                                                        zzav0.zzu.zzaV().zzb().zzc("Error pruning currencies. appId", zzgt.zzl(s), sQLiteException0);
                                                    }
                                                    long v7 = this.zzaZ().currentTimeMillis();
                                                    zzbg2 = zzbg1;
                                                    zzpm1 = new zzpm(s, zzbg1.zzc, "_ltv_" + s5, v7, v4);
                                                }
                                                else {
                                                    Object object1 = zzpm0.zze;
                                                    if(object1 instanceof Long) {
                                                        long v5 = this.zzaZ().currentTimeMillis();
                                                        zzbg2 = zzbg1;
                                                        zzpm1 = new zzpm(s, zzbg1.zzc, "_ltv_" + s5, v5, ((long)(((long)(((Long)object1))) + v4)));
                                                        goto label_86;
                                                    }
                                                    goto label_74;
                                                }
                                            label_86:
                                                if(!this.zzj().zzl(zzpm1)) {
                                                    this.zzaV().zzb().zzd("Too many unique user properties are set. Ignoring user property. appId", zzgt.zzl(s), this.zzn.zzl().zzc(zzpm1.zzc), zzpm1.zze);
                                                    this.zzt().zzN(this.zzK, s, 9, null, null, 0);
                                                }
                                            }
                                            else {
                                                zzbg2 = zzbg1;
                                            }
                                        }
                                        goto label_94;
                                    }
                                }
                                else {
                                    v4 = (long)zzbe0.zzb("value");
                                    goto label_61;
                                }
                            }
                            else if(z) {
                                z = true;
                                goto label_49;
                            }
                            else {
                                goto label_93;
                            }
                            goto label_393;
                        }
                        catch(Throwable throwable0) {
                            this.zzj().zzd();
                            throw throwable0;
                        }
                    label_370:
                        this.zzj().zzd();
                        this.zzaK();
                        this.zzaV().zzk().zzb("Background event processing time, ms", ((long)((System.nanoTime() - v + 500000L) / 1000000L)));
                        return;
                        try {
                        label_374:
                            this.zzaV().zzb().zzd("Too many event names used, ignoring event. appId, name, supported count", zzgt.zzl(s), zzib0.zzl().zza(s8), this.zzd().zzh(s));
                            this.zzt().zzN(this.zzK, s, 8, null, null, 0);
                            goto label_393;
                        label_377:
                            if(v13 == 1L) {
                                this.zzaV().zzb().zzc("Too many error events logged. appId, count", zzgt.zzl(s), zzar0.zzd);
                            }
                            this.zzj().zzc();
                            goto label_393;
                        label_381:
                            if(v12 % 1000L == 1L) {
                                this.zzaV().zzb().zzc("Data loss. Too many public events logged. appId, count", zzgt.zzl(s), zzar0.zza);
                            }
                            this.zzt().zzN(this.zzK, s, 16, "_ev", zzbg2.zza, 0);
                            this.zzj().zzc();
                            goto label_393;
                        label_386:
                            if(v10 % 1000L == 1L) {
                                this.zzaV().zzb().zzc("Data loss. Too many events logged. appId, count", zzgt.zzl(s), zzar0.zzb);
                            }
                            this.zzj().zzc();
                        }
                        catch(Throwable throwable0) {
                            this.zzj().zzd();
                            throw throwable0;
                        }
                    label_393:
                        this.zzj().zzd();
                    }
                }
            }
            else if(!"_err".equals(s1)) {
                this.zzt().zzN(this.zzK, s, 11, "_ev", s1, 0);
            }
        }
    }

    public final void zzI(zzh zzh0, zzic zzic0) {
        this.zzaW().zzg();
        this.zzu();
        zzan zzan0 = zzan.zzd(zzic0.zzaA());
        String s = zzh0.zzc();
        this.zzaW().zzg();
        this.zzu();
        zzjk zzjk0 = this.zzB(s);
        switch(zzjk0.zzp().ordinal()) {
            case 1: {
                zzan0.zzc(zzjj.zza, zzam.zzi);
                break;
            }
            case 2: 
            case 3: {
                zzan0.zzb(zzjj.zza, zzjk0.zzb());
                break;
            }
            default: {
                zzan0.zzc(zzjj.zza, zzam.zzj);
            }
        }
        switch(zzjk0.zzq().ordinal()) {
            case 1: {
                zzan0.zzc(zzjj.zzb, zzam.zzi);
                break;
            }
            case 2: 
            case 3: {
                zzan0.zzb(zzjj.zzb, zzjk0.zzb());
                break;
            }
            default: {
                zzan0.zzc(zzjj.zzb, zzam.zzj);
            }
        }
        String s1 = zzh0.zzc();
        this.zzaW().zzg();
        this.zzu();
        zzaz zzaz0 = this.zzz(s1, this.zzx(s1), this.zzB(s1), zzan0);
        zzic0.zzaD(((Boolean)Preconditions.checkNotNull(zzaz0.zzj())).booleanValue());
        if(!TextUtils.isEmpty(zzaz0.zzk())) {
            zzic0.zzaF(zzaz0.zzk());
        }
        this.zzaW().zzg();
        this.zzu();
        for(Object object0: zzic0.zzk()) {
            zziu zziu0 = (zziu)object0;
        }
        int v = this.zzaB(zzh0.zzc(), zzan0);
        zzit zzit0 = zziu.zzm();
        zzit0.zzb("_npa");
        zzit0.zza(this.zzaZ().currentTimeMillis());
        zzit0.zze(((long)v));
        zzic0.zzo(((zziu)zzit0.zzbc()));
        this.zzaV().zzk().zzc("Setting user property", "non_personalized_ads(_npa)", v);
        zzic0.zzaB(zzan0.toString());
        String s2 = zzh0.zzc();
        this.zzc.zzy(s2);
        List list0 = zzic0.zzb();
        for(int v1 = 0; v1 < list0.size(); ++v1) {
        }
    }

    public final void zzJ(zzh zzh0, zzic zzic0) {
        this.zzaW().zzg();
        this.zzu();
        zzgx zzgx0 = com.google.android.gms.internal.measurement.zzha.zzr();
        byte[] arr_b = zzh0.zzaJ();
        if(arr_b != null) {
            try {
                zzgx0 = (zzgx)zzpj.zzw(zzgx0, arr_b);
            }
            catch(zzmq unused_ex) {
                this.zzaV().zze().zzb("Failed to parse locally stored ad campaign info. appId", zzgt.zzl(zzh0.zzc()));
            }
        }
        for(Object object0: zzic0.zzb()) {
            com.google.android.gms.internal.measurement.zzhs zzhs0 = (com.google.android.gms.internal.measurement.zzhs)object0;
        }
        if(!((com.google.android.gms.internal.measurement.zzha)zzgx0.zzbc()).equals(com.google.android.gms.internal.measurement.zzha.zzs())) {
            zzic0.zzaM(((com.google.android.gms.internal.measurement.zzha)zzgx0.zzbc()));
        }
        zzh0.zzaI(((com.google.android.gms.internal.measurement.zzha)zzgx0.zzbc()).zzcc());
        if(zzh0.zza()) {
            this.zzj().zzv(zzh0, false, false);
        }
        if(this.zzd().zzp(null, zzfx.zzbg)) {
            this.zzj().zzk(zzh0.zzc(), "_lgclid");
        }
    }

    public final String zzK(zzjk zzjk0) {
        if(zzjk0.zzo(zzjj.zzb)) {
            byte[] arr_b = new byte[16];
            this.zzt().zzf().nextBytes(arr_b);
            return String.format(Locale.US, "%032x", new BigInteger(1, arr_b));
        }
        return null;
    }

    public final void zzL(List list0) {
        Preconditions.checkArgument(!list0.isEmpty());
        if(this.zzz != null) {
            this.zzaV().zzb().zza("Set uploading progress before finishing the previous upload");
            return;
        }
        this.zzz = new ArrayList(list0);
    }

    public final void zzM() {
        Throwable throwable2;
        SQLiteException sQLiteException2;
        Cursor cursor1;
        this.zzaW().zzg();
        this.zzu();
        this.zzw = true;
        try {
            Boolean boolean0 = this.zzn.zzt().zzJ();
            if(boolean0 == null) {
                this.zzaV().zze().zza("Upload data called on the client side before use of service was decided");
            }
            else if(boolean0.booleanValue()) {
                this.zzaV().zzb().zza("Upload called in the client side when service should be used");
            }
            else if(this.zza > 0L) {
                this.zzaK();
            }
            else {
                this.zzaW().zzg();
                if(this.zzz != null) {
                    this.zzaV().zzk().zza("Uploading requested multiple times");
                }
                else if(this.zzi().zzb()) {
                    long v1 = this.zzaZ().currentTimeMillis();
                    Cursor cursor0 = null;
                    int v2 = this.zzd().zzm(null, zzfx.zzai);
                    this.zzd();
                    long v3 = zzal.zzF();
                    for(int v4 = 0; v4 < v2 && this.zzaF(null, v1 - v3); ++v4) {
                    }
                    zzql.zza();
                    this.zzaW().zzg();
                    this.zzaE();
                    long v5 = this.zzk.zzd.zza();
                    if(v5 != 0L) {
                        this.zzaV().zzj().zzb("Uploading events. Elapsed time since last upload attempt (ms)", Math.abs(v1 - v5));
                    }
                    String s = this.zzj().zzF();
                    long v6 = -1L;
                    if(TextUtils.isEmpty(s)) {
                        this.zzB = -1L;
                        zzav zzav1 = this.zzj();
                        this.zzd();
                        long v7 = zzal.zzF();
                        zzav1.zzg();
                        zzav1.zzay();
                        try {
                            cursor1 = zzav1.zze().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(v1 - v7)});
                        }
                        catch(SQLiteException sQLiteException1) {
                            sQLiteException2 = sQLiteException1;
                            cursor1 = null;
                            goto label_82;
                        }
                        catch(Throwable throwable1) {
                            throwable2 = throwable1;
                            goto label_87;
                        }
                        try {
                            try {
                                if(cursor1.moveToFirst()) {
                                    cursor0 = cursor1.getString(0);
                                }
                                else {
                                    zzav1.zzu.zzaV().zzk().zza("No expired configs for apps with pending events");
                                }
                                goto label_91;
                            }
                            catch(SQLiteException sQLiteException2) {
                            }
                        label_82:
                            zzav1.zzu.zzaV().zzb().zzb("Error selecting expired configs", sQLiteException2);
                            if(cursor1 != null) {
                                goto label_91;
                            }
                            goto label_92;
                        }
                        catch(Throwable throwable2) {
                            cursor0 = cursor1;
                        }
                    label_87:
                        if(cursor0 != null) {
                            cursor0.close();
                        }
                        throw throwable2;
                    label_91:
                        cursor1.close();
                    label_92:
                        if(!TextUtils.isEmpty(((CharSequence)cursor0))) {
                            zzh zzh0 = this.zzj().zzu(((String)cursor0));
                            if(zzh0 != null) {
                                this.zzV(zzh0);
                            }
                        }
                    }
                    else {
                        if(this.zzB == -1L) {
                            zzav zzav0 = this.zzj();
                            try {
                                try {
                                    cursor0 = zzav0.zze().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                                    if(cursor0.moveToFirst()) {
                                        v6 = cursor0.getLong(0);
                                        goto label_55;
                                    }
                                    else {
                                        goto label_57;
                                    }
                                }
                                catch(SQLiteException sQLiteException0) {
                                    zzav0.zzu.zzaV().zzb().zzb("Error querying raw events", sQLiteException0);
                                    if(cursor0 != null) {
                                        goto label_55;
                                    }
                                }
                                goto label_58;
                            }
                            catch(Throwable throwable0) {
                                if(cursor0 != null) {
                                    cursor0.close();
                                }
                                throw throwable0;
                            }
                        label_55:
                            cursor0.close();
                            goto label_58;
                        label_57:
                            cursor0.close();
                        label_58:
                            this.zzB = v6;
                        }
                        this.zzN(s, v1);
                    }
                }
                else {
                    this.zzaV().zzk().zza("Network not connected, ignoring upload request");
                    this.zzaK();
                }
            }
        }
        finally {
            this.zzw = false;
            this.zzaL();
        }
    }

    public final void zzN(String s, long v) {
        String s3;
        Iterator iterator8;
        String s2;
        int v18;
        zzos zzos1;
        int v16;
        boolean z4;
        List list7;
        int v15;
        zzib zzib0;
        zzav zzav1;
        int v10;
        int v9;
        List list6;
        Cursor cursor5;
        zzgr zzgr0;
        Cursor cursor4;
        Cursor cursor3;
        long v6;
        SQLiteDatabase sQLiteDatabase0;
        List list1;
        zzic zzic0;
        byte[] arr_b2;
        int v5;
        byte[] arr_b1;
        ByteArrayOutputStream byteArrayOutputStream0;
        zzpj zzpj0;
        byte[] arr_b;
        long v4;
        int v3;
        List list0;
        Cursor cursor1;
        Cursor cursor0;
        int v1 = this.zzd().zzm(s, zzfx.zzg);
        int v2 = Math.max(0, this.zzd().zzm(s, zzfx.zzh));
        zzav zzav0 = this.zzj();
        zzav0.zzg();
        zzav0.zzay();
        Preconditions.checkArgument(v1 > 0);
        Preconditions.checkArgument(v2 > 0);
        Preconditions.checkNotEmpty(s);
        try {
            cursor0 = null;
            cursor0 = zzav0.zze().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{s}, null, null, "rowid", String.valueOf(v1));
        }
        catch(SQLiteException sQLiteException0) {
            goto label_94;
        }
        catch(Throwable throwable0) {
            cursor1 = null;
            goto label_105;
        }
        try {
            if(cursor0.moveToFirst()) {
                list0 = new ArrayList();
                v3 = 0;
                while(true) {
                label_19:
                    v4 = cursor0.getLong(0);
                    try {
                        arr_b = cursor0.getBlob(1);
                        zzpj0 = zzav0.zzg.zzp();
                        goto label_26;
                    }
                    catch(IOException iOException0) {
                    }
                    goto label_24;
                }
            }
            else {
                list1 = Collections.EMPTY_LIST;
                goto label_108;
            }
            goto label_110;
        }
        catch(SQLiteException sQLiteException0) {
            goto label_92;
        }
        catch(Throwable throwable0) {
            goto label_103;
        }
    label_24:
        Cursor cursor2 = cursor0;
        goto label_79;
        try {
        label_26:
            ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(arr_b);
            GZIPInputStream gZIPInputStream0 = new GZIPInputStream(byteArrayInputStream0);
            byteArrayOutputStream0 = new ByteArrayOutputStream();
            arr_b1 = new byte[0x400];
            ByteArrayInputStream byteArrayInputStream1 = byteArrayInputStream0;
            while(true) {
            label_31:
                v5 = gZIPInputStream0.read(arr_b1);
                if(v5 <= 0) {
                    gZIPInputStream0.close();
                    byteArrayInputStream1.close();
                    arr_b2 = byteArrayOutputStream0.toByteArray();
                    goto label_40;
                }
                goto label_71;
            }
        }
        catch(IOException iOException1) {
            cursor2 = cursor0;
            goto label_76;
            try {
            label_40:
                if(((ArrayList)list0).isEmpty()) {
                    zzic0 = (zzic)zzpj.zzw(zzid.zzaE(), arr_b2);
                label_49:
                    if(((ArrayList)list0).isEmpty()) {
                    label_63:
                        if(!cursor0.isNull(2)) {
                            zzic0.zzao(cursor0.getInt(2));
                        }
                        v3 += arr_b2.length;
                        ((ArrayList)list0).add(Pair.create(((zzid)zzic0.zzbc()), v4));
                        cursor2 = cursor0;
                        goto label_80;
                    }
                    else {
                        zzid zzid0 = (zzid)((Pair)((ArrayList)list0).get(0)).first;
                        zzid zzid1 = (zzid)zzic0.zzbc();
                        if(zzid0.zzao() == zzid1.zzao()) {
                            for(Object object0: zzid0.zzf()) {
                                zziu zziu0 = (zziu)object0;
                            }
                            Iterator iterator1 = zzid1.zzf().iterator();
                            while(true) {
                                if(!iterator1.hasNext()) {
                                    goto label_63;
                                }
                                Object object1 = iterator1.next();
                                zziu zziu1 = (zziu)object1;
                            }
                        }
                    }
                }
                else if(arr_b2.length + v3 <= v2) {
                    try {
                        zzic0 = (zzic)zzpj.zzw(zzid.zzaE(), arr_b2);
                        goto label_49;
                    }
                    catch(IOException iOException2) {
                    }
                    zzav0.zzu.zzaV().zzb().zzc("Failed to merge queued bundle. appId", zzgt.zzl(s), iOException2);
                    cursor2 = cursor0;
                    goto label_80;
                }
                cursor2 = cursor0;
                goto label_83;
            }
            catch(SQLiteException sQLiteException0) {
                goto label_92;
            }
            catch(Throwable throwable0) {
                goto label_103;
            }
            try {
            label_71:
                cursor2 = cursor0;
                byteArrayOutputStream0.write(arr_b1, 0, v5);
                cursor0 = cursor2;
                goto label_31;
            }
            catch(IOException iOException1) {
                try {
                label_76:
                    zzpj0.zzu.zzaV().zzb().zzb("Failed to ungzip content", iOException1);
                    throw iOException1;
                }
                catch(IOException iOException0) {
                }
                catch(SQLiteException sQLiteException0) {
                    goto label_93;
                }
                catch(Throwable throwable0) {
                    goto label_104;
                }
                try {
                label_79:
                    zzav0.zzu.zzaV().zzb().zzc("Failed to unzip queued bundle. appId", zzgt.zzl(s), iOException0);
                label_80:
                    if(!cursor2.moveToNext() || v3 > v2) {
                        goto label_83;
                    }
                    else {
                        cursor0 = cursor2;
                        goto label_19;
                    }
                    goto label_110;
                }
                catch(SQLiteException sQLiteException0) {
                    goto label_93;
                }
                catch(Throwable throwable0) {
                    goto label_104;
                }
                try {
                    cursor0 = cursor2;
                    goto label_19;
                }
                catch(SQLiteException sQLiteException0) {
                    goto label_92;
                }
                catch(Throwable throwable0) {
                    goto label_103;
                }
            label_83:
                cursor2.close();
                goto label_110;
            }
            catch(SQLiteException sQLiteException0) {
                goto label_93;
            }
            catch(Throwable throwable0) {
                goto label_104;
            }
            try {
                list1 = Collections.EMPTY_LIST;
                goto label_108;
            }
            catch(SQLiteException sQLiteException0) {
                goto label_92;
            }
            catch(Throwable throwable0) {
                goto label_103;
            }
        }
        catch(SQLiteException sQLiteException0) {
        label_92:
            cursor2 = cursor0;
        label_93:
            cursor0 = cursor2;
            try {
            label_94:
                zzav0.zzu.zzaV().zzb().zzc("Error querying bundles. appId", zzgt.zzl(s), sQLiteException0);
                list1 = Collections.EMPTY_LIST;
            }
            catch(Throwable throwable0) {
                cursor1 = cursor0;
                goto label_105;
            }
            if(cursor0 != null) {
                goto label_108;
            }
            goto label_109;
        }
        catch(Throwable throwable0) {
        label_103:
            cursor2 = cursor0;
        }
    label_104:
        cursor1 = cursor2;
    label_105:
        if(cursor1 != null) {
            cursor1.close();
        }
        throw throwable0;
    label_108:
        cursor0.close();
    label_109:
        list0 = list1;
    label_110:
        if(!list0.isEmpty()) {
            com.google.android.gms.internal.measurement.zzpk.zza();
            zzal zzal0 = this.zzd();
            zzfw zzfw0 = zzfx.zzbi;
            if(zzal0.zzp(null, zzfw0)) {
                com.google.android.gms.internal.measurement.zzpk.zza();
                if(this.zzd().zzp(null, zzfw0)) {
                    if(this.zzB(s).zzo(zzjj.zzb) || !this.zzh().zzB(s)) {
                        ArrayList arrayList0 = new ArrayList(list0.size());
                        zzav zzav2 = this.zzj();
                        Preconditions.checkNotEmpty(s);
                        zzav2.zzg();
                        zzav2.zzay();
                        List list3 = new ArrayList();
                        try {
                            sQLiteDatabase0 = zzav2.zze();
                            v6 = zzav2.zzu.zzaZ().currentTimeMillis();
                            List list4 = list0;
                            cursor3 = sQLiteDatabase0.query("no_data_mode_events", new String[]{"data"}, "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)", new String[]{s, String.valueOf(v6)}, null, null, "rowid", null);
                            list4 = list0;
                        }
                        catch(SQLiteException sQLiteException2) {
                            cursor4 = null;
                            goto label_193;
                        }
                        catch(Throwable throwable1) {
                            cursor5 = null;
                            goto label_199;
                        }
                        try {
                            if(cursor3.moveToFirst()) {
                                while(true) {
                                    try {
                                    label_164:
                                        byte[] arr_b3 = cursor3.getBlob(0);
                                        ((ArrayList)list3).add(((com.google.android.gms.internal.measurement.zzhs)((zzhr)zzpj.zzw(com.google.android.gms.internal.measurement.zzhs.zzk(), arr_b3)).zzbc()));
                                        cursor4 = cursor3;
                                        goto label_179;
                                    }
                                    catch(zzmq zzmq0) {
                                    }
                                    zzgr0 = zzav2.zzu.zzaV().zzh();
                                    cursor4 = cursor3;
                                    goto label_171;
                                }
                            }
                            else {
                                goto label_202;
                            }
                            goto label_204;
                        }
                        catch(SQLiteException sQLiteException2) {
                            cursor4 = cursor3;
                            goto label_193;
                        }
                        catch(Throwable throwable1) {
                            cursor5 = cursor3;
                            goto label_199;
                        }
                        try {
                        label_171:
                            zzgr0.zzc("Failed to parse stored NO_DATA mode event, appId", zzgt.zzl(s), zzmq0);
                        label_179:
                            if(!cursor4.moveToNext()) {
                                cursor4.close();
                                goto label_181;
                            }
                            cursor3 = cursor4;
                            goto label_164;
                        }
                        catch(SQLiteException sQLiteException2) {
                            goto label_193;
                        }
                        catch(Throwable throwable1) {
                            goto label_198;
                        }
                        try {
                        label_181:
                            int v7 = sQLiteDatabase0.delete("no_data_mode_events", "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)", new String[]{s, String.valueOf(v6)});
                            zzav2.zzu.zzaV().zzk().zzb("Pruned " + v7 + " NO_DATA mode events. appId", s);
                            goto label_204;
                        }
                        catch(SQLiteException sQLiteException2) {
                            cursor4 = null;
                            goto label_193;
                        }
                        catch(Throwable throwable1) {
                            cursor5 = null;
                            goto label_199;
                        }
                        try {
                            cursor3 = cursor4;
                            goto label_164;
                        }
                        catch(SQLiteException sQLiteException2) {
                            try {
                            label_193:
                                zzav2.zzu.zzaV().zzb().zzc("Error flushing NO_DATA mode events. appId", zzgt.zzl(s), sQLiteException2);
                                list3 = Collections.EMPTY_LIST;
                                if(cursor4 != null) {
                                    goto label_203;
                                }
                                goto label_204;
                            }
                            catch(Throwable throwable1) {
                                goto label_198;
                            }
                        }
                        catch(Throwable throwable1) {
                        label_198:
                            cursor5 = cursor4;
                        }
                    label_199:
                        if(cursor5 != null) {
                            cursor5.close();
                        }
                        throw throwable1;
                    label_202:
                        cursor4 = cursor3;
                    label_203:
                        cursor4.close();
                    label_204:
                        boolean z = true;
                        for(Object object4: list4) {
                            zzic zzic1 = (zzic)((zzid)((Pair)object4).first).zzcl();
                            if(z && !list3.isEmpty()) {
                                List list5 = zzic1.zzb();
                                zzic1.zzi();
                                zzic1.zzh(list3);
                                zzic1.zzh(list5);
                                z = false;
                            }
                            zzhh zzhh0 = zzho.zzb();
                            zzgf zzgf0 = this.zzh().zzx(s);
                            ArrayList arrayList1 = new ArrayList();
                            if(zzgf0 != null) {
                                for(Object object5: zzgf0.zza()) {
                                    zzhk zzhk0 = zzhl.zza();
                                    int v8 = ((zzfu)object5).zzb() - 1;
                                    switch(v8) {
                                        case 1: {
                                            list6 = list3;
                                            v9 = 3;
                                            v10 = 2;
                                            break;
                                        }
                                        case 2: {
                                            list6 = list3;
                                            v9 = 3;
                                            v10 = 3;
                                            break;
                                        }
                                        default: {
                                            list6 = list3;
                                            v9 = 3;
                                            switch(v8) {
                                                case 3: {
                                                    v10 = 4;
                                                    break;
                                                }
                                                case 4: {
                                                    v10 = 5;
                                                    break;
                                                }
                                                default: {
                                                    v10 = 1;
                                                }
                                            }
                                        }
                                    }
                                    zzhk0.zza(v10);
                                    int v11 = ((zzfu)object5).zzd() - 1;
                                    if(v11 == 1) {
                                        v9 = 2;
                                    }
                                    else if(v11 != 2) {
                                        v9 = 1;
                                    }
                                    zzhk0.zzb(v9);
                                    arrayList1.add(((zzhl)zzhk0.zzbc()));
                                    list3 = list6;
                                }
                            }
                            zzhh0.zza(arrayList1);
                            zzic1.zzaQ(zzhh0);
                            arrayList0.add(Pair.create(((zzid)zzic1.zzbc()), ((Long)((Pair)object4).second)));
                        }
                        list0 = arrayList0;
                    }
                    else {
                        List list2 = Arrays.asList(new String[]{"_f", "_v", "_cmp"});
                    alab1:
                        for(Object object2: list0) {
                            Pair pair0 = (Pair)object2;
                            try {
                                this.zzj().zzH(((long)(((Long)pair0.second))));
                                Iterator iterator3 = ((zzid)pair0.first).zzc().iterator();
                                while(true) {
                                label_125:
                                    if(!iterator3.hasNext()) {
                                        continue alab1;
                                    }
                                    Object object3 = iterator3.next();
                                    com.google.android.gms.internal.measurement.zzhs zzhs0 = (com.google.android.gms.internal.measurement.zzhs)object3;
                                    if(list2.contains("")) {
                                        zzav1 = this.zzj();
                                        zzav1.zzg();
                                        zzav1.zzay();
                                        Preconditions.checkNotNull(zzhs0);
                                        Preconditions.checkNotEmpty(s);
                                        zzib0 = zzav1.zzu;
                                        zzib0.zzaV().zzk().zzb("Caching events in NO_DATA mode", zzhs0);
                                        ContentValues contentValues0 = new ContentValues();
                                        contentValues0.put("app_id", s);
                                        contentValues0.put("name", "");
                                        contentValues0.put("data", zzhs0.zzcc());
                                        contentValues0.put("timestamp_millis", zzhs0.zzf());
                                        break;
                                    }
                                }
                            }
                            catch(SQLiteException unused_ex) {
                                goto label_147;
                            }
                            try {
                                if(zzav1.zze().insert("no_data_mode_events", null, contentValues0) != -1L) {
                                    goto label_125;
                                }
                                zzib0.zzaV().zzb().zzb("Failed to insert NO_DATA mode event (got -1). appId", zzgt.zzl(s));
                                goto label_125;
                            }
                            catch(SQLiteException sQLiteException1) {
                                try {
                                    zzav1.zzu.zzaV().zzb().zzc("Error storing NO_DATA mode event. appId", zzgt.zzl(s), sQLiteException1);
                                    goto label_125;
                                }
                                catch(SQLiteException unused_ex) {
                                }
                            }
                        label_147:
                            this.zzaV().zzh().zzb("Failed handling NO_DATA mode bundles. appId", s);
                        }
                        list0 = Collections.EMPTY_LIST;
                    }
                }
                if(!list0.isEmpty()) {
                    goto label_259;
                }
            }
            else {
            label_259:
                zzjk zzjk0 = this.zzB(s);
                zzjj zzjj0 = zzjj.zza;
                if(zzjk0.zzo(zzjj0)) {
                    for(Object object6: list0) {
                        zzid zzid2 = (zzid)((Pair)object6).first;
                    }
                }
                zzhz zzhz0 = com.google.android.gms.internal.measurement.zzib.zzh();
                int v12 = list0.size();
                ArrayList arrayList2 = new ArrayList(list0.size());
                int v13 = !this.zzd().zzC(s) || !this.zzB(s).zzo(zzjj0) ? 0 : 1;
                boolean z1 = this.zzB(s).zzo(zzjj0);
                boolean z2 = this.zzB(s).zzo(zzjj.zzb);
                zzqu.zza();
                boolean z3 = this.zzd().zzp(s, zzfx.zzaM);
                zzot zzot0 = this.zzl;
                zzos zzos0 = zzot0.zza(s);
                int v14 = 0;
                while(v14 < v12) {
                    zzic zzic2 = (zzic)((zzid)((Pair)list0.get(v14)).first).zzcl();
                    arrayList2.add(((Long)((Pair)list0.get(v14)).second));
                    this.zzd().zzi();
                    zzic2.zzO(130000L);
                    zzic2.zzs(v);
                    zzic2.zzae(false);
                    if(v13 == 0) {
                        zzic2.zzan();
                    }
                    if(!z1) {
                        zzic2.zzR();
                        zzic2.zzU();
                    }
                    if(!z2) {
                        zzic2.zzX();
                    }
                    this.zzS(s, zzic2);
                    if(!z3) {
                        zzic2.zzav();
                    }
                    if(!z2) {
                        zzic2.zzag();
                    }
                    String s1 = zzic2.zzP();
                    if(TextUtils.isEmpty(s1) || s1.equals("00000000-0000-0000-0000-000000000000")) {
                        v15 = v13;
                        for(Object object7: new ArrayList(zzic2.zzb())) {
                            com.google.android.gms.internal.measurement.zzhs zzhs1 = (com.google.android.gms.internal.measurement.zzhs)object7;
                        }
                    }
                    else {
                        v15 = v13;
                    }
                    list7 = list0;
                    z4 = z3;
                    v16 = v14;
                    if(zzic2.zzc() != 0) {
                        if(this.zzd().zzp(s, zzfx.zzaC)) {
                            byte[] arr_b4 = ((zzid)zzic2.zzbc()).zzcc();
                            zzic2.zzas(this.zzp().zzt(arr_b4));
                        }
                        zzis zzis0 = zzos0.zzd();
                        if(zzis0 != null) {
                            zzic2.zzaN(zzis0);
                        }
                        zzhz0.zze(zzic2);
                    }
                    v14 = v16 + 1;
                    v13 = v15;
                    z3 = z4;
                    list0 = list7;
                }
                if(zzhz0.zzb() == 0) {
                    this.zzL(arrayList2);
                    this.zzU(false, 204, null, null, s, Collections.EMPTY_LIST);
                    return;
                }
                com.google.android.gms.internal.measurement.zzib zzib1 = (com.google.android.gms.internal.measurement.zzib)zzhz0.zzbc();
                ArrayList arrayList3 = new ArrayList();
                int v17 = zzos0.zzc() == zzlr.zzd ? 1 : 0;
                if(zzos0.zzc() == zzlr.zzc) {
                    v18 = v17;
                    s2 = null;
                    iterator8 = ((com.google.android.gms.internal.measurement.zzib)zzhz0.zzbc()).zza().iterator();
                label_344:
                    while(iterator8.hasNext()) {
                        Object object8 = iterator8.next();
                        if(((zzid)object8).zzY()) {
                            s2 = "b5f07e46-b1fc-4aee-b43a-d2b727802be3";
                            break;
                        }
                    }
                    com.google.android.gms.internal.measurement.zzib zzib2 = (com.google.android.gms.internal.measurement.zzib)zzhz0.zzbc();
                    this.zzaW().zzg();
                    this.zzu();
                    zzhz zzhz1 = com.google.android.gms.internal.measurement.zzib.zzi(zzib2);
                    if(!TextUtils.isEmpty(s2)) {
                        zzhz1.zzi(s2);
                    }
                    String s4 = this.zzh().zzc(s);
                    if(!TextUtils.isEmpty(s4)) {
                        zzhz1.zzj(s4);
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for(Object object9: zzib2.zza()) {
                        zzic zzic3 = zzid.zzaF(((zzid)object9));
                        zzic3.zzan();
                        arrayList4.add(((zzid)zzic3.zzbc()));
                    }
                    zzhz1.zzg();
                    zzhz1.zzf(arrayList4);
                    this.zzaV().zzk().zzb("[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: ", (TextUtils.isEmpty(s2) ? "null" : zzhz1.zzh()));
                    com.google.android.gms.internal.measurement.zzib zzib3 = (com.google.android.gms.internal.measurement.zzib)zzhz1.zzbc();
                    if(TextUtils.isEmpty(s2)) {
                        s3 = null;
                    }
                    else {
                        com.google.android.gms.internal.measurement.zzib zzib4 = (com.google.android.gms.internal.measurement.zzib)zzhz0.zzbc();
                        this.zzaW().zzg();
                        this.zzu();
                        zzhz zzhz2 = com.google.android.gms.internal.measurement.zzib.zzh();
                        this.zzaV().zzk().zzb("[sgtm] Processing Google Signal, sgtmJoinId:", s2);
                        zzhz2.zzi(s2);
                        for(Object object10: zzib4.zza()) {
                            zzic zzic4 = zzid.zzaE();
                            zzic4.zzam("");
                            zzic4.zzaJ(((zzid)object10).zzav());
                            zzhz2.zze(zzic4);
                        }
                        s3 = null;
                        com.google.android.gms.internal.measurement.zzib zzib5 = (com.google.android.gms.internal.measurement.zzib)zzhz2.zzbc();
                        String s5 = zzot0.zzg.zzh().zzc(s);
                        if(TextUtils.isEmpty(s5)) {
                            zzos1 = new zzos("https://app-measurement.com/s/d", Collections.EMPTY_MAP, (v18 == 0 ? zzlr.zzb : zzlr.zze), null);
                        }
                        else {
                            Uri uri0 = Uri.parse("https://app-measurement.com/s/d");
                            Uri.Builder uri$Builder0 = uri0.buildUpon();
                            uri$Builder0.authority(s5 + "." + uri0.getAuthority());
                            zzos1 = new zzos(uri$Builder0.build().toString(), Collections.EMPTY_MAP, (v18 == 0 ? zzlr.zzb : zzlr.zze), null);
                        }
                        arrayList3.add(Pair.create(zzib5, zzos1));
                    }
                    if(v18 == 0) {
                        zzib1 = zzib3;
                    label_418:
                        if(this.zzi().zzb()) {
                            if(Log.isLoggable(this.zzaV().zzn(), 2)) {
                                s3 = this.zzp().zzi(zzib1);
                            }
                            this.zzp();
                            byte[] arr_b5 = zzib1.zzcc();
                            this.zzL(arrayList2);
                            this.zzk.zze.zzb(v);
                            this.zzaV().zzk().zzd("Uploading data. app, uncompressed size, data", s, ((int)arr_b5.length), s3);
                            this.zzv = true;
                            this.zzi().zzc(s, zzos0, zzib1, new zzov(this, s, arrayList3));
                        }
                    }
                    else {
                        zzhz zzhz3 = (zzhz)zzib3.zzcl();
                        for(int v19 = 0; v19 < zzib3.zzb(); ++v19) {
                            zzic zzic5 = (zzic)zzib3.zzc(v19).zzcl();
                            zzic5.zzt();
                            zzic5.zzaO(v);
                            zzhz3.zzd(v19, zzic5);
                        }
                        arrayList3.add(Pair.create(((com.google.android.gms.internal.measurement.zzib)zzhz3.zzbc()), zzos0));
                        this.zzL(arrayList2);
                        this.zzU(false, 204, null, null, s, arrayList3);
                        if(this.zzO(s, zzos0.zza())) {
                            this.zzaV().zzk().zzb("[sgtm] Sending sgtm batches available notification to app", s);
                            Intent intent0 = new Intent();
                            intent0.setAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
                            intent0.setPackage(s);
                            zzpf.zzaP(this.zzn.zzaY(), intent0);
                        }
                    }
                }
                else if(v17 != 0) {
                    v18 = 1;
                    s2 = null;
                    iterator8 = ((com.google.android.gms.internal.measurement.zzib)zzhz0.zzbc()).zza().iterator();
                    goto label_344;
                }
                else {
                    s3 = null;
                    goto label_418;
                }
            }
        }
    }

    public final boolean zzO(String s, String s1) {
        zzh zzh0 = this.zzj().zzu(s);
        if(zzh0 != null && this.zzt().zzaa(s, zzh0.zzay())) {
            this.zzF.remove(s1);
            return true;
        }
        zzpd zzpd0 = (zzpd)this.zzF.get(s1);
        return zzpd0 == null ? true : zzpd0.zzb();
    }

    public final void zzP(String s) {
        this.zzaW().zzg();
        this.zzu();
        this.zzw = true;
        try {
            Boolean boolean0 = this.zzn.zzt().zzJ();
            if(boolean0 == null) {
                this.zzaV().zze().zza("Upload data called on the client side before use of service was decided");
            }
            else if(boolean0.booleanValue()) {
                this.zzaV().zzb().zza("Upload called in the client side when service should be used");
            }
            else if(this.zza > 0L) {
                this.zzaK();
            }
            else if(!this.zzi().zzb()) {
                this.zzaV().zzk().zza("Network not connected, ignoring upload request");
                this.zzaK();
            }
            else if(this.zzj().zzD(s)) {
                zzav zzav0 = this.zzj();
                Preconditions.checkNotEmpty(s);
                zzav0.zzg();
                zzav0.zzay();
                List list0 = zzav0.zzC(s, zzon.zza(new zzlr[]{zzlr.zzb}), 1);
                zzpi zzpi0 = list0.isEmpty() ? null : ((zzpi)list0.get(0));
                if(zzpi0 != null) {
                    com.google.android.gms.internal.measurement.zzib zzib0 = zzpi0.zzd();
                    if(zzib0 != null) {
                        this.zzaV().zzk().zzd("[sgtm] Uploading data from upload queue. appId, type, url", s, zzpi0.zzf(), zzpi0.zze());
                        byte[] arr_b = zzib0.zzcc();
                        if(Log.isLoggable(this.zzaV().zzn(), 2)) {
                            String s1 = this.zzp().zzi(zzib0);
                            this.zzaV().zzk().zzd("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", s, ((int)arr_b.length), s1);
                        }
                        zzos zzos0 = zzpi0.zza();
                        this.zzv = true;
                        this.zzi().zzc(s, zzos0, zzib0, new zzow(this, s, zzpi0));
                    }
                }
            }
            else {
                this.zzaV().zzk().zzb("[sgtm] Upload queue has no batches for appId", s);
            }
        }
        finally {
            this.zzw = false;
            this.zzaL();
        }
    }

    public final void zzQ(String s, int v, Throwable throwable0, byte[] arr_b, zzpi zzpi0) {
        this.zzaW().zzg();
        this.zzu();
        try {
            if(arr_b == null) {
                arr_b = new byte[0];
            }
            if(v == 200) {
            label_8:
                if(throwable0 == null) {
                    this.zzj().zzE(zzpi0.zzc());
                    this.zzaV().zzk().zzc("Successfully uploaded batch from upload queue. appId, status", s, v);
                    if(!this.zzi().zzb() || !this.zzj().zzD(s)) {
                        this.zzaK();
                    }
                    else {
                        this.zzP(s);
                    }
                }
                else {
                label_16:
                    String s1 = new String(arr_b, StandardCharsets.UTF_8);
                    String s2 = s1.substring(0, Math.min(0x20, s1.length()));
                    zzgr zzgr0 = this.zzaV().zzh();
                    Integer integer0 = v;
                    if(throwable0 == null) {
                        throwable0 = s2;
                    }
                    zzgr0.zzd("Network upload failed. Will retry later. appId, status, error", s, integer0, throwable0);
                    this.zzj().zzK(zzpi0.zzc());
                    this.zzaK();
                }
            }
            else if(v == 204) {
                v = 204;
                goto label_8;
            }
            else {
                goto label_16;
            }
        }
        finally {
            this.zzv = false;
            this.zzaL();
        }
    }

    public final void zzR(String s, boolean z, Long long0, Long long1) {
        zzh zzh0 = this.zzj().zzu(s);
        if(zzh0 != null) {
            zzh0.zzar(z);
            zzh0.zzat(long0);
            zzh0.zzav(long1);
            if(zzh0.zza()) {
                this.zzj().zzv(zzh0, false, false);
            }
        }
    }

    public final void zzS(String s, zzic zzic0) {
        Set set0 = this.zzh().zzl(s);
        if(set0 != null) {
            zzic0.zzaw(set0);
        }
        if(this.zzh().zzp(s)) {
            zzic0.zzG();
        }
        if(this.zzh().zzq(s)) {
            String s1 = zzic0.zzD();
            if(!TextUtils.isEmpty(s1)) {
                int v = s1.indexOf(".");
                if(v != -1) {
                    zzic0.zzE(s1.substring(0, v));
                }
            }
        }
        if(this.zzh().zzr(s)) {
            int v1 = zzpj.zzx(zzic0, "_id");
            if(v1 != -1) {
                zzic0.zzr(v1);
            }
        }
        if(this.zzh().zzs(s)) {
            zzic0.zzan();
        }
        if(this.zzh().zzt(s)) {
            zzic0.zzX();
            if(this.zzB(s).zzo(zzjj.zzb)) {
                Map map0 = this.zzE;
                zzpc zzpc0 = (zzpc)map0.get(s);
                if(zzpc0 == null) {
                    zzpc0 = new zzpc(this, null);
                    map0.put(s, zzpc0);
                }
                else {
                    long v2 = zzpc0.zzb;
                    if(this.zzd().zzl(s, zzfx.zzak) + v2 < this.zzaZ().elapsedRealtime()) {
                        zzpc0 = new zzpc(this, null);
                        map0.put(s, zzpc0);
                    }
                }
                zzic0.zzax(zzpc0.zza);
            }
        }
        if(this.zzh().zzu(s)) {
            zzic0.zzav();
        }
    }

    public final void zzT(String s, zzhv zzhv0, Bundle bundle0, String s1) {
        List list0 = CollectionUtils.listOf(new String[]{"_o", "_sn", "_sc", "_si"});
        int v = zzpo.zzZ(zzhv0.zza()) || zzpo.zzZ(s) ? this.zzd().zzf(s1, true) : this.zzd().zze(s1, true);
        long v1 = (long)zzhv0.zzc().codePointCount(0, zzhv0.zzc().length());
        zzpo zzpo0 = this.zzt();
        String s2 = zzhv0.zza();
        this.zzd();
        String s3 = zzpo0.zzC(s2, 40, true);
        if(v1 > ((long)v) && !list0.contains(zzhv0.zza())) {
            if("_ev".equals(zzhv0.zza())) {
                bundle0.putString("_ev", this.zzt().zzC(zzhv0.zzc(), this.zzd().zzf(s1, true), true));
                return;
            }
            this.zzaV().zzh().zzc("Param value is too long; discarded. Name, value length", s3, v1);
            if(bundle0.getLong("_err") == 0L) {
                bundle0.putLong("_err", 4L);
                if(bundle0.getString("_ev") == null) {
                    bundle0.putString("_ev", s3);
                    bundle0.putLong("_el", v1);
                }
            }
            bundle0.remove(zzhv0.zza());
        }
    }

    public final void zzU(boolean z, int v, Throwable throwable0, byte[] arr_b, String s, List list0) {
        Integer integer0;
        this.zzaW().zzg();
        this.zzu();
        try {
            byte[] arr_b1 = arr_b == null ? new byte[0] : arr_b;
            List list1 = (List)Preconditions.checkNotNull(this.zzz);
            this.zzz = null;
            if(!z) {
                integer0 = v;
                this.zzaV().zzk().zzc("Network upload successful with code, uploadAttempted", integer0, Boolean.FALSE);
                try {
                label_24:
                    if(z) {
                        this.zzk.zzd.zzb(this.zzaZ().currentTimeMillis());
                    }
                    this.zzk.zze.zzb(0L);
                    this.zzaK();
                    if(z) {
                        this.zzaV().zzk().zzc("Successful upload. Got network response. code, size", integer0, ((int)arr_b1.length));
                    }
                    else {
                        this.zzaV().zzk().zza("Purged empty bundles");
                    }
                    this.zzj().zzb();
                }
                catch(SQLiteException sQLiteException0) {
                    this.zzaV().zzb().zzb("Database error while trying to delete uploaded bundles", sQLiteException0);
                    this.zza = this.zzaZ().elapsedRealtime();
                    this.zzaV().zzk().zzb("Disable upload, time", this.zza);
                    return;
                }
                try {
                    HashMap hashMap0 = new HashMap();
                    for(Object object0: list0) {
                        com.google.android.gms.internal.measurement.zzib zzib0 = (com.google.android.gms.internal.measurement.zzib)((Pair)object0).first;
                        zzos zzos0 = (zzos)((Pair)object0).second;
                        if(zzos0.zzc() != zzlr.zzd) {
                            this.zzj().zzA(s, zzib0, zzos0.zza(), zzos0.zzb(), zzos0.zzc(), null);
                        }
                    }
                    for(Object object1: list0) {
                        com.google.android.gms.internal.measurement.zzib zzib1 = (com.google.android.gms.internal.measurement.zzib)((Pair)object1).first;
                        zzos zzos1 = (zzos)((Pair)object1).second;
                        if(zzos1.zzc() == zzlr.zzd) {
                            Object object2 = hashMap0.get("");
                            this.zzj().zzA(s, zzib1, zzos1.zza(), zzos1.zzb(), zzos1.zzc(), ((Long)object2));
                        }
                    }
                    List list2 = this.zzj().zzC(s, zzon.zza(new zzlr[]{zzlr.zzd}), 1);
                    if(!list2.isEmpty()) {
                        long v2 = ((zzpi)list2.get(0)).zzg();
                        if(this.zzaZ().currentTimeMillis() > ((long)(((Long)zzfx.zzE.zzb(null)))) + v2) {
                            this.zzaV().zze().zzc("[sgtm] client batches are queued too long. appId, creationTime", s, v2);
                        }
                    }
                    for(Object object3: list1) {
                        Long long0 = (Long)object3;
                        try {
                            this.zzj().zzH(((long)long0));
                        }
                        catch(SQLiteException sQLiteException1) {
                            if(this.zzA == null || !this.zzA.contains(long0)) {
                                throw sQLiteException1;
                            }
                            if(false) {
                                break;
                            }
                        }
                    }
                    this.zzj().zzc();
                    goto label_72;
                }
                catch(Throwable throwable1) {
                }
                try {
                    this.zzj().zzd();
                    throw throwable1;
                label_72:
                    this.zzj().zzd();
                    this.zzA = null;
                    if(this.zzi().zzb() && this.zzj().zzD(s)) {
                        this.zzP(s);
                    }
                    else if(this.zzi().zzb() && this.zzaI()) {
                        this.zzM();
                    }
                    else {
                        this.zzB = -1L;
                        this.zzaK();
                    }
                    this.zza = 0L;
                    return;
                }
                catch(SQLiteException sQLiteException0) {
                }
                this.zzaV().zzb().zzb("Database error while trying to delete uploaded bundles", sQLiteException0);
                this.zza = this.zzaZ().elapsedRealtime();
                this.zzaV().zzk().zzb("Disable upload, time", this.zza);
            }
            else if(v == 200) {
            label_10:
                if(throwable0 == null) {
                    integer0 = v;
                    this.zzaV().zzk().zzc("Network upload successful with code, uploadAttempted", integer0, Boolean.TRUE);
                    goto label_24;
                }
                else {
                label_11:
                    String s1 = new String(arr_b1, StandardCharsets.UTF_8);
                    this.zzaV().zzh().zzd("Network upload failed. Will retry later. code, error", v, throwable0, s1.substring(0, Math.min(0x20, s1.length())));
                    this.zzk.zze.zzb(this.zzaZ().currentTimeMillis());
                    if(v == 429 || v == 503) {
                        this.zzk.zzc.zzb(this.zzaZ().currentTimeMillis());
                    }
                    this.zzj().zzJ(list1);
                    this.zzaK();
                }
            }
            else if(v == 204) {
                v = 204;
                goto label_10;
            }
            else {
                goto label_11;
            }
        }
        finally {
            this.zzv = false;
            this.zzaL();
        }
    }

    public final void zzV(zzh zzh0) {
        this.zzaW().zzg();
        if(TextUtils.isEmpty(zzh0.zzf())) {
            this.zzW(((String)Preconditions.checkNotNull(zzh0.zzc())), 204, null, null, null);
            return;
        }
        String s = (String)Preconditions.checkNotNull(zzh0.zzc());
        this.zzaV().zzk().zzb("Fetching remote configuration", s);
        zzgl zzgl0 = this.zzh().zzb(s);
        String s1 = this.zzh().zzd(s);
        Map map0 = null;
        if(zzgl0 != null) {
            if(!TextUtils.isEmpty(s1)) {
                map0 = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
                ((V)map0).put("If-Modified-Since", s1);
            }
            String s2 = this.zzh().zze(s);
            if(!TextUtils.isEmpty(s2)) {
                if(map0 == null) {
                    map0 = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
                }
                map0.put("If-None-Match", s2);
            }
        }
        this.zzu = true;
        this.zzi().zzd(zzh0, map0, (String s, int v, Throwable throwable0, byte[] arr_b, Map map0) -> {
            boolean z;
            this.zzaW().zzg();
            this.zzu();
            Preconditions.checkNotEmpty(s);
            try {
                if(arr_b == null) {
                    arr_b = new byte[0];
                }
                zzgr zzgr0 = this.zzaV().zzk();
                Integer integer0 = (int)arr_b.length;
                zzgr0.zzb("onConfigFetched. Response size", integer0);
                this.zzj().zzb();
                try {
                    zzh zzh0 = this.zzj().zzu(s);
                    switch(v) {
                        case 200: 
                        case 204: {
                            z = throwable0 == null;
                            break;
                        }
                        case 304: {
                            v = 304;
                            z = throwable0 == null;
                            break;
                        }
                        default: {
                            z = false;
                        }
                    }
                    if(zzh0 == null) {
                        this.zzaV().zze().zzb("App does not exist in onConfigFetched. appId", zzgt.zzl(s));
                    }
                    else if(z || v == 404) {
                        String s1 = zzpf.zzaJ(map0, "Last-Modified");
                        String s2 = zzpf.zzaJ(map0, "ETag");
                        if(v != 304 && v != 404) {
                            this.zzh().zzi(s, arr_b, s1, s2);
                        }
                        else if(this.zzh().zzb(s) == null) {
                            this.zzh().zzi(s, null, null, null);
                        }
                        zzh0.zzI(this.zzaZ().currentTimeMillis());
                        this.zzj().zzv(zzh0, false, false);
                        if(v == 404) {
                            this.zzaV().zzh().zzb("Config not found. Using empty config. appId", s);
                        }
                        else {
                            this.zzaV().zzk().zzc("Successfully fetched config. Got network response. code, size", v, integer0);
                        }
                        if(this.zzi().zzb() && this.zzaI()) {
                            this.zzM();
                        }
                        else if(this.zzi().zzb() && this.zzj().zzD(zzh0.zzc())) {
                            this.zzP(zzh0.zzc());
                        }
                        else {
                            this.zzaK();
                        }
                    }
                    else {
                        zzh0.zzK(this.zzaZ().currentTimeMillis());
                        this.zzj().zzv(zzh0, false, false);
                        this.zzaV().zzk().zzc("Fetching config failed. code, error", v, throwable0);
                        this.zzh().zzf(s);
                        this.zzk.zze.zzb(this.zzaZ().currentTimeMillis());
                        if(v == 429 || v == 503) {
                            this.zzk.zzc.zzb(this.zzaZ().currentTimeMillis());
                        }
                        this.zzaK();
                    }
                    this.zzj().zzc();
                }
                catch(Throwable throwable1) {
                    this.zzj().zzd();
                    throw throwable1;
                }
                this.zzj().zzd();
            }
            finally {
                this.zzu = false;
                this.zzaL();
            }
        });
    }

    // 检测为 Lambda 实现
    public final void zzW(String s, int v, Throwable throwable0, byte[] arr_b, Map map0) [...]

    public final void zzX(Runnable runnable0) {
        this.zzaW().zzg();
        if(this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable0);
    }

    public final void zzY() {
        this.zzaW().zzg();
        this.zzu();
        if(!this.zzp) {
            this.zzp = true;
            if(this.zzZ()) {
                FileChannel fileChannel0 = this.zzy;
                this.zzaW().zzg();
                int v = 0;
                if(fileChannel0 == null || !fileChannel0.isOpen()) {
                    this.zzaV().zzb().zza("Bad channel to read from");
                }
                else {
                    ByteBuffer byteBuffer0 = ByteBuffer.allocate(4);
                    try {
                        fileChannel0.position(0L);
                        int v1 = fileChannel0.read(byteBuffer0);
                        if(v1 == 4) {
                            byteBuffer0.flip();
                            v = byteBuffer0.getInt();
                        }
                        else if(v1 != -1) {
                            this.zzaV().zze().zzb("Unexpected data length. Bytes read", v1);
                        }
                        goto label_23;
                    }
                    catch(IOException iOException0) {
                    }
                    this.zzaV().zzb().zzb("Failed to read from channel", iOException0);
                }
            label_23:
                int v2 = this.zzn.zzv().zzm();
                this.zzaW().zzg();
                if(v > v2) {
                    this.zzaV().zzb().zzc("Panic: can\'t downgrade version. Previous, current version", v, v2);
                    return;
                }
                if(v < v2) {
                    FileChannel fileChannel1 = this.zzy;
                    this.zzaW().zzg();
                    if(fileChannel1 != null && fileChannel1.isOpen()) {
                        ByteBuffer byteBuffer1 = ByteBuffer.allocate(4);
                        byteBuffer1.putInt(v2);
                        byteBuffer1.flip();
                        try {
                            fileChannel1.truncate(0L);
                            fileChannel1.write(byteBuffer1);
                            fileChannel1.force(true);
                            if(fileChannel1.size() != 4L) {
                                this.zzaV().zzb().zzb("Error writing to channel. Bytes written", fileChannel1.size());
                            }
                        }
                        catch(IOException iOException1) {
                            this.zzaV().zzb().zzb("Failed to write to channel", iOException1);
                            this.zzaV().zzb().zzc("Storage version upgrade failed. Previous, current version", v, v2);
                            return;
                        }
                        this.zzaV().zzk().zzc("Storage version upgraded. Previous, current version", v, v2);
                        return;
                    }
                    this.zzaV().zzb().zza("Bad channel to read from");
                    this.zzaV().zzb().zzc("Storage version upgrade failed. Previous, current version", v, v2);
                }
            }
        }
    }

    public final boolean zzZ() {
        this.zzaW().zzg();
        if(this.zzx != null && this.zzx.isValid()) {
            this.zzaV().zzk().zza("Storage concurrent access okay");
            return true;
        }
        File file0 = new File(new File(this.zzn.zzaY().getFilesDir(), "google_app_measurement.db").getPath());
        try {
            FileChannel fileChannel0 = new RandomAccessFile(file0, "rw").getChannel();
            this.zzy = fileChannel0;
            FileLock fileLock0 = fileChannel0.tryLock();
            this.zzx = fileLock0;
            if(fileLock0 != null) {
                this.zzaV().zzk().zza("Storage concurrent access okay");
                return true;
            }
            this.zzaV().zzb().zza("Storage concurrent data access panic");
            return false;
        }
        catch(FileNotFoundException fileNotFoundException0) {
        }
        catch(IOException iOException0) {
            this.zzaV().zzb().zzb("Failed to access storage lock file", iOException0);
            return false;
        }
        catch(OverlappingFileLockException overlappingFileLockException0) {
            this.zzaV().zze().zzb("Storage lock already acquired", overlappingFileLockException0);
            return false;
        }
        this.zzaV().zzb().zzb("Failed to acquire storage lock", fileNotFoundException0);
        return false;
    }

    public static zzpf zza(Context context0) {
        Preconditions.checkNotNull(context0);
        Preconditions.checkNotNull(context0.getApplicationContext());
        if(zzpf.zzb == null) {
            synchronized(zzpf.class) {
                if(zzpf.zzb == null) {
                    zzpf.zzb = new zzpf(((zzpg)Preconditions.checkNotNull(new zzpg(context0))), null);
                }
            }
        }
        return zzpf.zzb;
    }

    public static final void zzaA(zzhr zzhr0, String s) {
        List list0 = zzhr0.zza();
        for(int v = 0; v < list0.size(); ++v) {
            if(s.equals("")) {
                zzhr0.zzj(v);
                return;
            }
        }
    }

    private final int zzaB(String s, zzan zzan0) {
        zzhs zzhs0 = this.zzc;
        if(zzhs0.zzx(s) == null) {
            zzan0.zzc(zzjj.zzd, zzam.zzj);
            return 1;
        }
        zzh zzh0 = this.zzj().zzu(s);
        if(zzh0 != null && zze.zzc(zzh0.zzaH()).zza() == zzjh.zzb) {
            zzjj zzjj0 = zzjj.zzd;
            zzjh zzjh0 = zzhs0.zzA(s, zzjj0);
            if(zzjh0 != zzjh.zza) {
                zzan0.zzc(zzjj0, zzam.zzi);
                return zzjh0 == zzjh.zzd ? 0 : 1;
            }
        }
        zzan0.zzc(zzjj.zzd, zzam.zzb);
        return zzhs0.zzv(s, zzjj.zzd) ? 0 : 1;
    }

    private final Map zzaC(com.google.android.gms.internal.measurement.zzhs zzhs0) {
        Map map0 = new HashMap();
        this.zzp();
        for(Object object0: zzpj.zzH(zzhs0, "gad_").entrySet()) {
            ((HashMap)map0).put(((String)((Map.Entry)object0).getKey()), String.valueOf(((Map.Entry)object0).getValue()));
        }
        return map0;
    }

    private final zzay zzaD() {
        if(this.zzI == null) {
            this.zzI = new zzox(this, this.zzn);
        }
        return this.zzI;
    }

    private final void zzaE() {
        this.zzaW().zzg();
        if(!this.zzr.isEmpty() && !this.zzaD().zzc()) {
            long v = this.zzaZ().elapsedRealtime() - this.zzJ;
            long v1 = Math.max(0L, ((long)(((int)(((Integer)zzfx.zzaB.zzb(null)))))) - v);
            this.zzaV().zzk().zzb("Scheduling notify next app runnable, delay in ms", v1);
            this.zzaD().zzb(v1);
        }
    }

    private final boolean zzaF(String s, long v) {
        boolean z6;
        long v26;
        zzic zzic1;
        Long long9;
        int v25;
        long v24;
        Long long5;
        long v21;
        Long long4;
        int v20;
        SecureRandom secureRandom1;
        HashMap hashMap1;
        Long long3;
        boolean z4;
        boolean z3;
        int v9;
        int v8;
        boolean z1;
        this.zzj().zzb();
        try {
            zzpb zzpb0 = new zzpb(this, null);
            this.zzj().zzav(s, v, this.zzB, zzpb0);
            if(zzpb0.zzc == null || zzpb0.zzc.isEmpty()) {
                this.zzj().zzc();
                z6 = false;
            }
            else {
                zzic zzic0 = (zzic)zzpb0.zza.zzcl();
                zzic0.zzi();
                zzhr zzhr0 = null;
                zzhr zzhr1 = null;
                int v2 = -1;
                int v3 = -1;
                int v4 = 0;
                int v5 = 0;
                int v6 = 0;
                boolean z = false;
                while(true) {
                    int v7 = v6;
                    z1 = z;
                    if(v4 >= zzpb0.zzc.size()) {
                        break;
                    }
                    zzhr zzhr2 = (zzhr)((com.google.android.gms.internal.measurement.zzhs)zzpb0.zzc.get(v4)).zzcl();
                    if(this.zzh().zzj("", zzhr2.zzk())) {
                        zzgr zzgr0 = this.zzaV().zze();
                        Object object0 = zzgt.zzl("");
                        String s1 = zzhr2.zzk();
                        zzgr0.zzc("Dropping blocked raw event. appId", object0, this.zzn.zzl().zza(s1));
                        if(!this.zzh().zzn("") && !this.zzh().zzo("") && !"_err".equals(zzhr2.zzk())) {
                            zzpo zzpo0 = this.zzt();
                            String s2 = zzhr2.zzk();
                            zzpo0.zzN(this.zzK, "", 11, "_ev", s2, 0);
                        }
                        v8 = v4;
                    }
                    else {
                        String s3 = zzhr2.zzk();
                        if(s3.equals("purchase") || (s3.equals("_iap") || s3.equals("ecommerce_purchase"))) {
                            zzhv zzhv0 = zzhw.zzn();
                            v9 = v2;
                            zzhv0.zzb("_ct");
                            zzhv0.zzd((v7 != 0 || (!this.zzaO("", "purchase") || !this.zzaO("", "_iap")) || !this.zzaO("", "ecommerce_purchase") ? "returning" : "new"));
                            zzhr2.zzf(((zzhw)zzhv0.zzbc()));
                            v7 = 1;
                        }
                        else {
                            v9 = v2;
                        }
                        if(zzhr2.zzk().equals("ad_impression")) {
                            zzhr2.zzl("_ai");
                            this.zzaV().zzk().zza("Renaming ad_impression to _ai");
                            if(Log.isLoggable(this.zzaV().zzn(), 5)) {
                                for(int v10 = 0; v10 < zzhr2.zzb(); ++v10) {
                                }
                            }
                        }
                        boolean z2 = this.zzh().zzk("", zzhr2.zzk());
                        if(z2) {
                            int v11 = 0;
                            while(true) {
                                z4 = z2;
                                if(v11 >= zzhr2.zzb()) {
                                    break;
                                }
                                ++v11;
                                z2 = z4;
                            }
                            if(z4) {
                                zzgr zzgr1 = this.zzaV().zzk();
                                String s5 = zzhr2.zzk();
                                zzgr1.zzb("Marking event as conversion", this.zzn.zzl().zza(s5));
                                zzhv zzhv1 = zzhw.zzn();
                                zzhv1.zzb("_c");
                                zzhv1.zzf(1L);
                                zzhr2.zzg(zzhv1);
                            }
                            zzgr zzgr2 = this.zzaV().zzk();
                            String s6 = zzhr2.zzk();
                            zzgr2.zzb("Marking event as real-time", this.zzn.zzl().zza(s6));
                            zzhv zzhv2 = zzhw.zzn();
                            zzhv2.zzb("_r");
                            zzhv2.zzf(1L);
                            zzhr2.zzg(zzhv2);
                            if(this.zzj().zzw(this.zzC(), "", false, false, false, false, true, false, false).zze > ((long)this.zzd().zzm("", zzfx.zzo))) {
                                zzpf.zzaA(zzhr2, "_r");
                                z3 = z1;
                            }
                            else {
                                z3 = true;
                            }
                            if(zzpo.zzh(zzhr2.zzk()) && z4 && this.zzj().zzw(this.zzC(), "", false, false, true, false, false, false, false).zzc > ((long)this.zzd().zzm("", zzfx.zzn))) {
                                this.zzaV().zze().zzb("Too many conversions. Not logging as conversion. appId", zzgt.zzl(""));
                                for(int v12 = 0; v12 < zzhr2.zzb(); ++v12) {
                                    zzhr2.zzc(v12);
                                }
                                this.zzaV().zzb().zzb("Did not find conversion parameter. appId", zzgt.zzl(""));
                            }
                        }
                        else {
                            this.zzp();
                            String s4 = zzhr2.zzk();
                            Preconditions.checkNotEmpty(s4);
                            if(s4.hashCode() != 95027 || !s4.equals("_ui")) {
                                z3 = z1;
                                z4 = false;
                            }
                        }
                        if(z4) {
                            ArrayList arrayList0 = new ArrayList(zzhr2.zza());
                            int v13 = 0;
                            while(true) {
                                z1 = z3;
                                if(v13 >= arrayList0.size()) {
                                    break;
                                }
                                ++v13;
                                z3 = z1;
                            }
                        }
                        else {
                            z1 = z3;
                        }
                        if("_e".equals(zzhr2.zzk())) {
                            this.zzp();
                            if(zzpj.zzF(((com.google.android.gms.internal.measurement.zzhs)zzhr2.zzbc()), "_fr") == null) {
                                if(zzhr1 != null && Math.abs(zzhr1.zzn() - zzhr2.zzn()) <= 1000L) {
                                    zzhr zzhr3 = (zzhr)zzhr1.zzba();
                                    if(this.zzaH(zzhr2, zzhr3)) {
                                        zzic0.zzf(v3, zzhr3);
                                        v2 = v9;
                                        zzhr0 = null;
                                        zzhr1 = null;
                                        goto label_130;
                                    }
                                }
                                v2 = v5;
                                zzhr0 = zzhr2;
                            }
                        }
                        else if("_vs".equals(zzhr2.zzk())) {
                            this.zzp();
                            if(zzpj.zzF(((com.google.android.gms.internal.measurement.zzhs)zzhr2.zzbc()), "_et") == null) {
                                if(zzhr0 != null && Math.abs(zzhr0.zzn() - zzhr2.zzn()) <= 1000L) {
                                    zzhr zzhr4 = (zzhr)zzhr0.zzba();
                                    if(this.zzaH(zzhr4, zzhr2)) {
                                        zzic0.zzf(v9, zzhr4);
                                        v2 = v9;
                                        zzhr0 = null;
                                        zzhr1 = null;
                                        goto label_130;
                                    }
                                }
                                v3 = v5;
                                v2 = v9;
                                zzhr1 = zzhr2;
                            }
                        }
                        else {
                            v2 = v9;
                        }
                    label_130:
                        if(zzhr2.zzb() != 0) {
                            this.zzp();
                            Bundle bundle0 = zzpj.zzE(zzhr2.zza());
                            for(int v14 = 0; v14 < zzhr2.zzb(); ++v14) {
                                this.zzT(zzhr2.zzk(), ((zzhv)zzhr2.zzc(v14).zzcl()), bundle0, "");
                            }
                            zzhr2.zzi();
                            zzpj zzpj0 = this.zzp();
                            ArrayList arrayList1 = new ArrayList();
                            for(Object object1: bundle0.keySet()) {
                                zzhv zzhv3 = zzhw.zzn();
                                zzhv3.zzb(((String)object1));
                                Object object2 = bundle0.get(((String)object1));
                                if(object2 != null) {
                                    zzpj0.zzd(zzhv3, object2);
                                    arrayList1.add(((zzhw)zzhv3.zzbc()));
                                }
                            }
                            for(Object object3: arrayList1) {
                                zzhr2.zzf(((zzhw)object3));
                            }
                        }
                        v8 = v4;
                        zzpb0.zzc.set(v8, ((com.google.android.gms.internal.measurement.zzhs)zzhr2.zzbc()));
                        zzic0.zzg(zzhr2);
                        ++v5;
                    }
                    v6 = v7;
                    z = z1;
                    v4 = v8 + 1;
                }
                Long long0 = 1L;
                long v15 = 0L;
                for(int v16 = 0; v16 < v5; ++v16) {
                    com.google.android.gms.internal.measurement.zzhs zzhs0 = zzic0.zzd(v16);
                    this.zzp();
                    zzhw zzhw0 = zzpj.zzF(zzhs0, "_et");
                    if(zzhw0 != null) {
                        Long long1 = zzhw0.zze() ? zzhw0.zzf() : null;
                        if(long1 != null && ((long)long1) > 0L) {
                            v15 += (long)long1;
                        }
                    }
                }
                this.zzaG(zzic0, v15, false);
                Iterator iterator2 = zzic0.zzb().iterator();
                while(iterator2.hasNext()) {
                    iterator2.next();
                }
                if(zzpj.zzx(zzic0, "_sid") >= 0) {
                    this.zzaG(zzic0, v15, true);
                }
                else {
                    int v17 = zzpj.zzx(zzic0, "_se");
                    if(v17 >= 0) {
                        zzic0.zzr(v17);
                        this.zzaV().zzb().zzb("Session engagement user property is in the bundle without session ID. appId", zzgt.zzl(""));
                    }
                }
                this.zzaW().zzg();
                this.zzu();
                zzh zzh0 = this.zzj().zzu("");
                if(zzh0 == null) {
                    this.zzaV().zzb().zzb("Cannot fix consent fields without appInfo. appId", zzgt.zzl(""));
                }
                else {
                    this.zzI(zzh0, zzic0);
                }
                this.zzaW().zzg();
                this.zzu();
                zzh zzh1 = this.zzj().zzu("");
                if(zzh1 == null) {
                    this.zzaV().zze().zzb("Cannot populate ad_campaign_info without appInfo. appId", zzgt.zzl(""));
                }
                else {
                    this.zzJ(zzh1, zzic0);
                }
                zzpf.zzaR(zzic0);
                zzic0.zzak();
                zzjk zzjk0 = this.zzB("").zzs(zzjk.zzf("", 100));
                zzjk zzjk1 = this.zzj().zzaf("");
                this.zzj().zzae("", zzjk0);
                zzjj zzjj0 = zzjj.zzb;
                if(!zzjk0.zzo(zzjj0) && zzjk1.zzo(zzjj0)) {
                    this.zzj().zzi("");
                }
                else if(zzjk0.zzo(zzjj0) && !zzjk1.zzo(zzjj0)) {
                    this.zzj().zzj("");
                }
                zzjj zzjj1 = zzjj.zza;
                if(!zzjk0.zzo(zzjj1)) {
                    zzic0.zzR();
                    zzic0.zzU();
                    zzic0.zzan();
                }
                if(!zzjk0.zzo(zzjj0)) {
                    zzic0.zzX();
                    zzic0.zzav();
                }
                zzql.zza();
                if(this.zzd().zzp("", zzfx.zzaP) && this.zzt().zzX("") && this.zzB("").zzo(zzjj1) && zzpb0.zza.zzak()) {
                    for(int v18 = 0; v18 < zzic0.zzc(); ++v18) {
                        Iterator iterator3 = ((zzhr)zzic0.zzd(v18).zzcl()).zza().iterator();
                        while(iterator3.hasNext()) {
                            iterator3.next();
                        }
                    }
                }
                zzic0.zzag();
                zzic0.zzaf(this.zzm().zzb(zzic0.zzK(), zzic0.zzb(), zzic0.zzk(), zzic0.zzu(), zzic0.zzw(), !zzjk0.zzo(zzjj0)));
                if(this.zzd().zzD("")) {
                    HashMap hashMap0 = new HashMap();
                    ArrayList arrayList2 = new ArrayList();
                    SecureRandom secureRandom0 = this.zzt().zzf();
                    int v19 = 0;
                    while(v19 < zzic0.zzc()) {
                        zzhr zzhr5 = (zzhr)zzic0.zzd(v19).zzcl();
                        if(zzhr5.zzk().equals("_ep")) {
                            this.zzp();
                            String s7 = (String)zzpj.zzI(((com.google.android.gms.internal.measurement.zzhs)zzhr5.zzbc()), "_en");
                            zzbc zzbc0 = (zzbc)hashMap0.get(s7);
                            if(zzbc0 == null) {
                                zzbc0 = this.zzj().zzf("", ((String)Preconditions.checkNotNull(s7)));
                                if(zzbc0 != null) {
                                    hashMap0.put(s7, zzbc0);
                                }
                            }
                            if(zzbc0 == null || zzbc0.zzi != null) {
                                long3 = long0;
                            }
                            else {
                                Long long2 = zzbc0.zzj;
                                if(long2 != null && ((long)long2) > 1L) {
                                    this.zzp();
                                    zzpj.zzC(zzhr5, "_sr", long2);
                                }
                                if(zzbc0.zzk == null || !zzbc0.zzk.booleanValue()) {
                                    long3 = long0;
                                }
                                else {
                                    this.zzp();
                                    long3 = long0;
                                    zzpj.zzC(zzhr5, "_efs", long3);
                                }
                                arrayList2.add(((com.google.android.gms.internal.measurement.zzhs)zzhr5.zzbc()));
                            }
                            zzic0.zzf(v19, zzhr5);
                            hashMap1 = hashMap0;
                            secureRandom1 = secureRandom0;
                            v20 = v19;
                            long4 = long3;
                        }
                        else {
                            zzhs zzhs1 = this.zzh();
                            String s8 = zzhs1.zza("", "measurement.account.time_zone_offset_minutes");
                            if(TextUtils.isEmpty(s8)) {
                                v21 = 0L;
                            }
                            else {
                                try {
                                    v21 = Long.parseLong(s8);
                                }
                                catch(NumberFormatException numberFormatException0) {
                                    zzhs1.zzu.zzaV().zze().zzc("Unable to parse timezone offset. appId", zzgt.zzl(""), numberFormatException0);
                                    v21 = 0L;
                                }
                            }
                            long v22 = this.zzt().zzaj(zzhr5.zzn(), v21);
                            com.google.android.gms.internal.measurement.zzhs zzhs2 = (com.google.android.gms.internal.measurement.zzhs)zzhr5.zzbc();
                            if(!TextUtils.isEmpty("_dbg")) {
                                for(Object object4: zzhs2.zza()) {
                                    zzhw zzhw1 = (zzhw)object4;
                                }
                            }
                            int v23 = this.zzh().zzm("", zzhr5.zzk());
                            if(v23 <= 0) {
                                this.zzaV().zze().zzc("Sample rate must be positive. event, rate", zzhr5.zzk(), v23);
                                arrayList2.add(((com.google.android.gms.internal.measurement.zzhs)zzhr5.zzbc()));
                                zzic0.zzf(v19, zzhr5);
                                secureRandom1 = secureRandom0;
                                v20 = v19;
                                long4 = long0;
                                hashMap1 = hashMap0;
                            }
                            else {
                                hashMap1 = hashMap0;
                                zzbc zzbc1 = (zzbc)hashMap1.get(zzhr5.zzk());
                                if(zzbc1 == null) {
                                    long5 = long0;
                                    zzbc zzbc2 = this.zzj().zzf("", zzhr5.zzk());
                                    if(zzbc2 == null) {
                                        v24 = v21;
                                        this.zzaV().zze().zzc("Event being bundled has no eventAggregate. appId, eventName", "", zzhr5.zzk());
                                        zzbc1 = new zzbc("", zzhr5.zzk(), 1L, 1L, 1L, zzhr5.zzn(), 0L, null, null, null, null);
                                        goto label_311;
                                    }
                                    else {
                                        zzbc1 = zzbc2;
                                        goto label_310;
                                    }
                                    goto label_309;
                                }
                                else {
                                label_309:
                                    long5 = long0;
                                }
                            label_310:
                                v24 = v21;
                            label_311:
                                this.zzp();
                                Long long6 = (Long)zzpj.zzI(((com.google.android.gms.internal.measurement.zzhs)zzhr5.zzbc()), "_eid");
                                boolean z5 = long6 != null;
                                if(v23 == 1) {
                                    arrayList2.add(((com.google.android.gms.internal.measurement.zzhs)zzhr5.zzbc()));
                                    if(z5 && (zzbc1.zzi != null || zzbc1.zzj != null || zzbc1.zzk != null)) {
                                        hashMap1.put(zzhr5.zzk(), zzbc1.zzc(null, null, null));
                                    }
                                    zzic0.zzf(v19, zzhr5);
                                    secureRandom1 = secureRandom0;
                                    v20 = v19;
                                    long4 = long5;
                                }
                                else {
                                    if(secureRandom0.nextInt(v23) == 0) {
                                        this.zzp();
                                        Long long7 = (long)v23;
                                        zzpj.zzC(zzhr5, "_sr", long7);
                                        arrayList2.add(((com.google.android.gms.internal.measurement.zzhs)zzhr5.zzbc()));
                                        if(z5) {
                                            zzbc1 = zzbc1.zzc(null, long7, null);
                                        }
                                        hashMap1.put(zzhr5.zzk(), zzbc1.zzb(zzhr5.zzn(), v22));
                                        secureRandom1 = secureRandom0;
                                        v20 = v19;
                                        long4 = long5;
                                    }
                                    else {
                                        Long long8 = zzbc1.zzh;
                                        if(long8 == null) {
                                            secureRandom1 = secureRandom0;
                                            v25 = v19;
                                            long9 = long6;
                                            zzic1 = zzic0;
                                            v26 = this.zzt().zzaj(zzhr5.zzp(), v24);
                                        }
                                        else {
                                            v25 = v19;
                                            long9 = long6;
                                            zzic1 = zzic0;
                                            secureRandom1 = secureRandom0;
                                            v26 = (long)long8;
                                        }
                                        if(v26 == v22) {
                                            long4 = long5;
                                            if(z5) {
                                                hashMap1.put(zzhr5.zzk(), zzbc1.zzc(long9, null, null));
                                            }
                                        }
                                        else {
                                            this.zzp();
                                            long4 = long5;
                                            zzpj.zzC(zzhr5, "_efs", long4);
                                            this.zzp();
                                            Long long10 = (long)v23;
                                            zzpj.zzC(zzhr5, "_sr", long10);
                                            arrayList2.add(((com.google.android.gms.internal.measurement.zzhs)zzhr5.zzbc()));
                                            if(z5) {
                                                zzbc1 = zzbc1.zzc(null, long10, Boolean.TRUE);
                                            }
                                            hashMap1.put(zzhr5.zzk(), zzbc1.zzb(zzhr5.zzn(), v22));
                                        }
                                        v20 = v25;
                                        zzic0 = zzic1;
                                    }
                                    zzic0.zzf(v20, zzhr5);
                                }
                            }
                        }
                        v19 = v20 + 1;
                        long0 = long4;
                        secureRandom0 = secureRandom1;
                        hashMap0 = hashMap1;
                    }
                    if(arrayList2.size() < zzic0.zzc()) {
                        zzic0.zzi();
                        zzic0.zzh(arrayList2);
                    }
                    for(Object object5: hashMap0.entrySet()) {
                        this.zzj().zzh(((zzbc)((Map.Entry)object5).getValue()));
                    }
                }
                zzh zzh2 = this.zzj().zzu("");
                if(zzh2 == null) {
                    this.zzaV().zzb().zzb("Bundling raw events w/o app info. appId", zzgt.zzl(""));
                }
                else if(zzic0.zzc() > 0) {
                    long v27 = zzh2.zzp();
                    if(v27 == 0L) {
                        zzic0.zzB();
                    }
                    else {
                        zzic0.zzA(v27);
                    }
                    long v28 = zzh2.zzn();
                    if(v28 != 0L) {
                        v27 = v28;
                    }
                    if(v27 == 0L) {
                        zzic0.zzz();
                    }
                    else {
                        zzic0.zzy(v27);
                    }
                    zzh2.zzM(((long)zzic0.zzc()));
                    zzic0.zzaJ(((int)zzh2.zzaF()));
                    zzic0.zzZ(((int)zzh2.zzG()));
                    zzh2.zzo(zzic0.zzu());
                    zzh2.zzq(zzic0.zzw());
                    String s9 = zzh2.zzaa();
                    if(s9 == null) {
                        zzic0.zzab();
                    }
                    else {
                        zzic0.zzaa(s9);
                    }
                    this.zzj().zzv(zzh2, false, false);
                }
                if(zzic0.zzc() > 0) {
                    zzgl zzgl0 = this.zzh().zzb("");
                    if(zzgl0 == null || !zzgl0.zza()) {
                        zzic0.zzal(-1L);
                    }
                    else {
                        zzic0.zzal(zzgl0.zzb());
                    }
                    this.zzj().zzz(((zzid)zzic0.zzbc()), z1);
                }
                this.zzj().zzS(zzpb0.zzb);
                this.zzj().zzT("");
                this.zzj().zzc();
                z6 = true;
            }
            return z6;
        }
        finally {
            this.zzj().zzd();
        }
    }

    private final void zzaG(zzic zzic0, long v, boolean z) {
        zzpm zzpm1;
        zzpm zzpm0 = this.zzj().zzm(zzic0.zzK(), (z ? "_se" : "_lte"));
        if(zzpm0 == null) {
            zzpm1 = new zzpm(zzic0.zzK(), "auto", (z ? "_se" : "_lte"), this.zzaZ().currentTimeMillis(), v);
        }
        else {
            Object object0 = zzpm0.zze;
            zzpm1 = object0 == null ? new zzpm(zzic0.zzK(), "auto", (z ? "_se" : "_lte"), this.zzaZ().currentTimeMillis(), v) : new zzpm(zzic0.zzK(), "auto", (z ? "_se" : "_lte"), this.zzaZ().currentTimeMillis(), ((long)(((long)(((Long)object0))) + v)));
        }
        zzit zzit0 = zziu.zzm();
        zzit0.zzb((z ? "_se" : "_lte"));
        zzit0.zza(this.zzaZ().currentTimeMillis());
        Object object1 = zzpm1.zze;
        zzit0.zze(((long)(((Long)object1))));
        zziu zziu0 = (zziu)zzit0.zzbc();
        int v1 = zzpj.zzx(zzic0, (z ? "_se" : "_lte"));
        if(v1 >= 0) {
            zzic0.zzn(v1, zziu0);
        }
        else {
            zzic0.zzo(zziu0);
        }
        if(v > 0L) {
            this.zzj().zzl(zzpm1);
            this.zzaV().zzk().zzc("Updated engagement user property. scope, value", (z ? "session-scoped" : "lifetime"), object1);
        }
    }

    private final boolean zzaH(zzhr zzhr0, zzhr zzhr1) {
        Preconditions.checkArgument("_e".equals(zzhr0.zzk()));
        this.zzp();
        String s = null;
        String s1 = zzpj.zzF(((com.google.android.gms.internal.measurement.zzhs)zzhr0.zzbc()), "_sc") == null ? null : "";
        this.zzp();
        if(zzpj.zzF(((com.google.android.gms.internal.measurement.zzhs)zzhr1.zzbc()), "_pc") != null) {
            s = "";
        }
        if(s != null && s.equals(s1)) {
            Preconditions.checkArgument("_e".equals(zzhr0.zzk()));
            this.zzp();
            zzhw zzhw0 = zzpj.zzF(((com.google.android.gms.internal.measurement.zzhs)zzhr0.zzbc()), "_et");
            if(zzhw0 != null && zzhw0.zze() && zzhw0.zzf() > 0L) {
                long v = zzhw0.zzf();
                this.zzp();
                zzhw zzhw1 = zzpj.zzF(((com.google.android.gms.internal.measurement.zzhs)zzhr1.zzbc()), "_et");
                if(zzhw1 != null && zzhw1.zzf() > 0L) {
                    v += zzhw1.zzf();
                }
                this.zzp();
                zzpj.zzC(zzhr1, "_et", v);
                this.zzp();
                zzpj.zzC(zzhr0, "_fr", 1L);
            }
            return true;
        }
        return false;
    }

    private final boolean zzaI() {
        this.zzaW().zzg();
        this.zzu();
        return this.zzj().zzP() || !TextUtils.isEmpty(this.zzj().zzF());
    }

    private static String zzaJ(Map map0, String s) {
        if(map0 != null) {
            for(Object object0: map0.entrySet()) {
                Map.Entry map$Entry0 = (Map.Entry)object0;
                if(s.equalsIgnoreCase(((String)map$Entry0.getKey()))) {
                    return ((List)map$Entry0.getValue()).isEmpty() ? null : ((String)((List)map$Entry0.getValue()).get(0));
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    private final void zzaK() {
        long v7;
        long v3;
        this.zzaW().zzg();
        this.zzu();
        if(this.zza > 0L) {
            long v = Math.abs(this.zzaZ().elapsedRealtime() - this.zza);
            if(3600000L - v > 0L) {
                this.zzaV().zzk().zzb("Upload has been suspended. Will update scheduling later in approximately ms", ((long)(3600000L - v)));
                this.zzk().zzb();
                this.zzl().zzd();
                return;
            }
            this.zza = 0L;
        }
        if(this.zzn.zzH() && this.zzaI()) {
            long v1 = this.zzaZ().currentTimeMillis();
            this.zzd();
            long v2 = Math.max(0L, ((long)(((Long)zzfx.zzO.zzb(null)))));
            if(this.zzj().zzR() || this.zzj().zzG()) {
                String s = this.zzd().zzA();
                if(TextUtils.isEmpty(s) || ".none.".equals(s)) {
                    this.zzd();
                    v3 = Math.max(0L, ((long)(((Long)zzfx.zzI.zzb(null)))));
                }
                else {
                    this.zzd();
                    v3 = Math.max(0L, ((long)(((Long)zzfx.zzJ.zzb(null)))));
                }
            }
            else {
                this.zzd();
                v3 = Math.max(0L, ((long)(((Long)zzfx.zzH.zzb(null)))));
            }
            long v4 = this.zzk.zzd.zza();
            long v5 = this.zzk.zze.zza();
            long v6 = Math.max(this.zzj().zzM(), this.zzj().zzO());
            if(v6 == 0L) {
                v7 = 0L;
            }
            else {
                long v8 = v1 - Math.abs(v6 - v1);
                long v9 = v1 - Math.abs(v5 - v1);
                v7 = v2 + v8;
                long v10 = Math.max(v1 - Math.abs(v4 - v1), v9);
                if(v10 > 0L) {
                    v7 = Math.min(v8, v10) + v3;
                }
                if(!this.zzp().zzs(v10, v3)) {
                    v7 = v10 + v3;
                }
                if(v9 != 0L && v9 >= v8) {
                    for(int v11 = 0; true; ++v11) {
                        this.zzd();
                        if(v11 >= Math.min(20, Math.max(0, ((int)(((Integer)zzfx.zzQ.zzb(null))))))) {
                            v7 = 0L;
                            break;
                        }
                        this.zzd();
                        v7 += Math.max(0L, ((long)(((Long)zzfx.zzP.zzb(null))))) * (1L << v11);
                        if(v7 > v9) {
                            break;
                        }
                    }
                }
            }
            if(v7 == 0L) {
                this.zzaV().zzk().zza("Next upload time is 0");
                this.zzk().zzb();
                this.zzl().zzd();
                return;
            }
            if(this.zzi().zzb()) {
                long v12 = this.zzk.zzc.zza();
                this.zzd();
                long v13 = Math.max(0L, ((long)(((Long)zzfx.zzF.zzb(null)))));
                if(!this.zzp().zzs(v12, v13)) {
                    v7 = Math.max(v7, v12 + v13);
                }
                this.zzk().zzb();
                long v14 = v7 - this.zzaZ().currentTimeMillis();
                if(v14 <= 0L) {
                    this.zzd();
                    v14 = Math.max(0L, ((long)(((Long)zzfx.zzK.zzb(null)))));
                    this.zzk.zzd.zzb(this.zzaZ().currentTimeMillis());
                }
                this.zzaV().zzk().zzb("Upload scheduled in approximately ms", v14);
                this.zzl().zzc(v14);
                return;
            }
            this.zzaV().zzk().zza("No network");
            this.zzk().zza();
            this.zzl().zzd();
            return;
        }
        this.zzaV().zzk().zza("Nothing to upload or uploading impossible");
        this.zzk().zzb();
        this.zzl().zzd();
    }

    private final void zzaL() {
        this.zzaW().zzg();
        if(!this.zzu && !this.zzv && !this.zzw) {
            this.zzaV().zzk().zza("Stopping uploading service(s)");
            List list0 = this.zzq;
            if(list0 == null) {
                return;
            }
            for(Object object0: list0) {
                ((Runnable)object0).run();
            }
            ((List)Preconditions.checkNotNull(this.zzq)).clear();
            return;
        }
        this.zzaV().zzk().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw));
    }

    private final Boolean zzaM(zzh zzh0) {
        try {
            if(Long.compare(zzh0.zzt(), 0xFFFFFFFF80000000L) != 0) {
                int v = Wrappers.packageManager(this.zzn.zzaY()).getPackageInfo(zzh0.zzc(), 0).versionCode;
                return zzh0.zzt() == ((long)v);
            }
            String s = Wrappers.packageManager(this.zzn.zzaY()).getPackageInfo(zzh0.zzc(), 0).versionName;
            String s1 = zzh0.zzr();
            return s1 == null || !s1.equals(s) ? false : true;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            return null;
        }
    }

    private final zzr zzaN(String s) {
        zzh zzh0 = this.zzj().zzu(s);
        if(zzh0 != null && !TextUtils.isEmpty(zzh0.zzr())) {
            Boolean boolean0 = this.zzaM(zzh0);
            if(boolean0 != null && !boolean0.booleanValue()) {
                this.zzaV().zzb().zzb("App version does not match; dropping. appId", zzgt.zzl(s));
                return null;
            }
            return new zzr(s, zzh0.zzf(), zzh0.zzr(), zzh0.zzt(), zzh0.zzv(), zzh0.zzx(), zzh0.zzz(), null, zzh0.zzD(), false, zzh0.zzl(), 0L, 0, zzh0.zzac(), false, zzh0.zzae(), zzh0.zzB(), zzh0.zzag(), this.zzB(s).zzl(), "", null, zzh0.zzai(), zzh0.zzak(), this.zzB(s).zzb(), this.zzx(s).zze(), zzh0.zzao(), zzh0.zzaw(), zzh0.zzay(), zzh0.zzaH(), 0L, zzh0.zzaL());
        }
        this.zzaV().zzj().zzb("No app data available; dropping", s);
        return null;
    }

    private final boolean zzaO(String s, String s1) {
        zzbc zzbc0 = this.zzj().zzf(s, s1);
        return zzbc0 == null || zzbc0.zzc < 1L;
    }

    private static void zzaP(Context context0, Intent intent0) {
        if(Build.VERSION.SDK_INT < 34) {
            context0.sendBroadcast(intent0);
            return;
        }
        m.u(context0, intent0, m.e(BroadcastOptions.makeBasic()).toBundle());
    }

    private static final boolean zzaQ(zzr zzr0) {
        return !TextUtils.isEmpty(zzr0.zzb);
    }

    private static final void zzaR(zzic zzic0) {
        zzic0.zzv(0x7FFFFFFFFFFFFFFFL);
        zzic0.zzx(0x8000000000000000L);
        for(int v = 0; v < zzic0.zzc(); ++v) {
            com.google.android.gms.internal.measurement.zzhs zzhs0 = zzic0.zzd(v);
            if(zzhs0.zzf() < zzic0.zzu()) {
                zzic0.zzv(zzhs0.zzf());
            }
            if(zzhs0.zzf() > zzic0.zzw()) {
                zzic0.zzx(zzhs0.zzf());
            }
        }
    }

    private static final zzor zzaS(zzor zzor0) {
        if(zzor0 == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if(!zzor0.zzax()) {
            throw new IllegalStateException("Component not initialized: " + zzor0.getClass());
        }
        return zzor0;
    }

    private static final Boolean zzaT(zzr zzr0) {
        Boolean boolean0 = zzr0.zzp;
        String s = zzr0.zzC;
        if(!TextUtils.isEmpty(s)) {
            switch(zze.zzc(s).zza().ordinal()) {
                case 0: 
                case 1: {
                    return null;
                }
                case 2: {
                    return true;
                }
                case 3: {
                    return false;
                }
                default: {
                    return boolean0;
                }
            }
        }
        return boolean0;
    }

    @Override  // com.google.android.gms.measurement.internal.zzjf
    public final zzae zzaU() {
        return this.zzn.zzaU();
    }

    @Override  // com.google.android.gms.measurement.internal.zzjf
    public final zzgt zzaV() {
        return ((zzib)Preconditions.checkNotNull(this.zzn)).zzaV();
    }

    @Override  // com.google.android.gms.measurement.internal.zzjf
    public final zzhy zzaW() {
        return ((zzib)Preconditions.checkNotNull(this.zzn)).zzaW();
    }

    @Override  // com.google.android.gms.measurement.internal.zzjf
    public final Context zzaY() {
        return this.zzn.zzaY();
    }

    @Override  // com.google.android.gms.measurement.internal.zzjf
    public final Clock zzaZ() {
        return ((zzib)Preconditions.checkNotNull(this.zzn)).zzaZ();
    }

    public final void zzaa(zzr zzr0) {
        if(this.zzz != null) {
            ArrayList arrayList0 = new ArrayList();
            this.zzA = arrayList0;
            arrayList0.addAll(this.zzz);
        }
        zzav zzav0 = this.zzj();
        String s = (String)Preconditions.checkNotNull(zzr0.zza);
        Preconditions.checkNotEmpty(s);
        zzav0.zzg();
        zzav0.zzay();
        try {
            SQLiteDatabase sQLiteDatabase0 = zzav0.zze();
            String[] arr_s = {s};
            int v = sQLiteDatabase0.delete("apps", "app_id=?", arr_s) + sQLiteDatabase0.delete("events", "app_id=?", arr_s) + sQLiteDatabase0.delete("events_snapshot", "app_id=?", arr_s) + sQLiteDatabase0.delete("user_attributes", "app_id=?", arr_s) + sQLiteDatabase0.delete("conditional_properties", "app_id=?", arr_s) + sQLiteDatabase0.delete("raw_events", "app_id=?", arr_s) + sQLiteDatabase0.delete("raw_events_metadata", "app_id=?", arr_s) + sQLiteDatabase0.delete("queue", "app_id=?", arr_s) + sQLiteDatabase0.delete("audience_filter_values", "app_id=?", arr_s) + sQLiteDatabase0.delete("main_event_params", "app_id=?", arr_s) + sQLiteDatabase0.delete("default_event_params", "app_id=?", arr_s) + sQLiteDatabase0.delete("trigger_uris", "app_id=?", arr_s) + sQLiteDatabase0.delete("upload_queue", "app_id=?", arr_s);
            com.google.android.gms.internal.measurement.zzpk.zza();
            zzib zzib0 = zzav0.zzu;
            if(zzib0.zzc().zzp(null, zzfx.zzbi)) {
                v += sQLiteDatabase0.delete("no_data_mode_events", "app_id=?", arr_s);
            }
            if(v > 0) {
                zzib0.zzaV().zzk().zzc("Reset analytics data. app, records", s, v);
            }
        }
        catch(SQLiteException sQLiteException0) {
            zzav0.zzu.zzaV().zzb().zzc("Error resetting analytics data. appId, error", zzgt.zzl(s), sQLiteException0);
        }
        if(zzr0.zzh) {
            this.zzag(zzr0);
        }
    }

    public final void zzab(zzpk zzpk0, zzr zzr0) {
        long v4;
        this.zzaW().zzg();
        this.zzu();
        if(zzpf.zzaQ(zzr0)) {
            if(!zzr0.zzh) {
                this.zzan(zzr0);
                return;
            }
            zzpo zzpo0 = this.zzt();
            String s = zzpk0.zzb;
            int v = zzpo0.zzp(s);
            int v1 = 0;
            if(v != 0) {
                zzpo zzpo1 = this.zzt();
                this.zzd();
                String s1 = zzpo1.zzC(s, 24, true);
                if(s != null) {
                    v1 = s.length();
                }
                this.zzt().zzN(this.zzK, zzr0.zza, v, "_ev", s1, v1);
                return;
            }
            int v2 = this.zzt().zzK(s, zzpk0.zza());
            if(v2 != 0) {
                zzpo zzpo2 = this.zzt();
                this.zzd();
                String s2 = zzpo2.zzC(s, 24, true);
                Object object0 = zzpk0.zza();
                if(object0 != null && (object0 instanceof String || object0 instanceof CharSequence)) {
                    v1 = object0.toString().length();
                }
                this.zzt().zzN(this.zzK, zzr0.zza, v2, "_ev", s2, v1);
                return;
            }
            Object object1 = this.zzt().zzL(s, zzpk0.zza());
            if(object1 != null) {
                if("_sid".equals(s)) {
                    long v3 = zzpk0.zzc;
                    String s3 = zzpk0.zzf;
                    String s4 = (String)Preconditions.checkNotNull(zzr0.zza);
                    zzpm zzpm0 = this.zzj().zzm(s4, "_sno");
                    if(zzpm0 == null) {
                    label_40:
                        if(zzpm0 != null) {
                            this.zzaV().zze().zzb("Retrieved last session number from database does not contain a valid (long) value", zzpm0.zze);
                        }
                        zzbc zzbc0 = this.zzj().zzf(s4, "_s");
                        if(zzbc0 == null) {
                            v4 = 0L;
                        }
                        else {
                            this.zzaV().zzk().zzb("Backfill the session number. Last used session number", zzbc0.zzc);
                            v4 = zzbc0.zzc;
                        }
                    }
                    else {
                        Object object2 = zzpm0.zze;
                        if(object2 instanceof Long) {
                            v4 = (long)(((Long)object2));
                            goto label_48;
                        }
                        goto label_40;
                    }
                label_48:
                    this.zzab(new zzpk("_sno", v3, ((long)(v4 + 1L)), s3), zzr0);
                }
                String s5 = zzr0.zza;
                zzpm zzpm1 = new zzpm(((String)Preconditions.checkNotNull(s5)), ((String)Preconditions.checkNotNull(zzpk0.zzf)), s, zzpk0.zzc, object1);
                zzgr zzgr0 = this.zzaV().zzk();
                zzib zzib0 = this.zzn;
                String s6 = zzpm1.zzc;
                zzgr0.zzc("Setting user property", zzib0.zzl().zzc(s6), object1);
                this.zzj().zzb();
                try {
                    if("_id".equals(s6)) {
                        zzpm zzpm2 = this.zzj().zzm(s5, "_id");
                        if(zzpm2 != null && !zzpm1.zze.equals(zzpm2.zze)) {
                            this.zzj().zzk(s5, "_lair");
                        }
                    }
                    this.zzan(zzr0);
                    boolean z = this.zzj().zzl(zzpm1);
                    if("_sid".equals(s)) {
                        long v6 = this.zzp().zzu(zzr0.zzu);
                        zzh zzh0 = this.zzj().zzu(s5);
                        if(zzh0 != null) {
                            zzh0.zzan(v6);
                            if(zzh0.zza()) {
                                this.zzj().zzv(zzh0, false, false);
                            }
                        }
                    }
                    this.zzj().zzc();
                    if(!z) {
                        this.zzaV().zzb().zzc("Too many unique user properties are set. Ignoring user property", zzib0.zzl().zzc(s6), zzpm1.zze);
                        this.zzt().zzN(this.zzK, s5, 9, null, null, 0);
                    }
                }
                finally {
                    this.zzj().zzd();
                }
            }
        }
    }

    public final void zzac(String s, zzr zzr0) {
        this.zzaW().zzg();
        this.zzu();
        if(!zzpf.zzaQ(zzr0)) {
            return;
        }
        if(!zzr0.zzh) {
            this.zzan(zzr0);
            return;
        }
        Boolean boolean0 = zzpf.zzaT(zzr0);
        if("_npa".equals(s) && boolean0 != null) {
            this.zzaV().zzj().zza("Falling back to manifest metadata value for ad personalization");
            this.zzab(new zzpk("_npa", this.zzaZ().currentTimeMillis(), ((long)(boolean0.booleanValue() ? 1L : 0L)), "auto"), zzr0);
            return;
        }
        zzgr zzgr0 = this.zzaV().zzj();
        zzib zzib0 = this.zzn;
        zzgr0.zzb("Removing user property", zzib0.zzl().zzc(s));
        this.zzj().zzb();
        try {
            this.zzan(zzr0);
            if("_id".equals(s)) {
                this.zzj().zzk(((String)Preconditions.checkNotNull(zzr0.zza)), "_lair");
            }
            this.zzj().zzk(((String)Preconditions.checkNotNull(zzr0.zza)), s);
            this.zzj().zzc();
            this.zzaV().zzj().zzb("User property removed", zzib0.zzl().zzc(s));
        }
        finally {
            this.zzj().zzd();
        }
    }

    public final void zzad() {
        ++this.zzs;
    }

    public final void zzae() {
        ++this.zzt;
    }

    public final zzib zzaf() {
        return this.zzn;
    }

    public final void zzag(zzr zzr0) {
        ApplicationInfo applicationInfo0;
        int v7;
        PackageInfo packageInfo0;
        boolean z;
        zzbc zzbc0;
        long v3;
        this.zzaW().zzg();
        this.zzu();
        Preconditions.checkNotNull(zzr0);
        String s = zzr0.zza;
        Preconditions.checkNotEmpty(s);
        if(!zzpf.zzaQ(zzr0)) {
            return;
        }
        zzh zzh0 = this.zzj().zzu(s);
        if(zzh0 != null && TextUtils.isEmpty(zzh0.zzf()) && !TextUtils.isEmpty(zzr0.zzb)) {
            zzh0.zzI(0L);
            this.zzj().zzv(zzh0, false, false);
            this.zzh().zzh(s);
        }
        if(!zzr0.zzh) {
            this.zzan(zzr0);
            return;
        }
        long v = zzr0.zzl == 0L ? this.zzaZ().currentTimeMillis() : zzr0.zzl;
        int v1 = zzr0.zzm;
        if(v1 != 0 && v1 != 1) {
            this.zzaV().zze().zzc("Incorrect app type, assuming installed app. appId, appType", zzgt.zzl(s), v1);
            v1 = 0;
        }
        this.zzj().zzb();
        try {
            zzpm zzpm0 = this.zzj().zzm(s, "_npa");
            Boolean boolean0 = zzpf.zzaT(zzr0);
            if(zzpm0 != null && !"auto".equals(zzpm0.zzb)) {
                v3 = v;
            }
            else if(boolean0 == null) {
                v3 = v;
                if(zzpm0 != null) {
                    this.zzac("_npa", zzr0);
                }
            }
            else {
                zzpk zzpk0 = new zzpk("_npa", v, ((long)(boolean0.booleanValue() ? 1L : 0L)), "auto");
                v3 = v;
                if(zzpm0 == null || !zzpm0.zze.equals(zzpk0.zzd)) {
                    this.zzab(zzpk0, zzr0);
                }
            }
            if(this.zzd().zzp(null, zzfx.zzbc)) {
                this.zzam(zzr0, zzr0.zzD);
            }
            else {
                this.zzam(zzr0, v3);
            }
            this.zzan(zzr0);
            if(v1 == 0) {
                zzbc0 = this.zzj().zzf(s, "_f");
                z = false;
            }
            else {
                zzbc0 = this.zzj().zzf(s, "_v");
                z = true;
            }
            if(zzbc0 == null) {
                long v4 = (v3 / 3600000L + 1L) * 3600000L;
                if(z) {
                    this.zzab(new zzpk("_fvt", v3, v4, "auto"), zzr0);
                    this.zzaW().zzg();
                    this.zzu();
                    Bundle bundle1 = new Bundle();
                    bundle1.putLong("_c", 1L);
                    bundle1.putLong("_r", 1L);
                    bundle1.putLong("_et", 1L);
                    if(zzr0.zzo) {
                        bundle1.putLong("_dac", 1L);
                    }
                    this.zzE(new zzbg("_v", new zzbe(bundle1), "auto", v3), zzr0);
                }
                else {
                    this.zzab(new zzpk("_fot", v3, v4, "auto"), zzr0);
                    this.zzaW().zzg();
                    Object object0 = Preconditions.checkNotNull(this.zzm);
                    if(s == null || s.isEmpty()) {
                        ((zzhj)object0).zza.zzaV().zzf().zza("Install Referrer Reporter was called with invalid app package name");
                    }
                    else {
                        zzib zzib0 = ((zzhj)object0).zza;
                        zzib0.zzaW().zzg();
                        if(((zzhj)object0).zza()) {
                            zzhi zzhi0 = new zzhi(((zzhj)object0), s);
                            zzib0.zzaW().zzg();
                            Intent intent0 = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
                            intent0.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
                            PackageManager packageManager0 = zzib0.zzaY().getPackageManager();
                            if(packageManager0 == null) {
                                zzib0.zzaV().zzf().zza("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
                            }
                            else {
                                List list0 = packageManager0.queryIntentServices(intent0, 0);
                                if(list0 == null || list0.isEmpty()) {
                                    zzib0.zzaV().zzi().zza("Play Service for fetching Install Referrer is unavailable on device");
                                }
                                else {
                                    ServiceInfo serviceInfo0 = ((ResolveInfo)list0.get(0)).serviceInfo;
                                    if(serviceInfo0 != null) {
                                        if(serviceInfo0.name == null || !"com.android.vending".equals(serviceInfo0.packageName) || !((zzhj)object0).zza()) {
                                            zzib0.zzaV().zze().zza("Play Store version 8.3.73 or higher required for Install Referrer");
                                        }
                                        else {
                                            Intent intent1 = new Intent(intent0);
                                            try {
                                                boolean z1 = ConnectionTracker.getInstance().bindService(zzib0.zzaY(), intent1, zzhi0, 1);
                                                zzib0.zzaV().zzk().zzb("Install Referrer Service is", (z1 ? "available" : "not available"));
                                                goto label_84;
                                            }
                                            catch(RuntimeException runtimeException0) {
                                            }
                                            ((zzhj)object0).zza.zzaV().zzb().zzb("Exception occurred while binding to Install Referrer Service", runtimeException0.getMessage());
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            zzib0.zzaV().zzi().zza("Install Referrer Reporter is not available");
                        }
                    }
                label_84:
                    this.zzaW().zzg();
                    this.zzu();
                    Bundle bundle0 = new Bundle();
                    bundle0.putLong("_c", 1L);
                    bundle0.putLong("_r", 1L);
                    bundle0.putLong("_uwa", 0L);
                    bundle0.putLong("_pfo", 0L);
                    bundle0.putLong("_sys", 0L);
                    bundle0.putLong("_sysu", 0L);
                    bundle0.putLong("_et", 1L);
                    if(zzr0.zzo) {
                        bundle0.putLong("_dac", 1L);
                    }
                    String s1 = (String)Preconditions.checkNotNull(zzr0.zza);
                    zzav zzav0 = this.zzj();
                    Preconditions.checkNotEmpty(s1);
                    zzav0.zzg();
                    zzav0.zzay();
                    long v5 = zzav0.zzN(s1, "first_open_count");
                    zzib zzib1 = this.zzn;
                    if(zzib1.zzaY().getPackageManager() == null) {
                        this.zzaV().zzb().zzb("PackageManager is null, first open report might be inaccurate. appId", zzgt.zzl(s1));
                    }
                    else {
                        try {
                            packageInfo0 = Wrappers.packageManager(zzib1.zzaY()).getPackageInfo(s1, 0);
                        }
                        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
                            this.zzaV().zzb().zzc("Package info is null, first open report might be inaccurate. appId", zzgt.zzl(s1), packageManager$NameNotFoundException0);
                            packageInfo0 = null;
                        }
                        if(packageInfo0 != null) {
                            long v6 = packageInfo0.firstInstallTime;
                            if(v6 != 0L) {
                                if(v6 == packageInfo0.lastUpdateTime) {
                                    v7 = 1;
                                }
                                else {
                                    if(!this.zzd().zzp(null, zzfx.zzaI)) {
                                        bundle0.putLong("_uwa", 1L);
                                    }
                                    else if(v5 == 0L) {
                                        bundle0.putLong("_uwa", 1L);
                                        v5 = 0L;
                                    }
                                    v7 = 0;
                                }
                                this.zzab(new zzpk("_fi", v3, ((long)(1 == v7 ? 1L : 0L)), "auto"), zzr0);
                            }
                        }
                        try {
                            applicationInfo0 = Wrappers.packageManager(this.zzn.zzaY()).getApplicationInfo(s1, 0);
                        }
                        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException1) {
                            this.zzaV().zzb().zzc("Application info is null, first open report might be inaccurate. appId", zzgt.zzl(s1), packageManager$NameNotFoundException1);
                            applicationInfo0 = null;
                        }
                        if(applicationInfo0 != null) {
                            if((applicationInfo0.flags & 1) != 0) {
                                bundle0.putLong("_sys", 1L);
                            }
                            if((applicationInfo0.flags & 0x80) != 0) {
                                bundle0.putLong("_sysu", 1L);
                            }
                        }
                    }
                    if(v5 >= 0L) {
                        bundle0.putLong("_pfo", v5);
                    }
                    this.zzE(new zzbg("_f", new zzbe(bundle0), "auto", v3), zzr0);
                }
            }
            else if(zzr0.zzi) {
                this.zzE(new zzbg("_cd", new zzbe(new Bundle()), "auto", v3), zzr0);
            }
            this.zzj().zzc();
        }
        finally {
            this.zzj().zzd();
        }
    }

    public final void zzah(zzr zzr0) {
        this.zzaW().zzg();
        this.zzu();
        Preconditions.checkNotNull(zzr0);
        String s = zzr0.zza;
        Preconditions.checkNotEmpty(s);
        int v = 0;
        if(this.zzd().zzp(null, zzfx.zzaz)) {
            long v1 = this.zzaZ().currentTimeMillis();
            int v2 = this.zzd().zzm(null, zzfx.zzai);
            this.zzd();
            long v3 = zzal.zzF();
            while(v < v2 && this.zzaF(null, v1 - v3)) {
                ++v;
            }
        }
        else {
            this.zzd();
            long v4 = zzal.zzH();
            while(((long)v) < v4 && this.zzaF(s, 0L)) {
                ++v;
            }
        }
        if(this.zzd().zzp(null, zzfx.zzaA)) {
            this.zzaW().zzg();
            this.zzaE();
        }
        zzin zzin0 = zzin.zzb(zzr0.zzE);
        if(this.zzl.zzc(s, zzin0)) {
            this.zzaV().zzk().zzb("[sgtm] Going background, trigger client side upload. appId", s);
            this.zzN(s, this.zzaZ().currentTimeMillis());
        }
    }

    public final void zzai(zzah zzah0) {
        zzr zzr0 = this.zzaN(((String)Preconditions.checkNotNull(zzah0.zza)));
        if(zzr0 != null) {
            this.zzaj(zzah0, zzr0);
        }
    }

    public final void zzaj(zzah zzah0, zzr zzr0) {
        Preconditions.checkNotNull(zzah0);
        Preconditions.checkNotEmpty(zzah0.zza);
        Preconditions.checkNotNull(zzah0.zzb);
        Preconditions.checkNotNull(zzah0.zzc);
        Preconditions.checkNotEmpty(zzah0.zzc.zzb);
        this.zzaW().zzg();
        this.zzu();
        if(!zzpf.zzaQ(zzr0)) {
            return;
        }
        if(!zzr0.zzh) {
            this.zzan(zzr0);
            return;
        }
        zzah zzah1 = new zzah(zzah0);
        boolean z = false;
        zzah1.zze = false;
        this.zzj().zzb();
        try {
            zzah zzah2 = this.zzj().zzq(((String)Preconditions.checkNotNull(zzah1.zza)), zzah1.zzc.zzb);
            if(zzah2 != null && !zzah2.zzb.equals(zzah1.zzb)) {
                this.zzaV().zze().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzl().zzc(zzah1.zzc.zzb), zzah1.zzb, zzah2.zzb);
            }
            if(zzah2 != null && zzah2.zze) {
                zzah1.zzb = zzah2.zzb;
                zzah1.zzd = zzah2.zzd;
                zzah1.zzh = zzah2.zzh;
                zzah1.zzf = zzah2.zzf;
                zzah1.zzi = zzah2.zzi;
                zzah1.zze = true;
                zzah1.zzc = new zzpk(zzah1.zzc.zzb, zzah2.zzc.zzc, zzah1.zzc.zza(), zzah2.zzc.zzf);
            }
            else if(TextUtils.isEmpty(zzah1.zzf)) {
                zzah1.zzc = new zzpk(zzah1.zzc.zzb, zzah1.zzd, zzah1.zzc.zza(), zzah1.zzc.zzf);
                zzah1.zze = true;
                z = true;
            }
            if(zzah1.zze) {
                zzpk zzpk0 = zzah1.zzc;
                String s = (String)Preconditions.checkNotNull(zzah1.zza);
                String s1 = zzah1.zzb;
                Object object0 = Preconditions.checkNotNull(zzpk0.zza());
                zzpm zzpm0 = new zzpm(s, s1, zzpk0.zzb, zzpk0.zzc, object0);
                if(this.zzj().zzl(zzpm0)) {
                    this.zzaV().zzj().zzd("User property updated immediately", zzah1.zza, this.zzn.zzl().zzc(zzpm0.zzc), zzpm0.zze);
                }
                else {
                    this.zzaV().zzb().zzd("(2)Too many active user properties, ignoring", zzgt.zzl(zzah1.zza), this.zzn.zzl().zzc(zzpm0.zzc), zzpm0.zze);
                }
                if(z && zzah1.zzi != null) {
                    this.zzH(new zzbg(zzah1.zzi, zzah1.zzd), zzr0);
                }
            }
            if(this.zzj().zzp(zzah1)) {
                this.zzaV().zzj().zzd("Conditional property added", zzah1.zza, this.zzn.zzl().zzc(zzah1.zzc.zzb), zzah1.zzc.zza());
            }
            else {
                this.zzaV().zzb().zzd("Too many conditional properties, ignoring", zzgt.zzl(zzah1.zza), this.zzn.zzl().zzc(zzah1.zzc.zzb), zzah1.zzc.zza());
            }
            this.zzj().zzc();
        }
        finally {
            this.zzj().zzd();
        }
    }

    public final void zzak(zzah zzah0) {
        zzr zzr0 = this.zzaN(((String)Preconditions.checkNotNull(zzah0.zza)));
        if(zzr0 != null) {
            this.zzal(zzah0, zzr0);
        }
    }

    public final void zzal(zzah zzah0, zzr zzr0) {
        Preconditions.checkNotNull(zzah0);
        Preconditions.checkNotEmpty(zzah0.zza);
        Preconditions.checkNotNull(zzah0.zzc);
        Preconditions.checkNotEmpty(zzah0.zzc.zzb);
        this.zzaW().zzg();
        this.zzu();
        if(!zzpf.zzaQ(zzr0)) {
            return;
        }
        if(!zzr0.zzh) {
            this.zzan(zzr0);
            return;
        }
        this.zzj().zzb();
        try {
            this.zzan(zzr0);
            Object object0 = Preconditions.checkNotNull(zzah0.zza);
            zzah zzah1 = this.zzj().zzq(((String)object0), zzah0.zzc.zzb);
            if(zzah1 == null) {
                this.zzaV().zze().zzc("Conditional user property doesn\'t exist", zzgt.zzl(zzah0.zza), this.zzn.zzl().zzc(zzah0.zzc.zzb));
            }
            else {
                this.zzaV().zzj().zzc("Removing conditional user property", zzah0.zza, this.zzn.zzl().zzc(zzah0.zzc.zzb));
                this.zzj().zzr(((String)object0), zzah0.zzc.zzb);
                if(zzah1.zze) {
                    this.zzj().zzk(((String)object0), zzah0.zzc.zzb);
                }
                zzbg zzbg0 = zzah0.zzk;
                if(zzbg0 != null) {
                    Bundle bundle0 = zzbg0.zzb == null ? null : zzbg0.zzb.zzf();
                    this.zzH(((zzbg)Preconditions.checkNotNull(this.zzt().zzac(((String)object0), ((zzbg)Preconditions.checkNotNull(zzbg0)).zza, bundle0, zzah1.zzb, zzbg0.zzd, true, true))), zzr0);
                }
            }
            this.zzj().zzc();
        }
        finally {
            this.zzj().zzd();
        }
    }

    public final void zzam(zzr zzr0, long v) {
        zzh zzh0 = this.zzj().zzu(((String)Preconditions.checkNotNull(zzr0.zza)));
        if(zzh0 != null) {
            zzpo zzpo0 = this.zzt();
            String s = zzh0.zzf();
            if(zzpo0.zzB(zzr0.zzb, s)) {
                this.zzaV().zze().zzb("New GMP App Id passed in. Removing cached database data. appId", zzgt.zzl(zzh0.zzc()));
                zzav zzav0 = this.zzj();
                String s1 = zzh0.zzc();
                zzav0.zzay();
                zzav0.zzg();
                Preconditions.checkNotEmpty(s1);
                try {
                    SQLiteDatabase sQLiteDatabase0 = zzav0.zze();
                    String[] arr_s = {s1};
                    int v1 = sQLiteDatabase0.delete("events", "app_id=?", arr_s) + sQLiteDatabase0.delete("user_attributes", "app_id=?", arr_s) + sQLiteDatabase0.delete("conditional_properties", "app_id=?", arr_s) + sQLiteDatabase0.delete("apps", "app_id=?", arr_s) + sQLiteDatabase0.delete("raw_events", "app_id=?", arr_s) + sQLiteDatabase0.delete("raw_events_metadata", "app_id=?", arr_s) + sQLiteDatabase0.delete("event_filters", "app_id=?", arr_s) + sQLiteDatabase0.delete("property_filters", "app_id=?", arr_s) + sQLiteDatabase0.delete("audience_filter_values", "app_id=?", arr_s) + sQLiteDatabase0.delete("consent_settings", "app_id=?", arr_s) + sQLiteDatabase0.delete("default_event_params", "app_id=?", arr_s) + sQLiteDatabase0.delete("trigger_uris", "app_id=?", arr_s);
                    com.google.android.gms.internal.measurement.zzpk.zza();
                    zzib zzib0 = zzav0.zzu;
                    if(zzib0.zzc().zzp(null, zzfx.zzbi)) {
                        v1 += sQLiteDatabase0.delete("no_data_mode_events", "app_id=?", arr_s);
                    }
                    if(v1 > 0) {
                        zzib0.zzaV().zzk().zzc("Deleted application data. app, records", s1, v1);
                    }
                }
                catch(SQLiteException sQLiteException0) {
                    zzav0.zzu.zzaV().zzb().zzc("Error deleting application data. appId, error", zzgt.zzl(s1), sQLiteException0);
                }
                zzh0 = null;
            }
        }
        int v2 = 1;
        if(zzh0 != null) {
            int v3 = Long.compare(zzh0.zzt(), 0xFFFFFFFF80000000L) == 0 || zzh0.zzt() == zzr0.zzj ? 0 : 1;
            String s2 = zzh0.zzr();
            if(zzh0.zzt() != 0xFFFFFFFF80000000L || s2 == null || s2.equals(zzr0.zzc)) {
                v2 = 0;
            }
            if((v3 | v2) != 0) {
                zzbg zzbg0 = new zzbg("_au", new zzbe(Y.b("_pv", s2)), "auto", v);
                if(this.zzd().zzp(null, zzfx.zzbd)) {
                    this.zzE(zzbg0, zzr0);
                    return;
                }
                this.zzF(zzbg0, zzr0);
            }
        }
    }

    public final zzh zzan(zzr zzr0) {
        boolean z1;
        this.zzaW().zzg();
        this.zzu();
        Preconditions.checkNotNull(zzr0);
        String s = zzr0.zza;
        Preconditions.checkNotEmpty(s);
        String s1 = zzr0.zzt;
        if(!s1.isEmpty()) {
            zzpc zzpc0 = new zzpc(this, s1, null);
            this.zzE.put(s, zzpc0);
        }
        zzh zzh0 = this.zzj().zzu(s);
        zzjk zzjk0 = this.zzB(s).zzs(zzjk.zzf(zzr0.zzs, 100));
        zzjj zzjj0 = zzjj.zza;
        String s2 = zzjk0.zzo(zzjj0) ? this.zzk.zzf(s, zzr0.zzn) : "";
        boolean z = true;
        if(zzh0 == null) {
            zzh zzh1 = new zzh(this.zzn, s);
            if(zzjk0.zzo(zzjj.zzb)) {
                zzh1.zze(this.zzK(zzjk0));
            }
            if(zzjk0.zzo(zzjj0)) {
                zzh1.zzk(s2);
            }
            zzh0 = zzh1;
            z1 = false;
        }
        else if(!zzjk0.zzo(zzjj0) || s2 == null || s2.equals(zzh0.zzj())) {
            if(TextUtils.isEmpty(zzh0.zzd()) && zzjk0.zzo(zzjj.zzb)) {
                zzh0.zze(this.zzK(zzjk0));
            }
            z1 = false;
        }
        else {
            boolean z2 = TextUtils.isEmpty(zzh0.zzj());
            zzh0.zzk(s2);
            if(!zzr0.zzn || "00000000-0000-0000-0000-000000000000".equals(this.zzk.zzc(s, zzjk0).first) || z2) {
                if(TextUtils.isEmpty(zzh0.zzd()) && zzjk0.zzo(zzjj.zzb)) {
                    zzh0.zze(this.zzK(zzjk0));
                }
                z1 = false;
            }
            else {
                if(zzjk0.zzo(zzjj.zzb)) {
                    zzh0.zze(this.zzK(zzjk0));
                    z1 = false;
                }
                else {
                    z1 = true;
                }
                if(this.zzj().zzm(s, "_id") != null && this.zzj().zzm(s, "_lair") == null) {
                    zzpm zzpm0 = new zzpm(s, "auto", "_lair", this.zzaZ().currentTimeMillis(), 1L);
                    this.zzj().zzl(zzpm0);
                }
            }
        }
        zzh0.zzg(zzr0.zzb);
        String s3 = zzr0.zzk;
        if(!TextUtils.isEmpty(s3)) {
            zzh0.zzm(s3);
        }
        long v = zzr0.zze;
        if(v != 0L) {
            zzh0.zzy(v);
        }
        String s4 = zzr0.zzc;
        if(!TextUtils.isEmpty(s4)) {
            zzh0.zzs(s4);
        }
        zzh0.zzu(zzr0.zzj);
        String s5 = zzr0.zzd;
        if(s5 != null) {
            zzh0.zzw(s5);
        }
        zzh0.zzA(zzr0.zzf);
        zzh0.zzE(zzr0.zzh);
        String s6 = zzr0.zzg;
        if(!TextUtils.isEmpty(s6)) {
            zzh0.zzab(s6);
        }
        zzh0.zzad(zzr0.zzn);
        zzh0.zzaf(zzr0.zzp);
        zzh0.zzC(zzr0.zzq);
        zzh0.zzi(zzr0.zzu);
        com.google.android.gms.internal.measurement.zzpn.zza();
        if(this.zzd().zzp(null, zzfx.zzaL)) {
            zzh0.zzah(zzr0.zzr);
        }
        else {
            com.google.android.gms.internal.measurement.zzpn.zza();
            if(this.zzd().zzp(null, zzfx.zzaK)) {
                zzh0.zzah(null);
            }
        }
        zzh0.zzaj(zzr0.zzv);
        zzh0.zzaz(zzr0.zzB);
        zzql.zza();
        if(this.zzd().zzp(null, zzfx.zzaP)) {
            zzh0.zzap(zzr0.zzz);
        }
        zzh0.zzal(zzr0.zzw);
        zzh0.zzaG(zzr0.zzC);
        zzh0.zzaK(zzr0.zzE);
        if(zzh0.zza()) {
            z = z1;
        }
        else if(!z1) {
            return zzh0;
        }
        this.zzj().zzv(zzh0, z, false);
        return zzh0;
    }

    public final String zzao(zzr zzr0) {
        Future future0 = this.zzaW().zzh(new zzoy(this, zzr0));
        try {
            return (String)future0.get(30000L, TimeUnit.MILLISECONDS);
        }
        catch(TimeoutException | InterruptedException | ExecutionException timeoutException0) {
            this.zzaV().zzb().zzc("Failed to get app instance id. appId", zzgt.zzl(zzr0.zza), timeoutException0);
            return null;
        }
    }

    public final List zzap(zzr zzr0, Bundle bundle0) {
        this.zzaW().zzg();
        zzql.zza();
        zzal zzal0 = this.zzd();
        String s = zzr0.zza;
        if(zzal0.zzp(s, zzfx.zzaP) && s != null) {
            if(bundle0 != null) {
                int[] arr_v = bundle0.getIntArray("uriSources");
                long[] arr_v1 = bundle0.getLongArray("uriTimestamps");
                if(arr_v != null) {
                    if(arr_v1 == null || arr_v1.length != arr_v.length) {
                        this.zzaV().zzb().zza("Uri sources and timestamps do not match");
                    }
                    else {
                        for(int v = 0; v < arr_v.length; ++v) {
                            zzav zzav0 = this.zzj();
                            int v1 = arr_v[v];
                            long v2 = arr_v1[v];
                            Preconditions.checkNotEmpty(s);
                            zzav0.zzg();
                            zzav0.zzay();
                            try {
                                int v3 = zzav0.zze().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{s, String.valueOf(v1), String.valueOf(v2)});
                                zzav0.zzu.zzaV().zzk().zzd("Pruned " + v3 + " trigger URIs. appId, source, timestamp", s, v1, v2);
                            }
                            catch(SQLiteException sQLiteException0) {
                                zzav0.zzu.zzaV().zzb().zzc("Error pruning trigger URIs. appId", zzgt.zzl(s), sQLiteException0);
                            }
                        }
                    }
                }
            }
            zzav zzav1 = this.zzj();
            String s1 = zzr0.zza;
            Preconditions.checkNotEmpty(s1);
            zzav1.zzg();
            zzav1.zzay();
            List list0 = new ArrayList();
            Cursor cursor0 = null;
            try {
                cursor0 = zzav1.zze().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{s1}, null, null, "rowid", null);
                if(cursor0.moveToFirst()) {
                    do {
                        String s2 = cursor0.getString(0);
                        if(s2 == null) {
                            s2 = "";
                        }
                        ((ArrayList)list0).add(new zzog(s2, cursor0.getLong(1), cursor0.getInt(2)));
                    }
                    while(cursor0.moveToNext());
                }
            }
            catch(SQLiteException sQLiteException1) {
                try {
                    try {
                    }
                    catch(SQLiteException sQLiteException1) {
                    }
                    zzav1.zzu.zzaV().zzb().zzc("Error querying trigger uris. appId", zzgt.zzl(s1), sQLiteException1);
                    list0 = Collections.EMPTY_LIST;
                    goto label_49;
                }
                catch(Throwable throwable0) {
                }
                goto label_47;
            }
            catch(Throwable throwable0) {
            label_47:
                TWR.safeClose$NT(cursor0, throwable0);
                throw throwable0;
            }
        label_49:
            if(cursor0 != null) {
                cursor0.close();
            }
            return list0;
        }
        return new ArrayList();
    }

    public final void zzaq(String s, zzaf zzaf0) {
        this.zzaW().zzg();
        this.zzu();
        zzav zzav0 = this.zzj();
        long v = zzaf0.zza;
        zzpi zzpi0 = zzav0.zzB(v);
        if(zzpi0 == null) {
            this.zzaV().zze().zzc("[sgtm] Queued batch doesn\'t exist. appId, rowId", s, v);
            return;
        }
        String s1 = zzpi0.zze();
        if(zzaf0.zzb == zzlq.zzb.zza()) {
            Map map0 = this.zzF;
            if(map0.containsKey(s1)) {
                map0.remove(s1);
            }
            Long long0 = v;
            this.zzj().zzE(long0);
            this.zzaV().zzk().zzc("[sgtm] queued batch deleted after successful client upload. appId, rowId", s, long0);
            long v1 = zzaf0.zzc;
            if(v1 > 0L) {
                zzav zzav1 = this.zzj();
                zzav1.zzg();
                zzav1.zzay();
                Long long1 = v1;
                Preconditions.checkNotNull(long1);
                ContentValues contentValues0 = new ContentValues();
                contentValues0.put("upload_type", zzlr.zzb.zza());
                zzib zzib0 = zzav1.zzu;
                contentValues0.put("creation_timestamp", zzib0.zzaZ().currentTimeMillis());
                try {
                    if(((long)zzav1.zze().update("upload_queue", contentValues0, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(v1), s, "4"})) != 1L) {
                        zzib0.zzaV().zze().zzc("Google Signal pending batch not updated. appId, rowId", s, long1);
                    }
                }
                catch(SQLiteException sQLiteException0) {
                    zzav1.zzu.zzaV().zzb().zzd("Failed to update google Signal pending batch. appid, rowId", s, v1, sQLiteException0);
                    throw sQLiteException0;
                }
                this.zzaV().zzk().zzc("[sgtm] queued Google Signal batch updated. appId, signalRowId", s, zzaf0.zzc);
                this.zzP(s);
                return;
            }
            return;
        }
        if(zzaf0.zzb == zzlq.zzd.zza()) {
            Map map1 = this.zzF;
            zzpd zzpd0 = (zzpd)map1.get(s1);
            if(zzpd0 == null) {
                zzpd0 = new zzpd(this);
                map1.put(s1, zzpd0);
            }
            else {
                zzpd0.zza();
            }
            long v2 = this.zzaZ().currentTimeMillis();
            this.zzaV().zzk().zzd("[sgtm] Putting sGTM server in backoff mode. appId, destination, nextRetryInSeconds", s, s1, ((long)((zzpd0.zzc() - v2) / 1000L)));
        }
        zzav zzav2 = this.zzj();
        Long long2 = zzaf0.zza;
        zzav2.zzK(long2);
        this.zzaV().zzk().zzc("[sgtm] increased batch retry count after failed client upload. appId, rowId", s, long2);
    }

    public final void zzar(boolean z) {
        this.zzaK();
    }

    public final void zzas(String s, zzlt zzlt0) {
        this.zzaW().zzg();
        if(this.zzH != null && !this.zzH.equals(s) && zzlt0 == null) {
            return;
        }
        this.zzH = s;
        this.zzG = zzlt0;
    }

    public final void zzat(zzpg zzpg0) {
        this.zzaW().zzg();
        this.zzm = new zzhj(this);
        zzav zzav0 = new zzav(this);
        zzav0.zzaz();
        this.zze = zzav0;
        this.zzd().zza(((zzak)Preconditions.checkNotNull(this.zzc)));
        zznm zznm0 = new zznm(this);
        zznm0.zzaz();
        this.zzk = zznm0;
        zzad zzad0 = new zzad(this);
        zzad0.zzaz();
        this.zzh = zzad0;
        zzlo zzlo0 = new zzlo(this);
        zzlo0.zzaz();
        this.zzj = zzlo0;
        zzoj zzoj0 = new zzoj(this);
        zzoj0.zzaz();
        this.zzg = zzoj0;
        this.zzf = new zzha(this);
        if(this.zzs != this.zzt) {
            this.zzaV().zzb().zzc("Not all upload components initialized", this.zzs, this.zzt);
        }
        this.zzo.set(true);
        this.zzaV().zzk().zza("UploadController is now fully initialized");
    }

    public final void zzau() {
        this.zzaE();
    }

    public static void zzav(Context context0, Intent intent0) {
        zzpf.zzaP(context0, intent0);
    }

    public final zzib zzaw() {
        return this.zzn;
    }

    public final Deque zzax() {
        return this.zzr;
    }

    public final void zzay(long v) {
        this.zzJ = v;
    }

    public static final void zzaz(zzhr zzhr0, int v, String s) {
        List list0 = zzhr0.zza();
        for(int v1 = 0; v1 < list0.size(); ++v1) {
        }
        zzhv zzhv0 = zzhw.zzn();
        zzhv0.zzb("_err");
        zzhv0.zzf(((long)v));
        zzhw zzhw0 = (zzhw)zzhv0.zzbc();
        zzhv zzhv1 = zzhw.zzn();
        zzhv1.zzb("_ev");
        zzhv1.zzd(s);
        zzhw zzhw1 = (zzhw)zzhv1.zzbc();
        zzhr0.zzf(zzhw0);
        zzhr0.zzf(zzhw1);
    }

    public final void zzc() {
        this.zzaW().zzg();
        this.zzj().zzI();
        zzav zzav0 = this.zzj();
        zzav0.zzg();
        zzav0.zzay();
        if(zzav0.zzai()) {
            zzfw zzfw0 = zzfx.zzav;
            if(((long)(((Long)zzfw0.zzb(null)))) != 0L) {
                SQLiteDatabase sQLiteDatabase0 = zzav0.zze();
                zzib zzib0 = zzav0.zzu;
                int v = sQLiteDatabase0.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzib0.zzaZ().currentTimeMillis()), String.valueOf(zzfw0.zzb(null))});
                if(v > 0) {
                    zzib0.zzaV().zzk().zzb("Deleted stale trigger uris. rowsDeleted", v);
                }
            }
        }
        if(this.zzk.zzd.zza() == 0L) {
            this.zzk.zzd.zzb(this.zzaZ().currentTimeMillis());
        }
        this.zzaK();
    }

    public final zzal zzd() {
        return ((zzib)Preconditions.checkNotNull(this.zzn)).zzc();
    }

    public final zzot zzf() {
        return this.zzl;
    }

    public final zzhs zzh() {
        zzpf.zzaS(this.zzc);
        return this.zzc;
    }

    public final zzgy zzi() {
        zzpf.zzaS(this.zzd);
        return this.zzd;
    }

    public final zzav zzj() {
        zzav zzav0 = this.zze;
        zzpf.zzaS(zzav0);
        return zzav0;
    }

    public final zzha zzk() {
        zzha zzha0 = this.zzf;
        if(zzha0 == null) {
            throw new IllegalStateException("Network broadcast receiver not created");
        }
        return zzha0;
    }

    public final zzoj zzl() {
        zzoj zzoj0 = this.zzg;
        zzpf.zzaS(zzoj0);
        return zzoj0;
    }

    public final zzad zzm() {
        zzad zzad0 = this.zzh;
        zzpf.zzaS(zzad0);
        return zzad0;
    }

    public final zzlo zzn() {
        zzlo zzlo0 = this.zzj;
        zzpf.zzaS(zzlo0);
        return zzlo0;
    }

    public final zzpj zzp() {
        zzpf.zzaS(this.zzi);
        return this.zzi;
    }

    public final zznm zzq() {
        return this.zzk;
    }

    public final zzgm zzs() {
        return this.zzn.zzl();
    }

    public final zzpo zzt() {
        return ((zzib)Preconditions.checkNotNull(this.zzn)).zzk();
    }

    public final void zzu() {
        if(!this.zzo.get()) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    public final void zzv(zzr zzr0) {
        this.zzaW().zzg();
        this.zzu();
        Preconditions.checkNotEmpty(zzr0.zza);
        zzjk zzjk0 = zzjk.zzf(zzr0.zzs, zzr0.zzx);
        this.zzB(zzr0.zza);
        this.zzaV().zzk().zzc("Setting storage consent for package", zzr0.zza, zzjk0);
        this.zzA(zzr0.zza, zzjk0);
    }

    public final void zzw(zzr zzr0) {
        this.zzaW().zzg();
        this.zzu();
        String s = zzr0.zza;
        Preconditions.checkNotEmpty(s);
        zzaz zzaz0 = zzaz.zzg(zzr0.zzy);
        this.zzaV().zzk().zzc("Setting DMA consent for package", s, zzaz0);
        this.zzaW().zzg();
        this.zzu();
        zzjh zzjh0 = zzaz.zzh(this.zzy(s), 100).zzc();
        this.zzD.put(s, zzaz0);
        this.zzj().zzad(s, zzaz0);
        zzjh zzjh1 = zzaz.zzh(this.zzy(s), 100).zzc();
        this.zzaW().zzg();
        this.zzu();
        boolean z = true;
        boolean z1 = zzjh0 == zzjh.zzc && zzjh1 == zzjh.zzd;
        if(zzjh0 != zzjh.zzd || zzjh1 != zzjh.zzc) {
            z = false;
        }
        if(!z1 && !z) {
            return;
        }
        this.zzaV().zzk().zzb("Generated _dcu event for", s);
        Bundle bundle0 = new Bundle();
        if(this.zzj().zzw(this.zzC(), s, false, false, false, false, false, false, false).zzf < ((long)this.zzd().zzm(s, zzfx.zzam))) {
            bundle0.putLong("_r", 1L);
            zzar zzar0 = this.zzj().zzw(this.zzC(), s, false, false, false, false, false, true, false);
            this.zzaV().zzk().zzc("_dcu realtime event count", s, zzar0.zzf);
        }
        this.zzK.zza(s, "_dcu", bundle0);
    }

    public final zzaz zzx(String s) {
        this.zzaW().zzg();
        this.zzu();
        Map map0 = this.zzD;
        zzaz zzaz0 = (zzaz)map0.get(s);
        if(zzaz0 == null) {
            zzaz0 = this.zzj().zzac(s);
            map0.put(s, zzaz0);
        }
        return zzaz0;
    }

    public final Bundle zzy(String s) {
        this.zzaW().zzg();
        this.zzu();
        if(this.zzh().zzx(s) == null) {
            return null;
        }
        Bundle bundle0 = new Bundle();
        zzjk zzjk0 = this.zzB(s);
        bundle0.putAll(zzjk0.zzn());
        bundle0.putAll(this.zzz(s, this.zzx(s), zzjk0, new zzan()).zzf());
        zzpm zzpm0 = this.zzj().zzm(s, "_npa");
        boolean z = zzpm0 == null ? this.zzaB(s, new zzan()) : zzpm0.zze.equals(1L);
        bundle0.putString("ad_personalization", (z ? "denied" : "granted"));
        return bundle0;
    }

    public final zzaz zzz(String s, zzaz zzaz0, zzjk zzjk0, zzan zzan0) {
        int v = 90;
        if(this.zzh().zzx(s) == null) {
            if(zzaz0.zzc() == zzjh.zzc) {
                v = zzaz0.zzb();
                zzan0.zzb(zzjj.zzc, v);
                return new zzaz(Boolean.FALSE, v, Boolean.TRUE, "-");
            }
            zzan0.zzc(zzjj.zzc, zzam.zzj);
            return new zzaz(Boolean.FALSE, 90, Boolean.TRUE, "-");
        }
        zzjh zzjh0 = zzaz0.zzc();
        zzjh zzjh1 = zzjh.zzd;
        if(zzjh0 == zzjh1) {
            v = zzaz0.zzb();
            zzan0.zzb(zzjj.zzc, v);
        }
        else {
            zzjh zzjh2 = zzjh.zzc;
            if(zzjh0 == zzjh2) {
                v = zzaz0.zzb();
                zzan0.zzb(zzjj.zzc, v);
            }
            else if(zzjh0 == zzjh.zzb) {
                zzjj zzjj0 = zzjj.zzc;
                zzjh zzjh3 = this.zzc.zzA(s, zzjj0);
                if(zzjh3 != zzjh.zza) {
                    zzan0.zzc(zzjj0, zzam.zzi);
                    zzjh0 = zzjh3;
                    goto label_39;
                }
                goto label_20;
            }
            else {
            label_20:
                zzhs zzhs0 = this.zzc;
                zzjj zzjj1 = zzjj.zzc;
                zzjj zzjj2 = zzhs0.zzw(s, zzjj1);
                zzjh zzjh4 = zzjk0.zzp();
                if(zzjj2 != zzjj.zza || zzjh4 != zzjh1 && zzjh4 != zzjh2) {
                    zzan0.zzc(zzjj1, zzam.zzb);
                    zzjh0 = zzhs0.zzv(s, zzjj1) ? zzjh1 : zzjh2;
                }
                else {
                    zzan0.zzc(zzjj1, zzam.zzc);
                    zzjh0 = zzjh4;
                }
            }
        }
    label_39:
        boolean z = this.zzc.zzy(s);
        SortedSet sortedSet0 = this.zzh().zzz(s);
        if(zzjh0 != zzjh.zzc && !sortedSet0.isEmpty()) {
            String s1 = z ? TextUtils.join("", sortedSet0) : "";
            return new zzaz(Boolean.TRUE, v, Boolean.valueOf(z), s1);
        }
        return new zzaz(Boolean.FALSE, v, Boolean.valueOf(z), "-");
    }
}

