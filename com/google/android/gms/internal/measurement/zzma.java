package com.google.android.gms.internal.measurement;

import java.io.IOException;

public class zzma extends zzkq {
    protected zzme zza;
    private final zzme zzb;

    public zzma(zzme zzme0) {
        this.zzb = zzme0;
        if(zzme0.zzcf()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = zzme0.zzch();
    }

    @Override  // com.google.android.gms.internal.measurement.zzkq
    public final Object clone() {
        return this.zzba();
    }

    private static void zza(Object object0, Object object1) {
        zznt.zza().zzb(object0.getClass()).zzd(object0, object1);
    }

    @Override  // com.google.android.gms.internal.measurement.zzkq
    public final zzkq zzaR() {
        return this.zzba();
    }

    @Override  // com.google.android.gms.internal.measurement.zzkq
    public final zzkq zzaS(byte[] arr_b, int v, int v1) {
        this.zzbe(arr_b, 0, v1, zzlq.zza);
        return this;
    }

    @Override  // com.google.android.gms.internal.measurement.zzkq
    public final zzkq zzaT(byte[] arr_b, int v, int v1, zzlq zzlq0) {
        this.zzbe(arr_b, 0, v1, zzlq0);
        return this;
    }

    public final void zzaX() {
        if(!this.zza.zzcf()) {
            this.zzaY();
        }
    }

    public void zzaY() {
        zzme zzme0 = this.zzb.zzch();
        zzma.zza(zzme0, this.zza);
        this.zza = zzme0;
    }

    public final zzma zzba() {
        zzma zzma0 = (zzma)this.zzb.zzl(5, null, null);
        zzma0.zza = this.zzbb();
        return zzma0;
    }

    public zzme zzbb() {
        if(!this.zza.zzcf()) {
            return this.zza;
        }
        this.zza.zzcj();
        return this.zza;
    }

    public final zzme zzbc() {
        zzme zzme0 = this.zzbb();
        if(!zzme0.zzcD()) {
            throw new zzog(zzme0);
        }
        return zzme0;
    }

    public final zzma zzbd(zzme zzme0) {
        if(!this.zzb.equals(zzme0)) {
            if(!this.zza.zzcf()) {
                this.zzaY();
            }
            zzma.zza(this.zza, zzme0);
        }
        return this;
    }

    public final zzma zzbe(byte[] arr_b, int v, int v1, zzlq zzlq0) {
        if(!this.zza.zzcf()) {
            this.zzaY();
        }
        try {
            zznt.zza().zzb(this.zza.getClass()).zzi(this.zza, arr_b, 0, v1, new zzkv(zzlq0));
            return this;
        }
        catch(zzmq zzmq0) {
            throw zzmq0;
        }
        catch(IndexOutOfBoundsException unused_ex) {
            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        catch(IOException iOException0) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", iOException0);
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zznk
    public zznl zzbf() {
        return this.zzbb();
    }

    @Override  // com.google.android.gms.internal.measurement.zznm
    public final boolean zzcD() {
        return zzme.zzcx(this.zza, false);
    }

    @Override  // com.google.android.gms.internal.measurement.zznm
    public final zznl zzcE() {
        throw null;
    }
}

