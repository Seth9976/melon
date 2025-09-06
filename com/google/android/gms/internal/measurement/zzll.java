package com.google.android.gms.internal.measurement;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzll extends zzky {
    zzlm zza;
    public static final int zzb;
    private static final Logger zzc;
    private static final boolean zzd;

    static {
        zzll.zzc = Logger.getLogger("com.google.android.gms.internal.measurement.zzll");
        zzll.zzd = false;
    }

    private zzll() {
        throw null;
    }

    public zzll(byte[] arr_b) {
    }

    public static int zzA(long v) {
        return 640 - Long.numberOfLeadingZeros(v) * 9 >>> 6;
    }

    public static int zzB(String s) {
        int v;
        try {
            v = zzor.zzb(s);
            return zzll.zzz(v) + v;
        }
        catch(zzoq unused_ex) {
            v = s.getBytes(zzmo.zza).length;
            return zzll.zzz(v) + v;
        }
    }

    public static int zzC(zznl zznl0) {
        int v = zznl0.zzcn();
        return zzll.zzz(v) + v;
    }

    public static int zzD(zznl zznl0, zznw zznw0) {
        int v = ((zzkr)zznl0).zzcd(zznw0);
        return zzll.zzz(v) + v;
    }

    public final void zzE() {
        if(this.zzy() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzF(String s, zzoq zzoq0) {
        zzll.zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzoq0);
        byte[] arr_b = s.getBytes(zzmo.zza);
        try {
            this.zzr(arr_b.length);
            this.zzw(arr_b, 0, arr_b.length);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzlk(indexOutOfBoundsException0);
        }
    }

    @Deprecated
    public static int zzG(int v, zznl zznl0, zznw zznw0) {
        int v1 = zzll.zzz(v << 3);
        return ((zzkr)zznl0).zzcd(zznw0) + (v1 + v1);
    }

    public static boolean zzH() [...] // 潜在的解密器

    public abstract void zza(int arg1, int arg2);

    public abstract void zzb(int arg1, int arg2);

    public abstract void zzc(int arg1, int arg2);

    public abstract void zzd(int arg1, int arg2);

    public abstract void zze(int arg1, long arg2);

    public abstract void zzf(int arg1, long arg2);

    public abstract void zzg(int arg1, boolean arg2);

    public abstract void zzh(int arg1, String arg2);

    public abstract void zzi(int arg1, zzlg arg2);

    public abstract void zzj(zzlg arg1);

    public abstract void zzk(byte[] arg1, int arg2, int arg3);

    public abstract void zzl(int arg1, zznl arg2, zznw arg3);

    public abstract void zzm(int arg1, zznl arg2);

    public abstract void zzn(int arg1, zzlg arg2);

    public abstract void zzo(zznl arg1);

    public abstract void zzp(byte arg1);

    public abstract void zzq(int arg1);

    public abstract void zzr(int arg1);

    public abstract void zzs(int arg1);

    public abstract void zzt(long arg1);

    public abstract void zzu(long arg1);

    public abstract void zzw(byte[] arg1, int arg2, int arg3);

    public abstract void zzx(String arg1);

    public abstract int zzy();

    public static int zzz(int v) [...] // 潜在的解密器
}

