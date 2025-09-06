package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.Executor;

@KeepForSdk
public abstract class GmsClientSupervisor {
    static HandlerThread zza = null;
    private static final Object zzb = null;
    private static int zzc = 9;
    private static zzq zzd = null;
    private static Executor zze = null;
    private static boolean zzf = false;

    static {
        GmsClientSupervisor.zzb = new Object();
    }

    @KeepForSdk
    public boolean bindService(ComponentName componentName0, ServiceConnection serviceConnection0, String s) {
        return this.zza(new zzn(componentName0, 0x1081), serviceConnection0, s, null).isSuccess();
    }

    @KeepForSdk
    public boolean bindService(ComponentName componentName0, ServiceConnection serviceConnection0, String s, Executor executor0) {
        return this.zza(new zzn(componentName0, 0x1081), serviceConnection0, s, executor0).isSuccess();
    }

    @KeepForSdk
    public boolean bindService(String s, ServiceConnection serviceConnection0, String s1) {
        return this.zza(new zzn(s, 0x1081, false), serviceConnection0, s1, null).isSuccess();
    }

    @KeepForSdk
    public static int getDefaultBindFlags() [...] // Inlined contents

    @KeepForSdk
    public static GmsClientSupervisor getInstance(Context context0) {
        synchronized(GmsClientSupervisor.zzb) {
            if(GmsClientSupervisor.zzd == null) {
                GmsClientSupervisor.zzd = new zzq(context0.getApplicationContext(), (GmsClientSupervisor.zzf ? GmsClientSupervisor.getOrStartHandlerThread().getLooper() : context0.getMainLooper()), GmsClientSupervisor.zze);
            }
            return GmsClientSupervisor.zzd;
        }
    }

    @KeepForSdk
    public static HandlerThread getOrStartHandlerThread() {
        synchronized(GmsClientSupervisor.zzb) {
            HandlerThread handlerThread0 = GmsClientSupervisor.zza;
            if(handlerThread0 != null) {
                return handlerThread0;
            }
            HandlerThread handlerThread1 = new HandlerThread("GoogleApiHandler", GmsClientSupervisor.zzc);
            GmsClientSupervisor.zza = handlerThread1;
            handlerThread1.start();
            return GmsClientSupervisor.zza;
        }
    }

    @KeepForSdk
    public static HandlerThread getOrStartHandlerThread(int v) {
        synchronized(GmsClientSupervisor.zzb) {
            HandlerThread handlerThread0 = GmsClientSupervisor.zza;
            if(handlerThread0 != null) {
                return handlerThread0;
            }
            HandlerThread handlerThread1 = new HandlerThread("GoogleApiHandler", v);
            GmsClientSupervisor.zza = handlerThread1;
            handlerThread1.start();
            return GmsClientSupervisor.zza;
        }
    }

    @KeepForSdk
    public static void setDefaultBindExecutor(Executor executor0) {
        synchronized(GmsClientSupervisor.zzb) {
            zzq zzq0 = GmsClientSupervisor.zzd;
            if(zzq0 != null) {
                zzq0.zze(executor0);
            }
            GmsClientSupervisor.zze = executor0;
        }
    }

    @KeepForSdk
    public static boolean setGamHandlerThreadPriorityIfNotInitialized(int v) {
        synchronized(GmsClientSupervisor.zzb) {
            if(GmsClientSupervisor.zza == null) {
                GmsClientSupervisor.zzc = v;
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public static void setUseHandlerThreadForCallbacks() {
        synchronized(GmsClientSupervisor.zzb) {
            zzq zzq0 = GmsClientSupervisor.zzd;
            if(zzq0 != null && !GmsClientSupervisor.zzf) {
                zzq0.zzd(GmsClientSupervisor.getOrStartHandlerThread().getLooper());
            }
            GmsClientSupervisor.zzf = true;
        }
    }

    @KeepForSdk
    public void unbindService(ComponentName componentName0, ServiceConnection serviceConnection0, String s) {
        this.zzc(new zzn(componentName0, 0x1081), serviceConnection0, s);
    }

    @KeepForSdk
    public void unbindService(String s, ServiceConnection serviceConnection0, String s1) {
        this.zzc(new zzn(s, 0x1081, false), serviceConnection0, s1);
    }

    public abstract ConnectionResult zza(zzn arg1, ServiceConnection arg2, String arg3, Executor arg4);

    public final void zzb(String s, String s1, int v, ServiceConnection serviceConnection0, String s2, boolean z) {
        this.zzc(new zzn(s, s1, 0x1081, z), serviceConnection0, s2);
    }

    public abstract void zzc(zzn arg1, ServiceConnection arg2, String arg3);
}

