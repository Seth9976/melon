package com.google.android.gms.internal.measurement;

final class zzop {
    public static boolean zza(byte b) {
        return b >= 0;
    }

    public static void zzb(byte b, byte b1, char[] arr_c, int v) {
        if(b < -62 || zzop.zze(b1)) {
            throw new zzmq("Protocol message had invalid UTF-8.");
        }
        arr_c[v] = (char)((b & 0x1F) << 6 | b1 & 0x3F);
    }

    public static void zzc(byte b, byte b1, byte b2, char[] arr_c, int v) {
        if(!zzop.zze(b1)) {
            if(b != 0xFFFFFFE0) {
            label_4:
                if(b != -19) {
                label_7:
                    if(!zzop.zze(b2)) {
                        arr_c[v] = (char)((b & 15) << 12 | (b1 & 0x3F) << 6 | b2 & 0x3F);
                        return;
                    }
                }
                else if(b1 < 0xFFFFFFA0) {
                    b = -19;
                    goto label_7;
                }
            }
            else if(b1 >= 0xFFFFFFA0) {
                b = (byte)0xE0;
                goto label_4;
            }
        }
        throw new zzmq("Protocol message had invalid UTF-8.");
    }

    public static void zzd(byte b, byte b1, byte b2, byte b3, char[] arr_c, int v) {
        if(zzop.zze(b1) || b1 + 0x70 + (b << 28) >> 30 != 0 || zzop.zze(b2) || zzop.zze(b3)) {
            throw new zzmq("Protocol message had invalid UTF-8.");
        }
        int v1 = (b & 7) << 18 | (b1 & 0x3F) << 12 | (b2 & 0x3F) << 6 | b3 & 0x3F;
        arr_c[v] = (char)((v1 >>> 10) + 0xD7C0);
        arr_c[v + 1] = (char)((v1 & 0x3FF) + 0xDC00);
    }

    private static boolean zze(byte b) {
        return b > -65;
    }
}

