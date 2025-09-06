package com.google.android.gms.internal.play_billing;

import U4.x;
import java.io.IOException;

public abstract class zzay implements zzec {
    protected int zza;

    public zzay() {
        this.zza = 0;
    }

    public int zza(zzeo zzeo0) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzec
    public final zzbq zzb() {
        try {
            int v = this.zzf();
            byte[] arr_b = new byte[v];
            zzby zzby0 = zzby.zzy(arr_b, 0, v);
            this.zze(zzby0);
            zzby0.zzz();
            return new zzbn(arr_b);
        }
        catch(IOException iOException0) {
            throw new RuntimeException(x.k("Serializing ", this.getClass().getName(), " to a ByteString threw an IOException (should never happen)."), iOException0);
        }
    }

    public final byte[] zzc() {
        try {
            int v = this.zzf();
            byte[] arr_b = new byte[v];
            zzby zzby0 = zzby.zzy(arr_b, 0, v);
            this.zze(zzby0);
            zzby0.zzz();
            return arr_b;
        }
        catch(IOException iOException0) {
            throw new RuntimeException(x.k("Serializing ", this.getClass().getName(), " to a byte array threw an IOException (should never happen)."), iOException0);
        }
    }
}

