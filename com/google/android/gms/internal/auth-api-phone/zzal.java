package com.google.android.gms.internal.auth-api-phone;

import com.google.android.gms.common.Feature;

public final class zzal {
    public static final Feature zza;
    public static final Feature zzb;
    public static final Feature zzc;
    public static final Feature zzd;
    public static final Feature zze;
    public static final Feature[] zzf;

    static {
        Feature feature0 = new Feature("sms_code_autofill", 2L);
        zzal.zza = feature0;
        Feature feature1 = new Feature("sms_code_browser", 2L);
        zzal.zzb = feature1;
        Feature feature2 = new Feature("sms_retrieve", 1L);
        zzal.zzc = feature2;
        Feature feature3 = new Feature("user_consent", 3L);
        zzal.zzd = feature3;
        Feature feature4 = new Feature("missed_call_retriever", 2L);
        zzal.zze = feature4;
        zzal.zzf = new Feature[]{feature0, feature1, feature2, feature3, feature4};
    }
}

