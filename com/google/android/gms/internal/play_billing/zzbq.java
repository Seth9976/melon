package com.google.android.gms.internal.play_billing;

import U4.x;
import androidx.appcompat.app.o;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

public abstract class zzbq implements Serializable, Iterable {
    private static final Comparator zza;
    public static final zzbq zzb;
    private int zzc;
    private static final zzbp zzd;

    static {
        zzbq.zzb = new zzbn(zzda.zzd);
        zzbq.zzd = new zzbp(null);
        zzbq.zza = new zzbh();
    }

    public zzbq() {
        this.zzc = 0;
    }

    @Override
    public abstract boolean equals(Object arg1);

    @Override
    public final int hashCode() {
        int v = this.zzc;
        if(v == 0) {
            int v1 = this.zzd();
            v = this.zze(v1, 0, v1);
            if(v == 0) {
                v = 1;
            }
            this.zzc = v;
        }
        return v;
    }

    @Override
    public final Iterator iterator() {
        return new zzbg(this);
    }

    @Override
    public final String toString() {
        String s1;
        String s = Integer.toHexString(System.identityHashCode(this));
        int v = this.zzd();
        if(this.zzd() <= 50) {
            s1 = zzfd.zza(this);
            return x.m(o.u(v, "<ByteString@", s, " size=", " contents=\""), s1, "\">");
        }
        s1 = zzfd.zza(this.zzf(0, 0x2F)) + "...";
        return x.m(o.u(v, "<ByteString@", s, " size=", " contents=\""), s1, "\">");
    }

    public abstract byte zza(int arg1);

    public abstract byte zzb(int arg1);

    public abstract int zzd();

    public abstract int zze(int arg1, int arg2, int arg3);

    public abstract zzbq zzf(int arg1, int arg2);

    public abstract String zzg(Charset arg1);

    public abstract void zzh(zzbf arg1);

    public abstract boolean zzi();

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

    public final int zzk() {
        return this.zzc;
    }

    public static zzbq zzl(byte[] arr_b, int v, int v1) {
        zzbq.zzj(v, v + v1, arr_b.length);
        byte[] arr_b1 = new byte[v1];
        System.arraycopy(arr_b, v, arr_b1, 0, v1);
        return new zzbn(arr_b1);
    }

    public final String zzm(Charset charset0) {
        return this.zzd() == 0 ? "" : this.zzg(charset0);
    }
}

