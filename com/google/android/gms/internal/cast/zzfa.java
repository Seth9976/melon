package com.google.android.gms.internal.cast;

import com.google.android.gms.common.Feature;

public final class zzfa {
    public static final Feature zza;
    public static final Feature zzb;
    public static final Feature zzc;
    public static final Feature zzd;
    public static final Feature zze;
    public static final Feature[] zzf;

    static {
        Feature feature0 = new Feature("usage_and_diagnostics_listener", 1L);
        zzfa.zza = feature0;
        Feature feature1 = new Feature("usage_and_diagnostics_consents", 1L);
        zzfa.zzb = feature1;
        Feature feature2 = new Feature("usage_and_diagnostics_check_consents", 1L);
        zzfa.zzc = feature2;
        Feature feature3 = new Feature("usage_and_diagnostics_settings_access", 1L);
        zzfa.zzd = feature3;
        Feature feature4 = new Feature("el_capitan", 1L);
        zzfa.zze = feature4;
        zzfa.zzf = new Feature[]{feature0, feature1, feature2, feature3, feature4};
    }
}

