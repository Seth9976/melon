package com.google.android.gms.internal.measurement;

import U4.x;
import androidx.appcompat.app.o;
import java.io.Serializable;
import java.util.Iterator;

public abstract class zzlg implements Serializable, Iterable {
    private int zza;
    public static final zzlg zzb;

    static {
        zzlg.zzb = new zzlf(zzmo.zzb);
    }

    public zzlg() {
        this.zza = 0;
    }

    @Override
    public abstract boolean equals(Object arg1);

    @Override
    public final int hashCode() {
        int v = this.zza;
        if(v == 0) {
            int v1 = this.zzc();
            v = this.zzg(v1, 0, v1);
            if(v == 0) {
                v = 1;
            }
            this.zza = v;
        }
        return v;
    }

    @Override
    public final Iterator iterator() {
        return new zzkz(this);
    }

    @Override
    public final String toString() {
        String s1;
        String s = Integer.toHexString(System.identityHashCode(this));
        int v = this.zzc();
        if(this.zzc() <= 50) {
            s1 = zzof.zza(this);
            return x.m(o.u(v, "<ByteString@", s, " size=", " contents=\""), s1, "\">");
        }
        s1 = zzof.zza(this.zze(0, 0x2F)) + "...";
        return x.m(o.u(v, "<ByteString@", s, " size=", " contents=\""), s1, "\">");
    }

    public abstract byte zza(int arg1);

    public abstract byte zzb(int arg1);

    public abstract int zzc();

    public abstract zzlg zze(int arg1, int arg2);

    public abstract void zzf(zzky arg1);

    public abstract int zzg(int arg1, int arg2, int arg3);

    public static zzlg zzh(byte[] arr_b, int v, int v1) {
        zzlg.zzj(v, v + v1, arr_b.length);
        byte[] arr_b1 = new byte[v1];
        System.arraycopy(arr_b, v, arr_b1, 0, v1);
        return new zzlf(arr_b1);
    }

    public final int zzi() {
        return this.zza;
    }

    public static int zzj(int v, int v1, int v2) {
        int v3 = v1 - v;
        if((v | v1 | v3 | v2 - v1) < 0) {
            if(v < 0) {
                throw new IndexOutOfBoundsException("Beginning index: " + v + " < 0");
            }
            throw v1 >= v ? new IndexOutOfBoundsException("End index: " + v1 + " >= " + v2) : new IndexOutOfBoundsException("Beginning index larger than ending index: " + v + ", " + v1);
        }
        return v3;
    }
}

