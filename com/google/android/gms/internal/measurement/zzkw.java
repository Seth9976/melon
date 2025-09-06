package com.google.android.gms.internal.measurement;

final class zzkw {
    public static final int zza = 0;
    private static volatile int zzb = 100;

    public static int zza(byte[] arr_b, int v, zzkv zzkv0) {
        int v1 = arr_b[v];
        if(v1 >= 0) {
            zzkv0.zza = v1;
            return v + 1;
        }
        return zzkw.zzb(v1, arr_b, v + 1, zzkv0);
    }

    public static int zzb(int v, byte[] arr_b, int v1, zzkv zzkv0) {
        int v2 = arr_b[v1];
        if(v2 >= 0) {
            zzkv0.zza = v & 0x7F | v2 << 7;
            return v1 + 1;
        }
        int v3 = v & 0x7F | (v2 & 0x7F) << 7;
        int v4 = arr_b[v1 + 1];
        if(v4 >= 0) {
            zzkv0.zza = v3 | v4 << 14;
            return v1 + 2;
        }
        int v5 = v3 | (v4 & 0x7F) << 14;
        int v6 = arr_b[v1 + 2];
        if(v6 >= 0) {
            zzkv0.zza = v5 | v6 << 21;
            return v1 + 3;
        }
        int v7 = v5 | (v6 & 0x7F) << 21;
        int v8 = v1 + 4;
        int v9 = arr_b[v1 + 3];
        if(v9 >= 0) {
            zzkv0.zza = v7 | v9 << 28;
            return v8;
        }
        while(arr_b[v8] < 0) {
            ++v8;
        }
        zzkv0.zza = v7 | (v9 & 0x7F) << 28;
        return v8 + 1;
    }

    public static int zzc(byte[] arr_b, int v, zzkv zzkv0) {
        long v1 = (long)arr_b[v];
        if(Long.compare(v1, 0L) >= 0) {
            zzkv0.zzb = v1;
            return v + 1;
        }
        int v2 = v + 2;
        int v3 = arr_b[v + 1];
        long v4 = v1 & 0x7FL | ((long)(v3 & 0x7F)) << 7;
        int v5 = 7;
        while(v3 < 0) {
            int v6 = arr_b[v2];
            v5 += 7;
            v4 |= ((long)(v6 & 0x7F)) << v5;
            v3 = v6;
            ++v2;
        }
        zzkv0.zzb = v4;
        return v2;
    }

    public static int zzd(byte[] arr_b, int v) {
        return (arr_b[v + 3] & 0xFF) << 24 | ((arr_b[v + 1] & 0xFF) << 8 | arr_b[v] & 0xFF | (arr_b[v + 2] & 0xFF) << 16);
    }

    public static long zze(byte[] arr_b, int v) {
        return ((long)arr_b[v]) & 0xFFL | (((long)arr_b[v + 1]) & 0xFFL) << 8 | (((long)arr_b[v + 2]) & 0xFFL) << 16 | (((long)arr_b[v + 3]) & 0xFFL) << 24 | (((long)arr_b[v + 4]) & 0xFFL) << 0x20 | (((long)arr_b[v + 5]) & 0xFFL) << 40 | (((long)arr_b[v + 6]) & 0xFFL) << 0x30 | (((long)arr_b[v + 7]) & 0xFFL) << 56;
    }

    public static int zzf(byte[] arr_b, int v, zzkv zzkv0) {
        int v1 = zzkw.zza(arr_b, v, zzkv0);
        int v2 = zzkv0.zza;
        if(v2 < 0) {
            throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if(v2 == 0) {
            zzkv0.zzc = "";
            return v1;
        }
        if((arr_b.length - v1 - v2 | (v1 | v2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", ((int)arr_b.length), v1, v2));
        }
        int v3 = v1 + v2;
        char[] arr_c = new char[v2];
        int v4;
        for(v4 = 0; v1 < v3; ++v4) {
            int v5 = arr_b[v1];
            if(!zzop.zza(((byte)v5))) {
                break;
            }
            ++v1;
            arr_c[v4] = (char)v5;
        }
        int v6 = v4;
        while(v1 < v3) {
            int v7 = v1 + 1;
            int v8 = arr_b[v1];
            if(zzop.zza(((byte)v8))) {
                arr_c[v6] = (char)v8;
                ++v6;
                v1 = v7;
                while(v1 < v3) {
                    int v9 = arr_b[v1];
                    if(!zzop.zza(((byte)v9))) {
                        break;
                    }
                    ++v1;
                    arr_c[v6] = (char)v9;
                    ++v6;
                }
                continue;
            }
            if(v8 < 0xFFFFFFE0) {
                if(v7 < v3) {
                    v1 += 2;
                    zzop.zzb(((byte)v8), arr_b[v7], arr_c, v6);
                    ++v6;
                    continue;
                }
            }
            else if(v8 >= -16) {
                if(v7 < v3 - 2) {
                    int v11 = arr_b[v7];
                    int v12 = v1 + 3;
                    int v13 = arr_b[v1 + 2];
                    v1 += 4;
                    zzop.zzd(((byte)v8), ((byte)v11), ((byte)v13), arr_b[v12], arr_c, v6);
                    v6 += 2;
                    continue;
                }
            }
            else if(v7 < v3 - 1) {
                int v10 = v1 + 2;
                v1 += 3;
                zzop.zzc(((byte)v8), arr_b[v7], arr_b[v10], arr_c, v6);
                ++v6;
                continue;
            }
            throw new zzmq("Protocol message had invalid UTF-8.");
        }
        zzkv0.zzc = new String(arr_c, 0, v6);
        return v3;
    }

    public static int zzg(byte[] arr_b, int v, zzkv zzkv0) {
        int v1 = zzkw.zza(arr_b, v, zzkv0);
        int v2 = zzkv0.zza;
        if(v2 < 0) {
            throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if(v2 > arr_b.length - v1) {
            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if(v2 == 0) {
            zzkv0.zzc = zzlg.zzb;
            return v1;
        }
        zzkv0.zzc = zzlg.zzh(arr_b, v1, v2);
        return v1 + v2;
    }

    public static int zzh(zznw zznw0, byte[] arr_b, int v, int v1, zzkv zzkv0) {
        Object object0 = zznw0.zza();
        int v2 = zzkw.zzj(object0, zznw0, arr_b, v, v1, zzkv0);
        zznw0.zzj(object0);
        zzkv0.zzc = object0;
        return v2;
    }

    public static int zzi(zznw zznw0, byte[] arr_b, int v, int v1, int v2, zzkv zzkv0) {
        Object object0 = zznw0.zza();
        int v3 = zzkw.zzk(object0, zznw0, arr_b, v, v1, v2, zzkv0);
        zznw0.zzj(object0);
        zzkv0.zzc = object0;
        return v3;
    }

    public static int zzj(Object object0, zznw zznw0, byte[] arr_b, int v, int v1, zzkv zzkv0) {
        int v2 = v + 1;
        int v3 = arr_b[v];
        if(v3 < 0) {
            v2 = zzkw.zzb(v3, arr_b, v2, zzkv0);
            v3 = zzkv0.zza;
        }
        if(v3 < 0 || v3 > v1 - v2) {
            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int v4 = zzkv0.zze + 1;
        zzkv0.zze = v4;
        zzkw.zzq(v4);
        int v5 = v2 + v3;
        zznw0.zzi(object0, arr_b, v2, v5, zzkv0);
        --zzkv0.zze;
        zzkv0.zzc = object0;
        return v5;
    }

    public static int zzk(Object object0, zznw zznw0, byte[] arr_b, int v, int v1, int v2, zzkv zzkv0) {
        int v3 = zzkv0.zze + 1;
        zzkv0.zze = v3;
        zzkw.zzq(v3);
        int v4 = ((zzno)zznw0).zzh(object0, arr_b, v, v1, v2, zzkv0);
        --zzkv0.zze;
        zzkv0.zzc = object0;
        return v4;
    }

    public static int zzl(int v, byte[] arr_b, int v1, int v2, zzmn zzmn0, zzkv zzkv0) {
        int v3 = zzkw.zza(arr_b, v1, zzkv0);
        ((zzmf)zzmn0).zzh(zzkv0.zza);
        while(v3 < v2) {
            int v4 = zzkw.zza(arr_b, v3, zzkv0);
            if(v != zzkv0.zza) {
                break;
            }
            v3 = zzkw.zza(arr_b, v4, zzkv0);
            ((zzmf)zzmn0).zzh(zzkv0.zza);
        }
        return v3;
    }

    public static int zzm(byte[] arr_b, int v, zzmn zzmn0, zzkv zzkv0) {
        int v1 = zzkw.zza(arr_b, v, zzkv0);
        int v2 = zzkv0.zza + v1;
        while(v1 < v2) {
            v1 = zzkw.zza(arr_b, v1, zzkv0);
            ((zzmf)zzmn0).zzh(zzkv0.zza);
        }
        if(v1 != v2) {
            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        return v1;
    }

    public static int zzn(zznw zznw0, int v, byte[] arr_b, int v1, int v2, zzmn zzmn0, zzkv zzkv0) {
        int v3 = zzkw.zzh(zznw0, arr_b, v1, v2, zzkv0);
        zzmn0.add(zzkv0.zzc);
        while(v3 < v2) {
            int v4 = zzkw.zza(arr_b, v3, zzkv0);
            if(v != zzkv0.zza) {
                break;
            }
            v3 = zzkw.zzh(zznw0, arr_b, v4, v2, zzkv0);
            zzmn0.add(zzkv0.zzc);
        }
        return v3;
    }

    public static int zzo(int v, byte[] arr_b, int v1, int v2, zzoi zzoi0, zzkv zzkv0) {
        if(v >>> 3 != 0) {
            switch(v & 7) {
                case 0: {
                    int v3 = zzkw.zzc(arr_b, v1, zzkv0);
                    zzoi0.zzk(v, zzkv0.zzb);
                    return v3;
                }
                case 1: {
                    zzoi0.zzk(v, zzkw.zze(arr_b, v1));
                    return v1 + 8;
                }
                case 2: {
                    int v4 = zzkw.zza(arr_b, v1, zzkv0);
                    int v5 = zzkv0.zza;
                    if(v5 < 0) {
                        throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                    }
                    if(v5 > arr_b.length - v4) {
                        throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                    }
                    if(v5 == 0) {
                        zzoi0.zzk(v, zzlg.zzb);
                        return v4;
                    }
                    zzoi0.zzk(v, zzlg.zzh(arr_b, v4, v5));
                    return v4 + v5;
                }
                case 3: {
                    int v6 = v & -8 | 4;
                    zzoi zzoi1 = zzoi.zzb();
                    int v7 = zzkv0.zze + 1;
                    zzkv0.zze = v7;
                    zzkw.zzq(v7);
                    int v8;
                    for(v8 = 0; v1 < v2; v8 = v10) {
                        int v9 = zzkw.zza(arr_b, v1, zzkv0);
                        int v10 = zzkv0.zza;
                        if(v10 == v6) {
                            v8 = v10;
                            v1 = v9;
                            break;
                        }
                        v1 = zzkw.zzo(v10, arr_b, v9, v2, zzoi1, zzkv0);
                    }
                    --zzkv0.zze;
                    if(v1 > v2 || v8 != v6) {
                        throw new zzmq("Failed to parse the message.");
                    }
                    zzoi0.zzk(v, zzoi1);
                    return v1;
                }
                case 5: {
                    zzoi0.zzk(v, zzkw.zzd(arr_b, v1));
                    return v1 + 4;
                }
                default: {
                    throw new zzmq("Protocol message contained an invalid tag (zero).");
                }
            }
        }
        throw new zzmq("Protocol message contained an invalid tag (zero).");
    }

    public static int zzp(int v, byte[] arr_b, int v1, int v2, zzkv zzkv0) {
        if(v >>> 3 != 0) {
            switch(v & 7) {
                case 0: {
                    return zzkw.zzc(arr_b, v1, zzkv0);
                }
                case 1: {
                    return v1 + 8;
                }
                case 2: {
                    return zzkw.zza(arr_b, v1, zzkv0) + zzkv0.zza;
                }
                case 3: {
                    int v3 = v & -8 | 4;
                    int v4 = 0;
                    while(v1 < v2) {
                        v1 = zzkw.zza(arr_b, v1, zzkv0);
                        v4 = zzkv0.zza;
                        if(v4 == v3) {
                            break;
                        }
                        v1 = zzkw.zzp(v4, arr_b, v1, v2, zzkv0);
                    }
                    if(v1 > v2 || v4 != v3) {
                        throw new zzmq("Failed to parse the message.");
                    }
                    return v1;
                }
                case 5: {
                    return v1 + 4;
                }
                default: {
                    throw new zzmq("Protocol message contained an invalid tag (zero).");
                }
            }
        }
        throw new zzmq("Protocol message contained an invalid tag (zero).");
    }

    private static void zzq(int v) {
        if(v >= zzkw.zzb) {
            throw new zzmq("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}

