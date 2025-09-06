package com.google.android.gms.internal.measurement;

public enum zzin implements zzmi {
    CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN(0),
    CLIENT_UPLOAD_ELIGIBLE(1),
    MEASUREMENT_SERVICE_NOT_ENABLED(2),
    ANDROID_TOO_OLD(3),
    NON_PLAY_MODE(4),
    SDK_TOO_OLD(5),
    MISSING_JOB_SCHEDULER(6),
    NOT_ENABLED_IN_MANIFEST(7),
    CLIENT_FLAG_OFF(8),
    SERVICE_FLAG_OFF(20),
    PINNED_TO_SERVICE_UPLOAD(21),
    MISSING_SGTM_SERVER_URL(22);

    private final int zzm;

    private zzin(int v1) {
        this.zzm = v1;
    }

    @Override
    public final String toString() {
        return Integer.toString(this.zzm);
    }

    @Override  // com.google.android.gms.internal.measurement.zzmi
    public final int zza() {
        return this.zzm;
    }

    public static zzin zzb(int v) {
        switch(v) {
            case 0: {
                return zzin.zza;
            }
            case 1: {
                return zzin.zzb;
            }
            case 2: {
                return zzin.zzc;
            }
            case 3: {
                return zzin.zzd;
            }
            case 4: {
                return zzin.zze;
            }
            case 5: {
                return zzin.zzf;
            }
            case 6: {
                return zzin.zzg;
            }
            case 7: {
                return zzin.zzh;
            }
            case 8: {
                return zzin.zzi;
            }
            case 20: {
                return zzin.zzj;
            }
            case 21: {
                return zzin.zzk;
            }
            case 22: {
                return zzin.zzl;
            }
            default: {
                return null;
            }
        }
    }
}

