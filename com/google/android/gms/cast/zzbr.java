package com.google.android.gms.cast;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zza;
import com.google.android.gms.cast.internal.zzac;
import com.google.android.gms.cast.internal.zzah;
import com.google.android.gms.cast.internal.zzaj;
import com.google.android.gms.cast.internal.zzal;
import com.google.android.gms.cast.internal.zzy;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods.Builder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzet;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@SuppressLint({"UseSparseArrays"})
public final class zzbr extends GoogleApi implements zzr {
    final zzbq zza;
    TaskCompletionSource zzb;
    TaskCompletionSource zzc;
    final Map zzd;
    final Map zze;
    public static final int zzf;
    private static final Logger zzg;
    private static final AbstractClientBuilder zzh;
    private static final Api zzi;
    private Handler zzj;
    private boolean zzk;
    private boolean zzl;
    private final AtomicLong zzm;
    private final Object zzn;
    private final Object zzo;
    private ApplicationMetadata zzp;
    private String zzq;
    private double zzr;
    private boolean zzs;
    private int zzt;
    private int zzu;
    private zzat zzv;
    private final CastDevice zzw;
    private final Listener zzx;
    private final List zzy;
    private int zzz;

    static {
        zzbr.zzg = new Logger("CastClient");
        zzbi zzbi0 = new zzbi();
        zzbr.zzh = zzbi0;
        zzbr.zzi = new Api("Cast.API_CXLESS", zzbi0, zzal.zzb);
    }

    public zzbr(Context context0, CastOptions cast$CastOptions0) {
        super(context0, zzbr.zzi, cast$CastOptions0, Settings.DEFAULT_SETTINGS);
        this.zza = new zzbq(this);
        this.zzn = new Object();
        this.zzo = new Object();
        this.zzy = Collections.synchronizedList(new ArrayList());
        Preconditions.checkNotNull(context0, "context cannot be null");
        Preconditions.checkNotNull(cast$CastOptions0, "CastOptions cannot be null");
        this.zzx = cast$CastOptions0.zzb;
        this.zzw = cast$CastOptions0.zza;
        this.zzd = new HashMap();
        this.zze = new HashMap();
        this.zzm = new AtomicLong(0L);
        this.zzz = 1;
        this.zzn();
    }

    // 检测为 Lambda 实现
    public static void zzA(zzbr zzbr0, String s, String s1, String s2, zzy zzy0, TaskCompletionSource taskCompletionSource0) [...]

    public static void zzB(zzbr zzbr0, String s, String s1, zzbs zzbs0, zzy zzy0, TaskCompletionSource taskCompletionSource0) {
        zzbr0.zzR();
        ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(zzy0.getContext()).build();
        ((zzah)zzy0.getService()).zzg(s, s1, null, ApiMetadata.fromComplianceOptions(complianceOptions0));
        zzbr0.zzT(taskCompletionSource0);
    }

    public static void zzC(zzbr zzbr0, ApplicationMetadata applicationMetadata0) {
        zzbr0.zzp = applicationMetadata0;
    }

    public static void zzD(zzbr zzbr0, String s) {
        zzbr0.zzq = s;
    }

    public static void zzE(zzbr zzbr0, boolean z) {
        zzbr0.zzl = true;
    }

    public static void zzF(zzbr zzbr0, boolean z) {
        zzbr0.zzk = true;
    }

    public static void zzG(zzbr zzbr0) {
        zzbr0.zzt = -1;
        zzbr0.zzu = -1;
        zzbr0.zzp = null;
        zzbr0.zzq = null;
        zzbr0.zzr = 0.0;
        zzbr0.zzn();
        zzbr0.zzs = false;
        zzbr0.zzv = null;
    }

    public static void zzH(zzbr zzbr0, zza zza0) {
        boolean z;
        String s = zza0.zza();
        if(CastUtils.zze(s, zzbr0.zzq)) {
            z = false;
        }
        else {
            zzbr0.zzq = s;
            z = true;
        }
        zzbr.zzg.d("hasChanged=%b, mFirstApplicationStatusUpdate=%b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(zzbr0.zzl)});
        Listener cast$Listener0 = zzbr0.zzx;
        if(cast$Listener0 != null && (z || zzbr0.zzl)) {
            cast$Listener0.onApplicationStatusChanged();
        }
        zzbr0.zzl = false;
    }

    public static void zzI(zzbr zzbr0, zzac zzac0) {
        boolean z3;
        boolean z1;
        ApplicationMetadata applicationMetadata0 = zzac0.zze();
        if(!CastUtils.zze(applicationMetadata0, zzbr0.zzp)) {
            zzbr0.zzp = applicationMetadata0;
            zzbr0.zzx.onApplicationMetadataChanged(applicationMetadata0);
        }
        double f = zzac0.zzb();
        boolean z = true;
        if(Double.isNaN(f) || Math.abs(f - zzbr0.zzr) <= 1.000000E-07) {
            z1 = false;
        }
        else {
            zzbr0.zzr = f;
            z1 = true;
        }
        boolean z2 = zzac0.zzg();
        if(z2 != zzbr0.zzs) {
            zzbr0.zzs = z2;
            z1 = true;
        }
        Logger logger0 = zzbr.zzg;
        logger0.d("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[]{Boolean.valueOf(z1), Boolean.valueOf(zzbr0.zzk)});
        Listener cast$Listener0 = zzbr0.zzx;
        if(cast$Listener0 != null && (z1 || zzbr0.zzk)) {
            cast$Listener0.onVolumeChanged();
        }
        int v = zzac0.zzc();
        if(v == zzbr0.zzt) {
            z3 = false;
        }
        else {
            zzbr0.zzt = v;
            z3 = true;
        }
        logger0.d("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[]{Boolean.valueOf(z3), Boolean.valueOf(zzbr0.zzk)});
        if(cast$Listener0 != null && (z3 || zzbr0.zzk)) {
            cast$Listener0.onActiveInputStateChanged(zzbr0.zzt);
        }
        int v1 = zzac0.zzd();
        if(v1 == zzbr0.zzu) {
            z = false;
        }
        else {
            zzbr0.zzu = v1;
        }
        logger0.d("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(zzbr0.zzk)});
        if(cast$Listener0 != null && (z || zzbr0.zzk)) {
            cast$Listener0.onStandbyStateChanged(zzbr0.zzu);
        }
        if(!CastUtils.zze(zzbr0.zzv, zzac0.zzf())) {
            zzbr0.zzv = zzac0.zzf();
        }
        zzbr0.zzk = false;
    }

    public static void zzJ(zzbr zzbr0) {
        zzbr0.zzS();
    }

    public static void zzK(zzbr zzbr0, int v) {
        zzbr0.zzU(v);
    }

    public static void zzL(zzbr zzbr0, ApplicationConnectionResult cast$ApplicationConnectionResult0) {
        synchronized(zzbr0.zzn) {
            TaskCompletionSource taskCompletionSource0 = zzbr0.zzb;
            if(taskCompletionSource0 != null) {
                taskCompletionSource0.setResult(cast$ApplicationConnectionResult0);
            }
            zzbr0.zzb = null;
        }
    }

    public static void zzM(zzbr zzbr0, long v, int v1) {
        TaskCompletionSource taskCompletionSource0;
        synchronized(zzbr0.zzd) {
            Long long0 = v;
            taskCompletionSource0 = (TaskCompletionSource)zzbr0.zzd.get(long0);
            zzbr0.zzd.remove(long0);
        }
        if(taskCompletionSource0 != null) {
            if(v1 == 0) {
                taskCompletionSource0.setResult(null);
                return;
            }
            taskCompletionSource0.setException(zzbr.zzP(v1));
        }
    }

    public static void zzN(zzbr zzbr0, int v) {
        synchronized(zzbr0.zzo) {
            TaskCompletionSource taskCompletionSource0 = zzbr0.zzc;
            if(taskCompletionSource0 == null) {
                return;
            }
            if(v == 0) {
                taskCompletionSource0.setResult(new Status(0));
            }
            else {
                taskCompletionSource0.setException(zzbr.zzP(v));
            }
            zzbr0.zzc = null;
        }
    }

    public static void zzO(zzbr zzbr0, int v) {
        zzbr0.zzz = v;
    }

    private static ApiException zzP(int v) {
        return ApiExceptionUtil.fromStatus(new Status(v));
    }

    private final Task zzQ(zzaj zzaj0) {
        return this.doUnregisterEventListener(((ListenerKey)Preconditions.checkNotNull(this.registerListener(zzaj0, "castDeviceControllerListenerKey").getListenerKey(), "Key must not be null")), 0x20DF);
    }

    private final void zzR() {
        Preconditions.checkState(this.zzl(), "Not connected to device");
    }

    private final void zzS() {
        zzbr.zzg.d("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized(this.zze) {
            this.zze.clear();
        }
    }

    private final void zzT(TaskCompletionSource taskCompletionSource0) {
        synchronized(this.zzn) {
            if(this.zzb != null) {
                this.zzU(0x9AD);
            }
            this.zzb = taskCompletionSource0;
        }
    }

    private final void zzU(int v) {
        synchronized(this.zzn) {
            TaskCompletionSource taskCompletionSource0 = this.zzb;
            if(taskCompletionSource0 != null) {
                taskCompletionSource0.setException(zzbr.zzP(v));
            }
            this.zzb = null;
        }
    }

    private final void zzV() {
        Preconditions.checkState(this.zzz != 1, "Not active connection");
    }

    @Override  // com.google.android.gms.cast.zzr
    public final double zza() {
        this.zzR();
        return this.zzr;
    }

    @Override  // com.google.android.gms.cast.zzr
    public final int zzb() {
        this.zzR();
        return this.zzt;
    }

    @Override  // com.google.android.gms.cast.zzr
    public final int zzc() {
        this.zzR();
        return this.zzu;
    }

    @Override  // com.google.android.gms.cast.zzr
    public final ApplicationMetadata zzd() {
        this.zzR();
        return this.zzp;
    }

    @Override  // com.google.android.gms.cast.zzr
    public final Task zze() {
        ListenerHolder listenerHolder0 = this.registerListener(this.zza, "castDeviceControllerListenerKey");
        Builder registrationMethods$Builder0 = RegistrationMethods.builder();
        zzbc zzbc0 = new zzbc(this);
        zzbd zzbd0 = new zzbd();
        this.zzz = 2;
        return this.doRegisterEventListener(registrationMethods$Builder0.withHolder(listenerHolder0).register(zzbc0).unregister(zzbd0).setFeatures(new Feature[]{zzav.zzb}).setMethodKey(0x20EC).build());
    }

    @Override  // com.google.android.gms.cast.zzr
    public final Task zzf() {
        Task task0 = this.doWrite(TaskApiCall.builder().run(new zzay()).setMethodKey(8403).build());
        this.zzS();
        this.zzQ(this.zza);
        return task0;
    }

    @Override  // com.google.android.gms.cast.zzr
    public final Task zzg(String s) {
        MessageReceivedCallback cast$MessageReceivedCallback0;
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized(this.zze) {
            cast$MessageReceivedCallback0 = (MessageReceivedCallback)this.zze.remove(s);
        }
        return this.doWrite(TaskApiCall.builder().run((zzy zzy0, TaskCompletionSource taskCompletionSource0) -> {
            this.zzV();
            if(cast$MessageReceivedCallback0 != null) {
                ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(zzy0.getContext()).build();
                ((zzah)zzy0.getService()).zzr(s, ApiMetadata.fromComplianceOptions(complianceOptions0));
            }
            taskCompletionSource0.setResult(null);
        }).setMethodKey(0x20DE).build());
    }

    @Override  // com.google.android.gms.cast.zzr
    public final Task zzh(String s, String s1) {
        CastUtils.throwIfInvalidNamespace(s);
        if(TextUtils.isEmpty(s1)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if(s1.length() <= 0x80000) {
            return this.doWrite(TaskApiCall.builder().run((zzy zzy0, TaskCompletionSource taskCompletionSource0) -> {
                long v = this.zzm.incrementAndGet();
                this.zzR();
                try {
                    this.zzd.put(v, taskCompletionSource0);
                    ApiMetadata apiMetadata0 = ApiMetadata.fromComplianceOptions(ComplianceOptions.newBuilder(zzy0.getContext()).build());
                    ((zzah)zzy0.getService()).zzm(s, s1, v, apiMetadata0);
                }
                catch(RemoteException remoteException0) {
                    this.zzd.remove(v);
                    taskCompletionSource0.setException(remoteException0);
                }
            }).setMethodKey(8405).build());
        }
        zzbr.zzg.w("Message send failed. Message exceeds maximum size", new Object[0]);
        throw new IllegalArgumentException("Message exceeds maximum size524288");
    }

    @Override  // com.google.android.gms.cast.zzr
    public final Task zzi(String s, MessageReceivedCallback cast$MessageReceivedCallback0) {
        CastUtils.throwIfInvalidNamespace(s);
        if(cast$MessageReceivedCallback0 != null) {
            synchronized(this.zze) {
                this.zze.put(s, cast$MessageReceivedCallback0);
            }
            return this.doWrite(TaskApiCall.builder().run((zzy zzy0, TaskCompletionSource taskCompletionSource0) -> {
                this.zzV();
                ApiMetadata apiMetadata0 = ApiMetadata.fromComplianceOptions(ComplianceOptions.newBuilder(zzy0.getContext()).build());
                ((zzah)zzy0.getService()).zzr(s, apiMetadata0);
                if(cast$MessageReceivedCallback0 != null) {
                    ((zzah)zzy0.getService()).zzk(s, apiMetadata0);
                }
                taskCompletionSource0.setResult(null);
            }).setMethodKey(0x20DD).build());
        }
        return this.doWrite(TaskApiCall.builder().run((zzy zzy0, TaskCompletionSource taskCompletionSource0) -> {
            this.zzV();
            ApiMetadata apiMetadata0 = ApiMetadata.fromComplianceOptions(ComplianceOptions.newBuilder(zzy0.getContext()).build());
            ((zzah)zzy0.getService()).zzr(s, apiMetadata0);
            if(null != null) {
                ((zzah)zzy0.getService()).zzk(s, apiMetadata0);
            }
            taskCompletionSource0.setResult(null);
        }).setMethodKey(0x20DD).build());
    }

    @Override  // com.google.android.gms.cast.zzr
    public final String zzj() {
        this.zzR();
        return this.zzq;
    }

    @Override  // com.google.android.gms.cast.zzr
    public final void zzk(zzq zzq0) {
        Preconditions.checkNotNull(zzq0);
        this.zzy.add(zzq0);
    }

    @Override  // com.google.android.gms.cast.zzr
    public final boolean zzl() {
        return this.zzz == 3;
    }

    @Override  // com.google.android.gms.cast.zzr
    public final boolean zzm() {
        this.zzR();
        return this.zzs;
    }

    @RequiresNonNull({"device"})
    public final double zzn() {
        CastDevice castDevice0 = this.zzw;
        if(castDevice0.hasCapability(0x800)) {
            return 0.02;
        }
        return castDevice0.hasCapability(4) && !castDevice0.hasCapability(1) && !"Chromecast Audio".equals(castDevice0.getModelName()) ? 0.02 : 0.05;
    }

    public static Handler zzo(zzbr zzbr0) {
        if(zzbr0.zzj == null) {
            zzbr0.zzj = new zzet(zzbr0.getLooper());
        }
        return zzbr0.zzj;
    }

    public static Listener zzp(zzbr zzbr0) {
        return zzbr0.zzx;
    }

    public static CastDevice zzq(zzbr zzbr0) {
        return zzbr0.zzw;
    }

    public static Logger zzr() {
        return zzbr.zzg;
    }

    public static Task zzs(zzbr zzbr0, zzaj zzaj0) {
        return zzbr0.zzQ(zzaj0);
    }

    public static List zzt(zzbr zzbr0) {
        return zzbr0.zzy;
    }

    // 检测为 Lambda 实现
    public static void zzu(zzbr zzbr0, String s, MessageReceivedCallback cast$MessageReceivedCallback0, zzy zzy0, TaskCompletionSource taskCompletionSource0) [...]

    public static void zzv(zzbr zzbr0, String s, LaunchOptions launchOptions0, zzy zzy0, TaskCompletionSource taskCompletionSource0) {
        zzbr0.zzR();
        ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(zzy0.getContext()).build();
        ((zzah)zzy0.getService()).zzh(s, launchOptions0, ApiMetadata.fromComplianceOptions(complianceOptions0));
        zzbr0.zzT(taskCompletionSource0);
    }

    // 检测为 Lambda 实现
    public static void zzw(zzbr zzbr0, MessageReceivedCallback cast$MessageReceivedCallback0, String s, zzy zzy0, TaskCompletionSource taskCompletionSource0) [...]

    public static void zzx(zzbr zzbr0, String s, zzy zzy0, TaskCompletionSource taskCompletionSource0) {
        zzbr0.zzR();
        ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(zzy0.getContext()).build();
        ((zzah)zzy0.getService()).zzp(s, ApiMetadata.fromComplianceOptions(complianceOptions0));
        synchronized(zzbr0.zzo) {
            if(zzbr0.zzc != null) {
                taskCompletionSource0.setException(zzbr.zzP(2001));
                return;
            }
            zzbr0.zzc = taskCompletionSource0;
        }
    }

    public static void zzy(zzbr zzbr0, boolean z, zzy zzy0, TaskCompletionSource taskCompletionSource0) {
        ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(zzy0.getContext()).build();
        ((zzah)zzy0.getService()).zzn(z, zzbr0.zzr, zzbr0.zzs, ApiMetadata.fromComplianceOptions(complianceOptions0));
        taskCompletionSource0.setResult(null);
    }

    public static void zzz(zzbr zzbr0, double f, zzy zzy0, TaskCompletionSource taskCompletionSource0) {
        ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(zzy0.getContext()).build();
        ((zzah)zzy0.getService()).zzo(f, zzbr0.zzr, zzbr0.zzs, ApiMetadata.fromComplianceOptions(complianceOptions0));
        taskCompletionSource0.setResult(null);
    }
}

