package com.google.android.gms.internal.cast;

import android.content.Context;
import com.google.android.gms.cast.CastMediaControlIntent;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionProvider;
import com.google.android.gms.cast.framework.media.internal.zzu;

public final class zzai extends SessionProvider {
    private final CastOptions zza;
    private final zzbf zzb;

    public zzai(Context context0, CastOptions castOptions0, zzbf zzbf0) {
        super(context0, (castOptions0.getSupportedNamespaces().isEmpty() ? CastMediaControlIntent.categoryForCast(castOptions0.getReceiverApplicationId()) : CastMediaControlIntent.categoryForCast(castOptions0.getReceiverApplicationId(), castOptions0.getSupportedNamespaces())));
        this.zza = castOptions0;
        this.zzb = zzbf0;
    }

    @Override  // com.google.android.gms.cast.framework.SessionProvider
    public final Session createSession(String s) {
        zzu zzu0 = new zzu(this.getContext(), this.zza, this.zzb);
        return new CastSession(this.getContext(), this.getCategory(), s, this.zza, this.zzb, zzu0);
    }

    @Override  // com.google.android.gms.cast.framework.SessionProvider
    public final boolean isSessionRecoverable() {
        return this.zza.getResumeSavedSession();
    }
}

