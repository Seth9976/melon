package com.google.android.gms.internal.cast;

public enum zzxc {
    DOUBLE(0, 1, zzxr.zze),
    FLOAT(1, 1, zzxr.zzd),
    INT64(2, 1, zzxr.zzc),
    UINT64(3, 1, zzxr.zzc),
    INT32(4, 1, zzxr.zzb),
    FIXED64(5, 1, zzxr.zzc),
    FIXED32(6, 1, zzxr.zzb),
    BOOL(7, 1, zzxr.zzf),
    STRING(8, 1, zzxr.zzg),
    MESSAGE(9, 1, zzxr.zzj),
    BYTES(10, 1, zzxr.zzh),
    UINT32(11, 1, zzxr.zzb),
    ENUM(12, 1, zzxr.zzi),
    SFIXED32(13, 1, zzxr.zzb),
    SFIXED64(14, 1, zzxr.zzc),
    SINT32(15, 1, zzxr.zzb),
    SINT64(16, 1, zzxr.zzc),
    GROUP(17, 1, zzxr.zzj),
    DOUBLE_LIST(18, 2, zzxr.zze),
    FLOAT_LIST(19, 2, zzxr.zzd),
    INT64_LIST(20, 2, zzxr.zzc),
    UINT64_LIST(21, 2, zzxr.zzc),
    INT32_LIST(22, 2, zzxr.zzb),
    FIXED64_LIST(23, 2, zzxr.zzc),
    FIXED32_LIST(24, 2, zzxr.zzb),
    BOOL_LIST(25, 2, zzxr.zzf),
    STRING_LIST(26, 2, zzxr.zzg),
    MESSAGE_LIST(27, 2, zzxr.zzj),
    BYTES_LIST(28, 2, zzxr.zzh),
    UINT32_LIST(29, 2, zzxr.zzb),
    ENUM_LIST(30, 2, zzxr.zzi),
    SFIXED32_LIST(0x1F, 2, zzxr.zzb),
    SFIXED64_LIST(0x20, 2, zzxr.zzc),
    SINT32_LIST(33, 2, zzxr.zzb),
    SINT64_LIST(34, 2, zzxr.zzc),
    DOUBLE_LIST_PACKED(35, 3, zzxr.zze),
    FLOAT_LIST_PACKED(36, 3, zzxr.zzd),
    INT64_LIST_PACKED(37, 3, zzxr.zzc),
    UINT64_LIST_PACKED(38, 3, zzxr.zzc),
    INT32_LIST_PACKED(39, 3, zzxr.zzb),
    FIXED64_LIST_PACKED(40, 3, zzxr.zzc),
    FIXED32_LIST_PACKED(41, 3, zzxr.zzb),
    BOOL_LIST_PACKED(42, 3, zzxr.zzf),
    UINT32_LIST_PACKED(43, 3, zzxr.zzb),
    ENUM_LIST_PACKED(44, 3, zzxr.zzi),
    SFIXED32_LIST_PACKED(45, 3, zzxr.zzb),
    SFIXED64_LIST_PACKED(46, 3, zzxr.zzc),
    SINT32_LIST_PACKED(0x2F, 3, zzxr.zzb),
    SINT64_LIST_PACKED(0x30, 3, zzxr.zzc),
    GROUP_LIST(49, 2, zzxr.zzj),
    MAP(50, 4, zzxr.zza);

    private static final zzxc[] zzZ;
    private final int zzab;

    static {
        zzxc[] arr_zzxc = (zzxc[])zzxc.zzaa.clone();
        zzxc.zzZ = new zzxc[arr_zzxc.length];
        for(int v = 0; v < arr_zzxc.length; ++v) {
            zzxc zzxc0 = arr_zzxc[v];
            zzxc.zzZ[zzxc0.zzab] = zzxc0;
        }
    }

    private zzxc(int v1, int v2, zzxr zzxr0) {
        this.zzab = v1;
        if(v2 == 1) {
            zzxr0.ordinal();
        }
    }

    public final int zza() {
        return this.zzab;
    }
}

