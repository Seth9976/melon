package com.google.android.gms.internal.play_billing;

final class zzbd {
    public static int zza(byte[] arr_b, int v, zzbc zzbc0) {
        int v1 = zzbd.zzh(arr_b, v, zzbc0);
        int v2 = zzbc0.zza;
        if(v2 < 0) {
            throw zzdc.zzd();
        }
        if(v2 > arr_b.length - v1) {
            throw zzdc.zzg();
        }
        if(v2 == 0) {
            zzbc0.zzc = zzbq.zzb;
            return v1;
        }
        zzbc0.zzc = zzbq.zzl(arr_b, v1, v2);
        return v1 + v2;
    }

    public static int zzb(byte[] arr_b, int v) {
        return (arr_b[v + 3] & 0xFF) << 24 | ((arr_b[v + 1] & 0xFF) << 8 | arr_b[v] & 0xFF | (arr_b[v + 2] & 0xFF) << 16);
    }

    public static int zzc(zzeo zzeo0, byte[] arr_b, int v, int v1, int v2, zzbc zzbc0) {
        Object object0 = zzeo0.zze();
        int v3 = zzbd.zzl(object0, zzeo0, arr_b, v, v1, v2, zzbc0);
        zzeo0.zzf(object0);
        zzbc0.zzc = object0;
        return v3;
    }

    public static int zzd(zzeo zzeo0, byte[] arr_b, int v, int v1, zzbc zzbc0) {
        Object object0 = zzeo0.zze();
        int v2 = zzbd.zzm(object0, zzeo0, arr_b, v, v1, zzbc0);
        zzeo0.zzf(object0);
        zzbc0.zzc = object0;
        return v2;
    }

    public static int zze(zzeo zzeo0, int v, byte[] arr_b, int v1, int v2, zzcz zzcz0, zzbc zzbc0) {
        int v3 = zzbd.zzd(zzeo0, arr_b, v1, v2, zzbc0);
        zzcz0.add(zzbc0.zzc);
        while(v3 < v2) {
            int v4 = zzbd.zzh(arr_b, v3, zzbc0);
            if(v != zzbc0.zza) {
                break;
            }
            v3 = zzbd.zzd(zzeo0, arr_b, v4, v2, zzbc0);
            zzcz0.add(zzbc0.zzc);
        }
        return v3;
    }

    public static int zzf(byte[] arr_b, int v, zzcz zzcz0, zzbc zzbc0) {
        int v1 = zzbd.zzh(arr_b, v, zzbc0);
        int v2 = zzbc0.zza + v1;
        while(v1 < v2) {
            v1 = zzbd.zzh(arr_b, v1, zzbc0);
            ((zzct)zzcz0).zzg(zzbc0.zza);
        }
        if(v1 != v2) {
            throw zzdc.zzg();
        }
        return v1;
    }

    public static int zzg(int v, byte[] arr_b, int v1, int v2, zzfg zzfg0, zzbc zzbc0) {
        if(v >>> 3 != 0) {
            switch(v & 7) {
                case 0: {
                    int v3 = zzbd.zzk(arr_b, v1, zzbc0);
                    zzfg0.zzj(v, zzbc0.zzb);
                    return v3;
                }
                case 1: {
                    zzfg0.zzj(v, zzbd.zzn(arr_b, v1));
                    return v1 + 8;
                }
                case 2: {
                    int v4 = zzbd.zzh(arr_b, v1, zzbc0);
                    int v5 = zzbc0.zza;
                    if(v5 < 0) {
                        throw zzdc.zzd();
                    }
                    if(v5 > arr_b.length - v4) {
                        throw zzdc.zzg();
                    }
                    if(v5 == 0) {
                        zzfg0.zzj(v, zzbq.zzb);
                        return v4;
                    }
                    zzfg0.zzj(v, zzbq.zzl(arr_b, v4, v5));
                    return v4 + v5;
                }
                case 3: {
                    int v6 = v & -8 | 4;
                    zzfg zzfg1 = zzfg.zzf();
                    int v7 = 0;
                    while(v1 < v2) {
                        int v8 = zzbd.zzh(arr_b, v1, zzbc0);
                        v7 = zzbc0.zza;
                        if(v7 == v6) {
                            v1 = v8;
                            if(true) {
                                break;
                            }
                        }
                        else {
                            v1 = zzbd.zzg(v7, arr_b, v8, v2, zzfg1, zzbc0);
                        }
                    }
                    if(v1 > v2 || v7 != v6) {
                        throw zzdc.zze();
                    }
                    zzfg0.zzj(v, zzfg1);
                    return v1;
                }
                case 5: {
                    zzfg0.zzj(v, zzbd.zzb(arr_b, v1));
                    return v1 + 4;
                }
                default: {
                    throw zzdc.zzb();
                }
            }
        }
        throw zzdc.zzb();
    }

    public static int zzh(byte[] arr_b, int v, zzbc zzbc0) {
        int v1 = arr_b[v];
        if(v1 >= 0) {
            zzbc0.zza = v1;
            return v + 1;
        }
        return zzbd.zzi(v1, arr_b, v + 1, zzbc0);
    }

    public static int zzi(int v, byte[] arr_b, int v1, zzbc zzbc0) {
        int v2 = arr_b[v1];
        if(v2 >= 0) {
            zzbc0.zza = v & 0x7F | v2 << 7;
            return v1 + 1;
        }
        int v3 = v & 0x7F | (v2 & 0x7F) << 7;
        int v4 = arr_b[v1 + 1];
        if(v4 >= 0) {
            zzbc0.zza = v3 | v4 << 14;
            return v1 + 2;
        }
        int v5 = v3 | (v4 & 0x7F) << 14;
        int v6 = arr_b[v1 + 2];
        if(v6 >= 0) {
            zzbc0.zza = v5 | v6 << 21;
            return v1 + 3;
        }
        int v7 = v5 | (v6 & 0x7F) << 21;
        int v8 = v1 + 4;
        int v9 = arr_b[v1 + 3];
        if(v9 >= 0) {
            zzbc0.zza = v7 | v9 << 28;
            return v8;
        }
        while(arr_b[v8] < 0) {
            ++v8;
        }
        zzbc0.zza = v7 | (v9 & 0x7F) << 28;
        return v8 + 1;
    }

    public static int zzj(int v, byte[] arr_b, int v1, int v2, zzcz zzcz0, zzbc zzbc0) {
        int v3 = zzbd.zzh(arr_b, v1, zzbc0);
        ((zzct)zzcz0).zzg(zzbc0.zza);
        while(v3 < v2) {
            int v4 = zzbd.zzh(arr_b, v3, zzbc0);
            if(v != zzbc0.zza) {
                break;
            }
            v3 = zzbd.zzh(arr_b, v4, zzbc0);
            ((zzct)zzcz0).zzg(zzbc0.zza);
        }
        return v3;
    }

    public static int zzk(byte[] arr_b, int v, zzbc zzbc0) {
        long v1 = (long)arr_b[v];
        if(Long.compare(v1, 0L) >= 0) {
            zzbc0.zzb = v1;
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
        zzbc0.zzb = v4;
        return v2;
    }

    public static int zzl(Object object0, zzeo zzeo0, byte[] arr_b, int v, int v1, int v2, zzbc zzbc0) {
        int v3 = ((zzef)zzeo0).zzc(object0, arr_b, v, v1, v2, zzbc0);
        zzbc0.zzc = object0;
        return v3;
    }

    public static int zzm(Object object0, zzeo zzeo0, byte[] arr_b, int v, int v1, zzbc zzbc0) {
        int v2 = v + 1;
        int v3 = arr_b[v];
        if(v3 < 0) {
            v2 = zzbd.zzi(v3, arr_b, v2, zzbc0);
            v3 = zzbc0.zza;
        }
        if(v3 < 0 || v3 > v1 - v2) {
            throw zzdc.zzg();
        }
        int v4 = v2 + v3;
        zzeo0.zzh(object0, arr_b, v2, v4, zzbc0);
        zzbc0.zzc = object0;
        return v4;
    }

    public static long zzn(byte[] arr_b, int v) {
        return ((long)arr_b[v]) & 0xFFL | (((long)arr_b[v + 1]) & 0xFFL) << 8 | (((long)arr_b[v + 2]) & 0xFFL) << 16 | (((long)arr_b[v + 3]) & 0xFFL) << 24 | (((long)arr_b[v + 4]) & 0xFFL) << 0x20 | (((long)arr_b[v + 5]) & 0xFFL) << 40 | (((long)arr_b[v + 6]) & 0xFFL) << 0x30 | (((long)arr_b[v + 7]) & 0xFFL) << 56;
    }
}

