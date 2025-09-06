package com.google.android.gms.internal.cast;

import U4.x;
import androidx.appcompat.app.o;
import java.io.Serializable;
import java.util.Iterator;

public abstract class zzwn implements Serializable, Iterable {
    private int zza;
    public static final zzwn zzb;

    static {
        zzwn.zzb = new zzwl(zzxo.zzb);
    }

    public zzwn() {
        this.zza = 0;
    }

    @Override
    public abstract boolean equals(Object arg1);

    @Override
    public final int hashCode() {
        int v = this.zza;
        if(v == 0) {
            int v1 = this.zzd();
            v = this.zze(v1, 0, v1);
            if(v == 0) {
                v = 1;
            }
            this.zza = v;
        }
        return v;
    }

    @Override
    public final Iterator iterator() {
        return new zzwg(this);
    }

    @Override
    public final String toString() {
        String s1;
        String s = Integer.toHexString(System.identityHashCode(this));
        int v = this.zzd();
        if(this.zzd() <= 50) {
            s1 = zzzf.zza(this);
            return x.m(o.u(v, "<ByteString@", s, " size=", " contents=\""), s1, "\">");
        }
        s1 = zzzf.zza(this.zzf(0, 0x2F)) + "...";
        return x.m(o.u(v, "<ByteString@", s, " size=", " contents=\""), s1, "\">");
    }

    public abstract byte zza(int arg1);

    public abstract byte zzb(int arg1);

    public abstract int zzd();

    public abstract int zze(int arg1, int arg2, int arg3);

    public abstract zzwn zzf(int arg1, int arg2);

    public abstract void zzg(zzwf arg1);

    public static int zzh(int v, int v1, int v2) {
        if((v2 - v1 | v1) < 0) {
            throw new IndexOutOfBoundsException("End index: " + v1 + " >= " + v2);
        }
        return v1;
    }

    public final int zzi() {
        return this.zza;
    }
}

