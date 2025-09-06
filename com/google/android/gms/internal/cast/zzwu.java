package com.google.android.gms.internal.cast;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzwu extends zzwf {
    zzwv zza;
    public static final int zzb;
    private static final Logger zzc;
    private static final boolean zzd;

    static {
        zzwu.zzc = Logger.getLogger("com.google.android.gms.internal.cast.zzwu");
        zzwu.zzd = false;
    }

    private zzwu() {
        throw null;
    }

    public zzwu(zzwt zzwt0) {
    }

    public static int zzA(long v) {
        return 640 - Long.numberOfLeadingZeros(v) * 9 >>> 6;
    }

    public final void zzB() {
        if(this.zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzC(String s, zzzp zzzp0) {
        zzwu.zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzzp0);
        byte[] arr_b = s.getBytes(zzxo.zza);
        try {
            this.zzt(arr_b.length);
            this.zzl(arr_b, 0, arr_b.length);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzws(indexOutOfBoundsException0);
        }
    }

    public static boolean zzD() [...] // 潜在的解密器

    public abstract int zza();

    public abstract void zzb(byte arg1);

    public abstract void zzd(int arg1, boolean arg2);

    public abstract void zze(int arg1, zzwn arg2);

    public abstract void zzf(int arg1, int arg2);

    public abstract void zzg(int arg1);

    public abstract void zzh(int arg1, long arg2);

    public abstract void zzi(long arg1);

    public abstract void zzj(int arg1, int arg2);

    public abstract void zzk(int arg1);

    public abstract void zzl(byte[] arg1, int arg2, int arg3);

    public abstract void zzm(int arg1, zzyl arg2, zzyv arg3);

    public abstract void zzn(int arg1, zzyl arg2);

    public abstract void zzo(int arg1, zzwn arg2);

    public abstract void zzp(int arg1, String arg2);

    public abstract void zzr(int arg1, int arg2);

    public abstract void zzs(int arg1, int arg2);

    public abstract void zzt(int arg1);

    public abstract void zzu(int arg1, long arg2);

    public abstract void zzv(long arg1);

    @Deprecated
    public static int zzw(int v, zzyl zzyl0, zzyv zzyv0) {
        int v1 = zzwu.zzz(v << 3);
        return ((zzwa)zzyl0).zzr(zzyv0) + (v1 + v1);
    }

    public static int zzx(zzyl zzyl0, zzyv zzyv0) {
        int v = ((zzwa)zzyl0).zzr(zzyv0);
        return zzwu.zzz(v) + v;
    }

    public static int zzy(String s) {
        int v;
        try {
            v = zzzq.zzb(s);
            return zzwu.zzz(v) + v;
        }
        catch(zzzp unused_ex) {
            v = s.getBytes(zzxo.zza).length;
            return zzwu.zzz(v) + v;
        }
    }

    public static int zzz(int v) [...] // 潜在的解密器
}

