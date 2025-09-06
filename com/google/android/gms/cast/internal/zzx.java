package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzat;
import com.google.android.gms.cast.zzbs;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public final class zzx extends GmsClient {
    private Bundle zzA;
    private final Map zzB;
    private ResultHolder zzC;
    private ResultHolder zzD;
    private static final Logger zze;
    private static final Object zzf;
    private static final Object zzg;
    private ApplicationMetadata zzh;
    private final CastDevice zzi;
    private final Listener zzj;
    private final Map zzk;
    private final long zzl;
    private final Bundle zzm;
    private zzw zzn;
    private String zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private double zzt;
    private zzat zzu;
    private int zzv;
    private int zzw;
    private final AtomicLong zzx;
    private String zzy;
    private String zzz;

    static {
        zzx.zze = new Logger("CastClientImpl");
        zzx.zzf = new Object();
        zzx.zzg = new Object();
    }

    public zzx(Context context0, Looper looper0, ClientSettings clientSettings0, CastDevice castDevice0, long v, Listener cast$Listener0, Bundle bundle0, ConnectionCallbacks googleApiClient$ConnectionCallbacks0, OnConnectionFailedListener googleApiClient$OnConnectionFailedListener0) {
        super(context0, looper0, 10, clientSettings0, googleApiClient$ConnectionCallbacks0, googleApiClient$OnConnectionFailedListener0);
        this.zzi = castDevice0;
        this.zzj = cast$Listener0;
        this.zzl = v;
        this.zzm = bundle0;
        this.zzk = new HashMap();
        this.zzx = new AtomicLong(0L);
        this.zzB = new HashMap();
        this.zzY();
        this.zzp();
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final IInterface createServiceInterface(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        return iInterface0 instanceof zzah ? ((zzah)iInterface0) : new zzah(iBinder0);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final void disconnect() {
        Logger logger0 = zzx.zze;
        logger0.d("disconnect(); ServiceListener=%s, isConnected=%b", new Object[]{this.zzn, Boolean.valueOf(this.isConnected())});
        zzw zzw0 = this.zzn;
        this.zzn = null;
        if(zzw0 != null && zzw0.zzq() != null) {
            this.zzZ();
            try {
                ((zzah)this.getService()).zzf(ApiMetadata.fromComplianceOptions(ComplianceOptions.newBuilder(this.getContext()).build()));
            }
            catch(RemoteException | IllegalStateException remoteException0) {
                zzx.zze.d(remoteException0, "Error while disconnecting the controller interface", new Object[0]);
            }
            finally {
                super.disconnect();
            }
            return;
        }
        logger0.d("already disposed, so short-circuiting", new Object[0]);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getConnectionHint() {
        Bundle bundle0 = this.zzA;
        if(bundle0 != null) {
            this.zzA = null;
            return bundle0;
        }
        return super.getConnectionHint();
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle0 = new Bundle();
        zzx.zze.d("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", new Object[]{this.zzy, this.zzz});
        this.zzi.putInBundle(bundle0);
        bundle0.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zzl);
        Bundle bundle1 = this.zzm;
        if(bundle1 != null) {
            bundle0.putAll(bundle1);
        }
        this.zzn = new zzw(this);
        bundle0.putParcelable("listener", new BinderWrapper(this.zzn));
        String s = this.zzy;
        if(s != null) {
            bundle0.putString("last_application_id", s);
            String s1 = this.zzz;
            if(s1 != null) {
                bundle0.putString("last_session_id", s1);
            }
        }
        return bundle0;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final int getMinApkVersion() {
        return 12800000;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionFailed(ConnectionResult connectionResult0) {
        super.onConnectionFailed(connectionResult0);
        this.zzZ();
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final void onPostInitHandler(int v, IBinder iBinder0, Bundle bundle0, int v1) {
        zzx.zze.d("in onPostInitHandler; statusCode=%d", new Object[]{v});
        if(v == 0 || v == 2300) {
            this.zzs = true;
            this.zzq = true;
            this.zzr = true;
        }
        else {
            this.zzs = false;
        }
        if(v == 2300) {
            Bundle bundle1 = new Bundle();
            this.zzA = bundle1;
            bundle1.putBoolean("com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING", true);
            v = 0;
        }
        super.onPostInitHandler(v, iBinder0, bundle0, v1);
    }

    public static Map zzA(zzx zzx0) {
        return zzx0.zzk;
    }

    public static void zzF(zzx zzx0, ResultHolder baseImplementation$ResultHolder0) {
        zzx0.zzC = null;
    }

    public static void zzH(zzx zzx0, zza zza0) {
        boolean z;
        String s = zza0.zza();
        if(CastUtils.zze(s, zzx0.zzo)) {
            z = false;
        }
        else {
            zzx0.zzo = s;
            z = true;
        }
        zzx.zze.d("hasChanged=%b, mFirstApplicationStatusUpdate=%b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(zzx0.zzq)});
        Listener cast$Listener0 = zzx0.zzj;
        if(cast$Listener0 != null && (z || zzx0.zzq)) {
            cast$Listener0.onApplicationStatusChanged();
        }
        zzx0.zzq = false;
    }

    public static void zzI(zzx zzx0, zzac zzac0) {
        boolean z3;
        boolean z1;
        ApplicationMetadata applicationMetadata0 = zzac0.zze();
        if(!CastUtils.zze(applicationMetadata0, zzx0.zzh)) {
            zzx0.zzh = applicationMetadata0;
            zzx0.zzj.onApplicationMetadataChanged(applicationMetadata0);
        }
        double f = zzac0.zzb();
        boolean z = true;
        if(Double.isNaN(f) || Math.abs(f - zzx0.zzt) <= 1.000000E-07) {
            z1 = false;
        }
        else {
            zzx0.zzt = f;
            z1 = true;
        }
        boolean z2 = zzac0.zzg();
        if(z2 != zzx0.zzp) {
            zzx0.zzp = z2;
            z1 = true;
        }
        Logger logger0 = zzx.zze;
        logger0.d("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[]{Boolean.valueOf(z1), Boolean.valueOf(zzx0.zzr)});
        Listener cast$Listener0 = zzx0.zzj;
        if(cast$Listener0 != null && (z1 || zzx0.zzr)) {
            cast$Listener0.onVolumeChanged();
        }
        int v = zzac0.zzc();
        if(v == zzx0.zzv) {
            z3 = false;
        }
        else {
            zzx0.zzv = v;
            z3 = true;
        }
        logger0.d("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[]{Boolean.valueOf(z3), Boolean.valueOf(zzx0.zzr)});
        if(cast$Listener0 != null && (z3 || zzx0.zzr)) {
            cast$Listener0.onActiveInputStateChanged(zzx0.zzv);
        }
        int v1 = zzac0.zzd();
        if(v1 == zzx0.zzw) {
            z = false;
        }
        else {
            zzx0.zzw = v1;
        }
        logger0.d("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(zzx0.zzr)});
        if(cast$Listener0 != null && (z || zzx0.zzr)) {
            cast$Listener0.onStandbyStateChanged(zzx0.zzw);
        }
        if(!CastUtils.zze(zzx0.zzu, zzac0.zzf())) {
            zzx0.zzu = zzac0.zzf();
        }
        zzx0.zzr = false;
    }

    public static void zzJ(zzx zzx0, long v, int v1) {
        zzx0.zzaa(v, v1);
    }

    public static void zzK(zzx zzx0, int v) {
        zzx0.zzab(v);
    }

    public final void zzL(String s, String s1, zzbs zzbs0, ResultHolder baseImplementation$ResultHolder0) {
        this.zzac(baseImplementation$ResultHolder0);
        zzbs zzbs1 = new zzbs();
        zzah zzah0 = (zzah)this.getService();
        if(this.zzW()) {
            zzah0.zzg(s, s1, zzbs1, ApiMetadata.fromComplianceOptions(ComplianceOptions.newBuilder(this.getContext()).build()));
            return;
        }
        this.zzR(0x7E0);
    }

    public final void zzM(String s, LaunchOptions launchOptions0, ResultHolder baseImplementation$ResultHolder0) {
        this.zzac(baseImplementation$ResultHolder0);
        zzah zzah0 = (zzah)this.getService();
        if(this.zzW()) {
            zzah0.zzh(s, launchOptions0, ApiMetadata.fromComplianceOptions(ComplianceOptions.newBuilder(this.getContext()).build()));
            return;
        }
        this.zzR(0x7E0);
    }

    public final void zzN(ResultHolder baseImplementation$ResultHolder0) {
        this.zzad(baseImplementation$ResultHolder0);
        zzah zzah0 = (zzah)this.getService();
        if(this.zzW()) {
            zzah0.zzi(ApiMetadata.fromComplianceOptions(ComplianceOptions.newBuilder(this.getContext()).build()));
            return;
        }
        this.zzab(0x7E0);
    }

    public final void zzO(String s) {
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized(this.zzk) {
            MessageReceivedCallback cast$MessageReceivedCallback0 = (MessageReceivedCallback)this.zzk.remove(s);
        }
        if(cast$MessageReceivedCallback0 != null) {
            try {
                ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(this.getContext()).build();
                ((zzah)this.getService()).zzr(s, ApiMetadata.fromComplianceOptions(complianceOptions0));
            }
            catch(IllegalStateException illegalStateException0) {
                zzx.zze.d(illegalStateException0, "Error unregistering namespace (%s)", new Object[]{s});
            }
        }
    }

    public final void zzP() {
        zzah zzah0 = (zzah)this.getService();
        if(this.zzW()) {
            zzah0.zzl(ApiMetadata.fromComplianceOptions(ComplianceOptions.newBuilder(this.getContext()).build()));
        }
    }

    public final void zzQ(String s, String s1, ResultHolder baseImplementation$ResultHolder0) {
        if(TextUtils.isEmpty(s1)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if(s1.length() <= 0x80000) {
            CastUtils.throwIfInvalidNamespace(s);
            long v = this.zzx.incrementAndGet();
            try {
                this.zzB.put(v, baseImplementation$ResultHolder0);
                IInterface iInterface0 = this.getService();
                if(this.zzW()) {
                    ((zzah)iInterface0).zzm(s, s1, v, ApiMetadata.fromComplianceOptions(ComplianceOptions.newBuilder(this.getContext()).build()));
                    return;
                }
                this.zzaa(v, 0x7E0);
                return;
            }
            catch(Throwable throwable0) {
                this.zzB.remove(v);
                throw throwable0;
            }
        }
        zzx.zze.w("Message send failed. Message exceeds maximum size", new Object[0]);
        throw new IllegalArgumentException("Message exceeds maximum size");
    }

    public final void zzR(int v) {
        synchronized(zzx.zzf) {
            ResultHolder baseImplementation$ResultHolder0 = this.zzC;
            if(baseImplementation$ResultHolder0 != null) {
                baseImplementation$ResultHolder0.setResult(new zzr(new Status(v), null, null, null, false));
                this.zzC = null;
            }
        }
    }

    public final void zzS(String s, MessageReceivedCallback cast$MessageReceivedCallback0) {
        CastUtils.throwIfInvalidNamespace(s);
        this.zzO(s);
        if(cast$MessageReceivedCallback0 != null) {
            synchronized(this.zzk) {
                this.zzk.put(s, cast$MessageReceivedCallback0);
            }
            zzah zzah0 = (zzah)this.getService();
            if(this.zzW()) {
                zzah0.zzk(s, ApiMetadata.fromComplianceOptions(ComplianceOptions.newBuilder(this.getContext()).build()));
            }
        }
    }

    public final void zzT(boolean z) {
        IInterface iInterface0 = this.getService();
        if(this.zzW()) {
            ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(this.getContext()).build();
            ((zzah)iInterface0).zzn(z, this.zzt, this.zzp, ApiMetadata.fromComplianceOptions(complianceOptions0));
        }
    }

    public final void zzU(double f) {
        if(Double.isInfinite(f) || Double.isNaN(f)) {
            throw new IllegalArgumentException("Volume cannot be " + f);
        }
        IInterface iInterface0 = this.getService();
        if(this.zzW()) {
            ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(this.getContext()).build();
            ((zzah)iInterface0).zzo(f, this.zzt, this.zzp, ApiMetadata.fromComplianceOptions(complianceOptions0));
        }
    }

    public final void zzV(String s, ResultHolder baseImplementation$ResultHolder0) {
        this.zzad(baseImplementation$ResultHolder0);
        zzah zzah0 = (zzah)this.getService();
        if(this.zzW()) {
            zzah0.zzp(s, ApiMetadata.fromComplianceOptions(ComplianceOptions.newBuilder(this.getContext()).build()));
            return;
        }
        this.zzab(0x7E0);
    }

    // 去混淆评级： 低(20)
    public final boolean zzW() {
        return this.zzs && (this.zzn != null && !this.zzn.zzr());
    }

    public final boolean zzX() {
        this.checkConnected();
        return this.zzp;
    }

    private final void zzY() {
        this.zzs = false;
        this.zzv = -1;
        this.zzw = -1;
        this.zzh = null;
        this.zzo = null;
        this.zzt = 0.0;
        this.zzp();
        this.zzp = false;
        this.zzu = null;
    }

    private final void zzZ() {
        zzx.zze.d("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized(this.zzk) {
            this.zzk.clear();
        }
    }

    private final void zzaa(long v, int v1) {
        ResultHolder baseImplementation$ResultHolder0;
        synchronized(this.zzB) {
            baseImplementation$ResultHolder0 = (ResultHolder)this.zzB.remove(v);
        }
        if(baseImplementation$ResultHolder0 != null) {
            baseImplementation$ResultHolder0.setResult(new Status(v1));
        }
    }

    private final void zzab(int v) {
        synchronized(zzx.zzg) {
            ResultHolder baseImplementation$ResultHolder0 = this.zzD;
            if(baseImplementation$ResultHolder0 != null) {
                baseImplementation$ResultHolder0.setResult(new Status(v));
                this.zzD = null;
            }
        }
    }

    private final void zzac(ResultHolder baseImplementation$ResultHolder0) {
        synchronized(zzx.zzf) {
            ResultHolder baseImplementation$ResultHolder1 = this.zzC;
            if(baseImplementation$ResultHolder1 != null) {
                baseImplementation$ResultHolder1.setResult(new zzr(new Status(0x9AD), null, null, null, false));
            }
            this.zzC = baseImplementation$ResultHolder0;
        }
    }

    private final void zzad(ResultHolder baseImplementation$ResultHolder0) {
        synchronized(zzx.zzg) {
            if(this.zzD != null) {
                baseImplementation$ResultHolder0.setResult(new Status(2001));
                return;
            }
            this.zzD = baseImplementation$ResultHolder0;
        }
    }

    public final double zzp() {
        CastDevice castDevice0 = this.zzi;
        Preconditions.checkNotNull(castDevice0, "device should not be null");
        if(castDevice0.hasCapability(0x800)) {
            return 0.02;
        }
        return castDevice0.hasCapability(4) && !castDevice0.hasCapability(1) && !"Chromecast Audio".equals(castDevice0.getModelName()) ? 0.02 : 0.05;
    }

    public final double zzq() {
        this.checkConnected();
        return this.zzt;
    }

    public final int zzr() {
        this.checkConnected();
        return this.zzv;
    }

    public final int zzs() {
        this.checkConnected();
        return this.zzw;
    }

    public final ApplicationMetadata zzt() {
        this.checkConnected();
        return this.zzh;
    }

    public static Listener zzu(zzx zzx0) {
        return zzx0.zzj;
    }

    public static CastDevice zzv(zzx zzx0) {
        return zzx0.zzi;
    }

    public static Logger zzw() {
        return zzx.zze;
    }

    public final String zzz() {
        this.checkConnected();
        return this.zzo;
    }
}

