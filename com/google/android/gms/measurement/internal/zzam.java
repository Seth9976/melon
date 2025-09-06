package com.google.android.gms.measurement.internal;

enum zzam {
    UNSET('0'),
    REMOTE_DEFAULT('1'),
    REMOTE_DELEGATION('2'),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    TCF('7'),
    REMOTE_ENFORCED_DEFAULT('8'),
    FAILSAFE('9');

    private final char zzk;

    private zzam(char c) {
        this.zzk = c;
    }

    public static zzam zza(char c) {
        zzam[] arr_zzam = zzam.values();
        for(int v = 0; v < arr_zzam.length; ++v) {
            zzam zzam0 = arr_zzam[v];
            if(zzam0.zzk == c) {
                return zzam0;
            }
        }
        return zzam.zza;
    }

    public final char zzb() {
        return this.zzk;
    }
}

