package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import jeb.synthetic.FIN;

@ParametersAreNonnullByDefault
public class AdvertisingIdClient {
    @KeepForSdkWithMembers
    public static final class Info {
        private final String zza;
        private final boolean zzb;

        @Deprecated
        public Info(String s, boolean z) {
            this.zza = s;
            this.zzb = z;
        }

        public String getId() {
            return this.zza;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzb;
        }

        @Override
        public String toString() {
            return "{" + this.zza + "}" + this.zzb;
        }
    }

    BlockingServiceConnection zza;
    zzf zzb;
    boolean zzc;
    final Object zzd;
    zzb zze;
    final long zzf;
    private static final Object zzg;
    private static volatile AdvertisingIdClient zzh;
    private final Context zzi;

    static {
        AdvertisingIdClient.zzg = new Object();
    }

    @KeepForSdk
    public AdvertisingIdClient(Context context0) {
        this(context0, 30000L, false, false);
    }

    public AdvertisingIdClient(Context context0, long v, boolean z, boolean z1) {
        this.zzd = new Object();
        Preconditions.checkNotNull(context0);
        this.zzi = context0.getApplicationContext();
        this.zzc = false;
        this.zzf = v;
    }

    @Override
    public final void finalize() {
        this.zza();
        super.finalize();
    }

    public static Info getAdvertisingIdInfo(Context context0) {
        zzd zzd1;
        long v4;
        long v3;
        AdvertisingIdClient advertisingIdClient1;
        Info advertisingIdClient$Info0;
        AdvertisingIdClient advertisingIdClient0 = AdvertisingIdClient.zzh;
        if(advertisingIdClient0 == null) {
            synchronized(AdvertisingIdClient.zzg) {
                advertisingIdClient0 = AdvertisingIdClient.zzh;
                if(advertisingIdClient0 == null) {
                    Log.d("AdvertisingIdClient", "Creating AdvertisingIdClient");
                    advertisingIdClient0 = new AdvertisingIdClient(context0);
                    AdvertisingIdClient.zzh = advertisingIdClient0;
                }
            }
        }
        Log.d("AdvertisingIdClient", "AdvertisingIdClient already created.");
        zzd zzd0 = zzd.zza(context0);
        long v1 = SystemClock.elapsedRealtime();
        int v2 = -1;
        try {
            advertisingIdClient$Info0 = advertisingIdClient0.zzf(-1);
            advertisingIdClient1 = advertisingIdClient0;
            v3 = SystemClock.elapsedRealtime() - v1;
            advertisingIdClient1 = advertisingIdClient0;
            advertisingIdClient1.zze(advertisingIdClient$Info0, true, 0.0f, v3, "", null);
            v4 = SystemClock.elapsedRealtime();
        }
        catch(Throwable throwable0) {
            zzd1 = zzd0;
            goto label_33;
        }
        try {
            zzd1 = zzd0;
            zzd0.zzc(35401, 0, v1, System.currentTimeMillis(), ((int)(v4 - v1)));
            zzd1 = zzd0;
            Log.i("AdvertisingIdClient", "GetInfoInternal elapse " + v3 + "ms");
            return advertisingIdClient$Info0;
        }
        catch(Throwable throwable0) {
        }
    label_33:
        advertisingIdClient1.zze(null, true, 0.0f, -1L, "", throwable0);
        if(throwable0 instanceof IOException) {
            v2 = 1;
        }
        else if(throwable0 instanceof GooglePlayServicesNotAvailableException) {
            v2 = 9;
        }
        else if(throwable0 instanceof GooglePlayServicesRepairableException) {
            v2 = 16;
        }
        else if(throwable0 instanceof IllegalStateException) {
            v2 = 8;
        }
        zzd1.zzc(35401, v2, v1, System.currentTimeMillis(), ((int)(SystemClock.elapsedRealtime() - v1)));
        throw throwable0;
    }

    @KeepForSdk
    public Info getInfo() {
        return this.zzf(-1);
    }

    @KeepForSdk
    public static boolean getIsAdIdFakeForDebugLogging(Context context0) {
        boolean z;
        AdvertisingIdClient advertisingIdClient0 = new AdvertisingIdClient(context0, -1L, false, false);
        try {
            advertisingIdClient0.zzc(false);
            Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
            synchronized(advertisingIdClient0) {
                advertisingIdClient0.zzd();
                Preconditions.checkNotNull(advertisingIdClient0.zza);
                Preconditions.checkNotNull(advertisingIdClient0.zzb);
                try {
                    z = advertisingIdClient0.zzb.zzd();
                }
                catch(RemoteException remoteException0) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", remoteException0);
                    throw new IOException("Remote exception", remoteException0);
                }
            }
            advertisingIdClient0.zzb();
            return z;
        }
        finally {
            advertisingIdClient0.zza();
        }
    }

    @KeepForSdk
    @ShowFirstParty
    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    @KeepForSdk
    public void start() {
        this.zzc(true);
    }

    public final void zza() {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized(this) {
            if(this.zzi != null && this.zza != null) {
                if(this.zzc) {
                    try {
                        ConnectionTracker.getInstance().unbindService(this.zzi, this.zza);
                    }
                    catch(Throwable throwable0) {
                        Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", throwable0);
                    }
                }
                this.zzc = false;
                this.zzb = null;
                this.zza = null;
            }
        }
    }

    public final void zzb() {
        synchronized(this.zzd) {
            zzb zzb0 = this.zze;
            if(zzb0 != null) {
                zzb0.zza.countDown();
                try {
                    this.zze.join();
                }
                catch(InterruptedException unused_ex) {
                }
            }
            long v1 = this.zzf;
            if(v1 > 0L) {
                this.zze = new zzb(this, v1);
            }
        }
    }

    public final void zzc(boolean z) {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        if(z) {
            this.zzb();
        }
        __monitor_enter(this);
        int v = FIN.finallyOpen$NT();
        if(this.zzc) {
            FIN.finallyCodeBegin$NT(v);
            __monitor_exit(this);
            FIN.finallyCodeEnd$NT(v);
            return;
        }
        try {
            Context context0 = this.zzi;
            context0.getPackageManager().getPackageInfo("com.android.vending", 0);
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            FIN.finallyExec$NT(v);
            throw new GooglePlayServicesNotAvailableException(9);
        }
        switch(GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context0, 12451000)) {
            case 0: 
            case 2: {
                BlockingServiceConnection blockingServiceConnection0 = new BlockingServiceConnection();
                Intent intent0 = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent0.setPackage("com.google.android.gms");
                try {
                    if(ConnectionTracker.getInstance().bindService(context0, intent0, blockingServiceConnection0, 1)) {
                        goto label_26;
                    }
                    goto label_36;
                }
                catch(Throwable throwable0) {
                    FIN.finallyExec$NT(v);
                    throw new IOException(throwable0);
                }
                try {
                label_26:
                    this.zza = blockingServiceConnection0;
                    this.zzb = zze.zza(blockingServiceConnection0.getServiceWithTimeout(10000L, TimeUnit.MILLISECONDS));
                    this.zzc = true;
                    FIN.finallyExec$NT(v);
                    return;
                }
                catch(InterruptedException unused_ex) {
                    FIN.finallyExec$NT(v);
                    throw new IOException("Interrupted exception");
                }
                catch(Throwable throwable1) {
                    FIN.finallyExec$NT(v);
                    throw new IOException(throwable1);
                }
            label_36:
                FIN.finallyExec$NT(v);
                throw new IOException("Connection failure");
            }
            default: {
                FIN.finallyExec$NT(v);
                throw new IOException("Google Play services not available");
            }
        }
    }

    public final void zzd() {
        synchronized(this) {
            if(!this.zzc) {
                try {
                    Log.d("AdvertisingIdClient", "AdvertisingIdClient is not bounded. Starting to bind it...");
                    this.zzc(false);
                    Log.d("AdvertisingIdClient", "AdvertisingIdClient is bounded");
                }
                catch(Exception exception0) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", exception0);
                }
                if(!this.zzc) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.");
                }
            }
        }
    }

    public final boolean zze(Info advertisingIdClient$Info0, boolean z, float f, long v, String s, Throwable throwable0) {
        if(Math.random() <= 0.0) {
            HashMap hashMap0 = new HashMap();
            String s1 = "1";
            hashMap0.put("app_context", "1");
            if(advertisingIdClient$Info0 != null) {
                if(!advertisingIdClient$Info0.isLimitAdTrackingEnabled()) {
                    s1 = "0";
                }
                hashMap0.put("limit_ad_tracking", s1);
                String s2 = advertisingIdClient$Info0.getId();
                if(s2 != null) {
                    hashMap0.put("ad_id_size", Integer.toString(s2.length()));
                }
            }
            if(throwable0 != null) {
                hashMap0.put("error", throwable0.getClass().getName());
            }
            hashMap0.put("tag", "AdvertisingIdClient");
            hashMap0.put("time_spent", Long.toString(v));
            new zza(this, hashMap0).start();
            return true;
        }
        return false;
    }

    private final Info zzf(int v) {
        Info advertisingIdClient$Info0;
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized(this) {
            this.zzd();
            Preconditions.checkNotNull(this.zza);
            Preconditions.checkNotNull(this.zzb);
            try {
                advertisingIdClient$Info0 = new Info(this.zzb.zzc(), this.zzb.zze(true));
            }
            catch(RemoteException remoteException0) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", remoteException0);
                throw new IOException("Remote exception", remoteException0);
            }
        }
        this.zzb();
        return advertisingIdClient$Info0;
    }
}

