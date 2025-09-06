package com.google.android.gms.internal.cast;

import android.app.Service;
import android.content.Context;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.ModuleUnavailableException;
import com.google.android.gms.cast.framework.media.internal.zzh;
import com.google.android.gms.cast.framework.media.internal.zzj;
import com.google.android.gms.cast.framework.zzaj;
import com.google.android.gms.cast.framework.zzat;
import com.google.android.gms.cast.framework.zzaw;
import com.google.android.gms.cast.framework.zzbe;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.Map;

public final class zzag {
    private static final Logger zza;

    static {
        zzag.zza = new Logger("CastDynamiteModule");
    }

    public static zzaj zza(Context context0, CastOptions castOptions0, zzam zzam0, Map map0) {
        return zzag.zzf(context0).zzf(ObjectWrapper.wrap(context0.getApplicationContext()), castOptions0, zzam0, map0);
    }

    public static com.google.android.gms.cast.framework.zzam zzb(Context context0, CastOptions castOptions0, IObjectWrapper iObjectWrapper0, com.google.android.gms.cast.framework.zzag zzag0) {
        if(iObjectWrapper0 == null) {
            return null;
        }
        try {
            return zzag.zzf(context0).zzg(castOptions0, iObjectWrapper0, zzag0);
        }
        catch(RemoteException | ModuleUnavailableException remoteException0) {
            zzag.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"newCastSessionImpl", "zzak"});
            return null;
        }
    }

    public static zzat zzc(Service service0, IObjectWrapper iObjectWrapper0, IObjectWrapper iObjectWrapper1) {
        if(iObjectWrapper0 != null && iObjectWrapper1 != null) {
            try {
                return zzag.zzf(service0.getApplicationContext()).zzh(ObjectWrapper.wrap(service0), iObjectWrapper0, iObjectWrapper1);
            }
            catch(RemoteException | ModuleUnavailableException remoteException0) {
                zzag.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"newReconnectionServiceImpl", "zzak"});
            }
        }
        return null;
    }

    public static zzaw zzd(Context context0, String s, String s1, zzbe zzbe0) {
        try {
            return zzag.zzf(context0).zzi(s, s1, zzbe0);
        }
        catch(RemoteException | ModuleUnavailableException exception0) {
            zzag.zza.d(exception0, "Unable to call %s on %s.", new Object[]{"newSessionImpl", "zzak"});
            return null;
        }
    }

    public static zzh zze(Context context0, AsyncTask asyncTask0, zzj zzj0, int v, int v1, boolean z, long v2, int v3, int v4, int v5) {
        try {
            zzak zzak0 = zzag.zzf(context0.getApplicationContext());
            IObjectWrapper iObjectWrapper0 = ObjectWrapper.wrap(context0.getApplicationContext());
            return zzak0.zze() < 233700000 ? zzak0.zzj(ObjectWrapper.wrap(asyncTask0), zzj0, v, v1, false, 0x200000L, 5, 333, 10000) : zzak0.zzk(iObjectWrapper0, ObjectWrapper.wrap(asyncTask0), zzj0, v, v1, false, 0x200000L, 5, 333, 10000);
        }
        catch(RemoteException | ModuleUnavailableException exception0) {
            zzag.zza.d(exception0, "Unable to call %s on %s.", new Object[]{"newFetchBitmapTaskImpl", "zzak"});
            return null;
        }
    }

    private static zzak zzf(Context context0) {
        try {
            IBinder iBinder0 = DynamiteModule.load(context0, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.cast.framework.dynamite").instantiate("com.google.android.gms.cast.framework.internal.CastDynamiteModuleImpl");
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
            return iInterface0 instanceof zzak ? ((zzak)iInterface0) : new com.google.android.gms.internal.cast.zzaj(iBinder0);
        }
        catch(LoadingException dynamiteModule$LoadingException0) {
            throw new ModuleUnavailableException(dynamiteModule$LoadingException0);
        }
    }
}

