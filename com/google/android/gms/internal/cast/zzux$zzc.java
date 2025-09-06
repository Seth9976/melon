package com.google.android.gms.internal.cast;

final class zzux.zzc {
    static final zzux.zzc zza;
    final Throwable zzb;

    static {
        zzux.zzc.zza = new zzux.zzc(new Throwable("Failure occurred while trying to finish a future.") {
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override
            public final Throwable fillInStackTrace() {
                return this;
            }
        });
    }

    public zzux.zzc(Throwable throwable0) {
        throwable0.getClass();
        this.zzb = throwable0;
    }
}

