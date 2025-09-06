package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import k8.Y;

public abstract class zzkr implements zznl {
    protected int zza;

    public zzkr() {
        this.zza = 0;
    }

    @Override  // com.google.android.gms.internal.measurement.zznl
    public final zzlg zzcb() {
        try {
            int v = this.zzcn();
            byte[] arr_b = new byte[v];
            zzlj zzlj0 = new zzlj(arr_b, 0, v);
            this.zzcB(zzlj0);
            return zzld.zza(zzlj0, arr_b);
        }
        catch(IOException iOException0) {
            String s = this.getClass().getName();
            throw new RuntimeException(Y.l(new StringBuilder(s.length() + 72), "Serializing ", s, " to a ByteString threw an IOException (should never happen)."), iOException0);
        }
    }

    public final byte[] zzcc() {
        try {
            int v = this.zzcn();
            byte[] arr_b = new byte[v];
            zzlj zzlj0 = new zzlj(arr_b, 0, v);
            this.zzcB(zzlj0);
            zzlj0.zzE();
            return arr_b;
        }
        catch(IOException iOException0) {
            String s = this.getClass().getName();
            throw new RuntimeException(Y.l(new StringBuilder(s.length() + 72), "Serializing ", s, " to a byte array threw an IOException (should never happen)."), iOException0);
        }
    }

    public int zzcd(zznw zznw0) {
        throw null;
    }

    public static void zzce(Iterable iterable0, List list0) {
        zzkq.zzaU(iterable0, list0);
    }
}

