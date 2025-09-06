package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;

public abstract class SessionProvider {
    private final Context zza;
    private final String zzb;
    private final zzbk zzc;

    public SessionProvider(Context context0, String s) {
        this.zzc = new zzbk(this, null);
        this.zza = ((Context)Preconditions.checkNotNull(context0)).getApplicationContext();
        this.zzb = Preconditions.checkNotEmpty(s);
    }

    public abstract Session createSession(String arg1);

    public final String getCategory() {
        return this.zzb;
    }

    public final Context getContext() {
        return this.zza;
    }

    public abstract boolean isSessionRecoverable();

    public final IBinder zza() {
        return this.zzc;
    }
}

