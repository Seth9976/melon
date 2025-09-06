package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.AttributionSource;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.wrappers.AttributionSourceWrapper;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

@KeepForSdk
public abstract class BaseGmsClient {
    @KeepForSdk
    public interface BaseConnectionCallbacks {
        @KeepForSdk
        public static final int CAUSE_DEAD_OBJECT_EXCEPTION = 3;
        @KeepForSdk
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        @KeepForSdk
        void onConnected(Bundle arg1);

        @KeepForSdk
        void onConnectionSuspended(int arg1);
    }

    @KeepForSdk
    public interface BaseOnConnectionFailedListener {
        @KeepForSdk
        void onConnectionFailed(ConnectionResult arg1);
    }

    @KeepForSdk
    public interface ConnectionProgressReportCallbacks {
        @KeepForSdk
        void onReportServiceBinding(ConnectionResult arg1);
    }

    public class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        final BaseGmsClient zza;

        @KeepForSdk
        public LegacyClientCallbackAdapter() {
            Objects.requireNonNull(baseGmsClient0);
            this.zza = baseGmsClient0;
            super();
        }

        @Override  // com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks
        public final void onReportServiceBinding(ConnectionResult connectionResult0) {
            if(connectionResult0.isSuccess()) {
                Set set0 = this.zza.getScopes();
                this.zza.getRemoteService(null, set0);
                return;
            }
            BaseGmsClient baseGmsClient0 = this.zza;
            if(baseGmsClient0.zzl() != null) {
                baseGmsClient0.zzl().onConnectionFailed(connectionResult0);
            }
        }
    }

    @KeepForSdk
    public interface SignOutCallbacks {
        @KeepForSdk
        void onSignOutComplete();
    }

    @KeepForSdk
    public static final int CONNECT_STATE_CONNECTED = 4;
    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    @KeepForSdk
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = null;
    @KeepForSdk
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private volatile String zzA;
    private volatile AttributionSourceWrapper zzB;
    private ConnectionResult zzC;
    private boolean zzD;
    private volatile zzj zzE;
    zzs zza;
    final Handler zzb;
    protected ConnectionProgressReportCallbacks zzc;
    protected AtomicInteger zzd;
    private static final Feature[] zze;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final GmsClientSupervisor zzn;
    private final GoogleApiAvailabilityLight zzo;
    private final Object zzp;
    private final Object zzq;
    private IGmsServiceBroker zzr;
    private IInterface zzs;
    private final ArrayList zzt;
    private zze zzu;
    private int zzv;
    private final BaseConnectionCallbacks zzw;
    private final BaseOnConnectionFailedListener zzx;
    private final int zzy;
    private final String zzz;

    static {
        BaseGmsClient.zze = new Feature[0];
        BaseGmsClient.GOOGLE_PLUS_REQUIRED_FEATURES = new String[]{"service_esmobile", "service_googleme"};
    }

    @KeepForSdk
    public BaseGmsClient(Context context0, Handler handler0, GmsClientSupervisor gmsClientSupervisor0, GoogleApiAvailabilityLight googleApiAvailabilityLight0, int v, BaseConnectionCallbacks baseGmsClient$BaseConnectionCallbacks0, BaseOnConnectionFailedListener baseGmsClient$BaseOnConnectionFailedListener0) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzC = null;
        this.zzD = false;
        this.zzE = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.checkNotNull(context0, "Context must not be null");
        this.zzl = context0;
        Preconditions.checkNotNull(handler0, "Handler must not be null");
        this.zzb = handler0;
        this.zzm = handler0.getLooper();
        Preconditions.checkNotNull(gmsClientSupervisor0, "Supervisor must not be null");
        this.zzn = gmsClientSupervisor0;
        Preconditions.checkNotNull(googleApiAvailabilityLight0, "API availability must not be null");
        this.zzo = googleApiAvailabilityLight0;
        this.zzy = v;
        this.zzw = baseGmsClient$BaseConnectionCallbacks0;
        this.zzx = baseGmsClient$BaseOnConnectionFailedListener0;
        this.zzz = null;
    }

    @KeepForSdk
    public BaseGmsClient(Context context0, Looper looper0, int v, BaseConnectionCallbacks baseGmsClient$BaseConnectionCallbacks0, BaseOnConnectionFailedListener baseGmsClient$BaseOnConnectionFailedListener0, String s) {
        GmsClientSupervisor gmsClientSupervisor0 = GmsClientSupervisor.getInstance(context0);
        Preconditions.checkNotNull(baseGmsClient$BaseConnectionCallbacks0);
        Preconditions.checkNotNull(baseGmsClient$BaseOnConnectionFailedListener0);
        this(context0, looper0, gmsClientSupervisor0, GoogleApiAvailabilityLight.getInstance(), v, baseGmsClient$BaseConnectionCallbacks0, baseGmsClient$BaseOnConnectionFailedListener0, s);
    }

    @KeepForSdk
    public BaseGmsClient(Context context0, Looper looper0, GmsClientSupervisor gmsClientSupervisor0, GoogleApiAvailabilityLight googleApiAvailabilityLight0, int v, BaseConnectionCallbacks baseGmsClient$BaseConnectionCallbacks0, BaseOnConnectionFailedListener baseGmsClient$BaseOnConnectionFailedListener0, String s) {
        this.zzk = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList();
        this.zzv = 1;
        this.zzC = null;
        this.zzD = false;
        this.zzE = null;
        this.zzd = new AtomicInteger(0);
        Preconditions.checkNotNull(context0, "Context must not be null");
        this.zzl = context0;
        Preconditions.checkNotNull(looper0, "Looper must not be null");
        this.zzm = looper0;
        Preconditions.checkNotNull(gmsClientSupervisor0, "Supervisor must not be null");
        this.zzn = gmsClientSupervisor0;
        Preconditions.checkNotNull(googleApiAvailabilityLight0, "API availability must not be null");
        this.zzo = googleApiAvailabilityLight0;
        this.zzb = new zzb(this, looper0);
        this.zzy = v;
        this.zzw = baseGmsClient$BaseConnectionCallbacks0;
        this.zzx = baseGmsClient$BaseOnConnectionFailedListener0;
        this.zzz = s;
    }

    @KeepForSdk
    public void checkAvailabilityAndConnect() {
        int v = this.getMinApkVersion();
        int v1 = this.zzo.isGooglePlayServicesAvailable(this.zzl, v);
        if(v1 != 0) {
            this.zzp(1, null);
            this.triggerNotAvailable(new LegacyClientCallbackAdapter(this), v1, null);
            return;
        }
        this.connect(new LegacyClientCallbackAdapter(this));
    }

    @KeepForSdk
    public final void checkConnected() {
        if(!this.isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @KeepForSdk
    public void connect(ConnectionProgressReportCallbacks baseGmsClient$ConnectionProgressReportCallbacks0) {
        Preconditions.checkNotNull(baseGmsClient$ConnectionProgressReportCallbacks0, "Connection progress callbacks cannot be null.");
        this.zzc = baseGmsClient$ConnectionProgressReportCallbacks0;
        this.zzp(2, null);
    }

    @KeepForSdk
    public abstract IInterface createServiceInterface(IBinder arg1);

    @KeepForSdk
    public void disconnect() {
        this.zzd.incrementAndGet();
        ArrayList arrayList0 = this.zzt;
        synchronized(arrayList0) {
            int v1 = arrayList0.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                ((zzc)arrayList0.get(v2)).zzf();
            }
            arrayList0.clear();
        }
        synchronized(this.zzq) {
            this.zzr = null;
        }
        this.zzp(1, null);
    }

    @KeepForSdk
    public void disconnect(String s) {
        this.zzk = s;
        this.disconnect();
    }

    @KeepForSdk
    public void dump(String s, FileDescriptor fileDescriptor0, PrintWriter printWriter0, String[] arr_s) {
        IGmsServiceBroker iGmsServiceBroker0;
        IInterface iInterface0;
        synchronized(this.zzp) {
            int v = this.zzv;
            iInterface0 = this.zzs;
        }
        synchronized(this.zzq) {
            iGmsServiceBroker0 = this.zzr;
        }
        printWriter0.append(s).append("mConnectState=");
        switch(v) {
            case 1: {
                printWriter0.print("DISCONNECTED");
                break;
            }
            case 2: {
                printWriter0.print("REMOTE_CONNECTING");
                break;
            }
            case 3: {
                printWriter0.print("LOCAL_CONNECTING");
                break;
            }
            case 4: {
                printWriter0.print("CONNECTED");
                break;
            }
            case 5: {
                printWriter0.print("DISCONNECTING");
                break;
            }
            default: {
                printWriter0.print("UNKNOWN");
            }
        }
        printWriter0.append(" mService=");
        if(iInterface0 == null) {
            printWriter0.append("null");
        }
        else {
            printWriter0.append(this.getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(iInterface0.asBinder())));
        }
        printWriter0.append(" mServiceBroker=");
        if(iGmsServiceBroker0 == null) {
            printWriter0.println("null");
        }
        else {
            printWriter0.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker0.asBinder())));
        }
        SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if(Long.compare(this.zzh, 0L) > 0) {
            printWriter0.append(s).append("lastConnectedTime=").println(this.zzh + " " + simpleDateFormat0.format(new Date(this.zzh)));
        }
        if(this.zzg > 0L) {
            printWriter0.append(s).append("lastSuspendedCause=");
            int v1 = this.zzf;
            switch(v1) {
                case 1: {
                    printWriter0.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                }
                case 2: {
                    printWriter0.append("CAUSE_NETWORK_LOST");
                    break;
                }
                case 3: {
                    printWriter0.append("CAUSE_DEAD_OBJECT_EXCEPTION");
                    break;
                }
                default: {
                    printWriter0.append(String.valueOf(v1));
                }
            }
            printWriter0.append(" lastSuspendedTime=").println(this.zzg + " " + simpleDateFormat0.format(new Date(this.zzg)));
        }
        if(this.zzj > 0L) {
            printWriter0.append(s).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzi));
            printWriter0.append(" lastFailedTime=").println(this.zzj + " " + simpleDateFormat0.format(new Date(this.zzj)));
        }
    }

    @KeepForSdk
    public boolean enableLocalFallback() [...] // Inlined contents

    @KeepForSdk
    public Account getAccount() {
        return null;
    }

    @KeepForSdk
    public Feature[] getApiFeatures() {
        return BaseGmsClient.zze;
    }

    @KeepForSdk
    public AttributionSourceWrapper getAttributionSourceWrapper() {
        return this.zzB;
    }

    @KeepForSdk
    public final Feature[] getAvailableFeatures() {
        return this.zzE == null ? null : this.zzE.zzb;
    }

    @KeepForSdk
    public Executor getBindServiceExecutor() {
        return null;
    }

    @KeepForSdk
    public Bundle getConnectionHint() {
        return null;
    }

    @KeepForSdk
    public final Context getContext() {
        return this.zzl;
    }

    @KeepForSdk
    public String getEndpointPackageName() {
        if(this.isConnected()) {
            zzs zzs0 = this.zza;
            if(zzs0 != null) {
                return zzs0.zzb();
            }
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    @KeepForSdk
    public int getGCoreServiceId() {
        return this.zzy;
    }

    @KeepForSdk
    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    @KeepForSdk
    public String getLastDisconnectMessage() {
        return this.zzk;
    }

    @KeepForSdk
    public String getLocalStartServiceAction() [...] // Inlined contents

    @KeepForSdk
    public final Looper getLooper() {
        return this.zzm;
    }

    @KeepForSdk
    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @KeepForSdk
    public void getRemoteService(IAccountAccessor iAccountAccessor0, Set set0) {
        String s;
        Bundle bundle0 = this.getGetServiceRequestExtraArgs();
        if(Build.VERSION.SDK_INT < 0x1F) {
            s = this.zzA;
        }
        else if(this.zzB == null) {
            s = this.zzA;
        }
        else {
            AttributionSource attributionSource0 = this.zzB.getAttributionSource();
            if(attributionSource0 == null) {
                s = this.zzA;
            }
            else {
                s = attributionSource0.getAttributionTag() == null ? this.zzA : attributionSource0.getAttributionTag();
            }
        }
        Bundle bundle1 = new Bundle();
        GetServiceRequest getServiceRequest0 = new GetServiceRequest(6, this.zzy, GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE, null, null, GetServiceRequest.zza, bundle1, null, GetServiceRequest.zzb, GetServiceRequest.zzb, true, 0, false, s);
        getServiceRequest0.zzf = "com.iloen.melon";
        getServiceRequest0.zzi = bundle0;
        if(set0 != null) {
            getServiceRequest0.zzh = (Scope[])set0.toArray(new Scope[0]);
        }
        if(this.requiresSignIn()) {
            Account account0 = this.getAccount();
            if(account0 == null) {
                account0 = new Account("<<default account>>", "com.google");
            }
            getServiceRequest0.zzj = account0;
            if(iAccountAccessor0 != null) {
                getServiceRequest0.zzg = iAccountAccessor0.asBinder();
            }
        }
        else if(this.requiresAccount()) {
            getServiceRequest0.zzj = this.getAccount();
        }
        getServiceRequest0.zzk = BaseGmsClient.zze;
        getServiceRequest0.zzl = this.getApiFeatures();
        if(this.usesClientTelemetry()) {
            getServiceRequest0.zzo = true;
        }
        try {
            synchronized(this.zzq) {
                IGmsServiceBroker iGmsServiceBroker0 = this.zzr;
                if(iGmsServiceBroker0 == null) {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
                else {
                    iGmsServiceBroker0.getService(new zzd(this, this.zzd.get()), getServiceRequest0);
                }
            }
        }
        catch(DeadObjectException deadObjectException0) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", deadObjectException0);
            this.triggerConnectionSuspended(3);
        }
        catch(SecurityException securityException0) {
            throw securityException0;
        }
        catch(RemoteException | RuntimeException remoteException0) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", remoteException0);
            this.onPostInitHandler(8, null, null, this.zzd.get());
        }
    }

    @KeepForSdk
    public Set getScopes() {
        return Collections.EMPTY_SET;
    }

    @KeepForSdk
    public final IInterface getService() {
        synchronized(this.zzp) {
            if(this.zzv != 5) {
                this.checkConnected();
                IInterface iInterface0 = this.zzs;
                Preconditions.checkNotNull(iInterface0, "Client is connected but service is null");
                return iInterface0;
            }
        }
        throw new DeadObjectException();
    }

    @KeepForSdk
    public IBinder getServiceBrokerBinder() {
        IGmsServiceBroker iGmsServiceBroker0;
        synchronized(this.zzq) {
            iGmsServiceBroker0 = this.zzr;
            if(iGmsServiceBroker0 == null) {
                return null;
            }
        }
        return iGmsServiceBroker0.asBinder();
    }

    @KeepForSdk
    public abstract String getServiceDescriptor();

    @KeepForSdk
    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @KeepForSdk
    public abstract String getStartServiceAction();

    @KeepForSdk
    public String getStartServicePackage() [...] // Inlined contents

    @KeepForSdk
    public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        return this.zzE == null ? null : this.zzE.zzd;
    }

    @KeepForSdk
    public boolean getUseDynamicLookup() {
        return this.getMinApkVersion() >= 211700000;
    }

    @KeepForSdk
    public boolean hasConnectionInfo() {
        return this.zzE != null;
    }

    @KeepForSdk
    public boolean isConnected() {
        synchronized(this.zzp) {
        }
        return this.zzv == 4;
    }

    @KeepForSdk
    public boolean isConnecting() {
        boolean z = true;
        synchronized(this.zzp) {
            if(this.zzv != 2 && this.zzv != 3) {
                z = false;
            }
        }
        return z;
    }

    @KeepForSdk
    public void onConnectedLocked(IInterface iInterface0) {
        this.zzh = System.currentTimeMillis();
    }

    @KeepForSdk
    public void onConnectionFailed(ConnectionResult connectionResult0) {
        this.zzi = connectionResult0.getErrorCode();
        this.zzj = System.currentTimeMillis();
    }

    @KeepForSdk
    public void onConnectionSuspended(int v) {
        this.zzf = v;
        this.zzg = System.currentTimeMillis();
    }

    @KeepForSdk
    public void onPostInitHandler(int v, IBinder iBinder0, Bundle bundle0, int v1) {
        zzf zzf0 = new zzf(this, v, iBinder0, bundle0);
        Message message0 = this.zzb.obtainMessage(1, v1, -1, zzf0);
        this.zzb.sendMessage(message0);
    }

    @KeepForSdk
    public void onUserSignOut(SignOutCallbacks baseGmsClient$SignOutCallbacks0) {
        baseGmsClient$SignOutCallbacks0.onSignOutComplete();
    }

    @KeepForSdk
    public boolean providesSignIn() {
        return false;
    }

    @KeepForSdk
    public boolean requiresAccount() {
        return false;
    }

    @KeepForSdk
    public boolean requiresGooglePlayServices() {
        return true;
    }

    @KeepForSdk
    public boolean requiresSignIn() {
        return false;
    }

    @KeepForSdk
    public void setAttributionSourceWrapper(AttributionSourceWrapper attributionSourceWrapper0) {
        this.zzB = attributionSourceWrapper0;
    }

    @KeepForSdk
    public void setAttributionTag(String s) {
        this.zzA = s;
    }

    @KeepForSdk
    public void triggerConnectionSuspended(int v) {
        int v1 = this.zzd.get();
        Message message0 = this.zzb.obtainMessage(6, v1, v);
        this.zzb.sendMessage(message0);
    }

    @KeepForSdk
    public void triggerNotAvailable(ConnectionProgressReportCallbacks baseGmsClient$ConnectionProgressReportCallbacks0, int v, PendingIntent pendingIntent0) {
        Preconditions.checkNotNull(baseGmsClient$ConnectionProgressReportCallbacks0, "Connection progress callbacks cannot be null.");
        this.zzc = baseGmsClient$ConnectionProgressReportCallbacks0;
        int v1 = this.zzd.get();
        Message message0 = this.zzb.obtainMessage(3, v1, v, pendingIntent0);
        this.zzb.sendMessage(message0);
    }

    @KeepForSdk
    public boolean usesClientTelemetry() {
        return false;
    }

    public final String zza() {
        return this.zzz == null ? this.zzl.getClass().getName() : this.zzz;
    }

    public final void zzb(int v, Bundle bundle0, int v1) {
        zzg zzg0 = new zzg(this, v, bundle0);
        Message message0 = this.zzb.obtainMessage(7, v1, -1, zzg0);
        this.zzb.sendMessage(message0);
    }

    public final void zzc(zzj zzj0) {
        this.zzE = zzj0;
        if(this.usesClientTelemetry()) {
            ConnectionTelemetryConfiguration connectionTelemetryConfiguration0 = zzj0.zzd;
            RootTelemetryConfigManager.getInstance().zza((connectionTelemetryConfiguration0 == null ? null : connectionTelemetryConfiguration0.zza()));
        }
    }

    public final void zzd(int v, IInterface iInterface0) {
        this.zzp(v, null);
    }

    public final boolean zze(int v, int v1, IInterface iInterface0) {
        synchronized(this.zzp) {
            if(this.zzv != v) {
                return false;
            }
            this.zzp(v1, iInterface0);
            return true;
        }
    }

    public final void zzf(int v) {
        int v1;
        synchronized(this.zzp) {
        }
        if(this.zzv == 3) {
            this.zzD = true;
            v1 = 5;
        }
        else {
            v1 = 4;
        }
        int v2 = this.zzd.get();
        Message message0 = this.zzb.obtainMessage(v1, v2, 16);
        this.zzb.sendMessage(message0);
    }

    public final boolean zzg() {
        if(this.zzD) {
            return false;
        }
        if(TextUtils.isEmpty(this.getServiceDescriptor())) {
            return false;
        }
        if(TextUtils.isEmpty(null)) {
            return false;
        }
        try {
            Class.forName(this.getServiceDescriptor());
            return true;
        }
        catch(ClassNotFoundException unused_ex) {
            return false;
        }
    }

    public final Object zzh() {
        return this.zzq;
    }

    public final void zzi(IGmsServiceBroker iGmsServiceBroker0) {
        this.zzr = iGmsServiceBroker0;
    }

    public final ArrayList zzj() {
        return this.zzt;
    }

    public final BaseConnectionCallbacks zzk() {
        return this.zzw;
    }

    public final BaseOnConnectionFailedListener zzl() {
        return this.zzx;
    }

    public final ConnectionResult zzm() {
        return this.zzC;
    }

    public final void zzn(ConnectionResult connectionResult0) {
        this.zzC = connectionResult0;
    }

    public final boolean zzo() {
        return this.zzD;
    }

    private final void zzp(int v, IInterface iInterface0) {
        Preconditions.checkArgument((v == 4 ? 1 : 0) == (iInterface0 == null ? 0 : 1));
        synchronized(this.zzp) {
            this.zzv = v;
            this.zzs = iInterface0;
            Bundle bundle0 = null;
            if(v == 1) {
                zze zze2 = this.zzu;
                if(zze2 != null) {
                    String s6 = this.zza.zza();
                    Preconditions.checkNotNull(s6);
                    String s7 = this.zza.zzb();
                    String s8 = this.zza();
                    this.zzn.zzb(s6, s7, 0x1081, zze2, s8, this.zza.zzc());
                    this.zzu = null;
                }
            }
            else {
                switch(v) {
                    case 2: 
                    case 3: {
                        zze zze0 = this.zzu;
                        if(zze0 != null) {
                            zzs zzs0 = this.zza;
                            if(zzs0 != null) {
                                Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzs0.zza() + " on " + zzs0.zzb());
                                String s = this.zza.zza();
                                Preconditions.checkNotNull(s);
                                String s1 = this.zza.zzb();
                                String s2 = this.zza();
                                this.zzn.zzb(s, s1, 0x1081, zze0, s2, this.zza.zzc());
                                this.zzd.incrementAndGet();
                            }
                        }
                        zze zze1 = new zze(this, this.zzd.get());
                        this.zzu = zze1;
                        zzs zzs1 = new zzs("com.google.android.gms", this.getStartServiceAction(), false, 0x1081, this.getUseDynamicLookup());
                        this.zza = zzs1;
                        if(zzs1.zzc() && this.getMinApkVersion() < 17895000) {
                            throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: " + this.zza.zza());
                        }
                        String s3 = this.zza.zza();
                        Preconditions.checkNotNull(s3);
                        String s4 = this.zza.zzb();
                        String s5 = this.zza();
                        zzn zzn0 = new zzn(s3, s4, 0x1081, this.zza.zzc());
                        ConnectionResult connectionResult0 = this.zzn.zza(zzn0, zze1, s5, this.getBindServiceExecutor());
                        if(!connectionResult0.isSuccess()) {
                            Log.w("GmsClient", "unable to connect to service: " + this.zza.zza() + " on " + this.zza.zzb());
                            int v1 = connectionResult0.getErrorCode() == -1 ? 16 : connectionResult0.getErrorCode();
                            if(connectionResult0.getResolution() != null) {
                                bundle0 = new Bundle();
                                bundle0.putParcelable("pendingIntent", connectionResult0.getResolution());
                            }
                            this.zzb(v1, bundle0, this.zzd.get());
                        }
                        break;
                    }
                    case 4: {
                        Preconditions.checkNotNull(iInterface0);
                        this.onConnectedLocked(iInterface0);
                    }
                }
            }
        }
    }
}

