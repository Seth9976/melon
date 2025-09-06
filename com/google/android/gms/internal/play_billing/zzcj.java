package com.google.android.gms.internal.play_billing;

public enum zzcj {
    DOUBLE(0, 1, zzdd.zze),
    FLOAT(1, 1, zzdd.zzd),
    INT64(2, 1, zzdd.zzc),
    UINT64(3, 1, zzdd.zzc),
    INT32(4, 1, zzdd.zzb),
    FIXED64(5, 1, zzdd.zzc),
    FIXED32(6, 1, zzdd.zzb),
    BOOL(7, 1, zzdd.zzf),
    STRING(8, 1, zzdd.zzg),
    MESSAGE(9, 1, zzdd.zzj),
    BYTES(10, 1, zzdd.zzh),
    UINT32(11, 1, zzdd.zzb),
    ENUM(12, 1, zzdd.zzi),
    SFIXED32(13, 1, zzdd.zzb),
    SFIXED64(14, 1, zzdd.zzc),
    SINT32(15, 1, zzdd.zzb),
    SINT64(16, 1, zzdd.zzc),
    GROUP(17, 1, zzdd.zzj),
    DOUBLE_LIST(18, 2, zzdd.zze),
    FLOAT_LIST(19, 2, zzdd.zzd),
    INT64_LIST(20, 2, zzdd.zzc),
    UINT64_LIST(21, 2, zzdd.zzc),
    INT32_LIST(22, 2, zzdd.zzb),
    FIXED64_LIST(23, 2, zzdd.zzc),
    FIXED32_LIST(24, 2, zzdd.zzb),
    BOOL_LIST(25, 2, zzdd.zzf),
    STRING_LIST(26, 2, zzdd.zzg),
    MESSAGE_LIST(27, 2, zzdd.zzj),
    BYTES_LIST(28, 2, zzdd.zzh),
    UINT32_LIST(29, 2, zzdd.zzb),
    ENUM_LIST(30, 2, zzdd.zzi),
    SFIXED32_LIST(0x1F, 2, zzdd.zzb),
    SFIXED64_LIST(0x20, 2, zzdd.zzc),
    SINT32_LIST(33, 2, zzdd.zzb),
    SINT64_LIST(34, 2, zzdd.zzc),
    DOUBLE_LIST_PACKED(35, 3, zzdd.zze),
    FLOAT_LIST_PACKED(36, 3, zzdd.zzd),
    INT64_LIST_PACKED(37, 3, zzdd.zzc),
    UINT64_LIST_PACKED(38, 3, zzdd.zzc),
    INT32_LIST_PACKED(39, 3, zzdd.zzb),
    FIXED64_LIST_PACKED(40, 3, zzdd.zzc),
    FIXED32_LIST_PACKED(41, 3, zzdd.zzb),
    BOOL_LIST_PACKED(42, 3, zzdd.zzf),
    UINT32_LIST_PACKED(43, 3, zzdd.zzb),
    ENUM_LIST_PACKED(44, 3, zzdd.zzi),
    SFIXED32_LIST_PACKED(45, 3, zzdd.zzb),
    SFIXED64_LIST_PACKED(46, 3, zzdd.zzc),
    SINT32_LIST_PACKED(0x2F, 3, zzdd.zzb),
    SINT64_LIST_PACKED(0x30, 3, zzdd.zzc),
    GROUP_LIST(49, 2, zzdd.zzj),
    MAP(50, 4, zzdd.zza);

    private static final zzcj[] zzZ;
    private final zzdd zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzcj[] arr_zzcj = (zzcj[])zzcj.zzaa.clone();
        zzcj.zzZ = new zzcj[arr_zzcj.length];
        for(int v = 0; v < arr_zzcj.length; ++v) {
            zzcj zzcj0 = arr_zzcj[v];
            zzcj.zzZ[zzcj0.zzac] = zzcj0;
        }
    }

    private zzcj(int v1, int v2, zzdd zzdd0) {
        this.zzac = v1;
        this.zzab = zzdd0;
        switch(v2 - 1) {
            case 1: {
                this.zzad = zzdd0.zza();
                break;
            }
            case 3: {
                this.zzad = zzdd0.zza();
                break;
            }
            default: {
                this.zzad = null;
            }
        }
        if(v2 == 1) {
            zzdd0.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}

