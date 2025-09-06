package com.google.android.gms.internal.auth_blockstore;

import com.google.android.gms.common.Feature;

public final class zzab {
    public static final Feature zza;
    public static final Feature zzb;
    public static final Feature zzc;
    public static final Feature zzd;
    public static final Feature zze;
    public static final Feature zzf;
    public static final Feature zzg;
    public static final Feature zzh;
    public static final Feature zzi;
    public static final Feature zzj;
    public static final Feature zzk;
    public static final Feature[] zzl;

    static {
        Feature feature0 = new Feature("auth_blockstore", 3L);
        zzab.zza = feature0;
        Feature feature1 = new Feature("blockstore_data_transfer", 1L);
        zzab.zzb = feature1;
        Feature feature2 = new Feature("blockstore_notify_app_restore", 1L);
        zzab.zzc = feature2;
        Feature feature3 = new Feature("blockstore_store_bytes_with_options", 2L);
        zzab.zzd = feature3;
        Feature feature4 = new Feature("blockstore_is_end_to_end_encryption_available", 1L);
        zzab.zze = feature4;
        Feature feature5 = new Feature("blockstore_enable_cloud_backup", 1L);
        zzab.zzf = feature5;
        Feature feature6 = new Feature("blockstore_delete_bytes", 2L);
        zzab.zzg = feature6;
        Feature feature7 = new Feature("blockstore_retrieve_bytes_with_options", 3L);
        zzab.zzh = feature7;
        Feature feature8 = new Feature("auth_clear_restore_credential", 1L);
        zzab.zzi = feature8;
        Feature feature9 = new Feature("auth_create_restore_credential", 1L);
        zzab.zzj = feature9;
        Feature feature10 = new Feature("auth_get_restore_credential", 1L);
        zzab.zzk = feature10;
        zzab.zzl = new Feature[]{feature0, feature1, feature2, feature3, feature4, feature5, feature6, feature7, feature8, feature9, feature10};
    }
}

