package com.google.android.gms.flags;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import com.google.android.gms.dynamite.DynamiteModule;

public final class zzb {
    private boolean zza;
    private zze zzb;

    public zzb() {
        this.zza = false;
        this.zzb = null;
    }

    public final Object zza(Flag flag0) {
        synchronized(this) {
            if(!this.zza) {
                return flag0.zzc();
            }
        }
        return flag0.zza(this.zzb);
    }

    public final void zzb(Context context0) {
        synchronized(this) {
            if(this.zza) {
                return;
            }
            try {
                zze zze0 = zzd.asInterface(DynamiteModule.load(context0, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.flags").instantiate("com.google.android.gms.flags.impl.FlagProviderImpl"));
                this.zzb = zze0;
                zze0.init(ObjectWrapper.wrap(context0));
                this.zza = true;
            }
            catch(LoadingException | RemoteException dynamiteModule$LoadingException0) {
                Log.w("FlagValueProvider", "Failed to initialize flags module.", dynamiteModule$LoadingException0);
            }
        }
    }
}

