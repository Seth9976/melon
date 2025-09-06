package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import b3.Z;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzcu;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import k8.Y;

public final class zznk extends zzg {
    private final zzne zza;
    private zzga zzb;
    private volatile Boolean zzc;
    private final zzay zzd;
    private ScheduledExecutorService zze;
    private final zzof zzf;
    private final List zzg;
    private final zzay zzh;

    public zznk(zzib zzib0) {
        super(zzib0);
        this.zzg = new ArrayList();
        this.zzf = new zzof(zzib0.zzaZ());
        this.zza = new zzne(this);
        this.zzd = new zzml(this, zzib0);
        this.zzh = new zzmp(this, zzib0);
    }

    public final void zzA(zzpk zzpk0) {
        this.zzg();
        this.zzb();
        boolean z = this.zzu.zzm().zzj(zzpk0);
        this.zzaf(new zzmf(this, this.zzah(true), z, zzpk0));
    }

    public final void zzB() {
        this.zzg();
        this.zzb();
        zzr zzr0 = this.zzah(false);
        this.zzu.zzm().zzh();
        this.zzaf(new zzmg(this, zzr0));
    }

    public final void zzC(AtomicReference atomicReference0) {
        this.zzg();
        this.zzb();
        this.zzaf(new zzmh(this, atomicReference0, this.zzah(false)));
    }

    public final void zzD(zzcu zzcu0) {
        this.zzg();
        this.zzb();
        this.zzaf(new zzmi(this, this.zzah(false), zzcu0));
    }

    public final void zzE() {
        this.zzg();
        this.zzb();
        zzr zzr0 = this.zzah(true);
        this.zzu.zzc().zzp(null, zzfx.zzbc);
        this.zzu.zzm().zzn();
        this.zzaf(new zzmj(this, zzr0, true));
    }

    public final void zzF() {
        this.zzg();
        this.zzb();
        this.zzaf(new zzmk(this, this.zzah(true)));
    }

    public final void zzG(zzlt zzlt0) {
        this.zzg();
        this.zzb();
        this.zzaf(new zzmm(this, zzlt0));
    }

    public final void zzH(Bundle bundle0) {
        this.zzg();
        this.zzb();
        zzbe zzbe0 = new zzbe(bundle0);
        boolean z = this.zzu.zzc().zzp(null, zzfx.zzbc) && this.zzu.zzm().zzl(zzbe0);
        this.zzaf(new zzmn(this, true, this.zzah(false), z, zzbe0, bundle0));
    }

    public final void zzI() {
        this.zzg();
        this.zzb();
        if(!this.zzh()) {
            if(this.zzK()) {
                this.zza.zzc();
                return;
            }
            zzib zzib0 = this.zzu;
            if(!zzib0.zzc().zzE()) {
                List list0 = zzib0.zzaY().getPackageManager().queryIntentServices(new Intent().setClassName(zzib0.zzaY(), "com.google.android.gms.measurement.AppMeasurementService"), 0x10000);
                if(list0 != null && !list0.isEmpty()) {
                    Intent intent0 = new Intent("com.google.android.gms.measurement.START");
                    intent0.setComponent(new ComponentName(zzib0.zzaY(), "com.google.android.gms.measurement.AppMeasurementService"));
                    this.zza.zza(intent0);
                    return;
                }
                Z.u(zzib0, "Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    public final Boolean zzJ() {
        return this.zzc;
    }

    public final boolean zzK() {
        this.zzg();
        this.zzb();
        if(this.zzc == null) {
            this.zzg();
            this.zzb();
            zzib zzib0 = this.zzu;
            zzhg zzhg0 = zzib0.zzd();
            zzhg0.zzg();
            boolean z = false;
            Boolean boolean0 = zzhg0.zzd().contains("use_service") ? Boolean.valueOf(zzhg0.zzd().getBoolean("use_service", false)) : null;
            boolean z1 = true;
            if(boolean0 == null || !boolean0.booleanValue()) {
                if(this.zzu.zzv().zzo() == 1) {
                    z = true;
                }
                else {
                    zzib0.zzaV().zzk().zza("Checking service availability");
                    int v = zzib0.zzk().zzai(12451000);
                    switch(v) {
                        case 0: {
                            zzib0.zzaV().zzk().zza("Service available");
                            z = true;
                            break;
                        }
                        case 1: {
                            zzib0.zzaV().zzk().zza("Service missing");
                            break;
                        }
                        case 2: {
                            zzib0.zzaV().zzj().zza("Service container out of date");
                            if(zzib0.zzk().zzah() >= 0x4423) {
                                if(boolean0 != null) {
                                    z1 = false;
                                }
                                z = z1;
                                z1 = false;
                            }
                            break;
                        }
                        case 3: {
                            Z.A(zzib0, "Service disabled");
                            z1 = false;
                            break;
                        }
                        case 9: {
                            Z.A(zzib0, "Service invalid");
                            z1 = false;
                            break;
                        }
                        case 18: {
                            Z.A(zzib0, "Service updating");
                            z = true;
                            break;
                        }
                        default: {
                            zzib0.zzaV().zze().zzb("Unexpected service status", v);
                            z1 = false;
                        }
                    }
                }
                if(!z && zzib0.zzc().zzE()) {
                    Z.u(zzib0, "No way to upload. Consider using the full version of Analytics");
                }
                else if(z1) {
                    zzhg zzhg1 = zzib0.zzd();
                    zzhg1.zzg();
                    SharedPreferences.Editor sharedPreferences$Editor0 = zzhg1.zzd().edit();
                    sharedPreferences$Editor0.putBoolean("use_service", z);
                    sharedPreferences$Editor0.apply();
                }
                z1 = z;
            }
            this.zzc = Boolean.valueOf(z1);
        }
        return this.zzc.booleanValue();
    }

    public final void zzL(zzga zzga0) {
        this.zzg();
        Preconditions.checkNotNull(zzga0);
        this.zzb = zzga0;
        this.zzae();
        this.zzag();
    }

    public final void zzM() {
        this.zzg();
        this.zzb();
        this.zza.zzb();
        try {
            ConnectionTracker.getInstance().unbindService(this.zzu.zzaY(), this.zza);
        }
        catch(IllegalStateException | IllegalArgumentException unused_ex) {
        }
        this.zzb = null;
    }

    public final void zzN(zzcu zzcu0, zzbg zzbg0, String s) {
        this.zzg();
        this.zzb();
        zzib zzib0 = this.zzu;
        if(zzib0.zzk().zzai(12451000) != 0) {
            zzib0.zzaV().zze().zza("Not bundling data. Service unavailable or out of date");
            zzib0.zzk().zzao(zzcu0, new byte[0]);
            return;
        }
        this.zzaf(new zzmo(this, zzbg0, s, zzcu0));
    }

    public final boolean zzO() {
        this.zzg();
        this.zzb();
        return !this.zzK() || this.zzu.zzk().zzah() >= ((int)(((Integer)zzfx.zzaJ.zzb(null))));
    }

    public final boolean zzP() {
        this.zzg();
        this.zzb();
        return !this.zzK() || this.zzu.zzk().zzah() >= 241200;
    }

    // 检测为 Lambda 实现
    public final void zzQ() [...]

    // 检测为 Lambda 实现
    public final void zzR() [...]

    // 检测为 Lambda 实现
    public final void zzS(AtomicReference atomicReference0, zzr zzr0, Bundle bundle0) [...]

    // 检测为 Lambda 实现
    public final void zzT(AtomicReference atomicReference0, zzr zzr0, zzon zzon0) [...]

    // 检测为 Lambda 实现
    public final void zzU(zzr zzr0, zzaf zzaf0) [...]

    public final void zzV() {
        this.zzae();
    }

    public final void zzW(ComponentName componentName0) {
        this.zzg();
        if(this.zzb != null) {
            this.zzb = null;
            this.zzu.zzaV().zzk().zzb("Disconnected from device MeasurementService", componentName0);
            this.zzg();
            this.zzI();
        }
    }

    public final void zzX() {
        this.zzag();
    }

    public final zzne zzY() {
        return this.zza;
    }

    public final zzga zzZ() {
        return this.zzb;
    }

    public final void zzaa(zzga zzga0) {
        this.zzb = null;
    }

    public final ScheduledExecutorService zzab() {
        return this.zze;
    }

    public final void zzac(ScheduledExecutorService scheduledExecutorService0) {
        this.zze = scheduledExecutorService0;
    }

    private final boolean zzad() {
        return true;
    }

    private final void zzae() {
        this.zzg();
        this.zzf.zza();
        long v = (long)(((Long)zzfx.zzY.zzb(null)));
        this.zzd.zzb(v);
    }

    private final void zzaf(Runnable runnable0) {
        this.zzg();
        if(this.zzh()) {
            runnable0.run();
            return;
        }
        List list0 = this.zzg;
        zzib zzib0 = this.zzu;
        if(((long)list0.size()) >= 1000L) {
            Z.u(zzib0, "Discarding data. Max runnable queue size reached");
            return;
        }
        list0.add(runnable0);
        this.zzh.zzb(60000L);
        this.zzI();
    }

    private final void zzag() {
        this.zzg();
        this.zzu.zzaV().zzk().zzb("Processing queued up service tasks", this.zzg.size());
        for(Object object0: this.zzg) {
            Runnable runnable0 = (Runnable)object0;
            try {
                runnable0.run();
            }
            catch(RuntimeException runtimeException0) {
                this.zzu.zzaV().zzb().zzb("Task exception while flushing queue", runtimeException0);
            }
        }
        this.zzg.clear();
        this.zzh.zzd();
    }

    private final zzr zzah(boolean z) {
        zzib zzib0 = this.zzu;
        zzgh zzgh0 = this.zzu.zzv();
        String s = null;
        if(z) {
            zzib zzib1 = zzib0.zzaV().zzu;
            if(zzib1.zzd().zzb != null) {
                Pair pair0 = zzib1.zzd().zzb.zzb();
                if(pair0 != null && pair0 != zzhg.zza) {
                    String s1 = String.valueOf(pair0.second);
                    String s2 = (String)pair0.first;
                    s = Y.l(new StringBuilder(s1.length() + 1 + String.valueOf(s2).length()), s1, ":", s2);
                }
            }
        }
        return zzgh0.zzh(s);
    }

    @Override  // com.google.android.gms.measurement.internal.zzg
    public final boolean zze() {
        return false;
    }

    public final boolean zzh() {
        this.zzg();
        this.zzb();
        return this.zzb != null;
    }

    public final void zzi() {
        this.zzg();
        this.zzb();
        this.zzaf(new zzmq(this, this.zzah(true)));
    }

    public final void zzj(boolean z) {
        this.zzg();
        this.zzb();
        if(this.zzO()) {
            this.zzaf(new zzmr(this, this.zzah(false)));
        }
    }

    public final void zzk(boolean z) {
        this.zzg();
        this.zzb();
        this.zzaf(() -> {
            zzga zzga0 = this.zzb;
            if(zzga0 == null) {
                Z.u(this.zzu, "Failed to send storage consent settings to service");
                return;
            }
            try {
                zzr zzr0 = this.zzah(false);
                Preconditions.checkNotNull(zzr0);
                zzga0.zzy(zzr0);
                this.zzae();
            }
            catch(RemoteException remoteException0) {
                this.zzu.zzaV().zzb().zzb("Failed to send storage consent settings to the service", remoteException0);
            }
        });
    }

    public final void zzl() {
        this.zzg();
        this.zzb();
        this.zzaf(() -> {
            zzga zzga0 = this.zzb;
            if(zzga0 == null) {
                Z.u(this.zzu, "Failed to send Dma consent settings to service");
                return;
            }
            try {
                zzr zzr0 = this.zzah(false);
                Preconditions.checkNotNull(zzr0);
                zzga0.zzz(zzr0);
                this.zzae();
            }
            catch(RemoteException remoteException0) {
                this.zzu.zzaV().zzb().zzb("Failed to send Dma consent settings to the service", remoteException0);
            }
        });
    }

    public final void zzm(zzga zzga0, AbstractSafeParcelable abstractSafeParcelable0, zzr zzr0) {
        long v7;
        long v6;
        long v5;
        zzr zzr2;
        int v4;
        this.zzg();
        this.zzb();
        zzib zzib0 = this.zzu;
        zzr zzr1 = zzr0;
        int v = 100;
        int v1 = 0;
        while(v1 < 1001 && v == 100) {
            ArrayList arrayList0 = new ArrayList();
            List list0 = this.zzu.zzm().zzm(100);
            if(list0 == null) {
                v = 0;
            }
            else {
                arrayList0.addAll(list0);
                v = list0.size();
            }
            if(abstractSafeParcelable0 != null && v < 100) {
                arrayList0.add(new zzgj(abstractSafeParcelable0, zzr1.zzc, zzr1.zzj));
            }
            boolean z = zzib0.zzc().zzp(null, zzfx.zzaO);
            int v2 = arrayList0.size();
            int v3 = 0;
            while(v3 < v2) {
                zzgj zzgj0 = (zzgj)arrayList0.get(v3);
                AbstractSafeParcelable abstractSafeParcelable1 = zzgj0.zza;
                zzfw zzfw0 = zzfx.zzbc;
                if(zzib0.zzc().zzp(null, zzfw0)) {
                    String s = zzgj0.zzb;
                    if(!TextUtils.isEmpty(s)) {
                        v4 = v3;
                        zzr2 = new zzr(zzr1.zza, zzr1.zzb, s, zzgj0.zzc, zzr1.zzd, zzr1.zze, zzr1.zzf, zzr1.zzg, zzr1.zzh, zzr1.zzi, zzr1.zzk, zzr1.zzl, zzr1.zzm, zzr1.zzn, zzr1.zzo, zzr1.zzp, zzr1.zzq, zzr1.zzr, zzr1.zzs, zzr1.zzt, zzr1.zzu, zzr1.zzv, zzr1.zzw, zzr1.zzx, zzr1.zzy, zzr1.zzz, zzr1.zzA, zzr1.zzB, zzr1.zzC, zzr1.zzD, zzr1.zzE);
                    }
                }
                else {
                    v4 = v3;
                    zzr2 = zzr1;
                }
                if(abstractSafeParcelable1 instanceof zzbg) {
                    if(z) {
                        try {
                            v5 = this.zzu.zzaZ().currentTimeMillis();
                        }
                        catch(RemoteException remoteException0) {
                            v6 = 0L;
                            v7 = 0L;
                            goto label_51;
                        }
                        try {
                            v7 = v5;
                            v6 = 0L;
                            v6 = this.zzu.zzaZ().elapsedRealtime();
                            goto label_45;
                        label_43:
                            v6 = 0L;
                            v7 = 0L;
                        label_45:
                            zzga0.zze(((zzbg)abstractSafeParcelable1), zzr2);
                            if(z) {
                                zzib0.zzaV().zzk().zza("Logging telemetry for logEvent from database");
                                zzgp.zza(this.zzu).zzb(36301, 0, v7, this.zzu.zzaZ().currentTimeMillis(), ((int)(this.zzu.zzaZ().elapsedRealtime() - v6)));
                            }
                            goto label_75;
                        }
                        catch(RemoteException remoteException0) {
                            goto label_51;
                        }
                    }
                    else {
                        goto label_43;
                    }
                    goto label_45;
                label_51:
                    this.zzu.zzaV().zzb().zzb("Failed to send event to the service", remoteException0);
                    if(z && v7 != 0L) {
                        zzgp.zza(this.zzu).zzb(36301, 13, v7, this.zzu.zzaZ().currentTimeMillis(), ((int)(this.zzu.zzaZ().elapsedRealtime() - v6)));
                    }
                }
                else if(abstractSafeParcelable1 instanceof zzpk) {
                    try {
                        zzga0.zzf(((zzpk)abstractSafeParcelable1), zzr2);
                    }
                    catch(RemoteException remoteException1) {
                        this.zzu.zzaV().zzb().zzb("Failed to send user property to the service", remoteException1);
                    }
                }
                else if(abstractSafeParcelable1 instanceof zzah) {
                    try {
                        zzga0.zzn(((zzah)abstractSafeParcelable1), zzr2);
                    }
                    catch(RemoteException remoteException2) {
                        this.zzu.zzaV().zzb().zzb("Failed to send conditional user property to the service", remoteException2);
                    }
                }
                else {
                    zzib zzib1 = this.zzu;
                    if(!zzib1.zzc().zzp(null, zzfw0) || !(abstractSafeParcelable1 instanceof zzbe)) {
                        Z.u(zzib1, "Discarding data. Unrecognized parcel type.");
                    }
                    else {
                        try {
                            zzga0.zzu(((zzbe)abstractSafeParcelable1).zzf(), zzr2);
                        }
                        catch(RemoteException remoteException3) {
                            this.zzu.zzaV().zzb().zzb("Failed to send default event parameters to the service", remoteException3);
                        }
                    }
                }
            label_75:
                v3 = v4 + 1;
                zzr1 = zzr2;
            }
            ++v1;
        }
    }

    public final void zzn(zzbg zzbg0, String s) {
        Preconditions.checkNotNull(zzbg0);
        this.zzg();
        this.zzb();
        boolean z = this.zzu.zzm().zzi(zzbg0);
        this.zzaf(new zzms(this, true, this.zzah(true), z, zzbg0, s));
    }

    public final void zzp(zzah zzah0) {
        Preconditions.checkNotNull(zzah0);
        this.zzg();
        this.zzb();
        boolean z = this.zzu.zzm().zzk(zzah0);
        zzah zzah1 = new zzah(zzah0);
        this.zzaf(new zzmt(this, true, this.zzah(true), z, zzah1, zzah0));
    }

    public final void zzq(AtomicReference atomicReference0, String s, String s1, String s2) {
        this.zzg();
        this.zzb();
        this.zzaf(new zzmu(this, atomicReference0, null, s1, s2, this.zzah(false)));
    }

    public final void zzs(zzcu zzcu0, String s, String s1) {
        this.zzg();
        this.zzb();
        this.zzaf(new zzmv(this, s, s1, this.zzah(false), zzcu0));
    }

    public final void zzt(AtomicReference atomicReference0, String s, String s1, String s2, boolean z) {
        this.zzg();
        this.zzb();
        this.zzaf(new zzmw(this, atomicReference0, null, s1, s2, this.zzah(false), z));
    }

    public final void zzu(zzcu zzcu0, String s, String s1, boolean z) {
        this.zzg();
        this.zzb();
        this.zzaf(new zzmb(this, s, s1, this.zzah(false), z, zzcu0));
    }

    public final void zzv(AtomicReference atomicReference0, boolean z) {
        this.zzg();
        this.zzb();
        this.zzaf(new zzmc(this, atomicReference0, this.zzah(false), z));
    }

    public final void zzw(AtomicReference atomicReference0, Bundle bundle0) {
        this.zzg();
        this.zzb();
        this.zzaf(() -> {
            zzga zzga0;
            synchronized(atomicReference0) {
                try {
                    zzga0 = this.zzb;
                    if(zzga0 == null) {
                        this.zzu.zzaV().zzb().zza("Failed to request trigger URIs; not connected to service");
                        return;
                    }
                    goto label_9;
                }
                catch(RemoteException remoteException0) {
                    this.zzu.zzaV().zzb().zzb("Failed to request trigger URIs; remote exception", remoteException0);
                    atomicReference0.notifyAll();
                    return;
                }
            }
            return;
            try {
            label_9:
                Preconditions.checkNotNull(this.zzah(false));
                zzga0.zzD(this.zzah(false), bundle0, new zzmd(this, atomicReference0));
                this.zzae();
            }
            catch(RemoteException remoteException0) {
                this.zzu.zzaV().zzb().zzb("Failed to request trigger URIs; remote exception", remoteException0);
                atomicReference0.notifyAll();
            }
        });
    }

    public final void zzx(AtomicReference atomicReference0, zzon zzon0) {
        this.zzg();
        this.zzb();
        this.zzaf(() -> {
            zzga zzga0;
            synchronized(atomicReference0) {
                try {
                    zzga0 = this.zzb;
                    if(zzga0 == null) {
                        this.zzu.zzaV().zzb().zza("[sgtm] Failed to get upload batches; not connected to service");
                        return;
                    }
                    goto label_9;
                }
                catch(RemoteException remoteException0) {
                    this.zzu.zzaV().zzb().zzb("[sgtm] Failed to get upload batches; remote exception", remoteException0);
                    atomicReference0.notifyAll();
                    return;
                }
            }
            return;
            try {
            label_9:
                Preconditions.checkNotNull(this.zzah(false));
                zzga0.zzB(this.zzah(false), zzon0, new zzme(this, atomicReference0));
                this.zzae();
            }
            catch(RemoteException remoteException0) {
                this.zzu.zzaV().zzb().zzb("[sgtm] Failed to get upload batches; remote exception", remoteException0);
                atomicReference0.notifyAll();
            }
        });
    }

    public final void zzy(zzaf zzaf0) {
        this.zzg();
        this.zzb();
        zzr zzr0 = this.zzah(true);
        Preconditions.checkNotNull(zzr0);
        this.zzaf(() -> {
            zzga zzga0 = this.zzb;
            if(zzga0 == null) {
                Z.u(this.zzu, "[sgtm] Discarding data. Failed to update batch upload status.");
                return;
            }
            try {
                zzga0.zzC(zzr0, zzaf0);
                this.zzae();
            }
            catch(RemoteException remoteException0) {
                this.zzu.zzaV().zzb().zzc("[sgtm] Failed to update batch upload status, rowId, exception", zzaf0.zza, remoteException0);
            }
        });
    }

    public final zzao zzz() {
        this.zzg();
        this.zzb();
        zzga zzga0 = this.zzb;
        if(zzga0 == null) {
            this.zzI();
            this.zzu.zzaV().zzj().zza("Failed to get consents; not connected to service yet.");
            return null;
        }
        zzr zzr0 = this.zzah(false);
        Preconditions.checkNotNull(zzr0);
        try {
            zzao zzao0 = zzga0.zzw(zzr0);
            this.zzae();
            return zzao0;
        }
        catch(RemoteException remoteException0) {
            this.zzu.zzaV().zzb().zzb("Failed to get consents; remote exception", remoteException0);
            return null;
        }
    }
}

