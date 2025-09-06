package com.google.android.gms.internal.measurement;

public enum zzlw {
    DOUBLE(0, 1, zzmr.zze),
    FLOAT(1, 1, zzmr.zzd),
    INT64(2, 1, zzmr.zzc),
    UINT64(3, 1, zzmr.zzc),
    INT32(4, 1, zzmr.zzb),
    FIXED64(5, 1, zzmr.zzc),
    FIXED32(6, 1, zzmr.zzb),
    BOOL(7, 1, zzmr.zzf),
    STRING(8, 1, zzmr.zzg),
    MESSAGE(9, 1, zzmr.zzj),
    BYTES(10, 1, zzmr.zzh),
    UINT32(11, 1, zzmr.zzb),
    ENUM(12, 1, zzmr.zzi),
    SFIXED32(13, 1, zzmr.zzb),
    SFIXED64(14, 1, zzmr.zzc),
    SINT32(15, 1, zzmr.zzb),
    SINT64(16, 1, zzmr.zzc),
    GROUP(17, 1, zzmr.zzj),
    DOUBLE_LIST(18, 2, zzmr.zze),
    FLOAT_LIST(19, 2, zzmr.zzd),
    INT64_LIST(20, 2, zzmr.zzc),
    UINT64_LIST(21, 2, zzmr.zzc),
    INT32_LIST(22, 2, zzmr.zzb),
    FIXED64_LIST(23, 2, zzmr.zzc),
    FIXED32_LIST(24, 2, zzmr.zzb),
    BOOL_LIST(25, 2, zzmr.zzf),
    STRING_LIST(26, 2, zzmr.zzg),
    MESSAGE_LIST(27, 2, zzmr.zzj),
    BYTES_LIST(28, 2, zzmr.zzh),
    UINT32_LIST(29, 2, zzmr.zzb),
    ENUM_LIST(30, 2, zzmr.zzi),
    SFIXED32_LIST(0x1F, 2, zzmr.zzb),
    SFIXED64_LIST(0x20, 2, zzmr.zzc),
    SINT32_LIST(33, 2, zzmr.zzb),
    SINT64_LIST(34, 2, zzmr.zzc),
    DOUBLE_LIST_PACKED(35, 3, zzmr.zze),
    FLOAT_LIST_PACKED(36, 3, zzmr.zzd),
    INT64_LIST_PACKED(37, 3, zzmr.zzc),
    UINT64_LIST_PACKED(38, 3, zzmr.zzc),
    INT32_LIST_PACKED(39, 3, zzmr.zzb),
    FIXED64_LIST_PACKED(40, 3, zzmr.zzc),
    FIXED32_LIST_PACKED(41, 3, zzmr.zzb),
    BOOL_LIST_PACKED(42, 3, zzmr.zzf),
    UINT32_LIST_PACKED(43, 3, zzmr.zzb),
    ENUM_LIST_PACKED(44, 3, zzmr.zzi),
    SFIXED32_LIST_PACKED(45, 3, zzmr.zzb),
    SFIXED64_LIST_PACKED(46, 3, zzmr.zzc),
    SINT32_LIST_PACKED(0x2F, 3, zzmr.zzb),
    SINT64_LIST_PACKED(0x30, 3, zzmr.zzc),
    GROUP_LIST(49, 2, zzmr.zzj),
    MAP(50, 4, zzmr.zza);

    private final int zzZ;
    private static final zzlw[] zzaa;

    static {
        zzlw[] arr_zzlw = (zzlw[])zzlw.zzab.clone();
        zzlw.zzaa = new zzlw[arr_zzlw.length];
        for(int v = 0; v < arr_zzlw.length; ++v) {
            zzlw zzlw0 = arr_zzlw[v];
            zzlw.zzaa[zzlw0.zzZ] = zzlw0;
        }
    }

    private zzlw(int v1, int v2, zzmr zzmr0) {
        this.zzZ = v1;
        if(v2 == 1) {
            zzmr0.ordinal();
        }
    }

    public final int zza() {
        return this.zzZ;
    }
}

