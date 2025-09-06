package com.google.android.gms.cast.framework;

import com.google.android.gms.dynamic.IObjectWrapper;

final class zzbk extends zzbb {
    final SessionProvider zza;

    public zzbk(SessionProvider sessionProvider0, zzbl zzbl0) {
        this.zza = sessionProvider0;
        super();
    }

    @Override  // com.google.android.gms.cast.framework.zzbc
    public final IObjectWrapper zzb(String s) {
        Session session0 = this.zza.createSession(s);
        return session0 == null ? null : session0.zzn();
    }

    @Override  // com.google.android.gms.cast.framework.zzbc
    public final String zzc() {
        return this.zza.getCategory();
    }

    @Override  // com.google.android.gms.cast.framework.zzbc
    public final boolean zzd() {
        return this.zza.isSessionRecoverable();
    }
}

