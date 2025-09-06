package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzmq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class zzjc extends zzfz {
    private final zzpf zza;
    private Boolean zzb;
    private String zzc;

    public zzjc(zzpf zzpf0, String s) {
        Preconditions.checkNotNull(zzpf0);
        this.zza = zzpf0;
        this.zzc = null;
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzA(zzr zzr0) {
        this.zzN(zzr0, false);
        this.zzd(new zzie(this, zzr0));
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzB(zzr zzr0, zzon zzon0, zzgg zzgg0) {
        this.zzN(zzr0, false);
        String s = (String)Preconditions.checkNotNull(zzr0.zza);
        this.zza.zzaW().zzj(() -> {
            zzpf zzpf0 = this.zza;
            zzpf0.zzY();
            zzpf0.zzaW().zzg();
            zzpf0.zzu();
            List list0 = zzpf0.zzj().zzC(s, zzon0, ((int)(((Integer)zzfx.zzA.zzb(null)))));
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: list0) {
                zzpi zzpi0 = (zzpi)object0;
                if(zzpf0.zzO(s, zzpi0.zze())) {
                    int v = zzpi0.zzi();
                    if(v > 0) {
                        if(v <= ((int)(((Integer)zzfx.zzy.zzb(null))))) {
                            long v1 = Math.min(((long)(((Long)zzfx.zzw.zzb(null)))) * (1L << v - 1), ((long)(((Long)zzfx.zzx.zzb(null)))));
                            if(zzpf0.zzaZ().currentTimeMillis() < zzpi0.zzh() + v1) {
                                zzpf0.zzaV().zzk().zzd("[sgtm] batch skipped waiting for next retry. appId, rowId, lastUploadMillis", s, zzpi0.zzc(), zzpi0.zzh());
                                continue;
                            }
                        }
                        else {
                            zzpf0.zzaV().zzk().zzd("[sgtm] batch skipped waiting for next retry. appId, rowId, lastUploadMillis", s, zzpi0.zzc(), zzpi0.zzh());
                            continue;
                        }
                    }
                    zzol zzol0 = zzpi0.zzb();
                    try {
                        zzhz zzhz0 = (zzhz)zzpj.zzw(zzib.zzh(), zzol0.zzb);
                        for(int v2 = 0; v2 < zzhz0.zzb(); ++v2) {
                            zzic zzic0 = (zzic)zzhz0.zzc(v2).zzcl();
                            zzic0.zzs(zzpf0.zzaZ().currentTimeMillis());
                            zzhz0.zzd(v2, zzic0);
                        }
                        zzol0.zzb = ((zzib)zzhz0.zzbc()).zzcc();
                        if(Log.isLoggable(zzpf0.zzaV().zzn(), 2)) {
                            zzol0.zzg = zzpf0.zzp().zzi(((zzib)zzhz0.zzbc()));
                        }
                    }
                    catch(zzmq unused_ex) {
                        zzpf0.zzaV().zze().zzb("Failed to parse queued batch. appId", s);
                        continue;
                    }
                    arrayList0.add(zzol0);
                }
                else {
                    zzpf0.zzaV().zzk().zzd("[sgtm] batch skipped due to destination in backoff. appId, rowId, url", s, zzpi0.zzc(), zzpi0.zze());
                }
            }
            zzop zzop0 = new zzop(arrayList0);
            try {
                zzgg0.zze(zzop0);
                this.zza.zzaV().zzk().zzc("[sgtm] Sending queued upload batches to client. appId, count", s, zzop0.zza.size());
            }
            catch(RemoteException remoteException0) {
                this.zza.zzaV().zzb().zzc("[sgtm] Failed to return upload batches for app", s, remoteException0);
            }
        });
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzC(zzr zzr0, zzaf zzaf0) {
        this.zzN(zzr0, false);
        this.zzd(() -> {
            this.zza.zzY();
            String s = (String)Preconditions.checkNotNull(zzr0.zza);
            this.zza.zzaq(s, zzaf0);
        });
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzD(zzr zzr0, Bundle bundle0, zzgd zzgd0) {
        this.zzN(zzr0, false);
        Object object0 = Preconditions.checkNotNull(zzr0.zza);
        this.zza.zzaW().zzj(() -> {
            this.zza.zzY();
            List list0 = this.zza.zzap(zzr0, bundle0);
            try {
                zzgd0.zze(list0);
            }
            catch(RemoteException remoteException0) {
                this.zza.zzaV().zzb().zzc("Failed to return trigger URIs for app", ((String)object0), remoteException0);
            }
        });
    }

    public final void zzE(Runnable runnable0) {
        Preconditions.checkNotNull(runnable0);
        zzpf zzpf0 = this.zza;
        if(zzpf0.zzaW().zze()) {
            runnable0.run();
            return;
        }
        zzpf0.zzaW().zzl(runnable0);
    }

    // 检测为 Lambda 实现
    public final void zzF(zzr zzr0) [...]

    // 检测为 Lambda 实现
    public final void zzG(zzr zzr0) [...]

    // 检测为 Lambda 实现
    public final void zzH(zzr zzr0, Bundle bundle0, zzgd zzgd0, String s) [...]

    // 检测为 Lambda 实现
    public final void zzI(String s, zzon zzon0, zzgg zzgg0) [...]

    // 检测为 Lambda 实现
    public final void zzJ(zzr zzr0, zzaf zzaf0) [...]

    // 检测为 Lambda 实现
    public final void zzK(Bundle bundle0, String s, zzr zzr0) [...]

    public final zzpf zzL() {
        return this.zza;
    }

    private final void zzM(zzbg zzbg0, zzr zzr0) {
        this.zza.zzY();
        this.zza.zzF(zzbg0, zzr0);
    }

    private final void zzN(zzr zzr0, boolean z) {
        Preconditions.checkNotNull(zzr0);
        Preconditions.checkNotEmpty(zzr0.zza);
        this.zzO(zzr0.zza, false);
        this.zza.zzt().zzA(zzr0.zzb);
    }

    private final void zzO(String s, boolean z) {
        boolean z1 = true;
        if(!TextUtils.isEmpty(s)) {
            try {
                if(z) {
                    if(this.zzb == null) {
                        if(!"com.google.android.gms".equals(this.zzc) && (!UidVerifier.isGooglePlayServicesUid(this.zza.zzaY(), Binder.getCallingUid()) && !GoogleSignatureVerifier.getInstance(this.zza.zzaY()).isUidGoogleSigned(Binder.getCallingUid()))) {
                            z1 = false;
                        }
                        this.zzb = Boolean.valueOf(z1);
                    }
                    if(!this.zzb.booleanValue()) {
                        goto label_8;
                    }
                    return;
                }
            label_8:
                if(this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzaY(), Binder.getCallingUid(), s)) {
                    this.zzc = s;
                }
                if(!s.equals(this.zzc)) {
                    throw new SecurityException("Unknown calling package name \'" + s + "\'.");
                }
                return;
            }
            catch(SecurityException securityException0) {
            }
            this.zza.zzaV().zzb().zzb("Measurement Service called with invalid calling package. appId", zzgt.zzl(s));
            throw securityException0;
        }
        this.zza.zzaV().zzb().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    public final void zzb(zzbg zzbg0, zzr zzr0) {
        zzpf zzpf0 = this.zza;
        zzhs zzhs0 = zzpf0.zzh();
        zzc zzc0 = TextUtils.isEmpty(zzr0.zza) ? null : ((zzc)zzhs0.zzd.get(zzr0.zza));
        if(zzc0 != null) {
            try {
                Map map0 = zzpf0.zzp().zzz(zzbg0.zzb.zzf(), true);
                String s = zzbg0.zza;
                String s1 = zzjl.zza(s);
                if(s1 != null) {
                    s = s1;
                }
                if(zzc0.zzb(new zzaa(s, zzbg0.zzd, map0))) {
                    goto label_13;
                }
            }
            catch(zzd unused_ex) {
                this.zza.zzaV().zzb().zzc("EES error. appId, eventName", zzr0.zzb, zzbg0.zza);
            }
            this.zza.zzaV().zzk().zzb("EES was not applied to event", zzbg0.zza);
            this.zzM(zzbg0, zzr0);
            return;
        label_13:
            if(zzc0.zzc()) {
                this.zza.zzaV().zzk().zzb("EES edited event", zzbg0.zza);
                this.zzM(this.zza.zzp().zzA(zzc0.zze().zzc()), zzr0);
            }
            else {
                this.zzM(zzbg0, zzr0);
            }
            if(zzc0.zzd()) {
                for(Object object0: zzc0.zze().zzf()) {
                    this.zza.zzaV().zzk().zzb("EES logging created event", ((zzaa)object0).zzb());
                    this.zzM(this.zza.zzp().zzA(((zzaa)object0)), zzr0);
                }
            }
            return;
        }
        this.zza.zzaV().zzk().zzb("EES not loaded for", zzr0.zza);
        this.zzM(zzbg0, zzr0);
    }

    public final zzbg zzc(zzbg zzbg0, zzr zzr0) {
        if("_cmp".equals(zzbg0.zza)) {
            zzbe zzbe0 = zzbg0.zzb;
            if(zzbe0 != null && zzbe0.zze() != 0) {
                String s = zzbe0.zzd("_cis");
                if("referrer broadcast".equals(s) || "referrer API".equals(s)) {
                    this.zza.zzaV().zzi().zzb("Event has been filtered ", zzbg0.toString());
                    return new zzbg("_cmpx", zzbe0, zzbg0.zzc, zzbg0.zzd);
                }
            }
        }
        return zzbg0;
    }

    public final void zzd(Runnable runnable0) {
        Preconditions.checkNotNull(runnable0);
        zzpf zzpf0 = this.zza;
        if(zzpf0.zzaW().zze()) {
            runnable0.run();
            return;
        }
        zzpf0.zzaW().zzj(runnable0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zze(zzbg zzbg0, zzr zzr0) {
        Preconditions.checkNotNull(zzbg0);
        this.zzN(zzr0, false);
        this.zzd(new zziq(this, zzbg0, zzr0));
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzf(zzpk zzpk0, zzr zzr0) {
        Preconditions.checkNotNull(zzpk0);
        this.zzN(zzr0, false);
        this.zzd(new zzit(this, zzpk0, zzr0));
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzg(zzr zzr0) {
        this.zzN(zzr0, false);
        this.zzd(new zzid(this, zzr0));
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzh(zzbg zzbg0, String s, String s1) {
        Preconditions.checkNotNull(zzbg0);
        Preconditions.checkNotEmpty(s);
        this.zzO(s, true);
        this.zzd(new zzir(this, zzbg0, s));
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzi(zzr zzr0) {
        this.zzN(zzr0, false);
        this.zzd(new zzim(this, zzr0));
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final List zzj(zzr zzr0, boolean z) {
        this.zzN(zzr0, false);
        Preconditions.checkNotNull(zzr0.zza);
        Future future0 = this.zza.zzaW().zzh(new com.google.android.gms.measurement.internal.zzic(this, zzr0.zza));
        try {
            List list0 = (List)future0.get();
            List list1 = new ArrayList(list0.size());
            for(Object object0: list0) {
                zzpm zzpm0 = (zzpm)object0;
                if(z || !zzpo.zzZ(zzpm0.zzc)) {
                    ((ArrayList)list1).add(new zzpk(zzpm0));
                }
            }
            return list1;
        }
        catch(InterruptedException | ExecutionException interruptedException0) {
        }
        this.zza.zzaV().zzb().zzc("Failed to get user properties. appId", zzgt.zzl(zzr0.zza), interruptedException0);
        return null;
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final byte[] zzk(zzbg zzbg0, String s) {
        Preconditions.checkNotEmpty(s);
        Preconditions.checkNotNull(zzbg0);
        this.zzO(s, true);
        zzpf zzpf0 = this.zza;
        zzgr zzgr0 = zzpf0.zzaV().zzj();
        String s1 = zzbg0.zza;
        zzgr0.zzb("Log and bundle. event", zzpf0.zzs().zza(s1));
        long v = zzpf0.zzaZ().nanoTime();
        Future future0 = zzpf0.zzaW().zzi(new zzis(this, zzbg0, s));
        try {
            byte[] arr_b = (byte[])future0.get();
            if(arr_b == null) {
                zzpf0.zzaV().zzb().zzb("Log and bundle returned null. appId", zzgt.zzl(s));
                arr_b = new byte[0];
            }
            long v1 = zzpf0.zzaZ().nanoTime();
            zzpf0.zzaV().zzj().zzd("Log and bundle processed. event, size, time_ms", zzpf0.zzs().zza(s1), ((int)arr_b.length), ((long)(v1 / 1000000L - v / 1000000L)));
            return arr_b;
        }
        catch(InterruptedException | ExecutionException interruptedException0) {
        }
        this.zza.zzaV().zzb().zzd("Failed to log and bundle. appId, event, error", zzgt.zzl(s), this.zza.zzs().zza(zzbg0.zza), interruptedException0);
        return null;
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzl(long v, String s, String s1, String s2) {
        this.zzd(new zzif(this, s1, s2, s, v));
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final String zzm(zzr zzr0) {
        this.zzN(zzr0, false);
        return this.zza.zzao(zzr0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzn(zzah zzah0, zzr zzr0) {
        Preconditions.checkNotNull(zzah0);
        Preconditions.checkNotNull(zzah0.zzc);
        this.zzN(zzr0, false);
        zzah zzah1 = new zzah(zzah0);
        zzah1.zza = zzr0.zza;
        this.zzd(new zzig(this, zzah1, zzr0));
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzo(zzah zzah0) {
        Preconditions.checkNotNull(zzah0);
        Preconditions.checkNotNull(zzah0.zzc);
        Preconditions.checkNotEmpty(zzah0.zza);
        this.zzO(zzah0.zza, true);
        this.zzd(new zzih(this, new zzah(zzah0)));
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final List zzp(String s, String s1, boolean z, zzr zzr0) {
        this.zzN(zzr0, false);
        Preconditions.checkNotNull(zzr0.zza);
        Future future0 = this.zza.zzaW().zzh(new zzii(this, zzr0.zza, s, s1));
        try {
            List list0 = (List)future0.get();
            List list1 = new ArrayList(list0.size());
            for(Object object0: list0) {
                zzpm zzpm0 = (zzpm)object0;
                if(z || !zzpo.zzZ(zzpm0.zzc)) {
                    ((ArrayList)list1).add(new zzpk(zzpm0));
                }
            }
            return list1;
        }
        catch(InterruptedException | ExecutionException interruptedException0) {
        }
        this.zza.zzaV().zzb().zzc("Failed to query user properties. appId", zzgt.zzl(zzr0.zza), interruptedException0);
        return Collections.EMPTY_LIST;
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final List zzq(String s, String s1, String s2, boolean z) {
        this.zzO(s, true);
        Future future0 = this.zza.zzaW().zzh(new zzij(this, s, s1, s2));
        try {
            List list0 = (List)future0.get();
            List list1 = new ArrayList(list0.size());
            for(Object object0: list0) {
                zzpm zzpm0 = (zzpm)object0;
                if(z || !zzpo.zzZ(zzpm0.zzc)) {
                    ((ArrayList)list1).add(new zzpk(zzpm0));
                }
            }
            return list1;
        }
        catch(InterruptedException | ExecutionException interruptedException0) {
        }
        this.zza.zzaV().zzb().zzc("Failed to get user properties as. appId", zzgt.zzl(s), interruptedException0);
        return Collections.EMPTY_LIST;
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final List zzr(String s, String s1, zzr zzr0) {
        this.zzN(zzr0, false);
        Preconditions.checkNotNull(zzr0.zza);
        Future future0 = this.zza.zzaW().zzh(new zzik(this, zzr0.zza, s, s1));
        try {
            return (List)future0.get();
        }
        catch(InterruptedException | ExecutionException interruptedException0) {
            this.zza.zzaV().zzb().zzb("Failed to get conditional user properties", interruptedException0);
            return Collections.EMPTY_LIST;
        }
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final List zzs(String s, String s1, String s2) {
        this.zzO(s, true);
        Future future0 = this.zza.zzaW().zzh(new zzil(this, s, s1, s2));
        try {
            return (List)future0.get();
        }
        catch(InterruptedException | ExecutionException interruptedException0) {
            this.zza.zzaV().zzb().zzb("Failed to get conditional user properties as", interruptedException0);
            return Collections.EMPTY_LIST;
        }
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzt(zzr zzr0) {
        Preconditions.checkNotEmpty(zzr0.zza);
        this.zzO(zzr0.zza, false);
        this.zzd(new zzin(this, zzr0));
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzu(Bundle bundle0, zzr zzr0) {
        this.zzN(zzr0, false);
        Preconditions.checkNotNull(zzr0.zza);
        this.zzd(() -> {
            zzpf zzpf0 = this.zza;
            if(bundle0.isEmpty() && zzpf0.zzd().zzp(null, zzfx.zzaV)) {
                zzav zzav0 = this.zza.zzj();
                zzav0.zzg();
                zzav0.zzay();
                try {
                    zzav0.zze().execSQL("delete from default_event_params where app_id=?", new String[]{zzr0.zza});
                }
                catch(SQLiteException sQLiteException0) {
                    zzav0.zzu.zzaV().zzb().zzb("Error clearing default event params", sQLiteException0);
                }
                return;
            }
            zzav zzav1 = zzpf0.zzj();
            zzav1.zzg();
            zzav1.zzay();
            zzbb zzbb0 = new zzbb(zzav1.zzu, "", zzr0.zza, "dep", 0L, 0L, bundle0);
            byte[] arr_b = zzav1.zzg.zzp().zzh(zzbb0).zzcc();
            com.google.android.gms.measurement.internal.zzib zzib0 = zzav1.zzu;
            zzib0.zzaV().zzk().zzc("Saving default event parameters, appId, data size", zzr0.zza, ((int)arr_b.length));
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("app_id", zzr0.zza);
            contentValues0.put("parameters", arr_b);
            try {
                if(zzav1.zze().insertWithOnConflict("default_event_params", null, contentValues0, 5) == -1L) {
                    zzib0.zzaV().zzb().zzb("Failed to insert default event parameters (got -1). appId", zzgt.zzl(zzr0.zza));
                }
            }
            catch(SQLiteException sQLiteException1) {
                zzav1.zzu.zzaV().zzb().zzc("Error storing default event parameters. appId", zzgt.zzl(zzr0.zza), sQLiteException1);
            }
            zzpf zzpf1 = this.zza;
            zzav zzav2 = zzpf1.zzj();
            long v = zzr0.zzD;
            if(zzav2.zzX(zzr0.zza, v)) {
                zzpf1.zzj().zzY(zzr0.zza, v, null, bundle0);
            }
        });
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzv(zzr zzr0) {
        Preconditions.checkNotEmpty(zzr0.zza);
        Preconditions.checkNotNull(zzr0.zzs);
        this.zzE(new zzio(this, zzr0));
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final zzao zzw(zzr zzr0) {
        this.zzN(zzr0, false);
        Preconditions.checkNotEmpty(zzr0.zza);
        Future future0 = this.zza.zzaW().zzi(new zzip(this, zzr0));
        try {
            return (zzao)future0.get(10000L, TimeUnit.MILLISECONDS);
        }
        catch(TimeoutException | InterruptedException | ExecutionException timeoutException0) {
            this.zza.zzaV().zzb().zzc("Failed to get consent. appId", zzgt.zzl(zzr0.zza), timeoutException0);
            return new zzao(null);
        }
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final List zzx(zzr zzr0, Bundle bundle0) {
        this.zzN(zzr0, false);
        Preconditions.checkNotNull(zzr0.zza);
        zzpf zzpf0 = this.zza;
        if(zzpf0.zzd().zzp(null, zzfx.zzaY)) {
            Future future0 = zzpf0.zzaW().zzi(new zziu(this, zzr0, bundle0));
            try {
                return (List)future0.get(10000L, TimeUnit.MILLISECONDS);
            }
            catch(TimeoutException | InterruptedException | ExecutionException timeoutException0) {
                this.zza.zzaV().zzb().zzc("Failed to get trigger URIs. appId", zzgt.zzl(zzr0.zza), timeoutException0);
                return Collections.EMPTY_LIST;
            }
        }
        Future future1 = this.zza.zzaW().zzh(new zziv(this, zzr0, bundle0));
        try {
            return (List)future1.get();
        }
        catch(InterruptedException | ExecutionException interruptedException0) {
            this.zza.zzaV().zzb().zzc("Failed to get trigger URIs. appId", zzgt.zzl(zzr0.zza), interruptedException0);
            return Collections.EMPTY_LIST;
        }
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzy(zzr zzr0) {
        Preconditions.checkNotEmpty(zzr0.zza);
        Preconditions.checkNotNull(zzr0.zzs);
        this.zzE(() -> {
            this.zza.zzY();
            this.zza.zzv(zzr0);
        });
    }

    @Override  // com.google.android.gms.measurement.internal.zzga
    public final void zzz(zzr zzr0) {
        Preconditions.checkNotEmpty(zzr0.zza);
        Preconditions.checkNotNull(zzr0.zzs);
        this.zzE(() -> {
            this.zza.zzY();
            this.zza.zzw(zzr0);
        });
    }
}

