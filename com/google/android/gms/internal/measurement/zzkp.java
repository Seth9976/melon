package com.google.android.gms.internal.measurement;

public enum zzkp implements zzmi {
    PURPOSE_RESTRICTION_NOT_ALLOWED(0),
    PURPOSE_RESTRICTION_REQUIRE_CONSENT(1),
    PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST(2),
    PURPOSE_RESTRICTION_UNDEFINED(3),
    UNRECOGNIZED(-1);

    private final int zzf;

    private zzkp(int v1) {
        this.zzf = v1;
    }

    @Override
    public final String toString() {
        return Integer.toString(this.zzf);
    }

    @Override  // com.google.android.gms.internal.measurement.zzmi
    public final int zza() {
        if(this == zzkp.zze) {
            throw new IllegalArgumentException("Can\'t get the number of an unknown enum value.");
        }
        return this.zzf;
    }
}

